package com.google.android.exoplayer2.p063h;

import android.graphics.Point;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.C1948n;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p055f.C2152h;
import com.google.android.exoplayer2.p055f.C2153i;
import com.google.android.exoplayer2.p063h.C2202f.C2200a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class C2210c extends C2209e {
    private static final int[] f6266a = new int[0];
    private final C2200a f6267b;
    private final AtomicReference<C2207a> f6268c = new AtomicReference(new C2207a());

    public static final class C2207a {
        public final String f6250a;
        public final String f6251b;
        public final boolean f6252c;
        public final boolean f6253d;
        public final int f6254e;
        public final int f6255f;
        public final boolean f6256g;
        public final int f6257h;
        public final int f6258i;
        public final boolean f6259j;

        public C2207a() {
            this(null, null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public C2207a(String str, String str2, boolean z, boolean z2, int i, int i2, boolean z3, int i3, int i4, boolean z4) {
            this.f6250a = str;
            this.f6251b = str2;
            this.f6252c = z;
            this.f6253d = z2;
            this.f6254e = i;
            this.f6255f = i2;
            this.f6256g = z3;
            this.f6257h = i3;
            this.f6258i = i4;
            this.f6259j = z4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C2207a c2207a = (C2207a) obj;
            return this.f6252c == c2207a.f6252c && this.f6253d == c2207a.f6253d && this.f6254e == c2207a.f6254e && this.f6255f == c2207a.f6255f && this.f6256g == c2207a.f6256g && this.f6259j == c2207a.f6259j && this.f6257h == c2207a.f6257h && this.f6258i == c2207a.f6258i && TextUtils.equals(this.f6250a, c2207a.f6250a) && TextUtils.equals(this.f6251b, c2207a.f6251b);
        }

        public int hashCode() {
            int i = 1;
            int hashCode = ((this.f6256g ? 1 : 0) + (((((((this.f6253d ? 1 : 0) + (((this.f6252c ? 1 : 0) + (((this.f6250a.hashCode() * 31) + this.f6251b.hashCode()) * 31)) * 31)) * 31) + this.f6254e) * 31) + this.f6255f) * 31)) * 31;
            if (!this.f6259j) {
                i = 0;
            }
            return ((((hashCode + i) * 31) + this.f6257h) * 31) + this.f6258i;
        }
    }

    public C2210c(Handler handler, C2200a c2200a) {
        super(handler);
        this.f6267b = c2200a;
    }

    private static int m6881a(int i, int i2) {
        return i == -1 ? i2 == -1 ? 0 : -1 : i2 == -1 ? 1 : i - i2;
    }

    private static int m6882a(C2152h c2152h, int[] iArr, int i, String str, int i2, int i3, List<Integer> list) {
        int i4 = 0;
        int i5 = 0;
        while (i4 < list.size()) {
            int intValue = ((Integer) list.get(i4)).intValue();
            i4++;
            i5 = C2210c.m6889a(c2152h.m6574a(intValue), str, iArr[intValue], i, i2, i3) ? i5 + 1 : i5;
        }
        return i5;
    }

    private static Point m6883a(boolean z, int i, int i2, int i3, int i4) {
        Object obj = 1;
        if (z) {
            Object obj2 = i3 > i4 ? 1 : null;
            if (i <= i2) {
                obj = null;
            }
            if (obj2 != obj) {
                int i5 = i;
                i = i2;
                i2 = i5;
            }
        }
        return i3 * i2 >= i4 * i ? new Point(i, C2273r.m7125a(i * i4, i3)) : new Point(C2273r.m7125a(i2 * i3, i4), i2);
    }

    private static C2202f m6884a(C2153i c2153i, int[][] iArr, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        C2152h c2152h = null;
        int i5 = 0;
        int i6 = -1;
        Object obj = null;
        for (int i7 = 0; i7 < c2153i.f6028a; i7++) {
            C2152h a = c2153i.m6576a(i7);
            List a2 = C2210c.m6886a(a, i3, i4, z);
            int[] iArr2 = iArr[i7];
            int i8 = 0;
            while (i8 < a.f6025a) {
                Object obj2;
                int a3;
                int i9;
                C2152h c2152h2;
                if (C2210c.m6887a(iArr2[i8])) {
                    Format a4 = a.m6574a(i8);
                    obj2 = (!a2.contains(Integer.valueOf(i8)) || ((a4.f4951i != -1 && a4.f4951i > i) || (a4.f4952j != -1 && a4.f4952j > i2))) ? null : 1;
                    a3 = a4.m5488a();
                    Object obj3 = obj != null ? (obj2 == null || C2210c.m6881a(a3, i6) <= 0) ? null : 1 : (obj2 != null || (z2 && (c2152h == null || C2210c.m6881a(a3, i6) < 0))) ? 1 : null;
                    if (obj3 != null) {
                        i9 = a3;
                        c2152h2 = a;
                        a3 = i8;
                        i8++;
                        i5 = a3;
                        c2152h = c2152h2;
                        i6 = i9;
                        obj = obj2;
                    }
                }
                obj2 = obj;
                a3 = i5;
                i9 = i6;
                c2152h2 = c2152h;
                i8++;
                i5 = a3;
                c2152h = c2152h2;
                i6 = i9;
                obj = obj2;
            }
        }
        return c2152h == null ? null : new C2211d(c2152h, i5);
    }

    private static C2202f m6885a(C1948n c1948n, C2153i c2153i, int[][] iArr, int i, int i2, boolean z, boolean z2, int i3, int i4, boolean z3, C2200a c2200a) {
        int i5 = z ? 12 : 8;
        boolean z4 = z2 && (c1948n.mo2910l() & i5) != 0;
        for (int i6 = 0; i6 < c2153i.f6028a; i6++) {
            C2152h a = c2153i.m6576a(i6);
            int[] a2 = C2210c.m6890a(a, iArr[i6], z4, i5, i, i2, i3, i4, z3);
            if (a2.length > 0) {
                return c2200a.mo3085b(a, a2);
            }
        }
        return null;
    }

    private static List<Integer> m6886a(C2152h c2152h, int i, int i2, boolean z) {
        int i3;
        int i4 = 0;
        ArrayList arrayList = new ArrayList(c2152h.f6025a);
        for (i3 = 0; i3 < c2152h.f6025a; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
            return arrayList;
        }
        int i5 = Integer.MAX_VALUE;
        while (i4 < c2152h.f6025a) {
            Format a = c2152h.m6574a(i4);
            if (a.f4951i > 0 && a.f4952j > 0) {
                Point a2 = C2210c.m6883a(z, i, i2, a.f4951i, a.f4952j);
                i3 = a.f4951i * a.f4952j;
                if (a.f4951i >= ((int) (((float) a2.x) * 0.98f)) && a.f4952j >= ((int) (((float) a2.y) * 0.98f)) && i3 < i5) {
                    i4++;
                    i5 = i3;
                }
            }
            i3 = i5;
            i4++;
            i5 = i3;
        }
        if (i5 != Integer.MAX_VALUE) {
            for (i4 = arrayList.size() - 1; i4 >= 0; i4--) {
                i3 = c2152h.m6574a(((Integer) arrayList.get(i4)).intValue()).m5488a();
                if (i3 == -1 || i3 > i5) {
                    arrayList.remove(i4);
                }
            }
        }
        return arrayList;
    }

    private static boolean m6887a(int i) {
        return (i & 3) == 3;
    }

    private static boolean m6888a(Format format, String str) {
        return str != null && str.equals(C2273r.m7139b(format.f4965w));
    }

    private static boolean m6889a(Format format, String str, int i, int i2, int i3, int i4) {
        return C2210c.m6887a(i) && (i & i2) != 0 && ((str == null || C2273r.m7135a(format.f4947e, (Object) str)) && ((format.f4951i == -1 || format.f4951i <= i3) && (format.f4952j == -1 || format.f4952j <= i4)));
    }

    private static int[] m6890a(C2152h c2152h, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, boolean z2) {
        if (c2152h.f6025a < 2) {
            return f6266a;
        }
        List a = C2210c.m6886a(c2152h, i4, i5, z2);
        if (a.size() < 2) {
            return f6266a;
        }
        String str;
        String str2 = null;
        if (z) {
            str = null;
        } else {
            HashSet hashSet = new HashSet();
            int i6 = 0;
            int i7 = 0;
            while (i7 < a.size()) {
                int a2;
                str = c2152h.m6574a(((Integer) a.get(i7)).intValue()).f4947e;
                if (!hashSet.contains(str)) {
                    hashSet.add(str);
                    a2 = C2210c.m6882a(c2152h, iArr, i, str, i2, i3, a);
                    if (a2 > i6) {
                        i7++;
                        i6 = a2;
                        str2 = str;
                    }
                }
                a2 = i6;
                str = str2;
                i7++;
                i6 = a2;
                str2 = str;
            }
            str = str2;
        }
        C2210c.m6891b(c2152h, iArr, i, str, i2, i3, a);
        return a.size() < 2 ? f6266a : C2273r.m7136a(a);
    }

    private static void m6891b(C2152h c2152h, int[] iArr, int i, String str, int i2, int i3, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = ((Integer) list.get(size)).intValue();
            if (!C2210c.m6889a(c2152h.m6574a(intValue), str, iArr[intValue], i, i2, i3)) {
                list.remove(size);
            }
        }
    }

    protected C2202f m6892a(int i, C2153i c2153i, int[][] iArr) {
        Object obj = null;
        int i2 = 0;
        C2152h c2152h = null;
        for (int i3 = 0; i3 < c2153i.f6028a; i3++) {
            C2152h a = c2153i.m6576a(i3);
            int[] iArr2 = iArr[i3];
            int i4 = 0;
            while (i4 < a.f6025a) {
                Object obj2;
                int i5;
                C2152h c2152h2;
                if (C2210c.m6887a(iArr2[i4])) {
                    if (((a.m6574a(i4).f4964v & 1) != 0 ? 1 : null) != null) {
                        obj2 = 2;
                    } else {
                        int i6 = 1;
                    }
                    if (obj2 > obj) {
                        i5 = i4;
                        c2152h2 = a;
                        i4++;
                        c2152h = c2152h2;
                        i2 = i5;
                        obj = obj2;
                    }
                }
                obj2 = obj;
                i5 = i2;
                c2152h2 = c2152h;
                i4++;
                c2152h = c2152h2;
                i2 = i5;
                obj = obj2;
            }
        }
        return c2152h == null ? null : new C2211d(c2152h, i2);
    }

    protected C2202f m6893a(C2153i c2153i, int[][] iArr, String str) {
        Object obj = null;
        int i = 0;
        C2152h c2152h = null;
        for (int i2 = 0; i2 < c2153i.f6028a; i2++) {
            C2152h a = c2153i.m6576a(i2);
            int[] iArr2 = iArr[i2];
            int i3 = 0;
            while (i3 < a.f6025a) {
                Object obj2;
                int i4;
                C2152h c2152h2;
                if (C2210c.m6887a(iArr2[i3])) {
                    Format a2 = a.m6574a(i3);
                    obj2 = (a2.f4964v & 1) != 0 ? 1 : null;
                    if (C2210c.m6888a(a2, str)) {
                        obj2 = obj2 != null ? 4 : 3;
                    } else if (obj2 != null) {
                        obj2 = 2;
                    } else {
                        int i5 = 1;
                    }
                    if (obj2 > obj) {
                        i4 = i3;
                        c2152h2 = a;
                        i3++;
                        c2152h = c2152h2;
                        i = i4;
                        obj = obj2;
                    }
                }
                obj2 = obj;
                i4 = i;
                c2152h2 = c2152h;
                i3++;
                c2152h = c2152h2;
                i = i4;
                obj = obj2;
            }
        }
        return c2152h == null ? null : new C2211d(c2152h, i);
    }

    protected C2202f m6894a(C2153i c2153i, int[][] iArr, String str, String str2) {
        C2152h c2152h = null;
        int i = 0;
        Object obj = null;
        for (int i2 = 0; i2 < c2153i.f6028a; i2++) {
            C2152h a = c2153i.m6576a(i2);
            int[] iArr2 = iArr[i2];
            int i3 = 0;
            while (i3 < a.f6025a) {
                Object obj2;
                int i4;
                C2152h c2152h2;
                if (C2210c.m6887a(iArr2[i3])) {
                    Format a2 = a.m6574a(i3);
                    obj2 = (a2.f4964v & 1) != 0 ? 1 : null;
                    Object obj3 = (a2.f4964v & 2) != 0 ? 1 : null;
                    obj2 = C2210c.m6888a(a2, str) ? obj2 != null ? 6 : obj3 == null ? 5 : 4 : obj2 != null ? 3 : obj3 != null ? C2210c.m6888a(a2, str2) ? 2 : 1 : null;
                    if (obj2 > obj) {
                        i4 = i3;
                        c2152h2 = a;
                        i3++;
                        c2152h = c2152h2;
                        i = i4;
                        obj = obj2;
                    }
                }
                obj2 = obj;
                i4 = i;
                c2152h2 = c2152h;
                i3++;
                c2152h = c2152h2;
                i = i4;
                obj = obj2;
            }
        }
        return c2152h == null ? null : new C2211d(c2152h, i);
    }

    protected C2202f m6895a(C1948n c1948n, C2153i c2153i, int[][] iArr, int i, int i2, boolean z, boolean z2, int i3, int i4, boolean z3, C2200a c2200a, boolean z4) {
        C2202f c2202f = null;
        if (c2200a != null) {
            c2202f = C2210c.m6885a(c1948n, c2153i, iArr, i, i2, z, z2, i3, i4, z3, c2200a);
        }
        return c2202f == null ? C2210c.m6884a(c2153i, iArr, i, i2, i3, i4, z3, z4) : c2202f;
    }

    protected C2202f[] mo3091a(C1948n[] c1948nArr, C2153i[] c2153iArr, int[][][] iArr) {
        C2202f[] c2202fArr = new C2202f[c1948nArr.length];
        C2207a c2207a = (C2207a) this.f6268c.get();
        for (int i = 0; i < c1948nArr.length; i++) {
            switch (c1948nArr[i].mo2894a()) {
                case 1:
                    c2202fArr[i] = m6893a(c2153iArr[i], iArr[i], c2207a.f6250a);
                    break;
                case 2:
                    c2202fArr[i] = m6895a(c1948nArr[i], c2153iArr[i], iArr[i], c2207a.f6254e, c2207a.f6255f, c2207a.f6253d, c2207a.f6252c, c2207a.f6257h, c2207a.f6258i, c2207a.f6259j, this.f6267b, c2207a.f6256g);
                    break;
                case 3:
                    c2202fArr[i] = m6894a(c2153iArr[i], iArr[i], c2207a.f6251b, c2207a.f6250a);
                    break;
                default:
                    c2202fArr[i] = m6892a(c1948nArr[i].mo2894a(), c2153iArr[i], iArr[i]);
                    break;
            }
        }
        return c2202fArr;
    }
}
