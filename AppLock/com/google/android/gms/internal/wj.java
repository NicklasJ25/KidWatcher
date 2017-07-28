package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.wi.C2361a;
import com.google.android.gms.internal.wk.C3396a;
import com.google.android.gms.internal.yy.C3457a;
import com.google.android.gms.internal.zzmk.C3513a;
import org.json.JSONObject;

@wh
public class wj extends zg implements C3396a {
    zn f11170a;
    zzmn f11171b;
    tr f11172c;
    private final C2361a f11173d;
    private final C3513a f11174e;
    private final Object f11175f = new Object();
    private final Context f11176g;
    private zzmk f11177h;
    private Runnable f11178i;

    class C33931 implements Runnable {
        final /* synthetic */ wj f11166a;

        C33931(wj wjVar) {
            this.f11166a = wjVar;
        }

        public void run() {
            synchronized (this.f11166a.f11175f) {
                if (this.f11166a.f11170a == null) {
                    return;
                }
                this.f11166a.onStop();
                this.f11166a.m14498a(2, "Timed out waiting for ad response.");
            }
        }
    }

    @wh
    static final class C3395a extends Exception {
        private final int f11169a;

        public C3395a(String str, int i) {
            super(str);
            this.f11169a = i;
        }

        public int m14495a() {
            return this.f11169a;
        }
    }

    public wj(Context context, C3513a c3513a, C2361a c2361a) {
        this.f11173d = c2361a;
        this.f11176g = context;
        this.f11174e = c3513a;
    }

    private void m14498a(int i, String str) {
        if (i == 3 || i == -1) {
            aad.m8425d(str);
        } else {
            aad.m8426e(str);
        }
        if (this.f11171b == null) {
            this.f11171b = new zzmn(i);
        } else {
            this.f11171b = new zzmn(i, this.f11171b.f12045k);
        }
        this.f11173d.zza(new C3457a(this.f11177h != null ? this.f11177h : new zzmk(this.f11174e, -1, null, null, null), this.f11171b, this.f11172c, null, i, -1, this.f11171b.f12048n, null));
    }

    zn m14502a(zzqh com_google_android_gms_internal_zzqh, aam<zzmk> com_google_android_gms_internal_aam_com_google_android_gms_internal_zzmk) {
        return wk.m14509a(this.f11176g, com_google_android_gms_internal_zzqh, com_google_android_gms_internal_aam_com_google_android_gms_internal_zzmk, this);
    }

