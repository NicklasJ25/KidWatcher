package com.domobile.lockbean;

import android.text.TextUtils;

public class C1371j {
    public int f2960a;
    public int f2961b;
    public String f2962c;

    public C1371j(String str) {
        this.f2962c = str;
    }

    public boolean equals(Object obj) {
        return ((obj instanceof C1371j) && TextUtils.equals(this.f2962c, ((C1371j) obj).f2962c)) ? true : super.equals(obj);
    }
}
