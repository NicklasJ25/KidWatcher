package com.facebook.ads.internal.view.p038b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.internal.p020a.C1468a;
import com.facebook.ads.internal.p020a.C1469b;
import com.facebook.ads.internal.view.C1864k;
import com.facebook.ads.internal.view.p035c.p036a.C1757a;
import java.util.HashMap;

public class C1755a extends RelativeLayout {
    private final String f4424a;
    private C1864k f4425b;
    private final Paint f4426c = new Paint();
    private final RectF f4427d;

    class C17541 implements OnClickListener {
        final /* synthetic */ C1755a f4423a;

        C17541(C1755a c1755a) {
            this.f4423a = c1755a;
        }

        public void onClick(View view) {
            try {
                Uri parse = Uri.parse(this.f4423a.f4424a);
                this.f4423a.f4425b.getEventBus().m4512a(new C1757a(parse));
                C1468a a = C1469b.m3801a(this.f4423a.getContext(), "", parse, new HashMap());
                if (a != null) {
                    a.mo2642b();
                }
            } catch (Throwable e) {
                Log.e(String.valueOf(C1755a.class), "Error while opening " + this.f4423a.f4424a, e);
            } catch (Throwable e2) {
                Log.e(String.valueOf(C1755a.class), "Error executing action", e2);
            }
        }
    }

    public C1755a(Context context, String str, String str2, int i, C1864k c1864k) {
        super(context);
        this.f4424a = str;
        this.f4425b = c1864k;
        View textView = new TextView(context);
        textView.setTextColor(-1);
        textView.setTextSize(16.0f);
        textView.setText(str2);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        setGravity(17);
        addView(textView);
        this.f4426c.setStyle(Style.FILL);
        this.f4426c.setColor(i);
        this.f4427d = new RectF();
        setBackgroundColor(0);
        setOnClickListener(new C17541(this));
    }

    protected void onDraw(Canvas canvas) {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.f4427d.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        canvas.drawRoundRect(this.f4427d, 10.0f * f, f * 10.0f, this.f4426c);
        super.onDraw(canvas);
    }
}
