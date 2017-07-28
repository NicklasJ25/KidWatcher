package com.google.android.gms.internal;

import java.io.EOFException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class gt {
    private static long f9116a = 0;
    private C2917b f9117b;
    private boolean f9118c = false;
    private boolean f9119d = false;
    private long f9120e = 0;
    private gv f9121f;
    private C2898a f9122g;
    private ScheduledFuture<?> f9123h;
    private ScheduledFuture<?> f9124i;
    private final gl f9125j;
    private final ScheduledExecutorService f9126k;
    private final jp f9127l;

    public interface C2898a {
        void mo3664a(Map<String, Object> map);

        void mo3665a(boolean z);
    }

    class C29151 implements Runnable {
        final /* synthetic */ gt f9106a;

        C29151(gt gtVar) {
            this.f9106a = gtVar;
        }

        public void run() {
            this.f9106a.m11249h();
        }
    }

    class C29162 implements Runnable {
        final /* synthetic */ gt f9107a;

        C29162(gt gtVar) {
            this.f9107a = gtVar;
        }

        public void run() {
            if (this.f9107a.f9117b != null) {
                this.f9107a.f9117b.mo3693a("0");
                this.f9107a.m11238c();
            }
        }
    }

    private interface C2917b {
        void mo3690a();

        void mo3693a(String str);

        void mo3694b();
    }

    private class C2922c implements C2917b, kq {
        final /* synthetic */ gt f9114a;
        private kp f9115b;

        class C29181 implements Runnable {
            final /* synthetic */ C2922c f9108a;

            C29181(C2922c c2922c) {
                this.f9108a = c2922c;
            }

            public void run() {
                this.f9108a.f9114a.f9124i.cancel(false);
                this.f9108a.f9114a.f9118c = true;
                if (this.f9108a.f9114a.f9127l.m11961a()) {
                    this.f9108a.f9114a.f9127l.m11960a("websocket opened", new Object[0]);
                }
                this.f9108a.f9114a.m11238c();
            }
        }

        class C29203 implements Runnable {
            final /* synthetic */ C2922c f9111a;

            C29203(C2922c c2922c) {
                this.f9111a = c2922c;
            }

            public void run() {
                if (this.f9111a.f9114a.f9127l.m11961a()) {
                    this.f9111a.f9114a.f9127l.m11960a("closed", new Object[0]);
                }
                this.f9111a.f9114a.m11245f();
            }
        }

        private C2922c(gt gtVar, kp kpVar) {
            this.f9114a = gtVar;
            this.f9115b = kpVar;
            this.f9115b.m12227a((kq) this);
        }

        private void m11221e() {
            this.f9115b.m12233e();
            try {
                this.f9115b.m12235g();
            } catch (Throwable e) {
                this.f9114a.f9127l.m11958a("Interrupted while shutting down websocket threads", e);
            }
        }

        public void mo3690a() {
            try {
                this.f9115b.m12232d();
            } catch (Throwable e) {
                if (this.f9114a.f9127l.m11961a()) {
                    this.f9114a.f9127l.m11959a("Error connecting", e, new Object[0]);
                }
                m11221e();
            }
        }

        public void mo3691a(final kr krVar) {
            this.f9114a.f9126k.execute(new Runnable(this) {
                final /* synthetic */ C2922c f9113b;

                public void run() {
                    if (krVar.getCause() == null || !(krVar.getCause() instanceof EOFException)) {
                        this.f9113b.f9114a.f9127l.m11959a("WebSocket error.", krVar, new Object[0]);
                    } else {
                        this.f9113b.f9114a.f9127l.m11960a("WebSocket reached EOF.", new Object[0]);
                    }
                    this.f9113b.f9114a.m11245f();
                }
            });
        }

        public void mo3692a(kt ktVar) {
            final String a = ktVar.m12243a();
            if (this.f9114a.f9127l.m11961a()) {
                jp b = this.f9114a.f9127l;
                String str = "ws message: ";
                String valueOf = String.valueOf(a);
                b.m11960a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
            }
            this.f9114a.f9126k.execute(new Runnable(this) {
                final /* synthetic */ C2922c f9110b;

                public void run() {
                    this.f9110b.f9114a.m11240c(a);
                }
            });
        }

        public void mo3693a(String str) {
            this.f9115b.m12229a(str);
        }

        public void mo3694b() {
            this.f9115b.m12233e();
        }

        public void mo3695c() {
            this.f9114a.f9126k.execute(new C29181(this));
        }

        public void mo3696d() {
            this.f9114a.f9126k.execute(new C29203(this));
        }
    }

    public gt(gl glVar, gn gnVar, String str, C2898a c2898a, String str2) {
        this.f9125j = glVar;
        this.f9126k = glVar.m11068c();
        this.f9122g = c2898a;
        long j = f9116a;
        f9116a = 1 + j;
        this.f9127l = new jp(glVar.m11066a(), "WebSocket", "ws_" + j);
        this.f9117b = m11229a(gnVar, str, str2);
    }

    private C2917b m11229a(gn gnVar, String str, String str2) {
        if (str == null) {
            str = gnVar.m11078a();
        }
        URI a = gn.m11077a(str, gnVar.m11080c(), gnVar.m11079b(), str2);
        Map hashMap = new HashMap();
        hashMap.put("User-Agent", this.f9125j.m11071f());
        return new C2922c(new kp(a, null, hashMap));
    }

    private void m11231a(int i) {
        this.f9120e = (long) i;
        this.f9121f = new gv();
        if (this.f9127l.m11961a()) {
            this.f9127l.m11960a("HandleNewFrameCount: " + this.f9120e, new Object[0]);
        }
    }

    private void m11233a(String str) {
        Throwable th;
        jp jpVar;
        String str2;
        String valueOf;
        this.f9121f.m11268a(str);
        this.f9120e--;
        if (this.f9120e == 0) {
            try {
                this.f9121f.m11267a();
                Map a = ky.m12270a(this.f9121f.toString());
                this.f9121f = null;
                if (this.f9127l.m11961a()) {
                    jp jpVar2 = this.f9127l;
                    String valueOf2 = String.valueOf(a);
                    jpVar2.m11960a(new StringBuilder(String.valueOf(valueOf2).length() + 36).append("handleIncomingFrame complete frame: ").append(valueOf2).toString(), new Object[0]);
                }
                this.f9122g.mo3664a(a);
            } catch (Throwable e) {
                th = e;
                jpVar = this.f9127l;
                str2 = "Error parsing frame: ";
                valueOf = String.valueOf(this.f9121f.toString());
                jpVar.m11958a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
                m11252b();
                m11248g();
            } catch (Throwable e2) {
                th = e2;
                jpVar = this.f9127l;
                str2 = "Error parsing frame (cast error): ";
                valueOf = String.valueOf(this.f9121f.toString());
                jpVar.m11958a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
                m11252b();
                m11248g();
            }
        }
    }

    private static String[] m11235a(String str, int i) {
        int i2 = 0;
        if (str.length() <= i) {
            return new String[]{str};
        }
        ArrayList arrayList = new ArrayList();
        while (i2 < str.length()) {
            arrayList.add(str.substring(i2, Math.min(i2 + i, str.length())));
            i2 += i;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private String m11237b(String str) {
        if (str.length() <= 6) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt > 0) {
                    m11231a(parseInt);
                }
                return null;
            } catch (NumberFormatException e) {
            }
        }
        m11231a(1);
        return str;
    }

    private void m11238c() {
        if (!this.f9119d) {
            if (this.f9123h != null) {
                this.f9123h.cancel(false);
                if (this.f9127l.m11961a()) {
                    this.f9127l.m11960a("Reset keepAlive. Remaining: " + this.f9123h.getDelay(TimeUnit.MILLISECONDS), new Object[0]);
                }
            } else if (this.f9127l.m11961a()) {
                this.f9127l.m11960a("Reset keepAlive", new Object[0]);
            }
            this.f9123h = this.f9126k.schedule(m11241d(), 45000, TimeUnit.MILLISECONDS);
        }
    }

    private void m11240c(String str) {
        if (!this.f9119d) {
            m11238c();
            if (m11244e()) {
                m11233a(str);
                return;
            }
            String b = m11237b(str);
            if (b != null) {
                m11233a(b);
            }
        }
    }

    private Runnable m11241d() {
        return new C29162(this);
    }

    private boolean m11244e() {
        return this.f9121f != null;
    }

    private void m11245f() {
        if (!this.f9119d) {
            if (this.f9127l.m11961a()) {
                this.f9127l.m11960a("closing itself", new Object[0]);
            }
            m11248g();
        }
        this.f9117b = null;
        if (this.f9123h != null) {
            this.f9123h.cancel(false);
        }
    }

    private void m11248g() {
        this.f9119d = true;
        this.f9122g.mo3665a(this.f9118c);
    }

    private void m11249h() {
        if (!this.f9118c && !this.f9119d) {
            if (this.f9127l.m11961a()) {
                this.f9127l.m11960a("timed out on connect", new Object[0]);
            }
            this.f9117b.mo3694b();
        }
    }

    public void m11250a() {
        this.f9117b.mo3690a();
        this.f9124i = this.f9126k.schedule(new C29151(this), 30000, TimeUnit.MILLISECONDS);
    }

    public void m11251a(Map<String, Object> map) {
        String str;
        m11238c();
        try {
            String[] a = m11235a(ky.m12268a((Map) map), 16384);
            if (a.length > 1) {
                this.f9117b.mo3693a(a.length);
            }
            for (String str2 : a) {
                this.f9117b.mo3693a(str2);
            }
        } catch (Throwable e) {
            Throwable th = e;
            jp jpVar = this.f9127l;
            str2 = "Failed to serialize message: ";
            String valueOf = String.valueOf(map.toString());
            jpVar.m11958a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
            m11248g();
        }
    }

    public void m11252b() {
        if (this.f9127l.m11961a()) {
            this.f9127l.m11960a("websocket is being closed", new Object[0]);
        }
        this.f9119d = true;
        this.f9117b.mo3694b();
        if (this.f9124i != null) {
            this.f9124i.cancel(true);
        }
        if (this.f9123h != null) {
            this.f9123h.cancel(true);
        }
    }
}
