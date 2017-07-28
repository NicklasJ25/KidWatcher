package com.google.android.gms.common.util;

import android.support.v4.util.ArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

public class C2576a<E> extends AbstractSet<E> {
    private final ArrayMap<E, E> f7557a;

    public C2576a() {
        this.f7557a = new ArrayMap();
    }

    public C2576a(int i) {
        this.f7557a = new ArrayMap(i);
    }

    public C2576a(Collection<E> collection) {
        this(collection.size());
        addAll(collection);
    }

    public boolean m8262a(C2576a<? extends E> c2576a) {
        int size = size();
        this.f7557a.putAll(c2576a.f7557a);
        return size() > size;
    }

    public boolean add(E e) {
        if (this.f7557a.containsKey(e)) {
            return false;
        }
        this.f7557a.put(e, e);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof C2576a ? m8262a((C2576a) collection) : super.addAll(collection);
    }

    public void clear() {
        this.f7557a.clear();
    }

    public boolean contains(Object obj) {
        return this.f7557a.containsKey(obj);
    }

    public Iterator<E> iterator() {
        return this.f7557a.keySet().iterator();
    }

    public boolean remove(Object obj) {
        if (!this.f7557a.containsKey(obj)) {
            return false;
        }
        this.f7557a.remove(obj);
        return true;
    }

    public int size() {
        return this.f7557a.size();
    }
}
