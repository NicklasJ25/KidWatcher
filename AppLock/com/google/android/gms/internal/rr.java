package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.internal.rf.C3153a;
import com.google.android.gms.internal.rg.C3211a;
import com.google.android.gms.p065a.C2312b;
import com.google.android.gms.p065a.C2314c;
import com.google.android.gms.p065a.C2314c.C2313a;

@wh
public class rr extends C2314c<rg> {
    public rr() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    public rf m13655a(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        Throwable e;
        try {
            return C3153a.m13165a(((rg) m7329a(context)).mo3978a(C2312b.m7327a((Object) context), C2312b.m7327a((Object) frameLayout), C2312b.m7327a((Object) frameLayout2), 10260000));
        } catch (RemoteException e2) {
            e = e2;
            aad.m8424c("Could not create remote NativeAdViewDelegate.", e);
            return null;
        } catch (C2313a e3) {
            e = e3;
            aad.m8424c("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    protected /* synthetic */ Object mo3832a(IBinder iBinder) {
        return m13657b(iBinder);
    }

    protected rg m13657b(IBinder iBinder) {
        return C3211a.m13603a(iBinder);
    }
}
