package com.google.android.gms.common.api;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C2456a.C2416a;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.internal.acd;
import java.util.ArrayList;

public class C2471m extends Exception {
    private final ArrayMap<acd<?>, ConnectionResult> f7293a;

    public C2471m(ArrayMap<acd<?>, ConnectionResult> arrayMap) {
        this.f7293a = arrayMap;
    }

    public ArrayMap<acd<?>, ConnectionResult> m7786a() {
        return this.f7293a;
    }

    public ConnectionResult m7787a(C2475n<? extends C2416a> c2475n) {
        acd b = c2475n.m7795b();
        C2513c.m7942b(this.f7293a.get(b) != null, "The given API was not part of the availability request.");
        return (ConnectionResult) this.f7293a.get(b);
    }

    public String getMessage() {
        Iterable arrayList = new ArrayList();
        Object obj = 1;
        for (acd com_google_android_gms_internal_acd : this.f7293a.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) this.f7293a.get(com_google_android_gms_internal_acd);
            if (connectionResult.m7713b()) {
                obj = null;
            }
            String valueOf = String.valueOf(com_google_android_gms_internal_acd.m8951a());
            String valueOf2 = String.valueOf(connectionResult);
            arrayList.add(new StringBuilder((String.valueOf(valueOf).length() + 2) + String.valueOf(valueOf2).length()).append(valueOf).append(": ").append(valueOf2).toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (obj != null) {
            stringBuilder.append("None of the queried APIs are available. ");
        } else {
            stringBuilder.append("Some of the queried APIs are unavailable. ");
        }
        stringBuilder.append(TextUtils.join("; ", arrayList));
        return stringBuilder.toString();
    }
}
