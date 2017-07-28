package com.google.android.gms.p004b;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

public final class C2432g {
    public static final Executor f7227a = new C2431a();
    static final Executor f7228b = new C24301();

    class C24301 implements Executor {
        C24301() {
        }

        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }

    private static final class C2431a implements Executor {
        private final Handler f7226a = new Handler(Looper.getMainLooper());

        public void execute(@NonNull Runnable runnable) {
            this.f7226a.post(runnable);
        }
    }
}
