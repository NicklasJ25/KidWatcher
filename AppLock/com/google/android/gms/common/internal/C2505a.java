package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C2489m;
import com.google.android.gms.common.internal.C2503v.C2504a;

public class C2505a extends C2504a {
    int f7388a;

    public static Account m7911a(C2503v c2503v) {
        Account account = null;
        if (c2503v != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = c2503v.mo3326a();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public Account mo3326a() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.f7388a) {
            if (C2489m.m7860a(null, callingUid)) {
                this.f7388a = callingUid;
            } else {
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        Account account = null;
        return this == obj ? true : !(obj instanceof C2505a) ? false : account.equals(account);
    }
}
