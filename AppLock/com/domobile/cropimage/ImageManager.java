package com.domobile.cropimage;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ImageManager {
    public static final String f2282a = (Environment.getExternalStorageDirectory().toString() + "/DCIM/Camera");
    public static final String f2283b = m2728a(f2282a);
    private static final Uri f2284c = Media.EXTERNAL_CONTENT_URI;
    private static final Uri f2285d = Thumbnails.EXTERNAL_CONTENT_URI;
    private static final Uri f2286e = Uri.parse("content://media/external/video/media");

    public static class ImageListParam implements Parcelable {
        public static final Creator CREATOR = new C11731();
        public C1174a f2271a;
        public int f2272b;
        public int f2273c;
        public String f2274d;
        public Uri f2275e;
        public boolean f2276f;

        static class C11731 implements Creator {
            C11731() {
            }

            public ImageListParam m2712a(Parcel parcel) {
                return new ImageListParam(parcel);
            }

            public ImageListParam[] m2713a(int i) {
                return new ImageListParam[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2712a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2713a(i);
            }
        }

        private ImageListParam(Parcel parcel) {
            this.f2271a = C1174a.values()[parcel.readInt()];
            this.f2272b = parcel.readInt();
            this.f2273c = parcel.readInt();
            this.f2274d = parcel.readString();
            this.f2275e = (Uri) parcel.readParcelable(null);
            this.f2276f = parcel.readInt() != 0;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return String.format("ImageListParam{loc=%s,inc=%d,sort=%d,bucket=%s,empty=%b,single=%s}", new Object[]{this.f2271a, Integer.valueOf(this.f2272b), Integer.valueOf(this.f2273c), this.f2274d, Boolean.valueOf(this.f2276f), this.f2275e});
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2271a.ordinal());
            parcel.writeInt(this.f2272b);
            parcel.writeInt(this.f2273c);
            parcel.writeString(this.f2274d);
            parcel.writeParcelable(this.f2275e, i);
            parcel.writeInt(this.f2276f ? 1 : 0);
        }
    }

    public enum C1174a {
        NONE,
        INTERNAL,
        EXTERNAL,
        ALL
    }

    private static class C1176b implements C1175g {
        private C1176b() {
        }

        public C1177f mo2505a(int i) {
            return null;
        }

        public C1177f mo2506a(Uri uri) {
            return null;
        }

        public void mo2507a() {
        }

        public int mo2508b() {
            return 0;
        }
    }

    public static ImageListParam m2722a(Uri uri) {
        ImageListParam imageListParam = new ImageListParam();
        imageListParam.f2275e = uri;
        return imageListParam;
    }

    public static ImageListParam m2723a(C1174a c1174a, int i, int i2, String str) {
        ImageListParam imageListParam = new ImageListParam();
        imageListParam.f2271a = c1174a;
        imageListParam.f2272b = i;
        imageListParam.f2273c = i2;
        imageListParam.f2274d = str;
        return imageListParam;
    }

    public static C1175g m2724a(ContentResolver contentResolver, Uri uri) {
        return m2726a(contentResolver, m2722a(uri));
    }

    public static C1175g m2725a(ContentResolver contentResolver, Uri uri, int i) {
        String uri2 = uri != null ? uri.toString() : "";
        if (uri2.startsWith("content://drm")) {
            return m2727a(contentResolver, C1174a.ALL, 2, i, null);
        }
        if (uri2.startsWith("content://media/external/video")) {
            return m2727a(contentResolver, C1174a.EXTERNAL, 4, i, null);
        }
        if (m2731b(uri2)) {
            return m2724a(contentResolver, uri);
        }
        return m2727a(contentResolver, C1174a.ALL, 1, i, uri.getQueryParameter("bucketId"));
    }

    public static C1175g m2726a(ContentResolver contentResolver, ImageListParam imageListParam) {
        C1174a c1174a = imageListParam.f2271a;
        int i = imageListParam.f2272b;
        int i2 = imageListParam.f2273c;
        String str = imageListParam.f2274d;
        Uri uri = imageListParam.f2275e;
        if (imageListParam.f2276f || contentResolver == null) {
            return new C1176b();
        }
        if (uri != null) {
            return new C1211p(contentResolver, uri);
        }
        boolean a = m2730a(false);
        ArrayList arrayList = new ArrayList();
        if (!(!a || c1174a == C1174a.INTERNAL || (i & 1) == 0)) {
            arrayList.add(new C1193i(contentResolver, f2284c, i2, str));
        }
        if ((c1174a == C1174a.INTERNAL || c1174a == C1174a.ALL) && (i & 1) != 0) {
            arrayList.add(new C1193i(contentResolver, Media.INTERNAL_CONTENT_URI, i2, str));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C1179b c1179b = (C1179b) it.next();
            if (c1179b.m2749c()) {
                c1179b.mo2507a();
                it.remove();
            }
        }
        return arrayList.size() == 1 ? (C1179b) arrayList.get(0) : new C1198j((C1175g[]) arrayList.toArray(new C1175g[arrayList.size()]), i2);
    }

    public static C1175g m2727a(ContentResolver contentResolver, C1174a c1174a, int i, int i2, String str) {
        return m2726a(contentResolver, m2723a(c1174a, i, i2, str));
    }

    public static String m2728a(String str) {
        return String.valueOf(str.toLowerCase().hashCode());
    }

    private static boolean m2729a() {
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

    public static boolean m2730a(boolean z) {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) ? z ? m2729a() : true : !z && "mounted_ro".equals(externalStorageState);
    }

    static boolean m2731b(String str) {
        return (str.startsWith(Media.EXTERNAL_CONTENT_URI.toString()) || str.startsWith(Media.INTERNAL_CONTENT_URI.toString())) ? false : true;
    }
}
