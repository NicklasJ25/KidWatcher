package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.common.internal.C2513c;

@wh
public class aas {
    private final aat f7658a;
    private final Context f7659b;
    private final ViewGroup f7660c;
    private zzl f7661d;

    public aas(Context context, ViewGroup viewGroup, aat com_google_android_gms_internal_aat) {
        this(context, viewGroup, com_google_android_gms_internal_aat, null);
    }

    aas(Context context, ViewGroup viewGroup, aat com_google_android_gms_internal_aat, zzl com_google_android_gms_ads_internal_overlay_zzl) {
        this.f7659b = context;
        this.f7660c = viewGroup;
        this.f7658a = com_google_android_gms_internal_aat;
        this.f7661d = com_google_android_gms_ads_internal_overlay_zzl;
    }

    public zzl m8471a() {
        C2513c.m7940b("getAdVideoUnderlay must be called from the UI thread.");
        return this.f7661d;
    }

    public void m8472a(int i, int i2, int i3, int i4) {
        C2513c.m7940b("The underlay may only be modified from the UI thread.");
        if (this.f7661d != null) {
            this.f7661d.zzd(i, i2, i3, i4);
        }
    }

    public void m8473a(int i, int i2, int i3, int i4, int i5, boolean z) {
        if (this.f7661d == null) {
            qf.m13288a(this.f7658a.mo3447y().m13298a(), this.f7658a.mo3446x(), "vpr2");
            this.f7661d = new zzl(this.f7659b, this.f7658a, i5, z, this.f7658a.mo3447y().m13298a());
            this.f7660c.addView(this.f7661d, 0, new LayoutParams(-1, -1));
            this.f7661d.zzd(i, i2, i3, i4);
            this.f7658a.mo3424l().m8553a(false);
        }
    }

    public void m8474b() {
        C2513c.m7940b("onPause must be called from the UI thread.");
        if (this.f7661d != null) {
            this.f7661d.pause();
        }
    }

    public void m8475c() {
        C2513c.m7940b("onDestroy must be called from the UI thread.");
        if (this.f7661d != null) {
            this.f7661d.destroy();
            this.f7660c.removeView(this.f7661d);
            this.f7661d = null;
        }
    }
}
