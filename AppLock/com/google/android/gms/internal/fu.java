package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.internal.gp.C2900a;
import com.google.android.gms.internal.jq.C3008a;
import com.google.firebase.C3531b;
import com.google.firebase.C3531b.C2873b;
import com.google.firebase.database.C3537c;
import com.google.firebase.database.C3576f;
import com.google.firebase.database.connection.idl.C3562c;
import com.google.firebase.database.connection.idl.zzc;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public class fu implements hi {
    private final Context f8962a;
    private final Set<String> f8963b = new HashSet();
    private final C3531b f8964c;

    public fu(C3531b c3531b) {
        this.f8964c = c3531b;
        if (this.f8964c == null) {
            Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            Log.e("FirebaseDatabase", "ERROR: You must call FirebaseApp.initializeApp() before using Firebase Database.");
            Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            throw new RuntimeException("You need to call FirebaseApp.initializeApp() before using Firebase Database.");
        }
        this.f8962a = this.f8964c.m15431a();
    }

    public gp mo3605a(ha haVar, gl glVar, gn gnVar, C2900a c2900a) {
        final gp a = C3562c.m15527a(this.f8962a, new zzc(gnVar, haVar.m11320e(), null, haVar.m11323h(), C3576f.m15586c(), haVar.m11327l()), glVar, c2900a);
        this.f8964c.m15433a(new C2873b(this) {
            public void mo3604a(boolean z) {
                if (z) {
                    a.mo3687d("app_in_background");
                } else {
                    a.mo3688e("app_in_background");
                }
            }
        });
        return a;
    }

    public gw mo3606a(ScheduledExecutorService scheduledExecutorService) {
        return new fs(this.f8964c, scheduledExecutorService);
    }

    public he mo3607a(ha haVar) {
        return new ft();
    }

    public im mo3608a(ha haVar, String str) {
        String m = haVar.m11328m();
        String stringBuilder = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(m).length()).append(str).append("_").append(m).toString();
        if (this.f8963b.contains(stringBuilder)) {
            throw new C3537c(new StringBuilder(String.valueOf(m).length() + 47).append("SessionPersistenceKey '").append(m).append("' has already been used.").toString());
        }
        this.f8963b.add(stringBuilder);
        return new ij(haVar, new fv(this.f8962a, haVar, stringBuilder), new ik(haVar.m11324i()));
    }

    public jq mo3609a(ha haVar, C3008a c3008a, List<String> list) {
        return new jn(c3008a, list);
    }

    public hm mo3610b(ha haVar) {
        final jp a = haVar.m11314a("RunLoop");
        return new lb(this) {
            final /* synthetic */ fu f8960b;

            public void mo3603a(final Throwable th) {
                final String b = lb.m10813b(th);
                a.m11958a(b, th);
                new Handler(this.f8960b.f8962a.getMainLooper()).post(new Runnable(this) {
                    public void run() {
                        throw new RuntimeException(b, th);
                    }
                });
                m10819d().shutdownNow();
            }
        };
    }

    public String mo3611c(ha haVar) {
        return VERSION.SDK_INT + "/Android";
    }
}
