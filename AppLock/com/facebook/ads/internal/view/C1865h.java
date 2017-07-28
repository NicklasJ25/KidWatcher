package com.facebook.ads.internal.view;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkActivity.C1449b;
import com.facebook.ads.C1467i;
import com.facebook.ads.internal.p018m.C1708d;
import com.facebook.ads.internal.p018m.C1722n;
import com.facebook.ads.internal.p018m.C1723o;
import com.facebook.ads.internal.p021b.C1494g;
import com.facebook.ads.internal.p022h.C1597f;
import com.facebook.ads.internal.p034k.C1671a;
import com.facebook.ads.internal.p034k.C1671a.C1669a;
import com.facebook.ads.internal.view.p035c.p036a.C1701m;
import com.facebook.ads.internal.view.p035c.p036a.C1758b;
import com.facebook.ads.internal.view.p035c.p036a.C1759c;
import com.facebook.ads.internal.view.p035c.p036a.C1764h;
import com.facebook.ads.internal.view.p035c.p036a.C1765i;
import com.facebook.ads.internal.view.p035c.p036a.C1766j;
import com.facebook.ads.internal.view.p035c.p036a.C1767k;
import com.facebook.ads.internal.view.p035c.p036a.C1768l;
import com.facebook.ads.internal.view.p035c.p039b.C1784m;
import com.facebook.ads.internal.view.p035c.p039b.C1808f;
import com.facebook.ads.internal.view.p035c.p039b.C1813g;
import com.facebook.ads.internal.view.p035c.p040c.C1847d;
import java.util.UUID;

public class C1865h extends C1864k {
    static final /* synthetic */ boolean f4693a = (!C1865h.class.desiredAssertionStatus());
    private final C1767k f4694c = new C18581(this);
    private final C1765i f4695d = new C18592(this);
    private final C1701m f4696e = new C18613(this);
    private final C1759c f4697f = new C18624(this);
    private final String f4698g = UUID.randomUUID().toString();
    private final C1597f f4699h;
    private final C1671a f4700i;
    private final C1494g f4701j;
    private final C1808f f4702k;
    @Nullable
    private C1708d f4703l;
    @Nullable
    private String f4704m;
    @Nullable
    private Uri f4705n;
    @Nullable
    private String f4706o;
    @Nullable
    private String f4707p;
    @Nullable
    private C1450i f4708q;
    private boolean f4709r = false;

    class C18581 extends C1767k {
        final /* synthetic */ C1865h f4666a;

        C18581(C1865h c1865h) {
            this.f4666a = c1865h;
        }

        public void m5235a(C1766j c1766j) {
            if (this.f4666a.f4708q != null) {
                this.f4666a.f4708q.mo2628c();
            }
        }
    }

    class C18592 extends C1765i {
        final /* synthetic */ C1865h f4667a;

        C18592(C1865h c1865h) {
            this.f4667a = c1865h;
        }

        public void m5237a(C1764h c1764h) {
            if (this.f4667a.f4708q != null) {
                this.f4667a.f4708q.mo2627b();
            }
        }
    }

    class C18613 extends C1701m {
        final /* synthetic */ C1865h f4669a;

        class C18601 implements OnTouchListener {
            final /* synthetic */ C18613 f4668a;

            C18601(C18613 c18613) {
                this.f4668a = c18613;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    this.f4668a.f4669a.m5264k();
                }
                return true;
            }
        }

        C18613(C1865h c1865h) {
            this.f4669a = c1865h;
        }

