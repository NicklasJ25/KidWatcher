package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.aam.C2380c;
import com.google.android.gms.internal.aam.C2637a;
import com.google.android.gms.internal.ti.C3299b;
import com.google.android.gms.internal.ti.C3309e;
import com.google.android.gms.internal.yy.C3457a;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

@wh
public class vy {
    private static final long f11065a = TimeUnit.SECONDS.toMillis(60);
    private static final Object f11066b = new Object();
    private static boolean f11067c = false;
    private static ti f11068d = null;
    private final Context f11069e;
    private final zzqh f11070f;
    private final zzs f11071g;
    private final ed f11072h;
    private tg f11073i;
    private C3309e f11074j;
    private tf f11075k;
    private boolean f11076l;

    public static abstract class C3196a {
        public void mo4176a() {
        }

        public abstract void mo3974a(tj tjVar);
    }

    class C33723 implements zq<tf> {
        final /* synthetic */ vy f11064a;

        C33723(vy vyVar) {
            this.f11064a = vyVar;
        }

        public void m14396a(tf tfVar) {
            zzs com_google_android_gms_ads_internal_zzs = (zzs) new WeakReference(this.f11064a.f11071g).get();
            tfVar.mo4035a(com_google_android_gms_ads_internal_zzs, com_google_android_gms_ads_internal_zzs, com_google_android_gms_ads_internal_zzs, com_google_android_gms_ads_internal_zzs, false, null, null, null, null);
        }

        public /* synthetic */ void mo4041a(Object obj) {
            m14396a((tf) obj);
        }
    }

    public vy(Context context, zzs com_google_android_gms_ads_internal_zzs, ed edVar, zzqh com_google_android_gms_internal_zzqh) {
        this.f11076l = false;
        this.f11069e = context;
        this.f11071g = com_google_android_gms_ads_internal_zzs;
        this.f11072h = edVar;
        this.f11070f = com_google_android_gms_internal_zzqh;
        this.f11076l = ((Boolean) qb.cg.m13225c()).booleanValue();
    }

    public vy(Context context, C3457a c3457a, zzs com_google_android_gms_ads_internal_zzs, ed edVar) {
        zzqh com_google_android_gms_internal_zzqh = (c3457a == null || c3457a.f11509a == null) ? null : c3457a.f11509a.f12002k;
        this(context, com_google_android_gms_ads_internal_zzs, edVar, com_google_android_gms_internal_zzqh);
    }

    private void m14399g() {
        synchronized (f11066b) {
            if (!f11067c) {
                f11068d = new ti(this.f11069e.getApplicationContext() != null ? this.f11069e.getApplicationContext() : this.f11069e, this.f11070f, (String) qb.cd.m13225c(), new C33723(this), new C3299b());
                f11067c = true;
            }
        }
    }

    private void m14400h() {
        this.f11074j = new C3309e(m14408e().m13968b(this.f11072h));
    }

    private void m14401i() {
        this.f11073i = new tg();
    }

    private void m14402j() {
        this.f11075k = (tf) m14406c().m13912a(this.f11069e, this.f11070f, (String) qb.cd.m13225c(), this.f11072h, this.f11071g.zzby()).get(f11065a, TimeUnit.MILLISECONDS);
        this.f11075k.mo4035a(this.f11071g, this.f11071g, this.f11071g, this.f11071g, false, null, null, null, null);
    }

    public void m14403a() {
        if (this.f11076l) {
            m14399g();
        } else {
            m14401i();
        }
    }

    public void m14404a(final C3196a c3196a) {
        if (this.f11076l) {
            C3309e f = m14409f();
            if (f == null) {
                aad.m8426e("SharedJavascriptEngine not initialized");
                return;
            } else {
                f.mo3380a(new C2380c<tj>(this) {
                    public void m14393a(tj tjVar) {
                        c3196a.mo3974a(tjVar);
                    }

                    public /* synthetic */ void mo3272a(Object obj) {
                        m14393a((tj) obj);
                    }
                }, new C2637a(this) {
                    public void mo3379a() {
                        c3196a.mo4176a();
                    }
                });
                return;
            }
        }
        tj d = m14407d();
        if (d == null) {
            aad.m8426e("JavascriptEngine not initialized");
        } else {
            c3196a.mo3974a(d);
        }
    }

    public void m14405b() {
        if (this.f11076l) {
            m14400h();
        } else {
            m14402j();
        }
    }

    protected tg m14406c() {
        return this.f11073i;
    }

    protected tf m14407d() {
        return this.f11075k;
    }

    protected ti m14408e() {
        return f11068d;
    }

    protected C3309e m14409f() {
        return this.f11074j;
    }
}
