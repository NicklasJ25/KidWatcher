package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.internal.ro.C3218a;

@wh
public class rt extends C3218a {
    private final OnContentAdLoadedListener f10523a;

    public rt(OnContentAdLoadedListener onContentAdLoadedListener) {
        this.f10523a = onContentAdLoadedListener;
    }

    public void mo4010a(rj rjVar) {
        this.f10523a.onContentAdLoaded(m13661b(rjVar));
    }

    rk m13661b(rj rjVar) {
        return new rk(rjVar);
    }
}
