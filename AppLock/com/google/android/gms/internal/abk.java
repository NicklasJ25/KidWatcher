package com.google.android.gms.internal;

import com.google.android.gms.internal.ej.C2847a;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class abk implements px {
    protected static final boolean f7797a = abj.f7796b;
    private static int f7798d = 3000;
    private static int f7799e = 4096;
    protected final abp f7800b;
    protected final abl f7801c;

    public abk(abp com_google_android_gms_internal_abp) {
        this(com_google_android_gms_internal_abp, new abl(f7799e));
    }

    public abk(abp com_google_android_gms_internal_abp, abl com_google_android_gms_internal_abl) {
        this.f7800b = com_google_android_gms_internal_abp;
        this.f7801c = com_google_android_gms_internal_abl;
    }

    protected static Map<String, String> m8761a(Header[] headerArr) {
        Map<String, String> treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    private void m8762a(long j, vb<?> vbVar, byte[] bArr, StatusLine statusLine) {
        if (f7797a || j > ((long) f7798d)) {
            String str = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";
            Object[] objArr = new Object[5];
            objArr[0] = vbVar;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(vbVar.m9067o().mo3860b());
            abj.m8757b(str, objArr);
        }
    }

    private static void m8763a(String str, vb<?> vbVar, abi com_google_android_gms_internal_abi) {
        yw o = vbVar.m9067o();
        int n = vbVar.m9066n();
        try {
            o.mo3859a(com_google_android_gms_internal_abi);
            vbVar.m9053b(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(n)}));
        } catch (abi e) {
            vbVar.m9053b(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(n)}));
            throw e;
        }
    }

    private void m8764a(Map<String, String> map, C2847a c2847a) {
        if (c2847a != null) {
            if (c2847a.f8828b != null) {
                map.put("If-None-Match", c2847a.f8828b);
            }
            if (c2847a.f8830d > 0) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(c2847a.f8830d)));
            }
        }
    }

    private byte[] m8765a(HttpEntity httpEntity) {
        aa aaVar = new aa(this.f7801c, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new zx();
            }
            bArr = this.f7801c.m8770a(1024);
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                aaVar.write(bArr, 0, read);
            }
            byte[] toByteArray = aaVar.toByteArray();
            return toByteArray;
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException e) {
                abj.m8755a("Error occured when calling consumingContent", new Object[0]);
            }
            this.f7801c.m8769a(bArr);
            aaVar.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.sz mo3459a(com.google.android.gms.internal.vb<?> r19) {
        /*
        r18 = this;
        r16 = android.os.SystemClock.elapsedRealtime();
    L_0x0004:
        r3 = 0;
        r14 = 0;
        r6 = java.util.Collections.emptyMap();
        r2 = new java.util.HashMap;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00de }
        r2.<init>();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00de }
        r4 = r19.m9057e();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00de }
        r0 = r18;
        r0.m8764a(r2, r4);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00de }
        r0 = r18;
        r4 = r0.f7800b;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00de }
        r0 = r19;
        r15 = r4.mo3463a(r0, r2);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00de }
        r12 = r15.getStatusLine();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
        r4 = r12.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
        r2 = r15.getAllHeaders();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
        r6 = m8761a(r2);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
        r2 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r4 != r2) goto L_0x0065;
    L_0x0036:
        r2 = r19.m9057e();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
        if (r2 != 0) goto L_0x004c;
    L_0x003c:
        r3 = new com.google.android.gms.internal.sz;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
        r4 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r5 = 0;
        r7 = 1;
        r8 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
        r8 = r8 - r16;
        r3.<init>(r4, r5, r6, r7, r8);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
    L_0x004b:
        return r3;
    L_0x004c:
        r3 = r2.f8833g;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
        r3.putAll(r6);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
        r7 = new com.google.android.gms.internal.sz;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
        r8 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r9 = r2.f8827a;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
        r10 = r2.f8833g;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
        r11 = 1;
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
        r12 = r2 - r16;
        r7.<init>(r8, r9, r10, r11, r12);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
        r3 = r7;
        goto L_0x004b;
    L_0x0065:
        r2 = r15.getEntity();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
        if (r2 == 0) goto L_0x009f;
    L_0x006b:
        r2 = r15.getEntity();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
        r0 = r18;
        r11 = r0.m8765a(r2);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
    L_0x0075:
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015e }
        r8 = r2 - r16;
        r7 = r18;
        r10 = r19;
        r7.m8762a(r8, r10, r11, r12);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015e }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r4 < r2) goto L_0x008a;
    L_0x0086:
        r2 = 299; // 0x12b float:4.19E-43 double:1.477E-321;
        if (r4 <= r2) goto L_0x00a3;
    L_0x008a:
        r2 = new java.io.IOException;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015e }
        r2.<init>();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015e }
        throw r2;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015e }
    L_0x0090:
        r2 = move-exception;
        r2 = "socket";
        r3 = new com.google.android.gms.internal.aax;
        r3.<init>();
        r0 = r19;
        m8763a(r2, r0, r3);
        goto L_0x0004;
    L_0x009f:
        r2 = 0;
        r11 = new byte[r2];	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015a }
        goto L_0x0075;
    L_0x00a3:
        r3 = new com.google.android.gms.internal.sz;	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015e }
        r7 = 0;
        r8 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015e }
        r8 = r8 - r16;
        r5 = r11;
        r3.<init>(r4, r5, r6, r7, r8);	 Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x015e }
        goto L_0x004b;
    L_0x00b1:
        r2 = move-exception;
        r2 = "connection";
        r3 = new com.google.android.gms.internal.aax;
        r3.<init>();
        r0 = r19;
        m8763a(r2, r0, r3);
        goto L_0x0004;
    L_0x00c0:
        r2 = move-exception;
        r3 = new java.lang.RuntimeException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Bad URL ";
        r4 = r4.append(r5);
        r5 = r19.m9054c();
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.<init>(r4, r2);
        throw r3;
    L_0x00de:
        r2 = move-exception;
        r5 = r14;
    L_0x00e0:
        if (r3 == 0) goto L_0x0124;
    L_0x00e2:
        r2 = r3.getStatusLine();
        r4 = r2.getStatusCode();
        r2 = "Unexpected response code %d for %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r7 = 0;
        r8 = java.lang.Integer.valueOf(r4);
        r3[r7] = r8;
        r7 = 1;
        r8 = r19.m9054c();
        r3[r7] = r8;
        com.google.android.gms.internal.abj.m8758c(r2, r3);
        if (r5 == 0) goto L_0x014c;
    L_0x0102:
        r3 = new com.google.android.gms.internal.sz;
        r7 = 0;
        r8 = android.os.SystemClock.elapsedRealtime();
        r8 = r8 - r16;
        r3.<init>(r4, r5, r6, r7, r8);
        r2 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r4 == r2) goto L_0x0116;
    L_0x0112:
        r2 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r4 != r2) goto L_0x012a;
    L_0x0116:
        r2 = "auth";
        r4 = new com.google.android.gms.internal.a;
        r4.<init>(r3);
        r0 = r19;
        m8763a(r2, r0, r4);
        goto L_0x0004;
    L_0x0124:
        r3 = new com.google.android.gms.internal.ua;
        r3.<init>(r2);
        throw r3;
    L_0x012a:
        r2 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r4 < r2) goto L_0x0138;
    L_0x012e:
        r2 = 499; // 0x1f3 float:6.99E-43 double:2.465E-321;
        if (r4 > r2) goto L_0x0138;
    L_0x0132:
        r2 = new com.google.android.gms.internal.nc;
        r2.<init>(r3);
        throw r2;
    L_0x0138:
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r4 < r2) goto L_0x0146;
    L_0x013c:
        r2 = 599; // 0x257 float:8.4E-43 double:2.96E-321;
        if (r4 > r2) goto L_0x0146;
    L_0x0140:
        r2 = new com.google.android.gms.internal.zx;
        r2.<init>(r3);
        throw r2;
    L_0x0146:
        r2 = new com.google.android.gms.internal.zx;
        r2.<init>(r3);
        throw r2;
    L_0x014c:
        r2 = "network";
        r3 = new com.google.android.gms.internal.ry;
        r3.<init>();
        r0 = r19;
        m8763a(r2, r0, r3);
        goto L_0x0004;
    L_0x015a:
        r2 = move-exception;
        r5 = r14;
        r3 = r15;
        goto L_0x00e0;
    L_0x015e:
        r2 = move-exception;
        r5 = r11;
        r3 = r15;
        goto L_0x00e0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.abk.a(com.google.android.gms.internal.vb):com.google.android.gms.internal.sz");
    }
}
