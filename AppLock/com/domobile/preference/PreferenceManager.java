package com.domobile.preference;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import com.domobile.preference.GenericInflater.Parent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class PreferenceManager {
    public static final String KEY_HAS_SET_DEFAULT_VALUES = "_has_set_default_values";
    public static final String METADATA_KEY_PREFERENCES = "android.preference";
    private static final String TAG = "PreferenceManager";
    private Activity mActivity;
    private List<OnActivityDestroyListener> mActivityDestroyListeners;
    private List<OnActivityResultListener> mActivityResultListeners;
    private List<OnActivityStopListener> mActivityStopListeners;
    private Context mContext;
    private Editor mEditor;
    private PreferenceFragment mFragment;
    private long mNextId = 0;
    private int mNextRequestCode;
    private boolean mNoCommit;
    private OnPreferenceTreeClickListener mOnPreferenceTreeClickListener;
    private PreferenceScreen mPreferenceScreen;
    private List<DialogInterface> mPreferencesScreens;
    private SharedPreferences mSharedPreferences;
    private int mSharedPreferencesMode;
    private String mSharedPreferencesName;

    interface OnPreferenceTreeClickListener {
        boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference);
    }

    public interface OnActivityDestroyListener {
        void onActivityDestroy();
    }

    public interface OnActivityResultListener {
        boolean onActivityResult(int i, int i2, Intent intent);
    }

    public interface OnActivityStopListener {
        void onActivityStop();
    }

    PreferenceManager(Activity activity, int i) {
        this.mActivity = activity;
        this.mNextRequestCode = i;
        init(activity);
    }

    private PreferenceManager(Context context) {
        init(context);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dismissAllScreens() {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.mPreferencesScreens;	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
    L_0x0006:
        return;
    L_0x0007:
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x002a }
        r0 = r3.mPreferencesScreens;	 Catch:{ all -> 0x002a }
        r2.<init>(r0);	 Catch:{ all -> 0x002a }
        r0 = r3.mPreferencesScreens;	 Catch:{ all -> 0x002a }
        r0.clear();	 Catch:{ all -> 0x002a }
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        r0 = r2.size();
        r0 = r0 + -1;
        r1 = r0;
    L_0x001b:
        if (r1 < 0) goto L_0x0006;
    L_0x001d:
        r0 = r2.get(r1);
        r0 = (android.content.DialogInterface) r0;
        r0.dismiss();
        r0 = r1 + -1;
        r1 = r0;
        goto L_0x001b;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.domobile.preference.PreferenceManager.dismissAllScreens():void");
    }

    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        return context.getSharedPreferences(getDefaultSharedPreferencesName(context), getDefaultSharedPreferencesMode());
    }

    private static int getDefaultSharedPreferencesMode() {
        return 0;
    }

    private static String getDefaultSharedPreferencesName(Context context) {
        return context.getPackageName() + "_preferences";
    }

    private void init(Context context) {
        this.mContext = context;
        setSharedPreferencesName(getDefaultSharedPreferencesName(context));
    }

    private List<ResolveInfo> queryIntentActivities(Intent intent) {
        return this.mContext.getPackageManager().queryIntentActivities(intent, 128);
    }

    public static void setDefaultValues(Context context, int i, boolean z) {
        setDefaultValues(context, getDefaultSharedPreferencesName(context), getDefaultSharedPreferencesMode(), i, z);
    }

    public static void setDefaultValues(Context context, String str, int i, int i2, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_HAS_SET_DEFAULT_VALUES, 0);
        if (z || !sharedPreferences.getBoolean(KEY_HAS_SET_DEFAULT_VALUES, false)) {
            PreferenceManager preferenceManager = new PreferenceManager(context);
            preferenceManager.setSharedPreferencesName(str);
            preferenceManager.setSharedPreferencesMode(i);
            preferenceManager.inflateFromResource(context, i2, null);
            Editor putBoolean = sharedPreferences.edit().putBoolean(KEY_HAS_SET_DEFAULT_VALUES, true);
            try {
                putBoolean.apply();
            } catch (Error e) {
                putBoolean.commit();
            } catch (Exception e2) {
                putBoolean.commit();
            }
        }
    }

    private void setNoCommit(boolean z) {
        if (!(z || this.mEditor == null)) {
            try {
                this.mEditor.apply();
            } catch (Error e) {
                this.mEditor.commit();
            } catch (Exception e2) {
                this.mEditor.commit();
            }
        }
        this.mNoCommit = z;
    }

    void addPreferencesScreen(DialogInterface dialogInterface) {
        synchronized (this) {
            if (this.mPreferencesScreens == null) {
                this.mPreferencesScreens = new ArrayList();
            }
            this.mPreferencesScreens.add(dialogInterface);
        }
    }

    public PreferenceScreen createPreferenceScreen(Context context) {
        PreferenceScreen preferenceScreen = new PreferenceScreen(context, null);
        preferenceScreen.onAttachedToHierarchy(this);
        return preferenceScreen;
    }

    void dispatchActivityDestroy() {
        synchronized (this) {
            List arrayList = this.mActivityDestroyListeners != null ? new ArrayList(this.mActivityDestroyListeners) : null;
        }
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((OnActivityDestroyListener) arrayList.get(i)).onActivityDestroy();
            }
        }
        dismissAllScreens();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void dispatchActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.mActivityResultListeners;	 Catch:{ all -> 0x0027 }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r4);	 Catch:{ all -> 0x0027 }
    L_0x0006:
        return;
    L_0x0007:
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x0027 }
        r0 = r4.mActivityResultListeners;	 Catch:{ all -> 0x0027 }
        r2.<init>(r0);	 Catch:{ all -> 0x0027 }
        monitor-exit(r4);	 Catch:{ all -> 0x0027 }
        r3 = r2.size();
        r0 = 0;
        r1 = r0;
    L_0x0015:
        if (r1 >= r3) goto L_0x0006;
    L_0x0017:
        r0 = r2.get(r1);
        r0 = (com.domobile.preference.PreferenceManager.OnActivityResultListener) r0;
        r0 = r0.onActivityResult(r5, r6, r7);
        if (r0 != 0) goto L_0x0006;
    L_0x0023:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0015;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0027 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.domobile.preference.PreferenceManager.dispatchActivityResult(int, int, android.content.Intent):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void dispatchActivityStop() {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.mActivityStopListeners;	 Catch:{ all -> 0x0024 }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r4);	 Catch:{ all -> 0x0024 }
    L_0x0006:
        return;
    L_0x0007:
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x0024 }
        r0 = r4.mActivityStopListeners;	 Catch:{ all -> 0x0024 }
        r2.<init>(r0);	 Catch:{ all -> 0x0024 }
        monitor-exit(r4);	 Catch:{ all -> 0x0024 }
        r3 = r2.size();
        r0 = 0;
        r1 = r0;
    L_0x0015:
        if (r1 >= r3) goto L_0x0006;
    L_0x0017:
        r0 = r2.get(r1);
        r0 = (com.domobile.preference.PreferenceManager.OnActivityStopListener) r0;
        r0.onActivityStop();
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0015;
    L_0x0024:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0024 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.domobile.preference.PreferenceManager.dispatchActivityStop():void");
    }

    void dispatchNewIntent(Intent intent) {
        dismissAllScreens();
    }

    public Preference findPreference(CharSequence charSequence) {
        return this.mPreferenceScreen == null ? null : this.mPreferenceScreen.findPreference(charSequence);
    }

    Activity getActivity() {
        return this.mActivity;
    }

    Context getContext() {
        return this.mContext;
    }

    Editor getEditor() {
        if (!this.mNoCommit) {
            return getSharedPreferences().edit();
        }
        if (this.mEditor == null) {
            this.mEditor = getSharedPreferences().edit();
        }
        return this.mEditor;
    }

    PreferenceFragment getFragment() {
        return this.mFragment;
    }

    long getNextId() {
        long j;
        synchronized (this) {
            j = this.mNextId;
            this.mNextId = 1 + j;
        }
        return j;
    }

    int getNextRequestCode() {
        int i;
        synchronized (this) {
            i = this.mNextRequestCode;
            this.mNextRequestCode = i + 1;
        }
        return i;
    }

    OnPreferenceTreeClickListener getOnPreferenceTreeClickListener() {
        return this.mOnPreferenceTreeClickListener;
    }

    PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceScreen;
    }

    public SharedPreferences getSharedPreferences() {
        if (this.mSharedPreferences == null) {
            this.mSharedPreferences = this.mContext.getSharedPreferences(this.mSharedPreferencesName, this.mSharedPreferencesMode);
        }
        return this.mSharedPreferences;
    }

    public int getSharedPreferencesMode() {
        return this.mSharedPreferencesMode;
    }

    public String getSharedPreferencesName() {
        return this.mSharedPreferencesName;
    }

    PreferenceScreen inflateFromIntent(Intent intent, PreferenceScreen preferenceScreen) {
        List queryIntentActivities = queryIntentActivities(intent);
        HashSet hashSet = new HashSet();
        int size = queryIntentActivities.size() - 1;
        PreferenceScreen preferenceScreen2 = preferenceScreen;
        while (size >= 0) {
            PreferenceScreen preferenceScreen3;
            ActivityInfo activityInfo = ((ResolveInfo) queryIntentActivities.get(size)).activityInfo;
            Bundle bundle = activityInfo.metaData;
            if (bundle != null) {
                if (bundle.containsKey(METADATA_KEY_PREFERENCES)) {
                    String str = activityInfo.packageName + ":" + activityInfo.metaData.getInt(METADATA_KEY_PREFERENCES);
                    if (!hashSet.contains(str)) {
                        hashSet.add(str);
                        try {
                            Context createPackageContext = this.mContext.createPackageContext(activityInfo.packageName, 0);
                            PreferenceInflater preferenceInflater = new PreferenceInflater(createPackageContext, this);
                            Object loadXmlMetaData = activityInfo.loadXmlMetaData(createPackageContext.getPackageManager(), METADATA_KEY_PREFERENCES);
                            preferenceScreen3 = (PreferenceScreen) preferenceInflater.inflate((XmlPullParser) loadXmlMetaData, (Parent) preferenceScreen2, true);
                            loadXmlMetaData.close();
                        } catch (Throwable e) {
                            Log.w(TAG, "Could not create context for " + activityInfo.packageName + ": " + Log.getStackTraceString(e));
                            preferenceScreen3 = preferenceScreen2;
                        }
                    }
                } else {
                    preferenceScreen3 = preferenceScreen2;
                }
                size--;
                preferenceScreen2 = preferenceScreen3;
            }
            preferenceScreen3 = preferenceScreen2;
            size--;
            preferenceScreen2 = preferenceScreen3;
        }
        preferenceScreen2.onAttachedToHierarchy(this);
        return preferenceScreen2;
    }

    public PreferenceScreen inflateFromResource(Context context, int i, PreferenceScreen preferenceScreen) {
        setNoCommit(true);
        PreferenceScreen preferenceScreen2 = (PreferenceScreen) new PreferenceInflater(context, this).inflate(i, (Parent) preferenceScreen, true);
        preferenceScreen2.onAttachedToHierarchy(this);
        setNoCommit(false);
        return preferenceScreen2;
    }

    void registerOnActivityDestroyListener(OnActivityDestroyListener onActivityDestroyListener) {
        synchronized (this) {
            if (this.mActivityDestroyListeners == null) {
                this.mActivityDestroyListeners = new ArrayList();
            }
            if (!this.mActivityDestroyListeners.contains(onActivityDestroyListener)) {
                this.mActivityDestroyListeners.add(onActivityDestroyListener);
            }
        }
    }

    void registerOnActivityResultListener(OnActivityResultListener onActivityResultListener) {
        synchronized (this) {
            if (this.mActivityResultListeners == null) {
                this.mActivityResultListeners = new ArrayList();
            }
            if (!this.mActivityResultListeners.contains(onActivityResultListener)) {
                this.mActivityResultListeners.add(onActivityResultListener);
            }
        }
    }

    void registerOnActivityStopListener(OnActivityStopListener onActivityStopListener) {
        synchronized (this) {
            if (this.mActivityStopListeners == null) {
                this.mActivityStopListeners = new ArrayList();
            }
            if (!this.mActivityStopListeners.contains(onActivityStopListener)) {
                this.mActivityStopListeners.add(onActivityStopListener);
            }
        }
    }

    public void removePreferenceScreen() {
        this.mPreferenceScreen = null;
    }

    void removePreferencesScreen(DialogInterface dialogInterface) {
        synchronized (this) {
            if (this.mPreferencesScreens == null) {
                return;
            }
            this.mPreferencesScreens.remove(dialogInterface);
        }
    }

    void setFragment(PreferenceFragment preferenceFragment) {
        this.mFragment = preferenceFragment;
    }

    void setOnPreferenceTreeClickListener(OnPreferenceTreeClickListener onPreferenceTreeClickListener) {
        this.mOnPreferenceTreeClickListener = onPreferenceTreeClickListener;
    }

    boolean setPreferences(PreferenceScreen preferenceScreen) {
        if (preferenceScreen == this.mPreferenceScreen) {
            return false;
        }
        this.mPreferenceScreen = preferenceScreen;
        return true;
    }

    public void setSharedPreferencesMode(int i) {
        this.mSharedPreferencesMode = i;
        this.mSharedPreferences = null;
    }

    public void setSharedPreferencesName(String str) {
        this.mSharedPreferencesName = str;
        this.mSharedPreferences = null;
    }

    boolean shouldCommit() {
        return !this.mNoCommit;
    }

    void unregisterOnActivityDestroyListener(OnActivityDestroyListener onActivityDestroyListener) {
        synchronized (this) {
            if (this.mActivityDestroyListeners != null) {
                this.mActivityDestroyListeners.remove(onActivityDestroyListener);
            }
        }
    }

    void unregisterOnActivityResultListener(OnActivityResultListener onActivityResultListener) {
        synchronized (this) {
            if (this.mActivityResultListeners != null) {
                this.mActivityResultListeners.remove(onActivityResultListener);
            }
        }
    }

    void unregisterOnActivityStopListener(OnActivityStopListener onActivityStopListener) {
        synchronized (this) {
            if (this.mActivityStopListeners != null) {
                this.mActivityStopListeners.remove(onActivityStopListener);
            }
        }
    }
}
