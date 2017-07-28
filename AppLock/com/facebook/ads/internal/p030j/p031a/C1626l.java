package com.facebook.ads.internal.p030j.p031a;

public abstract class C1626l {
    protected String f4029a = "";
    protected C1628j f4030b;
    protected String f4031c;
    protected byte[] f4032d;

    public C1626l(String str, C1633p c1633p) {
        if (str != null) {
            this.f4029a = str;
        }
        if (c1633p != null) {
            this.f4029a += "?" + c1633p.m4596a();
        }
    }

    public String m4580a() {
        return this.f4029a;
    }

    public C1628j m4581b() {
        return this.f4030b;
    }

    public String m4582c() {
        return this.f4031c;
    }

    public byte[] m4583d() {
        return this.f4032d;
    }
}
