package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.android.gallery3d.exif.ExifTag.GpsMeasureMode;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.aau.C2340a;
import com.google.android.gms.internal.qz.C3180a;
import com.google.android.gms.internal.qz.C3181b;
import com.google.android.gms.internal.rd.C3178a;
import com.google.android.gms.internal.vy.C3196a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

@wh
public class ra implements qz {
    boolean f10407a;
    private final Object f10408b = new Object();
    private final zzs f10409c;
    private final Context f10410d;
    @Nullable
    private final JSONObject f10411e;
    @Nullable
    private final vy f10412f;
    @Nullable
    private final C3180a f10413g;
    private final ed f10414h;
    @Nullable
    private final zzqh f10415i;
    @Nullable
    private String f10416j;
    @Nullable
    private yr f10417k;
    private WeakReference<View> f10418l = null;

    private static class C3205a {
        private final WeakReference<aat> f10480a;
        private String f10481b;

        class C32045 extends C3196a {
            final /* synthetic */ C3205a f10479a;

            C32045(C3205a c3205a) {
                this.f10479a = c3205a;
            }

            public void mo3974a(tj tjVar) {
                aat com_google_android_gms_internal_aat = (aat) this.f10479a.f10480a.get();
                if (com_google_android_gms_internal_aat != null) {
                    tjVar.mo3402a("/loadHtml", this.f10479a.m13559a(tjVar));
                    tjVar.mo3402a("/showOverlay", this.f10479a.m13563b(tjVar));
                    tjVar.mo3402a("/hideOverlay", this.f10479a.m13566c(tjVar));
                    com_google_android_gms_internal_aat.mo3424l().m8552a("/sendMessageToSdk", this.f10479a.m13568d(tjVar));
                }
            }
        }

        public C3205a(aat com_google_android_gms_internal_aat) {
            this.f10480a = new WeakReference(com_google_android_gms_internal_aat);
        }

        private sc m13559a(final tj tjVar) {
            return new sc(this) {
                final /* synthetic */ C3205a f10472b;

                public void mo3260a(aat com_google_android_gms_internal_aat, final Map<String, String> map) {
                    aat com_google_android_gms_internal_aat2 = (aat) this.f10472b.f10480a.get();
                    if (com_google_android_gms_internal_aat2 == null) {
                        tjVar.mo3409b("/loadHtml", (sc) this);
                        return;
                    }
                    com_google_android_gms_internal_aat2.mo3424l().m8547a(new C2340a(this) {
                        final /* synthetic */ C32001 f10470b;

                        public void mo3168a(aat com_google_android_gms_internal_aat, boolean z) {
                            this.f10470b.f10472b.f10481b = (String) map.get("id");
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("messageType", "htmlLoaded");
                                jSONObject.put("id", this.f10470b.f10472b.f10481b);
                                tjVar.mo3410b("sendMessageToNativeJs", jSONObject);
                            } catch (Throwable e) {
                                aad.m8422b("Unable to dispatch sendMessageToNativeJs event", e);
                            }
                        }
                    });
                    String str = (String) map.get("overlayHtml");
                    String str2 = (String) map.get("baseUrl");
                    if (TextUtils.isEmpty(str2)) {
                        com_google_android_gms_internal_aat2.loadData(str, "text/html", "UTF-8");
                    } else {
                        com_google_android_gms_internal_aat2.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                    }
                }
            };
        }

