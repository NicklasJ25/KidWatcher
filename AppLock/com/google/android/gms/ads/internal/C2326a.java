package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.ch;
import com.google.android.gms.internal.ec;
import com.google.android.gms.internal.ol;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.zk;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@wh
class C2326a implements ch, Runnable {
    CountDownLatch f6718a = new CountDownLatch(1);
    private final List<Object[]> f6719b = new Vector();
    private final AtomicReference<ch> f6720c = new AtomicReference();
    private zzx f6721d;

    public C2326a(zzx com_google_android_gms_ads_internal_zzx) {
        this.f6721d = com_google_android_gms_ads_internal_zzx;
        if (ol.m12979a().m8413b()) {
            zk.m15079a((Runnable) this);
        } else {
            run();
        }
    }

    private Context m7361b(Context context) {
        if (!((Boolean) qb.f10300m.m13225c()).booleanValue()) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    private void m7362b() {
        if (!this.f6719b.isEmpty()) {
            for (Object[] objArr : this.f6719b) {
                if (objArr.length == 1) {
                    ((ch) this.f6720c.get()).mo3154a((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    ((ch) this.f6720c.get()).mo3153a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.f6719b.clear();
        }
    }

    protected ch m7363a(String str, Context context, boolean z) {
        return ec.m10554a(str, context, z);
    }

    public String mo3151a(Context context) {
        return m7366a(context, null);
    }

    public String mo3152a(Context context, String str, View view) {
        if (m7370a()) {
            ch chVar = (ch) this.f6720c.get();
            if (chVar != null) {
                m7362b();
                return chVar.mo3152a(m7361b(context), str, view);
            }
        }
        return "";
    }

    public String m7366a(Context context, byte[] bArr) {
        if (m7370a()) {
            ch chVar = (ch) this.f6720c.get();
            if (chVar != null) {
                m7362b();
                return chVar.mo3151a(m7361b(context));
            }
        }
        return "";
    }

    public void mo3153a(int i, int i2, int i3) {
        ch chVar = (ch) this.f6720c.get();
        if (chVar != null) {
            m7362b();
            chVar.mo3153a(i, i2, i3);
            return;
        }
        this.f6719b.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public void mo3154a(MotionEvent motionEvent) {
        ch chVar = (ch) this.f6720c.get();
        if (chVar != null) {
            m7362b();
            chVar.mo3154a(motionEvent);
            return;
        }
        this.f6719b.add(new Object[]{motionEvent});
    }

    protected void m7369a(ch chVar) {
        this.f6720c.set(chVar);
    }

    protected boolean m7370a() {
        try {
            this.f6718a.await();
            return true;
        } catch (Throwable e) {
            aad.m8424c("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    public void run() {
        try {
            Object obj = (this.f6721d.zzvn.f12084d || !((Boolean) qb.f10269I.m13225c()).booleanValue()) ? 1 : null;
            boolean z = (((Boolean) qb.aO.m13225c()).booleanValue() || obj == null) ? false : true;
            m7369a(m7363a(this.f6721d.zzvn.f12081a, m7361b(this.f6721d.zzqn), z));
        } finally {
            this.f6718a.countDown();
            this.f6721d = null;
        }
    }
}
