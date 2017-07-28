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
import android.util.Log;
import android.view.View;
import com.android.gallery3d.data.MediaSet;
import com.domobile.applock.R;
import com.domobile.libs_ads.C1348d;

public class C1422d extends View {
    private final Paint f3195a = new Paint();
    private boolean f3196b = false;
    private boolean f3197c;
    private float f3198d;
    private float f3199e;
    private float f3200f;
    private float f3201g;
    private float f3202h;
    private float f3203i;
    private float f3204j;
    private boolean f3205k;
    private boolean f3206l;
    private int f3207m;
    private int f3208n;
    private int f3209o;
    private int f3210p;
    private float f3211q;
    private float f3212r;
    private int f3213s;
    private int f3214t;
    private C1421a f3215u;
    private int f3216v;
    private double f3217w;
    private boolean f3218x;
    private int f3219y = 1;

    private class C1421a implements AnimatorUpdateListener {
        final /* synthetic */ C1422d f3194a;

        private C1421a(C1422d c1422d) {
            this.f3194a = c1422d;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f3194a.invalidate();
        }
    }

    public C1422d(Context context) {
        super(context);
    }

    public int m3617a(float f, float f2, boolean z, Boolean[] boolArr) {
        boolean z2 = true;
        if (!this.f3197c) {
            return -1;
        }
        double sqrt = Math.sqrt((double) (((f2 - ((float) this.f3209o)) * (f2 - ((float) this.f3209o))) + ((f - ((float) this.f3208n)) * (f - ((float) this.f3208n)))));
        if (this.f3206l) {
            if (z) {
                boolArr[0] = Boolean.valueOf(((int) Math.abs(sqrt - ((double) ((int) (((float) this.f3210p) * this.f3200f))))) <= ((int) Math.abs(sqrt - ((double) ((int) (((float) this.f3210p) * this.f3201g))))));
            } else {
                int i = ((int) (((float) this.f3210p) * this.f3201g)) + this.f3214t;
                int i2 = (int) (((float) this.f3210p) * ((this.f3201g + this.f3200f) / 2.0f));
                if (sqrt >= ((double) (((int) (((float) this.f3210p) * this.f3200f)) - this.f3214t)) && sqrt <= ((double) i2)) {
                    boolArr[0] = Boolean.valueOf(true);
                } else if (sqrt > ((double) i) || sqrt < ((double) i2)) {
                    return -1;
                } else {
                    boolArr[0] = Boolean.valueOf(false);
                }
            }
        } else if (!z && ((int) Math.abs(sqrt - ((double) this.f3213s))) > ((int) (((float) this.f3210p) * (1.0f - this.f3202h)))) {
            return -1;
        }
        int asin = (int) ((Math.asin(((double) Math.abs(f2 - ((float) this.f3209o))) / sqrt) * 180.0d) / 3.141592653589793d);
        boolean z3 = f > ((float) this.f3208n);
        if (f2 >= ((float) this.f3209o)) {
            z2 = false;
        }
        return (z3 && z2) ? 90 - asin : (!z3 || z2) ? (z3 || z2) ? (z3 || !z2) ? asin : asin + 270 : 270 - asin : asin + 90;
    }

    public void m3618a(int i, boolean z, boolean z2) {
        this.f3216v = i;
        this.f3217w = (((double) i) * 3.141592653589793d) / 180.0d;
        this.f3218x = z2;
        if (!this.f3206l) {
            return;
        }
        if (z) {
            this.f3202h = this.f3200f;
        } else {
            this.f3202h = this.f3201g;
        }
    }

    void m3619a(Context context, boolean z) {
        int color;
        Resources resources = context.getResources();
        if (z) {
            color = resources.getColor(R.color.red);
            this.f3207m = 102;
        } else {
            color = resources.getColor(R.color.blue);
            this.f3207m = 51;
        }
        this.f3195a.setColor(color);
    }

    public void m3620a(Context context, boolean z, boolean z2, boolean z3, int i, boolean z4) {
        int i2 = -1;
        if (this.f3196b) {
            Log.e("RadialSelectorView", "This RadialSelectorView may only be initialized once.");
            return;
        }
        Resources resources = context.getResources();
        this.f3195a.setColor(resources.getColor(R.color.blue));
        this.f3195a.setAntiAlias(true);
        this.f3207m = 51;
        this.f3205k = z;
        if (z) {
            this.f3198d = Float.parseFloat(resources.getString(R.string.circle_radius_multiplier_24HourMode));
        } else {
            this.f3198d = Float.parseFloat(resources.getString(R.string.circle_radius_multiplier));
            this.f3199e = Float.parseFloat(resources.getString(R.string.ampm_circle_radius_multiplier));
        }
        this.f3206l = z2;
        if (z2) {
            this.f3200f = Float.parseFloat(resources.getString(R.string.numbers_radius_multiplier_inner));
            this.f3201g = Float.parseFloat(resources.getString(R.string.numbers_radius_multiplier_outer));
        } else {
            this.f3202h = Float.parseFloat(resources.getString(R.string.numbers_radius_multiplier_normal));
        }
        this.f3203i = Float.parseFloat(resources.getString(R.string.selection_radius_multiplier));
        this.f3204j = 1.0f;
        this.f3211q = (((float) (z3 ? -1 : 1)) * 0.05f) + 1.0f;
        if (z3) {
            i2 = 1;
        }
        this.f3212r = (0.3f * ((float) i2)) + 1.0f;
        if (C1348d.Q) {
            this.f3215u = new C1421a();
        }
        m3618a(i, z4, false);
        this.f3196b = true;
    }

