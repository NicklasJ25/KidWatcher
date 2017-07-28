package com.google.android.exoplayer2.p045c.p049d;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.p043j.C2263k;
import java.util.UUID;

public final class C2019g {
    public static UUID m6028a(byte[] bArr) {
        Pair b = C2019g.m6029b(bArr);
        return b == null ? null : (UUID) b.first;
    }

    private static Pair<UUID, byte[]> m6029b(byte[] bArr) {
        C2263k c2263k = new C2263k(bArr);
        if (c2263k.m7072c() < 32) {
            return null;
        }
        c2263k.m7073c(0);
        if (c2263k.m7086n() != c2263k.m7070b() + 4 || c2263k.m7086n() != C1999a.f5350T) {
            return null;
        }
        int a = C1999a.m5928a(c2263k.m7086n());
        if (a > 1) {
            Log.w("PsshAtomUtil", "Unsupported pssh version: " + a);
            return null;
        }
        UUID uuid = new UUID(c2263k.m7088p(), c2263k.m7088p());
        if (a == 1) {
            c2263k.m7075d(c2263k.m7092t() * 16);
        }
        a = c2263k.m7092t();
        if (a != c2263k.m7070b()) {
            return null;
        }
        Object obj = new byte[a];
        c2263k.m7069a(obj, 0, a);
        return Pair.create(uuid, obj);
    }
}
