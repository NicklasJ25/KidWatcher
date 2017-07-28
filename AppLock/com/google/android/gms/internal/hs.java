package com.google.android.gms.internal;

public class hs {
    private final long f9362a;

    public hs(long j) {
        this.f9362a = j;
    }

    public long m11581a() {
        return this.f9362a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f9362a == ((hs) obj).f9362a;
    }

    public int hashCode() {
        return (int) (this.f9362a ^ (this.f9362a >>> 32));
    }

    public String toString() {
        return "Tag{tagNumber=" + this.f9362a + "}";
    }
}
