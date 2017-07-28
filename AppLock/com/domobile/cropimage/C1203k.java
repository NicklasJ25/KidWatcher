package com.domobile.cropimage;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.domobile.cropimage.C0590n.C1201a;
import java.io.FileDescriptor;
import java.io.IOException;

public class C1203k {

    private static class C1202a extends C1201a implements Runnable {
        private final C0590n f2363a;
        private final ProgressDialog f2364b;
        private final Runnable f2365c;
        private final Handler f2366d;
        private final Runnable f2367e = new C11991(this);

        class C11991 implements Runnable {
            final /* synthetic */ C1202a f2362a;

            C11991(C1202a c1202a) {
                this.f2362a = c1202a;
            }

            public void run() {
                this.f2362a.f2363a.m602b(this.f2362a);
                if (this.f2362a.f2364b.getWindow() != null) {
                    this.f2362a.f2364b.dismiss();
                }
            }
        }

        public C1202a(C0590n c0590n, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
            this.f2363a = c0590n;
            this.f2364b = progressDialog;
            this.f2365c = runnable;
            this.f2363a.m601a(this);
            this.f2366d = handler;
        }

        public void mo2517a(C0590n c0590n) {
            this.f2367e.run();
            this.f2366d.removeCallbacks(this.f2367e);
        }

        public void mo2518b(C0590n c0590n) {
            this.f2364b.hide();
        }

        public void mo2519c(C0590n c0590n) {
            this.f2364b.show();
        }

        public void run() {
            try {
                this.f2365c.run();
            } finally {
                this.f2366d.post(this.f2367e);
            }
        }
    }

    public static int m2807a(Options options, int i, int i2) {
        int b = C1203k.m2818b(options, i, i2);
        if (b > 8) {
            return ((b + 7) / 8) * 8;
        }
        int i3 = 1;
        while (i3 < b) {
            i3 <<= 1;
        }
        return i3;
    }

    public static Bitmap m2808a(int i, int i2, Uri uri, ContentResolver contentResolver, ParcelFileDescriptor parcelFileDescriptor, Options options) {
        Bitmap bitmap = null;
        if (parcelFileDescriptor == null) {
            try {
                parcelFileDescriptor = C1203k.m2814a(uri, contentResolver);
            } catch (Throwable e) {
                Log.e("Util", "Got oom exception ", e);
            } finally {
                C1203k.m2815a(parcelFileDescriptor);
            }
        }
        if (parcelFileDescriptor == null) {
            C1203k.m2815a(parcelFileDescriptor);
        } else {
            if (options == null) {
                options = new Options();
            }
            FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
            options.inJustDecodeBounds = true;
            C1183c.m2753a().m2757a(fileDescriptor, options);
            if (options.mCancel || options.outWidth == -1 || options.outHeight == -1) {
                C1203k.m2815a(parcelFileDescriptor);
            } else {
                options.inSampleSize = C1203k.m2807a(options, i, i2);
                options.inJustDecodeBounds = false;
                options.inDither = false;
                options.inPreferredConfig = Config.ARGB_8888;
                bitmap = C1183c.m2753a().m2757a(fileDescriptor, options);
                C1203k.m2815a(parcelFileDescriptor);
            }
        }
        return bitmap;
    }

    public static Bitmap m2809a(int i, int i2, Uri uri, ContentResolver contentResolver, boolean z) {
        ParcelFileDescriptor openFileDescriptor;
        Throwable th;
        try {
            Options a;
            openFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
            if (z) {
                try {
                    a = C1203k.m2813a();
                } catch (IOException e) {
                    C1203k.m2815a(openFileDescriptor);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    C1203k.m2815a(openFileDescriptor);
                    throw th;
                }
            }
            a = null;
            Bitmap a2 = C1203k.m2808a(i, i2, uri, contentResolver, openFileDescriptor, a);
            C1203k.m2815a(openFileDescriptor);
            return a2;
        } catch (IOException e2) {
            openFileDescriptor = null;
            C1203k.m2815a(openFileDescriptor);
            return null;
        } catch (Throwable th3) {
            th = th3;
            openFileDescriptor = null;
            C1203k.m2815a(openFileDescriptor);
            throw th;
        }
    }

    public static Bitmap m2810a(int i, int i2, ParcelFileDescriptor parcelFileDescriptor, boolean z) {
        return C1203k.m2808a(i, i2, null, null, parcelFileDescriptor, z ? C1203k.m2813a() : null);
    }

    public static Bitmap m2811a(Bitmap bitmap, int i) {
        if (i == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == createBitmap) {
                return bitmap;
            }
            bitmap.recycle();
            return createBitmap;
        } catch (OutOfMemoryError e) {
            return bitmap;
        }
    }

    public static Bitmap m2812a(Matrix matrix, Bitmap bitmap, int i, int i2, boolean z, boolean z2) {
        int width = bitmap.getWidth() - i;
        int height = bitmap.getHeight() - i2;
        Bitmap createBitmap;
        if (z || (width >= 0 && height >= 0)) {
            Matrix matrix2;
            float width2 = (float) bitmap.getWidth();
            float height2 = (float) bitmap.getHeight();
            if (width2 / height2 > ((float) i) / ((float) i2)) {
                width2 = ((float) i2) / height2;
                if (width2 < 0.9f || width2 > 1.0f) {
                    matrix.setScale(width2, width2);
                } else {
                    matrix = null;
                }
                matrix2 = matrix;
            } else {
                width2 = ((float) i) / width2;
                if (width2 < 0.9f || width2 > 1.0f) {
                    matrix.setScale(width2, width2);
                    matrix2 = matrix;
                } else {
                    matrix2 = null;
                }
            }
            if (matrix2 != null) {
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true);
            } else {
                createBitmap = bitmap;
            }
            if (z2 && createBitmap != bitmap) {
                bitmap.recycle();
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, Math.max(0, createBitmap.getWidth() - i) / 2, Math.max(0, createBitmap.getHeight() - i2) / 2, i, i2);
            if (createBitmap2 == createBitmap) {
                return createBitmap2;
            }
            if (!z2 && createBitmap == bitmap) {
                return createBitmap2;
            }
            createBitmap.recycle();
            return createBitmap2;
        }
        createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        width = Math.max(0, width / 2);
        int max = Math.max(0, height / 2);
        Rect rect = new Rect(width, max, Math.min(i, bitmap.getWidth()) + width, Math.min(i2, bitmap.getHeight()) + max);
        max = (i - rect.width()) / 2;
        width = (i2 - rect.height()) / 2;
        canvas.drawBitmap(bitmap, rect, new Rect(max, width, i - max, i2 - width), null);
        if (z2) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Options m2813a() {
        return new Options();
    }

    private static ParcelFileDescriptor m2814a(Uri uri, ContentResolver contentResolver) {
        try {
            return contentResolver.openFileDescriptor(uri, "r");
        } catch (IOException e) {
            return null;
        }
    }

    public static void m2815a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (Throwable th) {
            }
        }
    }

    public static void m2816a(C0590n c0590n, String str, String str2, Runnable runnable, Handler handler) {
        new Thread(new C1202a(c0590n, runnable, ProgressDialog.show(c0590n, str, str2, true, false), handler)).start();
    }

    public static boolean m2817a(String str, String str2) {
        return str == str2 || str.equals(str2);
    }

    private static int m2818b(Options options, int i, int i2) {
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        int min = i == -1 ? 128 : (int) Math.min(Math.floor(d / ((double) i)), Math.floor(d2 / ((double) i)));
        return min < ceil ? ceil : (i2 == -1 && i == -1) ? 1 : i != -1 ? min : ceil;
    }
}
