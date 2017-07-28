package com.google.android.exoplayer2.p056i;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2269o;
import com.google.android.exoplayer2.p056i.C2225d.C2224a;

public final class C2234j implements C2225d, C2233r<Object> {
    private final Handler f6352a;
    private final C2224a f6353b;
    private final C2269o f6354c;
    private int f6355d;
    private long f6356e;
    private long f6357f;
    private long f6358g;
    private long f6359h;
    private long f6360i;

    public C2234j() {
        this(null, null);
    }

    public C2234j(Handler handler, C2224a c2224a) {
        this(handler, c2224a, 2000);
    }

    public C2234j(Handler handler, C2224a c2224a, int i) {
        this.f6352a = handler;
        this.f6353b = c2224a;
        this.f6354c = new C2269o(i);
        this.f6360i = -1;
    }

    private void m6973a(int i, long j, long j2) {
        if (this.f6352a != null && this.f6353b != null) {
            final int i2 = i;
            final long j3 = j;
            final long j4 = j2;
            this.f6352a.post(new Runnable(this) {
                final /* synthetic */ C2234j f6351d;

                public void run() {
                    this.f6351d.f6353b.m6955a(i2, j3, j4);
                }
            });
        }
    }

    public synchronized long mo3102a() {
        return this.f6360i;
    }

    public synchronized void mo3103a(Object obj) {
        C2252a.m7024b(this.f6355d > 0);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = (int) (elapsedRealtime - this.f6356e);
        this.f6358g += (long) i;
        this.f6359h += this.f6357f;
        if (i > 0) {
            this.f6354c.m7114a((int) Math.sqrt((double) this.f6357f), (float) ((this.f6357f * 8000) / ((long) i)));
            if (this.f6358g >= 2000 || this.f6359h >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                float a = this.f6354c.m7113a(0.5f);
                this.f6360i = Float.isNaN(a) ? -1 : (long) a;
            }
        }
        m6973a(i, this.f6357f, this.f6360i);
        int i2 = this.f6355d - 1;
        this.f6355d = i2;
        if (i2 > 0) {
            this.f6356e = elapsedRealtime;
        }
        this.f6357f = 0;
    }

    public synchronized void mo3104a(Object obj, int i) {
        this.f6357f += (long) i;
    }

    public synchronized void mo3105a(Object obj, C2230h c2230h) {
        if (this.f6355d == 0) {
            this.f6356e = SystemClock.elapsedRealtime();
        }
        this.f6355d++;
    }
}
