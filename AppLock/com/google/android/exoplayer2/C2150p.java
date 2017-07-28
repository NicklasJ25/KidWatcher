package com.google.android.exoplayer2;

public abstract class C2150p {

    public static final class C2299a {
        public Object f6583a;
        public Object f6584b;
        public int f6585c;
        private long f6586d;
        private long f6587e;

        public long m7270a() {
            return C1961b.m5732a(this.f6586d);
        }

        public C2299a m7271a(Object obj, Object obj2, int i, long j, long j2) {
            this.f6583a = obj;
            this.f6584b = obj2;
            this.f6585c = i;
            this.f6586d = j;
            this.f6587e = j2;
            return this;
        }

        public long m7272b() {
            return this.f6586d;
        }

        public long m7273c() {
            return C1961b.m5732a(this.f6587e);
        }
    }

    public static final class C2300b {
        public Object f6588a;
        public long f6589b;
        public long f6590c;
        public boolean f6591d;
        public boolean f6592e;
        public int f6593f;
        public int f6594g;
        private long f6595h;
        private long f6596i;
        private long f6597j;

        public long m7274a() {
            return this.f6595h;
        }

        public C2300b m7275a(Object obj, long j, long j2, boolean z, boolean z2, long j3, long j4, int i, int i2, long j5) {
            this.f6588a = obj;
            this.f6589b = j;
            this.f6590c = j2;
            this.f6591d = z;
            this.f6592e = z2;
            this.f6595h = j3;
            this.f6596i = j4;
            this.f6593f = i;
            this.f6594g = i2;
            this.f6597j = j5;
            return this;
        }

        public long m7276b() {
            return C1961b.m5732a(this.f6596i);
        }

        public long m7277c() {
            return C1961b.m5732a(this.f6597j);
        }

        public long m7278d() {
            return this.f6597j;
        }
    }

    public abstract int mo3039a();

    public abstract int mo3040a(Object obj);

    public final C2299a m6563a(int i, C2299a c2299a) {
        return mo3041a(i, c2299a, false);
    }

    public abstract C2299a mo3041a(int i, C2299a c2299a, boolean z);

    public final C2300b m6565a(int i, C2300b c2300b) {
        return mo3042a(i, c2300b, false);
    }

    public abstract C2300b mo3042a(int i, C2300b c2300b, boolean z);

    public abstract int mo3043b();
}
