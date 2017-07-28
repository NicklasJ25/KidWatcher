package com.google.android.gms.internal;

import com.google.firebase.database.C3537c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class hh implements Comparable<hh>, Iterable<js> {
    static final /* synthetic */ boolean f9196a = (!hh.class.desiredAssertionStatus());
    private static final hh f9197e = new hh("");
    private final js[] f9198b;
    private final int f9199c;
    private final int f9200d;

    class C29381 implements Iterator<js> {
        int f9194a = this.f9195b.f9199c;
        final /* synthetic */ hh f9195b;

        C29381(hh hhVar) {
            this.f9195b = hhVar;
        }

        public js m11375a() {
            if (hasNext()) {
                js jsVar = this.f9195b.f9198b[this.f9194a];
                this.f9194a++;
                return jsVar;
            }
            throw new NoSuchElementException("No more elements.");
        }

        public boolean hasNext() {
            return this.f9194a < this.f9195b.f9200d;
        }

        public /* synthetic */ Object next() {
            return m11375a();
        }

        public void remove() {
            throw new UnsupportedOperationException("Can't remove component from immutable Path!");
        }
    }

    public hh(String str) {
        String[] split = str.split("/");
        int i = 0;
        for (String length : split) {
            if (length.length() > 0) {
                i++;
            }
        }
        this.f9198b = new js[i];
        int length2 = split.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length2) {
            String str2 = split[i2];
            if (str2.length() > 0) {
                i = i3 + 1;
                this.f9198b[i3] = js.m12005a(str2);
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        this.f9199c = 0;
        this.f9200d = this.f9198b.length;
    }

    public hh(List<String> list) {
        this.f9198b = new js[list.size()];
        int i = 0;
        for (String a : list) {
            int i2 = i + 1;
            this.f9198b[i] = js.m12005a(a);
            i = i2;
        }
        this.f9199c = 0;
        this.f9200d = list.size();
    }

    public hh(js... jsVarArr) {
        this.f9198b = (js[]) Arrays.copyOf(jsVarArr, jsVarArr.length);
        this.f9199c = 0;
        this.f9200d = jsVarArr.length;
        int length = jsVarArr.length;
        int i = 0;
        while (i < length) {
            js jsVar = jsVarArr[i];
            if (f9196a || jsVar != null) {
                i++;
            } else {
                throw new AssertionError("Can't construct a path with a null value!");
            }
        }
    }

    private hh(js[] jsVarArr, int i, int i2) {
        this.f9198b = jsVarArr;
        this.f9199c = i;
        this.f9200d = i2;
    }

    public static hh m11376a() {
        return f9197e;
    }

    public static hh m11377a(hh hhVar, hh hhVar2) {
        js d = hhVar.m11387d();
        js d2 = hhVar2.m11387d();
        if (d == null) {
            return hhVar2;
        }
        if (d.equals(d2)) {
            return m11377a(hhVar.m11388e(), hhVar2.m11388e());
        }
        String valueOf = String.valueOf(hhVar2);
        String valueOf2 = String.valueOf(hhVar);
        throw new C3537c(new StringBuilder((String.valueOf(valueOf).length() + 37) + String.valueOf(valueOf2).length()).append("INTERNAL ERROR: ").append(valueOf).append(" is not contained in ").append(valueOf2).toString());
    }

    public hh m11381a(hh hhVar) {
        int i = m11392i() + hhVar.m11392i();
        Object obj = new js[i];
        System.arraycopy(this.f9198b, this.f9199c, obj, 0, m11392i());
        System.arraycopy(hhVar.f9198b, hhVar.f9199c, obj, m11392i(), hhVar.m11392i());
        return new hh(obj, 0, i);
    }

    public hh m11382a(js jsVar) {
        int i = m11392i();
        Object obj = new js[(i + 1)];
        System.arraycopy(this.f9198b, this.f9199c, obj, 0, i);
        obj[i] = jsVar;
        return new hh(obj, 0, i + 1);
    }

    public String m11383b() {
        if (m11391h()) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = this.f9199c; i < this.f9200d; i++) {
            if (i > this.f9199c) {
                stringBuilder.append("/");
            }
            stringBuilder.append(this.f9198b[i].m12010d());
        }
        return stringBuilder.toString();
    }

    public boolean m11384b(hh hhVar) {
        if (m11392i() > hhVar.m11392i()) {
            return false;
        }
        int i = this.f9199c;
        int i2 = hhVar.f9199c;
        while (i < this.f9200d) {
            if (!this.f9198b[i].equals(hhVar.f9198b[i2])) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public int m11385c(hh hhVar) {
        int i = this.f9199c;
        int i2 = hhVar.f9199c;
        while (i < this.f9200d && i2 < hhVar.f9200d) {
            int a = this.f9198b[i].m12009a(hhVar.f9198b[i2]);
            if (a != 0) {
                return a;
            }
            i++;
            i2++;
        }
        return (i == this.f9200d && i2 == hhVar.f9200d) ? 0 : i == this.f9200d ? -1 : 1;
    }

    public List<String> m11386c() {
        List<String> arrayList = new ArrayList(m11392i());
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(((js) it.next()).m12010d());
        }
        return arrayList;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m11385c((hh) obj);
    }

    public js m11387d() {
        return m11391h() ? null : this.f9198b[this.f9199c];
    }

    public hh m11388e() {
        int i = this.f9199c;
        if (!m11391h()) {
            i++;
        }
        return new hh(this.f9198b, i, this.f9200d);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof hh)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        hh hhVar = (hh) obj;
        if (m11392i() != hhVar.m11392i()) {
            return false;
        }
        int i = this.f9199c;
        int i2 = hhVar.f9199c;
        while (i < this.f9200d && i2 < hhVar.f9200d) {
            if (!this.f9198b[i].equals(hhVar.f9198b[i2])) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public hh m11389f() {
        return m11391h() ? null : new hh(this.f9198b, this.f9199c, this.f9200d - 1);
    }

    public js m11390g() {
        return !m11391h() ? this.f9198b[this.f9200d - 1] : null;
    }

    public boolean m11391h() {
        return this.f9199c >= this.f9200d;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = this.f9199c; i2 < this.f9200d; i2++) {
            i = (i * 37) + this.f9198b[i2].hashCode();
        }
        return i;
    }

    public int m11392i() {
        return this.f9200d - this.f9199c;
    }

    public Iterator<js> iterator() {
        return new C29381(this);
    }

    public String toString() {
        if (m11391h()) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = this.f9199c; i < this.f9200d; i++) {
            stringBuilder.append("/");
            stringBuilder.append(this.f9198b[i].m12010d());
        }
        return stringBuilder.toString();
    }
}
