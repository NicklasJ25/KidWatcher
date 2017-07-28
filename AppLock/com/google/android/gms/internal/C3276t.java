package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.C2481b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C2445g;
import com.google.android.gms.common.api.C2456a;
import com.google.android.gms.common.api.C2456a.C2448b;
import com.google.android.gms.common.api.C2456a.C2449c;
import com.google.android.gms.common.api.C2456a.C2450d;
import com.google.android.gms.common.api.C2456a.C2451f;
import com.google.android.gms.common.api.C2461c;
import com.google.android.gms.common.api.C2461c.C2459b;
import com.google.android.gms.common.api.C2461c.C2460c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.C2539m;
import com.google.android.gms.common.internal.C2547r;
import com.google.android.gms.common.internal.C2547r.C2518a;
import com.google.android.gms.internal.C2859f.C2676a;
import com.google.android.gms.internal.C3459z.C2884a;
import com.google.android.gms.internal.ac.C2683a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

public final class C3276t extends C2461c implements C2683a {
    final Queue<C2676a<?, ?>> f10648a = new LinkedList();
    C3459z f10649b;
    final Map<C2450d<?>, C2451f> f10650c;
    Set<Scope> f10651d = new HashSet();
    final C2539m f10652e;
    final Map<C2456a<?>, Boolean> f10653f;
    final C2448b<? extends em, en> f10654g;
    Set<at> f10655h = null;
    final au f10656i;
    private final Lock f10657j;
    private boolean f10658k;
    private final C2547r f10659l;
    private ac f10660m = null;
    private final int f10661n;
    private final Context f10662o;
    private final Looper f10663p;
    private volatile boolean f10664q;
    private long f10665r = 120000;
    private long f10666s = 5000;
    private final C3274a f10667t;
    private final C2481b f10668u;
    private final ai f10669v = new ai();
    private final ArrayList<C2977i> f10670w;
    private Integer f10671x = null;
    private final C2518a f10672y = new C32731(this);

    class C32731 implements C2518a {
        final /* synthetic */ C3276t f10645a;

        C32731(C3276t c3276t) {
            this.f10645a = c3276t;
        }

        public boolean mo4026b() {
            return this.f10645a.m13864e();
        }

        public Bundle mo4027u() {
            return null;
        }
    }

    final class C3274a extends Handler {
        final /* synthetic */ C3276t f10646a;

