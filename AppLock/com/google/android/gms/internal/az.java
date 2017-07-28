package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import com.google.android.gms.internal.zzacp.zza;
import java.util.ArrayList;

public class az implements Creator<zzacp> {
    static void m9080a(zzacp com_google_android_gms_internal_zzacp, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzacp.f11759a);
        C2552b.m8153b(parcel, 2, com_google_android_gms_internal_zzacp.m15294a(), false);
        C2552b.m8129a(parcel, a);
    }

    public zzacp m9081a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    arrayList = C2551a.m8103c(parcel, a, zza.CREATOR);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzacp(i, arrayList);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzacp[] m9082a(int i) {
        return new zzacp[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9081a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9082a(i);
    }
}
