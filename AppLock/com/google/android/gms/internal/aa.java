package com.google.android.gms.internal;

import java.io.ByteArrayOutputStream;

public class aa extends ByteArrayOutputStream {
    private final abl f7609a;

    public aa(abl com_google_android_gms_internal_abl, int i) {
        this.f7609a = com_google_android_gms_internal_abl;
        this.buf = this.f7609a.m8770a(Math.max(i, 256));
    }

    private void m8382a(int i) {
        if (this.count + i > this.buf.length) {
            Object a = this.f7609a.m8770a((this.count + i) * 2);
            System.arraycopy(this.buf, 0, a, 0, this.count);
            this.f7609a.m8769a(this.buf);
            this.buf = a;
        }
    }

    public void close() {
        this.f7609a.m8769a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f7609a.m8769a(this.buf);
    }

    public synchronized void write(int i) {
        m8382a(1);
        super.write(i);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        m8382a(i2);
        super.write(bArr, i, i2);
    }
}
