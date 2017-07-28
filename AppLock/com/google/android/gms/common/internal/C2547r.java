package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.C2461c.C2459b;
import com.google.android.gms.common.api.C2461c.C2460c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class C2547r implements Callback {
    final ArrayList<C2459b> f7462a = new ArrayList();
    private final C2518a f7463b;
    private final ArrayList<C2459b> f7464c = new ArrayList();
    private final ArrayList<C2460c> f7465d = new ArrayList();
    private volatile boolean f7466e = false;
    private final AtomicInteger f7467f = new AtomicInteger(0);
    private boolean f7468g = false;
    private final Handler f7469h;
    private final Object f7470i = new Object();

    public interface C2518a {
        boolean mo4026b();

        Bundle mo4027u();
    }

    public C2547r(Looper looper, C2518a c2518a) {
        this.f7463b = c2518a;
        this.f7469h = new Handler(looper, this);
    }

    public void m8075a() {
        this.f7466e = false;
        this.f7467f.incrementAndGet();
    }

    public void m8076a(int i) {
        boolean z = false;
        if (Looper.myLooper() == this.f7469h.getLooper()) {
            z = true;
        }
        C2513c.m7938a(z, (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f7469h.removeMessages(1);
        synchronized (this.f7470i) {
            this.f7468g = true;
            ArrayList arrayList = new ArrayList(this.f7464c);
            int i2 = this.f7467f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C2459b c2459b = (C2459b) it.next();
                if (!this.f7466e || this.f7467f.get() != i2) {
                    break;
                } else if (this.f7464c.contains(c2459b)) {
                    c2459b.mo3496a(i);
                }
            }
            this.f7462a.clear();
            this.f7468g = false;
        }
    }

    public void m8077a(Bundle bundle) {
        boolean z = true;
        C2513c.m7938a(Looper.myLooper() == this.f7469h.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f7470i) {
            C2513c.m7937a(!this.f7468g);
            this.f7469h.removeMessages(1);
            this.f7468g = true;
            if (this.f7462a.size() != 0) {
                z = false;
            }
            C2513c.m7937a(z);
            ArrayList arrayList = new ArrayList(this.f7464c);
            int i = this.f7467f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C2459b c2459b = (C2459b) it.next();
                if (!this.f7466e || !this.f7463b.mo4026b() || this.f7467f.get() != i) {
                    break;
                } else if (!this.f7462a.contains(c2459b)) {
                    c2459b.mo3497a(bundle);
                }
            }
            this.f7462a.clear();
            this.f7468g = false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m8078a(com.google.android.gms.common.ConnectionResult r6) {
        /*
        r5 = this;
        r1 = 1;
        r0 = android.os.Looper.myLooper();
        r2 = r5.f7469h;
        r2 = r2.getLooper();
        if (r0 != r2) goto L_0x0046;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        r2 = "onConnectionFailure must only be called on the Handler thread";
        com.google.android.gms.common.internal.C2513c.m7938a(r0, r2);
        r0 = r5.f7469h;
        r0.removeMessages(r1);
        r1 = r5.f7470i;
        monitor-enter(r1);
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0054 }
        r2 = r5.f7465d;	 Catch:{ all -> 0x0054 }
        r0.<init>(r2);	 Catch:{ all -> 0x0054 }
        r2 = r5.f7467f;	 Catch:{ all -> 0x0054 }
        r2 = r2.get();	 Catch:{ all -> 0x0054 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0054 }
    L_0x002c:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x0057;
    L_0x0032:
        r0 = r3.next();	 Catch:{ all -> 0x0054 }
        r0 = (com.google.android.gms.common.api.C2461c.C2460c) r0;	 Catch:{ all -> 0x0054 }
        r4 = r5.f7466e;	 Catch:{ all -> 0x0054 }
        if (r4 == 0) goto L_0x0044;
    L_0x003c:
        r4 = r5.f7467f;	 Catch:{ all -> 0x0054 }
        r4 = r4.get();	 Catch:{ all -> 0x0054 }
        if (r4 == r2) goto L_0x0048;
    L_0x0044:
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
    L_0x0045:
        return;
    L_0x0046:
        r0 = 0;
        goto L_0x000e;
    L_0x0048:
        r4 = r5.f7465d;	 Catch:{ all -> 0x0054 }
        r4 = r4.contains(r0);	 Catch:{ all -> 0x0054 }
        if (r4 == 0) goto L_0x002c;
    L_0x0050:
        r0.mo3498a(r6);	 Catch:{ all -> 0x0054 }
        goto L_0x002c;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
        throw r0;
    L_0x0057:
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.r.a(com.google.android.gms.common.ConnectionResult):void");
    }

    public void m8079a(C2459b c2459b) {
        C2513c.m7932a((Object) c2459b);
        synchronized (this.f7470i) {
            if (this.f7464c.contains(c2459b)) {
                String valueOf = String.valueOf(c2459b);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 62).append("registerConnectionCallbacks(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.f7464c.add(c2459b);
            }
        }
        if (this.f7463b.mo4026b()) {
            this.f7469h.sendMessage(this.f7469h.obtainMessage(1, c2459b));
        }
    }

    public void m8080a(C2460c c2460c) {
        C2513c.m7932a((Object) c2460c);
        synchronized (this.f7470i) {
            if (this.f7465d.contains(c2460c)) {
                String valueOf = String.valueOf(c2460c);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 67).append("registerConnectionFailedListener(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.f7465d.add(c2460c);
            }
        }
    }

    public void m8081b() {
        this.f7466e = true;
    }

    public void m8082b(C2460c c2460c) {
        C2513c.m7932a((Object) c2460c);
        synchronized (this.f7470i) {
            if (!this.f7465d.remove(c2460c)) {
                String valueOf = String.valueOf(c2460c);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(valueOf).append(" not found").toString());
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            C2459b c2459b = (C2459b) message.obj;
            synchronized (this.f7470i) {
                if (this.f7466e && this.f7463b.mo4026b() && this.f7464c.contains(c2459b)) {
                    c2459b.mo3497a(this.f7463b.mo4027u());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
        return false;
    }
}
