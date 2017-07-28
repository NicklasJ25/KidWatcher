package com.google.android.gms.internal;

import com.google.android.gms.internal.dz.C2828a;

public interface ea {

    public static final class C2836a extends lv<C2836a> {
        private static volatile C2836a[] f8741d;
        public String f8742a;
        public Boolean f8743b;
        public Boolean f8744c;

        public C2836a() {
            m10502c();
        }

        public static C2836a[] m10497b() {
            if (f8741d == null) {
                synchronized (lz.f9749c) {
                    if (f8741d == null) {
                        f8741d = new C2836a[0];
                    }
                }
            }
            return f8741d;
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f8742a != null) {
                a += lu.m12373b(1, this.f8742a);
            }
            if (this.f8743b != null) {
                a += lu.m12374b(2, this.f8743b.booleanValue());
            }
            return this.f8744c != null ? a + lu.m12374b(3, this.f8744c.booleanValue()) : a;
        }

        public C2836a m10499a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f8742a = ltVar.m12351i();
                        continue;
                    case 16:
                        this.f8743b = Boolean.valueOf(ltVar.m12350h());
                        continue;
                    case 24:
                        this.f8744c = Boolean.valueOf(ltVar.m12350h());
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
            if (this.f8742a != null) {
                luVar.m12402a(1, this.f8742a);
            }
            if (this.f8743b != null) {
                luVar.m12403a(2, this.f8743b.booleanValue());
            }
            if (this.f8744c != null) {
                luVar.m12403a(3, this.f8744c.booleanValue());
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m10499a(ltVar);
        }

