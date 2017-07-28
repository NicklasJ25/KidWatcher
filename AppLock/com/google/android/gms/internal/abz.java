package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class abz implements Creator<zzzu> {
    static void m8921a(zzzu com_google_android_gms_internal_zzzu, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8142a(parcel, 2, com_google_android_gms_internal_zzzu.f12096a, false);
        C2552b.m8132a(parcel, 3, com_google_android_gms_internal_zzzu.f12097b);
        C2552b.m8132a(parcel, 4, com_google_android_gms_internal_zzzu.f12098c);
        C2552b.m8142a(parcel, 5, com_google_android_gms_internal_zzzu.f12099d, false);
        C2552b.m8142a(parcel, 6, com_google_android_gms_internal_zzzu.f12100e, false);
        C2552b.m8144a(parcel, 7, com_google_android_gms_internal_zzzu.f12101f);
        C2552b.m8142a(parcel, 8, com_google_android_gms_internal_zzzu.f12102g, false);
        C2552b.m8144a(parcel, 9, com_google_android_gms_internal_zzzu.f12103h);
        C2552b.m8132a(parcel, 10, com_google_android_gms_internal_zzzu.f12104i);
        C2552b.m8129a(parcel, a);
    }

    public zzzu m8922a(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = C2551a.m8100b(parcel);
        boolean z = true;
        boolean z2 = false;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        int i3 = 0;
        String str4 = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    str4 = C2551a.m8115n(parcel, a);
                    break;
                case 3:
                    i3 = C2551a.m8105d(parcel, a);
                    break;
                case 4:
                    i2 = C2551a.m8105d(parcel, a);
                    break;
                case 5:
                    str3 = C2551a.m8115n(parcel, a);
                    break;
                case 6:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 7:
                    z = C2551a.m8104c(parcel, a);
                    break;
                case 8:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 9:
                    z2 = C2551a.m8104c(parcel, a);
                    break;
                case 10:
                    i = C2551a.m8105d(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzzu(str4, i3, i2, str3, str2, z, str, z2, i);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzzu[] m8923a(int i) {
        return new zzzu[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8922a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8923a(i);
    }
}
