package com.domobile.widget.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import com.domobile.applock.R;

public class C1417b extends View {
    private final Paint f3177a = new Paint();
    private boolean f3178b;
    private int f3179c;
    private int f3180d;
    private float f3181e;
    private float f3182f;
    private boolean f3183g;
    private boolean f3184h;
    private int f3185i;
    private int f3186j;
    private int f3187k;

    public C1417b(Context context) {
        super(context);
        Resources resources = context.getResources();
        this.f3179c = resources.getColor(17170443);
        this.f3180d = resources.getColor(R.color.numbers_text_color);
        this.f3177a.setAntiAlias(true);
        this.f3183g = false;
    }

    public void m3608a(Context context, boolean z) {
        if (this.f3183g) {
            Log.e("CircleView", "CircleView may only be initialized once.");
            return;
        }
        Resources resources = context.getResources();
        this.f3178b = z;
        if (z) {
            this.f3181e = Float.parseFloat(resources.getString(R.string.circle_radius_multiplier_24HourMode));
        } else {
            this.f3181e = Float.parseFloat(resources.getString(R.string.circle_radius_multiplier));
            this.f3182f = Float.parseFloat(resources.getString(R.string.ampm_circle_radius_multiplier));
        }
        this.f3183g = true;
    }

    void m3609b(Context context, boolean z) {
        Resources resources = context.getResources();
        if (z) {
            this.f3179c = resources.getColor(R.color.dark_gray);
            this.f3180d = resources.getColor(R.color.light_gray);
            return;
        }
        this.f3179c = resources.getColor(R.color.white);
        this.f3180d = resources.getColor(R.color.numbers_text_color);
    }

    public void onDraw(Canvas canvas) {
        if (getWidth() != 0 && this.f3183g) {
            if (!this.f3184h) {
                this.f3185i = getWidth() / 2;
                this.f3186j = getHeight() / 2;
                this.f3187k = (int) (((float) Math.min(this.f3185i, this.f3186j)) * this.f3181e);
                if (!this.f3178b) {
                    this.f3186j -= ((int) (((float) this.f3187k) * this.f3182f)) / 2;
                }
                this.f3184h = true;
            }
            this.f3177a.setColor(this.f3179c);
            canvas.drawCircle((float) this.f3185i, (float) this.f3186j, (float) this.f3187k, this.f3177a);
            this.f3177a.setColor(this.f3180d);
            canvas.drawCircle((float) this.f3185i, (float) this.f3186j, 2.0f, this.f3177a);
        }
    }
}
