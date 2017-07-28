package com.google.android.gms.internal;

import com.google.android.gms.internal.jt.C2958a;
import com.google.android.gms.internal.kf.C3025a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class ju {
    private final List<hh> f9583a;
    private final List<String> f9584b;

    class C30141 extends C2958a {
        final /* synthetic */ C3015a f9573a;

        C30141(C3015a c3015a) {
            this.f9573a = c3015a;
        }

        public void mo3720a(js jsVar, kf kfVar) {
            this.f9573a.m12045a(jsVar);
            ju.m12066b(kfVar, this.f9573a);
            this.f9573a.m12055e();
        }
    }

    static class C3015a {
        private StringBuilder f9574a = null;
        private Stack<js> f9575b = new Stack();
        private int f9576c = -1;
        private int f9577d;
        private boolean f9578e = true;
        private final List<hh> f9579f = new ArrayList();
        private final List<String> f9580g = new ArrayList();
        private final C3016c f9581h;

        public C3015a(C3016c c3016c) {
            this.f9581h = c3016c;
        }

        private hh m12044a(int i) {
            js[] jsVarArr = new js[i];
            for (int i2 = 0; i2 < i; i2++) {
                jsVarArr[i2] = (js) this.f9575b.get(i2);
            }
            return new hh(jsVarArr);
        }

        private void m12045a(js jsVar) {
            m12053d();
            if (this.f9578e) {
                this.f9574a.append(",");
            }
            m12050a(this.f9574a, jsVar);
            this.f9574a.append(":(");
            if (this.f9577d == this.f9575b.size()) {
                this.f9575b.add(jsVar);
            } else {
                this.f9575b.set(this.f9577d, jsVar);
            }
            this.f9577d++;
            this.f9578e = false;
        }

        private void m12049a(kb<?> kbVar) {
            m12053d();
            this.f9576c = this.f9577d;
            this.f9574a.append(kbVar.mo3787a(C3025a.V2));
            this.f9578e = true;
            if (this.f9581h.mo3793a(this)) {
                m12057g();
            }
        }

        private void m12050a(StringBuilder stringBuilder, js jsVar) {
            stringBuilder.append(lh.m12298c(jsVar.m12010d()));
        }

        private void m12053d() {
            if (!m12058a()) {
                this.f9574a = new StringBuilder();
                this.f9574a.append("(");
                Iterator it = m12044a(this.f9577d).iterator();
                while (it.hasNext()) {
                    m12050a(this.f9574a, (js) it.next());
                    this.f9574a.append(":(");
                }
                this.f9578e = false;
            }
        }

        private void m12055e() {
            this.f9577d--;
            if (m12058a()) {
                this.f9574a.append(")");
            }
            this.f9578e = true;
        }

        private void m12056f() {
            lh.m12296a(this.f9577d == 0, "Can't finish hashing in the middle processing a child");
            if (m12058a()) {
                m12057g();
            }
            this.f9580g.add("");
        }

        private void m12057g() {
            lh.m12296a(m12058a(), "Can't end range without starting a range!");
            for (int i = 0; i < this.f9577d; i++) {
                this.f9574a.append(")");
            }
            this.f9574a.append(")");
            hh a = m12044a(this.f9576c);
            this.f9580g.add(lh.m12297b(this.f9574a.toString()));
            this.f9579f.add(a);
            this.f9574a = null;
        }

        public boolean m12058a() {
            return this.f9574a != null;
        }

        public int m12059b() {
            return this.f9574a.length();
        }

        public hh m12060c() {
            return m12044a(this.f9577d);
        }
    }

    public interface C3016c {
        boolean mo3793a(C3015a c3015a);
    }

    private static class C3017b implements C3016c {
        private final long f9582a;

        public C3017b(kf kfVar) {
            this.f9582a = Math.max(512, (long) Math.sqrt((double) (lc.m12281a(kfVar) * 100)));
        }

        public boolean mo3793a(C3015a c3015a) {
            return ((long) c3015a.m12059b()) > this.f9582a && (c3015a.m12060c().m11391h() || !c3015a.m12060c().m11390g().equals(js.m12008c()));
        }
    }

    private ju(List<hh> list, List<String> list2) {
        if (list.size() != list2.size() - 1) {
            throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        }
        this.f9583a = list;
        this.f9584b = list2;
    }

    public static ju m12063a(kf kfVar) {
        return m12064a(kfVar, new C3017b(kfVar));
    }

    public static ju m12064a(kf kfVar, C3016c c3016c) {
        if (kfVar.mo3778b()) {
            return new ju(Collections.emptyList(), Collections.singletonList(""));
        }
        C3015a c3015a = new C3015a(c3016c);
        m12066b(kfVar, c3015a);
        c3015a.m12056f();
        return new ju(c3015a.f9579f, c3015a.f9580g);
    }

    private static void m12066b(kf kfVar, C3015a c3015a) {
        if (kfVar.mo3782e()) {
            c3015a.m12049a((kb) kfVar);
        } else if (kfVar.mo3778b()) {
            throw new IllegalArgumentException("Can't calculate hash on empty node!");
        } else if (kfVar instanceof jt) {
            ((jt) kfVar).m12030a(new C30141(c3015a), true);
        } else {
            String valueOf = String.valueOf(kfVar);
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Expected children node, but got: ").append(valueOf).toString());
        }
    }

    public List<hh> m12067a() {
        return Collections.unmodifiableList(this.f9583a);
    }

    public List<String> m12068b() {
        return Collections.unmodifiableList(this.f9584b);
    }
}
