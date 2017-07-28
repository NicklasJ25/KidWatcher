package com.android.gallery3d.app;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.android.gallery3d.C0488R;
import com.android.gallery3d.common.ApiHelper;
import com.android.gallery3d.data.BitmapPool;
import com.android.gallery3d.data.DataManager;
import com.android.gallery3d.data.MediaItem;
import com.android.gallery3d.ui.GLRoot;
import com.android.gallery3d.ui.GLRootView;
import com.android.gallery3d.util.ThreadPool;
import com.domobile.frame.C1263b;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1288c;

public class AbstractGalleryActivity extends ActionBarActivity implements GalleryContext {
    private static final String TAG = "AbstractGalleryActivity";
    public C1263b mActionBar;
    private C1288c mDialog;
    private boolean mDisableToggleStatusBar;
    private GLRootView mGLRootView;
    private Handler mHandler = new Handler();
    private OrientationManager mOrientationManager;
    private StateManager mStateManager;
    public Toolbar mToolbar;
    private TransitionStore mTransitionStore = new TransitionStore();
    private boolean showBackButton;

    class C04901 implements Runnable {
        C04901() {
        }

        public void run() {
            try {
                AbstractGalleryActivity.this.mDialog = C1148d.m2505a(AbstractGalleryActivity.this, null, null);
                AbstractGalleryActivity.this.mDialog.m3117b(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class C04912 implements Runnable {
        C04912() {
        }

        public void run() {
            AbstractGalleryActivity.this.hideLoadingDialog_mt();
        }
    }

    private static void clearBitmapPool(BitmapPool bitmapPool) {
        if (bitmapPool != null) {
            bitmapPool.clear();
        }
    }

    private void toggleStatusBarByOrientation() {
        if (!this.mDisableToggleStatusBar) {
            Window window = getWindow();
            if (getResources().getConfiguration().orientation == 1) {
                window.clearFlags(1024);
            } else {
                window.addFlags(1024);
            }
        }
    }

    protected void disableToggleStatusBar() {
        this.mDisableToggleStatusBar = true;
    }

    public Context getAndroidContext() {
        return this;
    }

    public DataManager getDataManager() {
        return ((GalleryApp) getApplication()).getDataManager();
    }

    public C1263b getDoMoActionBar() {
        return this.mActionBar;
    }

    public GLRoot getGLRoot() {
        return this.mGLRootView;
    }

    public OrientationManager getOrientationManager() {
        return this.mOrientationManager;
    }

    public synchronized StateManager getStateManager() {
        if (this.mStateManager == null) {
            this.mStateManager = new StateManager(this);
        }
        return this.mStateManager;
    }

    public ThreadPool getThreadPool() {
        return ((GalleryApp) getApplication()).getThreadPool();
    }

    public Toolbar getToolbar() {
        return this.mToolbar;
    }

    public TransitionStore getTransitionStore() {
        return this.mTransitionStore;
    }

    public void hideLoadingDialog() {
        this.mHandler.post(new C04912());
    }

    public void hideLoadingDialog_mt() {
        C1148d.m2517a(this.mDialog);
    }

    public void initActionToolBar() {
        this.mToolbar = (Toolbar) findViewById(C0488R.id.action_toolbar);
        if (this.mToolbar != null) {
            setSupportActionBar(this.mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }

    protected boolean isFullscreen() {
        return (getWindow().getAttributes().flags & 1024) != 0;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.mGLRootView.lockRenderThread();
        try {
            getStateManager().notifyActivityResult(i, i2, intent);
        } finally {
            this.mGLRootView.unlockRenderThread();
        }
    }

    public void onBackPressed() {
        GLRoot gLRoot = getGLRoot();
        gLRoot.lockRenderThread();
        try {
            getStateManager().onBackPressed();
        } finally {
            gLRoot.unlockRenderThread();
        }
    }

    @TargetApi(11)
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mStateManager.onConfigurationChange(configuration);
        if (ApiHelper.HAS_INVALIDATE_OPTIONS_MENU) {
            invalidateOptionsMenu();
        }
        toggleStatusBarByOrientation();
    }

    protected void onCreate(Bundle bundle) {
        getWindow().requestFeature(9);
        super.onCreate(bundle);
        this.mOrientationManager = new OrientationManager(this);
        toggleStatusBarByOrientation();
        getWindow().setBackgroundDrawable(null);
        super.setContentView(C0488R.layout.abstract_gallery_pager);
        initActionToolBar();
        if (this.mActionBar == null) {
            this.mActionBar = new C1263b(this, false, true, false);
            this.showBackButton = getIntent().getBooleanExtra("EXTRA_SHOW_BACK", true);
            this.mActionBar.m3010d(this.showBackButton);
            this.mActionBar.m3002a(true);
            this.mActionBar.m3006b(false);
            ((ViewGroup) findViewById(C0488R.id.acstract_gallery_pager_content)).addView(this.mActionBar.m3004b());
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mGLRootView.lockRenderThread();
        try {
            getStateManager().destroy();
        } finally {
            this.mGLRootView.unlockRenderThread();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean z = true;
        C1147a.m2482b(getClass().getName(), " options item selected.");
        if (menuItem.getItemId() == 16908332) {
            finish();
        } else {
            GLRoot gLRoot = getGLRoot();
            gLRoot.lockRenderThread();
            try {
                z = getStateManager().itemSelected(menuItem);
            } finally {
                gLRoot.unlockRenderThread();
            }
        }
        return z;
    }

    protected void onPause() {
        super.onPause();
        hideLoadingDialog_mt();
        this.mOrientationManager.pause();
        this.mGLRootView.onPause();
        this.mGLRootView.lockRenderThread();
        try {
            getStateManager().pause();
            getDataManager().pause();
            clearBitmapPool(MediaItem.getMicroThumbPool());
            clearBitmapPool(MediaItem.getThumbPool());
            MediaItem.getBytesBufferPool().clear();
        } finally {
            this.mGLRootView.unlockRenderThread();
        }
    }

    protected void onResume() {
        super.onResume();
        this.mGLRootView.lockRenderThread();
        try {
            getStateManager().resume();
            getDataManager().resume();
            this.mGLRootView.onResume();
            this.mOrientationManager.resume();
        } finally {
            this.mGLRootView.unlockRenderThread();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.mGLRootView.lockRenderThread();
        try {
            super.onSaveInstanceState(bundle);
            getStateManager().saveState(bundle);
        } finally {
            this.mGLRootView.unlockRenderThread();
        }
    }

    public void setContentView(int i) {
        View inflate = LayoutInflater.from(this).inflate(i, null);
        this.mGLRootView = (GLRootView) inflate.findViewById(C0488R.id.gl_root_view);
        this.mActionBar.m3014g().addView(inflate);
    }

    public void showCancelableLoadingDialog() {
        this.mHandler.post(new C04901());
    }
}
