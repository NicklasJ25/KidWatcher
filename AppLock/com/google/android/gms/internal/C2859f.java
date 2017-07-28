package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C2445g;
import com.google.android.gms.common.api.C2456a;
import com.google.android.gms.common.api.C2456a.C2449c;
import com.google.android.gms.common.api.C2456a.C2450d;
import com.google.android.gms.common.api.C2461c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2513c;

public class C2859f {

    public static abstract class C2676a<R extends C2445g, A extends C2449c> extends C2675h<R> {
        private final C2450d<A> f7868d;
        private final C2456a<?> f7869e;

        protected C2676a(C2456a<?> c2456a, C2461c c2461c) {
            super((C2461c) C2513c.m7933a((Object) c2461c, (Object) "GoogleApiClient must not be null"));
            this.f7868d = c2456a.m7751c();
            this.f7869e = c2456a;
        }

        private void m8870a(RemoteException remoteException) {
            m8871a(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        public final void m8871a(Status status) {
            C2513c.m7942b(!status.m7729d(), "Failed result must not be success");
            m8859a(mo3476c(status));
        }

        public final void m8872a(A a) {
            try {
                mo3475b(a);
            } catch (RemoteException e) {
                m8870a(e);
                throw e;
            } catch (RemoteException e2) {
                m8870a(e2);
            }
        }

        public final C2450d<A> mo3473b() {
            return this.f7868d;
        }

        protected abstract void mo3475b(A a);

        public final C2456a<?> mo3474c() {
            return this.f7869e;
        }
    }
}
