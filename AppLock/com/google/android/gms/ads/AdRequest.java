package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.pe;
import com.google.android.gms.internal.pe.C3146a;
import java.util.Date;
import java.util.Set;

public final class AdRequest {
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    private final pe f6675a;

    public static final class Builder {
        private final C3146a f6674a = new C3146a();

        public Builder() {
            this.f6674a.m13063b("B3EEABB8EE11C2BE770B684D95219ECB");
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.f6674a.m13062b(cls, bundle);
            return this;
        }

        public Builder addKeyword(String str) {
            this.f6674a.m13058a(str);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f6674a.m13056a(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.f6674a.m13057a((Class) cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.f6674a.m13065c("B3EEABB8EE11C2BE770B684D95219ECB");
            }
            return this;
        }

        public Builder addTestDevice(String str) {
            this.f6674a.m13063b(str);
            return this;
        }

        public AdRequest build() {
            return new AdRequest();
        }

        public Builder setBirthday(Date date) {
            this.f6674a.m13060a(date);
            return this;
        }

        public Builder setContentUrl(String str) {
            C2513c.m7933a((Object) str, (Object) "Content URL must be non-null.");
            C2513c.m7935a(str, (Object) "Content URL must be non-empty.");
            C2513c.m7943b(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", Integer.valueOf(512), Integer.valueOf(str.length()));
            this.f6674a.m13067d(str);
            return this;
        }

        public Builder setGender(int i) {
            this.f6674a.m13054a(i);
            return this;
        }

        public Builder setIsDesignedForFamilies(boolean z) {
            this.f6674a.m13066c(z);
            return this;
        }

        public Builder setLocation(Location location) {
            this.f6674a.m13055a(location);
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.f6674a.m13069f(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.f6674a.m13064b(z);
            return this;
        }
    }

    private AdRequest(Builder builder) {
        this.f6675a = new pe(builder.f6674a);
    }

    public Date getBirthday() {
        return this.f6675a.m13072a();
    }

    public String getContentUrl() {
        return this.f6675a.m13075b();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.f6675a.m13077c(cls);
    }

    public int getGender() {
        return this.f6675a.m13076c();
    }

    public Set<String> getKeywords() {
        return this.f6675a.m13078d();
    }

    public Location getLocation() {
        return this.f6675a.m13079e();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.f6675a.m13071a((Class) cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.f6675a.m13074b(cls);
    }

    public boolean isTestDevice(Context context) {
        return this.f6675a.m13073a(context);
    }

    public pe zzbp() {
        return this.f6675a;
    }
}
