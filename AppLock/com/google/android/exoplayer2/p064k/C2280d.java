package com.google.android.exoplayer2.p064k;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.WindowManager;

@TargetApi(16)
public final class C2280d {
    private final C2279a f6527a;
    private final boolean f6528b;
    private final long f6529c;
    private final long f6530d;
    private long f6531e;
    private long f6532f;
    private long f6533g;
    private boolean f6534h;
    private long f6535i;
    private long f6536j;
    private long f6537k;

    private static final class C2279a implements Callback, FrameCallback {
        private static final C2279a f6521b = new C2279a();
        public volatile long f6522a;
        private final Handler f6523c;
        private final HandlerThread f6524d = new HandlerThread("ChoreographerOwner:Handler");
        private Choreographer f6525e;
        private int f6526f;

        private C2279a() {
            this.f6524d.start();
            this.f6523c = new Handler(this.f6524d.getLooper(), this);
            this.f6523c.sendEmptyMessage(0);
        }

        public static C2279a m7183a() {
            return f6521b;
        }

        private void m7184d() {
            this.f6525e = Choreographer.getInstance();
        }

        private void m7185e() {
            this.f6526f++;
            if (this.f6526f == 1) {
                this.f6525e.postFrameCallback(this);
            }
        }

        private void m7186f() {
            this.f6526f--;
            if (this.f6526f == 0) {
                this.f6525e.removeFrameCallback(this);
                this.f6522a = 0;
            }
        }

        public void m7187b() {
            this.f6523c.sendEmptyMessage(1);
        }

        public void m7188c() {
            this.f6523c.sendEmptyMessage(2);
        }

        public void doFrame(long j) {
            this.f6522a = j;
            this.f6525e.postFrameCallbackDelayed(this, 500);
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    m7184d();
                    return true;
                case 1:
                    m7185e();
                    return true;
                case 2:
                    m7186f();
                    return true;
                default:
                    return false;
            }
        }
    }

    public C2280d() {
        this(-1.0d, false);
    }

    private C2280d(double d, boolean z) {
        this.f6528b = z;
        if (z) {
            this.f6527a = C2279a.m7183a();
            this.f6529c = (long) (1.0E9d / d);
            this.f6530d = (this.f6529c * 80) / 100;
            return;
        }
        this.f6527a = null;
        this.f6529c = -1;
        this.f6530d = -1;
    }

    public C2280d(Context context) {
        this((double) C2280d.m7189a(context), true);
    }

    private static float m7189a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRefreshRate();
    }

    private static long m7190a(long j, long j2, long j3) {
        long j4;
        long j5 = (((j - j2) / j3) * j3) + j2;
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            j4 = j5;
            j5 += j3;
        }
        return j5 - j < j - j4 ? j5 : j4;
    }

    private boolean m7191b(long j, long j2) {
        return Math.abs((j2 - this.f6535i) - (j - this.f6536j)) > 20000000;
    }

    public long m7192a(long j, long j2) {
        long j3;
        long j4;
        long j5 = j * 1000;
        if (this.f6534h) {
            if (j != this.f6531e) {
                this.f6537k++;
                this.f6532f = this.f6533g;
            }
            if (this.f6537k >= 6) {
                j3 = this.f6532f + ((j5 - this.f6536j) / this.f6537k);
                if (m7191b(j3, j2)) {
                    this.f6534h = false;
                    j4 = j2;
                    j3 = j5;
                } else {
                    j4 = (this.f6535i + j3) - this.f6536j;
                }
                if (!this.f6534h) {
                    this.f6536j = j5;
                    this.f6535i = j2;
                    this.f6537k = 0;
                    this.f6534h = true;
                    m7195c();
                }
                this.f6531e = j;
                this.f6533g = j3;
                return (this.f6527a == null || this.f6527a.f6522a == 0) ? j4 : C2280d.m7190a(j4, this.f6527a.f6522a, this.f6529c) - this.f6530d;
            } else if (m7191b(j5, j2)) {
                this.f6534h = false;
            }
        }
        j4 = j2;
        j3 = j5;
        if (this.f6534h) {
            this.f6536j = j5;
            this.f6535i = j2;
            this.f6537k = 0;
            this.f6534h = true;
            m7195c();
        }
        this.f6531e = j;
        this.f6533g = j3;
        if (this.f6527a == null) {
            return j4;
        }
    }

    public void m7193a() {
        this.f6534h = false;
        if (this.f6528b) {
            this.f6527a.m7187b();
        }
    }

    public void m7194b() {
        if (this.f6528b) {
            this.f6527a.m7188c();
        }
    }

    protected void m7195c() {
    }
}
