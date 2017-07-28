package com.getbase.floatingactionbutton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.TextView;
import com.domobile.p015b.C1168b.C1159c;
import com.domobile.p015b.C1168b.C1160d;
import com.domobile.p015b.C1168b.C1161e;
import com.domobile.p015b.C1168b.C1162f;
import com.domobile.p015b.C1168b.C1167k;

public class FloatingActionButton extends ImageButton {
    @DrawableRes
    private int f4849a;
    int f4850b;
    int f4851c;
    int f4852d;
    String f4853e;
    boolean f4854f;
    private Drawable f4855g;
    private int f4856h;
    private float f4857i;
    private float f4858j;
    private float f4859k;
    private int f4860l;

    private static class C1909a extends LayerDrawable {
        private final int f4848a;

        public C1909a(int i, Drawable... drawableArr) {
            super(drawableArr);
            this.f4848a = i;
        }

        public void draw(Canvas canvas) {
            Rect bounds = getBounds();
            canvas.saveLayerAlpha((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.f4848a, 31);
            super.draw(canvas);
            canvas.restore();
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo2846a(context, attributeSet);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo2846a(context, attributeSet);
    }

    private Drawable m5432a(int i, float f) {
        int alpha = Color.alpha(i);
        int f2 = m5443f(i);
        Paint paint = new ShapeDrawable(new OvalShape()).getPaint();
        paint.setAntiAlias(true);
        paint.setColor(f2);
        Drawable[] drawableArr = new Drawable[]{r3, m5439c(f2, f)};
        Drawable layerDrawable = (alpha == 255 || !this.f4854f) ? new LayerDrawable(drawableArr) : new C1909a(alpha, drawableArr);
        alpha = (int) (f / 2.0f);
        layerDrawable.setLayerInset(1, alpha, alpha, alpha, alpha);
        return layerDrawable;
    }

    private StateListDrawable m5433a(float f) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, m5432a(this.f4852d, f));
        stateListDrawable.addState(new int[]{16842919}, m5432a(this.f4851c, f));
        stateListDrawable.addState(new int[0], m5432a(this.f4850b, f));
        return stateListDrawable;
    }

