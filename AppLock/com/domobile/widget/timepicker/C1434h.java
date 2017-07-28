package com.domobile.widget.timepicker;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import com.domobile.libs_ads.C1348d;

public class C1434h {
    public static ObjectAnimator m3658a(View view, float f, float f2) {
        if (!C1348d.Q) {
            return null;
        }
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 1.0f);
        Keyframe ofFloat2 = Keyframe.ofFloat(0.275f, f);
        Keyframe ofFloat3 = Keyframe.ofFloat(0.69f, f2);
        Keyframe ofFloat4 = Keyframe.ofFloat(1.0f, 1.0f);
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe("scaleX", new Keyframe[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
        PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe("scaleY", new Keyframe[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofKeyframe, ofKeyframe2});
        ofPropertyValuesHolder.setDuration(544);
        return ofPropertyValuesHolder;
    }

    @SuppressLint({"NewApi"})
    public static void m3659a(View view, CharSequence charSequence) {
        if (C1434h.m3660a() && view != null && charSequence != null) {
            view.announceForAccessibility(charSequence);
        }
    }

    public static boolean m3660a() {
        return VERSION.SDK_INT >= 16;
    }
}
