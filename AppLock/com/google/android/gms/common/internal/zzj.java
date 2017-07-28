package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.C2480k;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C2503v.C2504a;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.zzc;
import java.util.Collection;

public class zzj extends zza {
    public static final Creator<zzj> CREATOR = new C2544p();
    final int f7513a;
    final int f7514b;
    int f7515c;
    String f7516d;
    IBinder f7517e;
    Scope[] f7518f;
    Bundle f7519g;
    Account f7520h;
    zzc[] f7521i;

    public zzj(int i) {
        this.f7513a = 3;
        this.f7515c = C2480k.f7315b;
        this.f7514b = i;
    }

    zzj(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, zzc[] com_google_android_gms_common_zzcArr) {
        this.f7513a = i;
        this.f7514b = i2;
        this.f7515c = i3;
        if ("com.google.android.gms".equals(str)) {
            this.f7516d = "com.google.android.gms";
        } else {
            this.f7516d = str;
        }
        if (i < 2) {
            this.f7520h = m8197a(iBinder);
        } else {
            this.f7517e = iBinder;
            this.f7520h = account;
        }
        this.f7518f = scopeArr;
        this.f7519g = bundle;
        this.f7521i = com_google_android_gms_common_zzcArr;
    }

    private Account m8197a(IBinder iBinder) {
        return iBinder != null ? C2505a.m7911a(C2504a.m7910a(iBinder)) : null;
    }

    public zzj m8198a(Account account) {
        this.f7520h = account;
        return this;
    }

    public zzj m8199a(Bundle bundle) {
        this.f7519g = bundle;
        return this;
    }

    public zzj m8200a(C2503v c2503v) {
        if (c2503v != null) {
            this.f7517e = c2503v.asBinder();
        }
        return this;
    }

    public zzj m8201a(String str) {
        this.f7516d = str;
        return this;
    }

    public zzj m8202a(Collection<Scope> collection) {
        this.f7518f = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public zzj m8203a(zzc[] com_google_android_gms_common_zzcArr) {
        this.f7521i = com_google_android_gms_common_zzcArr;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2544p.m8069a(this, parcel, i);
    }
}
