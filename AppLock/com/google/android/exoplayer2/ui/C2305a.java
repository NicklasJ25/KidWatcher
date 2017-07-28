package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p057g.C2163a;
import com.google.android.exoplayer2.p057g.C2167b;

final class C2305a {
    private int f6631A;
    private int f6632B;
    private int f6633C;
    private StaticLayout f6634D;
    private int f6635E;
    private int f6636F;
    private int f6637G;
    private final RectF f6638a = new RectF();
    private final float f6639b;
    private final float f6640c;
    private final float f6641d;
    private final float f6642e;
    private final float f6643f;
    private final float f6644g;
    private final TextPaint f6645h;
    private final Paint f6646i;
    private CharSequence f6647j;
    private Alignment f6648k;
    private float f6649l;
    private int f6650m;
    private int f6651n;
    private float f6652o;
    private int f6653p;
    private float f6654q;
    private boolean f6655r;
    private int f6656s;
    private int f6657t;
    private int f6658u;
    private int f6659v;
    private int f6660w;
    private float f6661x;
    private float f6662y;
    private int f6663z;

    public C2305a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.f6644g = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f6643f = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        int round = Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * 2.0f) / 160.0f);
        this.f6639b = (float) round;
        this.f6640c = (float) round;
        this.f6641d = (float) round;
        this.f6642e = (float) round;
        this.f6645h = new TextPaint();
        this.f6645h.setAntiAlias(true);
        this.f6645h.setSubpixelText(true);
        this.f6646i = new Paint();
        this.f6646i.setAntiAlias(true);
        this.f6646i.setStyle(Style.FILL);
    }

    private void m7323a(Canvas canvas) {
        StaticLayout staticLayout = this.f6634D;
        if (staticLayout != null) {
            int lineCount;
            int i;
            int save = canvas.save();
            canvas.translate((float) this.f6635E, (float) this.f6636F);
            if (Color.alpha(this.f6658u) > 0) {
                this.f6646i.setColor(this.f6658u);
                canvas.drawRect((float) (-this.f6637G), 0.0f, (float) (staticLayout.getWidth() + this.f6637G), (float) staticLayout.getHeight(), this.f6646i);
            }
            if (Color.alpha(this.f6657t) > 0) {
                this.f6646i.setColor(this.f6657t);
                float lineTop = (float) staticLayout.getLineTop(0);
                lineCount = staticLayout.getLineCount();
                float f = lineTop;
                for (i = 0; i < lineCount; i++) {
                    this.f6638a.left = staticLayout.getLineLeft(i) - ((float) this.f6637G);
                    this.f6638a.right = staticLayout.getLineRight(i) + ((float) this.f6637G);
                    this.f6638a.top = f;
                    this.f6638a.bottom = (float) staticLayout.getLineBottom(i);
                    f = this.f6638a.bottom;
                    canvas.drawRoundRect(this.f6638a, this.f6639b, this.f6639b, this.f6646i);
                }
            }
            if (this.f6660w == 1) {
                this.f6645h.setStrokeJoin(Join.ROUND);
                this.f6645h.setStrokeWidth(this.f6640c);
                this.f6645h.setColor(this.f6659v);
                this.f6645h.setStyle(Style.FILL_AND_STROKE);
                staticLayout.draw(canvas);
            } else if (this.f6660w == 2) {
                this.f6645h.setShadowLayer(this.f6641d, this.f6642e, this.f6642e, this.f6659v);
            } else if (this.f6660w == 3 || this.f6660w == 4) {
                lineCount = this.f6660w == 3 ? 1 : 0;
                int i2 = lineCount != 0 ? -1 : this.f6659v;
                i = lineCount != 0 ? this.f6659v : -1;
                float f2 = this.f6641d / 2.0f;
                this.f6645h.setColor(this.f6656s);
                this.f6645h.setStyle(Style.FILL);
                this.f6645h.setShadowLayer(this.f6641d, -f2, -f2, i2);
                staticLayout.draw(canvas);
                this.f6645h.setShadowLayer(this.f6641d, f2, f2, i);
            }
            this.f6645h.setColor(this.f6656s);
            this.f6645h.setStyle(Style.FILL);
            staticLayout.draw(canvas);
            this.f6645h.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    private static boolean m7324a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    public void m7325a(C2167b c2167b, boolean z, C2163a c2163a, float f, float f2, Canvas canvas, int i, int i2, int i3, int i4) {
        CharSequence charSequence = c2167b.f6067a;
        if (!TextUtils.isEmpty(charSequence)) {
            if (!z) {
                charSequence = charSequence.toString();
            }
            if (C2305a.m7324a(this.f6647j, charSequence) && C2273r.m7135a(this.f6648k, c2167b.f6068b) && this.f6649l == c2167b.f6069c && this.f6650m == c2167b.f6070d && C2273r.m7135a(Integer.valueOf(this.f6651n), Integer.valueOf(c2167b.f6071e)) && this.f6652o == c2167b.f6072f && C2273r.m7135a(Integer.valueOf(this.f6653p), Integer.valueOf(c2167b.f6073g)) && this.f6654q == c2167b.f6074h && this.f6655r == z && this.f6656s == c2163a.f6055b && this.f6657t == c2163a.f6056c && this.f6658u == c2163a.f6057d && this.f6660w == c2163a.f6058e && this.f6659v == c2163a.f6059f && C2273r.m7135a(this.f6645h.getTypeface(), c2163a.f6060g) && this.f6661x == f && this.f6662y == f2 && this.f6663z == i && this.f6631A == i2 && this.f6632B == i3 && this.f6633C == i4) {
                m7323a(canvas);
                return;
            }
            this.f6647j = charSequence;
            this.f6648k = c2167b.f6068b;
            this.f6649l = c2167b.f6069c;
            this.f6650m = c2167b.f6070d;
            this.f6651n = c2167b.f6071e;
            this.f6652o = c2167b.f6072f;
            this.f6653p = c2167b.f6073g;
            this.f6654q = c2167b.f6074h;
            this.f6655r = z;
            this.f6656s = c2163a.f6055b;
            this.f6657t = c2163a.f6056c;
            this.f6658u = c2163a.f6057d;
            this.f6660w = c2163a.f6058e;
            this.f6659v = c2163a.f6059f;
            this.f6645h.setTypeface(c2163a.f6060g);
            this.f6661x = f;
            this.f6662y = f2;
            this.f6663z = i;
            this.f6631A = i2;
            this.f6632B = i3;
            this.f6633C = i4;
            int i5 = this.f6632B - this.f6663z;
            int i6 = this.f6633C - this.f6631A;
            this.f6645h.setTextSize(f);
            int i7 = (int) ((0.125f * f) + 0.5f);
            int i8 = i5 - (i7 * 2);
            if (this.f6654q != Float.MIN_VALUE) {
                i8 = (int) (((float) i8) * this.f6654q);
            }
            if (i8 <= 0) {
                Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
                return;
            }
            Alignment alignment = this.f6648k == null ? Alignment.ALIGN_CENTER : this.f6648k;
            this.f6634D = new StaticLayout(charSequence, this.f6645h, i8, alignment, this.f6643f, this.f6644g, true);
            int height = this.f6634D.getHeight();
            int lineCount = this.f6634D.getLineCount();
            int i9 = 0;
            int i10 = 0;
            while (i10 < lineCount) {
                int max = Math.max((int) Math.ceil((double) this.f6634D.getLineWidth(i10)), i9);
                i10++;
                i9 = max;
            }
            if (this.f6654q == Float.MIN_VALUE || i9 >= i8) {
                i8 = i9;
            }
            i8 += i7 * 2;
            if (this.f6652o != Float.MIN_VALUE) {
                i9 = Math.round(((float) i5) * this.f6652o) + this.f6663z;
                if (this.f6653p == 2) {
                    i9 -= i8;
                } else if (this.f6653p == 1) {
                    i9 = ((i9 * 2) - i8) / 2;
                }
                i10 = Math.max(i9, this.f6663z);
                i9 = Math.min(i10 + i8, this.f6632B);
                i5 = i10;
            } else {
                i10 = (i5 - i8) / 2;
                i9 = i10 + i8;
                i5 = i10;
            }
            if (this.f6649l != Float.MIN_VALUE) {
                if (this.f6650m == 0) {
                    i10 = Math.round(((float) i6) * this.f6649l) + this.f6631A;
                } else {
                    i10 = this.f6634D.getLineBottom(0) - this.f6634D.getLineTop(0);
                    i10 = this.f6649l >= 0.0f ? Math.round(((float) i10) * this.f6649l) + this.f6631A : Math.round(((float) i10) * this.f6649l) + this.f6633C;
                }
                if (this.f6651n == 2) {
                    i10 -= height;
                } else if (this.f6651n == 1) {
                    i10 = ((i10 * 2) - height) / 2;
                }
                if (i10 + height > this.f6633C) {
                    i10 = this.f6633C - height;
                } else if (i10 < this.f6631A) {
                    i10 = this.f6631A;
                }
                i6 = i10;
            } else {
                i6 = (this.f6633C - height) - ((int) (((float) i6) * f2));
            }
            this.f6634D = new StaticLayout(charSequence, this.f6645h, i9 - i5, alignment, this.f6643f, this.f6644g, true);
            this.f6635E = i5;
            this.f6636F = i6;
            this.f6637G = i7;
            m7323a(canvas);
        }
    }
}
