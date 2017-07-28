package com.facebook.ads.internal.p030j.p032b.p033a;

import com.facebook.ads.internal.p030j.p032b.C1635a;
import com.facebook.ads.internal.p030j.p032b.C1661l;
import java.io.File;
import java.io.RandomAccessFile;

public class C1636b implements C1635a {
    public File f4044a;
    private final C1634a f4045b;
    private RandomAccessFile f4046c;

    public C1636b(File file, C1634a c1634a) {
        if (c1634a == null) {
            try {
                throw new NullPointerException();
            } catch (Throwable e) {
                throw new C1661l("Error using file " + file + " as disc cache", e);
            }
        }
        this.f4045b = c1634a;
        C1640d.m4618a(file.getParentFile());
        boolean exists = file.exists();
        this.f4044a = exists ? file : new File(file.getParentFile(), file.getName() + ".download");
        this.f4046c = new RandomAccessFile(this.f4044a, exists ? "r" : "rw");
    }

    private boolean m4608a(File file) {
        return file.getName().endsWith(".download");
    }

    public synchronized int mo2760a() {
        try {
        } catch (Throwable e) {
            throw new C1661l("Error reading length of file " + this.f4044a, e);
        }
        return (int) this.f4046c.length();
    }

    public synchronized int mo2761a(byte[] bArr, long j, int i) {
        try {
            this.f4046c.seek(j);
        } catch (Throwable e) {
            throw new C1661l(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(mo2760a()), Integer.valueOf(bArr.length)}), e);
        }
        return this.f4046c.read(bArr, 0, i);
    }

    public synchronized void mo2762a(byte[] bArr, int i) {
        try {
            if (mo2765d()) {
                throw new C1661l("Error append cache: cache file " + this.f4044a + " is completed!");
            }
            this.f4046c.seek((long) mo2760a());
            this.f4046c.write(bArr, 0, i);
        } catch (Throwable e) {
            throw new C1661l(String.format("Error writing %d bytes to %s from buffer with size %d", new Object[]{Integer.valueOf(i), this.f4046c, Integer.valueOf(bArr.length)}), e);
        }
    }

    public synchronized void mo2763b() {
        try {
            this.f4046c.close();
            this.f4045b.mo2766a(this.f4044a);
        } catch (Throwable e) {
            throw new C1661l("Error closing file " + this.f4044a, e);
        }
    }

    public synchronized void mo2764c() {
        if (!mo2765d()) {
            mo2763b();
            File file = new File(this.f4044a.getParentFile(), this.f4044a.getName().substring(0, this.f4044a.getName().length() - ".download".length()));
            if (this.f4044a.renameTo(file)) {
                this.f4044a = file;
                try {
                    this.f4046c = new RandomAccessFile(this.f4044a, "r");
                } catch (Throwable e) {
                    throw new C1661l("Error opening " + this.f4044a + " as disc cache", e);
                }
            }
            throw new C1661l("Error renaming file " + this.f4044a + " to " + file + " for completion!");
        }
    }

    public synchronized boolean mo2765d() {
        return !m4608a(this.f4044a);
    }
}
