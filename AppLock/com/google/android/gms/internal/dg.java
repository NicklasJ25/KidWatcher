package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.internal.C2513c;
import com.google.firebase.iid.C3598c;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Locale;

class dg extends dn {
    static final Pair<String, Long> f8404a = new Pair("", Long.valueOf(0));
    public final C2769c f8405b = new C2769c("health_monitor", mo3550w().af());
    public final C2768b f8406c = new C2768b(this, "last_upload", 0);
    public final C2768b f8407d = new C2768b(this, "last_upload_attempt", 0);
    public final C2768b f8408e = new C2768b(this, "backoff", 0);
    public final C2768b f8409f = new C2768b(this, "last_delete_stale", 0);
    public final C2768b f8410g = new C2768b(this, "midnight_offset", 0);
    public final C2768b f8411h = new C2768b(this, "time_before_start", 10000);
    public final C2768b f8412i = new C2768b(this, "session_timeout", 1800000);
    public final C2767a f8413j = new C2767a(this, "start_new_session", true);
    public final C2768b f8414k = new C2768b(this, "last_pause_time", 0);
    public final C2768b f8415l = new C2768b(this, "time_active", 0);
    public boolean f8416m;
    private SharedPreferences f8417o;
    private String f8418p;
    private boolean f8419q;
    private long f8420r;
    private String f8421s;
    private long f8422t;
    private final Object f8423u = new Object();
    private SecureRandom f8424v;

    public final class C2767a {
        final /* synthetic */ dg f8389a;
        private final String f8390b;
        private final boolean f8391c;
        private boolean f8392d;
        private boolean f8393e;

        public C2767a(dg dgVar, String str, boolean z) {
            this.f8389a = dgVar;
            C2513c.m7934a(str);
            this.f8390b = str;
            this.f8391c = z;
        }

        @WorkerThread
        private void m9854b() {
            if (!this.f8392d) {
                this.f8392d = true;
                this.f8393e = this.f8389a.f8417o.getBoolean(this.f8390b, this.f8391c);
            }
        }

        @WorkerThread
        public void m9855a(boolean z) {
            Editor edit = this.f8389a.f8417o.edit();
            edit.putBoolean(this.f8390b, z);
            edit.apply();
            this.f8393e = z;
        }

        @WorkerThread
        public boolean m9856a() {
            m9854b();
            return this.f8393e;
        }
    }

    public final class C2768b {
        final /* synthetic */ dg f8394a;
        private final String f8395b;
        private final long f8396c;
        private boolean f8397d;
        private long f8398e;

        public C2768b(dg dgVar, String str, long j) {
            this.f8394a = dgVar;
            C2513c.m7934a(str);
            this.f8395b = str;
            this.f8396c = j;
        }

        @WorkerThread
        private void m9857b() {
            if (!this.f8397d) {
                this.f8397d = true;
                this.f8398e = this.f8394a.f8417o.getLong(this.f8395b, this.f8396c);
            }
        }

        @WorkerThread
        public long m9858a() {
            m9857b();
            return this.f8398e;
        }

        @WorkerThread
        public void m9859a(long j) {
            Editor edit = this.f8394a.f8417o.edit();
            edit.putLong(this.f8395b, j);
            edit.apply();
            this.f8398e = j;
        }
    }

    public final class C2769c {
        final String f8399a;
        final /* synthetic */ dg f8400b;
        private final String f8401c;
        private final String f8402d;
        private final long f8403e;

        private C2769c(dg dgVar, String str, long j) {
            this.f8400b = dgVar;
            C2513c.m7934a(str);
            C2513c.m7941b(j > 0);
            this.f8399a = String.valueOf(str).concat(":start");
            this.f8401c = String.valueOf(str).concat(":count");
            this.f8402d = String.valueOf(str).concat(":value");
            this.f8403e = j;
        }

        @WorkerThread
        private void m9860b() {
            this.f8400b.mo3532e();
            long a = this.f8400b.mo3540m().mo3360a();
            Editor edit = this.f8400b.f8417o.edit();
            edit.remove(this.f8401c);
            edit.remove(this.f8402d);
            edit.putLong(this.f8399a, a);
            edit.apply();
        }

        @WorkerThread
        private long m9861c() {
            this.f8400b.mo3532e();
            long d = m9862d();
            if (d != 0) {
                return Math.abs(d - this.f8400b.mo3540m().mo3360a());
            }
            m9860b();
            return 0;
        }

        @WorkerThread
        private long m9862d() {
            return this.f8400b.m9866G().getLong(this.f8399a, 0);
        }

        @WorkerThread
        public Pair<String, Long> m9863a() {
            this.f8400b.mo3532e();
            long c = m9861c();
            if (c < this.f8403e) {
                return null;
            }
            if (c > this.f8403e * 2) {
                m9860b();
                return null;
            }
            String string = this.f8400b.m9866G().getString(this.f8402d, null);
            c = this.f8400b.m9866G().getLong(this.f8401c, 0);
            m9860b();
            return (string == null || c <= 0) ? dg.f8404a : new Pair(string, Long.valueOf(c));
        }

        @WorkerThread
        public void m9864a(String str) {
            m9865a(str, 1);
        }

