package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.internal.nn.C3102a;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@wh
public class nk {
    private final int f10027a;
    private final int f10028b;
    private final int f10029c;
    private final nj f10030d = new nm();

    class C31001 implements Comparator<C3102a> {
        C31001(nk nkVar) {
        }

        public int m12807a(C3102a c3102a, C3102a c3102a2) {
            int i = c3102a.f10034c - c3102a2.f10034c;
            return i != 0 ? i : (int) (c3102a.f10032a - c3102a2.f10032a);
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m12807a((C3102a) obj, (C3102a) obj2);
        }
    }

    static class C3101a {
        ByteArrayOutputStream f10025a = new ByteArrayOutputStream(4096);
        Base64OutputStream f10026b = new Base64OutputStream(this.f10025a, 10);

        public void m12808a(byte[] bArr) {
            this.f10026b.write(bArr);
        }

        public String toString() {
            String byteArrayOutputStream;
            try {
                this.f10026b.close();
            } catch (Throwable e) {
                aad.m8422b("HashManager: Unable to convert to Base64.", e);
            }
            try {
                this.f10025a.close();
                byteArrayOutputStream = this.f10025a.toString();
            } catch (Throwable e2) {
                aad.m8422b("HashManager: Unable to convert to Base64.", e2);
                byteArrayOutputStream = "";
            } finally {
                this.f10025a = null;
                this.f10026b = null;
            }
            return byteArrayOutputStream;
        }
    }

    public nk(int i) {
        this.f10028b = i;
        this.f10027a = 6;
        this.f10029c = 0;
    }

    C3101a m12809a() {
        return new C3101a();
    }

    String m12810a(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        C3101a a = m12809a();
        PriorityQueue priorityQueue = new PriorityQueue(this.f10028b, new C31001(this));
        for (String b : split) {
            String[] b2 = nl.m12817b(b);
            if (b2.length != 0) {
                nn.m12827a(b2, this.f10028b, this.f10027a, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                a.m12808a(this.f10030d.mo3848a(((C3102a) it.next()).f10033b));
            } catch (Throwable e) {
                aad.m8422b("Error while writing hash to byteStream", e);
            }
        }
        return a.toString();
    }

    public String m12811a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((String) it.next()).toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        return m12810a(stringBuffer.toString());
    }
}
