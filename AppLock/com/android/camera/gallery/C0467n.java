package com.android.camera.gallery;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.android.camera.C0390a;
import com.android.camera.C0487k;
import java.io.File;
import java.io.FileNotFoundException;

class C0467n implements C0450f {
    private final Uri f252a;
    private final C0382g f253b;
    private final ContentResolver f254c;

    C0467n(C0382g c0382g, ContentResolver contentResolver, Uri uri) {
        this.f253b = c0382g;
        this.f254c = contentResolver;
        this.f252a = uri;
    }

    private ParcelFileDescriptor m342g() {
        try {
            return this.f252a.getScheme().equals("file") ? ParcelFileDescriptor.open(new File(this.f252a.getPath()), 268435456) : this.f254c.openFileDescriptor(this.f252a, "r");
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private Options m343i() {
        ParcelFileDescriptor g = m342g();
        if (g == null) {
            return null;
        }
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            C0390a.m84a().m88a(g.getFileDescriptor(), options);
            return options;
        } finally {
            C0487k.m413a(g);
        }
    }

    public Bitmap m344a(int i, int i2, boolean z) {
        return m345a(i, i2, z, false);
    }

    public Bitmap m345a(int i, int i2, boolean z, boolean z2) {
        try {
            return C0487k.m403a(i, i2, m342g(), z2);
        } catch (Throwable e) {
            Log.e("UriImage", "got exception decoding bitmap ", e);
            return null;
        }
    }

    public Bitmap m346a(boolean z) {
        return m344a(320, 196608, z);
    }

    public String mo2082a() {
        return this.f252a.getPath();
    }

    public Uri mo2108b() {
        return this.f252a;
    }

    public long mo2084c() {
        return 0;
    }

    public int mo2085d() {
        return 0;
    }

    public String mo2088e() {
        return this.f252a.toString();
    }

    public Bitmap mo2089f() {
        return m346a(true);
    }

    public int getHeight() {
        Options i = m343i();
        return i != null ? i.outHeight : 0;
    }

    public String getMimeType() {
        Options i = m343i();
        return (i == null || i.outMimeType == null) ? "" : i.outMimeType;
    }

    public int getWidth() {
        Options i = m343i();
        return i != null ? i.outWidth : 0;
    }

    public String mo2099h() {
        return null;
    }
}
