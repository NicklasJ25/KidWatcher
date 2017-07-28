package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.yy.C3457a;
import com.google.android.gms.p065a.C2312b;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@wh
public class xq extends zzb implements yf {
    private static xq f11437l;
    private static final tz f11438m = new tz();
    private final Map<String, yj> f11439n = new HashMap();
    private boolean f11440o;

    class C34401 implements Runnable {
        final /* synthetic */ xq f11434a;

        C34401(xq xqVar) {
            this.f11434a = xqVar;
        }

        public void run() {
            this.f11434a.m7465a(1);
        }
    }

    public xq(Context context, zze com_google_android_gms_ads_internal_zze, zzeg com_google_android_gms_internal_zzeg, ub ubVar, zzqh com_google_android_gms_internal_zzqh) {
        super(context, com_google_android_gms_internal_zzeg, null, ubVar, com_google_android_gms_internal_zzqh, com_google_android_gms_ads_internal_zze);
        f11437l = this;
    }

    private C3457a m14795a(C3457a c3457a) {
        zh.m15051a("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            String jSONObject = xb.m14689a(c3457a.f11510b).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, c3457a.f11509a.f11996e);
            tq tqVar = new tq(jSONObject, null, Arrays.asList(new String[]{"com.google.ads.mediation.admob.AdMobAdapter"}), null, null, Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList());
            return new C3457a(c3457a.f11509a, c3457a.f11510b, new tr(Arrays.asList(new tq[]{tqVar}), ((Long) qb.bG.m13225c()).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "", -1, 0, 1, null, 0, -1, -1, false), c3457a.f11512d, c3457a.f11513e, c3457a.f11514f, c3457a.f11515g, c3457a.f11516h);
        } catch (Throwable e) {
            aad.m8422b("Unable to generate ad state for non-mediated rewarded video.", e);
            return m14797b(c3457a);
        }
    }

    private C3457a m14797b(C3457a c3457a) {
        return new C3457a(c3457a.f11509a, c3457a.f11510b, null, c3457a.f11512d, 0, c3457a.f11514f, c3457a.f11515g, c3457a.f11516h);
    }

    public static xq m14798g() {
        return f11437l;
    }

    protected void mo3283a() {
        this.f.zzvs = null;
        super.mo3283a();
    }

    public void m14800a(@NonNull Context context) {
        for (yj a : this.f11439n.values()) {
            try {
                a.m14914a().mo4063a(C2312b.m7327a((Object) context));
            } catch (Throwable e) {
                aad.m8422b("Unable to call Adapter.onContextChanged.", e);
            }
        }
    }

    public void m14801a(zzoa com_google_android_gms_internal_zzoa) {
        C2513c.m7940b("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzoa.f12073b)) {
            aad.m8426e("Invalid ad unit id. Aborting.");
            zl.f11678a.post(new C34401(this));
            return;
        }
        this.f11440o = false;
        this.f.zzvl = com_google_android_gms_internal_zzoa.f12073b;
        super.zzb(com_google_android_gms_internal_zzoa.f12072a);
    }

    protected boolean mo3284a(zzec com_google_android_gms_internal_zzec, yy yyVar, boolean z) {
        return false;
    }

