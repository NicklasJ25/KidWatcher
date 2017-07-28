package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzw;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

@wh
public class mv implements OnGlobalLayoutListener, OnScrollChangedListener {
    protected final Object f9872a = new Object();
    protected final mt f9873b;
    @Nullable
    BroadcastReceiver f9874c;
    private final WeakReference<yy> f9875d;
    private WeakReference<ViewTreeObserver> f9876e;
    private final nd f9877f;
    private final Context f9878g;
    private final WindowManager f9879h;
    private final PowerManager f9880i;
    private final KeyguardManager f9881j;
    @Nullable
    private mw f9882k;
    private boolean f9883l;
    private boolean f9884m = false;
    private boolean f9885n = false;
    private boolean f9886o;
    private boolean f9887p;
    private boolean f9888q;
    private final HashSet<Object> f9889r = new HashSet();
    private zw f9890s;
    private final HashSet<mz> f9891t = new HashSet();

    class C30641 extends BroadcastReceiver {
        final /* synthetic */ mv f9865a;

        C30641(mv mvVar) {
            this.f9865a = mvVar;
        }

        public void onReceive(Context context, Intent intent) {
            this.f9865a.m12661a(3);
        }
    }

    public static class C3065a implements nd {
        private WeakReference<qz> f9866a;

        public C3065a(qz qzVar) {
            this.f9866a = new WeakReference(qzVar);
        }

        @Nullable
        public View mo3840a() {
            qz qzVar = (qz) this.f9866a.get();
            return qzVar != null ? qzVar.mo3969e() : null;
        }

        public boolean mo3841b() {
            return this.f9866a.get() == null;
        }

        public nd mo3842c() {
            return new C3066b((qz) this.f9866a.get());
        }
    }

    public static class C3066b implements nd {
        private qz f9867a;

        public C3066b(qz qzVar) {
            this.f9867a = qzVar;
        }

        public View mo3840a() {
            return this.f9867a != null ? this.f9867a.mo3969e() : null;
        }

        public boolean mo3841b() {
            return this.f9867a == null;
        }

        public nd mo3842c() {
            return this;
        }
    }

    public static class C3067c implements nd {
        @Nullable
        private final View f9868a;
        @Nullable
        private final yy f9869b;

        public C3067c(View view, yy yyVar) {
            this.f9868a = view;
            this.f9869b = yyVar;
        }

        public View mo3840a() {
            return this.f9868a;
        }

        public boolean mo3841b() {
            return this.f9869b == null || this.f9868a == null;
        }

        public nd mo3842c() {
            return this;
        }
    }

    public static class C3068d implements nd {
        private final WeakReference<View> f9870a;
        private final WeakReference<yy> f9871b;

        public C3068d(View view, yy yyVar) {
            this.f9870a = new WeakReference(view);
            this.f9871b = new WeakReference(yyVar);
        }

        public View mo3840a() {
            return (View) this.f9870a.get();
        }

        public boolean mo3841b() {
            return this.f9870a.get() == null || this.f9871b.get() == null;
        }

        public nd mo3842c() {
            return new C3067c((View) this.f9870a.get(), (yy) this.f9871b.get());
        }
    }

    public mv(Context context, zzeg com_google_android_gms_internal_zzeg, yy yyVar, zzqh com_google_android_gms_internal_zzqh, nd ndVar) {
        this.f9875d = new WeakReference(yyVar);
        this.f9877f = ndVar;
        this.f9876e = new WeakReference(null);
        this.f9886o = true;
        this.f9888q = false;
        this.f9890s = new zw(200);
        this.f9873b = new mt(UUID.randomUUID().toString(), com_google_android_gms_internal_zzqh, com_google_android_gms_internal_zzeg.f11895a, yyVar.f11535j, yyVar.m14963a(), com_google_android_gms_internal_zzeg.f11902h);
        this.f9879h = (WindowManager) context.getSystemService("window");
        this.f9880i = (PowerManager) context.getApplicationContext().getSystemService("power");
        this.f9881j = (KeyguardManager) context.getSystemService("keyguard");
        this.f9878g = context;
    }

