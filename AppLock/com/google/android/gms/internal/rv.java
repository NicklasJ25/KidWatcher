package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.internal.rq.C3222a;

@wh
public class rv extends C3222a {
    private final OnCustomTemplateAdLoadedListener f10525a;

    public rv(OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.f10525a = onCustomTemplateAdLoadedListener;
    }

    public void mo4012a(rl rlVar) {
        this.f10525a.onCustomTemplateAdLoaded(new rm(rlVar));
    }
}
