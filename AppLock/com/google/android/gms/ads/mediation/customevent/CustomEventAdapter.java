package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.aad;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    CustomEventBanner f7143a;
    CustomEventInterstitial f7144b;
    CustomEventNative f7145c;
    private View f7146d;

    static final class C2408a implements CustomEventBannerListener {
        private final CustomEventAdapter f7136a;
        private final MediationBannerListener f7137b;

        public C2408a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f7136a = customEventAdapter;
            this.f7137b = mediationBannerListener;
        }

        public void onAdClicked() {
            aad.m8421b("Custom event adapter called onAdClicked.");
            this.f7137b.onAdClicked(this.f7136a);
        }

        public void onAdClosed() {
            aad.m8421b("Custom event adapter called onAdClosed.");
            this.f7137b.onAdClosed(this.f7136a);
        }

        public void onAdFailedToLoad(int i) {
            aad.m8421b("Custom event adapter called onAdFailedToLoad.");
            this.f7137b.onAdFailedToLoad(this.f7136a, i);
        }

        public void onAdLeftApplication() {
            aad.m8421b("Custom event adapter called onAdLeftApplication.");
            this.f7137b.onAdLeftApplication(this.f7136a);
        }

        public void onAdLoaded(View view) {
            aad.m8421b("Custom event adapter called onAdLoaded.");
            this.f7136a.m7597a(view);
            this.f7137b.onAdLoaded(this.f7136a);
        }

        public void onAdOpened() {
            aad.m8421b("Custom event adapter called onAdOpened.");
            this.f7137b.onAdOpened(this.f7136a);
        }
    }

    class C2409b implements CustomEventInterstitialListener {
        final /* synthetic */ CustomEventAdapter f7138a;
        private final CustomEventAdapter f7139b;
        private final MediationInterstitialListener f7140c;

        public C2409b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f7138a = customEventAdapter;
            this.f7139b = customEventAdapter2;
            this.f7140c = mediationInterstitialListener;
        }

        public void onAdClicked() {
            aad.m8421b("Custom event adapter called onAdClicked.");
            this.f7140c.onAdClicked(this.f7139b);
        }

        public void onAdClosed() {
            aad.m8421b("Custom event adapter called onAdClosed.");
            this.f7140c.onAdClosed(this.f7139b);
        }

        public void onAdFailedToLoad(int i) {
            aad.m8421b("Custom event adapter called onFailedToReceiveAd.");
            this.f7140c.onAdFailedToLoad(this.f7139b, i);
        }

        public void onAdLeftApplication() {
            aad.m8421b("Custom event adapter called onAdLeftApplication.");
            this.f7140c.onAdLeftApplication(this.f7139b);
        }

        public void onAdLoaded() {
            aad.m8421b("Custom event adapter called onReceivedAd.");
            this.f7140c.onAdLoaded(this.f7138a);
        }

        public void onAdOpened() {
            aad.m8421b("Custom event adapter called onAdOpened.");
            this.f7140c.onAdOpened(this.f7139b);
        }
    }

    static class C2410c implements CustomEventNativeListener {
        private final CustomEventAdapter f7141a;
        private final MediationNativeListener f7142b;

        public C2410c(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.f7141a = customEventAdapter;
            this.f7142b = mediationNativeListener;
        }

        public void onAdClicked() {
            aad.m8421b("Custom event adapter called onAdClicked.");
            this.f7142b.onAdClicked(this.f7141a);
        }

        public void onAdClosed() {
            aad.m8421b("Custom event adapter called onAdClosed.");
            this.f7142b.onAdClosed(this.f7141a);
        }

        public void onAdFailedToLoad(int i) {
            aad.m8421b("Custom event adapter called onAdFailedToLoad.");
            this.f7142b.onAdFailedToLoad(this.f7141a, i);
        }

        public void onAdImpression() {
            aad.m8421b("Custom event adapter called onAdImpression.");
            this.f7142b.onAdImpression(this.f7141a);
        }

        public void onAdLeftApplication() {
            aad.m8421b("Custom event adapter called onAdLeftApplication.");
            this.f7142b.onAdLeftApplication(this.f7141a);
        }

        public void onAdLoaded(NativeAdMapper nativeAdMapper) {
            aad.m8421b("Custom event adapter called onAdLoaded.");
            this.f7142b.onAdLoaded(this.f7141a, nativeAdMapper);
        }

        public void onAdOpened() {
            aad.m8421b("Custom event adapter called onAdOpened.");
            this.f7142b.onAdOpened(this.f7141a);
        }
    }

    private static <T> T m7596a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String valueOf = String.valueOf(th.getMessage());
            aad.m8426e(new StringBuilder((String.valueOf(str).length() + 46) + String.valueOf(valueOf).length()).append("Could not instantiate custom event adapter: ").append(str).append(". ").append(valueOf).toString());
            return null;
        }
    }

    private void m7597a(View view) {
        this.f7146d = view;
    }

    C2409b m7599a(MediationInterstitialListener mediationInterstitialListener) {
        return new C2409b(this, this, mediationInterstitialListener);
    }

    public View getBannerView() {
        return this.f7146d;
    }

    public void onDestroy() {
        if (this.f7143a != null) {
            this.f7143a.onDestroy();
        }
        if (this.f7144b != null) {
            this.f7144b.onDestroy();
        }
        if (this.f7145c != null) {
            this.f7145c.onDestroy();
        }
    }

    public void onPause() {
        if (this.f7143a != null) {
            this.f7143a.onPause();
        }
        if (this.f7144b != null) {
            this.f7144b.onPause();
        }
        if (this.f7145c != null) {
            this.f7145c.onPause();
        }
    }

    public void onResume() {
        if (this.f7143a != null) {
            this.f7143a.onResume();
        }
        if (this.f7144b != null) {
            this.f7144b.onResume();
        }
        if (this.f7145c != null) {
            this.f7145c.onResume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f7143a = (CustomEventBanner) m7596a(bundle.getString("class_name"));
        if (this.f7143a == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.f7143a.requestBannerAd(context, new C2408a(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f7144b = (CustomEventInterstitial) m7596a(bundle.getString("class_name"));
        if (this.f7144b == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.f7144b.requestInterstitialAd(context, m7599a(mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.f7145c = (CustomEventNative) m7596a(bundle.getString("class_name"));
        if (this.f7145c == null) {
            mediationNativeListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.f7145c.requestNativeAd(context, new C2410c(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public void showInterstitial() {
        this.f7144b.showInterstitial();
    }
}
