package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.google.android.gms.common.api.C2445g;
import com.google.android.gms.common.api.C2456a.C2450d;
import com.google.android.gms.common.api.C2456a.C2451f;
import com.google.android.gms.common.api.C2476o;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C2859f.C2676a;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class au {
    public static final Status f7942a = new Status(8, "The connection to Google Play services was lost");
    private static final C2675h<?>[] f7943c = new C2675h[0];
    final Set<C2675h<?>> f7944b = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final C2695b f7945d = new C26961(this);
    private final Map<C2450d<?>, C2451f> f7946e;

    interface C2695b {
        void mo3501a(C2675h<?> c2675h);
    }

    class C26961 implements C2695b {
        final /* synthetic */ au f7938a;

        C26961(au auVar) {
            this.f7938a = auVar;
        }

        public void mo3501a(C2675h<?> c2675h) {
            this.f7938a.f7944b.remove(c2675h);
            if (c2675h.mo3470a() != null) {
                null;
            }
        }
    }

    private static class C2697a implements DeathRecipient, C2695b {
        private final WeakReference<C2675h<?>> f7939a;
        private final WeakReference<C2476o> f7940b;
        private final WeakReference<IBinder> f7941c;

        private C2697a(C2675h<?> c2675h, C2476o c2476o, IBinder iBinder) {
            this.f7940b = new WeakReference(c2476o);
            this.f7939a = new WeakReference(c2675h);
            this.f7941c = new WeakReference(iBinder);
        }

        private void m9032a() {
            C2675h c2675h = (C2675h) this.f7939a.get();
            C2476o c2476o = (C2476o) this.f7940b.get();
            if (!(c2476o == null || c2675h == null)) {
                c2476o.m7800a(c2675h.mo3470a().intValue());
            }
            IBinder iBinder = (IBinder) this.f7941c.get();
            if (iBinder != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        public void mo3501a(C2675h<?> c2675h) {
            m9032a();
        }

        public void binderDied() {
            m9032a();
        }
    }

    public au(Map<C2450d<?>, C2451f> map) {
        this.f7946e = map;
    }

    private static void m9035a(C2675h<?> c2675h, C2476o c2476o, IBinder iBinder) {
        if (c2675h.m8864d()) {
            c2675h.m8861a(new C2697a(c2675h, c2476o, iBinder));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            c2675h.m8861a(null);
            c2675h.m8865e();
            c2476o.m7800a(c2675h.mo3470a().intValue());
        } else {
            C2695b c2697a = new C2697a(c2675h, c2476o, iBinder);
            c2675h.m8861a(c2697a);
            try {
                iBinder.linkToDeath(c2697a, 0);
            } catch (RemoteException e) {
                c2675h.m8865e();
                c2476o.m7800a(c2675h.mo3470a().intValue());
            }
        }
    }

    public void m9036a() {
        for (C2675h c2675h : (C2675h[]) this.f7944b.toArray(f7943c)) {
            c2675h.m8861a(null);
            if (c2675h.mo3470a() != null) {
                c2675h.m8868h();
                m9035a(c2675h, null, ((C2451f) this.f7946e.get(((C2676a) c2675h).mo3473b())).m7745h());
                this.f7944b.remove(c2675h);
            } else if (c2675h.m8866f()) {
                this.f7944b.remove(c2675h);
            }
        }
    }

    void m9037a(C2675h<? extends C2445g> c2675h) {
        this.f7944b.add(c2675h);
        c2675h.m8861a(this.f7945d);
    }

    public void m9038a(PrintWriter printWriter) {
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f7944b.size());
    }

    public void m9039b() {
        for (C2675h b : (C2675h[]) this.f7944b.toArray(f7943c)) {
            b.m8862b(f7942a);
        }
    }
}
