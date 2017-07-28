package com.domobile.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.domobile.frame.p000a.C1148d;
import com.domobile.p015b.C1168b.C1159c;
import com.domobile.p015b.C1168b.C1160d;

public class C1410b extends LinearLayout {
    private int f3115a;
    private final Paint f3116b;
    private int f3117c;
    private float f3118d;

    public C1410b(Context context) {
        this(context, null);
    }

    public C1410b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = context.getResources();
        this.f3115a = resources.getDimensionPixelSize(C1160d.PaddingSizeTwo);
        int color = resources.getColor(C1159c.white);
        int color2 = resources.getColor(C1159c.accent_material_light);
        this.f3116b = new Paint();
        this.f3116b.setColor(color);
        setBackgroundColor(color2);
        setWillNotDraw(false);
    }

    private boolean m3577a() {
        return C1148d.O >= 17 && getLayoutDirection() == 1;
    }

    void m3578a(int i, float f, int i2) {
        this.f3117c = i;
        this.f3118d = f;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        int i = 0;
        int i2 = 1;
        if (getChildCount() > 0) {
            View childAt = getChildAt(this.f3117c);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            boolean a = m3577a();
            if (a) {
                if (this.f3117c > 0) {
                    i = 1;
                }
            } else if (this.f3117c < getChildCount() - 1) {
                i = 1;
            }
            if (this.f3118d <= 0.0f || r0 == 0) {
                i = right;
                i2 = left;
            } else {
                i = this.f3117c;
                if (a) {
                    i2 = -1;
                }
                View childAt2 = getChildAt(i + i2);
                i2 = childAt2.getLeft();
                i2 = (int) ((((float) i2) * this.f3118d) + (((float) left) * (1.0f - this.f3118d)));
                i = (int) ((((float) childAt2.getRight()) * this.f3118d) + (((float) right) * (1.0f - this.f3118d)));
            }
            int height = getHeight();
            canvas.drawRect((float) i2, (float) (height - this.f3115a), (float) i, (float) height, this.f3116b);
        }
    }
}
