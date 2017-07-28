package com.google.android.gms.internal;

import java.util.Comparator;

public class gh<A extends Comparable<A>> implements Comparator<A> {
    private static gh f9013a = new gh();

    private gh() {
    }

    public static <T extends Comparable<T>> gh<T> m11039a(Class<T> cls) {
        return f9013a;
    }

    public int m11040a(A a, A a2) {
        return a.compareTo(a2);
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m11040a((Comparable) obj, (Comparable) obj2);
    }
}
