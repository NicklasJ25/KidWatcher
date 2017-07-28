package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.C2590o;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.aat;
import com.google.android.gms.internal.aau;
import com.google.android.gms.internal.aau.C2375e;
import com.google.android.gms.internal.aau.C2377c;
import com.google.android.gms.internal.aaz;
import com.google.android.gms.internal.na;
import com.google.android.gms.internal.ol;
import com.google.android.gms.internal.pb;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.ub;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.yp;
import com.google.android.gms.internal.yr;
import com.google.android.gms.internal.yy;
import com.google.android.gms.internal.yy.C3457a;
import com.google.android.gms.internal.zl;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzqh;
import java.util.List;

@wh
public class zzg extends zzc implements OnGlobalLayoutListener, OnScrollChangedListener {
    private boolean f6957l;

    class C23741 implements Runnable {
        final /* synthetic */ zzg f6951a;

        C23741(zzg com_google_android_gms_ads_internal_zzg) {
            this.f6951a = com_google_android_gms_ads_internal_zzg;
        }

        public void run() {
            this.f6951a.m7500d(this.f6951a.f.zzvs);
        }
    }

    public class zza {
        final /* synthetic */ zzg f6956a;

        public zza(zzg com_google_android_gms_ads_internal_zzg) {
            this.f6956a = com_google_android_gms_ads_internal_zzg;
        }

        public void onClick() {
            this.f6956a.onAdClicked();
        }
    }

    public zzg(Context context, zzeg com_google_android_gms_internal_zzeg, String str, ub ubVar, zzqh com_google_android_gms_internal_zzqh, zze com_google_android_gms_ads_internal_zze) {
        super(context, com_google_android_gms_internal_zzeg, str, ubVar, com_google_android_gms_internal_zzqh, com_google_android_gms_ads_internal_zze);
    }

    private zzeg m7494a(C3457a c3457a) {
        if (c3457a.f11510b.f12018A) {
            return this.f.zzvr;
        }
        AdSize adSize;
        String str = c3457a.f11510b.f12047m;
        if (str != null) {
            String[] split = str.split("[xX]");
            split[0] = split[0].trim();
            split[1] = split[1].trim();
            adSize = new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        } else {
            adSize = this.f.zzvr.m15387b();
        }
        return new zzeg(this.f.zzqn, adSize);
    }

