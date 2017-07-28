package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Iterator;

public class zzato extends zza implements Iterable<String> {
    public static final Creator<zzato> CREATOR = new cv();
    private final Bundle f11825a;

    class C35111 implements Iterator<String> {
        Iterator<String> f11823a = this.f11824b.f11825a.keySet().iterator();
        final /* synthetic */ zzato f11824b;

        C35111(zzato com_google_android_gms_internal_zzato) {
            this.f11824b = com_google_android_gms_internal_zzato;
        }

        public String m15349a() {
            return (String) this.f11823a.next();
        }

        public boolean hasNext() {
            return this.f11823a.hasNext();
        }

        public /* synthetic */ Object next() {
            return m15349a();
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }

    zzato(Bundle bundle) {
        this.f11825a = bundle;
    }

    public int m15351a() {
        return this.f11825a.size();
    }

    Object m15352a(String str) {
        return this.f11825a.get(str);
    }

    public Bundle m15353b() {
        return new Bundle(this.f11825a);
    }

    public Iterator<String> iterator() {
        return new C35111(this);
    }

    public String toString() {
        return this.f11825a.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        cv.m9653a(this, parcel, i);
    }
}
