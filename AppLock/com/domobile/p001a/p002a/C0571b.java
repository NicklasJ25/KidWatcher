package com.domobile.p001a.p002a;

public class C0571b extends Exception {
    C0576d f348a;

    public C0571b(int i, String str) {
        this(new C0576d(i, str));
    }

    public C0571b(int i, String str, Exception exception) {
        this(new C0576d(i, str), exception);
    }

    public C0571b(C0576d c0576d) {
        this(c0576d, null);
    }

    public C0571b(C0576d c0576d, Exception exception) {
        super(c0576d.m524a(), exception);
        this.f348a = c0576d;
    }

    public C0576d m501a() {
        return this.f348a;
    }
}
