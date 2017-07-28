package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.api.C2465f;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@wh
public abstract class sr implements C2465f {
    protected Context f10603a;
    protected String f10604b;
    protected WeakReference<aat> f10605c;

    public sr(aat com_google_android_gms_internal_aat) {
        this.f10603a = com_google_android_gms_internal_aat.getContext();
        this.f10604b = zzw.zzcM().m15106a(this.f10603a, com_google_android_gms_internal_aat.mo3430o().f12081a);
        this.f10605c = new WeakReference(com_google_android_gms_internal_aat);
    }

    private void m13748a(String str, Map<String, String> map) {
        aat com_google_android_gms_internal_aat = (aat) this.f10605c.get();
        if (com_google_android_gms_internal_aat != null) {
            com_google_android_gms_internal_aat.mo3403a(str, (Map) map);
        }
    }

    private String m13749c(String str) {
        String str2 = "internal";
        Object obj = -1;
        switch (str.hashCode()) {
            case -1396664534:
                if (str.equals("badUrl")) {
                    obj = 6;
                    break;
                }
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    obj = 2;
                    break;
                }
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    obj = 7;
                    break;
                }
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    obj = 3;
                    break;
                }
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    obj = 1;
                    break;
                }
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    obj = 8;
                    break;
                }
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    obj = 9;
                    break;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    obj = null;
                    break;
                }
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    obj = 5;
                    break;
                }
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    obj = 4;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
            case 1:
            case 2:
            case 3:
                return "internal";
            case 4:
            case 5:
                return "io";
            case 6:
            case 7:
                return "network";
            case 8:
            case 9:
                return "policy";
            default:
                return str2;
        }
    }

    public void mo4014a() {
    }

    protected void m13751a(final String str, final String str2, final int i) {
        aac.f7622a.post(new Runnable(this) {
            final /* synthetic */ sr f10597d;

            public void run() {
                Map hashMap = new HashMap();
                hashMap.put("event", "precacheComplete");
                hashMap.put("src", str);
                hashMap.put("cachedSrc", str2);
                hashMap.put("totalBytes", Integer.toString(i));
                this.f10597d.m13748a("onPrecacheEvent", hashMap);
            }
        });
    }

    protected void m13752a(String str, String str2, int i, int i2, boolean z) {
        final String str3 = str;
        final String str4 = str2;
        final int i3 = i;
        final int i4 = i2;
        final boolean z2 = z;
        aac.f7622a.post(new Runnable(this) {
            final /* synthetic */ sr f10593f;

            public void run() {
                Map hashMap = new HashMap();
                hashMap.put("event", "precacheProgress");
                hashMap.put("src", str3);
                hashMap.put("cachedSrc", str4);
                hashMap.put("bytesLoaded", Integer.toString(i3));
                hashMap.put("totalBytes", Integer.toString(i4));
                hashMap.put("cacheReady", z2 ? "1" : "0");
                this.f10593f.m13748a("onPrecacheEvent", hashMap);
            }
        });
    }

    public void m13753a(String str, String str2, String str3, @Nullable String str4) {
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        aac.f7622a.post(new Runnable(this) {
            final /* synthetic */ sr f10602e;

            public void run() {
                Map hashMap = new HashMap();
                hashMap.put("event", "precacheCanceled");
                hashMap.put("src", str5);
                if (!TextUtils.isEmpty(str6)) {
                    hashMap.put("cachedSrc", str6);
                }
                hashMap.put("type", this.f10602e.m13749c(str7));
                hashMap.put("reason", str7);
                if (!TextUtils.isEmpty(str8)) {
                    hashMap.put("message", str8);
                }
                this.f10602e.m13748a("onPrecacheEvent", hashMap);
            }
        });
    }

    public abstract boolean mo4015a(String str);

    protected String m13755b(String str) {
        return ol.m12979a().m8401a(str);
    }

    public abstract void mo4016b();
}
