package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import java.util.List;

public class C2420a implements Creator<GoogleSignInAccount> {
    static void m7649a(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, googleSignInAccount.f7185b);
        C2552b.m8142a(parcel, 2, googleSignInAccount.m7622a(), false);
        C2552b.m8142a(parcel, 3, googleSignInAccount.m7624b(), false);
        C2552b.m8142a(parcel, 4, googleSignInAccount.m7625c(), false);
        C2552b.m8142a(parcel, 5, googleSignInAccount.m7626d(), false);
        C2552b.m8137a(parcel, 6, googleSignInAccount.m7629g(), i, false);
        C2552b.m8142a(parcel, 7, googleSignInAccount.m7630h(), false);
        C2552b.m8133a(parcel, 8, googleSignInAccount.m7631i());
        C2552b.m8142a(parcel, 9, googleSignInAccount.m7632j(), false);
        C2552b.m8153b(parcel, 10, googleSignInAccount.f7186c, false);
        C2552b.m8142a(parcel, 11, googleSignInAccount.m7627e(), false);
        C2552b.m8142a(parcel, 12, googleSignInAccount.m7628f(), false);
        C2552b.m8129a(parcel, a);
    }

    public GoogleSignInAccount m7650a(Parcel parcel) {
        int b = C2551a.m8100b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        long j = 0;
        String str6 = null;
        List list = null;
        String str7 = null;
        String str8 = null;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 3:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 4:
                    str3 = C2551a.m8115n(parcel, a);
                    break;
                case 5:
                    str4 = C2551a.m8115n(parcel, a);
                    break;
                case 6:
                    uri = (Uri) C2551a.m8097a(parcel, a, Uri.CREATOR);
                    break;
                case 7:
                    str5 = C2551a.m8115n(parcel, a);
                    break;
                case 8:
                    j = C2551a.m8107f(parcel, a);
                    break;
                case 9:
                    str6 = C2551a.m8115n(parcel, a);
                    break;
                case 10:
                    list = C2551a.m8103c(parcel, a, Scope.CREATOR);
                    break;
                case 11:
                    str7 = C2551a.m8115n(parcel, a);
                    break;
                case 12:
                    str8 = C2551a.m8115n(parcel, a);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, list, str7, str8);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public GoogleSignInAccount[] m7651a(int i) {
        return new GoogleSignInAccount[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7650a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7651a(i);
    }
}
