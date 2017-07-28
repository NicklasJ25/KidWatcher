package com.android.gallery3d.common;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Build.VERSION;
import android.provider.MediaStore.MediaColumns;
import android.view.View;

public class ApiHelper {
    public static final boolean CAN_START_PREVIEW_IN_JPEG_CALLBACK = (VERSION.SDK_INT >= 14);
    public static final boolean ENABLE_PHOTO_EDITOR = (VERSION.SDK_INT >= 14);
    public static final boolean HAS_ACTION_BAR = (VERSION.SDK_INT >= 11);
    public static final boolean HAS_AUTO_FOCUS_MOVE_CALLBACK = (VERSION.SDK_INT >= 16);
    public static final boolean HAS_CAMERA_FOCUS_AREA = (VERSION.SDK_INT >= 14);
    public static final boolean HAS_CAMERA_HDR = (VERSION.SDK_INT >= 17);
    public static final boolean HAS_CAMERA_METERING_AREA = (VERSION.SDK_INT >= 14);
    public static final boolean HAS_EFFECTS_RECORDING = false;
    public static final boolean HAS_EFFECTS_RECORDING_CONTEXT_INPUT = (VERSION.SDK_INT >= 17);
    public static final boolean HAS_FACE_DETECTION;
    public static final boolean HAS_FINE_RESOLUTION_QUALITY_LEVELS = (VERSION.SDK_INT >= 11);
    public static final boolean HAS_GET_CAMERA_DISABLED = hasMethod(DevicePolicyManager.class, "getCameraDisabled", ComponentName.class);
    public static final boolean HAS_GET_SUPPORTED_VIDEO_SIZE = (VERSION.SDK_INT >= 11);
    public static final boolean HAS_INTENT_EXTRA_LOCAL_ONLY = (VERSION.SDK_INT >= 11);
    public static final boolean HAS_INVALIDATE_OPTIONS_MENU = (VERSION.SDK_INT >= 11);
    public static final boolean HAS_MEDIA_ACTION_SOUND = (VERSION.SDK_INT >= 16);
    public static final boolean HAS_MEDIA_COLUMNS_WIDTH_AND_HEIGHT = hasField(MediaColumns.class, "WIDTH");
    public static final boolean HAS_MEDIA_PROVIDER_FILES_TABLE = (VERSION.SDK_INT >= 11);
    public static final boolean HAS_MOTION_EVENT_TRANSFORM = (VERSION.SDK_INT >= 11);
    public static final boolean HAS_MTP = (VERSION.SDK_INT >= 12);
    public static final boolean HAS_OLD_PANORAMA = (VERSION.SDK_INT >= 14);
    public static final boolean HAS_OPTIONS_IN_MUTABLE = (VERSION.SDK_INT >= 11);
    public static final boolean HAS_POST_ON_ANIMATION;
    public static final boolean HAS_RELEASE_SURFACE_TEXTURE = hasMethod("android.graphics.SurfaceTexture", "release", new Class[0]);
    public static final boolean HAS_REMOTE_VIEWS_SERVICE = (VERSION.SDK_INT >= 11);
    public static final boolean HAS_REUSING_BITMAP_IN_BITMAP_FACTORY = (VERSION.SDK_INT >= 11);
    public static final boolean HAS_REUSING_BITMAP_IN_BITMAP_REGION_DECODER = (VERSION.SDK_INT >= 16);
    public static final boolean HAS_SET_BEAM_PUSH_URIS = (VERSION.SDK_INT >= 16);
    public static final boolean HAS_SET_DEFALT_BUFFER_SIZE = hasMethod("android.graphics.SurfaceTexture", "setDefaultBufferSize", Integer.TYPE, Integer.TYPE);
    public static final boolean HAS_SET_ICON_ATTRIBUTE = (VERSION.SDK_INT >= 11);
    public static final boolean HAS_SET_SYSTEM_UI_VISIBILITY = hasMethod(View.class, "setSystemUiVisibility", Integer.TYPE);
    public static final boolean HAS_SURFACE_TEXTURE = (VERSION.SDK_INT >= 11);
    public static final boolean HAS_SURFACE_TEXTURE_RECORDING = (VERSION.SDK_INT >= 16);
    public static final boolean HAS_TIME_LAPSE_RECORDING = (VERSION.SDK_INT >= 11);
    public static final boolean HAS_VIEW_PROPERTY_ANIMATOR = (VERSION.SDK_INT >= 12);
    public static final boolean HAS_VIEW_SYSTEM_UI_FLAG_HIDE_NAVIGATION = hasField(View.class, "SYSTEM_UI_FLAG_HIDE_NAVIGATION");
    public static final boolean HAS_VIEW_SYSTEM_UI_FLAG_LAYOUT_STABLE = hasField(View.class, "SYSTEM_UI_FLAG_LAYOUT_STABLE");
    public static final boolean HAS_VIEW_TRANSFORM_PROPERTIES = (VERSION.SDK_INT >= 11);
    public static final boolean HAS_ZOOM_WHEN_RECORDING = (VERSION.SDK_INT >= 14);
    public static final boolean USE_888_PIXEL_FORMAT = (VERSION.SDK_INT >= 16);

    public interface VERSION_CODES {
        public static final int GINGERBREAD_MR1 = 10;
        public static final int HONEYCOMB = 11;
        public static final int HONEYCOMB_MR1 = 12;
        public static final int HONEYCOMB_MR2 = 13;
        public static final int ICE_CREAM_SANDWICH = 14;
        public static final int ICE_CREAM_SANDWICH_MR1 = 15;
        public static final int JELLY_BEAN = 16;
        public static final int JELLY_BEAN_MR1 = 17;
    }

    static {
        boolean z;
        boolean z2 = true;
        try {
            z = hasMethod(Camera.class, "setFaceDetectionListener", Class.forName("android.hardware.Camera$FaceDetectionListener")) && hasMethod(Camera.class, "startFaceDetection", new Class[0]) && hasMethod(Camera.class, "stopFaceDetection", new Class[0]) && hasMethod(Parameters.class, "getMaxNumDetectedFaces", new Class[0]);
        } catch (Throwable th) {
            z = false;
        }
        HAS_FACE_DETECTION = z;
        if (VERSION.SDK_INT < 16) {
            z2 = false;
        }
        HAS_POST_ON_ANIMATION = z2;
    }

    public static int getIntFieldIfExists(Class<?> cls, String str, Class<?> cls2, int i) {
        try {
            i = cls.getDeclaredField(str).getInt(cls2);
        } catch (Exception e) {
        }
        return i;
    }

    private static boolean hasField(Class<?> cls, String str) {
        try {
            cls.getDeclaredField(str);
            return true;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }

    private static boolean hasMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            cls.getDeclaredMethod(str, clsArr);
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    private static boolean hasMethod(String str, String str2, Class<?>... clsArr) {
        try {
            Class.forName(str).getDeclaredMethod(str2, clsArr);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
