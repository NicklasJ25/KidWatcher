package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import com.google.android.gms.internal.zzqh;

public class zzg implements Creator<AdOverlayInfoParcel> {
    static void m7409a(AdOverlayInfoParcel adOverlayInfoParcel, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8137a(parcel, 2, adOverlayInfoParcel.zzNE, i, false);
        C2552b.m8135a(parcel, 3, adOverlayInfoParcel.m7371a(), false);
        C2552b.m8135a(parcel, 4, adOverlayInfoParcel.m7372b(), false);
        C2552b.m8135a(parcel, 5, adOverlayInfoParcel.m7373c(), false);
        C2552b.m8135a(parcel, 6, adOverlayInfoParcel.m7374d(), false);
        C2552b.m8142a(parcel, 7, adOverlayInfoParcel.zzNJ, false);
        C2552b.m8144a(parcel, 8, adOverlayInfoParcel.zzNK);
        C2552b.m8142a(parcel, 9, adOverlayInfoParcel.zzNL, false);
        C2552b.m8135a(parcel, 10, adOverlayInfoParcel.m7376f(), false);
        C2552b.m8132a(parcel, 11, adOverlayInfoParcel.orientation);
        C2552b.m8132a(parcel, 12, adOverlayInfoParcel.zzNN);
        C2552b.m8142a(parcel, 13, adOverlayInfoParcel.url, false);
        C2552b.m8137a(parcel, 14, adOverlayInfoParcel.zzvn, i, false);
        C2552b.m8135a(parcel, 15, adOverlayInfoParcel.m7375e(), false);
        C2552b.m8142a(parcel, 16, adOverlayInfoParcel.zzNP, false);
        C2552b.m8137a(parcel, 17, adOverlayInfoParcel.zzNQ, i, false);
        C2552b.m8129a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzl(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzN(i);
    }

    public AdOverlayInfoParcel[] zzN(int i) {
        return new AdOverlayInfoParcel[i];
    }

    public AdOverlayInfoParcel zzl(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        zzc com_google_android_gms_ads_internal_overlay_zzc = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i = 0;
        int i2 = 0;
        String str3 = null;
        zzqh com_google_android_gms_internal_zzqh = null;
        IBinder iBinder6 = null;
        String str4 = null;
        zzn com_google_android_gms_ads_internal_zzn = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    com_google_android_gms_ads_internal_overlay_zzc = (zzc) C2551a.m8097a(parcel, a, zzc.CREATOR);
                    break;
                case 3:
                    iBinder = C2551a.m8116o(parcel, a);
                    break;
                case 4:
                    iBinder2 = C2551a.m8116o(parcel, a);
                    break;
                case 5:
                    iBinder3 = C2551a.m8116o(parcel, a);
                    break;
                case 6:
                    iBinder4 = C2551a.m8116o(parcel, a);
                    break;
                case 7:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 8:
                    z = C2551a.m8104c(parcel, a);
                    break;
                case 9:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 10:
                    iBinder5 = C2551a.m8116o(parcel, a);
                    break;
                case 11:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 12:
                    i2 = C2551a.m8105d(parcel, a);
                    break;
                case 13:
                    str3 = C2551a.m8115n(parcel, a);
                    break;
                case 14:
                    com_google_android_gms_internal_zzqh = (zzqh) C2551a.m8097a(parcel, a, zzqh.CREATOR);
                    break;
                case 15:
                    iBinder6 = C2551a.m8116o(parcel, a);
                    break;
                case 16:
                    str4 = C2551a.m8115n(parcel, a);
                    break;
                case 17:
                    com_google_android_gms_ads_internal_zzn = (zzn) C2551a.m8097a(parcel, a, zzn.CREATOR);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdOverlayInfoParcel(com_google_android_gms_ads_internal_overlay_zzc, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i, i2, str3, com_google_android_gms_internal_zzqh, iBinder6, str4, com_google_android_gms_ads_internal_zzn);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }
}
