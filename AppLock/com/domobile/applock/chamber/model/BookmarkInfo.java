package com.domobile.applock.chamber.model;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.domobile.applock.chamber.p009c.C0793b;
import java.io.File;

public class BookmarkInfo implements Parcelable {
    public static final Creator<BookmarkInfo> CREATOR = new C08821();
    public String f1281a = "";
    public String f1282b = "";
    public String f1283c = "";
    public String f1284d = "";
    public String f1285e;
    public Uri f1286f;

    static class C08821 implements Creator<BookmarkInfo> {
        C08821() {
        }

        public BookmarkInfo m1505a(Parcel parcel) {
            return new BookmarkInfo(parcel);
        }

        public BookmarkInfo[] m1506a(int i) {
            return new BookmarkInfo[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1505a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1506a(i);
        }
    }

    protected BookmarkInfo(Parcel parcel) {
        this.f1281a = parcel.readString();
        this.f1282b = parcel.readString();
        this.f1283c = parcel.readString();
        this.f1284d = parcel.readString();
        this.f1285e = parcel.readString();
        this.f1286f = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    public Uri m1507a() {
        return Uri.parse(this.f1282b);
    }

    public String m1508a(Context context) {
        return C0793b.m1229b(context, m1510b());
    }

    public Uri m1509b(Context context) {
        if (this.f1286f == null) {
            this.f1286f = Uri.fromFile(new File(C0793b.m1231c(context, m1510b())));
        }
        return this.f1286f;
    }

    public String m1510b() {
        return m1507a().getHost();
    }

    public String m1511c() {
        return TextUtils.isEmpty(this.f1283c) ? m1507a().getHost() : this.f1283c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        try {
            return this.f1282b.equals(((BookmarkInfo) obj).f1282b);
        } catch (ClassCastException e) {
            e.printStackTrace();
            return super.equals(obj);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1281a);
        parcel.writeString(this.f1282b);
        parcel.writeString(this.f1283c);
        parcel.writeString(this.f1284d);
        parcel.writeString(this.f1285e);
        parcel.writeParcelable(this.f1286f, i);
    }
}
