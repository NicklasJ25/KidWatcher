package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.List;

public final class WakeLockEvent extends StatsEvent {
    public static final Creator<WakeLockEvent> CREATOR = new C2575b();
    final int f7536a;
    private final long f7537b;
    private int f7538c;
    private final String f7539d;
    private final String f7540e;
    private final String f7541f;
    private final int f7542g;
    private final List<String> f7543h;
    private final String f7544i;
    private final long f7545j;
    private int f7546k;
    private final String f7547l;
    private final float f7548m;
    private final long f7549n;
    private long f7550o = -1;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5) {
        this.f7536a = i;
        this.f7537b = j;
        this.f7538c = i2;
        this.f7539d = str;
        this.f7540e = str3;
        this.f7541f = str5;
        this.f7542g = i3;
        this.f7543h = list;
        this.f7544i = str2;
        this.f7545j = j2;
        this.f7546k = i4;
        this.f7547l = str4;
        this.f7548m = f;
        this.f7549n = j3;
    }

    public long mo3356a() {
        return this.f7537b;
    }

    public int mo3357b() {
        return this.f7538c;
    }

    public long mo3358c() {
        return this.f7550o;
    }

    public String mo3359d() {
        String valueOf = String.valueOf("\t");
        String valueOf2 = String.valueOf(m8241e());
        String valueOf3 = String.valueOf("\t");
        int h = m8244h();
        String valueOf4 = String.valueOf("\t");
        String join = m8245i() == null ? "" : TextUtils.join(",", m8245i());
        String valueOf5 = String.valueOf("\t");
        int l = m8248l();
        String valueOf6 = String.valueOf("\t");
        String f = m8242f() == null ? "" : m8242f();
        String valueOf7 = String.valueOf("\t");
        String m = m8249m() == null ? "" : m8249m();
        String valueOf8 = String.valueOf("\t");
        float n = m8250n();
        String valueOf9 = String.valueOf("\t");
        String g = m8243g() == null ? "" : m8243g();
        return new StringBuilder(((((((((((((String.valueOf(valueOf).length() + 37) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()) + String.valueOf(join).length()) + String.valueOf(valueOf5).length()) + String.valueOf(valueOf6).length()) + String.valueOf(f).length()) + String.valueOf(valueOf7).length()) + String.valueOf(m).length()) + String.valueOf(valueOf8).length()) + String.valueOf(valueOf9).length()) + String.valueOf(g).length()).append(valueOf).append(valueOf2).append(valueOf3).append(h).append(valueOf4).append(join).append(valueOf5).append(l).append(valueOf6).append(f).append(valueOf7).append(m).append(valueOf8).append(n).append(valueOf9).append(g).toString();
    }

    public String m8241e() {
        return this.f7539d;
    }

    public String m8242f() {
        return this.f7540e;
    }

    public String m8243g() {
        return this.f7541f;
    }

    public int m8244h() {
        return this.f7542g;
    }

    public List<String> m8245i() {
        return this.f7543h;
    }

    public String m8246j() {
        return this.f7544i;
    }

    public long m8247k() {
        return this.f7545j;
    }

    public int m8248l() {
        return this.f7546k;
    }

    public String m8249m() {
        return this.f7547l;
    }

    public float m8250n() {
        return this.f7548m;
    }

    public long m8251o() {
        return this.f7549n;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2575b.m8259a(this, parcel, i);
    }
}
