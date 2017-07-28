package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.zza;
import java.util.Date;
import java.util.HashSet;

@wh
public final class up {

    static /* synthetic */ class C33371 {
        static final /* synthetic */ int[] f10910a = new int[Gender.values().length];

        static {
            f10911b = new int[ErrorCode.values().length];
            try {
                f10911b[ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10911b[ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10911b[ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10911b[ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f10910a[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f10910a[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f10910a[Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static int m14264a(ErrorCode errorCode) {
        switch (errorCode) {
            case INVALID_REQUEST:
                return 1;
            case NETWORK_ERROR:
                return 2;
            case NO_FILL:
                return 3;
            default:
                return 0;
        }
    }

    public static Gender m14265a(int i) {
        switch (i) {
            case 1:
                return Gender.MALE;
            case 2:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }

    public static AdSize m14266a(zzeg com_google_android_gms_internal_zzeg) {
        int i = 0;
        AdSize[] adSizeArr = new AdSize[]{AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
        while (i < 6) {
            if (adSizeArr[i].getWidth() == com_google_android_gms_internal_zzeg.f11899e && adSizeArr[i].getHeight() == com_google_android_gms_internal_zzeg.f11896b) {
                return adSizeArr[i];
            }
            i++;
        }
        return new AdSize(zza.zza(com_google_android_gms_internal_zzeg.f11899e, com_google_android_gms_internal_zzeg.f11896b, com_google_android_gms_internal_zzeg.f11895a));
    }

    public static MediationAdRequest m14267a(zzec com_google_android_gms_internal_zzec) {
        return new MediationAdRequest(new Date(com_google_android_gms_internal_zzec.f11878b), m14265a(com_google_android_gms_internal_zzec.f11880d), com_google_android_gms_internal_zzec.f11881e != null ? new HashSet(com_google_android_gms_internal_zzec.f11881e) : null, com_google_android_gms_internal_zzec.f11882f, com_google_android_gms_internal_zzec.f11887k);
    }
}
