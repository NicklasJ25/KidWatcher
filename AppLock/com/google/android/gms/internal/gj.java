package com.google.android.gms.internal;

import com.google.android.gms.internal.gt.C2898a;
import java.util.HashMap;
import java.util.Map;

class gj implements C2898a {
    private static long f9023a = 0;
    private gn f9024b;
    private gt f9025c;
    private C2895a f9026d;
    private C2897c f9027e = C2897c.REALTIME_CONNECTING;
    private final jp f9028f;

    public interface C2895a {
        void mo3670a(long j, String str);

        void mo3671a(C2896b c2896b);

        void mo3672a(String str);

        void mo3679a(Map<String, Object> map);

        void mo3681b(String str);
    }

    public enum C2896b {
        SERVER_RESET,
        OTHER
    }

    private enum C2897c {
        REALTIME_CONNECTING,
        REALTIME_CONNECTED,
        REALTIME_DISCONNECTED
    }

    public gj(gl glVar, gn gnVar, String str, C2895a c2895a, String str2) {
        long j = f9023a;
        f9023a = 1 + j;
        this.f9024b = gnVar;
        this.f9026d = c2895a;
        this.f9028f = new jp(glVar.m11066a(), "Connection", "conn_" + j);
        this.f9025c = new gt(glVar, gnVar, str, this, str2);
    }

    private void m11050a(long j, String str) {
        if (this.f9028f.m11961a()) {
            this.f9028f.m11960a("realtime connection established", new Object[0]);
        }
        this.f9027e = C2897c.REALTIME_CONNECTED;
        this.f9026d.mo3670a(j, str);
    }

    private void m11051a(String str) {
        if (this.f9028f.m11961a()) {
            this.f9028f.m11960a("Connection shutdown command received. Shutting down...", new Object[0]);
        }
        this.f9026d.mo3681b(str);
        m11062b();
    }

    private void m11052b(String str) {
        if (this.f9028f.m11961a()) {
            jp jpVar = this.f9028f;
            String valueOf = String.valueOf(this.f9024b.m11078a());
            jpVar.m11960a(new StringBuilder((String.valueOf(valueOf).length() + 62) + String.valueOf(str).length()).append("Got a reset; killing connection to ").append(valueOf).append("; Updating internalHost to ").append(str).toString(), new Object[0]);
        }
        this.f9026d.mo3672a(str);
        m11058a(C2896b.SERVER_RESET);
    }

    private void m11053b(Map<String, Object> map) {
        if (this.f9028f.m11961a()) {
            jp jpVar = this.f9028f;
            String str = "received data message: ";
            String valueOf = String.valueOf(map.toString());
            jpVar.m11960a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
        }
        this.f9026d.mo3679a((Map) map);
    }

    private void m11054b(Map<String, Object> map, boolean z) {
        if (this.f9027e != C2897c.REALTIME_CONNECTED) {
            this.f9028f.m11960a("Tried to send on an unconnected connection", new Object[0]);
            return;
        }
        if (z) {
            this.f9028f.m11960a("Sending data (contents hidden)", new Object[0]);
        } else {
            this.f9028f.m11960a("Sending data: %s", map);
        }
        this.f9025c.m11251a((Map) map);
    }

    private void m11055c(Map<String, Object> map) {
        if (this.f9028f.m11961a()) {
            jp jpVar = this.f9028f;
            String str = "Got control message: ";
            String valueOf = String.valueOf(map.toString());
            jpVar.m11960a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
        }
        try {
            valueOf = (String) map.get("t");
            if (valueOf == null) {
                if (this.f9028f.m11961a()) {
                    jpVar = this.f9028f;
                    str = "Got invalid control message: ";
                    valueOf = String.valueOf(map.toString());
                    jpVar.m11960a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
                }
                m11062b();
            } else if (valueOf.equals("s")) {
                m11051a((String) map.get("d"));
            } else if (valueOf.equals("r")) {
                m11052b((String) map.get("d"));
            } else if (valueOf.equals("h")) {
                m11056d((Map) map.get("d"));
            } else if (this.f9028f.m11961a()) {
                jpVar = this.f9028f;
                str = "Ignoring unknown control message: ";
                valueOf = String.valueOf(valueOf);
                jpVar.m11960a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
            }
        } catch (ClassCastException e) {
            if (this.f9028f.m11961a()) {
                jpVar = this.f9028f;
                str = "Failed to parse control message: ";
                valueOf = String.valueOf(e.toString());
                jpVar.m11960a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
            }
            m11062b();
        }
    }

    private void m11056d(Map<String, Object> map) {
        long longValue = ((Long) map.get("ts")).longValue();
        this.f9026d.mo3672a((String) map.get("h"));
        String str = (String) map.get("s");
        if (this.f9027e == C2897c.REALTIME_CONNECTING) {
            m11050a(longValue, str);
        }
    }

    public void m11057a() {
        if (this.f9028f.m11961a()) {
            this.f9028f.m11960a("Opening a connection", new Object[0]);
        }
        this.f9025c.m11250a();
    }

    public void m11058a(C2896b c2896b) {
        if (this.f9027e != C2897c.REALTIME_DISCONNECTED) {
            if (this.f9028f.m11961a()) {
                this.f9028f.m11960a("closing realtime connection", new Object[0]);
            }
            this.f9027e = C2897c.REALTIME_DISCONNECTED;
            if (this.f9025c != null) {
                this.f9025c.m11252b();
                this.f9025c = null;
            }
            this.f9026d.mo3671a(c2896b);
        }
    }

    public void mo3664a(Map<String, Object> map) {
        String str;
        jp jpVar;
        String str2;
        try {
            str = (String) map.get("t");
            if (str == null) {
                if (this.f9028f.m11961a()) {
                    jpVar = this.f9028f;
                    str2 = "Failed to parse server message: missing message type:";
                    str = String.valueOf(map.toString());
                    jpVar.m11960a(str.length() != 0 ? str2.concat(str) : new String(str2), new Object[0]);
                }
                m11062b();
            } else if (str.equals("d")) {
                m11053b((Map) map.get("d"));
            } else if (str.equals("c")) {
                m11055c((Map) map.get("d"));
            } else if (this.f9028f.m11961a()) {
                jpVar = this.f9028f;
                str2 = "Ignoring unknown server message type: ";
                str = String.valueOf(str);
                jpVar.m11960a(str.length() != 0 ? str2.concat(str) : new String(str2), new Object[0]);
            }
        } catch (ClassCastException e) {
            if (this.f9028f.m11961a()) {
                jpVar = this.f9028f;
                str2 = "Failed to parse server message: ";
                str = String.valueOf(e.toString());
                jpVar.m11960a(str.length() != 0 ? str2.concat(str) : new String(str2), new Object[0]);
            }
            m11062b();
        }
    }

    public void m11060a(Map<String, Object> map, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("t", "d");
        hashMap.put("d", map);
        m11054b(hashMap, z);
    }

    public void mo3665a(boolean z) {
        this.f9025c = null;
        if (z || this.f9027e != C2897c.REALTIME_CONNECTING) {
            if (this.f9028f.m11961a()) {
                this.f9028f.m11960a("Realtime connection lost", new Object[0]);
            }
        } else if (this.f9028f.m11961a()) {
            this.f9028f.m11960a("Realtime connection failed", new Object[0]);
        }
        m11062b();
    }

    public void m11062b() {
        m11058a(C2896b.OTHER);
    }
}
