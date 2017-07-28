package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.internal.rp.C3220a;

@wh
public class ru extends C3220a {
    private final OnCustomClickListener f10524a;

    public ru(OnCustomClickListener onCustomClickListener) {
        this.f10524a = onCustomClickListener;
    }

    public void mo4011a(rl rlVar, String str) {
        this.f10524a.onCustomClick(new rm(rlVar), str);
    }
}
