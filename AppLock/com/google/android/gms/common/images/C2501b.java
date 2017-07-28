package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class C2501b implements Creator<WebImage> {
    static void m7904a(WebImage webImage, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, webImage.f7375a);
        C2552b.m8137a(parcel, 2, webImage.m7896a(), i, false);
        C2552b.m8132a(parcel, 3, webImage.m7897b());
        C2552b.m8132a(parcel, 4, webImage.m7898c());
        C2552b.m8129a(parcel, a);
    }

    public WebImage m7905a(Parcel parcel) {
        int i = 0;
        int b = C2551a.m8100b(parcel);
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            Uri uri2;
            int d;
            int a = C2551a.m8095a(parcel);
            int i4;
            switch (C2551a.m8094a(a)) {
                case 1:
                    i4 = i;
                    i = i2;
                    uri2 = uri;
                    d = C2551a.m8105d(parcel, a);
                    a = i4;
                    break;
                case 2:
                    d = i3;
                    i4 = i2;
                    uri2 = (Uri) C2551a.m8097a(parcel, a, Uri.CREATOR);
                    a = i;
                    i = i4;
                    break;
                case 3:
                    uri2 = uri;
                    d = i3;
                    i4 = i;
                    i = C2551a.m8105d(parcel, a);
                    a = i4;
                    break;
                case 4:
                    a = C2551a.m8105d(parcel, a);
                    i = i2;
                    uri2 = uri;
                    d = i3;
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    a = i;
                    i = i2;
                    uri2 = uri;
                    d = i3;
                    break;
            }
            i3 = d;
            uri = uri2;
            i2 = i;
            i = a;
        }
        if (parcel.dataPosition() == b) {
            return new WebImage(i3, uri, i2, i);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public WebImage[] m7906a(int i) {
        return new WebImage[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7905a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7906a(i);
    }
}
