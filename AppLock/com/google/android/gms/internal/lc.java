package com.google.android.gms.internal;

public class lc {
    static final /* synthetic */ boolean f9695a = (!lc.class.desiredAssertionStatus());

    private static long m12280a(kb<?> kbVar) {
        long j = 8;
        if (!((kbVar instanceof jw) || (kbVar instanceof kd))) {
            if (kbVar instanceof jr) {
                j = 4;
            } else if (kbVar instanceof kl) {
                j = (long) (((String) kbVar.mo3786a()).length() + 2);
            } else {
                String valueOf = String.valueOf(kbVar.getClass());
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Unknown leaf node type: ").append(valueOf).toString());
            }
        }
        if (kbVar.mo3783f().mo3778b()) {
            return j;
        }
        return m12280a((kb) kbVar.mo3783f()) + (24 + j);
    }

    public static long m12281a(kf kfVar) {
        if (kfVar.mo3778b()) {
            return 4;
        }
        if (kfVar.mo3782e()) {
            return m12280a((kb) kfVar);
        }
        if (f9695a || (kfVar instanceof jt)) {
            long j = 1;
            for (ke keVar : kfVar) {
                j = m12281a(keVar.m12170d()) + ((j + ((long) keVar.m12169c().m12010d().length())) + 4);
            }
            return !kfVar.mo3783f().mo3778b() ? (j + 12) + m12280a((kb) kfVar.mo3783f()) : j;
        } else {
            String valueOf = String.valueOf(kfVar.getClass());
            throw new AssertionError(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Unexpected node type: ").append(valueOf).toString());
        }
    }

    public static int m12282b(kf kfVar) {
        if (kfVar.mo3778b()) {
            return 0;
        }
        if (kfVar.mo3782e()) {
            return 1;
        }
        if (f9695a || (kfVar instanceof jt)) {
            int i = 0;
            for (ke d : kfVar) {
                i = m12282b(d.m12170d()) + i;
            }
            return i;
        }
        String valueOf = String.valueOf(kfVar.getClass());
        throw new AssertionError(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Unexpected node type: ").append(valueOf).toString());
    }
}
