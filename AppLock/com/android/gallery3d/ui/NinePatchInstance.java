package com.android.gallery3d.ui;

import com.android.gallery3d.common.Utils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL11;

class NinePatchInstance {
    private static final int INDEX_BUFFER_SIZE = 24;
    private static final String TAG = "NinePatchInstance";
    private static final int VERTEX_BUFFER_SIZE = 32;
    private int[] mBufferNames;
    private int mIdxCount;
    private ByteBuffer mIndexBuffer;
    private FloatBuffer mUvBuffer;
    private FloatBuffer mXyBuffer;

    public NinePatchInstance(NinePatchTexture ninePatchTexture, int i, int i2) {
        NinePatchChunk ninePatchChunk = ninePatchTexture.getNinePatchChunk();
        if (i <= 0 || i2 <= 0) {
            throw new RuntimeException("invalid dimension");
        } else if (ninePatchChunk.mDivX.length == 2 && ninePatchChunk.mDivY.length == 2) {
            float[] fArr = new float[4];
            float[] fArr2 = new float[4];
            float[] fArr3 = new float[4];
            float[] fArr4 = new float[4];
            prepareVertexData(fArr, fArr2, fArr3, fArr4, stretch(fArr, fArr3, ninePatchChunk.mDivX, ninePatchTexture.getWidth(), i), stretch(fArr2, fArr4, ninePatchChunk.mDivY, ninePatchTexture.getHeight(), i2), ninePatchChunk.mColor);
        } else {
            throw new RuntimeException("unsupported nine patch");
        }
    }

    private static ByteBuffer allocateDirectNativeOrderBuffer(int i) {
        return ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
    }

    private void prepareBuffers(GLCanvas gLCanvas) {
        this.mBufferNames = new int[3];
        GL11 gLInstance = gLCanvas.getGLInstance();
        GLId.glGenBuffers(3, this.mBufferNames, 0);
        gLInstance.glBindBuffer(34962, this.mBufferNames[0]);
        gLInstance.glBufferData(34962, this.mXyBuffer.capacity() * 4, this.mXyBuffer, 35044);
        gLInstance.glBindBuffer(34962, this.mBufferNames[1]);
        gLInstance.glBufferData(34962, this.mUvBuffer.capacity() * 4, this.mUvBuffer, 35044);
        gLInstance.glBindBuffer(34963, this.mBufferNames[2]);
        gLInstance.glBufferData(34963, this.mIndexBuffer.capacity(), this.mIndexBuffer, 35044);
        this.mXyBuffer = null;
        this.mUvBuffer = null;
        this.mIndexBuffer = null;
    }

    private void prepareVertexData(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, int i, int i2, int[] iArr) {
        int i3;
        int i4;
        int i5 = 0;
        float[] fArr5 = new float[32];
        float[] fArr6 = new float[32];
        int i6 = 0;
        while (i6 < i2) {
            i3 = 0;
            int i7 = i5;
            while (i3 < i) {
                int i8 = i7 + 1;
                i7 <<= 1;
                i4 = i7 + 1;
                fArr5[i7] = fArr[i3];
                fArr5[i4] = fArr2[i6];
                fArr6[i7] = fArr3[i3];
                fArr6[i4] = fArr4[i6];
                i3++;
                i7 = i8;
            }
            i6++;
            i5 = i7;
        }
        i4 = 1;
        Object obj = null;
        byte[] bArr = new byte[24];
        for (int i9 = 0; i9 < i2 - 1; i9++) {
            i4--;
            obj = obj == null ? 1 : null;
            if (obj != null) {
                i3 = 1;
                i8 = 0;
                i7 = i;
            } else {
                i8 = i - 1;
                i7 = -1;
                i3 = -1;
            }
            for (int i10 = i8; i10 != i7; i10 += i3) {
                int i11;
                int i12 = (i9 * i) + i10;
                if (i10 != i8) {
                    i6 = ((i - 1) * i9) + i10;
                    if (obj != null) {
                        i6--;
                    }
                    if (iArr[i6] == 0) {
                        bArr[i4] = bArr[i4 - 1];
                        i4++;
                        i6 = i4 + 1;
                        bArr[i4] = (byte) i12;
                        i11 = i6 + 1;
                        bArr[i6] = (byte) i12;
                        i4 = i11 + 1;
                        bArr[i11] = (byte) (i12 + i);
                    }
                }
                i6 = i4;
                i11 = i6 + 1;
                bArr[i6] = (byte) i12;
                i4 = i11 + 1;
                bArr[i11] = (byte) (i12 + i);
            }
        }
        this.mIdxCount = i4;
        i3 = (i5 * 2) * 4;
        this.mXyBuffer = allocateDirectNativeOrderBuffer(i3).asFloatBuffer();
        this.mUvBuffer = allocateDirectNativeOrderBuffer(i3).asFloatBuffer();
        this.mIndexBuffer = allocateDirectNativeOrderBuffer(this.mIdxCount);
        this.mXyBuffer.put(fArr5, 0, i5 * 2).position(0);
        this.mUvBuffer.put(fArr6, 0, i5 * 2).position(0);
        this.mIndexBuffer.put(bArr, 0, i4).position(0);
    }