    protected zzeg m14503a(zzmk com_google_android_gms_internal_zzmk) {
        int i;
        if (this.f11171b.f12018A) {
            for (zzeg com_google_android_gms_internal_zzeg : com_google_android_gms_internal_zzmk.f11995d.f11901g) {
                if (com_google_android_gms_internal_zzeg.f11903i) {
                    return new zzeg(com_google_android_gms_internal_zzeg, com_google_android_gms_internal_zzmk.f11995d.f11901g);
                }
            }
        }
        if (this.f11171b.f12047m == null) {
            throw new C3395a("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.f11171b.f12047m.split("x");
        if (split.length != 2) {
            String str = "Invalid ad size format from the ad response: ";
            String valueOf = String.valueOf(this.f11171b.f12047m);
            throw new C3395a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (zzeg com_google_android_gms_internal_zzeg2 : com_google_android_gms_internal_zzmk.f11995d.f11901g) {
                float f = this.f11176g.getResources().getDisplayMetrics().density;
                i = com_google_android_gms_internal_zzeg2.f11899e == -1 ? (int) (((float) com_google_android_gms_internal_zzeg2.f11900f) / f) : com_google_android_gms_internal_zzeg2.f11899e;
                int i2 = com_google_android_gms_internal_zzeg2.f11896b == -2 ? (int) (((float) com_google_android_gms_internal_zzeg2.f11897c) / f) : com_google_android_gms_internal_zzeg2.f11896b;
                if (parseInt == i && parseInt2 == i2 && !com_google_android_gms_internal_zzeg2.f11903i) {
                    return new zzeg(com_google_android_gms_internal_zzeg2, com_google_android_gms_internal_zzmk.f11995d.f11901g);
                }
            }
            str = "The ad size from the ad response was not one of the requested sizes: ";
            valueOf = String.valueOf(this.f11171b.f12047m);
            throw new C3395a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        } catch (NumberFormatException e) {
            str = "Invalid ad size number from the ad response: ";
            valueOf = String.valueOf(this.f11171b.f12047m);
            throw new C3395a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        }
    }

    protected void m14504a() {
        if (this.f11171b.f12039e != -3) {
            if (TextUtils.isEmpty(this.f11171b.f12037c)) {
                throw new C3395a("No fill from ad server.", 3);
            }
            zzw.zzcQ().m14992a(this.f11176g, this.f11171b.f12055u);
            if (this.f11171b.f12042h) {
                try {
                    this.f11172c = new tr(this.f11171b.f12037c);
                    zzw.zzcQ().m15014d(this.f11172c.f10793g);
                } catch (Throwable e) {
                    aad.m8422b("Could not parse mediation config.", e);
                    String str = "Could not parse mediation config: ";
                    String valueOf = String.valueOf(this.f11171b.f12037c);
                    throw new C3395a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
                }
            }
            zzw.zzcQ().m15014d(this.f11171b.f12028K);
            if (!TextUtils.isEmpty(this.f11171b.f12026I) && ((Boolean) qb.cV.m13225c()).booleanValue()) {
                aad.m8421b("Received cookie from server. Setting webview cookie in CookieManager.");
                CookieManager c = zzw.zzcO().mo4267c(this.f11176g);
                if (c != null) {
                    c.setCookie("googleads.g.doubleclick.net", this.f11171b.f12026I);
                }
            }
        }
    }

    public void mo4183a(@NonNull zzmn com_google_android_gms_internal_zzmn) {
        aad.m8421b("Received ad response.");
        this.f11171b = com_google_android_gms_internal_zzmn;
        long b = zzw.zzcS().mo3361b();
        synchronized (this.f11175f) {
            this.f11170a = null;
        }
        zzw.zzcQ().m15004b(this.f11176g, this.f11171b.f12025H);
        if (((Boolean) qb.aW.m13225c()).booleanValue()) {
            if (this.f11171b.f12033P) {
                zzw.zzcQ().m14995a(this.f11176g, this.f11177h.f11996e);
            } else {
                zzw.zzcQ().m15006b(this.f11176g, this.f11177h.f11996e);
            }
        }
        try {
            if (this.f11171b.f12039e == -2 || this.f11171b.f12039e == -3) {
                JSONObject jSONObject;
                m14504a();
                zzeg a = this.f11177h.f11995d.f11901g != null ? m14503a(this.f11177h) : null;
                zzw.zzcQ().m15007b(this.f11171b.f12056v);
                zzw.zzcQ().m15009c(this.f11171b.f12032O);
                if (!TextUtils.isEmpty(this.f11171b.f12052r)) {
                    try {
                        jSONObject = new JSONObject(this.f11171b.f12052r);
                    } catch (Throwable e) {
                        aad.m8422b("Error parsing the JSON for Active View.", e);
                    }
                    this.f11173d.zza(new C3457a(this.f11177h, this.f11171b, this.f11172c, a, -2, b, this.f11171b.f12048n, jSONObject));
                    zl.f11678a.removeCallbacks(this.f11178i);
                    return;
                }
                jSONObject = null;
                this.f11173d.zza(new C3457a(this.f11177h, this.f11171b, this.f11172c, a, -2, b, this.f11171b.f12048n, jSONObject));
                zl.f11678a.removeCallbacks(this.f11178i);
                return;
            }
            throw new C3395a("There was a problem getting an ad response. ErrorCode: " + this.f11171b.f12039e, this.f11171b.f12039e);
        } catch (C3395a e2) {
            m14498a(e2.m14495a(), e2.getMessage());
            zl.f11678a.removeCallbacks(this.f11178i);
        }
    }

    public void onStop() {
        synchronized (this.f11175f) {
            if (this.f11170a != null) {
                this.f11170a.cancel();
            }
        }
    }

    public void zzco() {
        aad.m8421b("AdLoaderBackgroundTask started.");
        this.f11178i = new C33931(this);
        zl.f11678a.postDelayed(this.f11178i, ((Long) qb.bF.m13225c()).longValue());
        long b = zzw.zzcS().mo3361b();
        if (((Boolean) qb.bE.m13225c()).booleanValue() && this.f11174e.f11945b.f11879c != null) {
            String string = this.f11174e.f11945b.f11879c.getString("_ad");
            if (string != null) {
                this.f11177h = new zzmk(this.f11174e, b, null, null, null);
                mo4183a(xb.m14682a(this.f11176g, this.f11177h, string));
                return;
            }
        }
        final aam com_google_android_gms_internal_aan = new aan();
        zk.m15079a(new Runnable(this) {
            final /* synthetic */ wj f11168b;

            public void run() {
                synchronized (this.f11168b.f11175f) {
                    this.f11168b.f11170a = this.f11168b.m14502a(this.f11168b.f11174e.f11953j, com_google_android_gms_internal_aan);
                    if (this.f11168b.f11170a == null) {
                        this.f11168b.m14498a(0, "Could not start the ad request service.");
                        zl.f11678a.removeCallbacks(this.f11168b.f11178i);
                    }
                }
            }
        });
        String b2 = zzw.zzdl().m14944b(this.f11176g);
        String c = zzw.zzdl().m14947c(this.f11176g);
        String d = zzw.zzdl().m14950d(this.f11176g);
        zzw.zzdl().m14953e(this.f11176g, d);
        this.f11177h = new zzmk(this.f11174e, b, b2, c, d);
        com_google_android_gms_internal_aan.mo3381a(this.f11177h);
    }
}
