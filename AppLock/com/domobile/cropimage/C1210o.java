package com.domobile.cropimage;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class C1210o {
    private Bitmap f2384a;
    private int f2385b = 0;

    public C1210o(Bitmap bitmap) {
        this.f2384a = bitmap;
    }

    public int m2824a() {
        return this.f2385b;
    }

    public void m2825a(int i) {
        this.f2385b = i;
    }

    public void m2826a(Bitmap bitmap) {
        this.f2384a = bitmap;
    }

    public Bitmap m2827b() {
        return this.f2384a;
    }

    public Matrix m2828c() {
        Matrix matrix = new Matrix();
        if (this.f2385b != 0) {
            matrix.preTranslate((float) (-(this.f2384a.getWidth() / 2)), (float) (-(this.f2384a.getHeight() / 2)));
            matrix.postRotate((float) this.f2385b);
            matrix.postTranslate((float) (m2831f() / 2), (float) (m2830e() / 2));
        }
        return matrix;
    }

    public boolean m2829d() {
        return (this.f2385b / 90) % 2 != 0;
    }

    public int m2830e() {
        return m2829d() ? this.f2384a.getWidth() : this.f2384a.getHeight();
    }

    public int m2831f() {
        return m2829d() ? this.f2384a.getHeight() : this.f2384a.getWidth();
    }
}
