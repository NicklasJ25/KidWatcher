package com.getbase.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import com.domobile.p015b.C1168b.C1160d;
import com.domobile.p015b.C1168b.C1167k;

public class C1910a extends FloatingActionButton {
    int f4861a;

    void mo2846a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1167k.AddFloatingActionButton, 0, 0);
        this.f4861a = obtainStyledAttributes.getColor(C1167k.AddFloatingActionButton_fab_plusIconColor, m5444a(17170443));
        obtainStyledAttributes.recycle();
        super.mo2846a(context, attributeSet);
    }

    Drawable getIconDrawable() {
        final float b = m5447b(C1160d.fab_icon_size);
        final float f = b / 2.0f;
        final float b2 = m5447b(C1160d.fab_plus_icon_stroke) / 2.0f;
        final float b3 = (b - m5447b(C1160d.fab_plus_icon_size)) / 2.0f;
        Drawable shapeDrawable = new ShapeDrawable(new Shape(this) {
            final /* synthetic */ C1910a f4896e;

            public void draw(Canvas canvas, Paint paint) {
                canvas.drawRect(b3, f - b2, b - b3, b2 + f, paint);
                canvas.drawRect(f - b2, b3, b2 + f, b - b3, paint);
            }
        });
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(this.f4861a);
        paint.setStyle(Style.FILL);
        paint.setAntiAlias(true);
        return shapeDrawable;
    }

    public int getPlusColor() {
        return this.f4861a;
    }

    public void setIcon(@DrawableRes int i) {
        throw new UnsupportedOperationException("Use FloatingActionButton if you want to use custom icon");
    }

    public void setPlusColor(int i) {
        if (this.f4861a != i) {
            this.f4861a = i;
            mo2849a();
        }
    }

    public void setPlusColorResId(@ColorRes int i) {
        setPlusColor(m5444a(i));
    }
}
