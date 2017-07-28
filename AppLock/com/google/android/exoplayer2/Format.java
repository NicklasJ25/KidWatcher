package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.p043j.C2273r;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format implements Parcelable {
    public static final Creator<Format> CREATOR = new C19251();
    public static final int NO_VALUE = -1;
    public static final long OFFSET_SAMPLE_RELATIVE = Long.MAX_VALUE;
    public final String f4943a;
    public final int f4944b;
    public final String f4945c;
    public final String f4946d;
    public final String f4947e;
    public final int f4948f;
    public final List<byte[]> f4949g;
    public final DrmInitData f4950h;
    public final int f4951i;
    public final int f4952j;
    public final float f4953k;
    public final int f4954l;
    public final float f4955m;
    public final int f4956n;
    public final byte[] f4957o;
    public final int f4958p;
    public final int f4959q;
    public final int f4960r;
    public final int f4961s;
    public final int f4962t;
    public final long f4963u;
    public final int f4964v;
    public final String f4965w;
    private int f4966x;
    private MediaFormat f4967y;

    static class C19251 implements Creator<Format> {
        C19251() {
        }

        public Format m5474a(Parcel parcel) {
            return new Format(parcel);
        }

        public Format[] m5475a(int i) {
            return new Format[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m5474a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m5475a(i);
        }
    }

    Format(Parcel parcel) {
        this.f4943a = parcel.readString();
        this.f4946d = parcel.readString();
        this.f4947e = parcel.readString();
        this.f4945c = parcel.readString();
        this.f4944b = parcel.readInt();
        this.f4948f = parcel.readInt();
        this.f4951i = parcel.readInt();
        this.f4952j = parcel.readInt();
        this.f4953k = parcel.readFloat();
        this.f4954l = parcel.readInt();
        this.f4955m = parcel.readFloat();
        this.f4957o = (parcel.readInt() != 0 ? 1 : null) != null ? parcel.createByteArray() : null;
        this.f4956n = parcel.readInt();
        this.f4958p = parcel.readInt();
        this.f4959q = parcel.readInt();
        this.f4960r = parcel.readInt();
        this.f4961s = parcel.readInt();
        this.f4962t = parcel.readInt();
        this.f4964v = parcel.readInt();
        this.f4965w = parcel.readString();
        this.f4963u = parcel.readLong();
        int readInt = parcel.readInt();
        this.f4949g = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.f4949g.add(parcel.createByteArray());
        }
        this.f4950h = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
    }

    Format(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, int i7, int i8, int i9, int i10, int i11, int i12, String str5, long j, List<byte[]> list, DrmInitData drmInitData) {
        this.f4943a = str;
        this.f4946d = str2;
        this.f4947e = str3;
        this.f4945c = str4;
        this.f4944b = i;
        this.f4948f = i2;
        this.f4951i = i3;
        this.f4952j = i4;
        this.f4953k = f;
        this.f4954l = i5;
        this.f4955m = f2;
        this.f4957o = bArr;
        this.f4956n = i6;
        this.f4958p = i7;
        this.f4959q = i8;
        this.f4960r = i9;
        this.f4961s = i10;
        this.f4962t = i11;
        this.f4964v = i12;
        this.f4965w = str5;
        this.f4963u = j;
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f4949g = list;
        this.f4950h = drmInitData;
    }

    public static Format m5476a(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, DrmInitData drmInitData) {
        return m5477a(str, str2, str3, i, i2, i3, i4, f, (List) list, i5, f2, null, -1, drmInitData);
    }

    public static Format m5477a(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i, i2, i3, i4, f, i5, f2, bArr, i6, -1, -1, -1, -1, -1, 0, null, OFFSET_SAMPLE_RELATIVE, list, drmInitData);
    }

    public static Format m5478a(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, int i6, int i7, List<byte[]> list, DrmInitData drmInitData, int i8, String str4) {
        return new Format(str, null, str2, str3, i, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, i3, i4, i5, i6, i7, i8, str4, OFFSET_SAMPLE_RELATIVE, list, drmInitData);
    }

    public static Format m5479a(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, DrmInitData drmInitData, int i6, String str4) {
        return m5478a(str, str2, str3, i, i2, i3, i4, i5, -1, -1, (List) list, drmInitData, i6, str4);
    }

    public static Format m5480a(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, DrmInitData drmInitData, int i5, String str4) {
        return m5479a(str, str2, str3, i, i2, i3, i4, -1, (List) list, drmInitData, i5, str4);
    }

    public static Format m5481a(String str, String str2, String str3, int i, int i2, String str4, DrmInitData drmInitData) {
        return m5482a(str, str2, str3, i, i2, str4, drmInitData, OFFSET_SAMPLE_RELATIVE);
    }

    public static Format m5482a(String str, String str2, String str3, int i, int i2, String str4, DrmInitData drmInitData, long j) {
        return new Format(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, -1, -1, -1, -1, -1, i2, str4, j, null, drmInitData);
    }

    public static Format m5483a(String str, String str2, String str3, int i, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, -1, -1, -1, -1, -1, 0, null, OFFSET_SAMPLE_RELATIVE, null, drmInitData);
    }

    public static Format m5484a(String str, String str2, String str3, int i, List<byte[]> list, String str4, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, -1, -1, -1, -1, -1, 0, str4, OFFSET_SAMPLE_RELATIVE, list, drmInitData);
    }

    @TargetApi(16)
    private static void m5485a(MediaFormat mediaFormat, String str, float f) {
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
    }

    @TargetApi(16)
    private static void m5486a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    @TargetApi(16)
    private static void m5487a(MediaFormat mediaFormat, String str, String str2) {
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
    }

    public int m5488a() {
        return (this.f4951i == -1 || this.f4952j == -1) ? -1 : this.f4951i * this.f4952j;
    }

    public Format m5489a(int i) {
        return new Format(this.f4943a, this.f4946d, this.f4947e, this.f4945c, this.f4944b, i, this.f4951i, this.f4952j, this.f4953k, this.f4954l, this.f4955m, this.f4957o, this.f4956n, this.f4958p, this.f4959q, this.f4960r, this.f4961s, this.f4962t, this.f4964v, this.f4965w, this.f4963u, this.f4949g, this.f4950h);
    }

    public Format m5490a(int i, int i2) {
        return new Format(this.f4943a, this.f4946d, this.f4947e, this.f4945c, this.f4944b, this.f4948f, this.f4951i, this.f4952j, this.f4953k, this.f4954l, this.f4955m, this.f4957o, this.f4956n, this.f4958p, this.f4959q, this.f4960r, i, i2, this.f4964v, this.f4965w, this.f4963u, this.f4949g, this.f4950h);
    }

    public Format m5491a(long j) {
        return new Format(this.f4943a, this.f4946d, this.f4947e, this.f4945c, this.f4944b, this.f4948f, this.f4951i, this.f4952j, this.f4953k, this.f4954l, this.f4955m, this.f4957o, this.f4956n, this.f4958p, this.f4959q, this.f4960r, this.f4961s, this.f4962t, this.f4964v, this.f4965w, j, this.f4949g, this.f4950h);
    }

    public Format m5492a(DrmInitData drmInitData) {
        return new Format(this.f4943a, this.f4946d, this.f4947e, this.f4945c, this.f4944b, this.f4948f, this.f4951i, this.f4952j, this.f4953k, this.f4954l, this.f4955m, this.f4957o, this.f4956n, this.f4958p, this.f4959q, this.f4960r, this.f4961s, this.f4962t, this.f4964v, this.f4965w, this.f4963u, this.f4949g, drmInitData);
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat m5493b() {
        if (this.f4967y == null) {
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", this.f4947e);
            m5487a(mediaFormat, "language", this.f4965w);
            m5486a(mediaFormat, "max-input-size", this.f4948f);
            m5486a(mediaFormat, "width", this.f4951i);
            m5486a(mediaFormat, "height", this.f4952j);
            m5485a(mediaFormat, "frame-rate", this.f4953k);
            m5486a(mediaFormat, "rotation-degrees", this.f4954l);
            m5486a(mediaFormat, "channel-count", this.f4958p);
            m5486a(mediaFormat, "sample-rate", this.f4959q);
            m5486a(mediaFormat, "encoder-delay", this.f4961s);
            m5486a(mediaFormat, "encoder-padding", this.f4962t);
            for (int i = 0; i < this.f4949g.size(); i++) {
                mediaFormat.setByteBuffer("csd-" + i, ByteBuffer.wrap((byte[]) this.f4949g.get(i)));
            }
            this.f4967y = mediaFormat;
        }
        return this.f4967y;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        if (this.f4944b != format.f4944b || this.f4948f != format.f4948f || this.f4951i != format.f4951i || this.f4952j != format.f4952j || this.f4953k != format.f4953k || this.f4954l != format.f4954l || this.f4955m != format.f4955m || this.f4956n != format.f4956n || this.f4958p != format.f4958p || this.f4959q != format.f4959q || this.f4960r != format.f4960r || this.f4961s != format.f4961s || this.f4962t != format.f4962t || this.f4963u != format.f4963u || this.f4964v != format.f4964v || !C2273r.m7135a(this.f4943a, format.f4943a) || !C2273r.m7135a(this.f4965w, format.f4965w) || !C2273r.m7135a(this.f4946d, format.f4946d) || !C2273r.m7135a(this.f4947e, format.f4947e) || !C2273r.m7135a(this.f4945c, format.f4945c) || !C2273r.m7135a(this.f4950h, format.f4950h) || !Arrays.equals(this.f4957o, format.f4957o) || this.f4949g.size() != format.f4949g.size()) {
            return false;
        }
        for (int i = 0; i < this.f4949g.size(); i++) {
            if (!Arrays.equals((byte[]) this.f4949g.get(i), (byte[]) format.f4949g.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        if (this.f4966x == 0) {
            int hashCode = ((this.f4965w == null ? 0 : this.f4965w.hashCode()) + (((((((((((((this.f4945c == null ? 0 : this.f4945c.hashCode()) + (((this.f4947e == null ? 0 : this.f4947e.hashCode()) + (((this.f4946d == null ? 0 : this.f4946d.hashCode()) + (((this.f4943a == null ? 0 : this.f4943a.hashCode()) + 527) * 31)) * 31)) * 31)) * 31) + this.f4944b) * 31) + this.f4951i) * 31) + this.f4952j) * 31) + this.f4958p) * 31) + this.f4959q) * 31)) * 31;
            if (this.f4950h != null) {
                i = this.f4950h.hashCode();
            }
            this.f4966x = hashCode + i;
        }
        return this.f4966x;
    }

    public String toString() {
        return "Format(" + this.f4943a + ", " + this.f4946d + ", " + this.f4947e + ", " + this.f4944b + ", , " + this.f4965w + ", [" + this.f4951i + ", " + this.f4952j + ", " + this.f4953k + "], [" + this.f4958p + ", " + this.f4959q + "])";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4943a);
        parcel.writeString(this.f4946d);
        parcel.writeString(this.f4947e);
        parcel.writeString(this.f4945c);
        parcel.writeInt(this.f4944b);
        parcel.writeInt(this.f4948f);
        parcel.writeInt(this.f4951i);
        parcel.writeInt(this.f4952j);
        parcel.writeFloat(this.f4953k);
        parcel.writeInt(this.f4954l);
        parcel.writeFloat(this.f4955m);
        parcel.writeInt(this.f4957o != null ? 1 : 0);
        if (this.f4957o != null) {
            parcel.writeByteArray(this.f4957o);
        }
        parcel.writeInt(this.f4956n);
        parcel.writeInt(this.f4958p);
        parcel.writeInt(this.f4959q);
        parcel.writeInt(this.f4960r);
        parcel.writeInt(this.f4961s);
        parcel.writeInt(this.f4962t);
        parcel.writeInt(this.f4964v);
        parcel.writeString(this.f4965w);
        parcel.writeLong(this.f4963u);
        int size = this.f4949g.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray((byte[]) this.f4949g.get(i2));
        }
        parcel.writeParcelable(this.f4950h, 0);
    }
}
