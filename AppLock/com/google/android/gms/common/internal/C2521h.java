package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.C2315a.C2307b;

public class C2521h {
    private final Resources f7425a;
    private final String f7426b = this.f7425a.getResourcePackageName(C2307b.common_google_play_services_unknown_issue);

    public C2521h(Context context) {
        C2513c.m7932a((Object) context);
        this.f7425a = context.getResources();
    }

    public String m8011a(String str) {
        int identifier = this.f7425a.getIdentifier(str, "string", this.f7426b);
        return identifier == 0 ? null : this.f7425a.getString(identifier);
    }
}
