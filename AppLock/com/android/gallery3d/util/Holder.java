package com.android.gallery3d.util;

public class Holder<T> {
    private T mObject;

    public T get() {
        return this.mObject;
    }

    public void set(T t) {
        this.mObject = t;
    }
}
