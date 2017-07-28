package com.google.android.gms.internal;

import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Stack;

public class fy<K, V> implements Iterator<Entry<K, V>> {
    private final Stack<gf<K, V>> f8985a = new Stack();
    private final boolean f8986b;

    fy(gd<K, V> gdVar, K k, Comparator<K> comparator, boolean z) {
        this.f8986b = z;
        gd gdVar2 = gdVar;
        while (!gdVar2.mo3653c()) {
            int compare = k != null ? z ? comparator.compare(k, gdVar2.mo3654d()) : comparator.compare(gdVar2.mo3654d(), k) : 1;
            if (compare < 0) {
                gdVar2 = z ? gdVar2.mo3656f() : gdVar2.mo3657g();
            } else if (compare == 0) {
                this.f8985a.push((gf) gdVar2);
                return;
            } else {
                this.f8985a.push((gf) gdVar2);
                gdVar2 = z ? gdVar2.mo3657g() : gdVar2.mo3656f();
            }
        }
    }

    public Entry<K, V> m10947a() {
        try {
            gf gfVar = (gf) this.f8985a.pop();
            Entry simpleEntry = new SimpleEntry(gfVar.mo3654d(), gfVar.mo3655e());
            gd f;
            if (this.f8986b) {
                for (f = gfVar.mo3656f(); !f.mo3653c(); f = f.mo3657g()) {
                    this.f8985a.push((gf) f);
                }
            } else {
                for (f = gfVar.mo3657g(); !f.mo3653c(); f = f.mo3656f()) {
                    this.f8985a.push((gf) f);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException e) {
            throw new NoSuchElementException();
        }
    }

    public boolean hasNext() {
        return this.f8985a.size() > 0;
    }

    public /* synthetic */ Object next() {
        return m10947a();
    }

    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
