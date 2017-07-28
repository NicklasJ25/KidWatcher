package com.facebook.ads.internal.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.C1668j;
import com.facebook.ads.internal.C1674k;
import com.facebook.ads.internal.p018m.C1708d;
import com.facebook.ads.internal.p018m.C1711g;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p018m.ab;
import com.facebook.ads.internal.p022h.C1511s;
import com.facebook.ads.internal.p022h.C1599g;
import com.facebook.ads.internal.p034k.C1671a;
import com.facebook.ads.internal.p034k.C1671a.C1669a;
import com.facebook.ads.internal.view.C1523c.C1436a;
import com.facebook.ads.internal.view.p035c.p036a.C1758b;
import com.facebook.ads.internal.view.p035c.p036a.C1760d;
import com.facebook.ads.internal.view.p035c.p036a.C1768l;
import com.facebook.ads.internal.view.p035c.p036a.C1774s;
import com.facebook.ads.internal.view.p035c.p039b.C1784m;
import com.facebook.ads.internal.view.p035c.p039b.C1803d;
import com.facebook.ads.internal.view.p035c.p039b.C1803d.C1802a;
import com.facebook.ads.internal.view.p035c.p039b.C1822j;
import com.facebook.ads.internal.view.p035c.p039b.C1827k;
import com.facebook.ads.internal.view.p035c.p039b.C1836p;
import com.facebook.ads.internal.view.p035c.p040c.C1847d;
import java.util.HashMap;
import java.util.Map;

public class C1878j implements C1523c {
    private C1671a f4738a;
    private C1864k f4739b;
    private C1708d f4740c;
    private C1711g f4741d;
    private C1436a f4742e;
    private C1511s<C1758b> f4743f;
    private C1511s<C1760d> f4744g;
    private C1511s<C1768l> f4745h;
    private C1511s<C1774s> f4746i;
    private String f4747j;
    private Context f4748k;
    private String f4749l;
    private RelativeLayout f4750m;
    private TextView f4751n;
    private TextView f4752o;
    private ImageView f4753p;
    private C1836p f4754q;

    class C18731 extends C1511s<C1774s> {
        final /* synthetic */ C1878j f4733a;

        C18731(C1878j c1878j) {
            this.f4733a = c1878j;
        }

        public Class<C1774s> mo2709a() {
            return C1774s.class;
        }

        public void m5292a(C1774s c1774s) {
            this.f4733a.f4741d.m4919a(c1774s.m5049b(), this.f4733a.f4739b, c1774s.m5048a());
        }
    }

    class C18742 extends C1511s<C1758b> {
        final /* synthetic */ C1878j f4734a;

        C18742(C1878j c1878j) {
            this.f4734a = c1878j;
        }

        public Class<C1758b> mo2709a() {
            return C1758b.class;
        }

        public void m5295a(C1758b c1758b) {
            if (this.f4734a.f4742e != null) {
                this.f4734a.f4742e.mo2618a(C1674k.REWARDED_VIDEO_COMPLETE.m4768a(), c1758b);
            }
            this.f4734a.m5318f();
        }
    }

    class C18753 extends C1511s<C1760d> {
        final /* synthetic */ C1878j f4735a;

        C18753(C1878j c1878j) {
            this.f4735a = c1878j;
        }

        public Class<C1760d> mo2709a() {
            return C1760d.class;
        }

        public void m5298a(C1760d c1760d) {
            if (this.f4735a.f4742e != null) {
                this.f4735a.f4742e.mo2617a(C1674k.REWARDED_VIDEO_ERROR.m4768a());
            }
            this.f4735a.m5318f();
        }
    }

    class C18764 extends C1511s<C1768l> {
        final /* synthetic */ C1878j f4736a;

        C18764(C1878j c1878j) {
            this.f4736a = c1878j;
        }

        public Class<C1768l> mo2709a() {
            return C1768l.class;
        }

        public void m5301a(C1768l c1768l) {
            if (this.f4736a.f4738a != null) {
                this.f4736a.f4738a.m4758a();
            }
        }
    }

