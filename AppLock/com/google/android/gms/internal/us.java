package com.google.android.gms.internal;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.C2581f;
import java.util.Map;
import java.util.Set;

@wh
public class us extends ux {
    static final Set<String> f10931a = C2581f.m8283a("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private String f10932b = "top-right";
    private boolean f10933c = true;
    private int f10934d = 0;
    private int f10935e = 0;
    private int f10936f = -1;
    private int f10937g = 0;
    private int f10938h = 0;
    private int f10939i = -1;
    private final Object f10940j = new Object();
    private final aat f10941k;
    private final Activity f10942l;
    private zzeg f10943m;
    private ImageView f10944n;
    private LinearLayout f10945o;
    private uy f10946p;
    private PopupWindow f10947q;
    private RelativeLayout f10948r;
    private ViewGroup f10949s;

    class C33431 implements OnClickListener {
        final /* synthetic */ us f10930a;

        C33431(us usVar) {
            this.f10930a = usVar;
        }

        public void onClick(View view) {
            this.f10930a.m14289a(true);
        }
    }

    public us(aat com_google_android_gms_internal_aat, uy uyVar) {
        super(com_google_android_gms_internal_aat, "resize");
        this.f10941k = com_google_android_gms_internal_aat;
        this.f10942l = com_google_android_gms_internal_aat.mo3418f();
        this.f10946p = uyVar;
    }

    private void m14284b(Map<String, String> map) {
        if (!TextUtils.isEmpty((CharSequence) map.get("width"))) {
            this.f10939i = zzw.zzcM().m15137b((String) map.get("width"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("height"))) {
            this.f10936f = zzw.zzcM().m15137b((String) map.get("height"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
            this.f10937g = zzw.zzcM().m15137b((String) map.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
            this.f10938h = zzw.zzcM().m15137b((String) map.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
            this.f10933c = Boolean.parseBoolean((String) map.get("allowOffscreen"));
        }
        String str = (String) map.get("customClosePosition");
        if (!TextUtils.isEmpty(str)) {
            this.f10932b = str;
        }
    }

    private int[] m14285d() {
        if (!m14294c()) {
            return null;
        }
        if (this.f10933c) {
            return new int[]{this.f10934d + this.f10937g, this.f10935e + this.f10938h};
        }
        int[] b = zzw.zzcM().m15144b(this.f10942l);
        int[] d = zzw.zzcM().m15152d(this.f10942l);
        int i = b[0];
        int i2 = this.f10934d + this.f10937g;
        int i3 = this.f10935e + this.f10938h;
        if (i2 < 0) {
            i2 = 0;
        } else if (this.f10939i + i2 > i) {
            i2 = i - this.f10939i;
        }
        if (i3 < d[0]) {
            i3 = d[0];
        } else if (this.f10936f + i3 > d[1]) {
            i3 = d[1] - this.f10936f;
        }
        return new int[]{i2, i3};
    }

    void m14286a(int i, int i2) {
        if (this.f10946p != null) {
            this.f10946p.zza(i, i2, this.f10939i, this.f10936f);
        }
    }

    public void m14287a(int i, int i2, boolean z) {
        synchronized (this.f10940j) {
            this.f10934d = i;
            this.f10935e = i2;
            if (this.f10947q != null && z) {
                int[] d = m14285d();
                if (d != null) {
                    this.f10947q.update(ol.m12979a().m8398a(this.f10942l, d[0]), ol.m12979a().m8398a(this.f10942l, d[1]), this.f10947q.getWidth(), this.f10947q.getHeight());
                    m14291b(d[0], d[1]);
                } else {
                    m14289a(true);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m14288a(java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
        r12 = this;
        r4 = -1;
        r5 = 1;
        r3 = 0;
        r6 = r12.f10940j;
        monitor-enter(r6);
        r1 = r12.f10942l;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0011;
    L_0x000a:
        r1 = "Not an activity context. Cannot resize.";
        r12.m14275b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
    L_0x0010:
        return;
    L_0x0011:
        r1 = r12.f10941k;	 Catch:{ all -> 0x0020 }
        r1 = r1.mo3423k();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0023;
    L_0x0019:
        r1 = "Webview is not yet available, size is not set.";
        r12.m14275b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0020:
        r1 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        throw r1;
    L_0x0023:
        r1 = r12.f10941k;	 Catch:{ all -> 0x0020 }
        r1 = r1.mo3423k();	 Catch:{ all -> 0x0020 }
        r1 = r1.f11898d;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0034;
    L_0x002d:
        r1 = "Is interstitial. Cannot resize an interstitial.";
        r12.m14275b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0034:
        r1 = r12.f10941k;	 Catch:{ all -> 0x0020 }
        r1 = r1.mo3433p();	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0043;
    L_0x003c:
        r1 = "Cannot resize an expanded banner.";
        r12.m14275b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0043:
        r12.m14284b(r13);	 Catch:{ all -> 0x0020 }
        r1 = r12.m14290a();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0053;
    L_0x004c:
        r1 = "Invalid width and height options. Cannot resize.";
        r12.m14275b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0053:
        r1 = r12.f10942l;	 Catch:{ all -> 0x0020 }
        r7 = r1.getWindow();	 Catch:{ all -> 0x0020 }
        if (r7 == 0) goto L_0x0061;
    L_0x005b:
        r1 = r7.getDecorView();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0068;
    L_0x0061:
        r1 = "Activity context is not ready, cannot get window or decor view.";
        r12.m14275b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0068:
        r8 = r12.m14285d();	 Catch:{ all -> 0x0020 }
        if (r8 != 0) goto L_0x0075;
    L_0x006e:
        r1 = "Resize location out of screen or close button is not visible.";
        r12.m14275b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0075:
        r1 = com.google.android.gms.internal.ol.m12979a();	 Catch:{ all -> 0x0020 }
        r2 = r12.f10942l;	 Catch:{ all -> 0x0020 }
        r9 = r12.f10939i;	 Catch:{ all -> 0x0020 }
        r9 = r1.m8398a(r2, r9);	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.internal.ol.m12979a();	 Catch:{ all -> 0x0020 }
        r2 = r12.f10942l;	 Catch:{ all -> 0x0020 }
        r10 = r12.f10936f;	 Catch:{ all -> 0x0020 }
        r10 = r1.m8398a(r2, r10);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10941k;	 Catch:{ all -> 0x0020 }
        r1 = r1.mo3405b();	 Catch:{ all -> 0x0020 }
        r2 = r1.getParent();	 Catch:{ all -> 0x0020 }
        if (r2 == 0) goto L_0x01d5;
    L_0x0099:
        r1 = r2 instanceof android.view.ViewGroup;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x01d5;
    L_0x009d:
        r0 = r2;
        r0 = (android.view.ViewGroup) r0;	 Catch:{ all -> 0x0020 }
        r1 = r0;
        r11 = r12.f10941k;	 Catch:{ all -> 0x0020 }
        r11 = r11.mo3405b();	 Catch:{ all -> 0x0020 }
        r1.removeView(r11);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10947q;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x01ce;
    L_0x00ae:
        r2 = (android.view.ViewGroup) r2;	 Catch:{ all -> 0x0020 }
        r12.f10949s = r2;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.zzw.zzcM();	 Catch:{ all -> 0x0020 }
        r2 = r12.f10941k;	 Catch:{ all -> 0x0020 }
        r2 = r2.mo3405b();	 Catch:{ all -> 0x0020 }
        r1 = r1.m15097a(r2);	 Catch:{ all -> 0x0020 }
        r2 = new android.widget.ImageView;	 Catch:{ all -> 0x0020 }
        r11 = r12.f10942l;	 Catch:{ all -> 0x0020 }
        r2.<init>(r11);	 Catch:{ all -> 0x0020 }
        r12.f10944n = r2;	 Catch:{ all -> 0x0020 }
        r2 = r12.f10944n;	 Catch:{ all -> 0x0020 }
        r2.setImageBitmap(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10941k;	 Catch:{ all -> 0x0020 }
        r1 = r1.mo3423k();	 Catch:{ all -> 0x0020 }
        r12.f10943m = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.f10949s;	 Catch:{ all -> 0x0020 }
        r2 = r12.f10944n;	 Catch:{ all -> 0x0020 }
        r1.addView(r2);	 Catch:{ all -> 0x0020 }
    L_0x00dd:
        r1 = new android.widget.RelativeLayout;	 Catch:{ all -> 0x0020 }
        r2 = r12.f10942l;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        r12.f10948r = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.f10948r;	 Catch:{ all -> 0x0020 }
        r2 = 0;
        r1.setBackgroundColor(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10948r;	 Catch:{ all -> 0x0020 }
        r2 = new android.view.ViewGroup$LayoutParams;	 Catch:{ all -> 0x0020 }
        r2.<init>(r9, r10);	 Catch:{ all -> 0x0020 }
        r1.setLayoutParams(r2);	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.zzw.zzcM();	 Catch:{ all -> 0x0020 }
        r2 = r12.f10948r;	 Catch:{ all -> 0x0020 }
        r11 = 0;
        r1 = r1.m15102a(r2, r9, r10, r11);	 Catch:{ all -> 0x0020 }
        r12.f10947q = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.f10947q;	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.setOutsideTouchable(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10947q;	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.setTouchable(r2);	 Catch:{ all -> 0x0020 }
        r2 = r12.f10947q;	 Catch:{ all -> 0x0020 }
        r1 = r12.f10933c;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x01dd;
    L_0x0115:
        r1 = r5;
    L_0x0116:
        r2.setClippingEnabled(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10948r;	 Catch:{ all -> 0x0020 }
        r2 = r12.f10941k;	 Catch:{ all -> 0x0020 }
        r2 = r2.mo3405b();	 Catch:{ all -> 0x0020 }
        r9 = -1;
        r10 = -1;
        r1.addView(r2, r9, r10);	 Catch:{ all -> 0x0020 }
        r1 = new android.widget.LinearLayout;	 Catch:{ all -> 0x0020 }
        r2 = r12.f10942l;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        r12.f10945o = r1;	 Catch:{ all -> 0x0020 }
        r2 = new android.widget.RelativeLayout$LayoutParams;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.internal.ol.m12979a();	 Catch:{ all -> 0x0020 }
        r9 = r12.f10942l;	 Catch:{ all -> 0x0020 }
        r10 = 50;
        r1 = r1.m8398a(r9, r10);	 Catch:{ all -> 0x0020 }
        r9 = com.google.android.gms.internal.ol.m12979a();	 Catch:{ all -> 0x0020 }
        r10 = r12.f10942l;	 Catch:{ all -> 0x0020 }
        r11 = 50;
        r9 = r9.m8398a(r10, r11);	 Catch:{ all -> 0x0020 }
        r2.<init>(r1, r9);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10932b;	 Catch:{ all -> 0x0020 }
        r9 = r1.hashCode();	 Catch:{ all -> 0x0020 }
        switch(r9) {
            case -1364013995: goto L_0x01f6;
            case -1012429441: goto L_0x01e0;
            case -655373719: goto L_0x0201;
            case 1163912186: goto L_0x0217;
            case 1288627767: goto L_0x020c;
            case 1755462605: goto L_0x01eb;
            default: goto L_0x0155;
        };	 Catch:{ all -> 0x0020 }
    L_0x0155:
        r1 = r4;
    L_0x0156:
        switch(r1) {
            case 0: goto L_0x0222;
            case 1: goto L_0x022e;
            case 2: goto L_0x023a;
            case 3: goto L_0x0241;
            case 4: goto L_0x024d;
            case 5: goto L_0x0259;
            default: goto L_0x0159;
        };	 Catch:{ all -> 0x0020 }
    L_0x0159:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
    L_0x0163:
        r1 = r12.f10945o;	 Catch:{ all -> 0x0020 }
        r3 = new com.google.android.gms.internal.us$1;	 Catch:{ all -> 0x0020 }
        r3.<init>(r12);	 Catch:{ all -> 0x0020 }
        r1.setOnClickListener(r3);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10945o;	 Catch:{ all -> 0x0020 }
        r3 = "Close button";
        r1.setContentDescription(r3);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10948r;	 Catch:{ all -> 0x0020 }
        r3 = r12.f10945o;	 Catch:{ all -> 0x0020 }
        r1.addView(r3, r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10947q;	 Catch:{ RuntimeException -> 0x0265 }
        r2 = r7.getDecorView();	 Catch:{ RuntimeException -> 0x0265 }
        r3 = 0;
        r4 = com.google.android.gms.internal.ol.m12979a();	 Catch:{ RuntimeException -> 0x0265 }
        r5 = r12.f10942l;	 Catch:{ RuntimeException -> 0x0265 }
        r7 = 0;
        r7 = r8[r7];	 Catch:{ RuntimeException -> 0x0265 }
        r4 = r4.m8398a(r5, r7);	 Catch:{ RuntimeException -> 0x0265 }
        r5 = com.google.android.gms.internal.ol.m12979a();	 Catch:{ RuntimeException -> 0x0265 }
        r7 = r12.f10942l;	 Catch:{ RuntimeException -> 0x0265 }
        r9 = 1;
        r9 = r8[r9];	 Catch:{ RuntimeException -> 0x0265 }
        r5 = r5.m8398a(r7, r9);	 Catch:{ RuntimeException -> 0x0265 }
        r1.showAtLocation(r2, r3, r4, r5);	 Catch:{ RuntimeException -> 0x0265 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0020 }
        r12.m14286a(r1, r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10941k;	 Catch:{ all -> 0x0020 }
        r2 = new com.google.android.gms.internal.zzeg;	 Catch:{ all -> 0x0020 }
        r3 = r12.f10942l;	 Catch:{ all -> 0x0020 }
        r4 = new com.google.android.gms.ads.AdSize;	 Catch:{ all -> 0x0020 }
        r5 = r12.f10939i;	 Catch:{ all -> 0x0020 }
        r7 = r12.f10936f;	 Catch:{ all -> 0x0020 }
        r4.<init>(r5, r7);	 Catch:{ all -> 0x0020 }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x0020 }
        r1.mo3400a(r2);	 Catch:{ all -> 0x0020 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0020 }
        r12.m14291b(r1, r2);	 Catch:{ all -> 0x0020 }
        r1 = "resized";
        r12.m14277d(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x01ce:
        r1 = r12.f10947q;	 Catch:{ all -> 0x0020 }
        r1.dismiss();	 Catch:{ all -> 0x0020 }
        goto L_0x00dd;
    L_0x01d5:
        r1 = "Webview is detached, probably in the middle of a resize or expand.";
        r12.m14275b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x01dd:
        r1 = r3;
        goto L_0x0116;
    L_0x01e0:
        r5 = "top-left";
        r1 = r1.equals(r5);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01e8:
        r1 = r3;
        goto L_0x0156;
    L_0x01eb:
        r3 = "top-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01f3:
        r1 = r5;
        goto L_0x0156;
    L_0x01f6:
        r3 = "center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01fe:
        r1 = 2;
        goto L_0x0156;
    L_0x0201:
        r3 = "bottom-left";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x0209:
        r1 = 3;
        goto L_0x0156;
    L_0x020c:
        r3 = "bottom-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x0214:
        r1 = 4;
        goto L_0x0156;
    L_0x0217:
        r3 = "bottom-right";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x021f:
        r1 = 5;
        goto L_0x0156;
    L_0x0222:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x022e:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x023a:
        r1 = 13;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0241:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x024d:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0259:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0265:
        r1 = move-exception;
        r2 = "Cannot show popup window: ";
        r1 = r1.getMessage();	 Catch:{ all -> 0x0020 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x0020 }
        r3 = r1.length();	 Catch:{ all -> 0x0020 }
        if (r3 == 0) goto L_0x02a8;
    L_0x0276:
        r1 = r2.concat(r1);	 Catch:{ all -> 0x0020 }
    L_0x027a:
        r12.m14275b(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10948r;	 Catch:{ all -> 0x0020 }
        r2 = r12.f10941k;	 Catch:{ all -> 0x0020 }
        r2 = r2.mo3405b();	 Catch:{ all -> 0x0020 }
        r1.removeView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10949s;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x02a5;
    L_0x028c:
        r1 = r12.f10949s;	 Catch:{ all -> 0x0020 }
        r2 = r12.f10944n;	 Catch:{ all -> 0x0020 }
        r1.removeView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10949s;	 Catch:{ all -> 0x0020 }
        r2 = r12.f10941k;	 Catch:{ all -> 0x0020 }
        r2 = r2.mo3405b();	 Catch:{ all -> 0x0020 }
        r1.addView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10941k;	 Catch:{ all -> 0x0020 }
        r2 = r12.f10943m;	 Catch:{ all -> 0x0020 }
        r1.mo3400a(r2);	 Catch:{ all -> 0x0020 }
    L_0x02a5:
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x02a8:
        r1 = new java.lang.String;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        goto L_0x027a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.us.a(java.util.Map):void");
    }

    public void m14289a(boolean z) {
        synchronized (this.f10940j) {
            if (this.f10947q != null) {
                this.f10947q.dismiss();
                this.f10948r.removeView(this.f10941k.mo3405b());
                if (this.f10949s != null) {
                    this.f10949s.removeView(this.f10944n);
                    this.f10949s.addView(this.f10941k.mo3405b());
                    this.f10941k.mo3400a(this.f10943m);
                }
                if (z) {
                    m14277d("default");
                    if (this.f10946p != null) {
                        this.f10946p.zzcb();
                    }
                }
                this.f10947q = null;
                this.f10948r = null;
                this.f10949s = null;
                this.f10945o = null;
            }
        }
    }

    boolean m14290a() {
        return this.f10939i > -1 && this.f10936f > -1;
    }

    void m14291b(int i, int i2) {
        m14272a(i, i2 - zzw.zzcM().m15152d(this.f10942l)[0], this.f10939i, this.f10936f);
    }

    public boolean m14292b() {
        boolean z;
        synchronized (this.f10940j) {
            z = this.f10947q != null;
        }
        return z;
    }

    public void m14293c(int i, int i2) {
        this.f10934d = i;
        this.f10935e = i2;
    }

    boolean m14294c() {
        int[] b = zzw.zzcM().m15144b(this.f10942l);
        int[] d = zzw.zzcM().m15152d(this.f10942l);
        int i = b[0];
        int i2 = b[1];
        if (this.f10939i < 50 || this.f10939i > i) {
            aad.m8426e("Width is too small or too large.");
            return false;
        } else if (this.f10936f < 50 || this.f10936f > i2) {
            aad.m8426e("Height is too small or too large.");
            return false;
        } else if (this.f10936f == i2 && this.f10939i == i) {
            aad.m8426e("Cannot resize to a full-screen ad.");
            return false;
        } else {
            if (this.f10933c) {
                int i3;
                String str = this.f10932b;
                boolean z = true;
                switch (str.hashCode()) {
                    case -1364013995:
                        if (str.equals("center")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1012429441:
                        if (str.equals("top-left")) {
                            z = false;
                            break;
                        }
                        break;
                    case -655373719:
                        if (str.equals("bottom-left")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1163912186:
                        if (str.equals("bottom-right")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1288627767:
                        if (str.equals("bottom-center")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1755462605:
                        if (str.equals("top-center")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        i3 = this.f10937g + this.f10934d;
                        i2 = this.f10935e + this.f10938h;
                        break;
                    case true:
                        i3 = ((this.f10934d + this.f10937g) + (this.f10939i / 2)) - 25;
                        i2 = this.f10935e + this.f10938h;
                        break;
                    case true:
                        i3 = ((this.f10934d + this.f10937g) + (this.f10939i / 2)) - 25;
                        i2 = ((this.f10935e + this.f10938h) + (this.f10936f / 2)) - 25;
                        break;
                    case true:
                        i3 = this.f10937g + this.f10934d;
                        i2 = ((this.f10935e + this.f10938h) + this.f10936f) - 50;
                        break;
                    case true:
                        i3 = ((this.f10934d + this.f10937g) + (this.f10939i / 2)) - 25;
                        i2 = ((this.f10935e + this.f10938h) + this.f10936f) - 50;
                        break;
                    case true:
                        i3 = ((this.f10934d + this.f10937g) + this.f10939i) - 50;
                        i2 = ((this.f10935e + this.f10938h) + this.f10936f) - 50;
                        break;
                    default:
                        i3 = ((this.f10934d + this.f10937g) + this.f10939i) - 50;
                        i2 = this.f10935e + this.f10938h;
                        break;
                }
                if (i3 < 0 || i3 + 50 > i || r2 < d[0] || r2 + 50 > d[1]) {
                    return false;
                }
            }
            return true;
        }
    }
}
