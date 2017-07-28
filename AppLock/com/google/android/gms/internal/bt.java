package com.google.android.gms.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.internal.bp.C2711a;
import com.google.android.gms.internal.bp.C2713c;
import com.google.android.gms.internal.bp.C2716f;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class bt {
    static boolean f8092a = false;
    static CountDownLatch f8093b = new CountDownLatch(1);
    private static MessageDigest f8094c = null;
    private static final Object f8095d = new Object();
    private static final Object f8096e = new Object();

    private static final class C2718a implements Runnable {
        private C2718a() {
        }

        public void run() {
            try {
                bt.f8094c = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
            } finally {
                bt.f8093b.countDown();
            }
        }
    }

    private static int m9197a(boolean z) {
        return z ? 239 : 255;
    }

    static C2711a m9198a(long j) {
        C2711a c2711a = new C2711a();
        c2711a.f8061t = Long.valueOf(j);
        return c2711a;
    }

    static String m9199a(C2711a c2711a, String str, boolean z) {
        return m9202a(mb.m9124a((mb) c2711a), str, z);
    }

    static String m9200a(String str, String str2, boolean z) {
        return m9201a(str, str2, z, ((Boolean) qb.bJ.m13225c()).booleanValue());
    }

    static String m9201a(String str, String str2, boolean z, boolean z2) {
        byte[] b = m9210b(str, str2, z, z2);
        return b != null ? br.m9193a(b, true) : Integer.toString(7);
    }

    static String m9202a(byte[] bArr, String str, boolean z) {
        return br.m9193a(z ? m9211b(bArr, str) : m9208a(bArr, str), true);
    }

    static Vector<byte[]> m9204a(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + i) - 1) / i;
        Vector<byte[]> vector = new Vector();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * i;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > i ? i3 + i : bArr.length));
                i2++;
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        return vector;
    }

    static void m9205a() {
        synchronized (f8096e) {
            if (!f8092a) {
                f8092a = true;
                new Thread(new C2718a()).start();
            }
        }
    }

    static void m9206a(String str, byte[] bArr) {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new lr(str.getBytes("UTF-8")).m12329a(bArr);
    }

    public static byte[] m9207a(byte[] bArr) {
        byte[] digest;
        synchronized (f8095d) {
            MessageDigest b = m9209b();
            if (b == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            b.reset();
            b.update(bArr);
            digest = f8094c.digest();
        }
        return digest;
    }

    static byte[] m9208a(byte[] bArr, String str) {
        Vector a = m9204a(bArr, 255);
        if (a == null || a.size() == 0) {
            return m9211b(mb.m9124a(m9198a((long) PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)), str);
        }
        mb c2716f = new C2716f();
        c2716f.f8082a = new byte[a.size()][];
        Iterator it = a.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            c2716f.f8082a[i] = m9212b((byte[]) it.next(), str, false);
            i = i2;
        }
        c2716f.f8083b = m9207a(bArr);
        return mb.m9124a(c2716f);
    }

    static MessageDigest m9209b() {
        m9205a();
        boolean z = false;
        try {
            z = f8093b.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        return (z && f8094c != null) ? f8094c : null;
    }

    static byte[] m9210b(String str, String str2, boolean z, boolean z2) {
        mb c2713c = new C2713c();
        try {
            c2713c.f8073a = str.length() < 3 ? str.getBytes("ISO-8859-1") : br.m9194a(str, true);
            byte[] bytes = z ? str2.length() < 3 ? str2.getBytes("ISO-8859-1") : br.m9194a(str2, true) : (str2 == null || str2.length() == 0) ? Integer.toString(5).getBytes("ISO-8859-1") : br.m9194a(m9202a(str2.getBytes("ISO-8859-1"), null, z2), true);
            c2713c.f8074b = bytes;
            return mb.m9124a(c2713c);
        } catch (UnsupportedEncodingException e) {
            return null;
        } catch (NoSuchAlgorithmException e2) {
            return null;
        }
    }

    static byte[] m9211b(byte[] bArr, String str) {
        return m9212b(bArr, str, true);
    }

    private static byte[] m9212b(byte[] bArr, String str, boolean z) {
        byte[] bArr2;
        byte[] array;
        int a = m9197a(z);
        if (bArr.length > a) {
            bArr = mb.m9124a(m9198a((long) PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
        }
        if (bArr.length < a) {
            bArr2 = new byte[(a - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(a + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(a + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            array = ByteBuffer.allocate(256).put(m9207a(array)).put(array).array();
        }
        bArr2 = new byte[256];
        new bu().m9226a(array, bArr2);
        if (str != null && str.length() > 0) {
            m9206a(str, bArr2);
        }
        return bArr2;
    }
}
