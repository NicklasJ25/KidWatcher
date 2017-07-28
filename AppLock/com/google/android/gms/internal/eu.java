package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.C2424c;
import com.google.android.gms.common.api.C2461c.C2459b;
import com.google.android.gms.common.api.C2461c.C2460c;
import com.google.android.gms.common.internal.C2503v;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.C2517l.C2535i;
import com.google.android.gms.common.internal.C2519q;
import com.google.android.gms.common.internal.C2539m;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.internal.es.C2855a;

public class eu extends C2519q<es> implements em {
    private final boolean f8854e;
    private final C2539m f8855f;
    private final Bundle f8856g;
    private Integer f8857h;

    public eu(Context context, Looper looper, boolean z, C2539m c2539m, Bundle bundle, C2459b c2459b, C2460c c2460c) {
        super(context, looper, 44, c2539m, c2459b, c2460c);
        this.f8854e = z;
        this.f8855f = c2539m;
        this.f8856g = bundle;
        this.f8857h = c2539m.m8055i();
    }

    public eu(Context context, Looper looper, boolean z, C2539m c2539m, en enVar, C2459b c2459b, C2460c c2460c) {
        this(context, looper, z, c2539m, m10679a(c2539m), c2459b, c2460c);
    }

    public static Bundle m10679a(C2539m c2539m) {
        en h = c2539m.m8054h();
        Integer i = c2539m.m8055i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", c2539m.m8046a());
        if (i != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", i.intValue());
        }
        if (h != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", h.m10634a());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", h.m10635b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", h.m10636c());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", h.m10637d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", h.m10638e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", h.m10639f());
            if (h.m10640g() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", h.m10640g().longValue());
            }
            if (h.m10641h() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", h.m10641h().longValue());
            }
        }
        return bundle;
    }

    private zzad m10680y() {
        Account b = this.f8855f.m8048b();
        GoogleSignInAccount googleSignInAccount = null;
        if ("<<default account>>".equals(b.name)) {
            googleSignInAccount = C2424c.m7661a(m7988o()).m7663a();
        }
        return new zzad(b, this.f8857h.intValue(), googleSignInAccount);
    }

    protected /* synthetic */ IInterface mo3335a(IBinder iBinder) {
        return m10684b(iBinder);
    }

    public void mo3582a(C2503v c2503v, boolean z) {
        try {
            ((es) m7995v()).mo3573a(c2503v, this.f8857h.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void mo3583a(er erVar) {
        C2513c.m7933a((Object) erVar, (Object) "Expecting a valid ISignInCallbacks");
        try {
            ((es) m7995v()).mo3579a(new zzbau(m10680y()), erVar);
        } catch (Throwable e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                erVar.mo3494a(new zzbaw(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    protected es m10684b(IBinder iBinder) {
        return C2855a.m10675a(iBinder);
    }

    public boolean mo3584d() {
        return this.f8854e;
    }

    protected String mo3336i() {
        return "com.google.android.gms.signin.service.START";
    }

    protected String mo3337j() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public void mo3338k() {
        try {
            ((es) m7995v()).mo3571a(this.f8857h.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public void mo3585l() {
        m7972a(new C2535i(this));
    }

    protected Bundle mo3586s() {
        if (!m7988o().getPackageName().equals(this.f8855f.m8052f())) {
            this.f8856g.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f8855f.m8052f());
        }
        return this.f8856g;
    }
}
