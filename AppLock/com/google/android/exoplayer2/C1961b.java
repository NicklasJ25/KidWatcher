package com.google.android.exoplayer2;

import android.support.v4.view.PointerIconCompat;
import com.google.android.exoplayer2.p043j.C2273r;
import java.util.UUID;

public final class C1961b {
    public static final int f5144a = (C2273r.f6478a < 23 ? PointerIconCompat.TYPE_GRAB : 6396);
    public static final UUID f5145b = new UUID(0, 0);
    public static final UUID f5146c = new UUID(-1301668207276963122L, -6645017420763422227L);
    public static final UUID f5147d = new UUID(-7348484286925749626L, -6083546864340672619L);

    public static long m5732a(long j) {
        return j == -9223372036854775807L ? -9223372036854775807L : j / 1000;
    }

    public static long m5733b(long j) {
        return j == -9223372036854775807L ? -9223372036854775807L : 1000 * j;
    }
}
