package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class C2487a implements Creator<BitmapTeleporter> {
    static void m7851a(BitmapTeleporter bitmapTeleporter, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, bitmapTeleporter.f7319a);
        C2552b.m8137a(parcel, 2, bitmapTeleporter.f7320b, i, false);
        C2552b.m8132a(parcel, 3, bitmapTeleporter.f7321c);
        C2552b.m8129a(parcel, a);
    }

    public BitmapTeleporter m7852a(Parcel parcel) {
        int i = 0;
        int b = C2551a.m8100b(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            ParcelFileDescriptor parcelFileDescriptor2;
            int d;
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    int i3 = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    d = C2551a.m8105d(parcel, a);
                    a = i3;
                    break;
                case 2:
                    d = i2;
                    ParcelFileDescriptor parcelFileDescriptor3 = (ParcelFileDescriptor) C2551a.m8097a(parcel, a, ParcelFileDescriptor.CREATOR);
                    a = i;
                    parcelFileDescriptor2 = parcelFileDescriptor3;
                    break;
                case 3:
                    a = C2551a.m8105d(parcel, a);
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    d = i2;
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    a = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    d = i2;
                    break;
            }
            i2 = d;
            parcelFileDescriptor = parcelFileDescriptor2;
            i = a;
        }
        if (parcel.dataPosition() == b) {
            return new BitmapTeleporter(i2, parcelFileDescriptor, i);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public BitmapTeleporter[] m7853a(int i) {
        return new BitmapTeleporter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7852a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7853a(i);
    }
}
