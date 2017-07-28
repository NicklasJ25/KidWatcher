package com.google.android.gms.internal;

import java.io.IOException;

public abstract class mb {
    protected volatile int ah = -1;

    public static final <T extends mb> T m9122a(T t, byte[] bArr) {
        return m9125b(t, bArr, 0, bArr.length);
    }

    public static final void m9123a(mb mbVar, byte[] bArr, int i, int i2) {
        try {
            lu a = lu.m12366a(bArr, i, i2);
            mbVar.mo3506a(a);
            a.m12409b();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final byte[] m9124a(mb mbVar) {
        byte[] bArr = new byte[mbVar.m9131g()];
        m9123a(mbVar, bArr, 0, bArr.length);
        return bArr;
    }

    public static final <T extends mb> T m9125b(T t, byte[] bArr, int i, int i2) {
        try {
            lt a = lt.m12333a(bArr, i, i2);
            t.mo3509b(a);
            a.m12336a(0);
            return t;
        } catch (ma e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    protected int mo3505a() {
        return 0;
    }

    public void mo3506a(lu luVar) {
    }

    public abstract mb mo3509b(lt ltVar);

    public /* synthetic */ Object clone() {
        return mo3508e();
    }

    public mb mo3508e() {
        return (mb) super.clone();
    }

    public int m9130f() {
        if (this.ah < 0) {
            m9131g();
        }
        return this.ah;
    }

    public int m9131g() {
        int a = mo3505a();
        this.ah = a;
        return a;
    }

    public String toString() {
        return mc.m12496a(this);
    }
}
