package com.google.android.exoplayer2.p043j;

import android.annotation.TargetApi;
import android.os.Trace;

public final class C2271q {
    public static void m7120a() {
        if (C2273r.f6478a >= 18) {
            C2271q.m7122b();
        }
    }

    public static void m7121a(String str) {
        if (C2273r.f6478a >= 18) {
            C2271q.m7123b(str);
        }
    }

    @TargetApi(18)
    private static void m7122b() {
        Trace.endSection();
    }

    @TargetApi(18)
    private static void m7123b(String str) {
        Trace.beginSection(str);
    }
}
