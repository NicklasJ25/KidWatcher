package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;

public interface eb {

    public static final class C2839a extends lv<C2839a> {
        private static volatile C2839a[] f8754e;
        public Integer f8755a;
        public C2844f f8756b;
        public C2844f f8757c;
        public Boolean f8758d;

        public C2839a() {
            m10519c();
        }

        public static C2839a[] m10514b() {
            if (f8754e == null) {
                synchronized (lz.f9749c) {
                    if (f8754e == null) {
                        f8754e = new C2839a[0];
                    }
                }
            }
            return f8754e;
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f8755a != null) {
                a += lu.m12371b(1, this.f8755a.intValue());
            }
            if (this.f8756b != null) {
                a += lu.m12378c(2, this.f8756b);
            }
            if (this.f8757c != null) {
                a += lu.m12378c(3, this.f8757c);
            }
            return this.f8758d != null ? a + lu.m12374b(4, this.f8758d.booleanValue()) : a;
        }

        public C2839a m10516a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f8755a = Integer.valueOf(ltVar.m12349g());
                        continue;
                    case 18:
                        if (this.f8756b == null) {
                            this.f8756b = new C2844f();
                        }
                        ltVar.m12337a(this.f8756b);
                        continue;
                    case 26:
                        if (this.f8757c == null) {
                            this.f8757c = new C2844f();
                        }
                        ltVar.m12337a(this.f8757c);
                        continue;
                    case 32:
                        this.f8758d = Boolean.valueOf(ltVar.m12350h());
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
            if (this.f8755a != null) {
                luVar.m12399a(1, this.f8755a.intValue());
            }
            if (this.f8756b != null) {
                luVar.m12401a(2, this.f8756b);
            }
            if (this.f8757c != null) {
                luVar.m12401a(3, this.f8757c);
            }
            if (this.f8758d != null) {
                luVar.m12403a(4, this.f8758d.booleanValue());
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m10516a(ltVar);
        }

