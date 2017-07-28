package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.aau.C2340a;
import com.google.android.gms.internal.tf.C3278a;
import org.json.JSONObject;

@wh
public class th implements tf {
    private final aat f10723a;

    public th(Context context, zzqh com_google_android_gms_internal_zzqh, @Nullable ed edVar, zze com_google_android_gms_ads_internal_zze) {
        this.f10723a = zzw.zzcN().m8575a(context, new zzeg(), false, false, edVar, com_google_android_gms_internal_zzqh, null, null, com_google_android_gms_ads_internal_zze);
        this.f10723a.mo3392a().setWillNotDraw(true);
    }

    private void m13915a(Runnable runnable) {
        if (ol.m12979a().m8413b()) {
            runnable.run();
        } else {
            zl.f11678a.post(runnable);
        }
    }

    public void mo4034a() {
        this.f10723a.destroy();
    }

    public void mo4035a(ny nyVar, zzh com_google_android_gms_ads_internal_overlay_zzh, rx rxVar, zzq com_google_android_gms_ads_internal_overlay_zzq, boolean z, se seVar, sg sgVar, zzf com_google_android_gms_ads_internal_zzf, uy uyVar) {
        this.f10723a.mo3424l().m8551a(nyVar, com_google_android_gms_ads_internal_overlay_zzh, rxVar, com_google_android_gms_ads_internal_overlay_zzq, z, seVar, sgVar, new zzf(this.f10723a.getContext(), false), uyVar, null);
    }

    public void mo4036a(final C3278a c3278a) {
        this.f10723a.mo3424l().m8547a(new C2340a(this) {
            public void mo3168a(aat com_google_android_gms_internal_aat, boolean z) {
                c3278a.mo4033a();
            }
        });
    }

    public void mo4037a(String str) {
        final String format = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str});
        m13915a(new Runnable(this) {
            final /* synthetic */ th f10717b;

            public void run() {
                this.f10717b.f10723a.loadData(format, "text/html", "UTF-8");
            }
        });
    }

    public void mo3402a(String str, sc scVar) {
        this.f10723a.mo3424l().m8552a(str, scVar);
    }

    public void mo3384a(final String str, final String str2) {
        m13915a(new Runnable(this) {
            final /* synthetic */ th f10715c;

            public void run() {
                this.f10715c.f10723a.mo3384a(str, str2);
            }
        });
    }

    public void mo3385a(final String str, final JSONObject jSONObject) {
        m13915a(new Runnable(this) {
            final /* synthetic */ th f10712c;

            public void run() {
                this.f10712c.f10723a.mo3385a(str, jSONObject);
            }
        });
    }

    public tk mo4038b() {
        return new tl(this);
    }

    public void mo4039b(final String str) {
        m13915a(new Runnable(this) {
            final /* synthetic */ th f10721b;

            public void run() {
                this.f10721b.f10723a.loadUrl(str);
            }
        });
    }

    public void mo3409b(String str, sc scVar) {
        this.f10723a.mo3424l().m8557b(str, scVar);
    }

    public void mo3410b(String str, JSONObject jSONObject) {
        this.f10723a.mo3410b(str, jSONObject);
    }

    public void mo4040c(final String str) {
        m13915a(new Runnable(this) {
            final /* synthetic */ th f10719b;

            public void run() {
                this.f10719b.f10723a.loadData(str, "text/html", "UTF-8");
            }
        });
    }
}
