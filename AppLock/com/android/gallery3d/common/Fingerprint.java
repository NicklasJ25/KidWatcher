package com.android.gallery3d.common;

import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;

public class Fingerprint {
    private static final MessageDigest DIGESTER;
    private static final String DIGEST_MD5 = "md5";
    private static final int FINGERPRINT_BYTE_LENGTH;
    private static final int STREAM_ID_CS_01_LENGTH;
    private static final String STREAM_ID_CS_PREFIX = "cs_01_";
    private final byte[] mMd5Digest;

    static {
        try {
            DIGESTER = MessageDigest.getInstance(DIGEST_MD5);
            FINGERPRINT_BYTE_LENGTH = DIGESTER.getDigestLength();
            STREAM_ID_CS_01_LENGTH = STREAM_ID_CS_PREFIX.length() + (FINGERPRINT_BYTE_LENGTH * 2);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public Fingerprint(byte[] bArr) {
        if (bArr == null || bArr.length != FINGERPRINT_BYTE_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.mMd5Digest = bArr;
    }

    private static void appendHexFingerprint(StringBuilder stringBuilder, byte[] bArr) {
        for (int i = 0; i < FINGERPRINT_BYTE_LENGTH; i++) {
            byte b = bArr[i];
            stringBuilder.append(Integer.toHexString((b >> 4) & 15));
            stringBuilder.append(Integer.toHexString(b & 15));
        }
    }

    public static Fingerprint extractFingerprint(List<String> list) {
        for (String str : list) {
            if (str.startsWith(STREAM_ID_CS_PREFIX)) {
                return fromStreamId(str);
            }
        }
        return null;
    }

    public static Fingerprint fromInputStream(InputStream inputStream, long[] jArr) {
        Throwable th;
        DigestInputStream digestInputStream;
        try {
            digestInputStream = new DigestInputStream(inputStream, DIGESTER);
            try {
                byte[] bArr = new byte[8192];
                long j = 0;
                while (true) {
                    int read = digestInputStream.read(bArr);
                    if (read < 0) {
                        break;
                    }
                    j += (long) read;
                }
                if (digestInputStream != null) {
                    digestInputStream.close();
                }
                if (jArr != null && jArr.length > 0) {
                    jArr[0] = j;
                }
                return new Fingerprint(digestInputStream.getMessageDigest().digest());
            } catch (Throwable th2) {
                th = th2;
                if (digestInputStream != null) {
                    digestInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            digestInputStream = null;
            if (digestInputStream != null) {
                digestInputStream.close();
            }
            throw th;
        }
    }

    public static Fingerprint fromStreamId(String str) {
        if (str != null && str.startsWith(STREAM_ID_CS_PREFIX) && str.length() == STREAM_ID_CS_01_LENGTH) {
            byte[] bArr = new byte[FINGERPRINT_BYTE_LENGTH];
            int i = 0;
            int length = STREAM_ID_CS_PREFIX.length();
            while (length < STREAM_ID_CS_01_LENGTH) {
                int toDigit = toDigit(str, length + 1) | (toDigit(str, length) << 4);
                int i2 = i + 1;
                bArr[i] = (byte) (toDigit & 255);
                length += 2;
                i = i2;
            }
            return new Fingerprint(bArr);
        }
        throw new IllegalArgumentException("bad streamId: " + str);
    }

    private static int toDigit(String str, int i) {
        int digit = Character.digit(str.charAt(i), 16);
        if (digit >= 0) {
            return digit;
        }
        throw new IllegalArgumentException("illegal hex digit in " + str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Fingerprint)) {
            return false;
        }
        return Arrays.equals(this.mMd5Digest, ((Fingerprint) obj).mMd5Digest);
    }

    public boolean equals(byte[] bArr) {
        return Arrays.equals(this.mMd5Digest, bArr);
    }

    public byte[] getBytes() {
        return this.mMd5Digest;
    }

    public int hashCode() {
        return Arrays.hashCode(this.mMd5Digest);
    }

    public String toStreamId() {
        StringBuilder stringBuilder = new StringBuilder(STREAM_ID_CS_PREFIX);
        appendHexFingerprint(stringBuilder, this.mMd5Digest);
        return stringBuilder.toString();
    }
}
