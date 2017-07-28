package com.google.android.gms.internal;

import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class abn implements abp {
    protected final HttpClient f7820a;

    public static final class C2666a extends HttpEntityEnclosingRequestBase {
        public C2666a(String str) {
            setURI(URI.create(str));
        }

        public String getMethod() {
            return "PATCH";
        }
    }

    public abn(HttpClient httpClient) {
        this.f7820a = httpClient;
    }

    private static void m8798a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, vb<?> vbVar) {
        byte[] k = vbVar.mo4270k();
        if (k != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(k));
        }
    }

    private static void m8799a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, (String) map.get(str));
        }
    }

    static HttpUriRequest m8800b(vb<?> vbVar, Map<String, String> map) {
        HttpEntityEnclosingRequestBase httpPost;
        switch (vbVar.m9042a()) {
            case -1:
                byte[] h = vbVar.m9060h();
                if (h == null) {
                    return new HttpGet(vbVar.m9054c());
                }
                HttpUriRequest httpPost2 = new HttpPost(vbVar.m9054c());
                httpPost2.addHeader("Content-Type", vbVar.m9059g());
                httpPost2.setEntity(new ByteArrayEntity(h));
                return httpPost2;
            case 0:
                return new HttpGet(vbVar.m9054c());
            case 1:
                httpPost = new HttpPost(vbVar.m9054c());
                httpPost.addHeader("Content-Type", vbVar.m9062j());
                m8798a(httpPost, (vb) vbVar);
                return httpPost;
            case 2:
                httpPost = new HttpPut(vbVar.m9054c());
                httpPost.addHeader("Content-Type", vbVar.m9062j());
                m8798a(httpPost, (vb) vbVar);
                return httpPost;
            case 3:
                return new HttpDelete(vbVar.m9054c());
            case 4:
                return new HttpHead(vbVar.m9054c());
            case 5:
                return new HttpOptions(vbVar.m9054c());
            case 6:
                return new HttpTrace(vbVar.m9054c());
            case 7:
                httpPost = new C2666a(vbVar.m9054c());
                httpPost.addHeader("Content-Type", vbVar.m9062j());
                m8798a(httpPost, (vb) vbVar);
                return httpPost;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    public HttpResponse mo3463a(vb<?> vbVar, Map<String, String> map) {
        HttpUriRequest b = m8800b(vbVar, map);
        m8799a(b, (Map) map);
        m8799a(b, vbVar.mo4269f());
        HttpParams params = b.getParams();
        int n = vbVar.m9066n();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, n);
        return this.f7820a.execute(b);
    }
}
