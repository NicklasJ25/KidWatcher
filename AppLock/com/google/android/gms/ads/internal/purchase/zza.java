package com.google.android.gms.ads.internal.purchase;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class zza implements Creator<GInAppPurchaseManagerInfoParcel> {
    static void m7445a(GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8135a(parcel, 3, gInAppPurchaseManagerInfoParcel.m7442b(), false);
        C2552b.m8135a(parcel, 4, gInAppPurchaseManagerInfoParcel.m7443c(), false);
        C2552b.m8135a(parcel, 5, gInAppPurchaseManagerInfoParcel.m7444d(), false);
        C2552b.m8135a(parcel, 6, gInAppPurchaseManagerInfoParcel.m7441a(), false);
        C2552b.m8129a(parcel, a);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzm(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzO(i);
    }

    public GInAppPurchaseManagerInfoParcel[] zzO(int i) {
        return new GInAppPurchaseManagerInfoParcel[i];
    }

    public GInAppPurchaseManagerInfoParcel zzm(Parcel parcel) {
        IBinder iBinder = null;
        int b = C2551a.m8100b(parcel);
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 3:
                    iBinder4 = C2551a.m8116o(parcel, a);
                    break;
                case 4:
                    iBinder3 = C2551a.m8116o(parcel, a);
                    break;
                case 5:
                    iBinder2 = C2551a.m8116o(parcel, a);
                    break;
                case 6:
                    iBinder = C2551a.m8116o(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GInAppPurchaseManagerInfoParcel(iBinder4, iBinder3, iBinder2, iBinder);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }
}
