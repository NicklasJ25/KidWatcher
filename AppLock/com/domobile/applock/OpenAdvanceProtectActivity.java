package com.domobile.applock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.InputDeviceCompat;
import android.widget.PopupWindow.OnDismissListener;
import com.domobile.frame.p000a.C1148d;

public class OpenAdvanceProtectActivity extends C0386c {
    private static boolean f502e = false;
    private boolean f503d = true;

    public static void m645a(final Activity activity) {
        C1150y.m2567a(activity, (int) R.string.setting_success, (int) R.string.secure_level_enabled, 17039370).m3113b((int) R.drawable.ic_dialog_ok_holo_light).m3107a(new OnDismissListener() {
            public void onDismiss() {
                if (activity instanceof OpenAdvanceProtectActivity) {
                    activity.finish();
                }
            }
        });
    }

    public static void m646a(Context context) {
        if (!f502e) {
            try {
                context.startActivity(new Intent(context, OpenAdvanceProtectActivity.class).setFlags(268435456));
            } catch (Exception e) {
            }
        }
    }

    private boolean m647a(C0386c c0386c, int i) {
        if (i == InputDeviceCompat.SOURCE_TOUCHSCREEN) {
            if (C1150y.m2590a((Context) c0386c, C1150y.m2597b())) {
                C1150y.m2587a(c0386c, (int) FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                return true;
            }
            MainTabFragmentActivity.m623a((Activity) c0386c, true);
            return true;
        } else if (i != FragmentTransaction.TRANSIT_FRAGMENT_FADE) {
            return false;
        } else {
            MainTabFragmentActivity.m623a((Activity) c0386c, false);
            return true;
        }
    }

    public void mo2041d() {
        this.f = false;
        this.g = false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1148d.m2520b((Context) this, "latest_leave_app_timemills", (Object) Long.valueOf(System.currentTimeMillis()));
        this.h.setVisibility(8);
        f502e = true;
        if (C1150y.m2542G(this)) {
            finish();
            return;
        }
        m80e();
        MainTabFragmentActivity.m627a((C0386c) this, (int) InputDeviceCompat.SOURCE_TOUCHSCREEN);
    }

    public void onDestroy() {
        super.onDestroy();
        f502e = false;
    }

    protected void onResume() {
        super.onResume();
        if (this.a > 0) {
            this.b = false;
            this.c = true;
        }
        if (this.f503d) {
            this.f503d = false;
        } else if (!m647a(this, this.a)) {
            finish();
        } else if (C1150y.m2542G(this)) {
            m645a((Activity) this);
        }
    }
}
