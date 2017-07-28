package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.C2513c;

class de extends BroadcastReceiver {
    static final String f8385a = de.class.getName();
    private final dk f8386b;
    private boolean f8387c;
    private boolean f8388d;

    de(dk dkVar) {
        C2513c.m7932a((Object) dkVar);
        this.f8386b = dkVar;
    }

    private Context m9849d() {
        return this.f8386b.m10047s();
    }

    private dc m9850e() {
        return this.f8386b.m10034f();
    }

    @WorkerThread
    public void m9851a() {
        this.f8386b.m10001a();
        this.f8386b.m9985C();
        if (!this.f8387c) {
            m9849d().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f8388d = this.f8386b.m10046r().m9847x();
            m9850e().m9786D().m9775a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f8388d));
            this.f8387c = true;
        }
    }

    @WorkerThread
    public void m9852b() {
        this.f8386b.m10001a();
        this.f8386b.m9985C();
        if (m9853c()) {
            m9850e().m9786D().m9774a("Unregistering connectivity change receiver");
            this.f8387c = false;
            this.f8388d = false;
            try {
                m9849d().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                m9850e().m9815x().m9775a("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    @WorkerThread
    public boolean m9853c() {
        this.f8386b.m9985C();
        return this.f8387c;
    }

    @MainThread
    public void onReceive(Context context, Intent intent) {
        this.f8386b.m10001a();
        String action = intent.getAction();
        m9850e().m9786D().m9775a("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            final boolean x = this.f8386b.m10046r().m9847x();
            if (this.f8388d != x) {
                this.f8388d = x;
                this.f8386b.m10036h().m9938a(new Runnable(this) {
                    final /* synthetic */ de f8384b;

                    public void run() {
                        this.f8384b.f8386b.m10015a(x);
                    }
                });
                return;
            }
            return;
        }
        m9850e().m9817z().m9775a("NetworkBroadcastReceiver received unknown action", action);
    }
}
