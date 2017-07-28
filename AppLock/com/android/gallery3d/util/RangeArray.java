package com.android.gallery3d.util;

public class RangeArray<T> {
    private T[] mData;
    private int mOffset;

    public RangeArray(int i, int i2) {
        this.mData = new Object[((i2 - i) + 1)];
        this.mOffset = i;
    }

    public RangeArray(T[] tArr, int i, int i2) {
        if ((i2 - i) + 1 != tArr.length) {
            throw new AssertionError();
        }
        this.mData = tArr;
        this.mOffset = i;
    }

    public T get(int i) {
        return this.mData[i - this.mOffset];
    }

    public int indexOf(T t) {
        for (int i = 0; i < this.mData.length; i++) {
            if (this.mData[i] == t) {
                return i + this.mOffset;
            }
        }
        return Integer.MAX_VALUE;
    }

    public void put(int i, T t) {
        this.mData[i - this.mOffset] = t;
    }
}
