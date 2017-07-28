package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ov.C3113a;

@wh
public final class oi extends C3113a {
    private final AppEventListener f10084a;

    public oi(AppEventListener appEventListener) {
        this.f10084a = appEventListener;
    }

    public void mo3861a(String str, String str2) {
        this.f10084a.onAppEvent(str, str2);
    }
}
