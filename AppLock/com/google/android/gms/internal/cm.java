package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class cm implements Creator<zzatd> {
    static void m9444a(zzatd com_google_android_gms_internal_zzatd, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8142a(parcel, 2, com_google_android_gms_internal_zzatd.f11797a, false);
        C2552b.m8142a(parcel, 3, com_google_android_gms_internal_zzatd.f11798b, false);
        C2552b.m8142a(parcel, 4, com_google_android_gms_internal_zzatd.f11799c, false);
        C2552b.m8142a(parcel, 5, com_google_android_gms_internal_zzatd.f11800d, false);
        C2552b.m8133a(parcel, 6, com_google_android_gms_internal_zzatd.f11801e);
        C2552b.m8133a(parcel, 7, com_google_android_gms_internal_zzatd.f11802f);
        C2552b.m8142a(parcel, 8, com_google_android_gms_internal_zzatd.f11803g, false);
        C2552b.m8144a(parcel, 9, com_google_android_gms_internal_zzatd.f11804h);
        C2552b.m8144a(parcel, 10, com_google_android_gms_internal_zzatd.f11805i);
        C2552b.m8133a(parcel, 11, com_google_android_gms_internal_zzatd.f11806j);
        C2552b.m8142a(parcel, 12, com_google_android_gms_internal_zzatd.f11807k, false);
        C2552b.m8133a(parcel, 13, com_google_android_gms_internal_zzatd.f11808l);
        C2552b.m8133a(parcel, 14, com_google_android_gms_internal_zzatd.f11809m);
        C2552b.m8132a(parcel, 15, com_google_android_gms_internal_zzatd.f11810n);
        C2552b.m8129a(parcel, a);
    }

    public zzatd m9445a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        String str5 = null;
        boolean z = true;
        boolean z2 = false;
        long j3 = -2147483648L;
        String str6 = null;
        long j4 = 0;
        long j5 = 0;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 3:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 4:
                    str3 = C2551a.m8115n(parcel, a);
                    break;
                case 5:
                    str4 = C2551a.m8115n(parcel, a);
                    break;
                case 6:
                    j = C2551a.m8107f(parcel, a);
                    break;
                case 7:
                    j2 = C2551a.m8107f(parcel, a);
                    break;
                case 8:
                    str5 = C2551a.m8115n(parcel, a);
                    break;
                case 9:
                    z = C2551a.m8104c(parcel, a);
                    break;
                case 10:
                    z2 = C2551a.m8104c(parcel, a);
                    break;
                case 11:
                    j3 = C2551a.m8107f(parcel, a);
                    break;
                case 12:
                    str6 = C2551a.m8115n(parcel, a);
                    break;
                case 13:
                    j4 = C2551a.m8107f(parcel, a);
                    break;
                case 14:
                    j5 = C2551a.m8107f(parcel, a);
                    break;
                case 15:
                    i = C2551a.m8105d(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzatd(str, str2, str3, str4, j, j2, str5, z, z2, j3, str6, j4, j5, i);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzatd[] m9446a(int i) {
        return new zzatd[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9445a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9446a(i);
    }
}
