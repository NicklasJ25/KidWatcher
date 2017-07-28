package com.google.android.gms.internal;

import com.google.android.exoplayer2.Format;

public class aca {
    public static long m8933a(long j, long j2) {
        return j >= 0 ? j % j2 : (((Format.OFFSET_SAMPLE_RELATIVE % j2) + 1) + ((j & Format.OFFSET_SAMPLE_RELATIVE) % j2)) % j2;
    }
}
