package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class abj {
    public static String f7795a = "Volley";
    public static boolean f7796b = Log.isLoggable(f7795a, 2);

    static class C2661a {
        public static final boolean f7792a = abj.f7796b;
        private final List<C2660a> f7793b = new ArrayList();
        private boolean f7794c = false;

        private static class C2660a {
            public final String f7789a;
            public final long f7790b;
            public final long f7791c;

            public C2660a(String str, long j, long j2) {
                this.f7789a = str;
                this.f7790b = j;
                this.f7791c = j2;
            }
        }

        C2661a() {
        }

        private long m8752a() {
            if (this.f7793b.size() == 0) {
                return 0;
            }
            return ((C2660a) this.f7793b.get(this.f7793b.size() - 1)).f7791c - ((C2660a) this.f7793b.get(0)).f7791c;
        }

        public synchronized void m8753a(String str) {
            this.f7794c = true;
            if (m8752a() > 0) {
                long j = ((C2660a) this.f7793b.get(0)).f7791c;
                abj.m8757b("(%-4d ms) %s", Long.valueOf(r2), str);
                long j2 = j;
                for (C2660a c2660a : this.f7793b) {
                    abj.m8757b("(+%-4d) [%2d] %s", Long.valueOf(c2660a.f7791c - j2), Long.valueOf(c2660a.f7790b), c2660a.f7789a);
                    j2 = c2660a.f7791c;
                }
            }
        }

        public synchronized void m8754a(String str, long j) {
            if (this.f7794c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f7793b.add(new C2660a(str, j, SystemClock.elapsedRealtime()));
        }

        protected void finalize() {
            if (!this.f7794c) {
                m8753a("Request on the loose");
                abj.m8758c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    public static void m8755a(String str, Object... objArr) {
        if (f7796b) {
            Log.v(f7795a, m8759d(str, objArr));
        }
    }

    public static void m8756a(Throwable th, String str, Object... objArr) {
        Log.e(f7795a, m8759d(str, objArr), th);
    }

    public static void m8757b(String str, Object... objArr) {
        Log.d(f7795a, m8759d(str, objArr));
    }

    public static void m8758c(String str, Object... objArr) {
        Log.e(f7795a, m8759d(str, objArr));
    }

    private static String m8759d(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str3 = "<unknown>";
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(abj.class)) {
                str3 = stackTrace[i].getClassName();
                str3 = str3.substring(str3.lastIndexOf(46) + 1);
                str2 = str3.substring(str3.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
        }
        str2 = str3;
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
