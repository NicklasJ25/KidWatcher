package com.google.android.exoplayer2.p056i;

import android.net.Uri;
import com.google.android.exoplayer2.p043j.C2252a;
import java.util.Arrays;

public final class C2230h {
    public final Uri f6333a;
    public final byte[] f6334b;
    public final long f6335c;
    public final long f6336d;
    public final long f6337e;
    public final String f6338f;
    public final int f6339g;

    public C2230h(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    public C2230h(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
    }

    public C2230h(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        C2252a.m7022a(j >= 0);
        C2252a.m7022a(j2 >= 0);
        boolean z = j3 > 0 || j3 == -1;
        C2252a.m7022a(z);
        this.f6333a = uri;
        this.f6334b = bArr;
        this.f6335c = j;
        this.f6336d = j2;
        this.f6337e = j3;
        this.f6338f = str;
        this.f6339g = i;
    }

    public String toString() {
        return "DataSpec[" + this.f6333a + ", " + Arrays.toString(this.f6334b) + ", " + this.f6335c + ", " + this.f6336d + ", " + this.f6337e + ", " + this.f6338f + ", " + this.f6339g + "]";
    }
}
