package com.facebook.ads.internal.p021b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.ads.C1460d;
import com.facebook.ads.C1903l;
import com.facebook.ads.C1903l.C1898a;
import com.facebook.ads.internal.p018m.C1717j;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p018m.ah;
import com.facebook.ads.internal.p022h.C1597f;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAdView;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C1501i extends ab implements C1500z {
    private static final String f3503a = C1501i.class.getSimpleName();
    private View f3504b;
    private NativeAd f3505c;
    private ac f3506d;
    private NativeAdView f3507e;
    private View f3508f;
    private boolean f3509g;
    private Uri f3510h;
    private Uri f3511i;
    private String f3512j;
    private String f3513k;
    private String f3514l;
    private String f3515m;

    class C14994 implements OnClickListener {
        final /* synthetic */ C1501i f3502a;

        C14994(C1501i c1501i) {
            this.f3502a = c1501i;
        }

        public void onClick(View view) {
            this.f3502a.f3508f.performClick();
        }
    }

    private void m3939a(View view) {
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
    }

    public void mo2675a(int i) {
    }

    public void mo2676a(final Context context, ac acVar, C1597f c1597f, Map<String, Object> map) {
        boolean z;
        boolean z2;
        C1729s.m4971a(context, ah.m4824a(mo2705z()) + " Loading");
        JSONObject jSONObject = (JSONObject) map.get("data");
        String optString = jSONObject.optString("ad_unit_id");
        JSONArray optJSONArray = jSONObject.optJSONArray("creative_types");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            int i = 0;
            z = false;
            z2 = false;
            while (i < length) {
                try {
                    String string = optJSONArray.getString(i);
                    if (string != null) {
                        boolean z3 = true;
                        switch (string.hashCode()) {
                            case 704091517:
                                if (string.equals("app_install")) {
                                    z3 = false;
                                    break;
                                }
                                break;
                            case 883765328:
                                if (string.equals("page_post")) {
                                    z3 = true;
                                    break;
                                }
                                break;
                        }
                        switch (z3) {
                            case false:
                                z2 = true;
                                break;
                            case true:
                                z = true;
                                break;
                            default:
                                break;
                        }
                    }
                    i++;
                } catch (JSONException e) {
                    C1729s.m4971a(context, ah.m4824a(mo2705z()) + " AN server error");
                    acVar.mo2662a(this, C1460d.f3366d);
                    return;
                }
            }
        }
        z = false;
        z2 = false;
        if (TextUtils.isEmpty(optString) || !(z2 || z)) {
            C1729s.m4971a(context, ah.m4824a(mo2705z()) + " AN server error");
            acVar.mo2662a(this, C1460d.f3366d);
            return;
        }
        this.f3506d = acVar;
        Builder builder = new Builder(context, optString);
        if (z2) {
            builder.forAppInstallAd(new OnAppInstallAdLoadedListener(this) {
                final /* synthetic */ C1501i f3497b;

                public void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
                    Uri uri = null;
                    this.f3497b.f3505c = nativeAppInstallAd;
                    this.f3497b.f3509g = true;
                    this.f3497b.f3512j = nativeAppInstallAd.getHeadline() != null ? nativeAppInstallAd.getHeadline().toString() : null;
                    this.f3497b.f3513k = nativeAppInstallAd.getBody() != null ? nativeAppInstallAd.getBody().toString() : null;
                    this.f3497b.f3515m = nativeAppInstallAd.getStore() != null ? nativeAppInstallAd.getStore().toString() : null;
                    this.f3497b.f3514l = nativeAppInstallAd.getCallToAction() != null ? nativeAppInstallAd.getCallToAction().toString() : null;
                    List images = nativeAppInstallAd.getImages();
                    C1501i c1501i = this.f3497b;
                    Uri uri2 = (images == null || images.size() <= 0) ? null : ((Image) images.get(0)).getUri();
                    c1501i.f3510h = uri2;
                    C1501i c1501i2 = this.f3497b;
                    if (nativeAppInstallAd.getIcon() != null) {
                        uri = nativeAppInstallAd.getIcon().getUri();
                    }
                    c1501i2.f3511i = uri;
                    if (this.f3497b.f3506d != null) {
                        C1729s.m4971a(context, ah.m4824a(this.f3497b.mo2705z()) + " Loaded");
                        this.f3497b.f3506d.mo2661a(this.f3497b);
                    }
                }
            });
        }
        if (z) {
            builder.forContentAd(new OnContentAdLoadedListener(this) {
                final /* synthetic */ C1501i f3499b;

                public void onContentAdLoaded(NativeContentAd nativeContentAd) {
                    Uri uri = null;
                    this.f3499b.f3505c = nativeContentAd;
                    this.f3499b.f3509g = true;
                    this.f3499b.f3512j = nativeContentAd.getHeadline() != null ? nativeContentAd.getHeadline().toString() : null;
                    this.f3499b.f3513k = nativeContentAd.getBody() != null ? nativeContentAd.getBody().toString() : null;
                    this.f3499b.f3515m = nativeContentAd.getAdvertiser() != null ? nativeContentAd.getAdvertiser().toString() : null;
                    this.f3499b.f3514l = nativeContentAd.getCallToAction() != null ? nativeContentAd.getCallToAction().toString() : null;
                    List images = nativeContentAd.getImages();
                    C1501i c1501i = this.f3499b;
                    Uri uri2 = (images == null || images.size() <= 0) ? null : ((Image) images.get(0)).getUri();
                    c1501i.f3510h = uri2;
                    C1501i c1501i2 = this.f3499b;
                    if (nativeContentAd.getLogo() != null) {
                        uri = nativeContentAd.getLogo().getUri();
                    }
                    c1501i2.f3511i = uri;
                    if (this.f3499b.f3506d != null) {
                        C1729s.m4971a(context, ah.m4824a(this.f3499b.mo2705z()) + " Loaded");
                        this.f3499b.f3506d.mo2661a(this.f3499b);
                    }
                }
            });
        }
        builder.withAdListener(new AdListener(this) {
            final /* synthetic */ C1501i f3501b;

            public void onAdFailedToLoad(int i) {
                C1729s.m4971a(context, ah.m4824a(this.f3501b.mo2705z()) + " Failed with error code: " + i);
                if (this.f3501b.f3506d != null) {
                    this.f3501b.f3506d.mo2662a(this.f3501b, new C1460d(3001, "AdMob error code: " + i));
                }
            }

            public void onAdOpened() {
                if (this.f3501b.f3506d != null) {
                    this.f3501b.f3506d.mo2664c(this.f3501b);
                }
            }
        }).withNativeAdOptions(new NativeAdOptions.Builder().setReturnUrlsForImageAssets(true).build()).build().loadAd(new AdRequest.Builder().build());
    }

    public void mo2677a(View view, List<View> list) {
        this.f3504b = view;
        if (mo2683d() && view != null) {
            ViewGroup viewGroup;
            int i;
            int i2 = -1;
            ViewGroup viewGroup2 = null;
            while (true) {
                ViewGroup viewGroup3 = (ViewGroup) view.getParent();
                if (viewGroup3 == null) {
                    Log.e(f3503a, "View must have valid parent for AdMob registration, skipping registration. Impressions and clicks will not be logged.");
                    return;
                }
                if (viewGroup3 instanceof NativeAdView) {
                    viewGroup = (ViewGroup) viewGroup3.getParent();
                    if (viewGroup == null) {
                        Log.e(f3503a, "View must have valid parent for AdMob registration, skipping registration. Impressions and clicks will not be logged.");
                        return;
                    }
                    int indexOfChild = viewGroup.indexOfChild(viewGroup3);
                    viewGroup3.removeView(view);
                    viewGroup.removeView(viewGroup3);
                    viewGroup.addView(view, indexOfChild);
                    i = i2;
                    viewGroup = viewGroup2;
                } else {
                    viewGroup = viewGroup3;
                    i = viewGroup3.indexOfChild(view);
                }
                if (viewGroup != null) {
                    break;
                }
                i2 = i;
                viewGroup2 = viewGroup;
            }
            View nativeContentAdView = this.f3505c instanceof NativeContentAd ? new NativeContentAdView(view.getContext()) : new NativeAppInstallAdView(view.getContext());
            if (view instanceof ViewGroup) {
                nativeContentAdView.setLayoutParams(view.getLayoutParams());
            }
            m3939a(view);
            nativeContentAdView.addView(view);
            viewGroup.removeView(nativeContentAdView);
            viewGroup.addView(nativeContentAdView, i);
            this.f3507e = nativeContentAdView;
            this.f3507e.setNativeAd(this.f3505c);
            this.f3508f = new View(view.getContext());
            this.f3507e.addView(this.f3508f);
            this.f3508f.setVisibility(8);
            if (this.f3507e instanceof NativeContentAdView) {
                ((NativeContentAdView) this.f3507e).setCallToActionView(this.f3508f);
            } else if (this.f3507e instanceof NativeAppInstallAdView) {
                ((NativeAppInstallAdView) this.f3507e).setCallToActionView(this.f3508f);
            }
            OnClickListener c14994 = new C14994(this);
            for (View onClickListener : list) {
                onClickListener.setOnClickListener(c14994);
            }
        }
    }

    public void mo2678a(ac acVar) {
        this.f3506d = acVar;
    }

    public void mo2679a(Map<String, String> map) {
        if (mo2683d() && this.f3506d != null) {
            this.f3506d.mo2663b(this);
        }
    }

    public void mo2680b() {
        mo2682c();
        this.f3506d = null;
        this.f3505c = null;
        this.f3509g = false;
        this.f3510h = null;
        this.f3511i = null;
        this.f3512j = null;
        this.f3513k = null;
        this.f3514l = null;
        this.f3515m = null;
    }

    public void mo2681b(Map<String, String> map) {
    }

    public void mo2682c() {
        m3939a(this.f3508f);
        this.f3508f = null;
        if (this.f3504b != null) {
            View view = (ViewGroup) this.f3504b.getParent();
            if ((view instanceof NativeContentAdView) || (view instanceof NativeAppInstallAdView)) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    int indexOfChild = viewGroup.indexOfChild(view);
                    m3939a(this.f3504b);
                    m3939a(view);
                    viewGroup.addView(this.f3504b, indexOfChild);
                }
            }
            this.f3504b = null;
        }
        this.f3507e = null;
    }

    public boolean mo2683d() {
        return this.f3509g && this.f3505c != null;
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
        return false;
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
        return (!mo2683d() || this.f3511i == null) ? null : new C1898a(this.f3511i.toString(), 50, 50);
    }

    public C1898a mo2692m() {
        return (!mo2683d() || this.f3510h == null) ? null : new C1898a(this.f3510h.toString(), 1200, PositionController.SNAPBACK_ANIMATION_TIME);
    }

    public String mo2693n() {
        return this.f3512j;
    }

    public String mo2694o() {
        return this.f3513k;
    }

    public String mo2695p() {
        return this.f3514l;
    }

    public C1898a mo2696q() {
        return null;
    }

    public String mo2697r() {
        return null;
    }

    public String mo2698s() {
        return null;
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
        return C1504k.ADMOB;
    }
}
