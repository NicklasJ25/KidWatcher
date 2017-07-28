package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@wh
public final class zzmk extends zza {
    public static final Creator<zzmk> CREATOR = new wn();
    public final long f11970A;
    public final zzmr f11971B;
    public final String f11972C;
    public final float f11973D;
    public final int f11974E;
    public final int f11975F;
    public final boolean f11976G;
    public final boolean f11977H;
    public final String f11978I;
    public final boolean f11979J;
    public final String f11980K;
    public final boolean f11981L;
    public final int f11982M;
    public final Bundle f11983N;
    public final String f11984O;
    @Nullable
    public final zzfc f11985P;
    public final boolean f11986Q;
    public final Bundle f11987R;
    @Nullable
    public final String f11988S;
    @Nullable
    public final String f11989T;
    @Nullable
    public final String f11990U;
    @Nullable
    public final boolean f11991V;
    public final int f11992a;
    @Nullable
    public final Bundle f11993b;
    public final zzec f11994c;
    public final zzeg f11995d;
    public final String f11996e;
    public final ApplicationInfo f11997f;
    @Nullable
    public final PackageInfo f11998g;
    public final String f11999h;
    public final String f12000i;
    public final String f12001j;
    public final zzqh f12002k;
    public final Bundle f12003l;
    public final int f12004m;
    public final List<String> f12005n;
    public final Bundle f12006o;
    public final boolean f12007p;
    public final int f12008q;
    public final int f12009r;
    public final float f12010s;
    public final String f12011t;
    public final long f12012u;
    public final String f12013v;
    @Nullable
    public final List<String> f12014w;
    public final String f12015x;
    public final zzhc f12016y;
    public final List<String> f12017z;

    @wh
    public static final class C3513a {
        public final float f11927A;
        public final boolean f11928B;
        public final int f11929C;
        public final int f11930D;
        public final boolean f11931E;
        public final boolean f11932F;
        public final Future<String> f11933G;
        public final String f11934H;
        public final boolean f11935I;
        public final int f11936J;
        public final Bundle f11937K;
        public final String f11938L;
        @Nullable
        public final zzfc f11939M;
        public final boolean f11940N;
        @Nullable
        public final Bundle f11941O;
        public final boolean f11942P;
        public final Future<String> f11943Q;
        @Nullable
        public final Bundle f11944a;
        public final zzec f11945b;
        public final zzeg f11946c;
        public final String f11947d;
        public final ApplicationInfo f11948e;
        @Nullable
        public final PackageInfo f11949f;
        public final String f11950g;
        public final String f11951h;
        public final Bundle f11952i;
        public final zzqh f11953j;
        public final int f11954k;
        public final List<String> f11955l;
        public final List<String> f11956m;
        public final Bundle f11957n;
        public final boolean f11958o;
        public final int f11959p;
        public final int f11960q;
        public final float f11961r;
        public final String f11962s;
        public final long f11963t;
        public final String f11964u;
        @Nullable
        public final List<String> f11965v;
        public final String f11966w;
        public final zzhc f11967x;
        public final Future<zzmr> f11968y;
        public final String f11969z;

        public C3513a(@Nullable Bundle bundle, zzec com_google_android_gms_internal_zzec, zzeg com_google_android_gms_internal_zzeg, String str, ApplicationInfo applicationInfo, @Nullable PackageInfo packageInfo, String str2, String str3, zzqh com_google_android_gms_internal_zzqh, Bundle bundle2, List<String> list, List<String> list2, Bundle bundle3, boolean z, int i, int i2, float f, String str4, long j, String str5, @Nullable List<String> list3, String str6, zzhc com_google_android_gms_internal_zzhc, Future<zzmr> future, String str7, float f2, boolean z2, int i3, int i4, boolean z3, boolean z4, Future<String> future2, String str8, boolean z5, int i5, Bundle bundle4, String str9, @Nullable zzfc com_google_android_gms_internal_zzfc, boolean z6, Bundle bundle5, boolean z7, Future<String> future3) {
            this.f11944a = bundle;
            this.f11945b = com_google_android_gms_internal_zzec;
            this.f11946c = com_google_android_gms_internal_zzeg;
            this.f11947d = str;
            this.f11948e = applicationInfo;
            this.f11949f = packageInfo;
            this.f11950g = str2;
            this.f11951h = str3;
            this.f11953j = com_google_android_gms_internal_zzqh;
            this.f11952i = bundle2;
            this.f11958o = z;
            this.f11959p = i;
            this.f11960q = i2;
            this.f11961r = f;
            if (list == null || list.size() <= 0) {
                this.f11954k = 0;
                this.f11955l = null;
                this.f11956m = null;
            } else {
                this.f11954k = 3;
                this.f11955l = list;
                this.f11956m = list2;
            }
            this.f11957n = bundle3;
            this.f11962s = str4;
            this.f11963t = j;
            this.f11964u = str5;
            this.f11965v = list3;
            this.f11966w = str6;
            this.f11967x = com_google_android_gms_internal_zzhc;
            this.f11968y = future;
            this.f11969z = str7;
            this.f11927A = f2;
            this.f11928B = z2;
            this.f11929C = i3;
            this.f11930D = i4;
            this.f11931E = z3;
            this.f11932F = z4;
            this.f11933G = future2;
            this.f11934H = str8;
            this.f11935I = z5;
            this.f11936J = i5;
            this.f11937K = bundle4;
            this.f11938L = str9;
            this.f11939M = com_google_android_gms_internal_zzfc;
            this.f11940N = z6;
            this.f11941O = bundle5;
            this.f11942P = z7;
            this.f11943Q = future3;
        }
    }

