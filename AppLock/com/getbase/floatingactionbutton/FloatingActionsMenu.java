package com.getbase.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import com.domobile.p015b.C1168b.C1162f;

public class FloatingActionsMenu extends ViewGroup {
    private static Interpolator f4871s = new OvershootInterpolator();
    private static Interpolator f4872t = new DecelerateInterpolator(3.0f);
    private static Interpolator f4873u = new DecelerateInterpolator();
    private int f4874a;
    private int f4875b;
    private int f4876c;
    private boolean f4877d;
    private int f4878e;
    private int f4879f;
    private int f4880g;
    private int f4881h;
    private boolean f4882i;
    private AnimatorSet f4883j;
    private AnimatorSet f4884k;
    private C1910a f4885l;
    private C1915c f4886m;
    private int f4887n;
    private int f4888o;
    private int f4889p;
    private int f4890q;
    private C1914b f4891r;

    class C19111 extends C1910a {
        final /* synthetic */ FloatingActionsMenu f4862g;

        void mo2849a() {
            this.a = this.f4862g.f4874a;
            this.b = this.f4862g.f4875b;
            this.c = this.f4862g.f4876c;
            this.f = this.f4862g.f4877d;
            super.mo2849a();
        }

        Drawable getIconDrawable() {
            Drawable c1915c = new C1915c(super.getIconDrawable());
            this.f4862g.f4886m = c1915c;
            TimeInterpolator overshootInterpolator = new OvershootInterpolator();
            Animator ofFloat = ObjectAnimator.ofFloat(c1915c, "rotation", new float[]{135.0f, 0.0f});
            Animator ofFloat2 = ObjectAnimator.ofFloat(c1915c, "rotation", new float[]{0.0f, 135.0f});
            ofFloat.setInterpolator(overshootInterpolator);
            ofFloat2.setInterpolator(overshootInterpolator);
            this.f4862g.f4883j.play(ofFloat2);
            this.f4862g.f4884k.play(ofFloat);
            return c1915c;
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C19121();
        public boolean f4863a;

        static class C19121 implements Creator<SavedState> {
            C19121() {
            }

            public SavedState m5450a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m5451a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m5450a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m5451a(i);
            }
        }

