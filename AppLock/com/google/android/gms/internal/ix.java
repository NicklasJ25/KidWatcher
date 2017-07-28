package com.google.android.gms.internal;

import com.google.android.gms.internal.iz.C2995a;

public class ix {
    private final C2995a f9468a;
    private final jz f9469b;
    private final jz f9470c;
    private final js f9471d;
    private final js f9472e;

    private ix(C2995a c2995a, jz jzVar, js jsVar, js jsVar2, jz jzVar2) {
        this.f9468a = c2995a;
        this.f9469b = jzVar;
        this.f9471d = jsVar;
        this.f9472e = jsVar2;
        this.f9470c = jzVar2;
    }

    public static ix m11824a(js jsVar, jz jzVar) {
        return new ix(C2995a.CHILD_ADDED, jzVar, jsVar, null, null);
    }

    public static ix m11825a(js jsVar, jz jzVar, jz jzVar2) {
        return new ix(C2995a.CHILD_CHANGED, jzVar, jsVar, null, jzVar2);
    }

    public static ix m11826a(js jsVar, kf kfVar) {
        return m11824a(jsVar, jz.m12107a(kfVar));
    }

    public static ix m11827a(js jsVar, kf kfVar, kf kfVar2) {
        return m11825a(jsVar, jz.m12107a(kfVar), jz.m12107a(kfVar2));
    }

    public static ix m11828a(jz jzVar) {
        return new ix(C2995a.VALUE, jzVar, null, null, null);
    }

    public static ix m11829b(js jsVar, jz jzVar) {
        return new ix(C2995a.CHILD_REMOVED, jzVar, jsVar, null, null);
    }

    public static ix m11830b(js jsVar, kf kfVar) {
        return m11829b(jsVar, jz.m12107a(kfVar));
    }

    public static ix m11831c(js jsVar, jz jzVar) {
        return new ix(C2995a.CHILD_MOVED, jzVar, jsVar, null, null);
    }

    public ix m11832a(js jsVar) {
        return new ix(this.f9468a, this.f9469b, this.f9471d, jsVar, this.f9470c);
    }

    public js m11833a() {
        return this.f9471d;
    }

    public C2995a m11834b() {
        return this.f9468a;
    }

    public jz m11835c() {
        return this.f9469b;
    }

    public jz m11836d() {
        return this.f9470c;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9468a);
        String valueOf2 = String.valueOf(this.f9471d);
        return new StringBuilder((String.valueOf(valueOf).length() + 9) + String.valueOf(valueOf2).length()).append("Change: ").append(valueOf).append(" ").append(valueOf2).toString();
    }
}
