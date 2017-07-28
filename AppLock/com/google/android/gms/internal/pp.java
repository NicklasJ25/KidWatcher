package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class pp implements Creator<zzfp> {
    static void m13195a(zzfp com_google_android_gms_internal_zzfp, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 2, com_google_android_gms_internal_zzfp.f11906a);
        C2552b.m8132a(parcel, 3, com_google_android_gms_internal_zzfp.f11907b);
        C2552b.m8132a(parcel, 4, com_google_android_gms_internal_zzfp.f11908c);
        C2552b.m8132a(parcel, 5, com_google_android_gms_internal_zzfp.f11909d);
        C2552b.m8132a(parcel, 6, com_google_android_gms_internal_zzfp.f11910e);
        C2552b.m8132a(parcel, 7, com_google_android_gms_internal_zzfp.f11911f);
        C2552b.m8132a(parcel, 8, com_google_android_gms_internal_zzfp.f11912g);
        C2552b.m8132a(parcel, 9, com_google_android_gms_internal_zzfp.f11913h);
        C2552b.m8142a(parcel, 10, com_google_android_gms_internal_zzfp.f11914i, false);
        C2552b.m8132a(parcel, 11, com_google_android_gms_internal_zzfp.f11915j);
        C2552b.m8142a(parcel, 12, com_google_android_gms_internal_zzfp.f11916k, false);
        C2552b.m8132a(parcel, 13, com_google_android_gms_internal_zzfp.f11917l);
        C2552b.m8132a(parcel, 14, com_google_android_gms_internal_zzfp.f11918m);
        C2552b.m8142a(parcel, 15, com_google_android_gms_internal_zzfp.f11919n, false);
        C2552b.m8129a(parcel, a);
    }

    public zzfp m13196a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        String str = null;
        int i9 = 0;
        String str2 = null;
        int i10 = 0;
        int i11 = 0;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 3:
                    i2 = C2551a.m8105d(parcel, a);
                    break;
                case 4:
                    i3 = C2551a.m8105d(parcel, a);
                    break;
                case 5:
                    i4 = C2551a.m8105d(parcel, a);
                    break;
                case 6:
                    i5 = C2551a.m8105d(parcel, a);
                    break;
                case 7:
                    i6 = C2551a.m8105d(parcel, a);
                    break;
                case 8:
                    i7 = C2551a.m8105d(parcel, a);
                    break;
                case 9:
                    i8 = C2551a.m8105d(parcel, a);
                    break;
                case 10:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 11:
                    i9 = C2551a.m8105d(parcel, a);
                    break;
                case 12:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 13:
                    i10 = C2551a.m8105d(parcel, a);
                    break;
                case 14:
                    i11 = C2551a.m8105d(parcel, a);
                    break;
                case 15:
                    str3 = C2551a.m8115n(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzfp(i, i2, i3, i4, i5, i6, i7, i8, str, i9, str2, i10, i11, str3);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzfp[] m13197a(int i) {
        return new zzfp[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m13196a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m13197a(i);
    }
}