        private SavedState(Parcel parcel) {
            boolean z = true;
            super(parcel);
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f4863a = z;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4863a ? 1 : 0);
        }
    }

    private class C1913a extends LayoutParams {
        final /* synthetic */ FloatingActionsMenu f4864a;
        private ObjectAnimator f4865b = new ObjectAnimator();
        private ObjectAnimator f4866c = new ObjectAnimator();
        private ObjectAnimator f4867d = new ObjectAnimator();
        private ObjectAnimator f4868e = new ObjectAnimator();
        private boolean f4869f;

        public C1913a(FloatingActionsMenu floatingActionsMenu, LayoutParams layoutParams) {
            this.f4864a = floatingActionsMenu;
            super(layoutParams);
            this.f4865b.setInterpolator(FloatingActionsMenu.f4871s);
            this.f4866c.setInterpolator(FloatingActionsMenu.f4873u);
            this.f4867d.setInterpolator(FloatingActionsMenu.f4872t);
            this.f4868e.setInterpolator(FloatingActionsMenu.f4872t);
            this.f4868e.setProperty(View.ALPHA);
            this.f4868e.setFloatValues(new float[]{1.0f, 0.0f});
            this.f4866c.setProperty(View.ALPHA);
            this.f4866c.setFloatValues(new float[]{0.0f, 1.0f});
            switch (floatingActionsMenu.f4878e) {
                case 0:
                case 1:
                    this.f4867d.setProperty(View.TRANSLATION_Y);
                    this.f4865b.setProperty(View.TRANSLATION_Y);
                    return;
                case 2:
                case 3:
                    this.f4867d.setProperty(View.TRANSLATION_X);
                    this.f4865b.setProperty(View.TRANSLATION_X);
                    return;
                default:
                    return;
            }
        }

        public void m5454a(View view) {
            this.f4868e.setTarget(view);
            this.f4867d.setTarget(view);
            this.f4866c.setTarget(view);
            this.f4865b.setTarget(view);
            if (!this.f4869f) {
                this.f4864a.f4884k.play(this.f4868e);
                this.f4864a.f4884k.play(this.f4867d);
                this.f4864a.f4883j.play(this.f4866c);
                this.f4864a.f4883j.play(this.f4865b);
                this.f4869f = true;
            }
        }
    }

    public interface C1914b {
    }

    private static class C1915c extends LayerDrawable {
        private float f4870a;

        public C1915c(Drawable drawable) {
            super(new Drawable[]{drawable});
        }

        public void m5455a(float f) {
            this.f4870a = f;
            invalidateSelf();
        }

        public void draw(Canvas canvas) {
            canvas.save();
            canvas.rotate(this.f4870a, (float) getBounds().centerX(), (float) getBounds().centerY());
            super.draw(canvas);
            canvas.restore();
        }
    }

    private int m5456a(int i) {
        return (i * 12) / 10;
    }

    private boolean m5464d() {
        return this.f4878e == 2 || this.f4878e == 3;
    }

    private void m5467e() {
        Context contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f4889p);
        for (int i = 0; i < this.f4890q; i++) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) getChildAt(i);
            String title = floatingActionButton.getTitle();
            if (!(floatingActionButton == this.f4885l || title == null || floatingActionButton.getTag(C1162f.fab_label) != null)) {
                View textView = new TextView(contextThemeWrapper);
                textView.setText(floatingActionButton.getTitle());
                addView(textView);
                floatingActionButton.setTag(C1162f.fab_label, textView);
            }
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C1913a(this, super.generateDefaultLayoutParams());
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C1913a(this, super.generateLayoutParams(attributeSet));
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C1913a(this, super.generateLayoutParams(layoutParams));
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        bringChildToFront(this.f4885l);
        this.f4890q = getChildCount();
        if (this.f4889p != 0) {
            m5467e();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredHeight;
        int measuredHeight2;
        int measuredWidth;
        C1913a c1913a;
        switch (this.f4878e) {
            case 0:
            case 1:
                Object obj = this.f4878e == 0 ? 1 : null;
                measuredHeight = obj != null ? (i4 - i2) - this.f4885l.getMeasuredHeight() : 0;
                int measuredWidth2 = ((i3 - i) - this.f4887n) + ((this.f4887n - this.f4885l.getMeasuredWidth()) / 2);
                this.f4885l.layout(measuredWidth2, measuredHeight, this.f4885l.getMeasuredWidth() + measuredWidth2, this.f4885l.getMeasuredHeight() + measuredHeight);
                int i5 = ((i3 - i) - this.f4887n) - this.f4880g;
                measuredHeight2 = obj != null ? measuredHeight - this.f4879f : (this.f4885l.getMeasuredHeight() + measuredHeight) + this.f4879f;
                for (int i6 = this.f4890q - 1; i6 >= 0; i6--) {
                    View childAt = getChildAt(i6);
                    if (!(childAt == this.f4885l || childAt.getVisibility() == 8)) {
                        measuredWidth = ((this.f4885l.getMeasuredWidth() - childAt.getMeasuredWidth()) / 2) + measuredWidth2;
                        int measuredHeight3 = obj != null ? measuredHeight2 - childAt.getMeasuredHeight() : measuredHeight2;
                        childAt.layout(measuredWidth, measuredHeight3, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + measuredHeight3);
                        float f = (float) (measuredHeight - measuredHeight3);
                        childAt.setTranslationY(this.f4882i ? 0.0f : f);
                        childAt.setAlpha(this.f4882i ? 1.0f : 0.0f);
                        c1913a = (C1913a) childAt.getLayoutParams();
                        c1913a.f4867d.setFloatValues(new float[]{0.0f, f});
                        c1913a.f4865b.setFloatValues(new float[]{f, 0.0f});
                        c1913a.m5454a(childAt);
                        View view = (View) childAt.getTag(C1162f.fab_label);
                        if (view != null) {
                            int measuredHeight4 = (measuredHeight3 - this.f4881h) + ((childAt.getMeasuredHeight() - view.getMeasuredHeight()) / 2);
                            view.layout(i5 - view.getMeasuredWidth(), measuredHeight4, i5, view.getMeasuredHeight() + measuredHeight4);
                            view.setTranslationY(this.f4882i ? 0.0f : f);
                            view.setAlpha(this.f4882i ? 1.0f : 0.0f);
                            C1913a c1913a2 = (C1913a) view.getLayoutParams();
                            c1913a2.f4867d.setFloatValues(new float[]{0.0f, f});
                            c1913a2.f4865b.setFloatValues(new float[]{f, 0.0f});
                            c1913a2.m5454a(view);
                        }
                        measuredHeight2 = obj != null ? measuredHeight3 - this.f4879f : (childAt.getMeasuredHeight() + measuredHeight3) + this.f4879f;
                    }
                }
                return;
            case 2:
            case 3:
                Object obj2 = this.f4878e == 2 ? 1 : null;
                measuredWidth = obj2 != null ? (i3 - i) - this.f4885l.getMeasuredWidth() : 0;
                int measuredHeight5 = ((i4 - i2) - this.f4888o) + ((this.f4888o - this.f4885l.getMeasuredHeight()) / 2);
                this.f4885l.layout(measuredWidth, measuredHeight5, this.f4885l.getMeasuredWidth() + measuredWidth, this.f4885l.getMeasuredHeight() + measuredHeight5);
                measuredHeight2 = obj2 != null ? measuredWidth - this.f4879f : (this.f4885l.getMeasuredWidth() + measuredWidth) + this.f4879f;
                for (int i7 = this.f4890q - 1; i7 >= 0; i7--) {
                    View childAt2 = getChildAt(i7);
                    if (!(childAt2 == this.f4885l || childAt2.getVisibility() == 8)) {
                        measuredHeight = obj2 != null ? measuredHeight2 - childAt2.getMeasuredWidth() : measuredHeight2;
                        measuredHeight2 = ((this.f4885l.getMeasuredHeight() - childAt2.getMeasuredHeight()) / 2) + measuredHeight5;
                        childAt2.layout(measuredHeight, measuredHeight2, childAt2.getMeasuredWidth() + measuredHeight, childAt2.getMeasuredHeight() + measuredHeight2);
                        childAt2.setTranslationX(this.f4882i ? 0.0f : (float) (measuredWidth - measuredHeight));
                        childAt2.setAlpha(this.f4882i ? 1.0f : 0.0f);
                        c1913a = (C1913a) childAt2.getLayoutParams();
                        c1913a.f4867d.setFloatValues(new float[]{0.0f, r4});
                        c1913a.f4865b.setFloatValues(new float[]{r4, 0.0f});
                        c1913a.m5454a(childAt2);
                        measuredHeight2 = obj2 != null ? measuredHeight - this.f4879f : (childAt2.getMeasuredWidth() + measuredHeight) + this.f4879f;
                    }
                }
                return;
            default:
                return;
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        measureChildren(i, i2);
        this.f4887n = 0;
        this.f4888o = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < this.f4890q) {
            int i8;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 8) {
                i8 = i7;
                i7 = i6;
            } else {
                switch (this.f4878e) {
                    case 0:
                    case 1:
                        this.f4887n = Math.max(this.f4887n, childAt.getMeasuredWidth());
                        i8 = i7;
                        i7 = i6 + childAt.getMeasuredHeight();
                        break;
                    case 2:
                    case 3:
                        i7 += childAt.getMeasuredWidth();
                        this.f4888o = Math.max(this.f4888o, childAt.getMeasuredHeight());
                        break;
                }
                i8 = i7;
                i7 = i6;
                if (!m5464d()) {
                    TextView textView = (TextView) childAt.getTag(C1162f.fab_label);
                    if (textView != null) {
                        i5 = Math.max(i5, textView.getMeasuredWidth());
                    }
                }
            }
            i4++;
            i6 = i7;
            i7 = i8;
        }
        if (m5464d()) {
            i6 = this.f4888o;
        } else {
            i4 = this.f4887n;
            if (i5 > 0) {
                i3 = this.f4880g + i5;
            }
            i7 = i4 + i3;
        }
        switch (this.f4878e) {
            case 0:
            case 1:
                i6 = m5456a(i6 + (this.f4879f * (getChildCount() - 1)));
                break;
            case 2:
            case 3:
                i7 = m5456a((this.f4879f * (getChildCount() - 1)) + i7);
                break;
        }
        setMeasuredDimension(i7, i6);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f4882i = savedState.f4863a;
            if (this.f4886m != null) {
                this.f4886m.m5455a(this.f4882i ? 135.0f : 0.0f);
            }
            super.onRestoreInstanceState(savedState.getSuperState());
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4863a = this.f4882i;
        return savedState;
    }

    public void setOnFloatingActionsMenuUpdateListener(C1914b c1914b) {
        this.f4891r = c1914b;
    }
}
