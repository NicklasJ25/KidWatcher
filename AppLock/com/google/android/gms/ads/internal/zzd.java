package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzeg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

@wh
public class zzd {
    private static String m7489a(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            String a = obj == null ? "null" : obj instanceof Bundle ? m7489a((Bundle) obj) : obj.toString();
            stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }

    public static Object[] zza(String str, zzec com_google_android_gms_internal_zzec, String str2, int i, @Nullable zzeg com_google_android_gms_internal_zzeg) {
        Set hashSet = new HashSet(Arrays.asList(str.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        if (hashSet.contains("formatString")) {
            if (com_google_android_gms_internal_zzeg != null) {
                arrayList.add(com_google_android_gms_internal_zzeg.f11895a);
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(com_google_android_gms_internal_zzec.f11878b));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(m7489a(com_google_android_gms_internal_zzec.f11879c));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(com_google_android_gms_internal_zzec.f11880d));
        }
        if (hashSet.contains("keywords")) {
            if (com_google_android_gms_internal_zzec.f11881e != null) {
                arrayList.add(com_google_android_gms_internal_zzec.f11881e.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(com_google_android_gms_internal_zzec.f11882f));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(com_google_android_gms_internal_zzec.f11883g));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(com_google_android_gms_internal_zzec.f11884h));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(com_google_android_gms_internal_zzec.f11885i);
        }
        if (hashSet.contains("location")) {
            if (com_google_android_gms_internal_zzec.f11887k != null) {
                arrayList.add(com_google_android_gms_internal_zzec.f11887k.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(com_google_android_gms_internal_zzec.f11888l);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(m7489a(com_google_android_gms_internal_zzec.f11889m));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(m7489a(com_google_android_gms_internal_zzec.f11890n));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (com_google_android_gms_internal_zzec.f11891o != null) {
                arrayList.add(com_google_android_gms_internal_zzec.f11891o.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(com_google_android_gms_internal_zzec.f11892p);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(com_google_android_gms_internal_zzec.f11893q);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(com_google_android_gms_internal_zzec.f11894r));
        }
        return arrayList.toArray();
    }
}
