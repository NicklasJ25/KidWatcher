package com.domobile.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.domobile.applock.C1140x.C1139g;

public class LockerHeaderItemView extends CardView {
    private Drawable f3055a;
    private String f3056b;
    private int f3057c = 14;
    private int f3058d = -1;

    public LockerHeaderItemView(Context context) {
        super(context);
    }

    public LockerHeaderItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3534a(context, attributeSet, 0);
    }

    public LockerHeaderItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3534a(context, attributeSet, i);
    }

    private void m3534a(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1139g.LockerHeaderItemView, i, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        while (i2 < indexCount) {
            int index = obtainStyledAttributes.getIndex(i2);
            switch (index) {
                case 0:
                    this.f3057c = obtainStyledAttributes.getDimensionPixelSize(index, 14);
                    break;
                case 1:
                    this.f3058d = obtainStyledAttributes.getColor(index, -1);
                    break;
                case 2:
                    this.f3055a = obtainStyledAttributes.getDrawable(index);
                    break;
                case 3:
                    this.f3056b = obtainStyledAttributes.getString(index);
                    break;
                default:
                    break;
            }
            i2++;
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f3055a != null && !TextUtils.isEmpty(this.f3056b)) {
            int contentPaddingTop = getContentPaddingTop();
            contentPaddingTop = (getHeight() - contentPaddingTop) - getContentPaddingBottom();
            int contentPaddingLeft = getContentPaddingLeft();
            int height = (getHeight() - contentPaddingTop) / 2;
            this.f3055a.setBounds(contentPaddingLeft, height, contentPaddingTop + contentPaddingLeft, height + contentPaddingTop);
            this.f3055a.setColorFilter(this.f3058d, Mode.SRC_ATOP);
            this.f3055a.draw(canvas);
            String str = this.f3056b;
            if (!TextUtils.isEmpty(str)) {
                Paint paint = new Paint(1);
                paint.setTextSize((float) getTextSize());
                paint.setColor(getTextColor());
                Rect rect = new Rect();
                paint.getTextBounds(str, 0, str.length(), rect);
                canvas.drawText(str, (float) this.f3055a.getBounds().right, (float) (((getHeight() - rect.height()) / 2) + (rect.height() - rect.bottom)), paint);
            }
        }
    }

    public int getTextColor() {
        return this.f3058d;
    }

    public int getTextSize() {
        return this.f3057c;
    }

    public void setImageDrawable(Drawable drawable) {
        this.f3055a = drawable;
        invalidate();
    }

    public void setTextColor(int i) {
        this.f3058d = i;
        invalidate();
    }

    public void setTextSize(int i) {
        this.f3057c = (int) TypedValue.applyDimension(2, (float) i, getResources().getDisplayMetrics());
        invalidate();
    }

    public void setTitle(int i) {
        this.f3056b = getContext().getString(i);
        invalidate();
    }

    public void setTitle(String str) {
        this.f3056b = str;
        invalidate();
    }
}
