package com.domobile.cropimage;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class C1209m<K, V> {
    private final HashMap<K, V> f2381a;
    private final HashMap<K, C1208a<K, V>> f2382b = new HashMap();
    private ReferenceQueue<V> f2383c = new ReferenceQueue();

    private static class C1208a<K, V> extends WeakReference<V> {
        K f2380a;

        public C1208a(K k, V v, ReferenceQueue<V> referenceQueue) {
            super(v, referenceQueue);
            this.f2380a = k;
        }
    }

    public C1209m(int i) {
        final int i2 = i;
        this.f2381a = new LinkedHashMap<K, V>(this, 16, 0.75f, true) {
            final /* synthetic */ C1209m f2379b;

            protected boolean removeEldestEntry(Entry<K, V> entry) {
                return size() > i2;
            }
        };
    }

    private void m2820b() {
        C1208a c1208a = (C1208a) this.f2383c.poll();
        while (c1208a != null) {
            this.f2382b.remove(c1208a.f2380a);
            c1208a = (C1208a) this.f2383c.poll();
        }
    }

    public synchronized V m2821a(K k) {
        V v;
        m2820b();
        v = this.f2381a.get(k);
        if (v == null) {
            C1208a c1208a = (C1208a) this.f2382b.get(k);
            v = c1208a == null ? null : c1208a.get();
        }
        return v;
    }

    public synchronized V m2822a(K k, V v) {
        C1208a c1208a;
        m2820b();
        this.f2381a.put(k, v);
        c1208a = (C1208a) this.f2382b.put(k, new C1208a(k, v, this.f2383c));
        return c1208a == null ? null : c1208a.get();
    }

    public synchronized void m2823a() {
        this.f2381a.clear();
        this.f2382b.clear();
        this.f2383c = new ReferenceQueue();
    }
}
