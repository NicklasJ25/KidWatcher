package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class eg implements Creator<zzayx> {
    static void m10575a(zzayx com_google_android_gms_internal_zzayx, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 2, com_google_android_gms_internal_zzayx.f11838a);
        C2552b.m8147a(parcel, 3, com_google_android_gms_internal_zzayx.f11839b, i, false);
        C2552b.m8148a(parcel, 4, com_google_android_gms_internal_zzayx.f11840c, false);
        C2552b.m8129a(parcel, a);
    }

    public zzayx m10576a(Parcel parcel) {
        String[] strArr = null;
        int b = C2551a.m8100b(parcel);
        int i = 0;
        zzayz[] com_google_android_gms_internal_zzayzArr = null;
        while (parcel.dataPosition() < b) {
            zzayz[] com_google_android_gms_internal_zzayzArr2;
            int d;
            String[] strArr2;
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    String[] strArr3 = strArr;
                    com_google_android_gms_internal_zzayzArr2 = com_google_android_gms_internal_zzayzArr;
                    d = C2551a.m8105d(parcel, a);
                    strArr2 = strArr3;
                    break;
                case 3:
                    d = i;
                    zzayz[] com_google_android_gms_internal_zzayzArr3 = (zzayz[]) C2551a.m8102b(parcel, a, zzayz.CREATOR);
                    strArr2 = strArr;
                    com_google_android_gms_internal_zzayzArr2 = com_google_android_gms_internal_zzayzArr3;
                    break;
                case 4:
                    strArr2 = C2551a.m8127z(parcel, a);
                    com_google_android_gms_internal_zzayzArr2 = com_google_android_gms_internal_zzayzArr;
                    d = i;
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    strArr2 = strArr;
                    com_google_android_gms_internal_zzayzArr2 = com_google_android_gms_internal_zzayzArr;
                    d = i;
                    break;
            }
            i = d;
            com_google_android_gms_internal_zzayzArr = com_google_android_gms_internal_zzayzArr2;
            strArr = strArr2;
        }
        if (parcel.dataPosition() == b) {
            return new zzayx(i, com_google_android_gms_internal_zzayzArr, strArr);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzayx[] m10577a(int i) {
        return new zzayx[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10576a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10577a(i);
    }
}
