package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class C3459z extends BroadcastReceiver {
    protected Context f11566a;
    private final C2884a f11567b;

    public static abstract class C2884a {
        public abstract void mo3648a();
    }

    public C3459z(C2884a c2884a) {
        this.f11567b = c2884a;
    }

    public synchronized void m14977a() {
        if (this.f11566a != null) {
            this.f11566a.unregisterReceiver(this);
        }
        this.f11566a = null;
    }

    public void m14978a(Context context) {
        this.f11566a = context;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        Object obj = null;
        if (data != null) {
            obj = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(obj)) {
            this.f11567b.mo3648a();
            m14977a();
        }
    }
}