    private boolean m7495a(@Nullable yy yyVar, yy yyVar2) {
        if (yyVar2.f11539n) {
            View zzg = zzp.zzg(yyVar2);
            if (zzg == null) {
                aad.m8426e("Could not get mediation view");
                return false;
            }
            View nextView = this.f.f7110c.getNextView();
            if (nextView != null) {
                if (nextView instanceof aat) {
                    ((aat) nextView).destroy();
                }
                this.f.f7110c.removeView(nextView);
            }
            if (!zzp.zzh(yyVar2)) {
                try {
                    m7466a(zzg);
                } catch (Throwable th) {
                    zzw.zzcQ().m15000a(th, "BannerAdManager.swapViews");
                    aad.m8424c("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            }
        } else if (!(yyVar2.f11547v == null || yyVar2.f11527b == null)) {
            yyVar2.f11527b.mo3400a(yyVar2.f11547v);
            this.f.f7110c.removeAllViews();
            this.f.f7110c.setMinimumWidth(yyVar2.f11547v.f11900f);
            this.f.f7110c.setMinimumHeight(yyVar2.f11547v.f11897c);
            m7466a(yyVar2.f11527b.mo3405b());
        }
        if (this.f.f7110c.getChildCount() > 1) {
            this.f.f7110c.showNext();
        }
        if (yyVar != null) {
            View nextView2 = this.f.f7110c.getNextView();
            if (nextView2 instanceof aat) {
                ((aat) nextView2).mo3395a(this.f.zzqn, this.f.zzvr, this.a);
            } else if (nextView2 != null) {
                this.f.f7110c.removeView(nextView2);
            }
            this.f.zzdp();
        }
        this.f.f7110c.setVisibility(0);
        return true;
    }

    private void m7496e(final yy yyVar) {
        C2590o.m8307b();
        if (this.f.zzdq()) {
            if (yyVar.f11527b != null) {
                if (yyVar.f11535j != null) {
                    this.h.m12632a(this.f.zzvr, yyVar);
                }
                final na naVar = new na(this.f.zzqn, yyVar.f11527b.mo3405b());
                if (zzw.zzdl().m14946b()) {
                    naVar.m12739a(new yr(this.f.zzqn, this.f.zzvl));
                }
                if (yyVar.m14963a()) {
                    naVar.m12739a(yyVar.f11527b);
                } else {
                    yyVar.f11527b.mo3424l().m8549a(new C2377c(this) {
                        public void mo3268a() {
                            naVar.m12739a(yyVar.f11527b);
                        }
                    });
                }
            }
        } else if (this.f.f7128u != null && yyVar.f11535j != null) {
            this.h.m12633a(this.f.zzvr, yyVar, this.f.f7128u);
        }
    }

    protected aat mo3269a(C3457a c3457a, @Nullable zzf com_google_android_gms_ads_internal_zzf, @Nullable yp ypVar) {
        if (this.f.zzvr.f11901g == null && this.f.zzvr.f11903i) {
            this.f.zzvr = m7494a(c3457a);
        }
        return super.mo3269a(c3457a, com_google_android_gms_ads_internal_zzf, ypVar);
    }

    protected void mo3270a(@Nullable yy yyVar, boolean z) {
        super.mo3270a(yyVar, z);
        if (zzp.zzh(yyVar)) {
            zzp.zza(yyVar, new zza(this));
        }
    }

    zzec mo3271b(zzec com_google_android_gms_internal_zzec) {
        if (com_google_android_gms_internal_zzec.f11884h == this.f6957l) {
            return com_google_android_gms_internal_zzec;
        }
        int i = com_google_android_gms_internal_zzec.f11877a;
        long j = com_google_android_gms_internal_zzec.f11878b;
        Bundle bundle = com_google_android_gms_internal_zzec.f11879c;
        int i2 = com_google_android_gms_internal_zzec.f11880d;
        List list = com_google_android_gms_internal_zzec.f11881e;
        boolean z = com_google_android_gms_internal_zzec.f11882f;
        int i3 = com_google_android_gms_internal_zzec.f11883g;
        boolean z2 = com_google_android_gms_internal_zzec.f11884h || this.f6957l;
        return new zzec(i, j, bundle, i2, list, z, i3, z2, com_google_android_gms_internal_zzec.f11885i, com_google_android_gms_internal_zzec.f11886j, com_google_android_gms_internal_zzec.f11887k, com_google_android_gms_internal_zzec.f11888l, com_google_android_gms_internal_zzec.f11889m, com_google_android_gms_internal_zzec.f11890n, com_google_android_gms_internal_zzec.f11891o, com_google_android_gms_internal_zzec.f11892p, com_google_android_gms_internal_zzec.f11893q, com_google_android_gms_internal_zzec.f11894r);
    }

    void m7500d(@Nullable yy yyVar) {
        if (yyVar != null && !yyVar.f11538m && this.f.f7110c != null && zzw.zzcM().m15132a(this.f.f7110c, this.f.zzqn) && this.f.f7110c.getGlobalVisibleRect(new Rect(), null)) {
            if (!(yyVar == null || yyVar.f11527b == null || yyVar.f11527b.mo3424l() == null)) {
                yyVar.f11527b.mo3424l().m8550a(null);
            }
            mo3270a(yyVar, false);
            yyVar.f11538m = true;
        }
    }

    protected boolean mo3241f() {
        boolean z = true;
        if (!zzw.zzcM().m15131a(this.f.zzqn, this.f.zzqn.getPackageName(), "android.permission.INTERNET")) {
            ol.m12979a().m8407a(this.f.f7110c, this.f.zzvr, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        if (!zzw.zzcM().m15130a(this.f.zzqn)) {
            ol.m12979a().m8407a(this.f.f7110c, this.f.zzvr, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!(z || this.f.f7110c == null)) {
            this.f.f7110c.setVisibility(0);
        }
        return z;
    }

    public void onGlobalLayout() {
        m7500d(this.f.zzvs);
    }

    public void onScrollChanged() {
        m7500d(this.f.zzvs);
    }

    public void setManualImpressionsEnabled(boolean z) {
        C2513c.m7940b("setManualImpressionsEnabled must be called from the main thread.");
        this.f6957l = z;
    }

    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    public boolean zza(@Nullable yy yyVar, final yy yyVar2) {
        if (!super.zza(yyVar, yyVar2)) {
            return false;
        }
        if (!this.f.zzdq() || m7495a(yyVar, yyVar2)) {
            aaz z;
            if (yyVar2.f11536k) {
                m7500d(yyVar2);
                zzw.zzdk().m8460a(this.f.f7110c, (OnGlobalLayoutListener) this);
                zzw.zzdk().m8461a(this.f.f7110c, (OnScrollChangedListener) this);
                if (!yyVar2.f11538m) {
                    final Runnable c23741 = new C23741(this);
                    aau l = yyVar2.f11527b != null ? yyVar2.f11527b.mo3424l() : null;
                    if (l != null) {
                        l.m8550a(new C2375e(this) {
                            public void mo3267a() {
                                if (!yyVar2.f11538m) {
                                    zzw.zzcM();
                                    zl.m15093b(c23741);
                                }
                            }
                        });
                    }
                }
            } else if (!this.f.zzdr() || ((Boolean) qb.cb.m13225c()).booleanValue()) {
                mo3270a(yyVar2, false);
            }
            if (yyVar2.f11527b != null) {
                z = yyVar2.f11527b.mo3448z();
                aau l2 = yyVar2.f11527b.mo3424l();
                if (l2 != null) {
                    l2.m8564h();
                }
            } else {
                z = null;
            }
            if (!(this.f.f7122o == null || z == null)) {
                z.m8733b(this.f.f7122o.f11920a);
            }
            m7496e(yyVar2);
            return true;
        }
        m7465a(0);
        return false;
    }

    public boolean zzb(zzec com_google_android_gms_internal_zzec) {
        return super.zzb(mo3271b(com_google_android_gms_internal_zzec));
    }

    @Nullable
    public pb zzbF() {
        C2513c.m7940b("getVideoController must be called from the main thread.");
        return (this.f.zzvs == null || this.f.zzvs.f11527b == null) ? null : this.f.zzvs.f11527b.mo3448z();
    }
}
