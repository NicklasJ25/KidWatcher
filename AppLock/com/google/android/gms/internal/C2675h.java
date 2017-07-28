package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.C2445g;
import com.google.android.gms.common.api.C2461c;
import com.google.android.gms.common.api.C2463d;
import com.google.android.gms.common.api.C2463d.C2462a;
import com.google.android.gms.common.api.C2465f;
import com.google.android.gms.common.api.C2466h;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.C2557w;
import com.google.android.gms.internal.au.C2695b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public abstract class C2675h<R extends C2445g> extends C2463d<R> {
    static final ThreadLocal<Boolean> f7851a = new C29291();
    protected final C2930a<R> f7852b;
    protected final WeakReference<C2461c> f7853c;
    private final Object f7854d;
    private final CountDownLatch f7855e;
    private final ArrayList<C2462a> f7856f;
    private C2466h<? super R> f7857g;
    private final AtomicReference<C2695b> f7858h;
    private R f7859i;
    private Status f7860j;
    private C2931b f7861k;
    private volatile boolean f7862l;
    private boolean f7863m;
    private boolean f7864n;
    private C2557w f7865o;
    private volatile at<R> f7866p;
    private boolean f7867q;

    class C29291 extends ThreadLocal<Boolean> {
        C29291() {
        }

        protected Boolean m11293a() {
            return Boolean.valueOf(false);
        }

        protected /* synthetic */ Object initialValue() {
            return m11293a();
        }
    }

    public static class C2930a<R extends C2445g> extends Handler {
        public C2930a() {
            this(Looper.getMainLooper());
        }

        public C2930a(Looper looper) {
            super(looper);
        }

        public void m11294a() {
            removeMessages(2);
        }

        public void m11295a(C2466h<? super R> c2466h, R r) {
            sendMessage(obtainMessage(1, new Pair(c2466h, r)));
        }

        protected void m11296b(C2466h<? super R> c2466h, R r) {
            try {
                c2466h.mo3500a(r);
            } catch (RuntimeException e) {
                C2675h.m8854b((C2445g) r);
                throw e;
            }
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    m11296b((C2466h) pair.first, (C2445g) pair.second);
                    return;
                case 2:
                    ((C2675h) message.obj).m8862b(Status.zzazA);
                    return;
                default:
                    Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
                    return;
            }
        }
    }

    private final class C2931b {
        final /* synthetic */ C2675h f9165a;

        private C2931b(C2675h c2675h) {
            this.f9165a = c2675h;
        }

        protected void finalize() {
            C2675h.m8854b(this.f9165a.f7859i);
            super.finalize();
        }
    }

    @Deprecated
    C2675h() {
        this.f7854d = new Object();
        this.f7855e = new CountDownLatch(1);
        this.f7856f = new ArrayList();
        this.f7858h = new AtomicReference();
        this.f7867q = false;
        this.f7852b = new C2930a(Looper.getMainLooper());
        this.f7853c = new WeakReference(null);
    }

    @Deprecated
    protected C2675h(Looper looper) {
        this.f7854d = new Object();
        this.f7855e = new CountDownLatch(1);
        this.f7856f = new ArrayList();
        this.f7858h = new AtomicReference();
        this.f7867q = false;
        this.f7852b = new C2930a(looper);
        this.f7853c = new WeakReference(null);
    }

    protected C2675h(C2461c c2461c) {
        this.f7854d = new Object();
        this.f7855e = new CountDownLatch(1);
        this.f7856f = new ArrayList();
        this.f7858h = new AtomicReference();
        this.f7867q = false;
        this.f7852b = new C2930a(c2461c != null ? c2461c.mo4028a() : Looper.getMainLooper());
        this.f7853c = new WeakReference(c2461c);
    }

    private void mo3473b() {
        C2695b c2695b = (C2695b) this.f7858h.getAndSet(null);
        if (c2695b != null) {
            c2695b.mo3501a(this);
        }
    }

    public static void m8854b(C2445g c2445g) {
        if (c2445g instanceof C2465f) {
            try {
                ((C2465f) c2445g).mo4014a();
            } catch (Throwable e) {
                String valueOf = String.valueOf(c2445g);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    private R mo3474c() {
        R r;
        boolean z = true;
        synchronized (this.f7854d) {
            if (this.f7862l) {
                z = false;
            }
            C2513c.m7938a(z, (Object) "Result has already been consumed.");
            C2513c.m7938a(m8864d(), (Object) "Result is not ready.");
            r = this.f7859i;
            this.f7859i = null;
            this.f7857g = null;
            this.f7862l = true;
        }
        mo3473b();
        return r;
    }

    private void m8856c(R r) {
        this.f7859i = r;
        this.f7865o = null;
        this.f7855e.countDown();
        this.f7860j = this.f7859i.mo3313a();
        if (this.f7863m) {
            this.f7857g = null;
        } else if (this.f7857g != null) {
            this.f7852b.m11294a();
            this.f7852b.m11295a(this.f7857g, mo3474c());
        } else if (this.f7859i instanceof C2465f) {
            this.f7861k = new C2931b();
        }
        Iterator it = this.f7856f.iterator();
        while (it.hasNext()) {
            ((C2462a) it.next()).mo3846a(this.f7860j);
        }
        this.f7856f.clear();
    }

    public Integer mo3470a() {
        return null;
    }

    public final void mo3471a(C2462a c2462a) {
        C2513c.m7942b(c2462a != null, "Callback cannot be null.");
        synchronized (this.f7854d) {
            if (m8864d()) {
                c2462a.mo3846a(this.f7860j);
            } else {
                this.f7856f.add(c2462a);
            }
        }
    }

    public final void m8859a(R r) {
        boolean z = true;
        synchronized (this.f7854d) {
            if (this.f7864n || this.f7863m) {
                C2675h.m8854b((C2445g) r);
                return;
            }
            if (m8864d()) {
            }
            C2513c.m7938a(!m8864d(), (Object) "Results have already been set");
            if (this.f7862l) {
                z = false;
            }
            C2513c.m7938a(z, (Object) "Result has already been consumed");
            m8856c((C2445g) r);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo3472a(com.google.android.gms.common.api.C2466h<? super R> r6) {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r3 = r5.f7854d;
        monitor-enter(r3);
        if (r6 != 0) goto L_0x000c;
    L_0x0007:
        r0 = 0;
        r5.f7857g = r0;	 Catch:{ all -> 0x0027 }
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
    L_0x000b:
        return;
    L_0x000c:
        r2 = r5.f7862l;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002a;
    L_0x0010:
        r2 = r0;
    L_0x0011:
        r4 = "Result has already been consumed.";
        com.google.android.gms.common.internal.C2513c.m7938a(r2, r4);	 Catch:{ all -> 0x0027 }
        r2 = r5.f7866p;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002c;
    L_0x001a:
        r1 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.C2513c.m7938a(r0, r1);	 Catch:{ all -> 0x0027 }
        r0 = r5.m8867g();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x002e;
    L_0x0025:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        throw r0;
    L_0x002a:
        r2 = r1;
        goto L_0x0011;
    L_0x002c:
        r0 = r1;
        goto L_0x001a;
    L_0x002e:
        r0 = r5.m8864d();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x003f;
    L_0x0034:
        r0 = r5.f7852b;	 Catch:{ all -> 0x0027 }
        r1 = r5.mo3474c();	 Catch:{ all -> 0x0027 }
        r0.m11295a(r6, r1);	 Catch:{ all -> 0x0027 }
    L_0x003d:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x003f:
        r5.f7857g = r6;	 Catch:{ all -> 0x0027 }
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.h.a(com.google.android.gms.common.api.h):void");
    }

    public void m8861a(C2695b c2695b) {
        this.f7858h.set(c2695b);
    }

    public final void m8862b(Status status) {
        synchronized (this.f7854d) {
            if (!m8864d()) {
                m8859a(mo3476c(status));
                this.f7864n = true;
            }
        }
    }

    @NonNull
    protected abstract R mo3476c(Status status);

    public final boolean m8864d() {
        return this.f7855e.getCount() == 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m8865e() {
        /*
        r2 = this;
        r1 = r2.f7854d;
        monitor-enter(r1);
        r0 = r2.f7863m;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.f7862l;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.f7865o;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0016;
    L_0x0011:
        r0 = r2.f7865o;	 Catch:{ RemoteException -> 0x002c }
        r0.m8177a();	 Catch:{ RemoteException -> 0x002c }
    L_0x0016:
        r0 = r2.f7859i;	 Catch:{ all -> 0x0029 }
        com.google.android.gms.internal.C2675h.m8854b(r0);	 Catch:{ all -> 0x0029 }
        r0 = 1;
        r2.f7863m = r0;	 Catch:{ all -> 0x0029 }
        r0 = com.google.android.gms.common.api.Status.zzazB;	 Catch:{ all -> 0x0029 }
        r0 = r2.mo3476c(r0);	 Catch:{ all -> 0x0029 }
        r2.m8856c(r0);	 Catch:{ all -> 0x0029 }
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        goto L_0x000c;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.h.e():void");
    }

    public boolean m8866f() {
        boolean g;
        synchronized (this.f7854d) {
            if (((C2461c) this.f7853c.get()) == null || !this.f7867q) {
                m8865e();
            }
            g = m8867g();
        }
        return g;
    }

    public boolean m8867g() {
        boolean z;
        synchronized (this.f7854d) {
            z = this.f7863m;
        }
        return z;
    }

    public void m8868h() {
        mo3472a(null);
    }

    public void m8869i() {
        boolean z = this.f7867q || ((Boolean) f7851a.get()).booleanValue();
        this.f7867q = z;
    }
}
