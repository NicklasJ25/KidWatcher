package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.p065a.C2312b;

@wh
public class ql implements CustomRenderedAd {
    private final qm f10347a;

    public ql(qm qmVar) {
        this.f10347a = qmVar;
    }

    public String getBaseUrl() {
        try {
            return this.f10347a.mo3908a();
        } catch (Throwable e) {
            aad.m8424c("Could not delegate getBaseURL to CustomRenderedAd", e);
            return null;
        }
    }

    public String getContent() {
        try {
            return this.f10347a.mo3910b();
        } catch (Throwable e) {
            aad.m8424c("Could not delegate getContent to CustomRenderedAd", e);
            return null;
        }
    }

    public void onAdRendered(View view) {
        try {
            this.f10347a.mo3909a(view != null ? C2312b.m7327a((Object) view) : null);
        } catch (Throwable e) {
            aad.m8424c("Could not delegate onAdRendered to CustomRenderedAd", e);
        }
    }

    public void recordClick() {
        try {
            this.f10347a.mo3911c();
        } catch (Throwable e) {
            aad.m8424c("Could not delegate recordClick to CustomRenderedAd", e);
        }
    }

    public void recordImpression() {
        try {
            this.f10347a.mo3912d();
        } catch (Throwable e) {
            aad.m8424c("Could not delegate recordImpression to CustomRenderedAd", e);
        }
    }
}
