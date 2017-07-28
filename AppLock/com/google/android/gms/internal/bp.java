package com.google.android.gms.internal;

public interface bp {

    public static final class C2711a extends lv<C2711a> {
        public Long f8016A;
        public String f8017B;
        public Long f8018C;
        public Long f8019D;
        public Long f8020E;
        public C2712b f8021F;
        public Long f8022G;
        public Long f8023H;
        public Long f8024I;
        public Long f8025J;
        public Long f8026K;
        public Long f8027L;
        public String f8028M;
        public String f8029N;
        public Integer f8030O;
        public Integer f8031P;
        public Long f8032Q;
        public Long f8033R;
        public Long f8034S;
        public Long f8035T;
        public Long f8036U;
        public Integer f8037V;
        public C2709a f8038W;
        public C2709a[] f8039X;
        public C2710b f8040Y;
        public Long f8041Z;
        public String f8042a;
        public String aa;
        public Integer ab;
        public Boolean ac;
        public String ad;
        public Long ae;
        public C2715e af;
        public String f8043b;
        public Long f8044c;
        public Long f8045d;
        public Long f8046e;
        public Long f8047f;
        public Long f8048g;
        public Long f8049h;
        public Long f8050i;
        public Long f8051j;
        public Long f8052k;
        public Long f8053l;
        public String f8054m;
        public Long f8055n;
        public Long f8056o;
        public Long f8057p;
        public Long f8058q;
        public Long f8059r;
        public Long f8060s;
        public Long f8061t;
        public Long f8062u;
        public Long f8063v;
        public String f8064w;
        public String f8065x;
        public Long f8066y;
        public Long f8067z;

        public static final class C2709a extends lv<C2709a> {
            private static volatile C2709a[] f8000m;
            public Long f8001a;
            public Long f8002b;
            public Long f8003c;
            public Long f8004d;
            public Long f8005e;
            public Long f8006f;
            public Integer f8007g;
            public Long f8008h;
            public Long f8009i;
            public Long f8010j;
            public Integer f8011k;
            public Long f8012l;

            public C2709a() {
                this.f8001a = null;
                this.f8002b = null;
                this.f8003c = null;
                this.f8004d = null;
                this.f8005e = null;
                this.f8006f = null;
                this.f8007g = null;
                this.f8008h = null;
                this.f8009i = null;
                this.f8010j = null;
                this.f8011k = null;
                this.f8012l = null;
                this.ah = -1;
            }

            public static C2709a[] m9155b() {
                if (f8000m == null) {
                    synchronized (lz.f9749c) {
                        if (f8000m == null) {
                            f8000m = new C2709a[0];
                        }
                    }
                }
                return f8000m;
            }

            protected int mo3505a() {
                int a = super.mo3505a();
                if (this.f8001a != null) {
                    a += lu.m12385e(1, this.f8001a.longValue());
                }
                if (this.f8002b != null) {
                    a += lu.m12385e(2, this.f8002b.longValue());
                }
                if (this.f8003c != null) {
                    a += lu.m12385e(3, this.f8003c.longValue());
                }
                if (this.f8004d != null) {
                    a += lu.m12385e(4, this.f8004d.longValue());
                }
                if (this.f8005e != null) {
                    a += lu.m12385e(5, this.f8005e.longValue());
                }
                if (this.f8006f != null) {
                    a += lu.m12385e(6, this.f8006f.longValue());
                }
                if (this.f8007g != null) {
                    a += lu.m12371b(7, this.f8007g.intValue());
                }
                if (this.f8008h != null) {
                    a += lu.m12385e(8, this.f8008h.longValue());
                }
                if (this.f8009i != null) {
                    a += lu.m12385e(9, this.f8009i.longValue());
                }
                if (this.f8010j != null) {
                    a += lu.m12385e(10, this.f8010j.longValue());
                }
                if (this.f8011k != null) {
                    a += lu.m12371b(11, this.f8011k.intValue());
                }
                return this.f8012l != null ? a + lu.m12385e(12, this.f8012l.longValue()) : a;
            }

