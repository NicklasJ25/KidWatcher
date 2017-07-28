package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.internal.tv.C3314a;
import com.google.android.gms.internal.ud.C3310a;

@wh
public final class tt extends C3310a {
    private final Object f10804a = new Object();
    private C3314a f10805b;
    private ts f10806c;

    public void mo4046a() {
        synchronized (this.f10804a) {
            if (this.f10806c != null) {
                this.f10806c.zzbP();
            }
        }
    }

    public void mo4047a(int i) {
        synchronized (this.f10804a) {
            if (this.f10805b != null) {
                this.f10805b.mo4055a(i == 3 ? 1 : 2);
                this.f10805b = null;
            }
        }
    }

    public void m13993a(@Nullable ts tsVar) {
        synchronized (this.f10804a) {
            this.f10806c = tsVar;
        }
    }

    public void m13994a(C3314a c3314a) {
        synchronized (this.f10804a) {
            this.f10805b = c3314a;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4048a(com.google.android.gms.internal.ue r4) {
        /*
        r3 = this;
        r1 = r3.f10804a;
        monitor-enter(r1);
        r0 = r3.f10805b;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r0 = r3.f10805b;	 Catch:{ all -> 0x001d }
        r2 = 0;
        r0.mo4056a(r2, r4);	 Catch:{ all -> 0x001d }
        r0 = 0;
        r3.f10805b = r0;	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r3.f10806c;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = r3.f10806c;	 Catch:{ all -> 0x001d }
        r0.zzbT();	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        goto L_0x0011;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.tt.a(com.google.android.gms.internal.ue):void");
    }

    public void mo4049b() {
        synchronized (this.f10804a) {
            if (this.f10806c != null) {
                this.f10806c.zzbQ();
            }
        }
    }

    public void mo4050c() {
        synchronized (this.f10804a) {
            if (this.f10806c != null) {
                this.f10806c.zzbR();
            }
        }
    }

    public void mo4051d() {
        synchronized (this.f10804a) {
            if (this.f10806c != null) {
                this.f10806c.zzbS();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4052e() {
        /*
        r3 = this;
        r1 = r3.f10804a;
        monitor-enter(r1);
        r0 = r3.f10805b;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r0 = r3.f10805b;	 Catch:{ all -> 0x001d }
        r2 = 0;
        r0.mo4055a(r2);	 Catch:{ all -> 0x001d }
        r0 = 0;
        r3.f10805b = r0;	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r3.f10806c;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = r3.f10806c;	 Catch:{ all -> 0x001d }
        r0.zzbT();	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        goto L_0x0011;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.tt.e():void");
    }

    public void mo4053f() {
        synchronized (this.f10804a) {
            if (this.f10806c != null) {
                this.f10806c.zzbU();
            }
        }
    }
}
