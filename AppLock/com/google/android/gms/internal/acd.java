package com.google.android.gms.internal;

import com.google.android.gms.common.api.C2456a;
import com.google.android.gms.common.api.C2456a.C2416a;
import com.google.android.gms.common.internal.C2512b;

public final class acd<O extends C2416a> {
    private final boolean f7884a = true;
    private final int f7885b;
    private final C2456a<O> f7886c;
    private final O f7887d;

    private acd(C2456a<O> c2456a) {
        this.f7886c = c2456a;
        this.f7887d = null;
        this.f7885b = System.identityHashCode(this);
    }

    private acd(C2456a<O> c2456a, O o) {
        this.f7886c = c2456a;
        this.f7887d = o;
        this.f7885b = C2512b.m7929a(this.f7886c, this.f7887d);
    }

    public static <O extends C2416a> acd<O> m8949a(C2456a<O> c2456a) {
        return new acd(c2456a);
    }

    public static <O extends C2416a> acd<O> m8950a(C2456a<O> c2456a, O o) {
        return new acd(c2456a, o);
    }

    public String m8951a() {
        return this.f7886c.m7752d();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof acd)) {
            return false;
        }
        acd com_google_android_gms_internal_acd = (acd) obj;
        return !this.f7884a && !com_google_android_gms_internal_acd.f7884a && C2512b.m7931a(this.f7886c, com_google_android_gms_internal_acd.f7886c) && C2512b.m7931a(this.f7887d, com_google_android_gms_internal_acd.f7887d);
    }

    public int hashCode() {
        return this.f7885b;
    }
}
