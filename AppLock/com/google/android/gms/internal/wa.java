package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.aau.C2340a;
import com.google.android.gms.internal.aau.C2643b;
import com.google.android.gms.internal.yy.C3457a;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@wh
public class wa {
    private final Object f11129a = new Object();
    private final Context f11130b;
    private final ed f11131c;
    private final C3457a f11132d;
    private final qj f11133e;
    private final zzs f11134f;
    private OnGlobalLayoutListener f11135g;
    private OnScrollChangedListener f11136h;
    private zw f11137i;
    private int f11138j = -1;
    private int f11139k = -1;

    class C33872 implements sc {
        final /* synthetic */ wa f11124a;

        C33872(wa waVar) {
            this.f11124a = waVar;
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            this.f11124a.f11134f.zzct();
        }
    }

    public wa(Context context, ed edVar, C3457a c3457a, qj qjVar, zzs com_google_android_gms_ads_internal_zzs) {
        this.f11130b = context;
        this.f11131c = edVar;
        this.f11132d = c3457a;
        this.f11133e = qjVar;
        this.f11134f = com_google_android_gms_ads_internal_zzs;
        this.f11137i = new zw(200);
    }

    private OnGlobalLayoutListener m14456a(final WeakReference<aat> weakReference) {
        if (this.f11135g == null) {
            this.f11135g = new OnGlobalLayoutListener(this) {
                final /* synthetic */ wa f11126b;

                public void onGlobalLayout() {
                    this.f11126b.m14461a(weakReference, false);
                }
            };
        }
        return this.f11135g;
    }

    private void m14458a(aat com_google_android_gms_internal_aat) {
        aau l = com_google_android_gms_internal_aat.mo3424l();
        l.m8552a("/video", sb.f10541n);
        l.m8552a("/videoMeta", sb.f10542o);
        l.m8552a("/precache", sb.f10544q);
        l.m8552a("/delayPageLoaded", sb.f10547t);
        l.m8552a("/instrument", sb.f10545r);
        l.m8552a("/log", sb.f10536i);
        l.m8552a("/videoClicked", sb.f10537j);
        l.m8552a("/trackActiveViewUnit", new C33872(this));
    }

    private void m14461a(WeakReference<aat> weakReference, boolean z) {
        if (weakReference != null) {
            aat com_google_android_gms_internal_aat = (aat) weakReference.get();
            if (com_google_android_gms_internal_aat != null && com_google_android_gms_internal_aat.mo3405b() != null) {
                if (!z || this.f11137i.m15282a()) {
                    int[] iArr = new int[2];
                    com_google_android_gms_internal_aat.mo3405b().getLocationOnScreen(iArr);
                    int b = ol.m12979a().m8410b(this.f11130b, iArr[0]);
                    int b2 = ol.m12979a().m8410b(this.f11130b, iArr[1]);
                    synchronized (this.f11129a) {
                        if (!(this.f11138j == b && this.f11139k == b2)) {
                            this.f11138j = b;
                            this.f11139k = b2;
                            com_google_android_gms_internal_aat.mo3424l().m8541a(this.f11138j, this.f11139k, !z);
                        }
                    }
                }
            }
        }
    }

    private OnScrollChangedListener m14463b(final WeakReference<aat> weakReference) {
        if (this.f11136h == null) {
            this.f11136h = new OnScrollChangedListener(this) {
                final /* synthetic */ wa f11128b;

                public void onScrollChanged() {
                    this.f11128b.m14461a(weakReference, true);
                }
            };
        }
        return this.f11136h;
    }

    public aaj<aat> m14464a(final JSONObject jSONObject) {
        final aaj com_google_android_gms_internal_aag = new aag();
        zzw.zzcM().m15125a(new Runnable(this) {
            final /* synthetic */ wa f11123c;

            class C33852 implements C2340a {
                final /* synthetic */ C33861 f11120a;

                C33852(C33861 c33861) {
                    this.f11120a = c33861;
                }

                public void mo3168a(aat com_google_android_gms_internal_aat, boolean z) {
                    this.f11120a.f11123c.f11134f.zzcw();
                    com_google_android_gms_internal_aag.m8436b((Object) com_google_android_gms_internal_aat);
                }
            }

            public void run() {
                try {
                    final aat a = this.f11123c.m14465a();
                    this.f11123c.f11134f.zzc(a);
                    WeakReference weakReference = new WeakReference(a);
                    a.mo3424l().m8543a(this.f11123c.m14456a(weakReference), this.f11123c.m14463b(weakReference));
                    this.f11123c.m14458a(a);
                    a.mo3424l().m8548a(new C2643b(this) {
                        final /* synthetic */ C33861 f11119b;

                        public void mo4180a(aat com_google_android_gms_internal_aat) {
                            a.mo3385a("google.afma.nativeAds.renderVideo", jSONObject);
                        }
                    });
                    a.mo3424l().m8547a(new C33852(this));
                    a.loadUrl((String) qb.cf.m13225c());
                } catch (Throwable e) {
                    aad.m8424c("Exception occurred while getting video view", e);
                    com_google_android_gms_internal_aag.m8436b(null);
                }
            }
        });
        return com_google_android_gms_internal_aag;
    }

    aat m14465a() {
        return zzw.zzcN().m8575a(this.f11130b, zzeg.m15383a(this.f11130b), false, false, this.f11131c, this.f11132d.f11509a.f12002k, this.f11133e, null, this.f11134f.zzby());
    }
}
