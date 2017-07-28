package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.domobile.lockbean.Location;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzw;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@wh
public final class sb {
    public static final sc f10528a = new C32241();
    public static final sc f10529b = new sc() {
        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                aad.m8426e("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = com_google_android_gms_internal_aat.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
            }
            com_google_android_gms_internal_aat.mo3403a("openableURLs", hashMap);
        }
    };
    public static final sc f10530c = new C32252();
    public static final sc f10531d = new C32263();
    public static final sc f10532e = new C32274();
    public static final sc f10533f = new C32285();
    public static final sc f10534g = new C32296();
    public static final sc f10535h = new C32307();
    public static final sc f10536i = new C32318();
    public static final sc f10537j = new C32329();
    public static final sc f10538k = new sc() {
        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                ed n = com_google_android_gms_internal_aat.mo3429n();
                if (n != null) {
                    n.m10561a().mo3153a(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                aad.m8426e("Could not parse touch parameters from gmsg.");
            }
        }
    };
    public static final sc f10539l = new sc() {
        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            if (((Boolean) qb.bx.m13225c()).booleanValue()) {
                com_google_android_gms_internal_aat.mo3413c(!Boolean.parseBoolean((String) map.get("disabled")));
            }
        }
    };
    public static final sc f10540m = new sc() {
        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            String str = (String) map.get("action");
            if ("pause".equals(str)) {
                com_google_android_gms_internal_aat.zzbV();
            } else if ("resume".equals(str)) {
                com_google_android_gms_internal_aat.zzbW();
            }
        }
    };
    public static final sc f10541n = new sn();
    public static final sc f10542o = new so();
    public static final sc f10543p = new si();
    public static final sc f10544q = new ss();
    public static final sc f10545r = new sa();
    public static final sl f10546s = new sl();
    public static final sc f10547t = new sc() {
        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            if (map.keySet().contains(Location.CODE_START)) {
                com_google_android_gms_internal_aat.mo3424l().m8565i();
            } else if (map.keySet().contains(Location.CODE_STOP)) {
                com_google_android_gms_internal_aat.mo3424l().m8566j();
            } else if (map.keySet().contains("cancel")) {
                com_google_android_gms_internal_aat.mo3424l().m8567k();
            }
        }
    };
    public static final sc f10548u = new sc() {
        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            if (map.keySet().contains(Location.CODE_START)) {
                com_google_android_gms_internal_aat.mo3415d(true);
            }
            if (map.keySet().contains(Location.CODE_STOP)) {
                com_google_android_gms_internal_aat.mo3415d(false);
            }
        }
    };
    public static final sc f10549v = new sc() {
        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            com_google_android_gms_internal_aat.mo3403a("locationReady", zzw.zzcM().m15112a((View) com_google_android_gms_internal_aat, (WindowManager) com_google_android_gms_internal_aat.getContext().getSystemService("window")));
            aad.m8426e("GET LOCATION COMPILED");
        }
    };

    class C32241 implements sc {
        C32241() {
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        }
    }

    class C32252 implements sc {
        C32252() {
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            PackageManager packageManager = com_google_android_gms_internal_aat.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("id");
                            Object optString2 = jSONObject2.optString("u");
                            Object optString3 = jSONObject2.optString("i");
                            Object optString4 = jSONObject2.optString("m");
                            Object optString5 = jSONObject2.optString("p");
                            Object optString6 = jSONObject2.optString("c");
                            jSONObject2.optString("f");
                            jSONObject2.optString("e");
                            Intent intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                            try {
                                jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                            } catch (Throwable e) {
                                aad.m8422b("Error constructing openable urls response.", e);
                            }
                        } catch (Throwable e2) {
                            aad.m8422b("Error parsing the intent data.", e2);
                        }
                    }
                    com_google_android_gms_internal_aat.mo3410b("openableIntents", jSONObject);
                } catch (JSONException e3) {
                    com_google_android_gms_internal_aat.mo3410b("openableIntents", new JSONObject());
                }
            } catch (JSONException e4) {
                com_google_android_gms_internal_aat.mo3410b("openableIntents", new JSONObject());
            }
        }
    }

    class C32263 implements sc {
        C32263() {
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                aad.m8426e("URL missing from click GMSG.");
                return;
            }
            Uri a;
            String d;
            Uri parse = Uri.parse(str);
            try {
                ed n = com_google_android_gms_internal_aat.mo3429n();
                if (n != null && n.m10568c(parse)) {
                    a = n.m10560a(parse, com_google_android_gms_internal_aat.getContext(), com_google_android_gms_internal_aat.mo3405b());
                    if (zzw.zzdl().m14954e() && TextUtils.isEmpty(a.getQueryParameter("fbs_aeid"))) {
                        d = zzw.zzdl().m14950d(com_google_android_gms_internal_aat.getContext());
                        a = zzw.zzcM().m15098a(a, "fbs_aeid", d);
                        zzw.zzdl().m14948c(com_google_android_gms_internal_aat.getContext(), d);
                    }
                    new zv(com_google_android_gms_internal_aat.getContext(), com_google_android_gms_internal_aat.mo3430o().f12081a, a.toString()).zziP();
                }
            } catch (ee e) {
                String str2 = "Unable to append parameter to URL: ";
                str = String.valueOf(str);
                aad.m8426e(str.length() != 0 ? str2.concat(str) : new String(str2));
            }
            a = parse;
            d = zzw.zzdl().m14950d(com_google_android_gms_internal_aat.getContext());
            a = zzw.zzcM().m15098a(a, "fbs_aeid", d);
            zzw.zzdl().m14948c(com_google_android_gms_internal_aat.getContext(), d);
            new zv(com_google_android_gms_internal_aat.getContext(), com_google_android_gms_internal_aat.mo3430o().f12081a, a.toString()).zziP();
        }
    }

    class C32274 implements sc {
        C32274() {
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            zze i = com_google_android_gms_internal_aat.mo3421i();
            if (i != null) {
                i.close();
                return;
            }
            i = com_google_android_gms_internal_aat.mo3422j();
            if (i != null) {
                i.close();
            } else {
                aad.m8426e("A GMSG tried to close something that wasn't an overlay.");
            }
        }
    }

    class C32285 implements sc {
        C32285() {
        }

        private void m13690a(aat com_google_android_gms_internal_aat) {
            aad.m8425d("Received support message, responding.");
            com.google.android.gms.ads.internal.zze h = com_google_android_gms_internal_aat.mo3420h();
            if (!(h == null || h.zzsO == null)) {
                com_google_android_gms_internal_aat.getContext();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event", "checkSupport");
                jSONObject.put("supports", false);
                com_google_android_gms_internal_aat.mo3410b("appStreaming", jSONObject);
            } catch (Throwable th) {
                zzw.zzcQ().m15000a(th, "DefaultGmsgHandlers.processCheckSupportsMessage");
            }
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            if ("checkSupport".equals(map.get("action"))) {
                m13690a(com_google_android_gms_internal_aat);
                return;
            }
            zze i = com_google_android_gms_internal_aat.mo3421i();
            if (i != null) {
                i.zzg(com_google_android_gms_internal_aat, map);
            }
        }
    }

    class C32296 implements sc {
        C32296() {
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            com_google_android_gms_internal_aat.mo3411b("1".equals(map.get("custom_close")));
        }
    }

    class C32307 implements sc {
        C32307() {
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                aad.m8426e("URL missing from httpTrack GMSG.");
            } else {
                new zv(com_google_android_gms_internal_aat.getContext(), com_google_android_gms_internal_aat.mo3430o().f12081a, str).zziP();
            }
        }
    }

    class C32318 implements sc {
        C32318() {
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            String str = "Received log message: ";
            String valueOf = String.valueOf((String) map.get("string"));
            aad.m8425d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    class C32329 implements sc {
        C32329() {
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            qw E = com_google_android_gms_internal_aat.mo3390E();
            if (E != null) {
                E.mo3948a();
            }
        }
    }
}
