package com.google.android.gms.internal;

public interface dz {

    public static final class C2828a extends lv<C2828a> {
        private static volatile C2828a[] f8708d;
        public Integer f8709a;
        public C2832e[] f8710b;
        public C2829b[] f8711c;

        public C2828a() {
            m10461c();
        }

        public static C2828a[] m10456b() {
            if (f8708d == null) {
                synchronized (lz.f9749c) {
                    if (f8708d == null) {
                        f8708d = new C2828a[0];
                    }
                }
            }
            return f8708d;
        }

        protected int mo3505a() {
            int i = 0;
            int a = super.mo3505a();
            if (this.f8709a != null) {
                a += lu.m12371b(1, this.f8709a.intValue());
            }
            if (this.f8710b != null && this.f8710b.length > 0) {
                int i2 = a;
                for (mb mbVar : this.f8710b) {
                    if (mbVar != null) {
                        i2 += lu.m12378c(2, mbVar);
                    }
                }
                a = i2;
            }
            if (this.f8711c != null && this.f8711c.length > 0) {
                while (i < this.f8711c.length) {
                    mb mbVar2 = this.f8711c[i];
                    if (mbVar2 != null) {
                        a += lu.m12378c(3, mbVar2);
                    }
                    i++;
                }
            }
            return a;
        }

