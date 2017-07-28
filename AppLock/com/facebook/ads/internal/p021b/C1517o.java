package com.facebook.ads.internal.p021b;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.C1460d;
import com.facebook.ads.internal.p018m.C1707i;
import com.facebook.ads.internal.p018m.C1708d;
import com.facebook.ads.internal.p022h.C1511s;
import com.facebook.ads.internal.p022h.C1597f;
import com.facebook.ads.internal.view.C1864k;
import com.facebook.ads.internal.view.p035c.p036a.C1757a;
import com.facebook.ads.internal.view.p035c.p036a.C1758b;
import com.facebook.ads.internal.view.p035c.p036a.C1760d;
import com.facebook.ads.internal.view.p035c.p036a.C1768l;
import com.facebook.ads.internal.view.p035c.p039b.C1784m;
import com.facebook.ads.internal.view.p035c.p039b.C1786a;
import com.facebook.ads.internal.view.p035c.p039b.C1791b;
import com.facebook.ads.internal.view.p035c.p039b.C1793c;
import com.facebook.ads.internal.view.p035c.p039b.C1803d;
import com.facebook.ads.internal.view.p035c.p039b.C1803d.C1802a;
import com.facebook.ads.internal.view.p035c.p039b.C1805e;
import com.facebook.ads.internal.view.p035c.p039b.C1817h;
import com.facebook.ads.internal.view.p035c.p039b.C1822j;
import com.facebook.ads.internal.view.p035c.p039b.C1827k;
import com.facebook.ads.p019a.C1452a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class C1517o extends C1516x {
    static final /* synthetic */ boolean f3560d = (!C1517o.class.desiredAssertionStatus());
    @Nullable
    protected C1864k f3561a;
    @Nullable
    protected JSONObject f3562b;
    @Nullable
    protected Context f3563c;
    private final C1511s<C1758b> f3564e = new C15121(this);
    private final C1511s<C1768l> f3565f = new C15132(this);
    private final C1511s<C1760d> f3566g = new C15143(this);
    private final C1511s<C1757a> f3567h = new C15154(this);
    @Nullable
    private C1452a f3568i;
    @Nullable
    private C1597f f3569j;
    @Nullable
    private String f3570k;
    private boolean f3571l = false;
    @Nullable
    private C1707i f3572m;
    @Nullable
    private String f3573n;

    class C15121 extends C1511s<C1758b> {
        final /* synthetic */ C1517o f3556a;

        C15121(C1517o c1517o) {
            this.f3556a = c1517o;
        }

        public Class<C1758b> mo2709a() {
            return C1758b.class;
        }

        public void m4009a(C1758b c1758b) {
            if (this.f3556a.f3568i != null) {
                this.f3556a.f3568i.mo2670d(this.f3556a);
            }
        }
    }

    class C15132 extends C1511s<C1768l> {
        final /* synthetic */ C1517o f3557a;

        C15132(C1517o c1517o) {
            this.f3557a = c1517o;
        }

        public Class<C1768l> mo2709a() {
            return C1768l.class;
        }

        public void m4012a(C1768l c1768l) {
            if (this.f3557a.f3568i != null) {
                this.f3557a.f3571l = true;
                this.f3557a.f3568i.mo2665a(this.f3557a);
            }
        }
    }

    class C15143 extends C1511s<C1760d> {
        final /* synthetic */ C1517o f3558a;

        C15143(C1517o c1517o) {
            this.f3558a = c1517o;
        }

        public Class<C1760d> mo2709a() {
            return C1760d.class;
        }

        public void m4015a(C1760d c1760d) {
            if (this.f3558a.f3568i != null) {
                this.f3558a.f3568i.mo2667a(this.f3558a, C1460d.f3367e);
            }
        }
    }

    class C15154 extends C1511s<C1757a> {
        final /* synthetic */ C1517o f3559a;

        C15154(C1517o c1517o) {
            this.f3559a = c1517o;
        }

        public Class<C1757a> mo2709a() {
            return C1757a.class;
        }

        public void m4018a(C1757a c1757a) {
            if (this.f3559a.f3568i != null) {
                this.f3559a.f3568i.mo2668b(this.f3559a);
            }
            if (this.f3559a.f3569j != null) {
                this.f3559a.f3569j.mo2742b(this.f3559a.f3573n, new HashMap());
            }
        }
    }

    private void m4023a(Context context, C1452a c1452a, JSONObject jSONObject, C1597f c1597f, @Nullable Bundle bundle) {
        this.f3563c = context;
        this.f3568i = c1452a;
        this.f3569j = c1597f;
        this.f3562b = jSONObject;
        this.f3571l = false;
        JSONObject jSONObject2 = jSONObject.getJSONObject("video");
        this.f3573n = jSONObject.optString("ct");
        this.f3570k = jSONObject2.getString("videoURL");
        this.f3561a = new C1864k(context);
        mo2718c();
        this.f3561a.getEventBus().m4513a(this.f3564e);
        this.f3561a.getEventBus().m4513a(this.f3566g);
        this.f3561a.getEventBus().m4513a(this.f3565f);
        this.f3561a.getEventBus().m4513a(this.f3567h);
        if (bundle != null) {
            this.f3572m = new C1708d(context, c1597f, this.f3561a, this.f3573n, bundle.getBundle("logger"));
        } else {
            this.f3572m = new C1708d(context, c1597f, this.f3561a, this.f3573n);
        }
        this.f3568i.mo2666a((C1516x) this, this.f3561a);
        this.f3561a.setVideoURI(this.f3570k);
    }

    public final void mo2711a(Context context, C1452a c1452a, Map<String, Object> map, C1597f c1597f) {
        try {
            m4023a(context, c1452a, (JSONObject) map.get("data"), c1597f, null);
        } catch (JSONException e) {
            c1452a.mo2667a((C1516x) this, C1460d.f3367e);
        }
    }

    public void mo2680b() {
        if (this.f3561a != null) {
            this.f3561a.m5258g();
        }
        this.f3568i = null;
        this.f3569j = null;
        this.f3570k = null;
        this.f3571l = false;
        this.f3573n = null;
        this.f3561a = null;
        this.f3572m = null;
        this.f3562b = null;
        this.f3563c = null;
    }

    protected void mo2718c() {
        if (!f3560d && this.f3563c == null) {
            throw new AssertionError();
        } else if (f3560d || this.f3562b != null) {
            JSONObject jSONObject = this.f3562b.getJSONObject("video");
            JSONObject optJSONObject = this.f3562b.optJSONObject("text");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            this.f3561a.m5250a(new C1822j(this.f3563c));
            C1784m c1827k = new C1827k(this.f3563c);
            this.f3561a.m5250a(c1827k);
            this.f3561a.m5250a(new C1803d(c1827k, C1802a.INVSIBLE));
            this.f3561a.m5250a(new C1791b(this.f3563c));
            String d = m4030d();
            if (d != null) {
                C1784m c1793c = new C1793c(this.f3563c, d);
                LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                c1793c.setLayoutParams(layoutParams);
                c1793c.setCountdownTextColor(-1);
                this.f3561a.m5250a(c1793c);
            }
            if (jSONObject.has("destinationURL") && !jSONObject.isNull("destinationURL")) {
                Object string = jSONObject.getString("destinationURL");
                if (!TextUtils.isEmpty(string)) {
                    c1827k = new C1805e(this.f3563c, string, this.f3573n, optJSONObject.optString("learnMore", "Learn More"));
                    LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(10);
                    layoutParams2.addRule(11);
                    c1827k.setLayoutParams(layoutParams2);
                    this.f3561a.m5250a(c1827k);
                }
            }
            this.f3561a.m5250a(new C1786a(this.f3563c, "http://m.facebook.com/ads/ad_choices", this.f3573n, new float[]{0.0f, 0.0f, 8.0f, 0.0f}));
            int e = m4031e();
            if (e > 0) {
                c1827k = new C1817h(this.f3563c, e, optJSONObject.optString("skipAdIn", "Skip Ad in"), optJSONObject.optString("skipAd", "Skip Ad"));
                LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(12);
                layoutParams3.addRule(11);
                c1827k.setLayoutParams(layoutParams3);
                c1827k.setPadding(0, 0, 0, 30);
                this.f3561a.m5250a(c1827k);
            }
        } else {
            throw new AssertionError();
        }
    }

    protected String m4030d() {
        String str = null;
        if (f3560d || this.f3562b != null) {
            try {
                JSONObject jSONObject = this.f3562b.getJSONObject("capabilities");
                if (jSONObject.has("countdown") && !jSONObject.isNull("countdown")) {
                    jSONObject = jSONObject.getJSONObject("countdown");
                    if (jSONObject.has("format")) {
                        str = jSONObject.optString("format");
                    }
                }
            } catch (Throwable e) {
                Log.w(String.valueOf(C1517o.class), "Invalid JSON", e);
            }
            return str;
        }
        throw new AssertionError();
    }

    protected int m4031e() {
        int i = -1;
        if (f3560d || this.f3562b != null) {
            try {
                JSONObject jSONObject = this.f3562b.getJSONObject("capabilities");
                if (jSONObject.has("skipButton") && !jSONObject.isNull("skipButton")) {
                    jSONObject = jSONObject.getJSONObject("skipButton");
                    if (jSONObject.has("skippableSeconds")) {
                        i = jSONObject.getInt("skippableSeconds");
                    }
                }
            } catch (Throwable e) {
                Log.w(String.valueOf(C1517o.class), "Invalid JSON", e);
            }
            return i;
        }
        throw new AssertionError();
    }

    public boolean mo2712f() {
        if (!this.f3571l || this.f3561a == null) {
            return false;
        }
        if (this.f3572m.m4910l() > 0) {
            this.f3561a.m5248a(this.f3572m.m4910l());
            this.f3561a.mo2828d();
        } else {
            this.f3561a.mo2828d();
            m4033g();
        }
        return true;
    }

    protected void m4033g() {
        if (this.f3569j != null) {
            this.f3569j.mo2739a(this.f3573n, new HashMap());
            if (this.f3568i != null) {
                this.f3568i.mo2669c(this);
            }
        }
    }
}