    class C18775 extends C1669a {
        final /* synthetic */ C1878j f4737a;

        C18775(C1878j c1878j) {
            this.f4737a = c1878j;
        }

        public void mo2782a() {
            if (!this.f4737a.f4741d.m4921b()) {
                this.f4737a.f4741d.m4918a();
                Map hashMap = new HashMap();
                if (!TextUtils.isEmpty(this.f4737a.f4747j)) {
                    this.f4737a.f4738a.m4760a(hashMap);
                    hashMap.put("touch", C1729s.m4963a(this.f4737a.m5310a()));
                    C1599g.m4464a(this.f4737a.f4748k).mo2739a(this.f4737a.f4747j, hashMap);
                }
                if (this.f4737a.f4742e != null) {
                    this.f4737a.f4742e.mo2617a(C1674k.REWARDED_VIDEO_IMPRESSION.m4768a());
                }
            }
        }
    }

    public C1878j(Context context, C1436a c1436a) {
        this.f4748k = context;
        this.f4742e = c1436a;
        m5309h();
    }

    private void m5309h() {
        float f = this.f4748k.getResources().getDisplayMetrics().density;
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f4739b = new C1864k(this.f4748k);
        this.f4739b.m5259h();
        this.f4739b.setAutoplay(true);
        this.f4739b.setIsFullScreen(true);
        this.f4739b.setLayoutParams(layoutParams);
        this.f4739b.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f4746i = new C18731(this);
        this.f4743f = new C18742(this);
        this.f4744g = new C18753(this);
        this.f4745h = new C18764(this);
        this.f4739b.getEventBus().m4513a(this.f4743f);
        this.f4739b.getEventBus().m4513a(this.f4744g);
        this.f4739b.getEventBus().m4513a(this.f4745h);
        this.f4739b.getEventBus().m4513a(this.f4746i);
        this.f4739b.m5250a(new C1822j(this.f4748k));
        this.f4754q = new C1836p(this.f4748k, (int) (6.0f * f));
        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f4754q.setLayoutParams(layoutParams);
        this.f4739b.m5250a(this.f4754q);
        if (C1668j.m4727j(this.f4748k)) {
            C1784m c1827k = new C1827k(this.f4748k);
            this.f4739b.m5250a(c1827k);
            this.f4739b.m5250a(new C1803d(c1827k, C1802a.INVSIBLE));
        }
        if (C1668j.m4720c(this.f4748k)) {
            Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{0, -15658735});
            gradientDrawable.setCornerRadius(0.0f);
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            this.f4750m = new RelativeLayout(this.f4748k);
            if (VERSION.SDK_INT >= 16) {
                this.f4750m.setBackground(gradientDrawable);
            } else {
                this.f4750m.setBackgroundDrawable(gradientDrawable);
            }
            this.f4750m.setLayoutParams(layoutParams2);
            this.f4750m.setPadding((int) (16.0f * f), 0, (int) (16.0f * f), (int) (20.0f * f));
            this.f4751n = new TextView(this.f4748k);
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            layoutParams.addRule(4);
            this.f4751n.setEllipsize(TruncateAt.END);
            this.f4751n.setGravity(GravityCompat.START);
            this.f4751n.setLayoutParams(layoutParams);
            this.f4751n.setMaxLines(1);
            this.f4751n.setPadding((int) (72.0f * f), 0, 0, (int) (30.0f * f));
            this.f4751n.setTextColor(-1);
            this.f4751n.setTextSize(20.0f);
            this.f4752o = new TextView(this.f4748k);
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            this.f4752o.setEllipsize(TruncateAt.END);
            this.f4752o.setGravity(GravityCompat.START);
            this.f4752o.setLayoutParams(layoutParams);
            this.f4752o.setMaxLines(2);
            this.f4752o.setPadding((int) (72.0f * f), 0, 0, 0);
            this.f4752o.setTextColor(-1);
            this.f4753p = new ImageView(this.f4748k);
            layoutParams = new RelativeLayout.LayoutParams((int) (60.0f * f), (int) (f * 60.0f));
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            this.f4753p.setLayoutParams(layoutParams);
            this.f4750m.addView(this.f4753p);
            this.f4750m.addView(this.f4751n);
            this.f4750m.addView(this.f4752o);
            C1784m c1803d = new C1803d(new RelativeLayout(this.f4748k), C1802a.INVSIBLE);
            c1803d.m5090a(this.f4750m, C1802a.INVSIBLE);
            this.f4739b.m5250a(c1803d);
        }
        this.f4738a = new C1671a(this.f4739b, 1, new C18775(this));
        this.f4738a.m4759a((int) Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        this.f4741d = new C1711g();
        this.f4742e.mo2616a(this.f4739b);
        if (this.f4750m != null) {
            this.f4742e.mo2616a(this.f4750m);
        }
        this.f4742e.mo2616a(this.f4754q);
    }

