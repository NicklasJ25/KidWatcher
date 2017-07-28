package com.domobile.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.view.View;
import com.domobile.applock.R;

public class PageIndicator extends View {
    private int f3084a;
    private int f3085b;
    private int f3086c;
    private int f3087d;
    private int f3088e;
    private int f3089f;
    private Paint f3090g;

    public PageIndicator(Context context) {
        this(context, null);
    }

    public PageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3084a = 0;
        this.f3085b = 0;
        this.f3086c = 0;
        this.f3087d = 0;
        this.f3088e = -1;
        this.f3089f = -3355444;
        this.f3090g = new Paint(1);
        this.f3086c = context.getResources().getDimensionPixelOffset(R.dimen.PaddingSizeSmaller);
        this.f3087d = context.getResources().getDimensionPixelOffset(R.dimen.PaddingSizeSmaller);
        this.f3088e = ResourcesCompat.getColor(context.getResources(), R.color.material_deep_teal_500, null);
        this.f3089f = ResourcesCompat.getColor(context.getResources(), R.color.unlock_settings_divider_color, null);
    }

    public PageIndicator m3556a(int i) {
        getLayoutParams().width = i <= 0 ? 0 : ((this.f3087d * i) * 2) + (this.f3086c * (i - 1));
        getLayoutParams().height = this.f3087d * 2;
        this.f3085b = i;
        requestLayout();
        invalidate();
        return this;
    }

    public PageIndicator m3557b(int i) {
        this.f3084a = i;
        invalidate();
        return this;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f3090g.setStyle(Style.FILL);
        int i = 0;
        while (i < this.f3085b) {
            int i2 = this.f3087d + (((this.f3087d * i) * 2) + (this.f3086c * i));
            this.f3090g.setColor(i == this.f3084a ? this.f3088e : this.f3089f);
            canvas.drawCircle((float) i2, (float) this.f3087d, (float) this.f3087d, this.f3090g);
            i++;
        }
    }

    public void setActiveColor(@ColorRes int i) {
        this.f3088e = ResourcesCompat.getColor(getResources(), i, null);
    }

    public void setNormalColor(@ColorRes int i) {
        this.f3089f = ResourcesCompat.getColor(getResources(), i, null);
    }

    public void setPadding(@DimenRes int i) {
        this.f3086c = getResources().getDimensionPixelSize(i);
    }

    public void setRadius(@DimenRes int i) {
        this.f3087d = getResources().getDimensionPixelSize(i);
    }
}
