package com.android.gallery3d.data;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import com.android.gallery3d.common.ApiHelper;
import com.android.gallery3d.common.BitmapUtils;
import com.android.gallery3d.common.Utils;
import com.android.gallery3d.ui.Log;
import com.android.gallery3d.util.ThreadPool.CancelListener;
import com.android.gallery3d.util.ThreadPool.JobContext;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.InputStream;

public class DecodeUtils {
    private static final String TAG = "DecodeUtils";

    private static class DecodeCanceller implements CancelListener {
        Options mOptions;

        public DecodeCanceller(Options options) {
            this.mOptions = options;
        }

        public void onCancel() {
            this.mOptions.requestCancelDecode();
        }
    }

    public static BitmapRegionDecoder createBitmapRegionDecoder(JobContext jobContext, FileDescriptor fileDescriptor, boolean z) {
        try {
            return BitmapRegionDecoder.newInstance(fileDescriptor, z);
        } catch (Throwable th) {
            Log.m461w(TAG, th);
            return null;
        }
    }

    public static BitmapRegionDecoder createBitmapRegionDecoder(JobContext jobContext, InputStream inputStream, boolean z) {
        try {
            return BitmapRegionDecoder.newInstance(inputStream, z);
        } catch (Throwable th) {
            Log.m459w(TAG, "requestCreateBitmapRegionDecoder: " + th);
            return null;
        }
    }

    public static BitmapRegionDecoder createBitmapRegionDecoder(JobContext jobContext, String str, boolean z) {
        try {
            return BitmapRegionDecoder.newInstance(str, z);
        } catch (Throwable th) {
            Log.m461w(TAG, th);
            return null;
        }
    }

