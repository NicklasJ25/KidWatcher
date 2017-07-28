package com.domobile.cropimage;

import android.net.Uri;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class C1198j implements C1175g {
    private final C1175g[] f2356a;
    private final PriorityQueue<C1197c> f2357b;
    private long[] f2358c;
    private int f2359d;
    private int[] f2360e;
    private int f2361f;

    private static class C1195a implements Comparator<C1197c> {
        private C1195a() {
        }

        public int m2786a(C1197c c1197c, C1197c c1197c2) {
            return c1197c.f2352b != c1197c2.f2352b ? c1197c.f2352b < c1197c2.f2352b ? -1 : 1 : c1197c.f2351a - c1197c2.f2351a;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m2786a((C1197c) obj, (C1197c) obj2);
        }
    }

    private static class C1196b implements Comparator<C1197c> {
        private C1196b() {
        }

        public int m2787a(C1197c c1197c, C1197c c1197c2) {
            return c1197c.f2352b != c1197c2.f2352b ? c1197c.f2352b < c1197c2.f2352b ? 1 : -1 : c1197c.f2351a - c1197c2.f2351a;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m2787a((C1197c) obj, (C1197c) obj2);
        }
    }

    private static class C1197c {
        int f2351a;
        long f2352b;
        C1177f f2353c;
        private int f2354d = -1;
        private final C1175g f2355e;

        public C1197c(C1175g c1175g, int i) {
            this.f2355e = c1175g;
            this.f2351a = i;
        }

        public boolean m2788a() {
            if (this.f2354d >= this.f2355e.mo2508b() - 1) {
                return false;
            }
            C1175g c1175g = this.f2355e;
            int i = this.f2354d + 1;
            this.f2354d = i;
            this.f2353c = c1175g.mo2505a(i);
            this.f2352b = this.f2353c.mo2509a();
            return true;
        }
    }

    public C1198j(C1175g[] c1175gArr, int i) {
        this.f2356a = (C1175g[]) c1175gArr.clone();
        this.f2357b = new PriorityQueue(4, i == 1 ? new C1195a() : new C1196b());
        this.f2358c = new long[16];
        this.f2359d = 0;
        this.f2360e = new int[this.f2356a.length];
        this.f2361f = -1;
        this.f2357b.clear();
        int length = this.f2356a.length;
        for (int i2 = 0; i2 < length; i2++) {
            C1197c c1197c = new C1197c(this.f2356a[i2], i2);
            if (c1197c.m2788a()) {
                this.f2357b.add(c1197c);
            }
        }
    }

    private C1197c m2789c() {
        C1197c c1197c = (C1197c) this.f2357b.poll();
        if (c1197c == null) {
            return null;
        }
        if (c1197c.f2351a == this.f2361f) {
            int i = this.f2359d - 1;
            long[] jArr = this.f2358c;
            jArr[i] = jArr[i] + 1;
            return c1197c;
        }
        this.f2361f = c1197c.f2351a;
        if (this.f2358c.length == this.f2359d) {
            Object obj = new long[(this.f2359d * 2)];
            System.arraycopy(this.f2358c, 0, obj, 0, this.f2359d);
            this.f2358c = obj;
        }
        long[] jArr2 = this.f2358c;
        int i2 = this.f2359d;
        this.f2359d = i2 + 1;
        jArr2[i2] = (((long) this.f2361f) << 32) | 1;
        return c1197c;
    }

    public C1177f mo2505a(int i) {
        int i2 = 0;
        if (i < 0 || i > mo2508b()) {
            throw new IndexOutOfBoundsException("index " + i + " out of range max is " + mo2508b());
        }
        C1197c c;
        Arrays.fill(this.f2360e, 0);
        int i3 = this.f2359d;
        int i4 = 0;
        while (i4 < i3) {
            long j = this.f2358c[i4];
            int i5 = (int) (-1 & j);
            int i6 = (int) (j >> 32);
            if (i2 + i5 > i) {
                return this.f2356a[i6].mo2505a((i - i2) + this.f2360e[i6]);
            }
            int i7 = i2 + i5;
            int[] iArr = this.f2360e;
            iArr[i6] = iArr[i6] + i5;
            i4++;
            i2 = i7;
        }
        while (true) {
            c = m2789c();
            if (c == null) {
                return null;
            }
            if (i2 == i) {
                break;
            }
            if (c.m2788a()) {
                this.f2357b.add(c);
            }
            i2++;
        }
        C1177f c1177f = c.f2353c;
        if (!c.m2788a()) {
            return c1177f;
        }
        this.f2357b.add(c);
        return c1177f;
    }

    public C1177f mo2506a(Uri uri) {
        for (C1175g a : this.f2356a) {
            C1177f a2 = a.mo2506a(uri);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    public void mo2507a() {
        for (C1175g a : this.f2356a) {
            a.mo2507a();
        }
    }

    public int mo2508b() {
        int i = 0;
        C1175g[] c1175gArr = this.f2356a;
        int i2 = 0;
        while (i < c1175gArr.length) {
            i2 += c1175gArr[i].mo2508b();
            i++;
        }
        return i2;
    }
}