    private static int stretch(float[] fArr, float[] fArr2, int[] iArr, int i, int i2) {
        int i3;
        int nextPowerOf2 = Utils.nextPowerOf2(i);
        float f = ((float) i) / ((float) nextPowerOf2);
        float f2 = 0.0f;
        for (i3 = 0; i3 < iArr.length; i3 += 2) {
            f2 += (float) (iArr[i3 + 1] - iArr[i3]);
        }
        float f3 = ((float) (i2 - i)) + f2;
        float f4 = 0.0f;
        float f5 = 0.0f;
        fArr[0] = 0.0f;
        fArr2[0] = 0.0f;
        int length = iArr.length;
        for (i3 = 0; i3 < length; i3 += 2) {
            fArr[i3 + 1] = ((((float) iArr[i3]) - f5) + f4) + 0.5f;
            fArr2[i3 + 1] = Math.min((((float) iArr[i3]) + 0.5f) / ((float) nextPowerOf2), f);
            f5 = (float) (iArr[i3 + 1] - iArr[i3]);
            f4 = (f3 * f5) / f2;
            f3 -= f4;
            f2 -= f5;
            f4 += fArr[i3 + 1];
            f5 = (float) iArr[i3 + 1];
            fArr[i3 + 2] = f4 - 0.5f;
            fArr2[i3 + 2] = Math.min((f5 - 0.5f) / ((float) nextPowerOf2), f);
        }
        fArr[iArr.length + 1] = (float) i2;
        fArr2[iArr.length + 1] = f;
        int length2 = iArr.length + 2;
        i3 = 0;
        for (int i4 = 1; i4 < length2; i4++) {
            if (fArr[i4] - fArr[i3] >= 1.0f) {
                i3++;
                fArr[i3] = fArr[i4];
                fArr2[i3] = fArr2[i4];
            }
        }
        return i3 + 1;
    }

    public void draw(GLCanvas gLCanvas, NinePatchTexture ninePatchTexture, int i, int i2) {
        if (this.mBufferNames == null) {
            prepareBuffers(gLCanvas);
        }
        gLCanvas.drawMesh(ninePatchTexture, i, i2, this.mBufferNames[0], this.mBufferNames[1], this.mBufferNames[2], this.mIdxCount);
    }

    public void recycle(GLCanvas gLCanvas) {
        if (this.mBufferNames != null) {
            gLCanvas.deleteBuffer(this.mBufferNames[0]);
            gLCanvas.deleteBuffer(this.mBufferNames[1]);
            gLCanvas.deleteBuffer(this.mBufferNames[2]);
            this.mBufferNames = null;
        }
    }
}
