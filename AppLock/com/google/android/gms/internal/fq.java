package com.google.android.gms.internal;

import android.util.Log;
import com.google.firebase.crash.FirebaseCrash;
import java.lang.Thread.UncaughtExceptionHandler;

public class fq implements UncaughtExceptionHandler {
    private final FirebaseCrash f8933a;
    private final UncaughtExceptionHandler f8934b;

    public fq(UncaughtExceptionHandler uncaughtExceptionHandler, FirebaseCrash firebaseCrash) {
        this.f8933a = firebaseCrash;
        this.f8934b = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Log.e("UncaughtException", "", th);
        try {
            this.f8933a.m15446a(th);
        } catch (fm e) {
            try {
                Log.v("UncaughtException", e.getMessage());
            } catch (Throwable e2) {
                Log.e("UncaughtException", "Ouch!  My own exception handler threw an exception.", e2);
            }
        }
        if (this.f8934b != null) {
            this.f8934b.uncaughtException(thread, th);
        }
    }
}
