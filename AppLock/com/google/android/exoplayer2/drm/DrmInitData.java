package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.C1961b;
import com.google.android.exoplayer2.p043j.C2252a;
import com.google.android.exoplayer2.p043j.C2273r;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData implements Parcelable, Comparator<SchemeData> {
    public static final Creator<DrmInitData> CREATOR = new C21101();
    public final int f5928a;
    private final SchemeData[] f5929b;
    private int f5930c;

    static class C21101 implements Creator<DrmInitData> {
        C21101() {
        }

        public DrmInitData m6418a(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        public DrmInitData[] m6419a(int i) {
            return new DrmInitData[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6418a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6419a(i);
        }
    }

    public static final class SchemeData implements Parcelable {
        public static final Creator<SchemeData> CREATOR = new C21111();
        public final String f5923a;
        public final byte[] f5924b;
        public final boolean f5925c;
        private int f5926d;
        private final UUID f5927e;

        static class C21111 implements Creator<SchemeData> {
            C21111() {
            }

            public SchemeData m6420a(Parcel parcel) {
                return new SchemeData(parcel);
            }

            public SchemeData[] m6421a(int i) {
                return new SchemeData[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m6420a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m6421a(i);
            }
        }

        SchemeData(Parcel parcel) {
            this.f5927e = new UUID(parcel.readLong(), parcel.readLong());
            this.f5923a = parcel.readString();
            this.f5924b = parcel.createByteArray();
            this.f5925c = parcel.readByte() != (byte) 0;
        }

        public SchemeData(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        public SchemeData(UUID uuid, String str, byte[] bArr, boolean z) {
            this.f5927e = (UUID) C2252a.m7020a((Object) uuid);
            this.f5923a = (String) C2252a.m7020a((Object) str);
            this.f5924b = (byte[]) C2252a.m7020a((Object) bArr);
            this.f5925c = z;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            return this.f5923a.equals(schemeData.f5923a) && C2273r.m7135a(this.f5927e, schemeData.f5927e) && Arrays.equals(this.f5924b, schemeData.f5924b);
        }

        public int hashCode() {
            if (this.f5926d == 0) {
                this.f5926d = (((this.f5927e.hashCode() * 31) + this.f5923a.hashCode()) * 31) + Arrays.hashCode(this.f5924b);
            }
            return this.f5926d;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f5927e.getMostSignificantBits());
            parcel.writeLong(this.f5927e.getLeastSignificantBits());
            parcel.writeString(this.f5923a);
            parcel.writeByteArray(this.f5924b);
            parcel.writeByte((byte) (this.f5925c ? 1 : 0));
        }
    }

    DrmInitData(Parcel parcel) {
        this.f5929b = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.f5928a = this.f5929b.length;
    }

    public DrmInitData(List<SchemeData> list) {
        this(false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
    }

    private DrmInitData(boolean z, SchemeData... schemeDataArr) {
        SchemeData[] schemeDataArr2 = z ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        Arrays.sort(schemeDataArr2, this);
        for (int i = 1; i < schemeDataArr2.length; i++) {
            if (schemeDataArr2[i - 1].f5927e.equals(schemeDataArr2[i].f5927e)) {
                throw new IllegalArgumentException("Duplicate data for uuid: " + schemeDataArr2[i].f5927e);
            }
        }
        this.f5929b = schemeDataArr2;
        this.f5928a = schemeDataArr2.length;
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this(true, schemeDataArr);
    }

    public int m6423a(SchemeData schemeData, SchemeData schemeData2) {
        return C1961b.f5145b.equals(schemeData.f5927e) ? C1961b.f5145b.equals(schemeData2.f5927e) ? 0 : 1 : schemeData.f5927e.compareTo(schemeData2.f5927e);
    }

    public SchemeData m6424a(int i) {
        return this.f5929b[i];
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m6423a((SchemeData) obj, (SchemeData) obj2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj ? true : (obj == null || getClass() != obj.getClass()) ? false : Arrays.equals(this.f5929b, ((DrmInitData) obj).f5929b);
    }

    public int hashCode() {
        if (this.f5930c == 0) {
            this.f5930c = Arrays.hashCode(this.f5929b);
        }
        return this.f5930c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f5929b, 0);
    }
}
