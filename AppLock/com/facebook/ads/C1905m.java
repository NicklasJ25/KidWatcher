package com.facebook.ads;

public class C1905m {

    public enum C1904a {
        HEIGHT_100(-1, 100),
        HEIGHT_120(-1, 120),
        HEIGHT_300(-1, 300),
        HEIGHT_400(-1, 400);
        
        private final int f4829e;
        private final int f4830f;

        private C1904a(int i, int i2) {
            this.f4829e = i;
            this.f4830f = i2;
        }

        public int m5429a() {
            switch (this.f4830f) {
                case 100:
                    return 1;
                case 120:
                    return 2;
                case 300:
                    return 3;
                case 400:
                    return 4;
                default:
                    return -1;
            }
        }
    }
}
