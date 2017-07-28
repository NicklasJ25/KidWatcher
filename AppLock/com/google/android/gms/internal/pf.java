package com.google.android.gms.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import java.util.concurrent.atomic.AtomicBoolean;

@wh
public class pf {
    final on f10191a;
    private final tz f10192b;
    private final og f10193c;
    private final AtomicBoolean f10194d;
    private final VideoController f10195e;
    private ny f10196f;
    private AdListener f10197g;
    private AdSize[] f10198h;
    private AppEventListener f10199i;
    private Correlator f10200j;
    private ot f10201k;
    private InAppPurchaseListener f10202l;
    private OnCustomRenderedAdLoadedListener f10203m;
    private PlayStorePurchaseListener f10204n;
    private VideoOptions f10205o;
    private String f10206p;
    private String f10207q;
    private ViewGroup f10208r;
    private int f10209s;
    private boolean f10210t;

    class C31471 extends on {
        final /* synthetic */ pf f10190a;

        C31471(pf pfVar) {
            this.f10190a = pfVar;
        }

        public void onAdFailedToLoad(int i) {
            this.f10190a.f10195e.zza(this.f10190a.m13123o());
            super.onAdFailedToLoad(i);
        }

        public void onAdLoaded() {
            this.f10190a.f10195e.zza(this.f10190a.m13123o());
            super.onAdLoaded();
        }
    }

    public pf(ViewGroup viewGroup) {
        this(viewGroup, null, false, og.m12904a(), 0);
    }

