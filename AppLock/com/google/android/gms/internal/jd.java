package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public class jd {
    public static final jd f9496a = new jd();
    static final /* synthetic */ boolean f9497b = (!jd.class.desiredAssertionStatus());
    private Integer f9498c;
    private C3000a f9499d;
    private kf f9500e = null;
    private js f9501f = null;
    private kf f9502g = null;
    private js f9503h = null;
    private jy f9504i = ki.m12184d();
    private String f9505j = null;

    private enum C3000a {
        LEFT,
        RIGHT
    }

    public static jd m11850a(Map<String, Object> map) {
        String str;
        jd jdVar = new jd();
        jdVar.f9498c = (Integer) map.get("l");
        if (map.containsKey("sp")) {
            jdVar.f9500e = m11851a(kg.m12177a(map.get("sp")));
            str = (String) map.get("sn");
            if (str != null) {
                jdVar.f9501f = js.m12005a(str);
            }
        }
        if (map.containsKey("ep")) {
            jdVar.f9502g = m11851a(kg.m12177a(map.get("ep")));
            str = (String) map.get("en");
            if (str != null) {
                jdVar.f9503h = js.m12005a(str);
            }
        }
        str = (String) map.get("vf");
        if (str != null) {
            jdVar.f9499d = str.equals("l") ? C3000a.LEFT : C3000a.RIGHT;
        }
        str = (String) map.get("i");
        if (str != null) {
            jdVar.f9504i = jy.m12099a(str);
        }
        return jdVar;
    }

    private static kf m11851a(kf kfVar) {
        if ((kfVar instanceof kl) || (kfVar instanceof jr) || (kfVar instanceof jw) || (kfVar instanceof jx)) {
            return kfVar;
        }
        if (kfVar instanceof kd) {
            return new jw(Double.valueOf(((Long) kfVar.mo3786a()).doubleValue()), kj.m12190a());
        }
        String valueOf = String.valueOf(kfVar.mo3786a());
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Unexpected value passed to normalizeValue: ").append(valueOf).toString());
    }

    public boolean m11852a() {
        return this.f9500e != null;
    }

    public kf m11853b() {
        if (m11852a()) {
            return this.f9500e;
        }
        throw new IllegalArgumentException("Cannot get index start value if start has not been set");
    }

    public js m11854c() {
        if (m11852a()) {
            return this.f9501f != null ? this.f9501f : js.m12004a();
        } else {
            throw new IllegalArgumentException("Cannot get index start name if start has not been set");
        }
    }

    public boolean m11855d() {
        return this.f9502g != null;
    }

    public kf m11856e() {
        if (m11855d()) {
            return this.f9502g;
        }
        throw new IllegalArgumentException("Cannot get index end value if start has not been set");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        jd jdVar = (jd) obj;
        return (this.f9498c == null ? jdVar.f9498c != null : !this.f9498c.equals(jdVar.f9498c)) ? false : (this.f9504i == null ? jdVar.f9504i != null : !this.f9504i.equals(jdVar.f9504i)) ? false : (this.f9503h == null ? jdVar.f9503h != null : !this.f9503h.equals(jdVar.f9503h)) ? false : (this.f9502g == null ? jdVar.f9502g != null : !this.f9502g.equals(jdVar.f9502g)) ? false : (this.f9501f == null ? jdVar.f9501f != null : !this.f9501f.equals(jdVar.f9501f)) ? false : (this.f9500e == null ? jdVar.f9500e != null : !this.f9500e.equals(jdVar.f9500e)) ? false : m11861j() == jdVar.m11861j();
    }

    public js m11857f() {
        if (m11855d()) {
            return this.f9503h != null ? this.f9503h : js.m12006b();
        } else {
            throw new IllegalArgumentException("Cannot get index end name if start has not been set");
        }
    }

    public boolean m11858g() {
        return this.f9498c != null;
    }

    public int m11859h() {
        if (m11858g()) {
            return this.f9498c.intValue();
        }
        throw new IllegalArgumentException("Cannot get limit if limit has not been set");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f9503h != null ? this.f9503h.hashCode() : 0) + (((this.f9502g != null ? this.f9502g.hashCode() : 0) + (((this.f9501f != null ? this.f9501f.hashCode() : 0) + (((this.f9500e != null ? this.f9500e.hashCode() : 0) + (((m11861j() ? 1231 : 1237) + ((this.f9498c != null ? this.f9498c.intValue() : 0) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f9504i != null) {
            i = this.f9504i.hashCode();
        }
        return hashCode + i;
    }

    public jy m11860i() {
        return this.f9504i;
    }

    public boolean m11861j() {
        return this.f9499d != null ? this.f9499d == C3000a.LEFT : m11852a();
    }

    public Map<String, Object> m11862k() {
        Map<String, Object> hashMap = new HashMap();
        if (m11852a()) {
            hashMap.put("sp", this.f9500e.mo3786a());
            if (this.f9501f != null) {
                hashMap.put("sn", this.f9501f.m12010d());
            }
        }
        if (m11855d()) {
            hashMap.put("ep", this.f9502g.mo3786a());
            if (this.f9503h != null) {
                hashMap.put("en", this.f9503h.m12010d());
            }
        }
        if (this.f9498c != null) {
            hashMap.put("l", this.f9498c);
            C3000a c3000a = this.f9499d;
            if (c3000a == null) {
                c3000a = m11852a() ? C3000a.LEFT : C3000a.RIGHT;
            }
            switch (c3000a) {
                case LEFT:
                    hashMap.put("vf", "l");
                    break;
                case RIGHT:
                    hashMap.put("vf", "r");
                    break;
            }
        }
        if (!this.f9504i.equals(ki.m12184d())) {
            hashMap.put("i", this.f9504i.mo3812c());
        }
        return hashMap;
    }

    public boolean m11863l() {
        return (m11852a() || m11855d() || m11858g()) ? false : true;
    }

    public boolean m11864m() {
        return m11863l() && this.f9504i.equals(ki.m12184d());
    }

    public String m11865n() {
        if (this.f9505j == null) {
            try {
                this.f9505j = ky.m12268a(m11862k());
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        return this.f9505j;
    }

    public jl m11866o() {
        return m11863l() ? new jj(m11860i()) : m11858g() ? new jk(this) : new jm(this);
    }

    public String toString() {
        return m11862k().toString();
    }
}
