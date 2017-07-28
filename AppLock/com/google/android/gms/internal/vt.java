package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.aau.C2340a;
import com.google.android.gms.internal.vs.C2360a;
import com.google.android.gms.internal.yy.C3457a;

@wh
public class vt extends vq implements C2340a {
    vt(Context context, C3457a c3457a, aat com_google_android_gms_internal_aat, C2360a c2360a) {
        super(context, c3457a, com_google_android_gms_internal_aat, c2360a);
    }

    protected void mo4171b() {
        if (this.e.f12039e == -2) {
            this.c.mo3424l().m8547a((C2340a) this);
            mo4173c();
            aad.m8421b("Loading HTML in WebView.");
            this.c.loadDataWithBaseURL(this.e.f12036b, this.e.f12037c, "text/html", "UTF-8", null);
        }
    }

    protected void mo4173c() {
    }
}
