package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class C2488b implements Creator<DataHolder> {
    static void m7854a(DataHolder dataHolder, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8148a(parcel, 1, dataHolder.m7846b(), false);
        C2552b.m8147a(parcel, 2, dataHolder.m7847c(), i, false);
        C2552b.m8132a(parcel, 3, dataHolder.m7848d());
        C2552b.m8134a(parcel, 4, dataHolder.m7849e(), false);
        C2552b.m8132a(parcel, 1000, dataHolder.f7332a);
        C2552b.m8129a(parcel, a);
    }

    public DataHolder m7855a(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int b = C2551a.m8100b(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    strArr = C2551a.m8127z(parcel, a);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) C2551a.m8102b(parcel, a, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 4:
                    bundle = C2551a.m8117p(parcel, a);
                    break;
                case 1000:
                    i2 = C2551a.m8105d(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new C2550a("Overread allowed size end=" + b, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.m7845a();
        return dataHolder;
    }

    public DataHolder[] m7856a(int i) {
        return new DataHolder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7855a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7856a(i);
    }
}
