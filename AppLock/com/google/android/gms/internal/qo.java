package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.internal.qn.C3176a;

@wh
public final class qo extends C3176a {
    private final OnCustomRenderedAdLoadedListener f10350a;

    public qo(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f10350a = onCustomRenderedAdLoadedListener;
    }

    public void mo3918a(qm qmVar) {
        this.f10350a.onCustomRenderedAdLoaded(new ql(qmVar));
    }
}
