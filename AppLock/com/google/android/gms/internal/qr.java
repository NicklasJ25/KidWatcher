package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.C2513c;
import java.util.List;

@wh
public class qr extends RelativeLayout {
    private static final float[] f10367a = new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    @Nullable
    private AnimationDrawable f10368b;

    public qr(Context context, qq qqVar, LayoutParams layoutParams) {
        super(context);
        C2513c.m7932a((Object) qqVar);
        Drawable shapeDrawable = new ShapeDrawable(new RoundRectShape(f10367a, null, null));
        shapeDrawable.getPaint().setColor(qqVar.m13339c());
        setLayoutParams(layoutParams);
        zzw.zzcO().mo4259a((View) this, shapeDrawable);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(qqVar.m13337a())) {
            ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-2, -2);
            View textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(qqVar.m13337a());
            textView.setTextColor(qqVar.m13340d());
            textView.setTextSize((float) qqVar.m13341e());
            textView.setPadding(ol.m12979a().m8398a(context, 4), 0, ol.m12979a().m8398a(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        View imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<Drawable> b = qqVar.m13338b();
        if (b.size() > 1) {
            this.f10368b = new AnimationDrawable();
            for (Drawable shapeDrawable2 : b) {
                this.f10368b.addFrame(shapeDrawable2, qqVar.m13342f());
            }
            zzw.zzcO().mo4259a(imageView, this.f10368b);
        } else if (b.size() == 1) {
            imageView.setImageDrawable((Drawable) b.get(0));
        }
        addView(imageView);
    }

    public void onAttachedToWindow() {
        if (this.f10368b != null) {
            this.f10368b.start();
        }
        super.onAttachedToWindow();
    }
}
