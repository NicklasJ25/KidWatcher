package com.google.android.exoplayer2.p043j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class C2269o {
    private static final Comparator<C2268a> f6465a = new C22661();
    private static final Comparator<C2268a> f6466b = new C22672();
    private final int f6467c;
    private final ArrayList<C2268a> f6468d = new ArrayList();
    private final C2268a[] f6469e = new C2268a[5];
    private int f6470f = -1;
    private int f6471g;
    private int f6472h;
    private int f6473i;

    static class C22661 implements Comparator<C2268a> {
        C22661() {
        }

        public int m7109a(C2268a c2268a, C2268a c2268a2) {
            return c2268a.f6462a - c2268a2.f6462a;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m7109a((C2268a) obj, (C2268a) obj2);
        }
    }

    static class C22672 implements Comparator<C2268a> {
        C22672() {
        }

        public int m7110a(C2268a c2268a, C2268a c2268a2) {
            return c2268a.f6464c < c2268a2.f6464c ? -1 : c2268a2.f6464c < c2268a.f6464c ? 1 : 0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m7110a((C2268a) obj, (C2268a) obj2);
        }
    }

    private static class C2268a {
        public int f6462a;
        public int f6463b;
        public float f6464c;

        private C2268a() {
        }
    }

    public C2269o(int i) {
        this.f6467c = i;
    }

    private void m7111a() {
        if (this.f6470f != 1) {
            Collections.sort(this.f6468d, f6465a);
            this.f6470f = 1;
        }
    }

    private void m7112b() {
        if (this.f6470f != 0) {
            Collections.sort(this.f6468d, f6466b);
            this.f6470f = 0;
        }
    }

    public float m7113a(float f) {
        m7112b();
        float f2 = f * ((float) this.f6472h);
        int i = 0;
        for (int i2 = 0; i2 < this.f6468d.size(); i2++) {
            C2268a c2268a = (C2268a) this.f6468d.get(i2);
            i += c2268a.f6463b;
            if (((float) i) >= f2) {
                return c2268a.f6464c;
            }
        }
        return this.f6468d.isEmpty() ? Float.NaN : ((C2268a) this.f6468d.get(this.f6468d.size() - 1)).f6464c;
    }

    public void m7114a(int i, float f) {
        int i2;
        C2268a c2268a;
        m7111a();
        if (this.f6473i > 0) {
            C2268a[] c2268aArr = this.f6469e;
            i2 = this.f6473i - 1;
            this.f6473i = i2;
            c2268a = c2268aArr[i2];
        } else {
            c2268a = new C2268a();
        }
        i2 = this.f6471g;
        this.f6471g = i2 + 1;
        c2268a.f6462a = i2;
        c2268a.f6463b = i;
        c2268a.f6464c = f;
        this.f6468d.add(c2268a);
        this.f6472h += i;
        while (this.f6472h > this.f6467c) {
            i2 = this.f6472h - this.f6467c;
            c2268a = (C2268a) this.f6468d.get(0);
            if (c2268a.f6463b <= i2) {
                this.f6472h -= c2268a.f6463b;
                this.f6468d.remove(0);
                if (this.f6473i < 5) {
                    C2268a[] c2268aArr2 = this.f6469e;
                    int i3 = this.f6473i;
                    this.f6473i = i3 + 1;
                    c2268aArr2[i3] = c2268a;
                }
            } else {
                c2268a.f6463b -= i2;
                this.f6472h -= i2;
            }
        }
    }
}
