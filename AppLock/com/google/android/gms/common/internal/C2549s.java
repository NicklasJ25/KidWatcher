package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

public abstract class C2549s {
    private static final Object f7474a = new Object();
    private static C2549s f7475b;

    protected static final class C2548a {
        private final String f7471a;
        private final String f7472b;
        private final ComponentName f7473c = null;

        public C2548a(String str, String str2) {
            this.f7471a = C2513c.m7934a(str);
            this.f7472b = C2513c.m7934a(str2);
        }

        public String m8083a() {
            return this.f7472b;
        }

        public ComponentName m8084b() {
            return this.f7473c;
        }

        public Intent m8085c() {
            return this.f7471a != null ? new Intent(this.f7471a).setPackage(this.f7472b) : new Intent().setComponent(this.f7473c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C2548a)) {
                return false;
            }
            C2548a c2548a = (C2548a) obj;
            return C2512b.m7931a(this.f7471a, c2548a.f7471a) && C2512b.m7931a(this.f7473c, c2548a.f7473c);
        }

        public int hashCode() {
            return C2512b.m7929a(this.f7471a, this.f7473c);
        }

        public String toString() {
            return this.f7471a == null ? this.f7473c.flattenToString() : this.f7471a;
        }
    }

    public static C2549s m8086a(Context context) {
        synchronized (f7474a) {
            if (f7475b == null) {
                f7475b = new C2554t(context.getApplicationContext());
            }
        }
        return f7475b;
    }

    protected abstract boolean mo3349a(C2548a c2548a, ServiceConnection serviceConnection, String str);

    public boolean m8088a(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return mo3349a(new C2548a(str, str2), serviceConnection, str3);
    }

    protected abstract void mo3350b(C2548a c2548a, ServiceConnection serviceConnection, String str);

    public void m8090b(String str, String str2, ServiceConnection serviceConnection, String str3) {
        mo3350b(new C2548a(str, str2), serviceConnection, str3);
    }
}
