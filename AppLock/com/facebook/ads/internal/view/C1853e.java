package com.facebook.ads.internal.view;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkActivity.C1439a;
import com.facebook.ads.internal.p018m.C1730t;
import com.facebook.ads.internal.p018m.C1734w.C1733a;
import com.facebook.ads.internal.p022h.C1599g;
import com.facebook.ads.internal.view.C1523c.C1436a;
import com.facebook.ads.internal.view.p037a.C1742a;
import com.facebook.ads.internal.view.p037a.C1742a.C1741a;
import com.facebook.ads.internal.view.p037a.C1743b;
import com.facebook.ads.internal.view.p037a.C1749d;
import com.facebook.ads.internal.view.p037a.C1749d.C1747a;

@TargetApi(19)
public class C1853e implements C1523c {
    private static final String f4642a = C1853e.class.getSimpleName();
    private final AudienceNetworkActivity f4643b;
    private final C1742a f4644c;
    private final C1749d f4645d;
    private final C1743b f4646e;
    private final C1439a f4647f = new C18501(this);
    private String f4648g;
    private String f4649h;
    private long f4650i;
    private boolean f4651j = true;
    private long f4652k = -1;
    private boolean f4653l = true;

    class C18501 implements C1439a {
        final /* synthetic */ C1853e f4638a;

        C18501(C1853e c1853e) {
            this.f4638a = c1853e;
        }

        public boolean mo2619a() {
            if (!this.f4638a.f4645d.canGoBack()) {
                return false;
            }
            this.f4638a.f4645d.goBack();
            return true;
        }
    }

    class C18523 implements C1747a {
        final /* synthetic */ C1853e f4641a;

        C18523(C1853e c1853e) {
            this.f4641a = c1853e;
        }

        public void mo2815a(int i) {
            if (this.f4641a.f4651j) {
                this.f4641a.f4646e.setProgress(i);
            }
        }

        public void mo2816a(String str) {
            this.f4641a.f4651j = true;
            this.f4641a.f4644c.setUrl(str);
        }

        public void mo2817b(String str) {
            this.f4641a.f4644c.setTitle(str);
        }

        public void mo2818c(String str) {
            this.f4641a.f4646e.setProgress(100);
            this.f4641a.f4651j = false;
        }
    }

    public C1853e(final AudienceNetworkActivity audienceNetworkActivity, C1436a c1436a) {
        this.f4643b = audienceNetworkActivity;
        int i = (int) (2.0f * audienceNetworkActivity.getResources().getDisplayMetrics().density);
        this.f4644c = new C1742a(audienceNetworkActivity);
        this.f4644c.setId(View.generateViewId());
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        this.f4644c.setLayoutParams(layoutParams);
        this.f4644c.setListener(new C1741a(this) {
            final /* synthetic */ C1853e f4640b;

            public void mo2814a() {
                audienceNetworkActivity.finish();
            }
        });
        c1436a.mo2616a(this.f4644c);
        this.f4645d = new C1749d(audienceNetworkActivity);
        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, this.f4644c.getId());
        layoutParams.addRule(12);
        this.f4645d.setLayoutParams(layoutParams);
        this.f4645d.setListener(new C18523(this));
        c1436a.mo2616a(this.f4645d);
        this.f4646e = new C1743b(audienceNetworkActivity, null, 16842872);
        layoutParams = new RelativeLayout.LayoutParams(-1, i);
        layoutParams.addRule(3, this.f4644c.getId());
        this.f4646e.setLayoutParams(layoutParams);
        this.f4646e.setProgress(0);
        c1436a.mo2616a(this.f4646e);
        audienceNetworkActivity.m3720a(this.f4647f);
    }

    public void mo2715a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        if (this.f4652k < 0) {
            this.f4652k = System.currentTimeMillis();
        }
        if (bundle == null) {
            this.f4648g = intent.getStringExtra("browserURL");
            this.f4649h = intent.getStringExtra("clientToken");
            this.f4650i = intent.getLongExtra("handlerTime", -1);
        } else {
            this.f4648g = bundle.getString("browserURL");
            this.f4649h = bundle.getString("clientToken");
            this.f4650i = bundle.getLong("handlerTime", -1);
        }
        String str = this.f4648g != null ? this.f4648g : "about:blank";
        this.f4644c.setUrl(str);
        this.f4645d.loadUrl(str);
    }

    public void mo2716a(Bundle bundle) {
        bundle.putString("browserURL", this.f4648g);
    }

    public void mo2717a(C1436a c1436a) {
    }

    public void mo2680b() {
        this.f4643b.m3721b(this.f4647f);
        C1730t.m4978a(this.f4645d);
        this.f4645d.destroy();
    }

    public void mo2719i() {
        this.f4645d.onPause();
        if (this.f4653l) {
            this.f4653l = false;
            C1599g.m4464a(this.f4643b).m4473a(this.f4649h, new C1733a(this.f4645d.getFirstUrl()).m4984a(this.f4650i).m4986b(this.f4652k).m4987c(this.f4645d.getResponseEndMs()).m4988d(this.f4645d.getDomContentLoadedMs()).m4989e(this.f4645d.getScrollReadyMs()).m4990f(this.f4645d.getLoadFinishMs()).m4991g(System.currentTimeMillis()).m4985a());
        }
    }

    public void mo2720j() {
        this.f4645d.onResume();
    }
}
