package com.facebook.ads.internal.p021b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.ads.internal.view.C1865h;
import com.facebook.ads.internal.view.p035c.p036a.C1758b;
import com.facebook.ads.internal.view.p035c.p036a.C1762f;
import com.facebook.ads.internal.view.p035c.p036a.C1763g;
import com.facebook.ads.internal.view.p035c.p036a.C1764h;
import com.facebook.ads.internal.view.p035c.p036a.C1766j;
import com.facebook.ads.internal.view.p035c.p036a.C1771p;
import java.io.Serializable;

public class C1494g extends BroadcastReceiver {
    private Context f3493a;
    private C1865h f3494b;
    private boolean f3495c = false;

    public C1494g(C1865h c1865h, Context context) {
        this.f3494b = c1865h;
        this.f3493a = context;
    }

    public void m3927a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.ads.interstitial.displayed:" + this.f3494b.getUniqueId());
        intentFilter.addAction("videoInterstitalEvent:" + this.f3494b.getUniqueId());
        LocalBroadcastManager.getInstance(this.f3493a).registerReceiver(this, intentFilter);
    }

    public void m3928b() {
        try {
            LocalBroadcastManager.getInstance(this.f3493a).unregisterReceiver(this);
        } catch (Exception e) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        String[] split = intent.getAction().split(":");
        if (split.length != 2 || !split[1].equals(this.f3494b.getUniqueId())) {
            return;
        }
        if (split[0].equals("com.facebook.ads.interstitial.displayed")) {
            if (this.f3494b.getListener() != null) {
                this.f3494b.getListener().mo2632g();
                this.f3494b.getListener().mo2626a();
            }
        } else if (split[0].equals("videoInterstitalEvent")) {
            Serializable serializableExtra = intent.getSerializableExtra("event");
            if (serializableExtra instanceof C1771p) {
                if (this.f3494b.getListener() != null) {
                    this.f3494b.getListener().mo2631f();
                    this.f3494b.getListener().mo2626a();
                }
                if (this.f3495c) {
                    this.f3494b.m5248a(1);
                } else {
                    this.f3494b.m5248a(((C1771p) serializableExtra).m5047b());
                }
                this.f3494b.setVisibility(0);
                this.f3494b.mo2828d();
            } else if (serializableExtra instanceof C1762f) {
                if (this.f3494b.getListener() != null) {
                    this.f3494b.getListener().mo2629d();
                }
            } else if (serializableExtra instanceof C1763g) {
                if (this.f3494b.getListener() != null) {
                    this.f3494b.getListener().mo2630e();
                }
            } else if (serializableExtra instanceof C1758b) {
                if (this.f3494b.getListener() != null) {
                    this.f3494b.getListener().mo2633h();
                }
                this.f3495c = true;
            } else if (serializableExtra instanceof C1766j) {
                if (this.f3494b.getListener() != null) {
                    this.f3494b.getListener().mo2628c();
                }
                this.f3495c = false;
            } else if ((serializableExtra instanceof C1764h) && this.f3494b.getListener() != null) {
                this.f3494b.getListener().mo2627b();
            }
        }
    }
}
