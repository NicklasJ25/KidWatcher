package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.util.C2583h;
import com.google.android.gms.internal.wl.C3401a;
import com.google.android.gms.internal.wl.C3402b;

@wh
public final class wk {

    public interface C3396a {
        void mo4183a(zzmn com_google_android_gms_internal_zzmn);
    }

    interface C3397b {
        boolean mo4184a(zzqh com_google_android_gms_internal_zzqh);
    }

    class C33981 implements C3397b {
        final /* synthetic */ Context f11179a;

        C33981(Context context) {
            this.f11179a = context;
        }

        public boolean mo4184a(zzqh com_google_android_gms_internal_zzqh) {
            return com_google_android_gms_internal_zzqh.f12084d || (C2583h.m8295c(this.f11179a) && !((Boolean) qb.f10275O.m13225c()).booleanValue());
        }
    }

    private static zn m14508a(Context context, aam<zzmk> com_google_android_gms_internal_aam_com_google_android_gms_internal_zzmk, C3396a c3396a) {
        aad.m8421b("Fetching ad response from local ad request service.");
        zn c3401a = new C3401a(context, com_google_android_gms_internal_aam_com_google_android_gms_internal_zzmk, c3396a);
        c3401a.zziP();
        return c3401a;
    }

    public static zn m14509a(Context context, zzqh com_google_android_gms_internal_zzqh, aam<zzmk> com_google_android_gms_internal_aam_com_google_android_gms_internal_zzmk, C3396a c3396a) {
        return m14510a(context, com_google_android_gms_internal_zzqh, com_google_android_gms_internal_aam_com_google_android_gms_internal_zzmk, c3396a, new C33981(context));
    }

    static zn m14510a(Context context, zzqh com_google_android_gms_internal_zzqh, aam<zzmk> com_google_android_gms_internal_aam_com_google_android_gms_internal_zzmk, C3396a c3396a, C3397b c3397b) {
        return c3397b.mo4184a(com_google_android_gms_internal_zzqh) ? m14508a(context, com_google_android_gms_internal_aam_com_google_android_gms_internal_zzmk, c3396a) : m14511b(context, com_google_android_gms_internal_zzqh, com_google_android_gms_internal_aam_com_google_android_gms_internal_zzmk, c3396a);
    }

    private static zn m14511b(Context context, zzqh com_google_android_gms_internal_zzqh, aam<zzmk> com_google_android_gms_internal_aam_com_google_android_gms_internal_zzmk, C3396a c3396a) {
        aad.m8421b("Fetching ad response from remote ad request service.");
        if (ol.m12979a().m8414c(context)) {
            return new C3402b(context, com_google_android_gms_internal_zzqh, com_google_android_gms_internal_aam_com_google_android_gms_internal_zzmk, c3396a);
        }
        aad.m8426e("Failed to connect to remote ad request service.");
        return null;
    }
}
