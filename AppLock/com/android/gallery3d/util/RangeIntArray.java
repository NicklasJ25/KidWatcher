package com.android.gallery3d.util;

public class RangeIntArray {
    private int[] mData;
    private int mOffset;

    public RangeIntArray(int i, int i2) {
        this.mData = new int[((i2 - i) + 1)];
        this.mOffset = i;
    }

    public RangeIntArray(int[] iArr, int i, int i2) {
        this.mData = iArr;
        this.mOffset = i;
    }

    public int get(int i) {
        return this.mData[i - this.mOffset];
    }

    public int indexOf(int i) {
        for (int i2 = 0; i2 < this.mData.length; i2++) {
            if (this.mData[i2] == i) {
                return i2 + this.mOffset;
            }
        }
        return Integer.MAX_VALUE;
    }

    public void put(int i, int i2) {
        this.mData[i - this.mOffset] = i2;
    }
}
