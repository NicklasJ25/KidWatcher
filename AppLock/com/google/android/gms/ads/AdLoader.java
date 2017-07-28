package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.oa;
import com.google.android.gms.internal.og;
import com.google.android.gms.internal.ol;
import com.google.android.gms.internal.oq;
import com.google.android.gms.internal.or;
import com.google.android.gms.internal.pe;
import com.google.android.gms.internal.rs;
import com.google.android.gms.internal.rt;
import com.google.android.gms.internal.ru;
import com.google.android.gms.internal.rv;
import com.google.android.gms.internal.tz;
import com.google.android.gms.internal.zzhc;

public class AdLoader {
    private final og f6671a;
    private final Context f6672b;
    private final oq f6673c;

    public static class Builder {
        private final Context f6669a;
        private final or f6670b;

        Builder(Context context, or orVar) {
            this.f6669a = context;
            this.f6670b = orVar;
        }

        public Builder(Context context, String str) {
            this((Context) C2513c.m7933a((Object) context, (Object) "context cannot be null"), ol.m12981b().m12969a(context, str, new tz()));
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.f6669a, this.f6670b.zzck());
            } catch (Throwable e) {
                aad.m8422b("Failed to build AdLoader.", e);
                return null;
            }
        }

        public Builder forAppInstallAd(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.f6670b.zza(new rs(onAppInstallAdLoadedListener));
            } catch (Throwable e) {
                aad.m8424c("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder forContentAd(OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.f6670b.zza(new rt(onContentAdLoadedListener));
            } catch (Throwable e) {
                aad.m8424c("Failed to add content ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, OnCustomClickListener onCustomClickListener) {
            try {
                this.f6670b.zza(str, new rv(onCustomTemplateAdLoadedListener), onCustomClickListener == null ? null : new ru(onCustomClickListener));
            } catch (Throwable e) {
                aad.m8424c("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.f6670b.zzb(new oa(adListener));
            } catch (Throwable e) {
                aad.m8424c("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withCorrelator(@NonNull Correlator correlator) {
            C2513c.m7932a((Object) correlator);
            try {
                this.f6670b.zzb(correlator.zzbq());
            } catch (Throwable e) {
                aad.m8424c("Failed to set correlator.", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.f6670b.zza(new zzhc(nativeAdOptions));
            } catch (Throwable e) {
                aad.m8424c("Failed to specify native ad options", e);
            }
            return this;
        }
    }

    AdLoader(Context context, oq oqVar) {
        this(context, oqVar, og.m12904a());
    }

    AdLoader(Context context, oq oqVar, og ogVar) {
        this.f6672b = context;
        this.f6673c = oqVar;
        this.f6671a = ogVar;
    }

    private void m7332a(pe peVar) {
        try {
            this.f6673c.zzf(this.f6671a.m12905a(this.f6672b, peVar));
        } catch (Throwable e) {
            aad.m8422b("Failed to load ad.", e);
        }
    }

    public String getMediationAdapterClassName() {
        try {
            return this.f6673c.getMediationAdapterClassName();
        } catch (Throwable e) {
            aad.m8424c("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.f6673c.isLoading();
        } catch (Throwable e) {
            aad.m8424c("Failed to check if ad is loading.", e);
            return false;
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        m7332a(adRequest.zzbp());
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        m7332a(publisherAdRequest.zzbp());
    }
}