            public C2709a m9157a(lt ltVar) {
                while (true) {
                    int a = ltVar.m12335a();
                    switch (a) {
                        case 0:
                            break;
                        case 8:
                            this.f8001a = Long.valueOf(ltVar.m12347f());
                            continue;
                        case 16:
                            this.f8002b = Long.valueOf(ltVar.m12347f());
                            continue;
                        case 24:
                            this.f8003c = Long.valueOf(ltVar.m12347f());
                            continue;
                        case 32:
                            this.f8004d = Long.valueOf(ltVar.m12347f());
                            continue;
                        case 40:
                            this.f8005e = Long.valueOf(ltVar.m12347f());
                            continue;
                        case 48:
                            this.f8006f = Long.valueOf(ltVar.m12347f());
                            continue;
                        case 56:
                            a = ltVar.m12349g();
                            switch (a) {
                                case 0:
                                case 1:
                                case 2:
                                case 1000:
                                    this.f8007g = Integer.valueOf(a);
                                    break;
                                default:
                                    continue;
                            }
                        case 64:
                            this.f8008h = Long.valueOf(ltVar.m12347f());
                            continue;
                        case 72:
                            this.f8009i = Long.valueOf(ltVar.m12347f());
                            continue;
                        case 80:
                            this.f8010j = Long.valueOf(ltVar.m12347f());
                            continue;
                        case 88:
                            a = ltVar.m12349g();
                            switch (a) {
                                case 0:
                                case 1:
                                case 2:
                                case 1000:
                                    this.f8011k = Integer.valueOf(a);
                                    break;
                                default:
                                    continue;
                            }
                        case 96:
                            this.f8012l = Long.valueOf(ltVar.m12347f());
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
                if (this.f8001a != null) {
                    luVar.m12410b(1, this.f8001a.longValue());
                }
                if (this.f8002b != null) {
                    luVar.m12410b(2, this.f8002b.longValue());
                }
                if (this.f8003c != null) {
                    luVar.m12410b(3, this.f8003c.longValue());
                }
                if (this.f8004d != null) {
                    luVar.m12410b(4, this.f8004d.longValue());
                }
                if (this.f8005e != null) {
                    luVar.m12410b(5, this.f8005e.longValue());
                }
                if (this.f8006f != null) {
                    luVar.m12410b(6, this.f8006f.longValue());
                }
                if (this.f8007g != null) {
                    luVar.m12399a(7, this.f8007g.intValue());
                }
                if (this.f8008h != null) {
                    luVar.m12410b(8, this.f8008h.longValue());
                }
                if (this.f8009i != null) {
                    luVar.m12410b(9, this.f8009i.longValue());
                }
                if (this.f8010j != null) {
                    luVar.m12410b(10, this.f8010j.longValue());
                }
                if (this.f8011k != null) {
                    luVar.m12399a(11, this.f8011k.intValue());
                }
                if (this.f8012l != null) {
                    luVar.m12410b(12, this.f8012l.longValue());
                }
                super.mo3506a(luVar);
            }

            public /* synthetic */ mb mo3509b(lt ltVar) {
                return m9157a(ltVar);
            }
        }

        public static final class C2710b extends lv<C2710b> {
            public Long f8013a;
            public Long f8014b;
            public Long f8015c;

            public C2710b() {
                this.f8013a = null;
                this.f8014b = null;
                this.f8015c = null;
                this.ah = -1;
            }

            protected int mo3505a() {
                int a = super.mo3505a();
                if (this.f8013a != null) {
                    a += lu.m12385e(1, this.f8013a.longValue());
                }
                if (this.f8014b != null) {
                    a += lu.m12385e(2, this.f8014b.longValue());
                }
                return this.f8015c != null ? a + lu.m12385e(3, this.f8015c.longValue()) : a;
            }

            public C2710b m9161a(lt ltVar) {
                while (true) {
                    int a = ltVar.m12335a();
                    switch (a) {
                        case 0:
                            break;
                        case 8:
                            this.f8013a = Long.valueOf(ltVar.m12347f());
                            continue;
                        case 16:
                            this.f8014b = Long.valueOf(ltVar.m12347f());
                            continue;
                        case 24:
                            this.f8015c = Long.valueOf(ltVar.m12347f());
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
                if (this.f8013a != null) {
                    luVar.m12410b(1, this.f8013a.longValue());
                }
                if (this.f8014b != null) {
                    luVar.m12410b(2, this.f8014b.longValue());
                }
                if (this.f8015c != null) {
                    luVar.m12410b(3, this.f8015c.longValue());
                }
                super.mo3506a(luVar);
            }

            public /* synthetic */ mb mo3509b(lt ltVar) {
                return m9161a(ltVar);
            }
        }

        public C2711a() {
            this.f8042a = null;
            this.f8043b = null;
            this.f8044c = null;
            this.f8045d = null;
            this.f8046e = null;
            this.f8047f = null;
            this.f8048g = null;
            this.f8049h = null;
            this.f8050i = null;
            this.f8051j = null;
            this.f8052k = null;
            this.f8053l = null;
            this.f8054m = null;
            this.f8055n = null;
            this.f8056o = null;
            this.f8057p = null;
            this.f8058q = null;
            this.f8059r = null;
            this.f8060s = null;
            this.f8061t = null;
            this.f8062u = null;
            this.f8063v = null;
            this.f8064w = null;
            this.f8065x = null;
            this.f8066y = null;
            this.f8067z = null;
            this.f8016A = null;
            this.f8017B = null;
            this.f8018C = null;
            this.f8019D = null;
            this.f8020E = null;
            this.f8022G = null;
            this.f8023H = null;
            this.f8024I = null;
            this.f8025J = null;
            this.f8026K = null;
            this.f8027L = null;
            this.f8028M = null;
            this.f8029N = null;
            this.f8030O = null;
            this.f8031P = null;
            this.f8032Q = null;
            this.f8033R = null;
            this.f8034S = null;
            this.f8035T = null;
            this.f8036U = null;
            this.f8037V = null;
            this.f8039X = C2709a.m9155b();
            this.f8041Z = null;
            this.aa = null;
            this.ab = null;
            this.ac = null;
            this.ad = null;
            this.ae = null;
            this.ah = -1;
        }

        public static C2711a m9164a(byte[] bArr) {
            return (C2711a) mb.m9122a(new C2711a(), bArr);
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f8042a != null) {
                a += lu.m12373b(1, this.f8042a);
            }
            if (this.f8043b != null) {
                a += lu.m12373b(2, this.f8043b);
            }
            if (this.f8044c != null) {
                a += lu.m12385e(3, this.f8044c.longValue());
            }
            if (this.f8045d != null) {
                a += lu.m12385e(4, this.f8045d.longValue());
            }
            if (this.f8046e != null) {
                a += lu.m12385e(5, this.f8046e.longValue());
            }
            if (this.f8047f != null) {
                a += lu.m12385e(6, this.f8047f.longValue());
            }
            if (this.f8048g != null) {
                a += lu.m12385e(7, this.f8048g.longValue());
            }
            if (this.f8049h != null) {
                a += lu.m12385e(8, this.f8049h.longValue());
            }
            if (this.f8050i != null) {
                a += lu.m12385e(9, this.f8050i.longValue());
            }
            if (this.f8051j != null) {
                a += lu.m12385e(10, this.f8051j.longValue());
            }
            if (this.f8052k != null) {
                a += lu.m12385e(11, this.f8052k.longValue());
            }
            if (this.f8053l != null) {
                a += lu.m12385e(12, this.f8053l.longValue());
            }
            if (this.f8054m != null) {
                a += lu.m12373b(13, this.f8054m);
            }
            if (this.f8055n != null) {
                a += lu.m12385e(14, this.f8055n.longValue());
            }
            if (this.f8056o != null) {
                a += lu.m12385e(15, this.f8056o.longValue());
            }
            if (this.f8057p != null) {
                a += lu.m12385e(16, this.f8057p.longValue());
            }
            if (this.f8058q != null) {
                a += lu.m12385e(17, this.f8058q.longValue());
            }
            if (this.f8059r != null) {
                a += lu.m12385e(18, this.f8059r.longValue());
            }
            if (this.f8060s != null) {
                a += lu.m12385e(19, this.f8060s.longValue());
            }
            if (this.f8061t != null) {
                a += lu.m12385e(20, this.f8061t.longValue());
            }
            if (this.f8041Z != null) {
                a += lu.m12385e(21, this.f8041Z.longValue());
            }
            if (this.f8062u != null) {
                a += lu.m12385e(22, this.f8062u.longValue());
            }
            if (this.f8063v != null) {
                a += lu.m12385e(23, this.f8063v.longValue());
            }
            if (this.aa != null) {
                a += lu.m12373b(24, this.aa);
            }
            if (this.ae != null) {
                a += lu.m12385e(25, this.ae.longValue());
            }
            if (this.ab != null) {
                a += lu.m12371b(26, this.ab.intValue());
            }
            if (this.f8064w != null) {
                a += lu.m12373b(27, this.f8064w);
            }
            if (this.ac != null) {
                a += lu.m12374b(28, this.ac.booleanValue());
            }
            if (this.f8065x != null) {
                a += lu.m12373b(29, this.f8065x);
            }
            if (this.ad != null) {
                a += lu.m12373b(30, this.ad);
            }
            if (this.f8066y != null) {
                a += lu.m12385e(31, this.f8066y.longValue());
            }
            if (this.f8067z != null) {
                a += lu.m12385e(32, this.f8067z.longValue());
            }
            if (this.f8016A != null) {
                a += lu.m12385e(33, this.f8016A.longValue());
            }
            if (this.f8017B != null) {
                a += lu.m12373b(34, this.f8017B);
            }
            if (this.f8018C != null) {
                a += lu.m12385e(35, this.f8018C.longValue());
            }
            if (this.f8019D != null) {
                a += lu.m12385e(36, this.f8019D.longValue());
            }
            if (this.f8020E != null) {
                a += lu.m12385e(37, this.f8020E.longValue());
            }
            if (this.f8021F != null) {
                a += lu.m12378c(38, this.f8021F);
            }
            if (this.f8022G != null) {
                a += lu.m12385e(39, this.f8022G.longValue());
            }
            if (this.f8023H != null) {
                a += lu.m12385e(40, this.f8023H.longValue());
            }
            if (this.f8024I != null) {
                a += lu.m12385e(41, this.f8024I.longValue());
            }
            if (this.f8025J != null) {
                a += lu.m12385e(42, this.f8025J.longValue());
            }
            if (this.f8039X != null && this.f8039X.length > 0) {
                int i = a;
                for (mb mbVar : this.f8039X) {
                    if (mbVar != null) {
                        i += lu.m12378c(43, mbVar);
                    }
                }
                a = i;
            }
            if (this.f8026K != null) {
                a += lu.m12385e(44, this.f8026K.longValue());
            }
            if (this.f8027L != null) {
                a += lu.m12385e(45, this.f8027L.longValue());
            }
            if (this.f8028M != null) {
                a += lu.m12373b(46, this.f8028M);
            }
            if (this.f8029N != null) {
                a += lu.m12373b(47, this.f8029N);
            }
            if (this.f8030O != null) {
                a += lu.m12371b(48, this.f8030O.intValue());
            }
            if (this.f8031P != null) {
                a += lu.m12371b(49, this.f8031P.intValue());
            }
            if (this.f8038W != null) {
                a += lu.m12378c(50, this.f8038W);
            }
            if (this.f8032Q != null) {
                a += lu.m12385e(51, this.f8032Q.longValue());
            }
            if (this.f8033R != null) {
                a += lu.m12385e(52, this.f8033R.longValue());
            }
            if (this.f8034S != null) {
                a += lu.m12385e(53, this.f8034S.longValue());
            }
            if (this.f8035T != null) {
                a += lu.m12385e(54, this.f8035T.longValue());
            }
            if (this.f8036U != null) {
                a += lu.m12385e(55, this.f8036U.longValue());
            }
            if (this.f8037V != null) {
                a += lu.m12371b(56, this.f8037V.intValue());
            }
            if (this.f8040Y != null) {
                a += lu.m12378c(57, this.f8040Y);
            }
            return this.af != null ? a + lu.m12378c(201, this.af) : a;
        }

        public C2711a m9166a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f8042a = ltVar.m12351i();
                        continue;
                    case 18:
                        this.f8043b = ltVar.m12351i();
                        continue;
                    case 24:
                        this.f8044c = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 32:
                        this.f8045d = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 40:
                        this.f8046e = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 48:
                        this.f8047f = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 56:
                        this.f8048g = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 64:
                        this.f8049h = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 72:
                        this.f8050i = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 80:
                        this.f8051j = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 88:
                        this.f8052k = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 96:
                        this.f8053l = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 106:
                        this.f8054m = ltVar.m12351i();
                        continue;
                    case 112:
                        this.f8055n = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 120:
                        this.f8056o = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 128:
                        this.f8057p = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 136:
                        this.f8058q = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 144:
                        this.f8059r = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 152:
                        this.f8060s = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 160:
                        this.f8061t = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 168:
                        this.f8041Z = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 176:
                        this.f8062u = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 184:
                        this.f8063v = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 194:
                        this.aa = ltVar.m12351i();
                        continue;
                    case 200:
                        this.ae = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 208:
                        a = ltVar.m12349g();
                        switch (a) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.ab = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
                    case 218:
                        this.f8064w = ltVar.m12351i();
                        continue;
                    case 224:
                        this.ac = Boolean.valueOf(ltVar.m12350h());
                        continue;
                    case 234:
                        this.f8065x = ltVar.m12351i();
                        continue;
                    case 242:
                        this.ad = ltVar.m12351i();
                        continue;
                    case 248:
                        this.f8066y = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 256:
                        this.f8067z = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 264:
                        this.f8016A = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 274:
                        this.f8017B = ltVar.m12351i();
                        continue;
                    case 280:
                        this.f8018C = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 288:
                        this.f8019D = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 296:
                        this.f8020E = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 306:
                        if (this.f8021F == null) {
                            this.f8021F = new C2712b();
                        }
                        ltVar.m12337a(this.f8021F);
                        continue;
                    case 312:
                        this.f8022G = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 320:
                        this.f8023H = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 328:
                        this.f8024I = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 336:
                        this.f8025J = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 346:
                        int a2 = me.m12506a(ltVar, 346);
                        a = this.f8039X == null ? 0 : this.f8039X.length;
                        Object obj = new C2709a[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f8039X, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C2709a();
                            ltVar.m12337a(obj[a]);
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = new C2709a();
                        ltVar.m12337a(obj[a]);
                        this.f8039X = obj;
                        continue;
                    case 352:
                        this.f8026K = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 360:
                        this.f8027L = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 370:
                        this.f8028M = ltVar.m12351i();
                        continue;
                    case 378:
                        this.f8029N = ltVar.m12351i();
                        continue;
                    case 384:
                        a = ltVar.m12349g();
                        switch (a) {
                            case 0:
                            case 1:
                            case 2:
                            case 1000:
                                this.f8030O = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
                    case 392:
                        a = ltVar.m12349g();
                        switch (a) {
                            case 0:
                            case 1:
                            case 2:
                            case 1000:
                                this.f8031P = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
                    case 402:
                        if (this.f8038W == null) {
                            this.f8038W = new C2709a();
                        }
                        ltVar.m12337a(this.f8038W);
                        continue;
                    case 408:
                        this.f8032Q = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 416:
                        this.f8033R = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 424:
                        this.f8034S = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 432:
                        this.f8035T = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 440:
                        this.f8036U = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 448:
                        a = ltVar.m12349g();
                        switch (a) {
                            case 0:
                            case 1:
                            case 2:
                            case 1000:
                                this.f8037V = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
                    case 458:
                        if (this.f8040Y == null) {
                            this.f8040Y = new C2710b();
                        }
                        ltVar.m12337a(this.f8040Y);
                        continue;
                    case 1610:
                        if (this.af == null) {
                            this.af = new C2715e();
                        }
                        ltVar.m12337a(this.af);
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
            if (this.f8042a != null) {
                luVar.m12402a(1, this.f8042a);
            }
            if (this.f8043b != null) {
                luVar.m12402a(2, this.f8043b);
            }
            if (this.f8044c != null) {
                luVar.m12410b(3, this.f8044c.longValue());
            }
            if (this.f8045d != null) {
                luVar.m12410b(4, this.f8045d.longValue());
            }
            if (this.f8046e != null) {
                luVar.m12410b(5, this.f8046e.longValue());
            }
            if (this.f8047f != null) {
                luVar.m12410b(6, this.f8047f.longValue());
            }
            if (this.f8048g != null) {
                luVar.m12410b(7, this.f8048g.longValue());
            }
            if (this.f8049h != null) {
                luVar.m12410b(8, this.f8049h.longValue());
            }
            if (this.f8050i != null) {
                luVar.m12410b(9, this.f8050i.longValue());
            }
            if (this.f8051j != null) {
                luVar.m12410b(10, this.f8051j.longValue());
            }
            if (this.f8052k != null) {
                luVar.m12410b(11, this.f8052k.longValue());
            }
            if (this.f8053l != null) {
                luVar.m12410b(12, this.f8053l.longValue());
            }
            if (this.f8054m != null) {
                luVar.m12402a(13, this.f8054m);
            }
            if (this.f8055n != null) {
                luVar.m12410b(14, this.f8055n.longValue());
            }
            if (this.f8056o != null) {
                luVar.m12410b(15, this.f8056o.longValue());
            }
            if (this.f8057p != null) {
                luVar.m12410b(16, this.f8057p.longValue());
            }
            if (this.f8058q != null) {
                luVar.m12410b(17, this.f8058q.longValue());
            }
            if (this.f8059r != null) {
                luVar.m12410b(18, this.f8059r.longValue());
            }
            if (this.f8060s != null) {
                luVar.m12410b(19, this.f8060s.longValue());
            }
            if (this.f8061t != null) {
                luVar.m12410b(20, this.f8061t.longValue());
            }
            if (this.f8041Z != null) {
                luVar.m12410b(21, this.f8041Z.longValue());
            }
            if (this.f8062u != null) {
                luVar.m12410b(22, this.f8062u.longValue());
            }
            if (this.f8063v != null) {
                luVar.m12410b(23, this.f8063v.longValue());
            }
            if (this.aa != null) {
                luVar.m12402a(24, this.aa);
            }
            if (this.ae != null) {
                luVar.m12410b(25, this.ae.longValue());
            }
            if (this.ab != null) {
                luVar.m12399a(26, this.ab.intValue());
            }
            if (this.f8064w != null) {
                luVar.m12402a(27, this.f8064w);
            }
            if (this.ac != null) {
                luVar.m12403a(28, this.ac.booleanValue());
            }
            if (this.f8065x != null) {
                luVar.m12402a(29, this.f8065x);
            }
            if (this.ad != null) {
                luVar.m12402a(30, this.ad);
            }
            if (this.f8066y != null) {
                luVar.m12410b(31, this.f8066y.longValue());
            }
            if (this.f8067z != null) {
                luVar.m12410b(32, this.f8067z.longValue());
            }
            if (this.f8016A != null) {
                luVar.m12410b(33, this.f8016A.longValue());
            }
            if (this.f8017B != null) {
                luVar.m12402a(34, this.f8017B);
            }
            if (this.f8018C != null) {
                luVar.m12410b(35, this.f8018C.longValue());
            }
            if (this.f8019D != null) {
                luVar.m12410b(36, this.f8019D.longValue());
            }
            if (this.f8020E != null) {
                luVar.m12410b(37, this.f8020E.longValue());
            }
            if (this.f8021F != null) {
                luVar.m12401a(38, this.f8021F);
            }
            if (this.f8022G != null) {
                luVar.m12410b(39, this.f8022G.longValue());
            }
            if (this.f8023H != null) {
                luVar.m12410b(40, this.f8023H.longValue());
            }
            if (this.f8024I != null) {
                luVar.m12410b(41, this.f8024I.longValue());
            }
            if (this.f8025J != null) {
                luVar.m12410b(42, this.f8025J.longValue());
            }
            if (this.f8039X != null && this.f8039X.length > 0) {
                for (mb mbVar : this.f8039X) {
                    if (mbVar != null) {
                        luVar.m12401a(43, mbVar);
                    }
                }
            }
            if (this.f8026K != null) {
                luVar.m12410b(44, this.f8026K.longValue());
            }
            if (this.f8027L != null) {
                luVar.m12410b(45, this.f8027L.longValue());
            }
            if (this.f8028M != null) {
                luVar.m12402a(46, this.f8028M);
            }
            if (this.f8029N != null) {
                luVar.m12402a(47, this.f8029N);
            }
            if (this.f8030O != null) {
                luVar.m12399a(48, this.f8030O.intValue());
            }
            if (this.f8031P != null) {
                luVar.m12399a(49, this.f8031P.intValue());
            }
            if (this.f8038W != null) {
                luVar.m12401a(50, this.f8038W);
            }
            if (this.f8032Q != null) {
                luVar.m12410b(51, this.f8032Q.longValue());
            }
            if (this.f8033R != null) {
                luVar.m12410b(52, this.f8033R.longValue());
            }
            if (this.f8034S != null) {
                luVar.m12410b(53, this.f8034S.longValue());
            }
            if (this.f8035T != null) {
                luVar.m12410b(54, this.f8035T.longValue());
            }
            if (this.f8036U != null) {
                luVar.m12410b(55, this.f8036U.longValue());
            }
            if (this.f8037V != null) {
                luVar.m12399a(56, this.f8037V.intValue());
            }
            if (this.f8040Y != null) {
                luVar.m12401a(57, this.f8040Y);
            }
            if (this.af != null) {
                luVar.m12401a(201, this.af);
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m9166a(ltVar);
        }
    }

    public static final class C2712b extends lv<C2712b> {
        public Long f8068a;
        public Integer f8069b;
        public Boolean f8070c;
        public int[] f8071d;
        public Long f8072e;

        public C2712b() {
            this.f8068a = null;
            this.f8069b = null;
            this.f8070c = null;
            this.f8071d = me.f9777e;
            this.f8072e = null;
            this.ah = -1;
        }

        protected int mo3505a() {
            int i = 0;
            int a = super.mo3505a();
            if (this.f8068a != null) {
                a += lu.m12385e(1, this.f8068a.longValue());
            }
            if (this.f8069b != null) {
                a += lu.m12371b(2, this.f8069b.intValue());
            }
            if (this.f8070c != null) {
                a += lu.m12374b(3, this.f8070c.booleanValue());
            }
            if (this.f8071d != null && this.f8071d.length > 0) {
                int i2 = 0;
                while (i < this.f8071d.length) {
                    i2 += lu.m12368b(this.f8071d[i]);
                    i++;
                }
                a = (a + i2) + (this.f8071d.length * 1);
            }
            return this.f8072e != null ? a + lu.m12382d(5, this.f8072e.longValue()) : a;
        }

        public C2712b m9170a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                int a2;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f8068a = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 16:
                        this.f8069b = Integer.valueOf(ltVar.m12349g());
                        continue;
                    case 24:
                        this.f8070c = Boolean.valueOf(ltVar.m12350h());
                        continue;
                    case 32:
                        a2 = me.m12506a(ltVar, 32);
                        a = this.f8071d == null ? 0 : this.f8071d.length;
                        Object obj = new int[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f8071d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = ltVar.m12349g();
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = ltVar.m12349g();
                        this.f8071d = obj;
                        continue;
                    case 34:
                        int c = ltVar.m12342c(ltVar.m12354l());
                        a2 = ltVar.m12360r();
                        a = 0;
                        while (ltVar.m12358p() > 0) {
                            ltVar.m12349g();
                            a++;
                        }
                        ltVar.m12346e(a2);
                        a2 = this.f8071d == null ? 0 : this.f8071d.length;
                        Object obj2 = new int[(a + a2)];
                        if (a2 != 0) {
                            System.arraycopy(this.f8071d, 0, obj2, 0, a2);
                        }
                        while (a2 < obj2.length) {
                            obj2[a2] = ltVar.m12349g();
                            a2++;
                        }
                        this.f8071d = obj2;
                        ltVar.m12344d(c);
                        continue;
                    case 40:
                        this.f8072e = Long.valueOf(ltVar.m12345e());
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
            if (this.f8068a != null) {
                luVar.m12410b(1, this.f8068a.longValue());
            }
            if (this.f8069b != null) {
                luVar.m12399a(2, this.f8069b.intValue());
            }
            if (this.f8070c != null) {
                luVar.m12403a(3, this.f8070c.booleanValue());
            }
            if (this.f8071d != null && this.f8071d.length > 0) {
                for (int a : this.f8071d) {
                    luVar.m12399a(4, a);
                }
            }
            if (this.f8072e != null) {
                luVar.m12400a(5, this.f8072e.longValue());
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m9170a(ltVar);
        }
    }

    public static final class C2713c extends lv<C2713c> {
        public byte[] f8073a;
        public byte[] f8074b;

        public C2713c() {
            this.f8073a = null;
            this.f8074b = null;
            this.ah = -1;
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f8073a != null) {
                a += lu.m12375b(1, this.f8073a);
            }
            return this.f8074b != null ? a + lu.m12375b(2, this.f8074b) : a;
        }

        public C2713c m9174a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f8073a = ltVar.m12352j();
                        continue;
                    case 18:
                        this.f8074b = ltVar.m12352j();
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
            if (this.f8073a != null) {
                luVar.m12404a(1, this.f8073a);
            }
            if (this.f8074b != null) {
                luVar.m12404a(2, this.f8074b);
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m9174a(ltVar);
        }
    }

    public static final class C2714d extends lv<C2714d> {
        public byte[] f8075a;
        public byte[] f8076b;
        public byte[] f8077c;
        public byte[] f8078d;

        public C2714d() {
            this.f8075a = null;
            this.f8076b = null;
            this.f8077c = null;
            this.f8078d = null;
            this.ah = -1;
        }

        public static C2714d m9177a(byte[] bArr) {
            return (C2714d) mb.m9122a(new C2714d(), bArr);
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f8075a != null) {
                a += lu.m12375b(1, this.f8075a);
            }
            if (this.f8076b != null) {
                a += lu.m12375b(2, this.f8076b);
            }
            if (this.f8077c != null) {
                a += lu.m12375b(3, this.f8077c);
            }
            return this.f8078d != null ? a + lu.m12375b(4, this.f8078d) : a;
        }

        public C2714d m9179a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f8075a = ltVar.m12352j();
                        continue;
                    case 18:
                        this.f8076b = ltVar.m12352j();
                        continue;
                    case 26:
                        this.f8077c = ltVar.m12352j();
                        continue;
                    case 34:
                        this.f8078d = ltVar.m12352j();
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
            if (this.f8075a != null) {
                luVar.m12404a(1, this.f8075a);
            }
            if (this.f8076b != null) {
                luVar.m12404a(2, this.f8076b);
            }
            if (this.f8077c != null) {
                luVar.m12404a(3, this.f8077c);
            }
            if (this.f8078d != null) {
                luVar.m12404a(4, this.f8078d);
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m9179a(ltVar);
        }
    }

    public static final class C2715e extends lv<C2715e> {
        public Long f8079a;
        public String f8080b;
        public byte[] f8081c;

        public C2715e() {
            this.f8079a = null;
            this.f8080b = null;
            this.f8081c = null;
            this.ah = -1;
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f8079a != null) {
                a += lu.m12385e(1, this.f8079a.longValue());
            }
            if (this.f8080b != null) {
                a += lu.m12373b(3, this.f8080b);
            }
            return this.f8081c != null ? a + lu.m12375b(4, this.f8081c) : a;
        }

        public C2715e m9183a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f8079a = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 26:
                        this.f8080b = ltVar.m12351i();
                        continue;
                    case 34:
                        this.f8081c = ltVar.m12352j();
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
            if (this.f8079a != null) {
                luVar.m12410b(1, this.f8079a.longValue());
            }
            if (this.f8080b != null) {
                luVar.m12402a(3, this.f8080b);
            }
            if (this.f8081c != null) {
                luVar.m12404a(4, this.f8081c);
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m9183a(ltVar);
        }
    }

    public static final class C2716f extends lv<C2716f> {
        public byte[][] f8082a;
        public byte[] f8083b;
        public Integer f8084c;
        public Integer f8085d;

        public C2716f() {
            this.f8082a = me.f9783k;
            this.f8083b = null;
            this.f8084c = null;
            this.f8085d = null;
            this.ah = -1;
        }

        protected int mo3505a() {
            int i = 0;
            int a = super.mo3505a();
            if (this.f8082a == null || this.f8082a.length <= 0) {
                i = a;
            } else {
                int i2 = 0;
                int i3 = 0;
                while (i < this.f8082a.length) {
                    byte[] bArr = this.f8082a[i];
                    if (bArr != null) {
                        i3++;
                        i2 += lu.m12380c(bArr);
                    }
                    i++;
                }
                i = (a + i2) + (i3 * 1);
            }
            if (this.f8083b != null) {
                i += lu.m12375b(2, this.f8083b);
            }
            if (this.f8084c != null) {
                i += lu.m12371b(3, this.f8084c.intValue());
            }
            return this.f8085d != null ? i + lu.m12371b(4, this.f8085d.intValue()) : i;
        }

        public C2716f m9187a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        int a2 = me.m12506a(ltVar, 10);
                        a = this.f8082a == null ? 0 : this.f8082a.length;
                        Object obj = new byte[(a2 + a)][];
                        if (a != 0) {
                            System.arraycopy(this.f8082a, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = ltVar.m12352j();
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = ltVar.m12352j();
                        this.f8082a = obj;
                        continue;
                    case 18:
                        this.f8083b = ltVar.m12352j();
                        continue;
                    case 24:
                        a = ltVar.m12349g();
                        switch (a) {
                            case 0:
                            case 1:
                                this.f8084c = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
                    case 32:
                        a = ltVar.m12349g();
                        switch (a) {
                            case 0:
                            case 1:
                                this.f8085d = Integer.valueOf(a);
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
            if (this.f8082a != null && this.f8082a.length > 0) {
                for (byte[] bArr : this.f8082a) {
                    if (bArr != null) {
                        luVar.m12404a(1, bArr);
                    }
                }
            }
            if (this.f8083b != null) {
                luVar.m12404a(2, this.f8083b);
            }
            if (this.f8084c != null) {
                luVar.m12399a(3, this.f8084c.intValue());
            }
            if (this.f8085d != null) {
                luVar.m12399a(4, this.f8085d.intValue());
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m9187a(ltVar);
        }
    }
}
