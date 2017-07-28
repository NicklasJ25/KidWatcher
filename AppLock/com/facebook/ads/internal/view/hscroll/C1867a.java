package com.facebook.ads.internal.view.hscroll;

import android.util.SparseArray;

public class C1867a {
    private final SparseArray<int[]> f4719a = new SparseArray();

    public void m5273a(int i, int[] iArr) {
        this.f4719a.put(i, iArr);
    }

    public int[] m5274a(int i) {
        return (int[]) this.f4719a.get(i);
    }

    public boolean m5275b(int i) {
        return this.f4719a.indexOfKey(i) >= 0;
    }
}
