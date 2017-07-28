package com.android.gallery3d.ui;

import android.graphics.Bitmap;
import android.os.Message;
import com.android.gallery3d.C0488R;
import com.android.gallery3d.app.AbstractGalleryActivity;
import com.android.gallery3d.app.AlbumSetDataLoader;
import com.android.gallery3d.app.AlbumSetDataLoader.DataListener;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.data.BitmapPool;
import com.android.gallery3d.data.DataSourceType;
import com.android.gallery3d.data.MediaItem;
import com.android.gallery3d.data.MediaObject;
import com.android.gallery3d.data.MediaSet;
import com.android.gallery3d.data.Path;
import com.android.gallery3d.ui.AlbumSetSlotRenderer.LabelSpec;
import com.android.gallery3d.ui.TiledTexture.Uploader;
import com.android.gallery3d.util.Future;
import com.android.gallery3d.util.FutureListener;
import com.android.gallery3d.util.ThreadPool;

public class AlbumSetSlidingWindow implements DataListener {
    private static final int MSG_UPDATE_ALBUM_ENTRY = 1;
    private static final String TAG = "AlbumSetSlidingWindow";
    private int mActiveEnd = 0;
    private int mActiveRequestCount = 0;
    private int mActiveStart = 0;
    private int mContentEnd = 0;
    private int mContentStart = 0;
    private final Uploader mContentUploader;
    private final AlbumSetEntry[] mData;
    private final SynchronizedHandler mHandler;
    private boolean mIsActive = false;
    private final AlbumLabelMaker mLabelMaker;
    private final TextureUploader mLabelUploader;
    private Listener mListener;
    private BitmapTexture mLoadingLabel;
    private final String mLoadingText;
    private int mSize;
    private int mSlotWidth;
    private final AlbumSetDataLoader mSource;
    private final ThreadPool mThreadPool;

    private interface EntryUpdater {
        void updateEntry();
    }

    private class AlbumCoverLoader extends BitmapLoader implements EntryUpdater {
        private MediaItem mMediaItem;
        private final int mSlotIndex;

        public AlbumCoverLoader(int i, MediaItem mediaItem) {
            this.mSlotIndex = i;
            this.mMediaItem = mediaItem;
        }

        protected void onLoadComplete(Bitmap bitmap) {
            AlbumSetSlidingWindow.this.mHandler.obtainMessage(1, this).sendToTarget();
        }

        protected void recycleBitmap(Bitmap bitmap) {
            BitmapPool microThumbPool = MediaItem.getMicroThumbPool();
            if (microThumbPool != null) {
                microThumbPool.recycle(bitmap);
            }
        }

        protected Future<Bitmap> submitBitmapTask(FutureListener<Bitmap> futureListener) {
            return AlbumSetSlidingWindow.this.mThreadPool.submit(this.mMediaItem.requestImage(2), futureListener);
        }

        public void updateEntry() {
            Bitmap bitmap = getBitmap();
            if (bitmap != null) {
                AlbumSetEntry albumSetEntry = AlbumSetSlidingWindow.this.mData[this.mSlotIndex % AlbumSetSlidingWindow.this.mData.length];
                TiledTexture tiledTexture = new TiledTexture(bitmap);
                albumSetEntry.bitmapTexture = tiledTexture;
                albumSetEntry.content = tiledTexture;
                if (AlbumSetSlidingWindow.this.isActiveSlot(this.mSlotIndex)) {
                    AlbumSetSlidingWindow.this.mContentUploader.addTexture(tiledTexture);
                    AlbumSetSlidingWindow.access$606(AlbumSetSlidingWindow.this);
                    if (AlbumSetSlidingWindow.this.mActiveRequestCount == 0) {
                        AlbumSetSlidingWindow.this.requestNonactiveImages();
                    }
                    if (AlbumSetSlidingWindow.this.mListener != null) {
                        AlbumSetSlidingWindow.this.mListener.onContentChanged();
                        return;
                    }
                    return;
                }
                AlbumSetSlidingWindow.this.mContentUploader.addTexture(tiledTexture);
            }
        }
    }

    private class AlbumLabelLoader extends BitmapLoader implements EntryUpdater {
        private final int mSlotIndex;
        private final int mSourceType;
        private final String mTitle;
        private final int mTotalCount;

        public AlbumLabelLoader(int i, String str, int i2, int i3) {
            this.mSlotIndex = i;
            this.mTitle = str;
            this.mTotalCount = i2;
            this.mSourceType = i3;
        }

