package com.facebook.ads.internal.p025c;

import java.io.Serializable;

public class C1544c implements Serializable {
    private C1543a f3762a;
    private C1543a f3763b;

    public static class C1543a implements Serializable {
        private double f3751a;
        private double f3752b;
        private double f3753c;
        private double f3754d;
        private double f3755e;
        private double f3756f;
        private double f3757g;
        private int f3758h;
        private double f3759i;
        private double f3760j;
        private double f3761k;

        public C1543a(double d) {
            this.f3755e = d;
        }

        public void m4274a() {
            this.f3751a = 0.0d;
            this.f3753c = 0.0d;
            this.f3754d = 0.0d;
            this.f3756f = 0.0d;
            this.f3758h = 0;
            this.f3759i = 0.0d;
            this.f3760j = 1.0d;
            this.f3761k = 0.0d;
        }

        public void m4275a(double d, double d2) {
            this.f3758h++;
            this.f3759i += d;
            this.f3753c = d2;
            this.f3761k += d2 * d;
            this.f3751a = this.f3761k / this.f3759i;
            this.f3760j = Math.min(this.f3760j, d2);
            this.f3756f = Math.max(this.f3756f, d2);
            if (d2 >= this.f3755e) {
                this.f3754d += d;
                this.f3752b += d;
                this.f3757g = Math.max(this.f3757g, this.f3752b);
                return;
            }
            this.f3752b = 0.0d;
        }

        public double m4276b() {
            return this.f3758h == 0 ? 0.0d : this.f3760j;
        }

        public double m4277c() {
            return this.f3751a;
        }

        public double m4278d() {
            return this.f3756f;
        }

        public double m4279e() {
            return this.f3759i;
        }

        public double m4280f() {
            return this.f3754d;
        }

        public double m4281g() {
            return this.f3757g;
        }
    }

    public C1544c() {
        this(0.5d, 0.05d);
    }

    public C1544c(double d) {
        this(d, 0.05d);
    }

    public C1544c(double d, double d2) {
        this.f3762a = new C1543a(d);
        this.f3763b = new C1543a(d2);
        m4282a();
    }

    void m4282a() {
        this.f3762a.m4274a();
        this.f3763b.m4274a();
    }

    void m4283a(double d, double d2) {
        this.f3762a.m4275a(d, d2);
    }

    public C1543a m4284b() {
        return this.f3762a;
    }

    void m4285b(double d, double d2) {
        this.f3763b.m4275a(d, d2);
    }

    public C1543a m4286c() {
        return this.f3763b;
    }
}
