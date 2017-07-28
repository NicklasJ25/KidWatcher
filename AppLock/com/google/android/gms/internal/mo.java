package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.internal.mq.C3058a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;

@wh
public final class mo extends C3058a {
    private final ec f9845a;
    private final ed f9846b;
    private final cj f9847c;
    private boolean f9848d = false;

    public mo(String str, Context context, boolean z) {
        this.f9845a = ec.m10554a(str, context, z);
        this.f9846b = new ed(this.f9845a);
        this.f9847c = z ? null : cj.m9332b(context);
    }

    private C2309a m12581a(C2309a c2309a, C2309a c2309a2, boolean z) {
        try {
            Uri uri = (Uri) C2312b.m7328a(c2309a);
            Context context = (Context) C2312b.m7328a(c2309a2);
            return C2312b.m7327a(z ? this.f9846b.m10559a(uri, context) : this.f9846b.m10566b(uri, context));
        } catch (ee e) {
            return null;
        }
    }

    public C2309a mo3820a(C2309a c2309a, C2309a c2309a2) {
        return m12581a(c2309a, c2309a2, true);
    }

    public String mo3821a() {
        return "ms";
    }

    public String mo3822a(C2309a c2309a, String str) {
        return this.f9845a.m9312a((Context) C2312b.m7328a(c2309a), str);
    }

    public String mo3823a(C2309a c2309a, byte[] bArr) {
        Context context = (Context) C2312b.m7328a(c2309a);
        String a = this.f9845a.m9314a(context, bArr);
        if (this.f9847c == null || !this.f9848d) {
            return a;
        }
        String a2 = this.f9847c.m9334a(a, this.f9847c.m9314a(context, bArr));
        this.f9848d = false;
        return a2;
    }

    public void mo3824a(String str) {
        this.f9846b.m10563a(str);
    }

    public void mo3825a(String str, String str2) {
        this.f9846b.m10564a(str, str2);
    }

    public boolean mo3826a(C2309a c2309a) {
        return this.f9846b.m10565a((Uri) C2312b.m7328a(c2309a));
    }

    public boolean mo3827a(String str, boolean z) {
        if (this.f9847c == null) {
            return false;
        }
        this.f9847c.m9335a(new Info(str, z));
        this.f9848d = true;
        return true;
    }

    public C2309a mo3828b(C2309a c2309a, C2309a c2309a2) {
        return m12581a(c2309a, c2309a2, false);
    }

    public boolean mo3829b(C2309a c2309a) {
        return this.f9846b.m10568c((Uri) C2312b.m7328a(c2309a));
    }

    public String mo3830c(C2309a c2309a) {
        return mo3823a(c2309a, null);
    }

    public void mo3831d(C2309a c2309a) {
        this.f9846b.m10562a((MotionEvent) C2312b.m7328a(c2309a));
    }
}
