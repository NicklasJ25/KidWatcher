package com.android.gallery3d.ui;

import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11ExtensionPack;

public class GLId {
    static int sNextId = 1;

    public static synchronized void glDeleteBuffers(GL11 gl11, int i, int[] iArr, int i2) {
        synchronized (GLId.class) {
            gl11.glDeleteBuffers(i, iArr, i2);
        }
    }

    public static synchronized void glDeleteFramebuffers(GL11ExtensionPack gL11ExtensionPack, int i, int[] iArr, int i2) {
        synchronized (GLId.class) {
            gL11ExtensionPack.glDeleteFramebuffersOES(i, iArr, i2);
        }
    }

    public static synchronized void glDeleteTextures(GL11 gl11, int i, int[] iArr, int i2) {
        synchronized (GLId.class) {
            gl11.glDeleteTextures(i, iArr, i2);
        }
    }

    public static synchronized void glGenBuffers(int i, int[] iArr, int i2) {
        synchronized (GLId.class) {
            while (true) {
                int i3 = i - 1;
                if (i > 0) {
                    int i4 = i2 + i3;
                    int i5 = sNextId;
                    sNextId = i5 + 1;
                    iArr[i4] = i5;
                    i = i3;
                }
            }
        }
    }

    public static synchronized void glGenTextures(int i, int[] iArr, int i2) {
        synchronized (GLId.class) {
            while (true) {
                int i3 = i - 1;
                if (i > 0) {
                    int i4 = i2 + i3;
                    int i5 = sNextId;
                    sNextId = i5 + 1;
                    iArr[i4] = i5;
                    i = i3;
                }
            }
        }
    }
}
