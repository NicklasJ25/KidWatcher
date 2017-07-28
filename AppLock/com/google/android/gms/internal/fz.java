package com.google.android.gms.internal;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.internal.bp.C2711a;
import java.io.IOException;

public class fz extends ml {
    public fz(ez ezVar, String str, String str2, C2711a c2711a, int i, int i2) {
        super(ezVar, str, str2, c2711a, i, i2);
    }

    private void m10948c() {
        synchronized (this.e) {
            this.e.aa = (String) this.f.invoke(null, new Object[]{this.b.m10721b()});
        }
    }

    private void m10949d() {
        AdvertisingIdClient o = this.b.m10734o();
        if (o != null) {
            try {
                Info info = o.getInfo();
                String a = fb.m10741a(info.getId());
                if (a != null) {
                    synchronized (this.e) {
                        this.e.aa = a;
                        this.e.ac = Boolean.valueOf(info.isLimitAdTrackingEnabled());
                        this.e.ab = Integer.valueOf(5);
                    }
                }
            } catch (IOException e) {
            }
        }
    }

    protected void mo3587a() {
        if (this.b.m10727h()) {
            m10949d();
        } else {
            m10948c();
        }
    }
}
