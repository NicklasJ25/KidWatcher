package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.internal.gn;
import com.google.android.gms.internal.jq.C3008a;
import java.util.List;

public class zzc extends zza {
    public static final Creator<zzc> CREATOR = new C3555b();
    final zzf f12176a;
    final int f12177b;
    final List<String> f12178c;
    final boolean f12179d;
    final String f12180e;
    final String f12181f;

    public zzc(gn gnVar, C3008a c3008a, List<String> list, boolean z, String str, String str2) {
        int i;
        switch (c3008a) {
            case DEBUG:
                i = 1;
                break;
            case INFO:
                i = 2;
                break;
            case WARN:
                i = 3;
                break;
            case ERROR:
                i = 4;
                break;
            default:
                i = 0;
                break;
        }
        this.f12176a = zzf.m15569a(gnVar);
        this.f12177b = i;
        this.f12178c = list;
        this.f12179d = z;
        this.f12180e = str;
        this.f12181f = str2;
    }

    public zzc(zzf com_google_firebase_database_connection_idl_zzf, int i, List<String> list, boolean z, String str, String str2) {
        this.f12176a = com_google_firebase_database_connection_idl_zzf;
        this.f12177b = i;
        this.f12178c = list;
        this.f12179d = z;
        this.f12180e = str;
        this.f12181f = str2;
    }

    public C3008a m15566a() {
        switch (this.f12177b) {
            case 0:
                return C3008a.NONE;
            case 1:
                return C3008a.DEBUG;
            case 2:
                return C3008a.INFO;
            case 3:
                return C3008a.WARN;
            case 4:
                return C3008a.ERROR;
            default:
                return C3008a.NONE;
        }
    }

    public List<String> m15567b() {
        return this.f12178c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3555b.m15514a(this, parcel, i);
    }
}
