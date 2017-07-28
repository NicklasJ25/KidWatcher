package com.google.android.exoplayer2.p056i;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2271q;
import com.google.android.exoplayer2.p043j.C2273r;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class C2250q {
    private final ExecutorService f6411a;
    private C2248b<? extends C2134c> f6412b;
    private IOException f6413c;

    public interface C2134c {
        void mo3010a();

        boolean mo3011b();

        void mo3012c();
    }

    public interface C2141a<T extends C2134c> {
        int mo3017a(T t, long j, long j2, IOException iOException);

        void mo3024a(T t, long j, long j2);

        void mo3025a(T t, long j, long j2, boolean z);
    }

    @SuppressLint({"HandlerLeak"})
    private final class C2248b<T extends C2134c> extends Handler implements Runnable {
        public final int f6402a;
        final /* synthetic */ C2250q f6403b;
        private final T f6404c;
        private final C2141a<T> f6405d;
        private final long f6406e;
        private IOException f6407f;
        private int f6408g;
        private volatile Thread f6409h;
        private volatile boolean f6410i;

        public C2248b(C2250q c2250q, Looper looper, T t, C2141a<T> c2141a, int i, long j) {
            this.f6403b = c2250q;
            super(looper);
            this.f6404c = t;
            this.f6405d = c2141a;
            this.f6402a = i;
            this.f6406e = j;
        }

        private void m7003a() {
            this.f6407f = null;
            this.f6403b.f6411a.submit(this.f6403b.f6412b);
        }

        private void m7004b() {
            this.f6403b.f6412b = null;
        }

        private long m7005c() {
            return (long) Math.min((this.f6408g - 1) * 1000, 5000);
        }

        public void m7006a(int i) {
            if (this.f6407f != null && this.f6408g > i) {
                throw this.f6407f;
            }
        }

        public void m7007a(long j) {
            C2252a.m7024b(this.f6403b.f6412b == null);
            this.f6403b.f6412b = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                m7003a();
            }
        }

        public void m7008a(boolean z) {
            this.f6410i = z;
            this.f6407f = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.f6404c.mo3010a();
                if (this.f6409h != null) {
                    this.f6409h.interrupt();
                }
            }
            if (z) {
                m7004b();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f6405d.mo3025a(this.f6404c, elapsedRealtime, elapsedRealtime - this.f6406e, true);
            }
        }

        public void handleMessage(Message message) {
            if (!this.f6410i) {
                if (message.what == 0) {
                    m7003a();
                } else if (message.what == 4) {
                    throw ((Error) message.obj);
                } else {
                    m7004b();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j = elapsedRealtime - this.f6406e;
                    if (this.f6404c.mo3011b()) {
                        this.f6405d.mo3025a(this.f6404c, elapsedRealtime, j, false);
                        return;
                    }
                    switch (message.what) {
                        case 1:
                            this.f6405d.mo3025a(this.f6404c, elapsedRealtime, j, false);
                            return;
                        case 2:
                            this.f6405d.mo3024a(this.f6404c, elapsedRealtime, j);
                            return;
                        case 3:
                            this.f6407f = (IOException) message.obj;
                            int a = this.f6405d.mo3017a(this.f6404c, elapsedRealtime, j, this.f6407f);
                            if (a == 3) {
                                this.f6403b.f6413c = this.f6407f;
                                return;
                            } else if (a != 2) {
                                this.f6408g = a == 1 ? 1 : this.f6408g + 1;
                                m7007a(m7005c());
                                return;
                            } else {
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        }

        public void run() {
            try {
                this.f6409h = Thread.currentThread();
                if (!this.f6404c.mo3011b()) {
                    C2271q.m7121a("load:" + this.f6404c.getClass().getSimpleName());
                    this.f6404c.mo3012c();
                    C2271q.m7120a();
                }
                if (!this.f6410i) {
                    sendEmptyMessage(2);
                }
            } catch (IOException e) {
                if (!this.f6410i) {
                    obtainMessage(3, e).sendToTarget();
                }
            } catch (InterruptedException e2) {
                C2252a.m7024b(this.f6404c.mo3011b());
                if (!this.f6410i) {
                    sendEmptyMessage(2);
                }
            } catch (Throwable e3) {
                Log.e("LoadTask", "Unexpected exception loading stream", e3);
                if (!this.f6410i) {
                    obtainMessage(3, new C2249d(e3)).sendToTarget();
                }
            } catch (Throwable e32) {
                Log.e("LoadTask", "Unexpected error loading stream", e32);
                if (!this.f6410i) {
                    obtainMessage(4, e32).sendToTarget();
                }
                throw e32;
            } catch (Throwable th) {
                C2271q.m7120a();
            }
        }
    }

    public static final class C2249d extends IOException {
        public C2249d(Exception exception) {
            super("Unexpected " + exception.getClass().getSimpleName() + ": " + exception.getMessage(), exception);
        }
    }

    public C2250q(String str) {
        this.f6411a = C2273r.m7132a(str);
    }

    public <T extends C2134c> long m7013a(T t, C2141a<T> c2141a, int i) {
        Looper myLooper = Looper.myLooper();
        C2252a.m7024b(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new C2248b(this, myLooper, t, c2141a, i, elapsedRealtime).m7007a(0);
        return elapsedRealtime;
    }

    public void m7014a(int i) {
        if (this.f6413c != null) {
            throw this.f6413c;
        } else if (this.f6412b != null) {
            C2248b c2248b = this.f6412b;
            if (i == Integer.MIN_VALUE) {
                i = this.f6412b.f6402a;
            }
            c2248b.m7006a(i);
        }
    }

    public void m7015a(Runnable runnable) {
        if (this.f6412b != null) {
            this.f6412b.m7008a(true);
        }
        if (runnable != null) {
            this.f6411a.submit(runnable);
        }
        this.f6411a.shutdown();
    }

    public boolean m7016a() {
        return this.f6412b != null;
    }

    public void m7017b() {
        this.f6412b.m7008a(false);
    }

    public void m7018c() {
        m7014a(Integer.MIN_VALUE);
    }
}
