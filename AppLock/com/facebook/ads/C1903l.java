package com.facebook.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.C1905m.C1904a;
import com.facebook.ads.internal.C1464c;
import com.facebook.ads.internal.C1540b;
import com.facebook.ads.internal.C1555d;
import com.facebook.ads.internal.C1558e;
import com.facebook.ads.internal.C1584g;
import com.facebook.ads.internal.C1668j;
import com.facebook.ads.internal.p018m.C1711g;
import com.facebook.ads.internal.p018m.C1717j;
import com.facebook.ads.internal.p018m.C1722n;
import com.facebook.ads.internal.p018m.C1722n.C1721b;
import com.facebook.ads.internal.p018m.C1723o;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p021b.C1490a;
import com.facebook.ads.internal.p021b.C1495h;
import com.facebook.ads.internal.p021b.aa;
import com.facebook.ads.internal.p021b.ab;
import com.facebook.ads.internal.p021b.ac;
import com.facebook.ads.internal.p023d.C1528a;
import com.facebook.ads.internal.p023d.C1551b;
import com.facebook.ads.internal.p024l.C1675a;
import com.facebook.ads.internal.p028g.C1577e;
import com.facebook.ads.internal.p034k.C1671a;
import com.facebook.ads.internal.p034k.C1671a.C1669a;
import com.facebook.ads.internal.view.C1864k;
import com.facebook.ads.internal.view.C1887n;
import com.facebook.ads.internal.view.C1888o;
import com.facebook.ads.internal.view.hscroll.C1871b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import org.json.JSONObject;

public class C1903l implements C1453b {
    private static final C1558e f4796b = C1558e.ADS;
    private static final String f4797c = C1903l.class.getSimpleName();
    private static WeakHashMap<View, WeakReference<C1903l>> f4798d = new WeakHashMap();
    private String f4799A;
    private boolean f4800B;
    @Nullable
    protected ab f4801a;
    private final Context f4802e;
    private final String f4803f;
    private final String f4804g;
    private final C1551b f4805h;
    private C0657e f4806i;
    private C1540b f4807j;
    private volatile boolean f4808k;
    private C1577e f4809l;
    private View f4810m;
    private final List<View> f4811n;
    private OnTouchListener f4812o;
    private C1671a f4813p;
    private final C1711g f4814q;
    @Nullable
    private aa f4815r;
    private C1901d f4816s;
    private C1902e f4817t;
    private C1888o f4818u;
    private C1904a f4819v;
    private boolean f4820w;
    private MediaView f4821x;
    @Deprecated
    private boolean f4822y;
    private long f4823z;

    class C18932 implements C1887n {
        final /* synthetic */ C1903l f4776a;

        C18932(C1903l c1903l) {
            this.f4776a = c1903l;
        }

        public void mo2841a(int i) {
            if (this.f4776a.f4801a != null) {
                this.f4776a.f4801a.mo2675a(i);
            }
        }
    }

    class C18943 extends C1669a {
        final /* synthetic */ C1903l f4777a;

        C18943(C1903l c1903l) {
            this.f4777a = c1903l;
        }

        public void mo2782a() {
            this.f4777a.f4814q.m4918a();
            this.f4777a.f4813p.m4761b();
            if (this.f4777a.f4815r != null) {
                this.f4777a.f4815r.m3881a(this.f4777a.f4810m);
                this.f4777a.f4815r.m3882a(this.f4777a.f4819v);
                this.f4777a.f4815r.m3885a(this.f4777a.f4820w);
                this.f4777a.f4815r.m3886b(this.f4777a.f4821x != null);
                this.f4777a.f4815r.m3887c(this.f4777a.m5400x());
                this.f4777a.f4815r.m3876a();
            } else if (this.f4777a.f4813p != null) {
                this.f4777a.f4813p.m4761b();
                this.f4777a.f4813p = null;
            }
        }
    }

    class C18954 extends C1495h {
        final /* synthetic */ C1903l f4778a;

        C18954(C1903l c1903l) {
            this.f4778a = c1903l;
        }

        public boolean mo2842a() {
            return true;
        }
    }

    private class C1896f extends C1495h {
        final /* synthetic */ C1903l f4779b;

