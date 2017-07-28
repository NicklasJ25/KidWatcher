package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class ce implements Creator<zzaqi> {
    static void m9295a(zzaqi com_google_android_gms_internal_zzaqi, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzaqi.f11791a);
        C2552b.m8142a(parcel, 2, com_google_android_gms_internal_zzaqi.f11792b, false);
        C2552b.m8142a(parcel, 3, com_google_android_gms_internal_zzaqi.f11793c, false);
        C2552b.m8129a(parcel, a);
    }

    public zzaqi m9296a(Parcel parcel) {
        String str = null;
        int b = C2551a.m8100b(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 3:
                    str = C2551a.m8115n(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzaqi(i, str2, str);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzaqi[] m9297a(int i) {
        return new zzaqi[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9296a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9297a(i);
    }
}
