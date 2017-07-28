package com.google.android.exoplayer2.p045c.p047b;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.C1985g;

final class C1983e {
    private final C2263k f5267a = new C2263k(8);
    private int f5268b;

    private long m5841b(C1985g c1985g) {
        int i = 0;
        c1985g.mo2969c(this.f5267a.f6454a, 0, 1);
        int i2 = this.f5267a.f6454a[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i4++;
            i3 >>= 1;
        }
        i3 = (i3 ^ -1) & i2;
        c1985g.mo2969c(this.f5267a.f6454a, 1, i4);
        while (i < i4) {
            i3 = (i3 << 8) + (this.f5267a.f6454a[i + 1] & 255);
            i++;
        }
        this.f5268b += i4 + 1;
        return (long) i3;
    }

    public boolean m5842a(C1985g c1985g) {
        long d = c1985g.mo2970d();
        long j = (d == -1 || d > PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) ? PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID : d;
        int i = (int) j;
        c1985g.mo2969c(this.f5267a.f6454a, 0, 4);
        j = this.f5267a.m7084l();
        this.f5268b = 4;
        while (j != 440786851) {
            int i2 = this.f5268b + 1;
            this.f5268b = i2;
            if (i2 == i) {
                return false;
            }
            c1985g.mo2969c(this.f5267a.f6454a, 0, 1);
            j = ((j << 8) & -256) | ((long) (this.f5267a.f6454a[0] & 255));
        }
        j = m5841b(c1985g);
        long j2 = (long) this.f5268b;
        if (j == Long.MIN_VALUE) {
            return false;
        }
        if (d != -1 && j2 + j >= d) {
            return false;
        }
        while (((long) this.f5268b) < j2 + j) {
            if (m5841b(c1985g) == Long.MIN_VALUE) {
                return false;
            }
            d = m5841b(c1985g);
            if (d < 0 || d > 2147483647L) {
                return false;
            }
            if (d != 0) {
                c1985g.mo2968c((int) d);
                this.f5268b = (int) (d + ((long) this.f5268b));
            }
        }
        return ((long) this.f5268b) == j + j2;
    }
}
