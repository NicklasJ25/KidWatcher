package com.google.android.gms.internal;

public abstract class C2978if {
    protected final C2979a f9395b;
    protected final ig f9396c;
    protected final hh f9397d;

    public enum C2979a {
        Overwrite,
        Merge,
        AckUserWrite,
        ListenComplete
    }

    protected C2978if(C2979a c2979a, ig igVar, hh hhVar) {
        this.f9395b = c2979a;
        this.f9396c = igVar;
        this.f9397d = hhVar;
    }

    public abstract C2978if mo3735a(js jsVar);

    public hh m11648c() {
        return this.f9397d;
    }

    public ig m11649d() {
        return this.f9396c;
    }

    public C2979a m11650e() {
        return this.f9395b;
    }
}
