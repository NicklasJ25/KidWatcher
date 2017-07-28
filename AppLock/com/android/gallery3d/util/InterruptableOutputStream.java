package com.android.gallery3d.util;

import com.android.gallery3d.common.Utils;
import java.io.InterruptedIOException;
import java.io.OutputStream;

public class InterruptableOutputStream extends OutputStream {
    private static final int MAX_WRITE_BYTES = 4096;
    private volatile boolean mIsInterrupted = false;
    private OutputStream mOutputStream;

    public InterruptableOutputStream(OutputStream outputStream) {
        this.mOutputStream = (OutputStream) Utils.checkNotNull(outputStream);
    }

    public void close() {
        this.mOutputStream.close();
    }

    public void flush() {
        if (this.mIsInterrupted) {
            throw new InterruptedIOException();
        }
        this.mOutputStream.flush();
    }

    public void interrupt() {
        this.mIsInterrupted = true;
    }

    public void write(int i) {
        if (this.mIsInterrupted) {
            throw new InterruptedIOException();
        }
        this.mOutputStream.write(i);
    }

    public void write(byte[] bArr, int i, int i2) {
        int i3 = i + i2;
        while (i < i3) {
            if (this.mIsInterrupted) {
                throw new InterruptedIOException();
            }
            int min = Math.min(4096, i3 - i);
            this.mOutputStream.write(bArr, i, min);
            i += min;
        }
    }
}
