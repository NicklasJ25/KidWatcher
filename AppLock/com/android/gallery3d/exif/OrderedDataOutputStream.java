package com.android.gallery3d.exif;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class OrderedDataOutputStream extends FilterOutputStream {
    private final ByteBuffer mByteBuffer = ByteBuffer.allocate(4);

    public OrderedDataOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void setByteOrder(ByteOrder byteOrder) {
        this.mByteBuffer.order(byteOrder);
    }

    public void writeInt(int i) {
        this.mByteBuffer.rewind();
        this.mByteBuffer.putInt(i);
        this.out.write(this.mByteBuffer.array());
    }

    public void writeRational(Rational rational) {
        writeInt((int) rational.getNominator());
        writeInt((int) rational.getDenominator());
    }

    public void writeShort(short s) {
        this.mByteBuffer.rewind();
        this.mByteBuffer.putShort(s);
        this.out.write(this.mByteBuffer.array(), 0, 2);
    }
}
