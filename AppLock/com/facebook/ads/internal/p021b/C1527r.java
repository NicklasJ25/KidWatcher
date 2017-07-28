package com.facebook.ads.internal.p021b;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.facebook.ads.C1460d;
import com.facebook.ads.C1903l;
import com.facebook.ads.C1903l.C1898a;
import com.facebook.ads.C1903l.C1900c;
import com.facebook.ads.C1906n;
import com.facebook.ads.internal.C1668j;
import com.facebook.ads.internal.p018m.C1717j;
import com.facebook.ads.internal.p018m.C1719m;
import com.facebook.ads.internal.p018m.C1722n;
import com.facebook.ads.internal.p018m.C1722n.C1720a;
import com.facebook.ads.internal.p018m.C1723o;
import com.facebook.ads.internal.p018m.C1726q;
import com.facebook.ads.internal.p018m.C1727r;
import com.facebook.ads.internal.p018m.C1727r.C1526a;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p020a.C1468a;
import com.facebook.ads.internal.p020a.C1469b;
import com.facebook.ads.internal.p022h.C1597f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C1527r extends ab implements C1526a {
    private static final String f3615a = C1527r.class.getSimpleName();
    private C1898a f3616A;
    private String f3617B;
    private String f3618C;
    private C1906n f3619D;
    private List<C1903l> f3620E;
    private int f3621F;
    private int f3622G;
    private String f3623H;
    private boolean f3624I;
    private boolean f3625J;
    private boolean f3626K;
    private boolean f3627L;
    private boolean f3628M;
    private long f3629N = 0;
    private C1720a f3630O = null;
    @Nullable
    private C1597f f3631P;
    private Context f3632b;
    private ac f3633c;
    private Uri f3634d;
    private String f3635e;
    private String f3636f;
    private String f3637g;
    private String f3638h;
    private String f3639i;
    private C1898a f3640j;
    private C1898a f3641k;
    private C1900c f3642l;
    private String f3643m;
    private C1726q f3644n;
    private Collection<String> f3645o;
    private boolean f3646p;
    private boolean f3647q;
    private boolean f3648r;
    private int f3649s;
    private int f3650t;
    private int f3651u;
    private int f3652v;
    private String f3653w;
    private String f3654x;
    private C1717j f3655y;
    private String f3656z;

    private boolean m4083B() {
        return this.f3635e != null && this.f3635e.length() > 0 && this.f3638h != null && this.f3638h.length() > 0 && ((this.f3640j != null || this.f3624I) && this.f3641k != null);
    }

    private void m4084C() {
        if (!this.f3628M) {
            if (this.f3631P != null) {
                this.f3631P.mo2738a(this.f3643m);
            }
            this.f3628M = true;
        }
    }

    private void m4086a(Context context, JSONObject jSONObject, C1597f c1597f, String str, int i, int i2) {
        this.f3624I = true;
        this.f3632b = context;
        this.f3631P = c1597f;
        this.f3621F = i;
        this.f3622G = i2;
        m4088a(jSONObject, str);
    }

    private void m4087a(Map<String, String> map, final Map<String, String> map2) {
        try {
            final Map c = m4090c(map);
            new Handler().postDelayed(new Runnable(this) {
                final /* synthetic */ C1527r f3614c;

                public void run() {
                    if (!TextUtils.isEmpty(this.f3614c.f3623H)) {
                        Map hashMap = new HashMap();
                        hashMap.putAll(map2);
                        hashMap.putAll(c);
                        if (this.f3614c.f3631P != null) {
                            this.f3614c.f3631P.mo2745d(this.f3614c.f3623H, hashMap);
                        }
                    }
                }
            }, (long) (this.f3649s * 1000));
        } catch (Exception e) {
        }
    }

    private void m4088a(JSONObject jSONObject, String str) {
        JSONArray jSONArray = null;
        int i = 0;
        if (this.f3625J) {
            throw new IllegalStateException("Adapter already loaded data");
        } else if (jSONObject != null) {
            C1729s.m4971a(this.f3632b, "Audience Network Loaded");
            this.f3623H = str;
            this.f3634d = Uri.parse(C1729s.m4964a(jSONObject, "fbad_command"));
            this.f3635e = C1729s.m4964a(jSONObject, "title");
            this.f3636f = C1729s.m4964a(jSONObject, "subtitle");
            this.f3637g = C1729s.m4964a(jSONObject, "body");
            this.f3638h = C1729s.m4964a(jSONObject, "call_to_action");
            this.f3639i = C1729s.m4964a(jSONObject, "social_context");
            this.f3640j = C1898a.m5366a(jSONObject.optJSONObject("icon"));
            this.f3641k = C1898a.m5366a(jSONObject.optJSONObject("image"));
            this.f3642l = C1900c.m5370a(jSONObject.optJSONObject("star_rating"));
            this.f3643m = C1729s.m4964a(jSONObject, "used_report_url");
            this.f3646p = jSONObject.optBoolean("manual_imp");
            this.f3647q = jSONObject.optBoolean("enable_view_log");
            this.f3648r = jSONObject.optBoolean("enable_snapshot_log");
            this.f3649s = jSONObject.optInt("snapshot_log_delay_second", 4);
            this.f3650t = jSONObject.optInt("snapshot_compress_quality", 0);
            this.f3651u = jSONObject.optInt("viewability_check_initial_delay", 0);
            this.f3652v = jSONObject.optInt("viewability_check_interval", 1000);
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_choices_icon");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("native_ui_config");
            C1906n c1906n = (optJSONObject2 == null || optJSONObject2.length() == 0) ? null : new C1906n(optJSONObject2);
            this.f3619D = c1906n;
            if (optJSONObject != null) {
                this.f3616A = C1898a.m5366a(optJSONObject);
            }
            this.f3617B = C1729s.m4964a(jSONObject, "ad_choices_link_url");
            this.f3618C = C1729s.m4964a(jSONObject, "request_id");
            this.f3644n = C1726q.m4951a(jSONObject.optString("invalidation_behavior"));
            try {
                jSONArray = new JSONArray(jSONObject.optString("detection_strings"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.f3645o = C1727r.m4952a(jSONArray);
            this.f3653w = C1729s.m4964a(jSONObject, "video_url");
            this.f3654x = C1729s.m4964a(jSONObject, "video_mpd");
            if (jSONObject.has("video_autoplay_enabled")) {
                this.f3655y = jSONObject.optBoolean("video_autoplay_enabled") ? C1717j.ON : C1717j.OFF;
            } else {
                this.f3655y = C1717j.UNKNOWN;
            }
            this.f3656z = C1729s.m4964a(jSONObject, "video_report_url");
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("carousel");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    List arrayList = new ArrayList(length);
                    while (i < length) {
                        ab c1527r = new C1527r();
                        c1527r.m4086a(this.f3632b, optJSONArray.getJSONObject(i), this.f3631P, str, i, length);
                        arrayList.add(new C1903l(this.f3632b, c1527r, null));
                        i++;
                    }
                    this.f3620E = arrayList;
                }
            } catch (Throwable e2) {
                Log.e(f3615a, "Unable to parse carousel data.", e2);
            }
            this.f3625J = true;
            this.f3626K = m4083B();
        }
    }

    private Map<String, String> m4090c(Map<String, String> map) {
        Map<String, String> hashMap = new HashMap();
        if (map.containsKey("view")) {
            hashMap.put("view", map.get("view"));
        }
        if (map.containsKey("snapshot")) {
            hashMap.put("snapshot", map.get("snapshot"));
        }
        return hashMap;
    }

    public Collection<String> mo2721A() {
        return this.f3645o;
    }

    public void mo2675a(int i) {
        if (mo2683d() && i == 0 && this.f3629N > 0 && this.f3630O != null) {
            C1723o.m4943a(C1722n.m4938a(this.f3629N, this.f3630O, this.f3618C));
            this.f3629N = 0;
            this.f3630O = null;
        }
    }

    public void mo2676a(Context context, ac acVar, C1597f c1597f, Map<String, Object> map) {
        this.f3632b = context;
        this.f3633c = acVar;
        this.f3631P = c1597f;
        JSONObject jSONObject = (JSONObject) map.get("data");
        m4088a(jSONObject, C1729s.m4964a(jSONObject, "ct"));
        if (C1727r.m4953a(context, (C1526a) this)) {
            acVar.mo2662a(this, C1460d.f3364b);
            return;
        }
        if (acVar != null) {
            acVar.mo2661a(this);
        }
        C1722n.f4338a = this.f3618C;
    }

    public void mo2677a(View view, List<View> list) {
    }

    public void mo2678a(ac acVar) {
        this.f3633c = acVar;
    }

    public void mo2679a(Map<String, String> map) {
        if (mo2683d() && !this.f3627L) {
            if (this.f3633c != null) {
                this.f3633c.mo2663b(this);
            }
            Map hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            if (this.f3624I) {
                hashMap.put("cardind", String.valueOf(this.f3621F));
                hashMap.put("cardcnt", String.valueOf(this.f3622G));
            }
            if (!(TextUtils.isEmpty(mo2704y()) || this.f3631P == null)) {
                this.f3631P.mo2739a(mo2704y(), hashMap);
            }
            if (mo2686g() || mo2685f()) {
                m4087a((Map) map, hashMap);
            }
            this.f3627L = true;
        }
    }

    public void mo2680b() {
    }

    public void mo2681b(Map<String, String> map) {
        if (!mo2683d()) {
            return;
        }
        if (C1668j.m4719b(this.f3632b) && C1719m.m4936b((Map) map)) {
            Log.e(f3615a, "Click happened on lockscreen ad");
            return;
        }
        Map hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        C1729s.m4971a(this.f3632b, "Click logged");
        if (this.f3633c != null) {
            this.f3633c.mo2664c(this);
        }
        if (this.f3624I) {
            hashMap.put("cardind", String.valueOf(this.f3621F));
            hashMap.put("cardcnt", String.valueOf(this.f3622G));
        }
        C1468a a = C1469b.m3801a(this.f3632b, this.f3623H, this.f3634d, hashMap);
        if (a != null) {
            try {
                this.f3629N = System.currentTimeMillis();
                this.f3630O = a.mo2641a();
                a.mo2642b();
            } catch (Throwable e) {
                Log.e(f3615a, "Error executing action", e);
            }
        }
    }

    public void mo2682c() {
    }

    public boolean mo2683d() {
        return this.f3625J && this.f3626K;
    }

    public boolean mo2684e() {
        return mo2683d() && this.f3646p;
    }

    public boolean mo2685f() {
        return mo2683d() && this.f3648r;
    }

    public boolean mo2686g() {
        return mo2683d() && this.f3647q;
    }

    public boolean mo2687h() {
        return true;
    }

    public int mo2688i() {
        return (this.f3650t < 0 || this.f3650t > 100) ? 0 : this.f3650t;
    }

    public int mo2689j() {
        return this.f3651u;
    }

    public int mo2690k() {
        return this.f3652v;
    }

    public C1898a mo2691l() {
        return !mo2683d() ? null : this.f3640j;
    }

    public C1898a mo2692m() {
        return !mo2683d() ? null : this.f3641k;
    }

    public String mo2693n() {
        if (!mo2683d()) {
            return null;
        }
        m4084C();
        return this.f3635e;
    }

    public String mo2694o() {
        if (!mo2683d()) {
            return null;
        }
        m4084C();
        return this.f3637g;
    }

    public String mo2695p() {
        if (!mo2683d()) {
            return null;
        }
        m4084C();
        return this.f3638h;
    }

    public C1898a mo2696q() {
        return !mo2683d() ? null : this.f3616A;
    }

    public String mo2697r() {
        return !mo2683d() ? null : this.f3617B;
    }

    public String mo2698s() {
        return !mo2683d() ? null : "AdChoices";
    }

    public String mo2699t() {
        return !mo2683d() ? null : this.f3653w;
    }

    public String mo2700u() {
        return !mo2683d() ? null : this.f3654x;
    }

    public C1717j mo2701v() {
        return !mo2683d() ? C1717j.UNKNOWN : this.f3655y;
    }

    public String mo2702w() {
        return this.f3656z;
    }

    public List<C1903l> mo2703x() {
        return !mo2683d() ? null : this.f3620E;
    }

    public String mo2704y() {
        return this.f3623H;
    }

    public C1726q mo2722z() {
        return this.f3644n;
    }
}
