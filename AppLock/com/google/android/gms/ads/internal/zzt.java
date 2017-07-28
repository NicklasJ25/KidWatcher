package com.google.android.gms.ads.internal;

import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.zl;
import com.google.android.gms.internal.zzec;
import java.lang.ref.WeakReference;

@wh
public class zzt {
    private final zza f7044a;
    private final Runnable f7045b;
    @Nullable
    private zzec f7046c;
    private boolean f7047d;
    private boolean f7048e;
    private long f7049f;

    public static class zza {
        private final Handler f7043a;

        public zza(Handler handler) {
            this.f7043a = handler;
        }

        public boolean postDelayed(Runnable runnable, long j) {
            return this.f7043a.postDelayed(runnable, j);
        }

        public void removeCallbacks(Runnable runnable) {
            this.f7043a.removeCallbacks(runnable);
        }
    }

    public zzt(zza com_google_android_gms_ads_internal_zza) {
        this(com_google_android_gms_ads_internal_zza, new zza(zl.f11678a));
    }

    zzt(zza com_google_android_gms_ads_internal_zza, zza com_google_android_gms_ads_internal_zzt_zza) {
        this.f7047d = false;
        this.f7048e = false;
        this.f7049f = 0;
        this.f7044a = com_google_android_gms_ads_internal_zzt_zza;
        final WeakReference weakReference = new WeakReference(com_google_android_gms_ads_internal_zza);
        this.f7045b = new Runnable(this) {
            final /* synthetic */ zzt f7042b;

            public void run() {
                this.f7042b.f7047d = false;
                zza com_google_android_gms_ads_internal_zza = (zza) weakReference.get();
                if (com_google_android_gms_ads_internal_zza != null) {
                    com_google_android_gms_ads_internal_zza.zzd(this.f7042b.f7046c);
                }
            }
        };
    }

    public void cancel() {
        this.f7047d = false;
        this.f7044a.removeCallbacks(this.f7045b);
    }

    public void pause() {
        this.f7048e = true;
        if (this.f7047d) {
            this.f7044a.removeCallbacks(this.f7045b);
        }
    }

    public void resume() {
        this.f7048e = false;
        if (this.f7047d) {
            this.f7047d = false;
            zza(this.f7046c, this.f7049f);
        }
    }

    public void zza(zzec com_google_android_gms_internal_zzec, long j) {
        if (this.f7047d) {
            aad.m8426e("An ad refresh is already scheduled.");
            return;
        }
        this.f7046c = com_google_android_gms_internal_zzec;
        this.f7047d = true;
        this.f7049f = j;
        if (!this.f7048e) {
            aad.m8425d("Scheduling ad refresh " + j + " milliseconds from now.");
            this.f7044a.postDelayed(this.f7045b, j);
        }
    }

    public boolean zzcy() {
        return this.f7047d;
    }

    public void zzg(zzec com_google_android_gms_internal_zzec) {
        this.f7046c = com_google_android_gms_internal_zzec;
    }

    public void zzh(zzec com_google_android_gms_internal_zzec) {
        zza(com_google_android_gms_internal_zzec, 60000);
    }
}