    public pf(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, og.m12904a(), i);
    }

    public pf(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, og.m12904a(), 0);
    }

    public pf(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, z, og.m12904a(), i);
    }

    pf(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, og ogVar, int i) {
        this(viewGroup, attributeSet, z, ogVar, null, i);
    }

    pf(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, og ogVar, ot otVar, int i) {
        this.f10192b = new tz();
        this.f10195e = new VideoController();
        this.f10191a = new C31471(this);
        this.f10208r = viewGroup;
        this.f10193c = ogVar;
        this.f10201k = otVar;
        this.f10194d = new AtomicBoolean(false);
        this.f10209s = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                oj ojVar = new oj(context, attributeSet);
                this.f10198h = ojVar.m12915a(z);
                this.f10206p = ojVar.m12914a();
                if (viewGroup.isInEditMode()) {
                    ol.m12979a().m8406a(viewGroup, m13091a(context, this.f10198h[0], this.f10209s), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                ol.m12979a().m8407a(viewGroup, new zzeg(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    private static zzeg m13091a(Context context, AdSize adSize, int i) {
        zzeg com_google_android_gms_internal_zzeg = new zzeg(context, adSize);
        com_google_android_gms_internal_zzeg.m15386a(m13093a(i));
        return com_google_android_gms_internal_zzeg;
    }

    private static zzeg m13092a(Context context, AdSize[] adSizeArr, int i) {
        zzeg com_google_android_gms_internal_zzeg = new zzeg(context, adSizeArr);
        com_google_android_gms_internal_zzeg.m15386a(m13093a(i));
        return com_google_android_gms_internal_zzeg;
    }

    private static boolean m13093a(int i) {
        return i == 1;
    }

    private void m13094s() {
        try {
            C2309a zzbB = this.f10201k.zzbB();
            if (zzbB != null) {
                this.f10208r.addView((View) C2312b.m7328a(zzbB));
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to get an ad frame.", e);
        }
    }

    public void m13095a() {
        try {
            if (this.f10201k != null) {
                this.f10201k.destroy();
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to destroy AdView.", e);
        }
    }

    public void m13096a(AdListener adListener) {
        this.f10197g = adListener;
        this.f10191a.m12987a(adListener);
    }

    public void m13097a(Correlator correlator) {
        this.f10200j = correlator;
        try {
            if (this.f10201k != null) {
                this.f10201k.zza(this.f10200j == null ? null : this.f10200j.zzbq());
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to set correlator.", e);
        }
    }

    public void m13098a(VideoOptions videoOptions) {
        this.f10205o = videoOptions;
        try {
            if (this.f10201k != null) {
                this.f10201k.zza(videoOptions == null ? null : new zzft(videoOptions));
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to set video options.", e);
        }
    }

    public void m13099a(AppEventListener appEventListener) {
        try {
            this.f10199i = appEventListener;
            if (this.f10201k != null) {
                this.f10201k.zza(appEventListener != null ? new oi(appEventListener) : null);
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to set the AppEventListener.", e);
        }
    }

    public void m13100a(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f10203m = onCustomRenderedAdLoadedListener;
        try {
            if (this.f10201k != null) {
                this.f10201k.zza(onCustomRenderedAdLoadedListener != null ? new qo(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }

    public void m13101a(InAppPurchaseListener inAppPurchaseListener) {
        if (this.f10204n != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.f10202l = inAppPurchaseListener;
            if (this.f10201k != null) {
                this.f10201k.zza(inAppPurchaseListener != null ? new vl(inAppPurchaseListener) : null);
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void m13102a(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        if (this.f10202l != null) {
            throw new IllegalStateException("InAppPurchaseListener has already been set.");
        }
        try {
            this.f10204n = playStorePurchaseListener;
            this.f10207q = str;
            if (this.f10201k != null) {
                this.f10201k.zza(playStorePurchaseListener != null ? new vp(playStorePurchaseListener) : null, str);
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to set the play store purchase parameter.", e);
        }
    }

    public void m13103a(ny nyVar) {
        try {
            this.f10196f = nyVar;
            if (this.f10201k != null) {
                this.f10201k.zza(nyVar != null ? new nz(nyVar) : null);
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to set the AdClickListener.", e);
        }
    }

    public void m13104a(pe peVar) {
        try {
            if (this.f10201k == null) {
                m13125q();
            }
            if (this.f10201k.zzb(this.f10193c.m12905a(this.f10208r.getContext(), peVar))) {
                this.f10192b.m14056a(peVar.m13084j());
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to load ad.", e);
        }
    }

    public void m13105a(String str) {
        if (this.f10206p != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.f10206p = str;
    }

    public void m13106a(boolean z) {
        this.f10210t = z;
        try {
            if (this.f10201k != null) {
                this.f10201k.setManualImpressionsEnabled(this.f10210t);
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to set manual impressions.", e);
        }
    }

    public void m13107a(AdSize... adSizeArr) {
        if (this.f10198h != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        m13110b(adSizeArr);
    }

    public boolean m13108a(zzeg com_google_android_gms_internal_zzeg) {
        return "search_v2".equals(com_google_android_gms_internal_zzeg.f11895a);
    }

    public AdListener m13109b() {
        return this.f10197g;
    }

    public void m13110b(AdSize... adSizeArr) {
        this.f10198h = adSizeArr;
        try {
            if (this.f10201k != null) {
                this.f10201k.zza(m13092a(this.f10208r.getContext(), this.f10198h, this.f10209s));
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to set the ad size.", e);
        }
        this.f10208r.requestLayout();
    }

    public AdSize m13111c() {
        try {
            if (this.f10201k != null) {
                zzeg zzbC = this.f10201k.zzbC();
                if (zzbC != null) {
                    return zzbC.m15387b();
                }
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to get the current AdSize.", e);
        }
        return this.f10198h != null ? this.f10198h[0] : null;
    }

    public AdSize[] m13112d() {
        return this.f10198h;
    }

    public String m13113e() {
        return this.f10206p;
    }

    public AppEventListener m13114f() {
        return this.f10199i;
    }

    public InAppPurchaseListener m13115g() {
        return this.f10202l;
    }

    public OnCustomRenderedAdLoadedListener m13116h() {
        return this.f10203m;
    }

    public void m13117i() {
        try {
            if (this.f10201k != null) {
                this.f10201k.pause();
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to call pause.", e);
        }
    }

    public void m13118j() {
        if (!this.f10194d.getAndSet(true)) {
            try {
                if (this.f10201k != null) {
                    this.f10201k.zzbE();
                }
            } catch (Throwable e) {
                aad.m8424c("Failed to record impression.", e);
            }
        }
    }

    public void m13119k() {
        try {
            if (this.f10201k != null) {
                this.f10201k.resume();
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to call resume.", e);
        }
    }

    public String m13120l() {
        try {
            if (this.f10201k != null) {
                return this.f10201k.getMediationAdapterClassName();
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public boolean m13121m() {
        try {
            if (this.f10201k != null) {
                return this.f10201k.isLoading();
            }
        } catch (Throwable e) {
            aad.m8424c("Failed to check if ad is loading.", e);
        }
        return false;
    }

    public VideoController m13122n() {
        return this.f10195e;
    }

    public pb m13123o() {
        pb pbVar = null;
        if (this.f10201k != null) {
            try {
                pbVar = this.f10201k.zzbF();
            } catch (Throwable e) {
                aad.m8424c("Failed to retrieve VideoController.", e);
            }
        }
        return pbVar;
    }

    public VideoOptions m13124p() {
        return this.f10205o;
    }

    void m13125q() {
        if ((this.f10198h == null || this.f10206p == null) && this.f10201k == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        this.f10201k = m13126r();
        this.f10201k.zza(new oa(this.f10191a));
        if (this.f10196f != null) {
            this.f10201k.zza(new nz(this.f10196f));
        }
        if (this.f10199i != null) {
            this.f10201k.zza(new oi(this.f10199i));
        }
        if (this.f10202l != null) {
            this.f10201k.zza(new vl(this.f10202l));
        }
        if (this.f10204n != null) {
            this.f10201k.zza(new vp(this.f10204n), this.f10207q);
        }
        if (this.f10203m != null) {
            this.f10201k.zza(new qo(this.f10203m));
        }
        if (this.f10200j != null) {
            this.f10201k.zza(this.f10200j.zzbq());
        }
        if (this.f10205o != null) {
            this.f10201k.zza(new zzft(this.f10205o));
        }
        this.f10201k.setManualImpressionsEnabled(this.f10210t);
        m13094s();
    }

    protected ot m13126r() {
        Context context = this.f10208r.getContext();
        zzeg a = m13092a(context, this.f10198h, this.f10209s);
        return m13108a(a) ? ol.m12981b().m12970a(context, a, this.f10206p) : ol.m12981b().m12971a(context, a, this.f10206p, this.f10192b);
    }
}
