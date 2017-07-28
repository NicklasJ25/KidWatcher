package com.google.android.gms.internal;

import com.google.android.gms.internal.gd.C2889b;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class fx<K, V> implements Iterable<Entry<K, V>> {

    public static class C2882a {
        private static final C2880a f8984a = new C28811();

        public interface C2880a<C, D> {
            D mo3647a(C c);
        }

        class C28811 implements C2880a {
            C28811() {
            }

            public Object mo3647a(Object obj) {
                return obj;
            }
        }

        public static <A> C2880a<A, A> m10943a() {
            return f8984a;
        }

        public static <K, V> fx<K, V> m10944a(Comparator<K> comparator) {
            return new fw(comparator);
        }

        public static <A, B, C> fx<A, C> m10945a(List<A> list, Map<B, C> map, C2880a<A, B> c2880a, Comparator<A> comparator) {
            return list.size() < 25 ? fw.m10919a(list, map, c2880a, comparator) : gg.m11024a(list, map, c2880a, comparator);
        }

        public static <A, B> fx<A, B> m10946a(Map<A, B> map, Comparator<A> comparator) {
            return map.size() < 25 ? fw.m10920a((Map) map, (Comparator) comparator) : gg.m11025a((Map) map, (Comparator) comparator);
        }
    }

    public abstract fx<K, V> mo3634a(K k, V v);

    public abstract K mo3635a();

    public abstract void mo3636a(C2889b<K, V> c2889b);

    public abstract boolean mo3637a(K k);

    public abstract K mo3638b();

    public abstract V mo3639b(K k);

    public abstract int mo3640c();

    public abstract fx<K, V> mo3641c(K k);

    public abstract K mo3642d(K k);

    public abstract boolean mo3643d();

    public abstract Iterator<Entry<K, V>> mo3644e();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fx)) {
            return false;
        }
        fx fxVar = (fx) obj;
        if (!mo3645f().equals(fxVar.mo3645f())) {
            return false;
        }
        if (mo3640c() != fxVar.mo3640c()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = fxVar.iterator();
        while (it.hasNext()) {
            if (!((Entry) it.next()).equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract Comparator<K> mo3645f();

    public int hashCode() {
        int hashCode = mo3645f().hashCode();
        Iterator it = iterator();
        int i = hashCode;
        while (it.hasNext()) {
            i = ((Entry) it.next()).hashCode() + (i * 31);
        }
        return i;
    }

    public abstract Iterator<Entry<K, V>> iterator();

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("{");
        Iterator it = iterator();
        Object obj = 1;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append("(");
            stringBuilder.append(entry.getKey());
            stringBuilder.append("=>");
            stringBuilder.append(entry.getValue());
            stringBuilder.append(")");
        }
        stringBuilder.append("};");
        return stringBuilder.toString();
    }
}
