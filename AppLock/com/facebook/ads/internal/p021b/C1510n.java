package com.facebook.ads.internal.p021b;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.C1460d;
import com.facebook.ads.C1463g;
import com.facebook.ads.internal.p018m.C1722n;
import com.facebook.ads.internal.p018m.C1722n.C1720a;
import com.facebook.ads.internal.p018m.C1723o;
import com.facebook.ads.internal.p018m.C1727r;
import com.facebook.ads.internal.p018m.C1727r.C1526a;
import com.facebook.ads.internal.p018m.C1730t;
import com.facebook.ads.internal.p020a.C1468a;
import com.facebook.ads.internal.p020a.C1469b;
import com.facebook.ads.internal.p028g.C1577e;
import com.facebook.ads.internal.view.C1756b;
import com.facebook.ads.internal.view.C1756b.C1447b;
import java.util.Map;
import org.json.JSONObject;

public class C1510n extends C1492b {
    private static final String f3548a = C1510n.class.getSimpleName();
    private C1756b f3549b;
    private C1535v f3550c;
    private C1475c f3551d;
    private Map<String, Object> f3552e;
    private Context f3553f;
    private long f3554g;
    private C1720a f3555h;

    class C15092 extends C1495h {
        final /* synthetic */ C1510n f3547a;

        C15092(C1510n c1510n) {
            this.f3547a = c1510n;
        }

        public void mo2707d() {
            if (this.f3547a.f3551d != null) {
                this.f3547a.f3551d.mo2651a(this.f3547a);
            }
        }
    }

    private void m3996a(C1577e c1577e) {
        this.f3554g = 0;
        this.f3555h = null;
        final C1533u a = C1533u.m4167a((JSONObject) this.f3552e.get("data"));
        if (C1727r.m4953a(this.f3553f, (C1526a) a)) {
            this.f3551d.mo2653a((C1492b) this, C1460d.f3364b);
            return;
        }
        this.f3549b = new C1756b(this.f3553f, new C1447b(this) {
            final /* synthetic */ C1510n f3546b;

            public void mo2622a() {
                this.f3546b.f3550c.m4185b();
            }

            public void mo2623a(int i) {
                if (i == 0 && this.f3546b.f3554g > 0 && this.f3546b.f3555h != null) {
                    C1723o.m4943a(C1722n.m4938a(this.f3546b.f3554g, this.f3546b.f3555h, a.m4174d()));
                    this.f3546b.f3554g = 0;
                    this.f3546b.f3555h = null;
                }
            }

            public void mo2624a(String str, Map<String, String> map) {
                Uri parse = Uri.parse(str);
                if ("fbad".equals(parse.getScheme()) && C1469b.m3802a(parse.getAuthority()) && this.f3546b.f3551d != null) {
                    this.f3546b.f3551d.mo2654b(this.f3546b);
                }
                C1468a a = C1469b.m3801a(this.f3546b.f3553f, a.mo2704y(), parse, map);
                if (a != null) {
                    try {
                        this.f3546b.f3555h = a.mo2641a();
                        this.f3546b.f3554g = System.currentTimeMillis();
                        a.mo2642b();
                    } catch (Throwable e) {
                        Log.e(C1510n.f3548a, "Error executing action", e);
                    }
                }
            }

            public void mo2625b() {
                if (this.f3546b.f3550c != null) {
                    this.f3546b.f3550c.m3876a();
                }
            }
        }, c1577e.m4392e());
        this.f3549b.m5039a(c1577e.m4394g(), c1577e.m4395h());
        this.f3550c = new C1535v(this.f3553f, this.f3549b, this.f3549b.getViewabilityChecker(), new C15092(this));
        this.f3550c.m4183a(a);
        this.f3549b.loadDataWithBaseURL(C1730t.m4977a(), a.m4170a(), "text/html", "utf-8", null);
        if (this.f3551d != null) {
            this.f3551d.mo2652a((C1492b) this, this.f3549b);
        }
    }

    public void mo2708a(Context context, C1463g c1463g, C1475c c1475c, Map<String, Object> map) {
        this.f3553f = context;
        this.f3551d = c1475c;
        this.f3552e = map;
        m3996a((C1577e) map.get("definition"));
    }

    public void mo2680b() {
        if (this.f3549b != null) {
            C1730t.m4978a(this.f3549b);
            this.f3549b.destroy();
            this.f3549b = null;
        }
    }
}
