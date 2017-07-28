package com.android.gallery3d.ui;

import android.graphics.Bitmap;
import android.os.Message;
import com.android.gallery3d.app.AbstractGalleryActivity;
import com.android.gallery3d.app.AlbumDataLoader;
import com.android.gallery3d.app.AlbumDataLoader.DataListener;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.data.BitmapPool;
import com.android.gallery3d.data.MediaItem;
import com.android.gallery3d.data.Path;
import com.android.gallery3d.ui.TiledTexture.Uploader;
import com.android.gallery3d.util.Future;
import com.android.gallery3d.util.FutureListener;
import com.android.gallery3d.util.JobLimiter;

public class AlbumSlidingWindow implements DataListener {
    private static final int JOB_LIMIT = 2;
    private static final int MSG_UPDATE_ENTRY = 0;
    private static final String TAG = "AlbumSlidingWindow";
    private int mActiveEnd = 0;
    private int mActiveRequestCount = 0;
    private int mActiveStart = 0;
    private int mContentEnd = 0;
    private int mContentStart = 0;
    private final AlbumEntry[] mData;
    private final SynchronizedHandler mHandler;
    private boolean mIsActive = false;
    private Listener mListener;
    private int mSize;
    private final AlbumDataLoader mSource;
    private final JobLimiter mThreadPool;
    private final Uploader mTileUploader;

    public static class AlbumEntry {
        public TiledTexture bitmapTexture;
        public Texture content;
        private BitmapLoader contentLoader;
        public boolean isWaitDisplayed;
        public MediaItem item;
        public int mediaType;
        public Path path;
        public int rotation;
    }

    public interface Listener {
        void onContentChanged();

        void onSizeChanged(int i);
    }

    private class ThumbnailLoader extends BitmapLoader {
        private final MediaItem mItem;
        private final int mSlotIndex;

        public ThumbnailLoader(int i, MediaItem mediaItem) {
            this.mSlotIndex = i;
            this.mItem = mediaItem;
        }

        protected void onLoadComplete(Bitmap bitmap) {
            AlbumSlidingWindow.this.mHandler.obtainMessage(0, this).sendToTarget();
        }

        protected void recycleBitmap(Bitmap bitmap) {
            BitmapPool microThumbPool = MediaItem.getMicroThumbPool();
            if (microThumbPool != null) {
                microThumbPool.recycle(bitmap);
            }
        }

        protected Future<Bitmap> submitBitmapTask(FutureListener<Bitmap> futureListener) {
            return AlbumSlidingWindow.this.mThreadPool.submit(this.mItem.requestImage(2), this);
        }

        public void updateEntry() {
            Bitmap bitmap = getBitmap();
            if (bitmap != null) {
                AlbumEntry albumEntry = AlbumSlidingWindow.this.mData[this.mSlotIndex % AlbumSlidingWindow.this.mData.length];
                albumEntry.bitmapTexture = new TiledTexture(bitmap);
                albumEntry.content = albumEntry.bitmapTexture;
                if (AlbumSlidingWindow.this.isActiveSlot(this.mSlotIndex)) {
                    AlbumSlidingWindow.this.mTileUploader.addTexture(albumEntry.bitmapTexture);
                    AlbumSlidingWindow.access$506(AlbumSlidingWindow.this);
                    if (AlbumSlidingWindow.this.mActiveRequestCount == 0) {
                        AlbumSlidingWindow.this.requestNonactiveImages();
                    }
                    if (AlbumSlidingWindow.this.mListener != null) {
                        AlbumSlidingWindow.this.mListener.onContentChanged();
                        return;
                    }
                    return;
                }
                AlbumSlidingWindow.this.mTileUploader.addTexture(albumEntry.bitmapTexture);
            }
        }
    }

    public AlbumSlidingWindow(AbstractGalleryActivity abstractGalleryActivity, AlbumDataLoader albumDataLoader, int i) {
        albumDataLoader.setDataListener(this);
        this.mSource = albumDataLoader;
        this.mData = new AlbumEntry[i];
        this.mSize = albumDataLoader.size();
        this.mHandler = new SynchronizedHandler(abstractGalleryActivity.getGLRoot()) {
            public void handleMessage(Message message) {
                Utils.assertTrue(message.what == 0);
                ((ThumbnailLoader) message.obj).updateEntry();
            }
        };
        this.mThreadPool = new JobLimiter(abstractGalleryActivity.getThreadPool(), 2);
        this.mTileUploader = new Uploader(abstractGalleryActivity.getGLRoot());
    }

    static /* synthetic */ int access$506(AlbumSlidingWindow albumSlidingWindow) {
        int i = albumSlidingWindow.mActiveRequestCount - 1;
        albumSlidingWindow.mActiveRequestCount = i;
        return i;
    }

    private void cancelNonactiveImages() {
        int max = Math.max(this.mContentEnd - this.mActiveEnd, this.mActiveStart - this.mContentStart);
        for (int i = 0; i < max; i++) {
            cancelSlotImage(this.mActiveEnd + i);
            cancelSlotImage((this.mActiveStart - 1) - i);
        }
    }

    private void cancelSlotImage(int i) {
        if (i >= this.mContentStart && i < this.mContentEnd) {
            AlbumEntry albumEntry = this.mData[i % this.mData.length];
            if (albumEntry.contentLoader != null) {
                albumEntry.contentLoader.cancelLoad();
            }
        }
    }

