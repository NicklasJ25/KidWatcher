package com.facebook.ads.internal.p021b;

import android.content.Context;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p034k.C1671a;
import java.util.HashMap;
import java.util.Map;

public abstract class C1491f {
    protected final C1495h f3478a;
    protected final C1671a f3479b;
    private final Context f3480c;
    private boolean f3481d;

    public C1491f(Context context, C1495h c1495h, C1671a c1671a) {
        this.f3480c = context;
        this.f3478a = c1495h;
        this.f3479b = c1671a;
    }

    public final void m3876a() {
        if (!this.f3481d) {
            if (this.f3478a != null) {
                this.f3478a.mo2707d();
            }
            Map hashMap = new HashMap();
            if (this.f3479b != null) {
                this.f3479b.m4760a(hashMap);
            }
            mo2671a(hashMap);
            this.f3481d = true;
            C1729s.m4971a(this.f3480c, "Impression logged");
            if (this.f3478a != null) {
                this.f3478a.mo2843e();
            }
        }
    }

    protected abstract void mo2671a(Map<String, String> map);
}
