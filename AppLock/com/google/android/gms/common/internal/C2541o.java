package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.internal.af;

public abstract class C2541o implements OnClickListener {

    class C25421 extends C2541o {
        final /* synthetic */ Intent f7454a;
        final /* synthetic */ Activity f7455b;
        final /* synthetic */ int f7456c;

        C25421(Intent intent, Activity activity, int i) {
            this.f7454a = intent;
            this.f7455b = activity;
            this.f7456c = i;
        }

        public void mo3345a() {
            if (this.f7454a != null) {
                this.f7455b.startActivityForResult(this.f7454a, this.f7456c);
            }
        }
    }

    class C25432 extends C2541o {
        final /* synthetic */ Intent f7457a;
        final /* synthetic */ af f7458b;
        final /* synthetic */ int f7459c;

        C25432(Intent intent, af afVar, int i) {
            this.f7457a = intent;
            this.f7458b = afVar;
            this.f7459c = i;
        }

        public void mo3345a() {
            if (this.f7457a != null) {
                this.f7458b.startActivityForResult(this.f7457a, this.f7459c);
            }
        }
    }

    public static C2541o m8064a(Activity activity, Intent intent, int i) {
        return new C25421(intent, activity, i);
    }

    public static C2541o m8065a(@NonNull af afVar, Intent intent, int i) {
        return new C25432(intent, afVar, i);
    }

    protected abstract void mo3345a();

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            mo3345a();
        } catch (Throwable e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
