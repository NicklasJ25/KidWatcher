package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.C2590o;
import com.google.android.gms.internal.yy.C3457a;

@wh
public class vs {

    public interface C2360a {
        void zzb(yy yyVar);
    }

    public zn m14373a(Context context, zza com_google_android_gms_ads_internal_zza, C3457a c3457a, ed edVar, @Nullable aat com_google_android_gms_internal_aat, ub ubVar, C2360a c2360a, qj qjVar) {
        zzmn com_google_android_gms_internal_zzmn = c3457a.f11510b;
        zn vwVar = com_google_android_gms_internal_zzmn.f12042h ? new vw(context, c3457a, ubVar, c2360a, qjVar, com_google_android_gms_internal_aat) : (com_google_android_gms_internal_zzmn.f12054t || (com_google_android_gms_ads_internal_zza instanceof zzs)) ? (com_google_android_gms_internal_zzmn.f12054t && (com_google_android_gms_ads_internal_zza instanceof zzs)) ? new vx(context, (zzs) com_google_android_gms_ads_internal_zza, c3457a, edVar, c2360a, qjVar) : new vu(c3457a, c2360a) : (((Boolean) qb.ao.m13225c()).booleanValue() && C2590o.m8312g() && !C2590o.m8314i() && com_google_android_gms_internal_aat != null && com_google_android_gms_internal_aat.mo3423k().f11898d) ? new vv(context, c3457a, com_google_android_gms_internal_aat, c2360a) : new vt(context, c3457a, com_google_android_gms_internal_aat, c2360a);
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(vwVar.getClass().getName());
        aad.m8421b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        vwVar.zziP();
        return vwVar;
    }

    public zn m14374a(Context context, C3457a c3457a, xq xqVar) {
        zn yiVar = new yi(context, c3457a, xqVar);
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(yiVar.getClass().getName());
        aad.m8421b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        yiVar.zziP();
        return yiVar;
    }
}
