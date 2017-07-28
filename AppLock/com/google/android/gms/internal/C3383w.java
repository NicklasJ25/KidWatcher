package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class C3383w {
    private static final ExecutorService f11117a = Executors.newFixedThreadPool(2, new bi("GAC_Executor"));

    public static ExecutorService m14451a() {
        return f11117a;
    }
}
