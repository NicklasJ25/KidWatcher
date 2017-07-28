package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.aad;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    CustomEventBanner f4940a;
    CustomEventInterstitial f4941b;
    private View f4942c;

    static final class C1923a implements CustomEventBannerListener {
        private final CustomEventAdapter f4935a;
        private final MediationBannerListener f4936b;

        public C1923a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f4935a = customEventAdapter;
            this.f4936b = mediationBannerListener;
        }

        public void onClick() {
            aad.m8421b("Custom event adapter called onFailedToReceiveAd.");
            this.f4936b.onClick(this.f4935a);
        }

        public void onDismissScreen() {
            aad.m8421b("Custom event adapter called onFailedToReceiveAd.");
            this.f4936b.onDismissScreen(this.f4935a);
        }

        public void onFailedToReceiveAd() {
            aad.m8421b("Custom event adapter called onFailedToReceiveAd.");
            this.f4936b.onFailedToReceiveAd(this.f4935a, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            aad.m8421b("Custom event adapter called onFailedToReceiveAd.");
            this.f4936b.onLeaveApplication(this.f4935a);
        }

        public void onPresentScreen() {
            aad.m8421b("Custom event adapter called onFailedToReceiveAd.");
            this.f4936b.onPresentScreen(this.f4935a);
        }

        public void onReceivedAd(View view) {
            aad.m8421b("Custom event adapter called onReceivedAd.");
            this.f4935a.m5471a(view);
            this.f4936b.onReceivedAd(this.f4935a);
        }
    }

    class C1924b implements CustomEventInterstitialListener {
        final /* synthetic */ CustomEventAdapter f4937a;
        private final CustomEventAdapter f4938b;
        private final MediationInterstitialListener f4939c;

        public C1924b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f4937a = customEventAdapter;
            this.f4938b = customEventAdapter2;
            this.f4939c = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            aad.m8421b("Custom event adapter called onDismissScreen.");
            this.f4939c.onDismissScreen(this.f4938b);
        }

        public void onFailedToReceiveAd() {
            aad.m8421b("Custom event adapter called onFailedToReceiveAd.");
            this.f4939c.onFailedToReceiveAd(this.f4938b, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            aad.m8421b("Custom event adapter called onLeaveApplication.");
            this.f4939c.onLeaveApplication(this.f4938b);
        }

        public void onPresentScreen() {
            aad.m8421b("Custom event adapter called onPresentScreen.");
            this.f4939c.onPresentScreen(this.f4938b);
        }

        public void onReceivedAd() {
            aad.m8421b("Custom event adapter called onReceivedAd.");
            this.f4939c.onReceivedAd(this.f4937a);
        }
    }

    private static <T> T m5470a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String valueOf = String.valueOf(th.getMessage());
            aad.m8426e(new StringBuilder((String.valueOf(str).length() + 46) + String.valueOf(valueOf).length()).append("Could not instantiate custom event adapter: ").append(str).append(". ").append(valueOf).toString());
            return null;
        }
    }

    private void m5471a(View view) {
        this.f4942c = view;
    }

    C1924b m5473a(MediationInterstitialListener mediationInterstitialListener) {
        return new C1924b(this, this, mediationInterstitialListener);
    }

    public void destroy() {
        if (this.f4940a != null) {
            this.f4940a.destroy();
        }
        if (this.f4941b != null) {
            this.f4941b.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.f4942c;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f4940a = (CustomEventBanner) m5470a(customEventServerParameters.className);
        if (this.f4940a == null) {
            mediationBannerListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f4940a.requestBannerAd(new C1923a(this, mediationBannerListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f4941b = (CustomEventInterstitial) m5470a(customEventServerParameters.className);
        if (this.f4941b == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f4941b.requestInterstitialAd(m5473a(mediationInterstitialListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    public void showInterstitial() {
        this.f4941b.showInterstitial();
    }
}
