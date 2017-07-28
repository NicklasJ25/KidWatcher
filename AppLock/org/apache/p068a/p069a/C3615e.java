package org.apache.p068a.p069a;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import org.apache.p068a.p069a.p070a.C3610b;

public class C3615e {
    public static final char f12315a = File.separatorChar;
    public static final String f12316b;

    static {
        Writer c3610b = new C3610b(4);
        PrintWriter printWriter = new PrintWriter(c3610b);
        printWriter.println();
        f12316b = c3610b.toString();
        printWriter.close();
    }

    public static int m15753a(InputStream inputStream, OutputStream outputStream) {
        long b = C3615e.m15763b(inputStream, outputStream);
        return b > 2147483647L ? -1 : (int) b;
    }

    public static int m15754a(Reader reader, Writer writer) {
        long b = C3615e.m15764b(reader, writer);
        return b > 2147483647L ? -1 : (int) b;
    }

    public static long m15755a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public static long m15756a(Reader reader, Writer writer, char[] cArr) {
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += (long) read;
        }
    }

    public static String m15757a(InputStream inputStream, Charset charset) {
        Writer c3610b = new C3610b();
        C3615e.m15760a(inputStream, c3610b, charset);
        return c3610b.toString();
    }

    public static void m15758a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static void m15759a(InputStream inputStream) {
        C3615e.m15758a((Closeable) inputStream);
    }

    public static void m15760a(InputStream inputStream, Writer writer, Charset charset) {
        C3615e.m15754a(new InputStreamReader(inputStream, C3611a.m15723a(charset)), writer);
    }

    public static void m15761a(OutputStream outputStream) {
        C3615e.m15758a((Closeable) outputStream);
    }

    public static void m15762a(String str, OutputStream outputStream, Charset charset) {
        if (str != null) {
            outputStream.write(str.getBytes(C3611a.m15723a(charset)));
        }
    }

    public static long m15763b(InputStream inputStream, OutputStream outputStream) {
        return C3615e.m15755a(inputStream, outputStream, new byte[4096]);
    }

    public static long m15764b(Reader reader, Writer writer) {
        return C3615e.m15756a(reader, writer, new char[4096]);
    }
}
