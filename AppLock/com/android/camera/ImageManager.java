package com.android.camera;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video;
import android.util.Log;
import com.android.camera.gallery.C0382g;
import com.android.camera.gallery.C0450f;
import com.android.camera.gallery.C0452b;
import com.android.camera.gallery.C0457j;
import com.android.camera.gallery.C0462k;
import com.android.camera.gallery.C0466m;
import com.android.camera.gallery.C0468o;
import com.android.gallery3d.data.DownloadEntry.Columns;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ImageManager {
    public static final Uri f32a = Media.EXTERNAL_CONTENT_URI;
    public static final Uri f33b = Video.Media.EXTERNAL_CONTENT_URI;
    private static final Uri f34c = Thumbnails.EXTERNAL_CONTENT_URI;

    public static class ImageListParam implements Parcelable {
        public static final Creator CREATOR = new C03801();
        public C0381a f21a;
        public int f22b;
        public int f23c;
        public String f24d;
        public Uri f25e;
        public boolean f26f;

        static class C03801 implements Creator {
            C03801() {
            }

            public ImageListParam m21a(Parcel parcel) {
                return new ImageListParam(parcel);
            }

            public ImageListParam[] m22a(int i) {
                return new ImageListParam[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m21a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m22a(i);
            }
        }

        private ImageListParam(Parcel parcel) {
            this.f21a = C0381a.values()[parcel.readInt()];
            this.f22b = parcel.readInt();
            this.f23c = parcel.readInt();
            this.f24d = parcel.readString();
            this.f25e = (Uri) parcel.readParcelable(null);
            this.f26f = parcel.readInt() != 0;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return String.format("ImageListParam{loc=%s,inc=%d,sort=%d,bucket=%s,empty=%b,single=%s}", new Object[]{this.f21a, Integer.valueOf(this.f22b), Integer.valueOf(this.f23c), this.f24d, Boolean.valueOf(this.f26f), this.f25e});
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f21a.ordinal());
            parcel.writeInt(this.f22b);
            parcel.writeInt(this.f23c);
            parcel.writeString(this.f24d);
            parcel.writeParcelable(this.f25e, i);
            parcel.writeInt(this.f26f ? 1 : 0);
        }
    }

    public enum C0381a {
        NONE,
        INTERNAL,
        EXTERNAL,
        ALL
    }

    private static class C0383b implements C0382g {
        private C0383b() {
        }

        public C0450f mo2036a(int i) {
            return null;
        }

        public void mo2037a() {
        }

        public HashMap<String, String> mo2038b() {
            return new HashMap();
        }

        public int mo2039c() {
            return 0;
        }
    }

    private static Cursor m31a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursor = null;
        if (contentResolver != null) {
            try {
                cursor = contentResolver.query(uri, strArr, str, strArr2, str2);
            } catch (UnsupportedOperationException e) {
            }
        }
        return cursor;
    }

    public static Uri m32a(ContentResolver contentResolver, String str, long j, String str2, String str3, String str4, boolean z, int i) {
        return m33a(contentResolver, str, j, str2 + "/" + str3, str4, z, i);
    }

    public static Uri m33a(ContentResolver contentResolver, String str, long j, String str2, String str3, boolean z, int i) {
        Exception e;
        File file;
        ContentValues contentValues;
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor query = contentResolver.query(z ? f33b : f32a, null, "_data like '" + str2 + "'", null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                    try {
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        file = new File(str2);
                        contentValues = new ContentValues(7);
                        contentValues.put("title", str);
                        contentValues.put("_display_name", file.getName());
                        contentValues.put("datetaken", Long.valueOf(j));
                        contentValues.put("mime_type", str3);
                        contentValues.put(Columns.DATA, str2);
                        if (!z) {
                            contentValues.put("orientation", Integer.valueOf(i));
                        }
                        return z ? contentResolver.insert(f32a, contentValues) : contentResolver.insert(f33b, contentValues);
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            if (cursor != null) {
                cursor.close();
            }
            file = new File(str2);
            contentValues = new ContentValues(7);
            contentValues.put("title", str);
            contentValues.put("_display_name", file.getName());
            contentValues.put("datetaken", Long.valueOf(j));
            contentValues.put("mime_type", str3);
            contentValues.put(Columns.DATA, str2);
            if (z) {
                contentValues.put("orientation", Integer.valueOf(i));
            }
            if (z) {
            }
        }
        file = new File(str2);
        contentValues = new ContentValues(7);
        contentValues.put("title", str);
        contentValues.put("_display_name", file.getName());
        contentValues.put("datetaken", Long.valueOf(j));
        contentValues.put("mime_type", str3);
        contentValues.put(Columns.DATA, str2);
        if (z) {
            contentValues.put("orientation", Integer.valueOf(i));
        }
        if (z) {
        }
    }

    public static ImageListParam m34a(C0381a c0381a, int i, int i2, String str) {
        ImageListParam imageListParam = new ImageListParam();
        imageListParam.f21a = c0381a;
        imageListParam.f22b = i;
        imageListParam.f23c = i2;
        imageListParam.f24d = str;
        return imageListParam;
    }

    public static C0382g m35a(Context context, ImageListParam imageListParam) {
        ContentResolver contentResolver = context != null ? context.getContentResolver() : null;
        C0381a c0381a = imageListParam.f21a;
        int i = imageListParam.f22b;
        int i2 = imageListParam.f23c;
        String str = imageListParam.f24d;
        if (imageListParam.f26f || contentResolver == null) {
            return new C0383b();
        }
        if (imageListParam.f25e != null) {
            return new C0466m(contentResolver, imageListParam.f25e);
        }
        boolean a = m39a(false);
        ArrayList arrayList = new ArrayList();
        if (a && c0381a != C0381a.INTERNAL) {
            if ((i & 1) != 0) {
                arrayList.add(new C0457j(context, f32a, i2, str));
            }
            if ((i & 4) != 0) {
                arrayList.add(new C0468o(context, f33b, i2, str));
            }
        }
        if ((c0381a == C0381a.INTERNAL || c0381a == C0381a.ALL) && (i & 1) != 0) {
            arrayList.add(new C0457j(context, Media.INTERNAL_CONTENT_URI, i2, str));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0452b c0452b = (C0452b) it.next();
            if (c0452b.m308e()) {
                c0452b.mo2037a();
                it.remove();
            }
        }
        return arrayList.size() == 1 ? (C0452b) arrayList.get(0) : new C0462k((C0382g[]) arrayList.toArray(new C0382g[arrayList.size()]), i2);
    }

    public static C0382g m36a(Context context, C0381a c0381a, int i, int i2, String str) {
        return m35a(context, m34a(c0381a, i, i2, str));
    }

    public static void m37a() {
        File file = new File(Environment.getExternalStorageDirectory().toString() + "/DCIM/100ANDRO");
        if (!file.exists() && !file.mkdir()) {
            Log.e("ImageManager", "create NNNAAAAA file: " + file.getPath() + " failed");
        }
    }

    public static boolean m38a(ContentResolver contentResolver) {
        Cursor a = m31a(contentResolver, MediaStore.getMediaScannerUri(), new String[]{"volume"}, null, null, null);
        if (a == null) {
            return false;
        }
        boolean equals;
        if (a.getCount() == 1) {
            a.moveToFirst();
            equals = "external".equals(a.getString(0));
        } else {
            equals = false;
        }
        a.close();
        return equals;
    }

    public static boolean m39a(boolean z) {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) ? z ? m42d() : true : !z && "mounted_ro".equals(externalStorageState);
    }

    public static ImageListParam m40b() {
        ImageListParam imageListParam = new ImageListParam();
        imageListParam.f26f = true;
        return imageListParam;
    }

    public static boolean m41c() {
        return m39a(true);
    }

    private static boolean m42d() {
        String str = Environment.getExternalStorageDirectory().toString() + "/DCIM";
        File file = new File(str);
        if (!file.isDirectory() && !file.mkdirs()) {
            return false;
        }
        file = new File(str, ".probe");
        try {
            if (file.exists()) {
                file.delete();
            }
            if (!file.createNewFile()) {
                return false;
            }
            file.delete();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
