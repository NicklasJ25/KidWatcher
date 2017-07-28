package com.android.gallery3d.common;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class LruCache<K, V> {
    private final HashMap<K, V> mLruMap;
    private ReferenceQueue<V> mQueue = new ReferenceQueue();
    private final HashMap<K, Entry<K, V>> mWeakMap = new HashMap();

    private static class Entry<K, V> extends WeakReference<V> {
        K mKey;

        public Entry(K k, V v, ReferenceQueue<V> referenceQueue) {
            super(v, referenceQueue);
            this.mKey = k;
        }
    }

    public LruCache(int i) {
        final int i2 = i;
        this.mLruMap = new LinkedHashMap<K, V>(16, 0.75f, true) {
            protected boolean removeEldestEntry(java.util.Map.Entry<K, V> entry) {
                return size() > i2;
            }
        };
    }

    private void cleanUpWeakMap() {
        Entry entry = (Entry) this.mQueue.poll();
        while (entry != null) {
            this.mWeakMap.remove(entry.mKey);
            entry = (Entry) this.mQueue.poll();
        }
    }

    public synchronized void clear() {
        this.mLruMap.clear();
        this.mWeakMap.clear();
        this.mQueue = new ReferenceQueue();
    }

    public synchronized boolean containsKey(K k) {
        cleanUpWeakMap();
        return this.mWeakMap.containsKey(k);
    }

    public synchronized V get(K k) {
        V v;
        cleanUpWeakMap();
        v = this.mLruMap.get(k);
        if (v == null) {
            Entry entry = (Entry) this.mWeakMap.get(k);
            v = entry == null ? null : entry.get();
        }
        return v;
    }

    public synchronized V put(K k, V v) {
        Entry entry;
        cleanUpWeakMap();
        this.mLruMap.put(k, v);
        entry = (Entry) this.mWeakMap.put(k, new Entry(k, v, this.mQueue));
        return entry == null ? null : entry.get();
    }
}
