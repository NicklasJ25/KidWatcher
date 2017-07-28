package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.pe;
import com.google.android.gms.internal.pe.C3146a;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    private final pe f6689a;

    public static final class Builder {
        private final C3146a f6688a = new C3146a();

        public Builder addCategoryExclusion(String str) {
            this.f6688a.m13070g(str);
            return this;
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.f6688a.m13062b(cls, bundle);
            return this;
        }

        public Builder addCustomTargeting(String str, String str2) {
            this.f6688a.m13059a(str, str2);
            return this;
        }

        public Builder addCustomTargeting(String str, List<String> list) {
            if (list != null) {
                this.f6688a.m13059a(str, TextUtils.join(",", list));
            }
            return this;
        }

        public Builder addKeyword(String str) {
            this.f6688a.m13058a(str);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.f6688a.m13056a(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.f6688a.m13057a((Class) cls, bundle);
            return this;
        }

        public Builder addTestDevice(String str) {
            this.f6688a.m13063b(str);
            return this;
        }

        public PublisherAdRequest build() {
            return new PublisherAdRequest();
        }

        public Builder setBirthday(Date date) {
            this.f6688a.m13060a(date);
            return this;
        }

        public Builder setContentUrl(String str) {
            C2513c.m7933a((Object) str, (Object) "Content URL must be non-null.");
            C2513c.m7935a(str, (Object) "Content URL must be non-empty.");
            C2513c.m7943b(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", Integer.valueOf(512), Integer.valueOf(str.length()));
            this.f6688a.m13067d(str);
            return this;
        }

        public Builder setGender(int i) {
            this.f6688a.m13054a(i);
            return this;
        }

        public Builder setIsDesignedForFamilies(boolean z) {
            this.f6688a.m13066c(z);
            return this;
        }

        public Builder setLocation(Location location) {
            this.f6688a.m13055a(location);
            return this;
        }

        @Deprecated
        public Builder setManualImpressionsEnabled(boolean z) {
            this.f6688a.m13061a(z);
            return this;
        }

        public Builder setPublisherProvidedId(String str) {
            this.f6688a.m13068e(str);
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.f6688a.m13069f(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.f6688a.m13064b(z);
            return this;
        }
    }

    private PublisherAdRequest(Builder builder) {
        this.f6689a = new pe(builder.f6688a);
    }

    public static void updateCorrelator() {
    }

    public Date getBirthday() {
        return this.f6689a.m13072a();
    }

    public String getContentUrl() {
        return this.f6689a.m13075b();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.f6689a.m13077c(cls);
    }

    public Bundle getCustomTargeting() {
        return this.f6689a.m13087m();
    }

    public int getGender() {
        return this.f6689a.m13076c();
    }

    public Set<String> getKeywords() {
        return this.f6689a.m13078d();
    }

    public Location getLocation() {
        return this.f6689a.m13079e();
    }

    public boolean getManualImpressionsEnabled() {
        return this.f6689a.m13080f();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.f6689a.m13071a((Class) cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.f6689a.m13074b(cls);
    }

    public String getPublisherProvidedId() {
        return this.f6689a.m13081g();
    }

    public boolean isTestDevice(Context context) {
        return this.f6689a.m13073a(context);
    }

    public pe zzbp() {
        return this.f6689a;
    }
}
