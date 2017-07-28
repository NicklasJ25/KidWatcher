package com.facebook.ads.internal.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.p018m.C1722n;
import com.facebook.ads.internal.p018m.C1722n.C1720a;
import com.facebook.ads.internal.p018m.C1723o;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p018m.C1730t;
import com.facebook.ads.internal.p020a.C1468a;
import com.facebook.ads.internal.p020a.C1469b;
import com.facebook.ads.internal.p021b.C1495h;
import com.facebook.ads.internal.p021b.C1533u;
import com.facebook.ads.internal.p021b.C1535v;
import com.facebook.ads.internal.p022h.C1599g;
import com.facebook.ads.internal.view.C1523c.C1436a;
import com.facebook.ads.internal.view.C1756b.C1447b;
import java.util.HashMap;
import java.util.Map;

public class C1857g implements C1523c {
    private static final String f4658a = C1857g.class.getSimpleName();
    private final C1436a f4659b;
    private final C1756b f4660c;
    private final C1535v f4661d;
    private C1533u f4662e;
    private long f4663f = System.currentTimeMillis();
    private long f4664g;
    private C1720a f4665h;

    class C18562 extends C1495h {
        final /* synthetic */ C1857g f4657a;

        C18562(C1857g c1857g) {
            this.f4657a = c1857g;
        }

        public void mo2707d() {
            this.f4657a.f4659b.mo2617a("com.facebook.ads.interstitial.impression.logged");
        }
    }

    public C1857g(final AudienceNetworkActivity audienceNetworkActivity, C1436a c1436a) {
        this.f4659b = c1436a;
        this.f4660c = new C1756b(audienceNetworkActivity, new C1447b(this) {
            final /* synthetic */ C1857g f4656b;

            public void mo2622a() {
                this.f4656b.f4661d.m4185b();
            }

            public void mo2623a(int i) {
            }

            public void mo2624a(String str, Map<String, String> map) {
                Uri parse = Uri.parse(str);
                if ("fbad".equals(parse.getScheme()) && "close".equals(parse.getAuthority())) {
                    audienceNetworkActivity.finish();
                    return;
                }
                if ("fbad".equals(parse.getScheme()) && C1469b.m3802a(parse.getAuthority())) {
                    this.f4656b.f4659b.mo2617a("com.facebook.ads.interstitial.clicked");
                }
                C1468a a = C1469b.m3801a(audienceNetworkActivity, this.f4656b.f4662e.mo2704y(), parse, map);
                if (a != null) {
                    try {
                        this.f4656b.f4665h = a.mo2641a();
                        this.f4656b.f4664g = System.currentTimeMillis();
                        a.mo2642b();
                    } catch (Throwable e) {
                        Log.e(C1857g.f4658a, "Error executing action", e);
                    }
                }
            }

            public void mo2625b() {
                this.f4656b.f4661d.m3876a();
            }
        }, 1);
        this.f4660c.setLayoutParams(new LayoutParams(-1, -1));
        this.f4661d = new C1535v(audienceNetworkActivity, this.f4660c, this.f4660c.getViewabilityChecker(), new C18562(this));
        c1436a.mo2616a(this.f4660c);
    }

    public void mo2715a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        if (bundle == null || !bundle.containsKey("dataModel")) {
            this.f4662e = C1533u.m4168b(intent);
            if (this.f4662e != null) {
                this.f4661d.m4183a(this.f4662e);
                this.f4660c.loadDataWithBaseURL(C1730t.m4977a(), this.f4662e.m4170a(), "text/html", "utf-8", null);
                this.f4660c.m5039a(this.f4662e.m4175e(), this.f4662e.m4176f());
                return;
            }
            return;
        }
        this.f4662e = C1533u.m4166a(bundle.getBundle("dataModel"));
        if (this.f4662e != null) {
            this.f4660c.loadDataWithBaseURL(C1730t.m4977a(), this.f4662e.m4170a(), "text/html", "utf-8", null);
            this.f4660c.m5039a(this.f4662e.m4175e(), this.f4662e.m4176f());
        }
    }

    public void mo2716a(Bundle bundle) {
        if (this.f4662e != null) {
            bundle.putBundle("dataModel", this.f4662e.m4177g());
        }
    }

    public void mo2717a(C1436a c1436a) {
    }

    public void mo2680b() {
        if (this.f4662e != null) {
            C1723o.m4943a(C1722n.m4938a(this.f4663f, C1720a.XOUT, this.f4662e.m4174d()));
            if (!TextUtils.isEmpty(this.f4662e.mo2704y())) {
                Map hashMap = new HashMap();
                this.f4660c.getViewabilityChecker().m4760a(hashMap);
                hashMap.put("touch", C1729s.m4963a(this.f4660c.getTouchData()));
                C1599g.m4464a(this.f4660c.getContext()).mo2746e(this.f4662e.mo2704y(), hashMap);
            }
        }
        C1730t.m4978a(this.f4660c);
        this.f4660c.destroy();
    }

    public void mo2719i() {
        this.f4660c.onPause();
    }

    public void mo2720j() {
        if (!(this.f4664g <= 0 || this.f4665h == null || this.f4662e == null)) {
            C1723o.m4943a(C1722n.m4938a(this.f4664g, this.f4665h, this.f4662e.m4174d()));
        }
        this.f4660c.onResume();
    }
}
