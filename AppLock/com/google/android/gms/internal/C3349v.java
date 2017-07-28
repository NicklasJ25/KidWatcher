package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.C2480k;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C2445g;
import com.google.android.gms.common.api.C2456a;
import com.google.android.gms.common.api.C2456a.C2448b;
import com.google.android.gms.common.api.C2456a.C2449c;
import com.google.android.gms.common.api.C2456a.C2450d;
import com.google.android.gms.common.api.C2456a.C2451f;
import com.google.android.gms.common.internal.C2539m;
import com.google.android.gms.internal.C2859f.C2676a;
import com.google.android.gms.internal.ac.C2683a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class C3349v implements ac, C2996j {
    final Map<C2450d<?>, C2451f> f10983a;
    final Map<C2450d<?>, ConnectionResult> f10984b = new HashMap();
    final C2539m f10985c;
    final Map<C2456a<?>, Boolean> f10986d;
    final C2448b<? extends em, en> f10987e;
    int f10988f;
    final C3276t f10989g;
    final C2683a f10990h;
    private final Lock f10991i;
    private final Condition f10992j;
    private final Context f10993k;
    private final C2480k f10994l;
    private final C3348b f10995m;
    private volatile C3165u f10996n;
    private ConnectionResult f10997o = null;

    static abstract class C3162a {
        private final C3165u f10249a;

        protected C3162a(C3165u c3165u) {
            this.f10249a = c3165u;
        }

        protected abstract void mo3899a();

        public final void m13243a(C3349v c3349v) {
            c3349v.f10991i.lock();
            try {
                if (c3349v.f10996n == this.f10249a) {
                    mo3899a();
                    c3349v.f10991i.unlock();
                }
            } finally {
                c3349v.f10991i.unlock();
            }
        }
    }

    final class C3348b extends Handler {
        final /* synthetic */ C3349v f10982a;

        C3348b(C3349v c3349v, Looper looper) {
            this.f10982a = c3349v;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    ((C3162a) message.obj).m13243a(this.f10982a);
                    return;
                case 2:
                    throw ((RuntimeException) message.obj);
                default:
                    Log.w("GACStateManager", "Unknown message id: " + message.what);
                    return;
            }
        }
    }

    public C3349v(Context context, C3276t c3276t, Lock lock, Looper looper, C2480k c2480k, Map<C2450d<?>, C2451f> map, C2539m c2539m, Map<C2456a<?>, Boolean> map2, C2448b<? extends em, en> c2448b, ArrayList<C2977i> arrayList, C2683a c2683a) {
        this.f10993k = context;
        this.f10991i = lock;
        this.f10994l = c2480k;
        this.f10983a = map;
        this.f10985c = c2539m;
        this.f10986d = map2;
        this.f10987e = c2448b;
        this.f10989g = c3276t;
        this.f10990h = c2683a;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((C2977i) it.next()).m11640a((C2996j) this);
        }
        this.f10995m = new C3348b(this, looper);
        this.f10992j = lock.newCondition();
        this.f10996n = new C3223s(this);
    }

    public <A extends C2449c, T extends C2676a<? extends C2445g, A>> T mo3803a(@NonNull T t) {
        t.m8869i();
        return this.f10996n.mo3900a((C2676a) t);
    }

    public void mo3804a() {
        this.f10996n.mo3906c();
    }

    public void mo3496a(int i) {
        this.f10991i.lock();
        try {
            this.f10996n.mo3902a(i);
        } finally {
            this.f10991i.unlock();
        }
    }

    public void mo3497a(@Nullable Bundle bundle) {
        this.f10991i.lock();
        try {
            this.f10996n.mo3903a(bundle);
        } finally {
            this.f10991i.unlock();
        }
    }

    void m14332a(ConnectionResult connectionResult) {
        this.f10991i.lock();
        try {
            this.f10997o = connectionResult;
            this.f10996n = new C3223s(this);
            this.f10996n.mo3901a();
            this.f10992j.signalAll();
        } finally {
            this.f10991i.unlock();
        }
    }

    public void mo4157a(@NonNull ConnectionResult connectionResult, @NonNull C2456a<?> c2456a, boolean z) {
        this.f10991i.lock();
        try {
            this.f10996n.mo3904a(connectionResult, c2456a, z);
        } finally {
            this.f10991i.unlock();
        }
    }

    void m14334a(C3162a c3162a) {
        this.f10995m.sendMessage(this.f10995m.obtainMessage(1, c3162a));
    }

    void m14335a(RuntimeException runtimeException) {
        this.f10995m.sendMessage(this.f10995m.obtainMessage(2, runtimeException));
    }

    public void mo3805a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.f10996n);
        for (C2456a c2456a : this.f10986d.keySet()) {
            printWriter.append(str).append(c2456a.m7752d()).println(":");
            ((C2451f) this.f10983a.get(c2456a.m7751c())).m7738a(concat, fileDescriptor, printWriter, strArr);
        }
    }

    public void mo3806b() {
        if (this.f10996n.mo3905b()) {
            this.f10984b.clear();
        }
    }

    public boolean mo3807c() {
        return this.f10996n instanceof C3166q;
    }

    public void mo3808d() {
        if (mo3807c()) {
            ((C3166q) this.f10996n).m13262d();
        }
    }

    void m14340e() {
        this.f10991i.lock();
        try {
            this.f10996n = new C3195r(this, this.f10985c, this.f10986d, this.f10994l, this.f10987e, this.f10991i, this.f10993k);
            this.f10996n.mo3901a();
            this.f10992j.signalAll();
        } finally {
            this.f10991i.unlock();
        }
    }

    void m14341f() {
        this.f10991i.lock();
        try {
            this.f10989g.m13867h();
            this.f10996n = new C3166q(this);
            this.f10996n.mo3901a();
            this.f10992j.signalAll();
        } finally {
            this.f10991i.unlock();
        }
    }

    void m14342g() {
        for (C2451f a : this.f10983a.values()) {
            a.m7735a();
        }
    }
}
