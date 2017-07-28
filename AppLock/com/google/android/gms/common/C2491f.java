package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.internal.C2513c;

public class C2491f extends DialogFragment {
    private Dialog f7350a = null;
    private OnCancelListener f7351b = null;

    public static C2491f m7876a(Dialog dialog, OnCancelListener onCancelListener) {
        C2491f c2491f = new C2491f();
        Dialog dialog2 = (Dialog) C2513c.m7933a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        c2491f.f7350a = dialog2;
        if (onCancelListener != null) {
            c2491f.f7351b = onCancelListener;
        }
        return c2491f;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f7351b != null) {
            this.f7351b.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f7350a == null) {
            setShowsDialog(false);
        }
        return this.f7350a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
