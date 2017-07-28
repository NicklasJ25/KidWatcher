package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.pf;

public final class PublisherAdView extends ViewGroup {
    private final pf f6690a;

    public PublisherAdView(Context context) {
        super(context);
        this.f6690a = new pf(this);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6690a = new pf(this, attributeSet, true);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6690a = new pf(this, attributeSet, true);
    }

    public void destroy() {
        this.f6690a.m13095a();
    }

    public AdListener getAdListener() {
        return this.f6690a.m13109b();
    }

    public AdSize getAdSize() {
        return this.f6690a.m13111c();
    }

    public AdSize[] getAdSizes() {
        return this.f6690a.m13112d();
    }

    public String getAdUnitId() {
        return this.f6690a.m13113e();
    }

    public AppEventListener getAppEventListener() {
        return this.f6690a.m13114f();
    }

    public String getMediationAdapterClassName() {
        return this.f6690a.m13120l();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.f6690a.m13116h();
    }

    public VideoController getVideoController() {
        return this.f6690a.m13122n();
    }

    public VideoOptions getVideoOptions() {
        return this.f6690a.m13124p();
    }

    public boolean isLoading() {
        return this.f6690a.m13121m();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.f6690a.m13104a(publisherAdRequest.zzbp());
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
        this.f6690a.m13117i();
    }

    public void recordManualImpression() {
        this.f6690a.m13118j();
    }

    public void resume() {
        this.f6690a.m13119k();
    }

    public void setAdListener(AdListener adListener) {
        this.f6690a.m13096a(adListener);
    }

    public void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length < 1) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.f6690a.m13110b(adSizeArr);
    }

    public void setAdUnitId(String str) {
        this.f6690a.m13105a(str);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.f6690a.m13099a(appEventListener);
    }

    public void setCorrelator(Correlator correlator) {
        this.f6690a.m13097a(correlator);
    }

    public void setManualImpressionsEnabled(boolean z) {
        this.f6690a.m13106a(z);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f6690a.m13100a(onCustomRenderedAdLoadedListener);
    }

    public void setVideoOptions(VideoOptions videoOptions) {
        this.f6690a.m13098a(videoOptions);
    }
}
