package com.google.android.gms.common.util;

import android.util.Base64;

public final class C2578c {
    public static String m8270a(byte[] bArr) {
        return bArr == null ? null : Base64.encodeToString(bArr, 0);
    }

    public static String m8271b(byte[] bArr) {
        return bArr == null ? null : Base64.encodeToString(bArr, 10);
    }
}
