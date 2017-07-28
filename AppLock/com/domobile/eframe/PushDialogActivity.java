package com.domobile.eframe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import com.domobile.frame.ui.C1288c;

public class PushDialogActivity extends Activity implements OnClickListener, OnDismissListener {
    public void onBackPressed() {
        finish();
    }

    public void onClick(View view) {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View view = new View(this);
        view.setLayoutParams(new LayoutParams(-1, -1));
        setContentView(view);
        C1288c a = C1228f.m2879a((Activity) this);
        if (a != null) {
            a.m3107a((OnDismissListener) this);
            a.m3122d();
            return;
        }
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void onDismiss() {
        finish();
    }
}