    @Nullable
    public yj m14803b(String str) {
        yj yjVar;
        Throwable th;
        String str2;
        String valueOf;
        yj yjVar2 = (yj) this.f11439n.get(str);
        if (yjVar2 != null) {
            return yjVar2;
        }
        try {
            yjVar = new yj(("com.google.ads.mediation.admob.AdMobAdapter".equals(str) ? f11438m : this.j).mo4060a(str), this);
            try {
                this.f11439n.put(str, yjVar);
                return yjVar;
            } catch (Throwable e) {
                th = e;
                str2 = "Fail to instantiate adapter ";
                valueOf = String.valueOf(str);
                aad.m8424c(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf), th);
                return yjVar;
            }
        } catch (Throwable e2) {
            th = e2;
            yjVar = yjVar2;
            str2 = "Fail to instantiate adapter ";
            valueOf = String.valueOf(str);
            if (valueOf.length() == 0) {
            }
            aad.m8424c(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf), th);
            return yjVar;
        }
    }

    public void mo4197b(@Nullable zzoo com_google_android_gms_internal_zzoo) {
        if (!(this.f.zzvs == null || this.f.zzvs.f11540o == null)) {
            zzw.zzdf().m14034a(this.f.zzqn, this.f.zzvn.f12081a, this.f.zzvs, this.f.zzvl, false, this.f.zzvs.f11540o.f10781k);
        }
        if (!(this.f.zzvs == null || this.f.zzvs.f11543r == null || TextUtils.isEmpty(this.f.zzvs.f11543r.f10796j))) {
            com_google_android_gms_internal_zzoo = new zzoo(this.f.zzvs.f11543r.f10796j, this.f.zzvs.f11543r.f10797k);
        }
        m7467a(com_google_android_gms_internal_zzoo);
    }

    public void destroy() {
        C2513c.m7940b("destroy must be called on the main UI thread.");
        for (String str : this.f11439n.keySet()) {
            String str2;
            try {
                yj yjVar = (yj) this.f11439n.get(str2);
                if (!(yjVar == null || yjVar.m14914a() == null)) {
                    yjVar.m14914a().mo4074c();
                }
            } catch (RemoteException e) {
                String str3 = "Fail to destroy adapter: ";
                str2 = String.valueOf(str2);
                aad.m8426e(str2.length() != 0 ? str3.concat(str2) : new String(str3));
            }
        }
    }

    public void m14805h() {
        C2513c.m7940b("showAd must be called on the main UI thread.");
        if (m14806i()) {
            this.f11440o = true;
            yj b = m14803b(this.f.zzvs.f11542q);
            if (b != null && b.m14914a() != null) {
                try {
                    b.m14914a().mo4077f();
                    return;
                } catch (Throwable e) {
                    aad.m8424c("Could not call showVideo.", e);
                    return;
                }
            }
            return;
        }
        aad.m8426e("The reward video has not loaded.");
    }

    public boolean m14806i() {
        C2513c.m7940b("isLoaded must be called on the main UI thread.");
        return this.f.zzvp == null && this.f.zzvq == null && this.f.zzvs != null && !this.f11440o;
    }

    public void mo4198j() {
        mo3270a(this.f.zzvs, false);
        m7472c();
    }

    public void mo4199k() {
        if (!(this.f.zzvs == null || this.f.zzvs.f11540o == null)) {
            zzw.zzdf().m14034a(this.f.zzqn, this.f.zzvn.f12081a, this.f.zzvs, this.f.zzvl, false, this.f.zzvs.f11540o.f10780j);
        }
        m7475e();
    }

    public void mo4200l() {
        mo3283a();
    }

    public void mo4201m() {
        onAdClicked();
    }

    public void mo4202n() {
        m7470b();
    }

    public void pause() {
        String valueOf;
        C2513c.m7940b("pause must be called on the main UI thread.");
        for (String valueOf2 : this.f11439n.keySet()) {
            try {
                yj yjVar = (yj) this.f11439n.get(valueOf2);
                if (!(yjVar == null || yjVar.m14914a() == null)) {
                    yjVar.m14914a().mo4075d();
                }
            } catch (RemoteException e) {
                String str = "Fail to pause adapter: ";
                valueOf2 = String.valueOf(valueOf2);
                aad.m8426e(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
            }
        }
    }

    public void resume() {
        C2513c.m7940b("resume must be called on the main UI thread.");
        for (String str : this.f11439n.keySet()) {
            String str2;
            try {
                yj yjVar = (yj) this.f11439n.get(str2);
                if (!(yjVar == null || yjVar.m14914a() == null)) {
                    yjVar.m14914a().mo4076e();
                }
            } catch (RemoteException e) {
                String str3 = "Fail to resume adapter: ";
                str2 = String.valueOf(str2);
                aad.m8426e(str2.length() != 0 ? str3.concat(str2) : new String(str3));
            }
        }
    }

    public void zza(final C3457a c3457a, qj qjVar) {
        if (c3457a.f11513e != -2) {
            zl.f11678a.post(new Runnable(this) {
                final /* synthetic */ xq f11436b;

                public void run() {
                    this.f11436b.zzb(new yy(c3457a, null, null, null, null, null, null, null));
                }
            });
            return;
        }
        this.f.zzvt = c3457a;
        if (c3457a.f11511c == null) {
            this.f.zzvt = m14795a(c3457a);
        }
        this.f.zzvO = 0;
        this.f.zzvq = zzw.zzcL().m14374a(this.f.zzqn, this.f.zzvt, this);
    }

    public boolean zza(yy yyVar, yy yyVar2) {
        return true;
    }
}
