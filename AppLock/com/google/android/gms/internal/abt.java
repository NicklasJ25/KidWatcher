package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.api.C2445g;
import com.google.android.gms.common.api.C2456a.C2416a.C2446b;
import com.google.android.gms.common.api.C2456a.C2449c;
import com.google.android.gms.common.api.C2461c;
import com.google.android.gms.common.api.C2463d;
import com.google.android.gms.common.api.C2475n;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C2859f.C2676a;
import com.google.android.gms.internal.abw.C2672a;

public class abt extends C2475n<C2446b> implements abr {

    static class C2673a extends C2672a {
        C2673a() {
        }

        public void mo3465a(Status status) {
            throw new UnsupportedOperationException();
        }

        public void mo3466a(Status status, long j) {
            throw new UnsupportedOperationException();
        }

        public void mo3467b(Status status) {
            throw new UnsupportedOperationException();
        }

        public void mo3468b(Status status, long j) {
            throw new UnsupportedOperationException();
        }

        public void mo3469c(Status status) {
            throw new UnsupportedOperationException();
        }
    }

    static final class C2677b extends C2676a<Status, abu> {
        private final zzzm f7870d;

        class C26741 extends C2673a {
            final /* synthetic */ C2677b f7850a;

            C26741(C2677b c2677b) {
                this.f7850a = c2677b;
            }

            public void mo3465a(Status status) {
                this.f7850a.m8859a((C2445g) status);
            }
        }

        C2677b(zzzm com_google_android_gms_internal_zzzm, C2461c c2461c) {
            super(abq.f7837c, c2461c);
            this.f7870d = com_google_android_gms_internal_zzzm;
        }

        protected void m8876a(abu com_google_android_gms_internal_abu) {
            abw c26741 = new C26741(this);
            try {
                abt.m8881b(this.f7870d);
                com_google_android_gms_internal_abu.m8884a(c26741, this.f7870d);
            } catch (Throwable e) {
                Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", e);
                m8871a(new Status(10, "MessageProducer"));
            }
        }

        protected /* synthetic */ void mo3475b(C2449c c2449c) {
            m8876a((abu) c2449c);
        }

        protected /* synthetic */ C2445g mo3476c(Status status) {
            return m8879d(status);
        }

        protected Status m8879d(Status status) {
            return status;
        }
    }

    abt(@NonNull Context context) {
        super(context, abq.f7837c, null, new acc());
    }

    public static abr m8880a(@NonNull Context context) {
        return new abt(context);
    }

    static void m8881b(zzzm com_google_android_gms_internal_zzzm) {
        if (com_google_android_gms_internal_zzzm.f12094i != null && com_google_android_gms_internal_zzzm.f12093h.f9807k.length == 0) {
            com_google_android_gms_internal_zzzm.f12093h.f9807k = com_google_android_gms_internal_zzzm.f12094i.m8814a();
        }
        if (com_google_android_gms_internal_zzzm.f12095j != null && com_google_android_gms_internal_zzzm.f12093h.f9814r.length == 0) {
            com_google_android_gms_internal_zzzm.f12093h.f9814r = com_google_android_gms_internal_zzzm.f12095j.m8814a();
        }
        com_google_android_gms_internal_zzzm.f12087b = mb.m9124a(com_google_android_gms_internal_zzzm.f12093h);
    }

    public C2463d<Status> mo3477a(zzzm com_google_android_gms_internal_zzzm) {
        return m7796b(new C2677b(com_google_android_gms_internal_zzzm, m7798d()));
    }
}
