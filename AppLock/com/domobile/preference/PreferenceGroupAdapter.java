package com.domobile.preference;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.domobile.p015b.C1168b.C1162f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PreferenceGroupAdapter extends BaseAdapter implements OnPreferenceChangeInternalListener {
    private static final String TAG = "PreferenceGroupAdapter";
    private Handler mHandler = new Handler();
    private boolean mHasReturnedViewTypeCount = false;
    private volatile boolean mIsSyncing = false;
    private PreferenceGroup mPreferenceGroup;
    private ArrayList<PreferenceLayout> mPreferenceLayouts;
    private List<Preference> mPreferenceList;
    private Runnable mSyncRunnable = new C13951();
    private PreferenceLayout mTempPreferenceLayout = new PreferenceLayout();

    class C13951 implements Runnable {
        C13951() {
        }

        public void run() {
            PreferenceGroupAdapter.this.syncMyPreferences();
        }
    }

    private static class PreferenceLayout implements Comparable<PreferenceLayout> {
        private String name;
        private int resId;
        private int widgetResId;

        private PreferenceLayout() {
        }

        public int compareTo(PreferenceLayout preferenceLayout) {
            int compareTo = this.name.compareTo(preferenceLayout.name);
            return compareTo == 0 ? this.resId == preferenceLayout.resId ? this.widgetResId == preferenceLayout.widgetResId ? 0 : this.widgetResId - preferenceLayout.widgetResId : this.resId - preferenceLayout.resId : compareTo;
        }
    }

    public PreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        this.mPreferenceGroup = preferenceGroup;
        this.mPreferenceGroup.setOnPreferenceChangeInternalListener(this);
        this.mPreferenceList = new ArrayList();
        this.mPreferenceLayouts = new ArrayList();
        syncMyPreferences();
    }

    private void addPreferenceClassName(Preference preference) {
        PreferenceLayout createPreferenceLayout = createPreferenceLayout(preference, null);
        int binarySearch = Collections.binarySearch(this.mPreferenceLayouts, createPreferenceLayout);
        if (binarySearch < 0) {
            this.mPreferenceLayouts.add((binarySearch * -1) - 1, createPreferenceLayout);
        }
    }

    private PreferenceLayout createPreferenceLayout(Preference preference, PreferenceLayout preferenceLayout) {
        if (preferenceLayout == null) {
            preferenceLayout = new PreferenceLayout();
        }
        preferenceLayout.name = preference.getClass().getName();
        preferenceLayout.resId = preference.getLayoutResource();
        preferenceLayout.widgetResId = preference.getWidgetLayoutResource();
        return preferenceLayout;
    }

    private void flattenPreferenceGroup(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.sortPreferences();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            Preference preference = preferenceGroup.getPreference(i);
            list.add(preference);
            if (!(this.mHasReturnedViewTypeCount || preference.hasSpecifiedLayout())) {
                addPreferenceClassName(preference);
            }
            if (preference instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                if (preferenceGroup2.isOnSameScreenAsChildren()) {
                    flattenPreferenceGroup(list, preferenceGroup2);
                }
            }
            preference.setOnPreferenceChangeInternalListener(this);
        }
    }

    private void syncMyPreferences() {
        synchronized (this) {
            if (this.mIsSyncing) {
                return;
            }
            this.mIsSyncing = true;
            List arrayList = new ArrayList(this.mPreferenceList.size());
            flattenPreferenceGroup(arrayList, this.mPreferenceGroup);
            this.mPreferenceList = arrayList;
            notifyDataSetChanged();
            synchronized (this) {
                this.mIsSyncing = false;
                notifyAll();
            }
        }
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public int getCount() {
        return this.mPreferenceList.size();
    }

    public Preference getItem(int i) {
        return (i < 0 || i >= getCount()) ? null : (Preference) this.mPreferenceList.get(i);
    }

    public long getItemId(int i) {
        return (i < 0 || i >= getCount()) ? Long.MIN_VALUE : getItem(i).getId();
    }

    public int getItemViewType(int i) {
        if (!this.mHasReturnedViewTypeCount) {
            this.mHasReturnedViewTypeCount = true;
        }
        Preference item = getItem(i);
        if (item.hasSpecifiedLayout()) {
            return -1;
        }
        this.mTempPreferenceLayout = createPreferenceLayout(item, this.mTempPreferenceLayout);
        int binarySearch = Collections.binarySearch(this.mPreferenceLayouts, this.mTempPreferenceLayout);
        return binarySearch >= 0 ? binarySearch : -1;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Preference item = getItem(i);
        this.mTempPreferenceLayout = createPreferenceLayout(item, this.mTempPreferenceLayout);
        if (Collections.binarySearch(this.mPreferenceLayouts, this.mTempPreferenceLayout) < 0) {
            view = null;
        }
        View view2 = item.getView(view, viewGroup);
        View findViewById = view2.findViewById(C1162f.list_item_group_margin);
        if (findViewById != null) {
            if (i == 0) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
        }
        findViewById = view2.findViewById(C1162f.divider);
        if (findViewById != null) {
            if (i >= getCount() - 1) {
                findViewById.setVisibility(8);
            } else if (getItem(i + 1) instanceof PreferenceCategory) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
        }
        findViewById = view2.findViewById(16908334);
        if (findViewById != null) {
            if (i == getCount() - 1) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
        }
        item.setView(view2);
        return view2;
    }

    public int getViewTypeCount() {
        if (!this.mHasReturnedViewTypeCount) {
            this.mHasReturnedViewTypeCount = true;
        }
        return Math.max(1, this.mPreferenceLayouts.size());
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isEnabled(int i) {
        return (i < 0 || i >= getCount()) ? true : getItem(i).isSelectable();
    }

    public void onPreferenceChange(Preference preference) {
        if (preference instanceof CheckBoxPreference) {
            ((CheckBoxPreference) preference).onBindView(preference.getView());
        } else {
            notifyDataSetChanged();
        }
    }

    public void onPreferenceHierarchyChange(Preference preference) {
        this.mHandler.removeCallbacks(this.mSyncRunnable);
        this.mHandler.post(this.mSyncRunnable);
    }
}