        protected void onLoadComplete(Bitmap bitmap) {
            AlbumSetSlidingWindow.this.mHandler.obtainMessage(1, this).sendToTarget();
        }

        protected void recycleBitmap(Bitmap bitmap) {
            AlbumSetSlidingWindow.this.mLabelMaker.recycleLabel(bitmap);
        }

        protected Future<Bitmap> submitBitmapTask(FutureListener<Bitmap> futureListener) {
            return AlbumSetSlidingWindow.this.mThreadPool.submit(AlbumSetSlidingWindow.this.mLabelMaker.requestLabel(this.mTitle, String.valueOf(this.mTotalCount), this.mSourceType), futureListener);
        }

        public void updateEntry() {
            Bitmap bitmap = getBitmap();
            if (bitmap != null) {
                AlbumSetEntry albumSetEntry = AlbumSetSlidingWindow.this.mData[this.mSlotIndex % AlbumSetSlidingWindow.this.mData.length];
                UploadedTexture bitmapTexture = new BitmapTexture(bitmap);
                bitmapTexture.setOpaque(false);
                albumSetEntry.labelTexture = bitmapTexture;
                if (AlbumSetSlidingWindow.this.isActiveSlot(this.mSlotIndex)) {
                    AlbumSetSlidingWindow.this.mLabelUploader.addFgTexture(bitmapTexture);
                    AlbumSetSlidingWindow.access$606(AlbumSetSlidingWindow.this);
                    if (AlbumSetSlidingWindow.this.mActiveRequestCount == 0) {
                        AlbumSetSlidingWindow.this.requestNonactiveImages();
                    }
                    if (AlbumSetSlidingWindow.this.mListener != null) {
                        AlbumSetSlidingWindow.this.mListener.onContentChanged();
                        return;
                    }
                    return;
                }
                AlbumSetSlidingWindow.this.mLabelUploader.addBgTexture(bitmapTexture);
            }
        }
    }

    public static class AlbumSetEntry {
        public MediaSet album;
        public TiledTexture bitmapTexture;
        public int cacheFlag;
        public int cacheStatus;
        public Texture content;
        public long coverDataVersion;
        public MediaItem coverItem;
        private BitmapLoader coverLoader;
        public boolean isWaitLoadingDisplayed;
        private BitmapLoader labelLoader;
        public BitmapTexture labelTexture;
        public int rotation;
        public long setDataVersion;
        public Path setPath;
        public int sourceType;
        public String title;
        public int totalCount;
    }

    public interface Listener {
        void onContentChanged();

        void onSizeChanged(int i);
    }

    public AlbumSetSlidingWindow(AbstractGalleryActivity abstractGalleryActivity, AlbumSetDataLoader albumSetDataLoader, LabelSpec labelSpec, int i) {
        albumSetDataLoader.setModelListener(this);
        this.mSource = albumSetDataLoader;
        this.mData = new AlbumSetEntry[i];
        this.mSize = albumSetDataLoader.size();
        this.mThreadPool = abstractGalleryActivity.getThreadPool();
        this.mLabelMaker = new AlbumLabelMaker(abstractGalleryActivity.getAndroidContext(), labelSpec);
        this.mLoadingText = abstractGalleryActivity.getAndroidContext().getString(C0488R.string.loading);
        this.mContentUploader = new Uploader(abstractGalleryActivity.getGLRoot());
        this.mLabelUploader = new TextureUploader(abstractGalleryActivity.getGLRoot());
        this.mHandler = new SynchronizedHandler(abstractGalleryActivity.getGLRoot()) {
            public void handleMessage(Message message) {
                boolean z = true;
                if (message.what != 1) {
                    z = false;
                }
                Utils.assertTrue(z);
                ((EntryUpdater) message.obj).updateEntry();
            }
        };
    }

    static /* synthetic */ int access$606(AlbumSetSlidingWindow albumSetSlidingWindow) {
        int i = albumSetSlidingWindow.mActiveRequestCount - 1;
        albumSetSlidingWindow.mActiveRequestCount = i;
        return i;
    }

    private void cancelImagesInSlot(int i) {
        if (i >= this.mContentStart && i < this.mContentEnd) {
            AlbumSetEntry albumSetEntry = this.mData[i % this.mData.length];
            if (albumSetEntry.coverLoader != null) {
                albumSetEntry.coverLoader.cancelLoad();
            }
            if (albumSetEntry.labelLoader != null) {
                albumSetEntry.labelLoader.cancelLoad();
            }
        }
    }

