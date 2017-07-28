package com.google.android.gms.ads.internal;

import android.os.Debug;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.util.C2583h;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.mu;
import com.google.android.gms.internal.ny;
import com.google.android.gms.internal.oe;
import com.google.android.gms.internal.ol;
import com.google.android.gms.internal.oo;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.ot.C2359a;
import com.google.android.gms.internal.ov;
import com.google.android.gms.internal.ox;
import com.google.android.gms.internal.pb;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.qh;
import com.google.android.gms.internal.qj;
import com.google.android.gms.internal.qn;
import com.google.android.gms.internal.rx;
import com.google.android.gms.internal.vg;
import com.google.android.gms.internal.vk;
import com.google.android.gms.internal.vs.C2360a;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.wi.C2361a;
import com.google.android.gms.internal.xo;
import com.google.android.gms.internal.xu;
import com.google.android.gms.internal.yy;
import com.google.android.gms.internal.yy.C3457a;
import com.google.android.gms.internal.yz;
import com.google.android.gms.internal.zd;
import com.google.android.gms.internal.ze;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzfc;
import com.google.android.gms.internal.zzfr;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzoo;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

@wh
public abstract class zza extends C2359a implements zzq, ny, rx, C2360a, C2361a, zd {
    protected qj f6917a;
    protected qh f6918b;
    protected qh f6919c;
    protected boolean f6920d = false;
    protected final zzt f6921e;
    protected final zzx f6922f;
    @Nullable
    protected transient zzec f6923g;
    protected final mu f6924h;
    protected final zze f6925i;

    zza(zzx com_google_android_gms_ads_internal_zzx, @Nullable zzt com_google_android_gms_ads_internal_zzt, zze com_google_android_gms_ads_internal_zze) {
        this.f6922f = com_google_android_gms_ads_internal_zzx;
        if (com_google_android_gms_ads_internal_zzt == null) {
            com_google_android_gms_ads_internal_zzt = new zzt(this);
        }
        this.f6921e = com_google_android_gms_ads_internal_zzt;
        this.f6925i = com_google_android_gms_ads_internal_zze;
        zzw.zzcM().m15143b(this.f6922f.zzqn);
        zzw.zzcQ().m14994a(this.f6922f.zzqn, this.f6922f.zzvn);
        zzw.zzcR().m12849a(this.f6922f.zzqn);
        this.f6924h = zzw.zzcQ().m15030s();
        zzw.zzcP().m12782a(this.f6922f.zzqn);
        mo3241f();
    }

    private TimerTask m7458a(final Timer timer, final CountDownLatch countDownLatch) {
        return new TimerTask(this) {
            final /* synthetic */ zza f6916c;

            public void run() {
                if (((long) ((Integer) qb.cv.m13225c()).intValue()) != countDownLatch.getCount()) {
                    aad.m8421b("Stopping method tracing");
                    Debug.stopMethodTracing();
                    if (countDownLatch.getCount() == 0) {
                        timer.cancel();
                        return;
                    }
                }
                String concat = String.valueOf(this.f6916c.f6922f.zzqn.getPackageName()).concat("_adsTrace_");
                try {
                    aad.m8421b("Starting method tracing");
                    countDownLatch.countDown();
                    Debug.startMethodTracing(new StringBuilder(String.valueOf(concat).length() + 20).append(concat).append(zzw.zzcS().mo3360a()).toString(), ((Integer) qb.cw.m13225c()).intValue());
                } catch (Throwable e) {
                    aad.m8424c("Exception occurred while starting method tracing.", e);
                }
            }
        };
    }

    private zzec mo3271b(zzec com_google_android_gms_internal_zzec) {
        return (!C2583h.m8295c(this.f6922f.zzqn) || com_google_android_gms_internal_zzec.f11887k == null) ? com_google_android_gms_internal_zzec : new oe(com_google_android_gms_internal_zzec).m12899a(null).m12900a();
    }

    private void mo3241f() {
        if (((Boolean) qb.ct.m13225c()).booleanValue()) {
            Timer timer = new Timer();
            timer.schedule(m7458a(timer, new CountDownLatch(((Integer) qb.cv.m13225c()).intValue())), 0, ((Long) qb.cu.m13225c()).longValue());
        }
    }

