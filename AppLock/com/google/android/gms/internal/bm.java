package com.google.android.gms.internal;

import android.content.Context;

public class bm {
    private static bm f7980b = new bm();
    private bl f7981a = null;

    public static bl m9120b(Context context) {
        return f7980b.m9121a(context);
    }

    public synchronized bl m9121a(Context context) {
        if (this.f7981a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f7981a = new bl(context);
        }
        return this.f7981a;
    }
}
