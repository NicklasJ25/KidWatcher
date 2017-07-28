package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import java.util.Map;

@wh
public final class sa implements sc {
    private long m13674a(long j) {
        return (j - zzw.zzcS().mo3360a()) + zzw.zzcS().mo3361b();
    }

    private void m13675b(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        String str = (String) map.get("label");
        String str2 = (String) map.get("start_label");
        String str3 = (String) map.get("timestamp");
        if (TextUtils.isEmpty(str)) {
            aad.m8426e("No label given for CSI tick.");
        } else if (TextUtils.isEmpty(str3)) {
            aad.m8426e("No timestamp given for CSI tick.");
        } else {
            try {
                long a = m13674a(Long.parseLong(str3));
                if (TextUtils.isEmpty(str2)) {
                    str2 = "native:view_load";
                }
                com_google_android_gms_internal_aat.mo3447y().m13300a(str, str2, a);
            } catch (Throwable e) {
                aad.m8424c("Malformed timestamp for CSI tick.", e);
            }
        }
    }

    private void m13676c(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        String str = (String) map.get("value");
        if (TextUtils.isEmpty(str)) {
            aad.m8426e("No value given for CSI experiment.");
            return;
        }
        qj a = com_google_android_gms_internal_aat.mo3447y().m13298a();
        if (a == null) {
            aad.m8426e("No ticker for WebView, dropping experiment ID.");
        } else {
            a.m13305a("e", str);
        }
    }

    private void m13677d(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        String str = (String) map.get("name");
        String str2 = (String) map.get("value");
        if (TextUtils.isEmpty(str2)) {
            aad.m8426e("No value given for CSI extra.");
        } else if (TextUtils.isEmpty(str)) {
            aad.m8426e("No name given for CSI extra.");
        } else {
            qj a = com_google_android_gms_internal_aat.mo3447y().m13298a();
            if (a == null) {
                aad.m8426e("No ticker for WebView, dropping extra parameter.");
            } else {
                a.m13305a(str, str2);
            }
        }
    }

    public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            m13675b(com_google_android_gms_internal_aat, map);
        } else if ("experiment".equals(str)) {
            m13676c(com_google_android_gms_internal_aat, map);
        } else if ("extra".equals(str)) {
            m13677d(com_google_android_gms_internal_aat, map);
        }
    }
}
