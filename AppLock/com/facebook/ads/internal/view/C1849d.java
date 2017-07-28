package com.facebook.ads.internal.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class C1849d extends LinearLayout {
    private Bitmap f4623a;
    private Bitmap f4624b;
    private ImageView f4625c;
    private ImageView f4626d;
    private ImageView f4627e;
    private Bitmap f4628f;
    private Bitmap f4629g;
    private int f4630h;
    private int f4631i;
    private int f4632j;
    private int f4633k;
    private int f4634l;
    private int f4635m;
    private double f4636n;
    private double f4637o;

    public C1849d(Context context) {
        super(context);
        m5197d();
    }

    private int m5192a(double d) {
        return (int) Math.round(((double) getWidth()) / d);
    }

    private void m5193a() {
        if (getHeight() > 0 && getWidth() > 0) {
            this.f4637o = ((double) getMeasuredWidth()) / ((double) getMeasuredHeight());
            this.f4636n = ((double) this.f4623a.getWidth()) / ((double) this.f4623a.getHeight());
            if (this.f4636n > this.f4637o) {
                m5195b();
            } else {
                m5196c();
            }
        }
    }

    private int m5194b(double d) {
        return (int) Math.round(((double) getHeight()) * d);
    }

    private void m5195b() {
        this.f4632j = m5192a(this.f4636n);
        this.f4633k = getWidth();
        this.f4630h = (int) Math.ceil((double) (((float) (getHeight() - this.f4632j)) / 2.0f));
        if (this.f4624b != null) {
            Matrix matrix = new Matrix();
            matrix.preScale(1.0f, -1.0f);
            this.f4631i = (int) Math.floor((double) (((float) (getHeight() - this.f4632j)) / 2.0f));
            float height = ((float) this.f4623a.getHeight()) / ((float) this.f4632j);
            int min = Math.min(Math.round(((float) this.f4630h) * height), this.f4624b.getHeight());
            if (min > 0) {
                this.f4628f = Bitmap.createBitmap(this.f4624b, 0, 0, this.f4624b.getWidth(), min, matrix, true);
                this.f4625c.setImageBitmap(this.f4628f);
            }
            min = Math.min(Math.round(((float) this.f4631i) * height), this.f4624b.getHeight());
            if (min > 0) {
                this.f4629g = Bitmap.createBitmap(this.f4624b, 0, this.f4624b.getHeight() - min, this.f4624b.getWidth(), min, matrix, true);
                this.f4627e.setImageBitmap(this.f4629g);
            }
        }
    }

    private void m5196c() {
        this.f4633k = m5194b(this.f4636n);
        this.f4632j = getHeight();
        this.f4634l = (int) Math.ceil((double) (((float) (getWidth() - this.f4633k)) / 2.0f));
        if (this.f4624b != null) {
            Matrix matrix = new Matrix();
            matrix.preScale(-1.0f, 1.0f);
            this.f4635m = (int) Math.floor((double) (((float) (getWidth() - this.f4633k)) / 2.0f));
            float width = ((float) this.f4623a.getWidth()) / ((float) this.f4633k);
            int min = Math.min(Math.round(((float) this.f4634l) * width), this.f4624b.getWidth());
            if (min > 0) {
                this.f4628f = Bitmap.createBitmap(this.f4624b, 0, 0, min, this.f4624b.getHeight(), matrix, true);
                this.f4625c.setImageBitmap(this.f4628f);
            }
            int min2 = Math.min(Math.round(((float) this.f4635m) * width), this.f4624b.getWidth());
            if (min2 > 0) {
                this.f4629g = Bitmap.createBitmap(this.f4624b, this.f4624b.getWidth() - min2, 0, min2, this.f4624b.getHeight(), matrix, true);
                this.f4627e.setImageBitmap(this.f4629g);
            }
        }
    }

    private void m5197d() {
        getContext().getResources().getDisplayMetrics();
        setOrientation(1);
        this.f4625c = new ImageView(getContext());
        this.f4625c.setScaleType(ScaleType.FIT_XY);
        addView(this.f4625c);
        this.f4626d = new ImageView(getContext());
        this.f4626d.setLayoutParams(new LayoutParams(-1, -1));
        this.f4626d.setScaleType(ScaleType.FIT_XY);
        addView(this.f4626d);
        this.f4627e = new ImageView(getContext());
        this.f4627e.setScaleType(ScaleType.FIT_XY);
        addView(this.f4627e);
    }

    private boolean m5198e() {
        return ((this.f4630h + this.f4632j) + this.f4631i == getMeasuredHeight() && (this.f4634l + this.f4633k) + this.f4635m == getMeasuredWidth()) ? false : true;
    }

    public void m5199a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 == null) {
            this.f4625c.setImageDrawable(null);
            this.f4627e.setImageDrawable(null);
        }
        if (bitmap == null) {
            this.f4626d.setImageDrawable(null);
            return;
        }
        this.f4626d.setImageBitmap(Bitmap.createBitmap(bitmap));
        this.f4623a = bitmap;
        this.f4624b = bitmap2;
        m5193a();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f4623a == null) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        m5192a(this.f4636n);
        m5194b(this.f4636n);
        if (this.f4628f == null || m5198e()) {
            m5193a();
        }
        if (this.f4636n > this.f4637o) {
            this.f4625c.layout(i, i2, i3, this.f4630h);
            this.f4626d.layout(i, this.f4630h + i2, i3, this.f4630h + this.f4632j);
            this.f4627e.layout(i, (this.f4630h + i2) + this.f4632j, i3, i4);
            return;
        }
        this.f4625c.layout(i, i2, this.f4634l, i4);
        this.f4626d.layout(this.f4634l + i, i2, this.f4634l + this.f4633k, i4);
        this.f4627e.layout((this.f4634l + i) + this.f4633k, i2, i3, i4);
    }
}