        C3274a(C3276t c3276t, Looper looper) {
            this.f10646a = c3276t;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f10646a.m13849n();
                    return;
                case 2:
                    this.f10646a.m13848m();
                    return;
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
                    return;
            }
        }
    }

    static class C3275b extends C2884a {
        private WeakReference<C3276t> f10647a;

        C3275b(C3276t c3276t) {
            this.f10647a = new WeakReference(c3276t);
        }

        public void mo3648a() {
            C3276t c3276t = (C3276t) this.f10647a.get();
            if (c3276t != null) {
                c3276t.m13848m();
            }
        }
    }

    public C3276t(Context context, Lock lock, Looper looper, C2539m c2539m, C2481b c2481b, C2448b<? extends em, en> c2448b, Map<C2456a<?>, Boolean> map, List<C2459b> list, List<C2460c> list2, Map<C2450d<?>, C2451f> map2, int i, int i2, ArrayList<C2977i> arrayList, boolean z) {
        this.f10662o = context;
        this.f10657j = lock;
        this.f10658k = z;
        this.f10659l = new C2547r(looper, this.f10672y);
        this.f10663p = looper;
        this.f10667t = new C3274a(this, looper);
        this.f10668u = c2481b;
        this.f10661n = i;
        if (this.f10661n >= 0) {
            this.f10671x = Integer.valueOf(i2);
        }
        this.f10653f = map;
        this.f10650c = map2;
        this.f10670w = arrayList;
        this.f10656i = new au(this.f10650c);
        for (C2459b a : list) {
            this.f10659l.m8079a(a);
        }
        for (C2460c a2 : list2) {
            this.f10659l.m8080a(a2);
        }
        this.f10652e = c2539m;
        this.f10654g = c2448b;
    }

    public static int m13842a(Iterable<C2451f> iterable, boolean z) {
        int i = 0;
        int i2 = 0;
        for (C2451f c2451f : iterable) {
            if (c2451f.mo3584d()) {
                i2 = 1;
            }
            i = c2451f.m7743f() ? 1 : i;
        }
        return i2 != 0 ? (i == 0 || !z) ? 1 : 2 : 3;
    }

    static String m13844b(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void m13846c(int i) {
        if (this.f10671x == null) {
            this.f10671x = Integer.valueOf(i);
        } else if (this.f10671x.intValue() != i) {
            String valueOf = String.valueOf(C3276t.m13844b(i));
            String valueOf2 = String.valueOf(C3276t.m13844b(this.f10671x.intValue()));
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(valueOf2).length()).append("Cannot use sign-in mode: ").append(valueOf).append(". Mode was already set to ").append(valueOf2).toString());
        }
        if (this.f10660m == null) {
            boolean z = false;
            boolean z2 = false;
            for (C2451f c2451f : this.f10650c.values()) {
                if (c2451f.mo3584d()) {
                    z2 = true;
                }
                z = c2451f.m7743f() ? true : z;
            }
            switch (this.f10671x.intValue()) {
                case 1:
                    if (!z2) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (z) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (z2) {
                        if (this.f10658k) {
                            this.f10660m = new C3049m(this.f10662o, this.f10657j, this.f10663p, this.f10668u, this.f10650c, this.f10652e, this.f10653f, this.f10654g, this.f10670w, this, true);
                            return;
                        } else {
                            this.f10660m = C3021k.m12125a(this.f10662o, this, this.f10657j, this.f10663p, this.f10668u, this.f10650c, this.f10652e, this.f10653f, this.f10654g, this.f10670w);
                            return;
                        }
                    }
                    break;
            }
            if (!this.f10658k || z) {
                this.f10660m = new C3349v(this.f10662o, this, this.f10657j, this.f10663p, this.f10668u, this.f10650c, this.f10652e, this.f10653f, this.f10654g, this.f10670w, this);
            } else {
                this.f10660m = new C3049m(this.f10662o, this.f10657j, this.f10663p, this.f10668u, this.f10650c, this.f10652e, this.f10653f, this.f10654g, this.f10670w, this, false);
            }
        }
    }

    private void m13847l() {
        this.f10659l.m8081b();
        this.f10660m.mo3804a();
    }

    private void m13848m() {
        this.f10657j.lock();
        try {
            if (m13865f()) {
                m13847l();
            }
            this.f10657j.unlock();
        } catch (Throwable th) {
            this.f10657j.unlock();
        }
    }

    private void m13849n() {
        this.f10657j.lock();
        try {
            if (m13867h()) {
                m13847l();
            }
            this.f10657j.unlock();
        } catch (Throwable th) {
            this.f10657j.unlock();
        }
    }

    public Looper mo4028a() {
        return this.f10663p;
    }

    <C extends C2451f> C m13851a(C2450d<?> c2450d) {
        Object obj = (C2451f) this.f10650c.get(c2450d);
        C2513c.m7933a(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public <A extends C2449c, T extends C2676a<? extends C2445g, A>> T mo4029a(@NonNull T t) {
        C2513c.m7942b(t.mo3473b() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.f10650c.containsKey(t.mo3473b());
        String d = t.mo3474c() != null ? t.mo3474c().m7752d() : "the API";
        C2513c.m7942b(containsKey, new StringBuilder(String.valueOf(d).length() + 65).append("GoogleApiClient is not configured to use ").append(d).append(" required for this call.").toString());
        this.f10657j.lock();
        try {
            if (this.f10660m == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (m13865f()) {
                this.f10648a.add(t);
                while (!this.f10648a.isEmpty()) {
                    C2675h c2675h = (C2676a) this.f10648a.remove();
                    this.f10656i.m9037a(c2675h);
                    c2675h.m8871a(Status.zzazz);
                }
            } else {
                t = this.f10660m.mo3803a(t);
                this.f10657j.unlock();
            }
            return t;
        } finally {
            this.f10657j.unlock();
        }
    }

    public void mo4030a(int i) {
        boolean z = true;
        this.f10657j.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            C2513c.m7942b(z, "Illegal sign-in mode: " + i);
            m13846c(i);
            m13847l();
        } finally {
            this.f10657j.unlock();
        }
    }

    public void mo3800a(int i, boolean z) {
        if (i == 1 && !z) {
            m13866g();
        }
        this.f10656i.m9039b();
        this.f10659l.m8076a(i);
        this.f10659l.m8075a();
        if (i == 2) {
            m13847l();
        }
    }

    public void mo3801a(Bundle bundle) {
        while (!this.f10648a.isEmpty()) {
            mo4029a((C2676a) this.f10648a.remove());
        }
        this.f10659l.m8077a(bundle);
    }

    public void mo3802a(ConnectionResult connectionResult) {
        if (!this.f10668u.mo3321b(this.f10662o, connectionResult.m7714c())) {
            m13867h();
        }
        if (!m13865f()) {
            this.f10659l.m8078a(connectionResult);
            this.f10659l.m8075a();
        }
    }

    public void mo3869a(@NonNull C2460c c2460c) {
        this.f10659l.m8080a(c2460c);
    }

    public void mo4031a(at atVar) {
        this.f10657j.lock();
        try {
            if (this.f10655h == null) {
                this.f10655h = new HashSet();
            }
            this.f10655h.add(atVar);
        } finally {
            this.f10657j.unlock();
        }
    }

    public void mo3870a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.f10662o);
        printWriter.append(str).append("mResuming=").print(this.f10664q);
        printWriter.append(" mWorkQueue.size()=").print(this.f10648a.size());
        this.f10656i.m9038a(printWriter);
        if (this.f10660m != null) {
            this.f10660m.mo3805a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void mo3871b() {
        boolean z = false;
        this.f10657j.lock();
        try {
            if (this.f10661n >= 0) {
                if (this.f10671x != null) {
                    z = true;
                }
                C2513c.m7938a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f10671x == null) {
                this.f10671x = Integer.valueOf(C3276t.m13842a(this.f10650c.values(), false));
            } else if (this.f10671x.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            mo4030a(this.f10671x.intValue());
        } finally {
            this.f10657j.unlock();
        }
    }

    public void mo3872b(@NonNull C2460c c2460c) {
        this.f10659l.m8082b(c2460c);
    }

    public void mo4032b(at atVar) {
        this.f10657j.lock();
        try {
            if (this.f10655h == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.f10655h.remove(atVar)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!m13868i()) {
                this.f10660m.mo3808d();
            }
            this.f10657j.unlock();
        } catch (Throwable th) {
            this.f10657j.unlock();
        }
    }

    public void mo3873c() {
        this.f10657j.lock();
        try {
            this.f10656i.m9036a();
            if (this.f10660m != null) {
                this.f10660m.mo3806b();
            }
            this.f10669v.m8975a();
            for (C2676a c2676a : this.f10648a) {
                c2676a.m8861a(null);
                c2676a.m8865e();
            }
            this.f10648a.clear();
            if (this.f10660m != null) {
                m13867h();
                this.f10659l.m8075a();
                this.f10657j.unlock();
            }
        } finally {
            this.f10657j.unlock();
        }
    }

    public boolean m13864e() {
        return this.f10660m != null && this.f10660m.mo3807c();
    }

    boolean m13865f() {
        return this.f10664q;
    }

    void m13866g() {
        if (!m13865f()) {
            this.f10664q = true;
            if (this.f10649b == null) {
                this.f10649b = this.f10668u.m7828a(this.f10662o.getApplicationContext(), new C3275b(this));
            }
            this.f10667t.sendMessageDelayed(this.f10667t.obtainMessage(1), this.f10665r);
            this.f10667t.sendMessageDelayed(this.f10667t.obtainMessage(2), this.f10666s);
        }
    }

    boolean m13867h() {
        if (!m13865f()) {
            return false;
        }
        this.f10664q = false;
        this.f10667t.removeMessages(2);
        this.f10667t.removeMessages(1);
        if (this.f10649b != null) {
            this.f10649b.m14977a();
            this.f10649b = null;
        }
        return true;
    }

    boolean m13868i() {
        boolean z = false;
        this.f10657j.lock();
        try {
            if (this.f10655h != null) {
                if (!this.f10655h.isEmpty()) {
                    z = true;
                }
                this.f10657j.unlock();
            }
            return z;
        } finally {
            this.f10657j.unlock();
        }
    }

    String m13869j() {
        Writer stringWriter = new StringWriter();
        mo3870a("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public int m13870k() {
        return System.identityHashCode(this);
    }
}
