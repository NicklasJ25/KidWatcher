package com.android.gallery3d.common;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.util.Log;
import com.android.gallery3d.data.MediaItem;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;

public class BitmapUtils {
    private static final int DEFAULT_JPEG_QUALITY = 90;
    private static final String TAG = "BitmapUtils";
    public static final int UNCONSTRAINED = -1;

    private BitmapUtils() {
    }

    public static byte[] compressToBytes(Bitmap bitmap) {
        return compressToBytes(bitmap, 90);
    }

    public static byte[] compressToBytes(Bitmap bitmap, int i) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(65536);
        bitmap.compress(CompressFormat.JPEG, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static int computeInitialSampleSize(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i4 == -1 && i3 == -1) {
            return 1;
        }
        if (i4 != -1) {
            i5 = (int) Math.ceil(Math.sqrt((double) (((float) (i * i2)) / ((float) i4))));
        }
        return i3 != -1 ? Math.max(Math.min(i / i3, i2 / i3), i5) : i5;
    }

    public static int computeSampleSize(float f) {
        Utils.assertTrue(f > 0.0f);
        int max = Math.max(1, (int) Math.ceil((double) (1.0f / f)));
        return max <= 8 ? Utils.nextPowerOf2(max) : ((max + 7) / 8) * 8;
    }

    public static int computeSampleSize(int i, int i2, int i3, int i4) {
        int computeInitialSampleSize = computeInitialSampleSize(i, i2, i3, i4);
        return computeInitialSampleSize <= 8 ? Utils.nextPowerOf2(computeInitialSampleSize) : ((computeInitialSampleSize + 7) / 8) * 8;
    }

    public static int computeSampleSizeLarger(float f) {
        int floor = (int) Math.floor((double) (1.0f / f));
        return floor <= 1 ? 1 : floor <= 8 ? Utils.prevPowerOf2(floor) : (floor / 8) * 8;
    }

    public static int computeSampleSizeLarger(int i, int i2, int i3) {
        int max = Math.max(i / i3, i2 / i3);
        return max <= 1 ? 1 : max <= 8 ? Utils.prevPowerOf2(max) : (max / 8) * 8;
    }

