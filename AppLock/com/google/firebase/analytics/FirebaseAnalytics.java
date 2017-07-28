package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.annotation.Size;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.dk;
import com.google.android.gms.p004b.C2428e;

@Keep
public final class FirebaseAnalytics {
    private final dk zzbqb;

    public static class C3516a {
    }

    public static class C3520b {
    }

    public static class C3522c {
    }

    public FirebaseAnalytics(dk dkVar) {
        C2513c.m7932a((Object) dkVar);
        this.zzbqb = dkVar;
    }

    @Keep
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    public static FirebaseAnalytics getInstance(Context context) {
        return dk.m9976a(context).m10042n();
    }

    public C2428e<String> getAppInstanceId() {
        return this.zzbqb.m10040l().m10172y();
    }

    public void logEvent(@Size(max = 40, min = 1) @NonNull String str, Bundle bundle) {
        this.zzbqb.m10041m().logEvent(str, bundle);
    }

    public void setAnalyticsCollectionEnabled(boolean z) {
        this.zzbqb.m10041m().setMeasurementEnabled(z);
    }

    @Keep
    @MainThread
    public void setCurrentScreen(@NonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) {
        this.zzbqb.m10049u().m10182a(activity, str, str2);
    }

    public void setMinimumSessionDuration(long j) {
        this.zzbqb.m10041m().setMinimumSessionDuration(j);
    }

    public void setSessionTimeoutDuration(long j) {
        this.zzbqb.m10041m().setSessionTimeoutDuration(j);
    }

    public void setUserId(String str) {
        this.zzbqb.m10041m().setUserId(str);
    }

    public void setUserProperty(@Size(max = 24, min = 1) @NonNull String str, @Nullable @Size(max = 36) String str2) {
        this.zzbqb.m10041m().setUserProperty(str, str2);
    }
}
