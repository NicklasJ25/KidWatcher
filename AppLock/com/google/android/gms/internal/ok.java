package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.widget.FrameLayout;
import com.google.android.gms.internal.ow.C2325a;
import com.google.android.gms.p065a.C2312b;

@wh
public class ok {
    private ow f10119a;
    private final Object f10120b = new Object();
    private final od f10121c;
    private final oc f10122d;
    private final pj f10123e;
    private final rr f10124f;
    private final xw f10125g;
    private final vm f10126h;
    private final uz f10127i;

    @VisibleForTesting
    abstract class C3114a<T> {
        final /* synthetic */ ok f10087f;

        C3114a(ok okVar) {
            this.f10087f = okVar;
        }

        @Nullable
        protected abstract T mo3862b();

        @Nullable
        protected abstract T mo3863b(ow owVar);

        @Nullable
        protected final T m12918c() {
            T t = null;
            ow a = this.f10087f.m12962b();
            if (a == null) {
                aad.m8426e("ClientApi class cannot be loaded.");
            } else {
                try {
                    t = mo3863b(a);
                } catch (Throwable e) {
                    aad.m8424c("Cannot invoke local loader using ClientApi class", e);
                }
            }
            return t;
        }

        @Nullable
        protected final T m12919d() {
            try {
                return mo3862b();
            } catch (Throwable e) {
                aad.m8424c("Cannot invoke remote loader", e);
                return null;
            }
        }
    }

    public ok(od odVar, oc ocVar, pj pjVar, rr rrVar, xw xwVar, vm vmVar, uz uzVar) {
        this.f10121c = odVar;
        this.f10122d = ocVar;
        this.f10123e = pjVar;
        this.f10124f = rrVar;
        this.f10125g = xwVar;
        this.f10126h = vmVar;
        this.f10127i = uzVar;
    }

    @Nullable
    private static ow m12956a() {
        try {
            Object newInstance = ok.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (newInstance instanceof IBinder) {
                return C2325a.asInterface((IBinder) newInstance);
            }
            aad.m8426e("ClientApi class is not an instance of IBinder");
            return null;
        } catch (Throwable e) {
            aad.m8424c("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    private void m12958a(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        ol.m12979a().m8404a(context, null, "gmob-apps", bundle, true);
    }

    private static boolean m12960a(Activity activity, String str) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra(str)) {
            return intent.getBooleanExtra(str, false);
        }
        aad.m8423c("useClientJar flag not found in activity intent extras.");
        return false;
    }

    @Nullable
    private ow m12962b() {
        ow owVar;
        synchronized (this.f10120b) {
            if (this.f10119a == null) {
                this.f10119a = m12956a();
            }
            owVar = this.f10119a;
        }
        return owVar;
    }

    public or m12969a(final Context context, final String str, final ub ubVar) {
        return (or) m12976a(context, false, new C3114a<or>(this) {
            final /* synthetic */ ok f10105d;

            public or m12932a() {
                or a = this.f10105d.f10122d.m12893a(context, str, ubVar);
                if (a != null) {
                    return a;
                }
                this.f10105d.m12958a(context, "native_ad");
                return new pk();
            }

            public or m12933a(ow owVar) {
                return owVar.createAdLoaderBuilder(C2312b.m7327a(context), str, ubVar, 10260000);
            }

            public /* synthetic */ Object mo3862b() {
                return m12932a();
            }

            public /* synthetic */ Object mo3863b(ow owVar) {
                return m12933a(owVar);
            }
        });
    }

    public ot m12970a(final Context context, final zzeg com_google_android_gms_internal_zzeg, final String str) {
        return (ot) m12976a(context, false, new C3114a<ot>(this) {
            final /* synthetic */ ok f10096d;

            public ot m12924a() {
                ot a = this.f10096d.f10121c.m12896a(context, com_google_android_gms_internal_zzeg, str, null, 3);
                if (a != null) {
                    return a;
                }
                this.f10096d.m12958a(context, "search");
                return new pl();
            }

            public ot m12925a(ow owVar) {
                return owVar.createSearchAdManager(C2312b.m7327a(context), com_google_android_gms_internal_zzeg, str, 10260000);
            }

            public /* synthetic */ Object mo3862b() {
                return m12924a();
            }

            public /* synthetic */ Object mo3863b(ow owVar) {
                return m12925a(owVar);
            }
        });
    }

    public ot m12971a(Context context, zzeg com_google_android_gms_internal_zzeg, String str, ub ubVar) {
        final Context context2 = context;
        final zzeg com_google_android_gms_internal_zzeg2 = com_google_android_gms_internal_zzeg;
        final String str2 = str;
        final ub ubVar2 = ubVar;
        return (ot) m12976a(context, false, new C3114a<ot>(this) {
            final /* synthetic */ ok f10092e;

            public ot m12920a() {
                ot a = this.f10092e.f10121c.m12896a(context2, com_google_android_gms_internal_zzeg2, str2, ubVar2, 1);
                if (a != null) {
                    return a;
                }
                this.f10092e.m12958a(context2, "banner");
                return new pl();
            }

            public ot m12921a(ow owVar) {
                return owVar.createBannerAdManager(C2312b.m7327a(context2), com_google_android_gms_internal_zzeg2, str2, ubVar2, 10260000);
            }

            public /* synthetic */ Object mo3862b() {
                return m12920a();
            }

            public /* synthetic */ Object mo3863b(ow owVar) {
                return m12921a(owVar);
            }
        });
    }

