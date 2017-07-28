package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ef {
    private static Cipher f8823b = null;
    private static final Object f8824c = new Object();
    private static final Object f8825d = new Object();
    private final SecureRandom f8826a;

    public class C2846a extends Exception {
        public C2846a(ef efVar) {
        }

        public C2846a(ef efVar, Throwable th) {
            super(th);
        }
    }

    public ef(SecureRandom secureRandom) {
        this.f8826a = secureRandom;
    }

    private Cipher m10570a() {
        Cipher cipher;
        synchronized (f8825d) {
            if (f8823b == null) {
                f8823b = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = f8823b;
        }
        return cipher;
    }

    static void m10571a(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    public String m10572a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 16) {
            throw new C2846a(this);
        }
        try {
            byte[] doFinal;
            byte[] iv;
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (f8824c) {
                m10570a().init(1, secretKeySpec, this.f8826a);
                doFinal = m10570a().doFinal(bArr2);
                iv = m10570a().getIV();
            }
            int length = doFinal.length + iv.length;
            ByteBuffer allocate = ByteBuffer.allocate(length);
            allocate.put(iv).put(doFinal);
            allocate.flip();
            doFinal = new byte[length];
            allocate.get(doFinal);
            return br.m9193a(doFinal, false);
        } catch (Throwable e) {
            throw new C2846a(this, e);
        } catch (Throwable e2) {
            throw new C2846a(this, e2);
        } catch (Throwable e22) {
            throw new C2846a(this, e22);
        } catch (Throwable e222) {
            throw new C2846a(this, e222);
        } catch (Throwable e2222) {
            throw new C2846a(this, e2222);
        }
    }

    public byte[] m10573a(String str) {
        try {
            byte[] a = br.m9194a(str, false);
            if (a.length != 32) {
                throw new C2846a(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            m10571a(bArr);
            return bArr;
        } catch (Throwable e) {
            throw new C2846a(this, e);
        }
    }

    public byte[] m10574a(byte[] bArr, String str) {
        if (bArr.length != 16) {
            throw new C2846a(this);
        }
        try {
            byte[] a = br.m9194a(str, false);
            if (a.length <= 16) {
                throw new C2846a(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            a = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(a);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (f8824c) {
                m10570a().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                a = m10570a().doFinal(a);
            }
            return a;
        } catch (Throwable e) {
            throw new C2846a(this, e);
        } catch (Throwable e2) {
            throw new C2846a(this, e2);
        } catch (Throwable e22) {
            throw new C2846a(this, e22);
        } catch (Throwable e222) {
            throw new C2846a(this, e222);
        } catch (Throwable e2222) {
            throw new C2846a(this, e2222);
        } catch (Throwable e22222) {
            throw new C2846a(this, e22222);
        } catch (Throwable e222222) {
            throw new C2846a(this, e222222);
        }
    }
}
