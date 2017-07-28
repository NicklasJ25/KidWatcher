package org.apache.p068a.p069a.p070a;

import java.io.Serializable;
import java.io.Writer;

public class C3610b extends Writer implements Serializable {
    private final StringBuilder f12295a;

    public C3610b() {
        this.f12295a = new StringBuilder();
    }

    public C3610b(int i) {
        this.f12295a = new StringBuilder(i);
    }

    public Writer append(char c) {
        this.f12295a.append(c);
        return this;
    }

    public Writer append(CharSequence charSequence) {
        this.f12295a.append(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int i, int i2) {
        this.f12295a.append(charSequence, i, i2);
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    public String toString() {
        return this.f12295a.toString();
    }

    public void write(String str) {
        if (str != null) {
            this.f12295a.append(str);
        }
    }

    public void write(char[] cArr, int i, int i2) {
        if (cArr != null) {
            this.f12295a.append(cArr, i, i2);
        }
    }
}
