package com.android.gallery3d.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import com.android.gallery3d.anim.StateTransitionAnimation.Transition;
import com.android.gallery3d.common.Utils;
import java.util.Iterator;
import java.util.Stack;

public class StateManager {
    private static final String KEY_CLASS = "class";
    private static final String KEY_DATA = "data";
    private static final String KEY_MAIN = "activity-state";
    private static final String KEY_STATE = "bundle";
    private static final String TAG = "StateManager";
    private AbstractGalleryActivity mActivity;
    private boolean mIsResumed = false;
    private ResultEntry mResult;
    private Stack<StateEntry> mStack = new Stack();

    private static class StateEntry {
        public ActivityState activityState;
        public Bundle data;

        public StateEntry(Bundle bundle, ActivityState activityState) {
            this.data = bundle;
            this.activityState = activityState;
        }
    }

    public StateManager(AbstractGalleryActivity abstractGalleryActivity) {
        this.mActivity = abstractGalleryActivity;
    }

    public void clearActivityResult() {
        if (!this.mStack.isEmpty()) {
            getTopState().clearStateResult();
        }
    }

    public void clearTasks() {
        while (this.mStack.size() > 1) {
            ((StateEntry) this.mStack.pop()).activityState.onDestroy();
        }
    }

    public boolean createOptionsMenu(Menu menu) {
        return false;
    }

    public void destroy() {
        Log.m435v(TAG, "destroy");
        while (!this.mStack.isEmpty()) {
            ((StateEntry) this.mStack.pop()).activityState.onDestroy();
        }
        this.mStack.clear();
    }

    void finishState(ActivityState activityState) {
        finishState(activityState, true);
    }

    void finishState(ActivityState activityState, boolean z) {
        if (this.mStack.size() == 1) {
            Activity activity = (Activity) this.mActivity.getAndroidContext();
            if (this.mResult != null) {
                activity.setResult(this.mResult.resultCode, this.mResult.resultData);
            }
            activity.finish();
            if (activity.isFinishing()) {
                Log.m435v(TAG, "no more state, finish activity");
            } else {
                Log.m437w(TAG, "finish is rejected, keep the last state");
                return;
            }
        }
        Log.m435v(TAG, "finishState " + activityState);
        if (activityState == ((StateEntry) this.mStack.peek()).activityState) {
            this.mStack.pop();
            activityState.mIsFinishing = true;
            ActivityState activityState2 = !this.mStack.isEmpty() ? ((StateEntry) this.mStack.peek()).activityState : null;
            if (this.mIsResumed && z) {
                if (activityState2 != null) {
                    activityState.transitionOnNextPause(activityState.getClass(), activityState2.getClass(), Transition.Outgoing);
                }
                activityState.onPause();
            }
            this.mActivity.getGLRoot().setContentPane(null);
            activityState.onDestroy();
            if (activityState2 != null && this.mIsResumed) {
                activityState2.resume();
            }
        } else if (activityState.isDestroyed()) {
            Log.m429d(TAG, "The state is already destroyed");
        } else {
            throw new IllegalArgumentException("The stateview to be finished is not at the top of the stack: " + activityState + ", " + ((StateEntry) this.mStack.peek()).activityState);
        }
    }

    public int getStateCount() {
        return this.mStack.size();
    }

    public ActivityState getTopState() {
        Utils.assertTrue(!this.mStack.isEmpty());
        return ((StateEntry) this.mStack.peek()).activityState;
    }

    public boolean hasStateClass(Class<? extends ActivityState> cls) {
        Iterator it = this.mStack.iterator();
        while (it.hasNext()) {
            if (cls.isInstance(((StateEntry) it.next()).activityState)) {
                return true;
            }
        }
        return false;
    }

    public boolean itemSelected(MenuItem menuItem) {
        if (this.mStack.isEmpty() || menuItem.getItemId() != 16908332) {
            return false;
        }
        if (this.mStack.size() <= 1) {
            return true;
        }
        getTopState().onBackPressed();
        return true;
    }

