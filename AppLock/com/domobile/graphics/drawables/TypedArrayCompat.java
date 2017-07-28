package com.domobile.graphics.drawables;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

class TypedArrayCompat {
    private static final ITypedArray IMPL;
    private static final int[] TEMP_ARRAY = new int[1];

    interface ITypedArray {
        int getChangingConfigurations(TypedArray typedArray);
    }

    static class BaseTypedArray implements ITypedArray {
        BaseTypedArray() {
        }

        public int getChangingConfigurations(TypedArray typedArray) {
            return 0;
        }
    }

    @TargetApi(21)
    static class TypedArrayLollipop extends BaseTypedArray {
        TypedArrayLollipop() {
        }

        public int getChangingConfigurations(TypedArray typedArray) {
            return typedArray.getChangingConfigurations();
        }
    }

    static {
        if (Android.isLollipop()) {
            IMPL = new TypedArrayLollipop();
        } else {
            IMPL = new BaseTypedArray();
        }
    }

    TypedArrayCompat() {
    }

    public static TypedValue[] extractThemeAttrs(TypedArray typedArray) {
        int length = typedArray.length();
        TypedValue[] typedValueArr = null;
        for (int i = 0; i < length; i++) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (!(peekValue == null || peekValue.type != 2 || peekValue.data == 0)) {
                if (typedValueArr == null) {
                    typedValueArr = new TypedValue[length];
                }
                typedValueArr[i] = peekValue;
            }
        }
        return typedValueArr;
    }

    public static int getChangingConfigurations(TypedArray typedArray) {
        return IMPL.getChangingConfigurations(typedArray);
    }

    public static ColorStateList getColorStateList(Theme theme, TypedArray typedArray, TypedValue[] typedValueArr, int i) {
        if (!(typedValueArr == null || theme == null)) {
            TypedValue typedValue = typedValueArr[i];
            if (typedValue.type == 2) {
                TEMP_ARRAY[0] = typedValue.data;
                TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(null, TEMP_ARRAY, 0, 0);
                try {
                    ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
                    return colorStateList;
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        }
        return typedArray != null ? typedArray.getColorStateList(i) : null;
    }

    public static int getDimensionPixelOffset(Theme theme, TypedArray typedArray, TypedValue[] typedValueArr, int i, int i2) {
        if (!(typedValueArr == null || theme == null)) {
            TypedValue typedValue = typedValueArr[i];
            if (typedValue.type == 2) {
                TEMP_ARRAY[0] = typedValue.data;
                TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(null, TEMP_ARRAY, 0, 0);
                try {
                    i2 = obtainStyledAttributes.getDimensionPixelOffset(0, i2);
                    return i2;
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        }
        return typedArray != null ? typedArray.getDimensionPixelOffset(i, i2) : i2;
    }

    public static Drawable getDrawable(Theme theme, TypedArray typedArray, TypedValue[] typedValueArr, int i) {
        if (!(typedValueArr == null || theme == null)) {
            TypedValue typedValue = typedValueArr[i];
            if (typedValue.type == 2) {
                TEMP_ARRAY[0] = typedValue.data;
                TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(null, TEMP_ARRAY, 0, 0);
                try {
                    Drawable drawable = obtainStyledAttributes.getDrawable(0);
                    return drawable;
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        }
        return typedArray != null ? LollipopDrawablesCompat.getDrawable(typedArray, i, theme) : null;
    }

    public static int getResourceId(Theme theme, TypedArray typedArray, TypedValue[] typedValueArr, int i, int i2) {
        if (!(typedValueArr == null || theme == null)) {
            TypedValue typedValue = typedValueArr[i];
            if (typedValue.type == 2) {
                TEMP_ARRAY[0] = typedValue.data;
                TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(null, TEMP_ARRAY, 0, 0);
                try {
                    i2 = obtainStyledAttributes.getResourceId(0, i2);
                    return i2;
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        }
        return typedArray != null ? typedArray.getResourceId(i, i2) : i2;
    }
}
