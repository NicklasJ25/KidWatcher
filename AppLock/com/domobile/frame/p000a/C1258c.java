package com.domobile.frame.p000a;

import android.util.Log;
import com.domobile.p015b.C1156a;

public class C1258c {
    public static final boolean f2573a = C1156a.f2253a;

    public static void m2986a(Object... objArr) {
        if (f2573a && objArr != null) {
            Log.i("eLock", C1147a.m2480a(objArr));
        }
    }

    public static void m2987b(Object... objArr) {
        if (f2573a && objArr != null) {
            Log.e("eLock", C1147a.m2480a(objArr));
        }
    }
}