    public void notifyActivityResult(int i, int i2, Intent intent) {
        getTopState().onStateResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.mStack.isEmpty()) {
            getTopState().onBackPressed();
        }
    }

    public void onConfigurationChange(Configuration configuration) {
        Iterator it = this.mStack.iterator();
        while (it.hasNext()) {
            ((StateEntry) it.next()).activityState.onConfigurationChanged(configuration);
        }
    }

    public void pause() {
        if (this.mIsResumed) {
            this.mIsResumed = false;
            if (!this.mStack.isEmpty()) {
                getTopState().onPause();
            }
        }
    }

    public void restoreFromState(Bundle bundle) {
        Log.m435v(TAG, "restoreFromState");
        Parcelable[] parcelableArray = bundle.getParcelableArray(KEY_MAIN);
        int length = parcelableArray.length;
        int i = 0;
        while (i < length) {
            Bundle bundle2 = (Bundle) parcelableArray[i];
            Class cls = (Class) bundle2.getSerializable(KEY_CLASS);
            Bundle bundle3 = bundle2.getBundle(KEY_DATA);
            Bundle bundle4 = bundle2.getBundle(KEY_STATE);
            try {
                Log.m435v(TAG, "restoreFromState " + cls);
                ActivityState activityState = (ActivityState) cls.newInstance();
                activityState.initialize(this.mActivity, bundle3);
                activityState.onCreate(bundle3, bundle4);
                this.mStack.push(new StateEntry(bundle3, activityState));
                i++;
            } catch (Exception e) {
                throw new AssertionError(e);
            }
        }
    }

    public void resume() {
        if (!this.mIsResumed) {
            this.mIsResumed = true;
            if (!this.mStack.isEmpty()) {
                getTopState().resume();
            }
        }
    }

    public void saveState(Bundle bundle) {
        Log.m435v(TAG, "saveState");
        Parcelable[] parcelableArr = new Parcelable[this.mStack.size()];
        Iterator it = this.mStack.iterator();
        int i = 0;
        while (it.hasNext()) {
            StateEntry stateEntry = (StateEntry) it.next();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable(KEY_CLASS, stateEntry.activityState.getClass());
            bundle2.putBundle(KEY_DATA, stateEntry.data);
            Bundle bundle3 = new Bundle();
            stateEntry.activityState.onSaveState(bundle3);
            bundle2.putBundle(KEY_STATE, bundle3);
            Log.m435v(TAG, "saveState " + stateEntry.activityState.getClass());
            int i2 = i + 1;
            parcelableArr[i] = bundle2;
            i = i2;
        }
        bundle.putParcelableArray(KEY_MAIN, parcelableArr);
    }

    public void startState(Class<? extends ActivityState> cls, Bundle bundle) {
        Log.m435v(TAG, "startState " + cls);
        try {
            ActivityState activityState = (ActivityState) cls.newInstance();
            if (!this.mStack.isEmpty()) {
                ActivityState topState = getTopState();
                topState.transitionOnNextPause(topState.getClass(), cls, Transition.Incoming);
                if (this.mIsResumed) {
                    topState.onPause();
                }
            }
            activityState.initialize(this.mActivity, bundle);
            this.mStack.push(new StateEntry(bundle, activityState));
            activityState.onCreate(bundle, null);
            if (this.mIsResumed) {
                activityState.resume();
            }
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public void startStateForResult(Class<? extends ActivityState> cls, int i, Bundle bundle) {
        Log.m435v(TAG, "startStateForResult " + cls + ", " + i);
        try {
            ActivityState activityState = (ActivityState) cls.newInstance();
            activityState.initialize(this.mActivity, bundle);
            activityState.mResult = new ResultEntry();
            activityState.mResult.requestCode = i;
            if (this.mStack.isEmpty()) {
                this.mResult = activityState.mResult;
            } else {
                ActivityState topState = getTopState();
                topState.transitionOnNextPause(topState.getClass(), cls, Transition.Incoming);
                topState.mReceivedResults = activityState.mResult;
                if (this.mIsResumed) {
                    topState.onPause();
                }
            }
            this.mStack.push(new StateEntry(bundle, activityState));
            activityState.onCreate(bundle, null);
            if (this.mIsResumed) {
                activityState.resume();
            }
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public void switchState(ActivityState activityState, Class<? extends ActivityState> cls, Bundle bundle) {
        Log.m435v(TAG, "switchState " + activityState + ", " + cls);
        if (activityState != ((StateEntry) this.mStack.peek()).activityState) {
            throw new IllegalArgumentException("The stateview to be finished is not at the top of the stack: " + activityState + ", " + ((StateEntry) this.mStack.peek()).activityState);
        }
        this.mStack.pop();
        if (!bundle.containsKey(PhotoPage.KEY_APP_BRIDGE)) {
            activityState.transitionOnNextPause(activityState.getClass(), cls, Transition.Incoming);
        }
        if (this.mIsResumed) {
            activityState.onPause();
        }
        activityState.onDestroy();
        try {
            ActivityState activityState2 = (ActivityState) cls.newInstance();
            activityState2.initialize(this.mActivity, bundle);
            this.mStack.push(new StateEntry(bundle, activityState2));
            activityState2.onCreate(bundle, null);
            if (this.mIsResumed) {
                activityState2.resume();
            }
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}
