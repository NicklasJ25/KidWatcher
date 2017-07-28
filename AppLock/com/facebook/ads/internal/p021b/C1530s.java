package com.facebook.ads.internal.p021b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkActivity.C1449b;
import com.facebook.ads.C1460d;
import com.facebook.ads.C1462f;
import com.facebook.ads.internal.C1668j;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p023d.C1528a;
import com.facebook.ads.internal.p023d.C1551b;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class C1530s extends ad {
    private ae f3658b;
    private Context f3659c;
    private boolean f3660d = false;
    private String f3661e;
    private String f3662f;
    private String f3663g;
    private String f3664h = UUID.randomUUID().toString();
    private String f3665i;
    private String f3666j;
    private String f3667k;
    private String f3668l;
    private String f3669m;
    private String f3670n;
    private String f3671o;
    private af f3672p;
    private C1551b f3673q;

    class C15291 implements C1528a {
        final /* synthetic */ C1530s f3657a;

        C15291(C1530s c1530s) {
            this.f3657a = c1530s;
        }

        public void mo2723a() {
            this.f3657a.f3660d = true;
            this.f3657a.f3658b.mo2644a(this.f3657a);
        }
    }

    private void m4127e() {
        LocalBroadcastManager.getInstance(this.f3659c).registerReceiver(this.f3672p, this.f3672p.m3921a());
    }

    private void m4128f() {
        if (this.f3672p != null) {
            try {
                LocalBroadcastManager.getInstance(this.f3659c).unregisterReceiver(this.f3672p);
            } catch (Exception e) {
            }
        }
    }

    private String m4129g() {
        if (this.a == null) {
            return null;
        }
        String a = C1462f.m3759a();
        if (a == null || a.isEmpty()) {
            a = "https://www.facebook.com/audience_network/server_side_reward";
        } else {
            a = String.format("https://www.%s.facebook.com/audience_network/server_side_reward", new Object[]{a});
        }
        Uri parse = Uri.parse(a);
        Builder builder = new Builder();
        builder.scheme(parse.getScheme());
        builder.authority(parse.getAuthority());
        builder.path(parse.getPath());
        builder.query(parse.getQuery());
        builder.fragment(parse.getFragment());
        builder.appendQueryParameter("puid", this.a.m5430a());
        builder.appendQueryParameter("pc", this.a.m5431b());
        builder.appendQueryParameter("ptid", this.f3664h);
        builder.appendQueryParameter("appid", this.f3669m);
        return builder.build().toString();
    }

    private String m4130h() {
        return this.f3670n;
    }

    public void mo2724a(Context context, ae aeVar, Map<String, Object> map) {
        this.f3658b = aeVar;
        this.f3659c = context;
        this.f3660d = false;
        JSONObject jSONObject = (JSONObject) map.get("data");
        this.f3665i = jSONObject.optString("video_url");
        if (this.f3665i == null || this.f3665i.isEmpty()) {
            this.f3658b.mo2645a(this, C1460d.f3367e);
            return;
        }
        this.f3666j = jSONObject.optString("video_report_url");
        this.f3671o = jSONObject.optString("ct");
        this.f3667k = jSONObject.optString("end_card_markup");
        this.f3668l = jSONObject.optString("activation_command");
        this.f3670n = jSONObject.optString("context_switch", "endvideo");
        this.f3663g = jSONObject.optString("title");
        this.f3662f = jSONObject.optString("subtitle");
        if (jSONObject.has("icon") && !jSONObject.isNull("icon")) {
            try {
                this.f3661e = jSONObject.getJSONObject("icon").getString("url");
            } catch (Throwable e) {
                Log.w(C1530s.class.toString(), "Failed to get adIconURL", e);
            }
        }
        String str = (String) map.get("placement_id");
        if (str != null) {
            this.f3669m = str.split("_")[0];
        } else {
            this.f3669m = "";
        }
        this.f3672p = new af(this.f3664h, this, aeVar);
        m4127e();
        this.f3673q = new C1551b(context);
        this.f3673q.m4309b(this.f3665i);
        this.f3673q.m4307a(new C15291(this));
    }

    public void mo2680b() {
        m4128f();
    }

    public String m4133c() {
        Object obj = "";
        if (this.f3673q != null) {
            obj = this.f3673q.m4310c(this.f3665i);
        }
        return TextUtils.isEmpty(obj) ? this.f3665i : obj;
    }

    public boolean mo2725d() {
        if (!this.f3660d) {
            return false;
        }
        Intent intent = new Intent(this.f3659c, AudienceNetworkActivity.class);
        intent.putExtra("viewType", C1449b.REWARDED_VIDEO);
        intent.putExtra("videoURL", m4133c());
        intent.putExtra("videoReportURL", this.f3666j);
        if (!C1668j.m4726i(this.f3659c)) {
            intent.putExtra("predefinedOrientationKey", 6);
        }
        intent.putExtra("facebookRewardedVideoEndCardActivationCommand", this.f3668l);
        intent.putExtra("uniqueId", this.f3664h);
        intent.putExtra("facebookRewardedVideoEndCardMarkup", C1729s.m4974a(this.f3667k));
        intent.putExtra("clientToken", this.f3671o);
        intent.putExtra("rewardServerURL", m4129g());
        intent.putExtra("contextSwitchBehavior", m4130h());
        intent.putExtra("adTitle", this.f3663g);
        intent.putExtra("adSubtitle", this.f3662f);
        intent.putExtra("adIconUrl", this.f3661e);
        if (!(this.f3659c instanceof Activity)) {
            intent.setFlags(intent.getFlags() | 268435456);
        }
        this.f3659c.startActivity(intent);
        return true;
    }
}
