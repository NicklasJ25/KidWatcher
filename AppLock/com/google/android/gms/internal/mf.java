package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.util.Arrays;

public interface mf {

    public static final class C3050a extends lv<C3050a> implements Cloneable {
        public String[] f9785a;
        public String[] f9786b;
        public int[] f9787c;
        public long[] f9788d;
        public long[] f9789e;

        public C3050a() {
            m12512b();
        }

        protected int mo3505a() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int a = super.mo3505a();
            if (this.f9785a == null || this.f9785a.length <= 0) {
                i = a;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.f9785a) {
                    if (str != null) {
                        i3++;
                        i2 += lu.m12376b(str);
                    }
                }
                i = (a + i2) + (i3 * 1);
            }
            if (this.f9786b != null && this.f9786b.length > 0) {
                i3 = 0;
                a = 0;
                for (String str2 : this.f9786b) {
                    if (str2 != null) {
                        a++;
                        i3 += lu.m12376b(str2);
                    }
                }
                i = (i + i3) + (a * 1);
            }
            if (this.f9787c != null && this.f9787c.length > 0) {
                i3 = 0;
                for (int a2 : this.f9787c) {
                    i3 += lu.m12368b(a2);
                }
                i = (i + i3) + (this.f9787c.length * 1);
            }
            if (this.f9788d != null && this.f9788d.length > 0) {
                i3 = 0;
                for (long e : this.f9788d) {
                    i3 += lu.m12386e(e);
                }
                i = (i + i3) + (this.f9788d.length * 1);
            }
            if (this.f9789e == null || this.f9789e.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i4 < this.f9789e.length) {
                i2 += lu.m12386e(this.f9789e[i4]);
                i4++;
            }
            return (i + i2) + (this.f9789e.length * 1);
        }

        public C3050a m12509a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                int a2;
                Object obj;
                int c;
                Object obj2;
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        a2 = me.m12506a(ltVar, 10);
                        a = this.f9785a == null ? 0 : this.f9785a.length;
                        obj = new String[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f9785a, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = ltVar.m12351i();
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = ltVar.m12351i();
                        this.f9785a = obj;
                        continue;
                    case 18:
                        a2 = me.m12506a(ltVar, 18);
                        a = this.f9786b == null ? 0 : this.f9786b.length;
                        obj = new String[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f9786b, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = ltVar.m12351i();
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = ltVar.m12351i();
                        this.f9786b = obj;
                        continue;
                    case 24:
                        a2 = me.m12506a(ltVar, 24);
                        a = this.f9787c == null ? 0 : this.f9787c.length;
                        obj = new int[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f9787c, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = ltVar.m12349g();
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = ltVar.m12349g();
                        this.f9787c = obj;
                        continue;
                    case 26:
                        c = ltVar.m12342c(ltVar.m12354l());
                        a2 = ltVar.m12360r();
                        a = 0;
                        while (ltVar.m12358p() > 0) {
                            ltVar.m12349g();
                            a++;
                        }
                        ltVar.m12346e(a2);
                        a2 = this.f9787c == null ? 0 : this.f9787c.length;
                        obj2 = new int[(a + a2)];
                        if (a2 != 0) {
                            System.arraycopy(this.f9787c, 0, obj2, 0, a2);
                        }
                        while (a2 < obj2.length) {
                            obj2[a2] = ltVar.m12349g();
                            a2++;
                        }
                        this.f9787c = obj2;
                        ltVar.m12344d(c);
                        continue;
                    case 32:
                        a2 = me.m12506a(ltVar, 32);
                        a = this.f9788d == null ? 0 : this.f9788d.length;
                        obj = new long[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f9788d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = ltVar.m12347f();
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = ltVar.m12347f();
                        this.f9788d = obj;
                        continue;
                    case 34:
                        c = ltVar.m12342c(ltVar.m12354l());
                        a2 = ltVar.m12360r();
                        a = 0;
                        while (ltVar.m12358p() > 0) {
                            ltVar.m12347f();
                            a++;
                        }
                        ltVar.m12346e(a2);
                        a2 = this.f9788d == null ? 0 : this.f9788d.length;
                        obj2 = new long[(a + a2)];
                        if (a2 != 0) {
                            System.arraycopy(this.f9788d, 0, obj2, 0, a2);
                        }
                        while (a2 < obj2.length) {
                            obj2[a2] = ltVar.m12347f();
                            a2++;
                        }
                        this.f9788d = obj2;
                        ltVar.m12344d(c);
                        continue;
                    case 40:
                        a2 = me.m12506a(ltVar, 40);
                        a = this.f9789e == null ? 0 : this.f9789e.length;
                        obj = new long[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f9789e, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = ltVar.m12347f();
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = ltVar.m12347f();
                        this.f9789e = obj;
                        continue;
                    case 42:
                        c = ltVar.m12342c(ltVar.m12354l());
                        a2 = ltVar.m12360r();
                        a = 0;
                        while (ltVar.m12358p() > 0) {
                            ltVar.m12347f();
                            a++;
                        }
                        ltVar.m12346e(a2);
                        a2 = this.f9789e == null ? 0 : this.f9789e.length;
                        obj2 = new long[(a + a2)];
                        if (a2 != 0) {
                            System.arraycopy(this.f9789e, 0, obj2, 0, a2);
                        }
                        while (a2 < obj2.length) {
                            obj2[a2] = ltVar.m12347f();
                            a2++;
                        }
                        this.f9789e = obj2;
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
            if (this.f9785a != null && this.f9785a.length > 0) {
                for (String str : this.f9785a) {
                    if (str != null) {
                        luVar.m12402a(1, str);
                    }
                }
            }
            if (this.f9786b != null && this.f9786b.length > 0) {
                for (String str2 : this.f9786b) {
                    if (str2 != null) {
                        luVar.m12402a(2, str2);
                    }
                }
            }
            if (this.f9787c != null && this.f9787c.length > 0) {
                for (int a : this.f9787c) {
                    luVar.m12399a(3, a);
                }
            }
            if (this.f9788d != null && this.f9788d.length > 0) {
                for (long b : this.f9788d) {
                    luVar.m12410b(4, b);
                }
            }
            if (this.f9789e != null && this.f9789e.length > 0) {
                while (i < this.f9789e.length) {
                    luVar.m12410b(5, this.f9789e[i]);
                    i++;
                }
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m12509a(ltVar);
        }

        public C3050a m12512b() {
            this.f9785a = me.f9782j;
            this.f9786b = me.f9782j;
            this.f9787c = me.f9777e;
            this.f9788d = me.f9778f;
            this.f9789e = me.f9778f;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public C3050a m12513c() {
            try {
                C3050a c3050a = (C3050a) super.mo3819d();
                if (this.f9785a != null && this.f9785a.length > 0) {
                    c3050a.f9785a = (String[]) this.f9785a.clone();
                }
                if (this.f9786b != null && this.f9786b.length > 0) {
                    c3050a.f9786b = (String[]) this.f9786b.clone();
                }
                if (this.f9787c != null && this.f9787c.length > 0) {
                    c3050a.f9787c = (int[]) this.f9787c.clone();
                }
                if (this.f9788d != null && this.f9788d.length > 0) {
                    c3050a.f9788d = (long[]) this.f9788d.clone();
                }
                if (this.f9789e != null && this.f9789e.length > 0) {
                    c3050a.f9789e = (long[]) this.f9789e.clone();
                }
                return c3050a;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public /* synthetic */ Object clone() {
            return m12513c();
        }

        public /* synthetic */ lv mo3819d() {
            return (C3050a) clone();
        }

        public /* synthetic */ mb mo3508e() {
            return (C3050a) clone();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C3050a)) {
                return false;
            }
            C3050a c3050a = (C3050a) obj;
            return (lz.m12453a(this.f9785a, c3050a.f9785a) && lz.m12453a(this.f9786b, c3050a.f9786b) && lz.m12451a(this.f9787c, c3050a.f9787c) && lz.m12452a(this.f9788d, c3050a.f9788d) && lz.m12452a(this.f9789e, c3050a.f9789e)) ? (this.ag == null || this.ag.m12439b()) ? c3050a.ag == null || c3050a.ag.m12439b() : this.ag.equals(c3050a.ag) : false;
        }

        public int hashCode() {
            int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + lz.m12448a(this.f9785a)) * 31) + lz.m12448a(this.f9786b)) * 31) + lz.m12446a(this.f9787c)) * 31) + lz.m12447a(this.f9788d)) * 31) + lz.m12447a(this.f9789e)) * 31;
            int hashCode2 = (this.ag == null || this.ag.m12439b()) ? 0 : this.ag.hashCode();
            return hashCode2 + hashCode;
        }
    }

    public static final class C3051b extends lv<C3051b> implements Cloneable {
        public int f9790a;
        public String f9791b;
        public String f9792c;

        public C3051b() {
            m12520b();
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f9790a != 0) {
                a += lu.m12371b(1, this.f9790a);
            }
            if (!(this.f9791b == null || this.f9791b.equals(""))) {
                a += lu.m12373b(2, this.f9791b);
            }
            return (this.f9792c == null || this.f9792c.equals("")) ? a : a + lu.m12373b(3, this.f9792c);
        }

        public C3051b m12517a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f9790a = ltVar.m12349g();
                        continue;
                    case 18:
                        this.f9791b = ltVar.m12351i();
                        continue;
                    case 26:
                        this.f9792c = ltVar.m12351i();
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
            if (this.f9790a != 0) {
                luVar.m12399a(1, this.f9790a);
            }
            if (!(this.f9791b == null || this.f9791b.equals(""))) {
                luVar.m12402a(2, this.f9791b);
            }
            if (!(this.f9792c == null || this.f9792c.equals(""))) {
                luVar.m12402a(3, this.f9792c);
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m12517a(ltVar);
        }

        public C3051b m12520b() {
            this.f9790a = 0;
            this.f9791b = "";
            this.f9792c = "";
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public C3051b m12521c() {
            try {
                return (C3051b) super.mo3819d();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public /* synthetic */ Object clone() {
            return m12521c();
        }

        public /* synthetic */ lv mo3819d() {
            return (C3051b) clone();
        }

        public /* synthetic */ mb mo3508e() {
            return (C3051b) clone();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C3051b)) {
                return false;
            }
            C3051b c3051b = (C3051b) obj;
            if (this.f9790a != c3051b.f9790a) {
                return false;
            }
            if (this.f9791b == null) {
                if (c3051b.f9791b != null) {
                    return false;
                }
            } else if (!this.f9791b.equals(c3051b.f9791b)) {
                return false;
            }
            if (this.f9792c == null) {
                if (c3051b.f9792c != null) {
                    return false;
                }
            } else if (!this.f9792c.equals(c3051b.f9792c)) {
                return false;
            }
            return (this.ag == null || this.ag.m12439b()) ? c3051b.ag == null || c3051b.ag.m12439b() : this.ag.equals(c3051b.ag);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f9792c == null ? 0 : this.f9792c.hashCode()) + (((this.f9791b == null ? 0 : this.f9791b.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.f9790a) * 31)) * 31)) * 31;
            if (!(this.ag == null || this.ag.m12439b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C3052c extends lv<C3052c> implements Cloneable {
        public byte[] f9793a;
        public String f9794b;
        public byte[][] f9795c;
        public boolean f9796d;

        public C3052c() {
            m12528b();
        }

        protected int mo3505a() {
            int i = 0;
            int a = super.mo3505a();
            if (!Arrays.equals(this.f9793a, me.f9784l)) {
                a += lu.m12375b(1, this.f9793a);
            }
            if (this.f9795c != null && this.f9795c.length > 0) {
                int i2 = 0;
                int i3 = 0;
                while (i < this.f9795c.length) {
                    byte[] bArr = this.f9795c[i];
                    if (bArr != null) {
                        i3++;
                        i2 += lu.m12380c(bArr);
                    }
                    i++;
                }
                a = (a + i2) + (i3 * 1);
            }
            if (this.f9796d) {
                a += lu.m12374b(3, this.f9796d);
            }
            return (this.f9794b == null || this.f9794b.equals("")) ? a : a + lu.m12373b(4, this.f9794b);
        }

        public C3052c m12525a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f9793a = ltVar.m12352j();
                        continue;
                    case 18:
                        int a2 = me.m12506a(ltVar, 18);
                        a = this.f9795c == null ? 0 : this.f9795c.length;
                        Object obj = new byte[(a2 + a)][];
                        if (a != 0) {
                            System.arraycopy(this.f9795c, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = ltVar.m12352j();
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = ltVar.m12352j();
                        this.f9795c = obj;
                        continue;
                    case 24:
                        this.f9796d = ltVar.m12350h();
                        continue;
                    case 34:
                        this.f9794b = ltVar.m12351i();
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
            if (!Arrays.equals(this.f9793a, me.f9784l)) {
                luVar.m12404a(1, this.f9793a);
            }
            if (this.f9795c != null && this.f9795c.length > 0) {
                for (byte[] bArr : this.f9795c) {
                    if (bArr != null) {
                        luVar.m12404a(2, bArr);
                    }
                }
            }
            if (this.f9796d) {
                luVar.m12403a(3, this.f9796d);
            }
            if (!(this.f9794b == null || this.f9794b.equals(""))) {
                luVar.m12402a(4, this.f9794b);
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m12525a(ltVar);
        }

        public C3052c m12528b() {
            this.f9793a = me.f9784l;
            this.f9794b = "";
            this.f9795c = me.f9783k;
            this.f9796d = false;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public C3052c m12529c() {
            try {
                C3052c c3052c = (C3052c) super.mo3819d();
                if (this.f9795c != null && this.f9795c.length > 0) {
                    c3052c.f9795c = (byte[][]) this.f9795c.clone();
                }
                return c3052c;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public /* synthetic */ Object clone() {
            return m12529c();
        }

        public /* synthetic */ lv mo3819d() {
            return (C3052c) clone();
        }

        public /* synthetic */ mb mo3508e() {
            return (C3052c) clone();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C3052c)) {
                return false;
            }
            C3052c c3052c = (C3052c) obj;
            if (!Arrays.equals(this.f9793a, c3052c.f9793a)) {
                return false;
            }
            if (this.f9794b == null) {
                if (c3052c.f9794b != null) {
                    return false;
                }
            } else if (!this.f9794b.equals(c3052c.f9794b)) {
                return false;
            }
            return (lz.m12454a(this.f9795c, c3052c.f9795c) && this.f9796d == c3052c.f9796d) ? (this.ag == null || this.ag.m12439b()) ? c3052c.ag == null || c3052c.ag.m12439b() : this.ag.equals(c3052c.ag) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f9796d ? 1231 : 1237) + (((((this.f9794b == null ? 0 : this.f9794b.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.f9793a)) * 31)) * 31) + lz.m12449a(this.f9795c)) * 31)) * 31;
            if (!(this.ag == null || this.ag.m12439b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C3053d extends lv<C3053d> implements Cloneable {
        public long f9797a;
        public long f9798b;
        public long f9799c;
        public String f9800d;
        public int f9801e;
        public int f9802f;
        public boolean f9803g;
        public C3054e[] f9804h;
        public byte[] f9805i;
        public C3051b f9806j;
        public byte[] f9807k;
        public String f9808l;
        public String f9809m;
        public C3050a f9810n;
        public String f9811o;
        public long f9812p;
        public C3052c f9813q;
        public byte[] f9814r;
        public String f9815s;
        public int f9816t;
        public int[] f9817u;
        public long f9818v;
        public C3055f f9819w;

        public C3053d() {
            m12536b();
        }

        protected int mo3505a() {
            int i;
            int i2 = 0;
            int a = super.mo3505a();
            if (this.f9797a != 0) {
                a += lu.m12385e(1, this.f9797a);
            }
            if (!(this.f9800d == null || this.f9800d.equals(""))) {
                a += lu.m12373b(2, this.f9800d);
            }
            if (this.f9804h != null && this.f9804h.length > 0) {
                i = a;
                for (mb mbVar : this.f9804h) {
                    if (mbVar != null) {
                        i += lu.m12378c(3, mbVar);
                    }
                }
                a = i;
            }
            if (!Arrays.equals(this.f9805i, me.f9784l)) {
                a += lu.m12375b(4, this.f9805i);
            }
            if (!Arrays.equals(this.f9807k, me.f9784l)) {
                a += lu.m12375b(6, this.f9807k);
            }
            if (this.f9810n != null) {
                a += lu.m12378c(7, this.f9810n);
            }
            if (!(this.f9808l == null || this.f9808l.equals(""))) {
                a += lu.m12373b(8, this.f9808l);
            }
            if (this.f9806j != null) {
                a += lu.m12378c(9, this.f9806j);
            }
            if (this.f9803g) {
                a += lu.m12374b(10, this.f9803g);
            }
            if (this.f9801e != 0) {
                a += lu.m12371b(11, this.f9801e);
            }
            if (this.f9802f != 0) {
                a += lu.m12371b(12, this.f9802f);
            }
            if (!(this.f9809m == null || this.f9809m.equals(""))) {
                a += lu.m12373b(13, this.f9809m);
            }
            if (!(this.f9811o == null || this.f9811o.equals(""))) {
                a += lu.m12373b(14, this.f9811o);
            }
            if (this.f9812p != 180000) {
                a += lu.m12388f(15, this.f9812p);
            }
            if (this.f9813q != null) {
                a += lu.m12378c(16, this.f9813q);
            }
            if (this.f9798b != 0) {
                a += lu.m12385e(17, this.f9798b);
            }
            if (!Arrays.equals(this.f9814r, me.f9784l)) {
                a += lu.m12375b(18, this.f9814r);
            }
            if (this.f9816t != 0) {
                a += lu.m12371b(19, this.f9816t);
            }
            if (this.f9817u != null && this.f9817u.length > 0) {
                i = 0;
                while (i2 < this.f9817u.length) {
                    i += lu.m12368b(this.f9817u[i2]);
                    i2++;
                }
                a = (a + i) + (this.f9817u.length * 2);
            }
            if (this.f9799c != 0) {
                a += lu.m12385e(21, this.f9799c);
            }
            if (this.f9818v != 0) {
                a += lu.m12385e(22, this.f9818v);
            }
            if (this.f9819w != null) {
                a += lu.m12378c(23, this.f9819w);
            }
            return (this.f9815s == null || this.f9815s.equals("")) ? a : a + lu.m12373b(24, this.f9815s);
        }

        public C3053d m12533a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                int a2;
                Object obj;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f9797a = ltVar.m12347f();
                        continue;
                    case 18:
                        this.f9800d = ltVar.m12351i();
                        continue;
                    case 26:
                        a2 = me.m12506a(ltVar, 26);
                        a = this.f9804h == null ? 0 : this.f9804h.length;
                        obj = new C3054e[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f9804h, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C3054e();
                            ltVar.m12337a(obj[a]);
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = new C3054e();
                        ltVar.m12337a(obj[a]);
                        this.f9804h = obj;
                        continue;
                    case 34:
                        this.f9805i = ltVar.m12352j();
                        continue;
                    case 50:
                        this.f9807k = ltVar.m12352j();
                        continue;
                    case 58:
                        if (this.f9810n == null) {
                            this.f9810n = new C3050a();
                        }
                        ltVar.m12337a(this.f9810n);
                        continue;
                    case 66:
                        this.f9808l = ltVar.m12351i();
                        continue;
                    case 74:
                        if (this.f9806j == null) {
                            this.f9806j = new C3051b();
                        }
                        ltVar.m12337a(this.f9806j);
                        continue;
                    case 80:
                        this.f9803g = ltVar.m12350h();
                        continue;
                    case 88:
                        this.f9801e = ltVar.m12349g();
                        continue;
                    case 96:
                        this.f9802f = ltVar.m12349g();
                        continue;
                    case 106:
                        this.f9809m = ltVar.m12351i();
                        continue;
                    case 114:
                        this.f9811o = ltVar.m12351i();
                        continue;
                    case 120:
                        this.f9812p = ltVar.m12353k();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        if (this.f9813q == null) {
                            this.f9813q = new C3052c();
                        }
                        ltVar.m12337a(this.f9813q);
                        continue;
                    case 136:
                        this.f9798b = ltVar.m12347f();
                        continue;
                    case 146:
                        this.f9814r = ltVar.m12352j();
                        continue;
                    case 152:
                        a = ltVar.m12349g();
                        switch (a) {
                            case 0:
                            case 1:
                            case 2:
                                this.f9816t = a;
                                break;
                            default:
                                continue;
                        }
                    case 160:
                        a2 = me.m12506a(ltVar, 160);
                        a = this.f9817u == null ? 0 : this.f9817u.length;
                        obj = new int[(a2 + a)];
                        if (a != 0) {
                            System.arraycopy(this.f9817u, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = ltVar.m12349g();
                            ltVar.m12335a();
                            a++;
                        }
                        obj[a] = ltVar.m12349g();
                        this.f9817u = obj;
                        continue;
                    case 162:
                        int c = ltVar.m12342c(ltVar.m12354l());
                        a2 = ltVar.m12360r();
                        a = 0;
                        while (ltVar.m12358p() > 0) {
                            ltVar.m12349g();
                            a++;
                        }
                        ltVar.m12346e(a2);
                        a2 = this.f9817u == null ? 0 : this.f9817u.length;
                        Object obj2 = new int[(a + a2)];
                        if (a2 != 0) {
                            System.arraycopy(this.f9817u, 0, obj2, 0, a2);
                        }
                        while (a2 < obj2.length) {
                            obj2[a2] = ltVar.m12349g();
                            a2++;
                        }
                        this.f9817u = obj2;
                        ltVar.m12344d(c);
                        continue;
                    case 168:
                        this.f9799c = ltVar.m12347f();
                        continue;
                    case 176:
                        this.f9818v = ltVar.m12347f();
                        continue;
                    case 186:
                        if (this.f9819w == null) {
                            this.f9819w = new C3055f();
                        }
                        ltVar.m12337a(this.f9819w);
                        continue;
                    case 194:
                        this.f9815s = ltVar.m12351i();
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
            if (this.f9797a != 0) {
                luVar.m12410b(1, this.f9797a);
            }
            if (!(this.f9800d == null || this.f9800d.equals(""))) {
                luVar.m12402a(2, this.f9800d);
            }
            if (this.f9804h != null && this.f9804h.length > 0) {
                for (mb mbVar : this.f9804h) {
                    if (mbVar != null) {
                        luVar.m12401a(3, mbVar);
                    }
                }
            }
            if (!Arrays.equals(this.f9805i, me.f9784l)) {
                luVar.m12404a(4, this.f9805i);
            }
            if (!Arrays.equals(this.f9807k, me.f9784l)) {
                luVar.m12404a(6, this.f9807k);
            }
            if (this.f9810n != null) {
                luVar.m12401a(7, this.f9810n);
            }
            if (!(this.f9808l == null || this.f9808l.equals(""))) {
                luVar.m12402a(8, this.f9808l);
            }
            if (this.f9806j != null) {
                luVar.m12401a(9, this.f9806j);
            }
            if (this.f9803g) {
                luVar.m12403a(10, this.f9803g);
            }
            if (this.f9801e != 0) {
                luVar.m12399a(11, this.f9801e);
            }
            if (this.f9802f != 0) {
                luVar.m12399a(12, this.f9802f);
            }
            if (!(this.f9809m == null || this.f9809m.equals(""))) {
                luVar.m12402a(13, this.f9809m);
            }
            if (!(this.f9811o == null || this.f9811o.equals(""))) {
                luVar.m12402a(14, this.f9811o);
            }
            if (this.f9812p != 180000) {
                luVar.m12417c(15, this.f9812p);
            }
            if (this.f9813q != null) {
                luVar.m12401a(16, this.f9813q);
            }
            if (this.f9798b != 0) {
                luVar.m12410b(17, this.f9798b);
            }
            if (!Arrays.equals(this.f9814r, me.f9784l)) {
                luVar.m12404a(18, this.f9814r);
            }
            if (this.f9816t != 0) {
                luVar.m12399a(19, this.f9816t);
            }
            if (this.f9817u != null && this.f9817u.length > 0) {
                while (i < this.f9817u.length) {
                    luVar.m12399a(20, this.f9817u[i]);
                    i++;
                }
            }
            if (this.f9799c != 0) {
                luVar.m12410b(21, this.f9799c);
            }
            if (this.f9818v != 0) {
                luVar.m12410b(22, this.f9818v);
            }
            if (this.f9819w != null) {
                luVar.m12401a(23, this.f9819w);
            }
            if (!(this.f9815s == null || this.f9815s.equals(""))) {
                luVar.m12402a(24, this.f9815s);
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m12533a(ltVar);
        }

        public C3053d m12536b() {
            this.f9797a = 0;
            this.f9798b = 0;
            this.f9799c = 0;
            this.f9800d = "";
            this.f9801e = 0;
            this.f9802f = 0;
            this.f9803g = false;
            this.f9804h = C3054e.m12540b();
            this.f9805i = me.f9784l;
            this.f9806j = null;
            this.f9807k = me.f9784l;
            this.f9808l = "";
            this.f9809m = "";
            this.f9810n = null;
            this.f9811o = "";
            this.f9812p = 180000;
            this.f9813q = null;
            this.f9814r = me.f9784l;
            this.f9815s = "";
            this.f9816t = 0;
            this.f9817u = me.f9777e;
            this.f9818v = 0;
            this.f9819w = null;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public C3053d m12537c() {
            try {
                C3053d c3053d = (C3053d) super.mo3819d();
                if (this.f9804h != null && this.f9804h.length > 0) {
                    c3053d.f9804h = new C3054e[this.f9804h.length];
                    for (int i = 0; i < this.f9804h.length; i++) {
                        if (this.f9804h[i] != null) {
                            c3053d.f9804h[i] = (C3054e) this.f9804h[i].clone();
                        }
                    }
                }
                if (this.f9806j != null) {
                    c3053d.f9806j = (C3051b) this.f9806j.clone();
                }
                if (this.f9810n != null) {
                    c3053d.f9810n = (C3050a) this.f9810n.clone();
                }
                if (this.f9813q != null) {
                    c3053d.f9813q = (C3052c) this.f9813q.clone();
                }
                if (this.f9817u != null && this.f9817u.length > 0) {
                    c3053d.f9817u = (int[]) this.f9817u.clone();
                }
                if (this.f9819w != null) {
                    c3053d.f9819w = (C3055f) this.f9819w.clone();
                }
                return c3053d;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public /* synthetic */ Object clone() {
            return m12537c();
        }

        public /* synthetic */ lv mo3819d() {
            return (C3053d) clone();
        }

        public /* synthetic */ mb mo3508e() {
            return (C3053d) clone();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C3053d)) {
                return false;
            }
            C3053d c3053d = (C3053d) obj;
            if (this.f9797a != c3053d.f9797a || this.f9798b != c3053d.f9798b || this.f9799c != c3053d.f9799c) {
                return false;
            }
            if (this.f9800d == null) {
                if (c3053d.f9800d != null) {
                    return false;
                }
            } else if (!this.f9800d.equals(c3053d.f9800d)) {
                return false;
            }
            if (this.f9801e != c3053d.f9801e || this.f9802f != c3053d.f9802f || this.f9803g != c3053d.f9803g || !lz.m12453a(this.f9804h, c3053d.f9804h) || !Arrays.equals(this.f9805i, c3053d.f9805i)) {
                return false;
            }
            if (this.f9806j == null) {
                if (c3053d.f9806j != null) {
                    return false;
                }
            } else if (!this.f9806j.equals(c3053d.f9806j)) {
                return false;
            }
            if (!Arrays.equals(this.f9807k, c3053d.f9807k)) {
                return false;
            }
            if (this.f9808l == null) {
                if (c3053d.f9808l != null) {
                    return false;
                }
            } else if (!this.f9808l.equals(c3053d.f9808l)) {
                return false;
            }
            if (this.f9809m == null) {
                if (c3053d.f9809m != null) {
                    return false;
                }
            } else if (!this.f9809m.equals(c3053d.f9809m)) {
                return false;
            }
            if (this.f9810n == null) {
                if (c3053d.f9810n != null) {
                    return false;
                }
            } else if (!this.f9810n.equals(c3053d.f9810n)) {
                return false;
            }
            if (this.f9811o == null) {
                if (c3053d.f9811o != null) {
                    return false;
                }
            } else if (!this.f9811o.equals(c3053d.f9811o)) {
                return false;
            }
            if (this.f9812p != c3053d.f9812p) {
                return false;
            }
            if (this.f9813q == null) {
                if (c3053d.f9813q != null) {
                    return false;
                }
            } else if (!this.f9813q.equals(c3053d.f9813q)) {
                return false;
            }
            if (!Arrays.equals(this.f9814r, c3053d.f9814r)) {
                return false;
            }
            if (this.f9815s == null) {
                if (c3053d.f9815s != null) {
                    return false;
                }
            } else if (!this.f9815s.equals(c3053d.f9815s)) {
                return false;
            }
            if (this.f9816t != c3053d.f9816t || !lz.m12451a(this.f9817u, c3053d.f9817u) || this.f9818v != c3053d.f9818v) {
                return false;
            }
            if (this.f9819w == null) {
                if (c3053d.f9819w != null) {
                    return false;
                }
            } else if (!this.f9819w.equals(c3053d.f9819w)) {
                return false;
            }
            return (this.ag == null || this.ag.m12439b()) ? c3053d.ag == null || c3053d.ag.m12439b() : this.ag.equals(c3053d.ag);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f9819w == null ? 0 : this.f9819w.hashCode()) + (((((((((this.f9815s == null ? 0 : this.f9815s.hashCode()) + (((((this.f9813q == null ? 0 : this.f9813q.hashCode()) + (((((this.f9811o == null ? 0 : this.f9811o.hashCode()) + (((this.f9810n == null ? 0 : this.f9810n.hashCode()) + (((this.f9809m == null ? 0 : this.f9809m.hashCode()) + (((this.f9808l == null ? 0 : this.f9808l.hashCode()) + (((((this.f9806j == null ? 0 : this.f9806j.hashCode()) + (((((((this.f9803g ? 1231 : 1237) + (((((((this.f9800d == null ? 0 : this.f9800d.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.f9797a ^ (this.f9797a >>> 32)))) * 31) + ((int) (this.f9798b ^ (this.f9798b >>> 32)))) * 31) + ((int) (this.f9799c ^ (this.f9799c >>> 32)))) * 31)) * 31) + this.f9801e) * 31) + this.f9802f) * 31)) * 31) + lz.m12448a(this.f9804h)) * 31) + Arrays.hashCode(this.f9805i)) * 31)) * 31) + Arrays.hashCode(this.f9807k)) * 31)) * 31)) * 31)) * 31)) * 31) + ((int) (this.f9812p ^ (this.f9812p >>> 32)))) * 31)) * 31) + Arrays.hashCode(this.f9814r)) * 31)) * 31) + this.f9816t) * 31) + lz.m12446a(this.f9817u)) * 31) + ((int) (this.f9818v ^ (this.f9818v >>> 32)))) * 31)) * 31;
            if (!(this.ag == null || this.ag.m12439b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C3054e extends lv<C3054e> implements Cloneable {
        private static volatile C3054e[] f9820c;
        public String f9821a;
        public String f9822b;

        public C3054e() {
            m12545c();
        }

        public static C3054e[] m12540b() {
            if (f9820c == null) {
                synchronized (lz.f9749c) {
                    if (f9820c == null) {
                        f9820c = new C3054e[0];
                    }
                }
            }
            return f9820c;
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (!(this.f9821a == null || this.f9821a.equals(""))) {
                a += lu.m12373b(1, this.f9821a);
            }
            return (this.f9822b == null || this.f9822b.equals("")) ? a : a + lu.m12373b(2, this.f9822b);
        }

        public C3054e m12542a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f9821a = ltVar.m12351i();
                        continue;
                    case 18:
                        this.f9822b = ltVar.m12351i();
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
            if (!(this.f9821a == null || this.f9821a.equals(""))) {
                luVar.m12402a(1, this.f9821a);
            }
            if (!(this.f9822b == null || this.f9822b.equals(""))) {
                luVar.m12402a(2, this.f9822b);
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m12542a(ltVar);
        }

        public C3054e m12545c() {
            this.f9821a = "";
            this.f9822b = "";
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public /* synthetic */ Object clone() {
            return m12548h();
        }

        public /* synthetic */ lv mo3819d() {
            return (C3054e) clone();
        }

        public /* synthetic */ mb mo3508e() {
            return (C3054e) clone();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C3054e)) {
                return false;
            }
            C3054e c3054e = (C3054e) obj;
            if (this.f9821a == null) {
                if (c3054e.f9821a != null) {
                    return false;
                }
            } else if (!this.f9821a.equals(c3054e.f9821a)) {
                return false;
            }
            if (this.f9822b == null) {
                if (c3054e.f9822b != null) {
                    return false;
                }
            } else if (!this.f9822b.equals(c3054e.f9822b)) {
                return false;
            }
            return (this.ag == null || this.ag.m12439b()) ? c3054e.ag == null || c3054e.ag.m12439b() : this.ag.equals(c3054e.ag);
        }

        public C3054e m12548h() {
            try {
                return (C3054e) super.mo3819d();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f9822b == null ? 0 : this.f9822b.hashCode()) + (((this.f9821a == null ? 0 : this.f9821a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (!(this.ag == null || this.ag.m12439b())) {
                i = this.ag.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C3055f extends lv<C3055f> implements Cloneable {
        public int f9823a;
        public int f9824b;

        public C3055f() {
            m12553b();
        }

        protected int mo3505a() {
            int a = super.mo3505a();
            if (this.f9823a != -1) {
                a += lu.m12371b(1, this.f9823a);
            }
            return this.f9824b != 0 ? a + lu.m12371b(2, this.f9824b) : a;
        }

        public C3055f m12550a(lt ltVar) {
            while (true) {
                int a = ltVar.m12335a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        a = ltVar.m12349g();
                        switch (a) {
                            case -1:
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                                this.f9823a = a;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        a = ltVar.m12349g();
                        switch (a) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 100:
                                this.f9824b = a;
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
            if (this.f9823a != -1) {
                luVar.m12399a(1, this.f9823a);
            }
            if (this.f9824b != 0) {
                luVar.m12399a(2, this.f9824b);
            }
            super.mo3506a(luVar);
        }

        public /* synthetic */ mb mo3509b(lt ltVar) {
            return m12550a(ltVar);
        }

        public C3055f m12553b() {
            this.f9823a = -1;
            this.f9824b = 0;
            this.ag = null;
            this.ah = -1;
            return this;
        }

        public C3055f m12554c() {
            try {
                return (C3055f) super.mo3819d();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public /* synthetic */ Object clone() {
            return m12554c();
        }

        public /* synthetic */ lv mo3819d() {
            return (C3055f) clone();
        }

        public /* synthetic */ mb mo3508e() {
            return (C3055f) clone();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C3055f)) {
                return false;
            }
            C3055f c3055f = (C3055f) obj;
            return (this.f9823a == c3055f.f9823a && this.f9824b == c3055f.f9824b) ? (this.ag == null || this.ag.m12439b()) ? c3055f.ag == null || c3055f.ag.m12439b() : this.ag.equals(c3055f.ag) : false;
        }

        public int hashCode() {
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + this.f9823a) * 31) + this.f9824b) * 31;
            int hashCode2 = (this.ag == null || this.ag.m12439b()) ? 0 : this.ag.hashCode();
            return hashCode2 + hashCode;
        }
    }
}
