package com.android.gallery3d.ui;

import android.content.Context;
import android.os.StatFs;
import com.android.gallery3d.app.AbstractGalleryActivity;
import com.android.gallery3d.util.ThreadPool.JobContext;
import java.io.File;

public class CacheStorageUsageInfo {
    private static final String TAG = "CacheStorageUsageInfo";
    private AbstractGalleryActivity mActivity;
    private Context mContext;
    private long mTargetCacheBytes;
    private long mTotalBytes;
    private long mUsedBytes;
    private long mUsedCacheBytes;
    private long mUserChangeDelta;

    public CacheStorageUsageInfo(AbstractGalleryActivity abstractGalleryActivity) {
        this.mActivity = abstractGalleryActivity;
        this.mContext = abstractGalleryActivity.getAndroidContext();
    }

    public long getExpectedUsedBytes() {
        return ((this.mUsedBytes - this.mUsedCacheBytes) + this.mTargetCacheBytes) + this.mUserChangeDelta;
    }

    public long getFreeBytes() {
        return this.mTotalBytes - this.mUsedBytes;
    }

    public long getTotalBytes() {
        return this.mTotalBytes;
    }

    public long getUsedBytes() {
        return this.mUsedBytes;
    }

    public void increaseTargetCacheSize(long j) {
        this.mUserChangeDelta += j;
    }

    public void loadStorageInfo(JobContext jobContext) {
        File externalCacheDir = this.mContext.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = this.mContext.getCacheDir();
        }
        StatFs statFs = new StatFs(externalCacheDir.getAbsolutePath());
        long blockSize = (long) statFs.getBlockSize();
        long availableBlocks = (long) statFs.getAvailableBlocks();
        long blockCount = (long) statFs.getBlockCount();
        this.mTotalBytes = blockSize * blockCount;
        this.mUsedBytes = (blockCount - availableBlocks) * blockSize;
        this.mUsedCacheBytes = this.mActivity.getDataManager().getTotalUsedCacheSize();
        this.mTargetCacheBytes = this.mActivity.getDataManager().getTotalTargetCacheSize();
    }
}
