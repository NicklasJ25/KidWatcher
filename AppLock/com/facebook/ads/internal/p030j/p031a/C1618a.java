package com.facebook.ads.internal.p030j.p031a;

import android.os.Build.VERSION;
import android.util.Log;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.net.ssl.HttpsURLConnection;

public class C1618a {
    private static int[] f4014f = new int[20];
    private static final String f4015g = C1618a.class.getSimpleName();
    protected final C1615q f4016a = new C16171(this);
    protected final C1621d f4017b = new C1622e();
    protected C1623r f4018c = new C1624g();
    protected int f4019d = 2000;
    protected int f4020e = 8000;
    private int f4021h = 3;
    private Map<String, String> f4022i = new TreeMap();
    private boolean f4023j;
    private Set<String> f4024k;
    private Set<String> f4025l;

    class C16171 extends C1616f {
        final /* synthetic */ C1618a f4013a;

        C16171(C1618a c1618a) {
            this.f4013a = c1618a;
        }
    }

    static {
        C1618a.m4541c();
        if (VERSION.SDK_INT > 8) {
            C1618a.m4540a();
        }
    }

    public static void m4540a() {
        if (CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    private static void m4541c() {
        if (VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private void m4542c(HttpURLConnection httpURLConnection) {
        for (String str : this.f4022i.keySet()) {
            httpURLConnection.setRequestProperty(str, (String) this.f4022i.get(str));
        }
    }

    protected int m4543a(int i) {
        return f4014f[i + 2] * 1000;
    }

    protected int m4544a(HttpURLConnection httpURLConnection, byte[] bArr) {
        OutputStream outputStream = null;
        try {
            outputStream = this.f4016a.mo2747a(httpURLConnection);
            if (outputStream != null) {
                this.f4016a.mo2749a(outputStream, bArr);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                }
            }
            return responseCode;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e2) {
                }
            }
        }
    }

    public C1618a m4545a(String str, String str2) {
        this.f4022i.put(str, str2);
        return this;
    }

    public C1631n m4546a(C1626l c1626l) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        while (i < this.f4021h) {
            try {
                m4562c(m4543a(i));
                if (this.f4018c.mo2758a()) {
                    this.f4018c.mo2756a((i + 1) + "of" + this.f4021h + ", trying " + c1626l.m4580a());
                }
                currentTimeMillis = System.currentTimeMillis();
                C1631n a = m4547a(c1626l.m4580a(), c1626l.m4581b(), c1626l.m4582c(), c1626l.m4583d());
                if (a != null) {
                    return a;
                }
                i++;
            } catch (C1630m e) {
                if (m4555a((Throwable) e, currentTimeMillis) && i < this.f4021h - 1) {
                    continue;
                } else if (!this.f4016a.mo2751a(e) || i >= this.f4021h - 1) {
                    throw e;
                } else {
                    try {
                        Thread.sleep((long) this.f4019d);
                    } catch (InterruptedException e2) {
                        throw e;
                    }
                }
            }
        }
        return null;
    }

