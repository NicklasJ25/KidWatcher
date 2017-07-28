package com.android.gallery3d.ui;

import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class NinePatchChunk {
    public static final int NO_COLOR = 1;
    public static final int TRANSPARENT_COLOR = 0;
    public int[] mColor;
    public int[] mDivX;
    public int[] mDivY;
    public Rect mPaddings = new Rect();

    NinePatchChunk() {
    }

    private static void checkDivCount(int i) {
        if (i == 0 || (i & 1) != 0) {
            throw new RuntimeException("invalid nine-patch: " + i);
        }
    }

    public static NinePatchChunk deserialize(byte[] bArr) {
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder());
        if (order.get() == (byte) 0) {
            return null;
        }
        NinePatchChunk ninePatchChunk = new NinePatchChunk();
        ninePatchChunk.mDivX = new int[order.get()];
        ninePatchChunk.mDivY = new int[order.get()];
        ninePatchChunk.mColor = new int[order.get()];
        checkDivCount(ninePatchChunk.mDivX.length);
        checkDivCount(ninePatchChunk.mDivY.length);
        order.getInt();
        order.getInt();
        ninePatchChunk.mPaddings.left = order.getInt();
        ninePatchChunk.mPaddings.right = order.getInt();
        ninePatchChunk.mPaddings.top = order.getInt();
        ninePatchChunk.mPaddings.bottom = order.getInt();
        order.getInt();
        readIntArray(ninePatchChunk.mDivX, order);
        readIntArray(ninePatchChunk.mDivY, order);
        readIntArray(ninePatchChunk.mColor, order);
        return ninePatchChunk;
    }

    private static void readIntArray(int[] iArr, ByteBuffer byteBuffer) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = byteBuffer.getInt();
        }
    }
}
