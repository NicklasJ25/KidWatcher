package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.internal.tv.C3314a;
import com.google.android.gms.internal.ue.C3312a;
import com.google.android.gms.p065a.C2312b;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@wh
public class tu implements C3314a {
    private final String f10810a;
    private final ub f10811b;
    private final long f10812c;
    private final tr f10813d;
    private final tq f10814e;
    private zzec f10815f;
    private final zzeg f10816g;
    private final Context f10817h;
    private final Object f10818i = new Object();
    private final zzqh f10819j;
    private final boolean f10820k;
    private final zzhc f10821l;
    private final List<String> f10822m;
    private final boolean f10823n;
    private uc f10824o;
    private int f10825p = -2;
    private ue f10826q;

    class C33132 extends C3312a {
        final /* synthetic */ int f10809a;

        C33132(int i) {
            this.f10809a = i;
        }

        public int mo4054a() {
            return this.f10809a;
        }
    }

    public tu(Context context, String str, ub ubVar, tr trVar, tq tqVar, zzec com_google_android_gms_internal_zzec, zzeg com_google_android_gms_internal_zzeg, zzqh com_google_android_gms_internal_zzqh, boolean z, boolean z2, zzhc com_google_android_gms_internal_zzhc, List<String> list) {
        this.f10817h = context;
        this.f10811b = ubVar;
        this.f10814e = tqVar;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.f10810a = m14015b();
        } else {
            this.f10810a = str;
        }
        this.f10813d = trVar;
        this.f10812c = trVar.f10788b != -1 ? trVar.f10788b : 10000;
        this.f10815f = com_google_android_gms_internal_zzec;
        this.f10816g = com_google_android_gms_internal_zzeg;
        this.f10819j = com_google_android_gms_internal_zzqh;
        this.f10820k = z;
        this.f10823n = z2;
        this.f10821l = com_google_android_gms_internal_zzhc;
        this.f10822m = list;
    }

    private long m14006a(long j, long j2, long j3, long j4) {
        while (this.f10825p == -2) {
            m14016b(j, j2, j3, j4);
        }
        return zzw.zzcS().mo3361b() - j;
    }

    private String m14009a(String str) {
        if (!(str == null || !m14024e() || m14017b(2))) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.remove("cpm_floor_cents");
                str = jSONObject.toString();
            } catch (JSONException e) {
                aad.m8426e("Could not remove field. Returning the original value");
            }
        }
        return str;
    }

    private void m14010a(tt ttVar) {
        String a = m14009a(this.f10814e.f10779i);
        try {
            if (this.f10819j.f12083c < 4100000) {
                if (this.f10816g.f11898d) {
                    this.f10824o.mo4065a(C2312b.m7327a(this.f10817h), this.f10815f, a, ttVar);
                } else {
                    this.f10824o.mo4069a(C2312b.m7327a(this.f10817h), this.f10816g, this.f10815f, a, (ud) ttVar);
                }
            } else if (this.f10820k) {
                this.f10824o.mo4068a(C2312b.m7327a(this.f10817h), this.f10815f, a, this.f10814e.f10771a, ttVar, this.f10821l, this.f10822m);
            } else if (this.f10816g.f11898d) {
                this.f10824o.mo4067a(C2312b.m7327a(this.f10817h), this.f10815f, a, this.f10814e.f10771a, (ud) ttVar);
            } else if (!this.f10823n) {
                this.f10824o.mo4070a(C2312b.m7327a(this.f10817h), this.f10816g, this.f10815f, a, this.f10814e.f10771a, ttVar);
            } else if (this.f10814e.f10782l != null) {
                this.f10824o.mo4068a(C2312b.m7327a(this.f10817h), this.f10815f, a, this.f10814e.f10771a, ttVar, new zzhc(m14014b(this.f10814e.f10786p)), this.f10814e.f10785o);
            } else {
                this.f10824o.mo4070a(C2312b.m7327a(this.f10817h), this.f10816g, this.f10815f, a, this.f10814e.f10771a, ttVar);
            }
        } catch (Throwable e) {
            aad.m8424c("Could not request ad from mediation adapter.", e);
            mo4055a(5);
        }
    }

    private static NativeAdOptions m14014b(String str) {
        Builder builder = new Builder();
        if (str == null) {
            return builder.build();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            builder.setRequestMultipleImages(jSONObject.optBoolean("multiple_images", false));
            builder.setReturnUrlsForImageAssets(jSONObject.optBoolean("only_urls", false));
            builder.setImageOrientation(m14018c(jSONObject.optString("native_image_orientation", "any")));
        } catch (Throwable e) {
            aad.m8424c("Exception occurred when creating native ad options", e);
        }
        return builder.build();
    }

    private String m14015b() {
        try {
            if (!TextUtils.isEmpty(this.f10814e.f10775e)) {
                return this.f10811b.mo4061b(this.f10814e.f10775e) ? "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter" : "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        } catch (RemoteException e) {
            aad.m8426e("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private void m14016b(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        elapsedRealtime = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || elapsedRealtime <= 0) {
            aad.m8425d("Timed out waiting for adapter.");
            this.f10825p = 3;
            return;
        }
        try {
            this.f10818i.wait(Math.min(j5, elapsedRealtime));
        } catch (InterruptedException e) {
            this.f10825p = -1;
        }
    }

    private boolean m14017b(int i) {
        try {
            Bundle l = this.f10820k ? this.f10824o.mo4083l() : this.f10816g.f11898d ? this.f10824o.mo4082k() : this.f10824o.mo4081j();
            if (l == null) {
                return false;
            }
            return (l.getInt("capabilities", 0) & i) == i;
        } catch (RemoteException e) {
            aad.m8426e("Could not get adapter info. Returning false");
            return false;
        }
    }

    private static int m14018c(String str) {
        return "landscape".equals(str) ? 2 : "portrait".equals(str) ? 1 : 0;
    }

    private ue m14020c() {
        if (this.f10825p != 0 || !m14024e()) {
            return null;
        }
        try {
            if (!(!m14017b(4) || this.f10826q == null || this.f10826q.mo4054a() == 0)) {
                return this.f10826q;
            }
        } catch (RemoteException e) {
            aad.m8426e("Could not get cpm value from MediationResponseMetadata");
        }
        return m14021c(m14026f());
    }

    private static ue m14021c(int i) {
        return new C33132(i);
    }

    private uc m14022d() {
        String str = "Instantiating mediation adapter: ";
        String valueOf = String.valueOf(this.f10810a);
        aad.m8425d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        if (!this.f10820k) {
            if (((Boolean) qb.bC.m13225c()).booleanValue() && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.f10810a)) {
                return m14029a(new AdMobAdapter());
            }
            if (((Boolean) qb.bD.m13225c()).booleanValue() && "com.google.ads.mediation.AdUrlAdapter".equals(this.f10810a)) {
                return m14029a(new AdUrlAdapter());
            }
            if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(this.f10810a)) {
                return new ui(new uq());
            }
        }
        try {
            return this.f10811b.mo4060a(this.f10810a);
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = "Could not instantiate mediation adapter: ";
            valueOf = String.valueOf(this.f10810a);
            aad.m8419a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
            return null;
        }
    }

    private boolean m14024e() {
        return this.f10813d.f10798l != -1;
    }

    private int m14026f() {
        if (this.f10814e.f10779i == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.f10814e.f10779i);
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.f10810a)) {
                return jSONObject.optInt("cpm_cents", 0);
            }
            int optInt = m14017b(2) ? jSONObject.optInt("cpm_floor_cents", 0) : 0;
            return optInt == 0 ? jSONObject.optInt("penalized_average_cpm_cents", 0) : optInt;
        } catch (JSONException e) {
            aad.m8426e("Could not convert to json. Returning 0");
            return 0;
        }
    }

    public tv m14028a(long j, long j2) {
        tv tvVar;
        synchronized (this.f10818i) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            final tt ttVar = new tt();
            zl.f11678a.post(new Runnable(this) {
                final /* synthetic */ tu f10808b;

                public void run() {
                    synchronized (this.f10808b.f10818i) {
                        if (this.f10808b.f10825p != -2) {
                            return;
                        }
                        this.f10808b.f10824o = this.f10808b.m14022d();
                        if (this.f10808b.f10824o == null) {
                            this.f10808b.mo4055a(4);
                        } else if (!this.f10808b.m14024e() || this.f10808b.m14017b(1)) {
                            ttVar.m13994a(this.f10808b);
                            this.f10808b.m14010a(ttVar);
                        } else {
                            String f = this.f10808b.f10810a;
                            aad.m8426e(new StringBuilder(String.valueOf(f).length() + 56).append("Ignoring adapter ").append(f).append(" as delayed impression is not supported").toString());
                            this.f10808b.mo4055a(2);
                        }
                    }
                }
            });
            tt ttVar2 = ttVar;
            tvVar = new tv(this.f10814e, this.f10824o, this.f10810a, ttVar2, this.f10825p, m14020c(), m14006a(elapsedRealtime, this.f10812c, j, j2));
        }
        return tvVar;
    }

    protected uc m14029a(MediationAdapter mediationAdapter) {
        return new ui(mediationAdapter);
    }

    public void m14030a() {
        synchronized (this.f10818i) {
            try {
                if (this.f10824o != null) {
                    this.f10824o.mo4074c();
                }
            } catch (Throwable e) {
                aad.m8424c("Could not destroy mediation adapter.", e);
            }
            this.f10825p = -1;
            this.f10818i.notify();
        }
    }

    public void mo4055a(int i) {
        synchronized (this.f10818i) {
            this.f10825p = i;
            this.f10818i.notify();
        }
    }

    public void mo4056a(int i, ue ueVar) {
        synchronized (this.f10818i) {
            this.f10825p = i;
            this.f10826q = ueVar;
            this.f10818i.notify();
        }
    }
}
