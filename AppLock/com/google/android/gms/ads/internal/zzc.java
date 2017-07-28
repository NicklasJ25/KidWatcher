package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.aat;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.qj;
import com.google.android.gms.internal.qk;
import com.google.android.gms.internal.qm;
import com.google.android.gms.internal.qn;
import com.google.android.gms.internal.sc;
import com.google.android.gms.internal.tj;
import com.google.android.gms.internal.ub;
import com.google.android.gms.internal.uy;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.yp;
import com.google.android.gms.internal.yy;
import com.google.android.gms.internal.yy.C3457a;
import com.google.android.gms.internal.zl;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzqh;
import java.util.Map;

@wh
public abstract class zzc extends zzb implements zzi, uy {

    class C23691 implements sc {
        final /* synthetic */ zzc f6939a;

        C23691(zzc com_google_android_gms_ads_internal_zzc) {
            this.f6939a = com_google_android_gms_ads_internal_zzc;
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            if (this.f6939a.f.zzvs != null) {
                this.f6939a.h.m12634a(this.f6939a.f.zzvr, this.f6939a.f.zzvs, com_google_android_gms_internal_aat.mo3405b(), (tj) com_google_android_gms_internal_aat);
            } else {
                aad.m8426e("Request to enable ActiveView before adState is available.");
            }
        }
    }

    public zzc(Context context, zzeg com_google_android_gms_internal_zzeg, String str, ub ubVar, zzqh com_google_android_gms_internal_zzqh, zze com_google_android_gms_ads_internal_zze) {
        super(context, com_google_android_gms_internal_zzeg, str, ubVar, com_google_android_gms_internal_zzqh, com_google_android_gms_ads_internal_zze);
    }

    protected aat mo3269a(C3457a c3457a, @Nullable zzf com_google_android_gms_ads_internal_zzf, @Nullable yp ypVar) {
        aat com_google_android_gms_internal_aat = null;
        View nextView = this.f.f7110c.getNextView();
        if (nextView instanceof aat) {
            com_google_android_gms_internal_aat = (aat) nextView;
            if (((Boolean) qb.aC.m13225c()).booleanValue()) {
                aad.m8421b("Reusing webview...");
                com_google_android_gms_internal_aat.mo3395a(this.f.zzqn, this.f.zzvr, this.a);
            } else {
                com_google_android_gms_internal_aat.destroy();
                com_google_android_gms_internal_aat = null;
            }
        }
        if (com_google_android_gms_internal_aat == null) {
            if (nextView != null) {
                this.f.f7110c.removeView(nextView);
            }
            com_google_android_gms_internal_aat = zzw.zzcN().m8575a(this.f.zzqn, this.f.zzvr, false, false, this.f.f7109b, this.f.zzvn, this.a, this, this.i);
            if (this.f.zzvr.f11901g == null) {
                m7466a(com_google_android_gms_internal_aat.mo3405b());
            }
        }
        aat com_google_android_gms_internal_aat2 = com_google_android_gms_internal_aat;
        com_google_android_gms_internal_aat2.mo3424l().m8551a(this, this, this, this, false, this, null, com_google_android_gms_ads_internal_zzf, this, ypVar);
        m7488a(com_google_android_gms_internal_aat2);
        com_google_android_gms_internal_aat2.mo3408b(c3457a.f11509a.f12013v);
        return com_google_android_gms_internal_aat2;
    }

    protected void m7488a(tj tjVar) {
        tjVar.mo3402a("/trackActiveViewUnit", new C23691(this));
    }

    public void zza(int i, int i2, int i3, int i4) {
        m7472c();
    }

    public void zza(qn qnVar) {
        C2513c.m7940b("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.f.f7124q = qnVar;
    }

    protected void zza(final C3457a c3457a, final qj qjVar) {
        if (c3457a.f11513e != -2) {
            zl.f11678a.post(new Runnable(this) {
                final /* synthetic */ zzc f6941b;

                public void run() {
                    this.f6941b.zzb(new yy(c3457a, null, null, null, null, null, null, null));
                }
            });
            return;
        }
        if (c3457a.f11512d != null) {
            this.f.zzvr = c3457a.f11512d;
        }
        if (!c3457a.f11510b.f12042h || c3457a.f11510b.f12019B) {
            zl.f11678a.post(new Runnable(this, null) {
                final /* synthetic */ zzc f6947d;

                public void run() {
                    if (c3457a.f11510b.f12053s && this.f6947d.f.f7124q != null) {
                        String str = null;
                        if (c3457a.f11510b.f12036b != null) {
                            str = zzw.zzcM().m15109a(c3457a.f11510b.f12036b);
                        }
                        qm qkVar = new qk(this.f6947d, str, c3457a.f11510b.f12037c);
                        this.f6947d.f.zzvO = 1;
                        try {
                            this.f6947d.d = false;
                            this.f6947d.f.f7124q.mo3918a(qkVar);
                            return;
                        } catch (Throwable e) {
                            aad.m8424c("Could not call the onCustomRenderedAdLoadedListener.", e);
                            this.f6947d.d = true;
                        }
                    }
                    final zzf com_google_android_gms_ads_internal_zzf = new zzf(this.f6947d.f.zzqn, c3457a);
                    aat a = this.f6947d.mo3269a(c3457a, com_google_android_gms_ads_internal_zzf, null);
                    a.setOnTouchListener(new OnTouchListener(this) {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            com_google_android_gms_ads_internal_zzf.recordClick();
                            return false;
                        }
                    });
                    a.setOnClickListener(new OnClickListener(this) {
                        public void onClick(View view) {
                            com_google_android_gms_ads_internal_zzf.recordClick();
                        }
                    });
                    this.f6947d.f.zzvO = 0;
                    this.f6947d.f.zzvq = zzw.zzcL().m14373a(this.f6947d.f.zzqn, this.f6947d, c3457a, this.f6947d.f.f7109b, a, this.f6947d.j, this.f6947d, qjVar);
                }
            });
            return;
        }
        this.f.zzvO = 0;
        this.f.zzvq = zzw.zzcL().m14373a(this.f.zzqn, this, c3457a, this.f.f7109b, null, this.j, this, qjVar);
    }

    protected boolean zza(@Nullable yy yyVar, yy yyVar2) {
        if (this.f.zzdq() && this.f.f7110c != null) {
            this.f.f7110c.zzdw().m15236c(yyVar2.f11519C);
        }
        return super.zza(yyVar, yyVar2);
    }

    public void zzbZ() {
        onAdClicked();
    }

    public void zzc(View view) {
        this.f.f7128u = view;
        zzb(new yy(this.f.zzvt, null, null, null, null, null, null, null));
    }

    public void zzca() {
        recordImpression();
        zzbE();
    }

    public void zzcb() {
        mo3283a();
    }
}
