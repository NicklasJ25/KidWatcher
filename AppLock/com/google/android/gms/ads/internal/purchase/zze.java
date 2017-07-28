package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.view.PointerIconCompat;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.stats.C2574a;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.vf;
import com.google.android.gms.internal.vh.C2354a;
import com.google.android.gms.internal.wh;

@wh
public class zze extends C2354a implements ServiceConnection {
    zzh f6891a;
    private final Activity f6892b;
    private Context f6893c;
    private vf f6894d;
    private zzb f6895e;
    private zzf f6896f;
    private zzj f6897g;
    private zzk f6898h;
    private String f6899i = null;

    public zze(Activity activity) {
        this.f6892b = activity;
        this.f6891a = zzh.zzu(this.f6892b.getApplicationContext());
    }

    protected void m7456a(String str, boolean z, int i, Intent intent) {
        if (this.f6897g != null) {
            this.f6897g.zza(str, z, i, intent, this.f6896f);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == PointerIconCompat.TYPE_CONTEXT_MENU) {
            boolean z = false;
            try {
                int zzd = zzw.zzda().zzd(intent);
                if (i2 == -1) {
                    zzw.zzda();
                    if (zzd == 0) {
                        if (this.f6898h.zza(this.f6899i, i2, intent)) {
                            z = true;
                        }
                        this.f6894d.recordPlayBillingResolution(zzd);
                        this.f6892b.finish();
                        m7456a(this.f6894d.getProductId(), z, i2, intent);
                    }
                }
                this.f6891a.zza(this.f6896f);
                this.f6894d.recordPlayBillingResolution(zzd);
                this.f6892b.finish();
                m7456a(this.f6894d.getProductId(), z, i2, intent);
            } catch (RemoteException e) {
                aad.m8426e("Fail to process purchase result.");
                this.f6892b.finish();
            } finally {
                this.f6899i = null;
            }
        }
    }

    public void onCreate() {
        GInAppPurchaseManagerInfoParcel zzc = GInAppPurchaseManagerInfoParcel.zzc(this.f6892b.getIntent());
        this.f6897g = zzc.zzPp;
        this.f6898h = zzc.zzvL;
        this.f6894d = zzc.zzPn;
        this.f6895e = new zzb(this.f6892b.getApplicationContext());
        this.f6893c = zzc.zzPo;
        if (this.f6892b.getResources().getConfiguration().orientation == 2) {
            this.f6892b.setRequestedOrientation(zzw.zzcO().mo4247a());
        } else {
            this.f6892b.setRequestedOrientation(zzw.zzcO().mo4249b());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        C2574a.m8252a().m8256a(this.f6892b, intent, (ServiceConnection) this, 1);
    }

    public void onDestroy() {
        C2574a.m8252a().m8254a(this.f6892b, (ServiceConnection) this);
        this.f6895e.destroy();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Throwable e;
        this.f6895e.zzV(iBinder);
        try {
            this.f6899i = this.f6898h.zziM();
            Bundle zza = this.f6895e.zza(this.f6892b.getPackageName(), this.f6894d.getProductId(), this.f6899i);
            PendingIntent pendingIntent = (PendingIntent) zza.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int zzd = zzw.zzda().zzd(zza);
                this.f6894d.recordPlayBillingResolution(zzd);
                m7456a(this.f6894d.getProductId(), false, zzd, null);
                this.f6892b.finish();
                return;
            }
            this.f6896f = new zzf(this.f6894d.getProductId(), this.f6899i);
            this.f6891a.zzb(this.f6896f);
            this.f6892b.startIntentSenderForResult(pendingIntent.getIntentSender(), PointerIconCompat.TYPE_CONTEXT_MENU, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        } catch (RemoteException e2) {
            e = e2;
            aad.m8424c("Error when connecting in-app billing service", e);
            this.f6892b.finish();
        } catch (SendIntentException e3) {
            e = e3;
            aad.m8424c("Error when connecting in-app billing service", e);
            this.f6892b.finish();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        aad.m8425d("In-app billing service disconnected.");
        this.f6895e.destroy();
    }
}
