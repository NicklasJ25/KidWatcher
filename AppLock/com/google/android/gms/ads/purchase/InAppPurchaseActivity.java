package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.ol;
import com.google.android.gms.internal.vh;

public class InAppPurchaseActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.purchase.InAppPurchaseActivity";
    public static final String SIMPLE_CLASS_NAME = "InAppPurchaseActivity";
    private vh f7148a;

    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (this.f7148a != null) {
                this.f7148a.onActivityResult(i, i2, intent);
            }
        } catch (Throwable e) {
            aad.m8424c("Could not forward onActivityResult to in-app purchase manager:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7148a = ol.m12981b().m12974a((Activity) this);
        if (this.f7148a == null) {
            aad.m8426e("Could not create in-app purchase manager.");
            finish();
            return;
        }
        try {
            this.f7148a.onCreate();
        } catch (Throwable e) {
            aad.m8424c("Could not forward onCreate to in-app purchase manager:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.f7148a != null) {
                this.f7148a.onDestroy();
            }
        } catch (Throwable e) {
            aad.m8424c("Could not forward onDestroy to in-app purchase manager:", e);
        }
        super.onDestroy();
    }
}
