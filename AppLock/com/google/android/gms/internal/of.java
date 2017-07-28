package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import java.util.List;

public class of implements Creator<zzec> {
    static void m12901a(zzec com_google_android_gms_internal_zzec, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzec.f11877a);
        C2552b.m8133a(parcel, 2, com_google_android_gms_internal_zzec.f11878b);
        C2552b.m8134a(parcel, 3, com_google_android_gms_internal_zzec.f11879c, false);
        C2552b.m8132a(parcel, 4, com_google_android_gms_internal_zzec.f11880d);
        C2552b.m8143a(parcel, 5, com_google_android_gms_internal_zzec.f11881e, false);
        C2552b.m8144a(parcel, 6, com_google_android_gms_internal_zzec.f11882f);
        C2552b.m8132a(parcel, 7, com_google_android_gms_internal_zzec.f11883g);
        C2552b.m8144a(parcel, 8, com_google_android_gms_internal_zzec.f11884h);
        C2552b.m8142a(parcel, 9, com_google_android_gms_internal_zzec.f11885i, false);
        C2552b.m8137a(parcel, 10, com_google_android_gms_internal_zzec.f11886j, i, false);
        C2552b.m8137a(parcel, 11, com_google_android_gms_internal_zzec.f11887k, i, false);
        C2552b.m8142a(parcel, 12, com_google_android_gms_internal_zzec.f11888l, false);
        C2552b.m8134a(parcel, 13, com_google_android_gms_internal_zzec.f11889m, false);
        C2552b.m8134a(parcel, 14, com_google_android_gms_internal_zzec.f11890n, false);
        C2552b.m8143a(parcel, 15, com_google_android_gms_internal_zzec.f11891o, false);
        C2552b.m8142a(parcel, 16, com_google_android_gms_internal_zzec.f11892p, false);
        C2552b.m8142a(parcel, 17, com_google_android_gms_internal_zzec.f11893q, false);
        C2552b.m8144a(parcel, 18, com_google_android_gms_internal_zzec.f11894r);
        C2552b.m8129a(parcel, a);
    }

    public zzec m12902a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        zzfp com_google_android_gms_internal_zzfp = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        List list2 = null;
        String str3 = null;
        String str4 = null;
        boolean z3 = false;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    j = C2551a.m8107f(parcel, a);
                    break;
                case 3:
                    bundle = C2551a.m8117p(parcel, a);
                    break;
                case 4:
                    i2 = C2551a.m8105d(parcel, a);
                    break;
                case 5:
                    list = C2551a.m8091A(parcel, a);
                    break;
                case 6:
                    z = C2551a.m8104c(parcel, a);
                    break;
                case 7:
                    i3 = C2551a.m8105d(parcel, a);
                    break;
                case 8:
                    z2 = C2551a.m8104c(parcel, a);
                    break;
                case 9:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 10:
                    com_google_android_gms_internal_zzfp = (zzfp) C2551a.m8097a(parcel, a, zzfp.CREATOR);
                    break;
                case 11:
                    location = (Location) C2551a.m8097a(parcel, a, Location.CREATOR);
                    break;
                case 12:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 13:
                    bundle2 = C2551a.m8117p(parcel, a);
                    break;
                case 14:
                    bundle3 = C2551a.m8117p(parcel, a);
                    break;
                case 15:
                    list2 = C2551a.m8091A(parcel, a);
                    break;
                case 16:
                    str3 = C2551a.m8115n(parcel, a);
                    break;
                case 17:
                    str4 = C2551a.m8115n(parcel, a);
                    break;
                case 18:
                    z3 = C2551a.m8104c(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzec(i, j, bundle, i2, list, z, i3, z2, str, com_google_android_gms_internal_zzfp, location, str2, bundle2, bundle3, list2, str3, str4, z3);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzec[] m12903a(int i) {
        return new zzec[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m12902a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m12903a(i);
    }
}
