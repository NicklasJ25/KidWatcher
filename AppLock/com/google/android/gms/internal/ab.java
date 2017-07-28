package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.C2315a.C2307b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.C2521h;
import com.google.android.gms.common.internal.ac;

@Deprecated
public final class ab {
    private static final Object f7773a = new Object();
    private static ab f7774b;
    private final String f7775c;
    private final Status f7776d;
    private final boolean f7777e;
    private final boolean f7778f;

    ab(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(C2307b.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            boolean z2 = resources.getInteger(identifier) != 0;
            if (z2) {
                z = false;
            }
            this.f7778f = z;
            z = z2;
        } else {
            this.f7778f = false;
        }
        this.f7777e = z;
        Object a = ac.m7925a(context);
        if (a == null) {
            a = new C2521h(context).m8011a("google_app_id");
        }
        if (TextUtils.isEmpty(a)) {
            this.f7776d = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f7775c = null;
            return;
        }
        this.f7775c = a;
        this.f7776d = Status.zzazx;
    }

    public static Status m8739a(Context context) {
        Status status;
        C2513c.m7933a((Object) context, (Object) "Context must not be null.");
        synchronized (f7773a) {
            if (f7774b == null) {
                f7774b = new ab(context);
            }
            status = f7774b.f7776d;
        }
        return status;
    }

    private static ab m8740a(String str) {
        ab abVar;
        synchronized (f7773a) {
            if (f7774b == null) {
                throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 34).append("Initialize must be called before ").append(str).append(".").toString());
            }
            abVar = f7774b;
        }
        return abVar;
    }

    public static String m8741a() {
        return m8740a("getGoogleAppId").f7775c;
    }

    public static boolean m8742b() {
        return m8740a("isMeasurementExplicitlyDisabled").f7778f;
    }
}
