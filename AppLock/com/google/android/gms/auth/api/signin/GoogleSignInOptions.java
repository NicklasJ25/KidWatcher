package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.C2423b;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.api.C2456a.C2416a.C2419d;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInOptions extends zza implements C2419d, ReflectedParcelable {
    public static final Creator<GoogleSignInOptions> CREATOR = new C2421b();
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN = new C2415a().m7636a(SCOPE_GAMES, new Scope[0]).m7638c();
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new C2415a().m7635a().m7637b().m7638c();
    public static final Scope SCOPE_GAMES = new Scope("https://www.googleapis.com/auth/games");
    private static Comparator<Scope> f7205k = new C24141();
    public static final Scope zzakh = new Scope("profile");
    public static final Scope zzaki = new Scope("email");
    public static final Scope zzakj = new Scope("openid");
    final int f7206a;
    private final ArrayList<Scope> f7207b;
    private Account f7208c;
    private boolean f7209d;
    private final boolean f7210e;
    private final boolean f7211f;
    private String f7212g;
    private String f7213h;
    private ArrayList<zzg> f7214i;
    private Map<Integer, zzg> f7215j;

    class C24141 implements Comparator<Scope> {
        C24141() {
        }

        public int m7634a(Scope scope, Scope scope2) {
            return scope.m7724a().compareTo(scope2.m7724a());
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m7634a((Scope) obj, (Scope) obj2);
        }
    }

    public static final class C2415a {
        private Set<Scope> f7197a = new HashSet();
        private boolean f7198b;
        private boolean f7199c;
        private boolean f7200d;
        private String f7201e;
        private Account f7202f;
        private String f7203g;
        private Map<Integer, zzg> f7204h = new HashMap();

        public C2415a m7635a() {
            this.f7197a.add(GoogleSignInOptions.zzakj);
            return this;
        }

        public C2415a m7636a(Scope scope, Scope... scopeArr) {
            this.f7197a.add(scope);
            this.f7197a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public C2415a m7637b() {
            this.f7197a.add(GoogleSignInOptions.zzakh);
            return this;
        }

        public GoogleSignInOptions m7638c() {
            if (this.f7200d && (this.f7202f == null || !this.f7197a.isEmpty())) {
                m7635a();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.f7197a), this.f7202f, this.f7200d, this.f7198b, this.f7199c, this.f7201e, this.f7203g, this.f7204h);
        }
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, ArrayList<zzg> arrayList2) {
        this(i, (ArrayList) arrayList, account, z, z2, z3, str, str2, m7640a((List) arrayList2));
    }

    private GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, zzg> map) {
        this.f7206a = i;
        this.f7207b = arrayList;
        this.f7208c = account;
        this.f7209d = z;
        this.f7210e = z2;
        this.f7211f = z3;
        this.f7212g = str;
        this.f7213h = str2;
        this.f7214i = new ArrayList(map.values());
        this.f7215j = map;
    }

    @Nullable
    public static GoogleSignInOptions m7639a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Collection hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        Object optString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap());
    }

    private static Map<Integer, zzg> m7640a(@Nullable List<zzg> list) {
        Map<Integer, zzg> hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (zzg com_google_android_gms_auth_api_signin_internal_zzg : list) {
            hashMap.put(Integer.valueOf(com_google_android_gms_auth_api_signin_internal_zzg.m7668a()), com_google_android_gms_auth_api_signin_internal_zzg);
        }
        return hashMap;
    }

    public ArrayList<Scope> m7641a() {
        return new ArrayList(this.f7207b);
    }

    public Account m7642b() {
        return this.f7208c;
    }

    public boolean m7643c() {
        return this.f7209d;
    }

    public boolean m7644d() {
        return this.f7210e;
    }

    public boolean m7645e() {
        return this.f7211f;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.f7214i.size() > 0 || googleSignInOptions.f7214i.size() > 0 || this.f7207b.size() != googleSignInOptions.m7641a().size() || !this.f7207b.containsAll(googleSignInOptions.m7641a())) {
                return false;
            }
            if (this.f7208c == null) {
                if (googleSignInOptions.m7642b() != null) {
                    return false;
                }
            } else if (!this.f7208c.equals(googleSignInOptions.m7642b())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f7212g)) {
                if (!TextUtils.isEmpty(googleSignInOptions.m7646f())) {
                    return false;
                }
            } else if (!this.f7212g.equals(googleSignInOptions.m7646f())) {
                return false;
            }
            return this.f7211f == googleSignInOptions.m7645e() && this.f7209d == googleSignInOptions.m7643c() && this.f7210e == googleSignInOptions.m7644d();
        } catch (ClassCastException e) {
            return false;
        }
    }

    public String m7646f() {
        return this.f7212g;
    }

    public String m7647g() {
        return this.f7213h;
    }

    public ArrayList<zzg> m7648h() {
        return this.f7214i;
    }

    public int hashCode() {
        Object arrayList = new ArrayList();
        Iterator it = this.f7207b.iterator();
        while (it.hasNext()) {
            arrayList.add(((Scope) it.next()).m7724a());
        }
        Collections.sort(arrayList);
        return new C2423b().m7659a(arrayList).m7659a(this.f7208c).m7659a(this.f7212g).m7660a(this.f7211f).m7660a(this.f7209d).m7660a(this.f7210e).m7658a();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2421b.m7652a(this, parcel, i);
    }
}
