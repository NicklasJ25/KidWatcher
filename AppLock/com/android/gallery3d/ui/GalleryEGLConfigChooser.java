package com.android.gallery3d.ui;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import com.android.gallery3d.common.ApiHelper;
import com.android.gallery3d.exif.ExifTag.GpsLatitudeRef;
import com.android.gallery3d.exif.ExifTag.GpsStatus;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

class GalleryEGLConfigChooser implements EGLConfigChooser {
    private static final int[] ATTR_ID = new int[]{12324, 12323, 12322, 12321, 12325, 12326, 12328, 12327};
    private static final String[] ATTR_NAME = new String[]{"R", "G", "B", GpsStatus.IN_PROGRESS, "D", GpsLatitudeRef.SOUTH, "ID", "CAVEAT"};
    private static final String TAG = "GalleryEGLConfigChooser";
    private final int[] mConfigSpec565 = new int[]{12324, 5, 12323, 6, 12322, 5, 12321, 0, 12344};
    private final int[] mConfigSpec888 = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 0, 12344};

    GalleryEGLConfigChooser() {
    }

    private EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        EGLConfig eGLConfig = null;
        int i = Integer.MAX_VALUE;
        int[] iArr = new int[1];
        int length = eGLConfigArr.length;
        int i2 = 0;
        while (i2 < length) {
            if (ApiHelper.USE_888_PIXEL_FORMAT || !egl10.eglGetConfigAttrib(eGLDisplay, eGLConfigArr[i2], 12324, iArr) || iArr[0] != 8) {
                if (!egl10.eglGetConfigAttrib(eGLDisplay, eGLConfigArr[i2], 12326, iArr)) {
                    throw new RuntimeException("eglGetConfigAttrib error: " + egl10.eglGetError());
                } else if (iArr[0] != 0 && iArr[0] < r0) {
                    i = iArr[0];
                    eGLConfig = eGLConfigArr[i2];
                }
            }
            i2++;
        }
        if (eGLConfig == null) {
            eGLConfig = eGLConfigArr[0];
        }
        egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, 12326, iArr);
        logConfig(egl10, eGLDisplay, eGLConfig);
        return eGLConfig;
    }

    private void logConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        int[] iArr = new int[1];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ATTR_ID.length; i++) {
            egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, ATTR_ID[i], iArr);
            stringBuilder.append(ATTR_NAME[i] + iArr[0] + " ");
        }
        Log.m455i(TAG, "Config chosen: " + stringBuilder.toString());
    }

    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr = new int[1];
        int[] iArr2 = ApiHelper.USE_888_PIXEL_FORMAT ? this.mConfigSpec888 : this.mConfigSpec565;
        if (!egl10.eglChooseConfig(eGLDisplay, iArr2, null, 0, iArr)) {
            throw new RuntimeException("eglChooseConfig failed");
        } else if (iArr[0] <= 0) {
            throw new RuntimeException("No configs match configSpec");
        } else {
            EGLConfig[] eGLConfigArr = new EGLConfig[iArr[0]];
            if (egl10.eglChooseConfig(eGLDisplay, iArr2, eGLConfigArr, eGLConfigArr.length, iArr)) {
                return chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            }
            throw new RuntimeException();
        }
    }
}
