package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzw;
import java.util.ArrayList;
import java.util.Iterator;

@wh
public class ne {
    private final int f9961a;
    private final int f9962b;
    private final int f9963c;
    private final nk f9964d;
    private final np f9965e;
    private final Object f9966f = new Object();
    private ArrayList<String> f9967g = new ArrayList();
    private ArrayList<String> f9968h = new ArrayList();
    private ArrayList<ni> f9969i = new ArrayList();
    private int f9970j = 0;
    private int f9971k = 0;
    private int f9972l = 0;
    private int f9973m;
    private String f9974n = "";
    private String f9975o = "";
    private String f9976p = "";

    public ne(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f9961a = i;
        this.f9962b = i2;
        this.f9963c = i3;
        this.f9964d = new nk(i4);
        this.f9965e = new np(i5, i6, i7);
    }

    private String m12750a(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
            stringBuffer.append(' ');
            if (stringBuffer.length() > i) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() >= i ? stringBuffer2.substring(0, i) : stringBuffer2;
    }

    private void m12751c(@Nullable String str, boolean z, float f, float f2, float f3, float f4) {
        if (str != null && str.length() >= this.f9963c) {
            synchronized (this.f9966f) {
                this.f9967g.add(str);
                this.f9970j += str.length();
                if (z) {
                    this.f9968h.add(str);
                    this.f9969i.add(new ni(f, f2, f3, f4, this.f9968h.size() - 1));
                }
            }
        }
    }

    int m12752a(int i, int i2) {
        return (this.f9961a * i) + (this.f9962b * i2);
    }

    public void m12753a(int i) {
        this.f9971k = i;
    }

    public void m12754a(String str, boolean z, float f, float f2, float f3, float f4) {
        m12751c(str, z, f, f2, f3, f4);
        synchronized (this.f9966f) {
            if (this.f9972l < 0) {
                aad.m8421b("ActivityContent: negative number of WebViews.");
            }
            m12763h();
        }
    }

    public boolean m12755a() {
        boolean z;
        synchronized (this.f9966f) {
            z = this.f9972l == 0;
        }
        return z;
    }

    public String m12756b() {
        return this.f9974n;
    }

    public void m12757b(String str, boolean z, float f, float f2, float f3, float f4) {
        m12751c(str, z, f, f2, f3, f4);
    }

    public String m12758c() {
        return this.f9975o;
    }

    public String m12759d() {
        return this.f9976p;
    }

    public void m12760e() {
        synchronized (this.f9966f) {
            this.f9973m -= 100;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ne)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ne neVar = (ne) obj;
        return neVar.m12756b() != null && neVar.m12756b().equals(m12756b());
    }

    public void m12761f() {
        synchronized (this.f9966f) {
            this.f9972l--;
        }
    }

    public void m12762g() {
        synchronized (this.f9966f) {
            this.f9972l++;
        }
    }

    public void m12763h() {
        synchronized (this.f9966f) {
            int a = m12752a(this.f9970j, this.f9971k);
            if (a > this.f9973m) {
                this.f9973m = a;
                if (((Boolean) qb.ac.m13225c()).booleanValue() && !zzw.zzcQ().m15008b()) {
                    this.f9974n = this.f9964d.m12811a(this.f9967g);
                    this.f9975o = this.f9964d.m12811a(this.f9968h);
                }
                if (((Boolean) qb.ae.m13225c()).booleanValue() && !zzw.zzcQ().m15010c()) {
                    this.f9976p = this.f9965e.m12832a(this.f9968h, this.f9969i);
                }
            }
        }
    }

    public int hashCode() {
        return m12756b().hashCode();
    }

    public int m12764i() {
        return this.f9973m;
    }

    int m12765j() {
        return this.f9970j;
    }

    public String toString() {
        int i = this.f9971k;
        int i2 = this.f9973m;
        int i3 = this.f9970j;
        String valueOf = String.valueOf(m12750a(this.f9967g, 100));
        String valueOf2 = String.valueOf(m12750a(this.f9968h, 100));
        String str = this.f9974n;
        String str2 = this.f9975o;
        String str3 = this.f9976p;
        return new StringBuilder(((((String.valueOf(valueOf).length() + 165) + String.valueOf(valueOf2).length()) + String.valueOf(str).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append("ActivityContent fetchId: ").append(i).append(" score:").append(i2).append(" total_length:").append(i3).append("\n text: ").append(valueOf).append("\n viewableText").append(valueOf2).append("\n signture: ").append(str).append("\n viewableSignture: ").append(str2).append("\n viewableSignatureForVertical: ").append(str3).toString();
    }
}
