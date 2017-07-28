package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@wh
public class yz {
    private final zb f11554a;
    private final LinkedList<C3458a> f11555b;
    private final Object f11556c;
    private final String f11557d;
    private final String f11558e;
    private long f11559f;
    private long f11560g;
    private boolean f11561h;
    private long f11562i;
    private long f11563j;
    private long f11564k;
    private long f11565l;

    @wh
    private static final class C3458a {
        private long f11552a = -1;
        private long f11553b = -1;

        public long m14964a() {
            return this.f11553b;
        }

        public void m14965b() {
            this.f11553b = SystemClock.elapsedRealtime();
        }

        public void m14966c() {
            this.f11552a = SystemClock.elapsedRealtime();
        }

        public Bundle m14967d() {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", this.f11552a);
            bundle.putLong("tclose", this.f11553b);
            return bundle;
        }
    }

    public yz(zb zbVar, String str, String str2) {
        this.f11556c = new Object();
        this.f11559f = -1;
        this.f11560g = -1;
        this.f11561h = false;
        this.f11562i = -1;
        this.f11563j = 0;
        this.f11564k = -1;
        this.f11565l = -1;
        this.f11554a = zbVar;
        this.f11557d = str;
        this.f11558e = str2;
        this.f11555b = new LinkedList();
    }

    public yz(String str, String str2) {
        this(zzw.zzcQ(), str, str2);
    }

    public void m14968a() {
        synchronized (this.f11556c) {
            if (this.f11565l != -1 && this.f11560g == -1) {
                this.f11560g = SystemClock.elapsedRealtime();
                this.f11554a.m14997a(this);
            }
            this.f11554a.m15015e().m15044c();
        }
    }

    public void m14969a(long j) {
        synchronized (this.f11556c) {
            this.f11565l = j;
            if (this.f11565l != -1) {
                this.f11554a.m14997a(this);
            }
        }
    }

    public void m14970a(zzec com_google_android_gms_internal_zzec) {
        synchronized (this.f11556c) {
            this.f11564k = SystemClock.elapsedRealtime();
            this.f11554a.m15015e().m15042a(com_google_android_gms_internal_zzec, this.f11564k);
        }
    }

    public void m14971a(boolean z) {
        synchronized (this.f11556c) {
            if (this.f11565l != -1) {
                this.f11562i = SystemClock.elapsedRealtime();
                if (!z) {
                    this.f11560g = this.f11562i;
                    this.f11554a.m14997a(this);
                }
            }
        }
    }

    public void m14972b() {
        synchronized (this.f11556c) {
            if (this.f11565l != -1) {
                C3458a c3458a = new C3458a();
                c3458a.m14966c();
                this.f11555b.add(c3458a);
                this.f11563j++;
                this.f11554a.m15015e().m15043b();
                this.f11554a.m14997a(this);
            }
        }
    }

    public void m14973b(long j) {
        synchronized (this.f11556c) {
            if (this.f11565l != -1) {
                this.f11559f = j;
                this.f11554a.m14997a(this);
            }
        }
    }

    public void m14974b(boolean z) {
        synchronized (this.f11556c) {
            if (this.f11565l != -1) {
                this.f11561h = z;
                this.f11554a.m14997a(this);
            }
        }
    }

    public void m14975c() {
        synchronized (this.f11556c) {
            if (!(this.f11565l == -1 || this.f11555b.isEmpty())) {
                C3458a c3458a = (C3458a) this.f11555b.getLast();
                if (c3458a.m14964a() == -1) {
                    c3458a.m14965b();
                    this.f11554a.m14997a(this);
                }
            }
        }
    }

    public Bundle m14976d() {
        Bundle bundle;
        synchronized (this.f11556c) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.f11557d);
            bundle.putString("slotid", this.f11558e);
            bundle.putBoolean("ismediation", this.f11561h);
            bundle.putLong("treq", this.f11564k);
            bundle.putLong("tresponse", this.f11565l);
            bundle.putLong("timp", this.f11560g);
            bundle.putLong("tload", this.f11562i);
            bundle.putLong("pcc", this.f11563j);
            bundle.putLong("tfetch", this.f11559f);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f11555b.iterator();
            while (it.hasNext()) {
                arrayList.add(((C3458a) it.next()).m14967d());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }
}
