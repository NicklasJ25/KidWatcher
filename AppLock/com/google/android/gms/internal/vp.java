package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.vk.C3362a;

@wh
public final class vp extends C3362a {
    private final PlayStorePurchaseListener f11017a;

    public vp(PlayStorePurchaseListener playStorePurchaseListener) {
        this.f11017a = playStorePurchaseListener;
    }

    public void mo4161a(vj vjVar) {
        this.f11017a.onInAppPurchaseFinished(new vn(vjVar));
    }

    public boolean mo4162a(String str) {
        return this.f11017a.isValidPurchase(str);
    }
}
