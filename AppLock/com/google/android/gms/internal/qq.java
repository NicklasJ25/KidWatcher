package com.google.android.gms.internal;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import java.util.List;

@wh
public class qq {
    static final int f10355a = f10358d;
    static final int f10356b = f10357c;
    private static final int f10357c = Color.rgb(12, 174, 206);
    private static final int f10358d = Color.rgb(204, 204, 204);
    private final String f10359e;
    private final List<Drawable> f10360f;
    private final int f10361g;
    private final int f10362h;
    private final int f10363i;
    private final int f10364j;
    private final int f10365k;
    private final boolean f10366l;

    public qq(String str, List<Drawable> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.f10359e = str;
        this.f10360f = list;
        this.f10361g = num != null ? num.intValue() : f10355a;
        this.f10362h = num2 != null ? num2.intValue() : f10356b;
        this.f10363i = num3 != null ? num3.intValue() : 12;
        this.f10364j = i;
        this.f10365k = i2;
        this.f10366l = z;
    }

    public String m13337a() {
        return this.f10359e;
    }

    public List<Drawable> m13338b() {
        return this.f10360f;
    }

    public int m13339c() {
        return this.f10361g;
    }

    public int m13340d() {
        return this.f10362h;
    }

    public int m13341e() {
        return this.f10363i;
    }

    public int m13342f() {
        return this.f10364j;
    }

    public int m13343g() {
        return this.f10365k;
    }

    public boolean m13344h() {
        return this.f10366l;
    }
}
