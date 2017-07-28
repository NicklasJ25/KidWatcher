package com.google.android.gms.internal;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class kv {
    private BlockingQueue<ByteBuffer> f9678a;
    private final Random f9679b = new Random();
    private volatile boolean f9680c = false;
    private boolean f9681d = false;
    private kp f9682e;
    private WritableByteChannel f9683f;
    private final Thread f9684g = kp.m12218a().newThread(new C30361(this));

    class C30361 implements Runnable {
        final /* synthetic */ kv f9677a;

        C30361(kv kvVar) {
            this.f9677a = kvVar;
        }

        public void run() {
            this.f9677a.m12257e();
        }
    }

    kv(kp kpVar, String str, int i) {
        kp.m12222b().mo3704a(m12261b(), new StringBuilder(String.valueOf(str).length() + 18).append(str).append("Writer-").append(i).toString());
        this.f9682e = kpVar;
        this.f9678a = new LinkedBlockingQueue();
    }

    private void m12252a(kr krVar) {
        this.f9682e.m12228a(krVar);
    }

    private ByteBuffer m12254b(byte b, boolean z, byte[] bArr) {
        int i = 2;
        if (z) {
            i = 6;
        }
        int length = bArr.length;
        if (length >= TransportMediator.KEYCODE_MEDIA_PLAY) {
            i = length <= SupportMenu.USER_MASK ? i + 2 : i + 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i + bArr.length);
        allocate.put((byte) (b | -128));
        if (length < TransportMediator.KEYCODE_MEDIA_PLAY) {
            allocate.put((byte) (z ? length | 128 : length));
        } else if (length <= SupportMenu.USER_MASK) {
            allocate.put((byte) (z ? 254 : TransportMediator.KEYCODE_MEDIA_PLAY));
            allocate.putShort((short) length);
        } else {
            i = TransportMediator.KEYCODE_MEDIA_PAUSE;
            if (z) {
                i = 255;
            }
            allocate.put((byte) i);
            allocate.putInt(0);
            allocate.putInt(length);
        }
        if (z) {
            byte[] c = m12255c();
            allocate.put(c);
            for (i = 0; i < bArr.length; i++) {
                allocate.put((byte) (bArr[i] ^ c[i % 4]));
            }
        }
        allocate.flip();
        return allocate;
    }

    private byte[] m12255c() {
        byte[] bArr = new byte[4];
        this.f9679b.nextBytes(bArr);
        return bArr;
    }

    private void m12256d() {
        this.f9683f.write((ByteBuffer) this.f9678a.take());
    }

    private void m12257e() {
        while (!this.f9680c && !Thread.interrupted()) {
            try {
                m12256d();
            } catch (Throwable e) {
                m12252a(new kr("IO Exception", e));
                return;
            } catch (InterruptedException e2) {
                return;
            }
        }
        for (int i = 0; i < this.f9678a.size(); i++) {
            m12256d();
        }
    }

    void m12258a() {
        this.f9680c = true;
    }

    synchronized void m12259a(byte b, boolean z, byte[] bArr) {
        ByteBuffer b2 = m12254b(b, z, bArr);
        if (!this.f9680c || (!this.f9681d && b == (byte) 8)) {
            if (b == (byte) 8) {
                this.f9681d = true;
            }
            this.f9678a.add(b2);
        } else {
            throw new kr("Shouldn't be sending");
        }
    }

    void m12260a(OutputStream outputStream) {
        this.f9683f = Channels.newChannel(outputStream);
    }

    Thread m12261b() {
        return this.f9684g;
    }
}
