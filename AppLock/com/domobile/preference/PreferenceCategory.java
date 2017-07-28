package com.domobile.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.domobile.p015b.C1168b.C1163g;

public class PreferenceCategory extends PreferenceGroup {
    private static final String TAG = "PreferenceCategory";

    public PreferenceCategory(Context context) {
        this(context, null);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842892);
        setLayoutResource(C1163g.preference_category);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean isEnabled() {
        return false;
    }

    protected boolean onPrepareAddPreference(Preference preference) {
        if (!(preference instanceof PreferenceCategory)) {
            return super.onPrepareAddPreference(preference);
        }
        throw new IllegalArgumentException("Cannot add a PreferenceCategory directly to a PreferenceCategory");
    }
}
