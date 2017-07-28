package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.internal.oy.C2397a;
import com.google.android.gms.internal.oz.C3139a;
import com.google.android.gms.p065a.C2312b;
import com.google.android.gms.p065a.C2314c;

@wh
public class pj extends C2314c<oz> {
    public pj() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    protected /* synthetic */ Object mo3832a(IBinder iBinder) {
        return m13157b(iBinder);
    }

    public oy m13156b(Context context) {
        try {
            return C2397a.zzu(((oz) m7329a(context)).mo3868a(C2312b.m7327a((Object) context), 10260000));
        } catch (Throwable e) {
            aad.m8424c("Could not get remote MobileAdsSettingManager.", e);
            return null;
        } catch (Throwable e2) {
            aad.m8424c("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }

    protected oz m13157b(IBinder iBinder) {
        return C3139a.m13006a(iBinder);
    }
}