    zzmk(int i, Bundle bundle, zzec com_google_android_gms_internal_zzec, zzeg com_google_android_gms_internal_zzeg, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, zzqh com_google_android_gms_internal_zzqh, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, int i3, int i4, float f, String str5, long j, String str6, List<String> list2, String str7, zzhc com_google_android_gms_internal_zzhc, List<String> list3, long j2, zzmr com_google_android_gms_internal_zzmr, String str8, float f2, boolean z2, int i5, int i6, boolean z3, boolean z4, String str9, String str10, boolean z5, int i7, Bundle bundle4, String str11, zzfc com_google_android_gms_internal_zzfc, boolean z6, Bundle bundle5, String str12, String str13, String str14, boolean z7) {
        this.f11992a = i;
        this.f11993b = bundle;
        this.f11994c = com_google_android_gms_internal_zzec;
        this.f11995d = com_google_android_gms_internal_zzeg;
        this.f11996e = str;
        this.f11997f = applicationInfo;
        this.f11998g = packageInfo;
        this.f11999h = str2;
        this.f12000i = str3;
        this.f12001j = str4;
        this.f12002k = com_google_android_gms_internal_zzqh;
        this.f12003l = bundle2;
        this.f12004m = i2;
        this.f12005n = list;
        this.f12017z = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.f12006o = bundle3;
        this.f12007p = z;
        this.f12008q = i3;
        this.f12009r = i4;
        this.f12010s = f;
        this.f12011t = str5;
        this.f12012u = j;
        this.f12013v = str6;
        this.f12014w = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f12015x = str7;
        this.f12016y = com_google_android_gms_internal_zzhc;
        this.f11970A = j2;
        this.f11971B = com_google_android_gms_internal_zzmr;
        this.f11972C = str8;
        this.f11973D = f2;
        this.f11979J = z2;
        this.f11974E = i5;
        this.f11975F = i6;
        this.f11976G = z3;
        this.f11977H = z4;
        this.f11978I = str9;
        this.f11980K = str10;
        this.f11981L = z5;
        this.f11982M = i7;
        this.f11983N = bundle4;
        this.f11984O = str11;
        this.f11985P = com_google_android_gms_internal_zzfc;
        this.f11986Q = z6;
        this.f11987R = bundle5;
        this.f11988S = str12;
        this.f11989T = str13;
        this.f11990U = str14;
        this.f11991V = z7;
    }

    public zzmk(@Nullable Bundle bundle, zzec com_google_android_gms_internal_zzec, zzeg com_google_android_gms_internal_zzeg, String str, ApplicationInfo applicationInfo, @Nullable PackageInfo packageInfo, String str2, String str3, String str4, zzqh com_google_android_gms_internal_zzqh, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, int i2, int i3, float f, String str5, long j, String str6, @Nullable List<String> list3, String str7, zzhc com_google_android_gms_internal_zzhc, long j2, zzmr com_google_android_gms_internal_zzmr, String str8, float f2, boolean z2, int i4, int i5, boolean z3, boolean z4, String str9, String str10, boolean z5, int i6, Bundle bundle4, String str11, @Nullable zzfc com_google_android_gms_internal_zzfc, boolean z6, Bundle bundle5, String str12, String str13, String str14, boolean z7) {
        this(22, bundle, com_google_android_gms_internal_zzec, com_google_android_gms_internal_zzeg, str, applicationInfo, packageInfo, str2, str3, str4, com_google_android_gms_internal_zzqh, bundle2, i, list, bundle3, z, i2, i3, f, str5, j, str6, list3, str7, com_google_android_gms_internal_zzhc, list2, j2, com_google_android_gms_internal_zzmr, str8, f2, z2, i4, i5, z3, z4, str9, str10, z5, i6, bundle4, str11, com_google_android_gms_internal_zzfc, z6, bundle5, str12, str13, str14, z7);
    }

    public zzmk(C3513a c3513a, long j, String str, String str2, String str3) {
        this(c3513a.f11944a, c3513a.f11945b, c3513a.f11946c, c3513a.f11947d, c3513a.f11948e, c3513a.f11949f, (String) aai.m8443a(c3513a.f11943Q, "", 2, TimeUnit.SECONDS), c3513a.f11950g, c3513a.f11951h, c3513a.f11953j, c3513a.f11952i, c3513a.f11954k, c3513a.f11955l, c3513a.f11956m, c3513a.f11957n, c3513a.f11958o, c3513a.f11959p, c3513a.f11960q, c3513a.f11961r, c3513a.f11962s, c3513a.f11963t, c3513a.f11964u, c3513a.f11965v, c3513a.f11966w, c3513a.f11967x, j, c3513a.f11968y != null ? (zzmr) aai.m8443a(c3513a.f11968y, null, 6, TimeUnit.SECONDS) : null, c3513a.f11969z, c3513a.f11927A, c3513a.f11928B, c3513a.f11929C, c3513a.f11930D, c3513a.f11931E, c3513a.f11932F, (String) aai.m8443a(c3513a.f11933G, "", 1, TimeUnit.SECONDS), c3513a.f11934H, c3513a.f11935I, c3513a.f11936J, c3513a.f11937K, c3513a.f11938L, c3513a.f11939M, c3513a.f11940N, c3513a.f11941O, str, str2, str3, c3513a.f11942P);
    }

    public void writeToParcel(Parcel parcel, int i) {
        wn.m14534a(this, parcel, i);
    }
}
