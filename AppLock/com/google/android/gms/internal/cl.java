package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C2513c;

class cl {
    private final dk f8231a;
    private final String f8232b;
    private String f8233c;
    private String f8234d;
    private String f8235e;
    private String f8236f;
    private long f8237g;
    private long f8238h;
    private long f8239i;
    private String f8240j;
    private long f8241k;
    private String f8242l;
    private long f8243m;
    private long f8244n;
    private boolean f8245o;
    private long f8246p;
    private long f8247q;
    private long f8248r;
    private long f8249s;
    private long f8250t;
    private long f8251u;
    private long f8252v;
    private String f8253w;
    private boolean f8254x;
    private long f8255y;
    private long f8256z;

    @WorkerThread
    cl(dk dkVar, String str) {
        C2513c.m7932a((Object) dkVar);
        C2513c.m7934a(str);
        this.f8231a = dkVar;
        this.f8232b = str;
        this.f8231a.m9985C();
    }

    @WorkerThread
    public long m9394A() {
        this.f8231a.m9985C();
        return this.f8246p;
    }

    @WorkerThread
    public void m9395a() {
        this.f8231a.m9985C();
        this.f8254x = false;
    }

    @WorkerThread
    public void m9396a(long j) {
        this.f8231a.m9985C();
        this.f8254x = (this.f8238h != j ? 1 : 0) | this.f8254x;
        this.f8238h = j;
    }

    @WorkerThread
    public void m9397a(String str) {
        this.f8231a.m9985C();
        this.f8254x = (!dy.m10380c(this.f8233c, str) ? 1 : 0) | this.f8254x;
        this.f8233c = str;
    }

    @WorkerThread
    public void m9398a(boolean z) {
        this.f8231a.m9985C();
        this.f8254x = (this.f8245o != z ? 1 : 0) | this.f8254x;
        this.f8245o = z;
    }

    @WorkerThread
    public String m9399b() {
        this.f8231a.m9985C();
        return this.f8232b;
    }

    @WorkerThread
    public void m9400b(long j) {
        this.f8231a.m9985C();
        this.f8254x = (this.f8239i != j ? 1 : 0) | this.f8254x;
        this.f8239i = j;
    }

    @WorkerThread
    public void m9401b(String str) {
        this.f8231a.m9985C();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f8254x = (!dy.m10380c(this.f8234d, str) ? 1 : 0) | this.f8254x;
        this.f8234d = str;
    }

    @WorkerThread
    public String m9402c() {
        this.f8231a.m9985C();
        return this.f8233c;
    }

    @WorkerThread
    public void m9403c(long j) {
        this.f8231a.m9985C();
        this.f8254x = (this.f8241k != j ? 1 : 0) | this.f8254x;
        this.f8241k = j;
    }

    @WorkerThread
    public void m9404c(String str) {
        this.f8231a.m9985C();
        this.f8254x = (!dy.m10380c(this.f8235e, str) ? 1 : 0) | this.f8254x;
        this.f8235e = str;
    }

    @WorkerThread
    public String m9405d() {
        this.f8231a.m9985C();
        return this.f8234d;
    }

    @WorkerThread
    public void m9406d(long j) {
        this.f8231a.m9985C();
        this.f8254x = (this.f8243m != j ? 1 : 0) | this.f8254x;
        this.f8243m = j;
    }

    @WorkerThread
    public void m9407d(String str) {
        this.f8231a.m9985C();
        this.f8254x = (!dy.m10380c(this.f8236f, str) ? 1 : 0) | this.f8254x;
        this.f8236f = str;
    }

    @WorkerThread
    public String m9408e() {
        this.f8231a.m9985C();
        return this.f8235e;
    }

    @WorkerThread
    public void m9409e(long j) {
        this.f8231a.m9985C();
        this.f8254x = (this.f8244n != j ? 1 : 0) | this.f8254x;
        this.f8244n = j;
    }

    @WorkerThread
    public void m9410e(String str) {
        this.f8231a.m9985C();
        this.f8254x = (!dy.m10380c(this.f8240j, str) ? 1 : 0) | this.f8254x;
        this.f8240j = str;
    }

    @WorkerThread
    public String m9411f() {
        this.f8231a.m9985C();
        return this.f8236f;
    }

    @WorkerThread
    public void m9412f(long j) {
        int i = 1;
        C2513c.m7941b(j >= 0);
        this.f8231a.m9985C();
        boolean z = this.f8254x;
        if (this.f8237g == j) {
            i = 0;
        }
        this.f8254x = z | i;
        this.f8237g = j;
    }

    @WorkerThread
    public void m9413f(String str) {
        this.f8231a.m9985C();
        this.f8254x = (!dy.m10380c(this.f8242l, str) ? 1 : 0) | this.f8254x;
        this.f8242l = str;
    }

