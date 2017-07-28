package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.C2512b;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class ConnectionResult extends zza {
    public static final int API_UNAVAILABLE = 16;
    public static final int CANCELED = 13;
    public static final Creator<ConnectionResult> CREATOR = new C2493i();
    public static final int DEVELOPER_ERROR = 10;
    @Deprecated
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int RESTRICTED_PROFILE = 20;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UPDATING = 18;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 17;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    public static final ConnectionResult zzayj = new ConnectionResult(0);
    final int f7254a;
    private final int f7255b;
    private final PendingIntent f7256c;
    private final String f7257d;

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f7254a = i;
        this.f7255b = i2;
        this.f7256c = pendingIntent;
        this.f7257d = str;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    static String m7711a(int i) {
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            case 13:
                return "CANCELED";
            case 14:
                return "TIMEOUT";
            case 15:
                return "INTERRUPTED";
            case 16:
                return "API_UNAVAILABLE";
            case 17:
                return "SIGN_IN_FAILED";
            case 18:
                return "SERVICE_UPDATING";
            case 19:
                return "SERVICE_MISSING_PERMISSION";
            case 20:
                return "RESTRICTED_PROFILE";
            case 21:
                return "API_VERSION_UPDATE_REQUIRED";
            case 99:
                return "UNFINISHED";
            case DRIVE_EXTERNAL_STORAGE_REQUIRED /*1500*/:
                return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
            default:
                return "UNKNOWN_ERROR_CODE(" + i + ")";
        }
    }

    public boolean m7712a() {
        return (this.f7255b == 0 || this.f7256c == null) ? false : true;
    }

    public boolean m7713b() {
        return this.f7255b == 0;
    }

    public int m7714c() {
        return this.f7255b;
    }

    @Nullable
    public PendingIntent m7715d() {
        return this.f7256c;
    }

    @Nullable
    public String m7716e() {
        return this.f7257d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f7255b == connectionResult.f7255b && C2512b.m7931a(this.f7256c, connectionResult.f7256c) && C2512b.m7931a(this.f7257d, connectionResult.f7257d);
    }

    public int hashCode() {
        return C2512b.m7929a(Integer.valueOf(this.f7255b), this.f7256c, this.f7257d);
    }

    public String toString() {
        return C2512b.m7930a((Object) this).m7928a("statusCode", m7711a(this.f7255b)).m7928a("resolution", this.f7256c).m7928a("message", this.f7257d).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2493i.m7878a(this, parcel, i);
    }
}
