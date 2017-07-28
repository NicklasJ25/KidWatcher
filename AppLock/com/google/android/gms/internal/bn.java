package com.google.android.gms.internal;

public interface bn {

    public static final class C2705a extends lv<C2705a> {
        public C2706b f7982a;
        public C2707c f7983b;

        public C2705a() {
            this.ah = -1;
        }

        public static C2705a m9138a(byte[] bArr) {
            return (C2705a) mb.m9122a(new C2705a(), bArr);
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f7982a != null) {
                a += lu.m12378c(1, this.f7982a);
            }
            return this.f7983b != null ? a + lu.m12378c(2, this.f7983b) : a;
        }

        public C2705a m9140a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        if (this.f7982a == null) {
                            this.f7982a = new C2706b();
                        }
                        ltVar.m12337a(this.f7982a);
                        continue;
                    case 18:
                        if (this.f7983b == null) {
                            this.f7983b = new C2707c();
                        }
                        ltVar.m12337a(this.f7983b);
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
            if (this.f7982a != null) {
                luVar.m12401a(1, this.f7982a);
            }
            if (this.f7983b != null) {
                luVar.m12401a(2, this.f7983b);
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m9140a(ltVar);
        }
    }

    public static final class C2706b extends lv<C2706b> {
        public Integer f7984a;

        public C2706b() {
            this.f7984a = null;
            this.ah = -1;
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            return this.f7984a != null ? a + lu.m12371b(27, this.f7984a.intValue()) : a;
        }

        public C2706b m9144a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 216:
                        a = ltVar.m12349g();
                        switch (a) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                this.f7984a = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
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
            if (this.f7984a != null) {
                luVar.m12399a(27, this.f7984a.intValue());
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m9144a(ltVar);
        }
    }

    public static final class C2707c extends lv<C2707c> {
        public String f7985a;
        public String f7986b;
        public String f7987c;
        public String f7988d;
        public String f7989e;

        public C2707c() {
            this.f7985a = null;
            this.f7986b = null;
            this.f7987c = null;
            this.f7988d = null;
            this.f7989e = null;
            this.ah = -1;
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f7985a != null) {
                a += lu.m12373b(1, this.f7985a);
            }
            if (this.f7986b != null) {
                a += lu.m12373b(2, this.f7986b);
            }
            if (this.f7987c != null) {
                a += lu.m12373b(3, this.f7987c);
            }
            if (this.f7988d != null) {
                a += lu.m12373b(4, this.f7988d);
            }
            return this.f7989e != null ? a + lu.m12373b(5, this.f7989e) : a;
        }

        public C2707c m9148a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f7985a = ltVar.m12351i();
                        continue;
                    case 18:
                        this.f7986b = ltVar.m12351i();
                        continue;
                    case 26:
                        this.f7987c = ltVar.m12351i();
                        continue;
                    case 34:
                        this.f7988d = ltVar.m12351i();
                        continue;
                    case 42:
                        this.f7989e = ltVar.m12351i();
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
            if (this.f7985a != null) {
                luVar.m12402a(1, this.f7985a);
            }
            if (this.f7986b != null) {
                luVar.m12402a(2, this.f7986b);
            }
            if (this.f7987c != null) {
                luVar.m12402a(3, this.f7987c);
            }
            if (this.f7988d != null) {
                luVar.m12402a(4, this.f7988d);
            }
            if (this.f7989e != null) {
                luVar.m12402a(5, this.f7989e);
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m9148a(ltVar);
        }
    }
}
