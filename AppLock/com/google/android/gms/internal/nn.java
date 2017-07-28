package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.PriorityQueue;

@wh
public class nn {

    public static class C3102a {
        final long f10032a;
        final String f10033b;
        final int f10034c;

        C3102a(long j, String str, int i) {
            this.f10032a = j;
            this.f10033b = str;
            this.f10034c = i;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj == null || !(obj instanceof C3102a)) ? false : ((C3102a) obj).f10032a == this.f10032a && ((C3102a) obj).f10034c == this.f10034c;
        }

        public int hashCode() {
            return (int) this.f10032a;
        }
    }

    static long m12823a(int i, int i2, long j, long j2, long j3) {
        return ((((((j + 1073807359) - ((((((long) i) + 2147483647L) % 1073807359) * j2) % 1073807359)) % 1073807359) * j3) % 1073807359) + ((((long) i2) + 2147483647L) % 1073807359)) % 1073807359;
    }

    static long m12824a(long j, int i) {
        return i == 0 ? 1 : i != 1 ? i % 2 == 0 ? m12824a((j * j) % 1073807359, i / 2) % 1073807359 : ((m12824a((j * j) % 1073807359, i / 2) % 1073807359) * j) % 1073807359 : j;
    }

    static String m12825a(String[] strArr, int i, int i2) {
        if (strArr.length < i + i2) {
            aad.m8423c("Unable to construct shingle");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 < (i + i2) - 1; i3++) {
            stringBuffer.append(strArr[i3]);
            stringBuffer.append(' ');
        }
        stringBuffer.append(strArr[(i + i2) - 1]);
        return stringBuffer.toString();
    }

    static void m12826a(int i, long j, String str, int i2, PriorityQueue<C3102a> priorityQueue) {
        C3102a c3102a = new C3102a(j, str, i2);
        if ((priorityQueue.size() != i || (((C3102a) priorityQueue.peek()).f10034c <= c3102a.f10034c && ((C3102a) priorityQueue.peek()).f10032a <= c3102a.f10032a)) && !priorityQueue.contains(c3102a)) {
            priorityQueue.add(c3102a);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    public static void m12827a(String[] strArr, int i, int i2, PriorityQueue<C3102a> priorityQueue) {
        if (strArr.length < i2) {
            int i3 = i;
            m12826a(i3, m12828b(strArr, 0, strArr.length), m12825a(strArr, 0, strArr.length), strArr.length, (PriorityQueue) priorityQueue);
            return;
        }
        long b = m12828b(strArr, 0, i2);
        m12826a(i, b, m12825a(strArr, 0, i2), i2, (PriorityQueue) priorityQueue);
        long a = m12824a(16785407, i2 - 1);
        int i4 = 1;
        while (i4 < (strArr.length - i2) + 1) {
            long a2 = m12823a(nl.m12812a(strArr[i4 - 1]), nl.m12812a(strArr[(i4 + i2) - 1]), b, a, 16785407);
            m12826a(i, a2, m12825a(strArr, i4, i2), strArr.length, (PriorityQueue) priorityQueue);
            i4++;
            b = a2;
        }
    }

    private static long m12828b(String[] strArr, int i, int i2) {
        long a = (((long) nl.m12812a(strArr[i])) + 2147483647L) % 1073807359;
        for (int i3 = i + 1; i3 < i + i2; i3++) {
            a = (((a * 16785407) % 1073807359) + ((((long) nl.m12812a(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return a;
    }
}
