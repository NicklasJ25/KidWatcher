package com.facebook.ads.internal.p030j.p032b;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class C1660h implements C1659n {
    public final String f4096a;
    private HttpURLConnection f4097b;
    private InputStream f4098c;
    private volatile int f4099d;
    private volatile String f4100e;

    public C1660h(C1660h c1660h) {
        this.f4099d = Integer.MIN_VALUE;
        this.f4096a = c1660h.f4096a;
        this.f4100e = c1660h.f4100e;
        this.f4099d = c1660h.f4099d;
    }

    public C1660h(String str) {
        this(str, C1666m.m4708a(str));
    }

    public C1660h(String str, String str2) {
        this.f4099d = Integer.MIN_VALUE;
        this.f4096a = (String) C1663j.m4705a(str);
        this.f4100e = str2;
    }

    private int m4697a(HttpURLConnection httpURLConnection, int i, int i2) {
        int contentLength = httpURLConnection.getContentLength();
        return i2 == 200 ? contentLength : i2 == 206 ? contentLength + i : this.f4099d;
    }

    private HttpURLConnection m4698a(int i, int i2) {
        HttpURLConnection httpURLConnection;
        String str = this.f4096a;
        int i3 = 0;
        Object obj;
        do {
            Log.d("ProxyCache", "Open connection " + (i > 0 ? " with offset " + i : "") + " to " + str);
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + i + "-");
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
            }
            int responseCode = httpURLConnection.getResponseCode();
            obj = (responseCode == 301 || responseCode == 302 || responseCode == 303) ? 1 : null;
            if (obj != null) {
                str = httpURLConnection.getHeaderField("Location");
                i3++;
                httpURLConnection.disconnect();
            }
            if (i3 > 5) {
                throw new C1661l("Too many redirects: " + i3);
            }
        } while (obj != null);
        return httpURLConnection;
    }

    private void m4699d() {
        Throwable e;
        Closeable closeable = null;
        Log.d("ProxyCache", "Read content info from " + this.f4096a);
        HttpURLConnection a;
        try {
            a = m4698a(0, 10000);
            try {
                this.f4099d = a.getContentLength();
                this.f4100e = a.getContentType();
                closeable = a.getInputStream();
                Log.i("ProxyCache", "Content info for `" + this.f4096a + "`: mime: " + this.f4100e + ", content-length: " + this.f4099d);
                C1666m.m4710a(closeable);
                if (a != null) {
                    a.disconnect();
                }
            } catch (IOException e2) {
                e = e2;
                try {
                    Log.e("ProxyCache", "Error fetching info from " + this.f4096a, e);
                    C1666m.m4710a(closeable);
                    if (a != null) {
                        a.disconnect();
                    }
                } catch (Throwable th) {
                    e = th;
                    C1666m.m4710a(closeable);
                    if (a != null) {
                        a.disconnect();
                    }
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            a = null;
            Log.e("ProxyCache", "Error fetching info from " + this.f4096a, e);
            C1666m.m4710a(closeable);
            if (a != null) {
                a.disconnect();
            }
        } catch (Throwable th2) {
            e = th2;
            a = null;
            C1666m.m4710a(closeable);
            if (a != null) {
                a.disconnect();
            }
            throw e;
        }
    }

    public synchronized int mo2771a() {
        if (this.f4099d == Integer.MIN_VALUE) {
            m4699d();
        }
        return this.f4099d;
    }

    public int mo2772a(byte[] bArr) {
        if (this.f4098c == null) {
            throw new C1661l("Error reading data from " + this.f4096a + ": connection is absent!");
        }
        try {
            return this.f4098c.read(bArr, 0, bArr.length);
        } catch (Throwable e) {
            throw new C1662i("Reading source " + this.f4096a + " is interrupted", e);
        } catch (Throwable e2) {
            throw new C1661l("Error reading data from " + this.f4096a, e2);
        }
    }

    public void mo2773a(int i) {
        try {
            this.f4097b = m4698a(i, -1);
            this.f4100e = this.f4097b.getContentType();
            this.f4098c = new BufferedInputStream(this.f4097b.getInputStream(), 8192);
            this.f4099d = m4697a(this.f4097b, i, this.f4097b.getResponseCode());
        } catch (Throwable e) {
            throw new C1661l("Error opening connection for " + this.f4096a + " with offset " + i, e);
        }
    }

    public void mo2774b() {
        if (this.f4097b != null) {
            try {
                this.f4097b.disconnect();
            } catch (Throwable e) {
                throw new C1661l("Error disconnecting HttpUrlConnection", e);
            }
        }
    }

    public synchronized String m4704c() {
        if (TextUtils.isEmpty(this.f4100e)) {
            m4699d();
        }
        return this.f4100e;
    }

    public String toString() {
        return "HttpUrlSource{url='" + this.f4096a + "}";
    }
}
