package com.facebook.ads.internal.p021b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.facebook.ads.C1460d;
import com.facebook.ads.C1903l;
import com.facebook.ads.C1903l.C1898a;
import com.facebook.ads.internal.p018m.C1717j;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p018m.ah;
import com.facebook.ads.internal.p022h.C1597f;
import com.inmobi.ads.InMobiNative;
import com.inmobi.ads.InMobiNative.NativeAdListener;
import com.inmobi.sdk.InMobiSdk;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class C1537w extends ab implements C1500z {
    private ac f3704a;
    private InMobiNative f3705b;
    private boolean f3706c;
    private View f3707d;
    private String f3708e;
    private String f3709f;
    private String f3710g;
    private C1898a f3711h;
    private C1898a f3712i;

    public void mo2675a(int i) {
    }

    public void mo2676a(final Context context, ac acVar, C1597f c1597f, Map<String, Object> map) {
        C1729s.m4971a(context, ah.m4824a(mo2705z()) + " Loading");
        JSONObject jSONObject = (JSONObject) map.get("data");
        Object optString = jSONObject.optString("account_id");
        Long valueOf = Long.valueOf(jSONObject.optLong("placement_id"));
        if (TextUtils.isEmpty(optString) || valueOf == null) {
            acVar.mo2662a(this, C1460d.f3368f);
            return;
        }
        this.f3704a = acVar;
        InMobiSdk.init(context, optString);
        this.f3705b = new InMobiNative(valueOf.longValue(), new NativeAdListener(this) {
            final /* synthetic */ C1537w f3703b;
        });
        this.f3705b.load();
    }

    public void mo2677a(View view, List<View> list) {
        this.f3707d = view;
        if (mo2683d()) {
            InMobiNative inMobiNative = this.f3705b;
            InMobiNative.bind(this.f3707d, this.f3705b);
        }
    }

    public void mo2678a(ac acVar) {
        this.f3704a = acVar;
    }

    public void mo2679a(Map<String, String> map) {
        this.f3704a.mo2663b(this);
    }

    public void mo2680b() {
        mo2682c();
        this.f3705b = null;
        this.f3704a = null;
    }

    public void mo2681b(Map<String, String> map) {
        if (mo2683d()) {
            this.f3704a.mo2664c(this);
            this.f3705b.reportAdClickAndOpenLandingPage(null);
        }
    }

    public void mo2682c() {
        if (mo2683d()) {
            InMobiNative inMobiNative = this.f3705b;
            InMobiNative.unbind(this.f3707d);
        }
        this.f3707d = null;
    }

    public boolean mo2683d() {
        return this.f3705b != null && this.f3706c;
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
        return this.f3711h;
    }

    public C1898a mo2692m() {
        return this.f3712i;
    }

    public String mo2693n() {
        return this.f3708e;
    }

    public String mo2694o() {
        return this.f3709f;
    }

    public String mo2695p() {
        return this.f3710g;
    }

    public C1898a mo2696q() {
        return null;
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
        return C1504k.INMOBI;
    }
}
