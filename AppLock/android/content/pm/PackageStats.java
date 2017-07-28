package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PackageStats implements Parcelable {
    public static final Creator<PackageStats> CREATOR = new C00021();
    public long cacheSize;
    public long codeSize;
    public long dataSize;
    public String packageName;

    class C00021 implements Creator<PackageStats> {
        C00021() {
        }

        public PackageStats createFromParcel(Parcel parcel) {
            return new PackageStats(parcel);
        }

        public PackageStats[] newArray(int i) {
            return new PackageStats[i];
        }
    }

    public PackageStats(PackageStats packageStats) {
        this.packageName = packageStats.packageName;
        this.codeSize = packageStats.codeSize;
        this.dataSize = packageStats.dataSize;
        this.cacheSize = packageStats.cacheSize;
    }

    public PackageStats(Parcel parcel) {
        this.packageName = parcel.readString();
        this.codeSize = parcel.readLong();
        this.dataSize = parcel.readLong();
        this.cacheSize = parcel.readLong();
    }

    public PackageStats(String str) {
        this.packageName = str;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PackageStats{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.packageName + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.packageName);
        parcel.writeLong(this.codeSize);
        parcel.writeLong(this.dataSize);
        parcel.writeLong(this.cacheSize);
    }
}
