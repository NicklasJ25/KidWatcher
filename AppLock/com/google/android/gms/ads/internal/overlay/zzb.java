package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class zzb implements Creator<zzc> {
    static void m7390a(zzc com_google_android_gms_ads_internal_overlay_zzc, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8142a(parcel, 2, com_google_android_gms_ads_internal_overlay_zzc.zzMG, false);
        C2552b.m8142a(parcel, 3, com_google_android_gms_ads_internal_overlay_zzc.url, false);
        C2552b.m8142a(parcel, 4, com_google_android_gms_ads_internal_overlay_zzc.mimeType, false);
        C2552b.m8142a(parcel, 5, com_google_android_gms_ads_internal_overlay_zzc.packageName, false);
        C2552b.m8142a(parcel, 6, com_google_android_gms_ads_internal_overlay_zzc.zzMH, false);
        C2552b.m8142a(parcel, 7, com_google_android_gms_ads_internal_overlay_zzc.zzMI, false);
        C2552b.m8142a(parcel, 8, com_google_android_gms_ads_internal_overlay_zzc.zzMJ, false);
        C2552b.m8137a(parcel, 9, com_google_android_gms_ads_internal_overlay_zzc.intent, i, false);
        C2552b.m8129a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzk(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzJ(i);
    }

    public zzc[] zzJ(int i) {
        return new zzc[i];
    }

    public zzc zzk(Parcel parcel) {
        Intent intent = null;
        int b = C2551a.m8100b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    str7 = C2551a.m8115n(parcel, a);
                    break;
                case 3:
                    str6 = C2551a.m8115n(parcel, a);
                    break;
                case 4:
                    str5 = C2551a.m8115n(parcel, a);
                    break;
                case 5:
                    str4 = C2551a.m8115n(parcel, a);
                    break;
                case 6:
                    str3 = C2551a.m8115n(parcel, a);
                    break;
                case 7:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 8:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 9:
                    intent = (Intent) C2551a.m8097a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzc(str7, str6, str5, str4, str3, str2, str, intent);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }
}
