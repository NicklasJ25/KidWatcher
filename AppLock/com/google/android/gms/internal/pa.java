package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public class pa implements xy {
    private final Executor f10156a;

    private class C3142a implements Runnable {
        final /* synthetic */ pa f10152a;
        private final vb f10153b;
        private final wx f10154c;
        private final Runnable f10155d;

        public C3142a(pa paVar, vb vbVar, wx wxVar, Runnable runnable) {
            this.f10152a = paVar;
            this.f10153b = vbVar;
            this.f10154c = wxVar;
            this.f10155d = runnable;
        }

        public void run() {
            if (this.f10154c.m14582a()) {
                this.f10153b.mo3503a(this.f10154c.f11218a);
            } else {
                this.f10153b.m9052b(this.f10154c.f11220c);
            }
            if (this.f10154c.f11221d) {
                this.f10153b.m9053b("intermediate-response");
            } else {
                this.f10153b.m9055c("done");
            }
            if (this.f10155d != null) {
                this.f10155d.run();
            }
        }
    }

    public pa(final Handler handler) {
        this.f10156a = new Executor(this) {
            final /* synthetic */ pa f10151b;

            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public void mo3874a(vb<?> vbVar, abi com_google_android_gms_internal_abi) {
        vbVar.m9053b("post-error");
        this.f10156a.execute(new C3142a(this, vbVar, wx.m14580a(com_google_android_gms_internal_abi), null));
    }

    public void mo3875a(vb<?> vbVar, wx<?> wxVar) {
        mo3876a(vbVar, wxVar, null);
    }

    public void mo3876a(vb<?> vbVar, wx<?> wxVar, Runnable runnable) {
        vbVar.m9068p();
        vbVar.m9053b("post-response");
        this.f10156a.execute(new C3142a(this, vbVar, wxVar, runnable));
    }
}
