package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.fo.C2864a;

public class fp {
    private static fp f8931b;
    private DynamiteModule f8932a;

    public static class C2866a extends Exception {
        private C2866a(Throwable th) {
            super(th);
        }
    }

    private fp() {
    }

    public static fp m10794a() {
        fp fpVar;
        synchronized (fp.class) {
            if (f8931b != null) {
                fpVar = f8931b;
            } else {
                f8931b = new fp();
                fpVar = f8931b;
            }
        }
        return fpVar;
    }

    public void m10795a(Context context) {
        synchronized (fp.class) {
            if (this.f8932a != null) {
                return;
            }
            try {
                this.f8932a = DynamiteModule.m8341a(context, DynamiteModule.f7576c, "com.google.android.gms.crash");
            } catch (Throwable e) {
                throw new C2866a(e);
            }
        }
    }

    public fo m10796b() {
        C2513c.m7932a(this.f8932a);
        try {
            return C2864a.m10793a(this.f8932a.m8353a("com.google.firebase.crash.internal.api.FirebaseCrashApiImpl"));
        } catch (Throwable e) {
            throw new C2866a(e);
        }
    }
}
