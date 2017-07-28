package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;

public class ft implements he {
    private final Handler f8955a = new Handler(Looper.getMainLooper());

    public void mo3599a() {
    }

    public void mo3600a(Runnable runnable) {
        this.f8955a.post(runnable);
    }
}
