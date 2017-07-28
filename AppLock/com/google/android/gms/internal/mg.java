package com.google.android.gms.internal;

import com.google.android.gms.internal.ef.C2846a;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class mg {
    protected static final String f9826a = mg.class.getSimpleName();
    private final ez f9827b;
    private final String f9828c;
    private final String f9829d;
    private final int f9830e = 2;
    private volatile Method f9831f = null;
    private List<Class> f9832g;
    private CountDownLatch f9833h = new CountDownLatch(1);

    class C30561 implements Runnable {
        final /* synthetic */ mg f9825a;

        C30561(mg mgVar) {
            this.f9825a = mgVar;
        }

        public void run() {
            this.f9825a.m12559b();
        }
    }

    public mg(ez ezVar, String str, String str2, List<Class> list) {
        this.f9827b = ezVar;
        this.f9828c = str;
        this.f9829d = str2;
        this.f9832g = new ArrayList(list);
        this.f9827b.m10722c().submit(new C30561(this));
    }

    private String m12557a(byte[] bArr, String str) {
        return new String(this.f9827b.m10724e().m10574a(bArr, str), "UTF-8");
    }

    private void m12559b() {
        try {
            Class loadClass = this.f9827b.m10723d().loadClass(m12557a(this.f9827b.m10725f(), this.f9828c));
            if (loadClass != null) {
                this.f9831f = loadClass.getMethod(m12557a(this.f9827b.m10725f(), this.f9829d), (Class[]) this.f9832g.toArray(new Class[this.f9832g.size()]));
                if (this.f9831f == null) {
                    this.f9833h.countDown();
                } else {
                    this.f9833h.countDown();
                }
            }
        } catch (C2846a e) {
        } catch (UnsupportedEncodingException e2) {
        } catch (ClassNotFoundException e3) {
        } catch (NoSuchMethodException e4) {
        } catch (NullPointerException e5) {
        } finally {
            this.f9833h.countDown();
        }
    }

    public Method m12560a() {
        if (this.f9831f != null) {
            return this.f9831f;
        }
        try {
            return this.f9833h.await(2, TimeUnit.SECONDS) ? this.f9831f : null;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
