package com.android.gallery3d.util;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import com.android.gallery3d.common.ApiHelper;

public final class MotionEventHelper {
    private MotionEventHelper() {
    }

    private static PointerCoords[] getPointerCoords(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        PointerCoords[] pointerCoordsArr = new PointerCoords[pointerCount];
        for (int i = 0; i < pointerCount; i++) {
            pointerCoordsArr[i] = new PointerCoords();
            motionEvent.getPointerCoords(i, pointerCoordsArr[i]);
        }
        return pointerCoordsArr;
    }

    private static int[] getPointerIds(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        int[] iArr = new int[pointerCount];
        for (int i = 0; i < pointerCount; i++) {
            iArr[i] = motionEvent.getPointerId(i);
        }
        return iArr;
    }

    private static float transformAngle(Matrix matrix, float f) {
        float[] fArr = new float[]{(float) Math.sin((double) f), -((float) Math.cos((double) f))};
        matrix.mapVectors(fArr);
        float atan2 = (float) Math.atan2((double) fArr[0], (double) (-fArr[1]));
        return ((double) atan2) < -1.5707963267948966d ? (float) (((double) atan2) + 3.141592653589793d) : ((double) atan2) > 1.5707963267948966d ? (float) (((double) atan2) - 3.141592653589793d) : atan2;
    }

    public static MotionEvent transformEvent(MotionEvent motionEvent, Matrix matrix) {
        return ApiHelper.HAS_MOTION_EVENT_TRANSFORM ? transformEventNew(motionEvent, matrix) : transformEventOld(motionEvent, matrix);
    }

    @TargetApi(11)
    private static MotionEvent transformEventNew(MotionEvent motionEvent, Matrix matrix) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.transform(matrix);
        return obtain;
    }

    private static MotionEvent transformEventOld(MotionEvent motionEvent, Matrix matrix) {
        int i;
        long downTime = motionEvent.getDownTime();
        long eventTime = motionEvent.getEventTime();
        int action = motionEvent.getAction();
        int pointerCount = motionEvent.getPointerCount();
        int[] pointerIds = getPointerIds(motionEvent);
        PointerCoords[] pointerCoords = getPointerCoords(motionEvent);
        int metaState = motionEvent.getMetaState();
        float xPrecision = motionEvent.getXPrecision();
        float yPrecision = motionEvent.getYPrecision();
        int deviceId = motionEvent.getDeviceId();
        int edgeFlags = motionEvent.getEdgeFlags();
        int source = motionEvent.getSource();
        int flags = motionEvent.getFlags();
        float[] fArr = new float[(pointerCoords.length * 2)];
        for (i = 0; i < pointerCount; i++) {
            fArr[i * 2] = pointerCoords[i].x;
            fArr[(i * 2) + 1] = pointerCoords[i].y;
        }
        matrix.mapPoints(fArr);
        for (i = 0; i < pointerCount; i++) {
            pointerCoords[i].x = fArr[i * 2];
            pointerCoords[i].y = fArr[(i * 2) + 1];
            pointerCoords[i].orientation = transformAngle(matrix, pointerCoords[i].orientation);
        }
        return MotionEvent.obtain(downTime, eventTime, action, pointerCount, pointerIds, pointerCoords, metaState, xPrecision, yPrecision, deviceId, edgeFlags, source, flags);
    }
}
