package com.domobile.applock.p005b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.domobile.applock.R;

public class C0719a extends DialogFragment implements OnKeyListener {
    protected boolean f895a = true;

    protected int m987a() {
        return (int) (((float) getActivity().getResources().getDisplayMetrics().widthPixels) * 0.9f);
    }

    public View m988a(int i) {
        return getView() == null ? null : getView().findViewById(i);
    }

    public void m989b() {
        if (this.f895a) {
            dismissAllowingStateLoss();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.AppTheme.Dialog.Transparent.NoTitle);
        setCancelable(true);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4) {
            m989b();
        }
        return false;
    }

    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            LayoutParams attributes = getDialog().getWindow().getAttributes();
            attributes.width = m987a();
            getDialog().getWindow().setAttributes(attributes);
            getDialog().setOnKeyListener(this);
        }
    }
}
