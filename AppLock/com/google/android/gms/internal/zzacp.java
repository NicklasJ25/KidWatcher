package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.internal.zzacs.C3510a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class zzacp extends com.google.android.gms.common.internal.safeparcel.zza implements C3510a<String, Integer> {
    public static final Creator<zzacp> CREATOR = new az();
    final int f11759a;
    private final HashMap<String, Integer> f11760b;
    private final SparseArray<String> f11761c;
    private final ArrayList<zza> f11762d;

    public static final class zza extends com.google.android.gms.common.internal.safeparcel.zza {
        public static final Creator<zza> CREATOR = new ba();
        final int f11756a;
        final String f11757b;
        final int f11758c;

        zza(int i, String str, int i2) {
            this.f11756a = i;
            this.f11757b = str;
            this.f11758c = i2;
        }

        zza(String str, int i) {
            this.f11756a = 1;
            this.f11757b = str;
            this.f11758c = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            ba.m9091a(this, parcel, i);
        }
    }

    public zzacp() {
        this.f11759a = 1;
        this.f11760b = new HashMap();
        this.f11761c = new SparseArray();
        this.f11762d = null;
    }

    zzacp(int i, ArrayList<zza> arrayList) {
        this.f11759a = i;
        this.f11760b = new HashMap();
        this.f11761c = new SparseArray();
        this.f11762d = null;
        m15290a((ArrayList) arrayList);
    }

    private void m15290a(ArrayList<zza> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zza com_google_android_gms_internal_zzacp_zza = (zza) it.next();
            m15291a(com_google_android_gms_internal_zzacp_zza.f11757b, com_google_android_gms_internal_zzacp_zza.f11758c);
        }
    }

    public zzacp m15291a(String str, int i) {
        this.f11760b.put(str, Integer.valueOf(i));
        this.f11761c.put(i, str);
        return this;
    }

    public /* synthetic */ Object mo4272a(Object obj) {
        return m15293a((Integer) obj);
    }

    public String m15293a(Integer num) {
        String str = (String) this.f11761c.get(num.intValue());
        return (str == null && this.f11760b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    ArrayList<zza> m15294a() {
        ArrayList<zza> arrayList = new ArrayList();
        for (String str : this.f11760b.keySet()) {
            arrayList.add(new zza(str, ((Integer) this.f11760b.get(str)).intValue()));
        }
        return arrayList;
    }

    public void writeToParcel(Parcel parcel, int i) {
        az.m9080a(this, parcel, i);
    }
}
