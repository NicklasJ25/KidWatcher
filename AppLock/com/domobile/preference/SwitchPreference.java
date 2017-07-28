package com.domobile.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.domobile.p015b.C1168b.C1163g;
import com.domobile.p015b.C1168b.C1166j;

public class SwitchPreference extends CheckBoxPreference {
    public SwitchPreference(Context context) {
        this(context, null);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1166j.CheckBoxPreferenceStyle);
        setWidgetLayoutResource(C1163g.preference_widget_switch);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
