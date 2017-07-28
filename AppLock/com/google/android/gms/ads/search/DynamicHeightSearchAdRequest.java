package com.google.android.gms.ads.search;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.pe;

public final class DynamicHeightSearchAdRequest {
    private final SearchAdRequest f7151a;

    public static final class Builder {
        private final com.google.android.gms.ads.search.SearchAdRequest.Builder f7149a = new com.google.android.gms.ads.search.SearchAdRequest.Builder();
        private final Bundle f7150b = new Bundle();

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.f7149a.addCustomEventExtrasBundle(cls, bundle);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f7149a.addNetworkExtras(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.f7149a.addNetworkExtrasBundle(cls, bundle);
            return this;
        }

        public DynamicHeightSearchAdRequest build() {
            this.f7149a.addNetworkExtrasBundle(AdMobAdapter.class, this.f7150b);
            return new DynamicHeightSearchAdRequest();
        }

        public Builder setAdBorderSelectors(String str) {
            this.f7150b.putString("csa_adBorderSelectors", str);
            return this;
        }

        public Builder setAdTest(boolean z) {
            this.f7150b.putString("csa_adtest", z ? "on" : "off");
            return this;
        }

        public Builder setAdjustableLineHeight(int i) {
            this.f7150b.putString("csa_adjustableLineHeight", Integer.toString(i));
            return this;
        }

        public Builder setAdvancedOptionValue(String str, String str2) {
            this.f7150b.putString(str, str2);
            return this;
        }

        public Builder setAttributionSpacingBelow(int i) {
            this.f7150b.putString("csa_attributionSpacingBelow", Integer.toString(i));
            return this;
        }

        public Builder setBorderSelections(String str) {
            this.f7150b.putString("csa_borderSelections", str);
            return this;
        }

        public Builder setChannel(String str) {
            this.f7150b.putString("csa_channel", str);
            return this;
        }

        public Builder setColorAdBorder(String str) {
            this.f7150b.putString("csa_colorAdBorder", str);
            return this;
        }

        public Builder setColorAdSeparator(String str) {
            this.f7150b.putString("csa_colorAdSeparator", str);
            return this;
        }

        public Builder setColorAnnotation(String str) {
            this.f7150b.putString("csa_colorAnnotation", str);
            return this;
        }

        public Builder setColorAttribution(String str) {
            this.f7150b.putString("csa_colorAttribution", str);
            return this;
        }

        public Builder setColorBackground(String str) {
            this.f7150b.putString("csa_colorBackground", str);
            return this;
        }

        public Builder setColorBorder(String str) {
            this.f7150b.putString("csa_colorBorder", str);
            return this;
        }

        public Builder setColorDomainLink(String str) {
            this.f7150b.putString("csa_colorDomainLink", str);
            return this;
        }

        public Builder setColorText(String str) {
            this.f7150b.putString("csa_colorText", str);
            return this;
        }

        public Builder setColorTitleLink(String str) {
            this.f7150b.putString("csa_colorTitleLink", str);
            return this;
        }

        public Builder setCssWidth(int i) {
            this.f7150b.putString("csa_width", Integer.toString(i));
            return this;
        }

        public Builder setDetailedAttribution(boolean z) {
            this.f7150b.putString("csa_detailedAttribution", Boolean.toString(z));
            return this;
        }

        @Deprecated
        public Builder setFontFamily(int i) {
            return setFontFamily(Integer.toString(i));
        }

        public Builder setFontFamily(String str) {
            this.f7150b.putString("csa_fontFamily", str);
            return this;
        }

        public Builder setFontFamilyAttribution(String str) {
            this.f7150b.putString("csa_fontFamilyAttribution", str);
            return this;
        }

        public Builder setFontSizeAnnotation(int i) {
            this.f7150b.putString("csa_fontSizeAnnotation", Integer.toString(i));
            return this;
        }

        public Builder setFontSizeAttribution(int i) {
            this.f7150b.putString("csa_fontSizeAttribution", Integer.toString(i));
            return this;
        }

        public Builder setFontSizeDescription(int i) {
            this.f7150b.putString("csa_fontSizeDescription", Integer.toString(i));
            return this;
        }

        public Builder setFontSizeDomainLink(int i) {
            this.f7150b.putString("csa_fontSizeDomainLink", Integer.toString(i));
            return this;
        }

        public Builder setFontSizeTitle(int i) {
            this.f7150b.putString("csa_fontSizeTitle", Integer.toString(i));
            return this;
        }

        public Builder setHostLanguage(String str) {
            this.f7150b.putString("csa_hl", str);
            return this;
        }

        public Builder setIsClickToCallEnabled(boolean z) {
            this.f7150b.putString("csa_clickToCall", Boolean.toString(z));
            return this;
        }

        public Builder setIsLocationEnabled(boolean z) {
            this.f7150b.putString("csa_location", Boolean.toString(z));
            return this;
        }

        public Builder setIsPlusOnesEnabled(boolean z) {
            this.f7150b.putString("csa_plusOnes", Boolean.toString(z));
            return this;
        }

        public Builder setIsSellerRatingsEnabled(boolean z) {
            this.f7150b.putString("csa_sellerRatings", Boolean.toString(z));
            return this;
        }

        public Builder setIsSiteLinksEnabled(boolean z) {
            this.f7150b.putString("csa_siteLinks", Boolean.toString(z));
            return this;
        }

        public Builder setIsTitleBold(boolean z) {
            this.f7150b.putString("csa_titleBold", Boolean.toString(z));
            return this;
        }

        public Builder setIsTitleUnderlined(boolean z) {
            this.f7150b.putString("csa_noTitleUnderline", Boolean.toString(!z));
            return this;
        }

        public Builder setLocationColor(String str) {
            this.f7150b.putString("csa_colorLocation", str);
            return this;
        }

        public Builder setLocationFontSize(int i) {
            this.f7150b.putString("csa_fontSizeLocation", Integer.toString(i));
            return this;
        }

        public Builder setLongerHeadlines(boolean z) {
            this.f7150b.putString("csa_longerHeadlines", Boolean.toString(z));
            return this;
        }

        public Builder setNumber(int i) {
            this.f7150b.putString("csa_number", Integer.toString(i));
            return this;
        }

        public Builder setPage(int i) {
            this.f7150b.putString("csa_adPage", Integer.toString(i));
            return this;
        }

        public Builder setQuery(String str) {
            this.f7149a.setQuery(str);
            return this;
        }

        public Builder setVerticalSpacing(int i) {
            this.f7150b.putString("csa_verticalSpacing", Integer.toString(i));
            return this;
        }
    }

    private DynamicHeightSearchAdRequest(Builder builder) {
        this.f7151a = builder.f7149a.build();
    }

    pe m7601a() {
        return this.f7151a.m7617a();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.f7151a.getCustomEventExtrasBundle(cls);
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.f7151a.getNetworkExtras(cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.f7151a.getNetworkExtrasBundle(cls);
    }

    public String getQuery() {
        return this.f7151a.getQuery();
    }

    public boolean isTestDevice(Context context) {
        return this.f7151a.isTestDevice(context);
    }
}
