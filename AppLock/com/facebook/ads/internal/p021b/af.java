package com.facebook.ads.internal.p021b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.ads.C1460d;
import com.facebook.ads.internal.C1674k;

public class af extends BroadcastReceiver {
    private String f3490a;
    private ae f3491b;
    private ad f3492c;

    public af(String str, ad adVar, ae aeVar) {
        this.f3492c = adVar;
        this.f3491b = aeVar;
        this.f3490a = str;
    }

    public IntentFilter m3921a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(C1674k.REWARDED_VIDEO_COMPLETE.m4769a(this.f3490a));
        intentFilter.addAction(C1674k.REWARDED_VIDEO_ERROR.m4769a(this.f3490a));
        intentFilter.addAction(C1674k.REWARDED_VIDEO_AD_CLICK.m4769a(this.f3490a));
        intentFilter.addAction(C1674k.REWARDED_VIDEO_IMPRESSION.m4769a(this.f3490a));
        intentFilter.addAction(C1674k.REWARDED_VIDEO_CLOSED.m4769a(this.f3490a));
        intentFilter.addAction(C1674k.REWARD_SERVER_SUCCESS.m4769a(this.f3490a));
        intentFilter.addAction(C1674k.REWARD_SERVER_FAILED.m4769a(this.f3490a));
        return intentFilter;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (C1674k.REWARDED_VIDEO_COMPLETE.m4769a(this.f3490a).equals(action)) {
            this.f3491b.mo2648d(this.f3492c);
        } else if (C1674k.REWARDED_VIDEO_ERROR.m4769a(this.f3490a).equals(action)) {
            this.f3491b.mo2645a(this.f3492c, C1460d.f3367e);
        } else if (C1674k.REWARDED_VIDEO_AD_CLICK.m4769a(this.f3490a).equals(action)) {
            this.f3491b.mo2646b(this.f3492c);
        } else if (C1674k.REWARDED_VIDEO_IMPRESSION.m4769a(this.f3490a).equals(action)) {
            this.f3491b.mo2647c(this.f3492c);
        } else if (C1674k.REWARDED_VIDEO_CLOSED.m4769a(this.f3490a).equals(action)) {
            this.f3491b.mo2643a();
        } else if (C1674k.REWARD_SERVER_FAILED.m4769a(this.f3490a).equals(action)) {
            this.f3491b.mo2649e(this.f3492c);
        } else if (C1674k.REWARD_SERVER_SUCCESS.m4769a(this.f3490a).equals(action)) {
            this.f3491b.mo2650f(this.f3492c);
        }
    }
}
