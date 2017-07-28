package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.bm;
import com.google.android.gms.internal.vf.C2353a;
import com.google.android.gms.internal.wh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@wh
public class zzd extends C2353a {
    private String f6887a;
    private Context f6888b;
    private String f6889c;
    private ArrayList<String> f6890d;

    public zzd(String str, ArrayList<String> arrayList, Context context, String str2) {
        this.f6889c = str;
        this.f6890d = arrayList;
        this.f6887a = str2;
        this.f6888b = context;
    }

    protected int m7453a(int i) {
        return i == 0 ? 1 : i == 1 ? 2 : i == 4 ? 3 : 0;
    }

    Map<String, String> m7454a() {
        String packageName = this.f6888b.getPackageName();
        Object obj = "";
        try {
            obj = bm.m9120b(this.f6888b).m9118b(packageName, 0).versionName;
        } catch (Throwable e) {
            aad.m8424c("Error to retrieve app version", e);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - zzw.zzcQ().m15015e().m15039a();
        Map<String, String> hashMap = new HashMap();
        hashMap.put("sessionid", zzw.zzcQ().m14989a());
        hashMap.put("appid", packageName);
        hashMap.put("osversion", String.valueOf(VERSION.SDK_INT));
        hashMap.put("sdkversion", this.f6887a);
        hashMap.put("appversion", obj);
        hashMap.put("timestamp", String.valueOf(elapsedRealtime));
        return hashMap;
    }

    void m7455b() {
        try {
            this.f6888b.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke(null, new Object[]{this.f6888b, this.f6889c, "", Boolean.valueOf(true)});
        } catch (ClassNotFoundException e) {
            aad.m8426e("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            aad.m8426e("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Throwable e3) {
            aad.m8424c("Fail to report a conversion.", e3);
        }
    }

    public String getProductId() {
        return this.f6889c;
    }

    public void recordPlayBillingResolution(int i) {
        if (i == 0) {
            m7455b();
        }
        Map a = m7454a();
        a.put("google_play_status", String.valueOf(i));
        a.put("sku", this.f6889c);
        a.put("status", String.valueOf(m7453a(i)));
        List linkedList = new LinkedList();
        Iterator it = this.f6890d.iterator();
        while (it.hasNext()) {
            linkedList.add(zzw.zzcM().m15110a((String) it.next(), a));
        }
        zzw.zzcM().m15121a(this.f6888b, this.f6887a, linkedList);
    }

    public void recordResolution(int i) {
        if (i == 1) {
            m7455b();
        }
        Map a = m7454a();
        a.put("status", String.valueOf(i));
        a.put("sku", this.f6889c);
        List linkedList = new LinkedList();
        Iterator it = this.f6890d.iterator();
        while (it.hasNext()) {
            linkedList.add(zzw.zzcM().m15110a((String) it.next(), a));
        }
        zzw.zzcM().m15121a(this.f6888b, this.f6887a, linkedList);
    }
}