        public void m5239a(C1768l c1768l) {
            if (this.f4669a.m5260i()) {
                this.f4669a.mo2828d();
            }
            this.f4669a.setOnTouchListener(new C18601(this));
        }
    }

    class C18624 extends C1759c {
        final /* synthetic */ C1865h f4670a;

        C18624(C1865h c1865h) {
            this.f4670a = c1865h;
        }

        public void m5241a(C1758b c1758b) {
            if (this.f4670a.f4708q != null) {
                this.f4670a.f4708q.mo2633h();
            }
        }
    }

    class C18635 extends C1669a {
        final /* synthetic */ C1865h f4671a;

        C18635(C1865h c1865h) {
            this.f4671a = c1865h;
        }

        public void mo2782a() {
            if ((this.f4671a.m5260i() || this.f4671a.b.getTargetState() == C1847d.STARTED) && this.f4671a.b.getTargetState() != C1847d.PAUSED) {
                this.f4671a.mo2828d();
            }
        }

        public void mo2819b() {
            this.f4671a.m5256e();
        }
    }

    public C1865h(Context context, C1597f c1597f) {
        super(context);
        this.f4699h = c1597f;
        getEventBus().m4513a(this.f4694c);
        getEventBus().m4513a(this.f4695d);
        getEventBus().m4513a(this.f4697f);
        setAutoplay(true);
        setVolume(0.0f);
        this.f4702k = new C1808f(context);
        m5250a(this.f4702k);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        C1784m c1813g = new C1813g(context);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(12);
        c1813g.setPadding((int) (displayMetrics.density * 2.0f), (int) (displayMetrics.density * 25.0f), (int) (displayMetrics.density * 25.0f), (int) (displayMetrics.density * 2.0f));
        c1813g.setLayoutParams(layoutParams);
        m5250a(c1813g);
        getEventBus().m4513a(this.f4696e);
        this.f4701j = new C1494g(this, getContext());
        this.f4700i = new C1671a(this, 50, true, new C18635(this));
        this.f4700i.m4759a(0);
        this.f4700i.m4762b((int) Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    }

    private void m5262a(Context context, Intent intent) {
        if (!f4693a && this.f4704m == null) {
            throw new AssertionError();
        } else if (!f4693a && this.f4705n == null && this.f4707p == null) {
            throw new AssertionError();
        } else {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
            intent.putExtra("useNativeCloseButton", true);
            intent.putExtra("viewType", C1449b.VIDEO);
            intent.putExtra("videoURL", this.f4705n.toString());
            intent.putExtra("clientToken", this.f4706o == null ? "" : this.f4706o);
            intent.putExtra("videoMPD", this.f4707p);
            intent.putExtra("videoReportURL", this.f4704m);
            intent.putExtra("predefinedOrientationKey", 13);
            intent.putExtra("autoplay", mo2822a());
            intent.putExtra("videoSeekTime", getCurrentPosition());
            intent.putExtra("uniqueId", this.f4698g);
            intent.putExtra("videoLogger", this.f4703l.m4909k());
            intent.addFlags(268435456);
        }
    }

    private void m5264k() {
        Context context = getContext();
        Intent intent = new Intent(context, AudienceNetworkActivity.class);
        m5262a(context, intent);
        try {
            m5256e();
            setVisibility(8);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            try {
                intent.setClass(context, C1467i.class);
                context.startActivity(intent);
            } catch (Throwable e2) {
                C1723o.m4943a(C1722n.m4940a(e2, "Error occurred while loading fullscreen video activity."));
            }
        } catch (Throwable e22) {
            C1723o.m4943a(C1722n.m4940a(e22, "Error occurred while loading fullscreen video activity."));
        }
    }

    private void m5265l() {
        if (getVisibility() == 0 && this.f4709r) {
            this.f4700i.m4758a();
        } else {
            this.f4700i.m4761b();
        }
    }

    public void m5266a(String str, @Nullable String str2) {
        if (this.f4703l != null) {
            this.f4703l.m4914a();
        }
        if (str2 == null) {
            str2 = "";
        }
        this.f4703l = new C1708d(getContext(), this.f4699h, this, str2);
        this.f4706o = str2;
        this.f4704m = str;
    }

    public void mo2828d() {
        if (C1671a.m4743a((View) this, 50).m4763a()) {
            super.mo2828d();
        }
    }

    @Nullable
    public C1450i getListener() {
        return this.f4708q;
    }

    public String getUniqueId() {
        return this.f4698g;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4709r = true;
        this.f4701j.m3927a();
        m5265l();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4709r = false;
        this.f4701j.m3928b();
        m5265l();
    }

    protected void onVisibilityChanged(View view, int i) {
        m5265l();
        super.onVisibilityChanged(view, i);
    }

    public void setImage(String str) {
        this.f4702k.setImage(str);
    }

    public void setListener(@Nullable C1450i c1450i) {
        this.f4708q = c1450i;
    }

    public void setVideoMPD(String str) {
        if (f4693a || this.f4703l != null) {
            this.f4707p = str;
            super.setVideoMPD(str);
            return;
        }
        throw new AssertionError();
    }

    public void setVideoURI(Uri uri) {
        if (f4693a || this.f4703l != null) {
            this.f4705n = uri;
            super.setVideoURI(uri);
            return;
        }
        throw new AssertionError();
    }
}
