package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.vg.C3255a;

@wh
public final class vl extends C3255a {
    private final InAppPurchaseListener f11014a;

    public vl(InAppPurchaseListener inAppPurchaseListener) {
        this.f11014a = inAppPurchaseListener;
    }

    public void mo4018a(vf vfVar) {
        this.f11014a.onInAppPurchaseRequested(new vo(vfVar));
    }
}
