package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import java.util.List;

public class wq implements Creator<zzmp> {
    static void m14543a(zzmp com_google_android_gms_internal_zzmp, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8144a(parcel, 2, com_google_android_gms_internal_zzmp.f12061a);
        C2552b.m8143a(parcel, 3, com_google_android_gms_internal_zzmp.f12062b, false);
        C2552b.m8129a(parcel, a);
    }

    public zzmp m14544a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        boolean z = false;
        List list = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    z = C2551a.m8104c(parcel, a);
                    break;
                case 3:
                    list = C2551a.m8091A(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzmp(z, list);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzmp[] m14545a(int i) {
        return new zzmp[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14544a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14545a(i);
    }
}
