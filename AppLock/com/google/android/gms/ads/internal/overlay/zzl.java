package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.annotation.Nullable;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.C2523j;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.aat;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.qj;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.zh;
import com.google.android.gms.internal.zl;
import java.util.HashMap;
import java.util.Map;

@wh
public class zzl extends FrameLayout implements zzi {
    private final aat f6801a;
    private final FrameLayout f6802b;
    private final qj f6803c;
    private final C2327a f6804d;
    private final long f6805e;
    @Nullable
    private zzj f6806f;
    private boolean f6807g;
    private boolean f6808h;
    private boolean f6809i;
    private boolean f6810j;
    private long f6811k;
    private long f6812l;
    private String f6813m;
    private Bitmap f6814n;
    private ImageView f6815o;
    private boolean f6816p;

    class C23481 implements Runnable {
        final /* synthetic */ zzl f6799a;

        C23481(zzl com_google_android_gms_ads_internal_overlay_zzl) {
            this.f6799a = com_google_android_gms_ads_internal_overlay_zzl;
        }

        public void run() {
            this.f6799a.m7414a("surfaceCreated", new String[0]);
        }
    }

    class C23492 implements Runnable {
        final /* synthetic */ zzl f6800a;

        C23492(zzl com_google_android_gms_ads_internal_overlay_zzl) {
            this.f6800a = com_google_android_gms_ads_internal_overlay_zzl;
        }

        public void run() {
            this.f6800a.m7414a("surfaceDestroyed", new String[0]);
        }
    }

    public zzl(Context context, aat com_google_android_gms_internal_aat, int i, boolean z, qj qjVar) {
        super(context);
        this.f6801a = com_google_android_gms_internal_aat;
        this.f6803c = qjVar;
        this.f6802b = new FrameLayout(context);
        addView(this.f6802b, new LayoutParams(-1, -1));
        C2523j.m8015a(com_google_android_gms_internal_aat.mo3420h());
        this.f6806f = com_google_android_gms_internal_aat.mo3420h().zzsN.zza(context, com_google_android_gms_internal_aat, i, z, qjVar);
        if (this.f6806f != null) {
            this.f6802b.addView(this.f6806f, new LayoutParams(-1, -1, 17));
            if (((Boolean) qb.f10261A.m13225c()).booleanValue()) {
                zzic();
            }
        }
        this.f6815o = new ImageView(context);
        this.f6805e = ((Long) qb.f10265E.m13225c()).longValue();
        this.f6810j = ((Boolean) qb.f10263C.m13225c()).booleanValue();
        if (this.f6803c != null) {
            this.f6803c.m13305a("spinner_used", this.f6810j ? "1" : "0");
        }
        this.f6804d = new C2327a(this);
        if (this.f6806f != null) {
            this.f6806f.zza(this);
        }
        if (this.f6806f == null) {
            zzl("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    private void m7412a(int i, int i2) {
        if (this.f6810j) {
            int max = Math.max(i / ((Integer) qb.f10264D.m13225c()).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) qb.f10264D.m13225c()).intValue(), 1);
            if (this.f6814n == null || this.f6814n.getWidth() != max || this.f6814n.getHeight() != max2) {
                this.f6814n = Bitmap.createBitmap(max, max2, Config.ARGB_8888);
                this.f6816p = false;
            }
        }
    }

    private void m7414a(String str, String... strArr) {
        Map hashMap = new HashMap();
        hashMap.put("event", str);
        int length = strArr.length;
        int i = 0;
        Object obj = null;
        while (i < length) {
            Object obj2 = strArr[i];
            if (obj != null) {
                hashMap.put(obj, obj2);
                obj2 = null;
            }
            i++;
            obj = obj2;
        }
        this.f6801a.mo3403a("onVideoEvent", hashMap);
    }

