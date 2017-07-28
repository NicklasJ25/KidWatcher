package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.C2517l;
import com.google.android.gms.common.internal.C2517l.C2527b;
import com.google.android.gms.common.internal.C2517l.C2528c;
import com.google.android.gms.internal.ws.C3405a;

@wh
public class wm extends C2517l<ws> {
    final int f11194e;

    public wm(Context context, Looper looper, C2527b c2527b, C2528c c2528c, int i) {
        super(context, looper, 8, c2527b, c2528c, null);
        this.f11194e = i;
    }

    protected /* synthetic */ IInterface mo3335a(IBinder iBinder) {
        return m14530b(iBinder);
    }

    protected ws m14530b(IBinder iBinder) {
        return C3405a.m14553a(iBinder);
    }

    protected String mo3336i() {
        return "com.google.android.gms.ads.service.START";
    }

    protected String mo3337j() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public ws mo3338k() {
        return (ws) super.m7995v();
    }
}
