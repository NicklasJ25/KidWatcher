package com.google.android.gms.internal;

import java.util.Map;

public class sz {
    public final int f10640a;
    public final byte[] f10641b;
    public final Map<String, String> f10642c;
    public final boolean f10643d;
    public final long f10644e;

    public sz(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this.f10640a = i;
        this.f10641b = bArr;
        this.f10642c = map;
        this.f10643d = z;
        this.f10644e = j;
    }

    public sz(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0);
    }
}
