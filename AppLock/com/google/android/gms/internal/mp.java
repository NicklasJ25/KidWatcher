package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.C2480k;
import com.google.android.gms.internal.mq.C3058a;
import com.google.android.gms.internal.mr.C3061a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import com.google.android.gms.p065a.C2314c;
import com.google.android.gms.p065a.C2314c.C2313a;

public final class mp extends C2314c<mr> {
    private static final mp f9849a = new mp();

    private mp() {
        super("com.google.android.gms.ads.adshield.AdShieldCreatorImpl");
    }

    public static mq m12594a(String str, Context context, boolean z) {
        if (C2480k.m7807b().mo3314a(context) == 0) {
            mq b = f9849a.m12595b(str, context, z);
            if (b != null) {
                return b;
            }
        }
        return new mo(str, context, z);
    }

    private mq m12595b(String str, Context context, boolean z) {
        IBinder a;
        C2309a a2 = C2312b.m7327a((Object) context);
        if (z) {
            try {
                a = ((mr) m7329a(context)).mo3833a(str, a2);
            } catch (RemoteException e) {
                return null;
            } catch (C2313a e2) {
                return null;
            }
        }
        a = ((mr) m7329a(context)).mo3834b(str, a2);
        return C3058a.m12580a(a);
    }

    protected /* synthetic */ Object mo3832a(IBinder iBinder) {
        return m12597b(iBinder);
    }

    protected mr m12597b(IBinder iBinder) {
        return C3061a.m12614a(iBinder);
    }
}
