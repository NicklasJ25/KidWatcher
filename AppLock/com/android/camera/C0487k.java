package com.android.camera;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Log;
import com.android.camera.gallery.C0449h;
import com.android.camera.gallery.HidedPictureItem;
import com.android.gallery3d.common.Entry.Columns;
import com.android.gallery3d.data.MediaItem;
import com.android.gallery3d.exif.ExifTag.GpsMeasureMode;
import com.domobile.applock.C1150y;
import com.domobile.frame.C0399d;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.p016c.C1170b;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Random;
import org.apache.p068a.p069a.C3613c;

public class C0487k {
    public static final int f302a = "/dont_remove/".length();
    public static FileFilter f303b = new C04843();

    static class C04832 implements FileFilter {
        C04832() {
        }

        public boolean accept(File file) {
            return file.isDirectory();
        }
    }

    static class C04843 implements FileFilter {
        C04843() {
        }

        public boolean accept(File file) {
            return file.isFile();
        }
    }

    static class C04854 implements FileFilter {
        C04854() {
        }

        public boolean accept(File file) {
            if (file.isDirectory()) {
                String name = file.getName();
                if (name.startsWith(".") && new File(file, "/dont_remove/6c9d3f90697a41b").exists() && !name.endsWith("MySecurityData2")) {
                    return true;
                }
            }
            return false;
        }
    }

    public enum C0486a {
        TYPE_IMAGE,
        TYPE_VIDEO,
        TYPE_THUMB
    }

    public static int m396a(Options options, int i, int i2) {
        int b = C0487k.m421b(options, i, i2);
        if (b > 8) {
            return ((b + 7) / 8) * 8;
        }
        int i3 = 1;
        while (i3 < b) {
            i3 <<= 1;
        }
        return i3;
    }

    public static int m397a(String str, boolean z) {
        String str2 = z ? "file_type like '%video%'" : "file_type like '%image%'";
        try {
            Cursor query = C0411e.m157a().query("medias", new String[]{"COUNT(*)"}, C1147a.m2480a(str2, " and album=?"), new String[]{str}, null, null, null);
            if (query == null) {
                return 0;
            }
            int i = query.moveToFirst() ? query.getInt(0) : 0;
            try {
                query.close();
                return i;
            } catch (Exception e) {
                return i;
            }
        } catch (Exception e2) {
            return 0;
        }
    }

    @TargetApi(17)
    public static long m398a(Context context, File file) {
        long j;
        long j2;
        ContentResolver contentResolver = context.getContentResolver();
        if (C1150y.O >= 17) {
            j = (long) Global.getInt(contentResolver, "sys_storage_threshold_percentage", 10);
            j2 = Global.getLong(contentResolver, "sys_storage_threshold_max_bytes", 524288000);
        } else {
            j = (long) Secure.getInt(contentResolver, "sys_storage_threshold_percentage", 10);
            j2 = Secure.getLong(contentResolver, "sys_storage_threshold_max_bytes", 524288000);
        }
        return Math.min((j * file.getTotalSpace()) / 100, j2);
    }

    public static Cursor m399a(String str) {
        try {
            return C0411e.m157a().query("medias", null, C1147a.m2480a(Columns.ID, "=", str), null, null, null, null, null);
        } catch (Exception e) {
            return null;
        }
    }

    public static Cursor m400a(String str, boolean z, int i) {
        Cursor cursor = null;
        String str2 = z ? "file_type like '%video%'" : "file_type like '%image%'";
        try {
            cursor = C0411e.m157a().query("medias", null, C1147a.m2480a(str2, " and album=?"), new String[]{str}, null, null, null, i == -1 ? cursor : String.valueOf(i));
        } catch (Exception e) {
        }
        return cursor;
    }

    public static Cursor m401a(boolean z, String str) {
        String[] strArr;
        String str2;
        Cursor cursor = null;
        String str3 = z ? "file_type like '%video%'" : "file_type like '%image%'";
        if (TextUtils.isEmpty(str)) {
            strArr = cursor;
            str2 = str3;
        } else {
            str2 = C1147a.m2480a(str3, " and album=?");
            strArr = new String[]{str};
        }
        try {
            cursor = C0411e.m157a().query("medias", new String[]{"distinct(album)"}, str2, strArr, null, null, null);
        } catch (Exception e) {
        }
        return cursor;
    }

    public static Bitmap m402a(int i, int i2, Uri uri, ContentResolver contentResolver, ParcelFileDescriptor parcelFileDescriptor, Options options) {
        Bitmap bitmap = null;
        if (parcelFileDescriptor == null) {
            try {
                parcelFileDescriptor = C0487k.m407a(uri, contentResolver);
            } catch (Throwable e) {
                Log.e("Util", "Got oom exception ", e);
            } finally {
                C0487k.m413a(parcelFileDescriptor);
            }
        }
        if (parcelFileDescriptor == null) {
            C0487k.m413a(parcelFileDescriptor);
        } else {
            if (options == null) {
                options = new Options();
            }
            FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
            options.inJustDecodeBounds = true;
            C0390a.m84a().m88a(fileDescriptor, options);
            if (options.mCancel || options.outWidth == -1 || options.outHeight == -1) {
                C0487k.m413a(parcelFileDescriptor);
            } else {
                options.inSampleSize = C0487k.m396a(options, i, i2);
                options.inJustDecodeBounds = false;
                options.inDither = false;
                options.inPreferredConfig = Config.ARGB_8888;
                bitmap = C0390a.m84a().m88a(fileDescriptor, options);
                C0487k.m413a(parcelFileDescriptor);
            }
        }
        return bitmap;
    }

