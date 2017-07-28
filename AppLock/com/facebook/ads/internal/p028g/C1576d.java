package com.facebook.ads.internal.p028g;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class C1576d {
    private List<C1572a> f3879a = new ArrayList();
    private int f3880b = 0;
    private C1577e f3881c;
    @Nullable
    private String f3882d;

    public C1576d(C1577e c1577e, @Nullable String str) {
        this.f3881c = c1577e;
        this.f3882d = str;
    }

    public C1577e m4383a() {
        return this.f3881c;
    }

    public void m4384a(C1572a c1572a) {
        this.f3879a.add(c1572a);
    }

    @Nullable
    public String m4385b() {
        return this.f3882d;
    }

    public C1572a m4386c() {
        if (this.f3880b >= this.f3879a.size()) {
            return null;
        }
        this.f3880b++;
        return (C1572a) this.f3879a.get(this.f3880b - 1);
    }
}
