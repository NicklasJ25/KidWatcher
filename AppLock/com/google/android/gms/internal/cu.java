package com.google.android.gms.internal;

import com.google.android.gms.common.internal.C2513c;

class cu {
    final String f8288a;
    final String f8289b;
    final long f8290c;
    final long f8291d;
    final long f8292e;

    cu(String str, String str2, long j, long j2, long j3) {
        boolean z = true;
        C2513c.m7934a(str);
        C2513c.m7934a(str2);
        C2513c.m7941b(j >= 0);
        if (j2 < 0) {
            z = false;
        }
        C2513c.m7941b(z);
        this.f8288a = str;
        this.f8289b = str2;
        this.f8290c = j;
        this.f8291d = j2;
        this.f8292e = j3;
    }

    cu m9651a() {
        return new cu(this.f8288a, this.f8289b, this.f8290c + 1, this.f8291d + 1, this.f8292e);
    }

    cu m9652a(long j) {
        return new cu(this.f8288a, this.f8289b, this.f8290c, this.f8291d, j);
    }
}
