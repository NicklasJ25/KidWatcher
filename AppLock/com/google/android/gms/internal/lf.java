package com.google.android.gms.internal;

public class lf<T, U> {
    private final T f9699a;
    private final U f9700b;

    public lf(T t, U u) {
        this.f9699a = t;
        this.f9700b = u;
    }

    public T m12286a() {
        return this.f9699a;
    }

    public U m12287b() {
        return this.f9700b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        lf lfVar = (lf) obj;
        if (this.f9699a == null ? lfVar.f9699a != null : !this.f9699a.equals(lfVar.f9699a)) {
            return false;
        }
        if (this.f9700b != null) {
            if (this.f9700b.equals(lfVar.f9700b)) {
                return true;
            }
        } else if (lfVar.f9700b == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f9699a != null ? this.f9699a.hashCode() : 0) * 31;
        if (this.f9700b != null) {
            i = this.f9700b.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9699a);
        String valueOf2 = String.valueOf(this.f9700b);
        return new StringBuilder((String.valueOf(valueOf).length() + 7) + String.valueOf(valueOf2).length()).append("Pair(").append(valueOf).append(",").append(valueOf2).append(")").toString();
    }
}
