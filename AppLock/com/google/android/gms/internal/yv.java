package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.C2482c;
import com.google.android.gms.common.C2484d;
import java.io.IOException;

@wh
public final class yv implements yx {
    public aaj<Info> mo4244a(final Context context) {
        final aaj com_google_android_gms_internal_aag = new aag();
        if (ol.m12979a().m8415d(context)) {
            zk.m15079a(new Runnable(this) {
                public void run() {
                    Throwable e;
                    try {
                        com_google_android_gms_internal_aag.m8436b(AdvertisingIdClient.getAdvertisingIdInfo(context));
                        return;
                    } catch (IOException e2) {
                        e = e2;
                    } catch (IllegalStateException e3) {
                        e = e3;
                    } catch (C2482c e4) {
                        e = e4;
                    } catch (C2484d e5) {
                        e = e5;
                    }
                    com_google_android_gms_internal_aag.m8435a(e);
                    aad.m8422b("Exception while getting advertising Id info", e);
                }
            });
        }
        return com_google_android_gms_internal_aag;
    }

    public aaj<String> mo4245a(zzmk com_google_android_gms_internal_zzmk) {
        return new aah(com_google_android_gms_internal_zzmk.f11999h);
    }
}
