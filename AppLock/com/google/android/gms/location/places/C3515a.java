package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class C3515a implements Creator<PlaceReport> {
    static void m15401a(PlaceReport placeReport, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, placeReport.f12105a);
        C2552b.m8142a(parcel, 2, placeReport.m15398a(), false);
        C2552b.m8142a(parcel, 3, placeReport.m15399b(), false);
        C2552b.m8142a(parcel, 4, placeReport.m15400c(), false);
        C2552b.m8129a(parcel, a);
    }

    public PlaceReport m15402a(Parcel parcel) {
        String str = null;
        int b = C2551a.m8100b(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    str3 = C2551a.m8115n(parcel, a);
                    break;
                case 3:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 4:
                    str = C2551a.m8115n(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PlaceReport(i, str3, str2, str);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public PlaceReport[] m15403a(int i) {
        return new PlaceReport[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m15402a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m15403a(i);
    }
}
