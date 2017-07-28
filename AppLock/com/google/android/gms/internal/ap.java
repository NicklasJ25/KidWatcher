package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.C2424c;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C2456a.C2448b;
import com.google.android.gms.common.api.C2461c.C2459b;
import com.google.android.gms.common.api.C2461c.C2460c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C2503v;
import com.google.android.gms.common.internal.C2539m;
import com.google.android.gms.common.internal.zzaf;
import java.util.HashSet;
import java.util.Set;

public class ap extends ep implements C2459b, C2460c {
    private static C2448b<? extends em, en> f7910a = el.f8837c;
    private final Context f7911b;
    private final Handler f7912c;
    private final C2448b<? extends em, en> f7913d;
    private final boolean f7914e;
    private Set<Scope> f7915f;
    private C2539m f7916g;
    private em f7917h;
    private C2690a f7918i;

    @WorkerThread
    public interface C2690a {
        void mo4191a(C2503v c2503v, Set<Scope> set);

        void mo4192b(ConnectionResult connectionResult);
    }

    @WorkerThread
    public ap(Context context, Handler handler) {
        this.f7911b = context;
        this.f7912c = handler;
        this.f7913d = f7910a;
        this.f7914e = true;
    }

    @WorkerThread
    public ap(Context context, Handler handler, C2539m c2539m, C2448b<? extends em, en> c2448b) {
        this.f7911b = context;
        this.f7912c = handler;
        this.f7916g = c2539m;
        this.f7915f = c2539m.m8049c();
        this.f7913d = c2448b;
        this.f7914e = false;
    }

    @WorkerThread
    private void m8997b(zzbaw com_google_android_gms_internal_zzbaw) {
        ConnectionResult a = com_google_android_gms_internal_zzbaw.m15371a();
        if (a.m7713b()) {
            zzaf b = com_google_android_gms_internal_zzbaw.m15372b();
            ConnectionResult b2 = b.m8191b();
            if (b2.m7713b()) {
                this.f7918i.mo4191a(b.m8190a(), this.f7915f);
            } else {
                String valueOf = String.valueOf(b2);
                Log.wtf("SignInCoordinator", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                this.f7918i.mo4192b(b2);
                this.f7917h.m7735a();
                return;
            }
        }
        this.f7918i.mo4192b(a);
        this.f7917h.m7735a();
    }

    public em m8998a() {
        return this.f7917h;
    }

    @WorkerThread
    public void mo3496a(int i) {
        this.f7917h.m7735a();
    }

    @WorkerThread
    public void mo3497a(@Nullable Bundle bundle) {
        this.f7917h.mo3583a(this);
    }

    @WorkerThread
    public void mo3498a(@NonNull ConnectionResult connectionResult) {
        this.f7918i.mo4192b(connectionResult);
    }

    @WorkerThread
    public void m9002a(C2690a c2690a) {
        if (this.f7917h != null) {
            this.f7917h.m7735a();
        }
        if (this.f7914e) {
            GoogleSignInOptions b = C2424c.m7661a(this.f7911b).m7665b();
            this.f7915f = b == null ? new HashSet() : new HashSet(b.m7641a());
            this.f7916g = new C2539m(null, this.f7915f, null, 0, null, null, null, en.f8843a);
        }
        this.f7917h = (em) this.f7913d.mo3464a(this.f7911b, this.f7912c.getLooper(), this.f7916g, this.f7916g.m8054h(), this, this);
        this.f7918i = c2690a;
        this.f7917h.mo3585l();
    }

    @BinderThread
    public void mo3494a(final zzbaw com_google_android_gms_internal_zzbaw) {
        this.f7912c.post(new Runnable(this) {
            final /* synthetic */ ap f7909b;

            public void run() {
                this.f7909b.m8997b(com_google_android_gms_internal_zzbaw);
            }
        });
    }

    public void m9004b() {
        this.f7917h.m7735a();
    }
}
