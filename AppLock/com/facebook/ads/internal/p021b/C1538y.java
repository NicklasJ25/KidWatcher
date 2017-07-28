package com.facebook.ads.internal.p021b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.ads.C1460d;

public class C1538y extends BroadcastReceiver {
    private String f3713a;
    private Context f3714b;
    private C1478e f3715c;
    private C1493d f3716d;

    public C1538y(Context context, String str, C1493d c1493d, C1478e c1478e) {
        this.f3714b = context;
        this.f3713a = str;
        this.f3715c = c1478e;
        this.f3716d = c1493d;
    }

    public void m4217a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.ads.interstitial.impression.logged:" + this.f3713a);
        intentFilter.addAction("com.facebook.ads.interstitial.displayed:" + this.f3713a);
        intentFilter.addAction("com.facebook.ads.interstitial.dismissed:" + this.f3713a);
        intentFilter.addAction("com.facebook.ads.interstitial.clicked:" + this.f3713a);
        intentFilter.addAction("com.facebook.ads.interstitial.error:" + this.f3713a);
        LocalBroadcastManager.getInstance(this.f3714b).registerReceiver(this, intentFilter);
    }

    public void m4218b() {
        try {
            LocalBroadcastManager.getInstance(this.f3714b).unregisterReceiver(this);
        } catch (Exception e) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        Object obj = intent.getAction().split(":")[0];
        if (this.f3715c != null && obj != null) {
            if ("com.facebook.ads.interstitial.clicked".equals(obj)) {
                this.f3715c.mo2657a(this.f3716d, null, true);
            } else if ("com.facebook.ads.interstitial.dismissed".equals(obj)) {
                this.f3715c.mo2660d(this.f3716d);
            } else if ("com.facebook.ads.interstitial.displayed".equals(obj)) {
                this.f3715c.mo2659c(this.f3716d);
            } else if ("com.facebook.ads.interstitial.impression.logged".equals(obj)) {
                this.f3715c.mo2658b(this.f3716d);
            } else if ("com.facebook.ads.interstitial.error".equals(obj)) {
                this.f3715c.mo2656a(this.f3716d, C1460d.f3367e);
            }
        }
    }
}
