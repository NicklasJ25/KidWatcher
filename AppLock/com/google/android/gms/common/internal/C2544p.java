package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import com.google.android.gms.common.zzc;

public class C2544p implements Creator<zzj> {
    static void m8069a(zzj com_google_android_gms_common_internal_zzj, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_common_internal_zzj.f7513a);
        C2552b.m8132a(parcel, 2, com_google_android_gms_common_internal_zzj.f7514b);
        C2552b.m8132a(parcel, 3, com_google_android_gms_common_internal_zzj.f7515c);
        C2552b.m8142a(parcel, 4, com_google_android_gms_common_internal_zzj.f7516d, false);
        C2552b.m8135a(parcel, 5, com_google_android_gms_common_internal_zzj.f7517e, false);
        C2552b.m8147a(parcel, 6, com_google_android_gms_common_internal_zzj.f7518f, i, false);
        C2552b.m8134a(parcel, 7, com_google_android_gms_common_internal_zzj.f7519g, false);
        C2552b.m8137a(parcel, 8, com_google_android_gms_common_internal_zzj.f7520h, i, false);
        C2552b.m8147a(parcel, 10, com_google_android_gms_common_internal_zzj.f7521i, i, false);
        C2552b.m8129a(parcel, a);
    }

    public zzj m8070a(Parcel parcel) {
        int i = 0;
        zzc[] com_google_android_gms_common_zzcArr = null;
        int b = C2551a.m8100b(parcel);
        Account account = null;
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i3 = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    i2 = C2551a.m8105d(parcel, a);
                    break;
                case 3:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 4:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 5:
                    iBinder = C2551a.m8116o(parcel, a);
                    break;
                case 6:
                    scopeArr = (Scope[]) C2551a.m8102b(parcel, a, Scope.CREATOR);
                    break;
                case 7:
                    bundle = C2551a.m8117p(parcel, a);
                    break;
                case 8:
                    account = (Account) C2551a.m8097a(parcel, a, Account.CREATOR);
                    break;
                case 10:
                    com_google_android_gms_common_zzcArr = (zzc[]) C2551a.m8102b(parcel, a, zzc.CREATOR);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzj(i3, i2, i, str, iBinder, scopeArr, bundle, account, com_google_android_gms_common_zzcArr);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzj[] m8071a(int i) {
        return new zzj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8070a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8071a(i);
    }
}
