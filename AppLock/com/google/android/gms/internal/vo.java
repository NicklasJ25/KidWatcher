package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchase;

@wh
public class vo implements InAppPurchase {
    private final vf f11016a;

    public vo(vf vfVar) {
        this.f11016a = vfVar;
    }

    public String getProductId() {
        try {
            return this.f11016a.getProductId();
        } catch (Throwable e) {
            aad.m8424c("Could not forward getProductId to InAppPurchase", e);
            return null;
        }
    }

    public void recordPlayBillingResolution(int i) {
        try {
            this.f11016a.recordPlayBillingResolution(i);
        } catch (Throwable e) {
            aad.m8424c("Could not forward recordPlayBillingResolution to InAppPurchase", e);
        }
    }

    public void recordResolution(int i) {
        try {
            this.f11016a.recordResolution(i);
        } catch (Throwable e) {
            aad.m8424c("Could not forward recordResolution to InAppPurchase", e);
        }
    }
}
