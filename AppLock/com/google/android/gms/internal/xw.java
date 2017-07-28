package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.xs.C3155a;
import com.google.android.gms.internal.xt.C3445a;
import com.google.android.gms.p065a.C2312b;
import com.google.android.gms.p065a.C2314c;
import com.google.android.gms.p065a.C2314c.C2313a;

@wh
public class xw extends C2314c<xt> {
    public xw() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    public xs m14835a(Context context, ub ubVar) {
        Throwable e;
        try {
            return C3155a.m13182a(((xt) m7329a(context)).mo4203a(C2312b.m7327a((Object) context), ubVar, 10260000));
        } catch (RemoteException e2) {
            e = e2;
            aad.m8424c("Could not get remote RewardedVideoAd.", e);
            return null;
        } catch (C2313a e3) {
            e = e3;
            aad.m8424c("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    protected /* synthetic */ Object mo3832a(IBinder iBinder) {
        return m14837b(iBinder);
    }

    protected xt m14837b(IBinder iBinder) {
        return C3445a.m14827a(iBinder);
    }
}
