package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.stats.C2574a;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.vj.C2355a;
import com.google.android.gms.internal.wh;

@wh
public final class zzg extends C2355a implements ServiceConnection {
    zzb f6900a;
    private boolean f6901b = false;
    private Context f6902c;
    private int f6903d;
    private Intent f6904e;
    private zzf f6905f;
    private String f6906g;

    public zzg(Context context, String str, boolean z, int i, Intent intent, zzf com_google_android_gms_ads_internal_purchase_zzf) {
        this.f6906g = str;
        this.f6903d = i;
        this.f6904e = intent;
        this.f6901b = z;
        this.f6902c = context;
        this.f6905f = com_google_android_gms_ads_internal_purchase_zzf;
    }

    public void finishPurchase() {
        int zzd = zzw.zzda().zzd(this.f6904e);
        if (this.f6903d == -1 && zzd == 0) {
            this.f6900a = new zzb(this.f6902c);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            C2574a.m8252a().m8256a(this.f6902c, intent, (ServiceConnection) this, 1);
        }
    }

    public String getProductId() {
        return this.f6906g;
    }

    public Intent getPurchaseData() {
        return this.f6904e;
    }

    public int getResultCode() {
        return this.f6903d;
    }

    public boolean isVerified() {
        return this.f6901b;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        aad.m8425d("In-app billing service connected.");
        this.f6900a.zzV(iBinder);
        String zzaF = zzw.zzda().zzaF(zzw.zzda().zze(this.f6904e));
        if (zzaF != null) {
            if (this.f6900a.zzm(this.f6902c.getPackageName(), zzaF) == 0) {
                zzh.zzu(this.f6902c).zza(this.f6905f);
            }
            C2574a.m8252a().m8254a(this.f6902c, (ServiceConnection) this);
            this.f6900a.destroy();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        aad.m8425d("In-app billing service disconnected.");
        this.f6900a.destroy();
    }
}
