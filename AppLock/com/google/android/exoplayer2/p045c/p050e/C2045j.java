package com.google.android.exoplayer2.p045c.p050e;

import com.google.android.exoplayer2.C1970k;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p045c.p050e.C2033h.C2041a;
import com.google.android.exoplayer2.p045c.p050e.C2050k.C2047b;
import com.google.android.exoplayer2.p045c.p050e.C2050k.C2048c;
import com.google.android.exoplayer2.p045c.p050e.C2050k.C2049d;
import java.util.ArrayList;
import java.util.List;

final class C2045j extends C2033h {
    private C2044a f5602a;
    private int f5603b;
    private boolean f5604c;
    private C2049d f5605d;
    private C2047b f5606e;

    static final class C2044a {
        public final C2049d f5597a;
        public final C2047b f5598b;
        public final byte[] f5599c;
        public final C2048c[] f5600d;
        public final int f5601e;

        public C2044a(C2049d c2049d, C2047b c2047b, byte[] bArr, C2048c[] c2048cArr, int i) {
            this.f5597a = c2049d;
            this.f5598b = c2047b;
            this.f5599c = bArr;
            this.f5600d = c2048cArr;
            this.f5601e = i;
        }
    }

    C2045j() {
    }

    static int m6139a(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    private static int m6140a(byte b, C2044a c2044a) {
        return !c2044a.f5600d[C2045j.m6139a(b, c2044a.f5601e, 1)].f5615a ? c2044a.f5597a.f5625g : c2044a.f5597a.f5626h;
    }

    static void m6141a(C2263k c2263k, long j) {
        c2263k.m7071b(c2263k.m7072c() + 4);
        c2263k.f6454a[c2263k.m7072c() - 4] = (byte) ((int) (j & 255));
        c2263k.f6454a[c2263k.m7072c() - 3] = (byte) ((int) ((j >>> 8) & 255));
        c2263k.f6454a[c2263k.m7072c() - 2] = (byte) ((int) ((j >>> 16) & 255));
        c2263k.f6454a[c2263k.m7072c() - 1] = (byte) ((int) ((j >>> 24) & 255));
    }

    public static boolean m6142a(C2263k c2263k) {
        try {
            return C2050k.m6152a(1, c2263k, true);
        } catch (C1970k e) {
            return false;
        }
    }

    protected void mo2983a(boolean z) {
        super.mo2983a(z);
        if (z) {
            this.f5602a = null;
            this.f5605d = null;
            this.f5606e = null;
        }
        this.f5603b = 0;
        this.f5604c = false;
    }

    protected boolean mo2984a(C2263k c2263k, long j, C2041a c2041a) {
        if (this.f5602a != null) {
            return false;
        }
        this.f5602a = m6146c(c2263k);
        if (this.f5602a == null) {
            return true;
        }
        List arrayList = new ArrayList();
        arrayList.add(this.f5602a.f5597a.f5628j);
        arrayList.add(this.f5602a.f5599c);
        c2041a.f5591a = Format.m5480a(null, "audio/vorbis", null, this.f5602a.f5597a.f5623e, 65025, this.f5602a.f5597a.f5620b, (int) this.f5602a.f5597a.f5621c, arrayList, null, 0, null);
        return true;
    }

    protected long mo2985b(C2263k c2263k) {
        int i = 0;
        if ((c2263k.f6454a[0] & 1) == 1) {
            return -1;
        }
        int a = C2045j.m6140a(c2263k.f6454a[0], this.f5602a);
        if (this.f5604c) {
            i = (this.f5603b + a) / 4;
        }
        C2045j.m6141a(c2263k, (long) i);
        this.f5604c = true;
        this.f5603b = a;
        return (long) i;
    }

    C2044a m6146c(C2263k c2263k) {
        if (this.f5605d == null) {
            this.f5605d = C2050k.m6150a(c2263k);
            return null;
        } else if (this.f5606e == null) {
            this.f5606e = C2050k.m6155b(c2263k);
            return null;
        } else {
            Object obj = new byte[c2263k.m7072c()];
            System.arraycopy(c2263k.f6454a, 0, obj, 0, c2263k.m7072c());
            C2048c[] a = C2050k.m6154a(c2263k, this.f5605d.f5620b);
            return new C2044a(this.f5605d, this.f5606e, obj, a, C2050k.m6148a(a.length - 1));
        }
    }

    protected void mo2986d(long j) {
        int i = 0;
        super.mo2986d(j);
        this.f5604c = j != 0;
        if (this.f5605d != null) {
            i = this.f5605d.f5625g;
        }
        this.f5603b = i;
    }
}
