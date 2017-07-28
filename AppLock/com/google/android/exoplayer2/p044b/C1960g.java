package com.google.android.exoplayer2.p044b;

import com.google.android.exoplayer2.p043j.C2252a;
import java.util.LinkedList;

public abstract class C1960g<I extends C1957e, O extends C1958f, E extends Exception> implements C1955c<I, O, E> {
    private final Thread f5131a;
    private final Object f5132b = new Object();
    private final LinkedList<I> f5133c = new LinkedList();
    private final LinkedList<O> f5134d = new LinkedList();
    private final I[] f5135e;
    private final O[] f5136f;
    private int f5137g;
    private int f5138h;
    private I f5139i;
    private E f5140j;
    private boolean f5141k;
    private boolean f5142l;
    private int f5143m;

    class C19591 extends Thread {
        final /* synthetic */ C1960g f5130a;

        C19591(C1960g c1960g) {
            this.f5130a = c1960g;
        }

        public void run() {
            this.f5130a.m5716k();
        }
    }

    protected C1960g(I[] iArr, O[] oArr) {
        int i = 0;
        this.f5135e = iArr;
        this.f5137g = iArr.length;
        for (int i2 = 0; i2 < this.f5137g; i2++) {
            this.f5135e[i2] = mo3058g();
        }
        this.f5136f = oArr;
        this.f5138h = oArr.length;
        while (i < this.f5138h) {
            this.f5136f[i] = mo3059h();
            i++;
        }
        this.f5131a = new C19591(this);
        this.f5131a.start();
    }

    private void m5712b(I i) {
        i.mo2931a();
        C1957e[] c1957eArr = this.f5135e;
        int i2 = this.f5137g;
        this.f5137g = i2 + 1;
        c1957eArr[i2] = i;
    }

    private void m5713b(O o) {
        o.mo2931a();
        C1958f[] c1958fArr = this.f5136f;
        int i = this.f5138h;
        this.f5138h = i + 1;
        c1958fArr[i] = o;
    }

    private void mo3060i() {
        if (this.f5140j != null) {
            throw this.f5140j;
        }
    }

    private void mo3061j() {
        if (m5718m()) {
            this.f5132b.notify();
        }
    }

