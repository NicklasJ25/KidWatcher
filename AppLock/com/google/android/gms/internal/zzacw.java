package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2513c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class zzacw extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Creator<zzacw> CREATOR = new bd();
    final int f11780a;
    private final HashMap<String, Map<String, com.google.android.gms.internal.zzacs.zza<?, ?>>> f11781b;
    private final ArrayList<zza> f11782c = null;
    private final String f11783d;

    public static class zza extends com.google.android.gms.common.internal.safeparcel.zza {
        public static final Creator<zza> CREATOR = new be();
        final int f11774a;
        final String f11775b;
        final ArrayList<zzb> f11776c;

        zza(int i, String str, ArrayList<zzb> arrayList) {
            this.f11774a = i;
            this.f11775b = str;
            this.f11776c = arrayList;
        }

        zza(String str, Map<String, com.google.android.gms.internal.zzacs.zza<?, ?>> map) {
            this.f11774a = 1;
            this.f11775b = str;
            this.f11776c = m15322a(map);
        }

        private static ArrayList<zzb> m15322a(Map<String, com.google.android.gms.internal.zzacs.zza<?, ?>> map) {
            if (map == null) {
                return null;
            }
            ArrayList<zzb> arrayList = new ArrayList();
            for (String str : map.keySet()) {
                arrayList.add(new zzb(str, (com.google.android.gms.internal.zzacs.zza) map.get(str)));
            }
            return arrayList;
        }

        HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> m15323a() {
            HashMap<String, com.google.android.gms.internal.zzacs.zza<?, ?>> hashMap = new HashMap();
            int size = this.f11776c.size();
            for (int i = 0; i < size; i++) {
                zzb com_google_android_gms_internal_zzacw_zzb = (zzb) this.f11776c.get(i);
                hashMap.put(com_google_android_gms_internal_zzacw_zzb.f11778b, com_google_android_gms_internal_zzacw_zzb.f11779c);
            }
            return hashMap;
        }

        public void writeToParcel(Parcel parcel, int i) {
            be.m9103a(this, parcel, i);
        }
    }

    public static class zzb extends com.google.android.gms.common.internal.safeparcel.zza {
        public static final Creator<zzb> CREATOR = new bc();
        final int f11777a;
        final String f11778b;
        final com.google.android.gms.internal.zzacs.zza<?, ?> f11779c;

        zzb(int i, String str, com.google.android.gms.internal.zzacs.zza<?, ?> com_google_android_gms_internal_zzacs_zza___) {
            this.f11777a = i;
            this.f11778b = str;
            this.f11779c = com_google_android_gms_internal_zzacs_zza___;
        }

        zzb(String str, com.google.android.gms.internal.zzacs.zza<?, ?> com_google_android_gms_internal_zzacs_zza___) {
            this.f11777a = 1;
            this.f11778b = str;
            this.f11779c = com_google_android_gms_internal_zzacs_zza___;
        }

        public void writeToParcel(Parcel parcel, int i) {
            bc.m9097a(this, parcel, i);
        }
    }

    zzacw(int i, ArrayList<zza> arrayList, String str) {
        this.f11780a = i;
        this.f11781b = m15324a((ArrayList) arrayList);
        this.f11783d = (String) C2513c.m7932a((Object) str);
        m15326a();
    }

    private static HashMap<String, Map<String, com.google.android.gms.internal.zzacs.zza<?, ?>>> m15324a(ArrayList<zza> arrayList) {
        HashMap<String, Map<String, com.google.android.gms.internal.zzacs.zza<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zza com_google_android_gms_internal_zzacw_zza = (zza) arrayList.get(i);
            hashMap.put(com_google_android_gms_internal_zzacw_zza.f11775b, com_google_android_gms_internal_zzacw_zza.m15323a());
        }
        return hashMap;
    }

    public Map<String, com.google.android.gms.internal.zzacs.zza<?, ?>> m15325a(String str) {
        return (Map) this.f11781b.get(str);
    }

    public void m15326a() {
        for (String str : this.f11781b.keySet()) {
            Map map = (Map) this.f11781b.get(str);
            for (String str2 : map.keySet()) {
                ((com.google.android.gms.internal.zzacs.zza) map.get(str2)).m15298a(this);
            }
        }
    }

    ArrayList<zza> m15327b() {
        ArrayList<zza> arrayList = new ArrayList();
        for (String str : this.f11781b.keySet()) {
            arrayList.add(new zza(str, (Map) this.f11781b.get(str)));
        }
        return arrayList;
    }

    public String m15328c() {
        return this.f11783d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.f11781b.keySet()) {
            stringBuilder.append(str).append(":\n");
            Map map = (Map) this.f11781b.get(str);
            for (String str2 : map.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(map.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        bd.m9100a(this, parcel, i);
    }
}
