package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.os.EnvironmentCompat;
import android.util.Log;
import com.google.android.gms.common.internal.C2549s.C2548a;
import com.google.android.gms.common.stats.C2574a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class C2554t extends C2549s implements Callback {
    private final HashMap<C2548a, C2553a> f7483a = new HashMap();
    private final Context f7484b;
    private final Handler f7485c;
    private final C2574a f7486d;
    private final long f7487e;
    private final long f7488f;

    private final class C2553a implements ServiceConnection {
        final /* synthetic */ C2554t f7476a;
        private final Set<ServiceConnection> f7477b = new HashSet();
        private int f7478c = 2;
        private boolean f7479d;
        private IBinder f7480e;
        private final C2548a f7481f;
        private ComponentName f7482g;

        public C2553a(C2554t c2554t, C2548a c2548a) {
            this.f7476a = c2554t;
            this.f7481f = c2548a;
        }

        public void m8155a(ServiceConnection serviceConnection, String str) {
            this.f7476a.f7486d.m8255a(this.f7476a.f7484b, serviceConnection, str, this.f7481f.m8085c());
            this.f7477b.add(serviceConnection);
        }

        public void m8156a(String str) {
            this.f7478c = 3;
            this.f7479d = this.f7476a.f7486d.m8257a(this.f7476a.f7484b, str, this.f7481f.m8085c(), this, 129);
            if (this.f7479d) {
                this.f7476a.f7485c.sendMessageDelayed(this.f7476a.f7485c.obtainMessage(1, this.f7481f), this.f7476a.f7488f);
                return;
            }
            this.f7478c = 2;
            try {
                this.f7476a.f7486d.m8254a(this.f7476a.f7484b, (ServiceConnection) this);
            } catch (IllegalArgumentException e) {
            }
        }

        public boolean m8157a() {
            return this.f7479d;
        }

        public boolean m8158a(ServiceConnection serviceConnection) {
            return this.f7477b.contains(serviceConnection);
        }

        public int m8159b() {
            return this.f7478c;
        }

        public void m8160b(ServiceConnection serviceConnection, String str) {
            this.f7476a.f7486d.m8258b(this.f7476a.f7484b, serviceConnection);
            this.f7477b.remove(serviceConnection);
        }

        public void m8161b(String str) {
            this.f7476a.f7485c.removeMessages(1, this.f7481f);
            this.f7476a.f7486d.m8254a(this.f7476a.f7484b, (ServiceConnection) this);
            this.f7479d = false;
            this.f7478c = 2;
        }

        public boolean m8162c() {
            return this.f7477b.isEmpty();
        }

        public IBinder m8163d() {
            return this.f7480e;
        }

        public ComponentName m8164e() {
            return this.f7482g;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (this.f7476a.f7483a) {
                this.f7476a.f7485c.removeMessages(1, this.f7481f);
                this.f7480e = iBinder;
                this.f7482g = componentName;
                for (ServiceConnection onServiceConnected : this.f7477b) {
                    onServiceConnected.onServiceConnected(componentName, iBinder);
                }
                this.f7478c = 1;
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (this.f7476a.f7483a) {
                this.f7476a.f7485c.removeMessages(1, this.f7481f);
                this.f7480e = null;
                this.f7482g = componentName;
                for (ServiceConnection onServiceDisconnected : this.f7477b) {
                    onServiceDisconnected.onServiceDisconnected(componentName);
                }
                this.f7478c = 2;
            }
        }
    }

    C2554t(Context context) {
        this.f7484b = context.getApplicationContext();
        this.f7485c = new Handler(context.getMainLooper(), this);
        this.f7486d = C2574a.m8252a();
        this.f7487e = 5000;
        this.f7488f = 300000;
    }

    protected boolean mo3349a(C2548a c2548a, ServiceConnection serviceConnection, String str) {
        boolean a;
        C2513c.m7933a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f7483a) {
            C2553a c2553a = (C2553a) this.f7483a.get(c2548a);
            if (c2553a != null) {
                this.f7485c.removeMessages(0, c2548a);
                if (!c2553a.m8158a(serviceConnection)) {
                    c2553a.m8155a(serviceConnection, str);
                    switch (c2553a.m8159b()) {
                        case 1:
                            serviceConnection.onServiceConnected(c2553a.m8164e(), c2553a.m8163d());
                            break;
                        case 2:
                            c2553a.m8156a(str);
                            break;
                        default:
                            break;
                    }
                }
                String valueOf = String.valueOf(c2548a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
            }
            c2553a = new C2553a(this, c2548a);
            c2553a.m8155a(serviceConnection, str);
            c2553a.m8156a(str);
            this.f7483a.put(c2548a, c2553a);
            a = c2553a.m8157a();
        }
        return a;
    }

    protected void mo3350b(C2548a c2548a, ServiceConnection serviceConnection, String str) {
        C2513c.m7933a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f7483a) {
            C2553a c2553a = (C2553a) this.f7483a.get(c2548a);
            String valueOf;
            if (c2553a == null) {
                valueOf = String.valueOf(c2548a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
            } else if (c2553a.m8158a(serviceConnection)) {
                c2553a.m8160b(serviceConnection, str);
                if (c2553a.m8162c()) {
                    this.f7485c.sendMessageDelayed(this.f7485c.obtainMessage(0, c2548a), this.f7487e);
                }
            } else {
                valueOf = String.valueOf(c2548a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf).toString());
            }
        }
    }

    public boolean handleMessage(Message message) {
        C2548a c2548a;
        C2553a c2553a;
        switch (message.what) {
            case 0:
                synchronized (this.f7483a) {
                    c2548a = (C2548a) message.obj;
                    c2553a = (C2553a) this.f7483a.get(c2548a);
                    if (c2553a != null && c2553a.m8162c()) {
                        if (c2553a.m8157a()) {
                            c2553a.m8161b("GmsClientSupervisor");
                        }
                        this.f7483a.remove(c2548a);
                    }
                }
                return true;
            case 1:
                synchronized (this.f7483a) {
                    c2548a = (C2548a) message.obj;
                    c2553a = (C2553a) this.f7483a.get(c2548a);
                    if (c2553a != null && c2553a.m8159b() == 3) {
                        String valueOf = String.valueOf(c2548a);
                        Log.wtf("GmsClientSupervisor", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Timeout waiting for ServiceConnection callback ").append(valueOf).toString(), new Exception());
                        ComponentName e = c2553a.m8164e();
                        if (e == null) {
                            e = c2548a.m8084b();
                        }
                        c2553a.onServiceDisconnected(e == null ? new ComponentName(c2548a.m8083a(), EnvironmentCompat.MEDIA_UNKNOWN) : e);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
