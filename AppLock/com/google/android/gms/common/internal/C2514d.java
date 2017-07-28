package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class C2514d implements Creator<zzad> {
    static void m7945a(zzad com_google_android_gms_common_internal_zzad, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_common_internal_zzad.f7494a);
        C2552b.m8137a(parcel, 2, com_google_android_gms_common_internal_zzad.m8187a(), i, false);
        C2552b.m8132a(parcel, 3, com_google_android_gms_common_internal_zzad.m8188b());
        C2552b.m8137a(parcel, 4, com_google_android_gms_common_internal_zzad.m8189c(), i, false);
        C2552b.m8129a(parcel, a);
    }

    public zzad m7946a(Parcel parcel) {
        GoogleSignInAccount googleSignInAccount = null;
        int i = 0;
        int b = C2551a.m8100b(parcel);
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int i3;
            Account account2;
            int d;
            GoogleSignInAccount googleSignInAccount2;
            int a = C2551a.m8095a(parcel);
            GoogleSignInAccount googleSignInAccount3;
            switch (C2551a.m8094a(a)) {
                case 1:
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    d = C2551a.m8105d(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case 2:
                    d = i2;
                    int i4 = i;
                    account2 = (Account) C2551a.m8097a(parcel, a, Account.CREATOR);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i4;
                    break;
                case 3:
                    account2 = account;
                    d = i2;
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = C2551a.m8105d(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case 4:
                    googleSignInAccount2 = (GoogleSignInAccount) C2551a.m8097a(parcel, a, GoogleSignInAccount.CREATOR);
                    i3 = i;
                    account2 = account;
                    d = i2;
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    d = i2;
                    break;
            }
            i2 = d;
            account = account2;
            i = i3;
            googleSignInAccount = googleSignInAccount2;
        }
        if (parcel.dataPosition() == b) {
            return new zzad(i2, account, i, googleSignInAccount);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzad[] m7947a(int i) {
        return new zzad[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7946a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7947a(i);
    }
}
