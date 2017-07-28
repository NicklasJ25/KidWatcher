package com.domobile.p001a.p002a;

public class C0576d {
    int f373a;
    String f374b;

    public C0576d(int i, String str) {
        this.f373a = i;
        if (str == null || str.trim().length() == 0) {
            this.f374b = C0575c.m502a(i);
        } else {
            this.f374b = str + " (response: " + C0575c.m502a(i) + ")";
        }
    }

    public String m524a() {
        return this.f374b;
    }

    public void m525a(int i) {
        this.f373a = i;
    }

    public boolean m526b() {
        return this.f373a == 0;
    }

    public boolean m527c() {
        return !m526b();
    }

    public String toString() {
        return "IabResult: " + m524a();
    }
}
