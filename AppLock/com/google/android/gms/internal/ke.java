package com.google.android.gms.internal;

public class ke {
    private static final ke f9622c = new ke(js.m12004a(), jx.m12080j());
    private static final ke f9623d = new ke(js.m12006b(), kf.f9552d);
    private final js f9624a;
    private final kf f9625b;

    public ke(js jsVar, kf kfVar) {
        this.f9624a = jsVar;
        this.f9625b = kfVar;
    }

    public static ke m12167a() {
        return f9622c;
    }

    public static ke m12168b() {
        return f9623d;
    }

    public js m12169c() {
        return this.f9624a;
    }

    public kf m12170d() {
        return this.f9625b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ke keVar = (ke) obj;
        return !this.f9624a.equals(keVar.f9624a) ? false : this.f9625b.equals(keVar.f9625b);
    }

    public int hashCode() {
        return (this.f9624a.hashCode() * 31) + this.f9625b.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9624a);
        String valueOf2 = String.valueOf(this.f9625b);
        return new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(valueOf2).length()).append("NamedNode{name=").append(valueOf).append(", node=").append(valueOf2).append("}").toString();
    }
}
