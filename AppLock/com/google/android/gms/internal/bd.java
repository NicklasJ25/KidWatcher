package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import com.google.android.gms.internal.zzacw.zza;
import java.util.ArrayList;

public class bd implements Creator<zzacw> {
    static void m9100a(zzacw com_google_android_gms_internal_zzacw, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzacw.f11780a);
        C2552b.m8153b(parcel, 2, com_google_android_gms_internal_zzacw.m15327b(), false);
        C2552b.m8142a(parcel, 3, com_google_android_gms_internal_zzacw.m15328c(), false);
        C2552b.m8129a(parcel, a);
    }

    public zzacw m9101a(Parcel parcel) {
        String str = null;
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
                case 3:
                    str = C2551a.m8115n(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzacw(i, arrayList, str);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzacw[] m9102a(int i) {
        return new zzacw[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9101a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9102a(i);
    }
}
