package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.internal.va.C2347a;
import com.google.android.gms.internal.vc.C3354a;
import com.google.android.gms.p065a.C2312b;
import com.google.android.gms.p065a.C2314c;

@wh
public final class uz extends C2314c<vc> {
    public uz() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public va m14323a(Activity activity) {
        try {
            return C2347a.zzT(((vc) m7329a((Context) activity)).mo4158a(C2312b.m7327a((Object) activity)));
        } catch (Throwable e) {
            aad.m8424c("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            aad.m8424c("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object mo3832a(IBinder iBinder) {
        return m14325b(iBinder);
    }

    protected vc m14325b(IBinder iBinder) {
        return C3354a.m14345a(iBinder);
    }
}
