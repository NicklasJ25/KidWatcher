package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.internal.abj.C2661a;
import com.google.android.gms.internal.ej.C2847a;
import com.google.android.gms.internal.wx.C3415a;
import java.util.Collections;
import java.util.Map;

public abstract class vb<T> implements Comparable<vb<T>> {
    private final C2661a f7947a;
    private final int f7948b;
    private final String f7949c;
    private final int f7950d;
    private final C3415a f7951e;
    private Integer f7952f;
    private wc f7953g;
    private boolean f7954h;
    private boolean f7955i;
    private boolean f7956j;
    private boolean f7957k;
    private yw f7958l;
    private C2847a f7959m;

    public enum C3352a {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public vb(int i, String str, C3415a c3415a) {
        this.f7947a = C2661a.f7792a ? new C2661a() : null;
        this.f7954h = true;
        this.f7955i = false;
        this.f7956j = false;
        this.f7957k = false;
        this.f7959m = null;
        this.f7948b = i;
        this.f7949c = str;
        this.f7951e = c3415a;
        m9048a(new ob());
        this.f7950d = mo3504a(str);
    }

    private static int mo3504a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    return host.hashCode();
                }
            }
        }
        return 0;
    }

    public int m9042a() {
        return this.f7948b;
    }

    public int m9043a(vb<T> vbVar) {
        C3352a m = m9065m();
        C3352a m2 = vbVar.m9065m();
        return m == m2 ? this.f7952f.intValue() - vbVar.f7952f.intValue() : m2.ordinal() - m.ordinal();
    }

    protected abi m9044a(abi com_google_android_gms_internal_abi) {
        return com_google_android_gms_internal_abi;
    }

    public final vb<?> m9045a(int i) {
        this.f7952f = Integer.valueOf(i);
        return this;
    }

    public vb<?> m9046a(C2847a c2847a) {
        this.f7959m = c2847a;
        return this;
    }

    public vb<?> m9047a(wc wcVar) {
        this.f7953g = wcVar;
        return this;
    }

    public vb<?> m9048a(yw ywVar) {
        this.f7958l = ywVar;
        return this;
    }

    protected abstract wx<T> mo3502a(sz szVar);

    protected abstract void mo3503a(T t);

    public int m9051b() {
        return this.f7950d;
    }

    public void m9052b(abi com_google_android_gms_internal_abi) {
        if (this.f7951e != null) {
            this.f7951e.mo4268a(com_google_android_gms_internal_abi);
        }
    }

    public void m9053b(String str) {
        if (C2661a.f7792a) {
            this.f7947a.m8754a(str, Thread.currentThread().getId());
        }
    }

    public String m9054c() {
        return this.f7949c;
    }

    void m9055c(final String str) {
        if (this.f7953g != null) {
            this.f7953g.m14471b(this);
        }
        if (C2661a.f7792a) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ vb f11001c;

                    public void run() {
                        this.f11001c.f7947a.m8754a(str, id);
                        this.f11001c.f7947a.m8753a(toString());
                    }
                });
                return;
            }
            this.f7947a.m8754a(str, id);
            this.f7947a.m8753a(toString());
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m9043a((vb) obj);
    }

    public String m9056d() {
        return m9054c();
    }

    public C2847a m9057e() {
        return this.f7959m;
    }

    public Map<String, String> mo4269f() {
        return Collections.emptyMap();
    }

    @Deprecated
    public String m9059g() {
        return m9062j();
    }

    @Deprecated
    public byte[] m9060h() {
        return null;
    }

    protected String m9061i() {
        return "UTF-8";
    }

    public String m9062j() {
        return "application/x-www-form-urlencoded; charset=" + m9061i();
    }

    public byte[] mo4270k() {
        return null;
    }

    public final boolean m9064l() {
        return this.f7954h;
    }

    public C3352a m9065m() {
        return C3352a.NORMAL;
    }

    public final int m9066n() {
        return this.f7958l.mo3858a();
    }

    public yw m9067o() {
        return this.f7958l;
    }

    public void m9068p() {
        this.f7956j = true;
    }

    public boolean m9069q() {
        return this.f7956j;
    }

    public String toString() {
        return "[ ] " + m9054c() + " " + ("0x" + Integer.toHexString(m9051b())) + " " + m9065m() + " " + this.f7952f;
    }
}
