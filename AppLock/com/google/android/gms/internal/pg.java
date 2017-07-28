package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

@wh
public class pg {
    private final tz f10211a;
    private final Context f10212b;
    private final og f10213c;
    private AdListener f10214d;
    private ny f10215e;
    private ot f10216f;
    private String f10217g;
    private String f10218h;
    private AppEventListener f10219i;
    private PlayStorePurchaseListener f10220j;
    private InAppPurchaseListener f10221k;
    private PublisherInterstitialAd f10222l;
    private OnCustomRenderedAdLoadedListener f10223m;
    private Correlator f10224n;
    private RewardedVideoAdListener f10225o;
    private boolean f10226p;

    public pg(Context context) {
        this(context, og.m12904a(), null);
    }

    public pg(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, og.m12904a(), publisherInterstitialAd);
    }

    public pg(Context context, og ogVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.f10211a = new tz();
        this.f10212b = context;
        this.f10213c = ogVar;
        this.f10222l = publisherInterstitialAd;
    }

    private void m13127b(String str) {
        if (this.f10217g == null) {
            m13128c(str);
        }
        this.f10216f = ol.m12981b().m12977b(this.f10212b, this.f10226p ? zzeg.m15382a() : new zzeg(), this.f10217g, this.f10211a);
        if (this.f10214d != null) {
            this.f10216f.zza(new oa(this.f10214d));
        }
        if (this.f10215e != null) {
            this.f10216f.zza(new nz(this.f10215e));
        }
        if (this.f10219i != null) {
            this.f10216f.zza(new oi(this.f10219i));
        }
        if (this.f10221k != null) {
            this.f10216f.zza(new vl(this.f10221k));
        }
        if (this.f10220j != null) {
            this.f10216f.zza(new vp(this.f10220j), this.f10218h);
        }
        if (this.f10223m != null) {
            this.f10216f.zza(new qo(this.f10223m));
        }
        if (this.f10224n != null) {
            this.f10216f.zza(this.f10224n.zzbq());
        }
        if (this.f10225o != null) {
            this.f10216f.zza(new xx(this.f10225o));
        }
    }

    private void m13128c(String str) {
        if (this.f10216f == null) {
            throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 63).append("The ad unit ID must be set on InterstitialAd before ").append(str).append(" is called.").toString());
        }
    }

    public AdListener m13129a() {
        return this.f10214d;
    }

    public void m13130a(AdListener adListener) {
        try {
            this.f10214d = adListener;
            if (this.f10216f != null) {
                this.f10216f.zza(adListener != null ? new oa(adListener) : null);
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to set the AdListener.", e);
        }
    }

    public void m13131a(Correlator correlator) {
        this.f10224n = correlator;
        try {
            if (this.f10216f != null) {
                this.f10216f.zza(this.f10224n == null ? null : this.f10224n.zzbq());
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to set correlator.", e);
        }
    }

    public void m13132a(AppEventListener appEventListener) {
        try {
            this.f10219i = appEventListener;
            if (this.f10216f != null) {
                this.f10216f.zza(appEventListener != null ? new oi(appEventListener) : null);
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to set the AppEventListener.", e);
        }
    }

    public void m13133a(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.f10223m = onCustomRenderedAdLoadedListener;
            if (this.f10216f != null) {
                this.f10216f.zza(onCustomRenderedAdLoadedListener != null ? new qo(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to set the OnCustomRenderedAdLoadedListener.", e);
        }
    }

    public void m13134a(InAppPurchaseListener inAppPurchaseListener) {
        if (this.f10220j != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.f10221k = inAppPurchaseListener;
            if (this.f10216f != null) {
                this.f10216f.zza(inAppPurchaseListener != null ? new vl(inAppPurchaseListener) : null);
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void m13135a(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        if (this.f10221k != null) {
            throw new IllegalStateException("In app purchase parameter has already been set.");
        }
        try {
            this.f10220j = playStorePurchaseListener;
            this.f10218h = str;
            if (this.f10216f != null) {
                this.f10216f.zza(playStorePurchaseListener != null ? new vp(playStorePurchaseListener) : null, str);
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to set the play store purchase parameter.", e);
        }
    }

    public void m13136a(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.f10225o = rewardedVideoAdListener;
            if (this.f10216f != null) {
                this.f10216f.zza(rewardedVideoAdListener != null ? new xx(rewardedVideoAdListener) : null);
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to set the AdListener.", e);
        }
    }

    public void m13137a(ny nyVar) {
        try {
            this.f10215e = nyVar;
            if (this.f10216f != null) {
                this.f10216f.zza(nyVar != null ? new nz(nyVar) : null);
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to set the AdClickListener.", e);
        }
    }

    public void m13138a(pe peVar) {
        try {
            if (this.f10216f == null) {
                m13127b("loadAd");
            }
            if (this.f10216f.zzb(this.f10213c.m12905a(this.f10212b, peVar))) {
                this.f10211a.m14056a(peVar.m13084j());
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to load ad.", e);
        }
    }

    public void m13139a(String str) {
        if (this.f10217g != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.f10217g = str;
    }

    public void m13140a(boolean z) {
        this.f10226p = z;
    }

    public String m13141b() {
        return this.f10217g;
    }

    public AppEventListener m13142c() {
        return this.f10219i;
    }

    public InAppPurchaseListener m13143d() {
        return this.f10221k;
    }

    public OnCustomRenderedAdLoadedListener m13144e() {
        return this.f10223m;
    }

    public boolean m13145f() {
        boolean z = false;
        try {
            if (this.f10216f != null) {
                z = this.f10216f.isReady();
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to check if ad is ready.", e);
        }
        return z;
    }

    public boolean m13146g() {
        boolean z = false;
        try {
            if (this.f10216f != null) {
                z = this.f10216f.isLoading();
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to check if ad is loading.", e);
        }
        return z;
    }

    public String m13147h() {
        try {
            if (this.f10216f != null) {
                return this.f10216f.getMediationAdapterClassName();
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public void m13148i() {
        try {
            m13128c("show");
            this.f10216f.showInterstitial();
        } catch (Throwable e) {
            aad.m8424c("Failed to show interstitial.", e);
        }
    }
}
