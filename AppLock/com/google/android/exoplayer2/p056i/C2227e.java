package com.google.android.exoplayer2.p056i;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class C2227e implements C2222f {
    private final ContentResolver f6325a;
    private final C2233r<? super C2227e> f6326b;
    private Uri f6327c;
    private AssetFileDescriptor f6328d;
    private InputStream f6329e;
    private long f6330f;
    private boolean f6331g;

    public static class C2226a extends IOException {
        public C2226a(IOException iOException) {
            super(iOException);
        }
    }

    public C2227e(Context context, C2233r<? super C2227e> c2233r) {
        this.f6325a = context.getContentResolver();
        this.f6326b = c2233r;
    }

    public int mo3094a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.f6330f == 0) {
            return -1;
        }
        try {
            if (this.f6330f != -1) {
                i2 = (int) Math.min(this.f6330f, (long) i2);
            }
            int read = this.f6329e.read(bArr, i, i2);
            if (read != -1) {
                if (this.f6330f != -1) {
                    this.f6330f -= (long) read;
                }
                if (this.f6326b != null) {
                    this.f6326b.mo3104a((Object) this, read);
                }
                return read;
            } else if (this.f6330f == -1) {
                return -1;
            } else {
                throw new C2226a(new EOFException());
            }
        } catch (IOException e) {
            throw new C2226a(e);
        }
    }

    public long mo3095a(C2230h c2230h) {
        try {
            this.f6327c = c2230h.f6333a;
            this.f6328d = this.f6325a.openAssetFileDescriptor(this.f6327c, "r");
            this.f6329e = new FileInputStream(this.f6328d.getFileDescriptor());
            if (this.f6329e.skip(c2230h.f6336d) < c2230h.f6336d) {
                throw new EOFException();
            }
            if (c2230h.f6337e != -1) {
                this.f6330f = c2230h.f6337e;
            } else {
                this.f6330f = (long) this.f6329e.available();
                if (this.f6330f == 0) {
                    this.f6330f = -1;
                }
            }
            this.f6331g = true;
            if (this.f6326b != null) {
                this.f6326b.mo3105a((Object) this, c2230h);
            }
            return this.f6330f;
        } catch (IOException e) {
            throw new C2226a(e);
        }
    }

    public void mo3096a() {
        this.f6327c = null;
        try {
            if (this.f6329e != null) {
                this.f6329e.close();
            }
            this.f6329e = null;
            try {
                if (this.f6328d != null) {
                    this.f6328d.close();
                }
                this.f6328d = null;
                if (this.f6331g) {
                    this.f6331g = false;
                    if (this.f6326b != null) {
                        this.f6326b.mo3103a(this);
                    }
                }
            } catch (IOException e) {
                throw new C2226a(e);
            } catch (Throwable th) {
                this.f6328d = null;
                if (this.f6331g) {
                    this.f6331g = false;
                    if (this.f6326b != null) {
                        this.f6326b.mo3103a(this);
                    }
                }
            }
        } catch (IOException e2) {
            throw new C2226a(e2);
        } catch (Throwable th2) {
            this.f6329e = null;
            try {
                if (this.f6328d != null) {
                    this.f6328d.close();
                }
                this.f6328d = null;
                if (this.f6331g) {
                    this.f6331g = false;
                    if (this.f6326b != null) {
                        this.f6326b.mo3103a(this);
                    }
                }
            } catch (IOException e22) {
                throw new C2226a(e22);
            } catch (Throwable th3) {
                this.f6328d = null;
                if (this.f6331g) {
                    this.f6331g = false;
                    if (this.f6326b != null) {
                        this.f6326b.mo3103a(this);
                    }
                }
            }
        }
    }
}