        private sc m13563b(final tj tjVar) {
            return new sc(this) {
                final /* synthetic */ C3205a f10474b;

                public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
                    aat com_google_android_gms_internal_aat2 = (aat) this.f10474b.f10480a.get();
                    if (com_google_android_gms_internal_aat2 == null) {
                        tjVar.mo3409b("/showOverlay", (sc) this);
                    } else {
                        com_google_android_gms_internal_aat2.mo3405b().setVisibility(0);
                    }
                }
            };
        }

        private sc m13566c(final tj tjVar) {
            return new sc(this) {
                final /* synthetic */ C3205a f10476b;

                public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
                    aat com_google_android_gms_internal_aat2 = (aat) this.f10476b.f10480a.get();
                    if (com_google_android_gms_internal_aat2 == null) {
                        tjVar.mo3409b("/hideOverlay", (sc) this);
                    } else {
                        com_google_android_gms_internal_aat2.mo3405b().setVisibility(8);
                    }
                }
            };
        }

        private sc m13568d(final tj tjVar) {
            return new sc(this) {
                final /* synthetic */ C3205a f10478b;

                public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        for (String str : map.keySet()) {
                            jSONObject.put(str, map.get(str));
                        }
                        jSONObject.put("id", this.f10478b.f10481b);
                        tjVar.mo3410b("sendMessageToNativeJs", jSONObject);
                    } catch (Throwable e) {
                        aad.m8422b("Unable to dispatch sendMessageToNativeJs event", e);
                    }
                }
            };
        }

        public C3196a m13569a() {
            return new C32045(this);
        }
    }

    public ra(Context context, zzs com_google_android_gms_ads_internal_zzs, @Nullable vy vyVar, ed edVar, @Nullable JSONObject jSONObject, @Nullable C3180a c3180a, @Nullable zzqh com_google_android_gms_internal_zzqh, @Nullable String str) {
        this.f10410d = context;
        this.f10409c = com_google_android_gms_ads_internal_zzs;
        this.f10412f = vyVar;
        this.f10414h = edVar;
        this.f10411e = jSONObject;
        this.f10413g = c3180a;
        this.f10415i = com_google_android_gms_internal_zzqh;
        this.f10416j = str;
    }

    private JSONObject m13455a(Rect rect) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("x", m13460a(rect.left));
        jSONObject.put("y", m13460a(rect.top));
        jSONObject.put("width", m13460a(rect.right - rect.left));
        jSONObject.put("height", m13460a(rect.bottom - rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    private JSONObject m13456a(Map<String, WeakReference<View>> map, View view) {
        JSONObject jSONObject = new JSONObject();
        if (map == null || view == null) {
            return jSONObject;
        }
        try {
            int[] b = m13473b(view);
            for (Entry entry : map.entrySet()) {
                View view2 = (View) ((WeakReference) entry.getValue()).get();
                if (view2 != null) {
                    int[] b2 = m13473b(view2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("width", m13460a(m13474c(view2)));
                    jSONObject2.put("height", m13460a(m13476d(view2)));
                    jSONObject2.put("x", m13460a(b2[0] - b[0]));
                    jSONObject2.put("y", m13460a(b2[1] - b[1]));
                    jSONObject.put((String) entry.getKey(), jSONObject2);
                }
            }
        } catch (JSONException e) {
            aad.m8426e("Unable to get all view rectangles");
        }
        return jSONObject;
    }

    private JSONObject m13457b(Map<String, WeakReference<View>> map, View view) {
        JSONObject jSONObject = new JSONObject();
        if (map == null || view == null) {
            return jSONObject;
        }
        int[] b = m13473b(view);
        for (Entry entry : map.entrySet()) {
            View view2 = (View) ((WeakReference) entry.getValue()).get();
            if (view2 != null) {
                int[] b2 = m13473b(view2);
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    Object a;
                    jSONObject3.put("width", m13460a(m13474c(view2)));
                    jSONObject3.put("height", m13460a(m13476d(view2)));
                    jSONObject3.put("x", m13460a(b2[0] - b[0]));
                    jSONObject3.put("y", m13460a(b2[1] - b[1]));
                    jSONObject3.put("relative_to", "ad_view");
                    jSONObject2.put("frame", jSONObject3);
                    Rect rect = new Rect();
                    if (view2.getLocalVisibleRect(rect)) {
                        a = m13455a(rect);
                    } else {
                        a = new JSONObject();
                        a.put("x", m13460a(b2[0] - b[0]));
                        a.put("y", m13460a(b2[1] - b[1]));
                        a.put("width", 0);
                        a.put("height", 0);
                        a.put("relative_to", "ad_view");
                    }
                    jSONObject2.put("visible_bounds", a);
                    if (view2 instanceof TextView) {
                        TextView textView = (TextView) view2;
                        jSONObject2.put("text_color", textView.getCurrentTextColor());
                        jSONObject2.put("font_size", (double) textView.getTextSize());
                        jSONObject2.put("text", textView.getText());
                    }
                    jSONObject.put((String) entry.getKey(), jSONObject2);
                } catch (JSONException e) {
                    aad.m8426e("Unable to get asset views information");
                }
            }
        }
        return jSONObject;
    }

    private JSONObject m13458e(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                jSONObject.put("width", m13460a(m13474c(view)));
                jSONObject.put("height", m13460a(m13476d(view)));
            } catch (Exception e) {
                aad.m8426e("Unable to get native ad view bounding box");
            }
        }
        return jSONObject;
    }

    private JSONObject m13459f(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                Object a;
                int[] b = m13473b(view);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", m13460a(m13474c(view)));
                jSONObject2.put("height", m13460a(m13476d(view)));
                jSONObject2.put("x", m13460a(b[0]));
                jSONObject2.put("y", m13460a(b[1]));
                jSONObject2.put("relative_to", "window");
                jSONObject.put("frame", jSONObject2);
                Rect rect = new Rect();
                if (view.getGlobalVisibleRect(rect)) {
                    a = m13455a(rect);
                } else {
                    a = new JSONObject();
                    a.put("x", m13460a(b[0]));
                    a.put("y", m13460a(b[1]));
                    a.put("width", 0);
                    a.put("height", 0);
                    a.put("relative_to", "window");
                }
                jSONObject.put("visible_bounds", a);
            } catch (Exception e) {
                aad.m8426e("Unable to get native ad view bounding box");
            }
        }
        return jSONObject;
    }

    int m13460a(int i) {
        return ol.m12979a().m8410b(this.f10410d, i);
    }

    @Nullable
    public View mo3959a(OnClickListener onClickListener, boolean z) {
        qq m = this.f10413g.mo3935m();
        if (m == null) {
            return null;
        }
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        if (!z) {
            switch (m.m13343g()) {
                case 0:
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                    break;
                case 2:
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    break;
                case 3:
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                    break;
                default:
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    break;
            }
        }
        View qrVar = new qr(this.f10410d, m, layoutParams);
        qrVar.setOnClickListener(onClickListener);
        qrVar.setContentDescription((CharSequence) qb.co.m13225c());
        return qrVar;
    }

    @Nullable
    rd m13462a(Object obj) {
        return obj instanceof IBinder ? C3178a.m13348a((IBinder) obj) : null;
    }

    public void mo3960a(MotionEvent motionEvent) {
        this.f10414h.m10562a(motionEvent);
    }

    public void mo3961a(View view) {
        this.f10418l = new WeakReference(view);
    }

    public void mo3962a(View view, qw qwVar) {
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View o = this.f10413g.mo3937o();
        if (o != null) {
            ViewParent parent = o.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(o);
            }
            ((FrameLayout) view).addView(o, layoutParams);
            this.f10409c.zza(qwVar);
        } else if (this.f10413g instanceof C3181b) {
            C3181b c3181b = (C3181b) this.f10413g;
            if (c3181b.mo3924b() != null && c3181b.mo3924b().size() > 0) {
                rd a = m13462a(c3181b.mo3924b().get(0));
                if (a != null) {
                    try {
                        C2309a a2 = a.mo3919a();
                        if (a2 != null) {
                            Drawable drawable = (Drawable) C2312b.m7328a(a2);
                            o = m13482i();
                            o.setImageDrawable(drawable);
                            o.setScaleType(ScaleType.CENTER_INSIDE);
                            ((FrameLayout) view).addView(o, layoutParams);
                        }
                    } catch (RemoteException e) {
                        aad.m8426e("Could not get drawable from image");
                    }
                }
            }
        }
    }

    public void mo3963a(View view, String str, @Nullable JSONObject jSONObject, Map<String, WeakReference<View>> map, View view2) {
        C2513c.m7940b("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("asset", str);
            jSONObject2.put("template", this.f10413g.mo3933k());
            final JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ad", this.f10411e);
            jSONObject3.put("click", jSONObject2);
            jSONObject3.put("has_custom_click_handler", this.f10409c.zzz(this.f10413g.mo3934l()) != null);
            if (((Boolean) qb.cq.m13225c()).booleanValue()) {
                if (((Boolean) qb.cr.m13225c()).booleanValue()) {
                    jSONObject3.put("asset_view_signal", m13457b((Map) map, view2));
                    jSONObject3.put("ad_view_signal", m13459f(view2));
                } else {
                    jSONObject3.put("view_rectangles", m13456a((Map) map, view2));
                    jSONObject3.put("native_view_rectangle", m13458e(view2));
                }
            }
            if (jSONObject != null) {
                jSONObject3.put("click_point", jSONObject);
            }
            try {
                JSONObject optJSONObject = this.f10411e.optJSONObject("tracking_urls_and_actions");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                jSONObject2.put("click_signals", this.f10414h.m10561a().mo3152a(this.f10410d, optJSONObject.optString("click_string"), view));
            } catch (Throwable e) {
                aad.m8422b("Exception obtaining click signals", e);
            }
            jSONObject3.put("ads_id", this.f10416j);
            this.f10412f.m14404a(new C3196a(this) {
                public void mo3974a(tj tjVar) {
                    tjVar.mo3385a("google.afma.nativeAds.handleClickGmsg", jSONObject3);
                }
            });
        } catch (Throwable e2) {
            aad.m8422b("Unable to create click JSON.", e2);
        }
    }

    public void mo3964a(View view, Map<String, WeakReference<View>> map) {
        C2513c.m7940b("recordImpression must be called on the main UI thread.");
        m13470a(true);
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.f10411e);
            jSONObject.put("ads_id", this.f10416j);
            if (((Boolean) qb.cq.m13225c()).booleanValue()) {
                if (((Boolean) qb.cr.m13225c()).booleanValue()) {
                    jSONObject.put("asset_view_signal", m13457b((Map) map, view));
                    jSONObject.put("ad_view_signal", m13459f(view));
                } else {
                    jSONObject.put("view_rectangles", m13456a((Map) map, view));
                    jSONObject.put("native_view_rectangle", m13458e(view));
                }
            }
            this.f10412f.m14404a(new C3196a(this) {
                public void mo3974a(tj tjVar) {
                    tjVar.mo3385a("google.afma.nativeAds.handleImpressionPing", jSONObject);
                }
            });
        } catch (Throwable e) {
            aad.m8422b("Unable to create impression JSON.", e);
        }
        this.f10409c.zza((qz) this);
        this.f10409c.zzbL();
    }

    public void mo3971a(View view, Map<String, WeakReference<View>> map, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        if (((Boolean) qb.cl.m13225c()).booleanValue()) {
            view.setOnTouchListener(onTouchListener);
            view.setClickable(true);
            view.setOnClickListener(onClickListener);
            if (map != null) {
                for (Entry value : map.entrySet()) {
                    View view2 = (View) ((WeakReference) value.getValue()).get();
                    if (view2 != null) {
                        view2.setOnTouchListener(onTouchListener);
                        view2.setClickable(true);
                        view2.setOnClickListener(onClickListener);
                    }
                }
            }
        }
    }

    public void mo3965a(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, View view2) {
        C2513c.m7940b("performClick must be called on the main UI thread.");
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                    mo3963a(view, (String) entry.getKey(), jSONObject, map, view2);
                    return;
                }
            }
        }
        if (GpsMeasureMode.MODE_2_DIMENSIONAL.equals(this.f10413g.mo3933k())) {
            mo3963a(view, "2099", jSONObject, map, view2);
        } else if ("1".equals(this.f10413g.mo3933k())) {
            mo3963a(view, "1099", jSONObject, map, view2);
        }
    }

    protected void m13470a(boolean z) {
        this.f10407a = z;
    }

    public boolean mo3966a() {
        qq m = this.f10413g.mo3935m();
        return m != null && m.m13344h();
    }

    public void mo3967b(View view, Map<String, WeakReference<View>> map) {
        if (!((Boolean) qb.ck.m13225c()).booleanValue()) {
            view.setOnTouchListener(null);
            view.setClickable(false);
            view.setOnClickListener(null);
            if (map != null) {
                for (Entry value : map.entrySet()) {
                    View view2 = (View) ((WeakReference) value.getValue()).get();
                    if (view2 != null) {
                        view2.setOnTouchListener(null);
                        view2.setClickable(false);
                        view2.setOnClickListener(null);
                    }
                }
            }
        }
    }

    int[] m13473b(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    int m13474c(View view) {
        return view.getMeasuredWidth();
    }

    public void mo3968c(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.f10408b) {
            if (this.f10407a) {
            } else if (!view.isShown()) {
            } else if (view.getGlobalVisibleRect(new Rect(), null)) {
                mo3964a(view, (Map) map);
            }
        }
    }

    int m13476d(View view) {
        return view.getMeasuredHeight();
    }

    public aat mo3972d() {
        if (this.f10411e == null || this.f10411e.optJSONObject("overlay") == null) {
            return null;
        }
        aat h = m13481h();
        h.mo3405b().setVisibility(8);
        this.f10412f.m14404a(new C3205a(h).m13569a());
        return h;
    }

    public View mo3969e() {
        return this.f10418l != null ? (View) this.f10418l.get() : null;
    }

    public Context mo3970f() {
        return this.f10410d;
    }

    public void m13480g() {
        this.f10409c.zzcv();
    }

    aat m13481h() {
        return zzw.zzcN().m8574a(this.f10410d, zzeg.m15383a(this.f10410d), false, false, this.f10414h, this.f10415i);
    }

    ImageView m13482i() {
        return new ImageView(this.f10410d);
    }

    @Nullable
    public yr m13483j() {
        if (!zzw.zzdl().m14949c()) {
            return null;
        }
        if (this.f10417k == null) {
            this.f10417k = new yr(this.f10410d, this.f10409c.getAdUnitId());
        }
        return this.f10417k;
    }
}
