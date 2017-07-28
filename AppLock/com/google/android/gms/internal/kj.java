package com.google.android.gms.internal;

import com.google.firebase.database.C3537c;

public class kj {
    public static kf m12190a() {
        return jx.m12080j();
    }

    public static kf m12191a(Object obj) {
        kf a = kg.m12177a(obj);
        if (a instanceof kd) {
            a = new jw(Double.valueOf((double) ((Long) a.mo3786a()).longValue()), m12190a());
        }
        if (m12192a(a)) {
            return a;
        }
        throw new C3537c("Invalid Firebase Database priority (must be a string, double, ServerValue, or null)");
    }

    public static boolean m12192a(kf kfVar) {
        return kfVar.mo3783f().mo3778b() && (kfVar.mo3778b() || (kfVar instanceof jw) || (kfVar instanceof kl) || (kfVar instanceof jv));
    }
}
