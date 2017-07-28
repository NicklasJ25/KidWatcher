package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.C2517l;
import com.google.android.gms.common.internal.C2517l.C2527b;
import com.google.android.gms.common.internal.C2517l.C2528c;
import com.google.android.gms.internal.cg.C2745a;

public class cd extends C2517l<cg> {
    public cd(Context context, Looper looper, C2527b c2527b, C2528c c2528c) {
        super(context, looper, 116, c2527b, c2528c, null);
    }

    protected /* synthetic */ IInterface mo3335a(IBinder iBinder) {
        return m9291b(iBinder);
    }

    protected cg m9291b(IBinder iBinder) {
        return C2745a.m9303a(iBinder);
    }

    protected String mo3336i() {
        return "com.google.android.gms.gass.START";
    }

    protected String mo3337j() {
        return "com.google.android.gms.gass.internal.IGassService";
    }

    public cg mo3338k() {
        return (cg) super.m7995v();
    }
}
