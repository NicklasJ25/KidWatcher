package com.facebook.ads.internal.view.p037a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.facebook.ads.internal.p018m.ad;
import com.facebook.ads.internal.p018m.af;
import java.util.List;

@TargetApi(19)
public class C1742a extends LinearLayout {
    private static final int f4389a = Color.rgb(224, 224, 224);
    private static final Uri f4390b = Uri.parse("http://www.facebook.com");
    private static final OnTouchListener f4391c = new C17381();
    private static final int f4392d = Color.argb(34, 0, 0, 0);
    private ImageView f4393e;
    private C1744c f4394f;
    private ImageView f4395g;
    private C1741a f4396h;
    private String f4397i;

    static class C17381 implements OnTouchListener {
        C17381() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    view.setBackgroundColor(C1742a.f4392d);
                    break;
                case 1:
                    view.setBackgroundColor(0);
                    break;
            }
            return false;
        }
    }

    class C17392 implements OnClickListener {
        final /* synthetic */ C1742a f4387a;

        C17392(C1742a c1742a) {
            this.f4387a = c1742a;
        }

        public void onClick(View view) {
            if (this.f4387a.f4396h != null) {
                this.f4387a.f4396h.mo2814a();
            }
        }
    }

    class C17403 implements OnClickListener {
        final /* synthetic */ C1742a f4388a;

        C17403(C1742a c1742a) {
            this.f4388a = c1742a;
        }

        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.f4388a.f4397i) && !"about:blank".equals(this.f4388a.f4397i)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f4388a.f4397i));
                intent.addFlags(268435456);
                this.f4388a.getContext().startActivity(intent);
            }
        }
    }

    public interface C1741a {
        void mo2814a();
    }

    public C1742a(Context context) {
        super(context);
        m5006a(context);
    }

    private void m5006a(Context context) {
        float f = getResources().getDisplayMetrics().density;
        int i = (int) (50.0f * f);
        int i2 = (int) (f * 4.0f);
        setBackgroundColor(-1);
        setGravity(16);
        this.f4393e = new ImageView(context);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        this.f4393e.setScaleType(ScaleType.CENTER);
        this.f4393e.setImageBitmap(af.m4817a(context, ad.BROWSER_CLOSE));
        this.f4393e.setOnTouchListener(f4391c);
        this.f4393e.setOnClickListener(new C17392(this));
        addView(this.f4393e, layoutParams);
        this.f4394f = new C1744c(context);
        layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.f4394f.setPadding(0, i2, 0, i2);
        addView(this.f4394f, layoutParams);
        this.f4395g = new ImageView(context);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, i);
        this.f4395g.setScaleType(ScaleType.CENTER);
        this.f4395g.setOnTouchListener(f4391c);
        this.f4395g.setOnClickListener(new C17403(this));
        addView(this.f4395g, layoutParams2);
        setupDefaultNativeBrowser(context);
    }

    private void setupDefaultNativeBrowser(Context context) {
        Bitmap bitmap;
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", f4390b), 65536);
        if (queryIntentActivities.size() == 0) {
            this.f4395g.setVisibility(8);
            bitmap = null;
        } else {
            bitmap = (queryIntentActivities.size() == 1 && "com.android.chrome".equals(((ResolveInfo) queryIntentActivities.get(0)).activityInfo.packageName)) ? af.m4817a(context, ad.BROWSER_LAUNCH_CHROME) : af.m4817a(context, ad.BROWSER_LAUNCH_NATIVE);
        }
        this.f4395g.setImageBitmap(bitmap);
    }

    public void setListener(C1741a c1741a) {
        this.f4396h = c1741a;
    }

    public void setTitle(String str) {
        this.f4394f.setTitle(str);
    }

    public void setUrl(String str) {
        this.f4397i = str;
        if (TextUtils.isEmpty(str) || "about:blank".equals(str)) {
            this.f4394f.setSubtitle(null);
            this.f4395g.setEnabled(false);
            this.f4395g.setColorFilter(new PorterDuffColorFilter(f4389a, Mode.SRC_IN));
            return;
        }
        this.f4394f.setSubtitle(str);
        this.f4395g.setEnabled(true);
        this.f4395g.setColorFilter(null);
    }
}