    private void cancelNonactiveImages() {
        int max = Math.max(this.mContentEnd - this.mActiveEnd, this.mActiveStart - this.mContentStart);
        for (int i = 0; i < max; i++) {
            cancelImagesInSlot(this.mActiveEnd + i);
            cancelImagesInSlot((this.mActiveStart - 1) - i);
        }
    }

    private void freeSlotContent(int i) {
        AlbumSetEntry albumSetEntry = this.mData[i % this.mData.length];
        if (albumSetEntry.coverLoader != null) {
            albumSetEntry.coverLoader.recycle();
        }
        if (albumSetEntry.labelLoader != null) {
            albumSetEntry.labelLoader.recycle();
        }
        if (albumSetEntry.labelTexture != null) {
            albumSetEntry.labelTexture.recycle();
        }
        if (albumSetEntry.bitmapTexture != null) {
            albumSetEntry.bitmapTexture.recycle();
        }
        this.mData[i % this.mData.length] = null;
    }

    private static long getDataVersion(MediaObject mediaObject) {
        return mediaObject == null ? -1 : mediaObject.getDataVersion();
    }

    private static int identifyCacheFlag(MediaSet mediaSet) {
        return (mediaSet == null || (mediaSet.getSupportedOperations() & 256) == 0) ? 0 : mediaSet.getCacheFlag();
    }

    private static int identifyCacheStatus(MediaSet mediaSet) {
        return (mediaSet == null || (mediaSet.getSupportedOperations() & 256) == 0) ? 0 : mediaSet.getCacheStatus();
    }

    private boolean isLabelChanged(AlbumSetEntry albumSetEntry, String str, int i, int i2) {
        return (Utils.equals(albumSetEntry.title, str) && albumSetEntry.totalCount == i && albumSetEntry.sourceType == i2) ? false : true;
    }

    private void prepareSlotContent(int i) {
        AlbumSetEntry albumSetEntry = new AlbumSetEntry();
        updateAlbumSetEntry(albumSetEntry, i);
        this.mData[i % this.mData.length] = albumSetEntry;
    }

    private void requestImagesInSlot(int i) {
        if (i >= this.mContentStart && i < this.mContentEnd) {
            AlbumSetEntry albumSetEntry = this.mData[i % this.mData.length];
            if (albumSetEntry.coverLoader != null) {
                albumSetEntry.coverLoader.startLoad();
            }
            if (albumSetEntry.labelLoader != null) {
                albumSetEntry.labelLoader.startLoad();
            }
        }
    }

    private void requestNonactiveImages() {
        int max = Math.max(this.mContentEnd - this.mActiveEnd, this.mActiveStart - this.mContentStart);
        for (int i = 0; i < max; i++) {
            requestImagesInSlot(this.mActiveEnd + i);
            requestImagesInSlot((this.mActiveStart - 1) - i);
        }
    }

    private void setContentWindow(int i, int i2) {
        if (i != this.mContentStart || i2 != this.mContentEnd) {
            int i3;
            int i4;
            if (i >= this.mContentEnd || this.mContentStart >= i2) {
                i3 = this.mContentEnd;
                for (i4 = this.mContentStart; i4 < i3; i4++) {
                    freeSlotContent(i4);
                }
                this.mSource.setActiveWindow(i, i2);
                for (i4 = i; i4 < i2; i4++) {
                    prepareSlotContent(i4);
                }
            } else {
                for (i4 = this.mContentStart; i4 < i; i4++) {
                    freeSlotContent(i4);
                }
                i3 = this.mContentEnd;
                for (i4 = i2; i4 < i3; i4++) {
                    freeSlotContent(i4);
                }
                this.mSource.setActiveWindow(i, i2);
                i3 = this.mContentStart;
                for (i4 = i; i4 < i3; i4++) {
                    prepareSlotContent(i4);
                }
                for (i4 = this.mContentEnd; i4 < i2; i4++) {
                    prepareSlotContent(i4);
                }
            }
            this.mContentStart = i;
            this.mContentEnd = i2;
        }
    }

    private static boolean startLoadBitmap(BitmapLoader bitmapLoader) {
        if (bitmapLoader == null) {
            return false;
        }
        bitmapLoader.startLoad();
        return bitmapLoader.isRequestInProgress();
    }

