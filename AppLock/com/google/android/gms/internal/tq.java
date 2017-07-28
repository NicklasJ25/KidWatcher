package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@wh
public final class tq {
    public final String f10771a;
    public final String f10772b;
    public final List<String> f10773c;
    public final String f10774d;
    public final String f10775e;
    public final List<String> f10776f;
    public final List<String> f10777g;
    public final List<String> f10778h;
    public final String f10779i;
    public final List<String> f10780j;
    public final List<String> f10781k;
    @Nullable
    public final String f10782l;
    @Nullable
    public final String f10783m;
    public final String f10784n;
    @Nullable
    public final List<String> f10785o;
    public final String f10786p;

    public tq(String str, String str2, List<String> list, String str3, String str4, List<String> list2, List<String> list3, String str5, String str6, List<String> list4, List<String> list5, String str7, String str8, String str9, List<String> list6, String str10, List<String> list7) {
        this.f10771a = str;
        this.f10772b = str2;
        this.f10773c = list;
        this.f10774d = str3;
        this.f10775e = str4;
        this.f10776f = list2;
        this.f10777g = list3;
        this.f10779i = str5;
        this.f10780j = list4;
        this.f10781k = list5;
        this.f10782l = str7;
        this.f10783m = str8;
        this.f10784n = str9;
        this.f10785o = list6;
        this.f10786p = str10;
        this.f10778h = list7;
    }

    public tq(JSONObject jSONObject) {
        String str = null;
        this.f10772b = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.f10773c = Collections.unmodifiableList(arrayList);
        this.f10774d = jSONObject.optString("allocation_id", null);
        this.f10776f = zzw.zzdf().m14033a(jSONObject, "clickurl");
        this.f10777g = zzw.zzdf().m14033a(jSONObject, "imp_urls");
        this.f10778h = zzw.zzdf().m14033a(jSONObject, "fill_urls");
        this.f10780j = zzw.zzdf().m14033a(jSONObject, "video_start_urls");
        this.f10781k = zzw.zzdf().m14033a(jSONObject, "video_complete_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        this.f10771a = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.f10779i = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.f10775e = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.f10782l = jSONObject.optString("html_template", null);
        this.f10783m = jSONObject.optString("ad_base_url", null);
        optJSONObject = jSONObject.optJSONObject("assets");
        this.f10784n = optJSONObject != null ? optJSONObject.toString() : null;
        this.f10785o = zzw.zzdf().m14033a(jSONObject, "template_ids");
        optJSONObject = jSONObject.optJSONObject("ad_loader_options");
        if (optJSONObject != null) {
            str = optJSONObject.toString();
        }
        this.f10786p = str;
    }
}
