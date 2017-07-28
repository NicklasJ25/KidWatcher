package com.domobile.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.domobile.p015b.C1168b.C1167k;
import com.domobile.preference.GenericInflater.Parent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class PreferenceGroup extends Preference implements Parent<Preference> {
    private boolean mAttachedToActivity;
    private int mCurrentPreferenceOrder;
    private boolean mOrderingAsAdded;
    private List<Preference> mPreferenceList;

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOrderingAsAdded = true;
        this.mCurrentPreferenceOrder = 0;
        this.mAttachedToActivity = false;
        this.mPreferenceList = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1167k.MyPreferenceGroup, i, 0);
        this.mOrderingAsAdded = obtainStyledAttributes.getBoolean(C1167k.MyPreferenceGroup_android_orderingFromXml, this.mOrderingAsAdded);
        obtainStyledAttributes.recycle();
    }

    private boolean removePreferenceInt(Preference preference) {
        boolean remove;
        synchronized (this) {
            preference.onPrepareForRemoval();
            remove = this.mPreferenceList.remove(preference);
        }
        return remove;
    }

    public void addItemFromInflater(Preference preference) {
        addPreference(preference);
    }

    public boolean addPreference(Preference preference) {
        if (this.mPreferenceList.contains(preference)) {
            return true;
        }
        int i;
        if (preference.getOrder() == Integer.MAX_VALUE) {
            if (this.mOrderingAsAdded) {
                i = this.mCurrentPreferenceOrder;
                this.mCurrentPreferenceOrder = i + 1;
                preference.setOrder(i);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).setOrderingAsAdded(this.mOrderingAsAdded);
            }
        }
        i = Collections.binarySearch(this.mPreferenceList, preference);
        if (i < 0) {
            i = (i * -1) - 1;
        }
        if (!onPrepareAddPreference(preference)) {
            return false;
        }
        synchronized (this) {
            this.mPreferenceList.add(i, preference);
        }
        preference.onAttachedToHierarchy(getPreferenceManager());
        if (this.mAttachedToActivity) {
            preference.onAttachedToActivity();
        }
        notifyHierarchyChanged();
        return true;
    }

    protected void dispatchRestoreInstanceState(Bundle bundle) {
        super.dispatchRestoreInstanceState(bundle);
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).dispatchRestoreInstanceState(bundle);
        }
    }

    protected void dispatchSaveInstanceState(Bundle bundle) {
        super.dispatchSaveInstanceState(bundle);
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).dispatchSaveInstanceState(bundle);
        }
    }

    public Preference findPreference(CharSequence charSequence) {
        if (TextUtils.equals(getKey(), charSequence)) {
            return this;
        }
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            Preference preference = getPreference(i);
            String key = preference.getKey();
            if (key != null && key.equals(charSequence)) {
                return preference;
            }
            if (preference instanceof PreferenceGroup) {
                preference = ((PreferenceGroup) preference).findPreference(charSequence);
                if (preference != null) {
                    return preference;
                }
            }
        }
        return null;
    }

    public Preference getPreference(int i) {
        return (Preference) this.mPreferenceList.get(i);
    }

    public int getPreferenceCount() {
        return this.mPreferenceList.size();
    }

    protected boolean isOnSameScreenAsChildren() {
        return true;
    }

    public boolean isOrderingAsAdded() {
        return this.mOrderingAsAdded;
    }

    protected void onAttachedToActivity() {
        super.onAttachedToActivity();
        this.mAttachedToActivity = true;
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).onAttachedToActivity();
        }
    }

    protected boolean onPrepareAddPreference(Preference preference) {
        if (!super.isEnabled()) {
            preference.setEnabled(false);
        }
        return true;
    }

    protected void onPrepareForRemoval() {
        super.onPrepareForRemoval();
        this.mAttachedToActivity = false;
    }

    public void removeAll() {
        synchronized (this) {
            List list = this.mPreferenceList;
            for (int size = list.size() - 1; size >= 0; size--) {
                removePreferenceInt((Preference) list.get(0));
            }
        }
        notifyHierarchyChanged();
    }

    public boolean removePreference(Preference preference) {
        boolean removePreferenceInt = removePreferenceInt(preference);
        notifyHierarchyChanged();
        return removePreferenceInt;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).setEnabled(z);
        }
    }

    public void setOrderingAsAdded(boolean z) {
        this.mOrderingAsAdded = z;
    }

    void sortPreferences() {
        synchronized (this) {
            Collections.sort(this.mPreferenceList);
        }
    }
}
