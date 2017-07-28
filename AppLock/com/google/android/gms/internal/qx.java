package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.qz.C3180a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@wh
public class qx extends ra {
    @Nullable
    private uf f10419b;
    @Nullable
    private ug f10420c;
    private final zzs f10421d;
    @Nullable
    private qz f10422e;
    private boolean f10423f;
    private Object f10424g;

    private qx(Context context, zzs com_google_android_gms_ads_internal_zzs, ed edVar, C3180a c3180a) {
        super(context, com_google_android_gms_ads_internal_zzs, null, edVar, null, c3180a, null, null);
        this.f10423f = false;
        this.f10424g = new Object();
        this.f10421d = com_google_android_gms_ads_internal_zzs;
    }

    public qx(Context context, zzs com_google_android_gms_ads_internal_zzs, ed edVar, uf ufVar, C3180a c3180a) {
        this(context, com_google_android_gms_ads_internal_zzs, edVar, c3180a);
        this.f10419b = ufVar;
    }

    public qx(Context context, zzs com_google_android_gms_ads_internal_zzs, ed edVar, ug ugVar, C3180a c3180a) {
        this(context, com_google_android_gms_ads_internal_zzs, edVar, c3180a);
        this.f10420c = ugVar;
    }

    @Nullable
    public View mo3959a(OnClickListener onClickListener, boolean z) {
        synchronized (this.f10424g) {
            if (this.f10422e != null) {
                View a = this.f10422e.mo3959a(onClickListener, z);
                return a;
            }
            C2309a n;
            try {
                if (this.f10419b != null) {
                    n = this.f10419b.mo4101n();
                } else {
                    if (this.f10420c != null) {
                        n = this.f10420c.mo4115k();
                    }
                    n = null;
                }
            } catch (Throwable e) {
                aad.m8424c("Failed to call getAdChoicesContent", e);
            }
            if (n != null) {
                a = (View) C2312b.m7328a(n);
                return a;
            }
            return null;
        }
    }

    public void mo3964a(View view, Map<String, WeakReference<View>> map) {
        C2513c.m7940b("recordImpression must be called on the main UI thread.");
        synchronized (this.f10424g) {
            m13470a(true);
            if (this.f10422e != null) {
                this.f10422e.mo3964a(view, (Map) map);
                this.f10421d.recordImpression();
            } else {
                try {
                    if (this.f10419b != null && !this.f10419b.mo4097j()) {
                        this.f10419b.mo4096i();
                        this.f10421d.recordImpression();
                    } else if (!(this.f10420c == null || this.f10420c.mo4112h())) {
                        this.f10420c.mo4111g();
                        this.f10421d.recordImpression();
                    }
                } catch (Throwable e) {
                    aad.m8424c("Failed to call recordImpression", e);
                }
            }
        }
    }

    public void mo3971a(View view, Map<String, WeakReference<View>> map, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        synchronized (this.f10424g) {
            this.f10423f = true;
            try {
                if (this.f10419b != null) {
                    this.f10419b.mo4088b(C2312b.m7327a((Object) view));
                } else if (this.f10420c != null) {
                    this.f10420c.mo4105b(C2312b.m7327a((Object) view));
                }
            } catch (Throwable e) {
                aad.m8424c("Failed to call prepareAd", e);
            }
            this.f10423f = false;
        }
    }

    public void mo3965a(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, View view2) {
        C2513c.m7940b("performClick must be called on the main UI thread.");
        synchronized (this.f10424g) {
            if (this.f10422e != null) {
                this.f10422e.mo3965a(view, map, jSONObject, view2);
                this.f10421d.onAdClicked();
            } else {
                try {
                    if (!(this.f10419b == null || this.f10419b.mo4098k())) {
                        this.f10419b.mo4086a(C2312b.m7327a((Object) view));
                        this.f10421d.onAdClicked();
                    }
                    if (!(this.f10420c == null || this.f10420c.mo4113i())) {
                        this.f10420c.mo4103a(C2312b.m7327a((Object) view));
                        this.f10421d.onAdClicked();
                    }
                } catch (Throwable e) {
                    aad.m8424c("Failed to call performClick", e);
                }
            }
        }
    }

    public void m13488a(@Nullable qz qzVar) {
        synchronized (this.f10424g) {
            this.f10422e = qzVar;
        }
    }

    public boolean mo3966a() {
        boolean a;
        synchronized (this.f10424g) {
            if (this.f10422e != null) {
                a = this.f10422e.mo3966a();
            } else {
                a = this.f10421d.zzcx();
            }
        }
        return a;
    }

    public void mo3967b(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.f10424g) {
            try {
                if (this.f10419b != null) {
                    this.f10419b.mo4090c(C2312b.m7327a((Object) view));
                } else if (this.f10420c != null) {
                    this.f10420c.mo4107c(C2312b.m7327a((Object) view));
                }
            } catch (Throwable e) {
                aad.m8424c("Failed to call untrackView", e);
            }
        }
    }

    public boolean m13491b() {
        boolean z;
        synchronized (this.f10424g) {
            z = this.f10423f;
        }
        return z;
    }

    public qz m13492c() {
        qz qzVar;
        synchronized (this.f10424g) {
            qzVar = this.f10422e;
        }
        return qzVar;
    }

    @Nullable
    public aat mo3972d() {
        return null;
    }
}
