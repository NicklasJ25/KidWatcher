package com.facebook.ads;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import java.io.Serializable;

public class C1463g implements Serializable {
    @Deprecated
    public static final C1463g f3396a = new C1463g(320, 50);
    public static final C1463g f3397b = new C1463g(0, 0);
    public static final C1463g f3398c = new C1463g(-1, 50);
    public static final C1463g f3399d = new C1463g(-1, 90);
    public static final C1463g f3400e = new C1463g(-1, Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    private final int f3401f;
    private final int f3402g;

    public C1463g(int i, int i2) {
        this.f3401f = i;
        this.f3402g = i2;
    }

    public int m3767a() {
        return this.f3401f;
    }

    public int m3768b() {
        return this.f3402g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1463g c1463g = (C1463g) obj;
        return this.f3401f != c1463g.f3401f ? false : this.f3402g == c1463g.f3402g;
    }

    public int hashCode() {
        return (this.f3401f * 31) + this.f3402g;
    }
}
