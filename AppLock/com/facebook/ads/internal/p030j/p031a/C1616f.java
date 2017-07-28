package com.facebook.ads.internal.p030j.p031a;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class C1616f implements C1615q {
    private final C1623r f4012a;

    public C1616f() {
        this(new C1624g());
    }

    public C1616f(C1623r c1623r) {
        this.f4012a = c1623r;
    }

    public OutputStream mo2747a(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getOutputStream();
    }

    public HttpURLConnection mo2748a(String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    public void mo2749a(OutputStream outputStream, byte[] bArr) {
        outputStream.write(bArr);
    }

    public void mo2750a(HttpURLConnection httpURLConnection, C1628j c1628j, String str) {
        httpURLConnection.setRequestMethod(c1628j.m4586c());
        httpURLConnection.setDoOutput(c1628j.m4585b());
        httpURLConnection.setDoInput(c1628j.m4584a());
        if (str != null) {
            httpURLConnection.setRequestProperty("Content-Type", str);
        }
        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
    }

    public boolean mo2751a(C1630m c1630m) {
        C1631n a = c1630m.m4587a();
        if (this.f4012a.mo2758a()) {
            this.f4012a.mo2756a("BasicRequestHandler.onError got");
            c1630m.printStackTrace();
        }
        return a != null && a.m4588a() > 0;
    }

    public byte[] mo2752a(InputStream inputStream) {
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public InputStream mo2753b(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getInputStream();
    }
}
