package com.android.gallery3d.util;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.ConditionVariable;
import android.os.Environment;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.android.gallery3d.app.Gallery;
import com.android.gallery3d.app.PackagesMonitor;
import com.android.gallery3d.data.MediaItem;
import com.android.gallery3d.ui.TiledScreenNail;
import com.android.gallery3d.util.ThreadPool.CancelListener;
import com.android.gallery3d.util.ThreadPool.JobContext;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class GalleryUtils {
    private static final String CAMERA_LAUNCHER_NAME = "com.android.camera.CameraLauncher";
    private static final String DIR_TYPE_IMAGE = "vnd.android.cursor.dir/image";
    private static final String DIR_TYPE_VIDEO = "vnd.android.cursor.dir/video";
    private static final double EARTH_RADIUS_METERS = 6367000.0d;
    private static final String KEY_CAMERA_UPDATE = "camera-update";
    private static final String KEY_HAS_CAMERA = "has-camera";
    private static final String MAPS_CLASS_NAME = "com.google.android.maps.MapsActivity";
    private static final String MAPS_PACKAGE_NAME = "com.google.android.apps.maps";
    public static final String MIME_TYPE_ALL = "*/*";
    public static final String MIME_TYPE_IMAGE = "image/*";
    public static final String MIME_TYPE_VIDEO = "video/*";
    private static final String PREFIX_HAS_PHOTO_EDITOR = "has-editor-";
    private static final String PREFIX_PHOTO_EDITOR_UPDATE = "editor-update-";
    private static final double RAD_PER_DEG = 0.017453292519943295d;
    private static final String TAG = "GalleryUtils";
    private static boolean sCameraAvailable;
    private static boolean sCameraAvailableInitialized = false;
    private static volatile Thread sCurrentThread;
    private static float sPixelDensity = -1.0f;
    private static volatile boolean sWarned;

    public static double accurateDistanceMeters(double d, double d2, double d3, double d4) {
        double sin = Math.sin(0.5d * (d3 - d));
        double sin2 = Math.sin(0.5d * (d4 - d2));
        sin = (sin * sin) + (((sin2 * sin2) * Math.cos(d)) * Math.cos(d3));
        return (Math.atan2(Math.sqrt(sin), Math.sqrt(Math.max(0.0d, 1.0d - sin))) * 2.0d) * EARTH_RADIUS_METERS;
    }

    public static void assertNotInRenderThread() {
        if (!sWarned && Thread.currentThread() == sCurrentThread) {
            sWarned = true;
            Log.w(TAG, new Throwable("Should not do this in render thread"));
        }
    }

    @TargetApi(11)
    public static int determineTypeBits(Context context, Intent intent) {
        return 1;
    }

    public static float dpToPixel(float f) {
        return sPixelDensity * f;
    }

    public static int dpToPixel(int i) {
        return Math.round(dpToPixel((float) i));
    }

    public static void fakeBusy(JobContext jobContext, int i) {
        final ConditionVariable conditionVariable = new ConditionVariable();
        jobContext.setCancelListener(new CancelListener() {
            public void onCancel() {
                conditionVariable.open();
            }
        });
        conditionVariable.block((long) i);
        jobContext.setCancelListener(null);
    }

    public static double fastDistanceMeters(double d, double d2, double d3, double d4) {
        if (Math.abs(d - d3) > RAD_PER_DEG || Math.abs(d2 - d4) > RAD_PER_DEG) {
            return accurateDistanceMeters(d, d2, d3, d4);
        }
        double d5 = d - d3;
        double d6 = d2 - d4;
        double cos = Math.cos((d + d3) / 2.0d);
        return Math.sqrt((d5 * d5) + (d6 * ((cos * cos) * d6))) * EARTH_RADIUS_METERS;
    }

    public static String formatLatitudeLongitude(String str, double d, double d2) {
        return String.format(Locale.ENGLISH, str, new Object[]{Double.valueOf(d), Double.valueOf(d2)});
    }

    public static int getBucketId(String str) {
        return str.toLowerCase().hashCode();
    }

    public static byte[] getBytes(String str) {
        int i = 0;
        byte[] bArr = new byte[(str.length() * 2)];
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length;
        int i2 = 0;
        while (i < length) {
            char c = toCharArray[i];
            int i3 = i2 + 1;
            bArr[i2] = (byte) (c & 255);
            i2 = i3 + 1;
            bArr[i3] = (byte) (c >> 8);
            i++;
        }
        return bArr;
    }

    public static boolean hasSpaceForSize(long j) {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return false;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > j;
        } catch (Throwable e) {
            Log.i(TAG, "Fail to access external storage", e);
            return false;
        }
    }

    public static void initialize(Context context) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        sPixelDensity = displayMetrics.density;
        TiledScreenNail.setPlaceholderColor(Color.parseColor("#333333"));
        initializeThumbnailSizes(displayMetrics, context.getResources());
    }

    private static void initializeThumbnailSizes(DisplayMetrics displayMetrics, Resources resources) {
        int max = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels);
        MediaItem.setThumbnailSizes(max / 2, max / 5);
        TiledScreenNail.setMaxSide(max / 2);
    }

    public static float[] intColorToFloatARGBArray(int i) {
        return new float[]{((float) Color.alpha(i)) / 255.0f, ((float) Color.red(i)) / 255.0f, ((float) Color.green(i)) / 255.0f, ((float) Color.blue(i)) / 255.0f};
    }

    public static boolean isAnyCameraAvailable(Context context) {
        boolean z = false;
        int packagesVersion = PackagesMonitor.getPackagesVersion(context);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (defaultSharedPreferences.getInt(KEY_CAMERA_UPDATE, 0) != packagesVersion) {
            List queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.media.action.STILL_IMAGE_CAMERA"), 0);
            Editor putInt = defaultSharedPreferences.edit().putInt(KEY_CAMERA_UPDATE, packagesVersion);
            String str = KEY_HAS_CAMERA;
            if (!queryIntentActivities.isEmpty()) {
                z = true;
            }
            putInt.putBoolean(str, z).commit();
        }
        return defaultSharedPreferences.getBoolean(KEY_HAS_CAMERA, true);
    }

    public static boolean isCameraAvailable(Context context) {
        boolean z = true;
        if (sCameraAvailableInitialized) {
            return sCameraAvailable;
        }
        int componentEnabledSetting = context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, CAMERA_LAUNCHER_NAME));
        sCameraAvailableInitialized = true;
        if (!(componentEnabledSetting == 0 || componentEnabledSetting == 1)) {
            z = false;
        }
        sCameraAvailable = z;
        return sCameraAvailable;
    }

    public static boolean isEditorAvailable(Context context, String str) {
        boolean z = false;
        int packagesVersion = PackagesMonitor.getPackagesVersion(context);
        String str2 = PREFIX_PHOTO_EDITOR_UPDATE + str;
        String str3 = PREFIX_HAS_PHOTO_EDITOR + str;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (defaultSharedPreferences.getInt(str2, 0) != packagesVersion) {
            List queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.EDIT").setType(str), 0);
            Editor putInt = defaultSharedPreferences.edit().putInt(str2, packagesVersion);
            if (!queryIntentActivities.isEmpty()) {
                z = true;
            }
            putInt.putBoolean(str3, z).commit();
        }
        return defaultSharedPreferences.getBoolean(str3, true);
    }

    public static boolean isHighResolution(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels > 2048 || displayMetrics.widthPixels > 2048;
    }

    public static boolean isPanorama(MediaItem mediaItem) {
        if (mediaItem == null) {
            return false;
        }
        int width = mediaItem.getWidth();
        int height = mediaItem.getHeight();
        return height > 0 && width / height >= 2;
    }

    public static boolean isValidLocation(double d, double d2) {
        return (d == 0.0d && d2 == 0.0d) ? false : true;
    }

    public static int meterToPixel(float f) {
        return Math.round(dpToPixel((39.37f * f) * 160.0f));
    }

    public static void setRenderThread() {
        sCurrentThread = Thread.currentThread();
    }

    public static void setViewPointMatrix(float[] fArr, float f, float f2, float f3) {
        Arrays.fill(fArr, 0, 16, 0.0f);
        float f4 = -f3;
        fArr[15] = f4;
        fArr[5] = f4;
        fArr[0] = f4;
        fArr[8] = f;
        fArr[9] = f2;
        fArr[11] = 1.0f;
        fArr[10] = 1.0f;
    }

    public static void showOnMap(Context context, double d, double d2) {
        try {
            String formatLatitudeLongitude = formatLatitudeLongitude("http://maps.google.com/maps?f=q&q=(%f,%f)", d, d2);
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(formatLatitudeLongitude)).setComponent(new ComponentName(MAPS_PACKAGE_NAME, MAPS_CLASS_NAME)));
        } catch (Throwable e) {
            Log.e(TAG, "GMM activity not found!", e);
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(formatLatitudeLongitude("geo:%f,%f", d, d2))));
        }
    }

    public static void startCameraActivity(Context context) {
        context.startActivity(new Intent("android.media.action.STILL_IMAGE_CAMERA").setFlags(335544320));
    }

    public static void startGalleryActivity(Context context) {
        context.startActivity(new Intent(context, Gallery.class));
    }

    public static final double toMile(double d) {
        return d / 1609.0d;
    }
}
