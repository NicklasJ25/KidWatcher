package com.domobile.frame.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout {
    private C1280b f2636a;
    private ImageView f2637b;
    private TextView f2638c;
    private Context f2639d;
    private boolean f2640e;
    private int f2641f;
    private int f2642g;
    private LayoutInflater f2643h;
    private boolean f2644i;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f2641f = -1;
        this.f2642g = 0;
        this.f2639d = context;
    }

    private LayoutInflater getInflater() {
        if (this.f2643h == null) {
            this.f2643h = LayoutInflater.from(getContext());
        }
        return this.f2643h;
    }

    public void m3063a(C1280b c1280b, int i) {
        this.f2636a = c1280b;
        setVisibility(c1280b.isVisible() ? 0 : 8);
        setTitle(c1280b.getTitle());
        setIcon(c1280b.getIcon());
        setEnabled(c1280b.isEnabled());
    }

    public C1280b getItemData() {
        return this.f2636a;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isPressed()) {
            canvas.drawColor(this.f2642g);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f2637b = (ImageView) findViewById(16908294);
        this.f2638c = (TextView) findViewById(16908310);
        if (this.f2641f != -1) {
            this.f2638c.setTextAppearance(this.f2639d, this.f2641f);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setForceShowIcon(boolean z) {
        this.f2644i = z;
        this.f2640e = z;
    }

    public void setHighlightColor(int i) {
        this.f2642g = i;
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f2644i;
        if (!z && !this.f2640e) {
            return;
        }
        if (this.f2637b != null || drawable != null || this.f2640e) {
            if (drawable != null || this.f2640e) {
                ImageView imageView = this.f2637b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f2637b.getVisibility() != 0) {
                    this.f2637b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f2637b.setVisibility(8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f2638c.setText(charSequence);
            if (this.f2638c.getVisibility() != 0) {
                this.f2638c.setVisibility(0);
            }
        } else if (this.f2638c.getVisibility() != 8) {
            this.f2638c.setVisibility(8);
        }
    }
}
