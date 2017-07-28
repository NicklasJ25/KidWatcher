package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.vr.C3366a;
import com.google.android.gms.internal.vs.C2360a;
import com.google.android.gms.internal.yy.C3457a;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@wh
public class vw extends vr {
    tp f11047g;
    protected tv f11048h;
    private ub f11049i;
    private tr f11050j;
    private final qj f11051k;
    private final aat f11052l;
    private boolean f11053m;

    vw(Context context, C3457a c3457a, ub ubVar, C2360a c2360a, qj qjVar, aat com_google_android_gms_internal_aat) {
        super(context, c3457a, c2360a);
        this.f11049i = ubVar;
        this.f11050j = c3457a.f11511c;
        this.f11051k = qjVar;
        this.f11052l = com_google_android_gms_internal_aat;
    }

    private static String m14383a(tv tvVar) {
        String str = tvVar.f10828b.f10774d;
        int b = m14387b(tvVar.f10827a);
        return new StringBuilder(String.valueOf(str).length() + 33).append(str).append(".").append(b).append(".").append(tvVar.f10833g).toString();
    }

    private static String m14384a(List<tv> list) {
        String str = "";
        if (list == null) {
            return str.toString();
        }
        String str2 = str;
        for (tv tvVar : list) {
            if (!(tvVar == null || tvVar.f10828b == null || TextUtils.isEmpty(tvVar.f10828b.f10774d))) {
                str2 = String.valueOf(str2);
                str = String.valueOf(m14383a(tvVar));
                str2 = new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(str).length()).append(str2).append(str).append("_").toString();
            }
        }
        return str2.substring(0, Math.max(0, str2.length() - 1));
    }

    private void m14385a() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        zl.f11678a.post(new Runnable(this) {
            final /* synthetic */ vw f11046b;

            public void run() {
                synchronized (this.f11046b.d) {
                    this.f11046b.f11053m = zzp.zza(this.f11046b.f11052l, this.f11046b.f11048h, countDownLatch);
                }
            }
        });
        try {
            countDownLatch.await(10, TimeUnit.SECONDS);
            synchronized (this.d) {
                if (!this.f11053m) {
                    throw new C3366a("View could not be prepared", 0);
                } else if (this.f11052l.mo3435r()) {
                    throw new C3366a("Assets not loaded, web view is destroyed", 0);
                }
            }
        } catch (InterruptedException e) {
            String valueOf = String.valueOf(e);
            throw new C3366a(new StringBuilder(String.valueOf(valueOf).length() + 38).append("Interrupted while waiting for latch : ").append(valueOf).toString(), 0);
        }
    }

    private static int m14387b(int i) {
        switch (i) {
            case -1:
                return 4;
            case 0:
                return 0;
            case 1:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 5;
            default:
                return 6;
        }
    }

    protected yy mo4174a(int i) {
        zzmk com_google_android_gms_internal_zzmk = this.e.f11509a;
        return new yy(com_google_android_gms_internal_zzmk.f11994c, this.f11052l, this.f.f12038d, i, this.f.f12040f, this.f.f12044j, this.f.f12046l, this.f.f12045k, com_google_android_gms_internal_zzmk.f12000i, this.f.f12042h, this.f11048h != null ? this.f11048h.f10828b : null, this.f11048h != null ? this.f11048h.f10829c : null, this.f11048h != null ? this.f11048h.f10830d : AdMobAdapter.class.getName(), this.f11050j, this.f11048h != null ? this.f11048h.f10831e : null, this.f.f12043i, this.e.f11512d, this.f.f12041g, this.e.f11514f, this.f.f12048n, this.f.f12049o, this.e.f11516h, null, this.f.f12020C, this.f.f12021D, this.f.f12022E, this.f11050j != null ? this.f11050j.f10800n : false, this.f.f12024G, this.f11047g != null ? m14384a(this.f11047g.mo4059b()) : null, this.f.f12027J, this.f.f12031N);
    }

    protected void mo4175a(long j) {
        boolean z;
        ListIterator listIterator;
        synchronized (this.d) {
            this.f11047g = m14390b(j);
        }
        List arrayList = new ArrayList(this.f11050j.f10787a);
        Bundle bundle = this.e.f11509a.f11994c.f11889m;
        String str = "com.google.ads.mediation.admob.AdMobAdapter";
        if (bundle != null) {
            bundle = bundle.getBundle(str);
            if (bundle != null) {
                z = bundle.getBoolean("_skipMediation");
                if (z) {
                    listIterator = arrayList.listIterator();
                    while (listIterator.hasNext()) {
                        if (!((tq) listIterator.next()).f10773c.contains(str)) {
                            listIterator.remove();
                        }
                    }
                }
                this.f11048h = this.f11047g.mo4057a(arrayList);
                switch (this.f11048h.f10827a) {
                    case 0:
                        if (this.f11048h.f10828b != null && this.f11048h.f10828b.f10782l != null) {
                            m14385a();
                            return;
                        }
                        return;
                    case 1:
                        throw new C3366a("No fill from any mediation ad networks.", 3);
                    default:
                        throw new C3366a("Unexpected mediation result: " + this.f11048h.f10827a, 0);
                }
            }
        }
        z = false;
        if (z) {
            listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (!((tq) listIterator.next()).f10773c.contains(str)) {
                    listIterator.remove();
                }
            }
        }
        this.f11048h = this.f11047g.mo4057a(arrayList);
        switch (this.f11048h.f10827a) {
            case 0:
                if (this.f11048h.f10828b != null) {
                    return;
                }
                return;
            case 1:
                throw new C3366a("No fill from any mediation ad networks.", 3);
            default:
                throw new C3366a("Unexpected mediation result: " + this.f11048h.f10827a, 0);
        }
    }

    tp m14390b(long j) {
        if (this.f11050j.f10798l != -1) {
            return new tx(this.b, this.e.f11509a, this.f11049i, this.f11050j, this.f.f12054t, this.f.f12019B, j, ((Long) qb.bG.m13225c()).longValue(), 2);
        }
        return new ty(this.b, this.e.f11509a, this.f11049i, this.f11050j, this.f.f12054t, this.f.f12019B, j, ((Long) qb.bG.m13225c()).longValue(), this.f11051k);
    }

    public void onStop() {
        synchronized (this.d) {
            super.onStop();
            if (this.f11047g != null) {
                this.f11047g.mo4058a();
            }
        }
    }
}
