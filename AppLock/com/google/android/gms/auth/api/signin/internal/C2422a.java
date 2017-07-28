package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class C2422a implements Creator<zzg> {
    static void m7655a(zzg com_google_android_gms_auth_api_signin_internal_zzg, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_auth_api_signin_internal_zzg.f7222a);
        C2552b.m8132a(parcel, 2, com_google_android_gms_auth_api_signin_internal_zzg.m7668a());
        C2552b.m8134a(parcel, 3, com_google_android_gms_auth_api_signin_internal_zzg.m7669b(), false);
        C2552b.m8129a(parcel, a);
    }

    public zzg m7656a(Parcel parcel) {
        int i = 0;
        int b = C2551a.m8100b(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i2 = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 3:
                    bundle = C2551a.m8117p(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzg(i2, i, bundle);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzg[] m7657a(int i) {
        return new zzg[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7656a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7657a(i);
    }
}
