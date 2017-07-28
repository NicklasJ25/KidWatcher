package com.google.android.gms.internal;

import com.google.android.gms.ads.reward.RewardItem;

@wh
public class xv implements RewardItem {
    private final xr f11445a;

    public xv(xr xrVar) {
        this.f11445a = xrVar;
    }

    public int getAmount() {
        int i = 0;
        if (this.f11445a != null) {
            try {
                i = this.f11445a.mo4196b();
            } catch (Throwable e) {
                aad.m8424c("Could not forward getAmount to RewardItem", e);
            }
        }
        return i;
    }

    public String getType() {
        String str = null;
        if (this.f11445a != null) {
            try {
                str = this.f11445a.mo4195a();
            } catch (Throwable e) {
                aad.m8424c("Could not forward getType to RewardItem", e);
            }
        }
        return str;
    }
}
