package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C2517l.C2527b;
import com.google.android.gms.common.internal.C2517l.C2528c;
import com.google.android.gms.internal.aam.C2380c;
import com.google.android.gms.internal.aam.C2637a;
import com.google.android.gms.internal.wk.C3396a;

@wh
public abstract class wl implements C3396a, zn<Void> {
    private final aam<zzmk> f11183a;
    private final C3396a f11184b;
    private final Object f11185c = new Object();

    class C34002 implements C2637a {
        final /* synthetic */ wl f11182a;

        C34002(wl wlVar) {
            this.f11182a = wlVar;
        }

        public void mo3379a() {
            this.f11182a.mo4185a();
        }
    }

    @wh
    public static final class C3401a extends wl {
        private final Context f11186a;

        public C3401a(Context context, aam<zzmk> com_google_android_gms_internal_aam_com_google_android_gms_internal_zzmk, C3396a c3396a) {
            super(com_google_android_gms_internal_aam_com_google_android_gms_internal_zzmk, c3396a);
            this.f11186a = context;
        }

        public void mo4185a() {
        }

        public ws mo4186b() {
            return xa.m14674a(this.f11186a, new pt((String) qb.f10288b.m13225c()), wz.m14594a());
        }
    }

    @wh
    public static class C3402b extends wl implements C2527b, C2528c {
        protected wm f11187a;
        private Context f11188b;
        private zzqh f11189c;
        private aam<zzmk> f11190d;
        private final C3396a f11191e;
        private final Object f11192f = new Object();
        private boolean f11193g;

        public C3402b(Context context, zzqh com_google_android_gms_internal_zzqh, aam<zzmk> com_google_android_gms_internal_aam_com_google_android_gms_internal_zzmk, C3396a c3396a) {
            Looper a;
            super(com_google_android_gms_internal_aam_com_google_android_gms_internal_zzmk, c3396a);
            this.f11188b = context;
            this.f11189c = com_google_android_gms_internal_zzqh;
            this.f11190d = com_google_android_gms_internal_aam_com_google_android_gms_internal_zzmk;
            this.f11191e = c3396a;
            if (((Boolean) qb.f10274N.m13225c()).booleanValue()) {
                this.f11193g = true;
                a = zzw.zzdc().m15277a();
            } else {
                a = context.getMainLooper();
            }
            this.f11187a = new wm(context, a, this, this, this.f11189c.f12083c);
            m14527d();
        }

        public void mo4185a() {
            synchronized (this.f11192f) {
                if (this.f11187a.m7977b() || this.f11187a.m7978c()) {
                    this.f11187a.m7966a();
                }
                Binder.flushPendingCommands();
                if (this.f11193g) {
                    zzw.zzdc().m15278b();
                    this.f11193g = false;
                }
            }
        }

        public void mo3346a(int i) {
            aad.m8421b("Disconnected from remote ad request service.");
        }

        public void mo3347a(Bundle bundle) {
            zziP();
        }

        public void mo3348a(@NonNull ConnectionResult connectionResult) {
            aad.m8421b("Cannot connect to remote service, fallback to local instance.");
            m14528e().zziP();
            Bundle bundle = new Bundle();
            bundle.putString("action", "gms_connection_failed_fallback_to_local");
            zzw.zzcM().m15142b(this.f11188b, this.f11189c.f12081a, "gmob-apps", bundle, true);
        }

        public ws mo4186b() {
            ws k;
            synchronized (this.f11192f) {
                try {
                    k = this.f11187a.mo3338k();
                } catch (IllegalStateException e) {
                    k = null;
                    return k;
                } catch (DeadObjectException e2) {
                    k = null;
                    return k;
                }
            }
            return k;
        }

        protected void m14527d() {
            this.f11187a.m7987n();
        }

        zn m14528e() {
            return new C3401a(this.f11188b, this.f11190d, this.f11191e);
        }
    }

    public wl(aam<zzmk> com_google_android_gms_internal_aam_com_google_android_gms_internal_zzmk, C3396a c3396a) {
        this.f11183a = com_google_android_gms_internal_aam_com_google_android_gms_internal_zzmk;
        this.f11184b = c3396a;
    }

    public abstract void mo4185a();

    public void mo4183a(zzmn com_google_android_gms_internal_zzmn) {
        synchronized (this.f11185c) {
            this.f11184b.mo4183a(com_google_android_gms_internal_zzmn);
            mo4185a();
        }
    }

    boolean m14517a(ws wsVar, zzmk com_google_android_gms_internal_zzmk) {
        try {
            wsVar.mo4189a(com_google_android_gms_internal_zzmk, new wo(this));
            return true;
        } catch (Throwable th) {
            aad.m8424c("Could not fetch ad response from ad request service due to an Exception.", th);
            zzw.zzcQ().m15000a(th, "AdRequestClientTask.getAdResponseFromService");
            this.f11184b.mo4183a(new zzmn(0));
            return false;
        }
    }

    public abstract ws mo4186b();

    public Void m14519c() {
        final ws b = mo4186b();
        if (b == null) {
            this.f11184b.mo4183a(new zzmn(0));
            mo4185a();
        } else {
            this.f11183a.mo3380a(new C2380c<zzmk>(this) {
                final /* synthetic */ wl f11181b;

                public void m14512a(zzmk com_google_android_gms_internal_zzmk) {
                    if (!this.f11181b.m14517a(b, com_google_android_gms_internal_zzmk)) {
                        this.f11181b.mo4185a();
                    }
                }

                public /* synthetic */ void mo3272a(Object obj) {
                    m14512a((zzmk) obj);
                }
            }, new C34002(this));
        }
        return null;
    }

    public void cancel() {
        mo4185a();
    }

    public /* synthetic */ Object zziP() {
        return m14519c();
    }
}
