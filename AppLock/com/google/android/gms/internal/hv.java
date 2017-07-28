package com.google.android.gms.internal;

public class hv {
    private final long f9366a;
    private final hh f9367b;
    private final kf f9368c;
    private final gx f9369d;
    private final boolean f9370e;

    public hv(long j, hh hhVar, gx gxVar) {
        this.f9366a = j;
        this.f9367b = hhVar;
        this.f9368c = null;
        this.f9369d = gxVar;
        this.f9370e = true;
    }

    public hv(long j, hh hhVar, kf kfVar, boolean z) {
        this.f9366a = j;
        this.f9367b = hhVar;
        this.f9368c = kfVar;
        this.f9369d = null;
        this.f9370e = z;
    }

    public long m11587a() {
        return this.f9366a;
    }

    public hh m11588b() {
        return this.f9367b;
    }

    public kf m11589c() {
        if (this.f9368c != null) {
            return this.f9368c;
        }
        throw new IllegalArgumentException("Can't access overwrite when write is a merge!");
    }

    public gx m11590d() {
        if (this.f9369d != null) {
            return this.f9369d;
        }
        throw new IllegalArgumentException("Can't access merge when write is an overwrite!");
    }

    public boolean m11591e() {
        return this.f9368c != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        hv hvVar = (hv) obj;
        if (this.f9366a != hvVar.f9366a) {
            return false;
        }
        if (!this.f9367b.equals(hvVar.f9367b)) {
            return false;
        }
        if (this.f9370e != hvVar.f9370e) {
            return false;
        }
        if (!this.f9368c == null ? this.f9368c.equals(hvVar.f9368c) : hvVar.f9368c == null) {
            return false;
        }
        if (this.f9369d != null) {
            if (this.f9369d.equals(hvVar.f9369d)) {
                return true;
            }
        } else if (hvVar.f9369d == null) {
            return true;
        }
        return false;
    }

    public boolean m11592f() {
        return this.f9370e;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f9368c != null ? this.f9368c.hashCode() : 0) + (((((Long.valueOf(this.f9366a).hashCode() * 31) + Boolean.valueOf(this.f9370e).hashCode()) * 31) + this.f9367b.hashCode()) * 31)) * 31;
        if (this.f9369d != null) {
            i = this.f9369d.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        long j = this.f9366a;
        String valueOf = String.valueOf(this.f9367b);
        boolean z = this.f9370e;
        String valueOf2 = String.valueOf(this.f9368c);
        String valueOf3 = String.valueOf(this.f9369d);
        return new StringBuilder(((String.valueOf(valueOf).length() + 78) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append("UserWriteRecord{id=").append(j).append(" path=").append(valueOf).append(" visible=").append(z).append(" overwrite=").append(valueOf2).append(" merge=").append(valueOf3).append("}").toString();
    }
}
