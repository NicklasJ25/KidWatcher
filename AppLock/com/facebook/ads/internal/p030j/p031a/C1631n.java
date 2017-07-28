package com.facebook.ads.internal.p030j.p031a;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public class C1631n {
    private int f4039a;
    private String f4040b;
    private Map<String, List<String>> f4041c;
    private byte[] f4042d;

    public C1631n(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            this.f4039a = httpURLConnection.getResponseCode();
            this.f4040b = httpURLConnection.getURL().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f4041c = httpURLConnection.getHeaderFields();
        this.f4042d = bArr;
    }

    public int m4588a() {
        return this.f4039a;
    }

    public String m4589b() {
        return this.f4040b;
    }

    public Map<String, List<String>> m4590c() {
        return this.f4041c;
    }

    public byte[] m4591d() {
        return this.f4042d;
    }

    public String m4592e() {
        return this.f4042d != null ? new String(this.f4042d) : null;
    }
}
