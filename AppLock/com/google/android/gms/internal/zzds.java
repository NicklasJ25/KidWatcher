package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

@wh
public class zzds extends zza {
    public static final Creator<zzds> CREATOR = new nu();
    @Nullable
    public final String f11870a;
    public final long f11871b;
    public final String f11872c;
    public final String f11873d;
    public final String f11874e;
    public final Bundle f11875f;
    public final boolean f11876g;

    zzds(@Nullable String str, long j, String str2, String str3, String str4, Bundle bundle, boolean z) {
        this.f11870a = str;
        this.f11871b = j;
        if (str2 == null) {
            str2 = "";
        }
        this.f11872c = str2;
        if (str3 == null) {
            str3 = "";
        }
        this.f11873d = str3;
        if (str4 == null) {
            str4 = "";
        }
        this.f11874e = str4;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f11875f = bundle;
        this.f11876g = z;
    }

    @Nullable
    public static zzds m15378a(Uri uri) {
        Throwable e;
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                aad.m8426e("Expected 2 path parts for namespace and id, found :" + pathSegments.size());
                return null;
            }
            String str = (String) pathSegments.get(0);
            String str2 = (String) pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long parseLong = queryParameter2 == null ? 0 : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            for (String queryParameter22 : zzw.zzcO().mo4251a(uri)) {
                if (queryParameter22.startsWith("tag.")) {
                    bundle.putString(queryParameter22.substring("tag.".length()), uri.getQueryParameter(queryParameter22));
                }
            }
            return new zzds(queryParameter, parseLong, host, str, str2, bundle, equals);
        } catch (NullPointerException e2) {
            e = e2;
            aad.m8424c("Unable to parse Uri into cache offering.", e);
            return null;
        } catch (NumberFormatException e3) {
            e = e3;
            aad.m8424c("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    @Nullable
    public static zzds m15379a(String str) {
        return m15378a(Uri.parse(str));
    }

    public void writeToParcel(Parcel parcel, int i) {
        nu.m12859a(this, parcel, i);
    }
}
