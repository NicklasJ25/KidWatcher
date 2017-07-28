package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@wh
public class aai {

    class C26341 implements Runnable {
        final /* synthetic */ aag f7638a;
        final /* synthetic */ C2636a f7639b;
        final /* synthetic */ aaj f7640c;

        C26341(aag com_google_android_gms_internal_aag, C2636a c2636a, aaj com_google_android_gms_internal_aaj) {
            this.f7638a = com_google_android_gms_internal_aag;
            this.f7639b = c2636a;
            this.f7640c = com_google_android_gms_internal_aaj;
        }

        public void run() {
            try {
                this.f7638a.m8436b(this.f7639b.mo4177a(this.f7640c.get()));
                return;
            } catch (CancellationException e) {
            } catch (InterruptedException e2) {
            } catch (ExecutionException e3) {
            }
            this.f7638a.cancel(true);
        }
    }

    class C26352 implements Runnable {
        final /* synthetic */ AtomicInteger f7641a;
        final /* synthetic */ int f7642b;
        final /* synthetic */ aag f7643c;
        final /* synthetic */ List f7644d;

        C26352(AtomicInteger atomicInteger, int i, aag com_google_android_gms_internal_aag, List list) {
            this.f7641a = atomicInteger;
            this.f7642b = i;
            this.f7643c = com_google_android_gms_internal_aag;
            this.f7644d = list;
        }

        public void run() {
            Throwable e;
            if (this.f7641a.incrementAndGet() >= this.f7642b) {
                try {
                    this.f7643c.m8436b(aai.m8445c(this.f7644d));
                    return;
                } catch (ExecutionException e2) {
                    e = e2;
                } catch (InterruptedException e3) {
                    e = e3;
                }
            } else {
                return;
            }
            aad.m8424c("Unable to convert list of futures to a future of list", e);
        }
    }

    public interface C2636a<D, R> {
        R mo4177a(D d);
    }

    public static <A, B> aaj<B> m8441a(aaj<A> com_google_android_gms_internal_aaj_A, C2636a<A, B> c2636a) {
        aaj com_google_android_gms_internal_aag = new aag();
        com_google_android_gms_internal_aaj_A.mo3377a(new C26341(com_google_android_gms_internal_aag, c2636a, com_google_android_gms_internal_aaj_A));
        return com_google_android_gms_internal_aag;
    }

    public static <V> aaj<List<V>> m8442a(List<aaj<V>> list) {
        aaj com_google_android_gms_internal_aag = new aag();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (aaj a : list) {
            a.mo3377a(new C26352(atomicInteger, size, com_google_android_gms_internal_aag, list));
        }
        return com_google_android_gms_internal_aag;
    }

    public static <T> T m8443a(Future<T> future, T t, int i, TimeUnit timeUnit) {
        try {
            t = future.get((long) i, timeUnit);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e2) {
        }
        return t;
    }

    private static <V> List<V> m8445c(List<aaj<V>> list) {
        List<V> arrayList = new ArrayList();
        for (aaj com_google_android_gms_internal_aaj : list) {
            Object obj = com_google_android_gms_internal_aaj.get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
