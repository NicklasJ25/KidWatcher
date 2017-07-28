package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.aam.C2380c;
import com.google.android.gms.internal.aam.C2637a;
import com.google.android.gms.internal.ti.C3299b;
import com.google.android.gms.internal.ti.C3303c;
import com.google.android.gms.internal.ws.C3405a;
import com.google.android.gms.internal.xk.C3438a;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@wh
public final class xa extends C3405a {
    private static final Object f11303a = new Object();
    private static xa f11304b;
    private final Context f11305c;
    private final wz f11306d;
    private final pt f11307e;
    private final ti f11308f;

    class C34251 implements Callable<Void> {
        final /* synthetic */ wz f11285a;
        final /* synthetic */ Context f11286b;
        final /* synthetic */ zzmk f11287c;
        final /* synthetic */ Bundle f11288d;

        C34251(wz wzVar, Context context, zzmk com_google_android_gms_internal_zzmk, Bundle bundle) {
            this.f11285a = wzVar;
            this.f11286b = context;
            this.f11287c = com_google_android_gms_internal_zzmk;
            this.f11288d = bundle;
        }

        public Void m14668a() {
            String str = this.f11287c.f11998g.packageName;
            return null;
        }

        public /* synthetic */ Object call() {
            return m14668a();
        }
    }

    class C34282 implements Runnable {
        final /* synthetic */ ti f11291a;
        final /* synthetic */ xc f11292b;
        final /* synthetic */ qj f11293c;
        final /* synthetic */ qh f11294d;
        final /* synthetic */ String f11295e;

        class C34272 implements C2637a {
            C34272(C34282 c34282) {
            }

            public void mo3379a() {
            }
        }

        C34282(ti tiVar, xc xcVar, qj qjVar, qh qhVar, String str) {
            this.f11291a = tiVar;
            this.f11292b = xcVar;
            this.f11293c = qjVar;
            this.f11294d = qhVar;
            this.f11295e = str;
        }

        public void run() {
            C3303c a = this.f11291a.m13966a();
            this.f11292b.m14705a(a);
            this.f11293c.m13307a(this.f11294d, "rwc");
            final qh a2 = this.f11293c.m13301a();
            a.mo3380a(new C2380c<tj>(this) {
                final /* synthetic */ C34282 f11290b;

                public void m14669a(tj tjVar) {
                    this.f11290b.f11293c.m13307a(a2, "jsf");
                    this.f11290b.f11293c.m13308b();
                    tjVar.mo3402a("/invalidRequest", this.f11290b.f11292b.f11314b);
                    tjVar.mo3402a("/loadAdURL", this.f11290b.f11292b.f11315c);
                    tjVar.mo3402a("/loadAd", this.f11290b.f11292b.f11316d);
                    try {
                        tjVar.mo3384a("AFMA_getAd", this.f11290b.f11295e);
                    } catch (Throwable e) {
                        aad.m8422b("Error requesting an ad url", e);
                    }
                }

                public /* synthetic */ void mo3272a(Object obj) {
                    m14669a((tj) obj);
                }
            }, new C34272(this));
        }
    }

    class C34293 implements Runnable {
        final /* synthetic */ wz f11296a;
        final /* synthetic */ Context f11297b;
        final /* synthetic */ xc f11298c;
        final /* synthetic */ zzmk f11299d;

        C34293(wz wzVar, Context context, xc xcVar, zzmk com_google_android_gms_internal_zzmk) {
            this.f11296a = wzVar;
            this.f11297b = context;
            this.f11298c = xcVar;
            this.f11299d = com_google_android_gms_internal_zzmk;
        }

        public void run() {
            this.f11296a.f11237e.mo4193a(this.f11297b, this.f11298c, this.f11299d.f12002k);
        }
    }

    class C34304 implements zq<tf> {
        C34304(xa xaVar) {
        }

        public void m14672a(tf tfVar) {
            tfVar.mo3402a("/log", sb.f10536i);
        }

        public /* synthetic */ void mo4041a(Object obj) {
            m14672a((tf) obj);
        }
    }

    xa(Context context, pt ptVar, wz wzVar) {
        this.f11305c = context;
        this.f11306d = wzVar;
        this.f11307e = ptVar;
        this.f11308f = new ti(context.getApplicationContext() != null ? context.getApplicationContext() : context, zzqh.m15397a(), ptVar.m13212a(), new C34304(this), new C3299b());
    }

