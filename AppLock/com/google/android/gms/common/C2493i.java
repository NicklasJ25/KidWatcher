package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class C2493i implements Creator<ConnectionResult> {
    static void m7878a(ConnectionResult connectionResult, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, connectionResult.f7254a);
        C2552b.m8132a(parcel, 2, connectionResult.m7714c());
        C2552b.m8137a(parcel, 3, connectionResult.m7715d(), i, false);
        C2552b.m8142a(parcel, 4, connectionResult.m7716e(), false);
        C2552b.m8129a(parcel, a);
    }

    public ConnectionResult m7879a(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = C2551a.m8100b(parcel);
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            PendingIntent pendingIntent2;
            int i3;
            String str2;
            int a = C2551a.m8095a(parcel);
            String str3;
            switch (C2551a.m8094a(a)) {
                case 1:
                    str3 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = C2551a.m8105d(parcel, a);
                    str2 = str3;
                    break;
                case 2:
                    i = i2;
                    PendingIntent pendingIntent3 = pendingIntent;
                    i3 = C2551a.m8105d(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent3;
                    break;
                case 3:
                    i3 = i;
                    i = i2;
                    str3 = str;
                    pendingIntent2 = (PendingIntent) C2551a.m8097a(parcel, a, PendingIntent.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = C2551a.m8115n(parcel, a);
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            pendingIntent = pendingIntent2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionResult(i2, i, pendingIntent, str);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public ConnectionResult[] m7880a(int i) {
        return new ConnectionResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7879a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7880a(i);
    }
}
