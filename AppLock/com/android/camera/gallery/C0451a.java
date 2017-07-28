package com.android.camera.gallery;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.util.Log;
import com.android.camera.C0390a;
import com.android.camera.C0487k;
import com.android.gallery3d.data.DownloadEntry.Columns;
import com.domobile.frame.p000a.C1147a;

public abstract class C0451a implements C0450f {
    protected ContentResolver f199a;
    protected Uri f200b;
    protected long f201c;
    protected String f202d;
    protected final int f203e;
    protected String f204f;
    protected C0452b f205g;
    private final long f206h;
    private String f207i;
    private int f208j = -1;
    private int f209k = -1;

    protected C0451a(C0452b c0452b, ContentResolver contentResolver, long j, int i, Uri uri, String str, String str2, long j2, String str3) {
        this.f205g = c0452b;
        this.f199a = contentResolver;
        this.f201c = j;
        this.f203e = i;
        this.f200b = uri;
        this.f202d = str;
        this.f204f = str2;
        this.f206h = j2;
        this.f207i = str3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m292i() {
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.f199a;	 Catch:{ FileNotFoundException -> 0x002a, all -> 0x0035 }
        r2 = r5.f200b;	 Catch:{ FileNotFoundException -> 0x002a, all -> 0x0035 }
        r3 = "r";
        r0 = r1.openFileDescriptor(r2, r3);	 Catch:{ FileNotFoundException -> 0x002a, all -> 0x0035 }
        r1 = new android.graphics.BitmapFactory$Options;	 Catch:{ FileNotFoundException -> 0x002a }
        r1.<init>();	 Catch:{ FileNotFoundException -> 0x002a }
        r2 = 1;
        r1.inJustDecodeBounds = r2;	 Catch:{ FileNotFoundException -> 0x002a }
        r2 = com.android.camera.C0390a.m84a();	 Catch:{ FileNotFoundException -> 0x002a }
        r3 = r0.getFileDescriptor();	 Catch:{ FileNotFoundException -> 0x002a }
        r2.m88a(r3, r1);	 Catch:{ FileNotFoundException -> 0x002a }
        r2 = r1.outWidth;	 Catch:{ FileNotFoundException -> 0x002a }
        r5.f208j = r2;	 Catch:{ FileNotFoundException -> 0x002a }
        r1 = r1.outHeight;	 Catch:{ FileNotFoundException -> 0x002a }
        r5.f209k = r1;	 Catch:{ FileNotFoundException -> 0x002a }
        com.android.camera.C0487k.m413a(r0);
    L_0x0029:
        return;
    L_0x002a:
        r1 = move-exception;
        r1 = 0;
        r5.f208j = r1;	 Catch:{ all -> 0x003d }
        r1 = 0;
        r5.f209k = r1;	 Catch:{ all -> 0x003d }
        com.android.camera.C0487k.m413a(r0);
        goto L_0x0029;
    L_0x0035:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0039:
        com.android.camera.C0487k.m413a(r1);
        throw r0;
    L_0x003d:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.camera.gallery.a.i():void");
    }

    public String mo2082a() {
        return this.f202d;
    }

    public Uri mo2108b() {
        return this.f200b;
    }

    public long mo2084c() {
        return this.f206h;
    }

    public int mo2085d() {
        return 0;
    }

    public String mo2088e() {
        return this.f207i;
    }

    public boolean equals(Object obj) {
        return (obj == null || !(obj instanceof C0456i)) ? false : this.f200b.equals(((C0456i) obj).b);
    }

    public Bitmap mo2089f() {
        try {
            Bitmap g = m299g();
            return g != null ? C0487k.m404a(g, mo2085d()) : g;
        } catch (Throwable th) {
            Log.e("BaseImage", "miniThumbBitmap got exception", th);
            return null;
        }
    }

    public Bitmap m299g() {
        return C0390a.m84a().m87a(this.f199a, this.f201c, 3, null, false);
    }

    public int getHeight() {
        if (this.f209k == -1) {
            m292i();
        }
        return this.f209k;
    }

    public String getMimeType() {
        return this.f204f;
    }

    public int getWidth() {
        if (this.f208j == -1) {
            m292i();
        }
        return this.f208j;
    }

    public String mo2099h() {
        String str = null;
        String a = C1147a.m2480a("image_id", "=", Long.valueOf(this.f201c));
        Cursor query = this.f199a.query(Thumbnails.EXTERNAL_CONTENT_URI, new String[]{Columns.DATA}, a, null, null);
        if (query != null) {
            if (query.getCount() > 0 && query.moveToFirst()) {
                str = query.getString(0);
            }
            query.close();
        }
        return str;
    }

    public int hashCode() {
        return this.f200b.hashCode();
    }

    public String toString() {
        return this.f200b.toString();
    }
}
