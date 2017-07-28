package com.domobile.widget.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import com.domobile.applock.R;
import java.text.DateFormatSymbols;

public class C1416a extends View {
    private final Paint f3160a = new Paint();
    private int f3161b;
    private int f3162c;
    private int f3163d;
    private int f3164e;
    private float f3165f;
    private float f3166g;
    private String f3167h;
    private String f3168i;
    private boolean f3169j = false;
    private boolean f3170k;
    private int f3171l;
    private int f3172m;
    private int f3173n;
    private int f3174o;
    private int f3175p;
    private int f3176q;

    public C1416a(Context context) {
        super(context);
    }

    public int m3605a(float f, float f2) {
        if (!this.f3170k) {
            return -1;
        }
        int i = (int) ((f2 - ((float) this.f3174o)) * (f2 - ((float) this.f3174o)));
        if (((int) Math.sqrt((double) (((f - ((float) this.f3172m)) * (f - ((float) this.f3172m))) + ((float) i)))) <= this.f3171l) {
            return 0;
        }
        return ((int) Math.sqrt((double) (((float) i) + ((f - ((float) this.f3173n)) * (f - ((float) this.f3173n)))))) <= this.f3171l ? 1 : -1;
    }

    public void m3606a(Context context, int i) {
        if (this.f3169j) {
            Log.e("AmPmCirclesView", "AmPmCirclesView may only be initialized once.");
            return;
        }
        Resources resources = context.getResources();
        this.f3162c = resources.getColor(R.color.white);
        this.f3164e = resources.getColor(R.color.blue);
        this.f3163d = resources.getColor(R.color.ampm_text_color);
        this.f3161b = 51;
        this.f3160a.setTypeface(Typeface.create(resources.getString(R.string.sans_serif), 0));
        this.f3160a.setAntiAlias(true);
        this.f3160a.setTextAlign(Align.CENTER);
        this.f3165f = Float.parseFloat(resources.getString(R.string.circle_radius_multiplier));
        this.f3166g = Float.parseFloat(resources.getString(R.string.ampm_circle_radius_multiplier));
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.f3167h = amPmStrings[0];
        this.f3168i = amPmStrings[1];
        setAmOrPm(i);
        this.f3176q = -1;
        this.f3169j = true;
    }

    void m3607a(Context context, boolean z) {
        Resources resources = context.getResources();
        if (z) {
            this.f3162c = resources.getColor(R.color.dark_gray);
            this.f3164e = resources.getColor(R.color.red);
            this.f3163d = resources.getColor(R.color.white);
            this.f3161b = 102;
            return;
        }
        this.f3162c = resources.getColor(R.color.white);
        this.f3164e = resources.getColor(R.color.blue);
        this.f3163d = resources.getColor(R.color.ampm_text_color);
        this.f3161b = 51;
    }

    public void onDraw(Canvas canvas) {
        int i = 255;
        if (getWidth() != 0 && this.f3169j) {
            int width;
            int height;
            int min;
            if (!this.f3170k) {
                width = getWidth() / 2;
                height = getHeight() / 2;
                min = (int) (((float) Math.min(width, height)) * this.f3165f);
                this.f3171l = (int) (((float) min) * this.f3166g);
                this.f3160a.setTextSize((float) ((this.f3171l * 3) / 4));
                this.f3174o = (height - (this.f3171l / 2)) + min;
                this.f3172m = (width - min) + this.f3171l;
                this.f3173n = (width + min) - this.f3171l;
                this.f3170k = true;
            }
            min = this.f3162c;
            width = this.f3162c;
            if (this.f3175p == 0) {
                min = this.f3164e;
                height = this.f3161b;
            } else if (this.f3175p == 1) {
                height = this.f3164e;
                width = height;
                height = 255;
                i = this.f3161b;
            } else {
                height = 255;
            }
            if (this.f3176q == 0) {
                min = this.f3164e;
                height = this.f3161b;
            } else if (this.f3176q == 1) {
                width = this.f3164e;
                i = this.f3161b;
            }
            this.f3160a.setColor(min);
            this.f3160a.setAlpha(height);
            canvas.drawCircle((float) this.f3172m, (float) this.f3174o, (float) this.f3171l, this.f3160a);
            this.f3160a.setColor(width);
            this.f3160a.setAlpha(i);
            canvas.drawCircle((float) this.f3173n, (float) this.f3174o, (float) this.f3171l, this.f3160a);
            this.f3160a.setColor(this.f3163d);
            i = this.f3174o - (((int) (this.f3160a.descent() + this.f3160a.ascent())) / 2);
            canvas.drawText(this.f3167h, (float) this.f3172m, (float) i, this.f3160a);
            canvas.drawText(this.f3168i, (float) this.f3173n, (float) i, this.f3160a);
        }
    }

    public void setAmOrPm(int i) {
        this.f3175p = i;
    }

    public void setAmOrPmPressed(int i) {
        this.f3176q = i;
    }
}
