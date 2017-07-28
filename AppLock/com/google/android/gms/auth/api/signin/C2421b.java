package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import java.util.ArrayList;

public class C2421b implements Creator<GoogleSignInOptions> {
    static void m7652a(GoogleSignInOptions googleSignInOptions, Parcel parcel, int i) {
        int a = C2552b.m8128a(parcel);
        C2552b.m8132a(parcel, 1, googleSignInOptions.f7206a);
        C2552b.m8153b(parcel, 2, googleSignInOptions.m7641a(), false);
        C2552b.m8137a(parcel, 3, googleSignInOptions.m7642b(), i, false);
        C2552b.m8144a(parcel, 4, googleSignInOptions.m7643c());
        C2552b.m8144a(parcel, 5, googleSignInOptions.m7644d());
        C2552b.m8144a(parcel, 6, googleSignInOptions.m7645e());
        C2552b.m8142a(parcel, 7, googleSignInOptions.m7646f(), false);
        C2552b.m8142a(parcel, 8, googleSignInOptions.m7647g(), false);
        C2552b.m8153b(parcel, 9, googleSignInOptions.m7648h(), false);
        C2552b.m8129a(parcel, a);
    }

    public GoogleSignInOptions m7653a(Parcel parcel) {
        boolean z = false;
        ArrayList arrayList = null;
        int b = C2551a.m8100b(parcel);
        String str = null;
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        ArrayList arrayList2 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C2551a.m8095a(parcel);
            switch (C2551a.m8094a(a)) {
                case 1:
                    i = C2551a.m8105d(parcel, a);
                    break;
                case 2:
                    arrayList2 = C2551a.m8103c(parcel, a, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) C2551a.m8097a(parcel, a, Account.CREATOR);
                    break;
                case 4:
                    z3 = C2551a.m8104c(parcel, a);
                    break;
                case 5:
                    z2 = C2551a.m8104c(parcel, a);
                    break;
                case 6:
                    z = C2551a.m8104c(parcel, a);
                    break;
                case 7:
                    str2 = C2551a.m8115n(parcel, a);
                    break;
                case 8:
                    str = C2551a.m8115n(parcel, a);
                    break;
                case 9:
                    arrayList = C2551a.m8103c(parcel, a, zzg.CREATOR);
                    break;
                default:
                    C2551a.m8101b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleSignInOptions(i, arrayList2, account, z3, z2, z, str2, str, arrayList);
        }
        throw new C2550a("Overread allowed size end=" + b, parcel);
    }

    public GoogleSignInOptions[] m7654a(int i) {
        return new GoogleSignInOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7653a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7654a(i);
    }
}
