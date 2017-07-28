package com.android.camera.gallery;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore.Video.Thumbnails;
import android.util.Log;
import com.android.camera.C0390a;
import com.android.gallery3d.data.DownloadEntry.Columns;
import com.domobile.frame.p000a.C1147a;

public class C0469p extends C0451a implements C0450f {
    protected C0469p(C0452b c0452b, ContentResolver contentResolver, long j, int i, Uri uri, String str, String str2, long j2, String str3) {
        super(c0452b, contentResolver, j, i, uri, str, str2, j2, str3);
    }

    public boolean equals(Object obj) {
        return (obj == null || !(obj instanceof C0469p)) ? false : mo2108b().equals(((C0469p) obj).mo2108b());
    }

    public Bitmap mo2089f() {
        try {
            return C0390a.m84a().m87a(this.a, this.c, 3, null, true);
        } catch (Throwable th) {
            Log.e("VideoObject", "miniThumbBitmap got exception", th);
            return null;
        }
    }

    public int getHeight() {
        return 0;
    }

    public int getWidth() {
        return 0;
    }

    public String mo2099h() {
        String str = null;
        String a = C1147a.m2480a("video_id", "=", Long.valueOf(this.c));
        Cursor query = this.a.query(Thumbnails.EXTERNAL_CONTENT_URI, new String[]{Columns.DATA}, a, null, null);
        if (query != null) {
            if (query.getCount() > 0 && query.moveToFirst()) {
                str = query.getString(0);
            }
            query.close();
        }
        return str;
    }

    public int hashCode() {
        return mo2108b().toString().hashCode();
    }

    public String toString() {
        return "VideoObject" + this.c;
    }
}
