package com.facebook.ads.internal.p030j.p032b;

import android.text.TextUtils;
import com.facebook.ads.internal.p030j.p032b.p033a.C1636b;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;

class C1649e extends C1648k {
    private final C1660h f4067a;
    private final C1636b f4068b;
    private C1645b f4069c;

    public C1649e(C1660h c1660h, C1636b c1636b) {
        super(c1660h, c1636b);
        this.f4068b = c1636b;
        this.f4067a = c1660h;
    }

    private void m4653a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[8192];
        while (true) {
            int a = m4648a(bArr, j, bArr.length);
            if (a != -1) {
                outputStream.write(bArr, 0, a);
                j += (long) a;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private boolean m4654a(C1647d c1647d) {
        int a = this.f4067a.mo2771a();
        boolean z = a > 0;
        int a2 = this.f4068b.mo2760a();
        if (z && c1647d.f4058c) {
            if (((float) c1647d.f4057b) > (((float) a) * 0.2f) + ((float) a2)) {
                return false;
            }
        }
        return true;
    }

    private String m4655b(C1647d c1647d) {
        int i = !TextUtils.isEmpty(this.f4067a.m4704c()) ? 1 : 0;
        int a = this.f4068b.mo2765d() ? this.f4068b.mo2760a() : this.f4067a.mo2771a();
        int i2 = a >= 0 ? 1 : 0;
        long j = c1647d.f4058c ? ((long) a) - c1647d.f4057b : (long) a;
        int i3 = (i2 == 0 || !c1647d.f4058c) ? 0 : 1;
        return (c1647d.f4058c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n") + "Accept-Ranges: bytes\n" + (i2 != 0 ? String.format("Content-Length: %d\n", new Object[]{Long.valueOf(j)}) : "") + (i3 != 0 ? String.format("Content-Range: bytes %d-%d/%d\n", new Object[]{Long.valueOf(c1647d.f4057b), Integer.valueOf(a - 1), Integer.valueOf(a)}) : "") + (i != 0 ? String.format("Content-Type: %s\n", new Object[]{r9}) : "") + "\n";
    }

    private void m4656b(OutputStream outputStream, long j) {
        try {
            C1660h c1660h = new C1660h(this.f4067a);
            c1660h.mo2773a((int) j);
            byte[] bArr = new byte[8192];
            while (true) {
                int a = c1660h.mo2772a(bArr);
                if (a == -1) {
                    break;
                }
                outputStream.write(bArr, 0, a);
                j += (long) a;
            }
            outputStream.flush();
        } finally {
            this.f4067a.mo2774b();
        }
    }

    protected void mo2769a(int i) {
        if (this.f4069c != null) {
            this.f4069c.mo2770a(this.f4068b.f4044a, this.f4067a.f4096a, i);
        }
    }

    public void m4658a(C1645b c1645b) {
        this.f4069c = c1645b;
    }

    public void m4659a(C1647d c1647d, Socket socket) {
        OutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(m4655b(c1647d).getBytes("UTF-8"));
        long j = c1647d.f4057b;
        if (m4654a(c1647d)) {
            m4653a(bufferedOutputStream, j);
        } else {
            m4656b(bufferedOutputStream, j);
        }
    }
}
