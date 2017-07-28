package com.google.android.gms.ads.search;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.pf;
import com.google.android.gms.internal.wh;

@wh
public final class SearchAdView extends ViewGroup {
    private final pf f7182a;

    public SearchAdView(Context context) {
        super(context);
        this.f7182a = new pf(this);
    }

    public SearchAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7182a = new pf(this, attributeSet, false);
    }

    public SearchAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7182a = new pf(this, attributeSet, false);
    }

    public void destroy() {
        this.f7182a.m13095a();
    }

    public AdListener getAdListener() {
        return this.f7182a.m13109b();
    }

    public AdSize getAdSize() {
        return this.f7182a.m13111c();
    }

    public String getAdUnitId() {
        return this.f7182a.m13113e();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(DynamicHeightSearchAdRequest dynamicHeightSearchAdRequest) {
        if (AdSize.SEARCH.equals(getAdSize())) {
            this.f7182a.m13104a(dynamicHeightSearchAdRequest.m7601a());
            return;
        }
        throw new IllegalStateException("You must use AdSize.SEARCH for a DynamicHeightSearchAdRequest");
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(SearchAdRequest searchAdRequest) {
        this.f7182a.m13104a(searchAdRequest.m7617a());
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
        this.f7182a.m13117i();
    }

    public void resume() {
        this.f7182a.m13119k();
    }

    public void setAdListener(AdListener adListener) {
        this.f7182a.m13096a(adListener);
    }

    public void setAdSize(AdSize adSize) {
        this.f7182a.m13107a(adSize);
    }

    public void setAdUnitId(String str) {
        this.f7182a.m13105a(str);
    }
}
