package com.google.android.gms.internal;

public class ig {
    public static final ig f9410a = new ig(C2980a.User, null, false);
    public static final ig f9411b = new ig(C2980a.Server, null, false);
    static final /* synthetic */ boolean f9412c = (!ig.class.desiredAssertionStatus());
    private final C2980a f9413d;
    private final jd f9414e;
    private final boolean f9415f;

    private enum C2980a {
        User,
        Server
    }

    public ig(C2980a c2980a, jd jdVar, boolean z) {
        this.f9413d = c2980a;
        this.f9414e = jdVar;
        this.f9415f = z;
        if (!f9412c && z && !m11659b()) {
            throw new AssertionError();
        }
    }

    public static ig m11657a(jd jdVar) {
        return new ig(C2980a.Server, jdVar, true);
    }

    public boolean m11658a() {
        return this.f9413d == C2980a.User;
    }

    public boolean m11659b() {
        return this.f9413d == C2980a.Server;
    }

    public boolean m11660c() {
        return this.f9415f;
    }

    public jd m11661d() {
        return this.f9414e;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9413d);
        String valueOf2 = String.valueOf(this.f9414e);
        return new StringBuilder((String.valueOf(valueOf).length() + 52) + String.valueOf(valueOf2).length()).append("OperationSource{source=").append(valueOf).append(", queryParams=").append(valueOf2).append(", tagged=").append(this.f9415f).append("}").toString();
    }
}
