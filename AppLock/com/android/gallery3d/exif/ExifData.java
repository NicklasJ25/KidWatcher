package com.android.gallery3d.exif;

import com.android.gallery3d.exif.ExifTag.GpsLatitudeRef;
import com.android.gallery3d.exif.ExifTag.GpsLongitudeRef;
import java.io.Closeable;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;

public class ExifData {
    private final ByteOrder mByteOrder;
    private final IfdData[] mIfdDatas = new IfdData[5];
    private ArrayList<byte[]> mStripBytes = new ArrayList();
    private byte[] mThumbnail;

    private static class Util {
        private Util() {
        }

        public static void closeSilently(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                }
            }
        }

        public static boolean equals(Object obj, Object obj2) {
            return obj == obj2 || (obj != null && obj.equals(obj2));
        }
    }

    public ExifData(ByteOrder byteOrder) {
        this.mByteOrder = byteOrder;
    }

    private IfdData getOrCreateIfdData(int i) {
        IfdData ifdData = this.mIfdDatas[i];
        if (ifdData != null) {
            return ifdData;
        }
        ifdData = new IfdData(i);
        this.mIfdDatas[i] = ifdData;
        return ifdData;
    }

    private static Rational[] toExifLatLong(double d) {
        double abs = Math.abs(d);
        abs = (abs - ((double) ((int) abs))) * 60.0d;
        int i = (int) ((abs - ((double) ((int) abs))) * 6000.0d);
        return new Rational[]{new Rational((long) r2, 1), new Rational((long) r3, 1), new Rational((long) i, 100)};
    }

    public void addGpsTags(double d, double d2) {
        IfdData ifdData = getIfdData(4);
        if (ifdData == null) {
            ifdData = new IfdData(4);
            addIfdData(ifdData);
        }
        ExifTag exifTag = new ExifTag((short) 2, (short) 10, 3, 4);
        ExifTag exifTag2 = new ExifTag((short) 4, (short) 10, 3, 4);
        ExifTag exifTag3 = new ExifTag((short) 1, (short) 2, 2, 4);
        ExifTag exifTag4 = new ExifTag((short) 3, (short) 2, 2, 4);
        exifTag.setValue(toExifLatLong(d));
        exifTag2.setValue(toExifLatLong(d2));
        exifTag3.setValue(d >= 0.0d ? "N" : GpsLatitudeRef.SOUTH);
        exifTag4.setValue(d2 >= 0.0d ? GpsLongitudeRef.EAST : GpsLongitudeRef.WEST);
        ifdData.setTag(exifTag);
        ifdData.setTag(exifTag2);
        ifdData.setTag(exifTag3);
        ifdData.setTag(exifTag4);
    }

    void addIfdData(IfdData ifdData) {
        this.mIfdDatas[ifdData.getId()] = ifdData;
    }

    public ExifTag addInteroperabilityTag(short s) {
        IfdData orCreateIfdData = getOrCreateIfdData(3);
        ExifTag buildInteroperabilityTag = ExifTag.buildInteroperabilityTag(s);
        orCreateIfdData.setTag(buildInteroperabilityTag);
        return buildInteroperabilityTag;
    }

    public ExifTag addTag(short s) {
        IfdData orCreateIfdData = getOrCreateIfdData(ExifTag.getIfdIdFromTagId(s));
        ExifTag buildTag = ExifTag.buildTag(s);
        orCreateIfdData.setTag(buildTag);
        return buildTag;
    }

    public ExifTag addThumbnailTag(short s) {
        IfdData orCreateIfdData = getOrCreateIfdData(1);
        ExifTag buildThumbnailTag = ExifTag.buildThumbnailTag(s);
        orCreateIfdData.setTag(buildThumbnailTag);
        return buildThumbnailTag;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ExifData)) {
            return false;
        }
        ExifData exifData = (ExifData) obj;
        if (exifData.mByteOrder != this.mByteOrder || !Arrays.equals(exifData.mThumbnail, this.mThumbnail) || exifData.mStripBytes.size() != this.mStripBytes.size()) {
            return false;
        }
        for (int i = 0; i < this.mStripBytes.size(); i++) {
            if (!Arrays.equals((byte[]) exifData.mStripBytes.get(i), (byte[]) this.mStripBytes.get(i))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (!Util.equals(exifData.getIfdData(i2), getIfdData(i2))) {
                return false;
            }
        }
        return true;
    }

    public ByteOrder getByteOrder() {
        return this.mByteOrder;
    }

    public byte[] getCompressedThumbnail() {
        return this.mThumbnail;
    }

    IfdData getIfdData(int i) {
        return this.mIfdDatas[i];
    }

    public ExifTag getInteroperabilityTag(short s) {
        IfdData ifdData = this.mIfdDatas[3];
        return ifdData == null ? null : ifdData.getTag(s);
    }

    public byte[] getStrip(int i) {
        return (byte[]) this.mStripBytes.get(i);
    }

    public int getStripCount() {
        return this.mStripBytes.size();
    }

    public ExifTag getTag(short s) {
        IfdData ifdData = this.mIfdDatas[ExifTag.getIfdIdFromTagId(s)];
        return ifdData == null ? null : ifdData.getTag(s);
    }

    public ExifTag getThumbnailTag(short s) {
        IfdData ifdData = this.mIfdDatas[1];
        return ifdData == null ? null : ifdData.getTag(s);
    }

    public boolean hasCompressedThumbnail() {
        return this.mThumbnail != null;
    }

    public boolean hasUncompressedStrip() {
        return this.mStripBytes.size() != 0;
    }

    public void removeThumbnailData() {
        this.mThumbnail = null;
        this.mStripBytes.clear();
        this.mIfdDatas[1] = null;
    }

    public void setCompressedThumbnail(byte[] bArr) {
        this.mThumbnail = bArr;
    }

    public void setStripBytes(int i, byte[] bArr) {
        if (i < this.mStripBytes.size()) {
            this.mStripBytes.set(i, bArr);
            return;
        }
        for (int size = this.mStripBytes.size(); size < i; size++) {
            this.mStripBytes.add(null);
        }
        this.mStripBytes.add(bArr);
    }
}
