package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class cv implements Creator<zzato> {
    static void m9653a(zzato com_google_android_gms_internal_zzato, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8134a(parcel, 2, com_google_android_gms_internal_zzato.m15353b(), false);
        C2552b.m8129a(parcel, a);
    }

    public zzato m9654a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 2:
                    bundle = C2551a.m8117p(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new zzato(bundle);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzato[] m9655a(int i) {
        return new zzato[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9654a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m9655a(i);
    }
}
