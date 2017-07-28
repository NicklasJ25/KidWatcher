package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.common.internal.C2513c;

@wh
public final class uj implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {
    private final ud f10881a;
    private NativeAdMapper f10882b;

    public uj(ud udVar) {
        this.f10881a = udVar;
    }

    public NativeAdMapper m14206a() {
        return this.f10882b;
    }

    public void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        C2513c.m7940b("onAdClicked must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdClicked.");
        try {
            this.f10881a.mo4046a();
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdClicked.", e);
        }
    }

    public void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        C2513c.m7940b("onAdClicked must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdClicked.");
        try {
            this.f10881a.mo4046a();
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdClicked.", e);
        }
    }

    public void onAdClicked(MediationNativeAdapter mediationNativeAdapter) {
        C2513c.m7940b("onAdClicked must be called on the main UI thread.");
        NativeAdMapper a = m14206a();
        if (a == null) {
            aad.m8426e("Could not call onAdClicked since NativeAdMapper is null.");
        } else if (a.getOverrideClickHandling()) {
            aad.m8421b("Adapter called onAdClicked.");
            try {
                this.f10881a.mo4046a();
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdClicked.", e);
            }
        } else {
            aad.m8421b("Could not call onAdClicked since setOverrideClickHandling is not set to true");
        }
    }

    public void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        C2513c.m7940b("onAdClosed must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdClosed.");
        try {
            this.f10881a.mo4049b();
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdClosed.", e);
        }
    }

    public void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        C2513c.m7940b("onAdClosed must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdClosed.");
        try {
            this.f10881a.mo4049b();
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdClosed.", e);
        }
    }

    public void onAdClosed(MediationNativeAdapter mediationNativeAdapter) {
        C2513c.m7940b("onAdClosed must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdClosed.");
        try {
            this.f10881a.mo4049b();
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdClosed.", e);
        }
    }

    public void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i) {
        C2513c.m7940b("onAdFailedToLoad must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdFailedToLoad with error. " + i);
        try {
            this.f10881a.mo4047a(i);
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        C2513c.m7940b("onAdFailedToLoad must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.f10881a.mo4047a(i);
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i) {
        C2513c.m7940b("onAdFailedToLoad must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.f10881a.mo4047a(i);
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdImpression(MediationNativeAdapter mediationNativeAdapter) {
        C2513c.m7940b("onAdImpression must be called on the main UI thread.");
        NativeAdMapper a = m14206a();
        if (a == null) {
            aad.m8426e("Could not call onAdImpression since NativeAdMapper is null. ");
        } else if (a.getOverrideImpressionRecording()) {
            aad.m8421b("Adapter called onAdImpression.");
            try {
                this.f10881a.mo4053f();
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdImpression.", e);
            }
        } else {
            aad.m8421b("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
        }
    }

    public void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        C2513c.m7940b("onAdLeftApplication must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdLeftApplication.");
        try {
            this.f10881a.mo4050c();
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        C2513c.m7940b("onAdLeftApplication must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdLeftApplication.");
        try {
            this.f10881a.mo4050c();
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter) {
        C2513c.m7940b("onAdLeftApplication must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdLeftApplication.");
        try {
            this.f10881a.mo4050c();
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        C2513c.m7940b("onAdLoaded must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdLoaded.");
        try {
            this.f10881a.mo4052e();
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdLoaded.", e);
        }
    }

    public void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        C2513c.m7940b("onAdLoaded must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdLoaded.");
        try {
            this.f10881a.mo4052e();
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdLoaded.", e);
        }
    }

    public void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, NativeAdMapper nativeAdMapper) {
        C2513c.m7940b("onAdLoaded must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdLoaded.");
        this.f10882b = nativeAdMapper;
        try {
            this.f10881a.mo4052e();
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdLoaded.", e);
        }
    }

    public void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        C2513c.m7940b("onAdOpened must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdOpened.");
        try {
            this.f10881a.mo4051d();
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdOpened.", e);
        }
    }

    public void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        C2513c.m7940b("onAdOpened must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdOpened.");
        try {
            this.f10881a.mo4051d();
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdOpened.", e);
        }
    }

    public void onAdOpened(MediationNativeAdapter mediationNativeAdapter) {
        C2513c.m7940b("onAdOpened must be called on the main UI thread.");
        aad.m8421b("Adapter called onAdOpened.");
        try {
            this.f10881a.mo4051d();
        } catch (Throwable e) {
            aad.m8424c("Could not call onAdOpened.", e);
        }
    }
}
