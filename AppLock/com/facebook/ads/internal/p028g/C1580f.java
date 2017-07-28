package com.facebook.ads.internal.p028g;

import android.content.Context;
import com.facebook.ads.C1462f;
import com.facebook.ads.C1462f.C1461a;
import com.facebook.ads.C1463g;
import com.facebook.ads.internal.C1558e;
import com.facebook.ads.internal.C1571f;
import com.facebook.ads.internal.C1584g;
import com.facebook.ads.internal.p018m.C1719m;
import com.facebook.ads.internal.p018m.C1723o;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p018m.aa;
import com.facebook.ads.internal.p018m.aa.C1687a;
import com.facebook.ads.internal.p018m.ae;
import com.facebook.ads.internal.p018m.ai;
import com.facebook.ads.internal.p021b.C1503j;
import com.facebook.ads.internal.p024l.C1675a;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class C1580f {
    private static final ExecutorService f3900g = Executors.newSingleThreadExecutor();
    private static String f3901h = null;
    private static C1687a f3902i = aa.m4801a();
    protected String f3903a;
    protected C1675a f3904b;
    protected C1575c f3905c;
    public Context f3906d;
    public C1584g f3907e;
    public boolean f3908f;
    private C1558e f3909j;
    private int f3910k;
    private C1463g f3911l;

    public C1580f(Context context, String str, C1463g c1463g, C1584g c1584g, C1558e c1558e, int i, boolean z) {
        this.f3903a = str;
        this.f3911l = c1463g;
        this.f3907e = c1584g;
        this.f3905c = C1575c.m4382a(c1584g);
        this.f3909j = c1558e;
        this.f3910k = i;
        this.f3908f = z;
        m4398a(context);
    }

    private void m4398a(final Context context) {
        this.f3906d = context;
        C1581g.m4408a();
        C1583i.m4411a(context);
        m4402g();
        f3900g.submit(new Runnable(this) {
            final /* synthetic */ C1580f f3898b;

            public void run() {
                if (C1580f.f3901h == null) {
                    C1580f.f3901h = ae.m4812a(context, context.getPackageName());
                }
            }
        });
    }

    private void m4399a(Map<String, String> map, String str, String str2) {
        map.put(str, str2);
    }

    private static Map<String, String> m4400b(Context context) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("SDK", "android");
        hashMap.put("SDK_VERSION", "4.23.0");
        hashMap.put("LOCALE", Locale.getDefault().toString());
        float f = context.getResources().getDisplayMetrics().density;
        int i = context.getResources().getDisplayMetrics().widthPixels;
        int i2 = context.getResources().getDisplayMetrics().heightPixels;
        hashMap.put("DENSITY", String.valueOf(f));
        hashMap.put("SCREEN_WIDTH", String.valueOf((int) (((float) i) / f)));
        hashMap.put("SCREEN_HEIGHT", String.valueOf((int) (((float) i2) / f)));
        hashMap.put("IDFA", C1583i.f3934o);
        hashMap.put("IDFA_FLAG", C1583i.f3935p ? "0" : "1");
        hashMap.put("ATTRIBUTION_ID", C1583i.f3933n);
        hashMap.put("ID_SOURCE", C1583i.f3936q);
        hashMap.put("OS", "Android");
        hashMap.put("OSVERS", C1583i.f3920a);
        hashMap.put("BUNDLE", C1583i.f3923d);
        hashMap.put("APPNAME", C1583i.f3924e);
        hashMap.put("APPVERS", C1583i.f3925f);
        hashMap.put("APPBUILD", String.valueOf(C1583i.f3926g));
        hashMap.put("CARRIER", C1583i.f3928i);
        hashMap.put("MAKE", C1583i.f3921b);
        hashMap.put("MODEL", C1583i.f3922c);
        hashMap.put("ROOTED", String.valueOf(f3902i.f4188d));
        hashMap.put("COPPA", String.valueOf(C1462f.m3765e()));
        hashMap.put("INSTALLER", C1583i.f3927h);
        hashMap.put("SDK_CAPABILITY", C1571f.m4374b());
        hashMap.put("NETWORK_TYPE", String.valueOf(ai.m4833c(context).f4223g));
        hashMap.put("REQUEST_TIME", C1729s.m4961a(System.currentTimeMillis()));
        hashMap.put("SESSION_TIME", C1729s.m4960a(C1581g.m4409b()));
        hashMap.put("SESSION_ID", C1581g.m4410c());
        return hashMap;
    }

    private void m4402g() {
        if (this.f3905c == null) {
            this.f3905c = C1575c.UNKNOWN;
        }
        switch (this.f3905c) {
            case INTERSTITIAL:
                this.f3904b = C1675a.INTERSTITIAL;
                return;
            case BANNER:
                this.f3904b = C1675a.BANNER;
                return;
            case NATIVE:
                this.f3904b = C1675a.NATIVE;
                return;
            case REWARDED_VIDEO:
                this.f3904b = C1675a.REWARDED_VIDEO;
                return;
            default:
                this.f3904b = C1675a.UNKNOWN;
                return;
        }
    }

    public String m4403a() {
        return this.f3903a;
    }

    public C1575c m4404b() {
        return this.f3905c;
    }

    public C1463g m4405c() {
        return this.f3911l;
    }

    public int m4406d() {
        return this.f3910k;
    }

    public Map<String, String> m4407e() {
        Map<String, String> hashMap = new HashMap();
        m4399a(hashMap, "PLACEMENT_ID", this.f3903a);
        if (this.f3904b != C1675a.UNKNOWN) {
            m4399a(hashMap, "PLACEMENT_TYPE", this.f3904b.toString().toLowerCase());
        }
        for (Entry entry : C1580f.m4400b(this.f3906d).entrySet()) {
            m4399a(hashMap, (String) entry.getKey(), (String) entry.getValue());
        }
        if (this.f3911l != null) {
            m4399a(hashMap, "WIDTH", String.valueOf(this.f3911l.m3767a()));
            m4399a(hashMap, "HEIGHT", String.valueOf(this.f3911l.m3768b()));
        }
        m4399a(hashMap, "ADAPTERS", C1503j.m3979a(this.f3904b));
        if (this.f3907e != null) {
            m4399a(hashMap, "TEMPLATE_ID", String.valueOf(this.f3907e.m4415a()));
        }
        if (this.f3909j != null) {
            m4399a(hashMap, "REQUEST_TYPE", String.valueOf(this.f3909j.m4327a()));
        }
        if (this.f3908f) {
            m4399a(hashMap, "TEST_MODE", "1");
        }
        if (C1462f.m3766f() != C1461a.DEFAULT) {
            m4399a(hashMap, "DEMO_AD_ID", C1462f.m3766f().m3758a());
        }
        if (this.f3910k != 0) {
            m4399a(hashMap, "NUM_ADS_REQUESTED", String.valueOf(this.f3910k));
        }
        String d = C1462f.m3764d();
        if (d != null) {
            m4399a(hashMap, "MEDIATION_SERVICE", d);
        }
        m4399a(hashMap, "CLIENT_EVENTS", C1723o.m4942a());
        if (f3901h != null) {
            m4399a(hashMap, "AFP", f3901h);
        }
        m4399a(hashMap, "UNITY", String.valueOf(C1729s.m4972a(this.f3906d)));
        m4399a(hashMap, "KG_RESTRICTED", String.valueOf(C1719m.m4935b(this.f3906d)));
        return hashMap;
    }
}
