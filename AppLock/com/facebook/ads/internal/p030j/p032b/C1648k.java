package com.facebook.ads.internal.p030j.p032b;

import android.util.Log;
import java.lang.Thread.State;
import java.util.concurrent.atomic.AtomicInteger;

class C1648k {
    private final C1659n f4059a;
    private final C1635a f4060b;
    private final Object f4061c = new Object();
    private final Object f4062d = new Object();
    private final AtomicInteger f4063e;
    private volatile Thread f4064f;
    private volatile boolean f4065g;
    private volatile int f4066h = -1;

    private class C1665a implements Runnable {
        final /* synthetic */ C1648k f4101a;

        private C1665a(C1648k c1648k) {
            this.f4101a = c1648k;
        }

        public void run() {
            this.f4101a.m4644e();
        }
    }

    public C1648k(C1659n c1659n, C1635a c1635a) {
        this.f4059a = (C1659n) C1663j.m4705a(c1659n);
        this.f4060b = (C1635a) C1663j.m4705a(c1635a);
        this.f4063e = new AtomicInteger();
    }

    private void m4640b() {
        int i = this.f4063e.get();
        if (i >= 1) {
            this.f4063e.set(0);
            throw new C1661l("Error reading source " + i + " times");
        }
    }

    private void m4641b(long j, long j2) {
        m4651a(j, j2);
        synchronized (this.f4061c) {
            this.f4061c.notifyAll();
        }
    }

    private synchronized void m4642c() {
        Object obj = (this.f4064f == null || this.f4064f.getState() == State.TERMINATED) ? null : 1;
        if (!(this.f4065g || this.f4060b.mo2765d() || obj != null)) {
            this.f4064f = new Thread(new C1665a(), "Source reader for " + this.f4059a);
            this.f4064f.start();
        }
    }

    private void m4643d() {
        synchronized (this.f4061c) {
            try {
                this.f4061c.wait(1000);
            } catch (Throwable e) {
                throw new C1661l("Waiting source data is interrupted!", e);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4644e() {
        /*
        r8 = this;
        r3 = -1;
        r1 = 0;
        r0 = r8.f4060b;	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r1 = r0.mo2760a();	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r0 = r8.f4059a;	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r0.mo2773a(r1);	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r0 = r8.f4059a;	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r2 = r0.mo2771a();	 Catch:{ Throwable -> 0x006d, all -> 0x006a }
        r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = new byte[r0];	 Catch:{ Throwable -> 0x003f }
    L_0x0017:
        r4 = r8.f4059a;	 Catch:{ Throwable -> 0x003f }
        r4 = r4.mo2772a(r0);	 Catch:{ Throwable -> 0x003f }
        if (r4 == r3) goto L_0x005e;
    L_0x001f:
        r5 = r8.f4062d;	 Catch:{ Throwable -> 0x003f }
        monitor-enter(r5);	 Catch:{ Throwable -> 0x003f }
        r6 = r8.m4646g();	 Catch:{ all -> 0x0051 }
        if (r6 == 0) goto L_0x0032;
    L_0x0028:
        monitor-exit(r5);	 Catch:{ all -> 0x0051 }
        r8.m4647h();
        r0 = (long) r1;
        r2 = (long) r2;
        r8.m4641b(r0, r2);
    L_0x0031:
        return;
    L_0x0032:
        r6 = r8.f4060b;	 Catch:{ all -> 0x0051 }
        r6.mo2762a(r0, r4);	 Catch:{ all -> 0x0051 }
        monitor-exit(r5);	 Catch:{ all -> 0x0051 }
        r1 = r1 + r4;
        r4 = (long) r1;
        r6 = (long) r2;
        r8.m4641b(r4, r6);	 Catch:{ Throwable -> 0x003f }
        goto L_0x0017;
    L_0x003f:
        r0 = move-exception;
    L_0x0040:
        r3 = r8.f4063e;	 Catch:{ all -> 0x0054 }
        r3.incrementAndGet();	 Catch:{ all -> 0x0054 }
        r8.m4652a(r0);	 Catch:{ all -> 0x0054 }
        r8.m4647h();
        r0 = (long) r1;
        r2 = (long) r2;
        r8.m4641b(r0, r2);
        goto L_0x0031;
    L_0x0051:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0051 }
        throw r0;	 Catch:{ Throwable -> 0x003f }
    L_0x0054:
        r0 = move-exception;
    L_0x0055:
        r8.m4647h();
        r4 = (long) r1;
        r2 = (long) r2;
        r8.m4641b(r4, r2);
        throw r0;
    L_0x005e:
        r8.m4645f();	 Catch:{ Throwable -> 0x003f }
        r8.m4647h();
        r0 = (long) r1;
        r2 = (long) r2;
        r8.m4641b(r0, r2);
        goto L_0x0031;
    L_0x006a:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0055;
    L_0x006d:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.j.b.k.e():void");
    }

    private void m4645f() {
        synchronized (this.f4062d) {
            if (!m4646g() && this.f4060b.mo2760a() == this.f4059a.mo2771a()) {
                this.f4060b.mo2764c();
            }
        }
    }

    private boolean m4646g() {
        return Thread.currentThread().isInterrupted() || this.f4065g;
    }

    private void m4647h() {
        try {
            this.f4059a.mo2774b();
        } catch (Throwable e) {
            m4652a(new C1661l("Error closing source " + this.f4059a, e));
        }
    }

    public int m4648a(byte[] bArr, long j, int i) {
        C1666m.m4711a(bArr, j, i);
        while (!this.f4060b.mo2765d() && ((long) this.f4060b.mo2760a()) < ((long) i) + j && !this.f4065g) {
            m4642c();
            m4643d();
            m4640b();
        }
        int a = this.f4060b.mo2761a(bArr, j, i);
        if (this.f4060b.mo2765d() && this.f4066h != 100) {
            this.f4066h = 100;
            mo2769a(100);
        }
        return a;
    }

    public void m4649a() {
        synchronized (this.f4062d) {
            Log.d("ProxyCache", "Shutdown proxy for " + this.f4059a);
            try {
                this.f4065g = true;
                if (this.f4064f != null) {
                    this.f4064f.interrupt();
                }
                this.f4060b.mo2763b();
            } catch (Throwable e) {
                m4652a(e);
            }
        }
    }

    protected void mo2769a(int i) {
    }

    protected void m4651a(long j, long j2) {
        Object obj = 1;
        int i = ((j2 > 0 ? 1 : (j2 == 0 ? 0 : -1)) == 0 ? 1 : null) != null ? 100 : (int) ((100 * j) / j2);
        Object obj2 = i != this.f4066h ? 1 : null;
        if (j2 < 0) {
            obj = null;
        }
        if (!(obj == null || obj2 == null)) {
            mo2769a(i);
        }
        this.f4066h = i;
    }

    protected final void m4652a(Throwable th) {
        if (th instanceof C1662i) {
            Log.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            Log.e("ProxyCache", "ProxyCache error", th);
        }
    }
}