    public static BitmapRegionDecoder createBitmapRegionDecoder(JobContext jobContext, byte[] bArr, int i, int i2, boolean z) {
        if (i < 0 || i2 <= 0 || i + i2 > bArr.length) {
            throw new IllegalArgumentException(String.format("offset = %s, length = %s, bytes = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)}));
        }
        try {
            return BitmapRegionDecoder.newInstance(bArr, i, i2, z);
        } catch (Throwable th) {
            Log.m461w(TAG, th);
            return null;
        }
    }

    public static Bitmap decode(JobContext jobContext, FileDescriptor fileDescriptor, Options options) {
        if (options == null) {
            options = new Options();
        }
        jobContext.setCancelListener(new DecodeCanceller(options));
        setOptionsMutable(options);
        return ensureGLCompatibleBitmap(BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options));
    }

    @TargetApi(11)
    public static Bitmap decode(JobContext jobContext, FileDescriptor fileDescriptor, Options options, BitmapPool bitmapPool) {
        if (bitmapPool == null) {
            return decode(jobContext, fileDescriptor, options);
        }
        if (options == null) {
            options = new Options();
        }
        if (options.inSampleSize < 1) {
            options.inSampleSize = 1;
        }
        options.inPreferredConfig = Config.ARGB_8888;
        options.inBitmap = options.inSampleSize == 1 ? findCachedBitmap(bitmapPool, jobContext, fileDescriptor, options) : null;
        try {
            Bitmap decode = decode(jobContext, fileDescriptor, options);
            if (options.inBitmap == null || options.inBitmap == decode) {
                return decode;
            }
            bitmapPool.recycle(options.inBitmap);
            options.inBitmap = null;
            return decode;
        } catch (IllegalArgumentException e) {
            if (options.inBitmap == null) {
                throw e;
            }
            Log.m459w(TAG, "decode fail with a given bitmap, try decode to a new bitmap");
            bitmapPool.recycle(options.inBitmap);
            options.inBitmap = null;
            return decode(jobContext, fileDescriptor, options);
        }
    }

    public static Bitmap decode(JobContext jobContext, byte[] bArr, int i, int i2, Options options) {
        if (options == null) {
            options = new Options();
        }
        jobContext.setCancelListener(new DecodeCanceller(options));
        setOptionsMutable(options);
        return ensureGLCompatibleBitmap(BitmapFactory.decodeByteArray(bArr, i, i2, options));
    }

    @TargetApi(11)
    public static Bitmap decode(JobContext jobContext, byte[] bArr, int i, int i2, Options options, BitmapPool bitmapPool) {
        if (bitmapPool == null) {
            return decode(jobContext, bArr, i, i2, options);
        }
        Options options2 = options == null ? new Options() : options;
        if (options2.inSampleSize < 1) {
            options2.inSampleSize = 1;
        }
        options2.inPreferredConfig = Config.ARGB_8888;
        options2.inBitmap = options2.inSampleSize == 1 ? findCachedBitmap(bitmapPool, jobContext, bArr, i, i2, options2) : null;
        try {
            Bitmap decode = decode(jobContext, bArr, i, i2, options2);
            if (options2.inBitmap == null || options2.inBitmap == decode) {
                return decode;
            }
            bitmapPool.recycle(options2.inBitmap);
            options2.inBitmap = null;
            return decode;
        } catch (IllegalArgumentException e) {
            if (options2.inBitmap == null) {
                throw e;
            }
            Log.m459w(TAG, "decode fail with a given bitmap, try decode to a new bitmap");
            bitmapPool.recycle(options2.inBitmap);
            options2.inBitmap = null;
            return decode(jobContext, bArr, i, i2, options2);
        }
    }

    public static Bitmap decode(JobContext jobContext, byte[] bArr, Options options) {
        return decode(jobContext, bArr, 0, bArr.length, options);
    }

    public static void decodeBounds(JobContext jobContext, FileDescriptor fileDescriptor, Options options) {
        Utils.assertTrue(options != null);
        options.inJustDecodeBounds = true;
        jobContext.setCancelListener(new DecodeCanceller(options));
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        options.inJustDecodeBounds = false;
    }

    public static void decodeBounds(JobContext jobContext, byte[] bArr, int i, int i2, Options options) {
        Utils.assertTrue(options != null);
        options.inJustDecodeBounds = true;
        jobContext.setCancelListener(new DecodeCanceller(options));
        BitmapFactory.decodeByteArray(bArr, i, i2, options);
        options.inJustDecodeBounds = false;
    }

    public static Bitmap decodeIfBigEnough(JobContext jobContext, byte[] bArr, Options options, int i) {
        if (options == null) {
            options = new Options();
        }
        jobContext.setCancelListener(new DecodeCanceller(options));
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (jobContext.isCancelled() || options.outWidth < i || options.outHeight < i) {
            return null;
        }
        options.inSampleSize = BitmapUtils.computeSampleSizeLarger(options.outWidth, options.outHeight, i);
        options.inJustDecodeBounds = false;
        setOptionsMutable(options);
        return ensureGLCompatibleBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options));
    }

    public static Bitmap decodeThumbnail(JobContext jobContext, FileDescriptor fileDescriptor, Options options, int i, int i2) {
        if (options == null) {
            options = new Options();
        }
        jobContext.setCancelListener(new DecodeCanceller(options));
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        if (jobContext.isCancelled()) {
            return null;
        }
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i2 == 2) {
            options.inSampleSize = BitmapUtils.computeSampleSizeLarger(((float) i) / ((float) Math.min(i3, i4)));
            if ((i3 / options.inSampleSize) * (i4 / options.inSampleSize) > 640000) {
                options.inSampleSize = BitmapUtils.computeSampleSize((float) Math.sqrt((double) (640000.0f / ((float) (i3 * i4)))));
            }
        } else {
            options.inSampleSize = BitmapUtils.computeSampleSizeLarger(((float) i) / ((float) Math.max(i3, i4)));
        }
        options.inJustDecodeBounds = false;
        setOptionsMutable(options);
        Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        if (decodeFileDescriptor == null) {
            return null;
        }
        float min = ((float) i) / ((float) (i2 == 2 ? Math.min(decodeFileDescriptor.getWidth(), decodeFileDescriptor.getHeight()) : Math.max(decodeFileDescriptor.getWidth(), decodeFileDescriptor.getHeight())));
        if (((double) min) <= 0.5d) {
            decodeFileDescriptor = BitmapUtils.resizeBitmapByScale(decodeFileDescriptor, min, true);
        }
        return ensureGLCompatibleBitmap(decodeFileDescriptor);
    }

    public static Bitmap decodeThumbnail(JobContext jobContext, String str, Options options, int i, int i2) {
        Closeable fileInputStream;
        Throwable e;
        Throwable th;
        Bitmap bitmap = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                bitmap = decodeThumbnail(jobContext, fileInputStream.getFD(), options, i, i2);
                Utils.closeSilently(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                try {
                    Log.m461w(TAG, e);
                    Utils.closeSilently(fileInputStream);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    Utils.closeSilently(fileInputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = bitmap;
            Log.m461w(TAG, e);
            Utils.closeSilently(fileInputStream);
            return bitmap;
        } catch (Throwable e4) {
            fileInputStream = bitmap;
            th = e4;
            Utils.closeSilently(fileInputStream);
            throw th;
        }
        return bitmap;
    }

    public static Bitmap ensureGLCompatibleBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.getConfig() != null) {
            return bitmap;
        }
        Bitmap copy = bitmap.copy(Config.ARGB_8888, false);
        bitmap.recycle();
        return copy;
    }

    private static Bitmap findCachedBitmap(BitmapPool bitmapPool, JobContext jobContext, FileDescriptor fileDescriptor, Options options) {
        if (bitmapPool.isOneSize()) {
            return bitmapPool.getBitmap();
        }
        decodeBounds(jobContext, fileDescriptor, options);
        return bitmapPool.getBitmap(options.outWidth, options.outHeight);
    }

    private static Bitmap findCachedBitmap(BitmapPool bitmapPool, JobContext jobContext, byte[] bArr, int i, int i2, Options options) {
        if (bitmapPool.isOneSize()) {
            return bitmapPool.getBitmap();
        }
        decodeBounds(jobContext, bArr, i, i2, options);
        return bitmapPool.getBitmap(options.outWidth, options.outHeight);
    }

    @TargetApi(11)
    public static void setOptionsMutable(Options options) {
        if (ApiHelper.HAS_OPTIONS_IN_MUTABLE) {
            options.inMutable = true;
        }
    }
}
