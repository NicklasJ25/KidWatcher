package com.google.android.gms.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.C2580e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class dd extends dn {

    @WorkerThread
    interface C2762a {
        void mo3567a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map);
    }

    @WorkerThread
    private static class C2763b implements Runnable {
        private final C2762a f8371a;
        private final int f8372b;
        private final Throwable f8373c;
        private final byte[] f8374d;
        private final String f8375e;
        private final Map<String, List<String>> f8376f;

        private C2763b(String str, C2762a c2762a, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
            C2513c.m7932a((Object) c2762a);
            this.f8371a = c2762a;
            this.f8372b = i;
            this.f8373c = th;
            this.f8374d = bArr;
            this.f8375e = str;
            this.f8376f = map;
        }

        public void run() {
            this.f8371a.mo3567a(this.f8375e, this.f8372b, this.f8373c, this.f8374d, this.f8376f);
        }
    }

    @WorkerThread
    private class C2764c implements Runnable {
        final /* synthetic */ dd f8377a;
        private final URL f8378b;
        private final byte[] f8379c;
        private final C2762a f8380d;
        private final String f8381e;
        private final Map<String, String> f8382f;

        public C2764c(dd ddVar, String str, URL url, byte[] bArr, Map<String, String> map, C2762a c2762a) {
            this.f8377a = ddVar;
            C2513c.m7934a(str);
            C2513c.m7932a((Object) url);
            C2513c.m7932a((Object) c2762a);
            this.f8378b = url;
            this.f8379c = bArr;
            this.f8380d = c2762a;
            this.f8381e = str;
            this.f8382f = map;
        }

        public void run() {
            HttpURLConnection a;
            OutputStream outputStream;
            Throwable e;
            Map map;
            int i;
            HttpURLConnection httpURLConnection;
            Throwable th;
            Map map2;
            this.f8377a.mo3531d();
            int i2 = 0;
            try {
                a = this.f8377a.m9821a(this.f8378b);
                try {
                    if (this.f8382f != null) {
                        for (Entry entry : this.f8382f.entrySet()) {
                            a.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    if (this.f8379c != null) {
                        byte[] a2 = this.f8377a.mo3544q().m10411a(this.f8379c);
                        this.f8377a.mo3548u().m9786D().m9775a("Uploading data. size", Integer.valueOf(a2.length));
                        a.setDoOutput(true);
                        a.addRequestProperty("Content-Encoding", "gzip");
                        a.setFixedLengthStreamingMode(a2.length);
                        a.connect();
                        outputStream = a.getOutputStream();
                        try {
                            outputStream.write(a2);
                            outputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            map = null;
                            i = 0;
                            httpURLConnection = a;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e3) {
                                    this.f8377a.mo3548u().m9815x().m9776a("Error closing HTTP compressed POST connection output stream. appId", dc.m9779a(this.f8381e), e3);
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            this.f8377a.mo3547t().m9938a(new C2763b(this.f8381e, this.f8380d, i, e, null, map));
                        } catch (Throwable th2) {
                            th = th2;
                            map2 = null;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e32) {
                                    this.f8377a.mo3548u().m9815x().m9776a("Error closing HTTP compressed POST connection output stream. appId", dc.m9779a(this.f8381e), e32);
                                }
                            }
                            if (a != null) {
                                a.disconnect();
                            }
                            this.f8377a.mo3547t().m9938a(new C2763b(this.f8381e, this.f8380d, i2, null, null, map2));
                            throw th;
                        }
                    }
                    i2 = a.getResponseCode();
                    map2 = a.getHeaderFields();
                } catch (IOException e4) {
                    e = e4;
                    map = null;
                    i = i2;
                    outputStream = null;
                    httpURLConnection = a;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.f8377a.mo3547t().m9938a(new C2763b(this.f8381e, this.f8380d, i, e, null, map));
                } catch (Throwable th3) {
                    th = th3;
                    map2 = null;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    this.f8377a.mo3547t().m9938a(new C2763b(this.f8381e, this.f8380d, i2, null, null, map2));
                    throw th;
                }
                try {
                    byte[] a3 = this.f8377a.m9820a(a);
                    if (a != null) {
                        a.disconnect();
                    }
                    this.f8377a.mo3547t().m9938a(new C2763b(this.f8381e, this.f8380d, i2, null, a3, map2));
                } catch (IOException e5) {
                    e = e5;
                    map = map2;
                    i = i2;
                    outputStream = null;
                    httpURLConnection = a;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.f8377a.mo3547t().m9938a(new C2763b(this.f8381e, this.f8380d, i, e, null, map));
                } catch (Throwable th32) {
                    th = th32;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    this.f8377a.mo3547t().m9938a(new C2763b(this.f8381e, this.f8380d, i2, null, null, map2));
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                map = null;
                i = 0;
                outputStream = null;
                httpURLConnection = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                this.f8377a.mo3547t().m9938a(new C2763b(this.f8381e, this.f8380d, i, e, null, map));
            } catch (Throwable th322) {
                th = th322;
                map2 = null;
                a = null;
                outputStream = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                this.f8377a.mo3547t().m9938a(new C2763b(this.f8381e, this.f8380d, i2, null, null, map2));
                throw th;
            }
        }
    }

    public dd(dk dkVar) {
        super(dkVar);
    }

    @WorkerThread
    private byte[] m9820a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            return toByteArray;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @WorkerThread
    protected HttpURLConnection m9821a(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            mo3550w().m9484Q();
            httpURLConnection.setConnectTimeout(60000);
            mo3550w().m9485R();
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain HTTP connection");
    }

    protected void mo3551a() {
    }

    @WorkerThread
    public void m9823a(String str, URL url, Map<String, String> map, C2762a c2762a) {
        mo3532e();
        m9448R();
        C2513c.m7932a((Object) url);
        C2513c.m7932a((Object) c2762a);
        mo3547t().m9941b(new C2764c(this, str, url, null, map, c2762a));
    }

    @WorkerThread
    public void m9824a(String str, URL url, byte[] bArr, Map<String, String> map, C2762a c2762a) {
        mo3532e();
        m9448R();
        C2513c.m7932a((Object) url);
        C2513c.m7932a((Object) bArr);
        C2513c.m7932a((Object) c2762a);
        mo3547t().m9941b(new C2764c(this, str, url, bArr, map, c2762a));
    }

    public /* bridge */ /* synthetic */ void mo3529b() {
        super.mo3529b();
    }

    public /* bridge */ /* synthetic */ void mo3530c() {
        super.mo3530c();
    }

    public /* bridge */ /* synthetic */ void mo3531d() {
        super.mo3531d();
    }

    public /* bridge */ /* synthetic */ void mo3532e() {
        super.mo3532e();
    }

    public /* bridge */ /* synthetic */ ck mo3533f() {
        return super.mo3533f();
    }

    public /* bridge */ /* synthetic */ cn mo3534g() {
        return super.mo3534g();
    }

    public /* bridge */ /* synthetic */ dp mo3535h() {
        return super.mo3535h();
    }

    public /* bridge */ /* synthetic */ cz mo3536i() {
        return super.mo3536i();
    }

    public /* bridge */ /* synthetic */ cs mo3537j() {
        return super.mo3537j();
    }

    public /* bridge */ /* synthetic */ dr mo3538k() {
        return super.mo3538k();
    }

    public /* bridge */ /* synthetic */ dq mo3539l() {
        return super.mo3539l();
    }

    public /* bridge */ /* synthetic */ C2580e mo3540m() {
        return super.mo3540m();
    }

    public /* bridge */ /* synthetic */ Context mo3541n() {
        return super.mo3541n();
    }

    public /* bridge */ /* synthetic */ da mo3542o() {
        return super.mo3542o();
    }

    public /* bridge */ /* synthetic */ cq mo3543p() {
        return super.mo3543p();
    }

    public /* bridge */ /* synthetic */ dy mo3544q() {
        return super.mo3544q();
    }

    public /* bridge */ /* synthetic */ di mo3545r() {
        return super.mo3545r();
    }

    public /* bridge */ /* synthetic */ dt mo3546s() {
        return super.mo3546s();
    }

    public /* bridge */ /* synthetic */ dj mo3547t() {
        return super.mo3547t();
    }

    public /* bridge */ /* synthetic */ dc mo3548u() {
        return super.mo3548u();
    }

    public /* bridge */ /* synthetic */ dg mo3549v() {
        return super.mo3549v();
    }

    public /* bridge */ /* synthetic */ cp mo3550w() {
        return super.mo3550w();
    }

    public boolean m9847x() {
        NetworkInfo activeNetworkInfo;
        m9448R();
        try {
            activeNetworkInfo = ((ConnectivityManager) mo3541n().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
