package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.internal.aab;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.aat;
import com.google.android.gms.internal.aau;
import com.google.android.gms.internal.ed;
import com.google.android.gms.internal.ol;
import com.google.android.gms.internal.oo;
import com.google.android.gms.internal.op;
import com.google.android.gms.internal.ov;
import com.google.android.gms.internal.ox;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.qn;
import com.google.android.gms.internal.rn;
import com.google.android.gms.internal.ro;
import com.google.android.gms.internal.rp;
import com.google.android.gms.internal.rq;
import com.google.android.gms.internal.vg;
import com.google.android.gms.internal.vk;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.xu;
import com.google.android.gms.internal.yy;
import com.google.android.gms.internal.yy.C3457a;
import com.google.android.gms.internal.yz;
import com.google.android.gms.internal.ze;
import com.google.android.gms.internal.zg;
import com.google.android.gms.internal.zh;
import com.google.android.gms.internal.zn;
import com.google.android.gms.internal.zo;
import com.google.android.gms.internal.zw;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzfc;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzhc;
import com.google.android.gms.internal.zzqh;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@wh
public final class zzx implements OnGlobalLayoutListener, OnScrollChangedListener {
    private zw f7104A;
    private boolean f7105B;
    private boolean f7106C;
    private boolean f7107D;
    final String f7108a;
    final ed f7109b;
    @Nullable
    zza f7110c;
    @Nullable
    oo f7111d;
    @Nullable
    op f7112e;
    @Nullable
    ov f7113f;
    @Nullable
    ox f7114g;
    @Nullable
    vg f7115h;
    @Nullable
    vk f7116i;
    @Nullable
    rn f7117j;
    @Nullable
    ro f7118k;
    SimpleArrayMap<String, rp> f7119l;
    SimpleArrayMap<String, rq> f7120m;
    zzhc f7121n;
    @Nullable
    zzft f7122o;
    @Nullable
    zzfc f7123p;
    @Nullable
    qn f7124q;
    @Nullable
    xu f7125r;
    @Nullable
    List<String> f7126s;
    @Nullable
    zzk f7127t;
    @Nullable
    View f7128u;
    boolean f7129v;
    boolean f7130w;
    private HashSet<yz> f7131x;
    private int f7132y;
    private int f7133z;
    public final Context zzqn;
    @Nullable
    public ze zzvM;
    public int zzvO;
    public String zzvl;
    public final zzqh zzvn;
    @Nullable
    public zg zzvp;
    @Nullable
    public zn zzvq;
    public zzeg zzvr;
    @Nullable
    public yy zzvs;
    public C3457a zzvt;
    @Nullable
    public yz zzvu;

    public static class zza extends ViewSwitcher {
        private final zo f7101a;
        @Nullable
        private final aab f7102b;
        private boolean f7103c = true;

