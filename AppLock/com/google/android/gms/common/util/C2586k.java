package com.google.android.gms.common.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class C2586k {
    public static long m8299a(InputStream inputStream, OutputStream outputStream, boolean z) {
        return C2586k.m8300a(inputStream, outputStream, z, 1024);
    }

    public static long m8300a(InputStream inputStream, OutputStream outputStream, boolean z, int i) {
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, i);
                if (read == -1) {
                    break;
                }
                j += (long) read;
                outputStream.write(bArr, 0, read);
            } finally {
                if (z) {
                    C2586k.m8301a(inputStream);
                    C2586k.m8301a(outputStream);
                }
            }
        }
        return j;
    }

    public static void m8301a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static byte[] m8302a(InputStream inputStream, boolean z) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C2586k.m8299a(inputStream, byteArrayOutputStream, z);
        return byteArrayOutputStream.toByteArray();
    }
}
