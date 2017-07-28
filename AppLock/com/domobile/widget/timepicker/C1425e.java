package com.domobile.widget.timepicker;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import com.domobile.applock.R;
import com.domobile.libs_ads.C1348d;

public class C1425e extends View {
    private float[] f3221A;
    private float f3222B;
    private float f3223C;
    private float f3224D;
    private C1424a f3225E;
    private int f3226F = 1;
    ObjectAnimator f3227a;
    ObjectAnimator f3228b;
    private final Paint f3229c = new Paint();
    private boolean f3230d;
    private boolean f3231e = false;
    private Typeface f3232f;
    private Typeface f3233g;
    private String[] f3234h;
    private String[] f3235i;
    private boolean f3236j;
    private boolean f3237k;
    private float f3238l;
    private float f3239m;
    private float f3240n;
    private float f3241o;
    private float f3242p;
    private float f3243q;
    private int f3244r;
    private int f3245s;
    private float f3246t;
    private boolean f3247u;
    private float f3248v;
    private float f3249w;
    private float[] f3250x;
    private float[] f3251y;
    private float[] f3252z;

    private class C1424a implements AnimatorUpdateListener {
        final /* synthetic */ C1425e f3220a;

        private C1424a(C1425e c1425e) {
            this.f3220a = c1425e;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f3220a.invalidate();
        }
    }

    public C1425e(Context context) {
        super(context);
    }

