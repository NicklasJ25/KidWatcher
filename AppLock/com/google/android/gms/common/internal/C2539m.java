package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.C2456a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.en;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class C2539m {
    private final Account f7443a;
    private final Set<Scope> f7444b;
    private final Set<Scope> f7445c;
    private final Map<C2456a<?>, C2538a> f7446d;
    private final int f7447e;
    private final View f7448f;
    private final String f7449g;
    private final String f7450h;
    private final en f7451i;
    private Integer f7452j;

    public static final class C2538a {
        public final Set<Scope> f7442a;
    }

    public C2539m(Account account, Set<Scope> set, Map<C2456a<?>, C2538a> map, int i, View view, String str, String str2, en enVar) {
        Map map2;
        this.f7443a = account;
        this.f7444b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.f7446d = map2;
        this.f7448f = view;
        this.f7447e = i;
        this.f7449g = str;
        this.f7450h = str2;
        this.f7451i = enVar;
        Set hashSet = new HashSet(this.f7444b);
        for (C2538a c2538a : this.f7446d.values()) {
            hashSet.addAll(c2538a.f7442a);
        }
        this.f7445c = Collections.unmodifiableSet(hashSet);
    }

    public Account m8046a() {
        return this.f7443a;
    }

    public void m8047a(Integer num) {
        this.f7452j = num;
    }

    public Account m8048b() {
        return this.f7443a != null ? this.f7443a : new Account("<<default account>>", "com.google");
    }

    public Set<Scope> m8049c() {
        return this.f7444b;
    }

    public Set<Scope> m8050d() {
        return this.f7445c;
    }

    public Map<C2456a<?>, C2538a> m8051e() {
        return this.f7446d;
    }

    public String m8052f() {
        return this.f7449g;
    }

    public String m8053g() {
        return this.f7450h;
    }

    public en m8054h() {
        return this.f7451i;
    }

    public Integer m8055i() {
        return this.f7452j;
    }
}
