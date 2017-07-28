package com.facebook.ads.internal;

import android.text.TextUtils;
import com.facebook.ads.C1460d;

public class C1555d {
    private final C1474a f3792a;
    private final String f3793b;

    public C1555d(int i, String str) {
        this(C1474a.m3817a(i), str);
    }

    public C1555d(C1474a c1474a, String str) {
        if (TextUtils.isEmpty(str)) {
            str = c1474a.m3821b();
        }
        this.f3792a = c1474a;
        this.f3793b = str;
    }

    public C1474a m4322a() {
        return this.f3792a;
    }

    public C1460d m4323b() {
        return this.f3792a.m3822c() ? new C1460d(this.f3792a.m3819a(), this.f3793b) : new C1460d(C1474a.UNKNOWN_ERROR.m3819a(), C1474a.UNKNOWN_ERROR.m3821b());
    }
}