    private void m5716k() {
        do {
            try {
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        } while (m5717l());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m5717l() {
        /*
        r6 = this;
        r1 = 0;
        r2 = r6.f5132b;
        monitor-enter(r2);
    L_0x0004:
        r0 = r6.f5142l;	 Catch:{ all -> 0x0014 }
        if (r0 != 0) goto L_0x0017;
    L_0x0008:
        r0 = r6.m5718m();	 Catch:{ all -> 0x0014 }
        if (r0 != 0) goto L_0x0017;
    L_0x000e:
        r0 = r6.f5132b;	 Catch:{ all -> 0x0014 }
        r0.wait();	 Catch:{ all -> 0x0014 }
        goto L_0x0004;
    L_0x0014:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0014 }
        throw r0;
    L_0x0017:
        r0 = r6.f5142l;	 Catch:{ all -> 0x0014 }
        if (r0 == 0) goto L_0x001e;
    L_0x001b:
        monitor-exit(r2);	 Catch:{ all -> 0x0014 }
        r0 = r1;
    L_0x001d:
        return r0;
    L_0x001e:
        r0 = r6.f5133c;	 Catch:{ all -> 0x0014 }
        r0 = r0.removeFirst();	 Catch:{ all -> 0x0014 }
        r0 = (com.google.android.exoplayer2.p044b.C1957e) r0;	 Catch:{ all -> 0x0014 }
        r3 = r6.f5136f;	 Catch:{ all -> 0x0014 }
        r4 = r6.f5138h;	 Catch:{ all -> 0x0014 }
        r4 = r4 + -1;
        r6.f5138h = r4;	 Catch:{ all -> 0x0014 }
        r3 = r3[r4];	 Catch:{ all -> 0x0014 }
        r4 = r6.f5141k;	 Catch:{ all -> 0x0014 }
        r5 = 0;
        r6.f5141k = r5;	 Catch:{ all -> 0x0014 }
        monitor-exit(r2);	 Catch:{ all -> 0x0014 }
        r2 = r0.m5694c();
        if (r2 == 0) goto L_0x0050;
    L_0x003c:
        r1 = 4;
        r3.m5692b(r1);
    L_0x0040:
        r1 = r6.f5132b;
        monitor-enter(r1);
        r2 = r6.f5141k;	 Catch:{ all -> 0x007e }
        if (r2 == 0) goto L_0x006e;
    L_0x0047:
        r6.m5713b(r3);	 Catch:{ all -> 0x007e }
    L_0x004a:
        r6.m5712b(r0);	 Catch:{ all -> 0x007e }
        monitor-exit(r1);	 Catch:{ all -> 0x007e }
        r0 = 1;
        goto L_0x001d;
    L_0x0050:
        r2 = r0.d_();
        if (r2 == 0) goto L_0x005b;
    L_0x0056:
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r3.m5692b(r2);
    L_0x005b:
        r2 = r6.mo3056a(r0, r3, r4);
        r6.f5140j = r2;
        r2 = r6.f5140j;
        if (r2 == 0) goto L_0x0040;
    L_0x0065:
        r2 = r6.f5132b;
        monitor-enter(r2);
        monitor-exit(r2);	 Catch:{ all -> 0x006b }
        r0 = r1;
        goto L_0x001d;
    L_0x006b:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x006b }
        throw r0;
    L_0x006e:
        r2 = r3.d_();	 Catch:{ all -> 0x007e }
        if (r2 == 0) goto L_0x0081;
    L_0x0074:
        r2 = r6.f5143m;	 Catch:{ all -> 0x007e }
        r2 = r2 + 1;
        r6.f5143m = r2;	 Catch:{ all -> 0x007e }
        r6.m5713b(r3);	 Catch:{ all -> 0x007e }
        goto L_0x004a;
    L_0x007e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x007e }
        throw r0;
    L_0x0081:
        r2 = r6.f5143m;	 Catch:{ all -> 0x007e }
        r3.f5129b = r2;	 Catch:{ all -> 0x007e }
        r2 = 0;
        r6.f5143m = r2;	 Catch:{ all -> 0x007e }
        r2 = r6.f5134d;	 Catch:{ all -> 0x007e }
        r2.addLast(r3);	 Catch:{ all -> 0x007e }
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.b.g.l():boolean");
    }

    private boolean m5718m() {
        return !this.f5133c.isEmpty() && this.f5138h > 0;
    }

    protected abstract E mo3056a(I i, O o, boolean z);

    public /* synthetic */ Object mo2932a() {
        return m5728e();
    }

    protected final void m5721a(int i) {
        int i2 = 0;
        C2252a.m7024b(this.f5137g == this.f5135e.length);
        C1957e[] c1957eArr = this.f5135e;
        int length = c1957eArr.length;
        while (i2 < length) {
            c1957eArr[i2].m5710e(i);
            i2++;
        }
    }

    public final void m5722a(I i) {
        synchronized (this.f5132b) {
            mo3060i();
            C2252a.m7022a(i == this.f5139i);
            this.f5133c.addLast(i);
            mo3061j();
            this.f5139i = null;
        }
    }

    protected void mo3057a(O o) {
        synchronized (this.f5132b) {
            m5713b((C1958f) o);
            mo3061j();
        }
    }

    public /* synthetic */ Object mo2934b() {
        return m5729f();
    }

    public final void mo2935c() {
        synchronized (this.f5132b) {
            this.f5141k = true;
            this.f5143m = 0;
            if (this.f5139i != null) {
                m5712b(this.f5139i);
                this.f5139i = null;
            }
            while (!this.f5133c.isEmpty()) {
                m5712b((C1957e) this.f5133c.removeFirst());
            }
            while (!this.f5134d.isEmpty()) {
                m5713b((C1958f) this.f5134d.removeFirst());
            }
        }
    }

    public void mo2936d() {
        synchronized (this.f5132b) {
            this.f5142l = true;
            this.f5132b.notify();
        }
        try {
            this.f5131a.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public final I m5728e() {
        I i;
        synchronized (this.f5132b) {
            C1957e c1957e;
            mo3060i();
            C2252a.m7024b(this.f5139i == null);
            if (this.f5137g == 0) {
                c1957e = null;
            } else {
                C1957e[] c1957eArr = this.f5135e;
                int i2 = this.f5137g - 1;
                this.f5137g = i2;
                c1957e = c1957eArr[i2];
            }
            this.f5139i = c1957e;
            i = this.f5139i;
        }
        return i;
    }

    public final O m5729f() {
        O o;
        synchronized (this.f5132b) {
            mo3060i();
            if (this.f5134d.isEmpty()) {
                o = null;
            } else {
                C1958f c1958f = (C1958f) this.f5134d.removeFirst();
            }
        }
        return o;
    }

    protected abstract I mo3058g();

    protected abstract O mo3059h();
}
