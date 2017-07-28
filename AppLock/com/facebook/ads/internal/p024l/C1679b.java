package com.facebook.ads.internal.p024l;

import android.content.Context;
import com.facebook.ads.internal.C1474a;
import com.facebook.ads.internal.C1555d;
import com.facebook.ads.internal.C1668j;
import com.facebook.ads.internal.p018m.C1694b;
import com.facebook.ads.internal.p018m.C1725p;
import com.facebook.ads.internal.p018m.ai;
import com.facebook.ads.internal.p018m.ai.C1691a;
import com.facebook.ads.internal.p018m.al;
import com.facebook.ads.internal.p024l.C1683e.C1682a;
import com.facebook.ads.internal.p028g.C1576d;
import com.facebook.ads.internal.p028g.C1580f;
import com.facebook.ads.internal.p028g.C1583i;
import com.facebook.ads.internal.p030j.p031a.C1618a;
import com.facebook.ads.internal.p030j.p031a.C1619b;
import com.facebook.ads.internal.p030j.p031a.C1630m;
import com.facebook.ads.internal.p030j.p031a.C1631n;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;

public class C1679b {
    private static final al f4164i = new al();
    private static final ThreadPoolExecutor f4165j = ((ThreadPoolExecutor) Executors.newCachedThreadPool(f4164i));
    Map<String, String> f4166a;
    private final Context f4167b;
    private final C1681d f4168c = C1681d.m4792a();
    private final C1668j f4169d = new C1668j(this.f4167b);
    private C1539a f4170e;
    private C1580f f4171f;
    private C1618a f4172g;
    private final String f4173h = C1680c.m4790a();

    public interface C1539a {
        void mo2726a(C1555d c1555d);

        void mo2727a(C1684f c1684f);
    }

    class C16772 extends C1619b {
        final /* synthetic */ C1679b f4162a;

        C16772(C1679b c1679b) {
            this.f4162a = c1679b;
        }

        public void m4771a(C1630m c1630m) {
            C1725p.m4948b(this.f4162a.f4171f);
            this.f4162a.f4172g = null;
            try {
                C1631n a = c1630m.m4587a();
                if (a != null) {
                    String e = a.m4592e();
                    C1683e a2 = this.f4162a.f4168c.m4796a(e);
                    if (a2.m4797a() == C1682a.ERROR) {
                        C1685g c1685g = (C1685g) a2;
                        String c = c1685g.m4799c();
                        this.f4162a.m4776a(C1474a.m3818a(c1685g.m4800d(), C1474a.ERROR_MESSAGE).m3820a(c == null ? e : c));
                        return;
                    }
                }
            } catch (JSONException e2) {
            }
            this.f4162a.m4776a(new C1555d(C1474a.NETWORK_ERROR, c1630m.getMessage()));
        }

        public void mo2775a(C1631n c1631n) {
            if (c1631n != null) {
                String e = c1631n.m4592e();
                C1725p.m4948b(this.f4162a.f4171f);
                this.f4162a.f4172g = null;
                this.f4162a.m4780a(e);
            }
        }

        public void mo2776a(Exception exception) {
            if (C1630m.class.equals(exception.getClass())) {
                m4771a((C1630m) exception);
            } else {
                this.f4162a.m4776a(new C1555d(C1474a.NETWORK_ERROR, exception.getMessage()));
            }
        }
    }

    public C1679b(Context context) {
        this.f4167b = context.getApplicationContext();
    }

    private void m4776a(C1555d c1555d) {
        if (this.f4170e != null) {
            this.f4170e.mo2726a(c1555d);
        }
        m4787a();
    }

    private void m4779a(C1684f c1684f) {
        if (this.f4170e != null) {
            this.f4170e.mo2727a(c1684f);
        }
        m4787a();
    }

    private void m4780a(String str) {
        try {
            C1683e a = this.f4168c.m4796a(str);
            C1576d b = a.m4798b();
            if (b != null) {
                this.f4169d.m4736a(b.m4385b());
                C1725p.m4945a(b.m4383a().m4390c(), this.f4171f);
            }
            switch (a.m4797a()) {
                case ADS:
                    C1684f c1684f = (C1684f) a;
                    if (b != null && b.m4383a().m4391d()) {
                        C1725p.m4946a(str, this.f4171f);
                    }
                    m4779a(c1684f);
                    return;
                case ERROR:
                    C1685g c1685g = (C1685g) a;
                    String c = c1685g.m4799c();
                    C1474a a2 = C1474a.m3818a(c1685g.m4800d(), C1474a.ERROR_MESSAGE);
                    if (c != null) {
                        str = c;
                    }
                    m4776a(a2.m3820a(str));
                    return;
                default:
                    m4776a(C1474a.UNKNOWN_RESPONSE.m3820a(str));
                    return;
            }
        } catch (Exception e) {
            m4776a(C1474a.PARSER_FAILURE.m3820a(e.getMessage()));
        }
        m4776a(C1474a.PARSER_FAILURE.m3820a(e.getMessage()));
    }

    private C1619b m4781b() {
        return new C16772(this);
    }

    public void m4787a() {
        if (this.f4172g != null) {
            this.f4172g.m4562c(1);
            this.f4172g.m4560b(1);
            this.f4172g = null;
        }
    }

    public void m4788a(final C1580f c1580f) {
        m4787a();
        if (ai.m4833c(this.f4167b) == C1691a.NONE) {
            m4776a(new C1555d(C1474a.NETWORK_ERROR, "No network connection"));
            return;
        }
        this.f4171f = c1580f;
        C1694b.m4845a(this.f4167b);
        if (C1725p.m4947a(c1580f)) {
            String c = C1725p.m4949c(c1580f);
            if (c != null) {
                m4780a(c);
                return;
            } else {
                m4776a(C1474a.LOAD_TOO_FREQUENTLY.m3820a(null));
                return;
            }
        }
        f4165j.submit(new Runnable(this) {
            final /* synthetic */ C1679b f4161b;

            public void run() {
                C1583i.m4412b(this.f4161b.f4167b);
                this.f4161b.f4166a = c1580f.m4407e();
                try {
                    this.f4161b.f4172g = ai.m4832b(this.f4161b.f4167b, c1580f.f3907e);
                    this.f4161b.f4172g.m4552a(this.f4161b.f4173h, this.f4161b.f4172g.m4559b().m4595a(this.f4161b.f4166a), this.f4161b.m4781b());
                } catch (Exception e) {
                    this.f4161b.m4776a(C1474a.AD_REQUEST_FAILED.m3820a(e.getMessage()));
                }
            }
        });
    }

    public void m4789a(C1539a c1539a) {
        this.f4170e = c1539a;
    }
}
