package com.facebook.ads.internal.p030j.p032b.p033a;

import java.io.File;

public class C1644g extends C1642e {
    private final long f4050a;

    public C1644g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.f4050a = j;
    }

    public /* bridge */ /* synthetic */ void mo2766a(File file) {
        super.mo2766a(file);
    }

    protected boolean mo2768a(File file, long j, int i) {
        return j <= this.f4050a;
    }
}
