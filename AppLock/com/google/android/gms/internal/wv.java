package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.C2482c;
import com.google.android.gms.common.C2484d;
import com.google.android.gms.internal.aam.C2380c;
import com.google.android.gms.internal.aam.C2637a;
import com.google.android.gms.internal.ti.C3303c;
import com.google.android.gms.internal.wi.C2361a;
import com.google.android.gms.internal.yy.C3457a;
import com.google.android.gms.internal.zzmk.C3513a;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@wh
public class wv extends zg {
    static final long f11206a = TimeUnit.SECONDS.toMillis(10);
    static boolean f11207b = false;
    private static final Object f11208c = new Object();
    private static ti f11209d = null;
    private static sd f11210e = null;
    private static sh f11211f = null;
    private static sc f11212g = null;
    private final C2361a f11213h;
    private final C3513a f11214i;
    private final Object f11215j = new Object();
    private final Context f11216k;
    private C3303c f11217l;

    class C34113 implements Runnable {
        final /* synthetic */ wv f11205a;

        C34113(wv wvVar) {
            this.f11205a = wvVar;
        }

        public void run() {
            if (this.f11205a.f11217l != null) {
                this.f11205a.f11217l.g_();
                this.f11205a.f11217l = null;
            }
        }
    }

    public static class C3412a implements zq<tf> {
        public void m14561a(tf tfVar) {
            wv.m14574b(tfVar);
        }

        public /* synthetic */ void mo4041a(Object obj) {
            m14561a((tf) obj);
        }
    }

    public static class C3413b implements zq<tf> {
        public void m14563a(tf tfVar) {
            wv.m14571a(tfVar);
        }

        public /* synthetic */ void mo4041a(Object obj) {
            m14563a((tf) obj);
        }
    }

