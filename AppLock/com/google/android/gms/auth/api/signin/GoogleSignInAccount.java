package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.util.C2580e;
import com.google.android.gms.common.util.C2582g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount extends zza implements ReflectedParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new C2420a();
    public static C2580e f7183a = C2582g.m8288d();
    private static Comparator<Scope> f7184n = new C24131();
    final int f7185b;
    List<Scope> f7186c;
    private String f7187d;
    private String f7188e;
    private String f7189f;
    private String f7190g;
    private Uri f7191h;
    private String f7192i;
    private long f7193j;
    private String f7194k;
    private String f7195l;
    private String f7196m;

    class C24131 implements Comparator<Scope> {
        C24131() {
        }

        public int m7618a(Scope scope, Scope scope2) {
            return scope.m7724a().compareTo(scope2.m7724a());
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m7618a((Scope) obj, (Scope) obj2);
        }
    }

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.f7185b = i;
        this.f7187d = str;
        this.f7188e = str2;
        this.f7189f = str3;
        this.f7190g = str4;
        this.f7191h = uri;
        this.f7192i = str5;
        this.f7193j = j;
        this.f7194k = str6;
        this.f7186c = list;
        this.f7195l = str7;
        this.f7196m = str8;
    }

    @Nullable
    public static GoogleSignInAccount m7619a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Object optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        Set hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        return m7620a(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet).m7623b(jSONObject.optString("serverAuthCode", null));
    }

    public static GoogleSignInAccount m7620a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Uri uri, @Nullable Long l, @NonNull String str7, @NonNull Set<Scope> set) {
        if (l == null) {
            l = Long.valueOf(f7183a.mo3360a() / 1000);
        }
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l.longValue(), C2513c.m7934a(str7), new ArrayList((Collection) C2513c.m7932a((Object) set)), str5, str6);
    }

    private JSONObject m7621l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (m7622a() != null) {
                jSONObject.put("id", m7622a());
            }
            if (m7624b() != null) {
                jSONObject.put("tokenId", m7624b());
            }
            if (m7625c() != null) {
                jSONObject.put("email", m7625c());
            }
            if (m7626d() != null) {
                jSONObject.put("displayName", m7626d());
            }
            if (m7627e() != null) {
                jSONObject.put("givenName", m7627e());
            }
            if (m7628f() != null) {
                jSONObject.put("familyName", m7628f());
            }
            if (m7629g() != null) {
                jSONObject.put("photoUrl", m7629g().toString());
            }
            if (m7630h() != null) {
                jSONObject.put("serverAuthCode", m7630h());
            }
            jSONObject.put("expirationTime", this.f7193j);
            jSONObject.put("obfuscatedIdentifier", m7632j());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f7186c, f7184n);
            for (Scope a : this.f7186c) {
                jSONArray.put(a.m7724a());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    public String m7622a() {
        return this.f7187d;
    }

    public GoogleSignInAccount m7623b(String str) {
        this.f7192i = str;
        return this;
    }

    @Nullable
    public String m7624b() {
        return this.f7188e;
    }

    @Nullable
    public String m7625c() {
        return this.f7189f;
    }

    @Nullable
    public String m7626d() {
        return this.f7190g;
    }

    @Nullable
    public String m7627e() {
        return this.f7195l;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof GoogleSignInAccount) ? false : ((GoogleSignInAccount) obj).m7633k().equals(m7633k());
    }

    @Nullable
    public String m7628f() {
        return this.f7196m;
    }

    @Nullable
    public Uri m7629g() {
        return this.f7191h;
    }

    @Nullable
    public String m7630h() {
        return this.f7192i;
    }

    public int hashCode() {
        return m7633k().hashCode();
    }

    public long m7631i() {
        return this.f7193j;
    }

    @NonNull
    public String m7632j() {
        return this.f7194k;
    }

    public String m7633k() {
        return m7621l().toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2420a.m7649a(this, parcel, i);
    }
}
