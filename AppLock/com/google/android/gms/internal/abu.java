package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.C2461c.C2459b;
import com.google.android.gms.common.api.C2461c.C2460c;
import com.google.android.gms.common.internal.C2519q;
import com.google.android.gms.common.internal.C2539m;
import com.google.android.gms.internal.abx.C2680a;

public class abu extends C2519q<abx> {
    public abu(Context context, Looper looper, C2539m c2539m, C2459b c2459b, C2460c c2460c) {
        super(context, looper, 40, c2539m, c2459b, c2460c);
    }

    protected /* synthetic */ IInterface mo3335a(IBinder iBinder) {
        return m8885b(iBinder);
    }

    public void m8884a(abw com_google_android_gms_internal_abw, zzzm com_google_android_gms_internal_zzzm) {
        ((abx) m7995v()).mo3479a(com_google_android_gms_internal_abw, com_google_android_gms_internal_zzzm);
    }

    protected abx m8885b(IBinder iBinder) {
        return C2680a.m8912a(iBinder);
    }

    protected String mo3336i() {
        return "com.google.android.gms.clearcut.service.START";
    }

    protected String mo3337j() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }
}
