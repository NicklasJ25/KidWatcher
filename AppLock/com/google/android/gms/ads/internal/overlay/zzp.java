package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.internal.ol;
import com.google.android.gms.internal.wh;

@wh
public class zzp extends FrameLayout implements OnClickListener {
    private final ImageButton f6822a;
    private final zzv f6823b;

    static class C2350a {
        public int f6817a = 0;
        public int f6818b = 0;
        public int f6819c = 0;
        public int f6820d = 0;
        public int f6821e = 32;

        C2350a() {
        }
    }

    public zzp(Context context, C2350a c2350a, zzv com_google_android_gms_ads_internal_overlay_zzv) {
        super(context);
        this.f6823b = com_google_android_gms_ads_internal_overlay_zzv;
        setOnClickListener(this);
        this.f6822a = new ImageButton(context);
        this.f6822a.setImageResource(17301527);
        this.f6822a.setBackgroundColor(0);
        this.f6822a.setOnClickListener(this);
        this.f6822a.setPadding(ol.m12979a().m8398a(context, c2350a.f6817a), ol.m12979a().m8398a(context, 0), ol.m12979a().m8398a(context, c2350a.f6818b), ol.m12979a().m8398a(context, c2350a.f6820d));
        this.f6822a.setContentDescription("Interstitial close button");
        ol.m12979a().m8398a(context, c2350a.f6821e);
        addView(this.f6822a, new LayoutParams(ol.m12979a().m8398a(context, (c2350a.f6821e + c2350a.f6817a) + c2350a.f6818b), ol.m12979a().m8398a(context, (c2350a.f6821e + 0) + c2350a.f6820d), 17));
    }

    public void onClick(View view) {
        if (this.f6823b != null) {
            this.f6823b.zzhE();
        }
    }

    public void zza(boolean z, boolean z2) {
        if (!z2) {
            this.f6822a.setVisibility(0);
        } else if (z) {
            this.f6822a.setVisibility(4);
        } else {
            this.f6822a.setVisibility(8);
        }
    }
}
