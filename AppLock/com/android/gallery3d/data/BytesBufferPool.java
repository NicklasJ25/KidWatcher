package com.android.gallery3d.data;

import com.android.gallery3d.util.ThreadPool.JobContext;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.util.ArrayList;

public class BytesBufferPool {
    private static final int READ_STEP = 4096;
    private final int mBufferSize;
    private final ArrayList<BytesBuffer> mList;
    private final int mPoolSize;

    public static class BytesBuffer {
        public byte[] data;
        public int length;
        public int offset;

        private BytesBuffer(int i) {
            this.data = new byte[i];
        }

        public void readFrom(JobContext jobContext, FileDescriptor fileDescriptor) {
            FileInputStream fileInputStream = new FileInputStream(fileDescriptor);
            this.length = 0;
            try {
                int length = this.data.length;
                while (true) {
                    int read = fileInputStream.read(this.data, this.length, Math.min(4096, length - this.length));
                    if (read < 0 || jobContext.isCancelled()) {
                        fileInputStream.close();
                    } else {
                        this.length = read + this.length;
                        if (this.length == length) {
                            Object obj = new byte[(this.data.length * 2)];
                            System.arraycopy(this.data, 0, obj, 0, this.data.length);
                            this.data = obj;
                            length = this.data.length;
                        }
                    }
                }
                fileInputStream.close();
            } catch (Throwable th) {
                fileInputStream.close();
            }
        }
    }

    public BytesBufferPool(int i, int i2) {
        this.mList = new ArrayList(i);
        this.mPoolSize = i;
        this.mBufferSize = i2;
    }

    public synchronized void clear() {
        this.mList.clear();
    }

    public synchronized BytesBuffer get() {
        int size;
        size = this.mList.size();
        return size > 0 ? (BytesBuffer) this.mList.remove(size - 1) : new BytesBuffer(this.mBufferSize);
    }

    public synchronized void recycle(BytesBuffer bytesBuffer) {
        if (bytesBuffer.data.length == this.mBufferSize) {
            if (this.mList.size() < this.mPoolSize) {
                bytesBuffer.offset = 0;
                bytesBuffer.length = 0;
                this.mList.add(bytesBuffer);
            }
        }
    }
}
