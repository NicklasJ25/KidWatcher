package com.google.android.gms.internal;

import android.os.Bundle;

@wh
public class tc {
    private static tc f10686a = new tc();
    private int f10687b;
    private int f10688c;
    private int f10689d;
    private int f10690e;
    private int f10691f;

    public static tc m13885a() {
        return f10686a;
    }

    void m13886a(int i) {
        this.f10687b += i;
    }

    void m13887b() {
        this.f10688c++;
    }

    void m13888c() {
        this.f10689d++;
    }

    void m13889d() {
        this.f10690e++;
    }

    void m13890e() {
        this.f10691f++;
    }

    public int m13891f() {
        return this.f10688c;
    }

    public int m13892g() {
        return this.f10689d;
    }

    public int m13893h() {
        return this.f10690e;
    }

    public Bundle m13894i() {
        Bundle bundle = new Bundle();
        bundle.putInt("ipl", this.f10687b);
        bundle.putInt("ipds", this.f10688c);
        bundle.putInt("ipde", this.f10689d);
        bundle.putInt("iph", this.f10690e);
        bundle.putInt("ipm", this.f10691f);
        return bundle;
    }
}