    long m7461a(String str) {
        int indexOf = str.indexOf("ufe");
        int indexOf2 = str.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(indexOf + 4, indexOf2));
        } catch (IndexOutOfBoundsException e) {
            aad.m8426e("Invalid index for Url fetch time in CSI latency info.");
            return -1;
        } catch (NumberFormatException e2) {
            aad.m8426e("Cannot find valid format of Url fetch time in CSI latency info.");
            return -1;
        }
    }

    protected String m7462a(String str, String str2) {
        return (str == null || TextUtils.isEmpty(str2)) ? str2 : zzw.zzcM().m15099a(str2, "fbs_aeid", str).toString();
    }

    protected List<String> m7463a(String str, List<String> list) {
        if (str == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String a : list) {
            arrayList.add(m7462a(str, a));
        }
        return arrayList;
    }

    protected void mo3283a() {
        aad.m8425d("Ad closing.");
        if (this.f6922f.f7112e != null) {
            try {
                this.f6922f.f7112e.mo3853a();
            } catch (Throwable e) {
                aad.m8424c("Could not call AdListener.onAdClosed().", e);
            }
        }
        if (this.f6922f.f7125r != null) {
            try {
                this.f6922f.f7125r.mo4024d();
            } catch (Throwable e2) {
                aad.m8424c("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", e2);
            }
        }
    }

    protected void m7465a(int i) {
        aad.m8426e("Failed to load ad: " + i);
        this.f6920d = false;
        if (this.f6922f.f7112e != null) {
            try {
                this.f6922f.f7112e.mo3854a(i);
            } catch (Throwable e) {
                aad.m8424c("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
        if (this.f6922f.f7125r != null) {
            try {
                this.f6922f.f7125r.mo4020a(i);
            } catch (Throwable e2) {
                aad.m8424c("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", e2);
            }
        }
    }

    protected void m7466a(View view) {
        com.google.android.gms.ads.internal.zzx.zza com_google_android_gms_ads_internal_zzx_zza = this.f6922f.f7110c;
        if (com_google_android_gms_ads_internal_zzx_zza != null) {
            com_google_android_gms_ads_internal_zzx_zza.addView(view, zzw.zzcO().mo4266d());
        }
    }

    protected void m7467a(@Nullable zzoo com_google_android_gms_internal_zzoo) {
        if (this.f6922f.f7125r != null) {
            try {
                String str = "";
                int i = 1;
                if (com_google_android_gms_internal_zzoo != null) {
                    str = com_google_android_gms_internal_zzoo.f12074a;
                    i = com_google_android_gms_internal_zzoo.f12075b;
                }
                this.f6922f.f7125r.mo4021a(new xo(str, i));
            } catch (Throwable e) {
                aad.m8424c("Could not call RewardedVideoAdListener.onRewarded().", e);
            }
        }
    }

    boolean mo3239a(yy yyVar) {
        return false;
    }

    protected boolean mo3240a(zzec com_google_android_gms_internal_zzec) {
        if (this.f6922f.f7110c == null) {
            return false;
        }
        ViewParent parent = this.f6922f.f7110c.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        return zzw.zzcM().m15132a(view, view.getContext());
    }

    protected void m7470b() {
        aad.m8425d("Ad leaving application.");
        if (this.f6922f.f7112e != null) {
            try {
                this.f6922f.f7112e.mo3855b();
            } catch (Throwable e) {
                aad.m8424c("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
        if (this.f6922f.f7125r != null) {
            try {
                this.f6922f.f7125r.mo4025e();
            } catch (Throwable e2) {
                aad.m8424c("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", e2);
            }
        }
    }

    protected void m7471b(@Nullable yy yyVar) {
        if (yyVar == null) {
            aad.m8426e("Ad state was null when trying to ping impression URLs.");
            return;
        }
        aad.m8421b("Pinging Impression URLs.");
        if (this.f6922f.zzvu != null) {
            this.f6922f.zzvu.m14968a();
        }
        if (yyVar.f11530e != null && !yyVar.f11522F) {
            String d = zzw.zzdl().m14950d(this.f6922f.zzqn);
            zzw.zzcM().m15121a(this.f6922f.zzqn, this.f6922f.zzvn.f12081a, m7463a(d, yyVar.f11530e));
            yyVar.f11522F = true;
            m7473c(yyVar);
            if (yyVar.f11530e.size() > 0) {
                zzw.zzdl().m14951d(this.f6922f.zzqn, d);
            }
        }
    }

    protected void m7472c() {
        aad.m8425d("Ad opening.");
        if (this.f6922f.f7112e != null) {
            try {
                this.f6922f.f7112e.mo3857d();
            } catch (Throwable e) {
                aad.m8424c("Could not call AdListener.onAdOpened().", e);
            }
        }
        if (this.f6922f.f7125r != null) {
            try {
                this.f6922f.f7125r.mo4022b();
            } catch (Throwable e2) {
                aad.m8424c("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", e2);
            }
        }
    }

    protected void m7473c(yy yyVar) {
        if (yyVar != null && !TextUtils.isEmpty(yyVar.f11520D) && !yyVar.f11524H && zzw.zzcU().m15247b()) {
            aad.m8421b("Sending troubleshooting signals to the server.");
            zzw.zzcU().m15242a(this.f6922f.zzqn, this.f6922f.zzvn.f12081a, yyVar.f11520D, this.f6922f.zzvl);
            yyVar.f11524H = true;
        }
    }

    protected void mo3285d() {
        aad.m8425d("Ad finished loading.");
        this.f6920d = false;
        if (this.f6922f.f7112e != null) {
            try {
                this.f6922f.f7112e.mo3856c();
            } catch (Throwable e) {
                aad.m8424c("Could not call AdListener.onAdLoaded().", e);
            }
        }
        if (this.f6922f.f7125r != null) {
            try {
                this.f6922f.f7125r.mo4019a();
            } catch (Throwable e2) {
                aad.m8424c("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", e2);
            }
        }
    }

    public void destroy() {
        C2513c.m7940b("destroy must be called on the main UI thread.");
        this.f6921e.cancel();
        this.f6924h.m12639c(this.f6922f.zzvs);
        this.f6922f.destroy();
    }

    protected void m7475e() {
        if (this.f6922f.f7125r != null) {
            try {
                this.f6922f.f7125r.mo4023c();
            } catch (Throwable e) {
                aad.m8424c("Could not call RewardedVideoAdListener.onVideoStarted().", e);
            }
        }
    }

    public boolean isLoading() {
        return this.f6920d;
    }

    public boolean isReady() {
        C2513c.m7940b("isLoaded must be called on the main UI thread.");
        return this.f6922f.zzvp == null && this.f6922f.zzvq == null && this.f6922f.zzvs != null;
    }

    public void onAdClicked() {
        if (this.f6922f.zzvs == null) {
            aad.m8426e("Ad state was null when trying to ping click URLs.");
            return;
        }
        aad.m8421b("Pinging click URLs.");
        if (this.f6922f.zzvu != null) {
            this.f6922f.zzvu.m14972b();
        }
        if (this.f6922f.zzvs.f11528c != null) {
            String d = zzw.zzdl().m14950d(this.f6922f.zzqn);
            zzw.zzcM().m15121a(this.f6922f.zzqn, this.f6922f.zzvn.f12081a, m7463a(d, this.f6922f.zzvs.f11528c));
            if (this.f6922f.zzvs.f11528c.size() > 0) {
                zzw.zzdl().m14948c(this.f6922f.zzqn, d);
            }
        }
        if (this.f6922f.f7111d != null) {
            try {
                this.f6922f.f7111d.mo3852a();
            } catch (Throwable e) {
                aad.m8424c("Could not notify onAdClicked event.", e);
            }
        }
    }

    public void onAppEvent(String str, @Nullable String str2) {
        if (this.f6922f.f7113f != null) {
            try {
                this.f6922f.f7113f.mo3861a(str, str2);
            } catch (Throwable e) {
                aad.m8424c("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        C2513c.m7940b("pause must be called on the main UI thread.");
    }

    public void resume() {
        C2513c.m7940b("resume must be called on the main UI thread.");
    }

    public void setManualImpressionsEnabled(boolean z) {
        throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    public void setUserId(String str) {
        aad.m8426e("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void stopLoading() {
        C2513c.m7940b("stopLoading must be called on the main UI thread.");
        this.f6920d = false;
        this.f6922f.zzh(true);
    }

    public void zza(oo ooVar) {
        C2513c.m7940b("setAdListener must be called on the main UI thread.");
        this.f6922f.f7111d = ooVar;
    }

    public void zza(op opVar) {
        C2513c.m7940b("setAdListener must be called on the main UI thread.");
        this.f6922f.f7112e = opVar;
    }

    public void zza(ov ovVar) {
        C2513c.m7940b("setAppEventListener must be called on the main UI thread.");
        this.f6922f.f7113f = ovVar;
    }

    public void zza(ox oxVar) {
        C2513c.m7940b("setCorrelationIdProvider must be called on the main UI thread");
        this.f6922f.f7114g = oxVar;
    }

    public void zza(qn qnVar) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    public void zza(vg vgVar) {
        throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
    }

    public void zza(vk vkVar, String str) {
        throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
    }

    public void zza(xu xuVar) {
        C2513c.m7940b("setRewardedVideoAdListener can only be called from the UI thread.");
        this.f6922f.f7125r = xuVar;
    }

    public void zza(C3457a c3457a) {
        if (!(c3457a.f11510b.f12048n == -1 || TextUtils.isEmpty(c3457a.f11510b.f12059y))) {
            long a = m7461a(c3457a.f11510b.f12059y);
            if (a != -1) {
                qh a2 = this.f6917a.m13302a(a + c3457a.f11510b.f12048n);
                this.f6917a.m13307a(a2, "stc");
            }
        }
        this.f6917a.m13304a(c3457a.f11510b.f12059y);
        this.f6917a.m13307a(this.f6918b, "arf");
        this.f6919c = this.f6917a.m13301a();
        this.f6917a.m13305a("gqi", c3457a.f11510b.f12060z);
        this.f6922f.zzvp = null;
        this.f6922f.zzvt = c3457a;
        zza(c3457a, this.f6917a);
    }

    protected abstract void zza(C3457a c3457a, qj qjVar);

    public void zza(zzeg com_google_android_gms_internal_zzeg) {
        C2513c.m7940b("setAdSize must be called on the main UI thread.");
        this.f6922f.zzvr = com_google_android_gms_internal_zzeg;
        if (!(this.f6922f.zzvs == null || this.f6922f.zzvs.f11527b == null || this.f6922f.zzvO != 0)) {
            this.f6922f.zzvs.f11527b.mo3400a(com_google_android_gms_internal_zzeg);
        }
        if (this.f6922f.f7110c != null) {
            if (this.f6922f.f7110c.getChildCount() > 1) {
                this.f6922f.f7110c.removeView(this.f6922f.f7110c.getNextView());
            }
            this.f6922f.f7110c.setMinimumWidth(com_google_android_gms_internal_zzeg.f11900f);
            this.f6922f.f7110c.setMinimumHeight(com_google_android_gms_internal_zzeg.f11897c);
            this.f6922f.f7110c.requestLayout();
        }
    }

    public void zza(@Nullable zzfc com_google_android_gms_internal_zzfc) {
        C2513c.m7940b("setIconAdOptions must be called on the main UI thread.");
        this.f6922f.f7123p = com_google_android_gms_internal_zzfc;
    }

    public void zza(@Nullable zzft com_google_android_gms_internal_zzft) {
        C2513c.m7940b("setVideoOptions must be called on the main UI thread.");
        this.f6922f.f7122o = com_google_android_gms_internal_zzft;
    }

    public void zza(HashSet<yz> hashSet) {
        this.f6922f.zza(hashSet);
    }

    protected abstract boolean zza(@Nullable yy yyVar, yy yyVar2);

    protected abstract boolean zza(zzec com_google_android_gms_internal_zzec, qj qjVar);

    public void zzb(yy yyVar) {
        this.f6917a.m13307a(this.f6919c, "awr");
        this.f6922f.zzvq = null;
        if (!(yyVar.f11529d == -2 || yyVar.f11529d == 3)) {
            zzw.zzcQ().m15001a(this.f6922f.zzdm());
        }
        if (yyVar.f11529d == -1) {
            this.f6920d = false;
            return;
        }
        if (mo3239a(yyVar)) {
            aad.m8421b("Ad refresh scheduled.");
        }
        if (yyVar.f11529d != -2) {
            m7465a(yyVar.f11529d);
            return;
        }
        if (this.f6922f.zzvM == null) {
            this.f6922f.zzvM = new ze(this.f6922f.zzvl);
        }
        this.f6924h.m12638b(this.f6922f.zzvs);
        if (zza(this.f6922f.zzvs, yyVar)) {
            this.f6922f.zzvs = yyVar;
            this.f6922f.zzdv();
            this.f6917a.m13305a("is_mraid", this.f6922f.zzvs.m14963a() ? "1" : "0");
            this.f6917a.m13305a("is_mediation", this.f6922f.zzvs.f11539n ? "1" : "0");
            if (!(this.f6922f.zzvs.f11527b == null || this.f6922f.zzvs.f11527b.mo3424l() == null)) {
                this.f6917a.m13305a("is_delay_pl", this.f6922f.zzvs.f11527b.mo3424l().m8562f() ? "1" : "0");
            }
            this.f6917a.m13307a(this.f6918b, "ttc");
            if (zzw.zzcQ().m15017f() != null) {
                zzw.zzcQ().m15017f().m13283a(this.f6917a);
            }
            if (this.f6922f.zzdq()) {
                mo3285d();
            }
        }
        if (yyVar.f11525I != null) {
            zzw.zzcM().m15124a(this.f6922f.zzqn, yyVar.f11525I);
        }
    }

    public boolean zzb(zzec com_google_android_gms_internal_zzec) {
        C2513c.m7940b("loadAd must be called on the main UI thread.");
        zzw.zzcR().m12848a();
        if (((Boolean) qb.aR.m13225c()).booleanValue()) {
            zzec.m15380a(com_google_android_gms_internal_zzec);
        }
        zzec b = mo3271b(com_google_android_gms_internal_zzec);
        if (this.f6922f.zzvp == null && this.f6922f.zzvq == null) {
            aad.m8425d("Starting ad request.");
            zzbA();
            this.f6918b = this.f6917a.m13301a();
            if (!b.f11882f) {
                String valueOf = String.valueOf(ol.m12979a().m8400a(this.f6922f.zzqn));
                aad.m8425d(new StringBuilder(String.valueOf(valueOf).length() + 71).append("Use AdRequest.Builder.addTestDevice(\"").append(valueOf).append("\") to get test ads on this device.").toString());
            }
            this.f6921e.zzg(b);
            this.f6920d = zza(b, this.f6917a);
            return this.f6920d;
        }
        if (this.f6923g != null) {
            aad.m8426e("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
        } else {
            aad.m8426e("Loading already in progress, saving this object for future refreshes.");
        }
        this.f6923g = b;
        return false;
    }

    public void zzbA() {
        this.f6917a = new qj(((Boolean) qb.f10280T.m13225c()).booleanValue(), "load_ad", this.f6922f.zzvr.f11895a);
        this.f6918b = new qh(-1, null, null);
        this.f6919c = new qh(-1, null, null);
    }

    public C2309a zzbB() {
        C2513c.m7940b("getAdFrame must be called on the main UI thread.");
        return C2312b.m7327a(this.f6922f.f7110c);
    }

    @Nullable
    public zzeg zzbC() {
        C2513c.m7940b("getAdSize must be called on the main UI thread.");
        return this.f6922f.zzvr == null ? null : new zzfr(this.f6922f.zzvr);
    }

    public void zzbD() {
        m7470b();
    }

    public void zzbE() {
        C2513c.m7940b("recordManualImpression must be called on the main UI thread.");
        if (this.f6922f.zzvs == null) {
            aad.m8426e("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        aad.m8421b("Pinging manual tracking URLs.");
        if (this.f6922f.zzvs.f11531f != null && !this.f6922f.zzvs.f11523G) {
            zzw.zzcM().m15121a(this.f6922f.zzqn, this.f6922f.zzvn.f12081a, this.f6922f.zzvs.f11531f);
            this.f6922f.zzvs.f11523G = true;
            zzbL();
        }
    }

    public pb zzbF() {
        return null;
    }

    public void zzbL() {
        m7473c(this.f6922f.zzvs);
    }

    public zze zzby() {
        return this.f6925i;
    }

    public void zzd(zzec com_google_android_gms_internal_zzec) {
        if (mo3240a(com_google_android_gms_internal_zzec)) {
            zzb(com_google_android_gms_internal_zzec);
            return;
        }
        aad.m8425d("Ad is not visible. Not refreshing ad.");
        this.f6921e.zzh(com_google_android_gms_internal_zzec);
    }
}