    public static Bitmap m403a(int i, int i2, ParcelFileDescriptor parcelFileDescriptor, boolean z) {
        return C0487k.m402a(i, i2, null, null, parcelFileDescriptor, z ? C0487k.m406a() : null);
    }

    public static Bitmap m404a(Bitmap bitmap, int i) {
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

    public static Bitmap m405a(Matrix matrix, Bitmap bitmap, int i, int i2, boolean z, boolean z2) {
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        float min = Math.min(width / ((float) i), height / ((float) i2));
        int i3 = ((int) (width - (((float) i) * min))) / 2;
        int i4 = ((int) (height - (((float) i2) * min))) / 2;
        Rect rect = new Rect(i3, i4, ((int) (((float) i) * min)) + i3, ((int) (min * ((float) i2))) + i4);
        Rect rect2 = new Rect(0, 0, i, i2);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, rect, rect2, null);
        if (z2) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Options m406a() {
        Options options = new Options();
        options.inPurgeable = true;
        try {
            Field field = options.getClass().getField("inNativeAlloc");
            field.setAccessible(true);
            field.setBoolean(options, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return options;
    }

    private static ParcelFileDescriptor m407a(Uri uri, ContentResolver contentResolver) {
        try {
            return contentResolver.openFileDescriptor(uri, "r");
        } catch (IOException e) {
            return null;
        }
    }

    public static C0486a m408a(C0449h c0449h) {
        CharSequence mimeType = c0449h.getMimeType();
        return ((TextUtils.isEmpty(mimeType) || !mimeType.contains("video/")) && !TextUtils.equals(mimeType, "vnd.android.cursor.dir/video")) ? C0486a.TYPE_IMAGE : C0486a.TYPE_VIDEO;
    }

    public static File m409a(Context context, String str, C0486a c0486a) {
        File file = new File(C0487k.m423b(context, String.valueOf(new Random().nextInt(100)), c0486a), str);
        if (!file.getParentFile().exists()) {
            C0487k.m411a(context);
        }
        return file;
    }

    public static String m410a(Context context, String str) {
        return new File(C1150y.m2566a(context).m599m(), str).getAbsolutePath();
    }

    public static void m411a(Context context) {
        for (int i = 0; i < 100; i++) {
            String valueOf = String.valueOf(i);
            new File(C0487k.m423b(context, valueOf, C0486a.TYPE_IMAGE)).mkdirs();
            new File(C0487k.m423b(context, valueOf, C0486a.TYPE_VIDEO)).mkdirs();
            new File(C0487k.m423b(context, valueOf, C0486a.TYPE_THUMB)).mkdirs();
        }
    }

    public static void m412a(Context context, File file, HidedPictureItem hidedPictureItem, boolean z) {
        if (!file.exists() || file.isDirectory()) {
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
            return;
        }
        ImageManager.m32a(context.getContentResolver(), file.getName(), file.lastModified(), file.getParent(), file.getName(), hidedPictureItem.getMimeType(), z, hidedPictureItem.getRotation());
    }

    public static void m413a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (Throwable th) {
            }
        }
    }

    public static void m414a(final C0399d c0399d) {
        new Thread() {
            public void run() {
                c0399d.showLoadingDialog();
                C0487k.m426c(c0399d.mActivity);
                C1148d.m2489A(c0399d.mActivity, "com.domobile.elock.action.ACTION_SCAN_UNTRACKED_IMAGES_COMPLETE");
                c0399d.hideLoadingDialog();
            }
        }.start();
    }

    private static void m415a(File file, boolean z) {
        try {
            String name = file.getName();
            File file2 = new File(C1150y.L, ((!z ? Environment.DIRECTORY_DCIM : Environment.DIRECTORY_MOVIES) + File.separator) + name);
            ContentValues contentValues = new ContentValues();
            contentValues.put("file_type", z ? "video/mp4" : MediaItem.MIME_TYPE_JPEG);
            contentValues.put("album", file2.getParentFile().getName());
            contentValues.put("from_path", file2.getAbsolutePath());
            contentValues.put("dest_path", file.getAbsolutePath());
            contentValues.put("file_ext", z ? "mp4" : "jpg");
            contentValues.put("timestamp", Long.valueOf(name));
            contentValues.put("file_name", name);
            contentValues.put("rotation", Integer.valueOf(0));
            C0411e.m157a().insert("medias", null, contentValues);
        } catch (Exception e) {
        }
    }

    public static boolean m416a(Context context, long j, File file) {
        if (C1150y.O <= 8) {
            return true;
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return file.getParentFile().getFreeSpace() >= C0487k.m398a(context, file.getParentFile()) + j;
    }

    public static boolean m417a(Context context, File file, File file2) {
        boolean z = true;
        if (C1150y.O <= 8) {
            return true;
        }
        try {
            if (!file2.getParentFile().exists()) {
                z = file2.getParentFile().mkdirs();
            }
            if (!z) {
                try {
                    file2 = new File(C1150y.f2214a, file2.getName());
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
        }
        return file2.getParentFile().getFreeSpace() < C0487k.m398a(context, file2.getParentFile()) + file.length() ? false : C0487k.m416a(context, file.length(), file2);
    }

    public static boolean m418a(HidedPictureItem hidedPictureItem) {
        String mimeType = hidedPictureItem.getMimeType();
        return TextUtils.isEmpty(mimeType) ? false : TextUtils.equals(mimeType, "vnd.android.cursor.dir/image") || TextUtils.equals(mimeType, "vnd.android.cursor.dir/video") || mimeType.contains("image/") || mimeType.contains("video/");
    }

    private static boolean m419a(File file) {
        try {
            int lastIndexOf = file.getAbsolutePath().lastIndexOf("/dont_remove/");
            if (lastIndexOf < 0) {
                return true;
            }
            Cursor query = C0411e.m157a().query("medias", null, "dest_path like '%" + file.getAbsolutePath().substring(lastIndexOf + f302a) + "'", null, null, null, null);
            if (query == null) {
                return true;
            }
            int count = query.getCount();
            query.close();
            return count >= 1;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static int m420b() {
        if (!C1147a.m2484c()) {
            return 0;
        }
        try {
            Cursor query = C0411e.m157a().query("medias", new String[]{Columns.ID}, null, null, null, null, null);
            if (query != null) {
                int count = query.getCount();
                query.close();
                return count;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    private static int m421b(Options options, int i, int i2) {
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        int min = i == -1 ? 128 : (int) Math.min(Math.floor(d / ((double) i)), Math.floor(d2 / ((double) i)));
        return min < ceil ? ceil : (i2 == -1 && i == -1) ? 1 : i != -1 ? min : ceil;
    }

    public static File m422b(Context context, String str) {
        File file = new File(C1150y.m2566a(context).m599m(), ".cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str);
    }

    public static String m423b(Context context, String str, C0486a c0486a) {
        String str2 = ".image";
        if (c0486a == C0486a.TYPE_VIDEO) {
            str2 = ".video";
        } else if (c0486a == C0486a.TYPE_THUMB) {
            str2 = ".thumb";
        }
        return new File(C1150y.m2566a(context).m599m(), C1147a.m2480a(C1170b.m2685b(str), File.separator, str2)).getAbsolutePath();
    }

    public static void m424b(Context context) {
        File file = new File(C1150y.m2566a(context).m599m(), ".cache");
        try {
            if (file.exists()) {
                C3613c.m15739c(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String m425c(Context context, String str) {
        int indexOf = str.indexOf("/dont_remove/");
        if (indexOf == -1) {
            return str;
        }
        return new File(C1150y.m2566a(context).m599m(), str.substring(indexOf + f302a)).getAbsolutePath();
    }

    public static void m426c(Context context) {
        File m = C1150y.m2566a(context).m599m();
        if (m != null) {
            File[] listFiles = m.listFiles(new C04832());
            if (listFiles != null) {
                for (File file : listFiles) {
                    File[] listFiles2 = new File(file, ".image").listFiles();
                    if (listFiles2 != null) {
                        for (File file2 : listFiles2) {
                            String name = file2.getName();
                            if ((name.startsWith("1") || name.startsWith(GpsMeasureMode.MODE_2_DIMENSIONAL)) && !C0487k.m419a(file2)) {
                                C0487k.m415a(file2, false);
                            }
                        }
                    }
                    File[] listFiles3 = new File(file, ".video").listFiles();
                    if (listFiles3 != null) {
                        for (File file3 : listFiles3) {
                            String name2 = file3.getName();
                            if ((name2.startsWith("1") || name2.startsWith(GpsMeasureMode.MODE_2_DIMENSIONAL)) && !C0487k.m419a(file3)) {
                                C0487k.m415a(file3, true);
                            }
                        }
                    }
                }
            }
        }
    }

    public static File m427d(Context context) {
        File[] listFiles = new File(C1150y.L).listFiles(new C04854());
        if (listFiles != null && listFiles.length > 0) {
            if (listFiles.length == 1) {
                return listFiles[0];
            }
            for (File file : listFiles) {
                if (!file.getName().endsWith(".MySecurityData")) {
                    return file;
                }
            }
        }
        return null;
    }

    public static String m428d(Context context, String str) {
        int indexOf = str.indexOf("/dont_remove/");
        if (indexOf == -1) {
            return str;
        }
        return new File(new File(new File(C1150y.L, ".MySecurityData"), "/dont_remove/"), str.substring(indexOf + f302a)).getAbsolutePath();
    }
}
