package com.google.firebase.database;

import android.text.TextUtils;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hh;
import com.google.android.gms.internal.hj;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.lg;
import com.google.android.gms.internal.lh;
import com.google.firebase.C3531b;
import java.util.HashMap;
import java.util.Map;

public class C3576f {
    private static final Map<String, Map<hk, C3576f>> f12195a = new HashMap();
    private final C3531b f12196b;
    private final hk f12197c;
    private final hb f12198d;
    private hj f12199e;

    private C3576f(C3531b c3531b, hk hkVar, hb hbVar) {
        this.f12196b = c3531b;
        this.f12197c = hkVar;
        this.f12198d = hbVar;
    }

    public static C3576f m15583a() {
        C3531b d = C3531b.m15427d();
        if (d != null) {
            return C3576f.m15584a(d, d.m15436c().m15451c());
        }
        throw new C3537c("You must call FirebaseApp.initialize() first.");
    }

    public static synchronized C3576f m15584a(C3531b c3531b, String str) {
        C3576f c3576f;
        synchronized (C3576f.class) {
            if (TextUtils.isEmpty(str)) {
                throw new C3537c("Failed to get FirebaseDatabase instance: Specify DatabaseURL within FirebaseApp or from your getInstance() call.");
            }
            Map map;
            Map map2 = (Map) f12195a.get(c3531b.m15435b());
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                f12195a.put(c3531b.m15435b(), hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            lg a = lh.m12293a(str);
            if (a.f9702b.m11391h()) {
                c3576f = (C3576f) map.get(a.f9701a);
                if (c3576f == null) {
                    hb hbVar = new hb();
                    if (!c3531b.m15437e()) {
                        hbVar.mo3700c(c3531b.m15435b());
                    }
                    hbVar.m11330a(c3531b);
                    c3576f = new C3576f(c3531b, a.f9701a, hbVar);
                    map.put(a.f9701a, c3576f);
                }
            } else {
                String valueOf = String.valueOf(a.f9702b.toString());
                throw new C3537c(new StringBuilder((String.valueOf(str).length() + 113) + String.valueOf(valueOf).length()).append("Specified Database URL '").append(str).append("' is invalid. It should point to the root of a Firebase Database but it includes a path: ").append(valueOf).toString());
            }
        }
        return c3576f;
    }

    private void m15585a(String str) {
        if (this.f12199e != null) {
            throw new C3537c(new StringBuilder(String.valueOf(str).length() + 77).append("Calls to ").append(str).append("() must be made before any other usage of FirebaseDatabase instance.").toString());
        }
    }

    public static String m15586c() {
        return "3.0.0";
    }

    private synchronized void m15587d() {
        if (this.f12199e == null) {
            this.f12199e = hl.m11483a(this.f12198d, this.f12197c, this);
        }
    }

    public synchronized void m15588a(boolean z) {
        m15585a("setPersistenceEnabled");
        this.f12198d.m11331a(z);
    }

    public C3574d m15589b() {
        m15587d();
        return new C3574d(this.f12199e, hh.m11376a());
    }
}
