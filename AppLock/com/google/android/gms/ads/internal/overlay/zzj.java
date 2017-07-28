package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;
import com.google.android.gms.ads.internal.overlay.zzab.C2331a;
import com.google.android.gms.internal.wh;

@TargetApi(14)
@wh
public abstract class zzj extends TextureView implements C2331a {
    protected final zzw f6750a = new zzw();
    protected final zzab f6751b;

    public zzj(Context context) {
        super(context);
        this.f6751b = new zzab(context, this);
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void pause();

    public abstract void play();

    public abstract void seekTo(int i);

    public abstract void setVideoPath(String str);

    public abstract void stop();

    public abstract void zza(float f, float f2);

    public abstract void zza(zzi com_google_android_gms_ads_internal_overlay_zzi);

    public void zzb(float f) {
        this.f6751b.zzb(f);
        zzhC();
    }

    public abstract void zzhC();

    public void zzhZ() {
        this.f6751b.setMuted(true);
        zzhC();
    }

    public abstract String zzhy();

    public void zzia() {
        this.f6751b.setMuted(false);
        zzhC();
    }
}
