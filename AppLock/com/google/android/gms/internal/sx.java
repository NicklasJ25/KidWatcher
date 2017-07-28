package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.op.C3112a;
import java.util.Random;

@wh
class sx {
    @Nullable
    op f10631a;
    @Nullable
    ov f10632b;
    @Nullable
    vg f10633c;
    @Nullable
    qn f10634d;
    @Nullable
    oo f10635e;
    @Nullable
    xu f10636f;

    private static class C3272a extends C3112a {
        private final op f10630a;

        class C32711 implements Runnable {
            C32711(C3272a c3272a) {
            }

            public void run() {
                zzw.zzdb().m13833a();
            }
        }

        C3272a(op opVar) {
            this.f10630a = opVar;
        }

        public void mo3853a() {
            tc a = tc.m13885a();
            float floatValue = ((Float) qb.bg.m13225c()).floatValue();
            if (((float) (a.m13892g() + a.m13891f())) <= ((float) a.m13893h()) * floatValue || Float.isNaN(floatValue)) {
                int intValue = ((Integer) qb.be.m13225c()).intValue();
                int intValue2 = ((Integer) qb.bf.m13225c()).intValue();
                if (intValue <= 0 || intValue2 < 0) {
                    zzw.zzdb().m13833a();
                } else {
                    zl.f11678a.postDelayed(new C32711(this), (long) (new Random().nextInt(intValue2 + 1) + intValue));
                }
            }
            this.f10630a.mo3853a();
        }

        public void mo3854a(int i) {
            this.f10630a.mo3854a(i);
        }

        public void mo3855b() {
            this.f10630a.mo3855b();
        }

        public void mo3856c() {
            this.f10630a.mo3856c();
        }

        public void mo3857d() {
            this.f10630a.mo3857d();
        }
    }

    sx() {
    }

    void m13819a(zzm com_google_android_gms_ads_internal_zzm) {
        if (this.f10631a != null) {
            com_google_android_gms_ads_internal_zzm.zza(new C3272a(this.f10631a));
        }
        if (this.f10632b != null) {
            com_google_android_gms_ads_internal_zzm.zza(this.f10632b);
        }
        if (this.f10633c != null) {
            com_google_android_gms_ads_internal_zzm.zza(this.f10633c);
        }
        if (this.f10634d != null) {
            com_google_android_gms_ads_internal_zzm.zza(this.f10634d);
        }
        if (this.f10635e != null) {
            com_google_android_gms_ads_internal_zzm.zza(this.f10635e);
        }
        if (this.f10636f != null) {
            com_google_android_gms_ads_internal_zzm.zza(this.f10636f);
        }
    }
}
