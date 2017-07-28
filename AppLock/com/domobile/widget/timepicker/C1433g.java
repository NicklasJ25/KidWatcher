package com.domobile.widget.timepicker;

import android.content.Context;
import com.domobile.eframe.C1224e;
import java.util.Calendar;
import java.util.Locale;

public class C1433g {
    private static String[] f3292a = null;

    public static String[] m3657a(Context context) {
        if (f3292a == null) {
            String[] strArr = new String[7];
            Locale a = C1224e.m2873a(context);
            Calendar instance = Calendar.getInstance();
            for (int i = 0; i < 7; i++) {
                instance.set(7, i + 1);
                strArr[i] = instance.getDisplayName(7, 1, a);
            }
            f3292a = strArr;
        }
        return f3292a;
    }
}
