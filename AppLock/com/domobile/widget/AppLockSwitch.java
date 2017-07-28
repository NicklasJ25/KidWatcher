package com.domobile.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.ViewUtils;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.CompoundButton;
import com.domobile.applock.C1140x.C1139g;
import com.domobile.applock.R;
import com.domobile.frame.p000a.C1148d;

public class AppLockSwitch extends CompoundButton {
    private static final int[] f3018v = new int[]{16842912};
    private int f3019a;
    private int f3020b;
    private int f3021c;
    private boolean f3022d;
    private CharSequence f3023e;
    private CharSequence f3024f;
    private int f3025g;
    private int f3026h;
    private float f3027i;
    private float f3028j;
    private VelocityTracker f3029k;
    private int f3030l;
    private float f3031m;
    private int f3032n;
    private int f3033o;
    private int f3034p;
    private int f3035q;
    private int f3036r;
    private int f3037s;
    private Animation f3038t;
    private final Rect f3039u;
    private boolean f3040w;
    private Drawable f3041x;
    private Drawable f3042y;

    public AppLockSwitch(Context context) {
        this(context, null);
    }

    public AppLockSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchStyle);
    }

    public AppLockSwitch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3029k = VelocityTracker.obtain();
        this.f3039u = new Rect();
        this.f3040w = false;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C1139g.SwitchCompat, i, 0);
        this.f3023e = obtainStyledAttributes.getText(0);
        this.f3024f = obtainStyledAttributes.getText(1);
        this.f3019a = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.f3020b = obtainStyledAttributes.getDimensionPixelSize(10, 0);
        this.f3021c = obtainStyledAttributes.getDimensionPixelSize(11, 0);
        this.f3022d = obtainStyledAttributes.getBoolean(12, false);
        Resources resources = context.getResources();
        int parseColor = Color.parseColor("#b2b2b2");
        this.f3042y = C1148d.m2502a(resources, (int) R.drawable.toolbar_unlock).mutate();
        this.f3042y.setColorFilter(parseColor, Mode.SRC_ATOP);
        parseColor = resources.getColor(R.color.accent_material_light);
        this.f3041x = C1148d.m2502a(resources, (int) R.drawable.toolbar_lock).mutate();
        this.f3041x.setColorFilter(parseColor, Mode.SRC_ATOP);
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3026h = viewConfiguration.getScaledTouchSlop();
        this.f3030l = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private static float m3520a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    private void m3521a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void m3523a(boolean z) {
        final float f = this.f3031m;
        final float f2 = z ? 1.0f : 0.0f;
        final float f3 = f2 - f;
        this.f3038t = new Animation(this) {
            final /* synthetic */ AppLockSwitch f3017d;

            protected void applyTransformation(float f, Transformation transformation) {
                float f2 = f + (f3 * f);
                this.f3017d.setThumbPosition(f2);
                if (f2 == f2) {
                    this.f3017d.f3040w = false;
                }
            }
        };
        this.f3038t.setDuration(400);
        startAnimation(this.f3038t);
    }

    private boolean m3524a(float f, float f2) {
        int thumbOffset = (getThumbOffset() + this.f3035q) - this.f3026h;
        return f > ((float) thumbOffset) && f < ((float) ((((this.f3034p + thumbOffset) + this.f3039u.left) + this.f3039u.right) + this.f3026h)) && f2 > ((float) (this.f3036r - this.f3026h)) && f2 < ((float) (this.f3037s + this.f3026h));
    }

    private void m3526b() {
        if (this.f3038t != null) {
            clearAnimation();
            this.f3038t = null;
        }
    }

    private void m3527b(MotionEvent motionEvent) {
        boolean z = false;
        this.f3025g = 0;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        if (z2) {
            this.f3029k.computeCurrentVelocity(1000);
            float xVelocity = this.f3029k.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.f3030l)) {
                z = getTargetCheckedState();
            } else if (xVelocity < 0.0f) {
                z = true;
            }
        } else {
            z = isChecked();
        }
        this.f3040w = true;
        setChecked(z);
        m3521a(motionEvent);
    }

    private boolean getTargetCheckedState() {
        return this.f3031m > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((ViewUtils.isLayoutRtl(this) ? 1.0f - this.f3031m : this.f3031m) * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        return 0;
    }

    private void setThumbPosition(float f) {
        this.f3031m = f;
        invalidate();
    }

    public boolean m3528a() {
        return this.f3040w;
    }

    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.f3041x != null) {
            DrawableCompat.setHotspot(this.f3041x, f, f2);
        }
        if (this.f3042y != null) {
            DrawableCompat.setHotspot(this.f3042y, f, f2);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getCompoundPaddingLeft() {
        if (!ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f3032n;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f3021c : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f3032n;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f3021c : compoundPaddingRight;
    }

    public boolean getSplitTrack() {
        return this.f3022d;
    }

    public int getSwitchMinWidth() {
        return this.f3020b;
    }

    public int getSwitchPadding() {
        return this.f3021c;
    }

    public CharSequence getTextOff() {
        return this.f3024f;
    }

    public CharSequence getTextOn() {
        return this.f3023e;
    }

    public int getThumbTextPadding() {
        return this.f3019a;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f3041x != null) {
                this.f3041x.jumpToCurrentState();
            }
            if (this.f3042y != null) {
                this.f3042y.jumpToCurrentState();
            }
            if (this.f3038t != null && this.f3038t.hasStarted() && !this.f3038t.hasEnded()) {
                clearAnimation();
                this.f3038t = null;
            }
        }
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f3018v);
        }
        return onCreateDrawableState;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int save = canvas.save();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth();
        int height = getHeight();
        canvas.rotate((isChecked() ? this.f3031m : 1.0f - this.f3031m) * 360.0f, (float) (width / 2), (float) (height / 2));
        int i = (int) (((float) (width - (paddingLeft * 2))) * 1.0f);
        paddingLeft = (int) (((float) (height - (paddingTop * 2))) * 1.0f);
        paddingTop = (width - i) / 2;
        width = (height - paddingLeft) / 2;
        this.f3041x.setBounds(paddingTop, width, i + paddingTop, paddingLeft + width);
        this.f3042y.setBounds(this.f3041x.getBounds());
        i = (int) (this.f3031m * 255.0f);
        this.f3041x.setAlpha(i);
        this.f3042y.setAlpha(255 - i);
        this.f3041x.draw(canvas);
        this.f3042y.draw(canvas);
        canvas.restoreToCount(save);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AppLockSwitch.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(AppLockSwitch.class.getName());
            CharSequence charSequence = isChecked() ? this.f3023e : this.f3024f;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                CharSequence stringBuilder = new StringBuilder();
                stringBuilder.append(text).append(' ').append(charSequence);
                accessibilityNodeInfo.setText(stringBuilder);
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int paddingTop;
        super.onLayout(z, i, i2, i3, i4);
        if (ViewUtils.isLayoutRtl(this)) {
            paddingLeft = getPaddingLeft() + 0;
            i5 = ((this.f3032n + paddingLeft) - 0) - 0;
        } else {
            paddingLeft = ((((getWidth() - getPaddingRight()) - 0) - this.f3032n) + 0) + 0;
        }
        switch (getGravity() & 112) {
            case 16:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.f3033o / 2);
                i5 = this.f3033o + paddingTop;
                break;
            case 80:
                i5 = getHeight() - getPaddingBottom();
                paddingTop = i5 - this.f3033o;
                break;
            default:
                paddingTop = getPaddingTop();
                i5 = this.f3033o + paddingTop;
                break;
        }
        this.f3035q = paddingLeft;
        this.f3036r = paddingTop;
        this.f3037s = i5;
    }

    public void onMeasure(int i, int i2) {
        Rect rect = this.f3039u;
        this.f3034p = Math.max(0, 0);
        rect.setEmpty();
        int i3 = rect.left;
        int max = Math.max(this.f3020b, rect.right + (i3 + (this.f3034p * 2)));
        i3 = Math.max(0, 0);
        this.f3032n = max;
        this.f3033o = i3;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < i3) {
            setMeasuredDimension(ViewCompat.getMeasuredWidthAndState(this), i3);
        }
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Object obj = isChecked() ? this.f3023e : this.f3024f;
        if (obj != null) {
            accessibilityEvent.getText().add(obj);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f3029k.addMovement(motionEvent);
        float x;
        float y;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (isEnabled() && m3524a(x, y)) {
                    this.f3025g = 1;
                    this.f3027i = x;
                    this.f3028j = y;
                    break;
                }
            case 1:
            case 3:
                if (this.f3025g != 2) {
                    this.f3025g = 0;
                    this.f3029k.clear();
                    break;
                }
                m3527b(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            case 2:
                switch (this.f3025g) {
                    case 0:
                        break;
                    case 1:
                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        if (Math.abs(x - this.f3027i) > ((float) this.f3026h) || Math.abs(y - this.f3028j) > ((float) this.f3026h)) {
                            this.f3025g = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.f3027i = x;
                            this.f3028j = y;
                            return true;
                        }
                    case 2:
                        float x2 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f = x2 - this.f3027i;
                        x = thumbScrollRange != 0 ? f / ((float) thumbScrollRange) : f > 0.0f ? 1.0f : -1.0f;
                        if (ViewUtils.isLayoutRtl(this)) {
                            x = -x;
                        }
                        x = m3520a(x + this.f3031m, 0.0f, 1.0f);
                        if (x != this.f3031m) {
                            this.f3027i = x2;
                            setThumbPosition(x);
                        }
                        return true;
                    default:
                        break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() == null || !this.f3040w) {
            m3526b();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
            this.f3040w = false;
            return;
        }
        m3523a(isChecked);
    }

    public void setCheckedFromUser(boolean z) {
        this.f3040w = true;
        setChecked(z);
    }

    public void setSplitTrack(boolean z) {
        this.f3022d = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.f3020b = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.f3021c = i;
        requestLayout();
    }

    public void setTextOff(CharSequence charSequence) {
        this.f3024f = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.f3023e = charSequence;
        requestLayout();
    }

    public void setThumbTextPadding(int i) {
        this.f3019a = i;
        requestLayout();
    }

    public void toggle() {
        this.f3040w = true;
        super.toggle();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3041x || drawable == this.f3042y;
    }
}
