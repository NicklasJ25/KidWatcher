package com.facebook.ads.internal.p021b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkActivity.C1439a;
import com.facebook.ads.internal.p018m.ab;
import com.facebook.ads.internal.p021b.C1520p.C1519a;
import com.facebook.ads.internal.view.C1523c;
import com.facebook.ads.internal.view.C1523c.C1436a;
import com.facebook.ads.internal.view.p035c.p036a.C1774s;
import com.facebook.ads.internal.view.p035c.p039b.C1784m;
import com.facebook.ads.internal.view.p035c.p039b.C1786a.C1783a;
import com.facebook.ads.internal.view.p035c.p039b.C1803d;
import com.facebook.ads.internal.view.p035c.p039b.C1803d.C1802a;
import com.facebook.ads.internal.view.p035c.p039b.C1808f;
import com.facebook.ads.internal.view.p035c.p039b.C1820i;
import com.facebook.ads.internal.view.p035c.p039b.C1822j;
import com.facebook.ads.internal.view.p035c.p039b.C1827k;
import com.facebook.ads.internal.view.p035c.p039b.C1832o;
import com.facebook.ads.internal.view.p038b.C1755a;
import org.json.JSONObject;

public class C1524q extends C1517o implements OnTouchListener, C1523c {
    static final /* synthetic */ boolean f3590h = (!C1524q.class.desiredAssertionStatus());
    final int f3591e = 64;
    final int f3592f = 64;
    final int f3593g = 16;
    @Nullable
    private C1436a f3594i;
    @Nullable
    private Activity f3595j;
    private C1439a f3596k = new C15211(this);
    private final OnTouchListener f3597l = new C15222(this);
    private C1519a f3598m = C1519a.UNSPECIFIED;
    private C1755a f3599n;
    private TextView f3600o;
    private TextView f3601p;
    private ImageView f3602q;
    private C1783a f3603r;
    private C1832o f3604s;
    private ViewGroup f3605t;
    private C1803d f3606u;
    private C1820i f3607v;
    private int f3608w = -1;
    private int f3609x = -10525069;
    private int f3610y = -12286980;
    private boolean f3611z = false;

    class C15211 implements C1439a {
        final /* synthetic */ C1524q f3588a;

        C15211(C1524q c1524q) {
            this.f3588a = c1524q;
        }

        public boolean mo2619a() {
            if (this.f3588a.f3607v == null) {
                return false;
            }
            if (!this.f3588a.f3607v.m5127a()) {
                return true;
            }
            if (!(this.f3588a.f3607v.getSkipSeconds() == 0 || this.f3588a.a == null)) {
                this.f3588a.a.m5257f();
            }
            if (this.f3588a.a != null) {
                this.f3588a.a.m5258g();
            }
            this.f3588a.f3595j.finish();
            return false;
        }
    }

    class C15222 implements OnTouchListener {
        final /* synthetic */ C1524q f3589a;

