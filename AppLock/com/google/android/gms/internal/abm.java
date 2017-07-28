package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.internal.ej.C2847a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class abm implements ej {
    private final Map<String, C2664a> f7816a;
    private long f7817b;
    private final File f7818c;
    private final int f7819d;

    static class C2664a {
        public long f7807a;
        public String f7808b;
        public String f7809c;
        public long f7810d;
        public long f7811e;
        public long f7812f;
        public long f7813g;
        public Map<String, String> f7814h;

        private C2664a() {
        }

        public C2664a(String str, C2847a c2847a) {
            this.f7808b = str;
            this.f7807a = (long) c2847a.f8827a.length;
            this.f7809c = c2847a.f8828b;
            this.f7810d = c2847a.f8829c;
            this.f7811e = c2847a.f8830d;
            this.f7812f = c2847a.f8831e;
            this.f7813g = c2847a.f8832f;
            this.f7814h = c2847a.f8833g;
        }

        public static C2664a m8771a(InputStream inputStream) {
            C2664a c2664a = new C2664a();
            if (abm.m8778a(inputStream) != 538247942) {
                throw new IOException();
            }
            c2664a.f7808b = abm.m8787c(inputStream);
            c2664a.f7809c = abm.m8787c(inputStream);
            if (c2664a.f7809c.equals("")) {
                c2664a.f7809c = null;
            }
            c2664a.f7810d = abm.m8786b(inputStream);
            c2664a.f7811e = abm.m8786b(inputStream);
            c2664a.f7812f = abm.m8786b(inputStream);
            c2664a.f7813g = abm.m8786b(inputStream);
            c2664a.f7814h = abm.m8789d(inputStream);
            return c2664a;
        }

        public C2847a m8772a(byte[] bArr) {
            C2847a c2847a = new C2847a();
            c2847a.f8827a = bArr;
            c2847a.f8828b = this.f7809c;
            c2847a.f8829c = this.f7810d;
            c2847a.f8830d = this.f7811e;
            c2847a.f8831e = this.f7812f;
            c2847a.f8832f = this.f7813g;
            c2847a.f8833g = this.f7814h;
            return c2847a;
        }

        public boolean m8773a(OutputStream outputStream) {
            try {
                abm.m8780a(outputStream, 538247942);
                abm.m8782a(outputStream, this.f7808b);
                abm.m8782a(outputStream, this.f7809c == null ? "" : this.f7809c);
                abm.m8781a(outputStream, this.f7810d);
                abm.m8781a(outputStream, this.f7811e);
                abm.m8781a(outputStream, this.f7812f);
                abm.m8781a(outputStream, this.f7813g);
                abm.m8784a(this.f7814h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                abj.m8757b("%s", e.toString());
                return false;
            }
        }
    }

    private static class C2665b extends FilterInputStream {
        private int f7815a;

        private C2665b(InputStream inputStream) {
            super(inputStream);
            this.f7815a = 0;
        }

        public int read() {
            int read = super.read();
            if (read != -1) {
                this.f7815a++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f7815a += read;
            }
            return read;
        }
    }

    public abm(File file) {
        this(file, 5242880);
    }

    public abm(File file, int i) {
        this.f7816a = new LinkedHashMap(16, 0.75f, true);
        this.f7817b = 0;
        this.f7818c = file;
        this.f7819d = i;
    }

    static int m8778a(InputStream inputStream) {
        return ((((m8790e(inputStream) << 0) | 0) | (m8790e(inputStream) << 8)) | (m8790e(inputStream) << 16)) | (m8790e(inputStream) << 24);
    }

    private void m8779a(int i) {
        if (this.f7817b + ((long) i) >= ((long) this.f7819d)) {
            int i2;
            if (abj.f7796b) {
                abj.m8755a("Pruning old cache entries.", new Object[0]);
            }
            long j = this.f7817b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.f7816a.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                C2664a c2664a = (C2664a) ((Entry) it.next()).getValue();
                if (m8796c(c2664a.f7808b).delete()) {
                    this.f7817b -= c2664a.f7807a;
                } else {
                    abj.m8757b("Could not delete cache entry for key=%s, filename=%s", c2664a.f7808b, m8788d(c2664a.f7808b));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.f7817b + ((long) i))) < ((float) this.f7819d) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            i2 = i3;
            if (abj.f7796b) {
                abj.m8755a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f7817b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    static void m8780a(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void m8781a(OutputStream outputStream, long j) {
        outputStream.write((byte) ((int) (j >>> null)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void m8782a(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m8781a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void m8783a(String str, C2664a c2664a) {
        if (this.f7816a.containsKey(str)) {
            C2664a c2664a2 = (C2664a) this.f7816a.get(str);
            this.f7817b = (c2664a.f7807a - c2664a2.f7807a) + this.f7817b;
        } else {
            this.f7817b += c2664a.f7807a;
        }
        this.f7816a.put(str, c2664a);
    }

    static void m8784a(Map<String, String> map, OutputStream outputStream) {
        if (map != null) {
            m8780a(outputStream, map.size());
            for (Entry entry : map.entrySet()) {
                m8782a(outputStream, (String) entry.getKey());
                m8782a(outputStream, (String) entry.getValue());
            }
            return;
        }
        m8780a(outputStream, 0);
    }

    private static byte[] m8785a(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static long m8786b(InputStream inputStream) {
        return (((((((0 | ((((long) m8790e(inputStream)) & 255) << null)) | ((((long) m8790e(inputStream)) & 255) << 8)) | ((((long) m8790e(inputStream)) & 255) << 16)) | ((((long) m8790e(inputStream)) & 255) << 24)) | ((((long) m8790e(inputStream)) & 255) << 32)) | ((((long) m8790e(inputStream)) & 255) << 40)) | ((((long) m8790e(inputStream)) & 255) << 48)) | ((((long) m8790e(inputStream)) & 255) << 56);
    }

    static String m8787c(InputStream inputStream) {
        return new String(m8785a(inputStream, (int) m8786b(inputStream)), "UTF-8");
    }

    private String m8788d(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    static Map<String, String> m8789d(InputStream inputStream) {
        int a = m8778a(inputStream);
        Map<String, String> emptyMap = a == 0 ? Collections.emptyMap() : new HashMap(a);
        for (int i = 0; i < a; i++) {
            emptyMap.put(m8787c(inputStream).intern(), m8787c(inputStream).intern());
        }
        return emptyMap;
    }

    private static int m8790e(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private void m8791e(String str) {
        C2664a c2664a = (C2664a) this.f7816a.get(str);
        if (c2664a != null) {
            this.f7817b -= c2664a.f7807a;
            this.f7816a.remove(str);
        }
    }

    public synchronized C2847a mo3460a(String str) {
        C2847a c2847a;
        C2665b c2665b;
        IOException e;
        Throwable th;
        C2664a c2664a = (C2664a) this.f7816a.get(str);
        if (c2664a == null) {
            c2847a = null;
        } else {
            File c = m8796c(str);
            try {
                c2665b = new C2665b(new BufferedInputStream(new FileInputStream(c)));
                try {
                    C2664a.m8771a((InputStream) c2665b);
                    c2847a = c2664a.m8772a(m8785a((InputStream) c2665b, (int) (c.length() - ((long) c2665b.f7815a))));
                    try {
                        c2665b.close();
                    } catch (IOException e2) {
                        c2847a = null;
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        abj.m8757b("%s: %s", c.getAbsolutePath(), e.toString());
                        m8795b(str);
                        if (c2665b != null) {
                            try {
                                c2665b.close();
                            } catch (IOException e4) {
                                c2847a = null;
                            }
                        }
                        c2847a = null;
                        return c2847a;
                    } catch (Throwable th2) {
                        th = th2;
                        if (c2665b != null) {
                            try {
                                c2665b.close();
                            } catch (IOException e5) {
                                c2847a = null;
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                c2665b = null;
                abj.m8757b("%s: %s", c.getAbsolutePath(), e.toString());
                m8795b(str);
                if (c2665b != null) {
                    c2665b.close();
                }
                c2847a = null;
                return c2847a;
            } catch (Throwable th3) {
                th = th3;
                c2665b = null;
                if (c2665b != null) {
                    c2665b.close();
                }
                throw th;
            }
        }
        return c2847a;
    }

    public synchronized void mo3461a() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        if (this.f7818c.exists()) {
            File[] listFiles = this.f7818c.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    BufferedInputStream bufferedInputStream2 = null;
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        try {
                            C2664a a = C2664a.m8771a((InputStream) bufferedInputStream);
                            a.f7807a = file.length();
                            m8783a(a.f7808b, a);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e) {
                            }
                        } catch (IOException e2) {
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Throwable th2) {
                                    Throwable th3 = th2;
                                    bufferedInputStream2 = bufferedInputStream;
                                    th = th3;
                                }
                            }
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                        }
                    } catch (IOException e4) {
                        bufferedInputStream = null;
                        if (file != null) {
                            file.delete();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            }
        } else if (!this.f7818c.mkdirs()) {
            abj.m8758c("Unable to create cache dir %s", this.f7818c.getAbsolutePath());
        }
        return;
        if (bufferedInputStream2 != null) {
            try {
                bufferedInputStream2.close();
            } catch (IOException e5) {
            }
        }
        throw th;
        throw th;
    }

    public synchronized void mo3462a(String str, C2847a c2847a) {
        m8779a(c2847a.f8827a.length);
        File c = m8796c(str);
        try {
            OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(c));
            C2664a c2664a = new C2664a(str, c2847a);
            if (c2664a.m8773a(bufferedOutputStream)) {
                bufferedOutputStream.write(c2847a.f8827a);
                bufferedOutputStream.close();
                m8783a(str, c2664a);
            } else {
                bufferedOutputStream.close();
                abj.m8757b("Failed to write header for %s", c.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException e) {
            if (!c.delete()) {
                abj.m8757b("Could not clean up file %s", c.getAbsolutePath());
            }
        }
    }

    public synchronized void m8795b(String str) {
        boolean delete = m8796c(str).delete();
        m8791e(str);
        if (!delete) {
            abj.m8757b("Could not delete cache entry for key=%s, filename=%s", str, m8788d(str));
        }
    }

    public File m8796c(String str) {
        return new File(this.f7818c, m8788d(str));
    }
}
