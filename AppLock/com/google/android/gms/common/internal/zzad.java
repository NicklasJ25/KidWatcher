package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzad extends zza {
    public static final Creator<zzad> CREATOR = new C2514d();
    final int f7494a;
    private final Account f7495b;
    private final int f7496c;
    private final GoogleSignInAccount f7497d;

    zzad(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f7494a = i;
        this.f7495b = account;
        this.f7496c = i2;
        this.f7497d = googleSignInAccount;
    }

    public zzad(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public Account m8187a() {
        return this.f7495b;
    }

    public int m8188b() {
        return this.f7496c;
    }

    @Nullable
    public GoogleSignInAccount m8189c() {
        return this.f7497d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2514d.m7945a(this, parcel, i);
    }
}
