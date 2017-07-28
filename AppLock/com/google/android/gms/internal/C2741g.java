package com.google.android.gms.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import com.google.android.gms.common.C2481b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.internal.C3459z.C2884a;

public abstract class C2741g extends ae implements OnCancelListener {
    protected boolean f8180a;
    protected boolean f8181b;
    protected final C2481b f8182c;
    private ConnectionResult f8183e;
    private int f8184f;
    private final Handler f8185g;

    private class C2886a implements Runnable {
        final /* synthetic */ C2741g f8989a;

        private C2886a(C2741g c2741g) {
            this.f8989a = c2741g;
        }

        @MainThread
        public void run() {
            if (!this.f8989a.f8180a) {
                return;
            }
            if (this.f8989a.f8183e.m7712a()) {
                this.f8989a.d.startActivityForResult(GoogleApiActivity.m7722b(this.f8989a.m8962f(), this.f8989a.f8183e.m7715d(), this.f8989a.f8184f, false), 1);
            } else if (this.f8989a.f8182c.mo3317a(this.f8989a.f8183e.m7714c())) {
                this.f8989a.f8182c.m7834a(this.f8989a.m8962f(), this.f8989a.d, this.f8989a.f8183e.m7714c(), 2, this.f8989a);
            } else if (this.f8989a.f8183e.m7714c() == 18) {
                final Dialog a = this.f8989a.f8182c.m7823a(this.f8989a.m8962f(), this.f8989a);
                this.f8989a.f8182c.m7828a(this.f8989a.m8962f().getApplicationContext(), new C2884a(this) {
                    final /* synthetic */ C2886a f8988b;

                    public void mo3648a() {
                        this.f8988b.f8989a.m9267d();
                        if (a.isShowing()) {
                            a.dismiss();
                        }
                    }
                });
            } else {
                this.f8989a.mo3519a(this.f8989a.f8183e, this.f8989a.f8184f);
            }
        }
    }

    protected C2741g(af afVar) {
        this(afVar, C2481b.m7820a());
    }

    C2741g(af afVar, C2481b c2481b) {
        super(afVar);
        this.f8184f = -1;
        this.f8185g = new Handler(Looper.getMainLooper());
        this.f8182c = c2481b;
    }

    public void mo3514a() {
        super.mo3514a();
        this.f8180a = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3515a(int r6, int r7, android.content.Intent r8) {
        /*
        r5 = this;
        r4 = 18;
        r2 = 13;
        r0 = 1;
        r1 = 0;
        switch(r6) {
            case 1: goto L_0x0027;
            case 2: goto L_0x0010;
            default: goto L_0x0009;
        };
    L_0x0009:
        r0 = r1;
    L_0x000a:
        if (r0 == 0) goto L_0x003d;
    L_0x000c:
        r5.m9267d();
    L_0x000f:
        return;
    L_0x0010:
        r2 = r5.f8182c;
        r3 = r5.m8962f();
        r2 = r2.mo3314a(r3);
        if (r2 != 0) goto L_0x0047;
    L_0x001c:
        r1 = r5.f8183e;
        r1 = r1.m7714c();
        if (r1 != r4) goto L_0x000a;
    L_0x0024:
        if (r2 != r4) goto L_0x000a;
    L_0x0026:
        goto L_0x000f;
    L_0x0027:
        r3 = -1;
        if (r7 == r3) goto L_0x000a;
    L_0x002a:
        if (r7 != 0) goto L_0x0009;
    L_0x002c:
        if (r8 == 0) goto L_0x0045;
    L_0x002e:
        r0 = "<<ResolutionFailureErrorDetail>>";
        r0 = r8.getIntExtra(r0, r2);
    L_0x0034:
        r2 = new com.google.android.gms.common.ConnectionResult;
        r3 = 0;
        r2.<init>(r0, r3);
        r5.f8183e = r2;
        goto L_0x0009;
    L_0x003d:
        r0 = r5.f8183e;
        r1 = r5.f8184f;
        r5.mo3519a(r0, r1);
        goto L_0x000f;
    L_0x0045:
        r0 = r2;
        goto L_0x0034;
    L_0x0047:
        r0 = r1;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.g.a(int, int, android.content.Intent):void");
    }

    public void mo3516a(Bundle bundle) {
        super.mo3516a(bundle);
        if (bundle != null) {
            this.f8181b = bundle.getBoolean("resolving_error", false);
            if (this.f8181b) {
                this.f8184f = bundle.getInt("failed_client_id", -1);
                this.f8183e = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    protected abstract void mo3519a(ConnectionResult connectionResult, int i);

    public void mo3517b() {
        super.mo3517b();
        this.f8180a = false;
    }

    public void mo3518b(Bundle bundle) {
        super.mo3518b(bundle);
        bundle.putBoolean("resolving_error", this.f8181b);
        if (this.f8181b) {
            bundle.putInt("failed_client_id", this.f8184f);
            bundle.putInt("failed_status", this.f8183e.m7714c());
            bundle.putParcelable("failed_resolution", this.f8183e.m7715d());
        }
    }

    public void m9265b(ConnectionResult connectionResult, int i) {
        if (!this.f8181b) {
            this.f8181b = true;
            this.f8184f = i;
            this.f8183e = connectionResult;
            this.f8185g.post(new C2886a());
        }
    }

    protected abstract void mo3521c();

    protected void m9267d() {
        this.f8184f = -1;
        this.f8181b = false;
        this.f8183e = null;
        mo3521c();
    }

    public void onCancel(DialogInterface dialogInterface) {
        mo3519a(new ConnectionResult(13, null), this.f8184f);
        m9267d();
    }
}
