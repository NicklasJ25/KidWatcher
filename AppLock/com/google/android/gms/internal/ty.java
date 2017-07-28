package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

@wh
public class ty implements tp {
    private final zzmk f10852a;
    private final ub f10853b;
    private final Context f10854c;
    private final Object f10855d = new Object();
    private final tr f10856e;
    private final boolean f10857f;
    private final long f10858g;
    private final long f10859h;
    private final qj f10860i;
    private final boolean f10861j;
    private boolean f10862k = false;
    private tu f10863l;
    private List<tv> f10864m = new ArrayList();

    public ty(Context context, zzmk com_google_android_gms_internal_zzmk, ub ubVar, tr trVar, boolean z, boolean z2, long j, long j2, qj qjVar) {
        this.f10854c = context;
        this.f10852a = com_google_android_gms_internal_zzmk;
        this.f10853b = ubVar;
        this.f10856e = trVar;
        this.f10857f = z;
        this.f10861j = z2;
        this.f10858g = j;
        this.f10859h = j2;
        this.f10860i = qjVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.tv mo4057a(java.util.List<com.google.android.gms.internal.tq> r22) {
        /*
        r21 = this;
        r2 = "Starting mediation.";
        com.google.android.gms.internal.aad.m8421b(r2);
        r15 = new java.util.ArrayList;
        r15.<init>();
        r0 = r21;
        r2 = r0.f10860i;
        r16 = r2.m13301a();
        r17 = r22.iterator();
    L_0x0016:
        r2 = r17.hasNext();
        if (r2 == 0) goto L_0x0133;
    L_0x001c:
        r7 = r17.next();
        r7 = (com.google.android.gms.internal.tq) r7;
        r3 = "Trying mediation network: ";
        r2 = r7.f10772b;
        r2 = java.lang.String.valueOf(r2);
        r4 = r2.length();
        if (r4 == 0) goto L_0x0066;
    L_0x0030:
        r2 = r3.concat(r2);
    L_0x0034:
        com.google.android.gms.internal.aad.m8425d(r2);
        r2 = r7.f10773c;
        r18 = r2.iterator();
    L_0x003d:
        r2 = r18.hasNext();
        if (r2 == 0) goto L_0x0016;
    L_0x0043:
        r4 = r18.next();
        r4 = (java.lang.String) r4;
        r0 = r21;
        r2 = r0.f10860i;
        r19 = r2.m13301a();
        r0 = r21;
        r0 = r0.f10855d;
        r20 = r0;
        monitor-enter(r20);
        r0 = r21;
        r2 = r0.f10862k;	 Catch:{ all -> 0x010a }
        if (r2 == 0) goto L_0x006c;
    L_0x005e:
        r2 = new com.google.android.gms.internal.tv;	 Catch:{ all -> 0x010a }
        r3 = -1;
        r2.<init>(r3);	 Catch:{ all -> 0x010a }
        monitor-exit(r20);	 Catch:{ all -> 0x010a }
    L_0x0065:
        return r2;
    L_0x0066:
        r2 = new java.lang.String;
        r2.<init>(r3);
        goto L_0x0034;
    L_0x006c:
        r2 = new com.google.android.gms.internal.tu;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r3 = r0.f10854c;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r5 = r0.f10853b;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r6 = r0.f10856e;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r8 = r0.f10852a;	 Catch:{ all -> 0x010a }
        r8 = r8.f11994c;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r9 = r0.f10852a;	 Catch:{ all -> 0x010a }
        r9 = r9.f11995d;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r10 = r0.f10852a;	 Catch:{ all -> 0x010a }
        r10 = r10.f12002k;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r11 = r0.f10857f;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r12 = r0.f10861j;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r13 = r0.f10852a;	 Catch:{ all -> 0x010a }
        r13 = r13.f12016y;	 Catch:{ all -> 0x010a }
        r0 = r21;
        r14 = r0.f10852a;	 Catch:{ all -> 0x010a }
        r14 = r14.f12005n;	 Catch:{ all -> 0x010a }
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);	 Catch:{ all -> 0x010a }
        r0 = r21;
        r0.f10863l = r2;	 Catch:{ all -> 0x010a }
        monitor-exit(r20);	 Catch:{ all -> 0x010a }
        r0 = r21;
        r2 = r0.f10863l;
        r0 = r21;
        r8 = r0.f10858g;
        r0 = r21;
        r10 = r0.f10859h;
        r2 = r2.m14028a(r8, r10);
        r0 = r21;
        r3 = r0.f10864m;
        r3.add(r2);
        r3 = r2.f10827a;
        if (r3 != 0) goto L_0x010d;
    L_0x00c3:
        r3 = "Adapter succeeded.";
        com.google.android.gms.internal.aad.m8421b(r3);
        r0 = r21;
        r3 = r0.f10860i;
        r5 = "mediation_network_succeed";
        r3.m13305a(r5, r4);
        r3 = r15.isEmpty();
        if (r3 != 0) goto L_0x00e6;
    L_0x00d7:
        r0 = r21;
        r3 = r0.f10860i;
        r4 = "mediation_networks_fail";
        r5 = ",";
        r5 = android.text.TextUtils.join(r5, r15);
        r3.m13305a(r4, r5);
    L_0x00e6:
        r0 = r21;
        r3 = r0.f10860i;
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "mls";
        r4[r5] = r6;
        r0 = r19;
        r3.m13307a(r0, r4);
        r0 = r21;
        r3 = r0.f10860i;
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "ttm";
        r4[r5] = r6;
        r0 = r16;
        r3.m13307a(r0, r4);
        goto L_0x0065;
    L_0x010a:
        r2 = move-exception;
        monitor-exit(r20);	 Catch:{ all -> 0x010a }
        throw r2;
    L_0x010d:
        r15.add(r4);
        r0 = r21;
        r3 = r0.f10860i;
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "mlf";
        r4[r5] = r6;
        r0 = r19;
        r3.m13307a(r0, r4);
        r3 = r2.f10829c;
        if (r3 == 0) goto L_0x003d;
    L_0x0125:
        r3 = com.google.android.gms.internal.zl.f11678a;
        r4 = new com.google.android.gms.internal.ty$1;
        r0 = r21;
        r4.<init>(r0, r2);
        r3.post(r4);
        goto L_0x003d;
    L_0x0133:
        r2 = r15.isEmpty();
        if (r2 != 0) goto L_0x0148;
    L_0x0139:
        r0 = r21;
        r2 = r0.f10860i;
        r3 = "mediation_networks_fail";
        r4 = ",";
        r4 = android.text.TextUtils.join(r4, r15);
        r2.m13305a(r3, r4);
    L_0x0148:
        r2 = new com.google.android.gms.internal.tv;
        r3 = 1;
        r2.<init>(r3);
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ty.a(java.util.List):com.google.android.gms.internal.tv");
    }

    public void mo4058a() {
        synchronized (this.f10855d) {
            this.f10862k = true;
            if (this.f10863l != null) {
                this.f10863l.m14030a();
            }
        }
    }

    public List<tv> mo4059b() {
        return this.f10864m;
    }
}
