package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@wh
public class tx implements tp {
    private final zzmk f10838a;
    private final ub f10839b;
    private final Context f10840c;
    private final tr f10841d;
    private final boolean f10842e;
    private final long f10843f;
    private final long f10844g;
    private final int f10845h;
    private final Object f10846i = new Object();
    private boolean f10847j = false;
    private final Map<aaj<tv>, tu> f10848k = new HashMap();
    private final boolean f10849l;
    private List<tv> f10850m = new ArrayList();

    public tx(Context context, zzmk com_google_android_gms_internal_zzmk, ub ubVar, tr trVar, boolean z, boolean z2, long j, long j2, int i) {
        this.f10840c = context;
        this.f10838a = com_google_android_gms_internal_zzmk;
        this.f10839b = ubVar;
        this.f10841d = trVar;
        this.f10842e = z;
        this.f10849l = z2;
        this.f10843f = j;
        this.f10844g = j2;
        this.f10845h = i;
    }

    private void m14037a(final aaj<tv> com_google_android_gms_internal_aaj_com_google_android_gms_internal_tv) {
        zl.f11678a.post(new Runnable(this) {
            final /* synthetic */ tx f10837b;

            public void run() {
                for (aaj com_google_android_gms_internal_aaj : this.f10837b.f10848k.keySet()) {
                    if (com_google_android_gms_internal_aaj != com_google_android_gms_internal_aaj_com_google_android_gms_internal_tv) {
                        ((tu) this.f10837b.f10848k.get(com_google_android_gms_internal_aaj)).m14030a();
                    }
                }
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.gms.internal.tv m14038b(java.util.List<com.google.android.gms.internal.aaj<com.google.android.gms.internal.tv>> r5) {
        /*
        r4 = this;
        r2 = r4.f10846i;
        monitor-enter(r2);
        r0 = r4.f10847j;	 Catch:{ all -> 0x003c }
        if (r0 == 0) goto L_0x000f;
    L_0x0007:
        r1 = new com.google.android.gms.internal.tv;	 Catch:{ all -> 0x003c }
        r0 = -1;
        r1.<init>(r0);	 Catch:{ all -> 0x003c }
        monitor-exit(r2);	 Catch:{ all -> 0x003c }
    L_0x000e:
        return r1;
    L_0x000f:
        monitor-exit(r2);	 Catch:{ all -> 0x003c }
        r2 = r5.iterator();
    L_0x0014:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x003f;
    L_0x001a:
        r0 = r2.next();
        r0 = (com.google.android.gms.internal.aaj) r0;
        r1 = r0.get();	 Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
        r1 = (com.google.android.gms.internal.tv) r1;	 Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
        r3 = r4.f10850m;	 Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
        r3.add(r1);	 Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
        if (r1 == 0) goto L_0x0014;
    L_0x002d:
        r3 = r1.f10827a;	 Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
        if (r3 != 0) goto L_0x0014;
    L_0x0031:
        r4.m14037a(r0);	 Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
        goto L_0x000e;
    L_0x0035:
        r0 = move-exception;
    L_0x0036:
        r1 = "Exception while processing an adapter; continuing with other adapters";
        com.google.android.gms.internal.aad.m8424c(r1, r0);
        goto L_0x0014;
    L_0x003c:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x003c }
        throw r0;
    L_0x003f:
        r0 = 0;
        r4.m14037a(r0);
        r1 = new com.google.android.gms.internal.tv;
        r0 = 1;
        r1.<init>(r0);
        goto L_0x000e;
    L_0x004a:
        r0 = move-exception;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.tx.b(java.util.List):com.google.android.gms.internal.tv");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.gms.internal.tv m14041c(java.util.List<com.google.android.gms.internal.aaj<com.google.android.gms.internal.tv>> r16) {
        /*
        r15 = this;
        r1 = r15.f10846i;
        monitor-enter(r1);
        r0 = r15.f10847j;	 Catch:{ all -> 0x0080 }
        if (r0 == 0) goto L_0x000f;
    L_0x0007:
        r2 = new com.google.android.gms.internal.tv;	 Catch:{ all -> 0x0080 }
        r0 = -1;
        r2.<init>(r0);	 Catch:{ all -> 0x0080 }
        monitor-exit(r1);	 Catch:{ all -> 0x0080 }
    L_0x000e:
        return r2;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x0080 }
        r4 = -1;
        r3 = 0;
        r2 = 0;
        r0 = r15.f10841d;
        r0 = r0.f10799m;
        r6 = -1;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 == 0) goto L_0x0083;
    L_0x001d:
        r0 = r15.f10841d;
        r0 = r0.f10799m;
    L_0x0021:
        r8 = r16.iterator();
        r6 = r0;
    L_0x0026:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x00b9;
    L_0x002c:
        r0 = r8.next();
        r0 = (com.google.android.gms.internal.aaj) r0;
        r1 = com.google.android.gms.ads.internal.zzw.zzcS();
        r10 = r1.mo3360a();
        r12 = 0;
        r1 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r1 != 0) goto L_0x0086;
    L_0x0040:
        r1 = r0.isDone();	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        if (r1 == 0) goto L_0x0086;
    L_0x0046:
        r1 = r0.get();	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        r1 = (com.google.android.gms.internal.tv) r1;	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
    L_0x004c:
        r5 = r15.f10850m;	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        r5.add(r1);	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        if (r1 == 0) goto L_0x00cc;
    L_0x0053:
        r5 = r1.f10827a;	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        if (r5 != 0) goto L_0x00cc;
    L_0x0057:
        r5 = r1.f10832f;	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        if (r5 == 0) goto L_0x00cc;
    L_0x005b:
        r9 = r5.mo4054a();	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        if (r9 <= r4) goto L_0x00cc;
    L_0x0061:
        r2 = r5.mo4054a();	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        r14 = r1;
        r1 = r0;
        r0 = r14;
    L_0x0068:
        r3 = com.google.android.gms.ads.internal.zzw.zzcS();
        r4 = r3.mo3360a();
        r4 = r4 - r10;
        r4 = r6 - r4;
        r6 = 0;
        r4 = java.lang.Math.max(r4, r6);
        r3 = r1;
        r14 = r0;
        r0 = r4;
        r4 = r2;
        r2 = r14;
    L_0x007e:
        r6 = r0;
        goto L_0x0026;
    L_0x0080:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0080 }
        throw r0;
    L_0x0083:
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        goto L_0x0021;
    L_0x0086:
        r1 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        r1 = r0.get(r6, r1);	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        r1 = (com.google.android.gms.internal.tv) r1;	 Catch:{ InterruptedException -> 0x00c6, ExecutionException -> 0x00c8, RemoteException -> 0x008f, TimeoutException -> 0x00ca }
        goto L_0x004c;
    L_0x008f:
        r0 = move-exception;
    L_0x0090:
        r1 = "Exception while processing an adapter; continuing with other adapters";
        com.google.android.gms.internal.aad.m8424c(r1, r0);	 Catch:{ all -> 0x00a7 }
        r0 = com.google.android.gms.ads.internal.zzw.zzcS();
        r0 = r0.mo3360a();
        r0 = r0 - r10;
        r0 = r6 - r0;
        r6 = 0;
        r0 = java.lang.Math.max(r0, r6);
        goto L_0x007e;
    L_0x00a7:
        r0 = move-exception;
        r1 = com.google.android.gms.ads.internal.zzw.zzcS();
        r2 = r1.mo3360a();
        r2 = r2 - r10;
        r2 = r6 - r2;
        r4 = 0;
        java.lang.Math.max(r2, r4);
        throw r0;
    L_0x00b9:
        r15.m14037a(r3);
        if (r2 != 0) goto L_0x000e;
    L_0x00be:
        r2 = new com.google.android.gms.internal.tv;
        r0 = 1;
        r2.<init>(r0);
        goto L_0x000e;
    L_0x00c6:
        r0 = move-exception;
        goto L_0x0090;
    L_0x00c8:
        r0 = move-exception;
        goto L_0x0090;
    L_0x00ca:
        r0 = move-exception;
        goto L_0x0090;
    L_0x00cc:
        r0 = r2;
        r1 = r3;
        r2 = r4;
        goto L_0x0068;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.tx.c(java.util.List):com.google.android.gms.internal.tv");
    }

    public tv mo4057a(List<tq> list) {
        aad.m8421b("Starting mediation.");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        List arrayList = new ArrayList();
        for (tq tqVar : list) {
            String str = "Trying mediation network: ";
            String valueOf = String.valueOf(tqVar.f10772b);
            aad.m8425d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            for (String tuVar : tqVar.f10773c) {
                final tu tuVar2 = new tu(this.f10840c, tuVar, this.f10839b, this.f10841d, tqVar, this.f10838a.f11994c, this.f10838a.f11995d, this.f10838a.f12002k, this.f10842e, this.f10849l, this.f10838a.f12016y, this.f10838a.f12005n);
                aaj a = zk.m15081a(newCachedThreadPool, new Callable<tv>(this) {
                    final /* synthetic */ tx f10835b;

                    public tv m14035a() {
                        synchronized (this.f10835b.f10846i) {
                            if (this.f10835b.f10847j) {
                                return null;
                            }
                            return tuVar2.m14028a(this.f10835b.f10843f, this.f10835b.f10844g);
                        }
                    }

                    public /* synthetic */ Object call() {
                        return m14035a();
                    }
                });
                this.f10848k.put(a, tuVar2);
                arrayList.add(a);
            }
        }
        switch (this.f10845h) {
            case 2:
                return m14041c(arrayList);
            default:
                return m14038b(arrayList);
        }
    }

    public void mo4058a() {
        synchronized (this.f10846i) {
            this.f10847j = true;
            for (tu a : this.f10848k.values()) {
                a.m14030a();
            }
        }
    }

    public List<tv> mo4059b() {
        return this.f10850m;
    }
}
