package com.android.gallery3d.app;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.MenuInflater;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.android.gallery3d.C0488R;
import com.android.gallery3d.anim.StateTransitionAnimation;
import com.android.gallery3d.anim.StateTransitionAnimation.Transition;
import com.android.gallery3d.common.ApiHelper;
import com.android.gallery3d.ui.GLView;
import com.android.gallery3d.ui.PreparePageFadeoutTexture;
import com.android.gallery3d.ui.RawTexture;
import com.android.gallery3d.util.GalleryUtils;

public abstract class ActivityState {
    protected static final int FLAG_ALLOW_LOCK_WHILE_SCREEN_ON = 16;
    protected static final int FLAG_HIDE_ACTION_BAR = 1;
    protected static final int FLAG_HIDE_STATUS_BAR = 2;
    protected static final int FLAG_SCREEN_ON_ALWAYS = 8;
    protected static final int FLAG_SCREEN_ON_WHEN_PLUGGED = 4;
    protected static final int FLAG_SHOW_WHEN_LOCKED = 32;
    private static final String KEY_TRANSITION_IN = "transition-in";
    protected AbstractGalleryActivity mActivity;
    protected float[] mBackgroundColor;
    private GLView mContentPane;
    private ContentResolver mContentResolver;
    protected Bundle mData;
    private boolean mDestroyed = false;
    protected int mFlags;
    protected boolean mHapticsEnabled;
    private StateTransitionAnimation mIntroAnimation;
    boolean mIsFinishing = false;
    private Transition mNextTransition = Transition.None;
    private boolean mPlugged = false;
    BroadcastReceiver mPowerIntentReceiver = new C04921();
    protected ResultEntry mReceivedResults;
    protected ResultEntry mResult;

    class C04921 extends BroadcastReceiver {
        C04921() {
        }

        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                if (intent.getIntExtra("plugged", 0) != 0) {
                    z = true;
                }
                if (z != ActivityState.this.mPlugged) {
                    ActivityState.this.mPlugged = z;
                    ActivityState.this.setScreenFlags();
                }
            }
        }
    }

    protected static class ResultEntry {
        public int requestCode;
        public int resultCode = 0;
        public Intent resultData;

        protected ResultEntry() {
        }
    }

    protected ActivityState() {
    }

    private void setScreenFlags() {
        Window window = this.mActivity.getWindow();
        LayoutParams attributes = window.getAttributes();
        if ((this.mFlags & 8) != 0 || (this.mPlugged && (this.mFlags & 4) != 0)) {
            attributes.flags |= 128;
        } else {
            attributes.flags &= -129;
        }
        if ((this.mFlags & 16) != 0) {
            attributes.flags |= 1;
        } else {
            attributes.flags &= -2;
        }
        if ((this.mFlags & 32) != 0) {
            attributes.flags |= 524288;
        } else {
            attributes.flags &= -524289;
        }
        window.setAttributes(attributes);
    }

    protected void clearStateResult() {
    }

    protected float[] getBackgroundColor() {
        return this.mBackgroundColor;
    }

    protected int getBackgroundColorId() {
        return C0488R.color.default_background;
    }

    public Bundle getData() {
        return this.mData;
    }

    protected MenuInflater getSupportMenuInflater() {
        return this.mActivity.getMenuInflater();
    }

    void initialize(AbstractGalleryActivity abstractGalleryActivity, Bundle bundle) {
        this.mActivity = abstractGalleryActivity;
        this.mData = bundle;
        this.mContentResolver = abstractGalleryActivity.getAndroidContext().getContentResolver();
    }

    boolean isDestroyed() {
        return this.mDestroyed;
    }

    public boolean isFinishing() {
        return this.mIsFinishing;
    }

    protected void onBackPressed() {
        this.mActivity.getStateManager().finishState(this);
    }

    protected void onConfigurationChanged(Configuration configuration) {
    }

    protected void onCreate(Bundle bundle, Bundle bundle2) {
        this.mBackgroundColor = GalleryUtils.intColorToFloatARGBArray(this.mActivity.getResources().getColor(getBackgroundColorId()));
    }

    protected void onDestroy() {
        this.mDestroyed = true;
    }

    protected void onPause() {
        if ((this.mFlags & 4) != 0) {
            this.mActivity.unregisterReceiver(this.mPowerIntentReceiver);
        }
        if (this.mNextTransition != Transition.None) {
            this.mActivity.getTransitionStore().put(KEY_TRANSITION_IN, this.mNextTransition);
            PreparePageFadeoutTexture.prepareFadeOutTexture(this.mActivity, this.mContentPane);
            this.mNextTransition = Transition.None;
        }
    }

    protected void onResume() {
        RawTexture rawTexture = (RawTexture) this.mActivity.getTransitionStore().get(PreparePageFadeoutTexture.KEY_FADE_TEXTURE);
        this.mNextTransition = (Transition) this.mActivity.getTransitionStore().get(KEY_TRANSITION_IN, Transition.None);
        if (this.mNextTransition != Transition.None) {
            this.mIntroAnimation = new StateTransitionAnimation(this.mNextTransition, rawTexture);
            this.mNextTransition = Transition.None;
        }
    }

    protected void onSaveState(Bundle bundle) {
    }

    protected void onStateResult(int i, int i2, Intent intent) {
    }

    void resume() {
        AbstractGalleryActivity abstractGalleryActivity = this.mActivity;
        if (ApiHelper.HAS_INVALIDATE_OPTIONS_MENU) {
            abstractGalleryActivity.invalidateOptionsMenu();
        }
        setScreenFlags();
        ResultEntry resultEntry = this.mReceivedResults;
        if (resultEntry != null) {
            this.mReceivedResults = null;
            onStateResult(resultEntry.requestCode, resultEntry.resultCode, resultEntry.resultData);
        }
        if ((this.mFlags & 4) != 0) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            abstractGalleryActivity.registerReceiver(this.mPowerIntentReceiver, intentFilter);
        }
        try {
            this.mHapticsEnabled = System.getInt(this.mContentResolver, "haptic_feedback_enabled") != 0;
        } catch (SettingNotFoundException e) {
            this.mHapticsEnabled = false;
        }
        onResume();
        this.mActivity.getTransitionStore().clear();
    }

    protected void setContentPane(GLView gLView) {
        this.mContentPane = gLView;
        if (this.mIntroAnimation != null) {
            this.mContentPane.setIntroAnimation(this.mIntroAnimation);
            this.mIntroAnimation = null;
        }
        this.mContentPane.setBackgroundColor(getBackgroundColor());
        this.mActivity.getGLRoot().setContentPane(this.mContentPane);
    }

    protected void setStateResult(int i, Intent intent) {
        if (this.mResult != null) {
            this.mResult.resultCode = i;
            this.mResult.resultData = intent;
        }
    }

    protected void transitionOnNextPause(Class<? extends ActivityState> cls, Class<? extends ActivityState> cls2, Transition transition) {
        if (cls == PhotoPage.class && cls2 == AlbumPage.class) {
            this.mNextTransition = Transition.Outgoing;
        } else if (cls == AlbumPage.class && cls2 == PhotoPage.class) {
            this.mNextTransition = Transition.PhotoIncoming;
        } else {
            this.mNextTransition = transition;
        }
    }
}
