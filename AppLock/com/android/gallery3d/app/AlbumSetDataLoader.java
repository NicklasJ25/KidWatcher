package com.android.gallery3d.app;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.data.ContentListener;
import com.android.gallery3d.data.MediaItem;
import com.android.gallery3d.data.MediaSet;
import com.android.gallery3d.data.Path;
import com.android.gallery3d.ui.SynchronizedHandler;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class AlbumSetDataLoader {
    private static final int INDEX_NONE = -1;
    private static final int MIN_LOAD_COUNT = 4;
    private static final int MSG_LOAD_FINISH = 2;
    private static final int MSG_LOAD_START = 1;
    private static final int MSG_RUN_OBJECT = 3;
    private static final String TAG = "AlbumSetDataAdapter";
    private int mActiveEnd = 0;
    private int mActiveStart = 0;
    private int mContentEnd = 0;
    private int mContentStart = 0;
    private final MediaItem[] mCoverItem;
    private final MediaSet[] mData;
    private DataListener mDataListener;
    private final long[] mItemVersion;
    private LoadingListener mLoadingListener;
    private final Handler mMainHandler;
    private ReloadTask mReloadTask;
    private final long[] mSetVersion;
    private int mSize;
    private final MediaSet mSource;
    private final MySourceListener mSourceListener = new MySourceListener();
    private long mSourceVersion = -1;
    private final int[] mTotalCount;

    public interface DataListener {
        void onContentChanged(int i);

        void onSizeChanged(int i);
    }

    private class GetUpdateInfo implements Callable<UpdateInfo> {
        private final long mVersion;

        public GetUpdateInfo(long j) {
            this.mVersion = j;
        }

        private int getInvalidIndex(long j) {
            long[] access$400 = AlbumSetDataLoader.this.mSetVersion;
            int length = access$400.length;
            int access$600 = AlbumSetDataLoader.this.mContentEnd;
            for (int access$500 = AlbumSetDataLoader.this.mContentStart; access$500 < access$600; access$500++) {
                int i = access$500 % length;
                if (access$400[access$500 % length] != j) {
                    return access$500;
                }
            }
            return -1;
        }

        public UpdateInfo call() {
            int invalidIndex = getInvalidIndex(this.mVersion);
            if (invalidIndex == -1 && AlbumSetDataLoader.this.mSourceVersion == this.mVersion) {
                return null;
            }
            UpdateInfo updateInfo = new UpdateInfo();
            updateInfo.version = AlbumSetDataLoader.this.mSourceVersion;
            updateInfo.index = invalidIndex;
            updateInfo.size = AlbumSetDataLoader.this.mSize;
            return updateInfo;
        }
    }

    private class MySourceListener implements ContentListener {
        private MySourceListener() {
        }

        public void onContentDirty() {
            AlbumSetDataLoader.this.mReloadTask.notifyDirty();
        }
    }

    private class ReloadTask extends Thread {
        private volatile boolean mActive;
        private volatile boolean mDirty;
        private volatile boolean mIsLoading;

        private ReloadTask() {
            this.mActive = true;
            this.mDirty = true;
            this.mIsLoading = false;
        }

        private void updateLoading(boolean z) {
            if (this.mIsLoading != z) {
                this.mIsLoading = z;
                AlbumSetDataLoader.this.mMainHandler.sendEmptyMessage(z ? 1 : 2);
            }
        }

        public synchronized void notifyDirty() {
            this.mDirty = true;
            notifyAll();
        }

        public void run() {
            Process.setThreadPriority(10);
            boolean z = false;
            while (this.mActive) {
                synchronized (this) {
                    if (this.mActive && !this.mDirty && r0) {
                        if (!AlbumSetDataLoader.this.mSource.isLoading()) {
                            updateLoading(false);
                        }
                        Utils.waitWithoutInterrupt(this);
                    } else {
                        this.mDirty = false;
                        updateLoading(true);
                        long reload = AlbumSetDataLoader.this.mSource.reload();
                        UpdateInfo updateInfo = (UpdateInfo) AlbumSetDataLoader.this.executeAndWait(new GetUpdateInfo(reload));
                        boolean z2 = updateInfo == null;
                        if (z2) {
                            z = z2;
                        } else {
                            if (updateInfo.version != reload) {
                                updateInfo.version = reload;
                                updateInfo.size = AlbumSetDataLoader.this.mSource.getSubMediaSetCount();
                                if (updateInfo.index >= updateInfo.size) {
                                    updateInfo.index = -1;
                                }
                            }
                            if (updateInfo.index != -1) {
                                updateInfo.item = AlbumSetDataLoader.this.mSource.getSubMediaSet(updateInfo.index);
                                if (updateInfo.item == null) {
                                    z = z2;
                                } else {
                                    updateInfo.cover = updateInfo.item.getCoverMediaItem();
                                    updateInfo.totalCount = updateInfo.item.getTotalMediaItemCount();
                                }
                            }
                            AlbumSetDataLoader.this.executeAndWait(new UpdateContent(updateInfo));
                            z = z2;
                        }
                    }
                }
            }
            updateLoading(false);
        }

        public synchronized void terminate() {
            this.mActive = false;
            notifyAll();
        }
    }

    private class UpdateContent implements Callable<Void> {
        private final UpdateInfo mUpdateInfo;

        public UpdateContent(UpdateInfo updateInfo) {
            this.mUpdateInfo = updateInfo;
        }

        public Void call() {
            if (AlbumSetDataLoader.this.mReloadTask != null) {
                UpdateInfo updateInfo = this.mUpdateInfo;
                AlbumSetDataLoader.this.mSourceVersion = updateInfo.version;
                if (AlbumSetDataLoader.this.mSize != updateInfo.size) {
                    AlbumSetDataLoader.this.mSize = updateInfo.size;
                    if (AlbumSetDataLoader.this.mDataListener != null) {
                        AlbumSetDataLoader.this.mDataListener.onSizeChanged(AlbumSetDataLoader.this.mSize);
                    }
                    if (AlbumSetDataLoader.this.mContentEnd > AlbumSetDataLoader.this.mSize) {
                        AlbumSetDataLoader.this.mContentEnd = AlbumSetDataLoader.this.mSize;
                    }
                    if (AlbumSetDataLoader.this.mActiveEnd > AlbumSetDataLoader.this.mSize) {
                        AlbumSetDataLoader.this.mActiveEnd = AlbumSetDataLoader.this.mSize;
                    }
                }
                if (updateInfo.index >= AlbumSetDataLoader.this.mContentStart && updateInfo.index < AlbumSetDataLoader.this.mContentEnd) {
                    int length = updateInfo.index % AlbumSetDataLoader.this.mCoverItem.length;
                    AlbumSetDataLoader.this.mSetVersion[length] = updateInfo.version;
                    long dataVersion = updateInfo.item.getDataVersion();
                    if (AlbumSetDataLoader.this.mItemVersion[length] != dataVersion) {
                        AlbumSetDataLoader.this.mItemVersion[length] = dataVersion;
                        AlbumSetDataLoader.this.mData[length] = updateInfo.item;
                        AlbumSetDataLoader.this.mCoverItem[length] = updateInfo.cover;
                        AlbumSetDataLoader.this.mTotalCount[length] = updateInfo.totalCount;
                        if (AlbumSetDataLoader.this.mDataListener != null && updateInfo.index >= AlbumSetDataLoader.this.mActiveStart && updateInfo.index < AlbumSetDataLoader.this.mActiveEnd) {
                            AlbumSetDataLoader.this.mDataListener.onContentChanged(updateInfo.index);
                        }
                    }
                }
            }
            return null;
        }
    }

    private static class UpdateInfo {
        public MediaItem cover;
        public int index;
        public MediaSet item;
        public int size;
        public int totalCount;
        public long version;

        private UpdateInfo() {
        }
    }

    public AlbumSetDataLoader(AbstractGalleryActivity abstractGalleryActivity, MediaSet mediaSet, int i) {
        this.mSource = (MediaSet) Utils.checkNotNull(mediaSet);
        this.mCoverItem = new MediaItem[i];
        this.mData = new MediaSet[i];
        this.mTotalCount = new int[i];
        this.mItemVersion = new long[i];
        this.mSetVersion = new long[i];
        Arrays.fill(this.mItemVersion, -1);
        Arrays.fill(this.mSetVersion, -1);
        this.mMainHandler = new SynchronizedHandler(abstractGalleryActivity.getGLRoot()) {
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (AlbumSetDataLoader.this.mLoadingListener != null) {
                            AlbumSetDataLoader.this.mLoadingListener.onLoadingStarted();
                            return;
                        }
                        return;
                    case 2:
                        if (AlbumSetDataLoader.this.mLoadingListener != null) {
                            AlbumSetDataLoader.this.mLoadingListener.onLoadingFinished(false);
                            return;
                        }
                        return;
                    case 3:
                        ((Runnable) message.obj).run();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private void assertIsActive(int i) {
        if (i < this.mActiveStart && i >= this.mActiveEnd) {
            throw new IllegalArgumentException(String.format("%s not in (%s, %s)", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mActiveStart), Integer.valueOf(this.mActiveEnd)}));
        }
    }

    private void clearSlot(int i) {
        this.mData[i] = null;
        this.mCoverItem[i] = null;
        this.mTotalCount[i] = 0;
        this.mItemVersion[i] = -1;
        this.mSetVersion[i] = -1;
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

    private void setContentWindow(int i, int i2) {
        if (i != this.mContentStart || i2 != this.mContentEnd) {
            int length = this.mCoverItem.length;
            int i3 = this.mContentStart;
            int i4 = this.mContentEnd;
            this.mContentStart = i;
            this.mContentEnd = i2;
            if (i >= i4 || i3 >= i2) {
                while (i3 < i4) {
                    clearSlot(i3 % length);
                    i3++;
                }
            } else {
                while (i3 < i) {
                    clearSlot(i3 % length);
                    i3++;
                }
                while (i2 < i4) {
                    clearSlot(i2 % length);
                    i2++;
                }
            }
            this.mReloadTask.notifyDirty();
        }
    }

    public int findSet(Path path) {
        int length = this.mData.length;
        for (int i = this.mContentStart; i < this.mContentEnd; i++) {
            MediaSet mediaSet = this.mData[i % length];
            if (mediaSet != null && path == mediaSet.getPath()) {
                return i;
            }
        }
        return -1;
    }

    public int getActiveStart() {
        return this.mActiveStart;
    }

    public MediaItem getCoverItem(int i) {
        assertIsActive(i);
        return this.mCoverItem[i % this.mCoverItem.length];
    }

    public MediaSet getMediaSet(int i) {
        assertIsActive(i);
        return this.mData[i % this.mData.length];
    }

    public int getTotalCount(int i) {
        assertIsActive(i);
        return this.mTotalCount[i % this.mTotalCount.length];
    }

    public boolean isActive(int i) {
        return i >= this.mActiveStart && i < this.mActiveEnd;
    }

    public void pause() {
        this.mReloadTask.terminate();
        this.mReloadTask = null;
        this.mSource.removeContentListener(this.mSourceListener);
    }

    public void resume() {
        this.mSource.addContentListener(this.mSourceListener);
        this.mReloadTask = new ReloadTask();
        this.mReloadTask.start();
    }

    public void setActiveWindow(int i, int i2) {
        if (i != this.mActiveStart || i2 != this.mActiveEnd) {
            boolean z = i <= i2 && i2 - i <= this.mCoverItem.length && i2 <= this.mSize;
            Utils.assertTrue(z);
            this.mActiveStart = i;
            this.mActiveEnd = i2;
            int length = this.mCoverItem.length;
            if (i != i2) {
                int clamp = Utils.clamp(((i + i2) / 2) - (length / 2), 0, Math.max(0, this.mSize - length));
                length = Math.min(length + clamp, this.mSize);
                if (this.mContentStart > i || this.mContentEnd < i2 || Math.abs(clamp - this.mContentStart) > 4) {
                    setContentWindow(clamp, length);
                }
            }
        }
    }

    public void setLoadingListener(LoadingListener loadingListener) {
        this.mLoadingListener = loadingListener;
    }

    public void setModelListener(DataListener dataListener) {
        this.mDataListener = dataListener;
    }

    public int size() {
        return this.mSize;
    }
}
