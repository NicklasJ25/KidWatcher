package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ly implements Cloneable {
    private lw<?, ?> f9744a;
    private Object f9745b;
    private List<md> f9746c = new ArrayList();

    ly() {
    }

    private byte[] m12441c() {
        byte[] bArr = new byte[m12442a()];
        m12443a(lu.m12365a(bArr));
        return bArr;
    }

    int m12442a() {
        if (this.f9745b != null) {
            return this.f9744a.m12424a(this.f9745b);
        }
        int i = 0;
        for (md a : this.f9746c) {
            i = a.m12502a() + i;
        }
        return i;
    }

    void m12443a(lu luVar) {
        if (this.f9745b != null) {
            this.f9744a.m12425a(this.f9745b, luVar);
            return;
        }
        for (md a : this.f9746c) {
            a.m12503a(luVar);
        }
    }

    void m12444a(md mdVar) {
        this.f9746c.add(mdVar);
    }

    public final ly m12445b() {
        ly lyVar = new ly();
        try {
            lyVar.f9744a = this.f9744a;
            if (this.f9746c == null) {
                lyVar.f9746c = null;
            } else {
                lyVar.f9746c.addAll(this.f9746c);
            }
            if (this.f9745b != null) {
                if (this.f9745b instanceof mb) {
                    lyVar.f9745b = (mb) ((mb) this.f9745b).clone();
                } else if (this.f9745b instanceof byte[]) {
                    lyVar.f9745b = ((byte[]) this.f9745b).clone();
                } else if (this.f9745b instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.f9745b;
                    r4 = new byte[bArr.length][];
                    lyVar.f9745b = r4;
                    for (r2 = 0; r2 < bArr.length; r2++) {
                        r4[r2] = (byte[]) bArr[r2].clone();
                    }
                } else if (this.f9745b instanceof boolean[]) {
                    lyVar.f9745b = ((boolean[]) this.f9745b).clone();
                } else if (this.f9745b instanceof int[]) {
                    lyVar.f9745b = ((int[]) this.f9745b).clone();
                } else if (this.f9745b instanceof long[]) {
                    lyVar.f9745b = ((long[]) this.f9745b).clone();
                } else if (this.f9745b instanceof float[]) {
                    lyVar.f9745b = ((float[]) this.f9745b).clone();
                } else if (this.f9745b instanceof double[]) {
                    lyVar.f9745b = ((double[]) this.f9745b).clone();
                } else if (this.f9745b instanceof mb[]) {
                    mb[] mbVarArr = (mb[]) this.f9745b;
                    r4 = new mb[mbVarArr.length];
                    lyVar.f9745b = r4;
                    for (r2 = 0; r2 < mbVarArr.length; r2++) {
                        r4[r2] = (mb) mbVarArr[r2].clone();
                    }
                }
            }
            return lyVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public /* synthetic */ Object clone() {
        return m12445b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ly)) {
            return false;
        }
        ly lyVar = (ly) obj;
        if (this.f9745b != null && lyVar.f9745b != null) {
            return this.f9744a == lyVar.f9744a ? !this.f9744a.f9736b.isArray() ? this.f9745b.equals(lyVar.f9745b) : this.f9745b instanceof byte[] ? Arrays.equals((byte[]) this.f9745b, (byte[]) lyVar.f9745b) : this.f9745b instanceof int[] ? Arrays.equals((int[]) this.f9745b, (int[]) lyVar.f9745b) : this.f9745b instanceof long[] ? Arrays.equals((long[]) this.f9745b, (long[]) lyVar.f9745b) : this.f9745b instanceof float[] ? Arrays.equals((float[]) this.f9745b, (float[]) lyVar.f9745b) : this.f9745b instanceof double[] ? Arrays.equals((double[]) this.f9745b, (double[]) lyVar.f9745b) : this.f9745b instanceof boolean[] ? Arrays.equals((boolean[]) this.f9745b, (boolean[]) lyVar.f9745b) : Arrays.deepEquals((Object[]) this.f9745b, (Object[]) lyVar.f9745b) : false;
        } else {
            if (this.f9746c != null && lyVar.f9746c != null) {
                return this.f9746c.equals(lyVar.f9746c);
            }
            try {
                return Arrays.equals(m12441c(), lyVar.m12441c());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(m12441c()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
