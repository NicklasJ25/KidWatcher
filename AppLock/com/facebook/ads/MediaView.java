package com.facebook.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.p018m.ab;
import com.facebook.ads.internal.p021b.C1507m;
import com.facebook.ads.internal.p022h.C1597f;
import com.facebook.ads.internal.p022h.C1599g;
import com.facebook.ads.internal.view.C1450i;
import com.facebook.ads.internal.view.C1849d;
import com.facebook.ads.internal.view.C1865h;
import com.facebook.ads.internal.view.hscroll.C1871b;

public class MediaView extends RelativeLayout {
    private static final String f3339a = MediaView.class.getSimpleName();
    private static final int f3340b = Color.argb(51, 145, 150, 165);
    @Nullable
    private C1889k f3341c;
    private final C1849d f3342d;
    private final C1865h f3343e;
    private final C1871b f3344f;
    private boolean f3345g;
    @Deprecated
    private boolean f3346h;

    public MediaView(Context context) {
        this(context, null);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3345g = false;
        this.f3346h = true;
        setBackgroundColor(f3340b);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f3342d = new C1849d(context);
        this.f3342d.setVisibility(8);
        addView(this.f3342d, layoutParams);
        this.f3343e = new C1865h(context, getAdEventManager());
        this.f3343e.setVisibility(8);
        layoutParams.addRule(13);
        addView(this.f3343e, layoutParams);
        float f = context.getResources().getDisplayMetrics().density;
        int round = Math.round(4.0f * f);
        int round2 = Math.round(f * 12.0f);
        this.f3344f = new C1871b(getContext());
        this.f3344f.setChildSpacing(round);
        this.f3344f.setPadding(0, round2, 0, round2);
        this.f3344f.setVisibility(8);
        addView(this.f3344f, layoutParams);
    }

    private boolean m3739a(C1903l c1903l) {
        return VERSION.SDK_INT >= 14 && !TextUtils.isEmpty(c1903l.m5422m());
    }

    private boolean m3740b(C1903l c1903l) {
        if (c1903l.m5426q() == null) {
            return false;
        }
        for (C1903l f : c1903l.m5426q()) {
            if (f.m5415f() == null) {
                return false;
            }
        }
        return true;
    }

    public void m3741a() {
        this.f3343e.m5258g();
    }

    protected C1597f getAdEventManager() {
        return C1599g.m4464a(getContext());
    }

    @Deprecated
    public void setAutoplay(boolean z) {
        this.f3346h = z;
        this.f3343e.setAutoplay(z);
    }

    @Deprecated
    public void setAutoplayOnMobile(boolean z) {
        this.f3343e.setIsAutoplayOnMobile(z);
    }

    public void setListener(final C1889k c1889k) {
        this.f3341c = c1889k;
        if (c1889k == null) {
            this.f3343e.setListener(null);
        } else {
            this.f3343e.setListener(new C1450i(this) {
                final /* synthetic */ MediaView f3338b;

                public void mo2626a() {
                    c1889k.m5341a(this.f3338b, this.f3338b.f3343e.getVolume());
                }

                public void mo2627b() {
                    c1889k.m5342b(this.f3338b);
                }

                public void mo2628c() {
                    c1889k.m5340a(this.f3338b);
                }

                public void mo2629d() {
                    c1889k.m5346f(this.f3338b);
                }

                public void mo2630e() {
                    c1889k.m5347g(this.f3338b);
                }

                public void mo2631f() {
                    c1889k.m5345e(this.f3338b);
                }

                public void mo2632g() {
                    c1889k.m5344d(this.f3338b);
                }

                public void mo2633h() {
                    c1889k.m5343c(this.f3338b);
                }
            });
        }
    }

    public void setNativeAd(C1903l c1903l) {
        c1903l.m5406a(this);
        c1903l.m5410a(this.f3346h);
        if (this.f3345g) {
            this.f3342d.m5199a(null, null);
            this.f3345g = false;
        }
        String a = c1903l.m5415f() != null ? c1903l.m5415f().m5367a() : null;
        if (m3740b(c1903l)) {
            this.f3342d.setVisibility(8);
            this.f3343e.setVisibility(8);
            this.f3344f.setVisibility(0);
            bringChildToFront(this.f3344f);
            this.f3344f.setCurrentPosition(0);
            this.f3344f.setAdapter(new C1507m(this.f3344f, c1903l.m5426q()));
        } else if (m3739a(c1903l)) {
            String m = c1903l.m5422m();
            String n = c1903l.m5423n();
            this.f3343e.setImage(null);
            this.f3342d.setVisibility(8);
            this.f3343e.setVisibility(0);
            this.f3344f.setVisibility(8);
            bringChildToFront(this.f3343e);
            this.f3345g = true;
            this.f3343e.setAutoplay(this.f3346h);
            this.f3343e.setIsAutoPlayFromServer(c1903l.m5425p());
            if (a != null) {
                this.f3343e.setImage(a);
            }
            this.f3343e.m5266a(c1903l.m5424o(), c1903l.m5427r());
            this.f3343e.setVideoMPD(n);
            this.f3343e.setVideoURI(m);
        } else if (a != null) {
            this.f3342d.setVisibility(0);
            this.f3343e.setVisibility(8);
            this.f3344f.setVisibility(8);
            bringChildToFront(this.f3342d);
            this.f3345g = true;
            new ab(this.f3342d).m4809a(a);
        }
    }
}
