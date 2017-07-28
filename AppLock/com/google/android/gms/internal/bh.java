package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

public class bh implements Executor {
    private final Handler f7970a;

    public bh(Looper looper) {
        this.f7970a = new Handler(looper);
    }

    public void execute(@NonNull Runnable runnable) {
        this.f7970a.post(runnable);
    }
}
