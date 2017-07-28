package com.android.camera.gallery;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.android.gallery3d.common.BitmapUtils;
import com.android.gallery3d.common.Utils;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;

public class C0453c {
    public static Bitmap m312a(Bitmap bitmap) {
        if (bitmap == null || bitmap.getConfig() != null) {
            return bitmap;
        }
        Bitmap copy = bitmap.copy(Config.ARGB_8888, false);
        bitmap.recycle();
        return copy;
    }

    public static Bitmap m313a(FileDescriptor fileDescriptor, Options options, int i) {
        if (options == null) {
            options = new Options();
        }
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        options.inSampleSize = BitmapUtils.computeSampleSizeLarger(options.outWidth, options.outHeight, i);
        options.inJustDecodeBounds = false;
        return C0453c.m312a(BitmapUtils.resizeDownIfTooBig(BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options), i, true));
    }

    public static Bitmap m314a(String str, int i) {
        byte[] bArr = null;
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return null;
        }
        Options options = new Options();
        options.inPreferredConfig = Config.ARGB_8888;
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            if (exifInterface != null) {
                bArr = exifInterface.getThumbnail();
            }
        } catch (Throwable th) {
        }
        return bArr != null ? C0453c.m316a(bArr, options, i) : C0453c.m315a(str, options, i);
    }

    public static Bitmap m315a(String str, Options options, int i) {
        Throwable th;
        Bitmap bitmap = null;
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                bitmap = C0453c.m313a(fileInputStream.getFD(), options, i);
                Utils.closeSilently(fileInputStream);
            } catch (Exception e) {
                Utils.closeSilently(fileInputStream);
                return bitmap;
            } catch (Throwable th2) {
                th = th2;
                Utils.closeSilently(fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            fileInputStream = bitmap;
            Utils.closeSilently(fileInputStream);
            return bitmap;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileInputStream = bitmap;
            th = th4;
            Utils.closeSilently(fileInputStream);
            throw th;
        }
        return bitmap;
    }

    public static Bitmap m316a(byte[] bArr, Options options, int i) {
        if (options == null) {
            options = new Options();
        }
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        options.inSampleSize = BitmapUtils.computeSampleSizeLarger(options.outWidth, options.outHeight, i);
        options.inJustDecodeBounds = false;
        return C0453c.m312a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options));
    }
}
