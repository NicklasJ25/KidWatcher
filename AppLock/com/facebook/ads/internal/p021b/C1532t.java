package com.facebook.ads.internal.p021b;

import android.content.Context;
import android.view.View;
import com.facebook.ads.C1903l;
import com.facebook.ads.C1903l.C1898a;
import com.facebook.ads.internal.p018m.C1717j;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p018m.ah;
import com.facebook.ads.internal.p022h.C1597f;
import com.flurry.android.FlurryAgent;
import com.flurry.android.ads.FlurryAdNative;
import com.flurry.android.ads.FlurryAdNativeListener;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class C1532t extends ab implements C1500z {
    private static volatile boolean f3676a;
    private ac f3677b;
    private FlurryAdNative f3678c;
    private boolean f3679d;
    private String f3680e;
    private String f3681f;
    private String f3682g;
    private C1898a f3683h;
    private C1898a f3684i;
    private C1898a f3685j;

    public void mo2675a(int i) {
    }

    public void mo2676a(final Context context, ac acVar, C1597f c1597f, Map<String, Object> map) {
        JSONObject jSONObject = (JSONObject) map.get("data");
        String optString = jSONObject.optString("api_key");
        String optString2 = jSONObject.optString("placement_id");
        synchronized (C1532t.class) {
            if (!f3676a) {
                C1729s.m4971a(context, ah.m4824a(mo2705z()) + " Initializing");
                FlurryAgent.setLogEnabled(true);
                FlurryAgent.init(context, optString);
                f3676a = true;
            }
        }
        C1729s.m4971a(context, ah.m4824a(mo2705z()) + " Loading");
        this.f3677b = acVar;
        this.f3678c = new FlurryAdNative(context, optString2);
        this.f3678c.setListener(new FlurryAdNativeListener(this) {
            final /* synthetic */ C1532t f3675b;
        });
        this.f3678c.fetchAd();
    }

    public void mo2677a(View view, List<View> list) {
        if (this.f3678c != null) {
            this.f3678c.setTrackingView(view);
        }
    }

    public void mo2678a(ac acVar) {
        this.f3677b = acVar;
    }

    public void mo2679a(Map<String, String> map) {
    }

    public void mo2680b() {
        mo2682c();
        this.f3677b = null;
        if (this.f3678c != null) {
            this.f3678c.destroy();
            this.f3678c = null;
        }
    }

    public void mo2681b(Map<String, String> map) {
    }

    public void mo2682c() {
        if (this.f3678c != null) {
            this.f3678c.removeTrackingView();
        }
    }

    public boolean mo2683d() {
        return this.f3679d;
    }

    public boolean mo2684e() {
        return false;
    }

    public boolean mo2685f() {
        return false;
    }

    public boolean mo2686g() {
        return false;
    }

    public boolean mo2687h() {
        return true;
    }

    public int mo2688i() {
        return 0;
    }

    public int mo2689j() {
        return 0;
    }

    public int mo2690k() {
        return 0;
    }

    public C1898a mo2691l() {
        return this.f3683h;
    }

    public C1898a mo2692m() {
        return this.f3684i;
    }

    public String mo2693n() {
        return this.f3680e;
    }

    public String mo2694o() {
        return this.f3681f;
    }

    public String mo2695p() {
        return this.f3682g;
    }

    public C1898a mo2696q() {
        return this.f3685j;
    }

    public String mo2697r() {
        return null;
    }

    public String mo2698s() {
        return "Ad";
    }

    public String mo2699t() {
        return null;
    }

    public String mo2700u() {
        return null;
    }

    public C1717j mo2701v() {
        return C1717j.UNKNOWN;
    }

    public String mo2702w() {
        return null;
    }

    public List<C1903l> mo2703x() {
        return null;
    }

    public String mo2704y() {
        return null;
    }

    public C1504k mo2705z() {
        return C1504k.YAHOO;
    }
}
