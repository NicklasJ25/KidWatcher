package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.util.Base64;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.tb.C3277a;
import com.google.android.gms.internal.xg.C3435a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@wh
public class sy {
    private final Map<ta, tb> f10637a = new HashMap();
    private final LinkedList<ta> f10638b = new LinkedList();
    @Nullable
    private sv f10639c;

    static String m13820a(String str) {
        try {
            Matcher matcher = Pattern.compile("([^/]+/[0-9]+).*").matcher(str);
            if (matcher.matches()) {
                str = matcher.group(1);
            }
        } catch (RuntimeException e) {
        }
        return str;
    }

    static Set<String> m13821a(zzec com_google_android_gms_internal_zzec) {
        Set<String> hashSet = new HashSet();
        hashSet.addAll(com_google_android_gms_internal_zzec.f11879c.keySet());
        Bundle bundle = com_google_android_gms_internal_zzec.f11889m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            hashSet.addAll(bundle.keySet());
        }
        return hashSet;
    }

    private static void m13822a(Bundle bundle, String str) {
        String[] split = str.split("/", 2);
        if (split.length != 0) {
            String str2 = split[0];
            if (split.length == 1) {
                bundle.remove(str2);
                return;
            }
            Bundle bundle2 = bundle.getBundle(str2);
            if (bundle2 != null) {
                m13822a(bundle2, split[1]);
            }
        }
    }

    private static void m13823a(String str, ta taVar) {
        if (aad.m8420a(2)) {
            zh.m15051a(String.format(str, new Object[]{taVar}));
        }
    }

    static zzec m13824b(zzec com_google_android_gms_internal_zzec) {
        zzec e = m13830e(com_google_android_gms_internal_zzec);
        m13826c(e, "_skipMediation");
        return e;
    }

    private String[] m13825b(String str) {
        try {
            String[] split = str.split("\u0000");
            for (int i = 0; i < split.length; i++) {
                split[i] = new String(Base64.decode(split[i], 0), "UTF-8");
            }
            return split;
        } catch (UnsupportedEncodingException e) {
            return new String[0];
        }
    }

    private static void m13826c(zzec com_google_android_gms_internal_zzec, String str) {
        Bundle bundle = com_google_android_gms_internal_zzec.f11889m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            bundle.putBoolean(str, true);
        }
        com_google_android_gms_internal_zzec.f11879c.putBoolean(str, true);
    }

    static boolean m13827c(zzec com_google_android_gms_internal_zzec) {
        return m13821a(com_google_android_gms_internal_zzec).contains("_skipMediation");
    }

    private boolean m13828c(String str) {
        try {
            return Pattern.matches((String) qb.bd.m13225c(), str);
        } catch (Throwable e) {
            zzw.zzcQ().m15000a(e, "InterstitialAdPool.isExcludedAdUnit");
            return false;
        }
    }

    static zzec m13829d(zzec com_google_android_gms_internal_zzec) {
        zzec e = m13830e(com_google_android_gms_internal_zzec);
        for (String str : ((String) qb.aZ.m13225c()).split(",")) {
            m13822a(e.f11889m, str);
            String str2 = "com.google.ads.mediation.admob.AdMobAdapter/";
            if (str.startsWith(str2)) {
                m13822a(e.f11879c, str.replaceFirst(str2, ""));
            }
        }
        return e;
    }

    static zzec m13830e(zzec com_google_android_gms_internal_zzec) {
        Parcel obtain = Parcel.obtain();
        com_google_android_gms_internal_zzec.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        zzec com_google_android_gms_internal_zzec2 = (zzec) zzec.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        if (((Boolean) qb.aR.m13225c()).booleanValue()) {
            zzec.m15380a(com_google_android_gms_internal_zzec2);
        }
        return com_google_android_gms_internal_zzec2;
    }

    private String m13831e() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = this.f10638b.iterator();
            while (it.hasNext()) {
                stringBuilder.append(Base64.encodeToString(((ta) it.next()).toString().getBytes("UTF-8"), 0));
                if (it.hasNext()) {
                    stringBuilder.append("\u0000");
                }
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    @Nullable
    C3277a m13832a(zzec com_google_android_gms_internal_zzec, String str) {
        if (m13828c(str)) {
            return null;
        }
        tb tbVar;
        int i = new C3435a(this.f10639c.m13764a()).m14763a().f11406m;
        zzec d = m13829d(com_google_android_gms_internal_zzec);
        String a = m13820a(str);
        ta taVar = new ta(d, a, i);
        tb tbVar2 = (tb) this.f10637a.get(taVar);
        if (tbVar2 == null) {
            m13823a("Interstitial pool created at %s.", taVar);
            tbVar2 = new tb(d, a, i);
            this.f10637a.put(taVar, tbVar2);
            tbVar = tbVar2;
        } else {
            tbVar = tbVar2;
        }
        this.f10638b.remove(taVar);
        this.f10638b.add(taVar);
        tbVar.m13883g();
        while (this.f10638b.size() > ((Integer) qb.ba.m13225c()).intValue()) {
            ta taVar2 = (ta) this.f10638b.remove();
            tb tbVar3 = (tb) this.f10637a.get(taVar2);
            m13823a("Evicting interstitial queue for %s.", taVar2);
            while (tbVar3.m13880d() > 0) {
                C3277a a2 = tbVar3.m13874a(null);
                if (a2.f10678e) {
                    tc.m13885a().m13888c();
                }
                a2.f10674a.zzcm();
            }
            this.f10637a.remove(taVar2);
        }
        while (tbVar.m13880d() > 0) {
            C3277a a3 = tbVar.m13874a(d);
            if (!a3.f10678e || zzw.zzcS().mo3360a() - a3.f10677d <= 1000 * ((long) ((Integer) qb.bc.m13225c()).intValue())) {
                String str2 = a3.f10675b != null ? " (inline) " : " ";
                m13823a(new StringBuilder(String.valueOf(str2).length() + 34).append("Pooled interstitial").append(str2).append("returned at %s.").toString(), taVar);
                return a3;
            }
            m13823a("Expired interstitial at %s.", taVar);
            tc.m13885a().m13887b();
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m13833a() {
        /*
        r9 = this;
        r8 = 2;
        r0 = r9.f10639c;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r0 = r9.f10637a;
        r0 = r0.entrySet();
        r4 = r0.iterator();
    L_0x0010:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x0088;
    L_0x0016:
        r0 = r4.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (com.google.android.gms.internal.ta) r1;
        r0 = r0.getValue();
        r0 = (com.google.android.gms.internal.tb) r0;
        r2 = com.google.android.gms.internal.aad.m8420a(r8);
        if (r2 == 0) goto L_0x0056;
    L_0x002e:
        r2 = r0.m13880d();
        r3 = r0.m13881e();
        if (r3 >= r2) goto L_0x0056;
    L_0x0038:
        r5 = "Loading %s/%s pooled interstitials for %s.";
        r6 = 3;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r3 = r2 - r3;
        r3 = java.lang.Integer.valueOf(r3);
        r6[r7] = r3;
        r3 = 1;
        r2 = java.lang.Integer.valueOf(r2);
        r6[r3] = r2;
        r6[r8] = r1;
        r2 = java.lang.String.format(r5, r6);
        com.google.android.gms.internal.zh.m15051a(r2);
    L_0x0056:
        r2 = r0.m13882f();
        r2 = r2 + 0;
        r3 = r2;
    L_0x005d:
        r5 = r0.m13880d();
        r2 = com.google.android.gms.internal.qb.bb;
        r2 = r2.m13225c();
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        if (r5 >= r2) goto L_0x0080;
    L_0x006f:
        r2 = "Pooling and loading one new interstitial for %s.";
        m13823a(r2, r1);
        r2 = r9.f10639c;
        r2 = r0.m13877a(r2);
        if (r2 == 0) goto L_0x005d;
    L_0x007c:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x005d;
    L_0x0080:
        r0 = com.google.android.gms.internal.tc.m13885a();
        r0.m13886a(r3);
        goto L_0x0010;
    L_0x0088:
        r9.m13835b();
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.sy.a():void");
    }

    void m13834a(sv svVar) {
        if (this.f10639c == null) {
            this.f10639c = svVar.m13767b();
            m13837c();
        }
    }

    void m13835b() {
        if (this.f10639c != null) {
            Editor edit = this.f10639c.m13764a().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
            edit.clear();
            for (Entry entry : this.f10637a.entrySet()) {
                ta taVar = (ta) entry.getKey();
                tb tbVar = (tb) entry.getValue();
                if (tbVar.m13884h()) {
                    edit.putString(taVar.toString(), new te(tbVar).m13900a());
                    m13823a("Saved interstitial queue for %s.", taVar);
                }
            }
            edit.putString("PoolKeys", m13831e());
            edit.apply();
        }
    }

    void m13836b(zzec com_google_android_gms_internal_zzec, String str) {
        if (this.f10639c != null) {
            int i = new C3435a(this.f10639c.m13764a()).m14763a().f11406m;
            zzec d = m13829d(com_google_android_gms_internal_zzec);
            String a = m13820a(str);
            ta taVar = new ta(d, a, i);
            tb tbVar = (tb) this.f10637a.get(taVar);
            if (tbVar == null) {
                m13823a("Interstitial pool created at %s.", taVar);
                tbVar = new tb(d, a, i);
                this.f10637a.put(taVar, tbVar);
            }
            tbVar.m13876a(this.f10639c, com_google_android_gms_internal_zzec);
            tbVar.m13883g();
            m13823a("Inline entry added to the queue at %s.", taVar);
        }
    }

    void m13837c() {
        Throwable e;
        if (this.f10639c != null) {
            SharedPreferences sharedPreferences = this.f10639c.m13764a().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
            m13838d();
            try {
                Map hashMap = new HashMap();
                for (Entry entry : sharedPreferences.getAll().entrySet()) {
                    if (!((String) entry.getKey()).equals("PoolKeys")) {
                        te a = te.m13899a((String) entry.getValue());
                        ta taVar = new ta(a.f10698a, a.f10699b, a.f10700c);
                        if (!this.f10637a.containsKey(taVar)) {
                            this.f10637a.put(taVar, new tb(a.f10698a, a.f10699b, a.f10700c));
                            hashMap.put(taVar.toString(), taVar);
                            m13823a("Restored interstitial queue for %s.", taVar);
                        }
                    }
                }
                for (Object obj : m13825b(sharedPreferences.getString("PoolKeys", ""))) {
                    ta taVar2 = (ta) hashMap.get(obj);
                    if (this.f10637a.containsKey(taVar2)) {
                        this.f10638b.add(taVar2);
                    }
                }
            } catch (RuntimeException e2) {
                e = e2;
                zzw.zzcQ().m15000a(e, "InterstitialAdPool.restore");
                aad.m8424c("Malformed preferences value for InterstitialAdPool.", e);
                this.f10637a.clear();
                this.f10638b.clear();
            } catch (IOException e3) {
                e = e3;
                zzw.zzcQ().m15000a(e, "InterstitialAdPool.restore");
                aad.m8424c("Malformed preferences value for InterstitialAdPool.", e);
                this.f10637a.clear();
                this.f10638b.clear();
            }
        }
    }

    void m13838d() {
        while (this.f10638b.size() > 0) {
            ta taVar = (ta) this.f10638b.remove();
            tb tbVar = (tb) this.f10637a.get(taVar);
            m13823a("Flushing interstitial queue for %s.", taVar);
            while (tbVar.m13880d() > 0) {
                tbVar.m13874a(null).f10674a.zzcm();
            }
            this.f10637a.remove(taVar);
        }
    }
}
