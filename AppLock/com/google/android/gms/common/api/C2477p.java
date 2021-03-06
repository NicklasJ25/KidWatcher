package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class C2477p implements Creator<Scope> {
    static void m7801a(Scope scope, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, scope.f7261a);
        C2552b.m8142a(parcel, 2, scope.m7724a(), false);
        C2552b.m8129a(parcel, a);
    }

    public Scope m7802a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    str = C2551a.m8115n(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Scope(i, str);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public Scope[] m7803a(int i) {
        return new Scope[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7802a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7803a(i);
    }
}
