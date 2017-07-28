package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.ot.C2359a;
import com.google.android.gms.internal.ou.C3133a;
import com.google.android.gms.p065a.C2312b;
import com.google.android.gms.p065a.C2314c;
import com.google.android.gms.p065a.C2314c.C2313a;

@wh
public class od extends C2314c<ou> {
    public od() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public ot m12896a(Context context, zzeg com_google_android_gms_internal_zzeg, String str, ub ubVar, int i) {
        Throwable e;
        try {
            return C2359a.zzq(((ou) m7329a(context)).mo3867a(C2312b.m7327a((Object) context), com_google_android_gms_internal_zzeg, str, ubVar, 10260000, i));
        } catch (RemoteException e2) {
            e = e2;
            aad.m8419a("Could not create remote AdManager.", e);
            return null;
        } catch (C2313a e3) {
            e = e3;
            aad.m8419a("Could not create remote AdManager.", e);
            return null;
        }
    }

    protected /* synthetic */ Object mo3832a(IBinder iBinder) {
        return m12898b(iBinder);
    }

    protected ou m12898b(IBinder iBinder) {
        return C3133a.m13001a(iBinder);
    }
}
