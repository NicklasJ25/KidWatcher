package com.google.android.gms.internal;

import java.lang.Thread.State;
import java.net.Socket;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class kp {
    private static final AtomicInteger f9651a = new AtomicInteger(0);
    private static final Charset f9652b = Charset.forName("UTF-8");
    private static ThreadFactory f9653l = Executors.defaultThreadFactory();
    private static ko f9654m = new C30321();
    private volatile C3035a f9655c = C3035a.NONE;
    private volatile Socket f9656d = null;
    private kq f9657e = null;
    private final URI f9658f;
    private final ku f9659g;
    private final kv f9660h;
    private final ks f9661i;
    private final int f9662j = f9651a.incrementAndGet();
    private final Thread f9663k = m12218a().newThread(new C30332(this));

    class C30321 implements ko {
        C30321() {
        }

        public void mo3704a(Thread thread, String str) {
            thread.setName(str);
        }
    }

    class C30332 implements Runnable {
        final /* synthetic */ kp f9643a;

        C30332(kp kpVar) {
            this.f9643a = kpVar;
        }

        public void run() {
            this.f9643a.m12226l();
        }
    }

    private enum C3035a {
        NONE,
        CONNECTING,
        CONNECTED,
        DISCONNECTING,
        DISCONNECTED
    }

    public kp(URI uri, String str, Map<String, String> map) {
        this.f9658f = uri;
        this.f9661i = new ks(uri, str, map);
        this.f9659g = new ku(this);
        this.f9660h = new kv(this, "TubeSock", this.f9662j);
    }

    static ThreadFactory m12218a() {
        return f9653l;
    }

    private synchronized void m12219a(byte b, byte[] bArr) {
        if (this.f9655c != C3035a.CONNECTED) {
            this.f9657e.mo3691a(new kr("error while sending data: not connected"));
        } else {
            try {
                this.f9660h.m12259a(b, true, bArr);
            } catch (Throwable e) {
                this.f9657e.mo3691a(new kr("Failed to send frame", e));
                m12233e();
            }
        }
    }

    public static void m12221a(ThreadFactory threadFactory, ko koVar) {
        f9653l = threadFactory;
        f9654m = koVar;
    }

    static ko m12222b() {
        return f9654m;
    }

    private synchronized void m12223i() {
        if (this.f9655c != C3035a.DISCONNECTED) {
            this.f9659g.m12251b();
            this.f9660h.m12258a();
            if (this.f9656d != null) {
                try {
                    this.f9656d.close();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
            this.f9655c = C3035a.DISCONNECTED;
            this.f9657e.mo3696d();
        }
    }

    private void m12224j() {
        try {
            this.f9655c = C3035a.DISCONNECTING;
            this.f9660h.m12258a();
            this.f9660h.m12259a((byte) 8, true, new byte[0]);
        } catch (Throwable e) {
            this.f9657e.mo3691a(new kr("Failed to send close frame", e));
        }
    }

    private Socket m12225k() {
        Throwable th;
        String str;
        String valueOf;
        String scheme = this.f9658f.getScheme();
        String host = this.f9658f.getHost();
        int port = this.f9658f.getPort();
        if (scheme != null && scheme.equals("ws")) {
            try {
                return new Socket(host, port == -1 ? 80 : port);
            } catch (Throwable e) {
                th = e;
                str = "unknown host: ";
                valueOf = String.valueOf(host);
                throw new kr(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
            } catch (Throwable e2) {
                host = String.valueOf(this.f9658f);
                throw new kr(new StringBuilder(String.valueOf(host).length() + 31).append("error while creating socket to ").append(host).toString(), e2);
            }
        } else if (scheme == null || !scheme.equals("wss")) {
            String str2 = "unsupported protocol: ";
            valueOf = String.valueOf(scheme);
            throw new kr(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else {
            if (port == -1) {
                port = 443;
            }
            try {
                SSLSocket sSLSocket = (SSLSocket) SSLSocketFactory.getDefault().createSocket(host, port);
                if (HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sSLSocket.getSession())) {
                    return sSLSocket;
                }
                scheme = String.valueOf(this.f9658f);
                throw new kr(new StringBuilder(String.valueOf(scheme).length() + 39).append("Error while verifying secure socket to ").append(scheme).toString());
            } catch (Throwable e22) {
                th = e22;
                str = "unknown host: ";
                valueOf = String.valueOf(host);
                throw new kr(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
            } catch (Throwable e222) {
                host = String.valueOf(this.f9658f);
                throw new kr(new StringBuilder(String.valueOf(host).length() + 38).append("error while creating secure socket to ").append(host).toString(), e222);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m12226l() {
        /*
        r11 = this;
        r4 = 1;
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r1 = 0;
        r0 = r11.m12225k();	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        monitor-enter(r11);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r11.f9656d = r0;	 Catch:{ all -> 0x0025 }
        r2 = r11.f9655c;	 Catch:{ all -> 0x0025 }
        r3 = com.google.android.gms.internal.kp.C3035a.DISCONNECTED;	 Catch:{ all -> 0x0025 }
        if (r2 != r3) goto L_0x0032;
    L_0x0011:
        r0 = r11.f9656d;	 Catch:{ IOException -> 0x001e }
        r0.close();	 Catch:{ IOException -> 0x001e }
        r0 = 0;
        r11.f9656d = r0;	 Catch:{ all -> 0x0025 }
        monitor-exit(r11);	 Catch:{ all -> 0x0025 }
        r11.m12233e();
    L_0x001d:
        return;
    L_0x001e:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;	 Catch:{ all -> 0x0025 }
        r1.<init>(r0);	 Catch:{ all -> 0x0025 }
        throw r1;	 Catch:{ all -> 0x0025 }
    L_0x0025:
        r0 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x0025 }
        throw r0;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
    L_0x0028:
        r0 = move-exception;
        r1 = r11.f9657e;	 Catch:{ all -> 0x00e1 }
        r1.mo3691a(r0);	 Catch:{ all -> 0x00e1 }
        r11.m12233e();
        goto L_0x001d;
    L_0x0032:
        monitor-exit(r11);	 Catch:{ all -> 0x0025 }
        r5 = new java.io.DataInputStream;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r2 = r0.getInputStream();	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r5.<init>(r2);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r6 = r0.getOutputStream();	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0 = r11.f9661i;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0 = r0.m12242a();	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r6.write(r0);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = new byte[r0];	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r7 = new java.util.ArrayList;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r7.<init>();	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0 = r1;
        r3 = r1;
    L_0x0054:
        if (r3 != 0) goto L_0x00ec;
    L_0x0056:
        r8 = r5.read();	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r9 = -1;
        if (r8 != r9) goto L_0x0088;
    L_0x005d:
        r0 = new com.google.android.gms.internal.kr;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r1 = "Connection closed before handshake was complete";
        r0.<init>(r1);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        throw r0;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
    L_0x0065:
        r0 = move-exception;
        r2 = r11.f9657e;	 Catch:{ all -> 0x00e1 }
        r3 = new com.google.android.gms.internal.kr;	 Catch:{ all -> 0x00e1 }
        r4 = "error while connecting: ";
        r1 = r0.getMessage();	 Catch:{ all -> 0x00e1 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x00e1 }
        r5 = r1.length();	 Catch:{ all -> 0x00e1 }
        if (r5 == 0) goto L_0x014d;
    L_0x007a:
        r1 = r4.concat(r1);	 Catch:{ all -> 0x00e1 }
    L_0x007e:
        r3.<init>(r1, r0);	 Catch:{ all -> 0x00e1 }
        r2.mo3691a(r3);	 Catch:{ all -> 0x00e1 }
        r11.m12233e();
        goto L_0x001d;
    L_0x0088:
        r8 = (byte) r8;
        r2[r0] = r8;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0 = r0 + 1;
        r8 = r0 + -1;
        r8 = r2[r8];	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r9 = 10;
        if (r8 != r9) goto L_0x00c2;
    L_0x0095:
        r8 = r0 + -2;
        r8 = r2[r8];	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r9 = 13;
        if (r8 != r9) goto L_0x00c2;
    L_0x009d:
        r0 = new java.lang.String;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r8 = f9652b;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0.<init>(r2, r8);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r2 = r0.trim();	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r8 = "";
        r2 = r2.equals(r8);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        if (r2 == 0) goto L_0x00b9;
    L_0x00b0:
        r2 = r4;
    L_0x00b1:
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = new byte[r0];	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r3 = r2;
        r2 = r0;
        r0 = r1;
        goto L_0x0054;
    L_0x00b9:
        r0 = r0.trim();	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r7.add(r0);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r2 = r3;
        goto L_0x00b1;
    L_0x00c2:
        if (r0 != r10) goto L_0x0054;
    L_0x00c4:
        r0 = new java.lang.String;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r1 = f9652b;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0.<init>(r2, r1);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r1 = new com.google.android.gms.internal.kr;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r2 = "Unexpected long line in handshake: ";
        r0 = java.lang.String.valueOf(r0);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r3 = r0.length();	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        if (r3 == 0) goto L_0x00e6;
    L_0x00d9:
        r0 = r2.concat(r0);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
    L_0x00dd:
        r1.<init>(r0);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        throw r1;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
    L_0x00e1:
        r0 = move-exception;
        r11.m12233e();
        throw r0;
    L_0x00e6:
        r0 = new java.lang.String;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0.<init>(r2);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        goto L_0x00dd;
    L_0x00ec:
        r1 = r11.f9661i;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0 = 0;
        r0 = r7.get(r0);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0 = (java.lang.String) r0;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r1.m12240a(r0);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0 = 0;
        r7.remove(r0);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r1 = new java.util.HashMap;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r1.<init>();	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r2 = r7.iterator();	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
    L_0x0105:
        r0 = r2.hasNext();	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        if (r0 == 0) goto L_0x0122;
    L_0x010b:
        r0 = r2.next();	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0 = (java.lang.String) r0;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r3 = ": ";
        r4 = 2;
        r0 = r0.split(r3, r4);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r3 = 0;
        r3 = r0[r3];	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r4 = 1;
        r0 = r0[r4];	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r1.put(r3, r0);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        goto L_0x0105;
    L_0x0122:
        r0 = r11.f9661i;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0.m12241a(r1);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0 = r11.f9660h;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0.m12260a(r6);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0 = r11.f9659g;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0.m12250a(r5);	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0 = com.google.android.gms.internal.kp.C3035a.CONNECTED;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r11.f9655c = r0;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0 = r11.f9660h;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0 = r0.m12261b();	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0.start();	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0 = r11.f9657e;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0.mo3695c();	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0 = r11.f9659g;	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r0.m12249a();	 Catch:{ kr -> 0x0028, IOException -> 0x0065 }
        r11.m12233e();
        goto L_0x001d;
    L_0x014d:
        r1 = new java.lang.String;	 Catch:{ all -> 0x00e1 }
        r1.<init>(r4);	 Catch:{ all -> 0x00e1 }
        goto L_0x007e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.kp.l():void");
    }

    public void m12227a(kq kqVar) {
        this.f9657e = kqVar;
    }

    void m12228a(kr krVar) {
        this.f9657e.mo3691a(krVar);
        if (this.f9655c == C3035a.CONNECTED) {
            m12233e();
        }
        m12223i();
    }

    public synchronized void m12229a(String str) {
        m12219a((byte) 1, str.getBytes(f9652b));
    }

    synchronized void m12230a(byte[] bArr) {
        m12219a((byte) 10, bArr);
    }

    kq m12231c() {
        return this.f9657e;
    }

    public synchronized void m12232d() {
        if (this.f9655c != C3035a.NONE) {
            this.f9657e.mo3691a(new kr("connect() already called"));
            m12233e();
        } else {
            ko b = m12222b();
            Thread h = m12236h();
            String valueOf = String.valueOf("TubeSockReader-");
            b.mo3704a(h, new StringBuilder(String.valueOf(valueOf).length() + 11).append(valueOf).append(this.f9662j).toString());
            this.f9655c = C3035a.CONNECTING;
            m12236h().start();
        }
    }

    public synchronized void m12233e() {
        switch (this.f9655c) {
            case NONE:
                this.f9655c = C3035a.DISCONNECTED;
                break;
            case CONNECTING:
                m12223i();
                break;
            case CONNECTED:
                m12224j();
                break;
        }
    }

    void m12234f() {
        m12223i();
    }

    public void m12235g() {
        if (this.f9660h.m12261b().getState() != State.NEW) {
            this.f9660h.m12261b().join();
        }
        m12236h().join();
    }

    Thread m12236h() {
        return this.f9663k;
    }
}
