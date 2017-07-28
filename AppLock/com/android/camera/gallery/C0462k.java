package com.android.camera.gallery;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class C0462k implements C0382g {
    private final C0382g[] f238a;
    private final PriorityQueue<C0461c> f239b;
    private long[] f240c;
    private int f241d;
    private int[] f242e;
    private int f243f;

    private static class C0459a implements Comparator<C0461c> {
        private C0459a() {
        }

        public int m326a(C0461c c0461c, C0461c c0461c2) {
            return c0461c.f234b != c0461c2.f234b ? c0461c.f234b < c0461c2.f234b ? -1 : 1 : c0461c.f233a - c0461c2.f233a;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m326a((C0461c) obj, (C0461c) obj2);
        }
    }

    private static class C0460b implements Comparator<C0461c> {
        private C0460b() {
        }

        public int m327a(C0461c c0461c, C0461c c0461c2) {
            return c0461c.f234b != c0461c2.f234b ? c0461c.f234b < c0461c2.f234b ? 1 : -1 : c0461c.f233a - c0461c2.f233a;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m327a((C0461c) obj, (C0461c) obj2);
        }
    }

    private static class C0461c {
        int f233a;
        long f234b;
        C0450f f235c;
        private int f236d = -1;
        private final C0382g f237e;

        public C0461c(C0382g c0382g, int i) {
            this.f237e = c0382g;
            this.f233a = i;
        }

        public boolean m328a() {
            if (this.f236d >= this.f237e.mo2039c() - 1) {
                return false;
            }
            C0382g c0382g = this.f237e;
            int i = this.f236d + 1;
            this.f236d = i;
            this.f235c = c0382g.mo2036a(i);
            this.f234b = this.f235c.mo2084c();
            return true;
        }
    }

    public C0462k(C0382g[] c0382gArr, int i) {
        this.f238a = (C0382g[]) c0382gArr.clone();
        this.f239b = new PriorityQueue(4, i == 1 ? new C0459a() : new C0460b());
        this.f240c = new long[16];
        this.f241d = 0;
        this.f242e = new int[this.f238a.length];
        this.f243f = -1;
        this.f239b.clear();
        int length = this.f238a.length;
        for (int i2 = 0; i2 < length; i2++) {
            C0461c c0461c = new C0461c(this.f238a[i2], i2);
            if (c0461c.m328a()) {
                this.f239b.add(c0461c);
            }
        }
    }

    private C0461c m329d() {
        C0461c c0461c = (C0461c) this.f239b.poll();
        if (c0461c == null) {
            return null;
        }
        if (c0461c.f233a == this.f243f) {
            int i = this.f241d - 1;
            long[] jArr = this.f240c;
            jArr[i] = jArr[i] + 1;
            return c0461c;
        }
        this.f243f = c0461c.f233a;
        if (this.f240c.length == this.f241d) {
            Object obj = new long[(this.f241d * 2)];
            System.arraycopy(this.f240c, 0, obj, 0, this.f241d);
            this.f240c = obj;
        }
        long[] jArr2 = this.f240c;
        int i2 = this.f241d;
        this.f241d = i2 + 1;
        jArr2[i2] = (((long) this.f243f) << 32) | 1;
        return c0461c;
    }

    public C0450f mo2036a(int i) {
        int i2 = 0;
        if (i < 0 || i > mo2039c()) {
            throw new IndexOutOfBoundsException("index " + i + " out of range max is " + mo2039c());
        }
        C0461c d;
        Arrays.fill(this.f242e, 0);
        int i3 = this.f241d;
        int i4 = 0;
        while (i4 < i3) {
            long j = this.f240c[i4];
            int i5 = (int) (-1 & j);
            int i6 = (int) (j >> 32);
            if (i2 + i5 > i) {
                return this.f238a[i6].mo2036a((i - i2) + this.f242e[i6]);
            }
            int i7 = i2 + i5;
            int[] iArr = this.f242e;
            iArr[i6] = iArr[i6] + i5;
            i4++;
            i2 = i7;
        }
        while (true) {
            d = m329d();
            if (d == null) {
                return null;
            }
            if (i2 == i) {
                break;
            }
            if (d.m328a()) {
                this.f239b.add(d);
            }
            i2++;
        }
        C0450f c0450f = d.f235c;
        if (!d.m328a()) {
            return c0450f;
        }
        this.f239b.add(d);
        return c0450f;
    }

    public void mo2037a() {
        for (C0382g a : this.f238a) {
            a.mo2037a();
        }
    }

    public HashMap<String, String> mo2038b() {
        HashMap<String, String> hashMap = new HashMap();
        for (C0382g b : this.f238a) {
            hashMap.putAll(b.mo2038b());
        }
        return hashMap;
    }

    public int mo2039c() {
        int i = 0;
        C0382g[] c0382gArr = this.f238a;
        int i2 = 0;
        while (i < c0382gArr.length) {
            i2 += c0382gArr[i].mo2039c();
            i++;
        }
        return i2;
    }
}
