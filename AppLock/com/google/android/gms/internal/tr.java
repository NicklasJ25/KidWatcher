package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@wh
public final class tr {
    public final List<tq> f10787a;
    public final long f10788b;
    public final List<String> f10789c;
    public final List<String> f10790d;
    public final List<String> f10791e;
    public final List<String> f10792f;
    public final boolean f10793g;
    public final String f10794h;
    public final long f10795i;
    public final String f10796j;
    public final int f10797k;
    public final int f10798l;
    public final long f10799m;
    public final boolean f10800n;
    public final boolean f10801o;
    public int f10802p;
    public int f10803q;

    public tr(String str) {
        this(new JSONObject(str));
    }

    public tr(List<tq> list, long j, List<String> list2, List<String> list3, List<String> list4, List<String> list5, boolean z, String str, long j2, int i, int i2, String str2, int i3, int i4, long j3, boolean z2) {
        this.f10787a = list;
        this.f10788b = j;
        this.f10789c = list2;
        this.f10790d = list3;
        this.f10791e = list4;
        this.f10792f = list5;
        this.f10793g = z;
        this.f10794h = str;
        this.f10795i = j2;
        this.f10802p = i;
        this.f10803q = i2;
        this.f10796j = str2;
        this.f10797k = i3;
        this.f10798l = i4;
        this.f10799m = j3;
        this.f10800n = z2;
        this.f10801o = false;
    }

    public tr(JSONObject jSONObject) {
        if (aad.m8420a(2)) {
            String str = "Mediation Response JSON: ";
            String valueOf = String.valueOf(jSONObject.toString(2));
            zh.m15051a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        List arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            tq tqVar = new tq(jSONArray.getJSONObject(i2));
            arrayList.add(tqVar);
            if (i < 0 && m13981a(tqVar)) {
                i = i2;
            }
        }
        this.f10802p = i;
        this.f10803q = jSONArray.length();
        this.f10787a = Collections.unmodifiableList(arrayList);
        this.f10794h = jSONObject.optString("qdata");
        this.f10798l = jSONObject.optInt("fs_model_type", -1);
        this.f10799m = jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.f10788b = optJSONObject.optLong("ad_network_timeout_millis", -1);
            this.f10789c = zzw.zzdf().m14033a(optJSONObject, "click_urls");
            this.f10790d = zzw.zzdf().m14033a(optJSONObject, "imp_urls");
            this.f10791e = zzw.zzdf().m14033a(optJSONObject, "nofill_urls");
            this.f10792f = zzw.zzdf().m14033a(optJSONObject, "remote_ping_urls");
            this.f10793g = optJSONObject.optBoolean("render_in_browser", false);
            long optLong = optJSONObject.optLong("refresh", -1);
            this.f10795i = optLong > 0 ? optLong * 1000 : -1;
            zzoo a = zzoo.m15394a(optJSONObject.optJSONArray("rewards"));
            if (a == null) {
                this.f10796j = null;
                this.f10797k = 0;
            } else {
                this.f10796j = a.f12074a;
                this.f10797k = a.f12075b;
            }
            this.f10800n = optJSONObject.optBoolean("use_displayed_impression", false);
            this.f10801o = optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            return;
        }
        this.f10788b = -1;
        this.f10789c = null;
        this.f10790d = null;
        this.f10791e = null;
        this.f10792f = null;
        this.f10795i = -1;
        this.f10796j = null;
        this.f10797k = 0;
        this.f10800n = false;
        this.f10793g = false;
        this.f10801o = false;
    }

    private boolean m13981a(tq tqVar) {
        for (String equals : tqVar.f10773c) {
            if (equals.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
