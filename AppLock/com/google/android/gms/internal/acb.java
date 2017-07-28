package com.google.android.gms.internal;

import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.api.C2445g;
import com.google.android.gms.common.api.C2456a.C2449c;
import com.google.android.gms.common.api.C2470l;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.C2590o;
import com.google.android.gms.internal.C2859f.C2676a;
import com.google.android.gms.internal.C3424x.C3421a;
import com.google.android.gms.internal.ah.C2688a;
import com.google.android.gms.p004b.C2429f;

public abstract class acb {
    public final int f7880a;

    private static abstract class C2684a extends acb {
        protected final C2429f<Void> f7881b;

        public C2684a(int i, C2429f<Void> c2429f) {
            super(i);
            this.f7881b = c2429f;
        }

        public void mo3484a(@NonNull Status status) {
            this.f7881b.m7682b(new C2470l(status));
        }

        public void mo3485a(@NonNull C3081n c3081n, boolean z) {
        }

        public final void mo3486a(C3421a<?> c3421a) {
            try {
                mo3487b(c3421a);
            } catch (RemoteException e) {
                mo3484a(acb.m8935b(e));
                throw e;
            } catch (RemoteException e2) {
                mo3484a(acb.m8935b(e2));
            }
        }

        protected abstract void mo3487b(C3421a<?> c3421a);
    }

    public static class C2685b<A extends C2676a<? extends C2445g, C2449c>> extends acb {
        protected final A f7882b;

        public C2685b(int i, A a) {
            super(i);
            this.f7882b = a;
        }

        public void mo3484a(@NonNull Status status) {
            this.f7882b.m8871a(status);
        }

        public void mo3485a(@NonNull C3081n c3081n, boolean z) {
            c3081n.m12723a(this.f7882b, z);
        }

        public void mo3486a(C3421a<?> c3421a) {
            this.f7882b.m8872a(c3421a.m14613b());
        }
    }

    public static final class C2686c extends C2684a {
        public final C2688a<?> f7883c;

        public C2686c(C2688a<?> c2688a, C2429f<Void> c2429f) {
            super(4, c2429f);
            this.f7883c = c2688a;
        }

        public /* bridge */ /* synthetic */ void mo3484a(@NonNull Status status) {
            super.mo3484a(status);
        }

        public /* bridge */ /* synthetic */ void mo3485a(@NonNull C3081n c3081n, boolean z) {
            super.mo3485a(c3081n, z);
        }

        public void mo3487b(C3421a<?> c3421a) {
            al alVar = (al) c3421a.m14615c().remove(this.f7883c);
            if (alVar != null) {
                alVar.f7905a.m8976a();
                return;
            }
            Log.wtf("UnregisterListenerTask", "Received call to unregister a listener without a matching registration call.", new Exception());
            this.b.m7682b(new C2470l(Status.zzazz));
        }
    }

    public acb(int i) {
        this.f7880a = i;
    }

    private static Status m8935b(RemoteException remoteException) {
        StringBuilder stringBuilder = new StringBuilder();
        if (C2590o.m8308c() && (remoteException instanceof TransactionTooLargeException)) {
            stringBuilder.append("TransactionTooLargeException: ");
        }
        stringBuilder.append(remoteException.getLocalizedMessage());
        return new Status(8, stringBuilder.toString());
    }

    public abstract void mo3484a(@NonNull Status status);

    public abstract void mo3485a(@NonNull C3081n c3081n, boolean z);

    public abstract void mo3486a(C3421a<?> c3421a);
}
