package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

public class gv extends Reader {
    private List<String> f9146a;
    private boolean f9147b;
    private int f9148c;
    private int f9149d;
    private int f9150e;
    private int f9151f;
    private boolean f9152g;

    public gv() {
        this.f9146a = null;
        this.f9147b = false;
        this.f9150e = this.f9148c;
        this.f9151f = this.f9149d;
        this.f9152g = false;
        this.f9146a = new ArrayList();
    }

    private long m11263a(long j) {
        long j2 = 0;
        while (this.f9149d < this.f9146a.size() && j2 < j) {
            int c = m11265c();
            long j3 = j - j2;
            if (j3 < ((long) c)) {
                this.f9148c = (int) (((long) this.f9148c) + j3);
                j2 += j3;
            } else {
                j2 += (long) c;
                this.f9148c = 0;
                this.f9149d++;
            }
        }
        return j2;
    }

    private String m11264b() {
        return this.f9149d < this.f9146a.size() ? (String) this.f9146a.get(this.f9149d) : null;
    }

    private int m11265c() {
        String b = m11264b();
        return b == null ? 0 : b.length() - this.f9148c;
    }

    private void m11266d() {
        if (this.f9147b) {
            throw new IOException("Stream already closed");
        } else if (!this.f9152g) {
            throw new IOException("Reader needs to be frozen before read operations can be called");
        }
    }

    public void m11267a() {
        if (this.f9152g) {
            throw new IllegalStateException("Trying to freeze frozen StringListReader");
        }
        this.f9152g = true;
    }

    public void m11268a(String str) {
        if (this.f9152g) {
            throw new IllegalStateException("Trying to add string after reading");
        } else if (str.length() > 0) {
            this.f9146a.add(str);
        }
    }

    public void close() {
        m11266d();
        this.f9147b = true;
    }

    public void mark(int i) {
        m11266d();
        this.f9150e = this.f9148c;
        this.f9151f = this.f9149d;
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        m11266d();
        String b = m11264b();
        if (b == null) {
            return -1;
        }
        char charAt = b.charAt(this.f9148c);
        m11263a(1);
        return charAt;
    }

    public int read(CharBuffer charBuffer) {
        m11266d();
        int remaining = charBuffer.remaining();
        int i = 0;
        String b = m11264b();
        while (remaining > 0 && b != null) {
            int min = Math.min(b.length() - this.f9148c, remaining);
            charBuffer.put((String) this.f9146a.get(this.f9149d), this.f9148c, this.f9148c + min);
            remaining -= min;
            i += min;
            m11263a((long) min);
            b = m11264b();
        }
        return (i > 0 || b != null) ? i : -1;
    }

    public int read(char[] cArr, int i, int i2) {
        m11266d();
        int i3 = 0;
        String b = m11264b();
        while (b != null && i3 < i2) {
            int min = Math.min(m11265c(), i2 - i3);
            b.getChars(this.f9148c, this.f9148c + min, cArr, i + i3);
            int i4 = i3 + min;
            m11263a((long) min);
            i3 = i4;
            b = m11264b();
        }
        return (i3 > 0 || b != null) ? i3 : -1;
    }

    public boolean ready() {
        m11266d();
        return true;
    }

    public void reset() {
        this.f9148c = this.f9150e;
        this.f9149d = this.f9151f;
    }

    public long skip(long j) {
        m11266d();
        return m11263a(j);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : this.f9146a) {
            stringBuilder.append(append);
        }
        return stringBuilder.toString();
    }
}
