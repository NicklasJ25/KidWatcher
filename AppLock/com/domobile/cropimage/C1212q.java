package com.domobile.cropimage;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;

class C1212q implements C1177f {
    private final Uri f2388a;
    private final C1175g f2389b;
    private final ContentResolver f2390c;

    C1212q(C1175g c1175g, ContentResolver contentResolver, Uri uri) {
        this.f2389b = c1175g;
        this.f2390c = contentResolver;
        this.f2388a = uri;
    }

    private ParcelFileDescriptor m2836b() {
        try {
            return this.f2388a.getScheme().equals("file") ? ParcelFileDescriptor.open(new File(this.f2388a.getPath()), 268435456) : this.f2390c.openFileDescriptor(this.f2388a, "r");
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public long mo2509a() {
        return 0;
    }

    public Bitmap mo2510a(int i, int i2) {
        return m2840a(i, i2, true, false);
    }

    public Bitmap m2839a(int i, int i2, boolean z) {
        return m2840a(i, i2, z, false);
    }

    public Bitmap m2840a(int i, int i2, boolean z, boolean z2) {
        try {
            return C1203k.m2810a(i, i2, m2836b(), z2);
        } catch (Throwable e) {
            Log.e("UriImage", "got exception decoding bitmap ", e);
            return null;
        }
    }

    public Bitmap mo2511a(boolean z) {
        return m2839a(320, 196608, z);
    }
}
