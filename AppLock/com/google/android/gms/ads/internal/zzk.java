package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import com.android.gallery3d.exif.ExifTag.GpsMeasureMode;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.oq.C2384a;
import com.google.android.gms.internal.ox;
import com.google.android.gms.internal.rn;
import com.google.android.gms.internal.ro;
import com.google.android.gms.internal.rp;
import com.google.android.gms.internal.rq;
import com.google.android.gms.internal.ub;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.zl;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzhc;
import com.google.android.gms.internal.zzqh;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@wh
public class zzk extends C2384a {
    private final Context f6971a;
    private final op f6972b;
    private final ub f6973c;
    @Nullable
    private final rn f6974d;
    @Nullable
    private final ro f6975e;
    private final SimpleArrayMap<String, rq> f6976f;
    private final SimpleArrayMap<String, rp> f6977g;
    private final zzhc f6978h;
    private final List<String> f6979i;
    private final ox f6980j;
    private final String f6981k;
    private final zzqh f6982l;
    @Nullable
    private WeakReference<zzs> f6983m;
    private final zze f6984n;
    private final Object f6985o = new Object();

    zzk(Context context, String str, ub ubVar, zzqh com_google_android_gms_internal_zzqh, op opVar, rn rnVar, ro roVar, SimpleArrayMap<String, rq> simpleArrayMap, SimpleArrayMap<String, rp> simpleArrayMap2, zzhc com_google_android_gms_internal_zzhc, ox oxVar, zze com_google_android_gms_ads_internal_zze) {
        this.f6971a = context;
        this.f6981k = str;
        this.f6973c = ubVar;
        this.f6982l = com_google_android_gms_internal_zzqh;
        this.f6972b = opVar;
        this.f6975e = roVar;
        this.f6974d = rnVar;
        this.f6976f = simpleArrayMap;
        this.f6977g = simpleArrayMap2;
        this.f6978h = com_google_android_gms_internal_zzhc;
        this.f6979i = m7513b();
        this.f6980j = oxVar;
        this.f6984n = com_google_android_gms_ads_internal_zze;
    }

    private List<String> m7513b() {
        List<String> arrayList = new ArrayList();
        if (this.f6975e != null) {
            arrayList.add("1");
        }
        if (this.f6974d != null) {
            arrayList.add(GpsMeasureMode.MODE_2_DIMENSIONAL);
        }
        if (this.f6976f.size() > 0) {
            arrayList.add(GpsMeasureMode.MODE_3_DIMENSIONAL);
        }
        return arrayList;
    }

    protected zzs m7521a() {
        return new zzs(this.f6971a, this.f6984n, zzeg.m15383a(this.f6971a), this.f6981k, this.f6973c, this.f6982l);
    }

    protected void m7522a(Runnable runnable) {
        zl.f11678a.post(runnable);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.Nullable
    public java.lang.String getMediationAdapterClassName() {
        /*
        r3 = this;
        r1 = 0;
        r2 = r3.f6985o;
        monitor-enter(r2);
        r0 = r3.f6983m;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001a;
    L_0x0008:
        r0 = r3.f6983m;	 Catch:{ all -> 0x001d }
        r0 = r0.get();	 Catch:{ all -> 0x001d }
        r0 = (com.google.android.gms.ads.internal.zzs) r0;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0018;
    L_0x0012:
        r0 = r0.getMediationAdapterClassName();	 Catch:{ all -> 0x001d }
    L_0x0016:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
    L_0x0017:
        return r0;
    L_0x0018:
        r0 = r1;
        goto L_0x0016;
    L_0x001a:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        r0 = r1;
        goto L_0x0017;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzk.getMediationAdapterClassName():java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isLoading() {
        /*
        r3 = this;
        r1 = 0;
        r2 = r3.f6985o;
        monitor-enter(r2);
        r0 = r3.f6983m;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001a;
    L_0x0008:
        r0 = r3.f6983m;	 Catch:{ all -> 0x001d }
        r0 = r0.get();	 Catch:{ all -> 0x001d }
        r0 = (com.google.android.gms.ads.internal.zzs) r0;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0018;
    L_0x0012:
        r0 = r0.isLoading();	 Catch:{ all -> 0x001d }
    L_0x0016:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
    L_0x0017:
        return r0;
    L_0x0018:
        r0 = r1;
        goto L_0x0016;
    L_0x001a:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        r0 = r1;
        goto L_0x0017;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzk.isLoading():boolean");
    }

    public void zzf(final zzec com_google_android_gms_internal_zzec) {
        m7522a(new Runnable(this) {
            final /* synthetic */ zzk f6970b;

            public void run() {
                synchronized (this.f6970b.f6985o) {
                    zzs a = this.f6970b.m7521a();
                    this.f6970b.f6983m = new WeakReference(a);
                    a.zzb(this.f6970b.f6974d);
                    a.zzb(this.f6970b.f6975e);
                    a.zza(this.f6970b.f6976f);
                    a.zza(this.f6970b.f6972b);
                    a.zzb(this.f6970b.f6977g);
                    a.zzb(this.f6970b.m7513b());
                    a.zzb(this.f6970b.f6978h);
                    a.zza(this.f6970b.f6980j);
                    a.zzb(com_google_android_gms_internal_zzec);
                }
            }
        });
    }
}
