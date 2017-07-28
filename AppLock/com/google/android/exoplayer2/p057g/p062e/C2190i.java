package com.google.android.exoplayer2.p057g.p062e;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p057g.C2159e;
import com.google.android.exoplayer2.p057g.C2167b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class C2190i implements C2159e {
    private final List<C2184e> f6176a;
    private final int f6177b;
    private final long[] f6178c = new long[(this.f6177b * 2)];
    private final long[] f6179d;

    public C2190i(List<C2184e> list) {
        this.f6176a = list;
        this.f6177b = list.size();
        for (int i = 0; i < this.f6177b; i++) {
            C2184e c2184e = (C2184e) list.get(i);
            int i2 = i * 2;
            this.f6178c[i2] = c2184e.f6157i;
            this.f6178c[i2 + 1] = c2184e.f6158j;
        }
        this.f6179d = Arrays.copyOf(this.f6178c, this.f6178c.length);
        Arrays.sort(this.f6179d);
    }

    public int mo3051a(long j) {
        int b = C2273r.m7138b(this.f6179d, j, false, false);
        return b < this.f6179d.length ? b : -1;
    }

    public long mo3052a(int i) {
        boolean z = true;
        C2252a.m7022a(i >= 0);
        if (i >= this.f6179d.length) {
            z = false;
        }
        C2252a.m7022a(z);
        return this.f6179d[i];
    }

    public int mo3053b() {
        return this.f6179d.length;
    }

    public List<C2167b> mo3054b(long j) {
        CharSequence charSequence = null;
        int i = 0;
        C2184e c2184e = null;
        ArrayList arrayList = null;
        while (i < this.f6177b) {
            CharSequence charSequence2;
            C2184e c2184e2;
            ArrayList arrayList2;
            CharSequence charSequence3;
            if (this.f6178c[i * 2] > j || j >= this.f6178c[(i * 2) + 1]) {
                charSequence2 = charSequence;
                c2184e2 = c2184e;
                arrayList2 = arrayList;
                charSequence3 = charSequence2;
            } else {
                ArrayList arrayList3 = arrayList == null ? new ArrayList() : arrayList;
                C2184e c2184e3 = (C2184e) this.f6176a.get(i);
                if (!c2184e3.m6777a()) {
                    arrayList3.add(c2184e3);
                    charSequence3 = charSequence;
                    c2184e2 = c2184e;
                    arrayList2 = arrayList3;
                } else if (c2184e == null) {
                    arrayList2 = arrayList3;
                    C2184e c2184e4 = c2184e3;
                    charSequence3 = charSequence;
                    c2184e2 = c2184e4;
                } else if (charSequence == null) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append(c2184e.a).append("\n").append(c2184e3.a);
                    Object obj = spannableStringBuilder;
                    c2184e2 = c2184e;
                    arrayList2 = arrayList3;
                } else {
                    charSequence.append("\n").append(c2184e3.a);
                    charSequence3 = charSequence;
                    c2184e2 = c2184e;
                    arrayList2 = arrayList3;
                }
            }
            i++;
            charSequence2 = charSequence3;
            arrayList = arrayList2;
            c2184e = c2184e2;
            charSequence = charSequence2;
        }
        if (charSequence != null) {
            arrayList.add(new C2184e(charSequence));
        } else if (c2184e != null) {
            arrayList.add(c2184e);
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }
}
