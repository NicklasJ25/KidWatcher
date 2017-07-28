package com.android.camera.gallery;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class C0465l<K, V> {
    private final HashMap<K, V> f247a;
    private final HashMap<K, C0464a<K, V>> f248b = new HashMap();
    private ReferenceQueue<V> f249c = new ReferenceQueue();

    private static class C0464a<K, V> extends WeakReference<V> {
        K f246a;

        public C0464a(K k, V v, ReferenceQueue<V> referenceQueue) {
            super(v, referenceQueue);
            this.f246a = k;
        }
    }

    public C0465l(int i) {
        final int i2 = i;
        this.f247a = new LinkedHashMap<K, V>(this, 16, 0.75f, true) {
            final /* synthetic */ C0465l f245b;

            protected boolean removeEldestEntry(Entry<K, V> entry) {
                return size() > i2;
            }
        };
    }

    private void m334b() {
        C0464a c0464a = (C0464a) this.f249c.poll();
        while (c0464a != null) {
            this.f248b.remove(c0464a.f246a);
            c0464a = (C0464a) this.f249c.poll();
        }
    }

    public synchronized V m335a(K k) {
        V v;
        m334b();
        v = this.f247a.get(k);
        if (v == null) {
            C0464a c0464a = (C0464a) this.f248b.get(k);
            v = c0464a == null ? null : c0464a.get();
        }
        return v;
    }

    public synchronized V m336a(K k, V v) {
        C0464a c0464a;
        m334b();
        this.f247a.put(k, v);
        c0464a = (C0464a) this.f248b.put(k, new C0464a(k, v, this.f249c));
        return c0464a == null ? null : c0464a.get();
    }

    public synchronized void m337a() {
        this.f247a.clear();
        this.f248b.clear();
        this.f249c = new ReferenceQueue();
    }
}
