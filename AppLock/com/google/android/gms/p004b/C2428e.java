package com.google.android.gms.p004b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.concurrent.Executor;

public abstract class C2428e<TResult> {
    @NonNull
    public C2428e<TResult> mo3306a(@NonNull C0625a<TResult> c0625a) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @NonNull
    public C2428e<TResult> mo3307a(@NonNull Executor executor, @NonNull C0625a<TResult> c0625a) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @NonNull
    public abstract C2428e<TResult> mo3308a(@NonNull Executor executor, @NonNull C2425b c2425b);

    @NonNull
    public abstract C2428e<TResult> mo3309a(@NonNull Executor executor, @NonNull C2426c<? super TResult> c2426c);

    public abstract boolean mo3310a();

    public abstract TResult mo3311b();

    @Nullable
    public abstract Exception mo3312c();
}
