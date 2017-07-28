package com.domobile.applock.livelock.p014b;

import android.os.Handler;
import java.util.ArrayList;

public class C0975a {
    private ArrayList<C0976b> f1595a;
    private Handler f1596b = new Handler();
    private C0973a f1597c;
    private boolean f1598d = false;
    private boolean f1599e = true;
    private boolean f1600f = false;
    private C0974b f1601g = new C0974b();

    public interface C0973a {
        void mo2470a();

        void mo2471a(int i, C0976b c0976b);
    }

    private class C0974b implements Runnable {
        public int f1593a;
        final /* synthetic */ C0975a f1594b;

        private C0974b(C0975a c0975a) {
            this.f1594b = c0975a;
        }

        public void run() {
            if (this.f1594b.f1600f) {
                this.f1593a--;
                int size = this.f1594b.f1595a.size() - 1;
                if (this.f1593a < 0) {
                    this.f1593a = size;
                    if (this.f1594b.f1599e) {
                        this.f1594b.m1832a(this.f1593a);
                        return;
                    } else {
                        this.f1594b.m1844d();
                        return;
                    }
                }
                this.f1594b.m1832a(this.f1593a);
                return;
            }
            this.f1593a++;
            if (this.f1593a > this.f1594b.f1595a.size() - 1) {
                this.f1593a = 0;
                if (this.f1594b.f1599e) {
                    this.f1594b.m1832a(this.f1593a);
                    return;
                } else {
                    this.f1594b.m1844d();
                    return;
                }
            }
            this.f1594b.m1832a(this.f1593a);
        }
    }

    private void m1832a(int i) {
        C0976b c0976b = (C0976b) this.f1595a.get(i);
        this.f1601g.f1593a = i;
        this.f1596b.postDelayed(this.f1601g, c0976b.f1603b);
        if (this.f1597c != null) {
            this.f1597c.mo2471a(i, c0976b);
        }
    }

    public C0975a m1837a() {
        this.f1598d = false;
        this.f1596b.removeCallbacks(this.f1601g);
        this.f1596b.removeCallbacksAndMessages(null);
        return this;
    }

    public C0975a m1838a(C0973a c0973a) {
        this.f1597c = c0973a;
        return this;
    }

    public C0975a m1839a(ArrayList<C0976b> arrayList) {
        this.f1595a = arrayList;
        return this;
    }

    public C0975a m1840a(boolean z) {
        this.f1599e = z;
        return this;
    }

    public int m1841b() {
        return this.f1595a == null ? 0 : this.f1595a.size();
    }

    public C0975a m1842b(boolean z) {
        this.f1600f = z;
        return this;
    }

    public void m1843c() {
        if (this.f1595a != null && this.f1595a.size() != 0) {
            m1837a();
            this.f1598d = true;
            if (this.f1600f) {
                m1832a(this.f1595a.size() - 1);
            } else {
                m1832a(0);
            }
        }
    }

    public void m1844d() {
        m1837a();
        if (this.f1597c != null) {
            this.f1597c.mo2470a();
        }
    }

    public void m1845e() {
        m1837a();
    }

    public boolean m1846f() {
        return this.f1598d;
    }
}
