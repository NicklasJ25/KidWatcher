package com.android.gallery3d.app;

import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.InputDeviceCompat;
import com.android.gallery3d.app.PhotoPage.Model;
import com.android.gallery3d.common.BitmapUtils;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.data.BitmapPool;
import com.android.gallery3d.data.ContentListener;
import com.android.gallery3d.data.MediaItem;
import com.android.gallery3d.data.MediaSet;
import com.android.gallery3d.data.Path;
import com.android.gallery3d.ui.PhotoView;
import com.android.gallery3d.ui.PhotoView.Size;
import com.android.gallery3d.ui.ScreenNail;
import com.android.gallery3d.ui.SynchronizedHandler;
import com.android.gallery3d.ui.TileImageViewAdapter;
import com.android.gallery3d.ui.TiledScreenNail;
import com.android.gallery3d.ui.TiledTexture;
import com.android.gallery3d.ui.TiledTexture.Uploader;
import com.android.gallery3d.util.Future;
import com.android.gallery3d.util.FutureListener;
import com.android.gallery3d.util.ThreadPool;
import com.android.gallery3d.util.ThreadPool.Job;
import com.android.gallery3d.util.ThreadPool.JobContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class PhotoDataAdapter implements Model {
    private static final int BIT_FULL_IMAGE = 2;
    private static final int BIT_SCREEN_NAIL = 1;
    private static final int DATA_CACHE_SIZE = 256;
    private static final int IMAGE_CACHE_SIZE = 7;
    private static final int MIN_LOAD_COUNT = 16;
    private static final int MSG_LOAD_FINISH = 2;
    private static final int MSG_LOAD_START = 1;
    private static final int MSG_RUN_OBJECT = 3;
    private static final int MSG_UPDATE_IMAGE_REQUESTS = 4;
    private static final int SCREEN_NAIL_MAX = 3;
    private static final String TAG = "PhotoDataAdapter";
    private static ImageFetch[] sImageFetchSeq = new ImageFetch[16];
    private int mActiveEnd = 0;
    private int mActiveStart = 0;
    private int mCameraIndex;
    private final long[] mChanges = new long[7];
    private int mContentEnd = 0;
    private int mContentStart = 0;
    private int mCurrentIndex;
    private final MediaItem[] mData = new MediaItem[256];
    private DataListener mDataListener;
    private int mFocusHintDirection = 0;
    private Path mFocusHintPath = null;
    private HashMap<Path, ImageEntry> mImageCache = new HashMap();
    private boolean mIsActive;
    private boolean mIsStaticCamera;
    private Path mItemPath;
    private final Handler mMainHandler;
    private boolean mNeedFullImage;
    private final Path[] mPaths = new Path[7];
    private final PhotoView mPhotoView;
    private ReloadTask mReloadTask;
    private int mSize = 0;
    private final MediaSet mSource;
    private final SourceListener mSourceListener = new SourceListener();
    private long mSourceVersion = -1;
    private final ThreadPool mThreadPool;
    private final TileImageViewAdapter mTileProvider = new TileImageViewAdapter();
    private final Uploader mUploader;

    public interface DataListener extends LoadingListener {
        void onPhotoChanged(int i, Path path);
    }

    private class FullImageJob implements Job<BitmapRegionDecoder> {
        private MediaItem mItem;

        public FullImageJob(MediaItem mediaItem) {
            this.mItem = mediaItem;
        }

        public BitmapRegionDecoder run(JobContext jobContext) {
            return PhotoDataAdapter.this.isTemporaryItem(this.mItem) ? null : (BitmapRegionDecoder) this.mItem.requestLargeImage().run(jobContext);
        }
    }

    private class FullImageListener implements FutureListener<BitmapRegionDecoder>, Runnable {
        private Future<BitmapRegionDecoder> mFuture;
        private final Path mPath;

        public FullImageListener(MediaItem mediaItem) {
            this.mPath = mediaItem.getPath();
        }

        public void onFutureDone(Future<BitmapRegionDecoder> future) {
            this.mFuture = future;
            PhotoDataAdapter.this.mMainHandler.sendMessage(PhotoDataAdapter.this.mMainHandler.obtainMessage(3, this));
        }

        public void run() {
            PhotoDataAdapter.this.updateFullImage(this.mPath, this.mFuture);
        }
    }

    private class GetUpdateInfo implements Callable<UpdateInfo> {
        private GetUpdateInfo() {
        }

        private boolean needContentReload() {
            int access$1200 = PhotoDataAdapter.this.mContentEnd;
            for (int access$1100 = PhotoDataAdapter.this.mContentStart; access$1100 < access$1200; access$1100++) {
                if (PhotoDataAdapter.this.mData[access$1100 % 256] == null) {
                    return true;
                }
            }
            MediaItem mediaItem = PhotoDataAdapter.this.mData[PhotoDataAdapter.this.mCurrentIndex % 256];
            return mediaItem == null || mediaItem.getPath() != PhotoDataAdapter.this.mItemPath;
        }

        public UpdateInfo call() {
            UpdateInfo updateInfo = new UpdateInfo();
            updateInfo.version = PhotoDataAdapter.this.mSourceVersion;
            updateInfo.reloadContent = needContentReload();
            updateInfo.target = PhotoDataAdapter.this.mItemPath;
            updateInfo.indexHint = PhotoDataAdapter.this.mCurrentIndex;
            updateInfo.contentStart = PhotoDataAdapter.this.mContentStart;
            updateInfo.contentEnd = PhotoDataAdapter.this.mContentEnd;
            updateInfo.size = PhotoDataAdapter.this.mSize;
            return updateInfo;
        }
    }

    private static class ImageEntry {
        public boolean failToLoad;
        public BitmapRegionDecoder fullImage;
        public Future<BitmapRegionDecoder> fullImageTask;
        public long requestedFullImage;
        public long requestedScreenNail;
        public ScreenNail screenNail;
        public Future<ScreenNail> screenNailTask;

        private ImageEntry() {
            this.requestedScreenNail = -1;
            this.requestedFullImage = -1;
            this.failToLoad = false;
        }
    }

    private static class ImageFetch {
        int imageBit;
        int indexOffset;

        public ImageFetch(int i, int i2) {
            this.indexOffset = i;
            this.imageBit = i2;
        }
    }

    private class ReloadTask extends Thread {
        private volatile boolean mActive;
        private volatile boolean mDirty;
        private boolean mIsLoading;

        private ReloadTask() {
            this.mActive = true;
            this.mDirty = true;
            this.mIsLoading = false;
        }

        private MediaItem findCurrentMediaItem(UpdateInfo updateInfo) {
            ArrayList arrayList = updateInfo.items;
            int i = updateInfo.indexHint - updateInfo.contentStart;
            return (i < 0 || i >= arrayList.size()) ? null : (MediaItem) arrayList.get(i);
        }

        private int findIndexOfPathInCache(UpdateInfo updateInfo, Path path) {
            ArrayList arrayList = updateInfo.items;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                MediaItem mediaItem = (MediaItem) arrayList.get(i);
                if (mediaItem != null && mediaItem.getPath() == path) {
                    return updateInfo.contentStart + i;
                }
            }
            return -1;
        }

        private int findIndexOfTarget(UpdateInfo updateInfo) {
            if (updateInfo.target == null) {
                return updateInfo.indexHint;
            }
            if (updateInfo.items != null) {
                int findIndexOfPathInCache = findIndexOfPathInCache(updateInfo, updateInfo.target);
                if (findIndexOfPathInCache != -1) {
                    return findIndexOfPathInCache;
                }
            }
            return PhotoDataAdapter.this.mSource.getIndexOfItem(updateInfo.target, updateInfo.indexHint);
        }

        private void updateLoading(boolean z) {
            if (this.mIsLoading != z) {
                this.mIsLoading = z;
                PhotoDataAdapter.this.mMainHandler.sendEmptyMessage(z ? 1 : 2);
            }
        }

        public synchronized void notifyDirty() {
            this.mDirty = true;
            notifyAll();
        }

        public void run() {
            while (this.mActive) {
                synchronized (this) {
                    if (this.mDirty || !this.mActive) {
                        this.mDirty = false;
                        UpdateInfo updateInfo = (UpdateInfo) PhotoDataAdapter.this.executeAndWait(new GetUpdateInfo());
                        updateLoading(true);
                        if (updateInfo.version != PhotoDataAdapter.this.mSource.reload()) {
                            updateInfo.reloadContent = true;
                            updateInfo.size = PhotoDataAdapter.this.mSource.getMediaItemCount();
                        }
                        if (updateInfo.reloadContent) {
                            int findIndexOfPathInCache;
                            updateInfo.items = PhotoDataAdapter.this.mSource.getMediaItem(updateInfo.contentStart, updateInfo.contentEnd);
                            if (PhotoDataAdapter.this.mFocusHintPath != null) {
                                findIndexOfPathInCache = findIndexOfPathInCache(updateInfo, PhotoDataAdapter.this.mFocusHintPath);
                                PhotoDataAdapter.this.mFocusHintPath = null;
                            } else {
                                findIndexOfPathInCache = -1;
                            }
                            if (findIndexOfPathInCache == -1) {
                                MediaItem findCurrentMediaItem = findCurrentMediaItem(updateInfo);
                                findIndexOfPathInCache = (findCurrentMediaItem == null || findCurrentMediaItem.getPath() != updateInfo.target) ? findIndexOfTarget(updateInfo) : updateInfo.indexHint;
                            }
                            if (findIndexOfPathInCache == -1) {
                                findIndexOfPathInCache = updateInfo.indexHint;
                                int access$2800 = PhotoDataAdapter.this.mFocusHintDirection;
                                if (findIndexOfPathInCache == PhotoDataAdapter.this.mCameraIndex + 1) {
                                    access$2800 = 0;
                                }
                                if (access$2800 == 1 && findIndexOfPathInCache > 0) {
                                    findIndexOfPathInCache--;
                                }
                            }
                            if (PhotoDataAdapter.this.mSize > 0 && r1 >= PhotoDataAdapter.this.mSize) {
                                findIndexOfPathInCache = PhotoDataAdapter.this.mSize - 1;
                            }
                            updateInfo.indexHint = findIndexOfPathInCache;
                            PhotoDataAdapter.this.executeAndWait(new UpdateContent(updateInfo));
                        }
                    } else {
                        updateLoading(false);
                        Utils.waitWithoutInterrupt(this);
                    }
                }
            }
        }

        public synchronized void terminate() {
            this.mActive = false;
            notifyAll();
        }
    }

    private class ScreenNailJob implements Job<ScreenNail> {
        private MediaItem mItem;

        public ScreenNailJob(MediaItem mediaItem) {
            this.mItem = mediaItem;
        }

        public ScreenNail run(JobContext jobContext) {
            ScreenNail screenNail = this.mItem.getScreenNail();
            if (screenNail != null) {
                return screenNail;
            }
            if (PhotoDataAdapter.this.isTemporaryItem(this.mItem)) {
                return PhotoDataAdapter.this.newPlaceholderScreenNail(this.mItem);
            }
            Bitmap bitmap = (Bitmap) this.mItem.requestImage(1).run(jobContext);
            if (jobContext.isCancelled()) {
                return null;
            }
            Bitmap rotateBitmap = bitmap != null ? BitmapUtils.rotateBitmap(bitmap, this.mItem.getRotation() - this.mItem.getFullImageRotation(), true) : bitmap;
            return rotateBitmap == null ? null : new TiledScreenNail(rotateBitmap);
        }
    }

    private class ScreenNailListener implements FutureListener<ScreenNail>, Runnable {
        private Future<ScreenNail> mFuture;
        private final Path mPath;

        public ScreenNailListener(MediaItem mediaItem) {
            this.mPath = mediaItem.getPath();
        }

        public void onFutureDone(Future<ScreenNail> future) {
            this.mFuture = future;
            PhotoDataAdapter.this.mMainHandler.sendMessage(PhotoDataAdapter.this.mMainHandler.obtainMessage(3, this));
        }

        public void run() {
            PhotoDataAdapter.this.updateScreenNail(this.mPath, this.mFuture);
        }
    }

    private class SourceListener implements ContentListener {
        private SourceListener() {
        }

        public void onContentDirty() {
            if (PhotoDataAdapter.this.mReloadTask != null) {
                PhotoDataAdapter.this.mReloadTask.notifyDirty();
            }
        }
    }

    private class UpdateContent implements Callable<Void> {
        UpdateInfo mUpdateInfo;

        public UpdateContent(UpdateInfo updateInfo) {
            this.mUpdateInfo = updateInfo;
        }

        public Void call() {
            UpdateInfo updateInfo = this.mUpdateInfo;
            PhotoDataAdapter.this.mSourceVersion = updateInfo.version;
            if (updateInfo.size != PhotoDataAdapter.this.mSize) {
                PhotoDataAdapter.this.mSize = updateInfo.size;
                if (PhotoDataAdapter.this.mContentEnd > PhotoDataAdapter.this.mSize) {
                    PhotoDataAdapter.this.mContentEnd = PhotoDataAdapter.this.mSize;
                }
                if (PhotoDataAdapter.this.mActiveEnd > PhotoDataAdapter.this.mSize) {
                    PhotoDataAdapter.this.mActiveEnd = PhotoDataAdapter.this.mSize;
                }
            }
            PhotoDataAdapter.this.mCurrentIndex = updateInfo.indexHint;
            PhotoDataAdapter.this.updateSlidingWindow();
            if (updateInfo.items != null) {
                int max = Math.max(updateInfo.contentStart, PhotoDataAdapter.this.mContentStart);
                int min = Math.min(updateInfo.contentStart + updateInfo.items.size(), PhotoDataAdapter.this.mContentEnd);
                int i = max % 256;
                int i2 = max;
                while (i2 < min) {
                    PhotoDataAdapter.this.mData[i] = (MediaItem) updateInfo.items.get(i2 - updateInfo.contentStart);
                    max = i + 1;
                    if (max == 256) {
                        max = 0;
                    }
                    i2++;
                    i = max;
                }
            }
            MediaItem mediaItem = PhotoDataAdapter.this.mData[PhotoDataAdapter.this.mCurrentIndex % 256];
            PhotoDataAdapter.this.mItemPath = mediaItem == null ? null : mediaItem.getPath();
            PhotoDataAdapter.this.updateImageCache();
            PhotoDataAdapter.this.updateTileProvider();
            PhotoDataAdapter.this.updateImageRequests();
            if (PhotoDataAdapter.this.mDataListener != null) {
                PhotoDataAdapter.this.mDataListener.onPhotoChanged(PhotoDataAdapter.this.mCurrentIndex, PhotoDataAdapter.this.mItemPath);
            }
            PhotoDataAdapter.this.fireDataChange();
            return null;
        }
    }

    private static class UpdateInfo {
        public int contentEnd;
        public int contentStart;
        public int indexHint;
        public ArrayList<MediaItem> items;
        public boolean reloadContent;
        public int size;
        public Path target;
        public long version;

        private UpdateInfo() {
        }
    }

    static {
        sImageFetchSeq[0] = new ImageFetch(0, 1);
        int i = 1;
        for (int i2 = 1; i2 < 7; i2++) {
            int i3 = i + 1;
            sImageFetchSeq[i] = new ImageFetch(i2, 1);
            i = i3 + 1;
            sImageFetchSeq[i3] = new ImageFetch(-i2, 1);
        }
        int i4 = i + 1;
        sImageFetchSeq[i] = new ImageFetch(0, 2);
        i = i4 + 1;
        sImageFetchSeq[i4] = new ImageFetch(1, 2);
        int i5 = i + 1;
        sImageFetchSeq[i] = new ImageFetch(-1, 2);
    }

    public PhotoDataAdapter(AbstractGalleryActivity abstractGalleryActivity, PhotoView photoView, MediaSet mediaSet, Path path, int i, int i2, boolean z) {
        this.mSource = (MediaSet) Utils.checkNotNull(mediaSet);
        this.mPhotoView = (PhotoView) Utils.checkNotNull(photoView);
        this.mItemPath = (Path) Utils.checkNotNull(path);
        this.mCurrentIndex = i;
        this.mCameraIndex = i2;
        this.mIsStaticCamera = z;
        this.mThreadPool = abstractGalleryActivity.getThreadPool();
        this.mNeedFullImage = true;
        Arrays.fill(this.mChanges, -1);
        this.mUploader = new Uploader(abstractGalleryActivity.getGLRoot());
        this.mMainHandler = new SynchronizedHandler(abstractGalleryActivity.getGLRoot()) {
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PhotoDataAdapter.this.mDataListener != null) {
                            PhotoDataAdapter.this.mDataListener.onLoadingStarted();
                            return;
                        }
                        return;
                    case 2:
                        if (PhotoDataAdapter.this.mDataListener != null) {
                            PhotoDataAdapter.this.mDataListener.onLoadingFinished(false);
                            return;
                        }
                        return;
                    case 3:
                        ((Runnable) message.obj).run();
                        return;
                    case 4:
                        PhotoDataAdapter.this.updateImageRequests();
                        return;
                    default:
                        throw new AssertionError();
                }
            }
        };
        updateSlidingWindow();
    }

    private <T> T executeAndWait(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        this.mMainHandler.sendMessage(this.mMainHandler.obtainMessage(3, futureTask));
        try {
            return futureTask.get();
        } catch (InterruptedException e) {
            return null;
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    private void fireDataChange() {
        int i;
        int i2 = 0;
        for (i = -3; i <= 3; i++) {
            long version = getVersion(this.mCurrentIndex + i);
            if (this.mChanges[i + 3] != version) {
                this.mChanges[i + 3] = version;
                i2 = 1;
            }
        }
        if (i2 != 0) {
            int[] iArr = new int[7];
            Object obj = new Path[7];
            System.arraycopy(this.mPaths, 0, obj, 0, 7);
            for (i2 = 0; i2 < 7; i2++) {
                this.mPaths[i2] = getPath((this.mCurrentIndex + i2) - 3);
            }
            for (i = 0; i < 7; i++) {
                Path path = this.mPaths[i];
                if (path == null) {
                    iArr[i] = Integer.MAX_VALUE;
                } else {
                    i2 = 0;
                    while (i2 < 7 && obj[i2] != path) {
                        i2++;
                    }
                    iArr[i] = i2 < 7 ? i2 - 3 : Integer.MAX_VALUE;
                }
            }
            this.mPhotoView.notifyDataChange(iArr, -this.mCurrentIndex, (this.mSize - 1) - this.mCurrentIndex);
        }
    }

    private MediaItem getItem(int i) {
        if (i < 0 || i >= this.mSize || !this.mIsActive) {
            return null;
        }
        boolean z = i >= this.mActiveStart && i < this.mActiveEnd;
        Utils.assertTrue(z);
        return (i < this.mContentStart || i >= this.mContentEnd) ? null : this.mData[i % 256];
    }

    private MediaItem getItemInternal(int i) {
        return (i < 0 || i >= this.mSize || i < this.mContentStart || i >= this.mContentEnd) ? null : this.mData[i % 256];
    }

    private Path getPath(int i) {
        MediaItem itemInternal = getItemInternal(i);
        return itemInternal == null ? null : itemInternal.getPath();
    }

    private long getVersion(int i) {
        MediaItem itemInternal = getItemInternal(i);
        return itemInternal == null ? -1 : itemInternal.getDataVersion();
    }

    private boolean isTemporaryItem(MediaItem mediaItem) {
        return this.mCameraIndex < 0 ? false : false;
    }

    private ScreenNail newPlaceholderScreenNail(MediaItem mediaItem) {
        return new TiledScreenNail(mediaItem.getWidth(), mediaItem.getHeight());
    }

    private Future<?> startTaskIfNeeded(int i, int i2) {
        if (i < this.mActiveStart || i >= this.mActiveEnd) {
            return null;
        }
        ImageEntry imageEntry = (ImageEntry) this.mImageCache.get(getPath(i));
        if (imageEntry == null) {
            return null;
        }
        MediaItem mediaItem = this.mData[i % 256];
        Utils.assertTrue(mediaItem != null);
        long dataVersion = mediaItem.getDataVersion();
        if (i2 == 1 && imageEntry.screenNailTask != null && imageEntry.requestedScreenNail == dataVersion) {
            return imageEntry.screenNailTask;
        }
        if (i2 == 2 && imageEntry.fullImageTask != null && imageEntry.requestedFullImage == dataVersion) {
            return imageEntry.fullImageTask;
        }
        if (i2 == 1 && imageEntry.requestedScreenNail != dataVersion) {
            imageEntry.requestedScreenNail = dataVersion;
            imageEntry.screenNailTask = this.mThreadPool.submit(new ScreenNailJob(mediaItem), new ScreenNailListener(mediaItem));
            return imageEntry.screenNailTask;
        } else if (i2 != 2 || imageEntry.requestedFullImage == dataVersion || (mediaItem.getSupportedOperations() & 64) == 0) {
            return null;
        } else {
            imageEntry.requestedFullImage = dataVersion;
            imageEntry.fullImageTask = this.mThreadPool.submit(new FullImageJob(mediaItem), new FullImageListener(mediaItem));
            return imageEntry.fullImageTask;
        }
    }

    private void updateCurrentIndex(int i) {
        if (this.mCurrentIndex != i) {
            this.mCurrentIndex = i;
            updateSlidingWindow();
            MediaItem mediaItem = this.mData[i % 256];
            this.mItemPath = mediaItem == null ? null : mediaItem.getPath();
            updateImageCache();
            updateImageRequests();
            updateTileProvider();
            if (this.mDataListener != null) {
                this.mDataListener.onPhotoChanged(i, this.mItemPath);
            }
            fireDataChange();
        }
    }

    private void updateFullImage(Path path, Future<BitmapRegionDecoder> future) {
        ImageEntry imageEntry = (ImageEntry) this.mImageCache.get(path);
        if (imageEntry == null || imageEntry.fullImageTask != future) {
            BitmapRegionDecoder bitmapRegionDecoder = (BitmapRegionDecoder) future.get();
            if (bitmapRegionDecoder != null) {
                bitmapRegionDecoder.recycle();
                return;
            }
            return;
        }
        imageEntry.fullImageTask = null;
        imageEntry.fullImage = (BitmapRegionDecoder) future.get();
        if (imageEntry.fullImage != null && path == getPath(this.mCurrentIndex)) {
            updateTileProvider(imageEntry);
            this.mPhotoView.notifyImageChange(0);
        }
        updateImageRequests();
    }

    private void updateImageCache() {
        HashSet hashSet = new HashSet(this.mImageCache.keySet());
        for (int i = this.mActiveStart; i < this.mActiveEnd; i++) {
            ImageEntry imageEntry;
            MediaItem mediaItem = this.mData[i % 256];
            if (mediaItem != null) {
                Path path = mediaItem.getPath();
                imageEntry = (ImageEntry) this.mImageCache.get(path);
                hashSet.remove(path);
                if (imageEntry != null) {
                    if (Math.abs(i - this.mCurrentIndex) > 1) {
                        if (imageEntry.fullImageTask != null) {
                            imageEntry.fullImageTask.cancel();
                            imageEntry.fullImageTask = null;
                        }
                        imageEntry.fullImage = null;
                        imageEntry.requestedFullImage = -1;
                    }
                    if (imageEntry.requestedScreenNail != mediaItem.getDataVersion() && (imageEntry.screenNail instanceof TiledScreenNail)) {
                        ((TiledScreenNail) imageEntry.screenNail).updatePlaceholderSize(mediaItem.getWidth(), mediaItem.getHeight());
                    }
                } else {
                    this.mImageCache.put(path, new ImageEntry());
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            imageEntry = (ImageEntry) this.mImageCache.remove((Path) it.next());
            if (imageEntry.fullImageTask != null) {
                imageEntry.fullImageTask.cancel();
            }
            if (imageEntry.screenNailTask != null) {
                imageEntry.screenNailTask.cancel();
            }
            if (imageEntry.screenNail != null) {
                imageEntry.screenNail.recycle();
            }
        }
        updateScreenNailUploadQueue();
    }

    private void updateImageRequests() {
        if (this.mIsActive) {
            int i = this.mCurrentIndex;
            MediaItem mediaItem = this.mData[i % 256];
            if (mediaItem != null && mediaItem.getPath() == this.mItemPath) {
                Future future;
                Future future2 = null;
                for (int i2 = 0; i2 < sImageFetchSeq.length; i2++) {
                    int i3 = sImageFetchSeq[i2].indexOffset;
                    int i4 = sImageFetchSeq[i2].imageBit;
                    if (i4 != 2 || this.mNeedFullImage) {
                        future2 = startTaskIfNeeded(i + i3, i4);
                        if (future2 != null) {
                            future = future2;
                            break;
                        }
                    }
                }
                future = future2;
                for (ImageEntry imageEntry : this.mImageCache.values()) {
                    if (!(imageEntry.screenNailTask == null || imageEntry.screenNailTask == r1)) {
                        imageEntry.screenNailTask.cancel();
                        imageEntry.screenNailTask = null;
                        imageEntry.requestedScreenNail = -1;
                    }
                    if (!(imageEntry.fullImageTask == null || imageEntry.fullImageTask == r1)) {
                        imageEntry.fullImageTask.cancel();
                        imageEntry.fullImageTask = null;
                        imageEntry.requestedFullImage = -1;
                    }
                }
            }
        }
    }

    private void updateScreenNail(Path path, Future<ScreenNail> future) {
        ImageEntry imageEntry = (ImageEntry) this.mImageCache.get(path);
        ScreenNail screenNail = (ScreenNail) future.get();
        if (imageEntry != null && imageEntry.screenNailTask == future) {
            imageEntry.screenNailTask = null;
            if (imageEntry.screenNail instanceof TiledScreenNail) {
                screenNail = ((TiledScreenNail) imageEntry.screenNail).combine(screenNail);
            }
            if (screenNail == null) {
                imageEntry.failToLoad = true;
            } else {
                imageEntry.failToLoad = false;
                imageEntry.screenNail = screenNail;
            }
            for (int i = -3; i <= 3; i++) {
                if (path == getPath(this.mCurrentIndex + i)) {
                    if (i == 0) {
                        updateTileProvider(imageEntry);
                    }
                    this.mPhotoView.notifyImageChange(i);
                    updateImageRequests();
                    updateScreenNailUploadQueue();
                }
            }
            updateImageRequests();
            updateScreenNailUploadQueue();
        } else if (screenNail != null) {
            screenNail.recycle();
        }
    }

    private void updateScreenNailUploadQueue() {
        this.mUploader.clear();
        uploadScreenNail(0);
        for (int i = 1; i < 7; i++) {
            uploadScreenNail(i);
            uploadScreenNail(-i);
        }
    }

    private void updateSlidingWindow() {
        int clamp = Utils.clamp(this.mCurrentIndex - 3, 0, Math.max(0, this.mSize - 7));
        int min = Math.min(this.mSize, clamp + 7);
        if (this.mActiveStart != clamp || this.mActiveEnd != min) {
            this.mActiveStart = clamp;
            this.mActiveEnd = min;
            min = Utils.clamp(this.mCurrentIndex - 128, 0, Math.max(0, this.mSize + InputDeviceCompat.SOURCE_ANY));
            int min2 = Math.min(this.mSize, min + 256);
            if (this.mContentStart > this.mActiveStart || this.mContentEnd < this.mActiveEnd || Math.abs(min - this.mContentStart) > 16) {
                clamp = this.mContentStart;
                while (clamp < this.mContentEnd) {
                    if (clamp < min || clamp >= min2) {
                        this.mData[clamp % 256] = null;
                    }
                    clamp++;
                }
                this.mContentStart = min;
                this.mContentEnd = min2;
                if (this.mReloadTask != null) {
                    this.mReloadTask.notifyDirty();
                }
            }
        }
    }

    private void updateTileProvider() {
        ImageEntry imageEntry = (ImageEntry) this.mImageCache.get(getPath(this.mCurrentIndex));
        if (imageEntry == null) {
            this.mTileProvider.clear();
        } else {
            updateTileProvider(imageEntry);
        }
    }

    private void updateTileProvider(ImageEntry imageEntry) {
        ScreenNail screenNail = imageEntry.screenNail;
        BitmapRegionDecoder bitmapRegionDecoder = imageEntry.fullImage;
        if (screenNail == null) {
            this.mTileProvider.clear();
        } else if (bitmapRegionDecoder != null) {
            this.mTileProvider.setScreenNail(screenNail, bitmapRegionDecoder.getWidth(), bitmapRegionDecoder.getHeight());
            this.mTileProvider.setRegionDecoder(bitmapRegionDecoder);
        } else {
            this.mTileProvider.setScreenNail(screenNail, screenNail.getWidth(), screenNail.getHeight());
        }
    }

    private void uploadScreenNail(int i) {
        int i2 = this.mCurrentIndex + i;
        if (i2 >= this.mActiveStart && i2 < this.mActiveEnd) {
            MediaItem item = getItem(i2);
            if (item != null) {
                ImageEntry imageEntry = (ImageEntry) this.mImageCache.get(item.getPath());
                if (imageEntry != null) {
                    ScreenNail screenNail = imageEntry.screenNail;
                    if (screenNail instanceof TiledScreenNail) {
                        TiledTexture texture = ((TiledScreenNail) screenNail).getTexture();
                        if (texture != null && !texture.isReady()) {
                            this.mUploader.addTexture(texture);
                        }
                    }
                }
            }
        }
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    public int getImageHeight() {
        return this.mTileProvider.getImageHeight();
    }

    public int getImageRotation(int i) {
        MediaItem item = getItem(this.mCurrentIndex + i);
        return item == null ? 0 : item.getFullImageRotation();
    }

    public void getImageSize(int i, Size size) {
        MediaItem item = getItem(this.mCurrentIndex + i);
        if (item == null) {
            size.width = 0;
            size.height = 0;
            return;
        }
        size.width = item.getWidth();
        size.height = item.getHeight();
    }

    public int getImageWidth() {
        return this.mTileProvider.getImageWidth();
    }

    public int getLevelCount() {
        return this.mTileProvider.getLevelCount();
    }

    public int getLoadingState(int i) {
        ImageEntry imageEntry = (ImageEntry) this.mImageCache.get(getPath(this.mCurrentIndex + i));
        return imageEntry == null ? 0 : imageEntry.failToLoad ? 2 : imageEntry.screenNail != null ? 1 : 0;
    }

    public MediaItem getMediaItem(int i) {
        int i2 = this.mCurrentIndex + i;
        return (i2 < this.mContentStart || i2 >= this.mContentEnd) ? null : this.mData[i2 % 256];
    }

    public ScreenNail getScreenNail() {
        return getScreenNail(0);
    }

    public ScreenNail getScreenNail(int i) {
        int i2 = this.mCurrentIndex + i;
        if (i2 < 0 || i2 >= this.mSize || !this.mIsActive) {
            return null;
        }
        boolean z = i2 >= this.mActiveStart && i2 < this.mActiveEnd;
        Utils.assertTrue(z);
        MediaItem item = getItem(i2);
        if (item == null) {
            return null;
        }
        ImageEntry imageEntry = (ImageEntry) this.mImageCache.get(item.getPath());
        if (imageEntry == null) {
            return null;
        }
        if (imageEntry.screenNail == null && !isCamera(i)) {
            imageEntry.screenNail = newPlaceholderScreenNail(item);
            if (i == 0) {
                updateTileProvider(imageEntry);
            }
        }
        return imageEntry.screenNail;
    }

    public Bitmap getTile(int i, int i2, int i3, int i4, int i5, BitmapPool bitmapPool) {
        return this.mTileProvider.getTile(i, i2, i3, i4, i5, bitmapPool);
    }

    public boolean isCamera(int i) {
        return this.mCurrentIndex + i == this.mCameraIndex;
    }

    public boolean isDeletable(int i) {
        MediaItem item = getItem(this.mCurrentIndex + i);
        return (item == null || (item.getSupportedOperations() & 1) == 0) ? false : true;
    }

    public boolean isEmpty() {
        return this.mSize == 0;
    }

    public boolean isStaticCamera(int i) {
        return isCamera(i) && this.mIsStaticCamera;
    }

    public boolean isVideo(int i) {
        MediaItem item = getItem(this.mCurrentIndex + i);
        return item != null && item.getMediaType() == 4;
    }

    public void moveTo(int i) {
        updateCurrentIndex(i);
    }

    public void pause() {
        this.mIsActive = false;
        this.mReloadTask.terminate();
        this.mReloadTask = null;
        this.mSource.removeContentListener(this.mSourceListener);
        for (ImageEntry imageEntry : this.mImageCache.values()) {
            if (imageEntry.fullImageTask != null) {
                imageEntry.fullImageTask.cancel();
            }
            if (imageEntry.screenNailTask != null) {
                imageEntry.screenNailTask.cancel();
            }
            if (imageEntry.screenNail != null) {
                imageEntry.screenNail.recycle();
            }
        }
        this.mImageCache.clear();
        this.mTileProvider.clear();
        this.mUploader.clear();
        TiledTexture.freeResources();
    }

    public void resume() {
        this.mIsActive = true;
        TiledTexture.prepareResources();
        this.mSource.addContentListener(this.mSourceListener);
        updateImageCache();
        updateImageRequests();
        this.mReloadTask = new ReloadTask();
        this.mReloadTask.start();
        fireDataChange();
    }

    public void setCurrentPhoto(Path path, int i) {
        if (this.mItemPath != path) {
            this.mItemPath = path;
            this.mCurrentIndex = i;
            updateSlidingWindow();
            updateImageCache();
            fireDataChange();
            MediaItem mediaItem = getMediaItem(0);
            if (mediaItem != null && mediaItem.getPath() != path && this.mReloadTask != null) {
                this.mReloadTask.notifyDirty();
            }
        }
    }

    public void setDataListener(DataListener dataListener) {
        this.mDataListener = dataListener;
    }

    public void setFocusHintDirection(int i) {
        this.mFocusHintDirection = i;
    }

    public void setFocusHintPath(Path path) {
        this.mFocusHintPath = path;
    }

    public void setNeedFullImage(boolean z) {
        this.mNeedFullImage = z;
        this.mMainHandler.sendEmptyMessage(4);
    }
}
