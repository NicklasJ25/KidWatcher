package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.internal.or.C2385a;
import com.google.android.gms.internal.os.C3130a;
import com.google.android.gms.p065a.C2312b;
import com.google.android.gms.p065a.C2314c;

@wh
public final class oc extends C2314c<os> {
    public oc() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public or m12893a(Context context, String str, ub ubVar) {
        try {
            return C2385a.zzo(((os) m7329a(context)).mo3865a(C2312b.m7327a((Object) context), str, ubVar, 10260000));
        } catch (Throwable e) {
            aad.m8424c("Could not create remote builder for AdLoader.", e);
            return null;
        } catch (Throwable e2) {
            aad.m8424c("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object mo3832a(IBinder iBinder) {
        return m12895b(iBinder);
    }

    protected os m12895b(IBinder iBinder) {
        return C3130a.m12996a(iBinder);
    }
}
