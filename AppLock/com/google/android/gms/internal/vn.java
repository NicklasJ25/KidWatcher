package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

@wh
public class vn implements InAppPurchaseResult {
    private final vj f11015a;

    public vn(vj vjVar) {
        this.f11015a = vjVar;
    }

    public void finishPurchase() {
        try {
            this.f11015a.finishPurchase();
        } catch (Throwable e) {
            aad.m8424c("Could not forward finishPurchase to InAppPurchaseResult", e);
        }
    }

    public String getProductId() {
        try {
            return this.f11015a.getProductId();
        } catch (Throwable e) {
            aad.m8424c("Could not forward getProductId to InAppPurchaseResult", e);
            return null;
        }
    }

    public Intent getPurchaseData() {
        try {
            return this.f11015a.getPurchaseData();
        } catch (Throwable e) {
            aad.m8424c("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return null;
        }
    }

    public int getResultCode() {
        try {
            return this.f11015a.getResultCode();
        } catch (Throwable e) {
            aad.m8424c("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return 0;
        }
    }

    public boolean isVerified() {
        try {
            return this.f11015a.isVerified();
        } catch (Throwable e) {
            aad.m8424c("Could not forward isVerified to InAppPurchaseResult", e);
            return false;
        }
    }
}
