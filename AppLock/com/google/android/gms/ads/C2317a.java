package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.ny;
import com.google.android.gms.internal.pf;

class C2317a extends ViewGroup {
    protected final pf f6679a;

    public C2317a(Context context, int i) {
        super(context);
        this.f6679a = new pf(this, i);
    }

    public C2317a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f6679a = new pf(this, attributeSet, false, i);
    }

    public C2317a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f6679a = new pf(this, attributeSet, false, i2);
    }

    public void destroy() {
        this.f6679a.m13095a();
    }

    public AdListener getAdListener() {
        return this.f6679a.m13109b();
    }

    public AdSize getAdSize() {
        return this.f6679a.m13111c();
    }

    public String getAdUnitId() {
        return this.f6679a.m13113e();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.f6679a.m13115g();
    }

    public String getMediationAdapterClassName() {
        return this.f6679a.m13120l();
    }

    public boolean isLoading() {
        return this.f6679a.m13121m();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        this.f6679a.m13104a(adRequest.zzbp());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    protected void onMeasure(int i, int i2) {
        int widthInPixels;
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize;
            AdSize adSize2 = null;
            try {
                adSize = getAdSize();
            } catch (Throwable e) {
                aad.m8422b("Unable to retrieve ad size.", e);
                adSize = adSize2;
            }
            if (adSize != null) {
                Context context = getContext();
                widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
            } else {
                widthInPixels = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            widthInPixels = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(widthInPixels, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void pause() {
        this.f6679a.m13117i();
    }

    public void resume() {
        this.f6679a.m13119k();
    }

    public void setAdListener(AdListener adListener) {
        this.f6679a.m13096a(adListener);
        if (adListener != null && (adListener instanceof ny)) {
            this.f6679a.m13103a((ny) adListener);
        } else if (adListener == null) {
            this.f6679a.m13103a(null);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.f6679a.m13107a(adSize);
    }

    public void setAdUnitId(String str) {
        this.f6679a.m13105a(str);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.f6679a.m13101a(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        this.f6679a.m13102a(playStorePurchaseListener, str);
    }
}
