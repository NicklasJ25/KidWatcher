package com.google.android.gms.internal;

import com.google.android.gms.internal.fx.C2882a;
import com.google.android.gms.internal.fx.C2882a.C2880a;
import com.google.android.gms.internal.gd.C2889b;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class fw<K, V> extends fx<K, V> {
    private final K[] f8981a;
    private final V[] f8982b;
    private final Comparator<K> f8983c;

    public fw(Comparator<K> comparator) {
        this.f8981a = new Object[0];
        this.f8982b = new Object[0];
        this.f8983c = comparator;
    }

    private fw(Comparator<K> comparator, K[] kArr, V[] vArr) {
        this.f8981a = kArr;
        this.f8982b = vArr;
        this.f8983c = comparator;
    }

    public static <A, B, C> fw<A, C> m10919a(List<A> list, Map<B, C> map, C2880a<A, B> c2880a, Comparator<A> comparator) {
        Collections.sort(list, comparator);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        size = 0;
        for (Object next : list) {
            objArr[size] = next;
            objArr2[size] = map.get(c2880a.mo3647a(next));
            size++;
        }
        return new fw(comparator, objArr, objArr2);
    }

    public static <K, V> fw<K, V> m10920a(Map<K, V> map, Comparator<K> comparator) {
        return m10919a(new ArrayList(map.keySet()), map, C2882a.m10943a(), comparator);
    }

    private Iterator<Entry<K, V>> m10921a(final int i, final boolean z) {
        return new Iterator<Entry<K, V>>(this) {
            int f8977a = i;
            final /* synthetic */ fw f8980d;

            public Entry<K, V> m10906a() {
                Object obj = this.f8980d.f8981a[this.f8977a];
                Object obj2 = this.f8980d.f8982b[this.f8977a];
                this.f8977a = z ? this.f8977a - 1 : this.f8977a + 1;
                return new SimpleImmutableEntry(obj, obj2);
            }

            public boolean hasNext() {
                return z ? this.f8977a >= 0 : this.f8977a < this.f8980d.f8981a.length;
            }

            public /* synthetic */ Object next() {
                return m10906a();
            }

            public void remove() {
                throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
            }
        };
    }

    private static <T> T[] m10923a(T[] tArr, int i) {
        int length = tArr.length - 1;
        Object obj = new Object[length];
        System.arraycopy(tArr, 0, obj, 0, i);
        System.arraycopy(tArr, i + 1, obj, i, length - i);
        return obj;
    }

    private static <T> T[] m10924a(T[] tArr, int i, T t) {
        int length = tArr.length + 1;
        Object obj = new Object[length];
        System.arraycopy(tArr, 0, obj, 0, i);
        obj[i] = t;
        System.arraycopy(tArr, i, obj, i + 1, (length - i) - 1);
        return obj;
    }

    private static <T> T[] m10926b(T[] tArr, int i, T t) {
        int length = tArr.length;
        Object obj = new Object[length];
        System.arraycopy(tArr, 0, obj, 0, length);
        obj[i] = t;
        return obj;
    }

    private int m10927e(K k) {
        int i = 0;
        while (i < this.f8981a.length && this.f8983c.compare(this.f8981a[i], k) < 0) {
            i++;
        }
        return i;
    }

    private int m10928f(K k) {
        int i = 0;
        Object[] objArr = this.f8981a;
        int length = objArr.length;
        int i2 = 0;
        while (i2 < length) {
            if (this.f8983c.compare(k, objArr[i2]) == 0) {
                return i;
            }
            i2++;
            i++;
        }
        return -1;
    }

    public fx<K, V> mo3634a(K k, V v) {
        int f = m10928f(k);
        if (f != -1) {
            if (this.f8981a[f] == k && this.f8982b[f] == v) {
                return this;
            }
            return new fw(this.f8983c, m10926b(this.f8981a, f, k), m10926b(this.f8982b, f, v));
        } else if (this.f8981a.length > 25) {
            Map hashMap = new HashMap(this.f8981a.length + 1);
            for (f = 0; f < this.f8981a.length; f++) {
                hashMap.put(this.f8981a[f], this.f8982b[f]);
            }
            hashMap.put(k, v);
            return gg.m11025a(hashMap, this.f8983c);
        } else {
            f = m10927e(k);
            return new fw(this.f8983c, m10924a(this.f8981a, f, k), m10924a(this.f8982b, f, v));
        }
    }

    public K mo3635a() {
        return this.f8981a.length > 0 ? this.f8981a[0] : null;
    }

    public void mo3636a(C2889b<K, V> c2889b) {
        for (int i = 0; i < this.f8981a.length; i++) {
            c2889b.mo3719a(this.f8981a[i], this.f8982b[i]);
        }
    }

    public boolean mo3637a(K k) {
        return m10928f(k) != -1;
    }

    public K mo3638b() {
        return this.f8981a.length > 0 ? this.f8981a[this.f8981a.length - 1] : null;
    }

    public V mo3639b(K k) {
        int f = m10928f(k);
        return f != -1 ? this.f8982b[f] : null;
    }

    public int mo3640c() {
        return this.f8981a.length;
    }

    public fx<K, V> mo3641c(K k) {
        int f = m10928f(k);
        if (f == -1) {
            return this;
        }
        return new fw(this.f8983c, m10923a(this.f8981a, f), m10923a(this.f8982b, f));
    }

    public K mo3642d(K k) {
        int f = m10928f(k);
        if (f != -1) {
            return f > 0 ? this.f8981a[f - 1] : null;
        } else {
            throw new IllegalArgumentException("Can't find predecessor of nonexistent key");
        }
    }

    public boolean mo3643d() {
        return this.f8981a.length == 0;
    }

    public Iterator<Entry<K, V>> mo3644e() {
        return m10921a(this.f8981a.length - 1, true);
    }

    public Comparator<K> mo3645f() {
        return this.f8983c;
    }

    public Iterator<Entry<K, V>> iterator() {
        return m10921a(0, false);
    }
}
