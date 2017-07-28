package com.facebook.ads.internal.p021b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.p022h.C1599g;
import com.facebook.ads.internal.p034k.C1671a;
import com.facebook.ads.internal.view.C1748a;
import java.util.Map;

public class C1535v extends C1491f {
    private static final String f3697c = C1535v.class.getSimpleName();
    private final C1748a f3698d;
    private final Context f3699e;
    private C1533u f3700f;
    private boolean f3701g;

    class C15341 implements Runnable {
        final /* synthetic */ C1535v f3696a;

        C15341(C1535v c1535v) {
            this.f3696a = c1535v;
        }

        public void run() {
            if (this.f3696a.f3698d.m5018e()) {
                Log.w(C1535v.f3697c, "Webview already destroyed, cannot activate");
            } else {
                this.f3696a.f3698d.loadUrl("javascript:" + this.f3696a.f3700f.m4172b());
            }
        }
    }

    public C1535v(Context context, C1748a c1748a, C1671a c1671a, C1495h c1495h) {
        super(context, c1495h, c1671a);
        this.f3699e = context.getApplicationContext();
        this.f3698d = c1748a;
    }

    public void m4183a(C1533u c1533u) {
        this.f3700f = c1533u;
    }

    protected void mo2671a(Map<String, String> map) {
        if (this.f3700f != null && !TextUtils.isEmpty(this.f3700f.mo2704y())) {
            C1599g.m4464a(this.f3699e).mo2739a(this.f3700f.mo2704y(), (Map) map);
        }
    }

    public synchronized void m4185b() {
        if (!(this.f3701g || this.f3700f == null)) {
            this.f3701g = true;
            if (!(this.f3698d == null || TextUtils.isEmpty(this.f3700f.m4172b()))) {
                this.f3698d.post(new C15341(this));
            }
        }
    }
}
