package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.C2513c;

public class C2444a extends DialogFragment {
    private Dialog f7258a = null;
    private OnCancelListener f7259b = null;

    public static C2444a m7717a(Dialog dialog, OnCancelListener onCancelListener) {
        C2444a c2444a = new C2444a();
        Dialog dialog2 = (Dialog) C2513c.m7933a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        c2444a.f7258a = dialog2;
        if (onCancelListener != null) {
            c2444a.f7259b = onCancelListener;
        }
        return c2444a;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f7259b != null) {
            this.f7259b.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f7258a == null) {
            setShowsDialog(false);
        }
        return this.f7258a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
