package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsIntent.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.qp.C3177a;

@wh
public class uq implements MediationInterstitialAdapter {
    private Activity f10915a;
    private qp f10916b;
    private MediationInterstitialListener f10917c;
    private Uri f10918d;

    class C33381 implements C3177a {
        C33381(uq uqVar) {
        }
    }

    class C33392 implements zzh {
        final /* synthetic */ uq f10912a;

        C33392(uq uqVar) {
            this.f10912a = uqVar;
        }

        public void onPause() {
            aad.m8421b("AdMobCustomTabsAdapter overlay is paused.");
        }

        public void onResume() {
            aad.m8421b("AdMobCustomTabsAdapter overlay is resumed.");
        }

        public void zzbN() {
            aad.m8421b("AdMobCustomTabsAdapter overlay is closed.");
            this.f10912a.f10917c.onAdClosed(this.f10912a);
            try {
                this.f10912a.f10916b.m13334a(this.f10912a.f10915a);
            } catch (Throwable e) {
                aad.m8422b("Exception while unbinding from CustomTabsService.", e);
            }
        }

        public void zzbO() {
            aad.m8421b("Opening AdMobCustomTabsAdapter overlay.");
            this.f10912a.f10917c.onAdOpened(this.f10912a);
        }
    }

    public static boolean m14269a(Context context) {
        return qp.m13332a(context);
    }

    public void onDestroy() {
        aad.m8421b("Destroying AdMobCustomTabsAdapter adapter.");
        try {
            this.f10916b.m13334a(this.f10915a);
        } catch (Throwable e) {
            aad.m8422b("Exception while unbinding from CustomTabsService.", e);
        }
    }

    public void onPause() {
        aad.m8421b("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public void onResume() {
        aad.m8421b("Resuming AdMobCustomTabsAdapter adapter.");
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f10917c = mediationInterstitialListener;
        if (this.f10917c == null) {
            aad.m8426e("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            aad.m8426e("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.f10917c.onAdFailedToLoad(this, 0);
        } else if (m14269a(context)) {
            Object string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                aad.m8426e("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.f10917c.onAdFailedToLoad(this, 0);
                return;
            }
            this.f10915a = (Activity) context;
            this.f10918d = Uri.parse(string);
            this.f10916b = new qp();
            this.f10916b.m13335a(new C33381(this));
            this.f10916b.m13336b(this.f10915a);
            this.f10917c.onAdLoaded(this);
        } else {
            aad.m8426e("Default browser does not support custom tabs. Bailing out.");
            this.f10917c.onAdFailedToLoad(this, 0);
        }
    }

    public void showInterstitial() {
        CustomTabsIntent build = new Builder(this.f10916b.m13333a()).build();
        build.intent.setData(this.f10918d);
        final AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(new zzc(build.intent), null, new C33392(this), null, new zzqh(0, 0, false));
        zl.f11678a.post(new Runnable(this) {
            final /* synthetic */ uq f10914b;

            public void run() {
                zzw.zzcK().zza(this.f10914b.f10915a, adOverlayInfoParcel);
            }
        });
        zzw.zzcQ().m15014d(false);
    }
}
