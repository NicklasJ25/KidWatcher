package com.domobile.applock;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.domobile.applock.service.LockService;
import com.domobile.libs_ads.AdmobInterstitialActivity;
import com.domobile.libs_ads.C1342b;

public class TargetAdmobInterstitialActivity extends AdmobInterstitialActivity {
    private int f543d = 2000;
    private Handler f544e = new C06091(this);

    class C06091 extends Handler {
        final /* synthetic */ TargetAdmobInterstitialActivity f539a;

        C06091(TargetAdmobInterstitialActivity targetAdmobInterstitialActivity) {
            this.f539a = targetAdmobInterstitialActivity;
        }

        public void handleMessage(Message message) {
            if (this.f539a.c == 1) {
                if (this.f539a.b == null) {
                    this.f539a.finish();
                } else if (!this.f539a.b.m3796b()) {
                    this.f539a.finish();
                }
            } else if (this.f539a.a == null) {
                this.f539a.finish();
            } else if (!this.f539a.a.isLoaded()) {
                this.f539a.finish();
            }
        }
    }

    public boolean mo2368a() {
        this.f544e.sendEmptyMessageDelayed(0, (long) this.f543d);
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
        return isFinishing();
    }

    public boolean mo2373e() {
        return false;
    }

    public void mo2374f() {
        C1150y b = C1150y.m2598b((Context) this);
        this.f544e.removeMessages(0);
        LockService.m2165a((Context) this, b);
    }

    public void finish() {
        super.finish();
        this.f544e.removeMessages(0);
    }

    public void onBackPressed() {
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f543d = C1342b.m3318a((Context) this, "max_interstitial_load_mills", 2000);
    }
}
