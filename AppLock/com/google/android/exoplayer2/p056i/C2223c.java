package com.google.android.exoplayer2.p056i;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class C2223c implements C2222f {
    private final AssetManager f6319a;
    private final C2233r<? super C2223c> f6320b;
    private Uri f6321c;
    private InputStream f6322d;
    private long f6323e;
    private boolean f6324f;

    public static final class C2221a extends IOException {
        public C2221a(IOException iOException) {
            super(iOException);
        }
    }

    public C2223c(Context context, C2233r<? super C2223c> c2233r) {
        this.f6319a = context.getAssets();
        this.f6320b = c2233r;
    }

    public int mo3094a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.f6323e == 0) {
            return -1;
        }
        try {
            if (this.f6323e != -1) {
                i2 = (int) Math.min(this.f6323e, (long) i2);
            }
            int read = this.f6322d.read(bArr, i, i2);
            if (read != -1) {
                if (this.f6323e != -1) {
                    this.f6323e -= (long) read;
                }
                if (this.f6320b != null) {
                    this.f6320b.mo3104a((Object) this, read);
                }
                return read;
            } else if (this.f6323e == -1) {
                return -1;
            } else {
                throw new C2221a(new EOFException());
            }
        } catch (IOException e) {
            throw new C2221a(e);
        }
    }

    public long mo3095a(C2230h c2230h) {
        try {
            this.f6321c = c2230h.f6333a;
            String path = this.f6321c.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            this.f6322d = this.f6319a.open(path, 1);
            if (this.f6322d.skip(c2230h.f6336d) < c2230h.f6336d) {
                throw new EOFException();
            }
            if (c2230h.f6337e != -1) {
                this.f6323e = c2230h.f6337e;
            } else {
                this.f6323e = (long) this.f6322d.available();
                if (this.f6323e == 2147483647L) {
                    this.f6323e = -1;
                }
            }
            this.f6324f = true;
            if (this.f6320b != null) {
                this.f6320b.mo3105a((Object) this, c2230h);
            }
            return this.f6323e;
        } catch (IOException e) {
            throw new C2221a(e);
        }
    }

    public void mo3096a() {
        this.f6321c = null;
        try {
            if (this.f6322d != null) {
                this.f6322d.close();
            }
            this.f6322d = null;
            if (this.f6324f) {
                this.f6324f = false;
                if (this.f6320b != null) {
                    this.f6320b.mo3103a(this);
                }
            }
        } catch (IOException e) {
            throw new C2221a(e);
        } catch (Throwable th) {
            this.f6322d = null;
            if (this.f6324f) {
                this.f6324f = false;
                if (this.f6320b != null) {
                    this.f6320b.mo3103a(this);
                }
            }
        }
    }
}
