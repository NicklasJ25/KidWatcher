package com.domobile.graphics.drawables;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

class AnimatorsCompat {
    static List<WeakReference<ObjectAnimator>> sRunningAnimators = new ArrayList();

    AnimatorsCompat() {
    }

    private static boolean hasSameTargetAndProperties(ObjectAnimator objectAnimator, @Nullable Animator animator) {
        if (animator instanceof ObjectAnimator) {
            PropertyValuesHolder[] values = ((ObjectAnimator) animator).getValues();
            PropertyValuesHolder[] values2 = objectAnimator.getValues();
            if (((ObjectAnimator) animator).getTarget() == objectAnimator.getTarget() && values2.length == values.length) {
                int length = values2.length;
                for (int i = 0; i < length; i++) {
                    PropertyValuesHolder propertyValuesHolder = values2[i];
                    PropertyValuesHolder propertyValuesHolder2 = values[i];
                    if (propertyValuesHolder.getPropertyName() == null || !propertyValuesHolder.getPropertyName().equals(propertyValuesHolder2.getPropertyName())) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void start(ObjectAnimator objectAnimator) {
        sRunningAnimators.add(new WeakReference(objectAnimator));
        objectAnimator.start();
    }

    public static void startWithAutoCancel(ObjectAnimator objectAnimator) {
        for (WeakReference weakReference : sRunningAnimators) {
            ObjectAnimator objectAnimator2 = (ObjectAnimator) weakReference.get();
            if (objectAnimator2 != null && hasSameTargetAndProperties(objectAnimator, objectAnimator2)) {
                objectAnimator2.cancel();
            }
        }
        start(objectAnimator);
    }
}
