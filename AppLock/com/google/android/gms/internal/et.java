package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;

public class et implements Creator<zzbar> {
    static void m10676a(zzbar com_google_android_gms_internal_zzbar, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, com_google_android_gms_internal_zzbar.f11857a);
        C2552b.m8137a(parcel, 2, com_google_android_gms_internal_zzbar.m15367a(), i, false);
        C2552b.m8147a(parcel, 3, com_google_android_gms_internal_zzbar.m15368b(), i, false);
        C2552b.m8142a(parcel, 4, com_google_android_gms_internal_zzbar.m15369c(), false);
        C2552b.m8129a(parcel, a);
    }

    public zzbar m10677a(Parcel parcel) {
        String str = null;
        int b = C2551a.m8100b(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        Account account = null;
        while (parcel.dataPosition() < b) {
            Scope[] scopeArr2;
            Account account2;
            int d;
            String str2;
            int a = C2551a.m8095a(parcel);
            String str3;
            switch (C2551a.m8094a(a)) {
                case 1:
                    str3 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    d = C2551a.m8105d(parcel, a);
                    str2 = str3;
                    break;
                case 2:
                    d = i;
                    Scope[] scopeArr3 = scopeArr;
                    account2 = (Account) C2551a.m8097a(parcel, a, Account.CREATOR);
                    str2 = str;
                    scopeArr2 = scopeArr3;
                    break;
                case 3:
                    account2 = account;
                    d = i;
                    str3 = str;
                    scopeArr2 = (Scope[]) C2551a.m8102b(parcel, a, Scope.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = C2551a.m8115n(parcel, a);
                    scopeArr2 = scopeArr;
                    account2 = account;
                    d = i;
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    str2 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    d = i;
                    break;
            }
            i = d;
            account = account2;
            scopeArr = scopeArr2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new zzbar(i, account, scopeArr, str);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public zzbar[] m10678a(int i) {
        return new zzbar[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10677a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10678a(i);
    }
}
