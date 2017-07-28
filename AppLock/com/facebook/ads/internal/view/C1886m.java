package com.facebook.ads.internal.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.p018m.C1708d;
import com.facebook.ads.internal.p022h.C1599g;
import com.facebook.ads.internal.view.C1523c.C1436a;
import com.facebook.ads.internal.view.p035c.p036a.C1758b;
import com.facebook.ads.internal.view.p035c.p036a.C1759c;
import com.facebook.ads.internal.view.p035c.p036a.C1760d;
import com.facebook.ads.internal.view.p035c.p036a.C1761e;
import com.facebook.ads.internal.view.p035c.p036a.C1762f;
import com.facebook.ads.internal.view.p035c.p036a.C1763g;
import com.facebook.ads.internal.view.p035c.p036a.C1764h;
import com.facebook.ads.internal.view.p035c.p036a.C1765i;
import com.facebook.ads.internal.view.p035c.p036a.C1766j;
import com.facebook.ads.internal.view.p035c.p036a.C1767k;
import com.facebook.ads.internal.view.p035c.p036a.C1771p;
import com.facebook.ads.internal.view.p035c.p039b.C1791b;

public class C1886m implements C1523c {
    private final C1761e f4761a = new C18821(this);
    private final C1767k f4762b = new C18832(this);
    private final C1765i f4763c = new C18843(this);
    private final C1759c f4764d = new C18854(this);
    private final AudienceNetworkActivity f4765e;
    private final C1864k f4766f;
    private final C1436a f4767g;
    private C1708d f4768h;
    private int f4769i;

    class C18821 extends C1761e {
        final /* synthetic */ C1886m f4757a;

        C18821(C1886m c1886m) {
            this.f4757a = c1886m;
        }

        public void m5323a(C1760d c1760d) {
            this.f4757a.f4765e.finish();
        }
    }

    class C18832 extends C1767k {
        final /* synthetic */ C1886m f4758a;

        C18832(C1886m c1886m) {
            this.f4758a = c1886m;
        }

        public void m5325a(C1766j c1766j) {
            this.f4758a.f4767g.mo2618a("videoInterstitalEvent", c1766j);
        }
    }

    class C18843 extends C1765i {
        final /* synthetic */ C1886m f4759a;

        C18843(C1886m c1886m) {
            this.f4759a = c1886m;
        }

        public void m5327a(C1764h c1764h) {
            this.f4759a.f4767g.mo2618a("videoInterstitalEvent", c1764h);
        }
    }

    class C18854 extends C1759c {
        final /* synthetic */ C1886m f4760a;

        C18854(C1886m c1886m) {
            this.f4760a = c1886m;
        }

        public void m5329a(C1758b c1758b) {
            this.f4760a.f4767g.mo2618a("videoInterstitalEvent", c1758b);
        }
    }

    public C1886m(AudienceNetworkActivity audienceNetworkActivity, C1436a c1436a) {
        this.f4765e = audienceNetworkActivity;
        this.f4766f = new C1864k(audienceNetworkActivity);
        this.f4766f.m5250a(new C1791b(audienceNetworkActivity));
        this.f4766f.getEventBus().m4513a(this.f4762b);
        this.f4766f.getEventBus().m4513a(this.f4763c);
        this.f4766f.getEventBus().m4513a(this.f4764d);
        this.f4766f.getEventBus().m4513a(this.f4761a);
        this.f4767g = c1436a;
        this.f4766f.setIsFullScreen(true);
        this.f4766f.setVolume(1.0f);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        this.f4766f.setLayoutParams(layoutParams);
        c1436a.mo2616a(this.f4766f);
    }

    public void mo2715a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        boolean booleanExtra = intent.getBooleanExtra("autoplay", false);
        String stringExtra = intent.getStringExtra("videoURL");
        String stringExtra2 = intent.getStringExtra("videoMPD");
        Bundle bundleExtra = intent.getBundleExtra("videoLogger");
        String stringExtra3 = intent.getStringExtra("clientToken");
        this.f4769i = intent.getIntExtra("videoSeekTime", 0);
        this.f4766f.setAutoplay(booleanExtra);
        this.f4768h = new C1708d(audienceNetworkActivity, C1599g.m4464a(audienceNetworkActivity.getApplicationContext()), this.f4766f, stringExtra3, bundleExtra);
        this.f4766f.setVideoMPD(stringExtra2);
        this.f4766f.setVideoURI(stringExtra);
        if (this.f4769i > 0) {
            this.f4766f.m5248a(this.f4769i);
        }
        this.f4766f.mo2828d();
    }

    public void mo2716a(Bundle bundle) {
    }

    public void m5334a(View view) {
        this.f4766f.setControlsAnchorView(view);
    }

    public void mo2717a(C1436a c1436a) {
    }

    public void mo2680b() {
        this.f4767g.mo2618a("videoInterstitalEvent", new C1771p(this.f4769i, this.f4766f.getCurrentPosition()));
        this.f4768h.m4900b(this.f4766f.getCurrentPosition());
        this.f4766f.m5258g();
    }

    public void mo2719i() {
        this.f4767g.mo2618a("videoInterstitalEvent", new C1762f());
        this.f4766f.m5256e();
    }

    public void mo2720j() {
        this.f4767g.mo2618a("videoInterstitalEvent", new C1763g());
        this.f4766f.mo2828d();
    }
}
