package com.facebook.ads.internal.p030j.p032b;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.Closeable;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

public class C1666m {
    static String m4708a(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        Object fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        return TextUtils.isEmpty(fileExtensionFromUrl) ? null : singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    private static String m4709a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuffer.toString();
    }

    static void m4710a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                Log.e("ProxyCache", "Error closing resource", e);
            }
        }
    }

    static void m4711a(byte[] bArr, long j, int i) {
        boolean z = true;
        C1663j.m4706a((Object) bArr, "Buffer must be not null!");
        C1663j.m4707a(j >= 0, "Data offset must be positive!");
        if (i < 0 || i > bArr.length) {
            z = false;
        }
        C1663j.m4707a(z, "Length must be in range [0..buffer.length]");
    }

    static String m4712b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Throwable e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }

    static String m4713c(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Throwable e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }

    public static String m4714d(String str) {
        try {
            return C1666m.m4709a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