    protected C1631n m4547a(String str, C1628j c1628j, String str2, byte[] bArr) {
        Throwable e;
        C1631n a;
        HttpURLConnection httpURLConnection;
        Exception exception;
        C1631n c1631n = null;
        Object obj = 1;
        C1631n c1631n2 = null;
        HttpURLConnection a2;
        try {
            this.f4023j = false;
            a2 = m4550a(str);
            try {
                m4553a(a2, c1628j, str2);
                m4542c(a2);
                if (this.f4018c.mo2758a()) {
                    this.f4018c.mo2757a(a2, bArr);
                }
                a2.connect();
                this.f4023j = true;
                Object obj2 = (this.f4025l == null || this.f4025l.isEmpty()) ? null : 1;
                if (this.f4024k == null || this.f4024k.isEmpty()) {
                    obj = null;
                }
                if ((a2 instanceof HttpsURLConnection) && !(obj2 == null && r1 == null)) {
                    try {
                        C1632o.m4594a((HttpsURLConnection) a2, this.f4025l, this.f4024k);
                    } catch (Throwable e2) {
                        Log.e(f4015g, "Unable to validate SSL certificates.", e2);
                    } catch (Throwable th) {
                        e2 = th;
                        if (this.f4018c.mo2758a()) {
                            this.f4018c.mo2755a(c1631n);
                        }
                        if (a2 != null) {
                            a2.disconnect();
                        }
                        throw e2;
                    }
                }
                if (a2.getDoOutput() && bArr != null) {
                    m4544a(a2, bArr);
                }
                a = a2.getDoInput() ? m4549a(a2) : new C1631n(a2, null);
                if (this.f4018c.mo2758a()) {
                    this.f4018c.mo2755a(a);
                }
                if (a2 == null) {
                    return a;
                }
                a2.disconnect();
                return a;
            } catch (Exception e3) {
                httpURLConnection = a2;
                exception = e3;
                try {
                    a = m4558b(httpURLConnection);
                    if (a != null) {
                        try {
                            if (a.m4588a() > 0) {
                                if (this.f4018c.mo2758a()) {
                                    this.f4018c.mo2755a(a);
                                }
                                if (httpURLConnection != null) {
                                    return a;
                                }
                                httpURLConnection.disconnect();
                                return a;
                            }
                        } catch (Throwable th2) {
                            c1631n = a;
                            e2 = th2;
                            a2 = httpURLConnection;
                            if (this.f4018c.mo2758a()) {
                                this.f4018c.mo2755a(c1631n);
                            }
                            if (a2 != null) {
                                a2.disconnect();
                            }
                            throw e2;
                        }
                    }
                    throw new C1630m(exception, a);
                } catch (Exception e4) {
                    exception.printStackTrace();
                    if (null != null) {
                        if (c1631n2.m4588a() > 0) {
                            if (this.f4018c.mo2758a()) {
                                this.f4018c.mo2755a(null);
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return null;
                        }
                    }
                    throw new C1630m(exception, c1631n2);
                } catch (Throwable th3) {
                    e2 = th3;
                    a2 = httpURLConnection;
                    if (this.f4018c.mo2758a()) {
                        this.f4018c.mo2755a(c1631n);
                    }
                    if (a2 != null) {
                        a2.disconnect();
                    }
                    throw e2;
                }
            } catch (Throwable th4) {
                e2 = th4;
                if (this.f4018c.mo2758a()) {
                    this.f4018c.mo2755a(c1631n);
                }
                if (a2 != null) {
                    a2.disconnect();
                }
                throw e2;
            }
        } catch (Exception e32) {
            exception = e32;
            httpURLConnection = null;
            a = m4558b(httpURLConnection);
            if (a != null) {
                if (a.m4588a() > 0) {
                    if (this.f4018c.mo2758a()) {
                        this.f4018c.mo2755a(a);
                    }
                    if (httpURLConnection != null) {
                        return a;
                    }
                    httpURLConnection.disconnect();
                    return a;
                }
            }
            throw new C1630m(exception, a);
        } catch (Throwable th5) {
            e2 = th5;
            a2 = null;
            if (this.f4018c.mo2758a()) {
                this.f4018c.mo2755a(c1631n);
            }
            if (a2 != null) {
                a2.disconnect();
            }
            throw e2;
        }
    }

    public C1631n m4548a(String str, C1633p c1633p) {
        return m4556b(new C1627i(str, c1633p));
    }

    protected C1631n m4549a(HttpURLConnection httpURLConnection) {
        InputStream b;
        Throwable th;
        byte[] bArr = null;
        try {
            b = this.f4016a.mo2753b(httpURLConnection);
            if (b != null) {
                try {
                    bArr = this.f4016a.mo2752a(b);
                } catch (Throwable th2) {
                    th = th2;
                    if (b != null) {
                        try {
                            b.close();
                        } catch (Exception e) {
                        }
                    }
                    throw th;
                }
            }
            C1631n c1631n = new C1631n(httpURLConnection, bArr);
            if (b != null) {
                try {
                    b.close();
                } catch (Exception e2) {
                }
            }
            return c1631n;
        } catch (Throwable th3) {
            th = th3;
            b = null;
            if (b != null) {
                b.close();
            }
            throw th;
        }
    }

    protected HttpURLConnection m4550a(String str) {
        try {
            URL url = new URL(str);
            return this.f4016a.mo2748a(str);
        } catch (Throwable e) {
            throw new IllegalArgumentException(str + " is not a valid URL", e);
        }
    }

    protected void m4551a(C1626l c1626l, C1619b c1619b) {
        this.f4017b.mo2754a(this, c1619b).mo2759a(c1626l);
    }

    public void m4552a(String str, C1633p c1633p, C1619b c1619b) {
        m4551a(new C1629k(str, c1633p), c1619b);
    }

    protected void m4553a(HttpURLConnection httpURLConnection, C1628j c1628j, String str) {
        httpURLConnection.setConnectTimeout(this.f4019d);
        httpURLConnection.setReadTimeout(this.f4020e);
        this.f4016a.mo2750a(httpURLConnection, c1628j, str);
    }

    public void m4554a(Set<String> set) {
        this.f4025l = set;
    }

    protected boolean m4555a(Throwable th, long j) {
        long currentTimeMillis = (System.currentTimeMillis() - j) + 10;
        if (this.f4018c.mo2758a()) {
            this.f4018c.mo2756a("ELAPSED TIME = " + currentTimeMillis + ", CT = " + this.f4019d + ", RT = " + this.f4020e);
        }
        return this.f4023j ? currentTimeMillis >= ((long) this.f4020e) : currentTimeMillis >= ((long) this.f4019d);
    }

    public C1631n m4556b(C1626l c1626l) {
        C1631n c1631n = null;
        try {
            c1631n = m4547a(c1626l.m4580a(), c1626l.m4581b(), c1626l.m4582c(), c1626l.m4583d());
        } catch (C1630m e) {
            this.f4016a.mo2751a(e);
        } catch (Exception e2) {
            this.f4016a.mo2751a(new C1630m(e2, c1631n));
        }
        return c1631n;
    }

    public C1631n m4557b(String str, C1633p c1633p) {
        return m4556b(new C1629k(str, c1633p));
    }

    protected C1631n m4558b(HttpURLConnection httpURLConnection) {
        Throwable th;
        byte[] bArr = null;
        InputStream errorStream;
        try {
            errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                try {
                    bArr = this.f4016a.mo2752a(errorStream);
                } catch (Throwable th2) {
                    th = th2;
                    if (errorStream != null) {
                        try {
                            errorStream.close();
                        } catch (Exception e) {
                        }
                    }
                    throw th;
                }
            }
            C1631n c1631n = new C1631n(httpURLConnection, bArr);
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception e2) {
                }
            }
            return c1631n;
        } catch (Throwable th3) {
            th = th3;
            errorStream = null;
            if (errorStream != null) {
                errorStream.close();
            }
            throw th;
        }
    }

    public C1633p m4559b() {
        return new C1633p();
    }

    public void m4560b(int i) {
        if (i < 1 || i > 18) {
            throw new IllegalArgumentException("Maximum retries must be between 1 and 18");
        }
        this.f4021h = i;
    }

    public void m4561b(Set<String> set) {
        this.f4024k = set;
    }

    public void m4562c(int i) {
        this.f4019d = i;
    }
}
