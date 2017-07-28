package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class C2524k implements Creator<zzd> {
    static void m8018a(zzd com_google_android_gms_common_internal_zzd, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_common_internal_zzd.f7508a);
        C2552b.m8135a(parcel, 2, com_google_android_gms_common_internal_zzd.f7509b, false);
        C2552b.m8147a(parcel, 3, com_google_android_gms_common_internal_zzd.f7510c, i, false);
        C2552b.m8140a(parcel, 4, com_google_android_gms_common_internal_zzd.f7511d, false);
        C2552b.m8140a(parcel, 5, com_google_android_gms_common_internal_zzd.f7512e, false);
        C2552b.m8129a(parcel, a);
    }

    public zzd m8019a(Parcel parcel) {
        Integer num = null;
        int b = C2551a.m8100b(parcel);
        int i = 0;
        Integer num2 = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    iBinder = C2551a.m8116o(parcel, a);
                    break;
                case 3:
                    scopeArr = (Scope[]) C2551a.m8102b(parcel, a, Scope.CREATOR);
                    break;
                case 4:
                    num2 = C2551a.m8106e(parcel, a);
                    break;
                case 5:
                    num = C2551a.m8106e(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzd(i, iBinder, scopeArr, num2, num);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzd[] m8020a(int i) {
        return new zzd[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8019a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8020a(i);
    }
}
