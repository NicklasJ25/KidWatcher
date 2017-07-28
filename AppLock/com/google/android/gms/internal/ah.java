package com.google.android.gms.internal;

public final class ah<L> {
    private volatile L f7899a;

    public static final class C2688a<L> {
        private final L f7897a;
        private final String f7898b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C2688a)) {
                return false;
            }
            C2688a c2688a = (C2688a) obj;
            return this.f7897a == c2688a.f7897a && this.f7898b.equals(c2688a.f7898b);
        }

        public int hashCode() {
            return (System.identityHashCode(this.f7897a) * 31) + this.f7898b.hashCode();
        }
    }

    public void m8974a() {
        this.f7899a = null;
    }
}