    public static xa m14674a(Context context, pt ptVar, wz wzVar) {
        xa xaVar;
        synchronized (f11303a) {
            if (f11304b == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                f11304b = new xa(context, ptVar, wzVar);
            }
            xaVar = f11304b;
        }
        return xaVar;
    }

    private static zzmn m14675a(Context context, ti tiVar, pt ptVar, wz wzVar, zzmk com_google_android_gms_internal_zzmk) {
        Future a;
        Future a2;
        Bundle bundle;
        Future future;
        Throwable e;
        String str;
        aad.m8421b("Starting ad request from service using: AFMA_getAd");
        qb.m13268a(context);
        qj qjVar = new qj(((Boolean) qb.f10280T.m13225c()).booleanValue(), "load_ad", com_google_android_gms_internal_zzmk.f11995d.f11895a);
        if (com_google_android_gms_internal_zzmk.f11992a > 10 && com_google_android_gms_internal_zzmk.f11970A != -1) {
            qjVar.m13307a(qjVar.m13302a(com_google_android_gms_internal_zzmk.f11970A), "cts");
        }
        qh a3 = qjVar.m13301a();
        Future a4 = wzVar.f11241i.mo4159a(context);
        Future a5 = wzVar.f11240h.mo4194a(context);
        Future a6 = wzVar.f11235c.mo4243a(com_google_android_gms_internal_zzmk.f11998g.packageName);
        Future a7 = wzVar.f11242j.mo4245a(com_google_android_gms_internal_zzmk);
        Future a8 = zzw.zzcV().m14767a(context);
        aah com_google_android_gms_internal_aah = new aah(null);
        Bundle bundle2 = com_google_android_gms_internal_zzmk.f11994c.f11879c;
        Object obj = (bundle2 == null || bundle2.getString("_ad") == null) ? null : 1;
        if (com_google_android_gms_internal_zzmk.f11977H && obj == null) {
            a = wzVar.f11238f.mo4045a(com_google_android_gms_internal_zzmk.f11997f);
        } else {
            Object obj2 = com_google_android_gms_internal_aah;
        }
        com_google_android_gms_internal_aah = new aah(null);
        if (((Boolean) qb.aM.m13225c()).booleanValue()) {
            a2 = wzVar.f11242j.mo4244a(context);
        } else {
            Object obj3 = com_google_android_gms_internal_aah;
        }
        Bundle bundle3 = (com_google_android_gms_internal_zzmk.f11992a < 4 || com_google_android_gms_internal_zzmk.f12006o == null) ? null : com_google_android_gms_internal_zzmk.f12006o;
        if (!((Boolean) qb.aj.m13225c()).booleanValue() || wzVar.f11233a == null) {
            bundle = bundle3;
            future = null;
        } else {
            if (bundle3 == null && ((Boolean) qb.ak.m13225c()).booleanValue()) {
                zh.m15051a("contentInfo is not present, but we'll still launch the app index task");
                bundle3 = new Bundle();
            }
            if (bundle3 != null) {
                bundle = bundle3;
                future = zk.m15080a(new C34251(wzVar, context, com_google_android_gms_internal_zzmk, bundle3));
            } else {
                bundle = bundle3;
                future = null;
            }
        }
        if (zzw.zzcM().m15131a(context, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
            if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() == null) {
                aad.m8421b("Device is offline.");
            }
        }
        String uuid = com_google_android_gms_internal_zzmk.f11992a >= 7 ? com_google_android_gms_internal_zzmk.f12013v : UUID.randomUUID().toString();
        xc xcVar = new xc(uuid, com_google_android_gms_internal_zzmk.f11997f.packageName);
        if (com_google_android_gms_internal_zzmk.f11994c.f11879c != null) {
            String string = com_google_android_gms_internal_zzmk.f11994c.f11879c.getString("_ad");
            if (string != null) {
                return xb.m14682a(context, com_google_android_gms_internal_zzmk, string);
            }
        }
        List a9 = wzVar.f11236d.mo3897a(com_google_android_gms_internal_zzmk);
        if (future != null) {
            try {
                zh.m15051a("Waiting for app index fetching task.");
                future.get(((Long) qb.al.m13225c()).longValue(), TimeUnit.MILLISECONDS);
                zh.m15051a("App index fetching task completed.");
            } catch (ExecutionException e2) {
                e = e2;
                aad.m8424c("Failed to fetch app index signal", e);
            } catch (InterruptedException e3) {
                e = e3;
                aad.m8424c("Failed to fetch app index signal", e);
            } catch (TimeoutException e4) {
                aad.m8421b("Timed out waiting for app index fetching task");
            }
        }
        bundle2 = (Bundle) m14677a(a4, (Long) qb.cR.m13225c());
        C3438a c3438a = (C3438a) m14677a(a5, (Long) qb.bB.m13225c());
        Location location = (Location) m14677a(a, (Long) qb.cz.m13225c());
        Info info = (Info) m14677a(a2, (Long) qb.aN.m13225c());
        try {
            str = (String) a7.get();
        } catch (Throwable e5) {
            zzw.zzcQ().m15000a(e5, "AdRequestServiceImpl.loadAdAsync.qs");
            aad.m8424c("Error fetching qs signals. Continuing.", e5);
            str = null;
        }
        String str2 = null;
        try {
            str2 = (String) a6.get();
        } catch (Throwable e52) {
            zzw.zzcQ().m15000a(e52, "AdRequestServiceImpl.loadAdAsync.ds");
            aad.m8424c("Error fetching drt signals. Continuing.", e52);
        }
        try {
            JSONObject a10 = xb.m14688a(context, new wy().m14588a(com_google_android_gms_internal_zzmk).m14586a((xg) a8.get()).m14587a(c3438a).m14583a(location).m14584a(bundle2).m14589a(str).m14585a(info).m14590a(a9).m14592b(bundle).m14593b(str2).m14591a(wzVar.f11234b.mo3851a(context)));
            if (a10 == null) {
                return new zzmn(0);
            }
            if (com_google_android_gms_internal_zzmk.f11992a < 7) {
                try {
                    a10.put("request_id", uuid);
                } catch (JSONException e6) {
                }
            }
            String jSONObject = a10.toString();
            qjVar.m13307a(a3, "arc");
            zl.f11678a.post(new C34282(tiVar, xcVar, qjVar, qjVar.m13301a(), jSONObject));
            zzmn com_google_android_gms_internal_zzmn;
            try {
                xf xfVar = (xf) xcVar.m14706b().get(10, TimeUnit.SECONDS);
                if (xfVar == null) {
                    com_google_android_gms_internal_zzmn = new zzmn(0);
                    return com_google_android_gms_internal_zzmn;
                } else if (xfVar.m14747a() != -2) {
                    com_google_android_gms_internal_zzmn = new zzmn(xfVar.m14747a());
                    zl.f11678a.post(new C34293(wzVar, context, xcVar, com_google_android_gms_internal_zzmk));
                    return com_google_android_gms_internal_zzmn;
                } else {
                    if (qjVar.m13311e() != null) {
                        qjVar.m13307a(qjVar.m13311e(), "rur");
                    }
                    com_google_android_gms_internal_zzmn = null;
                    if (!TextUtils.isEmpty(xfVar.m14756i())) {
                        com_google_android_gms_internal_zzmn = xb.m14682a(context, com_google_android_gms_internal_zzmk, xfVar.m14756i());
                    }
                    if (com_google_android_gms_internal_zzmn == null && !TextUtils.isEmpty(xfVar.m14752e())) {
                        com_google_android_gms_internal_zzmn = m14676a(com_google_android_gms_internal_zzmk, context, com_google_android_gms_internal_zzmk.f12002k.f12081a, xfVar.m14752e(), str2, xfVar, qjVar, wzVar);
                    }
                    if (com_google_android_gms_internal_zzmn == null) {
                        com_google_android_gms_internal_zzmn = new zzmn(0);
                    }
                    qjVar.m13307a(a3, "tts");
                    com_google_android_gms_internal_zzmn.f12059y = qjVar.m13309c();
                    zl.f11678a.post(new C34293(wzVar, context, xcVar, com_google_android_gms_internal_zzmk));
                    return com_google_android_gms_internal_zzmn;
                }
            } catch (Exception e7) {
                com_google_android_gms_internal_zzmn = new zzmn(0);
                return com_google_android_gms_internal_zzmn;
            } finally {
                zl.f11678a.post(new C34293(wzVar, context, xcVar, com_google_android_gms_internal_zzmk));
            }
        } catch (Throwable e8) {
            zzw.zzcQ().m15000a(e8, "AdRequestServiceImpl.loadAdAsync.di");
            aad.m8424c("Error fetching device info. This is not recoverable.", e8);
            return new zzmn(0);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.zzmn m14676a(com.google.android.gms.internal.zzmk r13, android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, com.google.android.gms.internal.xf r18, com.google.android.gms.internal.qj r19, com.google.android.gms.internal.wz r20) {
        /*
        if (r19 == 0) goto L_0x00db;
    L_0x0002:
        r2 = r19.m13301a();
        r3 = r2;
    L_0x0007:
        r8 = new com.google.android.gms.internal.xd;	 Catch:{ IOException -> 0x00e6 }
        r2 = r18.m14750c();	 Catch:{ IOException -> 0x00e6 }
        r8.<init>(r13, r2);	 Catch:{ IOException -> 0x00e6 }
        r4 = "AdRequestServiceImpl: Sending request: ";
        r2 = java.lang.String.valueOf(r16);	 Catch:{ IOException -> 0x00e6 }
        r5 = r2.length();	 Catch:{ IOException -> 0x00e6 }
        if (r5 == 0) goto L_0x00df;
    L_0x001c:
        r2 = r4.concat(r2);	 Catch:{ IOException -> 0x00e6 }
    L_0x0020:
        com.google.android.gms.internal.aad.m8421b(r2);	 Catch:{ IOException -> 0x00e6 }
        r4 = new java.net.URL;	 Catch:{ IOException -> 0x00e6 }
        r0 = r16;
        r4.<init>(r0);	 Catch:{ IOException -> 0x00e6 }
        r2 = 0;
        r5 = com.google.android.gms.ads.internal.zzw.zzcS();	 Catch:{ IOException -> 0x00e6 }
        r10 = r5.mo3361b();	 Catch:{ IOException -> 0x00e6 }
        r6 = r2;
        r7 = r4;
    L_0x0035:
        r2 = r7.openConnection();	 Catch:{ IOException -> 0x00e6 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ IOException -> 0x00e6 }
        r4 = com.google.android.gms.ads.internal.zzw.zzcM();	 Catch:{ all -> 0x010b }
        r5 = 0;
        r4.m15122a(r14, r15, r5, r2);	 Catch:{ all -> 0x010b }
        r4 = android.text.TextUtils.isEmpty(r17);	 Catch:{ all -> 0x010b }
        if (r4 != 0) goto L_0x0056;
    L_0x0049:
        r4 = r18.m14754g();	 Catch:{ all -> 0x010b }
        if (r4 == 0) goto L_0x0056;
    L_0x004f:
        r4 = "x-afma-drt-cookie";
        r0 = r17;
        r2.addRequestProperty(r4, r0);	 Catch:{ all -> 0x010b }
    L_0x0056:
        r4 = r13.f11978I;	 Catch:{ all -> 0x010b }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x010b }
        if (r5 != 0) goto L_0x0068;
    L_0x005e:
        r5 = "Sending webview cookie in ad request header.";
        com.google.android.gms.internal.aad.m8421b(r5);	 Catch:{ all -> 0x010b }
        r5 = "Cookie";
        r2.addRequestProperty(r5, r4);	 Catch:{ all -> 0x010b }
    L_0x0068:
        if (r18 == 0) goto L_0x0094;
    L_0x006a:
        r4 = r18.m14751d();	 Catch:{ all -> 0x010b }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x010b }
        if (r4 != 0) goto L_0x0094;
    L_0x0074:
        r4 = 1;
        r2.setDoOutput(r4);	 Catch:{ all -> 0x010b }
        r4 = r18.m14751d();	 Catch:{ all -> 0x010b }
        r9 = r4.getBytes();	 Catch:{ all -> 0x010b }
        r4 = r9.length;	 Catch:{ all -> 0x010b }
        r2.setFixedLengthStreamingMode(r4);	 Catch:{ all -> 0x010b }
        r5 = 0;
        r4 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x0105 }
        r12 = r2.getOutputStream();	 Catch:{ all -> 0x0105 }
        r4.<init>(r12);	 Catch:{ all -> 0x0105 }
        r4.write(r9);	 Catch:{ all -> 0x0197 }
        com.google.android.gms.common.util.C2586k.m8301a(r4);	 Catch:{ all -> 0x010b }
    L_0x0094:
        r9 = r2.getResponseCode();	 Catch:{ all -> 0x010b }
        r12 = r2.getHeaderFields();	 Catch:{ all -> 0x010b }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r9 < r4) goto L_0x0116;
    L_0x00a0:
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r9 >= r4) goto L_0x0116;
    L_0x00a4:
        r6 = r7.toString();	 Catch:{ all -> 0x010b }
        r5 = 0;
        r4 = new java.io.InputStreamReader;	 Catch:{ all -> 0x0110 }
        r7 = r2.getInputStream();	 Catch:{ all -> 0x0110 }
        r4.<init>(r7);	 Catch:{ all -> 0x0110 }
        r5 = com.google.android.gms.ads.internal.zzw.zzcM();	 Catch:{ all -> 0x0194 }
        r5 = r5.m15108a(r4);	 Catch:{ all -> 0x0194 }
        com.google.android.gms.common.util.C2586k.m8301a(r4);	 Catch:{ all -> 0x010b }
        m14678a(r6, r12, r5, r9);	 Catch:{ all -> 0x010b }
        r8.m14743a(r6, r12, r5);	 Catch:{ all -> 0x010b }
        if (r19 == 0) goto L_0x00d2;
    L_0x00c5:
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x010b }
        r5 = 0;
        r6 = "ufe";
        r4[r5] = r6;	 Catch:{ all -> 0x010b }
        r0 = r19;
        r0.m13307a(r3, r4);	 Catch:{ all -> 0x010b }
    L_0x00d2:
        r3 = r8.m14742a(r10);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        r2 = r3;
    L_0x00da:
        return r2;
    L_0x00db:
        r2 = 0;
        r3 = r2;
        goto L_0x0007;
    L_0x00df:
        r2 = new java.lang.String;	 Catch:{ IOException -> 0x00e6 }
        r2.<init>(r4);	 Catch:{ IOException -> 0x00e6 }
        goto L_0x0020;
    L_0x00e6:
        r2 = move-exception;
        r3 = "Error while connecting to ad server: ";
        r2 = r2.getMessage();
        r2 = java.lang.String.valueOf(r2);
        r4 = r2.length();
        if (r4 == 0) goto L_0x018d;
    L_0x00f7:
        r2 = r3.concat(r2);
    L_0x00fb:
        com.google.android.gms.internal.aad.m8426e(r2);
        r2 = new com.google.android.gms.internal.zzmn;
        r3 = 2;
        r2.<init>(r3);
        goto L_0x00da;
    L_0x0105:
        r3 = move-exception;
        r4 = r5;
    L_0x0107:
        com.google.android.gms.common.util.C2586k.m8301a(r4);	 Catch:{ all -> 0x010b }
        throw r3;	 Catch:{ all -> 0x010b }
    L_0x010b:
        r3 = move-exception;
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        throw r3;	 Catch:{ IOException -> 0x00e6 }
    L_0x0110:
        r3 = move-exception;
        r4 = r5;
    L_0x0112:
        com.google.android.gms.common.util.C2586k.m8301a(r4);	 Catch:{ all -> 0x010b }
        throw r3;	 Catch:{ all -> 0x010b }
    L_0x0116:
        r4 = r7.toString();	 Catch:{ all -> 0x010b }
        r5 = 0;
        m14678a(r4, r12, r5, r9);	 Catch:{ all -> 0x010b }
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r9 < r4) goto L_0x015d;
    L_0x0122:
        r4 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r9 >= r4) goto L_0x015d;
    L_0x0126:
        r4 = "Location";
        r4 = r2.getHeaderField(r4);	 Catch:{ all -> 0x010b }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x010b }
        if (r5 == 0) goto L_0x0142;
    L_0x0132:
        r3 = "No location header to follow redirect.";
        com.google.android.gms.internal.aad.m8426e(r3);	 Catch:{ all -> 0x010b }
        r3 = new com.google.android.gms.internal.zzmn;	 Catch:{ all -> 0x010b }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        r2 = r3;
        goto L_0x00da;
    L_0x0142:
        r5 = new java.net.URL;	 Catch:{ all -> 0x010b }
        r5.<init>(r4);	 Catch:{ all -> 0x010b }
        r4 = r6 + 1;
        r6 = 5;
        if (r4 <= r6) goto L_0x0181;
    L_0x014c:
        r3 = "Too many redirects.";
        com.google.android.gms.internal.aad.m8426e(r3);	 Catch:{ all -> 0x010b }
        r3 = new com.google.android.gms.internal.zzmn;	 Catch:{ all -> 0x010b }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        r2 = r3;
        goto L_0x00da;
    L_0x015d:
        r3 = 46;
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010b }
        r4.<init>(r3);	 Catch:{ all -> 0x010b }
        r3 = "Received error HTTP response code: ";
        r3 = r4.append(r3);	 Catch:{ all -> 0x010b }
        r3 = r3.append(r9);	 Catch:{ all -> 0x010b }
        r3 = r3.toString();	 Catch:{ all -> 0x010b }
        com.google.android.gms.internal.aad.m8426e(r3);	 Catch:{ all -> 0x010b }
        r3 = new com.google.android.gms.internal.zzmn;	 Catch:{ all -> 0x010b }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        r2 = r3;
        goto L_0x00da;
    L_0x0181:
        r8.m14744a(r12);	 Catch:{ all -> 0x010b }
        r2.disconnect();	 Catch:{ IOException -> 0x00e6 }
        if (r20 == 0) goto L_0x0189;
    L_0x0189:
        r6 = r4;
        r7 = r5;
        goto L_0x0035;
    L_0x018d:
        r2 = new java.lang.String;
        r2.<init>(r3);
        goto L_0x00fb;
    L_0x0194:
        r3 = move-exception;
        goto L_0x0112;
    L_0x0197:
        r3 = move-exception;
        goto L_0x0107;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.xa.a(com.google.android.gms.internal.zzmk, android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.xf, com.google.android.gms.internal.qj, com.google.android.gms.internal.wz):com.google.android.gms.internal.zzmn");
    }

    @Nullable
    private static <T> T m14677a(Future<T> future, Long l) {
        Throwable e;
        try {
            return future.get(l.longValue(), TimeUnit.MILLISECONDS);
        } catch (Throwable e2) {
            aad.m8424c("InterruptedException caught while resolving future.", e2);
            Thread.currentThread().interrupt();
            return null;
        } catch (RuntimeException e3) {
            e2 = e3;
            aad.m8424c("Exception caught while resolving future", e2);
            return null;
        } catch (TimeoutException e4) {
            e2 = e4;
            aad.m8424c("Exception caught while resolving future", e2);
            return null;
        } catch (ExecutionException e5) {
            e2 = e5;
            aad.m8424c("Exception caught while resolving future", e2);
            return null;
        }
    }

    private static void m14678a(String str, Map<String, List<String>> map, String str2, int i) {
        if (aad.m8420a(2)) {
            zh.m15051a(new StringBuilder(String.valueOf(str).length() + 39).append("Http Response: {\n  URL:\n    ").append(str).append("\n  Headers:").toString());
            if (map != null) {
                for (String str3 : map.keySet()) {
                    String str32;
                    zh.m15051a(new StringBuilder(String.valueOf(str32).length() + 5).append("    ").append(str32).append(":").toString());
                    for (String str322 : (List) map.get(str322)) {
                        String str4 = "      ";
                        str322 = String.valueOf(str322);
                        zh.m15051a(str322.length() != 0 ? str4.concat(str322) : new String(str4));
                    }
                }
            }
            zh.m15051a("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    zh.m15051a(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                zh.m15051a("    null");
            }
            zh.m15051a("  Response Code:\n    " + i + "\n}");
        }
    }

    public zzmn mo4188a(zzmk com_google_android_gms_internal_zzmk) {
        return m14675a(this.f11305c, this.f11308f, this.f11307e, this.f11306d, com_google_android_gms_internal_zzmk);
    }

    public void mo4189a(final zzmk com_google_android_gms_internal_zzmk, final wt wtVar) {
        zzw.zzcQ().m14994a(this.f11305c, com_google_android_gms_internal_zzmk.f12002k);
        zk.m15079a(new Runnable(this) {
            final /* synthetic */ xa f11302c;

            public void run() {
                zzmn a;
                try {
                    a = this.f11302c.mo4188a(com_google_android_gms_internal_zzmk);
                } catch (Throwable e) {
                    zzw.zzcQ().m15000a(e, "AdRequestServiceImpl.loadAdAsync");
                    aad.m8424c("Could not fetch ad response due to an Exception.", e);
                    a = null;
                }
                if (a == null) {
                    a = new zzmn(0);
                }
                try {
                    wtVar.mo4187a(a);
                } catch (Throwable e2) {
                    aad.m8424c("Fail to forward ad response.", e2);
                }
            }
        });
    }
}