        public zza(Context context, String str, String str2, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
            super(context);
            this.f7101a = new zo(context);
            this.f7101a.m15234a(str);
            this.f7101a.m15235b(str2);
            if (context instanceof Activity) {
                this.f7102b = new aab((Activity) context, this, onGlobalLayoutListener, onScrollChangedListener);
            } else {
                this.f7102b = new aab(null, this, onGlobalLayoutListener, onScrollChangedListener);
            }
            this.f7102b.m8390a();
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f7102b != null) {
                this.f7102b.m8393c();
            }
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f7102b != null) {
                this.f7102b.m8394d();
            }
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (this.f7103c) {
                this.f7101a.m15233a(motionEvent);
            }
            return false;
        }

        public void removeAllViews() {
            List<aat> arrayList = new ArrayList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt != null && (childAt instanceof aat)) {
                    arrayList.add((aat) childAt);
                }
            }
            super.removeAllViews();
            for (aat destroy : arrayList) {
                destroy.destroy();
            }
        }

        public void zzds() {
            zh.m15051a("Disable position monitoring on adFrame.");
            if (this.f7102b != null) {
                this.f7102b.m8392b();
            }
        }

        public zo zzdw() {
            return this.f7101a;
        }

        public void zzdx() {
            zh.m15051a("Enable debug gesture detector on adFrame.");
            this.f7103c = true;
        }

        public void zzdy() {
            zh.m15051a("Disable debug gesture detector on adFrame.");
            this.f7103c = false;
        }
    }

    public zzx(Context context, zzeg com_google_android_gms_internal_zzeg, String str, zzqh com_google_android_gms_internal_zzqh) {
        this(context, com_google_android_gms_internal_zzeg, str, com_google_android_gms_internal_zzqh, null);
    }

    zzx(Context context, zzeg com_google_android_gms_internal_zzeg, String str, zzqh com_google_android_gms_internal_zzqh, ed edVar) {
        this.zzvM = null;
        this.f7128u = null;
        this.zzvO = 0;
        this.f7129v = false;
        this.f7130w = false;
        this.f7131x = null;
        this.f7132y = -1;
        this.f7133z = -1;
        this.f7105B = true;
        this.f7106C = true;
        this.f7107D = false;
        qb.m13268a(context);
        if (zzw.zzcQ().m15017f() != null) {
            List b = qb.m13269b();
            if (com_google_android_gms_internal_zzqh.f12082b != 0) {
                b.add(Integer.toString(com_google_android_gms_internal_zzqh.f12082b));
            }
            zzw.zzcQ().m15017f().m13282a(b);
        }
        this.f7108a = UUID.randomUUID().toString();
        if (com_google_android_gms_internal_zzeg.f11898d || com_google_android_gms_internal_zzeg.f11902h) {
            this.f7110c = null;
        } else {
            this.f7110c = new zza(context, str, com_google_android_gms_internal_zzqh.f12081a, this, this);
            this.f7110c.setMinimumWidth(com_google_android_gms_internal_zzeg.f11900f);
            this.f7110c.setMinimumHeight(com_google_android_gms_internal_zzeg.f11897c);
            this.f7110c.setVisibility(4);
        }
        this.zzvr = com_google_android_gms_internal_zzeg;
        this.zzvl = str;
        this.zzqn = context;
        this.zzvn = com_google_android_gms_internal_zzqh;
        if (edVar == null) {
            edVar = new ed(new C2326a(this));
        }
        this.f7109b = edVar;
        this.f7104A = new zw(200);
        this.f7120m = new SimpleArrayMap();
    }

    private void m7594a() {
        if (this.f7110c != null) {
            View findViewById = this.f7110c.getRootView().findViewById(16908290);
            if (findViewById != null) {
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                this.f7110c.getGlobalVisibleRect(rect);
                findViewById.getGlobalVisibleRect(rect2);
                if (rect.top != rect2.top) {
                    this.f7105B = false;
                }
                if (rect.bottom != rect2.bottom) {
                    this.f7106C = false;
                }
            }
        }
    }

    private void m7595a(boolean z) {
        boolean z2 = true;
        if (this.f7110c != null && this.zzvs != null && this.zzvs.f11527b != null && this.zzvs.f11527b.mo3424l() != null) {
            if (!z || this.f7104A.m15282a()) {
                if (this.zzvs.f11527b.mo3424l().m8558b()) {
                    int[] iArr = new int[2];
                    this.f7110c.getLocationOnScreen(iArr);
                    int b = ol.m12979a().m8410b(this.zzqn, iArr[0]);
                    int b2 = ol.m12979a().m8410b(this.zzqn, iArr[1]);
                    if (!(b == this.f7132y && b2 == this.f7133z)) {
                        this.f7132y = b;
                        this.f7133z = b2;
                        aau l = this.zzvs.f11527b.mo3424l();
                        b = this.f7132y;
                        int i = this.f7133z;
                        if (z) {
                            z2 = false;
                        }
                        l.m8541a(b, i, z2);
                    }
                }
                m7594a();
            }
        }
    }

    public void destroy() {
        zzds();
        this.f7112e = null;
        this.f7113f = null;
        this.f7116i = null;
        this.f7115h = null;
        this.f7124q = null;
        this.f7114g = null;
        zzh(false);
        if (this.f7110c != null) {
            this.f7110c.removeAllViews();
        }
        zzdn();
        zzdp();
        this.zzvs = null;
    }

    public void onGlobalLayout() {
        m7595a(false);
    }

    public void onScrollChanged() {
        m7595a(true);
        this.f7107D = true;
    }

    public void zza(HashSet<yz> hashSet) {
        this.f7131x = hashSet;
    }

    public HashSet<yz> zzdm() {
        return this.f7131x;
    }

    public void zzdn() {
        if (this.zzvs != null && this.zzvs.f11527b != null) {
            this.zzvs.f11527b.destroy();
        }
    }

    public void zzdo() {
        if (this.zzvs != null && this.zzvs.f11527b != null) {
            this.zzvs.f11527b.stopLoading();
        }
    }

    public void zzdp() {
        if (this.zzvs != null && this.zzvs.f11541p != null) {
            try {
                this.zzvs.f11541p.mo4074c();
            } catch (RemoteException e) {
                aad.m8426e("Could not destroy mediation adapter.");
            }
        }
    }

    public boolean zzdq() {
        return this.zzvO == 0;
    }

    public boolean zzdr() {
        return this.zzvO == 1;
    }

    public void zzds() {
        if (this.f7110c != null) {
            this.f7110c.zzds();
        }
    }

    public String zzdu() {
        return (this.f7105B && this.f7106C) ? "" : this.f7105B ? this.f7107D ? "top-scrollable" : "top-locked" : this.f7106C ? this.f7107D ? "bottom-scrollable" : "bottom-locked" : "";
    }

    public void zzdv() {
        if (this.zzvu != null) {
            if (this.zzvs != null) {
                this.zzvu.m14969a(this.zzvs.f11517A);
                this.zzvu.m14973b(this.zzvs.f11518B);
                this.zzvu.m14974b(this.zzvs.f11539n);
            }
            this.zzvu.m14971a(this.zzvr.f11898d);
        }
    }

    public void zzh(boolean z) {
        if (this.zzvO == 0) {
            zzdo();
        }
        if (this.zzvp != null) {
            this.zzvp.cancel();
        }
        if (this.zzvq != null) {
            this.zzvq.cancel();
        }
        if (z) {
            this.zzvs = null;
        }
    }
}
