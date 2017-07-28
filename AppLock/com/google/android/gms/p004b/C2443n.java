package com.google.android.gms.p004b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.C2513c;
import java.util.concurrent.Executor;

final class C2443n<TResult> extends C2428e<TResult> {
    private final Object f7249a = new Object();
    private final C2442m<TResult> f7250b = new C2442m();
    private boolean f7251c;
    private TResult f7252d;
    private Exception f7253e;

    C2443n() {
    }

    private void m7698d() {
        C2513c.m7938a(this.f7251c, (Object) "Task is not yet complete");
    }

    private void m7699e() {
        C2513c.m7938a(!this.f7251c, (Object) "Task is already complete");
    }

    private void m7700f() {
        synchronized (this.f7249a) {
            if (this.f7251c) {
                this.f7250b.m7696a((C2428e) this);
                return;
            }
        }
    }

    @NonNull
    public C2428e<TResult> mo3306a(@NonNull C0625a<TResult> c0625a) {
        return mo3307a(C2432g.f7227a, (C0625a) c0625a);
    }

    @NonNull
    public C2428e<TResult> mo3307a(@NonNull Executor executor, @NonNull C0625a<TResult> c0625a) {
        this.f7250b.m7697a(new C2437i(executor, c0625a));
        m7700f();
        return this;
    }

    @NonNull
    public C2428e<TResult> mo3308a(@NonNull Executor executor, @NonNull C2425b c2425b) {
        this.f7250b.m7697a(new C2439j(executor, c2425b));
        m7700f();
        return this;
    }

    @NonNull
    public C2428e<TResult> mo3309a(@NonNull Executor executor, @NonNull C2426c<? super TResult> c2426c) {
        this.f7250b.m7697a(new C2441k(executor, c2426c));
        m7700f();
        return this;
    }

    public void m7705a(@NonNull Exception exception) {
        C2513c.m7933a((Object) exception, (Object) "Exception must not be null");
        synchronized (this.f7249a) {
            m7699e();
            this.f7251c = true;
            this.f7253e = exception;
        }
        this.f7250b.m7696a((C2428e) this);
    }

    public void m7706a(TResult tResult) {
        synchronized (this.f7249a) {
            m7699e();
            this.f7251c = true;
            this.f7252d = tResult;
        }
        this.f7250b.m7696a((C2428e) this);
    }

    public boolean mo3310a() {
        boolean z;
        synchronized (this.f7249a) {
            z = this.f7251c && this.f7253e == null;
        }
        return z;
    }

    public TResult mo3311b() {
        TResult tResult;
        synchronized (this.f7249a) {
            m7698d();
            if (this.f7253e != null) {
                throw new C2427d(this.f7253e);
            }
            tResult = this.f7252d;
        }
        return tResult;
    }

    public boolean m7709b(@NonNull Exception exception) {
        boolean z = true;
        C2513c.m7933a((Object) exception, (Object) "Exception must not be null");
        synchronized (this.f7249a) {
            if (this.f7251c) {
                z = false;
            } else {
                this.f7251c = true;
                this.f7253e = exception;
                this.f7250b.m7696a((C2428e) this);
            }
        }
        return z;
    }

    @Nullable
    public Exception mo3312c() {
        Exception exception;
        synchronized (this.f7249a) {
            exception = this.f7253e;
        }
        return exception;
    }
}
