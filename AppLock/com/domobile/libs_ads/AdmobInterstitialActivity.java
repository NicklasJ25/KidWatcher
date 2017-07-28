package com.domobile.libs_ads;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.domobile.frame.p000a.C1258c;
import com.facebook.ads.C0665a;
import com.facebook.ads.C1453b;
import com.facebook.ads.C1460d;
import com.facebook.ads.C1466h;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;

public class AdmobInterstitialActivity extends Activity {
    protected InterstitialAd f540a;
    protected C1466h f541b;
    protected int f542c;

    class C13331 extends C0665a {
        final /* synthetic */ AdmobInterstitialActivity f2879a;

        C13331(AdmobInterstitialActivity admobInterstitialActivity) {
            this.f2879a = admobInterstitialActivity;
        }

        public void mo2390a(C1453b c1453b) {
            super.mo2390a(c1453b);
            C1258c.m2987b("Facebook onAdLoaded");
            if (!this.f2879a.mo2372d()) {
                this.f2879a.mo2374f();
                this.f2879a.f541b.m3797c();
            }
        }

        public void mo2391a(C1453b c1453b, C1460d c1460d) {
            super.mo2391a(c1453b, c1460d);
            if (!this.f2879a.mo2369a(0)) {
                this.f2879a.finish();
            }
        }

        public void mo2392b(C1453b c1453b) {
            super.mo2392b(c1453b);
            this.f2879a.mo2373e();
        }

        public void mo2393c(C1453b c1453b) {
            super.mo2393c(c1453b);
        }

        public void mo2395d(C1453b c1453b) {
            super.mo2395d(c1453b);
            if (!this.f2879a.mo2370b()) {
                this.f2879a.finish();
            }
        }

        public void mo2396e(C1453b c1453b) {
            super.mo2396e(c1453b);
        }
    }

    class C13342 extends AdListener {
        final /* synthetic */ AdmobInterstitialActivity f2880a;

        C13342(AdmobInterstitialActivity admobInterstitialActivity) {
            this.f2880a = admobInterstitialActivity;
        }

        public void onAdClosed() {
            if (!this.f2880a.mo2370b()) {
                this.f2880a.finish();
            }
        }

        public void onAdFailedToLoad(int i) {
            if (!this.f2880a.mo2369a(i)) {
                this.f2880a.finish();
            }
        }

        public void onAdLeftApplication() {
            if (!this.f2880a.mo2371c()) {
                this.f2880a.finish();
            }
        }

        public void onAdLoaded() {
            C1258c.m2987b("Google onAdLoaded");
            if (!this.f2880a.mo2372d()) {
                this.f2880a.mo2374f();
                this.f2880a.f540a.show();
            }
        }

        public void onAdOpened() {
            this.f2880a.mo2373e();
        }
    }

    private void m671g() {
        this.f541b = new C1466h(this, "970977059658692_970997496323315");
        this.f541b.m3795a(new C13331(this));
        mo2368a();
        this.f541b.m3794a();
    }

    private void m672h() {
        this.f540a = new InterstitialAd(this);
        this.f540a.setAdUnitId("ca-app-pub-4885652974540015/9196455687");
        AdRequest build = new Builder().build();
        this.f540a.setAdListener(new C13342(this));
        mo2368a();
        this.f540a.loadAd(build);
    }

    public boolean mo2368a() {
        return false;
    }

    public boolean mo2369a(int i) {
        return false;
    }

    public boolean mo2370b() {
        return false;
    }

    public boolean mo2371c() {
        return false;
    }

    public boolean mo2372d() {
        return false;
    }

    public boolean mo2373e() {
        return false;
    }

    public void mo2374f() {
    }

    public void onBackPressed() {
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View view = new View(this);
        view.setLayoutParams(new LayoutParams(-1, -1));
        setContentView(view);
        this.f542c = C1342b.m3331b(this);
        if (this.f542c == 1) {
            m671g();
        } else {
            m672h();
        }
    }
}
