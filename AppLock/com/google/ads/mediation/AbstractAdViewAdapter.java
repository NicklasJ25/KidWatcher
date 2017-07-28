package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter.zza;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.abh;
import com.google.android.gms.internal.ny;
import com.google.android.gms.internal.ol;
import com.google.android.gms.internal.wh;
import java.util.Date;
import java.util.Set;

@wh
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, MediationRewardedVideoAdAdapter, abh {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    protected AdView zzcD;
    protected InterstitialAd zzcE;
    private AdLoader zzcF;
    private Context zzcG;
    private InterstitialAd zzcH;
    private MediationRewardedVideoAdListener zzcI;
    final RewardedVideoAdListener zzcJ = new C19171(this);

    class C19171 implements RewardedVideoAdListener {
        final /* synthetic */ AbstractAdViewAdapter f4901a;

        C19171(AbstractAdViewAdapter abstractAdViewAdapter) {
            this.f4901a = abstractAdViewAdapter;
        }

        public void onRewarded(RewardItem rewardItem) {
            this.f4901a.zzcI.onRewarded(this.f4901a, rewardItem);
        }

        public void onRewardedVideoAdClosed() {
            this.f4901a.zzcI.onAdClosed(this.f4901a);
            this.f4901a.zzcH = null;
        }

        public void onRewardedVideoAdFailedToLoad(int i) {
            this.f4901a.zzcI.onAdFailedToLoad(this.f4901a, i);
        }

        public void onRewardedVideoAdLeftApplication() {
            this.f4901a.zzcI.onAdLeftApplication(this.f4901a);
        }

        public void onRewardedVideoAdLoaded() {
            this.f4901a.zzcI.onAdLoaded(this.f4901a);
        }

        public void onRewardedVideoAdOpened() {
            this.f4901a.zzcI.onAdOpened(this.f4901a);
        }

        public void onRewardedVideoStarted() {
            this.f4901a.zzcI.onVideoStarted(this.f4901a);
        }
    }

    static class C1918a extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd f4915e;

        public C1918a(NativeAppInstallAd nativeAppInstallAd) {
            this.f4915e = nativeAppInstallAd;
            setHeadline(nativeAppInstallAd.getHeadline().toString());
            setImages(nativeAppInstallAd.getImages());
            setBody(nativeAppInstallAd.getBody().toString());
            setIcon(nativeAppInstallAd.getIcon());
            setCallToAction(nativeAppInstallAd.getCallToAction().toString());
            if (nativeAppInstallAd.getStarRating() != null) {
                setStarRating(nativeAppInstallAd.getStarRating().doubleValue());
            }
            if (nativeAppInstallAd.getStore() != null) {
                setStore(nativeAppInstallAd.getStore().toString());
            }
            if (nativeAppInstallAd.getPrice() != null) {
                setPrice(nativeAppInstallAd.getPrice().toString());
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeAppInstallAd.getVideoController());
        }

        public void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.f4915e);
            }
        }
    }

    static class C1919b extends NativeContentAdMapper {
        private final NativeContentAd f4923e;

        public C1919b(NativeContentAd nativeContentAd) {
            this.f4923e = nativeContentAd;
            setHeadline(nativeContentAd.getHeadline().toString());
            setImages(nativeContentAd.getImages());
            setBody(nativeContentAd.getBody().toString());
            if (nativeContentAd.getLogo() != null) {
                setLogo(nativeContentAd.getLogo());
            }
            setCallToAction(nativeContentAd.getCallToAction().toString());
            setAdvertiser(nativeContentAd.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeContentAd.getVideoController());
        }

        public void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.f4923e);
            }
        }
    }

    static final class C1920c extends AdListener implements ny {
        final AbstractAdViewAdapter f4924a;
        final MediationBannerListener f4925b;

        public C1920c(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
            this.f4924a = abstractAdViewAdapter;
            this.f4925b = mediationBannerListener;
        }

        public void onAdClicked() {
            this.f4925b.onAdClicked(this.f4924a);
        }

        public void onAdClosed() {
            this.f4925b.onAdClosed(this.f4924a);
        }

        public void onAdFailedToLoad(int i) {
            this.f4925b.onAdFailedToLoad(this.f4924a, i);
        }

        public void onAdLeftApplication() {
            this.f4925b.onAdLeftApplication(this.f4924a);
        }

        public void onAdLoaded() {
            this.f4925b.onAdLoaded(this.f4924a);
        }

        public void onAdOpened() {
            this.f4925b.onAdOpened(this.f4924a);
        }
    }

    static final class C1921d extends AdListener implements ny {
        final AbstractAdViewAdapter f4926a;
        final MediationInterstitialListener f4927b;

        public C1921d(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f4926a = abstractAdViewAdapter;
            this.f4927b = mediationInterstitialListener;
        }

        public void onAdClicked() {
            this.f4927b.onAdClicked(this.f4926a);
        }

        public void onAdClosed() {
            this.f4927b.onAdClosed(this.f4926a);
        }

        public void onAdFailedToLoad(int i) {
            this.f4927b.onAdFailedToLoad(this.f4926a, i);
        }

        public void onAdLeftApplication() {
            this.f4927b.onAdLeftApplication(this.f4926a);
        }

        public void onAdLoaded() {
            this.f4927b.onAdLoaded(this.f4926a);
        }

        public void onAdOpened() {
            this.f4927b.onAdOpened(this.f4926a);
        }
    }

    static final class C1922e extends AdListener implements OnAppInstallAdLoadedListener, OnContentAdLoadedListener, ny {
        final AbstractAdViewAdapter f4928a;
        final MediationNativeListener f4929b;

        public C1922e(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.f4928a = abstractAdViewAdapter;
            this.f4929b = mediationNativeListener;
        }

        public void onAdClicked() {
            this.f4929b.onAdClicked(this.f4928a);
        }

        public void onAdClosed() {
            this.f4929b.onAdClosed(this.f4928a);
        }

        public void onAdFailedToLoad(int i) {
            this.f4929b.onAdFailedToLoad(this.f4928a, i);
        }

        public void onAdLeftApplication() {
            this.f4929b.onAdLeftApplication(this.f4928a);
        }

        public void onAdLoaded() {
        }

        public void onAdOpened() {
            this.f4929b.onAdOpened(this.f4928a);
        }

        public void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.f4929b.onAdLoaded(this.f4928a, new C1918a(nativeAppInstallAd));
        }

        public void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.f4929b.onAdLoaded(this.f4928a, new C1919b(nativeContentAd));
        }
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    public View getBannerView() {
        return this.zzcD;
    }

    public Bundle getInterstitialAdapterInfo() {
        return new zza().zzam(1).zzmm();
    }

    public void initialize(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzcG = context.getApplicationContext();
        this.zzcI = mediationRewardedVideoAdListener;
        this.zzcI.onInitializationSucceeded(this);
    }

    public boolean isInitialized() {
        return this.zzcI != null;
    }

    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        if (this.zzcG == null || this.zzcI == null) {
            aad.m8423c("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.zzcH = new InterstitialAd(this.zzcG);
        this.zzcH.zzd(true);
        this.zzcH.setAdUnitId(getAdUnitId(bundle));
        this.zzcH.setRewardedVideoAdListener(this.zzcJ);
        this.zzcH.loadAd(zza(this.zzcG, mediationAdRequest, bundle2, bundle));
    }

    public void onDestroy() {
        if (this.zzcD != null) {
            this.zzcD.destroy();
            this.zzcD = null;
        }
        if (this.zzcE != null) {
            this.zzcE = null;
        }
        if (this.zzcF != null) {
            this.zzcF = null;
        }
        if (this.zzcH != null) {
            this.zzcH = null;
        }
    }

    public void onPause() {
        if (this.zzcD != null) {
            this.zzcD.pause();
        }
    }

    public void onResume() {
        if (this.zzcD != null) {
            this.zzcD.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzcD = new AdView(context);
        this.zzcD.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zzcD.setAdUnitId(getAdUnitId(bundle));
        this.zzcD.setAdListener(new C1920c(this, mediationBannerListener));
        this.zzcD.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzcE = new InterstitialAd(context);
        this.zzcE.setAdUnitId(getAdUnitId(bundle));
        this.zzcE.setAdListener(new C1921d(this, mediationInterstitialListener));
        this.zzcE.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        OnContentAdLoadedListener c1922e = new C1922e(this, mediationNativeListener);
        Builder withAdListener = zza(context, bundle.getString(AD_UNIT_ID_PARAMETER)).withAdListener(c1922e);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            withAdListener.withNativeAdOptions(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            withAdListener.forAppInstallAd(c1922e);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            withAdListener.forContentAd(c1922e);
        }
        this.zzcF = withAdListener.build();
        this.zzcF.loadAd(zza(context, nativeMediationAdRequest, bundle2, bundle));
    }

    public void showInterstitial() {
        this.zzcE.show();
    }

    public void showVideo() {
        this.zzcH.show();
    }

    protected abstract Bundle zza(Bundle bundle, Bundle bundle2);

    Builder zza(Context context, String str) {
        return new Builder(context, str);
    }

    AdRequest zza(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(ol.m12979a().m8400a(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            builder.tagForChildDirectedTreatment(mediationAdRequest.taggedForChildDirectedTreatment() == 1);
        }
        builder.setIsDesignedForFamilies(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.build();
    }
}
