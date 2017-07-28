package com.google.android.gms.internal;

import com.google.android.gms.internal.ej.C2847a;

public class wx<T> {
    public final T f11218a;
    public final C2847a f11219b;
    public final abi f11220c;
    public boolean f11221d;

    public interface C3415a {
        void mo4268a(abi com_google_android_gms_internal_abi);
    }

    public interface C3416b<T> {
        void mo4271a(T t);
    }

    private wx(abi com_google_android_gms_internal_abi) {
        this.f11221d = false;
        this.f11218a = null;
        this.f11219b = null;
        this.f11220c = com_google_android_gms_internal_abi;
    }

    private wx(T t, C2847a c2847a) {
        this.f11221d = false;
        this.f11218a = t;
        this.f11219b = c2847a;
        this.f11220c = null;
    }

    public static <T> wx<T> m14580a(abi com_google_android_gms_internal_abi) {
        return new wx(com_google_android_gms_internal_abi);
    }

    public static <T> wx<T> m14581a(T t, C2847a c2847a) {
        return new wx(t, c2847a);
    }

    public boolean m14582a() {
        return this.f11220c == null;
    }
}
