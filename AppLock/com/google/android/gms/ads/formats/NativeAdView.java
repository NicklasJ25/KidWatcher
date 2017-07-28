package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.ol;
import com.google.android.gms.internal.rf;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;

public abstract class NativeAdView extends FrameLayout {
    private final FrameLayout f6702a;
    private final rf f6703b = m7343a();

    public NativeAdView(Context context) {
        super(context);
        this.f6702a = m7344b(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6702a = m7344b(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6702a = m7344b(context);
    }

    @TargetApi(21)
    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f6702a = m7344b(context);
    }

    private rf m7343a() {
        C2513c.m7933a(this.f6702a, (Object) "createDelegate must be called after mOverlayFrame has been created");
        return ol.m12981b().m12973a(this.f6702a.getContext(), (FrameLayout) this, this.f6702a);
    }

    private FrameLayout m7344b(Context context) {
        View a = m7346a(context);
        a.setLayoutParams(new LayoutParams(-1, -1));
        addView(a);
        return a;
    }

    protected View m7345a(String str) {
        try {
            C2309a a = this.f6703b.mo3881a(str);
            if (a != null) {
                return (View) C2312b.m7328a(a);
            }
        } catch (Throwable e) {
            aad.m8422b("Unable to call getAssetView on delegate", e);
        }
        return null;
    }

    FrameLayout m7346a(Context context) {
        return new FrameLayout(context);
    }

    protected void m7347a(String str, View view) {
        try {
            this.f6703b.mo3885a(str, C2312b.m7327a((Object) view));
        } catch (Throwable e) {
            aad.m8422b("Unable to call setAssetView on delegate", e);
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.f6702a);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.f6702a != view) {
            super.bringChildToFront(this.f6702a);
        }
    }

    public void destroy() {
        try {
            this.f6703b.mo3882a();
        } catch (Throwable e) {
            aad.m8422b("Unable to destroy native ad view", e);
        }
    }

    public AdChoicesView getAdChoicesView() {
        View a = m7345a("1098");
        return a instanceof AdChoicesView ? (AdChoicesView) a : null;
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.f6703b != null) {
            try {
                this.f6703b.mo3884a(C2312b.m7327a((Object) view), i);
            } catch (Throwable e) {
                aad.m8422b("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f6702a);
    }

    public void removeView(View view) {
        if (this.f6702a != view) {
            super.removeView(view);
        }
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        m7347a("1098", adChoicesView);
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.f6703b.mo3883a((C2309a) nativeAd.mo3979a());
        } catch (Throwable e) {
            aad.m8422b("Unable to call setNativeAd on delegate", e);
        }
    }
}