    public Map<String, String> m5310a() {
        return this.f4741d.m4924e();
    }

    public void mo2715a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        String stringExtra = intent.getStringExtra("videoURL");
        this.f4747j = intent.getStringExtra("clientToken");
        this.f4749l = intent.getStringExtra("contextSwitchBehavior");
        if (this.f4751n != null) {
            this.f4751n.setText(intent.getStringExtra("adTitle"));
        }
        if (this.f4752o != null) {
            this.f4752o.setText(intent.getStringExtra("adSubtitle"));
        }
        if (this.f4753p != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("adIconUrl"))) {
                new ab(this.f4753p).m4809a(r1);
            }
        }
        this.f4740c = new C1708d(this.f4748k, C1599g.m4464a(this.f4748k), this.f4739b, this.f4747j);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f4739b.setVideoURI(stringExtra);
        }
        this.f4739b.mo2828d();
    }

    public void mo2716a(Bundle bundle) {
    }

    public void mo2717a(C1436a c1436a) {
    }

    public void mo2680b() {
        m5318f();
        this.f4751n = null;
        this.f4752o = null;
        this.f4753p = null;
        this.f4750m = null;
        this.f4749l = null;
        this.f4743f = null;
        this.f4744g = null;
        this.f4745h = null;
        this.f4746i = null;
        this.f4738a = null;
        this.f4741d = null;
        this.f4740c = null;
        this.f4739b = null;
        this.f4742e = null;
        this.f4747j = null;
        this.f4748k = null;
        this.f4754q.m5156a();
        this.f4754q = null;
    }

    public void m5315c() {
        this.f4739b.m5248a(1);
        this.f4739b.mo2828d();
    }

    public void m5316d() {
        this.f4739b.m5256e();
    }

    public boolean m5317e() {
        return this.f4739b.getState() == C1847d.PAUSED;
    }

    public void m5318f() {
        if (this.f4739b != null) {
            this.f4739b.m5258g();
        }
        if (this.f4738a != null) {
            this.f4738a.m4761b();
        }
    }

    public void m5319g() {
        this.f4739b.m5248a(this.f4739b.getCurrentPosition());
        this.f4739b.mo2828d();
    }

    public void mo2719i() {
        m5316d();
    }

    public void mo2720j() {
        if (!m5317e()) {
            return;
        }
        if (this.f4749l.equals("restart")) {
            m5315c();
        } else if (this.f4749l.equals("resume")) {
            m5319g();
        } else if (this.f4749l.equals("skip")) {
            this.f4742e.mo2618a(C1674k.REWARDED_VIDEO_COMPLETE_WITHOUT_REWARD.m4768a(), new C1758b());
            m5318f();
        } else if (this.f4749l.equals("endvideo")) {
            this.f4742e.mo2617a(C1674k.REWARDED_VIDEO_END_ACTIVITY.m4768a());
            Map hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.f4747j)) {
                this.f4738a.m4760a(hashMap);
                hashMap.put("touch", C1729s.m4963a(m5310a()));
                C1599g.m4464a(this.f4748k).mo2746e(this.f4747j, hashMap);
            }
            m5318f();
        }
    }
}
