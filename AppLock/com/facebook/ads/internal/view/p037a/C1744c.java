package com.facebook.ads.internal.view.p037a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.internal.p018m.ad;
import com.facebook.ads.internal.p018m.af;

@TargetApi(19)
public class C1744c extends LinearLayout {
    private TextView f4402a;
    private TextView f4403b;
    private Drawable f4404c;

    public C1744c(Context context) {
        super(context);
        m5010a();
    }

    private void m5010a() {
        float f = getResources().getDisplayMetrics().density;
        setOrientation(1);
        this.f4402a = new TextView(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.f4402a.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4402a.setTextSize(2, 20.0f);
        this.f4402a.setEllipsize(TruncateAt.END);
        this.f4402a.setSingleLine(true);
        this.f4402a.setVisibility(8);
        addView(this.f4402a, layoutParams);
        this.f4403b = new TextView(getContext());
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.f4403b.setAlpha(0.5f);
        this.f4403b.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4403b.setTextSize(2, 15.0f);
        this.f4403b.setCompoundDrawablePadding((int) (f * 5.0f));
        this.f4403b.setEllipsize(TruncateAt.END);
        this.f4403b.setSingleLine(true);
        this.f4403b.setVisibility(8);
        addView(this.f4403b, layoutParams);
    }

    private Drawable getPadlockDrawable() {
        if (this.f4404c == null) {
            this.f4404c = af.m4818b(getContext(), ad.BROWSER_PADLOCK);
        }
        return this.f4404c;
    }

    public void setSubtitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f4403b.setText(null);
            this.f4403b.setVisibility(8);
            return;
        }
        Uri parse = Uri.parse(str);
        this.f4403b.setText(parse.getHost());
        this.f4403b.setCompoundDrawablesRelativeWithIntrinsicBounds("https".equals(parse.getScheme()) ? getPadlockDrawable() : null, null, null, null);
        this.f4403b.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f4402a.setText(null);
            this.f4402a.setVisibility(8);
            return;
        }
        this.f4402a.setText(str);
        this.f4402a.setVisibility(0);
    }
}
