package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.C2517l;
import com.google.android.gms.common.internal.C2517l.C2527b;
import com.google.android.gms.common.internal.C2517l.C2528c;
import com.google.android.gms.internal.nw.C3109a;

@wh
public class nt extends C2517l<nw> {
    nt(Context context, Looper looper, C2527b c2527b, C2528c c2528c) {
        super(context, looper, 123, c2527b, c2528c, null);
    }

    protected /* synthetic */ IInterface mo3335a(IBinder iBinder) {
        return m12855b(iBinder);
    }

    protected nw m12855b(IBinder iBinder) {
        return C3109a.m12865a(iBinder);
    }

    protected String mo3336i() {
        return "com.google.android.gms.ads.service.CACHE";
    }

    protected String mo3337j() {
        return "com.google.android.gms.ads.internal.cache.ICacheService";
    }

    public nw mo3338k() {
        return (nw) super.m7995v();
    }
}
