package com.domobile.applock.chamber.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.domobile.applock.p013f.C0904b;
import java.io.File;

public class InvaderBean implements Parcelable {
    public static final Creator<InvaderBean> CREATOR = new C08841();
    public String f1297a = "";
    public long f1298b;

    static class C08841 implements Creator<InvaderBean> {
        C08841() {
        }

        public InvaderBean m1518a(Parcel parcel) {
            return new InvaderBean(parcel);
        }

        public InvaderBean[] m1519a(int i) {
            return new InvaderBean[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1518a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1519a(i);
        }
    }

    protected InvaderBean(Parcel parcel) {
        this.f1297a = parcel.readString();
        this.f1298b = parcel.readLong();
    }

    public Uri m1520a() {
        return Uri.fromFile(new File(this.f1297a));
    }

    public String m1521b() {
        return C0904b.m1594a(this.f1298b, "yyyyMMdd   HH:mm");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        try {
            return this.f1297a.equals(((InvaderBean) obj).f1297a);
        } catch (ClassCastException e) {
            e.printStackTrace();
            return super.equals(obj);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1297a);
        parcel.writeLong(this.f1298b);
    }
}
