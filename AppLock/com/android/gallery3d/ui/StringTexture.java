package com.android.gallery3d.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Typeface;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;

class StringTexture extends CanvasTexture {
    private final FontMetricsInt mMetrics;
    private final TextPaint mPaint;
    private final String mText;

    private StringTexture(String str, TextPaint textPaint, FontMetricsInt fontMetricsInt, int i, int i2) {
        super(i, i2);
        this.mText = str;
        this.mPaint = textPaint;
        this.mMetrics = fontMetricsInt;
    }

    public static TextPaint getDefaultPaint(float f, int i) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f);
        textPaint.setAntiAlias(true);
        textPaint.setColor(i);
        textPaint.setShadowLayer(2.0f, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
        return textPaint;
    }

    public static StringTexture newInstance(String str, float f, int i) {
        return newInstance(str, getDefaultPaint(f, i));
    }

    public static StringTexture newInstance(String str, float f, int i, float f2, boolean z) {
        TextPaint defaultPaint = getDefaultPaint(f, i);
        if (z) {
            defaultPaint.setTypeface(Typeface.defaultFromStyle(1));
        }
        if (f2 > 0.0f) {
            str = TextUtils.ellipsize(str, defaultPaint, f2, TruncateAt.END).toString();
        }
        return newInstance(str, defaultPaint);
    }

    private static StringTexture newInstance(String str, TextPaint textPaint) {
        int i = 1;
        FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
        int ceil = (int) Math.ceil((double) textPaint.measureText(str));
        int i2 = fontMetricsInt.bottom - fontMetricsInt.top;
        if (ceil <= 0) {
            ceil = 1;
        }
        if (i2 > 0) {
            i = i2;
        }
        return new StringTexture(str, textPaint, fontMetricsInt, ceil, i);
    }

    protected void onDraw(Canvas canvas, Bitmap bitmap) {
        canvas.translate(0.0f, (float) (-this.mMetrics.ascent));
        canvas.drawText(this.mText, 0.0f, 0.0f, this.mPaint);
    }
}
