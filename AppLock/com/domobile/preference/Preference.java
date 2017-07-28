package com.domobile.preference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.domobile.p015b.C1168b.C1163g;
import com.domobile.p015b.C1168b.C1167k;
import java.util.ArrayList;
import java.util.List;

public class Preference implements OnDependencyChangeListener, Comparable<Preference> {
    public static final int DEFAULT_ORDER = Integer.MAX_VALUE;
    private boolean mBaseMethodCalled;
    private Context mContext;
    private Object mDefaultValue;
    private String mDependencyKey;
    private boolean mDependencyMet;
    private List<Preference> mDependents;
    private boolean mEnabled;
    private Bundle mExtras;
    private String mFragment;
    private boolean mHasSpecifiedLayout;
    private Drawable mIcon;
    private int mIconResId;
    private long mId;
    private Intent mIntent;
    private String mKey;
    private int mLayoutResId;
    private OnPreferenceChangeInternalListener mListener;
    private OnPreferenceChangeListener mOnChangeListener;
    private OnPreferenceClickListener mOnClickListener;
    private int mOrder;
    private boolean mPersistent;
    private PreferenceManager mPreferenceManager;
    private boolean mRequiresKey;
    private boolean mSelectable;
    private boolean mShouldDisableView;
    private CharSequence mSummary;
    private CharSequence mTitle;
    private int mTitleRes;
    private View mView;
    private int mWidgetLayoutResId;

    public interface OnPreferenceChangeListener {
        boolean onPreferenceChange(Preference preference, Object obj);
    }

    public interface OnPreferenceClickListener {
        boolean onPreferenceClick(Preference preference);
    }

    public static class BaseSavedState extends AbsSavedState {
        public static final Creator<BaseSavedState> CREATOR = new C13911();

        static class C13911 implements Creator<BaseSavedState> {
            C13911() {
            }

            public BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            public BaseSavedState[] newArray(int i) {
                return new BaseSavedState[i];
            }
        }

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    interface OnPreferenceChangeInternalListener {
        void onPreferenceChange(Preference preference);

        void onPreferenceHierarchyChange(Preference preference);
    }

    public Preference(Context context) {
        this(context, null);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this.mOrder = Integer.MAX_VALUE;
        this.mEnabled = true;
        this.mSelectable = true;
        this.mPersistent = true;
        this.mDependencyMet = true;
        this.mShouldDisableView = true;
        this.mLayoutResId = C1163g.preference_layout;
        this.mHasSpecifiedLayout = false;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1167k.MyPreference, i, 0);
        for (int indexCount = obtainStyledAttributes.getIndexCount(); indexCount >= 0; indexCount--) {
            int index = obtainStyledAttributes.getIndex(indexCount);
            if (index == C1167k.MyPreference_android_icon) {
                this.mIconResId = obtainStyledAttributes.getResourceId(index, 0);
            } else if (index == C1167k.MyPreference_android_key) {
                this.mKey = obtainStyledAttributes.getString(index);
            } else if (index == C1167k.MyPreference_android_title) {
                this.mTitleRes = obtainStyledAttributes.getResourceId(index, 0);
                this.mTitle = obtainStyledAttributes.getString(index);
            } else if (index == C1167k.MyPreference_android_summary) {
                this.mSummary = obtainStyledAttributes.getString(index);
            } else if (index == C1167k.MyPreference_android_order) {
                this.mOrder = obtainStyledAttributes.getInt(index, this.mOrder);
            } else if (index == C1167k.MyPreference_android_layout) {
                this.mLayoutResId = obtainStyledAttributes.getResourceId(index, this.mLayoutResId);
            } else if (index == C1167k.MyPreference_android_widgetLayout) {
                this.mWidgetLayoutResId = obtainStyledAttributes.getResourceId(index, this.mWidgetLayoutResId);
            } else if (index == C1167k.MyPreference_android_enabled) {
                this.mEnabled = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == C1167k.MyPreference_android_selectable) {
                this.mSelectable = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == C1167k.MyPreference_android_persistent) {
                this.mPersistent = obtainStyledAttributes.getBoolean(index, this.mPersistent);
            } else if (index == C1167k.MyPreference_android_dependency) {
                this.mDependencyKey = obtainStyledAttributes.getString(index);
            } else if (index == C1167k.MyPreference_android_defaultValue) {
                this.mDefaultValue = onGetDefaultValue(obtainStyledAttributes, index);
            } else if (index == C1167k.MyPreference_android_shouldDisableView) {
                this.mShouldDisableView = obtainStyledAttributes.getBoolean(index, this.mShouldDisableView);
            }
        }
        obtainStyledAttributes.recycle();
        if (!getClass().getName().startsWith(PreferenceManager.METADATA_KEY_PREFERENCES)) {
            this.mHasSpecifiedLayout = true;
        }
    }

