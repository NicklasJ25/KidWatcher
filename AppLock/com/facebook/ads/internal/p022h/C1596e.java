package com.facebook.ads.internal.p022h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.facebook.ads.internal.C1668j;
import com.facebook.ads.internal.p018m.ai;
import com.facebook.ads.internal.p024l.C1680c;
import com.facebook.ads.internal.p030j.p031a.C1618a;
import com.facebook.ads.internal.p030j.p031a.C1631n;
import com.facebook.ads.internal.p030j.p031a.C1633p;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class C1596e {
    private static final String f3969a = C1596e.class.getSimpleName();
    private static final String f3970b = C1680c.m4791b();
    private final C1595a f3971c;
    private final ThreadPoolExecutor f3972d;
    private final ConnectivityManager f3973e;
    private final C1618a f3974f;
    private final Handler f3975g;
    private final long f3976h;
    private final long f3977i;
    private final Runnable f3978j = new C15941(this);
    private volatile boolean f3979k;
    private int f3980l;
    private long f3981m;

    class C15941 implements Runnable {
        final /* synthetic */ C1596e f3968a;

        class C15931 extends AsyncTask<Void, Void, Void> {
            final /* synthetic */ C15941 f3967a;

            C15931(C15941 c15941) {
                this.f3967a = c15941;
            }

            protected Void m4438a(Void... voidArr) {
                C1596e.m4446b(this.f3967a.f3968a);
                if (this.f3967a.f3968a.f3981m > 0) {
                    try {
                        Thread.sleep(this.f3967a.f3968a.f3981m);
                    } catch (InterruptedException e) {
                    }
                }
                this.f3967a.f3968a.m4449d();
                return null;
            }

            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return m4438a((Void[]) objArr);
            }
        }

        C15941(C1596e c1596e) {
            this.f3968a = c1596e;
        }

        public void run() {
            this.f3968a.f3979k = false;
            if (this.f3968a.f3972d.getQueue().isEmpty()) {
                new C15931(this).executeOnExecutor(this.f3968a.f3972d, new Void[0]);
            }
        }
    }

    interface C1595a {
        JSONObject mo2737a();

        boolean mo2740a(JSONArray jSONArray);

        void mo2741b();

        boolean mo2744c();
    }

    C1596e(Context context, C1595a c1595a) {
        this.f3971c = c1595a;
        this.f3972d = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.f3973e = (ConnectivityManager) context.getSystemService("connectivity");
        this.f3974f = ai.m4831b(context);
        this.f3975g = new Handler(Looper.getMainLooper());
        this.f3976h = C1668j.m4723f(context);
        this.f3977i = C1668j.m4724g(context);
    }

    private void m4444a(long j) {
        this.f3975g.postDelayed(this.f3978j, j);
    }

    static /* synthetic */ int m4446b(C1596e c1596e) {
        int i = c1596e.f3980l + 1;
        c1596e.f3980l = i;
        return i;
    }

    private void m4448c() {
        if (this.f3980l >= 5) {
            m4451e();
            m4453b();
            return;
        }
        if (this.f3980l == 1) {
            this.f3981m = 2000;
        } else {
            this.f3981m *= 2;
        }
        m4452a();
    }

    @WorkerThread
    private void m4449d() {
        try {
            NetworkInfo activeNetworkInfo = this.f3973e.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                m4444a(this.f3977i);
                return;
            }
            JSONObject a = this.f3971c.mo2737a();
            if (a == null) {
                m4451e();
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("attempt", String.valueOf(this.f3980l));
            a.put("data", jSONObject);
            C1633p c1633p = new C1633p();
            c1633p.m4598a("payload", a.toString());
            C1631n b = this.f3974f.m4557b(f3970b, c1633p);
            Object e = b != null ? b.m4592e() : null;
            if (TextUtils.isEmpty(e)) {
                m4448c();
            } else if (b.m4588a() != 200) {
                m4448c();
            } else if (!this.f3971c.mo2740a(new JSONArray(e))) {
                m4448c();
            } else if (this.f3971c.mo2744c()) {
                m4448c();
            } else {
                m4451e();
            }
        } catch (Exception e2) {
            m4448c();
        }
    }

    private void m4451e() {
        this.f3980l = 0;
        this.f3981m = 0;
        if (this.f3972d.getQueue().size() == 0) {
            this.f3971c.mo2741b();
        }
    }

    void m4452a() {
        this.f3979k = true;
        this.f3975g.removeCallbacks(this.f3978j);
        m4444a(this.f3976h);
    }

    void m4453b() {
        if (!this.f3979k) {
            this.f3979k = true;
            this.f3975g.removeCallbacks(this.f3978j);
            m4444a(this.f3977i);
        }
    }
}
