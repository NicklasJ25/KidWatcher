package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Collections;
import java.util.List;

@wh
public final class zzmn extends zza {
    public static final Creator<zzmn> CREATOR = new wp();
    public final boolean f12018A;
    public final boolean f12019B;
    @Nullable
    public final zzoo f12020C;
    @Nullable
    public final List<String> f12021D;
    @Nullable
    public final List<String> f12022E;
    public final boolean f12023F;
    @Nullable
    public final zzmp f12024G;
    public final boolean f12025H;
    @Nullable
    public String f12026I;
    public final List<String> f12027J;
    public final boolean f12028K;
    @Nullable
    public final String f12029L;
    @Nullable
    public final zzor f12030M;
    @Nullable
    public final String f12031N;
    public final boolean f12032O;
    public final boolean f12033P;
    private zzmk f12034Q;
    public final int f12035a;
    public final String f12036b;
    public String f12037c;
    public final List<String> f12038d;
    public final int f12039e;
    public final List<String> f12040f;
    public final long f12041g;
    public final boolean f12042h;
    public final long f12043i;
    public final List<String> f12044j;
    public final long f12045k;
    public final int f12046l;
    public final String f12047m;
    public final long f12048n;
    public final String f12049o;
    public final boolean f12050p;
    public final String f12051q;
    public final String f12052r;
    public final boolean f12053s;
    public final boolean f12054t;
    public final boolean f12055u;
    public final boolean f12056v;
    public final boolean f12057w;
    public zzmv f12058x;
    public String f12059y;
    public final String f12060z;

    public zzmn(int i) {
        this(19, null, null, null, i, null, -1, false, -1, null, -1, -1, null, -1, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false);
    }

    public zzmn(int i, long j) {
        this(19, null, null, null, i, null, -1, false, -1, null, j, -1, null, -1, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false);
    }

    zzmn(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, zzmv com_google_android_gms_internal_zzmv, String str7, String str8, boolean z8, boolean z9, zzoo com_google_android_gms_internal_zzoo, List<String> list4, List<String> list5, boolean z10, zzmp com_google_android_gms_internal_zzmp, boolean z11, String str9, List<String> list6, boolean z12, String str10, zzor com_google_android_gms_internal_zzor, String str11, boolean z13, boolean z14) {
        this.f12035a = i;
        this.f12036b = str;
        this.f12037c = str2;
        this.f12038d = list != null ? Collections.unmodifiableList(list) : null;
        this.f12039e = i2;
        this.f12040f = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.f12041g = j;
        this.f12042h = z;
        this.f12043i = j2;
        this.f12044j = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.f12045k = j3;
        this.f12046l = i3;
        this.f12047m = str3;
        this.f12048n = j4;
        this.f12049o = str4;
        this.f12050p = z2;
        this.f12051q = str5;
        this.f12052r = str6;
        this.f12053s = z3;
        this.f12054t = z4;
        this.f12055u = z5;
        this.f12056v = z6;
        this.f12032O = z13;
        this.f12057w = z7;
        this.f12058x = com_google_android_gms_internal_zzmv;
        this.f12059y = str7;
        this.f12060z = str8;
        if (this.f12037c == null && this.f12058x != null) {
            zzmy com_google_android_gms_internal_zzmy = (zzmy) this.f12058x.m15391a(zzmy.CREATOR);
            if (!(com_google_android_gms_internal_zzmy == null || TextUtils.isEmpty(com_google_android_gms_internal_zzmy.m15392a()))) {
                this.f12037c = com_google_android_gms_internal_zzmy.m15392a();
            }
        }
        this.f12018A = z8;
        this.f12019B = z9;
        this.f12020C = com_google_android_gms_internal_zzoo;
        this.f12021D = list4;
        this.f12022E = list5;
        this.f12023F = z10;
        this.f12024G = com_google_android_gms_internal_zzmp;
        this.f12025H = z11;
        this.f12026I = str9;
        this.f12027J = list6;
        this.f12028K = z12;
        this.f12029L = str10;
        this.f12030M = com_google_android_gms_internal_zzor;
        this.f12031N = str11;
        this.f12033P = z14;
    }

    public zzmn(zzmk com_google_android_gms_internal_zzmk, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str6, boolean z7, boolean z8, zzoo com_google_android_gms_internal_zzoo, List<String> list4, List<String> list5, boolean z9, zzmp com_google_android_gms_internal_zzmp, boolean z10, String str7, List<String> list6, boolean z11, String str8, zzor com_google_android_gms_internal_zzor, String str9, boolean z12, boolean z13) {
        this(19, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, false, null, str5, z2, z3, z4, z5, z6, null, null, str6, z7, z8, com_google_android_gms_internal_zzoo, list4, list5, z9, com_google_android_gms_internal_zzmp, z10, str7, list6, z11, str8, com_google_android_gms_internal_zzor, str9, z12, z13);
        this.f12034Q = com_google_android_gms_internal_zzmk;
    }

    public zzmn(zzmk com_google_android_gms_internal_zzmk, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str7, boolean z8, boolean z9, zzoo com_google_android_gms_internal_zzoo, List<String> list4, List<String> list5, boolean z10, zzmp com_google_android_gms_internal_zzmp, boolean z11, String str8, List<String> list6, boolean z12, String str9, zzor com_google_android_gms_internal_zzor, String str10, boolean z13, boolean z14) {
        this(19, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, null, null, str7, z8, z9, com_google_android_gms_internal_zzoo, list4, list5, z10, com_google_android_gms_internal_zzmp, z11, str8, list6, z12, str9, com_google_android_gms_internal_zzor, str10, z13, z14);
        this.f12034Q = com_google_android_gms_internal_zzmk;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (!(this.f12034Q == null || this.f12034Q.f11992a < 9 || TextUtils.isEmpty(this.f12037c))) {
            this.f12058x = new zzmv(new zzmy(this.f12037c));
            this.f12037c = null;
        }
        wp.m14540a(this, parcel, i);
    }
}
