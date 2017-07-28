package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import com.google.firebase.iid.C3608h.C3607a;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Map;

public class C3599d {
    static Map<String, C3599d> f12247a = new ArrayMap();
    static String f12248e;
    private static C3608h f12249f;
    private static C3605f f12250g;
    Context f12251b;
    KeyPair f12252c;
    String f12253d = "";

    protected C3599d(Context context, String str, Bundle bundle) {
        this.f12251b = context.getApplicationContext();
        this.f12253d = str;
    }

    public static synchronized C3599d m15657a(Context context, Bundle bundle) {
        C3599d c3599d;
        synchronized (C3599d.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (f12249f == null) {
                f12249f = new C3608h(applicationContext);
                f12250g = new C3605f(applicationContext);
            }
            f12248e = Integer.toString(FirebaseInstanceId.m15603a(applicationContext));
            c3599d = (C3599d) f12247a.get(str);
            if (c3599d == null) {
                c3599d = new C3599d(applicationContext, str, bundle);
                f12247a.put(str, c3599d);
            }
        }
        return c3599d;
    }

    KeyPair m15658a() {
        if (this.f12252c == null) {
            this.f12252c = f12249f.m15718d(this.f12253d);
        }
        if (this.f12252c == null) {
            this.f12252c = f12249f.m15711a(this.f12253d);
        }
        return this.f12252c;
    }

    public void m15659a(String str, String str2, Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        f12249f.m15714b(this.f12253d, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("delete", "1");
        m15663c(str, str2, bundle);
    }

    public String m15660b(String str, String str2, Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        Object obj = 1;
        if (bundle.getString("ttl") != null || "jwt".equals(bundle.getString("type"))) {
            obj = null;
        } else {
            C3607a a = f12249f.m15710a(this.f12253d, str, str2);
            if (!(a == null || a.m15704b(f12248e))) {
                return a.f12284a;
            }
        }
        String c = m15663c(str, str2, bundle);
        if (c == null || r0 == null) {
            return c;
        }
        f12249f.m15712a(this.f12253d, str, str2, c, f12248e);
        return c;
    }

    public void m15661b() {
        f12249f.m15713b(this.f12253d);
        this.f12252c = null;
    }

    public C3608h m15662c() {
        return f12249f;
    }

    public String m15663c(String str, String str2, Bundle bundle) {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        if (!"".equals(this.f12253d)) {
            str = this.f12253d;
        }
        bundle.putString("subtype", str);
        bundle.putString("X-subtype", str);
        return f12250g.m15685a(f12250g.m15684a(bundle, m15658a()));
    }

    public C3605f m15664d() {
        return f12250g;
    }
}
