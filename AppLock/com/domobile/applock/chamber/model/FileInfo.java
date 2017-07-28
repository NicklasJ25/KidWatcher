package com.domobile.applock.chamber.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.domobile.applock.p003a.C0614e;
import java.io.File;

public class FileInfo implements Parcelable {
    public static final Creator<FileInfo> CREATOR = new C08831();
    public static final String MIME_APK = "application/vnd.android.package-archive";
    public static final String MIME_AUDIO = "audio";
    public static final String MIME_IMAGE = "image";
    public static final String MIME_VIDEO = "video";
    public static final int STATE_CANCELED = 3;
    public static final int STATE_FAILED = 4;
    public static final int STATE_FINISHED = 2;
    public static final int STATE_UPDATING = 1;
    public static final int STATE_WAITING = 0;
    public static final int TYPE_APP = 13;
    public static final int TYPE_AUDIO = 12;
    public static final int TYPE_COMMON = 0;
    public static final int TYPE_IMAGE = 10;
    public static final int TYPE_VIDEO = 11;
    public String f1287a = "";
    public String f1288b = "";
    public String f1289c = "";
    public String f1290d = "";
    public long f1291e;
    public long f1292f;
    public int f1293g = 0;
    public long f1294h;
    public long f1295i;
    public int f1296j = -1;

    static class C08831 implements Creator<FileInfo> {
        C08831() {
        }

        public FileInfo m1512a(Parcel parcel) {
            return new FileInfo(parcel);
        }

        public FileInfo[] m1513a(int i) {
            return new FileInfo[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1512a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1513a(i);
        }
    }

    protected FileInfo(Parcel parcel) {
        this.f1287a = parcel.readString();
        this.f1288b = parcel.readString();
        this.f1289c = parcel.readString();
        this.f1290d = parcel.readString();
        this.f1291e = parcel.readLong();
        this.f1292f = parcel.readLong();
        this.f1293g = parcel.readInt();
        this.f1294h = parcel.readLong();
        this.f1295i = parcel.readLong();
        this.f1296j = parcel.readInt();
    }

    public int m1514a() {
        return this.f1291e == 0 ? -1 : (int) ((((double) this.f1294h) / ((double) this.f1291e)) * 100.0d);
    }

    public int m1515b() {
        if (this.f1296j != -1) {
            return this.f1296j;
        }
        String d = C0614e.m714d(this.f1288b.toLowerCase());
        if (MIME_APK.equals(d)) {
            this.f1296j = 13;
        } else if (d.startsWith("image")) {
            this.f1296j = 10;
        } else if (d.startsWith("video")) {
            this.f1296j = 11;
        } else if (d.startsWith(MIME_AUDIO)) {
            this.f1296j = 12;
        } else {
            this.f1296j = 0;
        }
        return this.f1296j;
    }

    @NonNull
    public String m1516c() {
        return C0614e.m714d(this.f1288b.toLowerCase());
    }

    public Uri m1517d() {
        return Uri.fromFile(new File(this.f1289c));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        try {
            return this.f1287a.equals(((FileInfo) obj).f1287a);
        } catch (ClassCastException e) {
            e.printStackTrace();
            return super.equals(obj);
        }
    }

    public String toString() {
        return "FileInfo{fileId='" + this.f1287a + '\'' + ", name='" + this.f1288b + '\'' + ", path='" + this.f1289c + '\'' + ", url='" + this.f1290d + '\'' + ", size=" + this.f1291e + ", time=" + this.f1292f + ", state=" + this.f1293g + ", offset=" + this.f1294h + ", speed=" + this.f1295i + ", type=" + this.f1296j + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1287a);
        parcel.writeString(this.f1288b);
        parcel.writeString(this.f1289c);
        parcel.writeString(this.f1290d);
        parcel.writeLong(this.f1291e);
        parcel.writeLong(this.f1292f);
        parcel.writeInt(this.f1293g);
        parcel.writeLong(this.f1294h);
        parcel.writeLong(this.f1295i);
        parcel.writeInt(this.f1296j);
    }
}
