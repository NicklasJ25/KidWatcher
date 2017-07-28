package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.uv.C3347a;
import java.util.Map;

@wh
public class uw extends ux implements sc {
    DisplayMetrics f10969a;
    int f10970b = -1;
    int f10971c = -1;
    int f10972d = -1;
    int f10973e = -1;
    int f10974f = -1;
    int f10975g = -1;
    private final aat f10976h;
    private final Context f10977i;
    private final WindowManager f10978j;
    private final ps f10979k;
    private float f10980l;
    private int f10981m;

    public uw(aat com_google_android_gms_internal_aat, Context context, ps psVar) {
        super(com_google_android_gms_internal_aat);
        this.f10976h = com_google_android_gms_internal_aat;
        this.f10977i = context;
        this.f10979k = psVar;
        this.f10978j = (WindowManager) context.getSystemService("window");
    }

    private void m14312g() {
        this.f10969a = new DisplayMetrics();
        Display defaultDisplay = this.f10978j.getDefaultDisplay();
        defaultDisplay.getMetrics(this.f10969a);
        this.f10980l = this.f10969a.density;
        this.f10981m = defaultDisplay.getRotation();
    }

    private void m14313h() {
        int[] iArr = new int[2];
        this.f10976h.getLocationOnScreen(iArr);
        m14316a(ol.m12979a().m8410b(this.f10977i, iArr[0]), ol.m12979a().m8410b(this.f10977i, iArr[1]));
    }

    private uv m14314i() {
        return new C3347a().m14307b(this.f10979k.m13207a()).m14305a(this.f10979k.m13209b()).m14308c(this.f10979k.m13211e()).m14309d(this.f10979k.m13210c()).m14310e(true).m14306a();
    }

    void m14315a() {
        this.f10970b = ol.m12979a().m8411b(this.f10969a, this.f10969a.widthPixels);
        this.f10971c = ol.m12979a().m8411b(this.f10969a, this.f10969a.heightPixels);
        Activity f = this.f10976h.mo3418f();
        if (f == null || f.getWindow() == null) {
            this.f10972d = this.f10970b;
            this.f10973e = this.f10971c;
            return;
        }
        int[] a = zzw.zzcM().m15135a(f);
        this.f10972d = ol.m12979a().m8411b(this.f10969a, a[0]);
        this.f10973e = ol.m12979a().m8411b(this.f10969a, a[1]);
    }

    public void m14316a(int i, int i2) {
        int i3 = this.f10977i instanceof Activity ? zzw.zzcM().m15152d((Activity) this.f10977i)[0] : 0;
        if (this.f10976h.mo3423k() == null || !this.f10976h.mo3423k().f11898d) {
            this.f10974f = ol.m12979a().m8410b(this.f10977i, this.f10976h.getMeasuredWidth());
            this.f10975g = ol.m12979a().m8410b(this.f10977i, this.f10976h.getMeasuredHeight());
        }
        m14274b(i, i2 - i3, this.f10974f, this.f10975g);
        this.f10976h.mo3424l().m8540a(i, i2);
    }

    public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        m14319c();
    }

    void m14318b() {
        if (this.f10976h.mo3423k().f11898d) {
            this.f10974f = this.f10970b;
            this.f10975g = this.f10971c;
            return;
        }
        this.f10976h.measure(0, 0);
    }

    public void m14319c() {
        m14312g();
        m14315a();
        m14318b();
        m14321e();
        m14322f();
        m14313h();
        m14320d();
    }

    void m14320d() {
        if (aad.m8420a(2)) {
            aad.m8425d("Dispatching Ready Event.");
        }
        m14276c(this.f10976h.mo3430o().f12081a);
    }

    void m14321e() {
        m14273a(this.f10970b, this.f10971c, this.f10972d, this.f10973e, this.f10980l, this.f10981m);
    }

    void m14322f() {
        this.f10976h.mo3410b("onDeviceFeaturesReceived", m14314i().m14311a());
    }
}
