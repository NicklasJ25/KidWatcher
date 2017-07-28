package com.google.android.gms.internal;

public interface bo {

    public static final class C2708a extends lv<C2708a> {
        public String f7990a;
        public Long f7991b;
        public String f7992c;
        public String f7993d;
        public String f7994e;
        public Long f7995f;
        public Long f7996g;
        public String f7997h;
        public Long f7998i;
        public String f7999j;

        public C2708a() {
            this.f7990a = null;
            this.f7991b = null;
            this.f7992c = null;
            this.f7993d = null;
            this.f7994e = null;
            this.f7995f = null;
            this.f7996g = null;
            this.f7997h = null;
            this.f7998i = null;
            this.f7999j = null;
            this.ah = -1;
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f7990a != null) {
                a += lu.m12373b(1, this.f7990a);
            }
            if (this.f7991b != null) {
                a += lu.m12385e(2, this.f7991b.longValue());
            }
            if (this.f7992c != null) {
                a += lu.m12373b(3, this.f7992c);
            }
            if (this.f7993d != null) {
                a += lu.m12373b(4, this.f7993d);
            }
            if (this.f7994e != null) {
                a += lu.m12373b(5, this.f7994e);
            }
            if (this.f7995f != null) {
                a += lu.m12385e(6, this.f7995f.longValue());
            }
            if (this.f7996g != null) {
                a += lu.m12385e(7, this.f7996g.longValue());
            }
            if (this.f7997h != null) {
                a += lu.m12373b(8, this.f7997h);
            }
            if (this.f7998i != null) {
                a += lu.m12385e(9, this.f7998i.longValue());
            }
            return this.f7999j != null ? a + lu.m12373b(10, this.f7999j) : a;
        }

        public C2708a m9152a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f7990a = ltVar.m12351i();
                        continue;
                    case 16:
                        this.f7991b = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 26:
                        this.f7992c = ltVar.m12351i();
                        continue;
                    case 34:
                        this.f7993d = ltVar.m12351i();
                        continue;
                    case 42:
                        this.f7994e = ltVar.m12351i();
                        continue;
                    case 48:
                        this.f7995f = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 56:
                        this.f7996g = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 66:
                        this.f7997h = ltVar.m12351i();
                        continue;
                    case 72:
                        this.f7998i = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 82:
                        this.f7999j = ltVar.m12351i();
                        continue;
                    default:
                        if (!super.m9135a(ltVar, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo3506a(lu luVar) {
            if (this.f7990a != null) {
                luVar.m12402a(1, this.f7990a);
            }
            if (this.f7991b != null) {
                luVar.m12410b(2, this.f7991b.longValue());
            }
            if (this.f7992c != null) {
                luVar.m12402a(3, this.f7992c);
            }
            if (this.f7993d != null) {
                luVar.m12402a(4, this.f7993d);
            }
            if (this.f7994e != null) {
                luVar.m12402a(5, this.f7994e);
            }
            if (this.f7995f != null) {
                luVar.m12410b(6, this.f7995f.longValue());
            }
            if (this.f7996g != null) {
                luVar.m12410b(7, this.f7996g.longValue());
            }
            if (this.f7997h != null) {
                luVar.m12402a(8, this.f7997h);
            }
            if (this.f7998i != null) {
                luVar.m12410b(9, this.f7998i.longValue());
            }
            if (this.f7999j != null) {
                luVar.m12402a(10, this.f7999j);
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m9152a(ltVar);
        }
    }
}
