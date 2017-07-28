package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.internal.vh.C2354a;
import com.google.android.gms.internal.vi.C3359a;
import com.google.android.gms.p065a.C2312b;
import com.google.android.gms.p065a.C2314c;

@wh
public final class vm extends C2314c<vi> {
    public vm() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    public vh m14358a(Activity activity) {
        try {
            return C2354a.zzY(((vi) m7329a((Context) activity)).mo4160a(C2312b.m7327a((Object) activity)));
        } catch (Throwable e) {
            aad.m8424c("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (Throwable e2) {
            aad.m8424c("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object mo3832a(IBinder iBinder) {
        return m14360b(iBinder);
    }

    protected vi m14360b(IBinder iBinder) {
        return C3359a.m14351a(iBinder);
    }
}
