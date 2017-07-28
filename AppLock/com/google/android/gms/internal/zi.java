package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzw;

@wh
public class zi extends Handler {
    public zi(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Throwable e) {
            zzw.zzcQ().m15000a(e, "AdMobHandler.handleMessage");
        }
    }
}
