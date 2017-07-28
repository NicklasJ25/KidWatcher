package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.C2456a;
import com.google.android.gms.common.api.C2456a.C2416a.C2417a;
import com.google.android.gms.common.api.C2456a.C2448b;
import com.google.android.gms.common.api.C2456a.C2452g;
import com.google.android.gms.common.api.C2461c.C2459b;
import com.google.android.gms.common.api.C2461c.C2460c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C2539m;

public final class el {
    public static final C2452g<eu> f8835a = new C2452g();
    public static final C2452g<eu> f8836b = new C2452g();
    public static final C2448b<eu, en> f8837c = new C28481();
    static final C2448b<eu, C2850a> f8838d = new C28492();
    public static final Scope f8839e = new Scope("profile");
    public static final Scope f8840f = new Scope("email");
    public static final C2456a<en> f8841g = new C2456a("SignIn.API", f8837c, f8835a);
    public static final C2456a<C2850a> f8842h = new C2456a("SignIn.INTERNAL_API", f8838d, f8836b);

    class C28481 extends C2448b<eu, en> {
        C28481() {
        }

        public eu m10625a(Context context, Looper looper, C2539m c2539m, en enVar, C2459b c2459b, C2460c c2460c) {
            return new eu(context, looper, true, c2539m, enVar == null ? en.f8843a : enVar, c2459b, c2460c);
        }
    }

    class C28492 extends C2448b<eu, C2850a> {
        C28492() {
        }

        public eu m10627a(Context context, Looper looper, C2539m c2539m, C2850a c2850a, C2459b c2459b, C2460c c2460c) {
            return new eu(context, looper, false, c2539m, c2850a.m10628a(), c2459b, c2460c);
        }
    }

    public static class C2850a implements C2417a {
        private final Bundle f8834a;

        public Bundle m10628a() {
            return this.f8834a;
        }
    }
}
