package com.google.android.gms.internal;

import com.google.android.gms.internal.fx.C2882a;
import com.google.android.gms.internal.fx.C2882a.C2880a;
import com.google.android.gms.internal.gd.C2888a;
import com.google.android.gms.internal.gd.C2889b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class gg<K, V> extends fx<K, V> {
    private gd<K, V> f9011a;
    private Comparator<K> f9012b;

    private static class C2894a<A, B, C> {
        private final List<A> f9006a;
        private final Map<B, C> f9007b;
        private final C2880a<A, B> f9008c;
        private gf<A, C> f9009d;
        private gf<A, C> f9010e;

        static class C2892a implements Iterable<C2893b> {
            private long f9002a;
            private final int f9003b;

            class C28911 implements Iterator<C2893b> {
                final /* synthetic */ C2892a f9000a;
                private int f9001b = (this.f9000a.f9003b - 1);

                C28911(C2892a c2892a) {
                    this.f9000a = c2892a;
                }

                public C2893b m11017a() {
                    boolean z = true;
                    long b = this.f9000a.f9002a & ((long) (1 << this.f9001b));
                    C2893b c2893b = new C2893b();
                    if (b != 0) {
                        z = false;
                    }
                    c2893b.f9004a = z;
                    c2893b.f9005b = (int) Math.pow(2.0d, (double) this.f9001b);
                    this.f9001b--;
                    return c2893b;
                }

                public boolean hasNext() {
                    return this.f9001b >= 0;
                }

                public /* synthetic */ Object next() {
                    return m11017a();
                }

                public void remove() {
                }
            }

            public C2892a(int i) {
                int i2 = i + 1;
                this.f9003b = (int) Math.floor(Math.log((double) i2) / Math.log(2.0d));
                this.f9002a = ((long) i2) & (((long) Math.pow(2.0d, (double) this.f9003b)) - 1);
            }

            public Iterator<C2893b> iterator() {
                return new C28911(this);
            }
        }

        static class C2893b {
            public boolean f9004a;
            public int f9005b;

            C2893b() {
            }
        }

        private C2894a(List<A> list, Map<B, C> map, C2880a<A, B> c2880a) {
            this.f9006a = list;
            this.f9007b = map;
            this.f9008c = c2880a;
        }

        private gd<A, C> m11020a(int i, int i2) {
            if (i2 == 0) {
                return gc.m10999a();
            }
            if (i2 == 1) {
                Object obj = this.f9006a.get(i);
                return new gb(obj, m11022a(obj), null, null);
            }
            int i3 = i2 / 2;
            int i4 = i + i3;
            gd a = m11020a(i, i3);
            gd a2 = m11020a(i4 + 1, i3);
            obj = this.f9006a.get(i4);
            return new gb(obj, m11022a(obj), a, a2);
        }

        public static <A, B, C> gg<A, C> m11021a(List<A> list, Map<B, C> map, C2880a<A, B> c2880a, Comparator<A> comparator) {
            C2894a c2894a = new C2894a(list, map, c2880a);
            Collections.sort(list, comparator);
            Iterator it = new C2892a(list.size()).iterator();
            int size = list.size();
            while (it.hasNext()) {
                int i;
                C2893b c2893b = (C2893b) it.next();
                size -= c2893b.f9005b;
                if (c2893b.f9004a) {
                    c2894a.m11023a(C2888a.BLACK, c2893b.f9005b, size);
                    i = size;
                } else {
                    c2894a.m11023a(C2888a.BLACK, c2893b.f9005b, size);
                    size -= c2893b.f9005b;
                    c2894a.m11023a(C2888a.RED, c2893b.f9005b, size);
                    i = size;
                }
                size = i;
            }
            return new gg(c2894a.f9009d == null ? gc.m10999a() : c2894a.f9009d, comparator);
        }

        private C m11022a(A a) {
            return this.f9007b.get(this.f9008c.mo3647a(a));
        }

        private void m11023a(C2888a c2888a, int i, int i2) {
            gd a = m11020a(i2 + 1, i - 1);
            Object obj = this.f9006a.get(i2);
            gd geVar = c2888a == C2888a.RED ? new ge(obj, m11022a(obj), null, a) : new gb(obj, m11022a(obj), null, a);
            if (this.f9009d == null) {
                this.f9009d = geVar;
                this.f9010e = geVar;
                return;
            }
            this.f9010e.m10986a(geVar);
            this.f9010e = geVar;
        }
    }

    private gg(gd<K, V> gdVar, Comparator<K> comparator) {
        this.f9011a = gdVar;
        this.f9012b = comparator;
    }

    public static <A, B, C> gg<A, C> m11024a(List<A> list, Map<B, C> map, C2880a<A, B> c2880a, Comparator<A> comparator) {
        return C2894a.m11021a(list, map, c2880a, comparator);
    }

    public static <A, B> gg<A, B> m11025a(Map<A, B> map, Comparator<A> comparator) {
        return C2894a.m11021a(new ArrayList(map.keySet()), map, C2882a.m10943a(), comparator);
    }

    private gd<K, V> m11026e(K k) {
        gd<K, V> gdVar = this.f9011a;
        while (!gdVar.mo3653c()) {
            int compare = this.f9012b.compare(k, gdVar.mo3654d());
            if (compare < 0) {
                gdVar = gdVar.mo3656f();
            } else if (compare == 0) {
                return gdVar;
            } else {
                gdVar = gdVar.mo3657g();
            }
        }
        return null;
    }

    public fx<K, V> mo3634a(K k, V v) {
        return new gg(this.f9011a.mo3650a(k, v, this.f9012b).mo3649a(null, null, C2888a.BLACK, null, null), this.f9012b);
    }

    public K mo3635a() {
        return this.f9011a.mo3658h().mo3654d();
    }

    public void mo3636a(C2889b<K, V> c2889b) {
        this.f9011a.mo3652a(c2889b);
    }

    public boolean mo3637a(K k) {
        return m11026e(k) != null;
    }

    public K mo3638b() {
        return this.f9011a.mo3659i().mo3654d();
    }

    public V mo3639b(K k) {
        gd e = m11026e(k);
        return e != null ? e.mo3655e() : null;
    }

    public int mo3640c() {
        return this.f9011a.mo3660j();
    }

    public fx<K, V> mo3641c(K k) {
        if (!mo3637a((Object) k)) {
            return this;
        }
        return new gg(this.f9011a.mo3651a(k, this.f9012b).mo3649a(null, null, C2888a.BLACK, null, null), this.f9012b);
    }

    public K mo3642d(K k) {
        gd gdVar = this.f9011a;
        gd gdVar2 = null;
        while (!gdVar.mo3653c()) {
            int compare = this.f9012b.compare(k, gdVar.mo3654d());
            if (compare == 0) {
                if (gdVar.mo3656f().mo3653c()) {
                    return gdVar2 != null ? gdVar2.mo3654d() : null;
                } else {
                    gdVar2 = gdVar.mo3656f();
                    while (!gdVar2.mo3657g().mo3653c()) {
                        gdVar2 = gdVar2.mo3657g();
                    }
                    return gdVar2.mo3654d();
                }
            } else if (compare < 0) {
                gdVar = gdVar.mo3656f();
            } else {
                gd gdVar3 = gdVar;
                gdVar = gdVar.mo3657g();
                gdVar2 = gdVar3;
            }
        }
        String valueOf = String.valueOf(k);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Couldn't find predecessor key of non-present key: ").append(valueOf).toString());
    }

    public boolean mo3643d() {
        return this.f9011a.mo3653c();
    }

    public Iterator<Entry<K, V>> mo3644e() {
        return new fy(this.f9011a, null, this.f9012b, true);
    }

    public Comparator<K> mo3645f() {
        return this.f9012b;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new fy(this.f9011a, null, this.f9012b, false);
    }
}
