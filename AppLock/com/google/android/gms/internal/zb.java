package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.C2590o;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ng.C3095b;
import com.google.android.gms.internal.zj.C3460b;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

@wh
public class zb implements C3095b, C3460b {
    private String f11574A = "";
    private long f11575B = 0;
    private long f11576C = 0;
    private long f11577D = 0;
    private int f11578E = -1;
    private final AtomicInteger f11579F = new AtomicInteger(0);
    private final Object f11580a = new Object();
    private final String f11581b;
    private final zc f11582c;
    private mu f11583d;
    private BigInteger f11584e = BigInteger.ONE;
    private final HashSet<yz> f11585f = new HashSet();
    private final HashMap<String, ze> f11586g = new HashMap();
    private boolean f11587h = false;
    private boolean f11588i = true;
    private int f11589j = 0;
    private boolean f11590k = false;
    private Context f11591l;
    private zzqh f11592m;
    private qd f11593n = null;
    private boolean f11594o = true;
    private boolean f11595p = true;
    private nh f11596q = null;
    private nf f11597r = null;
    private String f11598s;
    private String f11599t;
    private Boolean f11600u = null;
    private String f11601v;
    private boolean f11602w = false;
    private boolean f11603x = false;
    private boolean f11604y = false;
    private boolean f11605z = false;

    public zb(zl zlVar) {
        this.f11581b = zlVar.m15151d();
        this.f11582c = new zc(this.f11581b);
    }

