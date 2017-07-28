package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import java.util.List;

public class C2575b implements Creator<WakeLockEvent> {
    static void m8259a(WakeLockEvent wakeLockEvent, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, wakeLockEvent.f7536a);
        C2552b.m8133a(parcel, 2, wakeLockEvent.mo3356a());
        C2552b.m8142a(parcel, 4, wakeLockEvent.m8241e(), false);
        C2552b.m8132a(parcel, 5, wakeLockEvent.m8244h());
        C2552b.m8143a(parcel, 6, wakeLockEvent.m8245i(), false);
        C2552b.m8133a(parcel, 8, wakeLockEvent.m8247k());
        C2552b.m8142a(parcel, 10, wakeLockEvent.m8242f(), false);
        C2552b.m8132a(parcel, 11, wakeLockEvent.mo3357b());
        C2552b.m8142a(parcel, 12, wakeLockEvent.m8246j(), false);
        C2552b.m8142a(parcel, 13, wakeLockEvent.m8249m(), false);
        C2552b.m8132a(parcel, 14, wakeLockEvent.m8248l());
        C2552b.m8131a(parcel, 15, wakeLockEvent.m8250n());
        C2552b.m8133a(parcel, 16, wakeLockEvent.m8251o());
        C2552b.m8142a(parcel, 17, wakeLockEvent.m8243g(), false);
        C2552b.m8129a(parcel, a);
    }

    public WakeLockEvent m8260a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        List list = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
        long j3 = 0;
        String str5 = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    j = C2551a.m8107f(parcel, a);
                    break;
                case 4:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 5:
                    i3 = C2551a.m8105d(parcel, a);
                    break;
                case 6:
                    list = C2551a.m8091A(parcel, a);
                    break;
                case 8:
                    j2 = C2551a.m8107f(parcel, a);
                    break;
                case 10:
                    str3 = C2551a.m8115n(parcel, a);
                    break;
                case 11:
                    i2 = C2551a.m8105d(parcel, a);
                    break;
                case 12:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 13:
                    str4 = C2551a.m8115n(parcel, a);
                    break;
                case 14:
                    i4 = C2551a.m8105d(parcel, a);
                    break;
                case 15:
                    f = C2551a.m8110i(parcel, a);
                    break;
                case 16:
                    j3 = C2551a.m8107f(parcel, a);
                    break;
                case 17:
                    str5 = C2551a.m8115n(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3, str5);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public WakeLockEvent[] m8261a(int i) {
        return new WakeLockEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8260a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m8261a(i);
    }
}
