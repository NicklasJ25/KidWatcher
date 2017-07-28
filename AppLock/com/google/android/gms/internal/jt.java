package com.google.android.gms.internal;

import com.google.android.gms.internal.fx.C2882a;
import com.google.android.gms.internal.gd.C2889b;
import com.google.android.gms.internal.kf.C3025a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class jt implements kf {
    public static Comparator<js> f9568a = new C30111();
    static final /* synthetic */ boolean f9569b = (!jt.class.desiredAssertionStatus());
    private final fx<js, kf> f9570c;
    private final kf f9571e;
    private String f9572f;

    public static abstract class C2958a extends C2889b<js, kf> {
        public abstract void mo3720a(js jsVar, kf kfVar);

        public /* synthetic */ void mo3719a(Object obj, Object obj2) {
            m11488b((js) obj, (kf) obj2);
        }

        public void m11488b(js jsVar, kf kfVar) {
            mo3720a(jsVar, kfVar);
        }
    }

    class C30111 implements Comparator<js> {
        C30111() {
        }

        public int m12016a(js jsVar, js jsVar2) {
            return jsVar.m12009a(jsVar2);
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m12016a((js) obj, (js) obj2);
        }
    }

    private static class C3013b implements Iterator<ke> {
        private final Iterator<Entry<js, kf>> f9567a;

        public C3013b(Iterator<Entry<js, kf>> it) {
            this.f9567a = it;
        }

        public ke m12019a() {
            Entry entry = (Entry) this.f9567a.next();
            return new ke((js) entry.getKey(), (kf) entry.getValue());
        }

        public boolean hasNext() {
            return this.f9567a.hasNext();
        }

        public /* synthetic */ Object next() {
            return m12019a();
        }

        public void remove() {
            this.f9567a.remove();
        }
    }

    protected jt() {
        this.f9572f = null;
        this.f9570c = C2882a.m10944a(f9568a);
        this.f9571e = kj.m12190a();
    }

    protected jt(fx<js, kf> fxVar, kf kfVar) {
        this.f9572f = null;
        if (!fxVar.mo3643d() || kfVar.mo3778b()) {
            this.f9571e = kfVar;
            this.f9570c = fxVar;
            return;
        }
        throw new IllegalArgumentException("Can't create empty ChildrenNode with priority!");
    }

    private static void m12020a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(" ");
        }
    }

    private void m12021b(StringBuilder stringBuilder, int i) {
        if (this.f9570c.mo3643d() && this.f9571e.mo3778b()) {
            stringBuilder.append("{ }");
            return;
        }
        stringBuilder.append("{\n");
        Iterator it = this.f9570c.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            m12020a(stringBuilder, i + 2);
            stringBuilder.append(((js) entry.getKey()).m12010d());
            stringBuilder.append("=");
            if (entry.getValue() instanceof jt) {
                ((jt) entry.getValue()).m12021b(stringBuilder, i + 2);
            } else {
                stringBuilder.append(((kf) entry.getValue()).toString());
            }
            stringBuilder.append("\n");
        }
        if (!this.f9571e.mo3778b()) {
            m12020a(stringBuilder, i + 2);
            stringBuilder.append(".priority=");
            stringBuilder.append(this.f9571e.toString());
            stringBuilder.append("\n");
        }
        m12020a(stringBuilder, i);
        stringBuilder.append("}");
    }

    public int mo3794a(kf kfVar) {
        return mo3778b() ? kfVar.mo3778b() ? 0 : -1 : kfVar.mo3782e() ? 1 : kfVar.mo3778b() ? 1 : kfVar == kf.f9552d ? -1 : 0;
    }

    public kf mo3772a(hh hhVar) {
        js d = hhVar.m11387d();
        return d == null ? this : mo3780c(d).mo3772a(hhVar.m11388e());
    }

    public kf mo3773a(hh hhVar, kf kfVar) {
        js d = hhVar.m11387d();
        if (d == null) {
            return kfVar;
        }
        if (!d.m12011e()) {
            return mo3774a(d, mo3780c(d).mo3773a(hhVar.m11388e(), kfVar));
        }
        if (f9569b || kj.m12192a(kfVar)) {
            return mo3788b(kfVar);
        }
        throw new AssertionError();
    }

    public kf mo3774a(js jsVar, kf kfVar) {
        if (jsVar.m12011e()) {
            return mo3788b(kfVar);
        }
        fx fxVar = this.f9570c;
        if (fxVar.mo3637a((Object) jsVar)) {
            fxVar = fxVar.mo3641c(jsVar);
        }
        if (!kfVar.mo3778b()) {
            fxVar = fxVar.mo3634a(jsVar, kfVar);
        }
        return fxVar.mo3643d() ? jx.m12080j() : new jt(fxVar, this.f9571e);
    }

    public Object mo3786a() {
        return mo3775a(false);
    }

    public Object mo3775a(boolean z) {
        int i = 0;
        if (mo3778b()) {
            return null;
        }
        Map hashMap = new HashMap();
        Iterator it = this.f9570c.iterator();
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            int i5;
            int i6;
            Entry entry = (Entry) it.next();
            String d = ((js) entry.getKey()).m12010d();
            hashMap.put(d, ((kf) entry.getValue()).mo3775a(z));
            i4++;
            if (i2 != 0) {
                if (d.length() <= 1 || d.charAt(0) != '0') {
                    Integer d2 = lh.m12299d(d);
                    if (d2 == null || d2.intValue() < 0) {
                        i5 = 0;
                        i6 = i3;
                        i2 = i5;
                        i3 = i6;
                    } else if (d2.intValue() > i3) {
                        i3 = d2.intValue();
                        i5 = i2;
                        i6 = i3;
                        i2 = i5;
                        i3 = i6;
                    }
                } else {
                    i5 = 0;
                    i6 = i3;
                    i2 = i5;
                    i3 = i6;
                }
            }
            i5 = i2;
            i6 = i3;
            i2 = i5;
            i3 = i6;
        }
        if (z || i2 == 0 || i3 >= i4 * 2) {
            if (z && !this.f9571e.mo3778b()) {
                hashMap.put(".priority", this.f9571e.mo3786a());
            }
            return hashMap;
        }
        List arrayList = new ArrayList(i3 + 1);
        while (i <= i3) {
            arrayList.add(hashMap.get(i));
            i++;
        }
        return arrayList;
    }

    public String mo3787a(C3025a c3025a) {
        if (c3025a != C3025a.V1) {
            throw new IllegalArgumentException("Hashes on children nodes only supported for V1");
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (!this.f9571e.mo3778b()) {
            stringBuilder.append("priority:");
            stringBuilder.append(this.f9571e.mo3787a(C3025a.V1));
            stringBuilder.append(":");
        }
        List<ke> arrayList = new ArrayList();
        Iterator it = iterator();
        Object obj = null;
        while (it.hasNext()) {
            ke keVar = (ke) it.next();
            arrayList.add(keVar);
            Object obj2 = (obj == null && keVar.m12170d().mo3783f().mo3778b()) ? null : 1;
            obj = obj2;
        }
        if (obj != null) {
            Collections.sort(arrayList, ki.m12184d());
        }
        for (ke keVar2 : arrayList) {
            String d = keVar2.m12170d().mo3781d();
            if (!d.equals("")) {
                stringBuilder.append(":");
                stringBuilder.append(keVar2.m12169c().m12010d());
                stringBuilder.append(":");
                stringBuilder.append(d);
            }
        }
        return stringBuilder.toString();
    }

    public void m12029a(C2958a c2958a) {
        m12030a(c2958a, false);
    }

    public void m12030a(final C2958a c2958a, boolean z) {
        if (!z || mo3783f().mo3778b()) {
            this.f9570c.mo3636a((C2889b) c2958a);
        } else {
            this.f9570c.mo3636a(new C2889b<js, kf>(this) {
                boolean f9564a = false;
                final /* synthetic */ jt f9566c;

                public void m12017a(js jsVar, kf kfVar) {
                    if (!this.f9564a && jsVar.m12009a(js.m12008c()) > 0) {
                        this.f9564a = true;
                        c2958a.mo3720a(js.m12008c(), this.f9566c.mo3783f());
                    }
                    c2958a.mo3720a(jsVar, kfVar);
                }

                public /* synthetic */ void mo3719a(Object obj, Object obj2) {
                    m12017a((js) obj, (kf) obj2);
                }
            });
        }
    }

    public boolean mo3776a(js jsVar) {
        return !mo3780c(jsVar).mo3778b();
    }

    public js mo3777b(js jsVar) {
        return (js) this.f9570c.mo3642d(jsVar);
    }

    public kf mo3788b(kf kfVar) {
        return this.f9570c.mo3643d() ? jx.m12080j() : new jt(this.f9570c, kfVar);
    }

    public boolean mo3778b() {
        return this.f9570c.mo3643d();
    }

    public int mo3779c() {
        return this.f9570c.mo3640c();
    }

    public kf mo3780c(js jsVar) {
        return (!jsVar.m12011e() || this.f9571e.mo3778b()) ? this.f9570c.mo3637a((Object) jsVar) ? (kf) this.f9570c.mo3639b(jsVar) : jx.m12080j() : this.f9571e;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return mo3794a((kf) obj);
    }

    public String mo3781d() {
        if (this.f9572f == null) {
            String a = mo3787a(C3025a.V1);
            this.f9572f = a.isEmpty() ? "" : lh.m12297b(a);
        }
        return this.f9572f;
    }

    public boolean mo3782e() {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof jt)) {
            return false;
        }
        jt jtVar = (jt) obj;
        if (!mo3783f().equals(jtVar.mo3783f())) {
            return false;
        }
        if (this.f9570c.mo3640c() != jtVar.f9570c.mo3640c()) {
            return false;
        }
        Iterator it = this.f9570c.iterator();
        Iterator it2 = jtVar.f9570c.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Entry entry = (Entry) it.next();
            Entry entry2 = (Entry) it2.next();
            if (((js) entry.getKey()).equals(entry2.getKey())) {
                if (!((kf) entry.getValue()).equals(entry2.getValue())) {
                }
            }
            return false;
        }
        if (!it.hasNext() && !it2.hasNext()) {
            return true;
        }
        throw new IllegalStateException("Something went wrong internally.");
    }

    public kf mo3783f() {
        return this.f9571e;
    }

    public js m12040g() {
        return (js) this.f9570c.mo3635a();
    }

    public js m12041h() {
        return (js) this.f9570c.mo3638b();
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            ke keVar = (ke) it.next();
            i = keVar.m12170d().hashCode() + (((i * 31) + keVar.m12169c().hashCode()) * 17);
        }
        return i;
    }

    public Iterator<ke> mo3784i() {
        return new C3013b(this.f9570c.mo3644e());
    }

    public Iterator<ke> iterator() {
        return new C3013b(this.f9570c.iterator());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        m12021b(stringBuilder, 0);
        return stringBuilder.toString();
    }
}