        public C2836a m10502c() {
            this.f8742a = null;
            this.f8743b = null;
            this.f8744c = null;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C2836a)) {
                return false;
            }
            C2836a c2836a = (C2836a) obj;
            if (this.f8742a == null) {
                if (c2836a.f8742a != null) {
                    return false;
                }
            } else if (!this.f8742a.equals(c2836a.f8742a)) {
                return false;
            }
            if (this.f8743b == null) {
                if (c2836a.f8743b != null) {
                    return false;
                }
            } else if (!this.f8743b.equals(c2836a.f8743b)) {
                return false;
            }
            if (this.f8744c == null) {
                if (c2836a.f8744c != null) {
                    return false;
                }
            } else if (!this.f8744c.equals(c2836a.f8744c)) {
                return false;
            }
            return (this.ag == null || this.ag.m12439b()) ? c2836a.ag == null || c2836a.ag.m12439b() : this.ag.equals(c2836a.ag);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f8744c == null ? 0 : this.f8744c.hashCode()) + (((this.f8743b == null ? 0 : this.f8743b.hashCode()) + (((this.f8742a == null ? 0 : this.f8742a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (!(this.ag == null || this.ag.m12439b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C2837b extends lv<C2837b> {
        public Long f8745a;
        public String f8746b;
        public Integer f8747c;
        public C2838c[] f8748d;
        public C2836a[] f8749e;
        public C2828a[] f8750f;

        public C2837b() {
            m10506b();
        }

        protected int mo3505a() {
            int i;
            int i2 = 0;
            int a = super.mo3505a();
            if (this.f8745a != null) {
                a += lu.m12385e(1, this.f8745a.longValue());
            }
            if (this.f8746b != null) {
                a += lu.m12373b(2, this.f8746b);
            }
            if (this.f8747c != null) {
                a += lu.m12371b(3, this.f8747c.intValue());
            }
            if (this.f8748d != null && this.f8748d.length > 0) {
                i = a;
                for (mb mbVar : this.f8748d) {
                    if (mbVar != null) {
                        i += lu.m12378c(4, mbVar);
                    }
                }
                a = i;
            }
            if (this.f8749e != null && this.f8749e.length > 0) {
                i = a;
                for (mb mbVar2 : this.f8749e) {
                    if (mbVar2 != null) {
                        i += lu.m12378c(5, mbVar2);
                    }
                }
                a = i;
            }
            if (this.f8750f != null && this.f8750f.length > 0) {
                while (i2 < this.f8750f.length) {
                    mb mbVar3 = this.f8750f[i2];
                    if (mbVar3 != null) {
                        a += lu.m12378c(6, mbVar3);
                    }
                    i2++;
                }
            }
            return a;
        }

        public C2837b m10504a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                int a2;
                Object obj;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f8745a = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 18:
                        this.f8746b = ltVar.m12351i();
                        continue;
                    case 24:
                        this.f8747c = Integer.valueOf(ltVar.m12349g());
                        continue;
                    case 34:
                        a2 = me.m12506a(ltVar, 34);
                        a = this.f8748d == null ? 0 : this.f8748d.length;
                        obj = new C2838c[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f8748d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C2838c();
                            ltVar.m12337a(obj[a]);
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = new C2838c();
                        ltVar.m12337a(obj[a]);
                        this.f8748d = obj;
                        continue;
                    case 42:
                        a2 = me.m12506a(ltVar, 42);
                        a = this.f8749e == null ? 0 : this.f8749e.length;
                        obj = new C2836a[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f8749e, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C2836a();
                            ltVar.m12337a(obj[a]);
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = new C2836a();
                        ltVar.m12337a(obj[a]);
                        this.f8749e = obj;
                        continue;
                    case 50:
                        a2 = me.m12506a(ltVar, 50);
                        a = this.f8750f == null ? 0 : this.f8750f.length;
                        obj = new C2828a[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f8750f, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C2828a();
                            ltVar.m12337a(obj[a]);
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = new C2828a();
                        ltVar.m12337a(obj[a]);
                        this.f8750f = obj;
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
            if (this.f8745a != null) {
                luVar.m12410b(1, this.f8745a.longValue());
            }
            if (this.f8746b != null) {
                luVar.m12402a(2, this.f8746b);
            }
            if (this.f8747c != null) {
                luVar.m12399a(3, this.f8747c.intValue());
            }
            if (this.f8748d != null && this.f8748d.length > 0) {
                for (mb mbVar : this.f8748d) {
                    if (mbVar != null) {
                        luVar.m12401a(4, mbVar);
                    }
                }
            }
            if (this.f8749e != null && this.f8749e.length > 0) {
                for (mb mbVar2 : this.f8749e) {
                    if (mbVar2 != null) {
                        luVar.m12401a(5, mbVar2);
                    }
                }
            }
            if (this.f8750f != null && this.f8750f.length > 0) {
                while (i < this.f8750f.length) {
                    mb mbVar3 = this.f8750f[i];
                    if (mbVar3 != null) {
                        luVar.m12401a(6, mbVar3);
                    }
                    i++;
                }
            }
            super.mo3506a(luVar);
        }

        public C2837b m10506b() {
            this.f8745a = null;
            this.f8746b = null;
            this.f8747c = null;
            this.f8748d = C2838c.m10508b();
            this.f8749e = C2836a.m10497b();
            this.f8750f = C2828a.m10456b();
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m10504a(ltVar);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C2837b)) {
                return false;
            }
            C2837b c2837b = (C2837b) obj;
            if (this.f8745a == null) {
                if (c2837b.f8745a != null) {
                    return false;
                }
            } else if (!this.f8745a.equals(c2837b.f8745a)) {
                return false;
            }
            if (this.f8746b == null) {
                if (c2837b.f8746b != null) {
                    return false;
                }
            } else if (!this.f8746b.equals(c2837b.f8746b)) {
                return false;
            }
            if (this.f8747c == null) {
                if (c2837b.f8747c != null) {
                    return false;
                }
            } else if (!this.f8747c.equals(c2837b.f8747c)) {
                return false;
            }
            return (lz.m12453a(this.f8748d, c2837b.f8748d) && lz.m12453a(this.f8749e, c2837b.f8749e) && lz.m12453a(this.f8750f, c2837b.f8750f)) ? (this.ag == null || this.ag.m12439b()) ? c2837b.ag == null || c2837b.ag.m12439b() : this.ag.equals(c2837b.ag) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((((this.f8747c == null ? 0 : this.f8747c.hashCode()) + (((this.f8746b == null ? 0 : this.f8746b.hashCode()) + (((this.f8745a == null ? 0 : this.f8745a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + lz.m12448a(this.f8748d)) * 31) + lz.m12448a(this.f8749e)) * 31) + lz.m12448a(this.f8750f)) * 31;
            if (!(this.ag == null || this.ag.m12439b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C2838c extends lv<C2838c> {
        private static volatile C2838c[] f8751c;
        public String f8752a;
        public String f8753b;

        public C2838c() {
            m10513c();
        }

        public static C2838c[] m10508b() {
            if (f8751c == null) {
                synchronized (lz.f9749c) {
                    if (f8751c == null) {
                        f8751c = new C2838c[0];
                    }
                }
            }
            return f8751c;
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f8752a != null) {
                a += lu.m12373b(1, this.f8752a);
            }
            return this.f8753b != null ? a + lu.m12373b(2, this.f8753b) : a;
        }

        public C2838c m10510a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f8752a = ltVar.m12351i();
                        continue;
                    case 18:
                        this.f8753b = ltVar.m12351i();
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
            if (this.f8752a != null) {
                luVar.m12402a(1, this.f8752a);
            }
            if (this.f8753b != null) {
                luVar.m12402a(2, this.f8753b);
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m10510a(ltVar);
        }

        public C2838c m10513c() {
            this.f8752a = null;
            this.f8753b = null;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C2838c)) {
                return false;
            }
            C2838c c2838c = (C2838c) obj;
            if (this.f8752a == null) {
                if (c2838c.f8752a != null) {
                    return false;
                }
            } else if (!this.f8752a.equals(c2838c.f8752a)) {
                return false;
            }
            if (this.f8753b == null) {
                if (c2838c.f8753b != null) {
                    return false;
                }
            } else if (!this.f8753b.equals(c2838c.f8753b)) {
                return false;
            }
            return (this.ag == null || this.ag.m12439b()) ? c2838c.ag == null || c2838c.ag.m12439b() : this.ag.equals(c2838c.ag);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f8753b == null ? 0 : this.f8753b.hashCode()) + (((this.f8752a == null ? 0 : this.f8752a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (!(this.ag == null || this.ag.m12439b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }
}