        C15222(C1524q c1524q) {
            this.f3589a = c1524q;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (this.f3589a.f3607v == null) {
                    this.f3589a.f3595j.finish();
                } else if (this.f3589a.f3607v.m5127a()) {
                    if (!(this.f3589a.f3607v.getSkipSeconds() == 0 || this.f3589a.a == null)) {
                        this.f3589a.a.m5257f();
                    }
                    if (this.f3589a.a != null) {
                        this.f3589a.a.m5258g();
                    }
                    this.f3589a.f3595j.finish();
                }
            }
            return true;
        }
    }

    private void m4060a(int i) {
        View linearLayout;
        float f = this.c.getResources().getDisplayMetrics().density;
        LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (56.0f * f), (int) (56.0f * f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        int i2 = (int) (16.0f * f);
        this.f3607v.setPadding(i2, i2, i2, i2);
        this.f3607v.setLayoutParams(layoutParams);
        C1802a c1802a = m4075h() ? C1802a.FADE_OUT_ON_PLAY : C1802a.VISIBLE;
        int id = this.a.getId();
        if (i == 1 && (m4065m() || m4066n())) {
            Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{0, -15658735});
            gradientDrawable.setCornerRadius(0.0f);
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(10);
            this.a.setLayoutParams(layoutParams2);
            m4061a(this.a);
            m4061a(this.f3607v);
            m4061a(this.f3603r);
            LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (((float) (((((this.f3599n != null ? 64 : 0) + 60) + 16) + 16) + 16)) * f));
            layoutParams3.addRule(12);
            View relativeLayout = new RelativeLayout(this.c);
            relativeLayout.setBackground(gradientDrawable);
            relativeLayout.setLayoutParams(layoutParams3);
            relativeLayout.setPadding(i2, 0, i2, (int) (((float) (((this.f3599n != null ? 64 : 0) + 16) + 16)) * f));
            this.f3605t = relativeLayout;
            if (!this.f3611z) {
                this.f3606u.m5090a(relativeLayout, c1802a);
            }
            m4061a(relativeLayout);
            if (this.f3604s != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, (int) (6.0f * f));
                layoutParams.addRule(12);
                layoutParams.topMargin = (int) (-6.0f * f);
                this.f3604s.setLayoutParams(layoutParams);
                m4061a(this.f3604s);
            }
            if (this.f3599n != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, (int) (64.0f * f));
                layoutParams.bottomMargin = (int) (16.0f * f);
                layoutParams.leftMargin = (int) (16.0f * f);
                layoutParams.rightMargin = (int) (16.0f * f);
                layoutParams.addRule(14);
                layoutParams.addRule(12);
                this.f3599n.setLayoutParams(layoutParams);
                m4061a(this.f3599n);
            }
            if (this.f3602q != null) {
                layoutParams = new RelativeLayout.LayoutParams((int) (60.0f * f), (int) (60.0f * f));
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                this.f3602q.setLayoutParams(layoutParams);
                m4062a(relativeLayout, this.f3602q);
            }
            if (this.f3600o != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = (int) (36.0f * f);
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                this.f3600o.setEllipsize(TruncateAt.END);
                this.f3600o.setGravity(GravityCompat.START);
                this.f3600o.setLayoutParams(layoutParams);
                this.f3600o.setMaxLines(1);
                this.f3600o.setPadding((int) (72.0f * f), 0, 0, 0);
                this.f3600o.setTextColor(-1);
                this.f3600o.setTextSize(18.0f);
                m4062a(relativeLayout, this.f3600o);
            }
            if (this.f3601p != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                layoutParams.bottomMargin = (int) (4.0f * f);
                this.f3601p.setEllipsize(TruncateAt.END);
                this.f3601p.setGravity(GravityCompat.START);
                this.f3601p.setLayoutParams(layoutParams);
                this.f3601p.setMaxLines(1);
                this.f3601p.setPadding((int) (72.0f * f), 0, 0, 0);
                this.f3601p.setTextColor(-1);
                m4062a(relativeLayout, this.f3601p);
            }
            ((ViewGroup) this.a.getParent()).setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        } else if (i == 1) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10);
            this.a.setLayoutParams(layoutParams);
            m4061a(this.a);
            m4061a(this.f3607v);
            m4061a(this.f3603r);
            linearLayout = new LinearLayout(this.c);
            this.f3605t = linearLayout;
            linearLayout.setGravity(112);
            linearLayout.setOrientation(1);
            r4 = new RelativeLayout.LayoutParams(-1, -1);
            r4.leftMargin = (int) (33.0f * f);
            r4.rightMargin = (int) (33.0f * f);
            r4.topMargin = (int) (8.0f * f);
            if (this.f3599n == null) {
                r4.bottomMargin = (int) (16.0f * f);
            } else {
                r4.bottomMargin = (int) (80.0f * f);
            }
            r4.addRule(3, id);
            linearLayout.setLayoutParams(r4);
            m4061a(linearLayout);
            if (this.f3599n != null) {
                r4 = new RelativeLayout.LayoutParams(-1, (int) (64.0f * f));
                r4.bottomMargin = (int) (16.0f * f);
                r4.leftMargin = (int) (33.0f * f);
                r4.rightMargin = (int) (33.0f * f);
                r4.addRule(14);
                r4.addRule(12);
                this.f3599n.setLayoutParams(r4);
                m4061a(this.f3599n);
            }
            if (this.f3600o != null) {
                r4 = new LinearLayout.LayoutParams(-2, -2);
                r4.weight = 2.0f;
                r4.gravity = 17;
                this.f3600o.setEllipsize(TruncateAt.END);
                this.f3600o.setGravity(17);
                this.f3600o.setLayoutParams(r4);
                this.f3600o.setMaxLines(2);
                this.f3600o.setPadding(0, 0, 0, 0);
                this.f3600o.setTextColor(this.f3609x);
                this.f3600o.setTextSize(24.0f);
                m4062a(linearLayout, this.f3600o);
            }
            if (this.f3602q != null) {
                r4 = new LinearLayout.LayoutParams((int) (64.0f * f), (int) (64.0f * f));
                r4.weight = 0.0f;
                r4.gravity = 17;
                this.f3602q.setLayoutParams(r4);
                m4062a(linearLayout, this.f3602q);
            }
            if (this.f3601p != null) {
                r4 = new LinearLayout.LayoutParams(-1, -2);
                r4.weight = 2.0f;
                r4.gravity = 16;
                this.f3601p.setEllipsize(TruncateAt.END);
                this.f3601p.setGravity(16);
                this.f3601p.setLayoutParams(r4);
                this.f3601p.setMaxLines(2);
                this.f3601p.setPadding(0, 0, 0, 0);
                this.f3601p.setTextColor(this.f3609x);
                m4062a(linearLayout, this.f3601p);
            }
            if (this.f3604s != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, (int) (6.0f * f));
                layoutParams.addRule(3, id);
                this.f3604s.setLayoutParams(layoutParams);
                m4061a(this.f3604s);
            }
            ((ViewGroup) this.a.getParent()).setBackgroundColor(this.f3608w);
        } else if (!m4067o() || m4066n()) {
            Drawable gradientDrawable2 = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{0, -15658735});
            gradientDrawable2.setCornerRadius(0.0f);
            this.a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            m4061a(this.a);
            m4061a(this.f3607v);
            m4061a(this.f3603r);
            LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) (124.0f * f));
            layoutParams4.addRule(12);
            View relativeLayout2 = new RelativeLayout(this.c);
            relativeLayout2.setBackground(gradientDrawable2);
            relativeLayout2.setLayoutParams(layoutParams4);
            relativeLayout2.setPadding(i2, 0, i2, i2);
            this.f3605t = relativeLayout2;
            if (!this.f3611z) {
                this.f3606u.m5090a(relativeLayout2, c1802a);
            }
            m4061a(relativeLayout2);
            if (this.f3599n != null) {
                layoutParams = new RelativeLayout.LayoutParams((int) (110.0f * f), (int) (56.0f * f));
                layoutParams.rightMargin = (int) (16.0f * f);
                layoutParams.bottomMargin = (int) (16.0f * f);
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                this.f3599n.setLayoutParams(layoutParams);
                m4061a(this.f3599n);
            }
            if (this.f3602q != null) {
                layoutParams = new RelativeLayout.LayoutParams((int) (64.0f * f), (int) (64.0f * f));
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                layoutParams.bottomMargin = (int) (8.0f * f);
                this.f3602q.setLayoutParams(layoutParams);
                m4062a(relativeLayout2, this.f3602q);
            }
            if (this.f3600o != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = (int) (48.0f * f);
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                this.f3600o.setEllipsize(TruncateAt.END);
                this.f3600o.setGravity(GravityCompat.START);
                this.f3600o.setLayoutParams(layoutParams);
                this.f3600o.setMaxLines(1);
                this.f3600o.setPadding((int) (80.0f * f), 0, this.f3599n != null ? (int) (126.0f * f) : 0, 0);
                this.f3600o.setTextColor(-1);
                this.f3600o.setTextSize(24.0f);
                m4062a(relativeLayout2, this.f3600o);
            }
            if (this.f3601p != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                this.f3601p.setEllipsize(TruncateAt.END);
                this.f3601p.setGravity(GravityCompat.START);
                this.f3601p.setLayoutParams(layoutParams);
                this.f3601p.setMaxLines(2);
                this.f3601p.setTextColor(-1);
                this.f3601p.setPadding((int) (80.0f * f), 0, this.f3599n != null ? (int) (126.0f * f) : 0, 0);
                m4062a(relativeLayout2, this.f3601p);
            }
            if (this.f3604s != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, (int) (6.0f * f));
                layoutParams.addRule(12);
                this.f3604s.setLayoutParams(layoutParams);
                m4061a(this.f3604s);
            }
            ((ViewGroup) this.a.getParent()).setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.addRule(9);
            this.a.setLayoutParams(layoutParams);
            m4061a(this.a);
            m4061a(this.f3607v);
            m4061a(this.f3603r);
            linearLayout = new LinearLayout(this.c);
            this.f3605t = linearLayout;
            linearLayout.setGravity(112);
            linearLayout.setOrientation(1);
            r4 = new RelativeLayout.LayoutParams(-1, -1);
            r4.leftMargin = (int) (16.0f * f);
            r4.rightMargin = (int) (16.0f * f);
            r4.topMargin = (int) (8.0f * f);
            r4.bottomMargin = (int) (80.0f * f);
            r4.addRule(1, id);
            linearLayout.setLayoutParams(r4);
            m4061a(linearLayout);
            if (this.f3604s != null) {
                r4 = new RelativeLayout.LayoutParams(-1, (int) (6.0f * f));
                r4.addRule(5, id);
                r4.addRule(7, id);
                r4.addRule(3, id);
                r4.topMargin = (int) (-6.0f * f);
                this.f3604s.setLayoutParams(r4);
                m4061a(this.f3604s);
            }
            if (this.f3600o != null) {
                r4 = new LinearLayout.LayoutParams(-2, -2);
                r4.weight = 2.0f;
                r4.gravity = 17;
                this.f3600o.setEllipsize(TruncateAt.END);
                this.f3600o.setGravity(17);
                this.f3600o.setLayoutParams(r4);
                this.f3600o.setMaxLines(10);
                this.f3600o.setPadding(0, 0, 0, 0);
                this.f3600o.setTextColor(this.f3609x);
                this.f3600o.setTextSize(24.0f);
                m4062a(linearLayout, this.f3600o);
            }
            if (this.f3602q != null) {
                r4 = new LinearLayout.LayoutParams((int) (64.0f * f), (int) (64.0f * f));
                r4.weight = 0.0f;
                r4.gravity = 17;
                this.f3602q.setLayoutParams(r4);
                m4062a(linearLayout, this.f3602q);
            }
            if (this.f3601p != null) {
                r4 = new LinearLayout.LayoutParams(-1, -2);
                r4.weight = 2.0f;
                r4.gravity = 16;
                this.f3601p.setEllipsize(TruncateAt.END);
                this.f3601p.setGravity(17);
                this.f3601p.setLayoutParams(r4);
                this.f3601p.setMaxLines(10);
                this.f3601p.setPadding(0, 0, 0, 0);
                this.f3601p.setTextColor(this.f3609x);
                m4062a(linearLayout, this.f3601p);
            }
            if (this.f3599n != null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, (int) (64.0f * f));
                layoutParams.bottomMargin = (int) (16.0f * f);
                layoutParams.leftMargin = (int) (16.0f * f);
                layoutParams.rightMargin = (int) (16.0f * f);
                layoutParams.addRule(14);
                layoutParams.addRule(12);
                layoutParams.addRule(1, id);
                this.f3599n.setLayoutParams(layoutParams);
                m4061a(this.f3599n);
            }
            ((ViewGroup) this.a.getParent()).setBackgroundColor(this.f3608w);
        }
        linearLayout = this.a.getRootView();
        if (linearLayout != null) {
            linearLayout.setOnTouchListener(this);
        }
    }

    private void m4061a(View view) {
        if (this.f3594i != null) {
            this.f3594i.mo2616a(view);
        }
    }

    private void m4062a(@Nullable ViewGroup viewGroup, @Nullable View view) {
        if (viewGroup != null) {
            viewGroup.addView(view);
        }
    }

    private void m4064b(View view) {
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
    }

    private boolean m4065m() {
        return ((double) (this.a.getVideoHeight() > 0 ? ((float) this.a.getVideoWidth()) / ((float) this.a.getVideoHeight()) : -1.0f)) <= 0.9d;
    }

    private boolean m4066n() {
        if (this.a.getVideoHeight() <= 0) {
            return false;
        }
        Rect rect = new Rect();
        float f = this.c.getResources().getDisplayMetrics().density;
        this.f3595j.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        if (rect.width() > rect.height()) {
            return ((float) (rect.width() - ((rect.height() * this.a.getVideoWidth()) / this.a.getVideoHeight()))) - (f * 192.0f) < 0.0f;
        } else {
            return ((((float) (rect.height() - ((rect.width() * this.a.getVideoHeight()) / this.a.getVideoWidth()))) - (64.0f * f)) - (64.0f * f)) - (f * 40.0f) < 0.0f;
        }
    }

    private boolean m4067o() {
        float videoWidth = this.a.getVideoHeight() > 0 ? ((float) this.a.getVideoWidth()) / ((float) this.a.getVideoHeight()) : -1.0f;
        return ((double) videoWidth) > 0.9d && ((double) videoWidth) < 1.1d;
    }

    private void m4068p() {
        m4064b(this.a);
        m4064b(this.f3599n);
        m4064b(this.f3600o);
        m4064b(this.f3601p);
        m4064b(this.f3602q);
        m4064b(this.f3603r);
        m4064b(this.f3604s);
        m4064b(this.f3605t);
        m4064b(this.f3607v);
    }

    @TargetApi(17)
    public void mo2715a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        this.f3595j = audienceNetworkActivity;
        if (f3590h || this.f3594i != null) {
            audienceNetworkActivity.m3720a(this.f3596k);
            m4068p();
            m4060a(this.f3595j.getResources().getConfiguration().orientation);
            if (m4075h()) {
                mo2712f();
                return;
            } else {
                m4033g();
                return;
            }
        }
        throw new AssertionError();
    }

    public void m4070a(Configuration configuration) {
        m4068p();
        m4060a(configuration.orientation);
    }

    public void mo2716a(Bundle bundle) {
    }

    public void mo2717a(C1436a c1436a) {
        this.f3594i = c1436a;
    }

    public void mo2680b() {
        if (this.a != null) {
            this.a.m5258g();
        }
        C1520p.m4044a((C1523c) this);
    }

    @TargetApi(17)
    protected void mo2718c() {
        C1784m c1808f;
        String optString = this.b.getJSONObject("context").optString("orientation");
        if (!optString.isEmpty()) {
            this.f3598m = C1519a.m4040a(Integer.parseInt(optString));
        }
        if (this.b.has("layout") && !this.b.isNull("layout")) {
            JSONObject jSONObject = this.b.getJSONObject("layout");
            this.f3608w = (int) jSONObject.optLong("bgColor", (long) this.f3608w);
            this.f3609x = (int) jSONObject.optLong("textColor", (long) this.f3609x);
            this.f3610y = (int) jSONObject.optLong("accentColor", (long) this.f3610y);
            this.f3611z = jSONObject.optBoolean("persistentAdDetails", this.f3611z);
        }
        JSONObject jSONObject2 = this.b.getJSONObject("text");
        this.a.setId(View.generateViewId());
        int e = m4031e();
        Context context = this.c;
        if (e < 0) {
            e = 0;
        }
        this.f3607v = new C1820i(context, e, this.f3610y);
        this.f3607v.setOnTouchListener(this.f3597l);
        this.a.m5250a(this.f3607v);
        if (this.b.has("cta") && !this.b.isNull("cta")) {
            JSONObject jSONObject3 = this.b.getJSONObject("cta");
            this.f3599n = new C1755a(this.c, jSONObject3.getString("url"), jSONObject3.getString("text"), this.f3610y, this.a);
        }
        if (this.b.has("icon") && !this.b.isNull("icon")) {
            jSONObject = this.b.getJSONObject("icon");
            this.f3602q = new ImageView(this.c);
            new ab(this.f3602q).m4809a(jSONObject.getString("url"));
        }
        if (this.b.has("image") && !this.b.isNull("image")) {
            jSONObject = this.b.getJSONObject("image");
            c1808f = new C1808f(this.c);
            this.a.m5250a(c1808f);
            c1808f.setImage(jSONObject.getString("url"));
        }
        CharSequence optString2 = jSONObject2.optString("title");
        if (!optString2.isEmpty()) {
            this.f3600o = new TextView(this.c);
            this.f3600o.setText(optString2);
            this.f3600o.setTypeface(Typeface.defaultFromStyle(1));
        }
        optString2 = jSONObject2.optString("subtitle");
        if (!optString2.isEmpty()) {
            this.f3601p = new TextView(this.c);
            this.f3601p.setText(optString2);
            this.f3601p.setTextSize(16.0f);
        }
        this.f3604s = new C1832o(this.c);
        this.a.m5250a(this.f3604s);
        this.f3603r = new C1783a(this.c, "AdChoices", "http://m.facebook.com/ads/ad_choices", new float[]{0.0f, 0.0f, 8.0f, 0.0f}, this.b.getString("ct"));
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        this.f3603r.setLayoutParams(layoutParams);
        this.a.m5250a(new C1822j(this.c));
        c1808f = new C1827k(this.c);
        this.a.m5250a(c1808f);
        C1802a c1802a = m4075h() ? C1802a.FADE_OUT_ON_PLAY : C1802a.VISIBLE;
        this.a.m5250a(new C1803d(c1808f, c1802a));
        this.f3606u = new C1803d(new RelativeLayout(this.c), c1802a);
        this.a.m5250a(this.f3606u);
    }

    protected boolean m4075h() {
        if (f3590h || this.b != null) {
            try {
                return this.b.getJSONObject("video").getBoolean("autoplay");
            } catch (Throwable e) {
                Log.w(String.valueOf(C1524q.class), "Invalid JSON", e);
                return true;
            }
        }
        throw new AssertionError();
    }

    public void mo2719i() {
    }

    public void mo2720j() {
    }

    public C1519a m4078k() {
        return this.f3598m;
    }

    public void m4079l() {
        if (this.f3595j != null) {
            this.f3595j.finish();
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.a != null) {
            this.a.getEventBus().m4512a(new C1774s(view, motionEvent));
        }
        return true;
    }
}
