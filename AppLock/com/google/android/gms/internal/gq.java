package com.google.android.gms.internal;

import com.google.android.gms.internal.gj.C2895a;
import com.google.android.gms.internal.gj.C2896b;
import com.google.android.gms.internal.gk.C2899a;
import com.google.android.gms.internal.gp.C2900a;
import com.google.android.gms.internal.gu.C2924a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class gq implements C2895a, gp {
    static final /* synthetic */ boolean f9074a = (!gq.class.desiredAssertionStatus());
    private static long f9075b = 0;
    private ScheduledFuture<?> f9076A = null;
    private long f9077B;
    private boolean f9078C;
    private final C2900a f9079c;
    private final gn f9080d;
    private String f9081e;
    private HashSet<String> f9082f = new HashSet();
    private boolean f9083g = true;
    private long f9084h;
    private gj f9085i;
    private C2910b f9086j = C2910b.Disconnected;
    private long f9087k = 0;
    private long f9088l = 0;
    private Map<Long, C2903a> f9089m;
    private List<C2912d> f9090n;
    private Map<Long, C2914f> f9091o;
    private Map<C2911c, C2913e> f9092p;
    private String f9093q;
    private boolean f9094r;
    private final gl f9095s;
    private final gk f9096t;
    private final ScheduledExecutorService f9097u;
    private final jp f9098v;
    private final gu f9099w;
    private String f9100x;
    private long f9101y = 0;
    private int f9102z = 0;

    private interface C2903a {
        void mo3668a(Map<String, Object> map);
    }

    class C29086 implements C2903a {
        final /* synthetic */ gq f9052a;

        C29086(gq gqVar) {
            this.f9052a = gqVar;
        }

        public void mo3668a(Map<String, Object> map) {
            String str = (String) map.get("s");
            if (!str.equals("ok")) {
                String str2 = (String) map.get("d");
                if (this.f9052a.f9098v.m11961a()) {
                    this.f9052a.f9098v.m11960a(new StringBuilder((String.valueOf(str).length() + 34) + String.valueOf(str2).length()).append("Failed to send stats: ").append(str).append(" (message: ").append(str2).append(")").toString(), new Object[0]);
                }
            }
        }
    }

    class C29097 implements Runnable {
        final /* synthetic */ gq f9053a;

        C29097(gq gqVar) {
            this.f9053a = gqVar;
        }

        public void run() {
            this.f9053a.f9076A = null;
            if (this.f9053a.m11186s()) {
                this.f9053a.mo3687d("connection_idle");
            } else {
                this.f9053a.m11184q();
            }
        }
    }

    private enum C2910b {
        Disconnected,
        GettingToken,
        Connecting,
        Authenticating,
        Connected
    }

    private static class C2911c {
        private final List<String> f9060a;
        private final Map<String, Object> f9061b;

        public C2911c(List<String> list, Map<String, Object> map) {
            this.f9060a = list;
            this.f9061b = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C2911c)) {
                return false;
            }
            C2911c c2911c = (C2911c) obj;
            return this.f9060a.equals(c2911c.f9060a) ? this.f9061b.equals(c2911c.f9061b) : false;
        }

        public int hashCode() {
            return (this.f9060a.hashCode() * 31) + this.f9061b.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(gm.m11073a(this.f9060a));
            String valueOf2 = String.valueOf(this.f9061b);
            return new StringBuilder((String.valueOf(valueOf).length() + 11) + String.valueOf(valueOf2).length()).append(valueOf).append(" (params: ").append(valueOf2).append(")").toString();
        }
    }

    private static class C2912d {
        private final String f9062a;
        private final List<String> f9063b;
        private final Object f9064c;
        private final gs f9065d;

        private C2912d(String str, List<String> list, Object obj, gs gsVar) {
            this.f9062a = str;
            this.f9063b = list;
            this.f9064c = obj;
            this.f9065d = gsVar;
        }

        public String m11117a() {
            return this.f9062a;
        }

        public List<String> m11118b() {
            return this.f9063b;
        }

        public Object m11119c() {
            return this.f9064c;
        }

        public gs m11120d() {
            return this.f9065d;
        }
    }

    private static class C2913e {
        private final gs f9066a;
        private final C2911c f9067b;
        private final go f9068c;
        private final Long f9069d;

        private C2913e(gs gsVar, C2911c c2911c, Long l, go goVar) {
            this.f9066a = gsVar;
            this.f9067b = c2911c;
            this.f9068c = goVar;
            this.f9069d = l;
        }

        public C2911c m11123a() {
            return this.f9067b;
        }

        public Long m11124b() {
            return this.f9069d;
        }

        public go m11125c() {
            return this.f9068c;
        }

        public String toString() {
            String valueOf = String.valueOf(this.f9067b.toString());
            String valueOf2 = String.valueOf(this.f9069d);
            return new StringBuilder((String.valueOf(valueOf).length() + 8) + String.valueOf(valueOf2).length()).append(valueOf).append(" (Tag: ").append(valueOf2).append(")").toString();
        }
    }

    private static class C2914f {
        private String f9070a;
        private Map<String, Object> f9071b;
        private gs f9072c;
        private boolean f9073d;

        private C2914f(String str, Map<String, Object> map, gs gsVar) {
            this.f9070a = str;
            this.f9071b = map;
            this.f9072c = gsVar;
        }

        public String m11127a() {
            return this.f9070a;
        }

        public Map<String, Object> m11128b() {
            return this.f9071b;
        }

        public gs m11129c() {
            return this.f9072c;
        }

        public void m11130d() {
            this.f9073d = true;
        }

        public boolean m11131e() {
            return this.f9073d;
        }
    }

    public gq(gl glVar, gn gnVar, C2900a c2900a) {
        this.f9079c = c2900a;
        this.f9095s = glVar;
        this.f9097u = glVar.m11068c();
        this.f9096t = glVar.m11067b();
        this.f9080d = gnVar;
        this.f9092p = new HashMap();
        this.f9089m = new HashMap();
        this.f9091o = new HashMap();
        this.f9090n = new ArrayList();
        this.f9099w = new C2924a(this.f9097u, glVar.m11066a(), "ConnectionRetryHelper").m11254a(1000).m11253a(1.3d).m11257b(30000).m11256b(0.7d).m11255a();
        long j = f9075b;
        f9075b = 1 + j;
        this.f9098v = new jp(glVar.m11066a(), "PersistentConnection", "pc_" + j);
        this.f9100x = null;
        m11184q();
    }

    private C2913e m11134a(C2911c c2911c) {
        if (this.f9098v.m11961a()) {
            jp jpVar = this.f9098v;
            String valueOf = String.valueOf(c2911c);
            jpVar.m11960a(new StringBuilder(String.valueOf(valueOf).length() + 15).append("removing query ").append(valueOf).toString(), new Object[0]);
        }
        if (this.f9092p.containsKey(c2911c)) {
            C2913e c2913e = (C2913e) this.f9092p.get(c2911c);
            this.f9092p.remove(c2911c);
            m11184q();
            return c2913e;
        }
        if (this.f9098v.m11961a()) {
            jpVar = this.f9098v;
            valueOf = String.valueOf(c2911c);
            jpVar.m11960a(new StringBuilder(String.valueOf(valueOf).length() + 64).append("Trying to remove listener for QuerySpec ").append(valueOf).append(" but no listener exists.").toString(), new Object[0]);
        }
        return null;
    }

    private Collection<C2913e> m11138a(List<String> list) {
        if (this.f9098v.m11961a()) {
            jp jpVar = this.f9098v;
            String valueOf = String.valueOf(list);
            jpVar.m11960a(new StringBuilder(String.valueOf(valueOf).length() + 29).append("removing all listens at path ").append(valueOf).toString(), new Object[0]);
        }
        Collection<C2913e> arrayList = new ArrayList();
        for (Entry entry : this.f9092p.entrySet()) {
            C2911c c2911c = (C2911c) entry.getKey();
            C2913e c2913e = (C2913e) entry.getValue();
            if (c2911c.f9060a.equals(list)) {
                arrayList.add(c2913e);
            }
        }
        for (C2913e c2913e2 : arrayList) {
            this.f9092p.remove(c2913e2.m11123a());
        }
        m11184q();
        return arrayList;
    }

    private Map<String, Object> m11139a(List<String> list, Object obj, String str) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("p", gm.m11073a((List) list));
        hashMap.put("d", obj);
        if (str != null) {
            hashMap.put("h", str);
        }
        return hashMap;
    }

    private void m11141a(long j) {
        if (this.f9098v.m11961a()) {
            this.f9098v.m11960a("handling timestamp", new Object[0]);
        }
        long currentTimeMillis = j - System.currentTimeMillis();
        Map hashMap = new HashMap();
        hashMap.put("serverTimeOffset", Long.valueOf(currentTimeMillis));
        this.f9079c.mo3716a(hashMap);
    }

    private void m11142a(C2913e c2913e) {
        Map hashMap = new HashMap();
        hashMap.put("p", gm.m11073a(c2913e.f9067b.f9060a));
        Long b = c2913e.m11124b();
        if (b != null) {
            hashMap.put("q", c2913e.m11123a().f9061b);
            hashMap.put("t", b);
        }
        m11148a("n", hashMap, null);
    }

    private void m11144a(String str, String str2) {
        this.f9098v.m11960a(new StringBuilder((String.valueOf(str).length() + 23) + String.valueOf(str2).length()).append("Auth token revoked: ").append(str).append(" (").append(str2).append(")").toString(), new Object[0]);
        this.f9093q = null;
        this.f9094r = true;
        this.f9079c.mo3717a(false);
        this.f9085i.m11062b();
    }

    private void m11145a(String str, List<String> list, Object obj, final gs gsVar) {
        Map hashMap = new HashMap();
        hashMap.put("p", gm.m11073a((List) list));
        hashMap.put("d", obj);
        m11148a(str, hashMap, new C2903a(this) {
            public void mo3668a(Map<String, Object> map) {
                String str = null;
                String str2 = (String) map.get("s");
                if (str2.equals("ok")) {
                    str2 = null;
                } else {
                    str = (String) map.get("d");
                }
                if (gsVar != null) {
                    gsVar.mo3707a(str2, str);
                }
            }
        });
    }

    private void m11146a(String str, List<String> list, Object obj, String str2, gs gsVar) {
        Map a = m11139a((List) list, obj, str2);
        long j = this.f9087k;
        this.f9087k = 1 + j;
        this.f9091o.put(Long.valueOf(j), new C2914f(str, a, gsVar));
        if (m11165g()) {
            m11154b(j);
        }
        this.f9077B = System.currentTimeMillis();
        m11184q();
    }

    private void m11147a(String str, Map<String, Object> map) {
        if (this.f9098v.m11961a()) {
            jp jpVar = this.f9098v;
            String valueOf = String.valueOf(map);
            jpVar.m11960a(new StringBuilder((String.valueOf(str).length() + 22) + String.valueOf(valueOf).length()).append("handleServerMessage: ").append(str).append(" ").append(valueOf).toString(), new Object[0]);
        }
        String str2;
        jp jpVar2;
        String str3;
        if (str.equals("d") || str.equals("m")) {
            boolean equals = str.equals("m");
            str2 = (String) map.get("p");
            Object obj = map.get("d");
            Long a = gm.m11072a(map.get("t"));
            if (!equals || !(obj instanceof Map) || ((Map) obj).size() != 0) {
                this.f9079c.mo3714a(gm.m11074a(str2), obj, equals, a);
            } else if (this.f9098v.m11961a()) {
                jpVar2 = this.f9098v;
                str3 = "ignoring empty merge for path ";
                str2 = String.valueOf(str2);
                jpVar2.m11960a(str2.length() != 0 ? str3.concat(str2) : new String(str3), new Object[0]);
            }
        } else if (str.equals("rm")) {
            str2 = (String) map.get("p");
            List a2 = gm.m11074a(str2);
            Object obj2 = map.get("d");
            Long a3 = gm.m11072a(map.get("t"));
            List<Map> list = (List) obj2;
            List arrayList = new ArrayList();
            for (Map map2 : list) {
                str3 = (String) map2.get("s");
                String str4 = (String) map2.get("e");
                arrayList.add(new gr(str3 != null ? gm.m11074a(str3) : null, str4 != null ? gm.m11074a(str4) : null, map2.get("m")));
            }
            if (!arrayList.isEmpty()) {
                this.f9079c.mo3715a(a2, arrayList, a3);
            } else if (this.f9098v.m11961a()) {
                jpVar2 = this.f9098v;
                str3 = "Ignoring empty range merge for path ";
                str2 = String.valueOf(str2);
                jpVar2.m11960a(str2.length() != 0 ? str3.concat(str2) : new String(str3), new Object[0]);
            }
        } else if (str.equals("c")) {
            m11156b(gm.m11074a((String) map.get("p")));
        } else if (str.equals("ac")) {
            m11144a((String) map.get("s"), (String) map.get("d"));
        } else if (str.equals("sd")) {
            m11157b((Map) map);
        } else if (this.f9098v.m11961a()) {
            jpVar2 = this.f9098v;
            str3 = "Unrecognized action from server: ";
            str2 = String.valueOf(str);
            jpVar2.m11960a(str2.length() != 0 ? str3.concat(str2) : new String(str3), new Object[0]);
        }
    }

    private void m11148a(String str, Map<String, Object> map, C2903a c2903a) {
        m11149a(str, false, (Map) map, c2903a);
    }

    private void m11149a(String str, boolean z, Map<String, Object> map, C2903a c2903a) {
        long p = m11182p();
        Map hashMap = new HashMap();
        hashMap.put("r", Long.valueOf(p));
        hashMap.put("a", str);
        hashMap.put("b", map);
        this.f9085i.m11060a(hashMap, z);
        this.f9089m.put(Long.valueOf(p), c2903a);
    }

    private void m11150a(List<String> list, C2911c c2911c) {
        if (list.contains("no_index")) {
            String valueOf = String.valueOf(c2911c.f9061b.get("i"));
            valueOf = new StringBuilder(String.valueOf(valueOf).length() + 14).append("\".indexOn\": \"").append(valueOf).append("\"").toString();
            jp jpVar = this.f9098v;
            String valueOf2 = String.valueOf(gm.m11073a(c2911c.f9060a));
            jpVar.m11957a(new StringBuilder((String.valueOf(valueOf).length() + 118) + String.valueOf(valueOf2).length()).append("Using an unspecified index. Consider adding '").append(valueOf).append("' at ").append(valueOf2).append(" to your security and Firebase Database rules for better performance").toString());
        }
    }

    private void m11151a(final boolean z) {
        gm.m11076a(m11163f(), "Must be connected to send auth, but was: %s", this.f9086j);
        gm.m11076a(this.f9093q != null, "Auth token must be set to authenticate!", new Object[0]);
        C2903a c29053 = new C2903a(this) {
            final /* synthetic */ gq f9044b;

            public void mo3668a(Map<String, Object> map) {
                this.f9044b.f9086j = C2910b.Connected;
                String str = (String) map.get("s");
                if (str.equals("ok")) {
                    this.f9044b.f9102z = 0;
                    this.f9044b.f9079c.mo3717a(true);
                    if (z) {
                        this.f9044b.m11178n();
                        return;
                    }
                    return;
                }
                this.f9044b.f9093q = null;
                this.f9044b.f9094r = true;
                this.f9044b.f9079c.mo3717a(false);
                String str2 = (String) map.get("d");
                this.f9044b.f9098v.m11960a(new StringBuilder((String.valueOf(str).length() + 26) + String.valueOf(str2).length()).append("Authentication failed: ").append(str).append(" (").append(str2).append(")").toString(), new Object[0]);
                this.f9044b.f9085i.m11062b();
                if (str.equals("invalid_token")) {
                    this.f9044b.f9102z = this.f9044b.f9102z + 1;
                    if (((long) this.f9044b.f9102z) >= 3) {
                        this.f9044b.f9099w.m11261b();
                        this.f9044b.f9098v.m11957a("Provided authentication credentials are invalid. This usually indicates your FirebaseApp instance was not initialized correctly. Make sure your google-services.json file has the correct firebase_url and api_key. You can re-download google-services.json from https://console.firebase.google.com/.");
                    }
                }
            }
        };
        Map hashMap = new HashMap();
        kx a = kx.m12264a(this.f9093q);
        if (a != null) {
            hashMap.put("cred", a.m12265a());
            if (a.m12266b() != null) {
                hashMap.put("authvar", a.m12266b());
            }
            m11149a("gauth", true, hashMap, c29053);
            return;
        }
        hashMap.put("cred", this.f9093q);
        m11149a("auth", true, hashMap, c29053);
    }

    private void m11154b(long j) {
        if (f9074a || m11165g()) {
            final C2914f c2914f = (C2914f) this.f9091o.get(Long.valueOf(j));
            final gs c = c2914f.m11129c();
            final String a = c2914f.m11127a();
            c2914f.m11130d();
            final long j2 = j;
            m11148a(a, c2914f.m11128b(), new C2903a(this) {
                final /* synthetic */ gq f9049e;

                public void mo3668a(Map<String, Object> map) {
                    if (this.f9049e.f9098v.m11961a()) {
                        jp a = this.f9049e.f9098v;
                        String str = a;
                        String valueOf = String.valueOf(map);
                        a.m11960a(new StringBuilder((String.valueOf(str).length() + 11) + String.valueOf(valueOf).length()).append(str).append(" response: ").append(valueOf).toString(), new Object[0]);
                    }
                    if (((C2914f) this.f9049e.f9091o.get(Long.valueOf(j2))) == c2914f) {
                        this.f9049e.f9091o.remove(Long.valueOf(j2));
                        if (c != null) {
                            String str2 = (String) map.get("s");
                            if (str2.equals("ok")) {
                                c.mo3707a(null, null);
                            } else {
                                c.mo3707a(str2, (String) map.get("d"));
                            }
                        }
                    } else if (this.f9049e.f9098v.m11961a()) {
                        this.f9049e.f9098v.m11960a("Ignoring on complete for put " + j2 + " because it was removed already.", new Object[0]);
                    }
                    this.f9049e.m11184q();
                }
            });
            return;
        }
        throw new AssertionError("sendPut called when we can't send writes (we're disconnected or writes are paused).");
    }

    private void m11155b(final C2913e c2913e) {
        Map hashMap = new HashMap();
        hashMap.put("p", gm.m11073a(c2913e.m11123a().f9060a));
        Long b = c2913e.m11124b();
        if (b != null) {
            hashMap.put("q", c2913e.f9067b.f9061b);
            hashMap.put("t", b);
        }
        go c = c2913e.m11125c();
        hashMap.put("h", c.mo3722a());
        if (c.mo3724b()) {
            gi c2 = c.mo3725c();
            List arrayList = new ArrayList();
            for (List a : c2.m11041a()) {
                arrayList.add(gm.m11073a(a));
            }
            Map hashMap2 = new HashMap();
            hashMap2.put("hs", c2.m11042b());
            hashMap2.put("ps", arrayList);
            hashMap.put("ch", hashMap2);
        }
        m11148a("q", hashMap, new C2903a(this) {
            final /* synthetic */ gq f9051b;

            public void mo3668a(Map<String, Object> map) {
                String str = (String) map.get("s");
                if (str.equals("ok")) {
                    Map map2 = (Map) map.get("d");
                    if (map2.containsKey("w")) {
                        this.f9051b.m11150a((List) map2.get("w"), c2913e.f9067b);
                    }
                }
                if (((C2913e) this.f9051b.f9092p.get(c2913e.m11123a())) != c2913e) {
                    return;
                }
                if (str.equals("ok")) {
                    c2913e.f9066a.mo3707a(null, null);
                    return;
                }
                this.f9051b.m11134a(c2913e.m11123a());
                c2913e.f9066a.mo3707a(str, (String) map.get("d"));
            }
        });
    }

    private void m11156b(List<String> list) {
        for (C2913e b : m11138a((List) list)) {
            b.f9066a.mo3707a("permission_denied", null);
        }
    }

    private void m11157b(Map<String, Object> map) {
        this.f9098v.m11962b((String) map.get("msg"));
    }

    private void m11159c(Map<String, Integer> map) {
        if (!map.isEmpty()) {
            Map hashMap = new HashMap();
            hashMap.put("c", map);
            m11148a("s", hashMap, new C29086(this));
        } else if (this.f9098v.m11961a()) {
            this.f9098v.m11960a("Not sending stats because stats are empty", new Object[0]);
        }
    }

    private boolean m11163f() {
        return this.f9086j == C2910b.Authenticating || this.f9086j == C2910b.Connected;
    }

    private boolean m11165g() {
        return this.f9086j == C2910b.Connected;
    }

    private void m11166h() {
        if (m11207e()) {
            gm.m11076a(this.f9086j == C2910b.Disconnected, "Not in disconnected state: %s", this.f9086j);
            final boolean z = this.f9094r;
            this.f9098v.m11960a("Scheduling connection attempt", new Object[0]);
            this.f9094r = false;
            this.f9099w.m11260a(new Runnable(this) {
                final /* synthetic */ gq f9041b;

                public void run() {
                    this.f9041b.f9098v.m11960a("Trying to fetch auth token", new Object[0]);
                    gm.m11076a(this.f9041b.f9086j == C2910b.Disconnected, "Not in disconnected state: %s", this.f9041b.f9086j);
                    this.f9041b.f9086j = C2910b.GettingToken;
                    this.f9041b.f9101y = 1 + this.f9041b.f9101y;
                    final long d = this.f9041b.f9101y;
                    this.f9041b.f9096t.mo3699a(z, new C2899a(this) {
                        final /* synthetic */ C29021 f9039b;

                        public void mo3666a(String str) {
                            if (d != this.f9039b.f9041b.f9101y) {
                                this.f9039b.f9041b.f9098v.m11960a("Ignoring getToken result, because this was not the latest attempt.", new Object[0]);
                            } else if (this.f9039b.f9041b.f9086j == C2910b.GettingToken) {
                                this.f9039b.f9041b.f9098v.m11960a("Successfully fetched token, opening connection", new Object[0]);
                                this.f9039b.f9041b.m11209g(str);
                            } else {
                                gm.m11076a(this.f9039b.f9041b.f9086j == C2910b.Disconnected, "Expected connection state disconnected, but was %s", this.f9039b.f9041b.f9086j);
                                this.f9039b.f9041b.f9098v.m11960a("Not opening connection after token refresh, because connection was set to disconnected", new Object[0]);
                            }
                        }

                        public void mo3667b(String str) {
                            if (d == this.f9039b.f9041b.f9101y) {
                                this.f9039b.f9041b.f9086j = C2910b.Disconnected;
                                jp a = this.f9039b.f9041b.f9098v;
                                String str2 = "Error fetching token: ";
                                String valueOf = String.valueOf(str);
                                a.m11960a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), new Object[0]);
                                this.f9039b.f9041b.m11166h();
                                return;
                            }
                            this.f9039b.f9041b.f9098v.m11960a("Ignoring getToken error, because this was not the latest attempt.", new Object[0]);
                        }
                    });
                }
            });
        }
    }

    private void m11169i() {
        Iterator it = this.f9091o.entrySet().iterator();
        while (it.hasNext()) {
            C2914f c2914f = (C2914f) ((Entry) it.next()).getValue();
            if (c2914f.m11128b().containsKey("h") && c2914f.m11131e()) {
                c2914f.m11129c().mo3707a("disconnected", null);
                it.remove();
            }
        }
    }

    private void m11171j() {
        m11151a(false);
    }

    private void m11173k() {
        m11151a(true);
    }

    private void m11175l() {
        gm.m11076a(m11163f(), "Must be connected to send unauth.", new Object[0]);
        gm.m11076a(this.f9093q == null, "Auth token must not be set.", new Object[0]);
        m11148a("unauth", Collections.emptyMap(), null);
    }

    private void m11177m() {
        if (this.f9098v.m11961a()) {
            this.f9098v.m11960a("calling restore state", new Object[0]);
        }
        gm.m11076a(this.f9086j == C2910b.Connecting, "Wanted to restore auth, but was in wrong state: %s", this.f9086j);
        if (this.f9093q == null) {
            if (this.f9098v.m11961a()) {
                this.f9098v.m11960a("Not restoring auth because token is null.", new Object[0]);
            }
            this.f9086j = C2910b.Connected;
            m11178n();
            return;
        }
        if (this.f9098v.m11961a()) {
            this.f9098v.m11960a("Restoring auth.", new Object[0]);
        }
        this.f9086j = C2910b.Authenticating;
        m11173k();
    }

    private void m11178n() {
        gm.m11076a(this.f9086j == C2910b.Connected, "Should be connected if we're restoring state, but we are: %s", this.f9086j);
        if (this.f9098v.m11961a()) {
            this.f9098v.m11960a("Restoring outstanding listens", new Object[0]);
        }
        for (C2913e c2913e : this.f9092p.values()) {
            if (this.f9098v.m11961a()) {
                jp jpVar = this.f9098v;
                String valueOf = String.valueOf(c2913e.m11123a());
                jpVar.m11960a(new StringBuilder(String.valueOf(valueOf).length() + 17).append("Restoring listen ").append(valueOf).toString(), new Object[0]);
            }
            m11155b(c2913e);
        }
        if (this.f9098v.m11961a()) {
            this.f9098v.m11960a("Restoring writes.", new Object[0]);
        }
        Object arrayList = new ArrayList(this.f9091o.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m11154b(((Long) it.next()).longValue());
        }
        for (C2912d c2912d : this.f9090n) {
            m11145a(c2912d.m11117a(), c2912d.m11118b(), c2912d.m11119c(), c2912d.m11120d());
        }
        this.f9090n.clear();
    }

    private void m11181o() {
        Map hashMap = new HashMap();
        String str;
        String valueOf;
        if (kw.m12262a()) {
            if (this.f9095s.m11069d()) {
                hashMap.put("persistence.android.enabled", Integer.valueOf(1));
            }
            str = "sdk.android.";
            valueOf = String.valueOf(this.f9095s.m11070e().replace('.', '-'));
            hashMap.put(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), Integer.valueOf(1));
        } else if (f9074a || !this.f9095s.m11069d()) {
            str = "sdk.java.";
            valueOf = String.valueOf(this.f9095s.m11070e().replace('.', '-'));
            hashMap.put(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), Integer.valueOf(1));
        } else {
            throw new AssertionError("Stats for persistence on JVM missing (persistence not yet supported)");
        }
        if (this.f9098v.m11961a()) {
            this.f9098v.m11960a("Sending first connection stats", new Object[0]);
        }
        m11159c(hashMap);
    }

    private long m11182p() {
        long j = this.f9088l;
        this.f9088l = 1 + j;
        return j;
    }

    private void m11184q() {
        boolean z = false;
        if (m11185r()) {
            if (this.f9076A != null) {
                this.f9076A.cancel(false);
            }
            this.f9076A = this.f9097u.schedule(new C29097(this), 60000, TimeUnit.MILLISECONDS);
        } else if (mo3689f("connection_idle")) {
            if (!m11185r()) {
                z = true;
            }
            gm.m11075a(z);
            mo3688e("connection_idle");
        }
    }

    private boolean m11185r() {
        return this.f9092p.isEmpty() && this.f9089m.isEmpty() && !this.f9078C && this.f9091o.isEmpty();
    }

    private boolean m11186s() {
        return m11185r() && System.currentTimeMillis() > this.f9077B + 60000;
    }

    public void mo3669a() {
        m11166h();
    }

    public void mo3670a(long j, String str) {
        if (this.f9098v.m11961a()) {
            this.f9098v.m11960a("onReady", new Object[0]);
        }
        this.f9084h = System.currentTimeMillis();
        m11141a(j);
        if (this.f9083g) {
            m11181o();
        }
        m11177m();
        this.f9083g = false;
        this.f9100x = str;
        this.f9079c.mo3713a();
    }

    public void mo3671a(C2896b c2896b) {
        if (this.f9098v.m11961a()) {
            jp jpVar = this.f9098v;
            String str = "Got on disconnect due to ";
            String valueOf = String.valueOf(c2896b.name());
            jpVar.m11960a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), new Object[0]);
        }
        this.f9086j = C2910b.Disconnected;
        this.f9085i = null;
        this.f9078C = false;
        this.f9089m.clear();
        m11169i();
        if (m11207e()) {
            boolean z = this.f9084h > 0 ? System.currentTimeMillis() - this.f9084h > 30000 : false;
            if (c2896b == C2896b.SERVER_RESET || r0) {
                this.f9099w.m11259a();
            }
            m11166h();
        }
        this.f9084h = 0;
        this.f9079c.mo3718b();
    }

    public void mo3672a(String str) {
        this.f9081e = str;
    }

    public void mo3673a(List<String> list, gs gsVar) {
        if (m11165g()) {
            m11145a("oc", (List) list, null, gsVar);
        } else {
            this.f9090n.add(new C2912d("oc", list, null, gsVar));
        }
        m11184q();
    }

    public void mo3674a(List<String> list, Object obj, gs gsVar) {
        m11146a("p", (List) list, obj, null, gsVar);
    }

    public void mo3675a(List<String> list, Object obj, String str, gs gsVar) {
        m11146a("p", (List) list, obj, str, gsVar);
    }

    public void mo3676a(List<String> list, Map<String, Object> map) {
        C2911c c2911c = new C2911c(list, map);
        if (this.f9098v.m11961a()) {
            jp jpVar = this.f9098v;
            String valueOf = String.valueOf(c2911c);
            jpVar.m11960a(new StringBuilder(String.valueOf(valueOf).length() + 15).append("unlistening on ").append(valueOf).toString(), new Object[0]);
        }
        C2913e a = m11134a(c2911c);
        if (a != null && m11163f()) {
            m11142a(a);
        }
        m11184q();
    }

    public void mo3677a(List<String> list, Map<String, Object> map, go goVar, Long l, gs gsVar) {
        C2911c c2911c = new C2911c(list, map);
        if (this.f9098v.m11961a()) {
            jp jpVar = this.f9098v;
            String valueOf = String.valueOf(c2911c);
            jpVar.m11960a(new StringBuilder(String.valueOf(valueOf).length() + 13).append("Listening on ").append(valueOf).toString(), new Object[0]);
        }
        gm.m11076a(!this.f9092p.containsKey(c2911c), "listen() called twice for same QuerySpec.", new Object[0]);
        if (this.f9098v.m11961a()) {
            jpVar = this.f9098v;
            valueOf = String.valueOf(c2911c);
            jpVar.m11960a(new StringBuilder(String.valueOf(valueOf).length() + 21).append("Adding listen query: ").append(valueOf).toString(), new Object[0]);
        }
        C2913e c2913e = new C2913e(gsVar, c2911c, l, goVar);
        this.f9092p.put(c2911c, c2913e);
        if (m11163f()) {
            m11155b(c2913e);
        }
        m11184q();
    }

    public void mo3678a(List<String> list, Map<String, Object> map, gs gsVar) {
        m11146a("m", (List) list, (Object) map, null, gsVar);
    }

    public void mo3679a(Map<String, Object> map) {
        if (map.containsKey("r")) {
            C2903a c2903a = (C2903a) this.f9089m.remove(Long.valueOf((long) ((Integer) map.get("r")).intValue()));
            if (c2903a != null) {
                c2903a.mo3668a((Map) map.get("b"));
            }
        } else if (!map.containsKey("error")) {
            if (map.containsKey("a")) {
                m11147a((String) map.get("a"), (Map) map.get("b"));
            } else if (this.f9098v.m11961a()) {
                jp jpVar = this.f9098v;
                String valueOf = String.valueOf(map);
                jpVar.m11960a(new StringBuilder(String.valueOf(valueOf).length() + 26).append("Ignoring unknown message: ").append(valueOf).toString(), new Object[0]);
            }
        }
    }

    public void mo3680b() {
        mo3687d("shutdown");
    }

    public void mo3681b(String str) {
        if (this.f9098v.m11961a()) {
            jp jpVar = this.f9098v;
            String str2 = "Firebase Database connection was forcefully killed by the server. Will not attempt reconnect. Reason: ";
            String valueOf = String.valueOf(str);
            jpVar.m11960a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), new Object[0]);
        }
        mo3687d("server_kill");
    }

    public void mo3682b(List<String> list, Object obj, gs gsVar) {
        this.f9078C = true;
        if (m11165g()) {
            m11145a("o", (List) list, obj, gsVar);
        } else {
            this.f9090n.add(new C2912d("o", list, obj, gsVar));
        }
        m11184q();
    }

    public void mo3683b(List<String> list, Map<String, Object> map, gs gsVar) {
        this.f9078C = true;
        if (m11165g()) {
            m11145a("om", (List) list, (Object) map, gsVar);
        } else {
            this.f9090n.add(new C2912d("om", list, map, gsVar));
        }
        m11184q();
    }

    public void mo3684c() {
        this.f9098v.m11960a("Auth token refresh requested", new Object[0]);
        mo3687d("token_refresh");
        mo3688e("token_refresh");
    }

    public void mo3685c(String str) {
        this.f9098v.m11960a("Auth token refreshed.", new Object[0]);
        this.f9093q = str;
        if (!m11163f()) {
            return;
        }
        if (str != null) {
            m11171j();
        } else {
            m11175l();
        }
    }

    public void mo3686d() {
        for (C2914f c2914f : this.f9091o.values()) {
            if (c2914f.f9072c != null) {
                c2914f.f9072c.mo3707a("write_canceled", null);
            }
        }
        for (C2912d c2912d : this.f9090n) {
            if (c2912d.f9065d != null) {
                c2912d.f9065d.mo3707a("write_canceled", null);
            }
        }
        this.f9091o.clear();
        this.f9090n.clear();
        if (!m11163f()) {
            this.f9078C = false;
        }
        m11184q();
    }

    public void mo3687d(String str) {
        if (this.f9098v.m11961a()) {
            jp jpVar = this.f9098v;
            String str2 = "Connection interrupted for: ";
            String valueOf = String.valueOf(str);
            jpVar.m11960a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), new Object[0]);
        }
        this.f9082f.add(str);
        if (this.f9085i != null) {
            this.f9085i.m11062b();
            this.f9085i = null;
        } else {
            this.f9099w.m11262c();
            this.f9086j = C2910b.Disconnected;
        }
        this.f9099w.m11259a();
    }

    public void mo3688e(String str) {
        if (this.f9098v.m11961a()) {
            jp jpVar = this.f9098v;
            String str2 = "Connection no longer interrupted for: ";
            String valueOf = String.valueOf(str);
            jpVar.m11960a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), new Object[0]);
        }
        this.f9082f.remove(str);
        if (m11207e() && this.f9086j == C2910b.Disconnected) {
            m11166h();
        }
    }

    boolean m11207e() {
        return this.f9082f.size() == 0;
    }

    public boolean mo3689f(String str) {
        return this.f9082f.contains(str);
    }

    public void m11209g(String str) {
        gm.m11076a(this.f9086j == C2910b.GettingToken, "Trying to open network connection while in the wrong state: %s", this.f9086j);
        if (str == null) {
            this.f9079c.mo3717a(false);
        }
        this.f9093q = str;
        this.f9086j = C2910b.Connecting;
        this.f9085i = new gj(this.f9095s, this.f9080d, this.f9081e, this, this.f9100x);
        this.f9085i.m11057a();
    }
}
