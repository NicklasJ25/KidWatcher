package com.google.android.exoplayer2.p057g.p062e;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.p043j.C2273r;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class C2181d {
    private String f6130a;
    private String f6131b;
    private List<String> f6132c;
    private String f6133d;
    private String f6134e;
    private int f6135f;
    private boolean f6136g;
    private int f6137h;
    private boolean f6138i;
    private int f6139j;
    private int f6140k;
    private int f6141l;
    private int f6142m;
    private int f6143n;
    private float f6144o;
    private Alignment f6145p;

    public C2181d() {
        m6744a();
    }

    private static int m6740a(int i, String str, String str2, int i2) {
        return (str.isEmpty() || i == -1) ? i : str.equals(str2) ? i + i2 : -1;
    }

    public int m6741a(String str, String str2, String[] strArr, String str3) {
        if (this.f6130a.isEmpty() && this.f6131b.isEmpty() && this.f6132c.isEmpty() && this.f6133d.isEmpty()) {
            return str2.isEmpty() ? 1 : 0;
        } else {
            int a = C2181d.m6740a(C2181d.m6740a(C2181d.m6740a(0, this.f6130a, str, 1073741824), this.f6131b, str2, 2), this.f6133d, str3, 4);
            return (a == -1 || !Arrays.asList(strArr).containsAll(this.f6132c)) ? 0 : (this.f6132c.size() * 4) + a;
        }
    }

    public C2181d m6742a(int i) {
        this.f6135f = i;
        this.f6136g = true;
        return this;
    }

    public C2181d m6743a(boolean z) {
        this.f6140k = z ? 1 : 0;
        return this;
    }

    public void m6744a() {
        this.f6130a = "";
        this.f6131b = "";
        this.f6132c = Collections.emptyList();
        this.f6133d = "";
        this.f6134e = null;
        this.f6136g = false;
        this.f6138i = false;
        this.f6139j = -1;
        this.f6140k = -1;
        this.f6141l = -1;
        this.f6142m = -1;
        this.f6143n = -1;
        this.f6145p = null;
    }

    public void m6745a(String str) {
        this.f6130a = str;
    }

    public void m6746a(String[] strArr) {
        this.f6132c = Arrays.asList(strArr);
    }

    public int m6747b() {
        int i = 0;
        if (this.f6141l == -1 && this.f6142m == -1) {
            return -1;
        }
        int i2 = this.f6141l == 1 ? 1 : 0;
        if (this.f6142m == 1) {
            i = 2;
        }
        return i2 | i;
    }

    public C2181d m6748b(int i) {
        this.f6137h = i;
        this.f6138i = true;
        return this;
    }

    public C2181d m6749b(boolean z) {
        this.f6141l = z ? 1 : 0;
        return this;
    }

    public void m6750b(String str) {
        this.f6131b = str;
    }

    public C2181d m6751c(boolean z) {
        this.f6142m = z ? 1 : 0;
        return this;
    }

    public void m6752c(String str) {
        this.f6133d = str;
    }

    public boolean m6753c() {
        return this.f6139j == 1;
    }

    public C2181d m6754d(String str) {
        this.f6134e = C2273r.m7141d(str);
        return this;
    }

    public boolean m6755d() {
        return this.f6140k == 1;
    }

    public String m6756e() {
        return this.f6134e;
    }

    public int m6757f() {
        if (this.f6136g) {
            return this.f6135f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public boolean m6758g() {
        return this.f6136g;
    }

    public int m6759h() {
        if (this.f6138i) {
            return this.f6137h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean m6760i() {
        return this.f6138i;
    }

    public Alignment m6761j() {
        return this.f6145p;
    }

    public int m6762k() {
        return this.f6143n;
    }

    public float m6763l() {
        return this.f6144o;
    }
}
