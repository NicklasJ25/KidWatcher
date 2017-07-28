package com.facebook.ads.internal.view.p035c.p039b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.net.Uri;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.view.C1864k;
import com.facebook.ads.internal.view.p035c.p036a.C1757a;

public class C1805e extends C1785n {
    private final Context f4490b;
    private final String f4491c;
    private final TextView f4492d = new TextView(getContext());
    private final String f4493e;
    private final Paint f4494f;
    private final RectF f4495g;

    public C1805e(Context context, String str, String str2, String str3) {
        super(context);
        this.f4490b = context;
        this.f4491c = str;
        this.f4493e = str2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f4492d.setTextColor(-3355444);
        this.f4492d.setTextSize(16.0f);
        this.f4492d.setPadding((int) (displayMetrics.density * 6.0f), (int) (displayMetrics.density * 4.0f), (int) (displayMetrics.density * 6.0f), (int) (displayMetrics.density * 4.0f));
        this.f4494f = new Paint();
        this.f4494f.setStyle(Style.FILL);
        this.f4494f.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4494f.setAlpha(178);
        this.f4495g = new RectF();
        setBackgroundColor(0);
        this.f4492d.setText(str3);
        addView(this.f4492d, new LayoutParams(-2, -2));
    }

    protected void a_(final C1864k c1864k) {
        this.f4492d.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ C1805e f4489b;

            public void onClick(View view) {
                try {
                    c1864k.getEventBus().m4512a(new C1757a(Uri.parse(this.f4489b.f4491c)));
                    C1729s.m4970a(this.f4489b.f4490b, Uri.parse(this.f4489b.f4491c), this.f4489b.f4493e);
                } catch (Throwable e) {
                    Log.e("LearnMorePlugin", "Error while opening " + this.f4489b.f4491c, e);
                }
            }
        });
    }

    protected void onDraw(Canvas canvas) {
        this.f4495g.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        canvas.drawRoundRect(this.f4495g, 0.0f, 0.0f, this.f4494f);
        super.onDraw(canvas);
    }
}
