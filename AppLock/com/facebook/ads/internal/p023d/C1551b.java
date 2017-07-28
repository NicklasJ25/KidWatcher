package com.facebook.ads.internal.p023d;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class C1551b {
    private static final String f3778a = C1551b.class.getSimpleName();
    private final Handler f3779b = new Handler();
    private final ExecutorService f3780c = Executors.newFixedThreadPool(10);
    private final C1552c f3781d;
    private final C1554d f3782e;
    private final List<Callable<Boolean>> f3783f;

    private class C1549a implements Callable<Boolean> {
        final /* synthetic */ C1551b f3774a;
        private final String f3775b;

        public C1549a(C1551b c1551b, String str) {
            this.f3774a = c1551b;
            this.f3775b = str;
        }

        public Boolean m4300a() {
            this.f3774a.f3781d.m4315a(this.f3775b);
            return Boolean.valueOf(true);
        }

        public /* synthetic */ Object call() {
            return m4300a();
        }
    }

    private class C1550b implements Callable<Boolean> {
        final /* synthetic */ C1551b f3776a;
        private final String f3777b;

        public C1550b(C1551b c1551b, String str) {
            this.f3776a = c1551b;
            this.f3777b = str;
        }

        public Boolean m4301a() {
            this.f3776a.f3782e.m4320a(this.f3777b);
            return Boolean.valueOf(true);
        }

        public /* synthetic */ Object call() {
            return m4301a();
        }
    }

    public C1551b(Context context) {
        this.f3781d = C1552c.m4311a(context);
        this.f3782e = C1554d.m4318a(context);
        this.f3783f = new ArrayList();
    }

    public void m4307a(final C1528a c1528a) {
        final ArrayList arrayList = new ArrayList(this.f3783f);
        this.f3780c.submit(new Runnable(this) {
            final /* synthetic */ C1551b f3773c;

            class C15471 implements Runnable {
                final /* synthetic */ C15481 f3770a;

                C15471(C15481 c15481) {
                    this.f3770a = c15481;
                }

                public void run() {
                    c1528a.mo2723a();
                }
            }

            public void run() {
                Throwable e;
                List<Future> arrayList = new ArrayList(arrayList.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList.add(this.f3773c.f3780c.submit((Callable) it.next()));
                }
                try {
                    for (Future future : arrayList) {
                        future.get();
                    }
                } catch (InterruptedException e2) {
                    e = e2;
                    Log.e(C1551b.f3778a, "Exception while executing cache downloads.", e);
                    this.f3773c.f3779b.post(new C15471(this));
                } catch (ExecutionException e3) {
                    e = e3;
                    Log.e(C1551b.f3778a, "Exception while executing cache downloads.", e);
                    this.f3773c.f3779b.post(new C15471(this));
                }
                this.f3773c.f3779b.post(new C15471(this));
            }
        });
        this.f3783f.clear();
    }

    public void m4308a(String str) {
        this.f3783f.add(new C1549a(this, str));
    }

    public void m4309b(String str) {
        this.f3783f.add(new C1550b(this, str));
    }

    public String m4310c(String str) {
        return this.f3782e.m4321b(str);
    }
}
