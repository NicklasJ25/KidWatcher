package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.internal.tf.C3278a;
import java.util.concurrent.Future;

@wh
public class tg {

    private static class C3281a<JavascriptEngine> extends aag<JavascriptEngine> {
        JavascriptEngine f10709a;

        private C3281a() {
        }
    }

    private tf m13910a(Context context, zzqh com_google_android_gms_internal_zzqh, final C3281a<tf> c3281a, ed edVar, zze com_google_android_gms_ads_internal_zze) {
        tf thVar = new th(context, com_google_android_gms_internal_zzqh, edVar, com_google_android_gms_ads_internal_zze);
        c3281a.f10709a = thVar;
        thVar.mo4036a(new C3278a(this) {
            public void mo4033a() {
                c3281a.m8436b((Object) (tf) c3281a.f10709a);
            }
        });
        return thVar;
    }

    public Future<tf> m13912a(Context context, zzqh com_google_android_gms_internal_zzqh, String str, ed edVar, zze com_google_android_gms_ads_internal_zze) {
        final Future c3281a = new C3281a();
        final Context context2 = context;
        final zzqh com_google_android_gms_internal_zzqh2 = com_google_android_gms_internal_zzqh;
        final ed edVar2 = edVar;
        final zze com_google_android_gms_ads_internal_zze2 = com_google_android_gms_ads_internal_zze;
        final String str2 = str;
        zl.f11678a.post(new Runnable(this) {
            final /* synthetic */ tg f10707g;

            public void run() {
                this.f10707g.m13910a(context2, com_google_android_gms_internal_zzqh2, c3281a, edVar2, com_google_android_gms_ads_internal_zze2).mo4039b(str2);
            }
        });
        return c3281a;
    }
}
