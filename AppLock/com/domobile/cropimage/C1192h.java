package com.domobile.cropimage;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import com.android.gallery3d.common.Entry.Columns;

public class C1192h extends C1178a implements C1177f {
    private static final String[] f2347i = new String[]{Columns.ID};
    private int f2348h;

    public C1192h(C1179b c1179b, ContentResolver contentResolver, long j, int i, Uri uri, String str, String str2, long j2, String str3, int i2) {
        super(c1179b, contentResolver, j, i, uri, str, str2, j2, str3);
        this.f2348h = i2;
    }

    public Bitmap mo2511a(boolean z) {
        Options options = new Options();
        options.inDither = false;
        options.inPreferredConfig = Config.ARGB_8888;
        Bitmap a = C1183c.m2753a().m2756a(this.a, this.c, 1, options, false);
        return (a == null || !z) ? a : C1203k.m2811a(a, mo2512b());
    }

    public int mo2512b() {
        return this.f2348h;
    }
}
