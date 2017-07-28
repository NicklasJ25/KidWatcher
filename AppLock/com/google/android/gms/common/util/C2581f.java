package com.google.android.gms.common.util;

import android.support.v4.util.ArrayMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class C2581f {
    public static <T> List<T> m8276a(T t) {
        return Collections.singletonList(t);
    }

    public static <K, V> Map<K, V> m8277a(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        Map arrayMap = new ArrayMap(6);
        arrayMap.put(k, v);
        arrayMap.put(k2, v2);
        arrayMap.put(k3, v3);
        arrayMap.put(k4, v4);
        arrayMap.put(k5, v5);
        arrayMap.put(k6, v6);
        return Collections.unmodifiableMap(arrayMap);
    }

    public static <K, V> Map<K, V> m8278a(K[] kArr, V[] vArr) {
        int i = 0;
        C2581f.m8287b((Object[]) kArr, (Object[]) vArr);
        int length = kArr.length;
        switch (length) {
            case 0:
                return C2581f.m8284b();
            case 1:
                return C2581f.m8285b(kArr[0], vArr[0]);
            default:
                Map arrayMap = length <= 32 ? new ArrayMap(length) : new HashMap(length, 1.0f);
                while (i < length) {
                    arrayMap.put(kArr[i], vArr[i]);
                    i++;
                }
                return Collections.unmodifiableMap(arrayMap);
        }
    }

    public static <T> Set<T> m8279a() {
        return Collections.emptySet();
    }

    public static <T> Set<T> m8280a(T t, T t2) {
        Set c2576a = new C2576a(2);
        c2576a.add(t);
        c2576a.add(t2);
        return Collections.unmodifiableSet(c2576a);
    }

    public static <T> Set<T> m8281a(T t, T t2, T t3) {
        Set c2576a = new C2576a(3);
        c2576a.add(t);
        c2576a.add(t2);
        c2576a.add(t3);
        return Collections.unmodifiableSet(c2576a);
    }

    public static <T> Set<T> m8282a(T t, T t2, T t3, T t4) {
        Set c2576a = new C2576a(4);
        c2576a.add(t);
        c2576a.add(t2);
        c2576a.add(t3);
        c2576a.add(t4);
        return Collections.unmodifiableSet(c2576a);
    }

    public static <T> Set<T> m8283a(T... tArr) {
        switch (tArr.length) {
            case 0:
                return C2581f.m8279a();
            case 1:
                return C2581f.m8286b(tArr[0]);
            case 2:
                return C2581f.m8280a(tArr[0], tArr[1]);
            case 3:
                return C2581f.m8281a(tArr[0], tArr[1], tArr[2]);
            case 4:
                return C2581f.m8282a(tArr[0], tArr[1], tArr[2], tArr[3]);
            default:
                return Collections.unmodifiableSet(tArr.length <= 32 ? new C2576a(Arrays.asList(tArr)) : new HashSet(Arrays.asList(tArr)));
        }
    }

    public static <K, V> Map<K, V> m8284b() {
        return Collections.emptyMap();
    }

    public static <K, V> Map<K, V> m8285b(K k, V v) {
        return Collections.singletonMap(k, v);
    }

    public static <T> Set<T> m8286b(T t) {
        return Collections.singleton(t);
    }

    private static <K, V> void m8287b(K[] kArr, V[] vArr) {
        if (kArr.length != vArr.length) {
            int length = kArr.length;
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + vArr.length);
        }
    }
}
