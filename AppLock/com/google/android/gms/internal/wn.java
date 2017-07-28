package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import java.util.List;

public class wn implements Creator<zzmk> {
    static void m14534a(zzmk com_google_android_gms_internal_zzmk, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzmk.f11992a);
        C2552b.m8134a(parcel, 2, com_google_android_gms_internal_zzmk.f11993b, false);
        C2552b.m8137a(parcel, 3, com_google_android_gms_internal_zzmk.f11994c, i, false);
        C2552b.m8137a(parcel, 4, com_google_android_gms_internal_zzmk.f11995d, i, false);
        C2552b.m8142a(parcel, 5, com_google_android_gms_internal_zzmk.f11996e, false);
        C2552b.m8137a(parcel, 6, com_google_android_gms_internal_zzmk.f11997f, i, false);
        C2552b.m8137a(parcel, 7, com_google_android_gms_internal_zzmk.f11998g, i, false);
        C2552b.m8142a(parcel, 8, com_google_android_gms_internal_zzmk.f11999h, false);
        C2552b.m8142a(parcel, 9, com_google_android_gms_internal_zzmk.f12000i, false);
        C2552b.m8142a(parcel, 10, com_google_android_gms_internal_zzmk.f12001j, false);
        C2552b.m8137a(parcel, 11, com_google_android_gms_internal_zzmk.f12002k, i, false);
        C2552b.m8134a(parcel, 12, com_google_android_gms_internal_zzmk.f12003l, false);
        C2552b.m8132a(parcel, 13, com_google_android_gms_internal_zzmk.f12004m);
        C2552b.m8143a(parcel, 14, com_google_android_gms_internal_zzmk.f12005n, false);
        C2552b.m8134a(parcel, 15, com_google_android_gms_internal_zzmk.f12006o, false);
        C2552b.m8144a(parcel, 16, com_google_android_gms_internal_zzmk.f12007p);
        C2552b.m8132a(parcel, 18, com_google_android_gms_internal_zzmk.f12008q);
        C2552b.m8132a(parcel, 19, com_google_android_gms_internal_zzmk.f12009r);
        C2552b.m8131a(parcel, 20, com_google_android_gms_internal_zzmk.f12010s);
        C2552b.m8142a(parcel, 21, com_google_android_gms_internal_zzmk.f12011t, false);
        C2552b.m8133a(parcel, 25, com_google_android_gms_internal_zzmk.f12012u);
        C2552b.m8142a(parcel, 26, com_google_android_gms_internal_zzmk.f12013v, false);
        C2552b.m8143a(parcel, 27, com_google_android_gms_internal_zzmk.f12014w, false);
        C2552b.m8142a(parcel, 28, com_google_android_gms_internal_zzmk.f12015x, false);
        C2552b.m8137a(parcel, 29, com_google_android_gms_internal_zzmk.f12016y, i, false);
        C2552b.m8143a(parcel, 30, com_google_android_gms_internal_zzmk.f12017z, false);
        C2552b.m8133a(parcel, 31, com_google_android_gms_internal_zzmk.f11970A);
        C2552b.m8137a(parcel, 32, com_google_android_gms_internal_zzmk.f11971B, i, false);
        C2552b.m8142a(parcel, 33, com_google_android_gms_internal_zzmk.f11972C, false);
        C2552b.m8131a(parcel, 34, com_google_android_gms_internal_zzmk.f11973D);
        C2552b.m8132a(parcel, 35, com_google_android_gms_internal_zzmk.f11974E);
        C2552b.m8132a(parcel, 36, com_google_android_gms_internal_zzmk.f11975F);
        C2552b.m8144a(parcel, 37, com_google_android_gms_internal_zzmk.f11976G);
        C2552b.m8144a(parcel, 38, com_google_android_gms_internal_zzmk.f11977H);
        C2552b.m8142a(parcel, 39, com_google_android_gms_internal_zzmk.f11978I, false);
        C2552b.m8144a(parcel, 40, com_google_android_gms_internal_zzmk.f11979J);
        C2552b.m8142a(parcel, 41, com_google_android_gms_internal_zzmk.f11980K, false);
        C2552b.m8144a(parcel, 42, com_google_android_gms_internal_zzmk.f11981L);
        C2552b.m8132a(parcel, 43, com_google_android_gms_internal_zzmk.f11982M);
        C2552b.m8134a(parcel, 44, com_google_android_gms_internal_zzmk.f11983N, false);
        C2552b.m8142a(parcel, 45, com_google_android_gms_internal_zzmk.f11984O, false);
        C2552b.m8137a(parcel, 46, com_google_android_gms_internal_zzmk.f11985P, i, false);
        C2552b.m8144a(parcel, 47, com_google_android_gms_internal_zzmk.f11986Q);
        C2552b.m8134a(parcel, 48, com_google_android_gms_internal_zzmk.f11987R, false);
        C2552b.m8142a(parcel, 49, com_google_android_gms_internal_zzmk.f11988S, false);
        C2552b.m8142a(parcel, 50, com_google_android_gms_internal_zzmk.f11989T, false);
        C2552b.m8142a(parcel, 51, com_google_android_gms_internal_zzmk.f11990U, false);
        C2552b.m8144a(parcel, 52, com_google_android_gms_internal_zzmk.f11991V);
        C2552b.m8129a(parcel, a);
    }

    public zzmk m14535a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        int i = 0;
        Bundle bundle = null;
        zzec com_google_android_gms_internal_zzec = null;
        zzeg com_google_android_gms_internal_zzeg = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        zzqh com_google_android_gms_internal_zzqh = null;
        Bundle bundle2 = null;
        int i2 = 0;
        List list = null;
        Bundle bundle3 = null;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        String str5 = null;
        long j = 0;
        String str6 = null;
        List list2 = null;
        String str7 = null;
        zzhc com_google_android_gms_internal_zzhc = null;
        List list3 = null;
        long j2 = 0;
        zzmr com_google_android_gms_internal_zzmr = null;
        String str8 = null;
        float f2 = 0.0f;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        int i7 = 0;
        Bundle bundle4 = null;
        String str11 = null;
        zzfc com_google_android_gms_internal_zzfc = null;
        boolean z6 = false;
        Bundle bundle5 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        boolean z7 = false;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    bundle = C2551a.m8117p(parcel, a);
                    break;
                case 3:
                    com_google_android_gms_internal_zzec = (zzec) C2551a.m8097a(parcel, a, zzec.CREATOR);
                    break;
                case 4:
                    com_google_android_gms_internal_zzeg = (zzeg) C2551a.m8097a(parcel, a, zzeg.CREATOR);
                    break;
                case 5:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) C2551a.m8097a(parcel, a, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) C2551a.m8097a(parcel, a, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 9:
                    str3 = C2551a.m8115n(parcel, a);
                    break;
                case 10:
                    str4 = C2551a.m8115n(parcel, a);
                    break;
                case 11:
                    com_google_android_gms_internal_zzqh = (zzqh) C2551a.m8097a(parcel, a, zzqh.CREATOR);
                    break;
                case 12:
                    bundle2 = C2551a.m8117p(parcel, a);
                    break;
                case 13:
                    i2 = C2551a.m8105d(parcel, a);
                    break;
                case 14:
                    list = C2551a.m8091A(parcel, a);
                    break;
                case 15:
                    bundle3 = C2551a.m8117p(parcel, a);
                    break;
                case 16:
                    z = C2551a.m8104c(parcel, a);
                    break;
                case 18:
                    i3 = C2551a.m8105d(parcel, a);
                    break;
                case 19:
                    i4 = C2551a.m8105d(parcel, a);
                    break;
                case 20:
                    f = C2551a.m8110i(parcel, a);
                    break;
                case 21:
                    str5 = C2551a.m8115n(parcel, a);
                    break;
                case 25:
                    j = C2551a.m8107f(parcel, a);
                    break;
                case 26:
                    str6 = C2551a.m8115n(parcel, a);
                    break;
                case 27:
                    list2 = C2551a.m8091A(parcel, a);
                    break;
                case 28:
                    str7 = C2551a.m8115n(parcel, a);
                    break;
                case 29:
                    com_google_android_gms_internal_zzhc = (zzhc) C2551a.m8097a(parcel, a, zzhc.CREATOR);
                    break;
                case 30:
                    list3 = C2551a.m8091A(parcel, a);
                    break;
                case 31:
                    j2 = C2551a.m8107f(parcel, a);
                    break;
                case 32:
                    com_google_android_gms_internal_zzmr = (zzmr) C2551a.m8097a(parcel, a, zzmr.CREATOR);
                    break;
                case 33:
                    str8 = C2551a.m8115n(parcel, a);
                    break;
                case 34:
                    f2 = C2551a.m8110i(parcel, a);
                    break;
                case 35:
                    i5 = C2551a.m8105d(parcel, a);
                    break;
                case 36:
                    i6 = C2551a.m8105d(parcel, a);
                    break;
                case 37:
                    z3 = C2551a.m8104c(parcel, a);
                    break;
                case 38:
                    z4 = C2551a.m8104c(parcel, a);
                    break;
                case 39:
                    str9 = C2551a.m8115n(parcel, a);
                    break;
                case 40:
                    z2 = C2551a.m8104c(parcel, a);
                    break;
                case 41:
                    str10 = C2551a.m8115n(parcel, a);
                    break;
                case 42:
                    z5 = C2551a.m8104c(parcel, a);
                    break;
                case 43:
                    i7 = C2551a.m8105d(parcel, a);
                    break;
                case 44:
                    bundle4 = C2551a.m8117p(parcel, a);
                    break;
                case 45:
                    str11 = C2551a.m8115n(parcel, a);
                    break;
                case 46:
                    com_google_android_gms_internal_zzfc = (zzfc) C2551a.m8097a(parcel, a, zzfc.CREATOR);
                    break;
                case 47:
                    z6 = C2551a.m8104c(parcel, a);
                    break;
                case 48:
                    bundle5 = C2551a.m8117p(parcel, a);
                    break;
                case 49:
                    str12 = C2551a.m8115n(parcel, a);
                    break;
                case 50:
                    str13 = C2551a.m8115n(parcel, a);
                    break;
                case 51:
                    str14 = C2551a.m8115n(parcel, a);
                    break;
                case 52:
                    z7 = C2551a.m8104c(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzmk(i, bundle, com_google_android_gms_internal_zzec, com_google_android_gms_internal_zzeg, str, applicationInfo, packageInfo, str2, str3, str4, com_google_android_gms_internal_zzqh, bundle2, i2, list, bundle3, z, i3, i4, f, str5, j, str6, list2, str7, com_google_android_gms_internal_zzhc, list3, j2, com_google_android_gms_internal_zzmr, str8, f2, z2, i5, i6, z3, z4, str9, str10, z5, i7, bundle4, str11, com_google_android_gms_internal_zzfc, z6, bundle5, str12, str13, str14, z7);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzmk[] m14536a(int i) {
        return new zzmk[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14535a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14536a(i);
    }
}
