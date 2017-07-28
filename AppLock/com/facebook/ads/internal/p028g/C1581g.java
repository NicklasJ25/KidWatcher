package com.facebook.ads.internal.p028g;

import java.util.UUID;

public class C1581g {
    private static final String f3912a = C1581g.class.getSimpleName();
    private static volatile boolean f3913b = false;
    private static double f3914c;
    private static String f3915d;

    public static void m4408a() {
        if (!f3913b) {
            synchronized (f3912a) {
                if (!f3913b) {
                    f3913b = true;
                    f3914c = ((double) System.currentTimeMillis()) / 1000.0d;
                    f3915d = UUID.randomUUID().toString();
                }
            }
        }
    }

    public static double m4409b() {
        return f3914c;
    }

    public static String m4410c() {
        return f3915d;
    }
}
