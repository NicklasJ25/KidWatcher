package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.aat;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.qj;
import com.google.android.gms.internal.qn;
import com.google.android.gms.internal.qt;
import com.google.android.gms.internal.qu;
import com.google.android.gms.internal.qv;
import com.google.android.gms.internal.qw;
import com.google.android.gms.internal.qx;
import com.google.android.gms.internal.qz;
import com.google.android.gms.internal.qz.C3180a;
import com.google.android.gms.internal.rn;
import com.google.android.gms.internal.ro;
import com.google.android.gms.internal.rp;
import com.google.android.gms.internal.rq;
import com.google.android.gms.internal.ub;
import com.google.android.gms.internal.uf;
import com.google.android.gms.internal.ug;
import com.google.android.gms.internal.vg;
import com.google.android.gms.internal.vy;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.yy;
import com.google.android.gms.internal.yy.C3457a;
import com.google.android.gms.internal.zl;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzhc;
import com.google.android.gms.internal.zzqh;
import java.util.List;

@wh
public class zzs extends zzb {
    private aat f7040l;

    public zzs(Context context, zze com_google_android_gms_ads_internal_zze, zzeg com_google_android_gms_internal_zzeg, String str, ub ubVar, zzqh com_google_android_gms_internal_zzqh) {
        super(context, com_google_android_gms_internal_zzeg, str, ubVar, com_google_android_gms_internal_zzqh, com_google_android_gms_ads_internal_zze);
    }

    private static qt m7559a(uf ufVar) {
        return new qt(ufVar.mo4085a(), ufVar.mo4087b(), ufVar.mo4089c(), ufVar.mo4091d() != null ? ufVar.mo4091d() : null, ufVar.mo4092e(), ufVar.mo4093f(), ufVar.mo4094g(), ufVar.mo4095h(), null, ufVar.mo4099l(), ufVar.mo4100m(), null);
    }

    private static qu m7560a(ug ugVar) {
        return new qu(ugVar.mo4102a(), ugVar.mo4104b(), ugVar.mo4106c(), ugVar.mo4108d() != null ? ugVar.mo4108d() : null, ugVar.mo4109e(), ugVar.mo4110f(), null, ugVar.mo4114j(), ugVar.mo4116l(), null);
    }