    private void updateAlbumSetEntry(AlbumSetEntry albumSetEntry, int i) {
        MediaObject mediaSet = this.mSource.getMediaSet(i);
        MediaObject coverItem = this.mSource.getCoverItem(i);
        int totalCount = this.mSource.getTotalCount(i);
        albumSetEntry.album = mediaSet;
        albumSetEntry.setDataVersion = getDataVersion(mediaSet);
        albumSetEntry.cacheFlag = identifyCacheFlag(mediaSet);
        albumSetEntry.cacheStatus = identifyCacheStatus(mediaSet);
        albumSetEntry.setPath = mediaSet == null ? null : mediaSet.getPath();
        String ensureNotNull = mediaSet == null ? "" : Utils.ensureNotNull(mediaSet.getName());
        int identifySourceType = DataSourceType.identifySourceType(mediaSet);
        if (isLabelChanged(albumSetEntry, ensureNotNull, totalCount, identifySourceType)) {
            albumSetEntry.title = ensureNotNull;
            albumSetEntry.totalCount = totalCount;
            albumSetEntry.sourceType = identifySourceType;
            if (albumSetEntry.labelLoader != null) {
                albumSetEntry.labelLoader.recycle();
                albumSetEntry.labelLoader = null;
                albumSetEntry.labelTexture = null;
            }
            if (mediaSet != null) {
                albumSetEntry.labelLoader = new AlbumLabelLoader(i, ensureNotNull, totalCount, identifySourceType);
            }
        }
        albumSetEntry.coverItem = coverItem;
        if (getDataVersion(coverItem) != albumSetEntry.coverDataVersion) {
            albumSetEntry.coverDataVersion = getDataVersion(coverItem);
            albumSetEntry.rotation = coverItem == null ? 0 : coverItem.getRotation();
            if (albumSetEntry.coverLoader != null) {
                albumSetEntry.coverLoader.recycle();
                albumSetEntry.coverLoader = null;
                albumSetEntry.bitmapTexture = null;
                albumSetEntry.content = null;
            }
            if (coverItem != null) {
                albumSetEntry.coverLoader = new AlbumCoverLoader(i, coverItem);
            }
        }
    }

    private void updateAllImageRequests() {
        this.mActiveRequestCount = 0;
        int i = this.mActiveEnd;
        for (int i2 = this.mActiveStart; i2 < i; i2++) {
            AlbumSetEntry albumSetEntry = this.mData[i2 % this.mData.length];
            if (startLoadBitmap(albumSetEntry.coverLoader)) {
                this.mActiveRequestCount++;
            }
            if (startLoadBitmap(albumSetEntry.labelLoader)) {
                this.mActiveRequestCount++;
            }
        }
        if (this.mActiveRequestCount == 0) {
            requestNonactiveImages();
        } else {
            cancelNonactiveImages();
        }
    }

    private void updateTextureUploadQueue() {
        if (this.mIsActive) {
            int i;
            this.mContentUploader.clear();
            this.mLabelUploader.clear();
            int i2 = this.mActiveEnd;
            for (i = this.mActiveStart; i < i2; i++) {
                AlbumSetEntry albumSetEntry = this.mData[i % this.mData.length];
                if (albumSetEntry.bitmapTexture != null) {
                    this.mContentUploader.addTexture(albumSetEntry.bitmapTexture);
                }
                if (albumSetEntry.labelTexture != null) {
                    this.mLabelUploader.addFgTexture(albumSetEntry.labelTexture);
                }
            }
            i2 = Math.max(this.mContentEnd - this.mActiveEnd, this.mActiveStart - this.mContentStart);
            for (i = 0; i < i2; i++) {
                uploadBackgroundTextureInSlot(this.mActiveEnd + i);
                uploadBackgroundTextureInSlot((this.mActiveStart - i) - 1);
            }
        }
    }

    private void uploadBackgroundTextureInSlot(int i) {
        if (i >= this.mContentStart && i < this.mContentEnd) {
            AlbumSetEntry albumSetEntry = this.mData[i % this.mData.length];
            if (albumSetEntry.bitmapTexture != null) {
                this.mContentUploader.addTexture(albumSetEntry.bitmapTexture);
            }
            if (albumSetEntry.labelTexture != null) {
                this.mLabelUploader.addBgTexture(albumSetEntry.labelTexture);
            }
        }
    }