    public oy m12972a(final Context context) {
        return (oy) m12976a(context, false, new C3114a<oy>(this) {
            final /* synthetic */ ok f10107b;

            public oy m12936a() {
                oy b = this.f10107b.f10123e.m13156b(context);
                if (b != null) {
                    return b;
                }
                this.f10107b.m12958a(context, "mobile_ads_settings");
                return new pm();
            }

            public oy m12937a(ow owVar) {
                return owVar.getMobileAdsSettingsManagerWithClientJarVersion(C2312b.m7327a(context), 10260000);
            }

            public /* synthetic */ Object mo3862b() {
                return m12936a();
            }

            public /* synthetic */ Object mo3863b(ow owVar) {
                return m12937a(owVar);
            }
        });
    }

    public rf m12973a(final Context context, final FrameLayout frameLayout, final FrameLayout frameLayout2) {
        return (rf) m12976a(context, false, new C3114a<rf>(this) {
            final /* synthetic */ ok f10111d;

            public rf m12940a() {
                rf a = this.f10111d.f10124f.m13655a(context, frameLayout, frameLayout2);
                if (a != null) {
                    return a;
                }
                this.f10111d.m12958a(context, "native_ad_view_delegate");
                return new pn();
            }

            public rf m12941a(ow owVar) {
                return owVar.createNativeAdViewDelegate(C2312b.m7327a(frameLayout), C2312b.m7327a(frameLayout2));
            }

            public /* synthetic */ Object mo3862b() {
                return m12940a();
            }

            public /* synthetic */ Object mo3863b(ow owVar) {
                return m12941a(owVar);
            }
        });
    }

    @Nullable
    public vh m12974a(final Activity activity) {
        return (vh) m12976a((Context) activity, m12960a(activity, "com.google.android.gms.ads.internal.purchase.useClientJar"), new C3114a<vh>(this) {
            final /* synthetic */ ok f10116b;

            public vh m12948a() {
                vh a = this.f10116b.f10126h.m14358a(activity);
                if (a != null) {
                    return a;
                }
                this.f10116b.m12958a(activity, "iap");
                return null;
            }

            public vh m12949a(ow owVar) {
                return owVar.createInAppPurchaseManager(C2312b.m7327a(activity));
            }

            public /* synthetic */ Object mo3862b() {
                return m12948a();
            }

            public /* synthetic */ Object mo3863b(ow owVar) {
                return m12949a(owVar);
            }
        });
    }

    public xs m12975a(final Context context, final ub ubVar) {
        return (xs) m12976a(context, false, new C3114a<xs>(this) {
            final /* synthetic */ ok f10114c;

            public xs m12944a() {
                xs a = this.f10114c.f10125g.m14835a(context, ubVar);
                if (a != null) {
                    return a;
                }
                this.f10114c.m12958a(context, "rewarded_video");
                return new po();
            }

            public xs m12945a(ow owVar) {
                return owVar.createRewardedVideoAd(C2312b.m7327a(context), ubVar, 10260000);
            }

            public /* synthetic */ Object mo3862b() {
                return m12944a();
            }

            public /* synthetic */ Object mo3863b(ow owVar) {
                return m12945a(owVar);
            }
        });
    }

    @VisibleForTesting
    <T> T m12976a(Context context, boolean z, C3114a<T> c3114a) {
        if (!(z || ol.m12979a().m8414c(context))) {
            aad.m8421b("Google Play Services is not available");
            z = true;
        }
        T c;
        if (z) {
            c = c3114a.m12918c();
            return c == null ? c3114a.m12919d() : c;
        } else {
            c = c3114a.m12919d();
            return c == null ? c3114a.m12918c() : c;
        }
    }

    public ot m12977b(Context context, zzeg com_google_android_gms_internal_zzeg, String str, ub ubVar) {
        final Context context2 = context;
        final zzeg com_google_android_gms_internal_zzeg2 = com_google_android_gms_internal_zzeg;
        final String str2 = str;
        final ub ubVar2 = ubVar;
        return (ot) m12976a(context, false, new C3114a<ot>(this) {
            final /* synthetic */ ok f10101e;

            public ot m12928a() {
                ot a = this.f10101e.f10121c.m12896a(context2, com_google_android_gms_internal_zzeg2, str2, ubVar2, 2);
                if (a != null) {
                    return a;
                }
                this.f10101e.m12958a(context2, "interstitial");
                return new pl();
            }

            public ot m12929a(ow owVar) {
                return owVar.createInterstitialAdManager(C2312b.m7327a(context2), com_google_android_gms_internal_zzeg2, str2, ubVar2, 10260000);
            }

            public /* synthetic */ Object mo3862b() {
                return m12928a();
            }

            public /* synthetic */ Object mo3863b(ow owVar) {
                return m12929a(owVar);
            }
        });
    }

    @Nullable
    public va m12978b(final Activity activity) {
        return (va) m12976a((Context) activity, m12960a(activity, "com.google.android.gms.ads.internal.overlay.useClientJar"), new C3114a<va>(this) {
            final /* synthetic */ ok f10118b;

            public va m12952a() {
                va a = this.f10118b.f10127i.m14323a(activity);
                if (a != null) {
                    return a;
                }
                this.f10118b.m12958a(activity, "ad_overlay");
                return null;
            }

            public va m12953a(ow owVar) {
                return owVar.createAdOverlay(C2312b.m7327a(activity));
            }

            public /* synthetic */ Object mo3862b() {
                return m12952a();
            }

            public /* synthetic */ Object mo3863b(ow owVar) {
                return m12953a(owVar);
            }
        });
    }
}
