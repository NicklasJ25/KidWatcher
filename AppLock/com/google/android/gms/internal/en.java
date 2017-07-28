package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.C2456a.C2416a.C2419d;

public final class en implements C2419d {
    public static final en f8843a = new C2852a().m10633a();
    private final boolean f8844b;
    private final boolean f8845c;
    private final String f8846d;
    private final boolean f8847e;
    private final String f8848f;
    private final boolean f8849g;
    private final Long f8850h;
    private final Long f8851i;

    public static final class C2852a {
        public en m10633a() {
            return new en(false, false, null, false, null, false, null, null);
        }
    }

    private en(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4, Long l, Long l2) {
        this.f8844b = z;
        this.f8845c = z2;
        this.f8846d = str;
        this.f8847e = z3;
        this.f8849g = z4;
        this.f8848f = str2;
        this.f8850h = l;
        this.f8851i = l2;
    }

    public boolean m10634a() {
        return this.f8844b;
    }

    public boolean m10635b() {
        return this.f8845c;
    }

    public String m10636c() {
        return this.f8846d;
    }

    public boolean m10637d() {
        return this.f8847e;
    }

    @Nullable
    public String m10638e() {
        return this.f8848f;
    }

    public boolean m10639f() {
        return this.f8849g;
    }

    @Nullable
    public Long m10640g() {
        return this.f8850h;
    }

    @Nullable
    public Long m10641h() {
        return this.f8851i;
    }
}
