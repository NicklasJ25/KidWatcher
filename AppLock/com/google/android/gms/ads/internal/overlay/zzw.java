package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.zl;
import java.util.concurrent.TimeUnit;

@TargetApi(14)
@wh
public class zzw {
    private final long f6825a = TimeUnit.MILLISECONDS.toNanos(((Long) qb.f10262B.m13225c()).longValue());
    private long f6826b;
    private boolean f6827c = true;

    zzw() {
    }

    public void zza(SurfaceTexture surfaceTexture, final zzi com_google_android_gms_ads_internal_overlay_zzi) {
        if (com_google_android_gms_ads_internal_overlay_zzi != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.f6827c || Math.abs(timestamp - this.f6826b) >= this.f6825a) {
                this.f6827c = false;
                this.f6826b = timestamp;
                zl.f11678a.post(new Runnable(this) {
                    public void run() {
                        com_google_android_gms_ads_internal_overlay_zzi.zzhY();
                    }
                });
            }
        }
    }

    public void zzhV() {
        this.f6827c = true;
    }
}
