package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.oq;
import com.google.android.gms.internal.or.C2385a;
import com.google.android.gms.internal.ox;
import com.google.android.gms.internal.rn;
import com.google.android.gms.internal.ro;
import com.google.android.gms.internal.rp;
import com.google.android.gms.internal.rq;
import com.google.android.gms.internal.ub;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.zzhc;
import com.google.android.gms.internal.zzqh;

@wh
public class zzl extends C2385a {
    private op f6986a;
    private rn f6987b;
    private ro f6988c;
    private SimpleArrayMap<String, rp> f6989d = new SimpleArrayMap();
    private SimpleArrayMap<String, rq> f6990e = new SimpleArrayMap();
    private zzhc f6991f;
    private ox f6992g;
    private final Context f6993h;
    private final ub f6994i;
    private final String f6995j;
    private final zzqh f6996k;
    private final zze f6997l;

    public zzl(Context context, String str, ub ubVar, zzqh com_google_android_gms_internal_zzqh, zze com_google_android_gms_ads_internal_zze) {
        this.f6993h = context;
        this.f6995j = str;
        this.f6994i = ubVar;
        this.f6996k = com_google_android_gms_internal_zzqh;
        this.f6997l = com_google_android_gms_ads_internal_zze;
    }

    public void zza(rn rnVar) {
        this.f6987b = rnVar;
    }

    public void zza(ro roVar) {
        this.f6988c = roVar;
    }

    public void zza(zzhc com_google_android_gms_internal_zzhc) {
        this.f6991f = com_google_android_gms_internal_zzhc;
    }

    public void zza(String str, rq rqVar, rp rpVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.f6990e.put(str, rqVar);
        this.f6989d.put(str, rpVar);
    }

    public void zzb(op opVar) {
        this.f6986a = opVar;
    }

    public void zzb(ox oxVar) {
        this.f6992g = oxVar;
    }

    public oq zzck() {
        return new zzk(this.f6993h, this.f6995j, this.f6994i, this.f6996k, this.f6986a, this.f6987b, this.f6988c, this.f6990e, this.f6989d, this.f6991f, this.f6992g, this.f6997l);
    }
}
