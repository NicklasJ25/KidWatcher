package com.google.android.gms.internal;

public class kr extends RuntimeException {
    public kr(String str) {
        super(str);
    }

    public kr(String str, Throwable th) {
        super(str, th);
    }
}
