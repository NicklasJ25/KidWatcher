package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug.MemoryInfo;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.xk.C3438a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@wh
public final class xb {
    private static final SimpleDateFormat f11309a = new SimpleDateFormat("yyyyMMdd", Locale.US);

    private static Bundle m14681a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("runtime_free", Long.toString(bundle.getLong("runtime_free_memory", -1)));
        bundle2.putString("runtime_max", Long.toString(bundle.getLong("runtime_max_memory", -1)));
        bundle2.putString("runtime_total", Long.toString(bundle.getLong("runtime_total_memory", -1)));
        bundle2.putString("web_view_count", Integer.toString(bundle.getInt("web_view_count", 0)));
        MemoryInfo memoryInfo = (MemoryInfo) bundle.getParcelable("debug_memory_info");
        if (memoryInfo != null) {
            bundle2.putString("debug_info_dalvik_private_dirty", Integer.toString(memoryInfo.dalvikPrivateDirty));
            bundle2.putString("debug_info_dalvik_pss", Integer.toString(memoryInfo.dalvikPss));
            bundle2.putString("debug_info_dalvik_shared_dirty", Integer.toString(memoryInfo.dalvikSharedDirty));
            bundle2.putString("debug_info_native_private_dirty", Integer.toString(memoryInfo.nativePrivateDirty));
            bundle2.putString("debug_info_native_pss", Integer.toString(memoryInfo.nativePss));
            bundle2.putString("debug_info_native_shared_dirty", Integer.toString(memoryInfo.nativeSharedDirty));
            bundle2.putString("debug_info_other_private_dirty", Integer.toString(memoryInfo.otherPrivateDirty));
            bundle2.putString("debug_info_other_pss", Integer.toString(memoryInfo.otherPss));
            bundle2.putString("debug_info_other_shared_dirty", Integer.toString(memoryInfo.otherSharedDirty));
        }
        return bundle2;
    }

    public static zzmn m14682a(Context context, zzmk com_google_android_gms_internal_zzmk, String str) {
        String optString;
        try {
            String str2;
            JSONObject jSONObject = new JSONObject(str);
            String optString2 = jSONObject.optString("ad_base_url", null);
            Object optString3 = jSONObject.optString("ad_url", null);
            String optString4 = jSONObject.optString("ad_size", null);
            String optString5 = jSONObject.optString("ad_slot_size", optString4);
            boolean z = (com_google_android_gms_internal_zzmk == null || com_google_android_gms_internal_zzmk.f12004m == 0) ? false : true;
            CharSequence optString6 = jSONObject.optString("ad_json", null);
            if (optString6 == null) {
                optString6 = jSONObject.optString("ad_html", null);
            }
            if (optString6 == null) {
                optString6 = jSONObject.optString("body", null);
            }
            long j = -1;
            String optString7 = jSONObject.optString("debug_dialog", null);
            String optString8 = jSONObject.optString("debug_signals", null);
            long j2 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            optString = jSONObject.optString("orientation", null);
            int i = -1;
            if ("portrait".equals(optString)) {
                i = zzw.zzcO().mo4249b();
            } else if ("landscape".equals(optString)) {
                i = zzw.zzcO().mo4247a();
            }
            zzmn com_google_android_gms_internal_zzmn = null;
            if (!TextUtils.isEmpty(optString6) || TextUtils.isEmpty(optString3)) {
                CharSequence charSequence = optString6;
            } else {
                com_google_android_gms_internal_zzmn = xa.m14676a(com_google_android_gms_internal_zzmk, context, com_google_android_gms_internal_zzmk.f12002k.f12081a, optString3, null, null, null, null);
                optString2 = com_google_android_gms_internal_zzmn.f12036b;
                str2 = com_google_android_gms_internal_zzmn.f12037c;
                j = com_google_android_gms_internal_zzmn.f12048n;
            }
            if (str2 == null) {
                return new zzmn(0);
            }
            long j3;
            String optString9;
            String str3;
            boolean optBoolean;
            JSONArray optJSONArray = jSONObject.optJSONArray("click_urls");
            List list = com_google_android_gms_internal_zzmn == null ? null : com_google_android_gms_internal_zzmn.f12038d;
            if (optJSONArray != null) {
                list = m14686a(optJSONArray, list);
            }
            optJSONArray = jSONObject.optJSONArray("impression_urls");
            List list2 = com_google_android_gms_internal_zzmn == null ? null : com_google_android_gms_internal_zzmn.f12040f;
            if (optJSONArray != null) {
                list2 = m14686a(optJSONArray, list2);
            }
            optJSONArray = jSONObject.optJSONArray("manual_impression_urls");
            List list3 = com_google_android_gms_internal_zzmn == null ? null : com_google_android_gms_internal_zzmn.f12044j;
            if (optJSONArray != null) {
                list3 = m14686a(optJSONArray, list3);
            }
            if (com_google_android_gms_internal_zzmn != null) {
                if (com_google_android_gms_internal_zzmn.f12046l != -1) {
                    i = com_google_android_gms_internal_zzmn.f12046l;
                }
                if (com_google_android_gms_internal_zzmn.f12041g > 0) {
                    j3 = com_google_android_gms_internal_zzmn.f12041g;
                    optString9 = jSONObject.optString("active_view");
                    str3 = null;
                    optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
                    if (optBoolean) {
                        str3 = jSONObject.optString("ad_passback_url", null);
                    }
                    return new zzmn(com_google_android_gms_internal_zzmk, optString2, str2, list, list2, j3, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), list3, jSONObject.optLong("refresh_interval_milliseconds", -1), i, optString4, j, optString7, optBoolean, str3, optString9, jSONObject.optBoolean("custom_render_allowed", false), z, com_google_android_gms_internal_zzmk.f12007p, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optString("gws_query_id", ""), "height".equals(jSONObject.optString("fluid", "")), jSONObject.optBoolean("native_express", false), zzoo.m15394a(jSONObject.optJSONArray("rewards")), m14686a(jSONObject.optJSONArray("video_start_urls"), null), m14686a(jSONObject.optJSONArray("video_complete_urls"), null), jSONObject.optBoolean("use_displayed_impression", false), zzmp.m15388a(jSONObject.optJSONObject("auto_protection_configuration")), com_google_android_gms_internal_zzmk.f11977H, jSONObject.optString("set_cookie", ""), m14686a(jSONObject.optJSONArray("remote_ping_urls"), null), jSONObject.optBoolean("render_in_browser", com_google_android_gms_internal_zzmk.f11981L), optString5, zzor.m15396a(jSONObject.optJSONObject("safe_browsing")), optString8, jSONObject.optBoolean("content_vertical_opted_out", true), com_google_android_gms_internal_zzmk.f11991V);
                }
            }
            j3 = j2;
            optString9 = jSONObject.optString("active_view");
            str3 = null;
            optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
            if (optBoolean) {
                str3 = jSONObject.optString("ad_passback_url", null);
            }
            return new zzmn(com_google_android_gms_internal_zzmk, optString2, str2, list, list2, j3, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), list3, jSONObject.optLong("refresh_interval_milliseconds", -1), i, optString4, j, optString7, optBoolean, str3, optString9, jSONObject.optBoolean("custom_render_allowed", false), z, com_google_android_gms_internal_zzmk.f12007p, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optString("gws_query_id", ""), "height".equals(jSONObject.optString("fluid", "")), jSONObject.optBoolean("native_express", false), zzoo.m15394a(jSONObject.optJSONArray("rewards")), m14686a(jSONObject.optJSONArray("video_start_urls"), null), m14686a(jSONObject.optJSONArray("video_complete_urls"), null), jSONObject.optBoolean("use_displayed_impression", false), zzmp.m15388a(jSONObject.optJSONObject("auto_protection_configuration")), com_google_android_gms_internal_zzmk.f11977H, jSONObject.optString("set_cookie", ""), m14686a(jSONObject.optJSONArray("remote_ping_urls"), null), jSONObject.optBoolean("render_in_browser", com_google_android_gms_internal_zzmk.f11981L), optString5, zzor.m15396a(jSONObject.optJSONObject("safe_browsing")), optString8, jSONObject.optBoolean("content_vertical_opted_out", true), com_google_android_gms_internal_zzmk.f11991V);
        } catch (JSONException e) {
            String str4 = "Could not parse the inline ad response: ";
            optString = String.valueOf(e.getMessage());
            aad.m8426e(optString.length() != 0 ? str4.concat(optString) : new String(str4));
            return new zzmn(0);
        }
    }

    private static Integer m14683a(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    private static String m14684a(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(ViewCompat.MEASURED_SIZE_MASK & i)});
    }

    private static String m14685a(zzhc com_google_android_gms_internal_zzhc) {
        switch (com_google_android_gms_internal_zzhc != null ? com_google_android_gms_internal_zzhc.f11923c : 0) {
            case 1:
                return "portrait";
            case 2:
                return "landscape";
            default:
                return "any";
        }
    }

    @Nullable
    private static List<String> m14686a(@Nullable JSONArray jSONArray, @Nullable List<String> list) {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new LinkedList();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }

    @Nullable
    static JSONArray m14687a(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    @Nullable
    public static JSONObject m14688a(Context context, wy wyVar) {
        Object obj;
        String str;
        String valueOf;
        zzmk com_google_android_gms_internal_zzmk = wyVar.f11230i;
        Location location = wyVar.f11225d;
        xg xgVar = wyVar.f11231j;
        Bundle bundle = wyVar.f11222a;
        JSONObject jSONObject = wyVar.f11232k;
        HashMap hashMap = new HashMap();
        hashMap.put("extra_caps", qb.bY.m13225c());
        if (wyVar.f11224c.size() > 0) {
            hashMap.put("eid", TextUtils.join(",", wyVar.f11224c));
        }
        if (com_google_android_gms_internal_zzmk.f11993b != null) {
            hashMap.put("ad_pos", com_google_android_gms_internal_zzmk.f11993b);
        }
        m14694a(hashMap, com_google_android_gms_internal_zzmk.f11994c);
        if (com_google_android_gms_internal_zzmk.f11995d.f11901g != null) {
            obj = null;
            Object obj2 = null;
            for (zzeg com_google_android_gms_internal_zzeg : com_google_android_gms_internal_zzmk.f11995d.f11901g) {
                if (!com_google_android_gms_internal_zzeg.f11903i && r3 == null) {
                    hashMap.put("format", com_google_android_gms_internal_zzeg.f11895a);
                    obj2 = 1;
                }
                if (com_google_android_gms_internal_zzeg.f11903i && r2 == null) {
                    hashMap.put("fluid", "height");
                    obj = 1;
                }
                if (obj2 != null && r2 != null) {
                    break;
                }
            }
        } else {
            hashMap.put("format", com_google_android_gms_internal_zzmk.f11995d.f11895a);
            if (com_google_android_gms_internal_zzmk.f11995d.f11903i) {
                hashMap.put("fluid", "height");
            }
        }
        if (com_google_android_gms_internal_zzmk.f11995d.f11899e == -1) {
            hashMap.put("smart_w", "full");
        }
        if (com_google_android_gms_internal_zzmk.f11995d.f11896b == -2) {
            hashMap.put("smart_h", "auto");
        }
        if (com_google_android_gms_internal_zzmk.f11995d.f11901g != null) {
            StringBuilder stringBuilder = new StringBuilder();
            obj = null;
            for (zzeg com_google_android_gms_internal_zzeg2 : com_google_android_gms_internal_zzmk.f11995d.f11901g) {
                if (com_google_android_gms_internal_zzeg2.f11903i) {
                    obj = 1;
                } else {
                    int i;
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("|");
                    }
                    if (com_google_android_gms_internal_zzeg2.f11899e == -1) {
                        i = (int) (((float) com_google_android_gms_internal_zzeg2.f11900f) / xgVar.f11411r);
                    } else {
                        try {
                            i = com_google_android_gms_internal_zzeg2.f11899e;
                        } catch (JSONException e) {
                            str = "Problem serializing ad request to JSON: ";
                            valueOf = String.valueOf(e.getMessage());
                            aad.m8426e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                            return null;
                        }
                    }
                    stringBuilder.append(i);
                    stringBuilder.append("x");
                    stringBuilder.append(com_google_android_gms_internal_zzeg2.f11896b == -2 ? (int) (((float) com_google_android_gms_internal_zzeg2.f11897c) / xgVar.f11411r) : com_google_android_gms_internal_zzeg2.f11896b);
                }
            }
            if (obj != null) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.insert(0, "|");
                }
                stringBuilder.insert(0, "320x50");
            }
            hashMap.put("sz", stringBuilder);
        }
        if (com_google_android_gms_internal_zzmk.f12004m != 0) {
            hashMap.put("native_version", Integer.valueOf(com_google_android_gms_internal_zzmk.f12004m));
            hashMap.put("native_templates", com_google_android_gms_internal_zzmk.f12005n);
            hashMap.put("native_image_orientation", m14685a(com_google_android_gms_internal_zzmk.f12016y));
            if (!com_google_android_gms_internal_zzmk.f12017z.isEmpty()) {
                hashMap.put("native_custom_templates", com_google_android_gms_internal_zzmk.f12017z);
            }
        }
        if (com_google_android_gms_internal_zzmk.f11995d.f11904j) {
            hashMap.put("ene", Boolean.valueOf(true));
        }
        if (com_google_android_gms_internal_zzmk.f11985P != null) {
            hashMap.put("is_icon_ad", Boolean.valueOf(true));
            hashMap.put("icon_ad_expansion_behavior", Integer.valueOf(com_google_android_gms_internal_zzmk.f11985P.f11905a));
        }
        hashMap.put("slotname", com_google_android_gms_internal_zzmk.f11996e);
        hashMap.put("pn", com_google_android_gms_internal_zzmk.f11997f.packageName);
        if (com_google_android_gms_internal_zzmk.f11998g != null) {
            hashMap.put("vc", Integer.valueOf(com_google_android_gms_internal_zzmk.f11998g.versionCode));
        }
        hashMap.put("ms", wyVar.f11228g);
        hashMap.put("seq_num", com_google_android_gms_internal_zzmk.f12000i);
        hashMap.put("session_id", com_google_android_gms_internal_zzmk.f12001j);
        hashMap.put("js", com_google_android_gms_internal_zzmk.f12002k.f12081a);
        m14693a(hashMap, xgVar, wyVar.f11226e, com_google_android_gms_internal_zzmk.f11983N, wyVar.f11223b);
        m14692a(hashMap, wyVar, context);
        hashMap.put("platform", Build.MANUFACTURER);
        hashMap.put("submodel", Build.MODEL);
        if (location != null) {
            m14691a(hashMap, location);
        } else if (com_google_android_gms_internal_zzmk.f11994c.f11877a >= 2 && com_google_android_gms_internal_zzmk.f11994c.f11887k != null) {
            m14691a(hashMap, com_google_android_gms_internal_zzmk.f11994c.f11887k);
        }
        if (com_google_android_gms_internal_zzmk.f11992a >= 2) {
            hashMap.put("quality_signals", com_google_android_gms_internal_zzmk.f12003l);
        }
        if (com_google_android_gms_internal_zzmk.f11992a >= 4 && com_google_android_gms_internal_zzmk.f12007p) {
            hashMap.put("forceHttps", Boolean.valueOf(com_google_android_gms_internal_zzmk.f12007p));
        }
        if (bundle != null) {
            hashMap.put("content_info", bundle);
        }
        if (com_google_android_gms_internal_zzmk.f11992a >= 5) {
            hashMap.put("u_sd", Float.valueOf(com_google_android_gms_internal_zzmk.f12010s));
            hashMap.put("sh", Integer.valueOf(com_google_android_gms_internal_zzmk.f12009r));
            hashMap.put("sw", Integer.valueOf(com_google_android_gms_internal_zzmk.f12008q));
        } else {
            hashMap.put("u_sd", Float.valueOf(xgVar.f11411r));
            hashMap.put("sh", Integer.valueOf(xgVar.f11413t));
            hashMap.put("sw", Integer.valueOf(xgVar.f11412s));
        }
        if (com_google_android_gms_internal_zzmk.f11992a >= 6) {
            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzmk.f12011t)) {
                try {
                    hashMap.put("view_hierarchy", new JSONObject(com_google_android_gms_internal_zzmk.f12011t));
                } catch (Throwable e2) {
                    aad.m8424c("Problem serializing view hierarchy to JSON", e2);
                }
            }
            hashMap.put("correlation_id", Long.valueOf(com_google_android_gms_internal_zzmk.f12012u));
        }
        if (com_google_android_gms_internal_zzmk.f11992a >= 7) {
            hashMap.put("request_id", com_google_android_gms_internal_zzmk.f12013v);
        }
        if (com_google_android_gms_internal_zzmk.f11992a >= 11 && com_google_android_gms_internal_zzmk.f11971B != null) {
            hashMap.put("capability", com_google_android_gms_internal_zzmk.f11971B.m15389a());
        }
        if (com_google_android_gms_internal_zzmk.f11992a >= 12 && !TextUtils.isEmpty(com_google_android_gms_internal_zzmk.f11972C)) {
            hashMap.put("anchor", com_google_android_gms_internal_zzmk.f11972C);
        }
        if (com_google_android_gms_internal_zzmk.f11992a >= 13) {
            hashMap.put("android_app_volume", Float.valueOf(com_google_android_gms_internal_zzmk.f11973D));
        }
        if (com_google_android_gms_internal_zzmk.f11992a >= 18) {
            hashMap.put("android_app_muted", Boolean.valueOf(com_google_android_gms_internal_zzmk.f11979J));
        }
        if (com_google_android_gms_internal_zzmk.f11992a >= 14 && com_google_android_gms_internal_zzmk.f11974E > 0) {
            hashMap.put("target_api", Integer.valueOf(com_google_android_gms_internal_zzmk.f11974E));
        }
        if (com_google_android_gms_internal_zzmk.f11992a >= 15) {
            hashMap.put("scroll_index", Integer.valueOf(com_google_android_gms_internal_zzmk.f11975F == -1 ? -1 : com_google_android_gms_internal_zzmk.f11975F));
        }
        if (com_google_android_gms_internal_zzmk.f11992a >= 16) {
            hashMap.put("_activity_context", Boolean.valueOf(com_google_android_gms_internal_zzmk.f11976G));
        }
        if (com_google_android_gms_internal_zzmk.f11992a >= 18) {
            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzmk.f11980K)) {
                try {
                    hashMap.put("app_settings", new JSONObject(com_google_android_gms_internal_zzmk.f11980K));
                } catch (Throwable e22) {
                    aad.m8424c("Problem creating json from app settings", e22);
                }
            }
            hashMap.put("render_in_browser", Boolean.valueOf(com_google_android_gms_internal_zzmk.f11981L));
        }
        if (com_google_android_gms_internal_zzmk.f11992a >= 18) {
            hashMap.put("android_num_video_cache_tasks", Integer.valueOf(com_google_android_gms_internal_zzmk.f11982M));
        }
        m14690a(context, hashMap, com_google_android_gms_internal_zzmk.f12002k);
        hashMap.put("cache_state", jSONObject);
        if (com_google_android_gms_internal_zzmk.f11992a >= 19) {
            hashMap.put("gct", com_google_android_gms_internal_zzmk.f11984O);
        }
        if (com_google_android_gms_internal_zzmk.f11992a >= 21 && com_google_android_gms_internal_zzmk.f11986Q) {
            hashMap.put("de", "1");
        }
        if (((Boolean) qb.aW.m13225c()).booleanValue()) {
            m14696a(hashMap, com_google_android_gms_internal_zzmk);
        }
        if (com_google_android_gms_internal_zzmk.f11992a >= 22 && zzw.zzdl().m14943a()) {
            hashMap.put("gmp_app_id", com_google_android_gms_internal_zzmk.f11988S);
            hashMap.put("fbs_aiid", com_google_android_gms_internal_zzmk.f11989T);
            hashMap.put("fbs_aeid", com_google_android_gms_internal_zzmk.f11990U);
        }
        if (aad.m8420a(2)) {
            str = "Ad Request JSON: ";
            valueOf = String.valueOf(zzw.zzcM().m15114a((Map) hashMap).toString(2));
            zh.m15051a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        return zzw.zzcM().m15114a((Map) hashMap);
    }

    public static JSONObject m14689a(zzmn com_google_android_gms_internal_zzmn) {
        JSONObject jSONObject = new JSONObject();
        if (com_google_android_gms_internal_zzmn.f12036b != null) {
            jSONObject.put("ad_base_url", com_google_android_gms_internal_zzmn.f12036b);
        }
        if (com_google_android_gms_internal_zzmn.f12047m != null) {
            jSONObject.put("ad_size", com_google_android_gms_internal_zzmn.f12047m);
        }
        jSONObject.put("native", com_google_android_gms_internal_zzmn.f12054t);
        if (com_google_android_gms_internal_zzmn.f12054t) {
            jSONObject.put("ad_json", com_google_android_gms_internal_zzmn.f12037c);
        } else {
            jSONObject.put("ad_html", com_google_android_gms_internal_zzmn.f12037c);
        }
        if (com_google_android_gms_internal_zzmn.f12049o != null) {
            jSONObject.put("debug_dialog", com_google_android_gms_internal_zzmn.f12049o);
        }
        if (com_google_android_gms_internal_zzmn.f12031N != null) {
            jSONObject.put("debug_signals", com_google_android_gms_internal_zzmn.f12031N);
        }
        if (com_google_android_gms_internal_zzmn.f12041g != -1) {
            jSONObject.put("interstitial_timeout", ((double) com_google_android_gms_internal_zzmn.f12041g) / 1000.0d);
        }
        if (com_google_android_gms_internal_zzmn.f12046l == zzw.zzcO().mo4249b()) {
            jSONObject.put("orientation", "portrait");
        } else if (com_google_android_gms_internal_zzmn.f12046l == zzw.zzcO().mo4247a()) {
            jSONObject.put("orientation", "landscape");
        }
        if (com_google_android_gms_internal_zzmn.f12038d != null) {
            jSONObject.put("click_urls", m14687a(com_google_android_gms_internal_zzmn.f12038d));
        }
        if (com_google_android_gms_internal_zzmn.f12040f != null) {
            jSONObject.put("impression_urls", m14687a(com_google_android_gms_internal_zzmn.f12040f));
        }
        if (com_google_android_gms_internal_zzmn.f12044j != null) {
            jSONObject.put("manual_impression_urls", m14687a(com_google_android_gms_internal_zzmn.f12044j));
        }
        if (com_google_android_gms_internal_zzmn.f12052r != null) {
            jSONObject.put("active_view", com_google_android_gms_internal_zzmn.f12052r);
        }
        jSONObject.put("ad_is_javascript", com_google_android_gms_internal_zzmn.f12050p);
        if (com_google_android_gms_internal_zzmn.f12051q != null) {
            jSONObject.put("ad_passback_url", com_google_android_gms_internal_zzmn.f12051q);
        }
        jSONObject.put("mediation", com_google_android_gms_internal_zzmn.f12042h);
        jSONObject.put("custom_render_allowed", com_google_android_gms_internal_zzmn.f12053s);
        jSONObject.put("content_url_opted_out", com_google_android_gms_internal_zzmn.f12056v);
        jSONObject.put("content_vertical_opted_out", com_google_android_gms_internal_zzmn.f12032O);
        jSONObject.put("prefetch", com_google_android_gms_internal_zzmn.f12057w);
        if (com_google_android_gms_internal_zzmn.f12045k != -1) {
            jSONObject.put("refresh_interval_milliseconds", com_google_android_gms_internal_zzmn.f12045k);
        }
        if (com_google_android_gms_internal_zzmn.f12043i != -1) {
            jSONObject.put("mediation_config_cache_time_milliseconds", com_google_android_gms_internal_zzmn.f12043i);
        }
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzmn.f12060z)) {
            jSONObject.put("gws_query_id", com_google_android_gms_internal_zzmn.f12060z);
        }
        jSONObject.put("fluid", com_google_android_gms_internal_zzmn.f12018A ? "height" : "");
        jSONObject.put("native_express", com_google_android_gms_internal_zzmn.f12019B);
        if (com_google_android_gms_internal_zzmn.f12021D != null) {
            jSONObject.put("video_start_urls", m14687a(com_google_android_gms_internal_zzmn.f12021D));
        }
        if (com_google_android_gms_internal_zzmn.f12022E != null) {
            jSONObject.put("video_complete_urls", m14687a(com_google_android_gms_internal_zzmn.f12022E));
        }
        if (com_google_android_gms_internal_zzmn.f12020C != null) {
            jSONObject.put("rewards", com_google_android_gms_internal_zzmn.f12020C.m15395a());
        }
        jSONObject.put("use_displayed_impression", com_google_android_gms_internal_zzmn.f12023F);
        jSONObject.put("auto_protection_configuration", com_google_android_gms_internal_zzmn.f12024G);
        jSONObject.put("render_in_browser", com_google_android_gms_internal_zzmn.f12028K);
        return jSONObject;
    }

    private static void m14690a(Context context, HashMap<String, Object> hashMap, zzqh com_google_android_gms_internal_zzqh) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle2.putString("cl", "155828604");
        bundle2.putString("rapid_rc", "dev");
        bundle2.putString("rapid_rollup", "HEAD");
        bundle.putBundle("build_meta", bundle2);
        bundle.putString("mf", Boolean.toString(((Boolean) qb.ca.m13225c()).booleanValue()));
        bundle.putBoolean("instant_app", bm.m9120b(context).m9115a());
        bundle.putBoolean("lite", com_google_android_gms_internal_zzqh.f12085e);
        hashMap.put("sdk_env", bundle);
    }

    private static void m14691a(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static void m14692a(HashMap<String, Object> hashMap, wy wyVar, Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("doritos", wyVar.f11227f);
        if (((Boolean) qb.aM.m13225c()).booleanValue()) {
            Object obj = null;
            boolean z = false;
            if (wyVar.f11229h != null) {
                obj = wyVar.f11229h.getId();
                z = wyVar.f11229h.isLimitAdTrackingEnabled();
            }
            if (TextUtils.isEmpty(obj)) {
                bundle.putString("pdid", ol.m12979a().m8412b(context));
                bundle.putString("pdidtype", "ssaid");
            } else {
                bundle.putString("rdid", obj);
                bundle.putBoolean("is_lat", z);
                bundle.putString("idtype", "adid");
            }
        }
        hashMap.put("pii", bundle);
    }

    private static void m14693a(HashMap<String, Object> hashMap, xg xgVar, C3438a c3438a, Bundle bundle, Bundle bundle2) {
        hashMap.put("am", Integer.valueOf(xgVar.f11394a));
        hashMap.put("cog", m14683a(xgVar.f11395b));
        hashMap.put("coh", m14683a(xgVar.f11396c));
        if (!TextUtils.isEmpty(xgVar.f11397d)) {
            hashMap.put("carrier", xgVar.f11397d);
        }
        hashMap.put("gl", xgVar.f11398e);
        if (xgVar.f11399f) {
            hashMap.put("simulator", Integer.valueOf(1));
        }
        if (xgVar.f11400g) {
            hashMap.put("is_sidewinder", Integer.valueOf(1));
        }
        hashMap.put("ma", m14683a(xgVar.f11401h));
        hashMap.put("sp", m14683a(xgVar.f11402i));
        hashMap.put("hl", xgVar.f11403j);
        if (!TextUtils.isEmpty(xgVar.f11404k)) {
            hashMap.put("mv", xgVar.f11404k);
        }
        hashMap.put("muv", Integer.valueOf(xgVar.f11405l));
        if (xgVar.f11406m != -2) {
            hashMap.put("cnt", Integer.valueOf(xgVar.f11406m));
        }
        hashMap.put("gnt", Integer.valueOf(xgVar.f11407n));
        hashMap.put("pt", Integer.valueOf(xgVar.f11408o));
        hashMap.put("rm", Integer.valueOf(xgVar.f11409p));
        hashMap.put("riv", Integer.valueOf(xgVar.f11410q));
        Bundle bundle3 = new Bundle();
        bundle3.putString("build", xgVar.f11418y);
        Bundle bundle4 = new Bundle();
        bundle4.putBoolean("is_charging", xgVar.f11415v);
        bundle4.putDouble("battery_level", xgVar.f11414u);
        bundle3.putBundle("battery", bundle4);
        bundle4 = new Bundle();
        bundle4.putInt("active_network_state", xgVar.f11417x);
        bundle4.putBoolean("active_network_metered", xgVar.f11416w);
        if (c3438a != null) {
            Bundle bundle5 = new Bundle();
            bundle5.putInt("predicted_latency_micros", c3438a.f11425a);
            bundle5.putLong("predicted_down_throughput_bps", c3438a.f11426b);
            bundle5.putLong("predicted_up_throughput_bps", c3438a.f11427c);
            bundle4.putBundle("predictions", bundle5);
        }
        bundle3.putBundle("network", bundle4);
        bundle4 = new Bundle();
        bundle4.putBoolean("is_browser_custom_tabs_capable", xgVar.f11419z);
        bundle3.putBundle("browser", bundle4);
        if (bundle != null) {
            bundle3.putBundle("android_mem_info", m14681a(bundle));
        }
        bundle4 = new Bundle();
        bundle4.putBundle("parental_controls", bundle2);
        bundle3.putBundle("play_store", bundle4);
        hashMap.put("device", bundle3);
    }

    private static void m14694a(HashMap<String, Object> hashMap, zzec com_google_android_gms_internal_zzec) {
        String a = zf.m15048a();
        if (a != null) {
            hashMap.put("abf", a);
        }
        if (com_google_android_gms_internal_zzec.f11878b != -1) {
            hashMap.put("cust_age", f11309a.format(new Date(com_google_android_gms_internal_zzec.f11878b)));
        }
        if (com_google_android_gms_internal_zzec.f11879c != null) {
            hashMap.put("extras", com_google_android_gms_internal_zzec.f11879c);
        }
        if (com_google_android_gms_internal_zzec.f11880d != -1) {
            hashMap.put("cust_gender", Integer.valueOf(com_google_android_gms_internal_zzec.f11880d));
        }
        if (com_google_android_gms_internal_zzec.f11881e != null) {
            hashMap.put("kw", com_google_android_gms_internal_zzec.f11881e);
        }
        if (com_google_android_gms_internal_zzec.f11883g != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(com_google_android_gms_internal_zzec.f11883g));
        }
        if (com_google_android_gms_internal_zzec.f11882f) {
            hashMap.put("adtest", "on");
        }
        if (com_google_android_gms_internal_zzec.f11877a >= 2) {
            if (com_google_android_gms_internal_zzec.f11884h) {
                hashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzec.f11885i)) {
                hashMap.put("ppid", com_google_android_gms_internal_zzec.f11885i);
            }
            if (com_google_android_gms_internal_zzec.f11886j != null) {
                m14695a((HashMap) hashMap, com_google_android_gms_internal_zzec.f11886j);
            }
        }
        if (com_google_android_gms_internal_zzec.f11877a >= 3 && com_google_android_gms_internal_zzec.f11888l != null) {
            hashMap.put("url", com_google_android_gms_internal_zzec.f11888l);
        }
        if (com_google_android_gms_internal_zzec.f11877a >= 5) {
            if (com_google_android_gms_internal_zzec.f11890n != null) {
                hashMap.put("custom_targeting", com_google_android_gms_internal_zzec.f11890n);
            }
            if (com_google_android_gms_internal_zzec.f11891o != null) {
                hashMap.put("category_exclusions", com_google_android_gms_internal_zzec.f11891o);
            }
            if (com_google_android_gms_internal_zzec.f11892p != null) {
                hashMap.put("request_agent", com_google_android_gms_internal_zzec.f11892p);
            }
        }
        if (com_google_android_gms_internal_zzec.f11877a >= 6 && com_google_android_gms_internal_zzec.f11893q != null) {
            hashMap.put("request_pkg", com_google_android_gms_internal_zzec.f11893q);
        }
        if (com_google_android_gms_internal_zzec.f11877a >= 7) {
            hashMap.put("is_designed_for_families", Boolean.valueOf(com_google_android_gms_internal_zzec.f11894r));
        }
    }

    private static void m14695a(HashMap<String, Object> hashMap, zzfp com_google_android_gms_internal_zzfp) {
        Object obj;
        Object obj2 = null;
        if (Color.alpha(com_google_android_gms_internal_zzfp.f11906a) != 0) {
            hashMap.put("acolor", m14684a(com_google_android_gms_internal_zzfp.f11906a));
        }
        if (Color.alpha(com_google_android_gms_internal_zzfp.f11907b) != 0) {
            hashMap.put("bgcolor", m14684a(com_google_android_gms_internal_zzfp.f11907b));
        }
        if (!(Color.alpha(com_google_android_gms_internal_zzfp.f11908c) == 0 || Color.alpha(com_google_android_gms_internal_zzfp.f11909d) == 0)) {
            hashMap.put("gradientto", m14684a(com_google_android_gms_internal_zzfp.f11908c));
            hashMap.put("gradientfrom", m14684a(com_google_android_gms_internal_zzfp.f11909d));
        }
        if (Color.alpha(com_google_android_gms_internal_zzfp.f11910e) != 0) {
            hashMap.put("bcolor", m14684a(com_google_android_gms_internal_zzfp.f11910e));
        }
        hashMap.put("bthick", Integer.toString(com_google_android_gms_internal_zzfp.f11911f));
        switch (com_google_android_gms_internal_zzfp.f11912g) {
            case 0:
                obj = "none";
                break;
            case 1:
                obj = "dashed";
                break;
            case 2:
                obj = "dotted";
                break;
            case 3:
                obj = "solid";
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            hashMap.put("btype", obj);
        }
        switch (com_google_android_gms_internal_zzfp.f11913h) {
            case 0:
                obj2 = "light";
                break;
            case 1:
                obj2 = "medium";
                break;
            case 2:
                obj2 = "dark";
                break;
        }
        if (obj2 != null) {
            hashMap.put("callbuttoncolor", obj2);
        }
        if (com_google_android_gms_internal_zzfp.f11914i != null) {
            hashMap.put("channel", com_google_android_gms_internal_zzfp.f11914i);
        }
        if (Color.alpha(com_google_android_gms_internal_zzfp.f11915j) != 0) {
            hashMap.put("dcolor", m14684a(com_google_android_gms_internal_zzfp.f11915j));
        }
        if (com_google_android_gms_internal_zzfp.f11916k != null) {
            hashMap.put("font", com_google_android_gms_internal_zzfp.f11916k);
        }
        if (Color.alpha(com_google_android_gms_internal_zzfp.f11917l) != 0) {
            hashMap.put("hcolor", m14684a(com_google_android_gms_internal_zzfp.f11917l));
        }
        hashMap.put("headersize", Integer.toString(com_google_android_gms_internal_zzfp.f11918m));
        if (com_google_android_gms_internal_zzfp.f11919n != null) {
            hashMap.put("q", com_google_android_gms_internal_zzfp.f11919n);
        }
    }

    private static void m14696a(HashMap<String, Object> hashMap, zzmk com_google_android_gms_internal_zzmk) {
        Object obj = 1;
        String str = com_google_android_gms_internal_zzmk.f11995d.f11895a;
        Object obj2 = (str.equals("interstitial_mb") || str.equals("reward_mb")) ? 1 : null;
        Bundle bundle = com_google_android_gms_internal_zzmk.f11987R;
        if (bundle == null) {
            obj = null;
        }
        if (obj2 != null && r2 != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putBundle("interstitial_pool", bundle);
            hashMap.put("counters", bundle2);
        }
    }
}
