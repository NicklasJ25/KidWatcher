package com.google.android.gms.internal;

public class ip {
    public final long f9432a;
    public final je f9433b;
    public final long f9434c;
    public final boolean f9435d;
    public final boolean f9436e;

    public ip(long j, je jeVar, long j2, boolean z, boolean z2) {
        this.f9432a = j;
        if (!jeVar.m11873e() || jeVar.m11872d()) {
            this.f9433b = jeVar;
            this.f9434c = j2;
            this.f9435d = z;
            this.f9436e = z2;
            return;
        }
        throw new IllegalArgumentException("Can't create TrackedQuery for a non-default query that loads all data");
    }

    public ip m11736a() {
        return new ip(this.f9432a, this.f9433b, this.f9434c, true, this.f9436e);
    }

    public ip m11737a(long j) {
        return new ip(this.f9432a, this.f9433b, j, this.f9435d, this.f9436e);
    }

    public ip m11738a(boolean z) {
        return new ip(this.f9432a, this.f9433b, this.f9434c, this.f9435d, z);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        ip ipVar = (ip) obj;
        return this.f9432a == ipVar.f9432a && this.f9433b.equals(ipVar.f9433b) && this.f9434c == ipVar.f9434c && this.f9435d == ipVar.f9435d && this.f9436e == ipVar.f9436e;
    }

    public int hashCode() {
        return (((((((Long.valueOf(this.f9432a).hashCode() * 31) + this.f9433b.hashCode()) * 31) + Long.valueOf(this.f9434c).hashCode()) * 31) + Boolean.valueOf(this.f9435d).hashCode()) * 31) + Boolean.valueOf(this.f9436e).hashCode();
    }

    public String toString() {
        long j = this.f9432a;
        String valueOf = String.valueOf(this.f9433b);
        long j2 = this.f9434c;
        boolean z = this.f9435d;
        return new StringBuilder(String.valueOf(valueOf).length() + 109).append("TrackedQuery{id=").append(j).append(", querySpec=").append(valueOf).append(", lastUse=").append(j2).append(", complete=").append(z).append(", active=").append(this.f9436e).append("}").toString();
    }
}