    public Bundle m14987a(Context context, zd zdVar, String str) {
        Bundle bundle;
        synchronized (this.f11580a) {
            bundle = new Bundle();
            bundle.putBundle("app", this.f11582c.m15040a(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.f11586g.keySet()) {
                bundle2.putBundle(str2, ((ze) this.f11586g.get(str2)).m15046a());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f11585f.iterator();
            while (it.hasNext()) {
                arrayList.add(((yz) it.next()).m14976d());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zdVar.zza(this.f11585f);
            this.f11585f.clear();
        }
        return bundle;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.nh m14988a(android.content.Context r6) {
        /*
        r5 = this;
        r1 = 0;
        r0 = com.google.android.gms.internal.qb.f10283W;
        r0 = r0.m13225c();
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0011;
    L_0x000f:
        r0 = r1;
    L_0x0010:
        return r0;
    L_0x0011:
        com.google.android.gms.common.util.C2590o.m8307b();
        r0 = com.google.android.gms.internal.qb.ae;
        r0 = r0.m13225c();
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0032;
    L_0x0022:
        r0 = com.google.android.gms.internal.qb.ac;
        r0 = r0.m13225c();
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0032;
    L_0x0030:
        r0 = r1;
        goto L_0x0010;
    L_0x0032:
        r0 = r5.m15008b();
        if (r0 == 0) goto L_0x0040;
    L_0x0038:
        r0 = r5.m15010c();
        if (r0 == 0) goto L_0x0040;
    L_0x003e:
        r0 = r1;
        goto L_0x0010;
    L_0x0040:
        r2 = r5.f11580a;
        monitor-enter(r2);
        r0 = android.os.Looper.getMainLooper();	 Catch:{ all -> 0x0077 }
        if (r0 == 0) goto L_0x004b;
    L_0x0049:
        if (r6 != 0) goto L_0x004e;
    L_0x004b:
        monitor-exit(r2);	 Catch:{ all -> 0x0077 }
        r0 = r1;
        goto L_0x0010;
    L_0x004e:
        r0 = r5.f11597r;	 Catch:{ all -> 0x0077 }
        if (r0 != 0) goto L_0x0059;
    L_0x0052:
        r0 = new com.google.android.gms.internal.nf;	 Catch:{ all -> 0x0077 }
        r0.<init>();	 Catch:{ all -> 0x0077 }
        r5.f11597r = r0;	 Catch:{ all -> 0x0077 }
    L_0x0059:
        r0 = r5.f11596q;	 Catch:{ all -> 0x0077 }
        if (r0 != 0) goto L_0x006e;
    L_0x005d:
        r0 = new com.google.android.gms.internal.nh;	 Catch:{ all -> 0x0077 }
        r1 = r5.f11597r;	 Catch:{ all -> 0x0077 }
        r3 = r5.f11591l;	 Catch:{ all -> 0x0077 }
        r4 = r5.f11592m;	 Catch:{ all -> 0x0077 }
        r3 = com.google.android.gms.internal.wf.m14481a(r3, r4);	 Catch:{ all -> 0x0077 }
        r0.<init>(r1, r3);	 Catch:{ all -> 0x0077 }
        r5.f11596q = r0;	 Catch:{ all -> 0x0077 }
    L_0x006e:
        r0 = r5.f11596q;	 Catch:{ all -> 0x0077 }
        r0.m12787a();	 Catch:{ all -> 0x0077 }
        r0 = r5.f11596q;	 Catch:{ all -> 0x0077 }
        monitor-exit(r2);	 Catch:{ all -> 0x0077 }
        goto L_0x0010;
    L_0x0077:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0077 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zb.a(android.content.Context):com.google.android.gms.internal.nh");
    }

    public String m14989a() {
        return this.f11581b;
    }

    Future m14990a(int i) {
        Future a;
        synchronized (this.f11580a) {
            this.f11578E = i;
            a = zj.m15055a(this.f11591l, i);
        }
        return a;
    }

    Future m14991a(long j) {
        Future a;
        synchronized (this.f11580a) {
            this.f11576C = j;
            a = zj.m15056a(this.f11591l, j);
        }
        return a;
    }

    public Future m14992a(Context context, boolean z) {
        Future a;
        synchronized (this.f11580a) {
            if (z != this.f11588i) {
                this.f11588i = z;
                a = zj.m15060a(context, z);
            } else {
                a = null;
            }
        }
        return a;
    }

    public Future m14993a(String str) {
        Future a;
        synchronized (this.f11580a) {
            if (str != null) {
                if (!str.equals(this.f11598s)) {
                    this.f11598s = str;
                    a = zj.m15058a(this.f11591l, str);
                }
            }
            a = null;
        }
        return a;
    }

    @TargetApi(23)
    public void m14994a(Context context, zzqh com_google_android_gms_internal_zzqh) {
        synchronized (this.f11580a) {
            if (!this.f11590k) {
                this.f11591l = context.getApplicationContext();
                this.f11592m = com_google_android_gms_internal_zzqh;
                zzw.zzcP().m12783a((C3095b) this);
                zj.m15057a(context, (C3460b) this);
                zj.m15062b(context, (C3460b) this);
                zj.m15065c(context, (C3460b) this);
                zj.m15068d(context, (C3460b) this);
                zj.m15070e(context, (C3460b) this);
                zj.m15072f(context, this);
                zj.m15073g(context, this);
                zj.m15074h(context, this);
                zj.m15075i(context, this);
                m15032u();
                this.f11601v = zzw.zzcM().m15106a(context, com_google_android_gms_internal_zzqh.f12081a);
                if (C2590o.m8316k() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                    this.f11603x = true;
                }
                this.f11583d = new mu(context.getApplicationContext(), this.f11592m, zzw.zzcM().m15103a(context, com_google_android_gms_internal_zzqh));
                m15034w();
                zzw.zzda().zzv(this.f11591l);
                this.f11590k = true;
            }
        }
    }

    public void m14995a(Context context, String str) {
        zj.m15067c(context, str);
    }

    public void mo4246a(Bundle bundle) {
        synchronized (this.f11580a) {
            this.f11588i = bundle.getBoolean("use_https", this.f11588i);
            this.f11589j = bundle.getInt("webview_cache_version", this.f11589j);
            if (bundle.containsKey("content_url_opted_out")) {
                m15007b(bundle.getBoolean("content_url_opted_out"));
            }
            if (bundle.containsKey("content_url_hashes")) {
                this.f11598s = bundle.getString("content_url_hashes");
            }
            this.f11604y = bundle.getBoolean("auto_collect_location", this.f11604y);
            if (bundle.containsKey("content_vertical_opted_out")) {
                m15009c(bundle.getBoolean("content_vertical_opted_out"));
            }
            if (bundle.containsKey("content_vertical_hashes")) {
                this.f11599t = bundle.getString("content_vertical_hashes");
            }
            this.f11574A = bundle.containsKey("app_settings_json") ? bundle.getString("app_settings_json") : this.f11574A;
            this.f11575B = bundle.getLong("app_settings_last_update_ms", this.f11575B);
            this.f11576C = bundle.getLong("app_last_background_time_ms", this.f11576C);
            this.f11578E = bundle.getInt("request_in_session_count", this.f11578E);
            this.f11577D = bundle.getLong("first_ad_req_time_ms", this.f11577D);
        }
    }

    public void m14997a(yz yzVar) {
        synchronized (this.f11580a) {
            this.f11585f.add(yzVar);
        }
    }

    public void m14998a(Boolean bool) {
        synchronized (this.f11580a) {
            this.f11600u = bool;
        }
    }

    public void m14999a(String str, ze zeVar) {
        synchronized (this.f11580a) {
            this.f11586g.put(str, zeVar);
        }
    }

    public void m15000a(Throwable th, String str) {
        wf.m14481a(this.f11591l, this.f11592m).mo4182a(th, str);
    }

    public void m15001a(HashSet<yz> hashSet) {
        synchronized (this.f11580a) {
            this.f11585f.addAll(hashSet);
        }
    }

    public void mo3849a(boolean z) {
        long a = zzw.zzcS().mo3360a();
        if (!z) {
            m14991a(a);
            m14990a(this.f11582c.m15045d());
        } else if (a - this.f11576C > ((Long) qb.aL.m13225c()).longValue()) {
            this.f11582c.m15041a(-1);
        } else {
            this.f11582c.m15041a(this.f11578E);
        }
    }

    Future m15003b(long j) {
        Future b;
        synchronized (this.f11580a) {
            this.f11577D = j;
            b = zj.m15061b(this.f11591l, j);
        }
        return b;
    }

    public Future m15004b(Context context, boolean z) {
        Future c;
        synchronized (this.f11580a) {
            if (z != this.f11604y) {
                this.f11604y = z;
                c = zj.m15066c(context, z);
            } else {
                c = null;
            }
        }
        return c;
    }

    public Future m15005b(String str) {
        Future b;
        synchronized (this.f11580a) {
            if (str != null) {
                if (!str.equals(this.f11599t)) {
                    this.f11599t = str;
                    b = zj.m15063b(this.f11591l, str);
                }
            }
            b = null;
        }
        return b;
    }

    public void m15006b(Context context, String str) {
        zj.m15069d(context, str);
    }

    public void m15007b(boolean z) {
        synchronized (this.f11580a) {
            if (this.f11594o != z) {
                zj.m15064b(this.f11591l, z);
            }
            this.f11594o = z;
            nh a = m14988a(this.f11591l);
            if (!(a == null || a.isAlive())) {
                aad.m8425d("start fetching content...");
                a.m12787a();
            }
        }
    }

    public boolean m15008b() {
        boolean z;
        synchronized (this.f11580a) {
            z = this.f11594o;
        }
        return z;
    }

    public void m15009c(boolean z) {
        synchronized (this.f11580a) {
            if (this.f11595p != z) {
                zj.m15064b(this.f11591l, z);
            }
            zj.m15064b(this.f11591l, z);
            this.f11595p = z;
            nh a = m14988a(this.f11591l);
            if (!(a == null || a.isAlive())) {
                aad.m8425d("start fetching content...");
                a.m12787a();
            }
        }
    }

    public boolean m15010c() {
        boolean z;
        synchronized (this.f11580a) {
            z = this.f11595p;
        }
        return z;
    }

    public boolean m15011c(Context context, String str) {
        return zj.m15071e(context, str);
    }

    public String m15012d() {
        String bigInteger;
        synchronized (this.f11580a) {
            bigInteger = this.f11584e.toString();
            this.f11584e = this.f11584e.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public Future m15013d(Context context, String str) {
        Future a;
        this.f11575B = zzw.zzcS().mo3360a();
        synchronized (this.f11580a) {
            if (str != null) {
                if (!str.equals(this.f11574A)) {
                    this.f11574A = str;
                    a = zj.m15059a(context, str, this.f11575B);
                }
            }
            a = null;
        }
        return a;
    }

    public void m15014d(boolean z) {
        this.f11605z = z;
    }

    public zc m15015e() {
        zc zcVar;
        synchronized (this.f11580a) {
            zcVar = this.f11582c;
        }
        return zcVar;
    }

    public void m15016e(boolean z) {
        synchronized (this.f11580a) {
            this.f11602w = z;
        }
    }

    public qd m15017f() {
        qd qdVar;
        synchronized (this.f11580a) {
            qdVar = this.f11593n;
        }
        return qdVar;
    }

    public boolean m15018g() {
        boolean z;
        synchronized (this.f11580a) {
            z = this.f11587h;
            this.f11587h = true;
        }
        return z;
    }

    public boolean m15019h() {
        boolean z;
        synchronized (this.f11580a) {
            z = this.f11588i || this.f11603x;
        }
        return z;
    }

    public String m15020i() {
        String str;
        synchronized (this.f11580a) {
            str = this.f11601v;
        }
        return str;
    }

    public String m15021j() {
        String str;
        synchronized (this.f11580a) {
            str = this.f11598s;
        }
        return str;
    }

    public String m15022k() {
        String str;
        synchronized (this.f11580a) {
            str = this.f11599t;
        }
        return str;
    }

    public Boolean m15023l() {
        Boolean bool;
        synchronized (this.f11580a) {
            bool = this.f11600u;
        }
        return bool;
    }

    public boolean m15024m() {
        boolean z;
        synchronized (this.f11580a) {
            z = this.f11604y;
        }
        return z;
    }

    long m15025n() {
        long j;
        synchronized (this.f11580a) {
            j = this.f11576C;
        }
        return j;
    }

    long m15026o() {
        long j;
        synchronized (this.f11580a) {
            j = this.f11577D;
        }
        return j;
    }

    int m15027p() {
        int i;
        synchronized (this.f11580a) {
            i = this.f11578E;
        }
        return i;
    }

    public boolean m15028q() {
        return this.f11605z;
    }

    public za m15029r() {
        za zaVar;
        synchronized (this.f11580a) {
            zaVar = new za(this.f11574A, this.f11575B);
        }
        return zaVar;
    }

    public mu m15030s() {
        return this.f11583d;
    }

    public Resources m15031t() {
        if (this.f11592m.f12084d) {
            return this.f11591l.getResources();
        }
        try {
            DynamiteModule a = DynamiteModule.m8341a(this.f11591l, DynamiteModule.f7574a, ModuleDescriptor.MODULE_ID);
            return a != null ? a.m8352a().getResources() : null;
        } catch (Throwable e) {
            aad.m8424c("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public void m15032u() {
        wf.m14481a(this.f11591l, this.f11592m);
    }

    public boolean m15033v() {
        boolean z;
        synchronized (this.f11580a) {
            z = this.f11602w;
        }
        return z;
    }

    void m15034w() {
        try {
            this.f11593n = zzw.zzcT().m13284a(new qc(this.f11591l, this.f11592m.f12081a));
        } catch (Throwable e) {
            aad.m8424c("Cannot initialize CSI reporter.", e);
        }
    }

    public void m15035x() {
        this.f11579F.incrementAndGet();
    }

    public void m15036y() {
        this.f11579F.decrementAndGet();
    }

    public int m15037z() {
        return this.f11579F.get();
    }
}
