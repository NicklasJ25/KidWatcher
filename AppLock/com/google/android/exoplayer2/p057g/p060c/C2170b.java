package com.google.android.exoplayer2.p057g.p060c;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p057g.C2167b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

final class C2170b {
    public final String f6084a;
    public final String f6085b;
    public final boolean f6086c;
    public final long f6087d;
    public final long f6088e;
    public final C2173e f6089f;
    public final String f6090g;
    private final String[] f6091h;
    private final HashMap<String, Integer> f6092i;
    private final HashMap<String, Integer> f6093j;
    private List<C2170b> f6094k;

    private C2170b(String str, String str2, long j, long j2, C2173e c2173e, String[] strArr, String str3) {
        this.f6084a = str;
        this.f6085b = str2;
        this.f6089f = c2173e;
        this.f6091h = strArr;
        this.f6086c = str2 != null;
        this.f6087d = j;
        this.f6088e = j2;
        this.f6090g = (String) C2252a.m7020a((Object) str3);
        this.f6092i = new HashMap();
        this.f6093j = new HashMap();
    }

    private SpannableStringBuilder m6667a(SpannableStringBuilder spannableStringBuilder) {
        int i;
        int length = spannableStringBuilder.length();
        int i2 = 0;
        while (i2 < length) {
            if (spannableStringBuilder.charAt(i2) == ' ') {
                i = i2 + 1;
                while (i < spannableStringBuilder.length() && spannableStringBuilder.charAt(i) == ' ') {
                    i++;
                }
                i -= i2 + 1;
                if (i > 0) {
                    spannableStringBuilder.delete(i2, i2 + i);
                    i = length - i;
                    i2++;
                    length = i;
                }
            }
            i = length;
            i2++;
            length = i;
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        i = length;
        length = 0;
        while (length < i - 1) {
            if (spannableStringBuilder.charAt(length) == '\n' && spannableStringBuilder.charAt(length + 1) == ' ') {
                spannableStringBuilder.delete(length + 1, length + 2);
                i--;
            }
            length++;
        }
        if (i > 0 && spannableStringBuilder.charAt(i - 1) == ' ') {
            spannableStringBuilder.delete(i - 1, i);
            i--;
        }
        length = 0;
        while (length < i - 1) {
            if (spannableStringBuilder.charAt(length) == ' ' && spannableStringBuilder.charAt(length + 1) == '\n') {
                spannableStringBuilder.delete(length, length + 1);
                i--;
            }
            length++;
        }
        if (i > 0 && spannableStringBuilder.charAt(i - 1) == '\n') {
            spannableStringBuilder.delete(i - 1, i);
        }
        return spannableStringBuilder;
    }

    private static SpannableStringBuilder m6668a(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return (SpannableStringBuilder) map.get(str);
    }

    public static C2170b m6669a(String str) {
        return new C2170b(null, C2172d.m6682a(str), -9223372036854775807L, -9223372036854775807L, null, null, "");
    }

    public static C2170b m6670a(String str, long j, long j2, C2173e c2173e, String[] strArr, String str2) {
        return new C2170b(str, null, j, j2, c2173e, strArr, str2);
    }

    private void m6671a(long j, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        this.f6092i.clear();
        this.f6093j.clear();
        String str2 = this.f6090g;
        if ("".equals(str2)) {
            str2 = str;
        }
        if (this.f6086c && z) {
            C2170b.m6668a(str2, (Map) map).append(this.f6085b);
        } else if ("br".equals(this.f6084a) && z) {
            C2170b.m6668a(str2, (Map) map).append('\n');
        } else if (!"metadata".equals(this.f6084a) && m6679a(j)) {
            boolean equals = "p".equals(this.f6084a);
            for (Entry entry : map.entrySet()) {
                this.f6092i.put(entry.getKey(), Integer.valueOf(((SpannableStringBuilder) entry.getValue()).length()));
            }
            for (int i = 0; i < m6675a(); i++) {
                C2170b a = m6676a(i);
                boolean z2 = z || equals;
                a.m6671a(j, z2, str2, (Map) map);
            }
            if (equals) {
                C2172d.m6683a(C2170b.m6668a(str2, (Map) map));
            }
            for (Entry entry2 : map.entrySet()) {
                this.f6093j.put(entry2.getKey(), Integer.valueOf(((SpannableStringBuilder) entry2.getValue()).length()));
            }
        }
    }

    private void m6672a(Map<String, C2173e> map, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        if (i != i2) {
            C2173e a = C2172d.m6681a(this.f6089f, this.f6091h, map);
            if (a != null) {
                C2172d.m6684a(spannableStringBuilder, i, i2, a);
            }
        }
    }

    private void m6673a(Map<String, C2173e> map, Map<String, SpannableStringBuilder> map2) {
        for (Entry entry : this.f6093j.entrySet()) {
            String str = (String) entry.getKey();
            m6672a((Map) map, (SpannableStringBuilder) map2.get(str), this.f6092i.containsKey(str) ? ((Integer) this.f6092i.get(str)).intValue() : 0, ((Integer) entry.getValue()).intValue());
            for (int i = 0; i < m6675a(); i++) {
                m6676a(i).m6673a((Map) map, (Map) map2);
            }
        }
    }

    private void m6674a(TreeSet<Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.f6084a);
        if (z || equals) {
            if (this.f6087d != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.f6087d));
            }
            if (this.f6088e != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.f6088e));
            }
        }
        if (this.f6094k != null) {
            for (int i = 0; i < this.f6094k.size(); i++) {
                C2170b c2170b = (C2170b) this.f6094k.get(i);
                boolean z2 = z || equals;
                c2170b.m6674a((TreeSet) treeSet, z2);
            }
        }
    }

    public int m6675a() {
        return this.f6094k == null ? 0 : this.f6094k.size();
    }

    public C2170b m6676a(int i) {
        if (this.f6094k != null) {
            return (C2170b) this.f6094k.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public List<C2167b> m6677a(long j, Map<String, C2173e> map, Map<String, C2171c> map2) {
        Map treeMap = new TreeMap();
        m6671a(j, false, this.f6090g, treeMap);
        m6673a((Map) map, treeMap);
        List<C2167b> arrayList = new ArrayList();
        for (Entry entry : treeMap.entrySet()) {
            C2171c c2171c = (C2171c) map2.get(entry.getKey());
            arrayList.add(new C2167b(m6667a((SpannableStringBuilder) entry.getValue()), null, c2171c.f6096b, c2171c.f6097c, Integer.MIN_VALUE, c2171c.f6095a, Integer.MIN_VALUE, c2171c.f6098d));
        }
        return arrayList;
    }

    public void m6678a(C2170b c2170b) {
        if (this.f6094k == null) {
            this.f6094k = new ArrayList();
        }
        this.f6094k.add(c2170b);
    }

    public boolean m6679a(long j) {
        return (this.f6087d == -9223372036854775807L && this.f6088e == -9223372036854775807L) || ((this.f6087d <= j && this.f6088e == -9223372036854775807L) || ((this.f6087d == -9223372036854775807L && j < this.f6088e) || (this.f6087d <= j && j < this.f6088e)));
    }

    public long[] m6680b() {
        TreeSet treeSet = new TreeSet();
        m6674a(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            jArr[i] = ((Long) it.next()).longValue();
            i = i2;
        }
        return jArr;
    }
}
