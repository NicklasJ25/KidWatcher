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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class AlbumDataLoader {
    private static final int DATA_CACHE_SIZE = 1000;
    private static final int MAX_LOAD_COUNT = 64;
    private static final int MIN_LOAD_COUNT = 32;
    private static final int MSG_LOAD_FINISH = 2;
    private static final int MSG_LOAD_START = 1;
    private static final int MSG_RUN_OBJECT = 3;
    private static final String TAG = "AlbumDataAdapter";
    private int mActiveEnd = 0;
    private int mActiveStart = 0;
    private int mContentEnd = 0;
    private int mContentStart = 0;
    private final MediaItem[] mData;
    private DataListener mDataListener;
    private long mFailedVersion = -1;
    private final long[] mItemVersion;
    private LoadingListener mLoadingListener;
    private final Handler mMainHandler;
    private ReloadTask mReloadTask;
    private final long[] mSetVersion;
    private int mSize = 0;
    private final MediaSet mSource;
    private MySourceListener mSourceListener = new MySourceListener();
    private long mSourceVersion = -1;

    public interface DataListener {
        void onContentChanged(int i);

        void onSizeChanged(int i);
    }

    private class GetUpdateInfo implements Callable<UpdateInfo> {
        private final long mVersion;

        public GetUpdateInfo(long j) {
            this.mVersion = j;
        }

        public UpdateInfo call() {
            if (AlbumDataLoader.this.mFailedVersion == this.mVersion) {
                return null;
            }
            UpdateInfo updateInfo = new UpdateInfo();
            long j = this.mVersion;
            updateInfo.version = AlbumDataLoader.this.mSourceVersion;
            updateInfo.size = AlbumDataLoader.this.mSize;
            long[] access$800 = AlbumDataLoader.this.mSetVersion;
            int access$1000 = AlbumDataLoader.this.mContentEnd;
            for (int access$900 = AlbumDataLoader.this.mContentStart; access$900 < access$1000; access$900++) {
                if (access$800[access$900 % 1000] != j) {
                    updateInfo.reloadStart = access$900;
                    updateInfo.reloadCount = Math.min(64, access$1000 - access$900);
                    return updateInfo;
                }
            }
            return AlbumDataLoader.this.mSourceVersion != this.mVersion ? updateInfo : null;
        }
    }

    private class MySourceListener implements ContentListener {
        private MySourceListener() {
        }

        public void onContentDirty() {
            if (AlbumDataLoader.this.mReloadTask != null) {
                AlbumDataLoader.this.mReloadTask.notifyDirty();
            }
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

        private void updateLoading(boolean z) {
            if (this.mIsLoading != z) {
                this.mIsLoading = z;
                AlbumDataLoader.this.mMainHandler.sendEmptyMessage(z ? 1 : 2);
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
                        updateLoading(false);
                        if (AlbumDataLoader.this.mFailedVersion != -1) {
                            Log.m429d(AlbumDataLoader.TAG, "reload pause");
                        }
                        Utils.waitWithoutInterrupt(this);
                        if (this.mActive && AlbumDataLoader.this.mFailedVersion != -1) {
                            Log.m429d(AlbumDataLoader.TAG, "reload resume");
                        }
                    } else {
                        this.mDirty = false;
                        updateLoading(true);
                        long reload = AlbumDataLoader.this.mSource.reload();
                        UpdateInfo updateInfo = (UpdateInfo) AlbumDataLoader.this.executeAndWait(new GetUpdateInfo(reload));
                        boolean z2 = updateInfo == null;
                        if (z2) {
                            z = z2;
                        } else {
                            if (updateInfo.version != reload) {
                                updateInfo.size = AlbumDataLoader.this.mSource.getMediaItemCount();
                                updateInfo.version = reload;
                            }
                            if (updateInfo.reloadCount > 0) {
                                updateInfo.items = AlbumDataLoader.this.mSource.getMediaItem(updateInfo.reloadStart, updateInfo.reloadCount);
                            }
                            AlbumDataLoader.this.executeAndWait(new UpdateContent(updateInfo));
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
        private UpdateInfo mUpdateInfo;

        public UpdateContent(UpdateInfo updateInfo) {
            this.mUpdateInfo = updateInfo;
        }

        public Void call() {
            UpdateInfo updateInfo = this.mUpdateInfo;
            AlbumDataLoader.this.mSourceVersion = updateInfo.version;
            if (AlbumDataLoader.this.mSize != updateInfo.size) {
                AlbumDataLoader.this.mSize = updateInfo.size;
                if (AlbumDataLoader.this.mDataListener != null) {
                    AlbumDataLoader.this.mDataListener.onSizeChanged(AlbumDataLoader.this.mSize);
                }
                if (AlbumDataLoader.this.mContentEnd > AlbumDataLoader.this.mSize) {
                    AlbumDataLoader.this.mContentEnd = AlbumDataLoader.this.mSize;
                }
                if (AlbumDataLoader.this.mActiveEnd > AlbumDataLoader.this.mSize) {
                    AlbumDataLoader.this.mActiveEnd = AlbumDataLoader.this.mSize;
                }
            }
            ArrayList arrayList = updateInfo.items;
            AlbumDataLoader.this.mFailedVersion = -1;
            if (arrayList != null && !arrayList.isEmpty()) {
                int max = Math.max(updateInfo.reloadStart, AlbumDataLoader.this.mContentStart);
                int min = Math.min(updateInfo.reloadStart + arrayList.size(), AlbumDataLoader.this.mContentEnd);
                int i = max;
                while (i < min) {
                    int i2 = i % 1000;
                    AlbumDataLoader.this.mSetVersion[i2] = updateInfo.version;
                    MediaItem mediaItem = (MediaItem) arrayList.get(i - updateInfo.reloadStart);
                    long dataVersion = mediaItem.getDataVersion();
                    if (AlbumDataLoader.this.mItemVersion[i2] != dataVersion) {
                        AlbumDataLoader.this.mItemVersion[i2] = dataVersion;
                        AlbumDataLoader.this.mData[i2] = mediaItem;
                        if (AlbumDataLoader.this.mDataListener != null && i >= AlbumDataLoader.this.mActiveStart && i < AlbumDataLoader.this.mActiveEnd) {
                            AlbumDataLoader.this.mDataListener.onContentChanged(i);
                        }
                    }
                    i++;
                }
            } else if (updateInfo.reloadCount > 0) {
                AlbumDataLoader.this.mFailedVersion = updateInfo.version;
                Log.m429d(AlbumDataLoader.TAG, "loading failed: " + AlbumDataLoader.this.mFailedVersion);
            }
            return null;
        }
    }

    private static class UpdateInfo {
        public ArrayList<MediaItem> items;
        public int reloadCount;
        public int reloadStart;
        public int size;
        public long version;

        private UpdateInfo() {
        }
    }

    public AlbumDataLoader(AbstractGalleryActivity abstractGalleryActivity, MediaSet mediaSet) {
        this.mSource = mediaSet;
        this.mData = new MediaItem[1000];
        this.mItemVersion = new long[1000];
        this.mSetVersion = new long[1000];
        Arrays.fill(this.mItemVersion, -1);
        Arrays.fill(this.mSetVersion, -1);
        this.mMainHandler = new SynchronizedHandler(abstractGalleryActivity.getGLRoot()) {
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (AlbumDataLoader.this.mLoadingListener != null) {
                            AlbumDataLoader.this.mLoadingListener.onLoadingStarted();
                            return;
                        }
                        return;
                    case 2:
                        if (AlbumDataLoader.this.mLoadingListener != null) {
                            AlbumDataLoader.this.mLoadingListener.onLoadingFinished(AlbumDataLoader.this.mFailedVersion != -1);
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

    private void clearSlot(int i) {
        this.mData[i] = null;
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
            int i3 = this.mContentEnd;
            int i4 = this.mContentStart;
            synchronized (this) {
                this.mContentStart = i;
                this.mContentEnd = i2;
            }
            long[] jArr = this.mItemVersion;
            jArr = this.mSetVersion;
            if (i >= i3 || i4 >= i2) {
                while (i4 < i3) {
                    clearSlot(i4 % 1000);
                    i4++;
                }
            } else {
                while (i4 < i) {
                    clearSlot(i4 % 1000);
                    i4++;
                }
                while (i2 < i3) {
                    clearSlot(i2 % 1000);
                    i2++;
                }
            }
            if (this.mReloadTask != null) {
                this.mReloadTask.notifyDirty();
            }
        }
    }

    public int findItem(Path path) {
        for (int i = this.mContentStart; i < this.mContentEnd; i++) {
            MediaItem mediaItem = this.mData[i % 1000];
            if (mediaItem != null && path == mediaItem.getPath()) {
                return i;
            }
        }
        return -1;
    }

    public MediaItem get(int i) {
        if (isActive(i)) {
            return this.mData[i % this.mData.length];
        }
        throw new IllegalArgumentException(String.format("%s not in (%s, %s)", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mActiveStart), Integer.valueOf(this.mActiveEnd)}));
    }

    public int getActiveStart() {
        return this.mActiveStart;
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
            boolean z = i <= i2 && i2 - i <= this.mData.length && i2 <= this.mSize;
            Utils.assertTrue(z);
            int length = this.mData.length;
            this.mActiveStart = i;
            this.mActiveEnd = i2;
            if (i != i2) {
                int clamp = Utils.clamp(((i + i2) / 2) - (length / 2), 0, Math.max(0, this.mSize - length));
                length = Math.min(length + clamp, this.mSize);
                if (this.mContentStart > i || this.mContentEnd < i2 || Math.abs(clamp - this.mContentStart) > 32) {
                    setContentWindow(clamp, length);
                }
            }
        }
    }

    public void setDataListener(DataListener dataListener) {
        this.mDataListener = dataListener;
    }

    public void setLoadingListener(LoadingListener loadingListener) {
        this.mLoadingListener = loadingListener;
    }

    public int size() {
        return this.mSize;
    }
}
