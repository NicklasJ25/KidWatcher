package com.android.gallery3d.exif;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ExifOutputStream extends FilterOutputStream {
    static final /* synthetic */ boolean $assertionsDisabled = (!ExifOutputStream.class.desiredAssertionStatus());
    private static final int EXIF_HEADER = 1165519206;
    private static final int STATE_FRAME_HEADER = 1;
    private static final int STATE_JPEG_DATA = 2;
    private static final int STATE_SOI = 0;
    private static final short TAG_SIZE = (short) 12;
    private static final short TIFF_BIG_ENDIAN = (short) 19789;
    private static final short TIFF_HEADER = (short) 42;
    private static final short TIFF_HEADER_SIZE = (short) 8;
    private static final short TIFF_LITTLE_ENDIAN = (short) 18761;
    private ByteBuffer mBuffer = ByteBuffer.allocate(4);
    private int mByteToCopy;
    private int mByteToSkip;
    private ExifData mExifData;
    private int mState = 0;

    public ExifOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    private int calculateAllOffset() {
        IfdData ifdData = this.mExifData.getIfdData(0);
        int calculateOffsetOfIfd = calculateOffsetOfIfd(ifdData, 8);
        ifdData.getTag(ExifTag.TAG_EXIF_IFD).setValue(calculateOffsetOfIfd);
        IfdData ifdData2 = this.mExifData.getIfdData(2);
        calculateOffsetOfIfd = calculateOffsetOfIfd(ifdData2, calculateOffsetOfIfd);
        IfdData ifdData3 = this.mExifData.getIfdData(3);
        if (ifdData3 != null) {
            ifdData2.getTag(ExifTag.TAG_INTEROPERABILITY_IFD).setValue(calculateOffsetOfIfd);
            calculateOffsetOfIfd = calculateOffsetOfIfd(ifdData3, calculateOffsetOfIfd);
        }
        ifdData2 = this.mExifData.getIfdData(4);
        if (ifdData2 != null) {
            ifdData.getTag(ExifTag.TAG_GPS_IFD).setValue(calculateOffsetOfIfd);
            calculateOffsetOfIfd = calculateOffsetOfIfd(ifdData2, calculateOffsetOfIfd);
        }
        ifdData2 = this.mExifData.getIfdData(1);
        if (ifdData2 != null) {
            ifdData.setOffsetToNextIfd(calculateOffsetOfIfd);
            calculateOffsetOfIfd = calculateOffsetOfIfd(ifdData2, calculateOffsetOfIfd);
        }
        if (this.mExifData.hasCompressedThumbnail()) {
            ifdData2.getTag(ExifTag.TAG_JPEG_INTERCHANGE_FORMAT).setValue(calculateOffsetOfIfd);
            return this.mExifData.getCompressedThumbnail().length + calculateOffsetOfIfd;
        } else if (!this.mExifData.hasUncompressedStrip()) {
            return calculateOffsetOfIfd;
        } else {
            long[] jArr = new long[this.mExifData.getStripCount()];
            int i = calculateOffsetOfIfd;
            for (calculateOffsetOfIfd = 0; calculateOffsetOfIfd < this.mExifData.getStripCount(); calculateOffsetOfIfd++) {
                jArr[calculateOffsetOfIfd] = (long) i;
                i += this.mExifData.getStrip(calculateOffsetOfIfd).length;
            }
            ifdData2.getTag(ExifTag.TAG_STRIP_OFFSETS).setValue(jArr);
            return i;
        }
    }

    private int calculateOffsetOfIfd(IfdData ifdData, int i) {
        int tagCount = i + (((ifdData.getTagCount() * 12) + 2) + 4);
        int i2 = tagCount;
        for (ExifTag exifTag : ifdData.getAllTags()) {
            if (exifTag.getDataSize() > 4) {
                exifTag.setOffset(i2);
                i2 += exifTag.getDataSize();
            }
        }
        return i2;
    }

    private void createRequiredIfdAndTag() {
        IfdData ifdData = this.mExifData.getIfdData(0);
        if (ifdData == null) {
            ifdData = new IfdData(0);
            this.mExifData.addIfdData(ifdData);
        }
        ifdData.setTag(new ExifTag(ExifTag.TAG_EXIF_IFD, (short) 4, 1, 0));
        IfdData ifdData2 = this.mExifData.getIfdData(2);
        if (ifdData2 == null) {
            ifdData2 = new IfdData(2);
            this.mExifData.addIfdData(ifdData2);
        }
        if (this.mExifData.getIfdData(4) != null) {
            ifdData.setTag(new ExifTag(ExifTag.TAG_GPS_IFD, (short) 4, 1, 0));
        }
        if (this.mExifData.getIfdData(3) != null) {
            ifdData2.setTag(new ExifTag(ExifTag.TAG_INTEROPERABILITY_IFD, (short) 4, 1, 2));
        }
        ifdData = this.mExifData.getIfdData(1);
        if (this.mExifData.hasCompressedThumbnail()) {
            if (ifdData == null) {
                ifdData = new IfdData(1);
                this.mExifData.addIfdData(ifdData);
            }
            ifdData.setTag(new ExifTag(ExifTag.TAG_JPEG_INTERCHANGE_FORMAT, (short) 4, 1, 1));
            ExifTag exifTag = new ExifTag(ExifTag.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, (short) 4, 1, 1);
            exifTag.setValue(this.mExifData.getCompressedThumbnail().length);
            ifdData.setTag(exifTag);
        } else if (this.mExifData.hasUncompressedStrip()) {
            if (ifdData == null) {
                ifdData = new IfdData(1);
                this.mExifData.addIfdData(ifdData);
            }
            int stripCount = this.mExifData.getStripCount();
            ExifTag exifTag2 = new ExifTag(ExifTag.TAG_STRIP_OFFSETS, (short) 4, stripCount, 1);
            ExifTag exifTag3 = new ExifTag(ExifTag.TAG_STRIP_BYTE_COUNTS, (short) 4, stripCount, 1);
            long[] jArr = new long[stripCount];
            for (stripCount = 0; stripCount < this.mExifData.getStripCount(); stripCount++) {
                jArr[stripCount] = (long) this.mExifData.getStrip(stripCount).length;
            }
            exifTag3.setValue(jArr);
            ifdData.setTag(exifTag2);
            ifdData.setTag(exifTag3);
        }
    }

    private int requestByteToBuffer(int i, byte[] bArr, int i2, int i3) {
        int position = i - this.mBuffer.position();
        if (i3 > position) {
            i3 = position;
        }
        this.mBuffer.put(bArr, i2, i3);
        return i3;
    }

    private void writeAllTags(OrderedDataOutputStream orderedDataOutputStream) {
        writeIfd(this.mExifData.getIfdData(0), orderedDataOutputStream);
        writeIfd(this.mExifData.getIfdData(2), orderedDataOutputStream);
        IfdData ifdData = this.mExifData.getIfdData(3);
        if (ifdData != null) {
            writeIfd(ifdData, orderedDataOutputStream);
        }
        ifdData = this.mExifData.getIfdData(4);
        if (ifdData != null) {
            writeIfd(ifdData, orderedDataOutputStream);
        }
        if (this.mExifData.getIfdData(1) != null) {
            writeIfd(this.mExifData.getIfdData(1), orderedDataOutputStream);
        }
    }

    private void writeExifData() {
        createRequiredIfdAndTag();
        int calculateAllOffset = calculateAllOffset();
        OrderedDataOutputStream orderedDataOutputStream = new OrderedDataOutputStream(this.out);
        orderedDataOutputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        orderedDataOutputStream.writeShort((short) -31);
        orderedDataOutputStream.writeShort((short) (calculateAllOffset + 8));
        orderedDataOutputStream.writeInt(EXIF_HEADER);
        orderedDataOutputStream.writeShort((short) 0);
        if (this.mExifData.getByteOrder() == ByteOrder.BIG_ENDIAN) {
            orderedDataOutputStream.writeShort(TIFF_BIG_ENDIAN);
        } else {
            orderedDataOutputStream.writeShort(TIFF_LITTLE_ENDIAN);
        }
        orderedDataOutputStream.setByteOrder(this.mExifData.getByteOrder());
        orderedDataOutputStream.writeShort(TIFF_HEADER);
        orderedDataOutputStream.writeInt(8);
        writeAllTags(orderedDataOutputStream);
        writeThumbnail(orderedDataOutputStream);
    }

    private void writeIfd(IfdData ifdData, OrderedDataOutputStream orderedDataOutputStream) {
        int i;
        int i2 = 0;
        ExifTag[] allTags = ifdData.getAllTags();
        orderedDataOutputStream.writeShort((short) allTags.length);
        for (ExifTag exifTag : allTags) {
            orderedDataOutputStream.writeShort(exifTag.getTagId());
            orderedDataOutputStream.writeShort(exifTag.getDataType());
            orderedDataOutputStream.writeInt(exifTag.getComponentCount());
            if (exifTag.getDataSize() > 4) {
                orderedDataOutputStream.writeInt(exifTag.getOffset());
            } else {
                writeTagValue(exifTag, orderedDataOutputStream);
                int dataSize = 4 - exifTag.getDataSize();
                for (i = 0; i < dataSize; i++) {
                    orderedDataOutputStream.write(0);
                }
            }
        }
        orderedDataOutputStream.writeInt(ifdData.getOffsetToNextIfd());
        i = allTags.length;
        while (i2 < i) {
            ExifTag exifTag2 = allTags[i2];
            if (exifTag2.getDataSize() > 4) {
                writeTagValue(exifTag2, orderedDataOutputStream);
            }
            i2++;
        }
    }

    private void writeTagValue(ExifTag exifTag, OrderedDataOutputStream orderedDataOutputStream) {
        int i = 0;
        int i2;
        switch (exifTag.getDataType()) {
            case (short) 1:
            case (short) 7:
                byte[] bArr = new byte[exifTag.getComponentCount()];
                exifTag.getBytes(bArr);
                orderedDataOutputStream.write(bArr);
                return;
            case (short) 2:
                orderedDataOutputStream.write(exifTag.getString().getBytes());
                int componentCount = exifTag.getComponentCount() - exifTag.getString().length();
                for (i2 = 0; i2 < componentCount; i2++) {
                    orderedDataOutputStream.write(0);
                }
                return;
            case (short) 3:
                i2 = exifTag.getComponentCount();
                while (i < i2) {
                    orderedDataOutputStream.writeShort((short) exifTag.getUnsignedShort(i));
                    i++;
                }
                return;
            case (short) 4:
                i2 = exifTag.getComponentCount();
                while (i < i2) {
                    orderedDataOutputStream.writeInt((int) exifTag.getUnsignedLong(i));
                    i++;
                }
                return;
            case (short) 5:
            case (short) 10:
                i2 = exifTag.getComponentCount();
                while (i < i2) {
                    orderedDataOutputStream.writeRational(exifTag.getRational(i));
                    i++;
                }
                return;
            case (short) 9:
                i2 = exifTag.getComponentCount();
                while (i < i2) {
                    orderedDataOutputStream.writeInt(exifTag.getLong(i));
                    i++;
                }
                return;
            default:
                return;
        }
    }

    private void writeThumbnail(OrderedDataOutputStream orderedDataOutputStream) {
        if (this.mExifData.hasCompressedThumbnail()) {
            orderedDataOutputStream.write(this.mExifData.getCompressedThumbnail());
        } else if (this.mExifData.hasUncompressedStrip()) {
            for (int i = 0; i < this.mExifData.getStripCount(); i++) {
                orderedDataOutputStream.write(this.mExifData.getStrip(i));
            }
        }
    }

    public ExifData getExifData() {
        return this.mExifData;
    }

    public void setExifData(ExifData exifData) {
        this.mExifData = exifData;
    }

    public void write(int i) {
        write(new byte[]{(byte) (i & 255)});
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        while (true) {
            if ((this.mByteToSkip > 0 || this.mByteToCopy > 0 || this.mState != 2) && i2 > 0) {
                int i3;
                if (this.mByteToSkip > 0) {
                    i3 = i2 > this.mByteToSkip ? this.mByteToSkip : i2;
                    i2 -= i3;
                    this.mByteToSkip -= i3;
                    i += i3;
                }
                if (this.mByteToCopy > 0) {
                    i3 = i2 > this.mByteToCopy ? this.mByteToCopy : i2;
                    this.out.write(bArr, i, i3);
                    i2 -= i3;
                    this.mByteToCopy -= i3;
                    i += i3;
                }
                if (i2 != 0) {
                    switch (this.mState) {
                        case 0:
                            i3 = requestByteToBuffer(2, bArr, i, i2);
                            i += i3;
                            i2 -= i3;
                            if (this.mBuffer.position() >= 2) {
                                this.mBuffer.rewind();
                                if ($assertionsDisabled || this.mBuffer.getShort() == (short) -40) {
                                    this.out.write(this.mBuffer.array(), 0, 2);
                                    this.mState = 1;
                                    this.mBuffer.rewind();
                                    writeExifData();
                                    break;
                                }
                                throw new AssertionError();
                            }
                            return;
                        case 1:
                            i3 = requestByteToBuffer(4, bArr, i, i2);
                            i += i3;
                            i2 -= i3;
                            if (this.mBuffer.position() == 2 && this.mBuffer.getShort() == (short) -39) {
                                this.out.write(this.mBuffer.array(), 0, 2);
                                this.mBuffer.rewind();
                            }
                            if (this.mBuffer.position() >= 4) {
                                this.mBuffer.rewind();
                                short s = this.mBuffer.getShort();
                                if (s == (short) -31) {
                                    this.mByteToSkip = (this.mBuffer.getShort() & 255) - 2;
                                    this.mState = 2;
                                } else if (JpegHeader.isSofMarker(s)) {
                                    this.out.write(this.mBuffer.array(), 0, 4);
                                    this.mState = 2;
                                } else {
                                    this.out.write(this.mBuffer.array(), 0, 4);
                                    this.mByteToCopy = (this.mBuffer.getShort() & 255) - 2;
                                }
                                this.mBuffer.rewind();
                                break;
                            }
                            return;
                        default:
                            break;
                    }
                }
                return;
            } else if (i2 > 0) {
                this.out.write(bArr, i, i2);
                return;
            } else {
                return;
            }
        }
    }
}
