package com.google.android.exoplayer2.p045c.p050e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2263k;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.p050e.C2033h.C2041a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class C2039g extends C2033h {
    private static final int f5588a = C2273r.m7142e("Opus");
    private static final byte[] f5589b = new byte[]{(byte) 79, (byte) 112, (byte) 117, (byte) 115, (byte) 72, (byte) 101, (byte) 97, (byte) 100};
    private boolean f5590c;

    C2039g() {
    }

    private long m6127a(byte[] bArr) {
        int i;
        int i2 = bArr[0] & 255;
        switch (i2 & 3) {
            case 0:
                i = 1;
                break;
            case 1:
            case 2:
                i = 2;
                break;
            default:
                i = bArr[1] & 63;
                break;
        }
        int i3 = i2 >> 3;
        i2 = i3 & 3;
        i3 = i3 >= 16 ? 2500 << i2 : i3 >= 12 ? 10000 << (i2 & 1) : i2 == 3 ? 60000 : 10000 << i2;
        return (long) (i3 * i);
    }

    private void m6128a(List<byte[]> list, int i) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) i) * 1000000000) / 48000).array());
    }

    public static boolean m6129a(C2263k c2263k) {
        if (c2263k.m7070b() < f5589b.length) {
            return false;
        }
        byte[] bArr = new byte[f5589b.length];
        c2263k.m7069a(bArr, 0, f5589b.length);
        return Arrays.equals(bArr, f5589b);
    }

    protected void mo2983a(boolean z) {
        super.mo2983a(z);
        if (z) {
            this.f5590c = false;
        }
    }

    protected boolean mo2984a(C2263k c2263k, long j, C2041a c2041a) {
        if (this.f5590c) {
            boolean z = c2263k.m7086n() == f5588a;
            c2263k.m7073c(0);
            return z;
        }
        Object copyOf = Arrays.copyOf(c2263k.f6454a, c2263k.m7072c());
        int i = copyOf[9] & 255;
        int i2 = ((copyOf[11] & 255) << 8) | (copyOf[10] & 255);
        List arrayList = new ArrayList(3);
        arrayList.add(copyOf);
        m6128a(arrayList, i2);
        m6128a(arrayList, 3840);
        c2041a.f5591a = Format.m5480a(null, "audio/opus", null, -1, -1, i, 48000, arrayList, null, 0, "und");
        this.f5590c = true;
        return true;
    }

    protected long mo2985b(C2263k c2263k) {
        return m6105c(m6127a(c2263k.f6454a));
    }
}
