package com.facebook.ads.internal.p030j.p032b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.ads.internal.p030j.p032b.p033a.C1636b;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

final class C1658g {
    private final AtomicInteger f4090a = new AtomicInteger(0);
    private final String f4091b;
    private volatile C1649e f4092c;
    private final List<C1645b> f4093d = new CopyOnWriteArrayList();
    private final C1645b f4094e;
    private final C1646c f4095f;

    private static final class C1657a extends Handler implements C1645b {
        private final String f4088a;
        private final List<C1645b> f4089b;

        public C1657a(String str, List<C1645b> list) {
            super(Looper.getMainLooper());
            this.f4088a = str;
            this.f4089b = list;
        }

        public void mo2770a(File file, String str, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        public void handleMessage(Message message) {
            for (C1645b a : this.f4089b) {
                a.mo2770a((File) message.obj, this.f4088a, message.arg1);
            }
        }
    }

    public C1658g(String str, C1646c c1646c) {
        this.f4091b = (String) C1663j.m4705a(str);
        this.f4095f = (C1646c) C1663j.m4705a(c1646c);
        this.f4094e = new C1657a(str, this.f4093d);
    }

    private synchronized void m4687c() {
        this.f4092c = this.f4092c == null ? m4689e() : this.f4092c;
    }

    private synchronized void m4688d() {
        if (this.f4090a.decrementAndGet() <= 0) {
            this.f4092c.m4649a();
            this.f4092c = null;
        }
    }

    private C1649e m4689e() {
        C1649e c1649e = new C1649e(new C1660h(this.f4091b), new C1636b(this.f4095f.m4635a(this.f4091b), this.f4095f.f4053c));
        c1649e.m4658a(this.f4094e);
        return c1649e;
    }

    public void m4690a() {
        this.f4093d.clear();
        if (this.f4092c != null) {
            this.f4092c.m4658a(null);
            this.f4092c.m4649a();
            this.f4092c = null;
        }
        this.f4090a.set(0);
    }

    public void m4691a(C1647d c1647d, Socket socket) {
        m4687c();
        try {
            this.f4090a.incrementAndGet();
            this.f4092c.m4659a(c1647d, socket);
        } finally {
            m4688d();
        }
    }

    public int m4692b() {
        return this.f4090a.get();
    }
}
