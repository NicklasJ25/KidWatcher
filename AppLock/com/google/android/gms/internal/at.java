package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.api.C2445g;
import com.google.android.gms.common.api.C2461c;
import com.google.android.gms.common.api.C2463d;
import com.google.android.gms.common.api.C2465f;
import com.google.android.gms.common.api.C2466h;
import com.google.android.gms.common.api.C2467i;
import com.google.android.gms.common.api.C2468j;
import com.google.android.gms.common.api.C2469k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2513c;
import java.lang.ref.WeakReference;

public class at<R extends C2445g> extends C2469k<R> implements C2466h<R> {
    private C2468j<? super R, ? extends C2445g> f7929a;
    private at<? extends C2445g> f7930b;
    private volatile C2467i<? super R> f7931c;
    private C2463d<R> f7932d;
    private final Object f7933e;
    private Status f7934f;
    private final WeakReference<C2461c> f7935g;
    private final C2694a f7936h;
    private boolean f7937i;

    private final class C2694a extends Handler {
        final /* synthetic */ at f7928a;

        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    C2463d c2463d = (C2463d) message.obj;
                    synchronized (this.f7928a.f7933e) {
                        if (c2463d == null) {
                            this.f7928a.f7930b.m9016a(new Status(13, "Transform returned null"));
                        } else if (c2463d instanceof an) {
                            this.f7928a.f7930b.m9016a(((an) c2463d).m8981b());
                        } else {
                            this.f7928a.f7930b.m9028a(c2463d);
                        }
                    }
                    return;
                case 1:
                    RuntimeException runtimeException = (RuntimeException) message.obj;
                    String str = "TransformedResultImpl";
                    String str2 = "Runtime exception on the transformation worker thread: ";
                    String valueOf = String.valueOf(runtimeException.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    throw runtimeException;
                default:
                    Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + message.what);
                    return;
            }
        }
    }

    private void m9016a(Status status) {
        synchronized (this.f7933e) {
            this.f7934f = status;
            m9021b(this.f7934f);
        }
    }

    private void m9020b() {
        if (this.f7929a != null || this.f7931c != null) {
            C2461c c2461c = (C2461c) this.f7935g.get();
            if (!(this.f7937i || this.f7929a == null || c2461c == null)) {
                c2461c.mo4031a(this);
                this.f7937i = true;
            }
            if (this.f7934f != null) {
                m9021b(this.f7934f);
            } else if (this.f7932d != null) {
                this.f7932d.mo3472a((C2466h) this);
            }
        }
    }

    private void m9021b(Status status) {
        synchronized (this.f7933e) {
            if (this.f7929a != null) {
                Status a = this.f7929a.m7784a(status);
                C2513c.m7933a((Object) a, (Object) "onFailure must not return null");
                this.f7930b.m9016a(a);
            } else if (m9024c()) {
                this.f7931c.m7782a(status);
            }
        }
    }

    private void m9022b(C2445g c2445g) {
        if (c2445g instanceof C2465f) {
            try {
                ((C2465f) c2445g).mo4014a();
            } catch (Throwable e) {
                String valueOf = String.valueOf(c2445g);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    private boolean m9024c() {
        return (this.f7931c == null || ((C2461c) this.f7935g.get()) == null) ? false : true;
    }

    void m9027a() {
        this.f7931c = null;
    }

    public void m9028a(C2463d<?> c2463d) {
        synchronized (this.f7933e) {
            this.f7932d = c2463d;
            m9020b();
        }
    }

    public void mo3500a(final R r) {
        synchronized (this.f7933e) {
            if (!r.mo3313a().m7729d()) {
                m9016a(r.mo3313a());
                m9022b((C2445g) r);
            } else if (this.f7929a != null) {
                am.m8977a().submit(new Runnable(this) {
                    final /* synthetic */ at f7927b;

                    @WorkerThread
                    public void run() {
                        C2461c c2461c;
                        try {
                            C2675h.f7851a.set(Boolean.valueOf(true));
                            this.f7927b.f7936h.sendMessage(this.f7927b.f7936h.obtainMessage(0, this.f7927b.f7929a.m7785a(r)));
                            C2675h.f7851a.set(Boolean.valueOf(false));
                            this.f7927b.m9022b(r);
                            c2461c = (C2461c) this.f7927b.f7935g.get();
                            if (c2461c != null) {
                                c2461c.mo4032b(this.f7927b);
                            }
                        } catch (RuntimeException e) {
                            this.f7927b.f7936h.sendMessage(this.f7927b.f7936h.obtainMessage(1, e));
                            C2675h.f7851a.set(Boolean.valueOf(false));
                            this.f7927b.m9022b(r);
                            c2461c = (C2461c) this.f7927b.f7935g.get();
                            if (c2461c != null) {
                                c2461c.mo4032b(this.f7927b);
                            }
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            C2675h.f7851a.set(Boolean.valueOf(false));
                            this.f7927b.m9022b(r);
                            c2461c = (C2461c) this.f7927b.f7935g.get();
                            if (c2461c != null) {
                                c2461c.mo4032b(this.f7927b);
                            }
                        }
                    }
                });
            } else if (m9024c()) {
                this.f7931c.m7783b(r);
            }
        }
    }
}
