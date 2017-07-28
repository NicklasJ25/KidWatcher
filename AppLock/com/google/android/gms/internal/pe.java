package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@wh
public final class pe {
    private final Date f10174a;
    private final String f10175b;
    private final int f10176c;
    private final Set<String> f10177d;
    private final Location f10178e;
    private final boolean f10179f;
    private final Bundle f10180g;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> f10181h;
    private final String f10182i;
    private final String f10183j;
    private final SearchAdRequest f10184k;
    private final int f10185l;
    private final Set<String> f10186m;
    private final Bundle f10187n;
    private final Set<String> f10188o;
    private final boolean f10189p;

    public static final class C3146a {
        private final HashSet<String> f10159a = new HashSet();
        private final Bundle f10160b = new Bundle();
        private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> f10161c = new HashMap();
        private final HashSet<String> f10162d = new HashSet();
        private final Bundle f10163e = new Bundle();
        private final HashSet<String> f10164f = new HashSet();
        private Date f10165g;
        private String f10166h;
        private int f10167i = -1;
        private Location f10168j;
        private boolean f10169k = false;
        private String f10170l;
        private String f10171m;
        private int f10172n = -1;
        private boolean f10173o;

        public void m13054a(int i) {
            this.f10167i = i;
        }

        public void m13055a(Location location) {
            this.f10168j = location;
        }

        @Deprecated
        public void m13056a(NetworkExtras networkExtras) {
            if (networkExtras instanceof AdMobExtras) {
                m13057a(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            } else {
                this.f10161c.put(networkExtras.getClass(), networkExtras);
            }
        }

        public void m13057a(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.f10160b.putBundle(cls.getName(), bundle);
        }

        public void m13058a(String str) {
            this.f10159a.add(str);
        }

        public void m13059a(String str, String str2) {
            this.f10163e.putString(str, str2);
        }

        public void m13060a(Date date) {
            this.f10165g = date;
        }

        public void m13061a(boolean z) {
            this.f10169k = z;
        }

        public void m13062b(Class<? extends CustomEvent> cls, Bundle bundle) {
            if (this.f10160b.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
                this.f10160b.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
            }
            this.f10160b.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
        }

        public void m13063b(String str) {
            this.f10162d.add(str);
        }

        public void m13064b(boolean z) {
            this.f10172n = z ? 1 : 0;
        }

        public void m13065c(String str) {
            this.f10162d.remove(str);
        }

        public void m13066c(boolean z) {
            this.f10173o = z;
        }

        public void m13067d(String str) {
            this.f10166h = str;
        }

        public void m13068e(String str) {
            this.f10170l = str;
        }

        public void m13069f(String str) {
            this.f10171m = str;
        }

        public void m13070g(String str) {
            this.f10164f.add(str);
        }
    }

    public pe(C3146a c3146a) {
        this(c3146a, null);
    }

    public pe(C3146a c3146a, SearchAdRequest searchAdRequest) {
        this.f10174a = c3146a.f10165g;
        this.f10175b = c3146a.f10166h;
        this.f10176c = c3146a.f10167i;
        this.f10177d = Collections.unmodifiableSet(c3146a.f10159a);
        this.f10178e = c3146a.f10168j;
        this.f10179f = c3146a.f10169k;
        this.f10180g = c3146a.f10160b;
        this.f10181h = Collections.unmodifiableMap(c3146a.f10161c);
        this.f10182i = c3146a.f10170l;
        this.f10183j = c3146a.f10171m;
        this.f10184k = searchAdRequest;
        this.f10185l = c3146a.f10172n;
        this.f10186m = Collections.unmodifiableSet(c3146a.f10162d);
        this.f10187n = c3146a.f10163e;
        this.f10188o = Collections.unmodifiableSet(c3146a.f10164f);
        this.f10189p = c3146a.f10173o;
    }

    @Deprecated
    public <T extends NetworkExtras> T m13071a(Class<T> cls) {
        return (NetworkExtras) this.f10181h.get(cls);
    }

    public Date m13072a() {
        return this.f10174a;
    }

    public boolean m13073a(Context context) {
        return this.f10186m.contains(ol.m12979a().m8400a(context));
    }

    public Bundle m13074b(Class<? extends MediationAdapter> cls) {
        return this.f10180g.getBundle(cls.getName());
    }

    public String m13075b() {
        return this.f10175b;
    }

    public int m13076c() {
        return this.f10176c;
    }

    public Bundle m13077c(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.f10180g.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        return bundle != null ? bundle.getBundle(cls.getName()) : null;
    }

    public Set<String> m13078d() {
        return this.f10177d;
    }

    public Location m13079e() {
        return this.f10178e;
    }

    public boolean m13080f() {
        return this.f10179f;
    }

    public String m13081g() {
        return this.f10182i;
    }

    public String m13082h() {
        return this.f10183j;
    }

    public SearchAdRequest m13083i() {
        return this.f10184k;
    }

    public Map<Class<? extends NetworkExtras>, NetworkExtras> m13084j() {
        return this.f10181h;
    }

    public Bundle m13085k() {
        return this.f10180g;
    }

    public int m13086l() {
        return this.f10185l;
    }

    public Bundle m13087m() {
        return this.f10187n;
    }

    public Set<String> m13088n() {
        return this.f10188o;
    }

    public boolean m13089o() {
        return this.f10189p;
    }
}
