package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import java.util.List;

public class yo implements Creator<zzor> {
    static void m14929a(zzor com_google_android_gms_internal_zzor, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8142a(parcel, 2, com_google_android_gms_internal_zzor.f12076a, false);
        C2552b.m8142a(parcel, 3, com_google_android_gms_internal_zzor.f12077b, false);
        C2552b.m8144a(parcel, 4, com_google_android_gms_internal_zzor.f12078c);
        C2552b.m8144a(parcel, 5, com_google_android_gms_internal_zzor.f12079d);
        C2552b.m8143a(parcel, 6, com_google_android_gms_internal_zzor.f12080e, false);
        C2552b.m8129a(parcel, a);
    }

    public zzor m14930a(Parcel parcel) {
        boolean z = false;
        List list = null;
        int b = C2551a.m8100b(parcel);
        boolean z2 = false;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 3:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 4:
                    z2 = C2551a.m8104c(parcel, a);
                    break;
                case 5:
                    z = C2551a.m8104c(parcel, a);
                    break;
                case 6:
                    list = C2551a.m8091A(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzor(str2, str, z2, z, list);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzor[] m14931a(int i) {
        return new zzor[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14930a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14931a(i);
    }
}