        public C2828a m10458a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                int a2;
                Object obj;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f8709a = Integer.valueOf(ltVar.m12349g());
                        continue;
                    case 18:
                        a2 = me.m12506a(ltVar, 18);
                        a = this.f8710b == null ? 0 : this.f8710b.length;
                        obj = new C2832e[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f8710b, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C2832e();
                            ltVar.m12337a(obj[a]);
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = new C2832e();
                        ltVar.m12337a(obj[a]);
                        this.f8710b = obj;
                        continue;
                    case 26:
                        a2 = me.m12506a(ltVar, 26);
                        a = this.f8711c == null ? 0 : this.f8711c.length;
                        obj = new C2829b[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f8711c, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C2829b();
                            ltVar.m12337a(obj[a]);
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = new C2829b();
                        ltVar.m12337a(obj[a]);
                        this.f8711c = obj;
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
            int i = 0;
            if (this.f8709a != null) {
                luVar.m12399a(1, this.f8709a.intValue());
            }
            if (this.f8710b != null && this.f8710b.length > 0) {
                for (mb mbVar : this.f8710b) {
                    if (mbVar != null) {
                        luVar.m12401a(2, mbVar);
                    }
                }
            }
            if (this.f8711c != null && this.f8711c.length > 0) {
                while (i < this.f8711c.length) {
                    mb mbVar2 = this.f8711c[i];
                    if (mbVar2 != null) {
                        luVar.m12401a(3, mbVar2);
                    }
                    i++;
                }
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m10458a(ltVar);
        }

        public C2828a m10461c() {
            this.f8709a = null;
            this.f8710b = C2832e.m10479b();
            this.f8711c = C2829b.m10462b();
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C2828a)) {
                return false;
            }
            C2828a c2828a = (C2828a) obj;
            if (this.f8709a == null) {
                if (c2828a.f8709a != null) {
                    return false;
                }
            } else if (!this.f8709a.equals(c2828a.f8709a)) {
                return false;
            }
            return (lz.m12453a(this.f8710b, c2828a.f8710b) && lz.m12453a(this.f8711c, c2828a.f8711c)) ? (this.ag == null || this.ag.m12439b()) ? c2828a.ag == null || c2828a.ag.m12439b() : this.ag.equals(c2828a.ag) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.f8709a == null ? 0 : this.f8709a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + lz.m12448a(this.f8710b)) * 31) + lz.m12448a(this.f8711c)) * 31;
            if (!(this.ag == null || this.ag.m12439b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C2829b extends lv<C2829b> {
        private static volatile C2829b[] f8712f;
        public Integer f8713a;
        public String f8714b;
        public C2830c[] f8715c;
        public Boolean f8716d;
        public C2831d f8717e;

        public C2829b() {
            m10467c();
        }

        public static C2829b[] m10462b() {
            if (f8712f == null) {
                synchronized (lz.f9749c) {
                    if (f8712f == null) {
                        f8712f = new C2829b[0];
                    }
                }
            }
            return f8712f;
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f8713a != null) {
                a += lu.m12371b(1, this.f8713a.intValue());
            }
            if (this.f8714b != null) {
                a += lu.m12373b(2, this.f8714b);
            }
            if (this.f8715c != null && this.f8715c.length > 0) {
                int i = a;
                for (mb mbVar : this.f8715c) {
                    if (mbVar != null) {
                        i += lu.m12378c(3, mbVar);
                    }
                }
                a = i;
            }
            if (this.f8716d != null) {
                a += lu.m12374b(4, this.f8716d.booleanValue());
            }
            return this.f8717e != null ? a + lu.m12378c(5, this.f8717e) : a;
        }

        public C2829b m10464a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f8713a = Integer.valueOf(ltVar.m12349g());
                        continue;
                    case 18:
                        this.f8714b = ltVar.m12351i();
                        continue;
                    case 26:
                        int a2 = me.m12506a(ltVar, 26);
                        a = this.f8715c == null ? 0 : this.f8715c.length;
                        Object obj = new C2830c[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f8715c, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C2830c();
                            ltVar.m12337a(obj[a]);
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = new C2830c();
                        ltVar.m12337a(obj[a]);
                        this.f8715c = obj;
                        continue;
                    case 32:
                        this.f8716d = Boolean.valueOf(ltVar.m12350h());
                        continue;
                    case 42:
                        if (this.f8717e == null) {
                            this.f8717e = new C2831d();
                        }
                        ltVar.m12337a(this.f8717e);
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
            if (this.f8713a != null) {
                luVar.m12399a(1, this.f8713a.intValue());
            }
            if (this.f8714b != null) {
                luVar.m12402a(2, this.f8714b);
            }
            if (this.f8715c != null && this.f8715c.length > 0) {
                for (mb mbVar : this.f8715c) {
                    if (mbVar != null) {
                        luVar.m12401a(3, mbVar);
                    }
                }
            }
            if (this.f8716d != null) {
                luVar.m12403a(4, this.f8716d.booleanValue());
            }
            if (this.f8717e != null) {
                luVar.m12401a(5, this.f8717e);
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m10464a(ltVar);
        }

        public C2829b m10467c() {
            this.f8713a = null;
            this.f8714b = null;
            this.f8715c = C2830c.m10468b();
            this.f8716d = null;
            this.f8717e = null;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C2829b)) {
                return false;
            }
            C2829b c2829b = (C2829b) obj;
            if (this.f8713a == null) {
                if (c2829b.f8713a != null) {
                    return false;
                }
            } else if (!this.f8713a.equals(c2829b.f8713a)) {
                return false;
            }
            if (this.f8714b == null) {
                if (c2829b.f8714b != null) {
                    return false;
                }
            } else if (!this.f8714b.equals(c2829b.f8714b)) {
                return false;
            }
            if (!lz.m12453a(this.f8715c, c2829b.f8715c)) {
                return false;
            }
            if (this.f8716d == null) {
                if (c2829b.f8716d != null) {
                    return false;
                }
            } else if (!this.f8716d.equals(c2829b.f8716d)) {
                return false;
            }
            if (this.f8717e == null) {
                if (c2829b.f8717e != null) {
                    return false;
                }
            } else if (!this.f8717e.equals(c2829b.f8717e)) {
                return false;
            }
            return (this.ag == null || this.ag.m12439b()) ? c2829b.ag == null || c2829b.ag.m12439b() : this.ag.equals(c2829b.ag);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f8717e == null ? 0 : this.f8717e.hashCode()) + (((this.f8716d == null ? 0 : this.f8716d.hashCode()) + (((((this.f8714b == null ? 0 : this.f8714b.hashCode()) + (((this.f8713a == null ? 0 : this.f8713a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + lz.m12448a(this.f8715c)) * 31)) * 31)) * 31;
            if (!(this.ag == null || this.ag.m12439b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C2830c extends lv<C2830c> {
        private static volatile C2830c[] f8718e;
        public C2833f f8719a;
        public C2831d f8720b;
        public Boolean f8721c;
        public String f8722d;

        public C2830c() {
            m10473c();
        }

        public static C2830c[] m10468b() {
            if (f8718e == null) {
                synchronized (lz.f9749c) {
                    if (f8718e == null) {
                        f8718e = new C2830c[0];
                    }
                }
            }
            return f8718e;
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f8719a != null) {
                a += lu.m12378c(1, this.f8719a);
            }
            if (this.f8720b != null) {
                a += lu.m12378c(2, this.f8720b);
            }
            if (this.f8721c != null) {
                a += lu.m12374b(3, this.f8721c.booleanValue());
            }
            return this.f8722d != null ? a + lu.m12373b(4, this.f8722d) : a;
        }

        public C2830c m10470a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        if (this.f8719a == null) {
                            this.f8719a = new C2833f();
                        }
                        ltVar.m12337a(this.f8719a);
                        continue;
                    case 18:
                        if (this.f8720b == null) {
                            this.f8720b = new C2831d();
                        }
                        ltVar.m12337a(this.f8720b);
                        continue;
                    case 24:
                        this.f8721c = Boolean.valueOf(ltVar.m12350h());
                        continue;
                    case 34:
                        this.f8722d = ltVar.m12351i();
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
            if (this.f8719a != null) {
                luVar.m12401a(1, this.f8719a);
            }
            if (this.f8720b != null) {
                luVar.m12401a(2, this.f8720b);
            }
            if (this.f8721c != null) {
                luVar.m12403a(3, this.f8721c.booleanValue());
            }
            if (this.f8722d != null) {
                luVar.m12402a(4, this.f8722d);
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m10470a(ltVar);
        }

        public C2830c m10473c() {
            this.f8719a = null;
            this.f8720b = null;
            this.f8721c = null;
            this.f8722d = null;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C2830c)) {
                return false;
            }
            C2830c c2830c = (C2830c) obj;
            if (this.f8719a == null) {
                if (c2830c.f8719a != null) {
                    return false;
                }
            } else if (!this.f8719a.equals(c2830c.f8719a)) {
                return false;
            }
            if (this.f8720b == null) {
                if (c2830c.f8720b != null) {
                    return false;
                }
            } else if (!this.f8720b.equals(c2830c.f8720b)) {
                return false;
            }
            if (this.f8721c == null) {
                if (c2830c.f8721c != null) {
                    return false;
                }
            } else if (!this.f8721c.equals(c2830c.f8721c)) {
                return false;
            }
            if (this.f8722d == null) {
                if (c2830c.f8722d != null) {
                    return false;
                }
            } else if (!this.f8722d.equals(c2830c.f8722d)) {
                return false;
            }
            return (this.ag == null || this.ag.m12439b()) ? c2830c.ag == null || c2830c.ag.m12439b() : this.ag.equals(c2830c.ag);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f8722d == null ? 0 : this.f8722d.hashCode()) + (((this.f8721c == null ? 0 : this.f8721c.hashCode()) + (((this.f8720b == null ? 0 : this.f8720b.hashCode()) + (((this.f8719a == null ? 0 : this.f8719a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
            if (!(this.ag == null || this.ag.m12439b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C2831d extends lv<C2831d> {
        public Integer f8723a;
        public Boolean f8724b;
        public String f8725c;
        public String f8726d;
        public String f8727e;

        public C2831d() {
            m10477b();
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f8723a != null) {
                a += lu.m12371b(1, this.f8723a.intValue());
            }
            if (this.f8724b != null) {
                a += lu.m12374b(2, this.f8724b.booleanValue());
            }
            if (this.f8725c != null) {
                a += lu.m12373b(3, this.f8725c);
            }
            if (this.f8726d != null) {
                a += lu.m12373b(4, this.f8726d);
            }
            return this.f8727e != null ? a + lu.m12373b(5, this.f8727e) : a;
        }

        public C2831d m10475a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        a = ltVar.m12349g();
                        switch (a) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                this.f8723a = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.f8724b = Boolean.valueOf(ltVar.m12350h());
                        continue;
                    case 26:
                        this.f8725c = ltVar.m12351i();
                        continue;
                    case 34:
                        this.f8726d = ltVar.m12351i();
                        continue;
                    case 42:
                        this.f8727e = ltVar.m12351i();
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
            if (this.f8723a != null) {
                luVar.m12399a(1, this.f8723a.intValue());
            }
            if (this.f8724b != null) {
                luVar.m12403a(2, this.f8724b.booleanValue());
            }
            if (this.f8725c != null) {
                luVar.m12402a(3, this.f8725c);
            }
            if (this.f8726d != null) {
                luVar.m12402a(4, this.f8726d);
            }
            if (this.f8727e != null) {
                luVar.m12402a(5, this.f8727e);
            }
            super.mo3506a(luVar);
        }

        public C2831d m10477b() {
            this.f8724b = null;
            this.f8725c = null;
            this.f8726d = null;
            this.f8727e = null;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m10475a(ltVar);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C2831d)) {
                return false;
            }
            C2831d c2831d = (C2831d) obj;
            if (this.f8723a == null) {
                if (c2831d.f8723a != null) {
                    return false;
                }
            } else if (!this.f8723a.equals(c2831d.f8723a)) {
                return false;
            }
            if (this.f8724b == null) {
                if (c2831d.f8724b != null) {
                    return false;
                }
            } else if (!this.f8724b.equals(c2831d.f8724b)) {
                return false;
            }
            if (this.f8725c == null) {
                if (c2831d.f8725c != null) {
                    return false;
                }
            } else if (!this.f8725c.equals(c2831d.f8725c)) {
                return false;
            }
            if (this.f8726d == null) {
                if (c2831d.f8726d != null) {
                    return false;
                }
            } else if (!this.f8726d.equals(c2831d.f8726d)) {
                return false;
            }
            if (this.f8727e == null) {
                if (c2831d.f8727e != null) {
                    return false;
                }
            } else if (!this.f8727e.equals(c2831d.f8727e)) {
                return false;
            }
            return (this.ag == null || this.ag.m12439b()) ? c2831d.ag == null || c2831d.ag.m12439b() : this.ag.equals(c2831d.ag);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f8727e == null ? 0 : this.f8727e.hashCode()) + (((this.f8726d == null ? 0 : this.f8726d.hashCode()) + (((this.f8725c == null ? 0 : this.f8725c.hashCode()) + (((this.f8724b == null ? 0 : this.f8724b.hashCode()) + (((this.f8723a == null ? 0 : this.f8723a.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (!(this.ag == null || this.ag.m12439b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C2832e extends lv<C2832e> {
        private static volatile C2832e[] f8728d;
        public Integer f8729a;
        public String f8730b;
        public C2830c f8731c;

        public C2832e() {
            m10484c();
        }

        public static C2832e[] m10479b() {
            if (f8728d == null) {
                synchronized (lz.f9749c) {
                    if (f8728d == null) {
                        f8728d = new C2832e[0];
                    }
                }
            }
            return f8728d;
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f8729a != null) {
                a += lu.m12371b(1, this.f8729a.intValue());
            }
            if (this.f8730b != null) {
                a += lu.m12373b(2, this.f8730b);
            }
            return this.f8731c != null ? a + lu.m12378c(3, this.f8731c) : a;
        }

        public C2832e m10481a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f8729a = Integer.valueOf(ltVar.m12349g());
                        continue;
                    case 18:
                        this.f8730b = ltVar.m12351i();
                        continue;
                    case 26:
                        if (this.f8731c == null) {
                            this.f8731c = new C2830c();
                        }
                        ltVar.m12337a(this.f8731c);
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
            if (this.f8729a != null) {
                luVar.m12399a(1, this.f8729a.intValue());
            }
            if (this.f8730b != null) {
                luVar.m12402a(2, this.f8730b);
            }
            if (this.f8731c != null) {
                luVar.m12401a(3, this.f8731c);
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m10481a(ltVar);
        }

        public C2832e m10484c() {
            this.f8729a = null;
            this.f8730b = null;
            this.f8731c = null;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C2832e)) {
                return false;
            }
            C2832e c2832e = (C2832e) obj;
            if (this.f8729a == null) {
                if (c2832e.f8729a != null) {
                    return false;
                }
            } else if (!this.f8729a.equals(c2832e.f8729a)) {
                return false;
            }
            if (this.f8730b == null) {
                if (c2832e.f8730b != null) {
                    return false;
                }
            } else if (!this.f8730b.equals(c2832e.f8730b)) {
                return false;
            }
            if (this.f8731c == null) {
                if (c2832e.f8731c != null) {
                    return false;
                }
            } else if (!this.f8731c.equals(c2832e.f8731c)) {
                return false;
            }
            return (this.ag == null || this.ag.m12439b()) ? c2832e.ag == null || c2832e.ag.m12439b() : this.ag.equals(c2832e.ag);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f8731c == null ? 0 : this.f8731c.hashCode()) + (((this.f8730b == null ? 0 : this.f8730b.hashCode()) + (((this.f8729a == null ? 0 : this.f8729a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (!(this.ag == null || this.ag.m12439b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C2833f extends lv<C2833f> {
        public Integer f8732a;
        public String f8733b;
        public Boolean f8734c;
        public String[] f8735d;

        public C2833f() {
            m10488b();
        }

        protected int mo3505a() {
            int i = 0;
            int a = super.mo3505a();
            if (this.f8732a != null) {
                a += lu.m12371b(1, this.f8732a.intValue());
            }
            if (this.f8733b != null) {
                a += lu.m12373b(2, this.f8733b);
            }
            if (this.f8734c != null) {
                a += lu.m12374b(3, this.f8734c.booleanValue());
            }
            if (this.f8735d == null || this.f8735d.length <= 0) {
                return a;
            }
            int i2 = 0;
            int i3 = 0;
            while (i < this.f8735d.length) {
                String str = this.f8735d[i];
                if (str != null) {
                    i3++;
                    i2 += lu.m12376b(str);
                }
                i++;
            }
            return (a + i2) + (i3 * 1);
        }

        public C2833f m10486a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        a = ltVar.m12349g();
                        switch (a) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.f8732a = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.f8733b = ltVar.m12351i();
                        continue;
                    case 24:
                        this.f8734c = Boolean.valueOf(ltVar.m12350h());
                        continue;
                    case 34:
                        int a2 = me.m12506a(ltVar, 34);
                        a = this.f8735d == null ? 0 : this.f8735d.length;
                        Object obj = new String[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f8735d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = ltVar.m12351i();
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = ltVar.m12351i();
                        this.f8735d = obj;
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
            if (this.f8732a != null) {
                luVar.m12399a(1, this.f8732a.intValue());
            }
            if (this.f8733b != null) {
                luVar.m12402a(2, this.f8733b);
            }
            if (this.f8734c != null) {
                luVar.m12403a(3, this.f8734c.booleanValue());
            }
            if (this.f8735d != null && this.f8735d.length > 0) {
                for (String str : this.f8735d) {
                    if (str != null) {
                        luVar.m12402a(4, str);
                    }
                }
            }
            super.mo3506a(luVar);
        }

        public C2833f m10488b() {
            this.f8733b = null;
            this.f8734c = null;
            this.f8735d = me.f9782j;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m10486a(ltVar);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C2833f)) {
                return false;
            }
            C2833f c2833f = (C2833f) obj;
            if (this.f8732a == null) {
                if (c2833f.f8732a != null) {
                    return false;
                }
            } else if (!this.f8732a.equals(c2833f.f8732a)) {
                return false;
            }
            if (this.f8733b == null) {
                if (c2833f.f8733b != null) {
                    return false;
                }
            } else if (!this.f8733b.equals(c2833f.f8733b)) {
                return false;
            }
            if (this.f8734c == null) {
                if (c2833f.f8734c != null) {
                    return false;
                }
            } else if (!this.f8734c.equals(c2833f.f8734c)) {
                return false;
            }
            return lz.m12453a(this.f8735d, c2833f.f8735d) ? (this.ag == null || this.ag.m12439b()) ? c2833f.ag == null || c2833f.ag.m12439b() : this.ag.equals(c2833f.ag) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.f8734c == null ? 0 : this.f8734c.hashCode()) + (((this.f8733b == null ? 0 : this.f8733b.hashCode()) + (((this.f8732a == null ? 0 : this.f8732a.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + lz.m12448a(this.f8735d)) * 31;
            if (!(this.ag == null || this.ag.m12439b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }
}
