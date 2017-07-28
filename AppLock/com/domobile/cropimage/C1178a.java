package com.domobile.cropimage;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;

public abstract class C1178a implements C1177f {
    protected ContentResolver f2287a;
    protected Uri f2288b;
    protected long f2289c;
    protected String f2290d;
    protected final int f2291e;
    protected String f2292f;
    protected C1179b f2293g;
    private final long f2294h;
    private String f2295i;
    private int f2296j = -1;
    private int f2297k = -1;

    protected C1178a(C1179b c1179b, ContentResolver contentResolver, long j, int i, Uri uri, String str, String str2, long j2, String str3) {
        this.f2293g = c1179b;
        this.f2287a = contentResolver;
        this.f2289c = j;
        this.f2291e = i;
        this.f2288b = uri;
        this.f2290d = str;
        this.f2292f = str2;
        this.f2294h = j2;
        this.f2295i = str3;
    }

    public long mo2509a() {
        return this.f2294h;
    }

    public Bitmap mo2510a(int i, int i2) {
        return m2737a(i, i2, true, false);
    }

    public Bitmap m2737a(int i, int i2, boolean z, boolean z2) {
        Uri a = this.f2293g.m2742a(this.f2289c);
        if (a == null) {
            return null;
        }
        Bitmap a2 = C1203k.m2809a(i, i2, a, this.f2287a, z2);
        return (a2 == null || !z) ? a2 : C1203k.m2811a(a2, mo2512b());
    }

    public int mo2512b() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj == null || !(obj instanceof C1192h)) ? false : this.f2288b.equals(((C1192h) obj).b);
    }

    public int hashCode() {
        return this.f2288b.hashCode();
    }

    public String toString() {
        return this.f2288b.toString();
    }
}
