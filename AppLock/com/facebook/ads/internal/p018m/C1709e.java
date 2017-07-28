package com.facebook.ads.internal.p018m;

import android.graphics.Bitmap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class C1709e {
    static final int f4282a = Runtime.getRuntime().availableProcessors();
    static final ExecutorService f4283b = Executors.newFixedThreadPool(f4282a);
    private static volatile boolean f4284c = true;
    private final Bitmap f4285d;
    private Bitmap f4286e;
    private final C1689v f4287f = new ag();

    public C1709e(Bitmap bitmap) {
        this.f4285d = bitmap;
    }

    public Bitmap m4915a() {
        return this.f4286e;
    }

    public Bitmap m4916a(int i) {
        this.f4286e = this.f4287f.mo2777a(this.f4285d, (float) i);
        return this.f4286e;
    }
}
