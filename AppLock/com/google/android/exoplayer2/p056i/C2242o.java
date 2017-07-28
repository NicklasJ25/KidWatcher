package com.google.android.exoplayer2.p056i;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class C2242o implements C2222f {
    private final C2233r<? super C2242o> f6392a;
    private RandomAccessFile f6393b;
    private Uri f6394c;
    private long f6395d;
    private boolean f6396e;

    public static class C2241a extends IOException {
        public C2241a(IOException iOException) {
            super(iOException);
        }
    }

    public C2242o() {
        this(null);
    }

    public C2242o(C2233r<? super C2242o> c2233r) {
        this.f6392a = c2233r;
    }

    public int mo3094a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.f6395d == 0) {
            return -1;
        }
        try {
            int read = this.f6393b.read(bArr, i, (int) Math.min(this.f6395d, (long) i2));
            if (read <= 0) {
                return read;
            }
            this.f6395d -= (long) read;
            if (this.f6392a == null) {
                return read;
            }
            this.f6392a.mo3104a((Object) this, read);
            return read;
        } catch (IOException e) {
            throw new C2241a(e);
        }
    }

    public long mo3095a(C2230h c2230h) {
        try {
            this.f6394c = c2230h.f6333a;
            this.f6393b = new RandomAccessFile(c2230h.f6333a.getPath(), "r");
            this.f6393b.seek(c2230h.f6336d);
            this.f6395d = c2230h.f6337e == -1 ? this.f6393b.length() - c2230h.f6336d : c2230h.f6337e;
            if (this.f6395d < 0) {
                throw new EOFException();
            }
            this.f6396e = true;
            if (this.f6392a != null) {
                this.f6392a.mo3105a((Object) this, c2230h);
            }
            return this.f6395d;
        } catch (IOException e) {
            throw new C2241a(e);
        }
    }

    public void mo3096a() {
        this.f6394c = null;
        try {
            if (this.f6393b != null) {
                this.f6393b.close();
            }
            this.f6393b = null;
            if (this.f6396e) {
                this.f6396e = false;
                if (this.f6392a != null) {
                    this.f6392a.mo3103a(this);
                }
            }
        } catch (IOException e) {
            throw new C2241a(e);
        } catch (Throwable th) {
            this.f6393b = null;
            if (this.f6396e) {
                this.f6396e = false;
                if (this.f6392a != null) {
                    this.f6392a.mo3103a(this);
                }
            }
        }
    }
}
