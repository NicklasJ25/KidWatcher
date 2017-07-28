package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.internal.xs.C3155a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;

@wh
public class xp extends C3155a {
    private final Context f11430a;
    private final Object f11431b;
    private final zzqh f11432c;
    private final xq f11433d;

    public xp(Context context, zze com_google_android_gms_ads_internal_zze, ub ubVar, zzqh com_google_android_gms_internal_zzqh) {
        this(context, com_google_android_gms_internal_zzqh, new xq(context, com_google_android_gms_ads_internal_zze, zzeg.m15382a(), ubVar, com_google_android_gms_internal_zzqh));
    }

    xp(Context context, zzqh com_google_android_gms_internal_zzqh, xq xqVar) {
        this.f11431b = new Object();
        this.f11430a = context;
        this.f11432c = com_google_android_gms_internal_zzqh;
        this.f11433d = xqVar;
    }

    public void mo3886a() {
        synchronized (this.f11431b) {
            this.f11433d.m14805h();
        }
    }

    public void mo3887a(C2309a c2309a) {
        synchronized (this.f11431b) {
            this.f11433d.pause();
        }
    }

    public void mo3888a(xu xuVar) {
        synchronized (this.f11431b) {
            this.f11433d.zza(xuVar);
        }
    }

    public void mo3889a(zzoa com_google_android_gms_internal_zzoa) {
        synchronized (this.f11431b) {
            this.f11433d.m14801a(com_google_android_gms_internal_zzoa);
        }
    }

    public void mo3890a(String str) {
        aad.m8426e("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void mo3891b(C2309a c2309a) {
        synchronized (this.f11431b) {
            Context context = c2309a == null ? null : (Context) C2312b.m7328a(c2309a);
            if (context != null) {
                try {
                    this.f11433d.m14800a(context);
                } catch (Throwable e) {
                    aad.m8424c("Unable to extract updated context.", e);
                }
            }
            this.f11433d.resume();
        }
    }

    public boolean mo3892b() {
        boolean i;
        synchronized (this.f11431b) {
            i = this.f11433d.m14806i();
        }
        return i;
    }

    public void mo3893c() {
        mo3887a(null);
    }

    public void mo3894c(C2309a c2309a) {
        synchronized (this.f11431b) {
            this.f11433d.destroy();
        }
    }

    public void mo3895d() {
        mo3891b(null);
    }

    public void mo3896e() {
        mo3894c(null);
    }
}
