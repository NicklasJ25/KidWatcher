package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.xg.C3435a;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@wh
public final class xh {
    private WeakHashMap<Context, C3437a> f11424a = new WeakHashMap();

    private class C3437a {
        public final long f11422a = zzw.zzcS().mo3360a();
        public final xg f11423b;

        public C3437a(xh xhVar, xg xgVar) {
            this.f11423b = xgVar;
        }

        public boolean m14765a() {
            return ((Long) qb.bq.m13225c()).longValue() + this.f11422a < zzw.zzcS().mo3360a();
        }
    }

    public Future<xg> m14767a(final Context context) {
        return zk.m15080a(new Callable<xg>(this) {
            final /* synthetic */ xh f11421b;

            public xg m14764a() {
                C3437a c3437a = (C3437a) this.f11421b.f11424a.get(context);
                xg a = (c3437a == null || c3437a.m14765a() || !((Boolean) qb.bp.m13225c()).booleanValue()) ? new C3435a(context).m14763a() : new C3435a(context, c3437a.f11423b).m14763a();
                this.f11421b.f11424a.put(context, new C3437a(this.f11421b, a));
                return a;
            }

            public /* synthetic */ Object call() {
                return m14764a();
            }
        });
    }
}