    @WorkerThread
    public long m9414g() {
        this.f8231a.m9985C();
        return this.f8238h;
    }

    @WorkerThread
    public void m9415g(long j) {
        this.f8231a.m9985C();
        this.f8254x = (this.f8255y != j ? 1 : 0) | this.f8254x;
        this.f8255y = j;
    }

    @WorkerThread
    public void m9416g(String str) {
        this.f8231a.m9985C();
        this.f8254x = (!dy.m10380c(this.f8253w, str) ? 1 : 0) | this.f8254x;
        this.f8253w = str;
    }

    @WorkerThread
    public long m9417h() {
        this.f8231a.m9985C();
        return this.f8239i;
    }

    @WorkerThread
    public void m9418h(long j) {
        this.f8231a.m9985C();
        this.f8254x = (this.f8256z != j ? 1 : 0) | this.f8254x;
        this.f8256z = j;
    }

    @WorkerThread
    public String m9419i() {
        this.f8231a.m9985C();
        return this.f8240j;
    }

    @WorkerThread
    public void m9420i(long j) {
        this.f8231a.m9985C();
        this.f8254x = (this.f8247q != j ? 1 : 0) | this.f8254x;
        this.f8247q = j;
    }

    @WorkerThread
    public long m9421j() {
        this.f8231a.m9985C();
        return this.f8241k;
    }

    @WorkerThread
    public void m9422j(long j) {
        this.f8231a.m9985C();
        this.f8254x = (this.f8248r != j ? 1 : 0) | this.f8254x;
        this.f8248r = j;
    }

    @WorkerThread
    public String m9423k() {
        this.f8231a.m9985C();
        return this.f8242l;
    }

    @WorkerThread
    public void m9424k(long j) {
        this.f8231a.m9985C();
        this.f8254x = (this.f8249s != j ? 1 : 0) | this.f8254x;
        this.f8249s = j;
    }

    @WorkerThread
    public long m9425l() {
        this.f8231a.m9985C();
        return this.f8243m;
    }

    @WorkerThread
    public void m9426l(long j) {
        this.f8231a.m9985C();
        this.f8254x = (this.f8250t != j ? 1 : 0) | this.f8254x;
        this.f8250t = j;
    }

    @WorkerThread
    public long m9427m() {
        this.f8231a.m9985C();
        return this.f8244n;
    }

    @WorkerThread
    public void m9428m(long j) {
        this.f8231a.m9985C();
        this.f8254x = (this.f8252v != j ? 1 : 0) | this.f8254x;
        this.f8252v = j;
    }

    @WorkerThread
    public void m9429n(long j) {
        this.f8231a.m9985C();
        this.f8254x = (this.f8251u != j ? 1 : 0) | this.f8254x;
        this.f8251u = j;
    }

    @WorkerThread
    public boolean m9430n() {
        this.f8231a.m9985C();
        return this.f8245o;
    }

    @WorkerThread
    public long m9431o() {
        this.f8231a.m9985C();
        return this.f8237g;
    }

    @WorkerThread
    public void m9432o(long j) {
        this.f8231a.m9985C();
        this.f8254x = (this.f8246p != j ? 1 : 0) | this.f8254x;
        this.f8246p = j;
    }

    @WorkerThread
    public long m9433p() {
        this.f8231a.m9985C();
        return this.f8255y;
    }

    @WorkerThread
    public long m9434q() {
        this.f8231a.m9985C();
        return this.f8256z;
    }

    @WorkerThread
    public void m9435r() {
        this.f8231a.m9985C();
        long j = this.f8237g + 1;
        if (j > 2147483647L) {
            this.f8231a.m10034f().m9817z().m9775a("Bundle index overflow. appId", dc.m9779a(this.f8232b));
            j = 0;
        }
        this.f8254x = true;
        this.f8237g = j;
    }

    @WorkerThread
    public long m9436s() {
        this.f8231a.m9985C();
        return this.f8247q;
    }

    @WorkerThread
    public long m9437t() {
        this.f8231a.m9985C();
        return this.f8248r;
    }

    @WorkerThread
    public long m9438u() {
        this.f8231a.m9985C();
        return this.f8249s;
    }

    @WorkerThread
    public long m9439v() {
        this.f8231a.m9985C();
        return this.f8250t;
    }

    @WorkerThread
    public long m9440w() {
        this.f8231a.m9985C();
        return this.f8252v;
    }

    @WorkerThread
    public long m9441x() {
        this.f8231a.m9985C();
        return this.f8251u;
    }

    @WorkerThread
    public String m9442y() {
        this.f8231a.m9985C();
        return this.f8253w;
    }

    @WorkerThread
    public String m9443z() {
        this.f8231a.m9985C();
        String str = this.f8253w;
        m9416g(null);
        return str;
    }
}
