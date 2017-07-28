package com.google.android.gms.internal;

import com.google.android.gms.internal.fx.C2882a;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class ga<T> implements Iterable<T> {
    private final fx<T, Void> f8991a;

    private static class C2887a<T> implements Iterator<T> {
        final Iterator<Entry<T, Void>> f8990a;

        public C2887a(Iterator<Entry<T, Void>> it) {
            this.f8990a = it;
        }

        public boolean hasNext() {
            return this.f8990a.hasNext();
        }

        public T next() {
            return ((Entry) this.f8990a.next()).getKey();
        }

        public void remove() {
            this.f8990a.remove();
        }
    }

    private ga(fx<T, Void> fxVar) {
        this.f8991a = fxVar;
    }

    public ga(List<T> list, Comparator<T> comparator) {
        this.f8991a = C2882a.m10945a(list, Collections.emptyMap(), C2882a.m10943a(), comparator);
    }

    public ga<T> m10953a(T t) {
        fx c = this.f8991a.mo3641c(t);
        return c == this.f8991a ? this : new ga(c);
    }

    public T m10954a() {
        return this.f8991a.mo3635a();
    }

    public ga<T> m10955b(T t) {
        return new ga(this.f8991a.mo3634a(t, null));
    }

    public T m10956b() {
        return this.f8991a.mo3638b();
    }

    public T m10957c(T t) {
        return this.f8991a.mo3642d(t);
    }

    public Iterator<T> m10958c() {
        return new C2887a(this.f8991a.mo3644e());
    }

    public Iterator<T> iterator() {
        return new C2887a(this.f8991a.iterator());
    }
}