    @TargetApi(14)
    private void m7415b() {
        if (this.f6814n != null) {
            long b = zzw.zzcS().mo3361b();
            if (this.f6806f.getBitmap(this.f6814n) != null) {
                this.f6816p = true;
            }
            b = zzw.zzcS().mo3361b() - b;
            if (zh.m15053b()) {
                zh.m15051a("Spinner frame grab took " + b + "ms");
            }
            if (b > this.f6805e) {
                aad.m8426e("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.f6810j = false;
                this.f6814n = null;
                if (this.f6803c != null) {
                    this.f6803c.m13305a("spinner_jank", Long.toString(b));
                }
            }
        }
    }

    private void m7416c() {
        if (this.f6816p && this.f6814n != null && !m7418e()) {
            this.f6815o.setImageBitmap(this.f6814n);
            this.f6815o.invalidate();
            this.f6802b.addView(this.f6815o, new LayoutParams(-1, -1));
            this.f6802b.bringChildToFront(this.f6815o);
        }
    }

    private void m7417d() {
        if (m7418e()) {
            this.f6802b.removeView(this.f6815o);
        }
    }

    private boolean m7418e() {
        return this.f6815o.getParent() != null;
    }

    private void m7419f() {
        if (this.f6801a.mo3418f() != null && !this.f6808h) {
            this.f6809i = (this.f6801a.mo3418f().getWindow().getAttributes().flags & 128) != 0;
            if (!this.f6809i) {
                this.f6801a.mo3418f().getWindow().addFlags(128);
                this.f6808h = true;
            }
        }
    }

    private void m7420g() {
        if (this.f6801a.mo3418f() != null && this.f6808h && !this.f6809i) {
            this.f6801a.mo3418f().getWindow().clearFlags(128);
            this.f6808h = false;
        }
    }

    public static void zzi(aat com_google_android_gms_internal_aat) {
        Map hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        com_google_android_gms_internal_aat.mo3403a("onVideoEvent", hashMap);
    }

    void m7421a() {
        if (this.f6806f != null) {
            long currentPosition = (long) this.f6806f.getCurrentPosition();
            if (this.f6811k != currentPosition && currentPosition > 0) {
                float f = ((float) currentPosition) / 1000.0f;
                m7414a("timeupdate", "time", String.valueOf(f));
                this.f6811k = currentPosition;
            }
        }
    }

    public void destroy() {
        this.f6804d.m7378a();
        if (this.f6806f != null) {
            this.f6806f.stop();
        }
        m7420g();
    }

    public void onPaused() {
        m7414a("pause", new String[0]);
        m7420g();
        this.f6807g = false;
    }

    public void pause() {
        if (this.f6806f != null) {
            this.f6806f.pause();
        }
    }

    public void play() {
        if (this.f6806f != null) {
            this.f6806f.play();
        }
    }

    public void seekTo(int i) {
        if (this.f6806f != null) {
            this.f6806f.seekTo(i);
        }
    }

    public void zza(float f, float f2) {
        if (this.f6806f != null) {
            this.f6806f.zza(f, f2);
        }
    }

    public void zzaC(String str) {
        this.f6813m = str;
    }

    public void zzb(float f) {
        if (this.f6806f != null) {
            this.f6806f.zzb(f);
        }
    }

    public void zzd(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.f6802b.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    @TargetApi(14)
    public void zzf(MotionEvent motionEvent) {
        if (this.f6806f != null) {
            this.f6806f.dispatchTouchEvent(motionEvent);
        }
    }

    public void zzg(int i, int i2) {
        m7412a(i, i2);
    }

    public void zzhT() {
        this.f6804d.m7379b();
        zl.f11678a.post(new C23481(this));
    }

    public void zzhU() {
        if (this.f6806f != null && this.f6812l == 0) {
            float duration = ((float) this.f6806f.getDuration()) / 1000.0f;
            int videoWidth = this.f6806f.getVideoWidth();
            int videoHeight = this.f6806f.getVideoHeight();
            m7414a("canplaythrough", "duration", String.valueOf(duration), "videoWidth", String.valueOf(videoWidth), "videoHeight", String.valueOf(videoHeight));
        }
    }

    public void zzhV() {
        m7419f();
        this.f6807g = true;
    }

    public void zzhW() {
        m7414a("ended", new String[0]);
        m7420g();
    }

    public void zzhX() {
        m7416c();
        this.f6804d.m7378a();
        this.f6812l = this.f6811k;
        zl.f11678a.post(new C23492(this));
    }

    public void zzhY() {
        if (this.f6807g) {
            m7417d();
        }
        m7415b();
    }

    public void zzhZ() {
        if (this.f6806f != null) {
            this.f6806f.zzhZ();
        }
    }

    public void zzia() {
        if (this.f6806f != null) {
            this.f6806f.zzia();
        }
    }

    public void zzib() {
        if (this.f6806f != null) {
            if (TextUtils.isEmpty(this.f6813m)) {
                m7414a("no_src", new String[0]);
            } else {
                this.f6806f.setVideoPath(this.f6813m);
            }
        }
    }

    @TargetApi(14)
    public void zzic() {
        if (this.f6806f != null) {
            View textView = new TextView(this.f6806f.getContext());
            String str = "AdMob - ";
            String valueOf = String.valueOf(this.f6806f.zzhy());
            textView.setText(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
            textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
            this.f6802b.addView(textView, new LayoutParams(-2, -2, 17));
            this.f6802b.bringChildToFront(textView);
        }
    }

    public void zzl(String str, @Nullable String str2) {
        m7414a("error", "what", str, "extra", str2);
    }
}
