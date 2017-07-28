package com.domobile.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.domobile.applock.R;
import com.domobile.frame.p000a.C1148d;
import com.domobile.libs_ads.C1348d;

public class GuideStepLineView extends View {
    private Paint f3052a = new Paint(1);
    private float f3053b = 0.0f;
    private Callback f3054c;

    class C14001 extends AnimatorListenerAdapter {
        final /* synthetic */ GuideStepLineView f3051a;

        C14001(GuideStepLineView guideStepLineView) {
            this.f3051a = guideStepLineView;
        }

        public void onAnimationEnd(Animator animator) {
            this.f3051a.m3532a();
        }
    }

    public GuideStepLineView(Context context) {
        super(context);
    }

    public GuideStepLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuideStepLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public GuideStepLineView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void m3532a() {
        if (this.f3054c != null) {
            Message message = new Message();
            message.obj = this;
            message.what = (int) this.f3053b;
            this.f3054c.handleMessage(message);
        }
    }

    public void m3533a(boolean z, Callback callback) {
        this.f3054c = callback;
        setSelected(z);
    }

    public float getLinePercent() {
        return this.f3053b;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f3052a.setStyle(Style.STROKE);
        this.f3052a.setStrokeWidth((float) (getHeight() * 2));
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo((float) getWidth(), (float) getHeight());
        this.f3052a.setColor(getResources().getColor(R.color.guide_step_text_off));
        int a = C1148d.m2498a(getContext(), 5.0f);
        this.f3052a.setPathEffect(new DashPathEffect(new float[]{(float) a, (float) a}, 1.0f));
        canvas.drawPath(path, this.f3052a);
        if (this.f3053b > 0.0f) {
            this.f3052a.setPathEffect(null);
            path.reset();
            path.moveTo(0.0f, 0.0f);
            path.lineTo(((float) getWidth()) * this.f3053b, (float) getHeight());
            canvas.drawPath(path, this.f3052a);
        }
    }

    public void setCallback(Callback callback) {
        this.f3054c = callback;
    }

    public void setLinePercent(float f) {
        this.f3053b = f;
        invalidate();
    }

    public void setSelected(boolean z) {
        if (isSelected() != z) {
            if (C1348d.O >= 11) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "linePercent", z ? new float[]{this.f3053b, 1.0f} : new float[]{this.f3053b, 0.0f});
                ofFloat.addListener(new C14001(this));
                ofFloat.setDuration(300).start();
            } else {
                setLinePercent(z ? 1.0f : 0.0f);
                m3532a();
            }
        }
        super.setSelected(z);
    }
}