    public ObjectAnimator getDisappearAnimator() {
        if (this.f3196b && this.f3197c && C1348d.Q) {
            Keyframe ofFloat = Keyframe.ofFloat(0.0f, 1.0f);
            Keyframe ofFloat2 = Keyframe.ofFloat(0.2f, this.f3211q);
            Keyframe ofFloat3 = Keyframe.ofFloat(1.0f, this.f3212r);
            PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", new Keyframe[]{ofFloat, ofFloat2, ofFloat3});
            ofFloat = Keyframe.ofFloat(0.0f, 1.0f);
            ofFloat3 = Keyframe.ofFloat(1.0f, 0.0f);
            PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[]{ofFloat, ofFloat3});
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofKeyframe, ofKeyframe2}).setDuration((long) MediaSet.MEDIAITEM_BATCH_FETCH_COUNT);
            duration.addUpdateListener(this.f3215u);
            return duration;
        }
        Log.e("RadialSelectorView", "RadialSelectorView was not ready for animation.");
        return null;
    }

    public ObjectAnimator getReappearAnimator() {
        if (this.f3196b && this.f3197c && C1348d.Q) {
            int i = (int) ((1.0f + 0.25f) * ((float) 500));
            float f = (((float) 500) * 0.25f) / ((float) i);
            float f2 = 1.0f - (0.2f * (1.0f - f));
            Keyframe ofFloat = Keyframe.ofFloat(0.0f, this.f3212r);
            Keyframe ofFloat2 = Keyframe.ofFloat(f, this.f3212r);
            Keyframe ofFloat3 = Keyframe.ofFloat(f2, this.f3211q);
            Keyframe ofFloat4 = Keyframe.ofFloat(1.0f, 1.0f);
            PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", new Keyframe[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
            ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
            Keyframe ofFloat5 = Keyframe.ofFloat(f, 0.0f);
            ofFloat2 = Keyframe.ofFloat(1.0f, 1.0f);
            PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[]{ofFloat, ofFloat5, ofFloat2});
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{ofKeyframe, ofKeyframe2}).setDuration((long) i);
            duration.addUpdateListener(this.f3215u);
            return duration;
        }
        Log.e("RadialSelectorView", "RadialSelectorView was not ready for animation.");
        return null;
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public void onDraw(Canvas canvas) {
        int i = 1;
        if (getWidth() != 0 && this.f3196b) {
            int i2;
            if (!this.f3197c) {
                this.f3208n = getWidth() / 2;
                this.f3209o = getHeight() / 2;
                this.f3210p = (int) (((float) Math.min(this.f3208n, this.f3209o)) * this.f3198d);
                if (!this.f3205k) {
                    this.f3209o -= ((int) (((float) this.f3210p) * this.f3199e)) / 2;
                }
                this.f3214t = (int) (((float) this.f3210p) * this.f3203i);
                this.f3197c = true;
            }
            this.f3213s = (int) ((((float) this.f3210p) * this.f3202h) * this.f3204j);
            int sin = ((int) (((double) this.f3213s) * Math.sin(this.f3217w))) + this.f3208n;
            int cos = this.f3209o - ((int) (((double) this.f3213s) * Math.cos(this.f3217w)));
            this.f3195a.setAlpha(this.f3207m * this.f3219y);
            canvas.drawCircle((float) sin, (float) cos, (float) this.f3214t, this.f3195a);
            boolean z = this.f3218x;
            if (this.f3216v % 30 == 0) {
                i = 0;
            }
            if ((i | z) != 0) {
                this.f3195a.setAlpha(this.f3219y * 255);
                canvas.drawCircle((float) sin, (float) cos, (float) ((this.f3214t * 2) / 7), this.f3195a);
                i2 = sin;
            } else {
                cos = this.f3213s - this.f3214t;
                sin = this.f3208n + ((int) (((double) cos) * Math.sin(this.f3217w)));
                cos = this.f3209o - ((int) (((double) cos) * Math.cos(this.f3217w)));
                i2 = sin;
            }
            this.f3195a.setAlpha(this.f3219y * 255);
            this.f3195a.setStrokeWidth(1.0f);
            canvas.drawLine((float) this.f3208n, (float) this.f3209o, (float) i2, (float) cos, this.f3195a);
        }
    }

    public void setAnimationRadiusMultiplier(float f) {
        this.f3204j = f;
    }

    public void setViewAlpha(int i) {
        this.f3219y = i;
        invalidate();
    }
}
