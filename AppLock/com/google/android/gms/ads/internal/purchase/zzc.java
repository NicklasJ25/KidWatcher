package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.stats.C2574a;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.vk;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.zg;
import com.google.android.gms.internal.zh;
import com.google.android.gms.internal.zl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@wh
public class zzc extends zg implements ServiceConnection {
    private final Object f6879a;
    private boolean f6880b;
    private Context f6881c;
    private vk f6882d;
    private zzb f6883e;
    private zzh f6884f;
    private List<zzf> f6885g;
    private zzk f6886h;

    public zzc(Context context, vk vkVar, zzk com_google_android_gms_ads_internal_purchase_zzk) {
        this(context, vkVar, com_google_android_gms_ads_internal_purchase_zzk, new zzb(context), zzh.zzu(context.getApplicationContext()));
    }

    zzc(Context context, vk vkVar, zzk com_google_android_gms_ads_internal_purchase_zzk, zzb com_google_android_gms_ads_internal_purchase_zzb, zzh com_google_android_gms_ads_internal_purchase_zzh) {
        this.f6879a = new Object();
        this.f6880b = false;
        this.f6885g = null;
        this.f6881c = context;
        this.f6882d = vkVar;
        this.f6886h = com_google_android_gms_ads_internal_purchase_zzk;
        this.f6883e = com_google_android_gms_ads_internal_purchase_zzb;
        this.f6884f = com_google_android_gms_ads_internal_purchase_zzh;
        this.f6885g = this.f6884f.zzg(10);
    }

    private void m7447a(long j) {
        do {
            if (!m7449b(j)) {
                zh.m15051a("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.f6880b);
    }

    private boolean m7449b(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.f6879a.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            aad.m8426e("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    protected void m7451a() {
        if (!this.f6885g.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (zzf com_google_android_gms_ads_internal_purchase_zzf : this.f6885g) {
                hashMap.put(com_google_android_gms_ads_internal_purchase_zzf.zzPI, com_google_android_gms_ads_internal_purchase_zzf);
            }
            String str = null;
            while (true) {
                Bundle zzn = this.f6883e.zzn(this.f6881c.getPackageName(), str);
                if (zzn == null || zzw.zzda().zzd(zzn) != 0) {
                    break;
                }
                ArrayList stringArrayList = zzn.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList stringArrayList2 = zzn.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList stringArrayList3 = zzn.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                String string = zzn.getString("INAPP_CONTINUATION_TOKEN");
                for (int i = 0; i < stringArrayList.size(); i++) {
                    if (hashMap.containsKey(stringArrayList.get(i))) {
                        str = (String) stringArrayList.get(i);
                        String str2 = (String) stringArrayList2.get(i);
                        String str3 = (String) stringArrayList3.get(i);
                        zzf com_google_android_gms_ads_internal_purchase_zzf2 = (zzf) hashMap.get(str);
                        if (com_google_android_gms_ads_internal_purchase_zzf2.zzPH.equals(zzw.zzda().zzaE(str2))) {
                            m7452a(com_google_android_gms_ads_internal_purchase_zzf2, str2, str3);
                            hashMap.remove(str);
                        }
                    }
                }
                if (string == null || hashMap.isEmpty()) {
                    break;
                }
                str = string;
            }
            for (String str4 : hashMap.keySet()) {
                this.f6884f.zza((zzf) hashMap.get(str4));
            }
        }
    }

    protected void m7452a(final zzf com_google_android_gms_ads_internal_purchase_zzf, String str, String str2) {
        final Intent intent = new Intent();
        zzw.zzda();
        intent.putExtra("RESPONSE_CODE", 0);
        zzw.zzda();
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        zzw.zzda();
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        zl.f11678a.post(new Runnable(this) {
            final /* synthetic */ zzc f6878c;

            public void run() {
                try {
                    if (this.f6878c.f6886h.zza(com_google_android_gms_ads_internal_purchase_zzf.zzPH, -1, intent)) {
                        this.f6878c.f6882d.mo4161a(new zzg(this.f6878c.f6881c, com_google_android_gms_ads_internal_purchase_zzf.zzPI, true, -1, intent, com_google_android_gms_ads_internal_purchase_zzf));
                    } else {
                        this.f6878c.f6882d.mo4161a(new zzg(this.f6878c.f6881c, com_google_android_gms_ads_internal_purchase_zzf.zzPI, false, -1, intent, com_google_android_gms_ads_internal_purchase_zzf));
                    }
                } catch (RemoteException e) {
                    aad.m8426e("Fail to verify and dispatch pending transaction");
                }
            }
        });
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f6879a) {
            this.f6883e.zzV(iBinder);
            m7451a();
            this.f6880b = true;
            this.f6879a.notify();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        aad.m8425d("In-app billing service disconnected.");
        this.f6883e.destroy();
    }

    public void onStop() {
        synchronized (this.f6879a) {
            C2574a.m8252a().m8254a(this.f6881c, (ServiceConnection) this);
            this.f6883e.destroy();
        }
    }

    public void zzco() {
        synchronized (this.f6879a) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            C2574a.m8252a().m8256a(this.f6881c, intent, (ServiceConnection) this, 1);
            m7447a(SystemClock.elapsedRealtime());
            C2574a.m8252a().m8254a(this.f6881c, (ServiceConnection) this);
            this.f6883e.destroy();
        }
    }
}
