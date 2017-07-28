package com.android.gallery3d.data;

import com.android.gallery3d.common.Utils;
import com.android.gallery3d.util.Future;
import java.util.ArrayList;
import java.util.WeakHashMap;

public abstract class MediaSet extends MediaObject {
    private static final Future<Integer> FUTURE_STUB = new C05311();
    public static final int INDEX_NOT_FOUND = -1;
    public static final int MEDIAITEM_BATCH_FETCH_COUNT = 500;
    public static final int SYNC_RESULT_CANCELLED = 1;
    public static final int SYNC_RESULT_ERROR = 2;
    public static final int SYNC_RESULT_SUCCESS = 0;
    private static final String TAG = "MediaSet";
    private WeakHashMap<ContentListener, Object> mListeners = new WeakHashMap();

    public interface SyncListener {
        void onSyncDone(MediaSet mediaSet, int i);
    }

    static class C05311 implements Future<Integer> {
        C05311() {
        }

        public void cancel() {
        }

        public Integer get() {
            return Integer.valueOf(0);
        }

        public boolean isCancelled() {
            return false;
        }

        public boolean isDone() {
            return true;
        }

        public void waitDone() {
        }
    }

    public interface ItemConsumer {
        void consume(int i, MediaItem mediaItem);
    }

    private class MultiSetSyncFuture implements SyncListener, Future<Integer> {
        private static final String TAG = "Gallery.MultiSetSync";
        private final Future<Integer>[] mFutures;
        private boolean mIsCancelled = false;
        private final SyncListener mListener;
        private int mPendingCount;
        private int mResult = -1;
        final /* synthetic */ MediaSet this$0;

        MultiSetSyncFuture(MediaSet mediaSet, MediaSet[] mediaSetArr, SyncListener syncListener) {
            int i = 0;
            this.this$0 = mediaSet;
            this.mListener = syncListener;
            this.mPendingCount = mediaSetArr.length;
            this.mFutures = new Future[mediaSetArr.length];
            synchronized (this) {
                int length = mediaSetArr.length;
                while (i < length) {
                    this.mFutures[i] = mediaSetArr[i].requestSync(this);
                    Log.m440d(TAG, "  request sync: " + Utils.maskDebugInfo(mediaSetArr[i].getName()));
                    i++;
                }
            }
        }

        public synchronized void cancel() {
            if (!this.mIsCancelled) {
                this.mIsCancelled = true;
                for (Future cancel : this.mFutures) {
                    cancel.cancel();
                }
                if (this.mResult < 0) {
                    this.mResult = 1;
                }
            }
        }

        public synchronized Integer get() {
            waitDone();
            return Integer.valueOf(this.mResult);
        }

        public synchronized boolean isCancelled() {
            return this.mIsCancelled;
        }

        public synchronized boolean isDone() {
            return this.mPendingCount == 0;
        }

        public void onSyncDone(MediaSet mediaSet, int i) {
            SyncListener syncListener = null;
            synchronized (this) {
                if (i == 2) {
                    this.mResult = 2;
                }
                this.mPendingCount--;
                if (this.mPendingCount == 0) {
                    syncListener = this.mListener;
                    notifyAll();
                }
                Log.m440d(TAG, "onSyncDone: " + Utils.maskDebugInfo(mediaSet.getName()) + " #pending=" + this.mPendingCount);
            }
            if (syncListener != null) {
                syncListener.onSyncDone(this.this$0, this.mResult);
            }
        }

