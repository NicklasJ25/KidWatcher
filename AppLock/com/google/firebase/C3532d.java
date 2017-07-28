package com.google.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C2512b;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.C2521h;
import com.google.android.gms.common.util.C2592q;

public final class C3532d {
    private final String f12139a;
    private final String f12140b;
    private final String f12141c;
    private final String f12142d;
    private final String f12143e;
    private final String f12144f;

    private C3532d(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        C2513c.m7938a(!C2592q.m8321a(str), (Object) "ApplicationId must be set.");
        this.f12140b = str;
        this.f12139a = str2;
        this.f12141c = str3;
        this.f12142d = str4;
        this.f12143e = str5;
        this.f12144f = str6;
    }

    public static C3532d m15448a(Context context) {
        C2521h c2521h = new C2521h(context);
        Object a = c2521h.m8011a("google_app_id");
        return TextUtils.isEmpty(a) ? null : new C3532d(a, c2521h.m8011a("google_api_key"), c2521h.m8011a("firebase_database_url"), c2521h.m8011a("ga_trackingId"), c2521h.m8011a("gcm_defaultSenderId"), c2521h.m8011a("google_storage_bucket"));
    }

    public String m15449a() {
        return this.f12139a;
    }

    public String m15450b() {
        return this.f12140b;
    }

    public String m15451c() {
        return this.f12141c;
    }

    public String m15452d() {
        return this.f12143e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C3532d)) {
            return false;
        }
        C3532d c3532d = (C3532d) obj;
        return C2512b.m7931a(this.f12140b, c3532d.f12140b) && C2512b.m7931a(this.f12139a, c3532d.f12139a) && C2512b.m7931a(this.f12141c, c3532d.f12141c) && C2512b.m7931a(this.f12142d, c3532d.f12142d) && C2512b.m7931a(this.f12143e, c3532d.f12143e) && C2512b.m7931a(this.f12144f, c3532d.f12144f);
    }

    public int hashCode() {
        return C2512b.m7929a(this.f12140b, this.f12139a, this.f12141c, this.f12142d, this.f12143e, this.f12144f);
    }

    public String toString() {
        return C2512b.m7930a((Object) this).m7928a("applicationId", this.f12140b).m7928a("apiKey", this.f12139a).m7928a("databaseUrl", this.f12141c).m7928a("gcmSenderId", this.f12143e).m7928a("storageBucket", this.f12144f).toString();
    }
}
