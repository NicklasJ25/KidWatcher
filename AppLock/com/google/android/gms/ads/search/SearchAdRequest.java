package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.pe;
import com.google.android.gms.internal.pe.C3146a;

public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final pe f7167a;
    private final int f7168b;
    private final int f7169c;
    private final int f7170d;
    private final int f7171e;
    private final int f7172f;
    private final int f7173g;
    private final int f7174h;
    private final int f7175i;
    private final String f7176j;
    private final int f7177k;
    private final String f7178l;
    private final int f7179m;
    private final int f7180n;
    private final String f7181o;

    public static final class Builder {
        private final C3146a f7152a = new C3146a();
        private int f7153b;
        private int f7154c;
        private int f7155d;
        private int f7156e;
        private int f7157f;
        private int f7158g;
        private int f7159h = 0;
        private int f7160i;
        private String f7161j;
        private int f7162k;
        private String f7163l;
        private int f7164m;
        private int f7165n;
        private String f7166o;

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.f7152a.m13062b(cls, bundle);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f7152a.m13056a(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.f7152a.m13057a((Class) cls, bundle);
            return this;
        }

        public Builder addTestDevice(String str) {
            this.f7152a.m13063b(str);
            return this;
        }

        public SearchAdRequest build() {
            return new SearchAdRequest();
        }

        public Builder setAnchorTextColor(int i) {
            this.f7153b = i;
            return this;
        }

        public Builder setBackgroundColor(int i) {
            this.f7154c = i;
            this.f7155d = Color.argb(0, 0, 0, 0);
            this.f7156e = Color.argb(0, 0, 0, 0);
            return this;
        }

        public Builder setBackgroundGradient(int i, int i2) {
            this.f7154c = Color.argb(0, 0, 0, 0);
            this.f7155d = i2;
            this.f7156e = i;
            return this;
        }

        public Builder setBorderColor(int i) {
            this.f7157f = i;
            return this;
        }

        public Builder setBorderThickness(int i) {
            this.f7158g = i;
            return this;
        }

        public Builder setBorderType(int i) {
            this.f7159h = i;
            return this;
        }

        public Builder setCallButtonColor(int i) {
            this.f7160i = i;
            return this;
        }

        public Builder setCustomChannels(String str) {
            this.f7161j = str;
            return this;
        }

        public Builder setDescriptionTextColor(int i) {
            this.f7162k = i;
            return this;
        }

        public Builder setFontFace(String str) {
            this.f7163l = str;
            return this;
        }

        public Builder setHeaderTextColor(int i) {
            this.f7164m = i;
            return this;
        }

        public Builder setHeaderTextSize(int i) {
            this.f7165n = i;
            return this;
        }

        public Builder setLocation(Location location) {
            this.f7152a.m13055a(location);
            return this;
        }

        public Builder setQuery(String str) {
            this.f7166o = str;
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.f7152a.m13069f(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.f7152a.m13064b(z);
            return this;
        }
    }

    private SearchAdRequest(Builder builder) {
        this.f7168b = builder.f7153b;
        this.f7169c = builder.f7154c;
        this.f7170d = builder.f7155d;
        this.f7171e = builder.f7156e;
        this.f7172f = builder.f7157f;
        this.f7173g = builder.f7158g;
        this.f7174h = builder.f7159h;
        this.f7175i = builder.f7160i;
        this.f7176j = builder.f7161j;
        this.f7177k = builder.f7162k;
        this.f7178l = builder.f7163l;
        this.f7179m = builder.f7164m;
        this.f7180n = builder.f7165n;
        this.f7181o = builder.f7166o;
        this.f7167a = new pe(builder.f7152a, this);
    }

    pe m7617a() {
        return this.f7167a;
    }

    public int getAnchorTextColor() {
        return this.f7168b;
    }

    public int getBackgroundColor() {
        return this.f7169c;
    }

    public int getBackgroundGradientBottom() {
        return this.f7170d;
    }

    public int getBackgroundGradientTop() {
        return this.f7171e;
    }

    public int getBorderColor() {
        return this.f7172f;
    }

    public int getBorderThickness() {
        return this.f7173g;
    }

    public int getBorderType() {
        return this.f7174h;
    }

    public int getCallButtonColor() {
        return this.f7175i;
    }

    public String getCustomChannels() {
        return this.f7176j;
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.f7167a.m13077c(cls);
    }

    public int getDescriptionTextColor() {
        return this.f7177k;
    }

    public String getFontFace() {
        return this.f7178l;
    }

    public int getHeaderTextColor() {
        return this.f7179m;
    }

    public int getHeaderTextSize() {
        return this.f7180n;
    }

    public Location getLocation() {
        return this.f7167a.m13079e();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.f7167a.m13071a((Class) cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.f7167a.m13074b(cls);
    }

    public String getQuery() {
        return this.f7181o;
    }

    public boolean isTestDevice(Context context) {
        return this.f7167a.m13073a(context);
    }
}
