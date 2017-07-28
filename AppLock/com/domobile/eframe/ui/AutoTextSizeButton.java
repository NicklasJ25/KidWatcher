package com.domobile.eframe.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Button;
import com.domobile.applock.R;

public class AutoTextSizeButton extends Button {
    Rect mBounds = new Rect();

    public AutoTextSizeButton(Context context) {
        super(context);
    }

    public AutoTextSizeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutoTextSizeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getFontHeight(float f) {
        if (TextUtils.isEmpty(getText().toString())) {
            return 0;
        }
        Paint paint = new Paint();
        paint.setTextSize(f);
        FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) Math.ceil((double) ((fontMetrics.bottom - fontMetrics.top) - ((fontMetrics.descent - fontMetrics.ascent) / 2.0f)));
    }

    public int getTextWidth(float f) {
        Object charSequence = getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        Paint paint = new Paint();
        paint.setTextSize(f);
        return (int) paint.measureText(charSequence);
    }

    protected void onDraw(Canvas canvas) {
        String charSequence = getText().toString();
        if (!TextUtils.isEmpty(charSequence) && getTextSize() >= 1.0f) {
            if (this.mBounds == null) {
                this.mBounds = new Rect();
            }
            getPaint().setColor(getCurrentTextColor());
            getPaint().getTextBounds(charSequence, 0, charSequence.length(), this.mBounds);
            if (getTextSize() < 15.0f || ((double) this.mBounds.height()) <= ((double) getHeight()) / 2.0d) {
                canvas.drawText(charSequence, (((float) getWidth()) - getPaint().measureText(charSequence)) / 2.0f, (float) ((this.mBounds.height() - this.mBounds.bottom) + ((getHeight() - this.mBounds.height()) / 2)), getPaint());
                return;
            }
            setTextSize(0, getTextSize() - 3.0f);
            invalidate();
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            int height = getHeight() / 2;
            int dimensionPixelSize = i - getContext().getResources().getDimensionPixelSize(R.dimen.auto_textsize_view_blankspace_width);
            int ceil = (int) Math.ceil((double) ((((float) getHeight()) * 3.0f) / 4.0f));
            while (ceil >= 15 && getFontHeight((float) ceil) > height) {
                ceil -= 3;
            }
            while (ceil >= 15 && getTextWidth((float) ceil) > dimensionPixelSize) {
                ceil -= 3;
            }
            setTextSize(0, (float) ceil);
            invalidate();
        }
    }
}