    public static Bitmap createVideoThumbnail(String str) {
        Object obj;
        Class cls;
        Throwable e;
        Class cls2;
        Object newInstance;
        try {
            cls2 = Class.forName("android.media.MediaMetadataRetriever");
            try {
                newInstance = cls2.newInstance();
                try {
                    cls2.getMethod("setDataSource", new Class[]{String.class}).invoke(newInstance, new Object[]{str});
                    Bitmap bitmap;
                    if (VERSION.SDK_INT <= 9) {
                        bitmap = (Bitmap) cls2.getMethod("captureFrame", new Class[0]).invoke(newInstance, new Object[0]);
                        if (newInstance == null) {
                            return bitmap;
                        }
                        try {
                            cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
                            return bitmap;
                        } catch (Exception e2) {
                            return bitmap;
                        }
                    }
                    byte[] bArr = (byte[]) cls2.getMethod("getEmbeddedPicture", new Class[0]).invoke(newInstance, new Object[0]);
                    if (bArr != null) {
                        bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                        if (bitmap != null) {
                            if (newInstance == null) {
                                return bitmap;
                            }
                            try {
                                cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
                                return bitmap;
                            } catch (Exception e3) {
                                return bitmap;
                            }
                        }
                    }
                    bitmap = (Bitmap) cls2.getMethod("getFrameAtTime", new Class[0]).invoke(newInstance, new Object[0]);
                    if (newInstance == null) {
                        return bitmap;
                    }
                    try {
                        cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
                        return bitmap;
                    } catch (Exception e4) {
                        return bitmap;
                    }
                } catch (IllegalArgumentException e5) {
                    obj = newInstance;
                    cls = cls2;
                    if (obj != null) {
                        try {
                            cls.getMethod("release", new Class[0]).invoke(obj, new Object[0]);
                        } catch (Exception e6) {
                        }
                    }
                    return null;
                } catch (RuntimeException e7) {
                    if (newInstance != null) {
                        try {
                            cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
                        } catch (Exception e8) {
                        }
                    }
                    return null;
                } catch (InstantiationException e9) {
                    e = e9;
                    try {
                        Log.e(TAG, "createVideoThumbnail", e);
                        if (newInstance != null) {
                            try {
                                cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
                            } catch (Exception e10) {
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (newInstance != null) {
                            try {
                                cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
                            } catch (Exception e11) {
                            }
                        }
                        throw e;
                    }
                } catch (InvocationTargetException e12) {
                    e = e12;
                    Log.e(TAG, "createVideoThumbnail", e);
                    if (newInstance != null) {
                        try {
                            cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
                        } catch (Exception e13) {
                        }
                    }
                    return null;
                } catch (ClassNotFoundException e14) {
                    e = e14;
                    Log.e(TAG, "createVideoThumbnail", e);
                    if (newInstance != null) {
                        try {
                            cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
                        } catch (Exception e15) {
                        }
                    }
                    return null;
                } catch (NoSuchMethodException e16) {
                    e = e16;
                    Log.e(TAG, "createVideoThumbnail", e);
                    if (newInstance != null) {
                        try {
                            cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
                        } catch (Exception e17) {
                        }
                    }
                    return null;
                } catch (IllegalAccessException e18) {
                    e = e18;
                    Log.e(TAG, "createVideoThumbnail", e);
                    if (newInstance != null) {
                        try {
                            cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
                        } catch (Exception e19) {
                        }
                    }
                    return null;
                }
            } catch (IllegalArgumentException e20) {
                obj = null;
                cls = cls2;
                if (obj != null) {
                    cls.getMethod("release", new Class[0]).invoke(obj, new Object[0]);
                }
                return null;
            } catch (RuntimeException e21) {
                newInstance = null;
                if (newInstance != null) {
                    cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
                }
                return null;
            } catch (InstantiationException e22) {
                e = e22;
                newInstance = null;
                Log.e(TAG, "createVideoThumbnail", e);
                if (newInstance != null) {
                    cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
                }
                return null;
            } catch (InvocationTargetException e23) {
                e = e23;
                newInstance = null;
                Log.e(TAG, "createVideoThumbnail", e);
                if (newInstance != null) {
                    cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
                }
                return null;
            } catch (ClassNotFoundException e24) {
                e = e24;
                newInstance = null;
                Log.e(TAG, "createVideoThumbnail", e);
                if (newInstance != null) {
                    cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
                }
                return null;
            } catch (NoSuchMethodException e25) {
                e = e25;
                newInstance = null;
                Log.e(TAG, "createVideoThumbnail", e);
                if (newInstance != null) {
                    cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
                }
                return null;
            } catch (IllegalAccessException e26) {
                e = e26;
                newInstance = null;
                Log.e(TAG, "createVideoThumbnail", e);
                if (newInstance != null) {
                    cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
                }
                return null;
            } catch (Throwable th2) {
                e = th2;
                newInstance = null;
                if (newInstance != null) {
                    cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
                }
                throw e;
            }
        } catch (IllegalArgumentException e27) {
            obj = null;
            cls = null;
            if (obj != null) {
                cls.getMethod("release", new Class[0]).invoke(obj, new Object[0]);
            }
            return null;
        } catch (RuntimeException e28) {
            newInstance = null;
            cls2 = null;
            if (newInstance != null) {
                cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
            }
            return null;
        } catch (InstantiationException e29) {
            e = e29;
            newInstance = null;
            cls2 = null;
            Log.e(TAG, "createVideoThumbnail", e);
            if (newInstance != null) {
                cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
            }
            return null;
        } catch (InvocationTargetException e30) {
            e = e30;
            newInstance = null;
            cls2 = null;
            Log.e(TAG, "createVideoThumbnail", e);
            if (newInstance != null) {
                cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
            }
            return null;
        } catch (ClassNotFoundException e31) {
            e = e31;
            newInstance = null;
            cls2 = null;
            Log.e(TAG, "createVideoThumbnail", e);
            if (newInstance != null) {
                cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
            }
            return null;
        } catch (NoSuchMethodException e32) {
            e = e32;
            newInstance = null;
            cls2 = null;
            Log.e(TAG, "createVideoThumbnail", e);
            if (newInstance != null) {
                cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
            }
            return null;
        } catch (IllegalAccessException e33) {
            e = e33;
            newInstance = null;
            cls2 = null;
            Log.e(TAG, "createVideoThumbnail", e);
            if (newInstance != null) {
                cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
            }
            return null;
        } catch (Throwable th3) {
            e = th3;
            newInstance = null;
            cls2 = null;
            if (newInstance != null) {
                cls2.getMethod("release", new Class[0]).invoke(newInstance, new Object[0]);
            }
            throw e;
        }
    }

    private static Config getConfig(Bitmap bitmap) {
        Config config = bitmap.getConfig();
        return config == null ? Config.ARGB_8888 : config;
    }

    public static boolean isRotationSupported(String str) {
        return str == null ? false : str.toLowerCase().equals(MediaItem.MIME_TYPE_JPEG);
    }

    public static boolean isSupportedByRegionDecoder(String str) {
        if (str == null) {
            return false;
        }
        String toLowerCase = str.toLowerCase();
        return (!toLowerCase.startsWith("image/") || toLowerCase.equals("image/gif") || toLowerCase.endsWith("bmp")) ? false : true;
    }

    public static void recycleSilently(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                bitmap.recycle();
            } catch (Throwable th) {
                Log.w(TAG, "unable recycle bitmap", th);
            }
        }
    }

