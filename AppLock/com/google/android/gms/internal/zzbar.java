package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbar extends zza {
    public static final Creator<zzbar> CREATOR = new et();
    final int f11857a;
    private final Account f11858b;
    private final Scope[] f11859c;
    private final String f11860d;

    zzbar(int i, Account account, Scope[] scopeArr, String str) {
        this.f11857a = i;
        this.f11858b = account;
        this.f11859c = scopeArr;
        this.f11860d = str;
    }

    public Account m15367a() {
        return this.f11858b;
    }

    public Scope[] m15368b() {
        return this.f11859c;
    }

    public String m15369c() {
        return this.f11860d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        et.m10676a(this, parcel, i);
    }
}
