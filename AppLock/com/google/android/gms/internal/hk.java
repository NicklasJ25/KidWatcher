package com.google.android.gms.internal;

public class hk {
    public String f9281a;
    public boolean f9282b;
    public String f9283c;
    public String f9284d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        hk hkVar = (hk) obj;
        return (this.f9282b == hkVar.f9282b && this.f9281a.equals(hkVar.f9281a)) ? this.f9283c.equals(hkVar.f9283c) : false;
    }

    public int hashCode() {
        return (((this.f9282b ? 1 : 0) + (this.f9281a.hashCode() * 31)) * 31) + this.f9283c.hashCode();
    }

    public String toString() {
        String str = this.f9282b ? "s" : "";
        String str2 = this.f9281a;
        return new StringBuilder((String.valueOf(str).length() + 7) + String.valueOf(str2).length()).append("http").append(str).append("://").append(str2).toString();
    }
}