    private void m3621a() {
        if (C1348d.Q) {
            Keyframe ofFloat = Keyframe.ofFloat(0.0f, 1.0f);
            Keyframe ofFloat2 = Keyframe.ofFloat(0.2f, this.f3223C);
            Keyframe ofFloat3 = Keyframe.ofFloat(1.0f, this.f3224D);
            PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", new Keyframe[]{ofFloat, ofFloat2, ofFloat3});
            ofFloat2 = Keyframe.ofFloat(0.0f, 1.0f);
            ofFloat3 = Keyframe.ofFloat(1.0f, 0.0f);
            PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[]{ofFloat2, ofFloat3});
            this.f3227a = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofKeyframe, ofKeyframe2}).setDuration((long) 500);
            this.f3227a.addUpdateListener(this.f3225E);
            int i = (int) ((1.0f + 0.25f) * ((float) 500));
            float f = (((float) 500) * 0.25f) / ((float) i);
            float f2 = 1.0f - (0.2f * (1.0f - f));
            ofFloat = Keyframe.ofFloat(0.0f, this.f3224D);
            ofFloat3 = Keyframe.ofFloat(f, this.f3224D);
            Keyframe ofFloat4 = Keyframe.ofFloat(f2, this.f3223C);
            Keyframe ofFloat5 = Keyframe.ofFloat(1.0f, 1.0f);
            PropertyValuesHolder ofKeyframe3 = PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", new Keyframe[]{ofFloat, ofFloat3, ofFloat4, ofFloat5});
            ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
            Keyframe ofFloat6 = Keyframe.ofFloat(f, 0.0f);
            ofFloat3 = Keyframe.ofFloat(1.0f, 1.0f);
            PropertyValuesHolder ofKeyframe4 = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[]{ofFloat, ofFloat6, ofFloat3});
            this.f3228b = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofKeyframe3, ofKeyframe4}).setDuration((long) i);
            this.f3228b.addUpdateListener(this.f3225E);
        }
    }

    private void m3622a(float f, float f2, float f3, float f4, float[] fArr, float[] fArr2) {
        float sqrt = (((float) Math.sqrt(3.0d)) * f) / 2.0f;
        float f5 = f / 2.0f;
        this.f3229c.setTextSize(f4);
        float descent = f3 - ((this.f3229c.descent() + this.f3229c.ascent()) / 2.0f);
        fArr[0] = descent - f;
        fArr2[0] = f2 - f;
        fArr[1] = descent - sqrt;
        fArr2[1] = f2 - sqrt;
        fArr[2] = descent - f5;
        fArr2[2] = f2 - f5;
        fArr[3] = descent;
        fArr2[3] = f2;
        fArr[4] = descent + f5;
        fArr2[4] = f5 + f2;
        fArr[5] = descent + sqrt;
        fArr2[5] = sqrt + f2;
        fArr[6] = descent + f;
        fArr2[6] = f2 + f;
    }

    private void m3623a(Canvas canvas, float f, Typeface typeface, String[] strArr, float[] fArr, float[] fArr2) {
        this.f3229c.setTextSize(f);
        this.f3229c.setTypeface(typeface);
        this.f3229c.setAlpha(this.f3226F * 255);
        canvas.drawText(strArr[0], fArr[3], fArr2[0], this.f3229c);
        canvas.drawText(strArr[1], fArr[4], fArr2[1], this.f3229c);
        canvas.drawText(strArr[2], fArr[5], fArr2[2], this.f3229c);
        canvas.drawText(strArr[3], fArr[6], fArr2[3], this.f3229c);
        canvas.drawText(strArr[4], fArr[5], fArr2[4], this.f3229c);
        canvas.drawText(strArr[5], fArr[4], fArr2[5], this.f3229c);
        canvas.drawText(strArr[6], fArr[3], fArr2[6], this.f3229c);
        canvas.drawText(strArr[7], fArr[2], fArr2[5], this.f3229c);
        canvas.drawText(strArr[8], fArr[1], fArr2[4], this.f3229c);
        canvas.drawText(strArr[9], fArr[0], fArr2[3], this.f3229c);
        canvas.drawText(strArr[10], fArr[1], fArr2[2], this.f3229c);
        canvas.drawText(strArr[11], fArr[2], fArr2[1], this.f3229c);
    }

    void m3624a(Context context, boolean z) {
        Resources resources = context.getResources();
        this.f3229c.setColor(z ? resources.getColor(R.color.white) : resources.getColor(R.color.numbers_text_color));
    }

    public void m3625a(Resources resources, String[] strArr, String[] strArr2, boolean z, boolean z2) {
        int i = -1;
        boolean z3 = false;
        if (this.f3231e) {
            Log.e("RadialTextsView", "This RadialTextsView may only be initialized once.");
            return;
        }
        this.f3229c.setColor(resources.getColor(R.color.numbers_text_color));
        this.f3232f = Typeface.create(resources.getString(R.string.radial_numbers_typeface), 0);
        this.f3233g = Typeface.create(resources.getString(R.string.sans_serif), 0);
        this.f3229c.setAntiAlias(true);
        this.f3229c.setTextAlign(Align.CENTER);
        this.f3234h = strArr;
        this.f3235i = strArr2;
        this.f3236j = z;
        if (strArr2 != null) {
            z3 = true;
        }
        this.f3237k = z3;
        if (z) {
            this.f3238l = Float.parseFloat(resources.getString(R.string.circle_radius_multiplier_24HourMode));
        } else {
            this.f3238l = Float.parseFloat(resources.getString(R.string.circle_radius_multiplier));
            this.f3239m = Float.parseFloat(resources.getString(R.string.ampm_circle_radius_multiplier));
        }
        this.f3250x = new float[7];
        this.f3251y = new float[7];
        if (this.f3237k) {
            this.f3240n = Float.parseFloat(resources.getString(R.string.numbers_radius_multiplier_outer));
            this.f3242p = Float.parseFloat(resources.getString(R.string.text_size_multiplier_outer));
            this.f3241o = Float.parseFloat(resources.getString(R.string.numbers_radius_multiplier_inner));
            this.f3243q = Float.parseFloat(resources.getString(R.string.text_size_multiplier_inner));
            this.f3252z = new float[7];
            this.f3221A = new float[7];
        } else {
            this.f3240n = Float.parseFloat(resources.getString(R.string.numbers_radius_multiplier_normal));
            this.f3242p = Float.parseFloat(resources.getString(R.string.text_size_multiplier_normal));
        }
        this.f3222B = 1.0f;
        this.f3223C = (((float) (z2 ? -1 : 1)) * 0.05f) + 1.0f;
        if (z2) {
            i = 1;
        }
        this.f3224D = (0.3f * ((float) i)) + 1.0f;
        if (C1348d.Q) {
            this.f3225E = new C1424a();
        }
        this.f3247u = true;
        this.f3231e = true;
    }

    public ObjectAnimator getDisappearAnimator() {
        if (this.f3231e && this.f3230d && this.f3227a != null) {
            return this.f3227a;
        }
        Log.e("RadialTextsView", "RadialTextView was not ready for animation.");
        return null;
    }

    public ObjectAnimator getReappearAnimator() {
        if (this.f3231e && this.f3230d && this.f3228b != null) {
            return this.f3228b;
        }
        Log.e("RadialTextsView", "RadialTextView was not ready for animation.");
        return null;
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public void onDraw(Canvas canvas) {
        if (getWidth() != 0 && this.f3231e) {
            if (!this.f3230d) {
                this.f3244r = getWidth() / 2;
                this.f3245s = getHeight() / 2;
                this.f3246t = ((float) Math.min(this.f3244r, this.f3245s)) * this.f3238l;
                if (!this.f3236j) {
                    this.f3245s = (int) (((float) this.f3245s) - ((this.f3246t * this.f3239m) / 2.0f));
                }
                this.f3248v = this.f3246t * this.f3242p;
                if (this.f3237k) {
                    this.f3249w = this.f3246t * this.f3243q;
                }
                m3621a();
                this.f3247u = true;
                this.f3230d = true;
            }
            if (this.f3247u) {
                m3622a(this.f3222B * (this.f3246t * this.f3240n), (float) this.f3244r, (float) this.f3245s, this.f3248v, this.f3250x, this.f3251y);
                if (this.f3237k) {
                    m3622a(this.f3222B * (this.f3246t * this.f3241o), (float) this.f3244r, (float) this.f3245s, this.f3249w, this.f3252z, this.f3221A);
                }
                this.f3247u = false;
            }
            m3623a(canvas, this.f3248v, this.f3232f, this.f3234h, this.f3251y, this.f3250x);
            if (this.f3237k) {
                m3623a(canvas, this.f3249w, this.f3233g, this.f3235i, this.f3221A, this.f3252z);
            }
        }
    }

    public void setAnimationRadiusMultiplier(float f) {
        this.f3222B = f;
        this.f3247u = true;
    }

    public void setViewAlpha(int i) {
        this.f3226F = i;
        invalidate();
    }
}
