package com.google.android.exoplayer2.p056i;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.p043j.C2243m;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p056i.C2237p.C2245b;
import com.google.android.exoplayer2.p056i.C2237p.C2246c;
import com.google.android.exoplayer2.p056i.C2237p.C2247d;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C2238m implements C2237p {
    private static final Pattern f6370b = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> f6371c = new AtomicReference();
    private final boolean f6372d;
    private final int f6373e;
    private final int f6374f;
    private final String f6375g;
    private final C2243m<String> f6376h;
    private final HashMap<String, String> f6377i = new HashMap();
    private final C2233r<? super C2238m> f6378j;
    private C2230h f6379k;
    private HttpURLConnection f6380l;
    private InputStream f6381m;
    private boolean f6382n;
    private long f6383o;
    private long f6384p;
    private long f6385q;
    private long f6386r;

    public C2238m(String str, C2243m<String> c2243m, C2233r<? super C2238m> c2233r, int i, int i2, boolean z) {
        this.f6375g = C2252a.m7021a(str);
        this.f6376h = c2243m;
        this.f6378j = c2233r;
        this.f6373e = i;
        this.f6374f = i2;
        this.f6372d = z;
    }

    private static long m6983a(HttpURLConnection httpURLConnection) {
        long j = -1;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                j = Long.parseLong(headerField);
            } catch (NumberFormatException e) {
                Log.e("DefaultHttpDataSource", "Unexpected Content-Length [" + headerField + "]");
            }
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField2)) {
            return j;
        }
        Matcher matcher = f6370b.matcher(headerField2);
        if (!matcher.find()) {
            return j;
        }
        try {
            long parseLong = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            if (j < 0) {
                return parseLong;
            }
            if (j == parseLong) {
                return j;
            }
            Log.w("DefaultHttpDataSource", "Inconsistent headers [" + headerField + "] [" + headerField2 + "]");
            return Math.max(j, parseLong);
        } catch (NumberFormatException e2) {
            Log.e("DefaultHttpDataSource", "Unexpected Content-Range [" + headerField2 + "]");
            return j;
        }
    }

    private HttpURLConnection m6984a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f6373e);
        httpURLConnection.setReadTimeout(this.f6374f);
        synchronized (this.f6377i) {
            for (Entry entry : this.f6377i.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if (!(j == 0 && j2 == -1)) {
            String str = "bytes=" + j + "-";
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f6375g);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length == 0) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    private static URL m6985a(URL url, String str) {
        if (str == null) {
            throw new ProtocolException("Null location redirect");
        }
        URL url2 = new URL(url, str);
        String protocol = url2.getProtocol();
        if ("https".equals(protocol) || "http".equals(protocol)) {
            return url2;
        }
        throw new ProtocolException("Unsupported protocol redirect: " + protocol);
    }

    private static void m6986a(HttpURLConnection httpURLConnection, long j) {
        if (C2273r.f6478a == 19 || C2273r.f6478a == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception e) {
            }
        }
    }

    private int m6987b(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.f6384p != -1) {
            long j = this.f6384p - this.f6386r;
            if (j == 0) {
                return -1;
            }
            i2 = (int) Math.min((long) i2, j);
        }
        int read = this.f6381m.read(bArr, i, i2);
        if (read != -1) {
            this.f6386r += (long) read;
            if (this.f6378j != null) {
                this.f6378j.mo3104a((Object) this, read);
            }
            return read;
        } else if (this.f6384p == -1) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    private HttpURLConnection m6988b(C2230h c2230h) {
        URL url = new URL(c2230h.f6333a.toString());
        byte[] bArr = c2230h.f6334b;
        long j = c2230h.f6336d;
        long j2 = c2230h.f6337e;
        boolean z = (c2230h.f6339g & 1) != 0;
        if (!this.f6372d) {
            return m6984a(url, bArr, j, j2, z, true);
        }
        HttpURLConnection a;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i <= 20) {
                a = m6984a(url, bArr, j, j2, z, false);
                int responseCode = a.getResponseCode();
                if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || (bArr == null && (responseCode == 307 || responseCode == 308))) {
                    bArr = null;
                    String headerField = a.getHeaderField("Location");
                    a.disconnect();
                    url = C2238m.m6985a(url, headerField);
                    i = i2;
                }
            } else {
                throw new NoRouteToHostException("Too many redirects: " + i2);
            }
        }
        return a;
    }

    private void m6989c() {
        if (this.f6385q != this.f6383o) {
            Object obj = (byte[]) f6371c.getAndSet(null);
            if (obj == null) {
                obj = new byte[4096];
            }
            while (this.f6385q != this.f6383o) {
                int read = this.f6381m.read(obj, 0, (int) Math.min(this.f6383o - this.f6385q, (long) obj.length));
                if (Thread.interrupted()) {
                    throw new InterruptedIOException();
                } else if (read == -1) {
                    throw new EOFException();
                } else {
                    this.f6385q += (long) read;
                    if (this.f6378j != null) {
                        this.f6378j.mo3104a((Object) this, read);
                    }
                }
            }
            f6371c.set(obj);
        }
    }

    private void m6990d() {
        if (this.f6380l != null) {
            try {
                this.f6380l.disconnect();
            } catch (Throwable e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.f6380l = null;
        }
    }

    public int mo3094a(byte[] bArr, int i, int i2) {
        try {
            m6989c();
            return m6987b(bArr, i, i2);
        } catch (IOException e) {
            throw new C2245b(e, this.f6379k, 2);
        }
    }

    public long mo3095a(C2230h c2230h) {
        long j = 0;
        this.f6379k = c2230h;
        this.f6386r = 0;
        this.f6385q = 0;
        try {
            this.f6380l = m6988b(c2230h);
            try {
                int responseCode = this.f6380l.getResponseCode();
                if (responseCode < 200 || responseCode > 299) {
                    Map headerFields = this.f6380l.getHeaderFields();
                    m6990d();
                    C2247d c2247d = new C2247d(responseCode, headerFields, c2230h);
                    if (responseCode == 416) {
                        c2247d.initCause(new C2229g(0));
                    }
                    throw c2247d;
                }
                String contentType = this.f6380l.getContentType();
                if (this.f6376h == null || this.f6376h.mo3107a(contentType)) {
                    if (responseCode == 200 && c2230h.f6336d != 0) {
                        j = c2230h.f6336d;
                    }
                    this.f6383o = j;
                    if ((c2230h.f6339g & 1) != 0) {
                        this.f6384p = c2230h.f6337e;
                    } else if (c2230h.f6337e != -1) {
                        this.f6384p = c2230h.f6337e;
                    } else {
                        j = C2238m.m6983a(this.f6380l);
                        this.f6384p = j != -1 ? j - this.f6383o : -1;
                    }
                    try {
                        this.f6381m = this.f6380l.getInputStream();
                        this.f6382n = true;
                        if (this.f6378j != null) {
                            this.f6378j.mo3105a((Object) this, c2230h);
                        }
                        return this.f6384p;
                    } catch (IOException e) {
                        m6990d();
                        throw new C2245b(e, c2230h, 1);
                    }
                }
                m6990d();
                throw new C2246c(contentType, c2230h);
            } catch (IOException e2) {
                m6990d();
                throw new C2245b("Unable to connect to " + c2230h.f6333a.toString(), e2, c2230h, 1);
            }
        } catch (IOException e22) {
            throw new C2245b("Unable to connect to " + c2230h.f6333a.toString(), e22, c2230h, 1);
        }
    }

    public void mo3096a() {
        try {
            if (this.f6381m != null) {
                C2238m.m6986a(this.f6380l, m6994b());
                this.f6381m.close();
            }
            this.f6381m = null;
            m6990d();
            if (this.f6382n) {
                this.f6382n = false;
                if (this.f6378j != null) {
                    this.f6378j.mo3103a(this);
                }
            }
        } catch (IOException e) {
            throw new C2245b(e, this.f6379k, 3);
        } catch (Throwable th) {
            this.f6381m = null;
            m6990d();
            if (this.f6382n) {
                this.f6382n = false;
                if (this.f6378j != null) {
                    this.f6378j.mo3103a(this);
                }
            }
        }
    }

    protected final long m6994b() {
        return this.f6384p == -1 ? this.f6384p : this.f6384p - this.f6386r;
    }
}
