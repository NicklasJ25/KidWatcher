package com.google.android.gms.internal;

import com.google.android.gms.internal.kn.C3027b;
import java.io.DataInputStream;
import java.net.SocketTimeoutException;

class ku {
    private DataInputStream f9671a = null;
    private kp f9672b = null;
    private kq f9673c = null;
    private byte[] f9674d = new byte[112];
    private C3027b f9675e;
    private volatile boolean f9676f = false;

    ku(kp kpVar) {
        this.f9672b = kpVar;
    }

    private int m12244a(byte[] bArr, int i, int i2) {
        this.f9671a.readFully(bArr, i, i2);
        return i2;
    }

    private long m12245a(byte[] bArr, int i) {
        return (((((((((long) bArr[i + 0]) << 56) + (((long) (bArr[i + 1] & 255)) << 48)) + (((long) (bArr[i + 2] & 255)) << 40)) + (((long) (bArr[i + 3] & 255)) << 32)) + (((long) (bArr[i + 4] & 255)) << 24)) + ((long) ((bArr[i + 5] & 255) << 16))) + ((long) ((bArr[i + 6] & 255) << 8))) + ((long) ((bArr[i + 7] & 255) << 0));
    }

    private void m12246a(kr krVar) {
        m12251b();
        this.f9672b.m12228a(krVar);
    }

    private void m12247a(boolean z, byte b, byte[] bArr) {
        if (b == (byte) 9) {
            if (z) {
                m12248a(bArr);
                return;
            }
            throw new kr("PING must not fragment across frames");
        } else if (this.f9675e != null && b != (byte) 0) {
            throw new kr("Failed to continue outstanding frame");
        } else if (this.f9675e == null && b == (byte) 0) {
            throw new kr("Received continuing frame, but there's nothing to continue");
        } else {
            if (this.f9675e == null) {
                this.f9675e = kn.m12216a(b);
            }
            if (!this.f9675e.mo3814a(bArr)) {
                throw new kr("Failed to decode frame");
            } else if (z) {
                kt a = this.f9675e.mo3813a();
                this.f9675e = null;
                this.f9673c.mo3692a(a);
            }
        }
    }

    private void m12248a(byte[] bArr) {
        if (bArr.length <= 125) {
            this.f9672b.m12230a(bArr);
            return;
        }
        throw new kr("PING frame too long");
    }

    void m12249a() {
        this.f9673c = this.f9672b.m12231c();
        while (!this.f9676f) {
            try {
                int a = m12244a(this.f9674d, 0, 1) + 0;
                boolean z = (this.f9674d[0] & 128) != 0;
                if (((this.f9674d[0] & 112) != 0 ? 1 : null) != null) {
                    throw new kr("Invalid frame received");
                }
                byte b = (byte) (this.f9674d[0] & 15);
                int a2 = a + m12244a(this.f9674d, a, 1);
                byte b2 = this.f9674d[1];
                long j = 0;
                if (b2 < (byte) 126) {
                    j = (long) b2;
                } else if (b2 == (byte) 126) {
                    m12244a(this.f9674d, a2, 2);
                    j = (long) (((this.f9674d[2] & 255) << 8) | (this.f9674d[3] & 255));
                } else if (b2 == Byte.MAX_VALUE) {
                    j = m12245a(this.f9674d, (m12244a(this.f9674d, a2, 8) + a2) - 8);
                }
                byte[] bArr = new byte[((int) j)];
                m12244a(bArr, 0, (int) j);
                if (b == (byte) 8) {
                    this.f9672b.m12234f();
                } else if (b == (byte) 10) {
                    continue;
                } else if (b == (byte) 1 || b == (byte) 2 || b == (byte) 9 || b == (byte) 0) {
                    m12247a(z, b, bArr);
                } else {
                    throw new kr("Unsupported opcode: " + b);
                }
            } catch (SocketTimeoutException e) {
            } catch (Throwable e2) {
                m12246a(new kr("IO Error", e2));
            } catch (kr e3) {
                m12246a(e3);
            }
        }
    }

    void m12250a(DataInputStream dataInputStream) {
        this.f9671a = dataInputStream;
    }

    void m12251b() {
        this.f9676f = true;
    }
}
