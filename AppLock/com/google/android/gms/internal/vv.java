package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.internal.vs.C2360a;
import com.google.android.gms.internal.yy.C3457a;

@TargetApi(19)
@wh
public class vv extends vt {
    private Object f11042g = new Object();
    private PopupWindow f11043h;
    private boolean f11044i = false;

    vv(Context context, C3457a c3457a, aat com_google_android_gms_internal_aat, C2360a c2360a) {
        super(context, c3457a, com_google_android_gms_internal_aat, c2360a);
    }

    private void m14379d() {
        synchronized (this.f11042g) {
            this.f11044i = true;
            if ((this.b instanceof Activity) && ((Activity) this.b).isDestroyed()) {
                this.f11043h = null;
            }
            if (this.f11043h != null) {
                if (this.f11043h.isShowing()) {
                    this.f11043h.dismiss();
                }
                this.f11043h = null;
            }
        }
    }

    protected void mo4172a(int i) {
        m14379d();
        super.mo4172a(i);
    }

    protected void mo4173c() {
        Window window = this.b instanceof Activity ? ((Activity) this.b).getWindow() : null;
        if (window != null && window.getDecorView() != null && !((Activity) this.b).isDestroyed()) {
            View frameLayout = new FrameLayout(this.b);
            frameLayout.setLayoutParams(new LayoutParams(-1, -1));
            frameLayout.addView(this.c.mo3405b(), -1, -1);
            synchronized (this.f11042g) {
                if (this.f11044i) {
                    return;
                }
                this.f11043h = new PopupWindow(frameLayout, 1, 1, false);
                this.f11043h.setOutsideTouchable(true);
                this.f11043h.setClippingEnabled(false);
                aad.m8421b("Displaying the 1x1 popup off the screen.");
                try {
                    this.f11043h.showAtLocation(window.getDecorView(), 0, -1, -1);
                } catch (Exception e) {
                    this.f11043h = null;
                }
            }
        }
    }

    public void cancel() {
        m14379d();
        super.cancel();
    }
}
