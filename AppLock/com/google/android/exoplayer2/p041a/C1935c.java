package com.google.android.exoplayer2.p041a;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p044b.C1956d;

public interface C1935c {

    public static final class C1934a {
        private final Handler f4993a;
        private final C1935c f4994b;

        public C1934a(Handler handler, C1935c c1935c) {
            this.f4993a = c1935c != null ? (Handler) C2252a.m7020a((Object) handler) : null;
            this.f4994b = c1935c;
        }

        public void m5508a(final int i) {
            if (this.f4994b != null) {
                this.f4993a.post(new Runnable(this) {
                    final /* synthetic */ C1934a f4992b;

                    public void run() {
                        this.f4992b.f4994b.mo3110a(i);
                    }
                });
            }
        }

        public void m5509a(int i, long j, long j2) {
            if (this.f4994b != null) {
                final int i2 = i;
                final long j3 = j;
                final long j4 = j2;
                this.f4993a.post(new Runnable(this) {
                    final /* synthetic */ C1934a f4988d;

                    public void run() {
                        this.f4988d.f4994b.mo3113a(i2, j3, j4);
                    }
                });
            }
        }

        public void m5510a(final Format format) {
            if (this.f4994b != null) {
                this.f4993a.post(new Runnable(this) {
                    final /* synthetic */ C1934a f4984b;

                    public void run() {
                        this.f4984b.f4994b.mo3121b(format);
                    }
                });
            }
        }

        public void m5511a(final C1956d c1956d) {
            if (this.f4994b != null) {
                this.f4993a.post(new Runnable(this) {
                    final /* synthetic */ C1934a f4978b;

                    public void run() {
                        this.f4978b.f4994b.mo3124c(c1956d);
                    }
                });
            }
        }

        public void m5512a(String str, long j, long j2) {
            if (this.f4994b != null) {
                final String str2 = str;
                final long j3 = j;
                final long j4 = j2;
                this.f4993a.post(new Runnable(this) {
                    final /* synthetic */ C1934a f4982d;

                    public void run() {
                        this.f4982d.f4994b.mo3123b(str2, j3, j4);
                    }
                });
            }
        }

        public void m5513b(final C1956d c1956d) {
            if (this.f4994b != null) {
                this.f4993a.post(new Runnable(this) {
                    final /* synthetic */ C1934a f4990b;

                    public void run() {
                        c1956d.m5705a();
                        this.f4990b.f4994b.mo3125d(c1956d);
                    }
                });
            }
        }
    }

    void mo3110a(int i);

    void mo3113a(int i, long j, long j2);

    void mo3121b(Format format);

    void mo3123b(String str, long j, long j2);

    void mo3124c(C1956d c1956d);

    void mo3125d(C1956d c1956d);
}
