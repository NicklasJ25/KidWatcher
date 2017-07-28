package com.google.firebase.database;

import com.google.android.gms.internal.kf;

public class C3587l {

    public interface C3585a {
        C3586b m15595a(C3578h c3578h);

        void m15596a(C3536b c3536b, boolean z, C3535a c3535a);
    }

    public static class C3586b {
        private boolean f12208a;
        private kf f12209b;

        private C3586b(boolean z, kf kfVar) {
            this.f12208a = z;
            this.f12209b = kfVar;
        }

        public boolean m15597a() {
            return this.f12208a;
        }

        public kf m15598b() {
            return this.f12209b;
        }
    }

    public static C3586b m15599a() {
        return new C3586b(false, null);
    }
}