        @WorkerThread
        public void m9865a(String str, long j) {
            this.f8400b.mo3532e();
            if (m9862d() == 0) {
                m9860b();
            }
            if (str == null) {
                str = "";
            }
            long j2 = this.f8400b.f8417o.getLong(this.f8401c, 0);
            if (j2 <= 0) {
                Editor edit = this.f8400b.f8417o.edit();
                edit.putString(this.f8402d, str);
                edit.putLong(this.f8401c, j);
                edit.apply();
                return;
            }
            Object obj = (this.f8400b.m9883x().nextLong() & Format.OFFSET_SAMPLE_RELATIVE) < (Format.OFFSET_SAMPLE_RELATIVE / (j2 + j)) * j ? 1 : null;
            Editor edit2 = this.f8400b.f8417o.edit();
            if (obj != null) {
                edit2.putString(this.f8402d, str);
            }
            edit2.putLong(this.f8401c, j2 + j);
            edit2.apply();
        }
    }

    dg(dk dkVar) {
        super(dkVar);
    }

    @WorkerThread
    private SharedPreferences m9866G() {
        mo3532e();
        m9448R();
        return this.f8417o;
    }

    @WorkerThread
    long m9869A() {
        m9448R();
        mo3532e();
        long a = this.f8410g.m9858a();
        if (a != 0) {
            return a;
        }
        a = (long) (m9883x().nextInt(86400000) + 1);
        this.f8410g.m9859a(a);
        return a;
    }

    @WorkerThread
    String m9870B() {
        mo3532e();
        return m9866G().getString("gmp_app_id", null);
    }

    String m9871C() {
        String str;
        synchronized (this.f8423u) {
            if (Math.abs(mo3540m().mo3361b() - this.f8422t) < 1000) {
                str = this.f8421s;
            } else {
                str = null;
            }
        }
        return str;
    }

    @WorkerThread
    Boolean m9872D() {
        mo3532e();
        return !m9866G().contains("use_service") ? null : Boolean.valueOf(m9866G().getBoolean("use_service", false));
    }

    @WorkerThread
    void m9873E() {
        boolean z = true;
        mo3532e();
        mo3548u().m9786D().m9774a("Clearing collection preferences.");
        boolean contains = m9866G().contains("measurement_enabled");
        if (contains) {
            z = m9881c(true);
        }
        Editor edit = m9866G().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            m9879b(z);
        }
    }

    @WorkerThread
    protected String m9874F() {
        mo3532e();
        String string = m9866G().getString("previous_os_version", null);
        String y = mo3537j().m9647y();
        if (!(TextUtils.isEmpty(y) || y.equals(string))) {
            Editor edit = m9866G().edit();
            edit.putString("previous_os_version", y);
            edit.apply();
        }
        return string;
    }

    @WorkerThread
    @NonNull
    Pair<String, Boolean> m9875a(String str) {
        mo3532e();
        long b = mo3540m().mo3361b();
        if (this.f8418p != null && b < this.f8420r) {
            return new Pair(this.f8418p, Boolean.valueOf(this.f8419q));
        }
        this.f8420r = b + mo3550w().m9503d(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(mo3541n());
            this.f8418p = advertisingIdInfo.getId();
            if (this.f8418p == null) {
                this.f8418p = "";
            }
            this.f8419q = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Throwable th) {
            mo3548u().m9785C().m9775a("Unable to get advertising id", th);
            this.f8418p = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.f8418p, Boolean.valueOf(this.f8419q));
    }

    protected void mo3551a() {
        this.f8417o = mo3541n().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f8416m = this.f8417o.getBoolean("has_been_opened", false);
        if (!this.f8416m) {
            Editor edit = this.f8417o.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
    }

    @WorkerThread
    void m9877a(boolean z) {
        mo3532e();
        mo3548u().m9786D().m9775a("Setting useService", Boolean.valueOf(z));
        Editor edit = m9866G().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    @WorkerThread
    String m9878b(String str) {
        mo3532e();
        String str2 = (String) m9875a(str).first;
        if (dy.m10381j("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, dy.m10381j("MD5").digest(str2.getBytes()))});
    }

    @WorkerThread
    void m9879b(boolean z) {
        mo3532e();
        mo3548u().m9786D().m9775a("Setting measurementEnabled", Boolean.valueOf(z));
        Editor edit = m9866G().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    @WorkerThread
    void m9880c(String str) {
        mo3532e();
        Editor edit = m9866G().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    @WorkerThread
    boolean m9881c(boolean z) {
        mo3532e();
        return m9866G().getBoolean("measurement_enabled", z);
    }

    void m9882d(String str) {
        synchronized (this.f8423u) {
            this.f8421s = str;
            this.f8422t = mo3540m().mo3361b();
        }
    }

    @WorkerThread
    protected SecureRandom m9883x() {
        mo3532e();
        if (this.f8424v == null) {
            this.f8424v = new SecureRandom();
        }
        return this.f8424v;
    }

    @WorkerThread
    String m9884y() {
        m9883x().nextBytes(new byte[16]);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, r0)});
    }

    @WorkerThread
    String m9885z() {
        mo3532e();
        try {
            return C3598c.m15655a().m15656b();
        } catch (IllegalStateException e) {
            mo3548u().m9817z().m9774a("Failed to retrieve Firebase Instance Id");
            return null;
        }
    }
}
