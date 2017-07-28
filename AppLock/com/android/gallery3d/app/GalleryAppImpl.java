package com.android.gallery3d.app;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import com.android.gallery3d.data.DataManager;
import com.android.gallery3d.data.DownloadCache;
import com.android.gallery3d.data.ImageCacheService;
import com.android.gallery3d.util.GalleryUtils;
import com.android.gallery3d.util.ThreadPool;
import java.io.File;

public abstract class GalleryAppImpl extends Application implements GalleryApp {
    private static final long DOWNLOAD_CAPACITY = 67108864;
    private static final String DOWNLOAD_FOLDER = "download";
    private DataManager mDataManager;
    private DownloadCache mDownloadCache;
    private ImageCacheService mImageCacheService;
    private Object mLock = new Object();
    private ThreadPool mThreadPool;

    private void initializeAsyncTask() {
        try {
            Class.forName(AsyncTask.class.getName());
        } catch (ClassNotFoundException e) {
        }
    }

    public Context getAndroidContext() {
        return this;
    }

    public synchronized DataManager getDataManager() {
        if (this.mDataManager == null) {
            this.mDataManager = new DataManager(this);
            initializeSourceMap(this.mDataManager);
        }
        return this.mDataManager;
    }

    public synchronized DownloadCache getDownloadCache() {
        if (this.mDownloadCache == null) {
            File file = new File(getExternalCacheDir(), "download");
            if (!file.isDirectory()) {
                file.mkdirs();
            }
            if (file.isDirectory()) {
                this.mDownloadCache = new DownloadCache(this, file, DOWNLOAD_CAPACITY);
            } else {
                throw new RuntimeException("fail to create: " + file.getAbsolutePath());
            }
        }
        return this.mDownloadCache;
    }

    public ImageCacheService getImageCacheService() {
        ImageCacheService imageCacheService;
        synchronized (this.mLock) {
            if (this.mImageCacheService == null) {
                this.mImageCacheService = new ImageCacheService(getAndroidContext());
            }
            imageCacheService = this.mImageCacheService;
        }
        return imageCacheService;
    }

    public synchronized ThreadPool getThreadPool() {
        if (this.mThreadPool == null) {
            this.mThreadPool = new ThreadPool();
        }
        return this.mThreadPool;
    }

    public void onCreate() {
        super.onCreate();
        initializeAsyncTask();
        GalleryUtils.initialize(this);
    }
}
