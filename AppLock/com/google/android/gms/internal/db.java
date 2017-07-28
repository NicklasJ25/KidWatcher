package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.C2517l;
import com.google.android.gms.common.internal.C2517l.C2527b;
import com.google.android.gms.common.internal.C2517l.C2528c;
import com.google.android.gms.internal.cy.C2755a;

public class db extends C2517l<cy> {
    public db(Context context, Looper looper, C2527b c2527b, C2528c c2528c) {
        super(context, looper, 93, c2527b, c2528c, null);
    }

    public /* synthetic */ IInterface mo3335a(IBinder iBinder) {
        return m9771b(iBinder);
    }

    public cy m9771b(IBinder iBinder) {
        return C2755a.m9700a(iBinder);
    }

    @NonNull
    protected String mo3336i() {
        return "com.google.android.gms.measurement.START";
    }

    @NonNull
    protected String mo3337j() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}
