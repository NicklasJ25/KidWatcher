package com.facebook.ads.internal.p027f;

abstract class C1564f<T> {
    private C1569a f3822a;

    public enum C1569a {
        UNKNOWN(9000, "An unknown error has occurred."),
        DATABASE_SELECT(3001, "Failed to read from database."),
        DATABASE_INSERT(3002, "Failed to insert row into database."),
        DATABASE_UPDATE(3003, "Failed to update row in database."),
        DATABASE_DELETE(3004, "Failed to delete row from database.");
        
        private final int f3837f;
        private final String f3838g;

        private C1569a(int i, String str) {
            this.f3837f = i;
            this.f3838g = str;
        }

        public int m4367a() {
            return this.f3837f;
        }

        public String m4368b() {
            return this.f3838g;
        }
    }

    C1564f() {
    }

    protected void m4348a(C1569a c1569a) {
        this.f3822a = c1569a;
    }

    abstract T mo2731b();

    public C1569a m4350c() {
        return this.f3822a;
    }
}
