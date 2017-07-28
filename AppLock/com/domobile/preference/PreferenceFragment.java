package com.domobile.preference;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.ListView;
import com.domobile.frame.C0399d;
import com.domobile.p015b.C1168b.C1163g;

public abstract class PreferenceFragment extends C0399d implements OnPreferenceTreeClickListener {
    private static final int FIRST_REQUEST_CODE = 100;
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";
    private Handler mHandler = new C13932();
    private boolean mHavePrefs;
    private boolean mInitDone;
    private int mLayouId = C1163g.preference_list_fragment;
    private OnKeyListener mListOnKeyListener = new C13921();
    private ListView mListView;
    private PreferenceManager mPreferenceManager;
    private final Runnable mRequestFocus = new C13943();

    class C13921 implements OnKeyListener {
        C13921() {
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            Object selectedItem = PreferenceFragment.this.mListView.getSelectedItem();
            if (!(selectedItem instanceof Preference)) {
                return false;
            }
            return ((Preference) selectedItem).onKey(PreferenceFragment.this.mListView.getSelectedView(), i, keyEvent);
        }
    }

    class C13932 extends Handler {
        C13932() {
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    PreferenceFragment.this.bindPreferences();
                    return;
                default:
                    return;
            }
        }
    }

    class C13943 implements Runnable {
        C13943() {
        }

        public void run() {
            PreferenceFragment.this.mListView.focusableViewAvailable(PreferenceFragment.this.mListView);
        }
    }

    public interface OnPreferenceStartFragmentCallback {
        boolean onPreferenceStartFragment(PreferenceFragment preferenceFragment, Preference preference);
    }

    private void bindPreferences() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            preferenceScreen.bind(getListView());
        }
    }

    private void ensureList() {
        if (this.mListView == null) {
            View view = getView();
            if (view == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            view = view.findViewById(16908298);
            if (view instanceof ListView) {
                this.mListView = (ListView) view;
                if (this.mListView == null) {
                    throw new RuntimeException("必须包含id为'android.R.id.list'的ListView");
                }
                this.mListView.setOnKeyListener(this.mListOnKeyListener);
                this.mHandler.post(this.mRequestFocus);
                return;
            }
            throw new RuntimeException("'android.R.id.list'不是ListView");
        }
    }

    private void postBindPreferences() {
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.obtainMessage(1).sendToTarget();
        }
    }

    private void requirePreferenceManager() {
        if (this.mPreferenceManager == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    public void addPreferencesFromIntent(Intent intent) {
        requirePreferenceManager();
        setPreferenceScreen(this.mPreferenceManager.inflateFromIntent(intent, getPreferenceScreen()));
    }

    public void addPreferencesFromResource(int i) {
        requirePreferenceManager();
        setPreferenceScreen(this.mPreferenceManager.inflateFromResource(getActivity(), i, getPreferenceScreen()));
    }

    public Preference findPreference(CharSequence charSequence) {
        return this.mPreferenceManager == null ? null : this.mPreferenceManager.findPreference(charSequence);
    }

    public ListView getListView() {
        ensureList();
        return this.mListView;
    }

    public PreferenceManager getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceManager.getPreferenceScreen();
    }

    public void init(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = layoutInflater.inflate(this.mLayouId, null);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.mHavePrefs) {
            bindPreferences();
        }
        this.mInitDone = true;
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle(PREFERENCES_TAG);
            if (bundle2 != null) {
                PreferenceScreen preferenceScreen = getPreferenceScreen();
                if (preferenceScreen != null) {
                    preferenceScreen.restoreHierarchyState(bundle2);
                }
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mPreferenceManager.dispatchActivityResult(i, i2, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPreferenceManager = new PreferenceManager(getActivity(), 100);
        this.mPreferenceManager.setFragment(this);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mPreferenceManager.dispatchActivityDestroy();
    }

    public void onDestroyView() {
        this.mListView = null;
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mHandler.removeMessages(1);
        super.onDestroyView();
    }

    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        return (preference.getFragment() == null || !(getActivity() instanceof OnPreferenceStartFragmentCallback)) ? false : ((OnPreferenceStartFragmentCallback) getActivity()).onPreferenceStartFragment(this, preference);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.saveHierarchyState(bundle2);
            bundle.putBundle(PREFERENCES_TAG, bundle2);
        }
    }

    public void onStart() {
        super.onStart();
        this.mPreferenceManager.setOnPreferenceTreeClickListener(this);
    }

    public void onStop() {
        super.onStop();
        this.mPreferenceManager.dispatchActivityStop();
        this.mPreferenceManager.setOnPreferenceTreeClickListener(null);
    }

    public void removePreferenceScreen() {
        this.mPreferenceManager.removePreferenceScreen();
    }

    public void setContentView(int i) {
        this.mLayouId = i;
    }

    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        if (this.mPreferenceManager.setPreferences(preferenceScreen) && preferenceScreen != null) {
            this.mHavePrefs = true;
            if (this.mInitDone) {
                postBindPreferences();
            }
        }
    }
}