    public static Bitmap resizeAndCropCenter(Bitmap bitmap, int i, boolean z) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == i && height == i) {
            return bitmap;
        }
        float min = ((float) i) / ((float) Math.min(width, height));
        Bitmap createBitmap = Bitmap.createBitmap(i, i, getConfig(bitmap));
        int round = Math.round(((float) bitmap.getWidth()) * min);
        int round2 = Math.round(((float) bitmap.getHeight()) * min);
        Canvas canvas = new Canvas(createBitmap);
        canvas.translate(((float) (i - round)) / 2.0f, ((float) (i - round2)) / 2.0f);
        canvas.scale(min, min);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint(6));
        if (z) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap resizeBitmapByScale(Bitmap bitmap, float f, boolean z) {
        int round = Math.round(((float) bitmap.getWidth()) * f);
        int round2 = Math.round(((float) bitmap.getHeight()) * f);
        if (round == bitmap.getWidth() && round2 == bitmap.getHeight()) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(round, round2, getConfig(bitmap));
        Canvas canvas = new Canvas(createBitmap);
        canvas.scale(f, f);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint(6));
        if (z) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap resizeDownBySideLength(Bitmap bitmap, int i, boolean z) {
        float min = Math.min(((float) i) / ((float) bitmap.getWidth()), ((float) i) / ((float) bitmap.getHeight()));
        return min >= 1.0f ? bitmap : resizeBitmapByScale(bitmap, min, z);
    }

    public static Bitmap resizeDownIfTooBig(Bitmap bitmap, int i, boolean z) {
        float max = Math.max(((float) i) / ((float) bitmap.getWidth()), ((float) i) / ((float) bitmap.getHeight()));
        return max > 0.5f ? bitmap : resizeBitmapByScale(bitmap, max, z);
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i, boolean z) {
        if (i == 0) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        if (z) {
            bitmap.recycle();
        }
        return createBitmap;
    }
}