    private void dispatchSetInitialValue() {
        if (shouldPersist() && getSharedPreferences().contains(this.mKey)) {
            onSetInitialValue(true, null);
        } else if (this.mDefaultValue != null) {
            onSetInitialValue(false, this.mDefaultValue);
        }
    }

    private void registerDependency() {
        if (!TextUtils.isEmpty(this.mDependencyKey)) {
            Preference findPreferenceInHierarchy = findPreferenceInHierarchy(this.mDependencyKey);
            if (findPreferenceInHierarchy != null) {
                findPreferenceInHierarchy.registerDependent(this);
                return;
            }
            throw new IllegalStateException("Dependency \"" + this.mDependencyKey + "\" not found for preference \"" + this.mKey + "\" (title: \"" + this.mTitle + "\"");
        }
    }

    private void registerDependent(Preference preference) {
        if (this.mDependents == null) {
            this.mDependents = new ArrayList();
        }
        this.mDependents.add(preference);
        preference.onDependencyChanged(this, shouldDisableDependents());
    }

    private void setEnabledStateOnViews(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                setEnabledStateOnViews(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    private void tryCommit(Editor editor) {
        if (this.mPreferenceManager.shouldCommit()) {
            try {
                editor.apply();
            } catch (Error e) {
                editor.commit();
            } catch (Exception e2) {
                editor.commit();
            }
        }
    }

    private void unregisterDependency() {
        if (this.mDependencyKey != null) {
            Preference findPreferenceInHierarchy = findPreferenceInHierarchy(this.mDependencyKey);
            if (findPreferenceInHierarchy != null) {
                findPreferenceInHierarchy.unregisterDependent(this);
            }
        }
    }

    private void unregisterDependent(Preference preference) {
        if (this.mDependents != null) {
            this.mDependents.remove(preference);
        }
    }

    protected boolean callChangeListener(Object obj) {
        return this.mOnChangeListener == null ? true : this.mOnChangeListener.onPreferenceChange(this, obj);
    }

    public int compareTo(Preference preference) {
        return (this.mOrder != Integer.MAX_VALUE || (this.mOrder == Integer.MAX_VALUE && preference.mOrder != Integer.MAX_VALUE)) ? this.mOrder - preference.mOrder : this.mTitle == null ? 1 : preference.mTitle == null ? -1 : CharSequences.compareToIgnoreCase(this.mTitle, preference.mTitle);
    }

    void dispatchRestoreInstanceState(Bundle bundle) {
        if (hasKey()) {
            Parcelable parcelable = bundle.getParcelable(this.mKey);
            if (parcelable != null) {
                this.mBaseMethodCalled = false;
                onRestoreInstanceState(parcelable);
                if (!this.mBaseMethodCalled) {
                    throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
                }
            }
        }
    }

    void dispatchSaveInstanceState(Bundle bundle) {
        if (hasKey()) {
            this.mBaseMethodCalled = false;
            Parcelable onSaveInstanceState = onSaveInstanceState();
            if (!this.mBaseMethodCalled) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            } else if (onSaveInstanceState != null) {
                bundle.putParcelable(this.mKey, onSaveInstanceState);
            }
        }
    }

    protected Preference findPreferenceInHierarchy(String str) {
        return (TextUtils.isEmpty(str) || this.mPreferenceManager == null) ? null : this.mPreferenceManager.findPreference(str);
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDependency() {
        return this.mDependencyKey;
    }

    public Editor getEditor() {
        return this.mPreferenceManager == null ? null : this.mPreferenceManager.getEditor();
    }

    public Bundle getExtras() {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        return this.mExtras;
    }

    StringBuilder getFilterableStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            stringBuilder.append(title).append(' ');
        }
        title = getSummary();
        if (!TextUtils.isEmpty(title)) {
            stringBuilder.append(title).append(' ');
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder;
    }

    public String getFragment() {
        return this.mFragment;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    long getId() {
        return this.mId;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public String getKey() {
        return this.mKey;
    }

    public int getLayoutResource() {
        return this.mLayoutResId;
    }

    public OnPreferenceChangeListener getOnPreferenceChangeListener() {
        return this.mOnChangeListener;
    }

    public OnPreferenceClickListener getOnPreferenceClickListener() {
        return this.mOnClickListener;
    }

    public int getOrder() {
        return this.mOrder;
    }

    protected boolean getPersistedBoolean(boolean z) {
        return !shouldPersist() ? z : this.mPreferenceManager.getSharedPreferences().getBoolean(this.mKey, z);
    }

    protected float getPersistedFloat(float f) {
        return !shouldPersist() ? f : this.mPreferenceManager.getSharedPreferences().getFloat(this.mKey, f);
    }

    protected int getPersistedInt(int i) {
        return !shouldPersist() ? i : this.mPreferenceManager.getSharedPreferences().getInt(this.mKey, i);
    }

    protected long getPersistedLong(long j) {
        return !shouldPersist() ? j : this.mPreferenceManager.getSharedPreferences().getLong(this.mKey, j);
    }

    protected String getPersistedString(String str) {
        return !shouldPersist() ? str : this.mPreferenceManager.getSharedPreferences().getString(this.mKey, str);
    }

    public PreferenceManager getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public SharedPreferences getSharedPreferences() {
        return this.mPreferenceManager == null ? null : this.mPreferenceManager.getSharedPreferences();
    }

    public boolean getShouldDisableView() {
        return this.mShouldDisableView;
    }

    public CharSequence getSummary() {
        return this.mSummary;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public int getTitleRes() {
        return this.mTitleRes;
    }

    public View getView() {
        return this.mView;
    }

    public View getView(View view, ViewGroup viewGroup) {
        if (view == null) {
            view = onCreateView(viewGroup);
        }
        onBindView(view);
        return view;
    }

    public int getWidgetLayoutResource() {
        return this.mWidgetLayoutResId;
    }

    public boolean hasKey() {
        return !TextUtils.isEmpty(this.mKey);
    }

    boolean hasSpecifiedLayout() {
        return this.mHasSpecifiedLayout;
    }

    public boolean isEnabled() {
        return this.mEnabled && this.mDependencyMet;
    }

    public boolean isPersistent() {
        return this.mPersistent;
    }

    public boolean isSelectable() {
        return this.mSelectable;
    }

    protected void notifyChanged() {
        if (this.mListener != null) {
            this.mListener.onPreferenceChange(this);
        }
    }

    public void notifyDependencyChange(boolean z) {
        List list = this.mDependents;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ((Preference) list.get(i)).onDependencyChanged(this, z);
            }
        }
    }

    protected void notifyHierarchyChanged() {
        if (this.mListener != null) {
            this.mListener.onPreferenceHierarchyChange(this);
        }
    }

    protected void onAttachedToActivity() {
        registerDependency();
    }

    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        this.mPreferenceManager = preferenceManager;
        this.mId = preferenceManager.getNextId();
        dispatchSetInitialValue();
    }

    protected void onBindView(View view) {
        int i = 0;
        if (view != null) {
            TextView textView = (TextView) view.findViewById(16908310);
            if (textView != null) {
                textView.setText(getTitle());
            }
            textView = (TextView) view.findViewById(16908304);
            if (textView != null) {
                if (!TextUtils.isEmpty(getSummary())) {
                    if (textView.getVisibility() != 0) {
                        textView.setVisibility(0);
                    }
                    textView.setText(getSummary());
                } else if (textView.getVisibility() != 8) {
                    textView.setVisibility(8);
                }
            }
            ImageView imageView = (ImageView) view.findViewById(16908294);
            if (imageView != null) {
                if (!(this.mIconResId == 0 && this.mIcon == null)) {
                    if (this.mIcon == null) {
                        this.mIcon = getContext().getResources().getDrawable(this.mIconResId);
                    }
                    if (this.mIcon != null) {
                        imageView.setImageDrawable(this.mIcon);
                    }
                }
                if (this.mIcon == null) {
                    i = 8;
                }
                imageView.setVisibility(i);
            }
            if (this.mShouldDisableView) {
                setEnabledStateOnViews(view, isEnabled());
            }
        }
    }

    protected void onClick() {
    }

    protected View onCreateView(ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(this.mLayoutResId, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            if (this.mWidgetLayoutResId != 0) {
                layoutInflater.inflate(this.mWidgetLayoutResId, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return inflate;
    }

    public void onDependencyChanged(Preference preference, boolean z) {
        if (this.mDependencyMet == z) {
            this.mDependencyMet = !z;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    protected Object onGetDefaultValue(TypedArray typedArray, int i) {
        return null;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    protected void onPrepareForRemoval() {
        unregisterDependency();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        this.mBaseMethodCalled = true;
        if (parcelable != BaseSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    protected Parcelable onSaveInstanceState() {
        this.mBaseMethodCalled = true;
        return BaseSavedState.EMPTY_STATE;
    }

    protected void onSetInitialValue(boolean z, Object obj) {
    }

    public Bundle peekExtras() {
        return this.mExtras;
    }

    void performClick(PreferenceScreen preferenceScreen) {
        if (isEnabled()) {
            onClick();
            if (this.mOnClickListener == null || !this.mOnClickListener.onPreferenceClick(this)) {
                PreferenceManager preferenceManager = getPreferenceManager();
                if (preferenceManager != null) {
                    OnPreferenceTreeClickListener onPreferenceTreeClickListener = preferenceManager.getOnPreferenceTreeClickListener();
                    if (!(preferenceScreen == null || onPreferenceTreeClickListener == null || !onPreferenceTreeClickListener.onPreferenceTreeClick(preferenceScreen, this))) {
                        return;
                    }
                }
                if (this.mIntent != null) {
                    getContext().startActivity(this.mIntent);
                }
            }
        }
    }

    protected boolean persistBoolean(boolean z) {
        boolean z2 = false;
        if (!shouldPersist()) {
            return false;
        }
        if (!z) {
            z2 = true;
        }
        if (z == getPersistedBoolean(z2)) {
            return true;
        }
        Editor editor = this.mPreferenceManager.getEditor();
        editor.putBoolean(this.mKey, z);
        tryCommit(editor);
        return true;
    }

    protected boolean persistFloat(float f) {
        if (!shouldPersist()) {
            return false;
        }
        if (f == getPersistedFloat(Float.NaN)) {
            return true;
        }
        Editor editor = this.mPreferenceManager.getEditor();
        editor.putFloat(this.mKey, f);
        tryCommit(editor);
        return true;
    }

    protected boolean persistInt(int i) {
        if (!shouldPersist()) {
            return false;
        }
        if (i == getPersistedInt(i ^ -1)) {
            return true;
        }
        Editor editor = this.mPreferenceManager.getEditor();
        editor.putInt(this.mKey, i);
        tryCommit(editor);
        return true;
    }

    protected boolean persistLong(long j) {
        if (!shouldPersist()) {
            return false;
        }
        if (j == getPersistedLong(-1 ^ j)) {
            return true;
        }
        Editor editor = this.mPreferenceManager.getEditor();
        editor.putLong(this.mKey, j);
        tryCommit(editor);
        return true;
    }

    protected boolean persistString(String str) {
        if (!shouldPersist()) {
            return false;
        }
        if (str == getPersistedString(null)) {
            return true;
        }
        Editor editor = this.mPreferenceManager.getEditor();
        editor.putString(this.mKey, str);
        tryCommit(editor);
        return true;
    }

    void requireKey() {
        if (this.mKey == null) {
            throw new IllegalStateException("Preference does not have a key assigned.");
        }
        this.mRequiresKey = true;
    }

    public void restoreHierarchyState(Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void saveHierarchyState(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void setDefaultValue(Object obj) {
        this.mDefaultValue = obj;
    }

    public void setDependency(String str) {
        unregisterDependency();
        this.mDependencyKey = str;
        registerDependency();
    }

    public void setEnabled(boolean z) {
        if (this.mEnabled != z) {
            this.mEnabled = z;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public void setFragment(String str) {
        this.mFragment = str;
    }

    public void setIcon(int i) {
        this.mIconResId = i;
        setIcon(this.mContext.getResources().getDrawable(i));
    }

    public void setIcon(Drawable drawable) {
        if ((drawable == null && this.mIcon != null) || (drawable != null && this.mIcon != drawable)) {
            this.mIcon = drawable;
            notifyChanged();
        }
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public void setKey(String str) {
        this.mKey = str;
        if (this.mRequiresKey && !hasKey()) {
            requireKey();
        }
    }

    public void setLayoutResource(int i) {
        if (i != this.mLayoutResId) {
            this.mHasSpecifiedLayout = true;
        }
        this.mLayoutResId = i;
    }

    final void setOnPreferenceChangeInternalListener(OnPreferenceChangeInternalListener onPreferenceChangeInternalListener) {
        this.mListener = onPreferenceChangeInternalListener;
    }

    public void setOnPreferenceChangeListener(OnPreferenceChangeListener onPreferenceChangeListener) {
        this.mOnChangeListener = onPreferenceChangeListener;
    }

    public void setOnPreferenceClickListener(OnPreferenceClickListener onPreferenceClickListener) {
        this.mOnClickListener = onPreferenceClickListener;
    }

    public void setOrder(int i) {
        if (i != this.mOrder) {
            this.mOrder = i;
            notifyHierarchyChanged();
        }
    }

    public void setPersistent(boolean z) {
        this.mPersistent = z;
    }

    public void setSelectable(boolean z) {
        if (this.mSelectable != z) {
            this.mSelectable = z;
            notifyChanged();
        }
    }

    public void setShouldDisableView(boolean z) {
        this.mShouldDisableView = z;
        notifyChanged();
    }

    public void setSummary(int i) {
        setSummary(this.mContext.getString(i));
    }

    public void setSummary(CharSequence charSequence) {
        if ((charSequence == null && this.mSummary != null) || (charSequence != null && !charSequence.equals(this.mSummary))) {
            this.mSummary = charSequence;
            notifyChanged();
        }
    }

    public void setTitle(int i) {
        setTitle(this.mContext.getString(i));
        this.mTitleRes = i;
    }

    public void setTitle(CharSequence charSequence) {
        if ((charSequence == null && this.mTitle != null) || (charSequence != null && !charSequence.equals(this.mTitle))) {
            this.mTitleRes = 0;
            this.mTitle = charSequence;
            notifyChanged();
        }
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void setWidgetLayoutResource(int i) {
        if (i != this.mWidgetLayoutResId) {
            this.mHasSpecifiedLayout = true;
        }
        this.mWidgetLayoutResId = i;
    }

    public boolean shouldCommit() {
        return this.mPreferenceManager == null ? false : this.mPreferenceManager.shouldCommit();
    }

    public boolean shouldDisableDependents() {
        return !isEnabled();
    }

    protected boolean shouldPersist() {
        return this.mPreferenceManager != null && isPersistent() && hasKey();
    }

    public String toString() {
        return getFilterableStringBuilder().toString();
    }
}