    public static class C3414c implements sc {
        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            String str = (String) map.get("request_id");
            String str2 = "Invalid request: ";
            String valueOf = String.valueOf((String) map.get("errors"));
            aad.m8426e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            wv.f11211f.m13718b(str);
        }
    }

    public wv(Context context, C3513a c3513a, C2361a c2361a) {
        super(true);
        this.f11213h = c2361a;
        this.f11216k = context;
        this.f11214i = c3513a;
        synchronized (f11208c) {
            if (!f11207b) {
                f11211f = new sh();
                f11210e = new sd(context.getApplicationContext(), c3513a.f11953j);
                f11212g = new C3414c();
                f11209d = new ti(this.f11216k.getApplicationContext(), this.f11214i.f11953j, (String) qb.f10288b.m13225c(), new C3413b(), new C3412a());
                f11207b = true;
            }
        }
    }

    private zzmn m14569a(zzmk com_google_android_gms_internal_zzmk) {
        final String c = zzw.zzcM().m15145c();
        final JSONObject a = m14570a(com_google_android_gms_internal_zzmk, c);
        if (a == null) {
            return new zzmn(0);
        }
        long b = zzw.zzcS().mo3361b();
        Future a2 = f11211f.m13715a(c);
        aac.f7622a.post(new Runnable(this) {
            final /* synthetic */ wv f11204c;

            class C34081 implements C2380c<tj> {
                final /* synthetic */ C34102 f11200a;

                C34081(C34102 c34102) {
                    this.f11200a = c34102;
                }

                public void m14558a(tj tjVar) {
                    try {
                        tjVar.mo3385a("AFMA_getAdapterLessMediationAd", a);
                    } catch (Throwable e) {
                        aad.m8422b("Error requesting an ad url", e);
                        wv.f11211f.m13718b(c);
                    }
                }

                public /* synthetic */ void mo3272a(Object obj) {
                    m14558a((tj) obj);
                }
            }

            class C34092 implements C2637a {
                final /* synthetic */ C34102 f11201a;

                C34092(C34102 c34102) {
                    this.f11201a = c34102;
                }

                public void mo3379a() {
                    wv.f11211f.m13718b(c);
                }
            }

            public void run() {
                this.f11204c.f11217l = wv.f11209d.m13966a();
                this.f11204c.f11217l.mo3380a(new C34081(this), new C34092(this));
            }
        });
        try {
            JSONObject jSONObject = (JSONObject) a2.get(f11206a - (zzw.zzcS().mo3361b() - b), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new zzmn(-1);
            }
            zzmn a3 = xb.m14682a(this.f11216k, com_google_android_gms_internal_zzmk, jSONObject.toString());
            return (a3.f12039e == -3 || !TextUtils.isEmpty(a3.f12037c)) ? a3 : new zzmn(3);
        } catch (CancellationException e) {
            return new zzmn(-1);
        } catch (InterruptedException e2) {
            return new zzmn(-1);
        } catch (TimeoutException e3) {
            return new zzmn(2);
        } catch (ExecutionException e4) {
            return new zzmn(0);
        }
    }

    private JSONObject m14570a(zzmk com_google_android_gms_internal_zzmk, String str) {
        Throwable e;
        Object obj;
        Info advertisingIdInfo;
        Map hashMap;
        JSONObject jSONObject = null;
        Bundle bundle = com_google_android_gms_internal_zzmk.f11994c.f11879c.getBundle("sdk_less_server_data");
        if (bundle != null) {
            xg xgVar;
            try {
                xgVar = (xg) zzw.zzcV().m14767a(this.f11216k).get();
            } catch (Throwable e2) {
                aad.m8424c("Error grabbing device info: ", e2);
                obj = jSONObject;
            }
            JSONObject a = xb.m14688a(this.f11216k, new wy().m14588a(com_google_android_gms_internal_zzmk).m14586a(xgVar));
            if (a != null) {
                try {
                    advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f11216k);
                } catch (IOException e3) {
                    e2 = e3;
                    aad.m8424c("Cannot get advertising id info", e2);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("request_param", a);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzw.zzcM().m15114a(hashMap);
                    return jSONObject;
                } catch (IllegalStateException e4) {
                    e2 = e4;
                    aad.m8424c("Cannot get advertising id info", e2);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("request_param", a);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        }
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzw.zzcM().m15114a(hashMap);
                    return jSONObject;
                } catch (C2482c e5) {
                    e2 = e5;
                    aad.m8424c("Cannot get advertising id info", e2);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("request_param", a);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        }
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzw.zzcM().m15114a(hashMap);
                    return jSONObject;
                } catch (C2484d e6) {
                    e2 = e6;
                    aad.m8424c("Cannot get advertising id info", e2);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("request_param", a);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        }
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzw.zzcM().m15114a(hashMap);
                    return jSONObject;
                }
                hashMap = new HashMap();
                hashMap.put("request_id", str);
                hashMap.put("request_param", a);
                hashMap.put("data", bundle);
                if (advertisingIdInfo != null) {
                    hashMap.put("adid", advertisingIdInfo.getId());
                    if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                    }
                    hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                }
                try {
                    jSONObject = zzw.zzcM().m15114a(hashMap);
                } catch (JSONException e7) {
                }
            }
        }
        return jSONObject;
    }

    protected static void m14571a(tf tfVar) {
        tfVar.mo3402a("/loadAd", f11211f);
        tfVar.mo3402a("/fetchHttpRequest", f11210e);
        tfVar.mo3402a("/invalidRequest", f11212g);
    }

    protected static void m14574b(tf tfVar) {
        tfVar.mo3409b("/loadAd", f11211f);
        tfVar.mo3409b("/fetchHttpRequest", f11210e);
        tfVar.mo3409b("/invalidRequest", f11212g);
    }

    public void onStop() {
        synchronized (this.f11215j) {
            aac.f7622a.post(new C34113(this));
        }
    }

    public void zzco() {
        aad.m8421b("SdkLessAdLoaderBackgroundTask started.");
        String d = zzw.zzdl().m14950d(this.f11216k);
        zzmk com_google_android_gms_internal_zzmk = new zzmk(this.f11214i, -1, zzw.zzdl().m14944b(this.f11216k), zzw.zzdl().m14947c(this.f11216k), d);
        zzw.zzdl().m14953e(this.f11216k, d);
        zzmn a = m14569a(com_google_android_gms_internal_zzmk);
        zzmk com_google_android_gms_internal_zzmk2 = com_google_android_gms_internal_zzmk;
        tr trVar = null;
        zzeg com_google_android_gms_internal_zzeg = null;
        final C3457a c3457a = new C3457a(com_google_android_gms_internal_zzmk2, a, trVar, com_google_android_gms_internal_zzeg, a.f12039e, zzw.zzcS().mo3361b(), a.f12048n, null);
        aac.f7622a.post(new Runnable(this) {
            final /* synthetic */ wv f11199b;

            public void run() {
                this.f11199b.f11213h.zza(c3457a);
                if (this.f11199b.f11217l != null) {
                    this.f11199b.f11217l.g_();
                    this.f11199b.f11217l = null;
                }
            }
        });
    }
}
