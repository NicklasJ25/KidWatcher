package org.apache.p068a.p069a;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import org.apache.p068a.p069a.p070a.C3609a;

public class C3613c {
    public static final BigInteger f12302a = BigInteger.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
    public static final BigInteger f12303b = f12302a.multiply(f12302a);
    public static final BigInteger f12304c = f12302a.multiply(f12303b);
    public static final BigInteger f12305d = f12302a.multiply(f12304c);
    public static final BigInteger f12306e = f12302a.multiply(f12305d);
    public static final BigInteger f12307f = f12302a.multiply(f12306e);
    public static final BigInteger f12308g = BigInteger.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID).multiply(BigInteger.valueOf(1152921504606846976L));
    public static final BigInteger f12309h = f12302a.multiply(f12308g);
    public static final File[] f12310i = new File[0];
    private static final Charset f12311j = Charset.forName("UTF-8");

    public static FileInputStream m15724a(File file) {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (file.canRead()) {
            return new FileInputStream(file);
        } else {
            throw new IOException("File '" + file + "' cannot be read");
        }
    }

    public static FileOutputStream m15725a(File file, boolean z) {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!(parentFile == null || parentFile.mkdirs() || parentFile.isDirectory())) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
        }
        return new FileOutputStream(file, z);
    }

    public static String m15726a(File file, String str) {
        return C3613c.m15727a(file, C3611a.m15722a(str));
    }

    public static String m15727a(File file, Charset charset) {
        InputStream inputStream = null;
        try {
            inputStream = C3613c.m15724a(file);
            String a = C3615e.m15757a(inputStream, C3611a.m15723a(charset));
            return a;
        } finally {
            C3615e.m15759a(inputStream);
        }
    }

    private static void m15728a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void m15729a(File file, File file2) {
        C3613c.m15730a(file, file2, true);
    }

    public static void m15730a(File file, File file2, boolean z) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        } else if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        } else {
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Destination '" + parentFile + "' directory cannot be created");
            } else if (!file2.exists() || file2.canWrite()) {
                C3613c.m15737b(file, file2, z);
            } else {
                throw new IOException("Destination '" + file2 + "' exists but is read-only");
            }
        }
    }

    public static void m15731a(File file, String str, Charset charset, boolean z) {
        OutputStream outputStream = null;
        try {
            outputStream = C3613c.m15725a(file, z);
            C3615e.m15762a(str, outputStream, charset);
            outputStream.close();
        } finally {
            C3615e.m15761a(outputStream);
        }
    }

    public static void m15732a(InputStream inputStream, File file) {
        OutputStream b;
        try {
            b = C3613c.m15735b(file);
            C3615e.m15753a(inputStream, b);
            b.close();
            C3615e.m15761a(b);
            C3615e.m15759a(inputStream);
        } catch (Throwable th) {
            C3615e.m15759a(inputStream);
        }
    }

    public static boolean m15733a(byte[] bArr, String str) {
        Throwable th;
        File file = new File(str);
        Closeable closeable = null;
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            Closeable fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                C3613c.m15728a(fileOutputStream);
                return true;
            } catch (Exception e) {
                closeable = fileOutputStream;
                try {
                    file.delete();
                    C3613c.m15728a(closeable);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    C3613c.m15728a(closeable);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = fileOutputStream;
                C3613c.m15728a(closeable);
                throw th;
            }
        } catch (Exception e2) {
            file.delete();
            C3613c.m15728a(closeable);
            return false;
        }
    }

    public static byte[] m15734a(String str) {
        Closeable fileInputStream;
        Throwable th;
        File file = new File(str);
        C3609a c3609a = new C3609a();
        Closeable closeable = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    c3609a.write(bArr, 0, read);
                }
                C3613c.m15728a(fileInputStream);
            } catch (Exception e) {
                C3613c.m15728a(fileInputStream);
                return c3609a.m15721a();
            } catch (Throwable th2) {
                Throwable th3 = th2;
                closeable = fileInputStream;
                th = th3;
                C3613c.m15728a(closeable);
                throw th;
            }
        } catch (Exception e2) {
            fileInputStream = null;
            C3613c.m15728a(fileInputStream);
            return c3609a.m15721a();
        } catch (Throwable th4) {
            th = th4;
            C3613c.m15728a(closeable);
            throw th;
        }
        return c3609a.m15721a();
    }

    public static FileOutputStream m15735b(File file) {
        return C3613c.m15725a(file, false);
    }

    public static void m15736b(File file, File file2) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' is a directory");
        } else if (file2.exists()) {
            throw new C3612b("Destination '" + file2 + "' already exists");
        } else if (file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' is a directory");
        } else if (!file.renameTo(file2)) {
            C3613c.m15729a(file, file2);
            if (!file.delete()) {
                C3613c.m15740d(file2);
                throw new IOException("Failed to delete original file '" + file + "' after copy to '" + file2 + "'");
            }
        }
    }

    private static void m15737b(File file, File file2, boolean z) {
        Throwable th;
        Closeable closeable;
        OutputStream outputStream;
        InputStream inputStream;
        Closeable channel;
        Closeable closeable2 = null;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        try {
            OutputStream fileOutputStream;
            InputStream fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                outputStream = null;
                inputStream = fileInputStream;
                C3615e.m15758a(closeable);
                C3615e.m15761a(outputStream);
                C3615e.m15758a(closeable2);
                C3615e.m15759a(inputStream);
                throw th;
            }
            try {
                closeable = fileInputStream.getChannel();
                try {
                    channel = fileOutputStream.getChannel();
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = fileOutputStream;
                    inputStream = fileInputStream;
                    closeable2 = closeable;
                    closeable = null;
                    C3615e.m15758a(closeable);
                    C3615e.m15761a(outputStream);
                    C3615e.m15758a(closeable2);
                    C3615e.m15759a(inputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                outputStream = fileOutputStream;
                inputStream = fileInputStream;
                C3615e.m15758a(closeable);
                C3615e.m15761a(outputStream);
                C3615e.m15758a(closeable2);
                C3615e.m15759a(inputStream);
                throw th;
            }
            try {
                long size = closeable.size();
                long j = 0;
                while (j < size) {
                    j += channel.transferFrom(closeable, j, size - j > 31457280 ? 31457280 : size - j);
                }
                C3615e.m15758a(channel);
                C3615e.m15761a(fileOutputStream);
                C3615e.m15758a(closeable);
                C3615e.m15759a(fileInputStream);
                if (file.length() != file2.length()) {
                    throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                } else if (z) {
                    file2.setLastModified(file.lastModified());
                }
            } catch (Throwable th5) {
                outputStream = fileOutputStream;
                inputStream = fileInputStream;
                Closeable closeable3 = closeable;
                closeable = channel;
                th = th5;
                closeable2 = closeable3;
                C3615e.m15758a(closeable);
                C3615e.m15761a(outputStream);
                C3615e.m15758a(closeable2);
                C3615e.m15759a(inputStream);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            closeable = null;
            outputStream = null;
            inputStream = null;
            C3615e.m15758a(closeable);
            C3615e.m15761a(outputStream);
            C3615e.m15758a(closeable2);
            C3615e.m15759a(inputStream);
            throw th;
        }
    }

    public static void m15738b(File file, String str) {
        C3613c.m15731a(file, str, Charset.defaultCharset(), false);
    }

    public static void m15739c(File file) {
        if (file.exists()) {
            if (!C3613c.m15746j(file)) {
                C3613c.m15741e(file);
            }
            if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
    }

    public static boolean m15740d(File file) {
        boolean z = false;
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    C3613c.m15741e(file);
                }
            } catch (Exception e) {
            }
            try {
                z = file.delete();
            } catch (Exception e2) {
            }
        }
        return z;
    }

    public static void m15741e(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("Failed to list contents of " + file);
            }
            IOException iOException = null;
            for (File g : listFiles) {
                try {
                    C3613c.m15743g(g);
                } catch (IOException e) {
                    iOException = e;
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } else {
            throw new IllegalArgumentException(file + " is not a directory");
        }
    }

    public static String m15742f(File file) {
        return C3613c.m15727a(file, Charset.defaultCharset());
    }

    public static void m15743g(File file) {
        if (file.isDirectory()) {
            C3613c.m15739c(file);
            return;
        }
        boolean exists = file.exists();
        if (!file.delete()) {
            if (exists) {
                throw new IOException("Unable to delete file: " + file);
            }
            throw new FileNotFoundException("File does not exist: " + file);
        }
    }

    public static long m15744h(File file) {
        return !file.exists() ? 0 : file.isDirectory() ? C3613c.m15745i(file) : file.length();
    }

    public static long m15745i(File file) {
        C3613c.m15747k(file);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        long j = 0;
        for (File file2 : listFiles) {
            try {
                if (C3613c.m15746j(file2)) {
                    continue;
                } else {
                    j += C3613c.m15744h(file2);
                    if (j < 0) {
                        return j;
                    }
                }
            } catch (IOException e) {
            }
        }
        return j;
    }

    public static boolean m15746j(File file) {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        } else if (C3614d.m15749a()) {
            return false;
        } else {
            if (file.getParent() != null) {
                file = new File(file.getParentFile().getCanonicalFile(), file.getName());
            }
            return !file.getCanonicalFile().equals(file.getAbsoluteFile());
        }
    }

    private static void m15747k(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
    }
}
