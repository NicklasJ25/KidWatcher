package com.android.gallery3d.app;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import com.android.gallery3d.data.DataManager;
import com.android.gallery3d.util.ThreadPool;
import com.domobile.frame.C1263b;

public interface GalleryContext {
    Context getAndroidContext();

    DataManager getDataManager();

    C1263b getDoMoActionBar();

    Looper getMainLooper();

    Resources getResources();

    ThreadPool getThreadPool();

    void hideLoadingDialog();

    void hideLoadingDialog_mt();

    void showCancelableLoadingDialog();
}