    private void m7561a(final qt qtVar) {
        zl.f11678a.post(new Runnable(this) {
            final /* synthetic */ zzs f7034b;

            public void run() {
                try {
                    if (this.f7034b.f.f7117j != null) {
                        this.f7034b.f.f7117j.mo4009a(qtVar);
                    }
                } catch (Throwable e) {
                    aad.m8424c("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
                }
            }
        });
    }

    private void m7562a(final qu quVar) {
        zl.f11678a.post(new Runnable(this) {
            final /* synthetic */ zzs f7036b;

            public void run() {
                try {
                    if (this.f7036b.f.f7118k != null) {
                        this.f7036b.f.f7118k.mo4010a(quVar);
                    }
                } catch (Throwable e) {
                    aad.m8424c("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
                }
            }
        });
    }

    private void m7563a(final yy yyVar, final String str) {
        zl.f11678a.post(new Runnable(this) {
            final /* synthetic */ zzs f7039c;

            public void run() {
                try {
                    ((rq) this.f7039c.f.f7120m.get(str)).mo4012a((qv) yyVar.f11521E);
                } catch (Throwable e) {
                    aad.m8424c("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
                }
            }
        });
    }

    protected boolean mo3284a(zzec com_google_android_gms_internal_zzec, yy yyVar, boolean z) {
        return this.e.zzcy();
    }

    public String getAdUnitId() {
        return this.f.zzvl;
    }

    public void pause() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    public void resume() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    public void zza(SimpleArrayMap<String, rq> simpleArrayMap) {
        C2513c.m7940b("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        this.f.f7120m = simpleArrayMap;
    }

    public void zza(qn qnVar) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    public void zza(qw qwVar) {
        if (this.f7040l != null) {
            this.f7040l.mo3399a(qwVar);
        }
    }

    public void zza(qz qzVar) {
        if (this.f.zzvs.f11535j != null) {
            zzw.zzcQ().m15030s().m12636a(this.f.zzvr, this.f.zzvs, qzVar);
        }
    }

    public void zza(vg vgVar) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    public void zza(final C3457a c3457a, qj qjVar) {
        if (c3457a.f11512d != null) {
            this.f.zzvr = c3457a.f11512d;
        }
        if (c3457a.f11513e != -2) {
            zl.f11678a.post(new Runnable(this) {
                final /* synthetic */ zzs f7032b;

                public void run() {
                    this.f7032b.zzb(new yy(c3457a, null, null, null, null, null, null, null));
                }
            });
            return;
        }
        this.f.zzvO = 0;
        this.f.zzvq = zzw.zzcL().m14373a(this.f.zzqn, this, c3457a, this.f.f7109b, null, this.j, this, qjVar);
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(this.f.zzvq.getClass().getName());
        aad.m8421b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    protected boolean zza(yy yyVar, yy yyVar2) {
        zzb(null);
        if (this.f.zzdq()) {
            if (yyVar2.f11539n) {
                try {
                    uf h = yyVar2.f11541p != null ? yyVar2.f11541p.mo4079h() : null;
                    ug i = yyVar2.f11541p != null ? yyVar2.f11541p.mo4080i() : null;
                    if (h == null || this.f.f7117j == null) {
                        if (i != null) {
                            if (this.f.f7118k != null) {
                                qu a = m7560a(i);
                                a.mo3923a(new qx(this.f.zzqn, this, this.f.f7109b, i, (C3180a) a));
                                m7562a(a);
                            }
                        }
                        aad.m8426e("No matching mapper/listener for retrieved native ad template.");
                        m7465a(0);
                        return false;
                    }
                    qt a2 = m7559a(h);
                    a2.mo3923a(new qx(this.f.zzqn, this, this.f.f7109b, h, (C3180a) a2));
                    m7561a(a2);
                } catch (Throwable e) {
                    aad.m8424c("Failed to get native ad mapper", e);
                }
            } else {
                C3180a c3180a = yyVar2.f11521E;
                if ((c3180a instanceof qu) && this.f.f7118k != null) {
                    m7562a((qu) yyVar2.f11521E);
                } else if ((c3180a instanceof qt) && this.f.f7117j != null) {
                    m7561a((qt) yyVar2.f11521E);
                } else if (!(c3180a instanceof qv) || this.f.f7120m == null || this.f.f7120m.get(((qv) c3180a).mo3934l()) == null) {
                    aad.m8426e("No matching listener for retrieved native ad template.");
                    m7465a(0);
                    return false;
                } else {
                    m7563a(yyVar2, ((qv) c3180a).mo3934l());
                }
            }
            return super.zza(yyVar, yyVar2);
        }
        throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }

    public boolean zza(zzec com_google_android_gms_internal_zzec, qj qjVar) {
        if (((Boolean) qb.cg.m13225c()).booleanValue() && ((Boolean) qb.ch.m13225c()).booleanValue()) {
            vy vyVar = new vy(this.f.zzqn, this, this.f.f7109b, this.f.zzvn);
            vyVar.m14403a();
            try {
                vyVar.m14405b();
            } catch (Throwable e) {
                aad.m8424c("Initializing javascript failed", e);
                return false;
            }
        }
        return super.zza(com_google_android_gms_internal_zzec, qjVar);
    }

    public void zzb(SimpleArrayMap<String, rp> simpleArrayMap) {
        C2513c.m7940b("setOnCustomClickListener must be called on the main UI thread.");
        this.f.f7119l = simpleArrayMap;
    }

    public void zzb(rn rnVar) {
        C2513c.m7940b("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        this.f.f7117j = rnVar;
    }

    public void zzb(ro roVar) {
        C2513c.m7940b("setOnContentAdLoadedListener must be called on the main UI thread.");
        this.f.f7118k = roVar;
    }

    public void zzb(zzhc com_google_android_gms_internal_zzhc) {
        C2513c.m7940b("setNativeAdOptions must be called on the main UI thread.");
        this.f.f7121n = com_google_android_gms_internal_zzhc;
    }

    public void zzb(@Nullable List<String> list) {
        C2513c.m7940b("setNativeTemplates must be called on the main UI thread.");
        this.f.f7126s = list;
    }

    public void zzc(aat com_google_android_gms_internal_aat) {
        this.f7040l = com_google_android_gms_internal_aat;
    }

    public void zzct() {
        if (this.f.zzvs == null || this.f7040l == null) {
            aad.m8426e("Request to enable ActiveView before adState is available.");
        } else {
            zzw.zzcQ().m15030s().m12634a(this.f.zzvr, this.f.zzvs, this.f7040l.mo3405b(), this.f7040l);
        }
    }

    public SimpleArrayMap<String, rq> zzcu() {
        C2513c.m7940b("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.f.f7120m;
    }

    public void zzcv() {
        if (this.f7040l != null) {
            this.f7040l.destroy();
            this.f7040l = null;
        }
    }

    public void zzcw() {
        if (this.f7040l != null && this.f7040l.mo3448z() != null && this.f.f7121n != null && this.f.f7121n.f11926f != null) {
            this.f7040l.mo3448z().m8733b(this.f.f7121n.f11926f.f11920a);
        }
    }

    public boolean zzcx() {
        return this.f.zzvs != null && this.f.zzvs.f11539n && this.f.zzvs.f11543r != null && this.f.zzvs.f11543r.f10801o;
    }

    @Nullable
    public rp zzz(String str) {
        C2513c.m7940b("getOnCustomClickListener must be called on the main UI thread.");
        return (rp) this.f.f7119l.get(str);
    }
}