    private void freeSlotContent(int i) {
        AlbumEntry[] albumEntryArr = this.mData;
        int length = i % albumEntryArr.length;
        AlbumEntry albumEntry = albumEntryArr[length];
        if (albumEntry.contentLoader != null) {
            albumEntry.contentLoader.recycle();
        }
        if (albumEntry.bitmapTexture != null) {
            albumEntry.bitmapTexture.recycle();
        }
        albumEntryArr[length] = null;
    }

    private void prepareSlotContent(int i) {
        AlbumEntry albumEntry = new AlbumEntry();
        MediaItem mediaItem = this.mSource.get(i);
        albumEntry.item = mediaItem;
        albumEntry.mediaType = mediaItem == null ? 1 : albumEntry.item.getMediaType();
        albumEntry.path = mediaItem == null ? null : mediaItem.getPath();
        albumEntry.rotation = mediaItem == null ? 0 : mediaItem.getRotation();
        albumEntry.contentLoader = new ThumbnailLoader(i, albumEntry.item);
        this.mData[i % this.mData.length] = albumEntry;
    }

    private void requestNonactiveImages() {
        int max = Math.max(this.mContentEnd - this.mActiveEnd, this.mActiveStart - this.mContentStart);
        for (int i = 0; i < max; i++) {
            requestSlotImage(this.mActiveEnd + i);
            requestSlotImage((this.mActiveStart - 1) - i);
        }
    }

    private boolean requestSlotImage(int i) {
        if (i < this.mContentStart || i >= this.mContentEnd) {
            return false;
        }
        AlbumEntry albumEntry = this.mData[i % this.mData.length];
        if (albumEntry.content != null || albumEntry.item == null) {
            return false;
        }
        albumEntry.contentLoader.startLoad();
        return albumEntry.contentLoader.isRequestInProgress();
    }

    private void setContentWindow(int i, int i2) {
        if (i != this.mContentStart || i2 != this.mContentEnd) {
            if (this.mIsActive) {
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
                return;
            }
            this.mContentStart = i;
            this.mContentEnd = i2;
            this.mSource.setActiveWindow(i, i2);
        }
    }

    private void updateAllImageRequests() {
        this.mActiveRequestCount = 0;
        int i = this.mActiveEnd;
        for (int i2 = this.mActiveStart; i2 < i; i2++) {
            if (requestSlotImage(i2)) {
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
            this.mTileUploader.clear();
            int i2 = this.mActiveEnd;
            for (i = this.mActiveStart; i < i2; i++) {
                AlbumEntry albumEntry = this.mData[i % this.mData.length];
                if (albumEntry.bitmapTexture != null) {
                    this.mTileUploader.addTexture(albumEntry.bitmapTexture);
                }
            }
            i2 = Math.max(this.mContentEnd - this.mActiveEnd, this.mActiveStart - this.mContentStart);
            for (i = 0; i < i2; i++) {
                uploadBgTextureInSlot(this.mActiveEnd + i);
                uploadBgTextureInSlot((this.mActiveStart - i) - 1);
            }
        }
    }

    private void uploadBgTextureInSlot(int i) {
        if (i < this.mContentEnd && i >= this.mContentStart) {
            AlbumEntry albumEntry = this.mData[i % this.mData.length];
            if (albumEntry.bitmapTexture != null) {
                this.mTileUploader.addTexture(albumEntry.bitmapTexture);
            }
        }
    }

    public AlbumEntry get(int i) {
        if (!isActiveSlot(i)) {
            Utils.fail("invalid slot: %s outsides (%s, %s)", Integer.valueOf(i), Integer.valueOf(this.mActiveStart), Integer.valueOf(this.mActiveEnd));
        }
        return this.mData[i % this.mData.length];
    }

    public boolean isActiveSlot(int i) {
        return i >= this.mActiveStart && i < this.mActiveEnd;
    }

    public void onContentChanged(int i) {
        if (i >= this.mContentStart && i < this.mContentEnd && this.mIsActive) {
            freeSlotContent(i);
            prepareSlotContent(i);
            updateAllImageRequests();
            if (this.mListener != null && isActiveSlot(i)) {
                this.mListener.onContentChanged();
            }
        }
    }

    public void onSizeChanged(int i) {
        if (this.mSize != i) {
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

    public void pause() {
        this.mIsActive = false;
        this.mTileUploader.clear();
        TiledTexture.freeResources();
        int i = this.mContentEnd;
        for (int i2 = this.mContentStart; i2 < i; i2++) {
            freeSlotContent(i2);
        }
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
            Utils.fail("%s, %s, %s, %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.mData.length), Integer.valueOf(this.mSize));
        }
        AlbumEntry[] albumEntryArr = this.mData;
        this.mActiveStart = i;
        this.mActiveEnd = i2;
        int clamp = Utils.clamp(((i + i2) / 2) - (albumEntryArr.length / 2), 0, Math.max(0, this.mSize - albumEntryArr.length));
        setContentWindow(clamp, Math.min(albumEntryArr.length + clamp, this.mSize));
        updateTextureUploadQueue();
        if (this.mIsActive) {
            updateAllImageRequests();
        }
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }
}
