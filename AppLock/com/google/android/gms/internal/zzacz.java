package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.safeparcel.C2551a;
import com.google.android.gms.common.internal.safeparcel.C2551a.C2550a;
import com.google.android.gms.common.internal.safeparcel.C2552b;
import com.google.android.gms.common.util.C2577b;
import com.google.android.gms.common.util.C2578c;
import com.google.android.gms.common.util.C2587l;
import com.google.android.gms.common.util.C2588m;
import com.google.android.gms.internal.zzacs.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzacz extends zzact {
    public static final Creator<zzacz> CREATOR = new bg();
    private final int f11784a;
    private final Parcel f11785b;
    private final int f11786c = 2;
    private final zzacw f11787d;
    private final String f11788e;
    private int f11789f;
    private int f11790g;

    zzacz(int i, Parcel parcel, zzacw com_google_android_gms_internal_zzacw) {
        this.f11784a = i;
        this.f11785b = (Parcel) C2513c.m7932a((Object) parcel);
        this.f11787d = com_google_android_gms_internal_zzacw;
        if (this.f11787d == null) {
            this.f11788e = null;
        } else {
            this.f11788e = this.f11787d.m15328c();
        }
        this.f11789f = 2;
    }

    private static SparseArray<Entry<String, zza<?, ?>>> m15329a(Map<String, zza<?, ?>> map) {
        SparseArray<Entry<String, zza<?, ?>>> sparseArray = new SparseArray();
        for (Entry entry : map.entrySet()) {
            sparseArray.put(((zza) entry.getValue()).m15304g(), entry);
        }
        return sparseArray;
    }

    public static HashMap<String, String> m15330a(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    private void m15331a(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                stringBuilder.append(obj);
                return;
            case 7:
                stringBuilder.append("\"").append(C2587l.m8303a(obj.toString())).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(C2578c.m8270a((byte[]) obj)).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(C2578c.m8271b((byte[]) obj));
                stringBuilder.append("\"");
                return;
            case 10:
                C2588m.m8304a(stringBuilder, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void m15332a(StringBuilder stringBuilder, zza<?, ?> com_google_android_gms_internal_zzacs_zza___, Parcel parcel, int i) {
        switch (com_google_android_gms_internal_zzacs_zza___.m15301d()) {
            case 0:
                m15333a(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, m15312a(com_google_android_gms_internal_zzacs_zza___, Integer.valueOf(C2551a.m8105d(parcel, i))));
                return;
            case 1:
                m15333a(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, m15312a(com_google_android_gms_internal_zzacs_zza___, C2551a.m8109h(parcel, i)));
                return;
            case 2:
                m15333a(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, m15312a(com_google_android_gms_internal_zzacs_zza___, Long.valueOf(C2551a.m8107f(parcel, i))));
                return;
            case 3:
                m15333a(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, m15312a(com_google_android_gms_internal_zzacs_zza___, Float.valueOf(C2551a.m8110i(parcel, i))));
                return;
            case 4:
                m15333a(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, m15312a(com_google_android_gms_internal_zzacs_zza___, Double.valueOf(C2551a.m8112k(parcel, i))));
                return;
            case 5:
                m15333a(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, m15312a(com_google_android_gms_internal_zzacs_zza___, C2551a.m8114m(parcel, i)));
                return;
            case 6:
                m15333a(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, m15312a(com_google_android_gms_internal_zzacs_zza___, Boolean.valueOf(C2551a.m8104c(parcel, i))));
                return;
            case 7:
                m15333a(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, m15312a(com_google_android_gms_internal_zzacs_zza___, C2551a.m8115n(parcel, i)));
                return;
            case 8:
            case 9:
                m15333a(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, m15312a(com_google_android_gms_internal_zzacs_zza___, C2551a.m8118q(parcel, i)));
                return;
            case 10:
                m15333a(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, m15312a(com_google_android_gms_internal_zzacs_zza___, m15330a(C2551a.m8117p(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + com_google_android_gms_internal_zzacs_zza___.m15301d());
        }
    }

    private void m15333a(StringBuilder stringBuilder, zza<?, ?> com_google_android_gms_internal_zzacs_zza___, Object obj) {
        if (com_google_android_gms_internal_zzacs_zza___.m15300c()) {
            m15334a(stringBuilder, (zza) com_google_android_gms_internal_zzacs_zza___, (ArrayList) obj);
        } else {
            m15331a(stringBuilder, com_google_android_gms_internal_zzacs_zza___.m15299b(), obj);
        }
    }

    private void m15334a(StringBuilder stringBuilder, zza<?, ?> com_google_android_gms_internal_zzacs_zza___, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            m15331a(stringBuilder, com_google_android_gms_internal_zzacs_zza___.m15299b(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    private void m15335a(StringBuilder stringBuilder, String str, zza<?, ?> com_google_android_gms_internal_zzacs_zza___, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (com_google_android_gms_internal_zzacs_zza___.m15307j()) {
            m15332a(stringBuilder, com_google_android_gms_internal_zzacs_zza___, parcel, i);
        } else {
            m15337b(stringBuilder, com_google_android_gms_internal_zzacs_zza___, parcel, i);
        }
    }

    private void m15336a(StringBuilder stringBuilder, Map<String, zza<?, ?>> map, Parcel parcel) {
        SparseArray a = m15329a((Map) map);
        stringBuilder.append('{');
        int b = C2551a.m8100b(parcel);
        Object obj = null;
        while (parcel.dataPosition() < b) {
            int a2 = C2551a.m8095a(parcel);
            Entry entry = (Entry) a.get(C2551a.m8094a(a2));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                m15335a(stringBuilder, (String) entry.getKey(), (zza) entry.getValue(), parcel, a2);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new C2550a("Overread allowed size end=" + b, parcel);
        }
        stringBuilder.append('}');
    }

    private void m15337b(StringBuilder stringBuilder, zza<?, ?> com_google_android_gms_internal_zzacs_zza___, Parcel parcel, int i) {
        if (com_google_android_gms_internal_zzacs_zza___.m15302e()) {
            stringBuilder.append("[");
            switch (com_google_android_gms_internal_zzacs_zza___.m15301d()) {
                case 0:
                    C2577b.m8265a(stringBuilder, C2551a.m8121t(parcel, i));
                    break;
                case 1:
                    C2577b.m8267a(stringBuilder, C2551a.m8123v(parcel, i));
                    break;
                case 2:
                    C2577b.m8266a(stringBuilder, C2551a.m8122u(parcel, i));
                    break;
                case 3:
                    C2577b.m8264a(stringBuilder, C2551a.m8124w(parcel, i));
                    break;
                case 4:
                    C2577b.m8263a(stringBuilder, C2551a.m8125x(parcel, i));
                    break;
                case 5:
                    C2577b.m8267a(stringBuilder, C2551a.m8126y(parcel, i));
                    break;
                case 6:
                    C2577b.m8269a(stringBuilder, C2551a.m8120s(parcel, i));
                    break;
                case 7:
                    C2577b.m8268a(stringBuilder, C2551a.m8127z(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] C = C2551a.m8093C(parcel, i);
                    int length = C.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        C[i2].setDataPosition(0);
                        m15336a(stringBuilder, com_google_android_gms_internal_zzacs_zza___.m15309l(), C[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (com_google_android_gms_internal_zzacs_zza___.m15301d()) {
            case 0:
                stringBuilder.append(C2551a.m8105d(parcel, i));
                return;
            case 1:
                stringBuilder.append(C2551a.m8109h(parcel, i));
                return;
            case 2:
                stringBuilder.append(C2551a.m8107f(parcel, i));
                return;
            case 3:
                stringBuilder.append(C2551a.m8110i(parcel, i));
                return;
            case 4:
                stringBuilder.append(C2551a.m8112k(parcel, i));
                return;
            case 5:
                stringBuilder.append(C2551a.m8114m(parcel, i));
                return;
            case 6:
                stringBuilder.append(C2551a.m8104c(parcel, i));
                return;
            case 7:
                stringBuilder.append("\"").append(C2587l.m8303a(C2551a.m8115n(parcel, i))).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(C2578c.m8270a(C2551a.m8118q(parcel, i))).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(C2578c.m8271b(C2551a.m8118q(parcel, i)));
                stringBuilder.append("\"");
                return;
            case 10:
                Bundle p = C2551a.m8117p(parcel, i);
                Set<String> keySet = p.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(C2587l.m8303a(p.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
                return;
            case 11:
                Parcel B = C2551a.m8092B(parcel, i);
                B.setDataPosition(0);
                m15336a(stringBuilder, com_google_android_gms_internal_zzacs_zza___.m15309l(), B);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    public Object mo4273a(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Map<String, zza<?, ?>> mo4275a() {
        return this.f11787d == null ? null : this.f11787d.m15325a(this.f11788e);
    }

    public int m15340b() {
        return this.f11784a;
    }

    public boolean mo4274b(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Parcel m15342c() {
        switch (this.f11789f) {
            case 0:
                this.f11790g = C2552b.m8128a(this.f11785b);
                C2552b.m8129a(this.f11785b, this.f11790g);
                this.f11789f = 2;
                break;
            case 1:
                C2552b.m8129a(this.f11785b, this.f11790g);
                this.f11789f = 2;
                break;
        }
        return this.f11785b;
    }

    zzacw m15343d() {
        switch (this.f11786c) {
            case 0:
                return null;
            case 1:
                return this.f11787d;
            case 2:
                return this.f11787d;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.f11786c);
        }
    }

    public String toString() {
        C2513c.m7933a(this.f11787d, (Object) "Cannot convert to JSON on client side.");
        Parcel c = m15342c();
        c.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        m15336a(stringBuilder, this.f11787d.m15325a(this.f11788e), c);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        bg.m9108a(this, parcel, i);
    }
}
