package com.google.android.gms.p004b;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.C2513c;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class C2434h {

    class C24331 implements Runnable {
        final /* synthetic */ C2443n f7229a;
        final /* synthetic */ Callable f7230b;

        C24331(C2443n c2443n, Callable callable) {
            this.f7229a = c2443n;
            this.f7230b = callable;
        }

        public void run() {
            try {
                this.f7229a.m7706a(this.f7230b.call());
            } catch (Exception e) {
                this.f7229a.m7705a(e);
            }
        }
    }

    public static <TResult> C2428e<TResult> m7683a(@NonNull Exception exception) {
        C2428e c2443n = new C2443n();
        c2443n.m7705a(exception);
        return c2443n;
    }

    public static <TResult> C2428e<TResult> m7684a(TResult tResult) {
        C2428e c2443n = new C2443n();
        c2443n.m7706a((Object) tResult);
        return c2443n;
    }

    public static <TResult> C2428e<TResult> m7685a(@NonNull Executor executor, @NonNull Callable<TResult> callable) {
        C2513c.m7933a((Object) executor, (Object) "Executor must not be null");
        C2513c.m7933a((Object) callable, (Object) "Callback must not be null");
        C2428e c2443n = new C2443n();
        executor.execute(new C24331(c2443n, callable));
        return c2443n;
    }
}
