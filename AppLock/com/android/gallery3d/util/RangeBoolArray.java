package com.android.gallery3d.util;

public class RangeBoolArray {
    private boolean[] mData;
    private int mOffset;

    public RangeBoolArray(int i, int i2) {
        this.mData = new boolean[((i2 - i) + 1)];
        this.mOffset = i;
    }

    public RangeBoolArray(boolean[] zArr, int i, int i2) {
        this.mData = zArr;
        this.mOffset = i;
    }

    public boolean get(int i) {
        return this.mData[i - this.mOffset];
    }

    public int indexOf(boolean z) {
        for (int i = 0; i < this.mData.length; i++) {
            if (this.mData[i] == z) {
                return i + this.mOffset;
            }
        }
        return Integer.MAX_VALUE;
    }

    public void put(int i, boolean z) {
        this.mData[i - this.mOffset] = z;
    }
}