        public C2839a m10519c() {
            this.f8755a = null;
            this.f8756b = null;
            this.f8757c = null;
            this.f8758d = null;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C2839a)) {
                return false;
            }
            C2839a c2839a = (C2839a) obj;
            if (this.f8755a == null) {
                if (c2839a.f8755a != null) {
                    return false;
                }
            } else if (!this.f8755a.equals(c2839a.f8755a)) {
                return false;
            }
            if (this.f8756b == null) {
                if (c2839a.f8756b != null) {
                    return false;
                }
            } else if (!this.f8756b.equals(c2839a.f8756b)) {
                return false;
            }
            if (this.f8757c == null) {
                if (c2839a.f8757c != null) {
                    return false;
                }
            } else if (!this.f8757c.equals(c2839a.f8757c)) {
                return false;
            }
            if (this.f8758d == null) {
                if (c2839a.f8758d != null) {
                    return false;
                }
            } else if (!this.f8758d.equals(c2839a.f8758d)) {
                return false;
            }
            return (this.ag == null || this.ag.m12439b()) ? c2839a.ag == null || c2839a.ag.m12439b() : this.ag.equals(c2839a.ag);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f8758d == null ? 0 : this.f8758d.hashCode()) + (((this.f8757c == null ? 0 : this.f8757c.hashCode()) + (((this.f8756b == null ? 0 : this.f8756b.hashCode()) + (((this.f8755a == null ? 0 : this.f8755a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
            if (!(this.ag == null || this.ag.m12439b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C2840b extends lv<C2840b> {
        private static volatile C2840b[] f8759f;
        public C2841c[] f8760a;
        public String f8761b;
        public Long f8762c;
        public Long f8763d;
        public Integer f8764e;

        public C2840b() {
            m10525c();
        }

        public static C2840b[] m10520b() {
            if (f8759f == null) {
                synchronized (lz.f9749c) {
                    if (f8759f == null) {
                        f8759f = new C2840b[0];
                    }
                }
            }
            return f8759f;
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f8760a != null && this.f8760a.length > 0) {
                for (mb mbVar : this.f8760a) {
                    if (mbVar != null) {
                        a += lu.m12378c(1, mbVar);
                    }
                }
            }
            if (this.f8761b != null) {
                a += lu.m12373b(2, this.f8761b);
            }
            if (this.f8762c != null) {
                a += lu.m12385e(3, this.f8762c.longValue());
            }
            if (this.f8763d != null) {
                a += lu.m12385e(4, this.f8763d.longValue());
            }
            return this.f8764e != null ? a + lu.m12371b(5, this.f8764e.intValue()) : a;
        }

        public C2840b m10522a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        int a2 = me.m12506a(ltVar, 10);
                        a = this.f8760a == null ? 0 : this.f8760a.length;
                        Object obj = new C2841c[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f8760a, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C2841c();
                            ltVar.m12337a(obj[a]);
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = new C2841c();
                        ltVar.m12337a(obj[a]);
                        this.f8760a = obj;
                        continue;
                    case 18:
                        this.f8761b = ltVar.m12351i();
                        continue;
                    case 24:
                        this.f8762c = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 32:
                        this.f8763d = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 40:
                        this.f8764e = Integer.valueOf(ltVar.m12349g());
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
            if (this.f8760a != null && this.f8760a.length > 0) {
                for (mb mbVar : this.f8760a) {
                    if (mbVar != null) {
                        luVar.m12401a(1, mbVar);
                    }
                }
            }
            if (this.f8761b != null) {
                luVar.m12402a(2, this.f8761b);
            }
            if (this.f8762c != null) {
                luVar.m12410b(3, this.f8762c.longValue());
            }
            if (this.f8763d != null) {
                luVar.m12410b(4, this.f8763d.longValue());
            }
            if (this.f8764e != null) {
                luVar.m12399a(5, this.f8764e.intValue());
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m10522a(ltVar);
        }

        public C2840b m10525c() {
            this.f8760a = C2841c.m10526b();
            this.f8761b = null;
            this.f8762c = null;
            this.f8763d = null;
            this.f8764e = null;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C2840b)) {
                return false;
            }
            C2840b c2840b = (C2840b) obj;
            if (!lz.m12453a(this.f8760a, c2840b.f8760a)) {
                return false;
            }
            if (this.f8761b == null) {
                if (c2840b.f8761b != null) {
                    return false;
                }
            } else if (!this.f8761b.equals(c2840b.f8761b)) {
                return false;
            }
            if (this.f8762c == null) {
                if (c2840b.f8762c != null) {
                    return false;
                }
            } else if (!this.f8762c.equals(c2840b.f8762c)) {
                return false;
            }
            if (this.f8763d == null) {
                if (c2840b.f8763d != null) {
                    return false;
                }
            } else if (!this.f8763d.equals(c2840b.f8763d)) {
                return false;
            }
            if (this.f8764e == null) {
                if (c2840b.f8764e != null) {
                    return false;
                }
            } else if (!this.f8764e.equals(c2840b.f8764e)) {
                return false;
            }
            return (this.ag == null || this.ag.m12439b()) ? c2840b.ag == null || c2840b.ag.m12439b() : this.ag.equals(c2840b.ag);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f8764e == null ? 0 : this.f8764e.hashCode()) + (((this.f8763d == null ? 0 : this.f8763d.hashCode()) + (((this.f8762c == null ? 0 : this.f8762c.hashCode()) + (((this.f8761b == null ? 0 : this.f8761b.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + lz.m12448a(this.f8760a)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (!(this.ag == null || this.ag.m12439b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C2841c extends lv<C2841c> {
        private static volatile C2841c[] f8765f;
        public String f8766a;
        public String f8767b;
        public Long f8768c;
        public Float f8769d;
        public Double f8770e;

        public C2841c() {
            m10531c();
        }

        public static C2841c[] m10526b() {
            if (f8765f == null) {
                synchronized (lz.f9749c) {
                    if (f8765f == null) {
                        f8765f = new C2841c[0];
                    }
                }
            }
            return f8765f;
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f8766a != null) {
                a += lu.m12373b(1, this.f8766a);
            }
            if (this.f8767b != null) {
                a += lu.m12373b(2, this.f8767b);
            }
            if (this.f8768c != null) {
                a += lu.m12385e(3, this.f8768c.longValue());
            }
            if (this.f8769d != null) {
                a += lu.m12370b(4, this.f8769d.floatValue());
            }
            return this.f8770e != null ? a + lu.m12369b(5, this.f8770e.doubleValue()) : a;
        }

        public C2841c m10528a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f8766a = ltVar.m12351i();
                        continue;
                    case 18:
                        this.f8767b = ltVar.m12351i();
                        continue;
                    case 24:
                        this.f8768c = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 37:
                        this.f8769d = Float.valueOf(ltVar.m12343d());
                        continue;
                    case 41:
                        this.f8770e = Double.valueOf(ltVar.m12341c());
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
            if (this.f8766a != null) {
                luVar.m12402a(1, this.f8766a);
            }
            if (this.f8767b != null) {
                luVar.m12402a(2, this.f8767b);
            }
            if (this.f8768c != null) {
                luVar.m12410b(3, this.f8768c.longValue());
            }
            if (this.f8769d != null) {
                luVar.m12398a(4, this.f8769d.floatValue());
            }
            if (this.f8770e != null) {
                luVar.m12397a(5, this.f8770e.doubleValue());
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m10528a(ltVar);
        }

        public C2841c m10531c() {
            this.f8766a = null;
            this.f8767b = null;
            this.f8768c = null;
            this.f8769d = null;
            this.f8770e = null;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C2841c)) {
                return false;
            }
            C2841c c2841c = (C2841c) obj;
            if (this.f8766a == null) {
                if (c2841c.f8766a != null) {
                    return false;
                }
            } else if (!this.f8766a.equals(c2841c.f8766a)) {
                return false;
            }
            if (this.f8767b == null) {
                if (c2841c.f8767b != null) {
                    return false;
                }
            } else if (!this.f8767b.equals(c2841c.f8767b)) {
                return false;
            }
            if (this.f8768c == null) {
                if (c2841c.f8768c != null) {
                    return false;
                }
            } else if (!this.f8768c.equals(c2841c.f8768c)) {
                return false;
            }
            if (this.f8769d == null) {
                if (c2841c.f8769d != null) {
                    return false;
                }
            } else if (!this.f8769d.equals(c2841c.f8769d)) {
                return false;
            }
            if (this.f8770e == null) {
                if (c2841c.f8770e != null) {
                    return false;
                }
            } else if (!this.f8770e.equals(c2841c.f8770e)) {
                return false;
            }
            return (this.ag == null || this.ag.m12439b()) ? c2841c.ag == null || c2841c.ag.m12439b() : this.ag.equals(c2841c.ag);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f8770e == null ? 0 : this.f8770e.hashCode()) + (((this.f8769d == null ? 0 : this.f8769d.hashCode()) + (((this.f8768c == null ? 0 : this.f8768c.hashCode()) + (((this.f8767b == null ? 0 : this.f8767b.hashCode()) + (((this.f8766a == null ? 0 : this.f8766a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (!(this.ag == null || this.ag.m12439b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C2842d extends lv<C2842d> {
        public C2843e[] f8771a;

        public C2842d() {
            m10535b();
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f8771a != null && this.f8771a.length > 0) {
                for (mb mbVar : this.f8771a) {
                    if (mbVar != null) {
                        a += lu.m12378c(1, mbVar);
                    }
                }
            }
            return a;
        }

        public C2842d m10533a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        int a2 = me.m12506a(ltVar, 10);
                        a = this.f8771a == null ? 0 : this.f8771a.length;
                        Object obj = new C2843e[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f8771a, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C2843e();
                            ltVar.m12337a(obj[a]);
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = new C2843e();
                        ltVar.m12337a(obj[a]);
                        this.f8771a = obj;
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
            if (this.f8771a != null && this.f8771a.length > 0) {
                for (mb mbVar : this.f8771a) {
                    if (mbVar != null) {
                        luVar.m12401a(1, mbVar);
                    }
                }
            }
            super.mo3506a(luVar);
        }

        public C2842d m10535b() {
            this.f8771a = C2843e.m10537b();
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m10533a(ltVar);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C2842d)) {
                return false;
            }
            C2842d c2842d = (C2842d) obj;
            return lz.m12453a(this.f8771a, c2842d.f8771a) ? (this.ag == null || this.ag.m12439b()) ? c2842d.ag == null || c2842d.ag.m12439b() : this.ag.equals(c2842d.ag) : false;
        }

        public int hashCode() {
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + lz.m12448a(this.f8771a)) * 31;
            int hashCode2 = (this.ag == null || this.ag.m12439b()) ? 0 : this.ag.hashCode();
            return hashCode2 + hashCode;
        }
    }

    public static final class C2843e extends lv<C2843e> {
        private static volatile C2843e[] f8772I;
        public C2839a[] f8773A;
        public String f8774B;
        public Integer f8775C;
        public Integer f8776D;
        public Integer f8777E;
        public String f8778F;
        public Long f8779G;
        public Long f8780H;
        public Integer f8781a;
        public C2840b[] f8782b;
        public C2845g[] f8783c;
        public Long f8784d;
        public Long f8785e;
        public Long f8786f;
        public Long f8787g;
        public Long f8788h;
        public String f8789i;
        public String f8790j;
        public String f8791k;
        public String f8792l;
        public Integer f8793m;
        public String f8794n;
        public String f8795o;
        public String f8796p;
        public Long f8797q;
        public Long f8798r;
        public String f8799s;
        public Boolean f8800t;
        public String f8801u;
        public Long f8802v;
        public Integer f8803w;
        public String f8804x;
        public String f8805y;
        public Boolean f8806z;

        public C2843e() {
            m10542c();
        }

        public static C2843e[] m10537b() {
            if (f8772I == null) {
                synchronized (lz.f9749c) {
                    if (f8772I == null) {
                        f8772I = new C2843e[0];
                    }
                }
            }
            return f8772I;
        }

        protected int mo3505a() {
            int i;
            int i2 = 0;
            int a = super.mo3505a();
            if (this.f8781a != null) {
                a += lu.m12371b(1, this.f8781a.intValue());
            }
            if (this.f8782b != null && this.f8782b.length > 0) {
                i = a;
                for (mb mbVar : this.f8782b) {
                    if (mbVar != null) {
                        i += lu.m12378c(2, mbVar);
                    }
                }
                a = i;
            }
            if (this.f8783c != null && this.f8783c.length > 0) {
                i = a;
                for (mb mbVar2 : this.f8783c) {
                    if (mbVar2 != null) {
                        i += lu.m12378c(3, mbVar2);
                    }
                }
                a = i;
            }
            if (this.f8784d != null) {
                a += lu.m12385e(4, this.f8784d.longValue());
            }
            if (this.f8785e != null) {
                a += lu.m12385e(5, this.f8785e.longValue());
            }
            if (this.f8786f != null) {
                a += lu.m12385e(6, this.f8786f.longValue());
            }
            if (this.f8788h != null) {
                a += lu.m12385e(7, this.f8788h.longValue());
            }
            if (this.f8789i != null) {
                a += lu.m12373b(8, this.f8789i);
            }
            if (this.f8790j != null) {
                a += lu.m12373b(9, this.f8790j);
            }
            if (this.f8791k != null) {
                a += lu.m12373b(10, this.f8791k);
            }
            if (this.f8792l != null) {
                a += lu.m12373b(11, this.f8792l);
            }
            if (this.f8793m != null) {
                a += lu.m12371b(12, this.f8793m.intValue());
            }
            if (this.f8794n != null) {
                a += lu.m12373b(13, this.f8794n);
            }
            if (this.f8795o != null) {
                a += lu.m12373b(14, this.f8795o);
            }
            if (this.f8796p != null) {
                a += lu.m12373b(16, this.f8796p);
            }
            if (this.f8797q != null) {
                a += lu.m12385e(17, this.f8797q.longValue());
            }
            if (this.f8798r != null) {
                a += lu.m12385e(18, this.f8798r.longValue());
            }
            if (this.f8799s != null) {
                a += lu.m12373b(19, this.f8799s);
            }
            if (this.f8800t != null) {
                a += lu.m12374b(20, this.f8800t.booleanValue());
            }
            if (this.f8801u != null) {
                a += lu.m12373b(21, this.f8801u);
            }
            if (this.f8802v != null) {
                a += lu.m12385e(22, this.f8802v.longValue());
            }
            if (this.f8803w != null) {
                a += lu.m12371b(23, this.f8803w.intValue());
            }
            if (this.f8804x != null) {
                a += lu.m12373b(24, this.f8804x);
            }
            if (this.f8805y != null) {
                a += lu.m12373b(25, this.f8805y);
            }
            if (this.f8787g != null) {
                a += lu.m12385e(26, this.f8787g.longValue());
            }
            if (this.f8806z != null) {
                a += lu.m12374b(28, this.f8806z.booleanValue());
            }
            if (this.f8773A != null && this.f8773A.length > 0) {
                while (i2 < this.f8773A.length) {
                    mb mbVar3 = this.f8773A[i2];
                    if (mbVar3 != null) {
                        a += lu.m12378c(29, mbVar3);
                    }
                    i2++;
                }
            }
            if (this.f8774B != null) {
                a += lu.m12373b(30, this.f8774B);
            }
            if (this.f8775C != null) {
                a += lu.m12371b(31, this.f8775C.intValue());
            }
            if (this.f8776D != null) {
                a += lu.m12371b(32, this.f8776D.intValue());
            }
            if (this.f8777E != null) {
                a += lu.m12371b(33, this.f8777E.intValue());
            }
            if (this.f8778F != null) {
                a += lu.m12373b(34, this.f8778F);
            }
            if (this.f8779G != null) {
                a += lu.m12385e(35, this.f8779G.longValue());
            }
            return this.f8780H != null ? a + lu.m12385e(36, this.f8780H.longValue()) : a;
        }

        public C2843e m10539a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                int a2;
                Object obj;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f8781a = Integer.valueOf(ltVar.m12349g());
                        continue;
                    case 18:
                        a2 = me.m12506a(ltVar, 18);
                        a = this.f8782b == null ? 0 : this.f8782b.length;
                        obj = new C2840b[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f8782b, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C2840b();
                            ltVar.m12337a(obj[a]);
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = new C2840b();
                        ltVar.m12337a(obj[a]);
                        this.f8782b = obj;
                        continue;
                    case 26:
                        a2 = me.m12506a(ltVar, 26);
                        a = this.f8783c == null ? 0 : this.f8783c.length;
                        obj = new C2845g[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f8783c, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C2845g();
                            ltVar.m12337a(obj[a]);
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = new C2845g();
                        ltVar.m12337a(obj[a]);
                        this.f8783c = obj;
                        continue;
                    case 32:
                        this.f8784d = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 40:
                        this.f8785e = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 48:
                        this.f8786f = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 56:
                        this.f8788h = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 66:
                        this.f8789i = ltVar.m12351i();
                        continue;
                    case 74:
                        this.f8790j = ltVar.m12351i();
                        continue;
                    case 82:
                        this.f8791k = ltVar.m12351i();
                        continue;
                    case 90:
                        this.f8792l = ltVar.m12351i();
                        continue;
                    case 96:
                        this.f8793m = Integer.valueOf(ltVar.m12349g());
                        continue;
                    case 106:
                        this.f8794n = ltVar.m12351i();
                        continue;
                    case 114:
                        this.f8795o = ltVar.m12351i();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        this.f8796p = ltVar.m12351i();
                        continue;
                    case 136:
                        this.f8797q = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 144:
                        this.f8798r = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 154:
                        this.f8799s = ltVar.m12351i();
                        continue;
                    case 160:
                        this.f8800t = Boolean.valueOf(ltVar.m12350h());
                        continue;
                    case 170:
                        this.f8801u = ltVar.m12351i();
                        continue;
                    case 176:
                        this.f8802v = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 184:
                        this.f8803w = Integer.valueOf(ltVar.m12349g());
                        continue;
                    case 194:
                        this.f8804x = ltVar.m12351i();
                        continue;
                    case 202:
                        this.f8805y = ltVar.m12351i();
                        continue;
                    case 208:
                        this.f8787g = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 224:
                        this.f8806z = Boolean.valueOf(ltVar.m12350h());
                        continue;
                    case 234:
                        a2 = me.m12506a(ltVar, 234);
                        a = this.f8773A == null ? 0 : this.f8773A.length;
                        obj = new C2839a[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f8773A, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C2839a();
                            ltVar.m12337a(obj[a]);
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = new C2839a();
                        ltVar.m12337a(obj[a]);
                        this.f8773A = obj;
                        continue;
                    case 242:
                        this.f8774B = ltVar.m12351i();
                        continue;
                    case 248:
                        this.f8775C = Integer.valueOf(ltVar.m12349g());
                        continue;
                    case 256:
                        this.f8776D = Integer.valueOf(ltVar.m12349g());
                        continue;
                    case 264:
                        this.f8777E = Integer.valueOf(ltVar.m12349g());
                        continue;
                    case 274:
                        this.f8778F = ltVar.m12351i();
                        continue;
                    case 280:
                        this.f8779G = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 288:
                        this.f8780H = Long.valueOf(ltVar.m12347f());
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
            if (this.f8781a != null) {
                luVar.m12399a(1, this.f8781a.intValue());
            }
            if (this.f8782b != null && this.f8782b.length > 0) {
                for (mb mbVar : this.f8782b) {
                    if (mbVar != null) {
                        luVar.m12401a(2, mbVar);
                    }
                }
            }
            if (this.f8783c != null && this.f8783c.length > 0) {
                for (mb mbVar2 : this.f8783c) {
                    if (mbVar2 != null) {
                        luVar.m12401a(3, mbVar2);
                    }
                }
            }
            if (this.f8784d != null) {
                luVar.m12410b(4, this.f8784d.longValue());
            }
            if (this.f8785e != null) {
                luVar.m12410b(5, this.f8785e.longValue());
            }
            if (this.f8786f != null) {
                luVar.m12410b(6, this.f8786f.longValue());
            }
            if (this.f8788h != null) {
                luVar.m12410b(7, this.f8788h.longValue());
            }
            if (this.f8789i != null) {
                luVar.m12402a(8, this.f8789i);
            }
            if (this.f8790j != null) {
                luVar.m12402a(9, this.f8790j);
            }
            if (this.f8791k != null) {
                luVar.m12402a(10, this.f8791k);
            }
            if (this.f8792l != null) {
                luVar.m12402a(11, this.f8792l);
            }
            if (this.f8793m != null) {
                luVar.m12399a(12, this.f8793m.intValue());
            }
            if (this.f8794n != null) {
                luVar.m12402a(13, this.f8794n);
            }
            if (this.f8795o != null) {
                luVar.m12402a(14, this.f8795o);
            }
            if (this.f8796p != null) {
                luVar.m12402a(16, this.f8796p);
            }
            if (this.f8797q != null) {
                luVar.m12410b(17, this.f8797q.longValue());
            }
            if (this.f8798r != null) {
                luVar.m12410b(18, this.f8798r.longValue());
            }
            if (this.f8799s != null) {
                luVar.m12402a(19, this.f8799s);
            }
            if (this.f8800t != null) {
                luVar.m12403a(20, this.f8800t.booleanValue());
            }
            if (this.f8801u != null) {
                luVar.m12402a(21, this.f8801u);
            }
            if (this.f8802v != null) {
                luVar.m12410b(22, this.f8802v.longValue());
            }
            if (this.f8803w != null) {
                luVar.m12399a(23, this.f8803w.intValue());
            }
            if (this.f8804x != null) {
                luVar.m12402a(24, this.f8804x);
            }
            if (this.f8805y != null) {
                luVar.m12402a(25, this.f8805y);
            }
            if (this.f8787g != null) {
                luVar.m12410b(26, this.f8787g.longValue());
            }
            if (this.f8806z != null) {
                luVar.m12403a(28, this.f8806z.booleanValue());
            }
            if (this.f8773A != null && this.f8773A.length > 0) {
                while (i < this.f8773A.length) {
                    mb mbVar3 = this.f8773A[i];
                    if (mbVar3 != null) {
                        luVar.m12401a(29, mbVar3);
                    }
                    i++;
                }
            }
            if (this.f8774B != null) {
                luVar.m12402a(30, this.f8774B);
            }
            if (this.f8775C != null) {
                luVar.m12399a(31, this.f8775C.intValue());
            }
            if (this.f8776D != null) {
                luVar.m12399a(32, this.f8776D.intValue());
            }
            if (this.f8777E != null) {
                luVar.m12399a(33, this.f8777E.intValue());
            }
            if (this.f8778F != null) {
                luVar.m12402a(34, this.f8778F);
            }
            if (this.f8779G != null) {
                luVar.m12410b(35, this.f8779G.longValue());
            }
            if (this.f8780H != null) {
                luVar.m12410b(36, this.f8780H.longValue());
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m10539a(ltVar);
        }

        public C2843e m10542c() {
            this.f8781a = null;
            this.f8782b = C2840b.m10520b();
            this.f8783c = C2845g.m10548b();
            this.f8784d = null;
            this.f8785e = null;
            this.f8786f = null;
            this.f8787g = null;
            this.f8788h = null;
            this.f8789i = null;
            this.f8790j = null;
            this.f8791k = null;
            this.f8792l = null;
            this.f8793m = null;
            this.f8794n = null;
            this.f8795o = null;
            this.f8796p = null;
            this.f8797q = null;
            this.f8798r = null;
            this.f8799s = null;
            this.f8800t = null;
            this.f8801u = null;
            this.f8802v = null;
            this.f8803w = null;
            this.f8804x = null;
            this.f8805y = null;
            this.f8806z = null;
            this.f8773A = C2839a.m10514b();
            this.f8774B = null;
            this.f8775C = null;
            this.f8776D = null;
            this.f8777E = null;
            this.f8778F = null;
            this.f8779G = null;
            this.f8780H = null;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C2843e)) {
                return false;
            }
            C2843e c2843e = (C2843e) obj;
            if (this.f8781a == null) {
                if (c2843e.f8781a != null) {
                    return false;
                }
            } else if (!this.f8781a.equals(c2843e.f8781a)) {
                return false;
            }
            if (!lz.m12453a(this.f8782b, c2843e.f8782b) || !lz.m12453a(this.f8783c, c2843e.f8783c)) {
                return false;
            }
            if (this.f8784d == null) {
                if (c2843e.f8784d != null) {
                    return false;
                }
            } else if (!this.f8784d.equals(c2843e.f8784d)) {
                return false;
            }
            if (this.f8785e == null) {
                if (c2843e.f8785e != null) {
                    return false;
                }
            } else if (!this.f8785e.equals(c2843e.f8785e)) {
                return false;
            }
            if (this.f8786f == null) {
                if (c2843e.f8786f != null) {
                    return false;
                }
            } else if (!this.f8786f.equals(c2843e.f8786f)) {
                return false;
            }
            if (this.f8787g == null) {
                if (c2843e.f8787g != null) {
                    return false;
                }
            } else if (!this.f8787g.equals(c2843e.f8787g)) {
                return false;
            }
            if (this.f8788h == null) {
                if (c2843e.f8788h != null) {
                    return false;
                }
            } else if (!this.f8788h.equals(c2843e.f8788h)) {
                return false;
            }
            if (this.f8789i == null) {
                if (c2843e.f8789i != null) {
                    return false;
                }
            } else if (!this.f8789i.equals(c2843e.f8789i)) {
                return false;
            }
            if (this.f8790j == null) {
                if (c2843e.f8790j != null) {
                    return false;
                }
            } else if (!this.f8790j.equals(c2843e.f8790j)) {
                return false;
            }
            if (this.f8791k == null) {
                if (c2843e.f8791k != null) {
                    return false;
                }
            } else if (!this.f8791k.equals(c2843e.f8791k)) {
                return false;
            }
            if (this.f8792l == null) {
                if (c2843e.f8792l != null) {
                    return false;
                }
            } else if (!this.f8792l.equals(c2843e.f8792l)) {
                return false;
            }
            if (this.f8793m == null) {
                if (c2843e.f8793m != null) {
                    return false;
                }
            } else if (!this.f8793m.equals(c2843e.f8793m)) {
                return false;
            }
            if (this.f8794n == null) {
                if (c2843e.f8794n != null) {
                    return false;
                }
            } else if (!this.f8794n.equals(c2843e.f8794n)) {
                return false;
            }
            if (this.f8795o == null) {
                if (c2843e.f8795o != null) {
                    return false;
                }
            } else if (!this.f8795o.equals(c2843e.f8795o)) {
                return false;
            }
            if (this.f8796p == null) {
                if (c2843e.f8796p != null) {
                    return false;
                }
            } else if (!this.f8796p.equals(c2843e.f8796p)) {
                return false;
            }
            if (this.f8797q == null) {
                if (c2843e.f8797q != null) {
                    return false;
                }
            } else if (!this.f8797q.equals(c2843e.f8797q)) {
                return false;
            }
            if (this.f8798r == null) {
                if (c2843e.f8798r != null) {
                    return false;
                }
            } else if (!this.f8798r.equals(c2843e.f8798r)) {
                return false;
            }
            if (this.f8799s == null) {
                if (c2843e.f8799s != null) {
                    return false;
                }
            } else if (!this.f8799s.equals(c2843e.f8799s)) {
                return false;
            }
            if (this.f8800t == null) {
                if (c2843e.f8800t != null) {
                    return false;
                }
            } else if (!this.f8800t.equals(c2843e.f8800t)) {
                return false;
            }
            if (this.f8801u == null) {
                if (c2843e.f8801u != null) {
                    return false;
                }
            } else if (!this.f8801u.equals(c2843e.f8801u)) {
                return false;
            }
            if (this.f8802v == null) {
                if (c2843e.f8802v != null) {
                    return false;
                }
            } else if (!this.f8802v.equals(c2843e.f8802v)) {
                return false;
            }
            if (this.f8803w == null) {
                if (c2843e.f8803w != null) {
                    return false;
                }
            } else if (!this.f8803w.equals(c2843e.f8803w)) {
                return false;
            }
            if (this.f8804x == null) {
                if (c2843e.f8804x != null) {
                    return false;
                }
            } else if (!this.f8804x.equals(c2843e.f8804x)) {
                return false;
            }
            if (this.f8805y == null) {
                if (c2843e.f8805y != null) {
                    return false;
                }
            } else if (!this.f8805y.equals(c2843e.f8805y)) {
                return false;
            }
            if (this.f8806z == null) {
                if (c2843e.f8806z != null) {
                    return false;
                }
            } else if (!this.f8806z.equals(c2843e.f8806z)) {
                return false;
            }
            if (!lz.m12453a(this.f8773A, c2843e.f8773A)) {
                return false;
            }
            if (this.f8774B == null) {
                if (c2843e.f8774B != null) {
                    return false;
                }
            } else if (!this.f8774B.equals(c2843e.f8774B)) {
                return false;
            }
            if (this.f8775C == null) {
                if (c2843e.f8775C != null) {
                    return false;
                }
            } else if (!this.f8775C.equals(c2843e.f8775C)) {
                return false;
            }
            if (this.f8776D == null) {
                if (c2843e.f8776D != null) {
                    return false;
                }
            } else if (!this.f8776D.equals(c2843e.f8776D)) {
                return false;
            }
            if (this.f8777E == null) {
                if (c2843e.f8777E != null) {
                    return false;
                }
            } else if (!this.f8777E.equals(c2843e.f8777E)) {
                return false;
            }
            if (this.f8778F == null) {
                if (c2843e.f8778F != null) {
                    return false;
                }
            } else if (!this.f8778F.equals(c2843e.f8778F)) {
                return false;
            }
            if (this.f8779G == null) {
                if (c2843e.f8779G != null) {
                    return false;
                }
            } else if (!this.f8779G.equals(c2843e.f8779G)) {
                return false;
            }
            if (this.f8780H == null) {
                if (c2843e.f8780H != null) {
                    return false;
                }
            } else if (!this.f8780H.equals(c2843e.f8780H)) {
                return false;
            }
            return (this.ag == null || this.ag.m12439b()) ? c2843e.ag == null || c2843e.ag.m12439b() : this.ag.equals(c2843e.ag);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f8780H == null ? 0 : this.f8780H.hashCode()) + (((this.f8779G == null ? 0 : this.f8779G.hashCode()) + (((this.f8778F == null ? 0 : this.f8778F.hashCode()) + (((this.f8777E == null ? 0 : this.f8777E.hashCode()) + (((this.f8776D == null ? 0 : this.f8776D.hashCode()) + (((this.f8775C == null ? 0 : this.f8775C.hashCode()) + (((this.f8774B == null ? 0 : this.f8774B.hashCode()) + (((((this.f8806z == null ? 0 : this.f8806z.hashCode()) + (((this.f8805y == null ? 0 : this.f8805y.hashCode()) + (((this.f8804x == null ? 0 : this.f8804x.hashCode()) + (((this.f8803w == null ? 0 : this.f8803w.hashCode()) + (((this.f8802v == null ? 0 : this.f8802v.hashCode()) + (((this.f8801u == null ? 0 : this.f8801u.hashCode()) + (((this.f8800t == null ? 0 : this.f8800t.hashCode()) + (((this.f8799s == null ? 0 : this.f8799s.hashCode()) + (((this.f8798r == null ? 0 : this.f8798r.hashCode()) + (((this.f8797q == null ? 0 : this.f8797q.hashCode()) + (((this.f8796p == null ? 0 : this.f8796p.hashCode()) + (((this.f8795o == null ? 0 : this.f8795o.hashCode()) + (((this.f8794n == null ? 0 : this.f8794n.hashCode()) + (((this.f8793m == null ? 0 : this.f8793m.hashCode()) + (((this.f8792l == null ? 0 : this.f8792l.hashCode()) + (((this.f8791k == null ? 0 : this.f8791k.hashCode()) + (((this.f8790j == null ? 0 : this.f8790j.hashCode()) + (((this.f8789i == null ? 0 : this.f8789i.hashCode()) + (((this.f8788h == null ? 0 : this.f8788h.hashCode()) + (((this.f8787g == null ? 0 : this.f8787g.hashCode()) + (((this.f8786f == null ? 0 : this.f8786f.hashCode()) + (((this.f8785e == null ? 0 : this.f8785e.hashCode()) + (((this.f8784d == null ? 0 : this.f8784d.hashCode()) + (((((((this.f8781a == null ? 0 : this.f8781a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + lz.m12448a(this.f8782b)) * 31) + lz.m12448a(this.f8783c)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + lz.m12448a(this.f8773A)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (!(this.ag == null || this.ag.m12439b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C2844f extends lv<C2844f> {
        public long[] f8807a;
        public long[] f8808b;

        public C2844f() {
            m10546b();
        }

        protected int mo3505a() {
            int i;
            int i2;
            int i3 = 0;
            int a = super.mo3505a();
            if (this.f8807a == null || this.f8807a.length <= 0) {
                i = a;
            } else {
                i2 = 0;
                for (long d : this.f8807a) {
                    i2 += lu.m12383d(d);
                }
                i = (a + i2) + (this.f8807a.length * 1);
            }
            if (this.f8808b == null || this.f8808b.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i3 < this.f8808b.length) {
                i2 += lu.m12383d(this.f8808b[i3]);
                i3++;
            }
            return (i + i2) + (this.f8808b.length * 1);
        }

        public C2844f m10544a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                int a2;
                Object obj;
                int c;
                Object obj2;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        a2 = me.m12506a(ltVar, 8);
                        a = this.f8807a == null ? 0 : this.f8807a.length;
                        obj = new long[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f8807a, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = ltVar.m12345e();
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = ltVar.m12345e();
                        this.f8807a = obj;
                        continue;
                    case 10:
                        c = ltVar.m12342c(ltVar.m12354l());
                        a2 = ltVar.m12360r();
                        a = 0;
                        while (ltVar.m12358p() > 0) {
                            ltVar.m12345e();
                            a++;
                        }
                        ltVar.m12346e(a2);
                        a2 = this.f8807a == null ? 0 : this.f8807a.length;
                        obj2 = new long[(a + a2)];
                        if (a2 != 0) {
                            System.arraycopy(this.f8807a, 0, obj2, 0, a2);
                        }
                        while (a2 < obj2.length) {
                            obj2[a2] = ltVar.m12345e();
                            a2++;
                        }
                        this.f8807a = obj2;
                        ltVar.m12344d(c);
                        continue;
                    case 16:
                        a2 = me.m12506a(ltVar, 16);
                        a = this.f8808b == null ? 0 : this.f8808b.length;
                        obj = new long[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f8808b, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = ltVar.m12345e();
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = ltVar.m12345e();
                        this.f8808b = obj;
                        continue;
                    case 18:
                        c = ltVar.m12342c(ltVar.m12354l());
                        a2 = ltVar.m12360r();
                        a = 0;
                        while (ltVar.m12358p() > 0) {
                            ltVar.m12345e();
                            a++;
                        }
                        ltVar.m12346e(a2);
                        a2 = this.f8808b == null ? 0 : this.f8808b.length;
                        obj2 = new long[(a + a2)];
                        if (a2 != 0) {
                            System.arraycopy(this.f8808b, 0, obj2, 0, a2);
                        }
                        while (a2 < obj2.length) {
                            obj2[a2] = ltVar.m12345e();
                            a2++;
                        }
                        this.f8808b = obj2;
                        ltVar.m12344d(c);
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
            if (this.f8807a != null && this.f8807a.length > 0) {
                for (long a : this.f8807a) {
                    luVar.m12400a(1, a);
                }
            }
            if (this.f8808b != null && this.f8808b.length > 0) {
                while (i < this.f8808b.length) {
                    luVar.m12400a(2, this.f8808b[i]);
                    i++;
                }
            }
            super.mo3506a(luVar);
        }

        public C2844f m10546b() {
            this.f8807a = me.f9778f;
            this.f8808b = me.f9778f;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m10544a(ltVar);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C2844f)) {
                return false;
            }
            C2844f c2844f = (C2844f) obj;
            return (lz.m12452a(this.f8807a, c2844f.f8807a) && lz.m12452a(this.f8808b, c2844f.f8808b)) ? (this.ag == null || this.ag.m12439b()) ? c2844f.ag == null || c2844f.ag.m12439b() : this.ag.equals(c2844f.ag) : false;
        }

        public int hashCode() {
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + lz.m12447a(this.f8807a)) * 31) + lz.m12447a(this.f8808b)) * 31;
            int hashCode2 = (this.ag == null || this.ag.m12439b()) ? 0 : this.ag.hashCode();
            return hashCode2 + hashCode;
        }
    }

    public static final class C2845g extends lv<C2845g> {
        private static volatile C2845g[] f8809g;
        public Long f8810a;
        public String f8811b;
        public String f8812c;
        public Long f8813d;
        public Float f8814e;
        public Double f8815f;

        public C2845g() {
            m10553c();
        }

        public static C2845g[] m10548b() {
            if (f8809g == null) {
                synchronized (lz.f9749c) {
                    if (f8809g == null) {
                        f8809g = new C2845g[0];
                    }
                }
            }
            return f8809g;
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f8810a != null) {
                a += lu.m12385e(1, this.f8810a.longValue());
            }
            if (this.f8811b != null) {
                a += lu.m12373b(2, this.f8811b);
            }
            if (this.f8812c != null) {
                a += lu.m12373b(3, this.f8812c);
            }
            if (this.f8813d != null) {
                a += lu.m12385e(4, this.f8813d.longValue());
            }
            if (this.f8814e != null) {
                a += lu.m12370b(5, this.f8814e.floatValue());
            }
            return this.f8815f != null ? a + lu.m12369b(6, this.f8815f.doubleValue()) : a;
        }

        public C2845g m10550a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f8810a = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 18:
                        this.f8811b = ltVar.m12351i();
                        continue;
                    case 26:
                        this.f8812c = ltVar.m12351i();
                        continue;
                    case 32:
                        this.f8813d = Long.valueOf(ltVar.m12347f());
                        continue;
                    case 45:
                        this.f8814e = Float.valueOf(ltVar.m12343d());
                        continue;
                    case 49:
                        this.f8815f = Double.valueOf(ltVar.m12341c());
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
            if (this.f8810a != null) {
                luVar.m12410b(1, this.f8810a.longValue());
            }
            if (this.f8811b != null) {
                luVar.m12402a(2, this.f8811b);
            }
            if (this.f8812c != null) {
                luVar.m12402a(3, this.f8812c);
            }
            if (this.f8813d != null) {
                luVar.m12410b(4, this.f8813d.longValue());
            }
            if (this.f8814e != null) {
                luVar.m12398a(5, this.f8814e.floatValue());
            }
            if (this.f8815f != null) {
                luVar.m12397a(6, this.f8815f.doubleValue());
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m10550a(ltVar);
        }

        public C2845g m10553c() {
            this.f8810a = null;
            this.f8811b = null;
            this.f8812c = null;
            this.f8813d = null;
            this.f8814e = null;
            this.f8815f = null;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C2845g)) {
                return false;
            }
            C2845g c2845g = (C2845g) obj;
            if (this.f8810a == null) {
                if (c2845g.f8810a != null) {
                    return false;
                }
            } else if (!this.f8810a.equals(c2845g.f8810a)) {
                return false;
            }
            if (this.f8811b == null) {
                if (c2845g.f8811b != null) {
                    return false;
                }
            } else if (!this.f8811b.equals(c2845g.f8811b)) {
                return false;
            }
            if (this.f8812c == null) {
                if (c2845g.f8812c != null) {
                    return false;
                }
            } else if (!this.f8812c.equals(c2845g.f8812c)) {
                return false;
            }
            if (this.f8813d == null) {
                if (c2845g.f8813d != null) {
                    return false;
                }
            } else if (!this.f8813d.equals(c2845g.f8813d)) {
                return false;
            }
            if (this.f8814e == null) {
                if (c2845g.f8814e != null) {
                    return false;
                }
            } else if (!this.f8814e.equals(c2845g.f8814e)) {
                return false;
            }
            if (this.f8815f == null) {
                if (c2845g.f8815f != null) {
                    return false;
                }
            } else if (!this.f8815f.equals(c2845g.f8815f)) {
                return false;
            }
            return (this.ag == null || this.ag.m12439b()) ? c2845g.ag == null || c2845g.ag.m12439b() : this.ag.equals(c2845g.ag);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f8815f == null ? 0 : this.f8815f.hashCode()) + (((this.f8814e == null ? 0 : this.f8814e.hashCode()) + (((this.f8813d == null ? 0 : this.f8813d.hashCode()) + (((this.f8812c == null ? 0 : this.f8812c.hashCode()) + (((this.f8811b == null ? 0 : this.f8811b.hashCode()) + (((this.f8810a == null ? 0 : this.f8810a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (!(this.ag == null || this.ag.m12439b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }
}
