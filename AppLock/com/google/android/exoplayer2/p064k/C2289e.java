package com.google.android.exoplayer2.p064k;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p044b.C1956d;

public interface C2289e {

    public static final class C2288a {
        private final Handler f6558a;
        private final C2289e f6559b;

        public C2288a(Handler handler, C2289e c2289e) {
            this.f6558a = c2289e != null ? (Handler) C2252a.m7020a((Object) handler) : null;
            this.f6559b = c2289e;
        }

        public void m7197a(int i, int i2, int i3, float f) {
            if (this.f6559b != null) {
                final int i4 = i;
                final int i5 = i2;
                final int i6 = i3;
                final float f2 = f;
                this.f6558a.post(new Runnable(this) {
                    final /* synthetic */ C2288a f6553e;

                    public void run() {
                        this.f6553e.f6559b.mo3111a(i4, i5, i6, f2);
                    }
                });
            }
        }

        public void m7198a(final int i, final long j) {
            if (this.f6559b != null) {
                this.f6558a.post(new Runnable(this) {
                    final /* synthetic */ C2288a f6548c;

                    public void run() {
                        this.f6548c.f6559b.mo3112a(i, j);
                    }
                });
            }
        }

        public void m7199a(final Surface surface) {
            if (this.f6559b != null) {
                this.f6558a.post(new Runnable(this) {
                    final /* synthetic */ C2288a f6555b;

                    public void run() {
                        this.f6555b.f6559b.mo3114a(surface);
                    }
                });
            }
        }

        public void m7200a(final Format format) {
            if (this.f6559b != null) {
                this.f6558a.post(new Runnable(this) {
                    final /* synthetic */ C2288a f6545b;

                    public void run() {
                        this.f6545b.f6559b.mo3115a(format);
                    }
                });
            }
        }

        public void m7201a(final C1956d c1956d) {
            if (this.f6559b != null) {
                this.f6558a.post(new Runnable(this) {
                    final /* synthetic */ C2288a f6539b;

                    public void run() {
                        this.f6539b.f6559b.mo3116a(c1956d);
                    }
                });
            }
        }

        public void m7202a(String str, long j, long j2) {
            if (this.f6559b != null) {
                final String str2 = str;
                final long j3 = j;
                final long j4 = j2;
                this.f6558a.post(new Runnable(this) {
                    final /* synthetic */ C2288a f6543d;

                    public void run() {
                        this.f6543d.f6559b.mo3119a(str2, j3, j4);
                    }
                });
            }
        }

        public void m7203b(final C1956d c1956d) {
            if (this.f6559b != null) {
                this.f6558a.post(new Runnable(this) {
                    final /* synthetic */ C2288a f6557b;

                    public void run() {
                        c1956d.m5705a();
                        this.f6557b.f6559b.mo3122b(c1956d);
                    }
                });
            }
        }
    }

    void mo3111a(int i, int i2, int i3, float f);

    void mo3112a(int i, long j);

    void mo3114a(Surface surface);

    void mo3115a(Format format);

    void mo3116a(C1956d c1956d);

    void mo3119a(String str, long j, long j2);

    void mo3122b(C1956d c1956d);
}
