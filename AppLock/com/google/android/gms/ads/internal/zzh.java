package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.aam.C2380c;
import com.google.android.gms.internal.aam.C2638b;
import com.google.android.gms.internal.aat;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.sc;
import com.google.android.gms.internal.ti;
import com.google.android.gms.internal.tj;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.za;
import com.google.android.gms.internal.zl;
import com.google.android.gms.internal.zzqh;
import java.util.Map;
import org.json.JSONObject;

@wh
public class zzh {
    private final Object f6967a = new Object();
    private Context f6968b;

    private static boolean m7507a(@Nullable za zaVar) {
        if (zaVar == null) {
            return true;
        }
        boolean z = (((zzw.zzcS().mo3360a() - zaVar.m14981a()) > ((Long) qb.cF.m13225c()).longValue() ? 1 : ((zzw.zzcS().mo3360a() - zaVar.m14981a()) == ((Long) qb.cF.m13225c()).longValue() ? 0 : -1)) > 0) || !zaVar.m14982b();
        return z;
    }

    void m7509a(Context context, zzqh com_google_android_gms_internal_zzqh, boolean z, @Nullable za zaVar, String str, @Nullable String str2, @Nullable Runnable runnable) {
        if (!m7507a(zaVar)) {
            return;
        }
        if (context == null) {
            aad.m8426e("Context not provided to fetch application settings");
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            aad.m8426e("App settings could not be fetched. Required parameters missing");
        } else {
            this.f6968b = context;
            final ti a = zzw.zzcM().m15103a(context, com_google_android_gms_internal_zzqh);
            final Runnable runnable2 = runnable;
            final sc c23791 = new sc(this) {
                final /* synthetic */ zzh f6959b;

                public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
                    com_google_android_gms_internal_aat.mo3409b("/appSettingsFetched", (sc) this);
                    synchronized (this.f6959b.f6967a) {
                        if (map != null) {
                            if ("true".equalsIgnoreCase((String) map.get("isSuccessful"))) {
                                zzw.zzcQ().m15013d(this.f6959b.f6968b, (String) map.get("appSettingsJson"));
                                try {
                                    if (runnable2 != null) {
                                        runnable2.run();
                                    }
                                } catch (Throwable th) {
                                    zzw.zzcQ().m15000a(th, "ConfigLoader.maybeFetchNewAppSettings");
                                    aad.m8424c("ConfigLoader post task failed.", th);
                                }
                            }
                        }
                    }
                }
            };
            final String str3 = str;
            final String str4 = str2;
            final boolean z2 = z;
            final Context context2 = context;
            zl.f11678a.post(new Runnable(this) {

                class C23811 implements C2380c<tj> {
                    final /* synthetic */ C23822 f6960a;

                    C23811(C23822 c23822) {
                        this.f6960a = c23822;
                    }

                    public void m7504a(tj tjVar) {
                        tjVar.mo3402a("/appSettingsFetched", c23791);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (!TextUtils.isEmpty(str3)) {
                                jSONObject.put("app_id", str3);
                            } else if (!TextUtils.isEmpty(str4)) {
                                jSONObject.put("ad_unit_id", str4);
                            }
                            jSONObject.put("is_init", z2);
                            jSONObject.put("pn", context2.getPackageName());
                            tjVar.mo3385a("AFMA_fetchAppSettings", jSONObject);
                        } catch (Throwable e) {
                            tjVar.mo3409b("/appSettingsFetched", c23791);
                            aad.m8422b("Error requesting application settings", e);
                        }
                    }

                    public /* synthetic */ void mo3272a(Object obj) {
                        m7504a((tj) obj);
                    }
                }

                public void run() {
                    a.m13966a().mo3380a(new C23811(this), new C2638b());
                }
            });
        }
    }

    public void zza(Context context, zzqh com_google_android_gms_internal_zzqh, String str, za zaVar) {
        m7509a(context, com_google_android_gms_internal_zzqh, false, zaVar, zaVar != null ? null : zaVar.m14984d(), str, null);
    }

    public void zza(Context context, zzqh com_google_android_gms_internal_zzqh, String str, @Nullable Runnable runnable) {
        m7509a(context, com_google_android_gms_internal_zzqh, true, null, str, null, runnable);
    }
}
