package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.internal.rn.C3216a;

@wh
public class rs extends C3216a {
    private final OnAppInstallAdLoadedListener f10522a;

    public rs(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.f10522a = onAppInstallAdLoadedListener;
    }

    public void mo4009a(rh rhVar) {
        this.f10522a.onAppInstallAdLoaded(m13659b(rhVar));
    }

    ri m13659b(rh rhVar) {
        return new ri(rhVar);
    }
}
