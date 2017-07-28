package com.google.android.gms.internal;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class C2704b implements abp {
    private final C2703a f7968a;
    private final SSLSocketFactory f7969b;

    public interface C2703a {
        String m9083a(String str);
    }

    public C2704b() {
        this(null);
    }

    public C2704b(C2703a c2703a) {
        this(c2703a, null);
    }

    public C2704b(C2703a c2703a, SSLSocketFactory sSLSocketFactory) {
        this.f7968a = c2703a;
        this.f7969b = sSLSocketFactory;
    }

    private HttpURLConnection m9084a(URL url, vb<?> vbVar) {
        HttpURLConnection a = m9089a(url);
        int n = vbVar.m9066n();
        a.setConnectTimeout(n);
        a.setReadTimeout(n);
        a.setUseCaches(false);
        a.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.f7969b != null) {
            ((HttpsURLConnection) a).setSSLSocketFactory(this.f7969b);
        }
        return a;
    }

    private static HttpEntity m9085a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        HttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    static void m9086a(HttpURLConnection httpURLConnection, vb<?> vbVar) {
        switch (vbVar.m9042a()) {
            case -1:
                byte[] h = vbVar.m9060h();
                if (h != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty("Content-Type", vbVar.m9059g());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(h);
                    dataOutputStream.close();
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                C2704b.m9088b(httpURLConnection, vbVar);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                C2704b.m9088b(httpURLConnection, vbVar);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                C2704b.m9088b(httpURLConnection, vbVar);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static boolean m9087a(int i, int i2) {
        return (i == 4 || ((100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304)) ? false : true;
    }

    private static void m9088b(HttpURLConnection httpURLConnection, vb<?> vbVar) {
        byte[] k = vbVar.mo4270k();
        if (k != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", vbVar.m9062j());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(k);
            dataOutputStream.close();
        }
    }

    protected HttpURLConnection m9089a(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    public HttpResponse mo3463a(vb<?> vbVar, Map<String, String> map) {
        String a;
        String c = vbVar.m9054c();
        HashMap hashMap = new HashMap();
        hashMap.putAll(vbVar.mo4269f());
        hashMap.putAll(map);
        if (this.f7968a != null) {
            a = this.f7968a.m9083a(c);
            if (a == null) {
                throw new IOException("URL blocked by rewriter: " + c);
            }
        }
        a = c;
        HttpURLConnection a2 = m9084a(new URL(a), (vb) vbVar);
        for (String a3 : hashMap.keySet()) {
            a2.addRequestProperty(a3, (String) hashMap.get(a3));
        }
        C2704b.m9086a(a2, (vb) vbVar);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (a2.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        StatusLine basicStatusLine = new BasicStatusLine(protocolVersion, a2.getResponseCode(), a2.getResponseMessage());
        HttpResponse basicHttpResponse = new BasicHttpResponse(basicStatusLine);
        if (C2704b.m9087a(vbVar.m9042a(), basicStatusLine.getStatusCode())) {
            basicHttpResponse.setEntity(C2704b.m9085a(a2));
        }
        for (Entry entry : a2.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
            }
        }
        return basicHttpResponse;
    }
}
