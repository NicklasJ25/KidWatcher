package com.google.android.gms.internal;

import com.google.android.gms.common.internal.C2512b;
import java.util.ArrayList;
import java.util.List;

@wh
public class zr {
    private final String[] f11721a;
    private final double[] f11722b;
    private final double[] f11723c;
    private final int[] f11724d;
    private int f11725e;

    public static class C3499a {
        public final String f11713a;
        public final double f11714b;
        public final double f11715c;
        public final double f11716d;
        public final int f11717e;

        public C3499a(String str, double d, double d2, double d3, int i) {
            this.f11713a = str;
            this.f11715c = d;
            this.f11714b = d2;
            this.f11716d = d3;
            this.f11717e = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C3499a)) {
                return false;
            }
            C3499a c3499a = (C3499a) obj;
            return C2512b.m7931a(this.f11713a, c3499a.f11713a) && this.f11714b == c3499a.f11714b && this.f11715c == c3499a.f11715c && this.f11717e == c3499a.f11717e && Double.compare(this.f11716d, c3499a.f11716d) == 0;
        }

        public int hashCode() {
            return C2512b.m7929a(this.f11713a, Double.valueOf(this.f11714b), Double.valueOf(this.f11715c), Double.valueOf(this.f11716d), Integer.valueOf(this.f11717e));
        }

        public String toString() {
            return C2512b.m7930a((Object) this).m7928a("name", this.f11713a).m7928a("minBound", Double.valueOf(this.f11715c)).m7928a("maxBound", Double.valueOf(this.f11714b)).m7928a("percent", Double.valueOf(this.f11716d)).m7928a("count", Integer.valueOf(this.f11717e)).toString();
        }
    }

    public static class C3500b {
        private final List<String> f11718a = new ArrayList();
        private final List<Double> f11719b = new ArrayList();
        private final List<Double> f11720c = new ArrayList();

        public C3500b m15254a(String str, double d, double d2) {
            int i = 0;
            while (i < this.f11718a.size()) {
                double doubleValue = ((Double) this.f11720c.get(i)).doubleValue();
                double doubleValue2 = ((Double) this.f11719b.get(i)).doubleValue();
                if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                    break;
                }
                i++;
            }
            this.f11718a.add(i, str);
            this.f11720c.add(i, Double.valueOf(d));
            this.f11719b.add(i, Double.valueOf(d2));
            return this;
        }

        public zr m15255a() {
            return new zr();
        }
    }

    private zr(C3500b c3500b) {
        int size = c3500b.f11719b.size();
        this.f11721a = (String[]) c3500b.f11718a.toArray(new String[size]);
        this.f11722b = m15256a(c3500b.f11719b);
        this.f11723c = m15256a(c3500b.f11720c);
        this.f11724d = new int[size];
        this.f11725e = 0;
    }

    private double[] m15256a(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    public List<C3499a> m15257a() {
        List<C3499a> arrayList = new ArrayList(this.f11721a.length);
        for (int i = 0; i < this.f11721a.length; i++) {
            arrayList.add(new C3499a(this.f11721a[i], this.f11723c[i], this.f11722b[i], ((double) this.f11724d[i]) / ((double) this.f11725e), this.f11724d[i]));
        }
        return arrayList;
    }

    public void m15258a(double d) {
        this.f11725e++;
        int i = 0;
        while (i < this.f11723c.length) {
            if (this.f11723c[i] <= d && d < this.f11722b[i]) {
                int[] iArr = this.f11724d;
                iArr[i] = iArr[i] + 1;
            }
            if (d >= this.f11723c[i]) {
                i++;
            } else {
                return;
            }
        }
    }
}
