package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class abl {
    protected static final Comparator<byte[]> f7802a = new C26621();
    private List<byte[]> f7803b = new LinkedList();
    private List<byte[]> f7804c = new ArrayList(64);
    private int f7805d = 0;
    private final int f7806e;

    static class C26621 implements Comparator<byte[]> {
        C26621() {
        }

        public int m8767a(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m8767a((byte[]) obj, (byte[]) obj2);
        }
    }

    public abl(int i) {
        this.f7806e = i;
    }

    private synchronized void m8768a() {
        while (this.f7805d > this.f7806e) {
            byte[] bArr = (byte[]) this.f7803b.remove(0);
            this.f7804c.remove(bArr);
            this.f7805d -= bArr.length;
        }
    }

    public synchronized void m8769a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f7806e) {
                this.f7803b.add(bArr);
                int binarySearch = Collections.binarySearch(this.f7804c, bArr, f7802a);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f7804c.add(binarySearch, bArr);
                this.f7805d += bArr.length;
                m8768a();
            }
        }
    }

    public synchronized byte[] m8770a(int i) {
        byte[] bArr;
        for (int i2 = 0; i2 < this.f7804c.size(); i2++) {
            bArr = (byte[]) this.f7804c.get(i2);
            if (bArr.length >= i) {
                this.f7805d -= bArr.length;
                this.f7804c.remove(i2);
                this.f7803b.remove(bArr);
                break;
            }
        }
        bArr = new byte[i];
        return bArr;
    }
}
