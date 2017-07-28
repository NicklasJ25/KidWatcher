package com.facebook.ads.internal.p018m;

import android.content.Context;
import android.support.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class ae {
    @Nullable
    public static final String m4812a(Context context, String str) {
        try {
            return ae.m4816b(context.getPackageManager().getApplicationInfo(str, 0).sourceDir);
        } catch (Exception e) {
            return null;
        }
    }

    @Nullable
    public static final String m4813a(File file) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[1024];
            InputStream fileInputStream = new FileInputStream(file);
            int read;
            do {
                read = fileInputStream.read(bArr);
                if (read > 0) {
                    instance.update(bArr, 0, read);
                }
            } while (read != -1);
            fileInputStream.close();
            return ae.m4815a(instance.digest());
        } catch (Exception e) {
            return null;
        }
    }

    @Nullable
    public static String m4814a(String str) {
        try {
            return ae.m4815a(MessageDigest.getInstance("MD5").digest(str.getBytes("utf-8")));
        } catch (Exception e) {
            return null;
        }
    }

    private static final String m4815a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            stringBuilder.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        return stringBuilder.toString();
    }

    @Nullable
    public static final String m4816b(String str) {
        return ae.m4813a(new File(str));
    }
}
