package com.android.gallery3d.app;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import com.android.gallery3d.data.DataManager;
import com.android.gallery3d.data.DownloadCache;
import com.android.gallery3d.data.ImageCacheService;
import com.android.gallery3d.util.ThreadPool;

public interface GalleryApp {
    Context getAndroidContext();

    ContentResolver getContentResolver();

    DataManager getDataManager();

    DownloadCache getDownloadCache();

    ImageCacheService getImageCacheService();

    Looper getMainLooper();

    Resources getResources();

    ThreadPool getThreadPool();

    void initializeSourceMap(DataManager dataManager);
}