    protected int m12657a(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    protected JSONObject m12658a(@Nullable View view) {
        if (view == null) {
            return m12683l();
        }
        boolean a = zzw.zzcO().mo4264a(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Throwable e) {
            aad.m8422b("Failure getting view location.", e);
        }
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.f9879h.getDefaultDisplay().getWidth();
        rect2.bottom = this.f9879h.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, null);
        Rect rect4 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect4);
        Rect rect5 = new Rect();
        view.getHitRect(rect5);
        JSONObject i = m12680i();
        i.put("windowVisibility", view.getWindowVisibility()).put("isAttachedToWindow", a).put("viewBox", new JSONObject().put("top", m12657a(rect2.top, displayMetrics)).put("bottom", m12657a(rect2.bottom, displayMetrics)).put("left", m12657a(rect2.left, displayMetrics)).put("right", m12657a(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", m12657a(rect.top, displayMetrics)).put("bottom", m12657a(rect.bottom, displayMetrics)).put("left", m12657a(rect.left, displayMetrics)).put("right", m12657a(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", m12657a(rect3.top, displayMetrics)).put("bottom", m12657a(rect3.bottom, displayMetrics)).put("left", m12657a(rect3.left, displayMetrics)).put("right", m12657a(rect3.right, displayMetrics))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", m12657a(rect4.top, displayMetrics)).put("bottom", m12657a(rect4.bottom, displayMetrics)).put("left", m12657a(rect4.left, displayMetrics)).put("right", m12657a(rect4.right, displayMetrics))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", m12657a(rect5.top, displayMetrics)).put("bottom", m12657a(rect5.bottom, displayMetrics)).put("left", m12657a(rect5.left, displayMetrics)).put("right", m12657a(rect5.right, displayMetrics))).put("screenDensity", (double) displayMetrics.density).put("isVisible", zzw.zzcM().m15133a(view, this.f9880i, this.f9881j));
        return i;
    }

    JSONObject m12659a(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }

    protected void m12660a() {
        synchronized (this.f9872a) {
            if (this.f9874c != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.f9874c = new C30641(this);
            this.f9878g.registerReceiver(this.f9874c, intentFilter);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void m12661a(int r8) {
        /*
        r7 = this;
        r0 = 0;
        r1 = 1;
        r3 = r7.f9872a;
        monitor-enter(r3);
        r2 = r7.m12682k();	 Catch:{ all -> 0x0041 }
        if (r2 == 0) goto L_0x000f;
    L_0x000b:
        r2 = r7.f9886o;	 Catch:{ all -> 0x0041 }
        if (r2 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
    L_0x0010:
        return;
    L_0x0011:
        r2 = r7.f9877f;	 Catch:{ all -> 0x0041 }
        r4 = r2.mo3840a();	 Catch:{ all -> 0x0041 }
        if (r4 == 0) goto L_0x0044;
    L_0x0019:
        r2 = com.google.android.gms.ads.internal.zzw.zzcM();	 Catch:{ all -> 0x0041 }
        r5 = r7.f9880i;	 Catch:{ all -> 0x0041 }
        r6 = r7.f9881j;	 Catch:{ all -> 0x0041 }
        r2 = r2.m15133a(r4, r5, r6);	 Catch:{ all -> 0x0041 }
        if (r2 == 0) goto L_0x0044;
    L_0x0027:
        r2 = new android.graphics.Rect;	 Catch:{ all -> 0x0041 }
        r2.<init>();	 Catch:{ all -> 0x0041 }
        r5 = 0;
        r2 = r4.getGlobalVisibleRect(r2, r5);	 Catch:{ all -> 0x0041 }
        if (r2 == 0) goto L_0x0044;
    L_0x0033:
        r2 = r1;
    L_0x0034:
        r5 = r7.f9877f;	 Catch:{ all -> 0x0041 }
        r5 = r5.mo3841b();	 Catch:{ all -> 0x0041 }
        if (r5 == 0) goto L_0x0046;
    L_0x003c:
        r7.m12675d();	 Catch:{ all -> 0x0041 }
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
        goto L_0x0010;
    L_0x0041:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
        throw r0;
    L_0x0044:
        r2 = r0;
        goto L_0x0034;
    L_0x0046:
        if (r8 != r1) goto L_0x0049;
    L_0x0048:
        r0 = r1;
    L_0x0049:
        if (r0 == 0) goto L_0x0059;
    L_0x004b:
        r0 = r7.f9890s;	 Catch:{ all -> 0x0041 }
        r0 = r0.m15282a();	 Catch:{ all -> 0x0041 }
        if (r0 != 0) goto L_0x0059;
    L_0x0053:
        r0 = r7.f9888q;	 Catch:{ all -> 0x0041 }
        if (r2 != r0) goto L_0x0059;
    L_0x0057:
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
        goto L_0x0010;
    L_0x0059:
        if (r2 != 0) goto L_0x0063;
    L_0x005b:
        r0 = r7.f9888q;	 Catch:{ all -> 0x0041 }
        if (r0 != 0) goto L_0x0063;
    L_0x005f:
        if (r8 != r1) goto L_0x0063;
    L_0x0061:
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
        goto L_0x0010;
    L_0x0063:
        r0 = r7.m12658a(r4);	 Catch:{ JSONException -> 0x007c, RuntimeException -> 0x0075 }
        r1 = 0;
        r7.m12667a(r0, r1);	 Catch:{ JSONException -> 0x007c, RuntimeException -> 0x0075 }
        r7.f9888q = r2;	 Catch:{ JSONException -> 0x007c, RuntimeException -> 0x0075 }
    L_0x006d:
        r7.m12678g();	 Catch:{ all -> 0x0041 }
        r7.m12676e();	 Catch:{ all -> 0x0041 }
        monitor-exit(r3);	 Catch:{ all -> 0x0041 }
        goto L_0x0010;
    L_0x0075:
        r0 = move-exception;
    L_0x0076:
        r1 = "Active view update failed.";
        com.google.android.gms.internal.aad.m8419a(r1, r0);	 Catch:{ all -> 0x0041 }
        goto L_0x006d;
    L_0x007c:
        r0 = move-exception;
        goto L_0x0076;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mv.a(int):void");
    }

    protected void m12662a(View view, Map<String, String> map) {
        m12661a(3);
    }

    void m12663a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        m12662a(com_google_android_gms_internal_aat.mo3405b(), (Map) map);
    }

    public void m12664a(mw mwVar) {
        synchronized (this.f9872a) {
            this.f9882k = mwVar;
        }
    }

    public void m12665a(mz mzVar) {
        if (this.f9891t.isEmpty()) {
            m12660a();
            m12661a(3);
        }
        this.f9891t.add(mzVar);
        try {
            mzVar.mo3843a(m12659a(m12658a(this.f9877f.mo3840a())), false);
        } catch (Throwable e) {
            aad.m8422b("Skipping measurement update for new client.", e);
        }
    }

    void m12666a(mz mzVar, Map<String, String> map) {
        String str = "Received request to untrack: ";
        String valueOf = String.valueOf(this.f9873b.m12627d());
        aad.m8421b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        m12671b(mzVar);
    }

    protected void m12667a(JSONObject jSONObject, boolean z) {
        try {
            m12673b(m12659a(jSONObject), z);
        } catch (Throwable th) {
            aad.m8422b("Skipping active view message.", th);
        }
    }

    protected void m12668a(boolean z) {
        Iterator it = this.f9889r.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    boolean m12669a(@Nullable Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        boolean z = !TextUtils.isEmpty(str) && str.equals(this.f9873b.m12627d());
        return z;
    }

    protected void m12670b() {
        synchronized (this.f9872a) {
            if (this.f9874c != null) {
                try {
                    this.f9878g.unregisterReceiver(this.f9874c);
                } catch (Throwable e) {
                    aad.m8422b("Failed trying to unregister the receiver", e);
                } catch (Throwable e2) {
                    zzw.zzcQ().m15000a(e2, "ActiveViewUnit.stopScreenStatusMonitoring");
                }
                this.f9874c = null;
            }
        }
    }

    public void m12671b(mz mzVar) {
        this.f9891t.remove(mzVar);
        mzVar.mo3845b();
        if (this.f9891t.isEmpty()) {
            m12674c();
        }
    }

    void m12672b(Map<String, String> map) {
        if (map.containsKey("isVisible")) {
            boolean z = "1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"));
            m12668a(z);
        }
    }

    protected void m12673b(JSONObject jSONObject, boolean z) {
        Iterator it = new ArrayList(this.f9891t).iterator();
        while (it.hasNext()) {
            ((mz) it.next()).mo3843a(jSONObject, z);
        }
    }

    protected void m12674c() {
        synchronized (this.f9872a) {
            m12679h();
            m12670b();
            this.f9886o = false;
            m12676e();
            m12681j();
        }
    }

    public void m12675d() {
        synchronized (this.f9872a) {
            if (this.f9886o) {
                this.f9887p = true;
                try {
                    m12667a(m12685n(), true);
                } catch (Throwable e) {
                    aad.m8422b("JSON failure while processing active view data.", e);
                } catch (Throwable e2) {
                    aad.m8422b("Failure while processing active view data.", e2);
                }
                String str = "Untracking ad unit: ";
                String valueOf = String.valueOf(this.f9873b.m12627d());
                aad.m8421b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        }
    }

    protected void m12676e() {
        if (this.f9882k != null) {
            this.f9882k.mo3839a(this);
        }
    }

    public boolean m12677f() {
        boolean z;
        synchronized (this.f9872a) {
            z = this.f9886o;
        }
        return z;
    }

    protected void m12678g() {
        View a = this.f9877f.mo3842c().mo3840a();
        if (a != null) {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f9876e.get();
            ViewTreeObserver viewTreeObserver2 = a.getViewTreeObserver();
            if (viewTreeObserver2 != viewTreeObserver) {
                m12679h();
                if (!this.f9883l || (viewTreeObserver != null && viewTreeObserver.isAlive())) {
                    this.f9883l = true;
                    viewTreeObserver2.addOnScrollChangedListener(this);
                    viewTreeObserver2.addOnGlobalLayoutListener(this);
                }
                this.f9876e = new WeakReference(viewTreeObserver2);
            }
        }
    }

    protected void m12679h() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f9876e.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    protected JSONObject m12680i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.f9873b.m12625b()).put("activeViewJSON", this.f9873b.m12626c()).put("timestamp", zzw.zzcS().mo3361b()).put("adFormat", this.f9873b.m12624a()).put("hashCode", this.f9873b.m12627d()).put("isMraid", this.f9873b.m12628e()).put("isStopped", this.f9885n).put("isPaused", this.f9884m).put("isScreenOn", m12684m()).put("isNative", this.f9873b.m12629f()).put("appMuted", zzw.zzcM().m15160h()).put("appVolume", (double) zzw.zzcM().m15157g()).put("deviceVolume", (double) zzw.zzcM().m15163j(this.f9878g));
        return jSONObject;
    }

    protected void m12681j() {
        Iterator it = new ArrayList(this.f9891t).iterator();
        while (it.hasNext()) {
            m12671b((mz) it.next());
        }
    }

    protected boolean m12682k() {
        Iterator it = this.f9891t.iterator();
        while (it.hasNext()) {
            if (((mz) it.next()).mo3844a()) {
                return true;
            }
        }
        return false;
    }

    protected JSONObject m12683l() {
        return m12680i().put("isAttachedToWindow", false).put("isScreenOn", m12684m()).put("isVisible", false);
    }

    boolean m12684m() {
        return this.f9880i.isScreenOn();
    }

    protected JSONObject m12685n() {
        JSONObject i = m12680i();
        i.put("doneReasonCode", "u");
        return i;
    }

    public void m12686o() {
        synchronized (this.f9872a) {
            this.f9885n = true;
            m12661a(3);
        }
    }

    public void onGlobalLayout() {
        m12661a(2);
    }

    public void onScrollChanged() {
        m12661a(1);
    }

    public void m12687p() {
        synchronized (this.f9872a) {
            this.f9884m = true;
            m12661a(3);
        }
    }

    public void m12688q() {
        synchronized (this.f9872a) {
            this.f9884m = false;
            m12661a(3);
        }
    }

    public mt m12689r() {
        return this.f9873b;
    }
}
