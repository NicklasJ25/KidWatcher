package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@wh
public final class uo<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final ud f10909a;

    class C33281 implements Runnable {
        final /* synthetic */ uo f10898a;

        C33281(uo uoVar) {
            this.f10898a = uoVar;
        }

        public void run() {
            try {
                this.f10898a.f10909a.mo4046a();
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdClicked.", e);
            }
        }
    }

    class C33303 implements Runnable {
        final /* synthetic */ uo f10901a;

        C33303(uo uoVar) {
            this.f10901a = uoVar;
        }

        public void run() {
            try {
                this.f10901a.f10909a.mo4050c();
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdLeftApplication.", e);
            }
        }
    }

    class C33314 implements Runnable {
        final /* synthetic */ uo f10902a;

        C33314(uo uoVar) {
            this.f10902a = uoVar;
        }

        public void run() {
            try {
                this.f10902a.f10909a.mo4051d();
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdOpened.", e);
            }
        }
    }

    class C33325 implements Runnable {
        final /* synthetic */ uo f10903a;

        C33325(uo uoVar) {
            this.f10903a = uoVar;
        }

        public void run() {
            try {
                this.f10903a.f10909a.mo4052e();
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdLoaded.", e);
            }
        }
    }

    class C33336 implements Runnable {
        final /* synthetic */ uo f10904a;

        C33336(uo uoVar) {
            this.f10904a = uoVar;
        }

        public void run() {
            try {
                this.f10904a.f10909a.mo4049b();
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdClosed.", e);
            }
        }
    }

    class C33358 implements Runnable {
        final /* synthetic */ uo f10907a;

        C33358(uo uoVar) {
            this.f10907a = uoVar;
        }

        public void run() {
            try {
                this.f10907a.f10909a.mo4050c();
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdLeftApplication.", e);
            }
        }
    }

    class C33369 implements Runnable {
        final /* synthetic */ uo f10908a;

        C33369(uo uoVar) {
            this.f10908a = uoVar;
        }

        public void run() {
            try {
                this.f10908a.f10909a.mo4051d();
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdOpened.", e);
            }
        }
    }

    public uo(ud udVar) {
        this.f10909a = udVar;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        aad.m8421b("Adapter called onClick.");
        if (ol.m12979a().m8413b()) {
            try {
                this.f10909a.mo4046a();
                return;
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdClicked.", e);
                return;
            }
        }
        aad.m8426e("onClick must be called on the main UI thread.");
        aac.f7622a.post(new C33281(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        aad.m8421b("Adapter called onDismissScreen.");
        if (ol.m12979a().m8413b()) {
            try {
                this.f10909a.mo4049b();
                return;
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdClosed.", e);
                return;
            }
        }
        aad.m8426e("onDismissScreen must be called on the main UI thread.");
        aac.f7622a.post(new C33336(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        aad.m8421b("Adapter called onDismissScreen.");
        if (ol.m12979a().m8413b()) {
            try {
                this.f10909a.mo4049b();
                return;
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdClosed.", e);
                return;
            }
        }
        aad.m8426e("onDismissScreen must be called on the main UI thread.");
        aac.f7622a.post(new Runnable(this) {
            final /* synthetic */ uo f10897a;

            {
                this.f10897a = r1;
            }

            public void run() {
                try {
                    this.f10897a.f10909a.mo4049b();
                } catch (Throwable e) {
                    aad.m8424c("Could not call onAdClosed.", e);
                }
            }
        });
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        aad.m8421b(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error. ").append(valueOf).toString());
        if (ol.m12979a().m8413b()) {
            try {
                this.f10909a.mo4047a(up.m14264a(errorCode));
                return;
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        aad.m8426e("onFailedToReceiveAd must be called on the main UI thread.");
        aac.f7622a.post(new Runnable(this) {
            final /* synthetic */ uo f10906b;

            public void run() {
                try {
                    this.f10906b.f10909a.mo4047a(up.m14264a(errorCode));
                } catch (Throwable e) {
                    aad.m8424c("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        aad.m8421b(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error ").append(valueOf).append(".").toString());
        if (ol.m12979a().m8413b()) {
            try {
                this.f10909a.mo4047a(up.m14264a(errorCode));
                return;
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        aad.m8426e("onFailedToReceiveAd must be called on the main UI thread.");
        aac.f7622a.post(new Runnable(this) {
            final /* synthetic */ uo f10900b;

            public void run() {
                try {
                    this.f10900b.f10909a.mo4047a(up.m14264a(errorCode));
                } catch (Throwable e) {
                    aad.m8424c("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        aad.m8421b("Adapter called onLeaveApplication.");
        if (ol.m12979a().m8413b()) {
            try {
                this.f10909a.mo4050c();
                return;
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        aad.m8426e("onLeaveApplication must be called on the main UI thread.");
        aac.f7622a.post(new C33358(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        aad.m8421b("Adapter called onLeaveApplication.");
        if (ol.m12979a().m8413b()) {
            try {
                this.f10909a.mo4050c();
                return;
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        aad.m8426e("onLeaveApplication must be called on the main UI thread.");
        aac.f7622a.post(new C33303(this));
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        aad.m8421b("Adapter called onPresentScreen.");
        if (ol.m12979a().m8413b()) {
            try {
                this.f10909a.mo4051d();
                return;
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdOpened.", e);
                return;
            }
        }
        aad.m8426e("onPresentScreen must be called on the main UI thread.");
        aac.f7622a.post(new C33369(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        aad.m8421b("Adapter called onPresentScreen.");
        if (ol.m12979a().m8413b()) {
            try {
                this.f10909a.mo4051d();
                return;
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdOpened.", e);
                return;
            }
        }
        aad.m8426e("onPresentScreen must be called on the main UI thread.");
        aac.f7622a.post(new C33314(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        aad.m8421b("Adapter called onReceivedAd.");
        if (ol.m12979a().m8413b()) {
            try {
                this.f10909a.mo4052e();
                return;
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdLoaded.", e);
                return;
            }
        }
        aad.m8426e("onReceivedAd must be called on the main UI thread.");
        aac.f7622a.post(new Runnable(this) {
            final /* synthetic */ uo f10896a;

            {
                this.f10896a = r1;
            }

            public void run() {
                try {
                    this.f10896a.f10909a.mo4052e();
                } catch (Throwable e) {
                    aad.m8424c("Could not call onAdLoaded.", e);
                }
            }
        });
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        aad.m8421b("Adapter called onReceivedAd.");
        if (ol.m12979a().m8413b()) {
            try {
                this.f10909a.mo4052e();
                return;
            } catch (Throwable e) {
                aad.m8424c("Could not call onAdLoaded.", e);
                return;
            }
        }
        aad.m8426e("onReceivedAd must be called on the main UI thread.");
        aac.f7622a.post(new C33325(this));
    }
}
