package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class lu {
    private final ByteBuffer f9734a;

    public static class C3045a extends IOException {
        C3045a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private lu(ByteBuffer byteBuffer) {
        this.f9734a = byteBuffer;
        this.f9734a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private lu(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int m12362a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < '') {
            i++;
        }
        int i2 = i;
        i = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt >= 'ࠀ') {
                i += m12363a(charSequence, i2);
                break;
            }
            i2++;
            i = ((127 - charAt) >>> 31) + i;
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
    }

    private static int m12363a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < 'ࠀ') {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if ('?' <= charAt && charAt <= '?') {
                    if (Character.codePointAt(charSequence, i3) < 65536) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    private static int m12364a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= '') {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '' && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < 'ࠀ' && i5 <= i4 - 2) {
                r6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = r6 + 1;
                bArr[r6] = (byte) ((charAt2 & 63) | 128);
            } else if ((charAt2 < '?' || '?' < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | 128);
                        r6 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | 128);
                        i6 = r6 + 1;
                        bArr[r6] = (byte) ((toCodePoint & 63) | 128);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    public static lu m12365a(byte[] bArr) {
        return m12366a(bArr, 0, bArr.length);
    }

    public static lu m12366a(byte[] bArr, int i, int i2) {
        return new lu(bArr, i, i2);
    }

    private static void m12367a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(m12364a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            m12377b(charSequence, byteBuffer);
        }
    }

    public static int m12368b(int i) {
        return i >= 0 ? m12387f(i) : 10;
    }

    public static int m12369b(int i, double d) {
        return m12381d(i) + 8;
    }

    public static int m12370b(int i, float f) {
        return m12381d(i) + 4;
    }

    public static int m12371b(int i, int i2) {
        return m12381d(i) + m12368b(i2);
    }

    public static int m12372b(int i, mb mbVar) {
        return (m12381d(i) * 2) + m12379c(mbVar);
    }

    public static int m12373b(int i, String str) {
        return m12381d(i) + m12376b(str);
    }

    public static int m12374b(int i, boolean z) {
        return m12381d(i) + 1;
    }

    public static int m12375b(int i, byte[] bArr) {
        return m12381d(i) + m12380c(bArr);
    }

    public static int m12376b(String str) {
        int a = m12362a((CharSequence) str);
        return a + m12387f(a);
    }

    private static void m12377b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 'ࠀ') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else if (charAt < '?' || '?' < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((toCodePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    public static int m12378c(int i, mb mbVar) {
        return m12381d(i) + m12384d(mbVar);
    }

    public static int m12379c(mb mbVar) {
        return mbVar.m9131g();
    }

    public static int m12380c(byte[] bArr) {
        return m12387f(bArr.length) + bArr.length;
    }

    public static int m12381d(int i) {
        return m12387f(me.m12505a(i, 0));
    }

    public static int m12382d(int i, long j) {
        return m12381d(i) + m12383d(j);
    }

    public static int m12383d(long j) {
        return m12390h(j);
    }

    public static int m12384d(mb mbVar) {
        int g = mbVar.m9131g();
        return g + m12387f(g);
    }

    public static int m12385e(int i, long j) {
        return m12381d(i) + m12386e(j);
    }

    public static int m12386e(long j) {
        return m12390h(j);
    }

    public static int m12387f(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int m12388f(int i, long j) {
        return m12381d(i) + m12389f(j);
    }

    public static int m12389f(long j) {
        return m12390h(m12391j(j));
    }

    public static int m12390h(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static long m12391j(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public int m12392a() {
        return this.f9734a.remaining();
    }

    public void m12393a(byte b) {
        if (this.f9734a.hasRemaining()) {
            this.f9734a.put(b);
            return;
        }
        throw new C3045a(this.f9734a.position(), this.f9734a.limit());
    }

    public void m12394a(double d) {
        m12423i(Double.doubleToLongBits(d));
    }

    public void m12395a(float f) {
        m12421g(Float.floatToIntBits(f));
    }

    public void m12396a(int i) {
        if (i >= 0) {
            m12420e(i);
        } else {
            m12422g((long) i);
        }
    }

    public void m12397a(int i, double d) {
        m12416c(i, 1);
        m12394a(d);
    }

    public void m12398a(int i, float f) {
        m12416c(i, 5);
        m12395a(f);
    }

    public void m12399a(int i, int i2) {
        m12416c(i, 0);
        m12396a(i2);
    }

    public void m12400a(int i, long j) {
        m12416c(i, 0);
        m12405a(j);
    }

    public void m12401a(int i, mb mbVar) {
        m12416c(i, 2);
        m12412b(mbVar);
    }

    public void m12402a(int i, String str) {
        m12416c(i, 2);
        m12407a(str);
    }

    public void m12403a(int i, boolean z) {
        m12416c(i, 0);
        m12408a(z);
    }

    public void m12404a(int i, byte[] bArr) {
        m12416c(i, 2);
        m12413b(bArr);
    }

    public void m12405a(long j) {
        m12422g(j);
    }

    public void m12406a(mb mbVar) {
        mbVar.mo3506a(this);
    }

    public void m12407a(String str) {
        try {
            int f = m12387f(str.length());
            if (f == m12387f(str.length() * 3)) {
                int position = this.f9734a.position();
                if (this.f9734a.remaining() < f) {
                    throw new C3045a(f + position, this.f9734a.limit());
                }
                this.f9734a.position(position + f);
                m12367a((CharSequence) str, this.f9734a);
                int position2 = this.f9734a.position();
                this.f9734a.position(position);
                m12420e((position2 - position) - f);
                this.f9734a.position(position2);
                return;
            }
            m12420e(m12362a((CharSequence) str));
            m12367a((CharSequence) str, this.f9734a);
        } catch (Throwable e) {
            C3045a c3045a = new C3045a(this.f9734a.position(), this.f9734a.limit());
            c3045a.initCause(e);
            throw c3045a;
        }
    }

    public void m12408a(boolean z) {
        m12415c(z ? 1 : 0);
    }

    public void m12409b() {
        if (m12392a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void m12410b(int i, long j) {
        m12416c(i, 0);
        m12411b(j);
    }

    public void m12411b(long j) {
        m12422g(j);
    }

    public void m12412b(mb mbVar) {
        m12420e(mbVar.m9130f());
        mbVar.mo3506a(this);
    }

    public void m12413b(byte[] bArr) {
        m12420e(bArr.length);
        m12419d(bArr);
    }

    public void m12414b(byte[] bArr, int i, int i2) {
        if (this.f9734a.remaining() >= i2) {
            this.f9734a.put(bArr, i, i2);
            return;
        }
        throw new C3045a(this.f9734a.position(), this.f9734a.limit());
    }

    public void m12415c(int i) {
        m12393a((byte) i);
    }

    public void m12416c(int i, int i2) {
        m12420e(me.m12505a(i, i2));
    }

    public void m12417c(int i, long j) {
        m12416c(i, 0);
        m12418c(j);
    }

    public void m12418c(long j) {
        m12422g(m12391j(j));
    }

    public void m12419d(byte[] bArr) {
        m12414b(bArr, 0, bArr.length);
    }

    public void m12420e(int i) {
        while ((i & -128) != 0) {
            m12415c((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        m12415c(i);
    }

    public void m12421g(int i) {
        if (this.f9734a.remaining() < 4) {
            throw new C3045a(this.f9734a.position(), this.f9734a.limit());
        }
        this.f9734a.putInt(i);
    }

    public void m12422g(long j) {
        while ((-128 & j) != 0) {
            m12415c((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        m12415c((int) j);
    }

    public void m12423i(long j) {
        if (this.f9734a.remaining() < 8) {
            throw new C3045a(this.f9734a.position(), this.f9734a.limit());
        }
        this.f9734a.putLong(j);
    }
}