    private int m5434b(int i, float f) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[2] = Math.min(fArr[2] * f, 1.0f);
        return Color.HSVToColor(Color.alpha(i), fArr);
    }

    private Drawable m5435b(float f) {
        Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(f);
        paint.setStyle(Style.STROKE);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setAlpha(m5437c(0.02f));
        return shapeDrawable;
    }

    private void m5436b() {
        this.f4860l = (int) (this.f4857i + (2.0f * this.f4858j));
    }

    private int m5437c(float f) {
        return (int) (255.0f * f);
    }

    private int m5438c(int i) {
        return m5434b(i, 0.9f);
    }

    private Drawable m5439c(int i, float f) {
        if (!this.f4854f) {
            return new ColorDrawable(0);
        }
        Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
        final int c = m5438c(i);
        final int e = m5442e(c);
        final int d = m5441d(i);
        final int e2 = m5442e(d);
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(f);
        paint.setStyle(Style.STROKE);
        final int i2 = i;
        shapeDrawable.setShaderFactory(new ShaderFactory(this) {
            final /* synthetic */ FloatingActionButton f4847f;

            public Shader resize(int i, int i2) {
                return new LinearGradient((float) (i / 2), 0.0f, (float) (i / 2), (float) i2, new int[]{d, e2, i2, e, c}, new float[]{0.0f, 0.2f, 0.5f, 0.8f, 1.0f}, TileMode.CLAMP);
            }
        });
        return shapeDrawable;
    }

    private void m5440c() {
        this.f4857i = m5447b(this.f4856h == 0 ? C1160d.fab_size_normal : C1160d.fab_size_mini);
    }

    private int m5441d(int i) {
        return m5434b(i, 1.1f);
    }

    private int m5442e(int i) {
        return Color.argb(Color.alpha(i) / 2, Color.red(i), Color.green(i), Color.blue(i));
    }

    private int m5443f(int i) {
        return Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
    }

    @SuppressLint({"NewApi"})
    private void setBackgroundCompat(Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    int m5444a(@ColorRes int i) {
        return getResources().getColor(i);
    }

    void mo2849a() {
        float b = m5447b(C1160d.fab_stroke_width);
        float f = b / 2.0f;
        Drawable[] drawableArr = new Drawable[4];
        drawableArr[0] = getResources().getDrawable(this.f4856h == 0 ? C1161e.fab_bg_normal : C1161e.fab_bg_mini);
        drawableArr[1] = m5433a(b);
        drawableArr[2] = m5435b(b);
        drawableArr[3] = getIconDrawable();
        Drawable layerDrawable = new LayerDrawable(drawableArr);
        int b2 = ((int) (this.f4857i - m5447b(C1160d.fab_icon_size))) / 2;
        int i = (int) this.f4858j;
        int i2 = (int) (this.f4858j - this.f4859k);
        int i3 = (int) (this.f4858j + this.f4859k);
        layerDrawable.setLayerInset(1, i, i2, i, i3);
        layerDrawable.setLayerInset(2, (int) (((float) i) - f), (int) (((float) i2) - f), (int) (((float) i) - f), (int) (((float) i3) - f));
        layerDrawable.setLayerInset(3, i + b2, i2 + b2, i + b2, i3 + b2);
        setBackgroundCompat(layerDrawable);
    }

    void mo2846a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1167k.FloatingActionButton, 0, 0);
        this.f4850b = obtainStyledAttributes.getColor(C1167k.FloatingActionButton_fab_colorNormal, ResourcesCompat.getColor(getResources(), C1159c.sliding_left_menu_item_icon_tintcolor, null));
        this.f4851c = obtainStyledAttributes.getColor(C1167k.FloatingActionButton_fab_colorPressed, ResourcesCompat.getColor(getResources(), C1159c.sliding_left_menu_item_icon_tintcolor, null));
        this.f4852d = obtainStyledAttributes.getColor(C1167k.FloatingActionButton_fab_colorDisabled, m5444a(17170432));
        this.f4856h = obtainStyledAttributes.getInt(C1167k.FloatingActionButton_fab_size, 0);
        this.f4849a = obtainStyledAttributes.getResourceId(C1167k.FloatingActionButton_fab_icon, 0);
        this.f4853e = obtainStyledAttributes.getString(C1167k.FloatingActionButton_fab_title);
        this.f4854f = obtainStyledAttributes.getBoolean(C1167k.FloatingActionButton_fab_stroke_visible, true);
        obtainStyledAttributes.recycle();
        m5440c();
        this.f4858j = m5447b(C1160d.fab_shadow_radius);
        this.f4859k = m5447b(C1160d.fab_shadow_offset);
        m5436b();
        mo2849a();
    }

    float m5447b(@DimenRes int i) {
        return getResources().getDimension(i);
    }

    public int getColorDisabled() {
        return this.f4852d;
    }

    public int getColorNormal() {
        return this.f4850b;
    }

    public int getColorPressed() {
        return this.f4851c;
    }

    Drawable getIconDrawable() {
        return this.f4855g != null ? this.f4855g : this.f4849a != 0 ? getResources().getDrawable(this.f4849a) : new ColorDrawable(0);
    }

    TextView getLabelView() {
        return (TextView) getTag(C1162f.fab_label);
    }

    public int getSize() {
        return this.f4856h;
    }

    public String getTitle() {
        return this.f4853e;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.f4860l, this.f4860l);
    }

    public void setColorDisabled(int i) {
        if (this.f4852d != i) {
            this.f4852d = i;
            mo2849a();
        }
    }

    public void setColorDisabledResId(@ColorRes int i) {
        setColorDisabled(m5444a(i));
    }

    public void setColorNormal(int i) {
        if (this.f4850b != i) {
            this.f4850b = i;
            mo2849a();
        }
    }

    public void setColorNormalResId(@ColorRes int i) {
        setColorNormal(m5444a(i));
    }

    public void setColorPressed(int i) {
        if (this.f4851c != i) {
            this.f4851c = i;
            mo2849a();
        }
    }

    public void setColorPressedResId(@ColorRes int i) {
        setColorPressed(m5444a(i));
    }

    public void setIcon(@DrawableRes int i) {
        if (this.f4849a != i) {
            this.f4849a = i;
            this.f4855g = null;
            mo2849a();
        }
    }

    public void setIconDrawable(@NonNull Drawable drawable) {
        if (this.f4855g != drawable) {
            this.f4849a = 0;
            this.f4855g = drawable;
            mo2849a();
        }
    }

    public void setSize(int i) {
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException("Use @FAB_SIZE constants only!");
        } else if (this.f4856h != i) {
            this.f4856h = i;
            m5440c();
            m5436b();
            mo2849a();
        }
    }

    public void setStrokeVisible(boolean z) {
        if (this.f4854f != z) {
            this.f4854f = z;
            mo2849a();
        }
    }

    public void setTitle(String str) {
        this.f4853e = str;
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setText(str);
        }
    }

    public void setVisibility(int i) {
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setVisibility(i);
        }
        super.setVisibility(i);
    }
}
