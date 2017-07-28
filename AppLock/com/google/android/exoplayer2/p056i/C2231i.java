package com.google.android.exoplayer2.p056i;

import com.google.android.exoplayer2.p043j.C2252a;
import java.util.Arrays;

public final class C2231i implements C2220b {
    private final boolean f6340a;
    private final int f6341b;
    private final byte[] f6342c;
    private final C2219a[] f6343d;
    private int f6344e;
    private int f6345f;
    private int f6346g;
    private C2219a[] f6347h;

    public C2231i(boolean z, int i) {
        this(z, i, 0);
    }

    public C2231i(boolean z, int i, int i2) {
        int i3 = 0;
        C2252a.m7022a(i > 0);
        C2252a.m7022a(i2 >= 0);
        this.f6340a = z;
        this.f6341b = i;
        this.f6346g = i2;
        this.f6347h = new C2219a[(i2 + 100)];
        if (i2 > 0) {
            this.f6342c = new byte[(i2 * i)];
            while (i3 < i2) {
                this.f6347h[i3] = new C2219a(this.f6342c, i3 * i);
                i3++;
            }
        } else {
            this.f6342c = null;
        }
        this.f6343d = new C2219a[1];
    }

    public synchronized C2219a mo3097a() {
        C2219a c2219a;
        this.f6345f++;
        if (this.f6346g > 0) {
            C2219a[] c2219aArr = this.f6347h;
            int i = this.f6346g - 1;
            this.f6346g = i;
            c2219a = c2219aArr[i];
            this.f6347h[this.f6346g] = null;
        } else {
            c2219a = new C2219a(new byte[this.f6341b], 0);
        }
        return c2219a;
    }

    public synchronized void m6962a(int i) {
        Object obj = i < this.f6344e ? 1 : null;
        this.f6344e = i;
        if (obj != null) {
            mo3100b();
        }
    }

    public synchronized void mo3098a(C2219a c2219a) {
        this.f6343d[0] = c2219a;
        mo3099a(this.f6343d);
    }

    public synchronized void mo3099a(C2219a[] c2219aArr) {
        if (this.f6346g + c2219aArr.length >= this.f6347h.length) {
            this.f6347h = (C2219a[]) Arrays.copyOf(this.f6347h, Math.max(this.f6347h.length * 2, this.f6346g + c2219aArr.length));
        }
        for (C2219a c2219a : c2219aArr) {
            boolean z = c2219a.f6317a == this.f6342c || c2219a.f6317a.length == this.f6341b;
            C2252a.m7022a(z);
            C2219a[] c2219aArr2 = this.f6347h;
            int i = this.f6346g;
            this.f6346g = i + 1;
            c2219aArr2[i] = c2219a;
        }
        this.f6345f -= c2219aArr.length;
        notifyAll();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo3100b() {
        /*
        r7 = this;
        r1 = 0;
        monitor-enter(r7);
        r0 = r7.f6344e;	 Catch:{ all -> 0x005e }
        r2 = r7.f6341b;	 Catch:{ all -> 0x005e }
        r0 = com.google.android.exoplayer2.p043j.C2273r.m7125a(r0, r2);	 Catch:{ all -> 0x005e }
        r2 = 0;
        r3 = r7.f6345f;	 Catch:{ all -> 0x005e }
        r0 = r0 - r3;
        r3 = java.lang.Math.max(r2, r0);	 Catch:{ all -> 0x005e }
        r0 = r7.f6346g;	 Catch:{ all -> 0x005e }
        if (r3 < r0) goto L_0x0018;
    L_0x0016:
        monitor-exit(r7);
        return;
    L_0x0018:
        r0 = r7.f6342c;	 Catch:{ all -> 0x005e }
        if (r0 == 0) goto L_0x0061;
    L_0x001c:
        r0 = r7.f6346g;	 Catch:{ all -> 0x005e }
        r0 = r0 + -1;
    L_0x0020:
        if (r1 > r0) goto L_0x004b;
    L_0x0022:
        r2 = r7.f6347h;	 Catch:{ all -> 0x005e }
        r4 = r2[r1];	 Catch:{ all -> 0x005e }
        r2 = r4.f6317a;	 Catch:{ all -> 0x005e }
        r5 = r7.f6342c;	 Catch:{ all -> 0x005e }
        if (r2 != r5) goto L_0x002f;
    L_0x002c:
        r1 = r1 + 1;
        goto L_0x0020;
    L_0x002f:
        r2 = r7.f6347h;	 Catch:{ all -> 0x005e }
        r5 = r2[r0];	 Catch:{ all -> 0x005e }
        r2 = r5.f6317a;	 Catch:{ all -> 0x005e }
        r6 = r7.f6342c;	 Catch:{ all -> 0x005e }
        if (r2 == r6) goto L_0x003c;
    L_0x0039:
        r0 = r0 + -1;
        goto L_0x0020;
    L_0x003c:
        r6 = r7.f6347h;	 Catch:{ all -> 0x005e }
        r2 = r1 + 1;
        r6[r1] = r5;	 Catch:{ all -> 0x005e }
        r5 = r7.f6347h;	 Catch:{ all -> 0x005e }
        r1 = r0 + -1;
        r5[r0] = r4;	 Catch:{ all -> 0x005e }
        r0 = r1;
        r1 = r2;
        goto L_0x0020;
    L_0x004b:
        r0 = java.lang.Math.max(r3, r1);	 Catch:{ all -> 0x005e }
        r1 = r7.f6346g;	 Catch:{ all -> 0x005e }
        if (r0 >= r1) goto L_0x0016;
    L_0x0053:
        r1 = r7.f6347h;	 Catch:{ all -> 0x005e }
        r2 = r7.f6346g;	 Catch:{ all -> 0x005e }
        r3 = 0;
        java.util.Arrays.fill(r1, r0, r2, r3);	 Catch:{ all -> 0x005e }
        r7.f6346g = r0;	 Catch:{ all -> 0x005e }
        goto L_0x0016;
    L_0x005e:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
    L_0x0061:
        r0 = r3;
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.i.b():void");
    }

    public int mo3101c() {
        return this.f6341b;
    }

    public synchronized void m6967d() {
        if (this.f6340a) {
            m6962a(0);
        }
    }

    public synchronized int m6968e() {
        return this.f6345f * this.f6341b;
    }
}