    public AlbumSetEntry get(int i) {
        if (!isActiveSlot(i)) {
            Utils.fail("invalid slot: %s outsides (%s, %s)", Integer.valueOf(i), Integer.valueOf(this.mActiveStart), Integer.valueOf(this.mActiveEnd));
        }
        return this.mData[i % this.mData.length];
    }

    public BitmapTexture getLoadingTexture() {
        if (this.mLoadingLabel == null) {
            this.mLoadingLabel = new BitmapTexture((Bitmap) this.mLabelMaker.requestLabel(this.mLoadingText, "", 0).run(ThreadPool.JOB_CONTEXT_STUB));
            this.mLoadingLabel.setOpaque(false);
        }
        return this.mLoadingLabel;
    }

    public boolean isActiveSlot(int i) {
        return i >= this.mActiveStart && i < this.mActiveEnd;
    }

    public void onContentChanged(int i) {
        if (!this.mIsActive) {
            return;
        }
        if (i < this.mContentStart || i >= this.mContentEnd) {
            Log.m459w(TAG, String.format("invalid update: %s is outside (%s, %s)", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mContentStart), Integer.valueOf(this.mContentEnd)}));
            return;
        }
        updateAlbumSetEntry(this.mData[i % this.mData.length], i);
        updateAllImageRequests();
        updateTextureUploadQueue();
        if (this.mListener != null && isActiveSlot(i)) {
            this.mListener.onContentChanged();
        }
    }

    public void onSizeChanged(int i) {
        if (this.mIsActive && this.mSize != i) {
            this.mSize = i;
            if (this.mListener != null) {
                this.mListener.onSizeChanged(this.mSize);
            }
            if (this.mContentEnd > this.mSize) {
                this.mContentEnd = this.mSize;
            }
            if (this.mActiveEnd > this.mSize) {
                this.mActiveEnd = this.mSize;
            }
        }
    }

    public void onSlotSizeChanged(int i, int i2) {
        if (this.mSlotWidth != i) {
            this.mSlotWidth = i;
            this.mLoadingLabel = null;
            this.mLabelMaker.setLabelWidth(this.mSlotWidth);
            if (this.mIsActive) {
                int i3 = this.mContentEnd;
                for (int i4 = this.mContentStart; i4 < i3; i4++) {
                    AlbumSetEntry albumSetEntry = this.mData[i4 % this.mData.length];
                    if (albumSetEntry.labelLoader != null) {
                        albumSetEntry.labelLoader.recycle();
                        albumSetEntry.labelLoader = null;
                        albumSetEntry.labelTexture = null;
                    }
                    if (albumSetEntry.album != null) {
                        albumSetEntry.labelLoader = new AlbumLabelLoader(i4, albumSetEntry.title, albumSetEntry.totalCount, albumSetEntry.sourceType);
                    }
                }
                updateAllImageRequests();
                updateTextureUploadQueue();
            }
        }
    }

    public void pause() {
        this.mIsActive = false;
        this.mLabelUploader.clear();
        this.mContentUploader.clear();
        TiledTexture.freeResources();
        int i = this.mContentEnd;
        for (int i2 = this.mContentStart; i2 < i; i2++) {
            freeSlotContent(i2);
        }
        this.mLabelMaker.clearRecycledLabels();
    }

    public void resume() {
        this.mIsActive = true;
        TiledTexture.prepareResources();
        int i = this.mContentEnd;
        for (int i2 = this.mContentStart; i2 < i; i2++) {
            prepareSlotContent(i2);
        }
        updateAllImageRequests();
    }

    public void setActiveWindow(int i, int i2) {
        if (i > i2 || i2 - i > this.mData.length || i2 > this.mSize) {
            Utils.fail("start = %s, end = %s, length = %s, size = %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.mData.length), Integer.valueOf(this.mSize));
        }
        AlbumSetEntry[] albumSetEntryArr = this.mData;
        this.mActiveStart = i;
        this.mActiveEnd = i2;
        int clamp = Utils.clamp(((i + i2) / 2) - (albumSetEntryArr.length / 2), 0, Math.max(0, this.mSize - albumSetEntryArr.length));
        setContentWindow(clamp, Math.min(albumSetEntryArr.length + clamp, this.mSize));
        if (this.mIsActive) {
            updateTextureUploadQueue();
            updateAllImageRequests();
        }
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public int size() {
        return this.mSize;
    }
}
