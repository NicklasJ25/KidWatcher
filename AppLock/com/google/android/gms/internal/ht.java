package com.google.android.gms.internal;

import java.lang.Thread.UncaughtExceptionHandler;

public interface ht {
    public static final ht f9185a = new C29731();

    class C29731 implements ht {
        C29731() {
        }

        public void mo3701a(Thread thread, String str) {
            thread.setName(str);
        }

        public void mo3702a(Thread thread, UncaughtExceptionHandler uncaughtExceptionHandler) {
            thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }

        public void mo3703a(Thread thread, boolean z) {
            thread.setDaemon(z);
        }
    }

    void mo3701a(Thread thread, String str);

    void mo3702a(Thread thread, UncaughtExceptionHandler uncaughtExceptionHandler);

    void mo3703a(Thread thread, boolean z);
}
