package com.domobile.applock;

import android.content.Context;
import java.io.File;
import java.lang.Thread.UncaughtExceptionHandler;
import org.apache.p068a.p069a.C3613c;

class C0948h implements UncaughtExceptionHandler {
    private static C0948h f1483b = new C0948h();
    private UncaughtExceptionHandler f1484a;
    private Context f1485c;

    private C0948h() {
    }

    private static int m1694a(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        int i = 0;
        int length = stackTraceElementArr2.length;
        int length2 = stackTraceElementArr.length;
        while (true) {
            length2--;
            if (length2 < 0) {
                break;
            }
            length--;
            if (length < 0 || !stackTraceElementArr2[length].equals(stackTraceElementArr[length2])) {
                break;
            }
            i++;
        }
        return i;
    }

    public static C0948h m1695a() {
        return f1483b;
    }

    private void m1696a(Throwable th, StringBuilder stringBuilder, StackTraceElement[] stackTraceElementArr) {
        int i = 0;
        stringBuilder.append(th.toString()).append("\n");
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            int a = stackTraceElementArr != null ? C0948h.m1694a(stackTrace, stackTraceElementArr) : 0;
            while (i < stackTrace.length - a) {
                stringBuilder.append(stackTrace[i].toString()).append("\n");
                i++;
            }
            if (a > 0) {
                stringBuilder.append("\t... ").append(a).append(" more\n");
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            stringBuilder.append("Caused by: ");
            m1696a(cause, stringBuilder, stackTrace);
        }
    }

    private boolean m1697a(Throwable th) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            m1696a(th, stringBuilder, null);
            C3613c.m15738b(new File(C1150y.M, ".AppLockCrash.log"), stringBuilder.toString());
        } catch (Exception e) {
        }
        return false;
    }

    public void m1698a(Context context) {
        this.f1485c = context;
        this.f1484a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (!m1697a(th) && this.f1484a != null) {
            this.f1484a.uncaughtException(thread, th);
        }
    }
}
