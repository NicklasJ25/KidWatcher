package com.google.android.gms.internal;

import java.util.Map;

public class je {
    private final hh f9506a;
    private final jd f9507b;

    public je(hh hhVar, jd jdVar) {
        this.f9506a = hhVar;
        this.f9507b = jdVar;
    }

    public static je m11867a(hh hhVar) {
        return new je(hhVar, jd.f9496a);
    }

    public static je m11868a(hh hhVar, Map<String, Object> map) {
        return new je(hhVar, jd.m11850a((Map) map));
    }

    public hh m11869a() {
        return this.f9506a;
    }

    public jd m11870b() {
        return this.f9507b;
    }

    public jy m11871c() {
        return this.f9507b.m11860i();
    }

    public boolean m11872d() {
        return this.f9507b.m11864m();
    }

    public boolean m11873e() {
        return this.f9507b.m11863l();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        je jeVar = (je) obj;
        return !this.f9506a.equals(jeVar.f9506a) ? false : this.f9507b.equals(jeVar.f9507b);
    }

    public int hashCode() {
        return (this.f9506a.hashCode() * 31) + this.f9507b.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9506a);
        String valueOf2 = String.valueOf(this.f9507b);
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append(":").append(valueOf2).toString();
    }
}
