package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.internal.gw.C2925a;
import com.google.android.gms.internal.gw.C2926b;
import com.google.android.gms.p004b.C2425b;
import com.google.android.gms.p004b.C2426c;
import com.google.firebase.C3528a;
import com.google.firebase.C3531b;
import com.google.firebase.C3531b.C2869a;
import com.google.firebase.p067a.C3527a;
import java.util.concurrent.ScheduledExecutorService;

public class fs implements gw {
    private final ScheduledExecutorService f8953a;
    private final C3531b f8954b;

    public fs(@NonNull C3531b c3531b, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.f8954b = c3531b;
        this.f8953a = scheduledExecutorService;
    }

    private C2869a m10804b(final C2926b c2926b) {
        return new C2869a(this) {
            final /* synthetic */ fs f8952b;
        };
    }

    public void mo3597a(C2926b c2926b) {
        this.f8954b.m15432a(m10804b(c2926b));
    }

    public void mo3598a(boolean z, @NonNull final C2925a c2925a) {
        this.f8954b.m15434b(z).mo3309a(this.f8953a, new C2426c<C3527a>(this) {
            public void m10800a(C3527a c3527a) {
                c2925a.mo3697a(c3527a.m15413a());
            }

            public /* synthetic */ void mo3596a(Object obj) {
                m10800a((C3527a) obj);
            }
        }).mo3308a(this.f8953a, new C2425b(this) {
            private boolean m10798b(Exception exception) {
                return (exception instanceof C3528a) || (exception instanceof lm);
            }

            public void mo3595a(@NonNull Exception exception) {
                if (m10798b(exception)) {
                    c2925a.mo3697a(null);
                } else {
                    c2925a.mo3698b(exception.getMessage());
                }
            }
        });
    }
}