        private C1896f(C1903l c1903l) {
            this.f4779b = c1903l;
        }

        public boolean mo2842a() {
            return false;
        }

        public void mo2707d() {
            if (this.f4779b.f4806i != null) {
                this.f4779b.f4806i.mo2393c(this.f4779b);
            }
        }

        public void mo2843e() {
        }
    }

    class C18975 extends C1896f {
        final /* synthetic */ C1903l f4780a;

        C18975(C1903l c1903l) {
            this.f4780a = c1903l;
            super();
        }

        public boolean mo2844b() {
            return true;
        }

        public String mo2845c() {
            return this.f4780a.f4799A;
        }
    }

    public static class C1898a {
        private final String f4781a;
        private final int f4782b;
        private final int f4783c;

        public C1898a(String str, int i, int i2) {
            this.f4781a = str;
            this.f4782b = i;
            this.f4783c = i2;
        }

        public static C1898a m5366a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("url");
            return optString != null ? new C1898a(optString, jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)) : null;
        }

        public String m5367a() {
            return this.f4781a;
        }

        public int m5368b() {
            return this.f4782b;
        }

        public int m5369c() {
            return this.f4783c;
        }
    }

    public enum C1899b {
        NONE(0),
        ICON(1),
        IMAGE(2),
        VIDEO(3);
        
        public static final EnumSet<C1899b> f4788e = null;
        private final long f4790f;

        static {
            f4788e = EnumSet.allOf(C1899b.class);
        }

        private C1899b(long j) {
            this.f4790f = j;
        }
    }

    public static class C1900c {
        private final double f4791a;
        private final double f4792b;

        public C1900c(double d, double d2) {
            this.f4791a = d;
            this.f4792b = d2;
        }

        public static C1900c m5370a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            double optDouble = jSONObject.optDouble("value", 0.0d);
            double optDouble2 = jSONObject.optDouble("scale", 0.0d);
            return (optDouble == 0.0d || optDouble2 == 0.0d) ? null : new C1900c(optDouble, optDouble2);
        }
    }

    private class C1901d implements OnClickListener, OnTouchListener {
        final /* synthetic */ C1903l f4793a;

        private C1901d(C1903l c1903l) {
            this.f4793a = c1903l;
        }

        public void onClick(View view) {
            if (!this.f4793a.f4814q.m4923d()) {
                Log.e("FBAudienceNetworkLog", "No touch data recorded, please ensure touch events reach the ad View by returning false if you intercept the event.");
            }
            int k = C1668j.m4728k(this.f4793a.f4802e);
            if (k < 0 || this.f4793a.f4814q.m4922c() >= ((long) k)) {
                if ((view instanceof C1459c) || !this.f4793a.f4814q.m4920a(C1668j.m4729l(this.f4793a.f4802e))) {
                    Map hashMap = new HashMap();
                    hashMap.put("touch", C1729s.m4963a(this.f4793a.f4814q.m4924e()));
                    if (this.f4793a.f4819v != null) {
                        hashMap.put("nti", String.valueOf(this.f4793a.f4819v.m5429a()));
                    }
                    if (this.f4793a.f4820w) {
                        hashMap.put("nhs", String.valueOf(this.f4793a.f4820w));
                    }
                    this.f4793a.f4813p.m4760a(hashMap);
                    this.f4793a.f4801a.mo2681b(hashMap);
                    return;
                }
                Log.e("FBAudienceNetworkLog", "Clicks are too close to the border of the view.");
            } else if (this.f4793a.f4814q.m4921b()) {
                Log.e("FBAudienceNetworkLog", "Clicks happened too fast.");
            } else {
                Log.e("FBAudienceNetworkLog", "Ad cannot be clicked before it is viewed.");
            }
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f4793a.f4814q.m4919a(motionEvent, this.f4793a.f4810m, view);
            return this.f4793a.f4812o != null && this.f4793a.f4812o.onTouch(view, motionEvent);
        }
    }

    private class C1902e extends BroadcastReceiver {
        final /* synthetic */ C1903l f4794a;
        private boolean f4795b;

        private C1902e(C1903l c1903l) {
            this.f4794a = c1903l;
        }

        public void m5371a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.facebook.ads.native.impression:" + this.f4794a.f4804g);
            intentFilter.addAction("com.facebook.ads.native.click:" + this.f4794a.f4804g);
            LocalBroadcastManager.getInstance(this.f4794a.f4802e).registerReceiver(this, intentFilter);
            this.f4795b = true;
        }

        public void m5372b() {
            if (this.f4795b) {
                try {
                    LocalBroadcastManager.getInstance(this.f4794a.f4802e).unregisterReceiver(this);
                } catch (Exception e) {
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            Object obj = intent.getAction().split(":")[0];
            if ("com.facebook.ads.native.impression".equals(obj) && this.f4794a.f4815r != null) {
                this.f4794a.f4815r.m3876a();
            } else if ("com.facebook.ads.native.click".equals(obj) && this.f4794a.f4801a != null) {
                Map hashMap = new HashMap();
                hashMap.put("mil", String.valueOf(true));
                this.f4794a.f4801a.mo2681b(hashMap);
            }
        }
    }

    public C1903l(Context context, ab abVar, C1577e c1577e) {
        this(context, null);
        this.f4809l = c1577e;
        this.f4808k = true;
        this.f4801a = abVar;
    }

    public C1903l(Context context, String str) {
        this.f4804g = UUID.randomUUID().toString();
        this.f4811n = new ArrayList();
        this.f4814q = new C1711g();
        this.f4800B = false;
        this.f4802e = context;
        this.f4803f = str;
        this.f4805h = new C1551b(context);
    }

    private void m5373A() {
        if (this.f4800B) {
            this.f4815r = new aa(this.f4802e, new C18975(this), this.f4813p, this.f4801a);
        }
    }

    public static void m5376a(C1898a c1898a, ImageView imageView) {
        if (c1898a != null && imageView != null) {
            new com.facebook.ads.internal.p018m.ab(imageView).m4809a(c1898a.m5367a());
        }
    }

    private void m5377a(List<View> list, View view) {
        if (!(view instanceof C1864k) && !(view instanceof C1459c) && !(view instanceof C1871b)) {
            list.add(view);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    m5377a((List) list, viewGroup.getChildAt(i));
                }
            }
        }
    }

    private void m5379b(View view) {
        this.f4811n.add(view);
        view.setOnClickListener(this.f4816s);
        view.setOnTouchListener(this.f4816s);
    }

    private int m5396t() {
        return this.f4809l != null ? this.f4809l.m4392e() : (this.f4807j == null || this.f4807j.m4262a() == null) ? 1 : this.f4807j.m4262a().m4392e();
    }

    private int m5397u() {
        return this.f4809l != null ? this.f4809l.m4393f() : (this.f4807j == null || this.f4807j.m4262a() == null) ? 0 : this.f4807j.m4262a().m4393f();
    }

    private int m5398v() {
        return this.f4809l != null ? this.f4809l.m4394g() : this.f4801a != null ? this.f4801a.mo2689j() : (this.f4807j == null || this.f4807j.m4262a() == null) ? 0 : this.f4807j.m4262a().m4394g();
    }

    private int m5399w() {
        return this.f4809l != null ? this.f4809l.m4395h() : this.f4801a != null ? this.f4801a.mo2690k() : (this.f4807j == null || this.f4807j.m4262a() == null) ? 1000 : this.f4807j.m4262a().m4395h();
    }

    private boolean m5400x() {
        return m5425p() == C1717j.UNKNOWN ? this.f4822y : m5425p() == C1717j.ON;
    }

    private void m5401y() {
        for (View view : this.f4811n) {
            view.setOnClickListener(null);
            view.setOnTouchListener(null);
        }
        this.f4811n.clear();
    }

    private void m5402z() {
        if (this.f4801a != null && this.f4801a.mo2684e()) {
            this.f4817t = new C1902e();
            this.f4817t.m5371a();
            this.f4815r = new aa(this.f4802e, new C18954(this), this.f4813p, this.f4801a);
        }
    }

    ab m5403a() {
        return this.f4801a;
    }

    public void m5404a(View view) {
        List arrayList = new ArrayList();
        m5377a(arrayList, view);
        m5405a(view, arrayList);
    }

    public void m5405a(View view, List<View> list) {
        if (view == null) {
            throw new IllegalArgumentException("Must provide a View");
        } else if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("Invalid set of clickable views");
        } else if (m5413d()) {
            if (this.f4810m != null) {
                Log.w(f4797c, "Native Ad was already registered with a View. Auto unregistering and proceeding.");
                m5428s();
            }
            if (f4798d.containsKey(view)) {
                Log.w(f4797c, "View already registered with a NativeAd. Auto unregistering and proceeding.");
                ((C1903l) ((WeakReference) f4798d.get(view)).get()).m5428s();
            }
            this.f4816s = new C1901d();
            this.f4810m = view;
            if (view instanceof ViewGroup) {
                this.f4818u = new C1888o(view.getContext(), new C18932(this));
                ((ViewGroup) view).addView(this.f4818u);
            }
            for (View b : list) {
                m5379b(b);
            }
            this.f4801a.mo2677a(view, list);
            this.f4813p = new C1671a(this.f4810m, m5396t(), m5397u(), true, new C18943(this));
            this.f4813p.m4759a(m5398v());
            this.f4813p.m4762b(m5399w());
            this.f4813p.m4758a();
            this.f4815r = new aa(this.f4802e, new C1896f(), this.f4813p, this.f4801a);
            this.f4815r.m3883a((List) list);
            f4798d.put(view, new WeakReference(this));
        } else {
            Log.e(f4797c, "Ad not loaded");
        }
    }

    void m5406a(MediaView mediaView) {
        this.f4821x = mediaView;
    }

    public void m5407a(C0657e c0657e) {
        this.f4806i = c0657e;
    }

    protected void m5408a(ac acVar) {
        this.f4801a.mo2678a(acVar);
    }

    public void m5409a(final EnumSet<C1899b> enumSet) {
        if (this.f4808k) {
            throw new IllegalStateException("loadAd cannot be called more than once");
        }
        this.f4823z = System.currentTimeMillis();
        this.f4808k = true;
        this.f4807j = new C1540b(this.f4802e, this.f4803f, C1584g.NATIVE_UNKNOWN, C1675a.NATIVE, null, f4796b, 1, true);
        this.f4807j.m4263a(new C1464c(this) {
            final /* synthetic */ C1903l f4775b;

            class C18912 implements ac {
                final /* synthetic */ C18921 f4773a;

                C18912(C18921 c18921) {
                    this.f4773a = c18921;
                }

                public void mo2661a(ab abVar) {
                }

                public void mo2662a(ab abVar, C1460d c1460d) {
                }

                public void mo2663b(ab abVar) {
                }

                public void mo2664c(ab abVar) {
                    if (this.f4773a.f4775b.f4806i != null) {
                        this.f4773a.f4775b.f4806i.mo2392b(this.f4773a.f4775b);
                    }
                }
            }

            public void mo2634a() {
                if (this.f4775b.f4806i != null) {
                    this.f4775b.f4806i.mo2392b(this.f4775b);
                }
            }

            public void mo2636a(C1490a c1490a) {
                if (this.f4775b.f4807j != null) {
                    this.f4775b.f4807j.m4267c();
                }
            }

            public void mo2840a(final ab abVar) {
                C1723o.m4943a(C1722n.m4939a(C1721b.LOADING_AD, C1675a.NATIVE, System.currentTimeMillis() - this.f4775b.f4823z, null));
                if (abVar != null) {
                    if (enumSet.contains(C1899b.ICON) && abVar.mo2691l() != null) {
                        this.f4775b.f4805h.m4308a(abVar.mo2691l().m5367a());
                    }
                    if (enumSet.contains(C1899b.IMAGE)) {
                        if (abVar.mo2692m() != null) {
                            this.f4775b.f4805h.m4308a(abVar.mo2692m().m5367a());
                        }
                        if (abVar.mo2703x() != null) {
                            for (C1903l c1903l : abVar.mo2703x()) {
                                if (c1903l.m5415f() != null) {
                                    this.f4775b.f4805h.m4308a(c1903l.m5415f().m5367a());
                                }
                            }
                        }
                    }
                    if (enumSet.contains(C1899b.VIDEO) && !TextUtils.isEmpty(abVar.mo2699t())) {
                        this.f4775b.f4805h.m4309b(abVar.mo2699t());
                    }
                    this.f4775b.f4805h.m4307a(new C1528a(this) {
                        final /* synthetic */ C18921 f4772b;

                        public void mo2723a() {
                            this.f4772b.f4775b.f4801a = abVar;
                            this.f4772b.f4775b.m5402z();
                            this.f4772b.f4775b.m5373A();
                            if (this.f4772b.f4775b.f4806i != null) {
                                this.f4772b.f4775b.f4806i.mo2390a(this.f4772b.f4775b);
                            }
                        }
                    });
                    if (this.f4775b.f4806i != null && abVar.mo2703x() != null) {
                        ac c18912 = new C18912(this);
                        for (C1903l c1903l2 : abVar.mo2703x()) {
                            c1903l2.m5408a(c18912);
                        }
                    }
                }
            }

            public void mo2637a(C1555d c1555d) {
                if (this.f4775b.f4806i != null) {
                    this.f4775b.f4806i.mo2391a(this.f4775b, c1555d.m4323b());
                }
            }

            public void mo2638b() {
                throw new IllegalStateException("Native ads manager their own impressions.");
            }
        });
        this.f4807j.m4266b();
    }

    @Deprecated
    public void m5410a(boolean z) {
        this.f4822y = z;
    }

    public void m5411b() {
        m5409a(EnumSet.of(C1899b.NONE));
    }

    public void m5412c() {
        if (this.f4817t != null) {
            this.f4817t.m5372b();
            this.f4817t = null;
        }
        if (this.f4807j != null) {
            this.f4807j.m4268d();
            this.f4807j = null;
        }
        if (this.f4821x != null) {
            this.f4821x.m3741a();
            this.f4821x = null;
        }
    }

    public boolean m5413d() {
        return this.f4801a != null && this.f4801a.mo2683d();
    }

    public C1898a m5414e() {
        return !m5413d() ? null : this.f4801a.mo2691l();
    }

    public C1898a m5415f() {
        return !m5413d() ? null : this.f4801a.mo2692m();
    }

    public String m5416g() {
        return !m5413d() ? null : this.f4801a.mo2693n();
    }

    public String m5417h() {
        return !m5413d() ? null : this.f4801a.mo2694o();
    }

    public String m5418i() {
        return !m5413d() ? null : this.f4801a.mo2695p();
    }

    public C1898a m5419j() {
        return !m5413d() ? null : this.f4801a.mo2696q();
    }

    public String m5420k() {
        return !m5413d() ? null : this.f4801a.mo2697r();
    }

    String m5421l() {
        return !m5413d() ? null : this.f4801a.mo2698s();
    }

    String m5422m() {
        return (!m5413d() || TextUtils.isEmpty(this.f4801a.mo2699t())) ? null : this.f4805h.m4310c(this.f4801a.mo2699t());
    }

    String m5423n() {
        return !m5413d() ? null : this.f4801a.mo2700u();
    }

    String m5424o() {
        return !m5413d() ? null : this.f4801a.mo2702w();
    }

    C1717j m5425p() {
        return !m5413d() ? C1717j.UNKNOWN : this.f4801a.mo2701v();
    }

    List<C1903l> m5426q() {
        return !m5413d() ? null : this.f4801a.mo2703x();
    }

    @Nullable
    String m5427r() {
        return !m5413d() ? null : this.f4801a.mo2704y();
    }

    public void m5428s() {
        if (this.f4810m != null) {
            if (f4798d.containsKey(this.f4810m) && ((WeakReference) f4798d.get(this.f4810m)).get() == this) {
                if ((this.f4810m instanceof ViewGroup) && this.f4818u != null) {
                    ((ViewGroup) this.f4810m).removeView(this.f4818u);
                    this.f4818u = null;
                }
                if (this.f4801a != null) {
                    this.f4801a.mo2682c();
                }
                f4798d.remove(this.f4810m);
                m5401y();
                this.f4810m = null;
                if (this.f4813p != null) {
                    this.f4813p.m4761b();
                    this.f4813p = null;
                }
                this.f4815r = null;
                return;
            }
            throw new IllegalStateException("View not registered with this NativeAd");
        }
    }
}