        public synchronized void waitDone() {
            while (!isDone()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Log.m440d(TAG, "waitDone() interrupted");
                }
            }
            return;
        }
    }

    public MediaSet(Path path, long j) {
        super(path, j);
    }

    public void addContentListener(ContentListener contentListener) {
        if (this.mListeners.containsKey(contentListener)) {
            throw new IllegalArgumentException();
        }
        this.mListeners.put(contentListener, null);
    }

    protected int enumerateMediaItems(ItemConsumer itemConsumer, int i) {
        int mediaItemCount = getMediaItemCount();
        int i2 = 0;
        while (i2 < mediaItemCount) {
            int min = Math.min(MEDIAITEM_BATCH_FETCH_COUNT, mediaItemCount - i2);
            ArrayList mediaItem = getMediaItem(i2, min);
            int size = mediaItem.size();
            for (int i3 = 0; i3 < size; i3++) {
                itemConsumer.consume((i + i2) + i3, (MediaItem) mediaItem.get(i3));
            }
            i2 += min;
        }
        return mediaItemCount;
    }

    public void enumerateMediaItems(ItemConsumer itemConsumer) {
        enumerateMediaItems(itemConsumer, 0);
    }

    protected int enumerateTotalMediaItems(ItemConsumer itemConsumer, int i) {
        int i2 = 0;
        int enumerateMediaItems = enumerateMediaItems(itemConsumer, i) + 0;
        while (i2 < getSubMediaSetCount()) {
            enumerateMediaItems += getSubMediaSet(i2).enumerateTotalMediaItems(itemConsumer, i + enumerateMediaItems);
            i2++;
        }
        return enumerateMediaItems;
    }

    public void enumerateTotalMediaItems(ItemConsumer itemConsumer) {
        enumerateTotalMediaItems(itemConsumer, 0);
    }

    public MediaItem getCoverMediaItem() {
        ArrayList mediaItem = getMediaItem(0, 1);
        if (mediaItem.size() > 0) {
            return (MediaItem) mediaItem.get(0);
        }
        int subMediaSetCount = getSubMediaSetCount();
        for (int i = 0; i < subMediaSetCount; i++) {
            MediaItem coverMediaItem = getSubMediaSet(i).getCoverMediaItem();
            if (coverMediaItem != null) {
                return coverMediaItem;
            }
        }
        return null;
    }

    public MediaDetails getDetails() {
        MediaDetails details = super.getDetails();
        details.addDetail(1, getName());
        return details;
    }

    protected int getIndexOf(Path path, ArrayList<MediaItem> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            MediaObject mediaObject = (MediaObject) arrayList.get(i);
            if (mediaObject != null && mediaObject.mPath == path) {
                return i;
            }
        }
        return -1;
    }

    public int getIndexOfItem(Path path, int i) {
        int i2 = 0;
        int max = Math.max(0, i - 250);
        int indexOf = getIndexOf(path, getMediaItem(max, MEDIAITEM_BATCH_FETCH_COUNT));
        if (indexOf != -1) {
            return max + indexOf;
        }
        if (max == 0) {
            i2 = MEDIAITEM_BATCH_FETCH_COUNT;
        }
        max = i2;
        ArrayList mediaItem = getMediaItem(i2, MEDIAITEM_BATCH_FETCH_COUNT);
        while (true) {
            indexOf = getIndexOf(path, mediaItem);
            if (indexOf != -1) {
                return max + indexOf;
            }
            if (mediaItem.size() < MEDIAITEM_BATCH_FETCH_COUNT) {
                return -1;
            }
            max += MEDIAITEM_BATCH_FETCH_COUNT;
            mediaItem = getMediaItem(max, MEDIAITEM_BATCH_FETCH_COUNT);
        }
    }

    public ArrayList<MediaItem> getMediaItem(int i, int i2) {
        return new ArrayList();
    }

    public int getMediaItemCount() {
        return 0;
    }

    public abstract String getName();

    public MediaSet getSubMediaSet(int i) {
        throw new IndexOutOfBoundsException();
    }

    public int getSubMediaSetCount() {
        return 0;
    }

    public int getTotalMediaItemCount() {
        int mediaItemCount = getMediaItemCount();
        for (int i = 0; i < getSubMediaSetCount(); i++) {
            mediaItemCount += getSubMediaSet(i).getTotalMediaItemCount();
        }
        return mediaItemCount;
    }

    public boolean isCameraRoll() {
        return false;
    }

    public boolean isLeafAlbum() {
        return false;
    }

    public boolean isLoading() {
        return false;
    }

    public void notifyContentChanged() {
        for (ContentListener onContentDirty : this.mListeners.keySet()) {
            onContentDirty.onContentDirty();
        }
    }

    public abstract long reload();

    public void removeContentListener(ContentListener contentListener) {
        if (this.mListeners.containsKey(contentListener)) {
            this.mListeners.remove(contentListener);
            return;
        }
        throw new IllegalArgumentException();
    }

    public Future<Integer> requestSync(SyncListener syncListener) {
        syncListener.onSyncDone(this, 0);
        return FUTURE_STUB;
    }

    protected Future<Integer> requestSyncOnMultipleSets(MediaSet[] mediaSetArr, SyncListener syncListener) {
        return new MultiSetSyncFuture(this, mediaSetArr, syncListener);
    }

    public void setDataDirtyNow() {
    }
}
