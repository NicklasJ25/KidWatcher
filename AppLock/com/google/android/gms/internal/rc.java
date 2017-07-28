package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.formats.AdChoicesView;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.na.C2640b;
import com.google.android.gms.internal.rf.C3153a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@wh
public class rc extends C3153a implements OnClickListener, OnTouchListener, OnGlobalLayoutListener, OnScrollChangedListener {
    static final String[] f10486a = new String[]{"2011", "1009"};
    @Nullable
    FrameLayout f10487b;
    Map<String, WeakReference<View>> f10488c = new HashMap();
    @Nullable
    View f10489d;
    @Nullable
    qz f10490e;
    boolean f10491f = false;
    Point f10492g = new Point();
    Point f10493h = new Point();
    WeakReference<na> f10494i = new WeakReference(null);
    private final Object f10495j = new Object();
    private final FrameLayout f10496k;

    public rc(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f10496k = frameLayout;
        this.f10487b = frameLayout2;
        zzw.zzdk().m8460a(this.f10496k, (OnGlobalLayoutListener) this);
        zzw.zzdk().m8461a(this.f10496k, (OnScrollChangedListener) this);
        this.f10496k.setOnTouchListener(this);
        this.f10496k.setOnClickListener(this);
        qb.m13268a(this.f10496k.getContext());
    }

    private void m13575a(ra raVar) {
        View view;
        ViewGroup viewGroup = null;
        boolean a = raVar.mo3966a();
        if (a && this.f10488c != null) {
            WeakReference weakReference = (WeakReference) this.f10488c.get("1098");
            view = weakReference != null ? (View) weakReference.get() : null;
            if (view instanceof ViewGroup) {
                viewGroup = (ViewGroup) view;
            }
        }
        boolean z = a && viewGroup != null;
        this.f10489d = m13581a(raVar, z);
        if (this.f10489d != null) {
            if (this.f10488c != null) {
                this.f10488c.put("1007", new WeakReference(this.f10489d));
            }
            if (z) {
                viewGroup.removeAllViews();
                viewGroup.addView(this.f10489d);
                return;
            }
            view = m13583a(raVar.mo3970f());
            view.setLayoutParams(new LayoutParams(-1, -1));
            view.addView(this.f10489d);
            if (this.f10487b != null) {
                this.f10487b.addView(view);
            }
        }
    }

    private void m13577b(ra raVar) {
        synchronized (this.f10495j) {
            final View f = m13578f();
            if (f instanceof FrameLayout) {
                raVar.mo3962a(f, new qw(this) {
                    final /* synthetic */ rc f10485b;

                    public void mo3948a() {
                        this.f10485b.onClick(f);
                    }

                    public void mo3949a(MotionEvent motionEvent) {
                        this.f10485b.onTouch(null, motionEvent);
                    }
                });
                return;
            }
            raVar.m13480g();
        }
    }

    private View m13578f() {
        if (this.f10488c == null) {
            return null;
        }
        for (Object obj : f10486a) {
            WeakReference weakReference = (WeakReference) this.f10488c.get(obj);
            if (weakReference != null) {
                return (View) weakReference.get();
            }
        }
        return null;
    }

    int m13579a(int i) {
        return ol.m12979a().m8410b(this.f10490e.mo3970f(), i);
    }

    Point m13580a(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        this.f10496k.getLocationOnScreen(iArr);
        return new Point((int) (motionEvent.getRawX() - ((float) iArr[0])), (int) (motionEvent.getRawY() - ((float) iArr[1])));
    }

    @Nullable
    View m13581a(ra raVar, boolean z) {
        return raVar.mo3959a((OnClickListener) this, z);
    }

    public C2309a mo3881a(String str) {
        Object obj = null;
        synchronized (this.f10495j) {
            if (this.f10488c == null) {
                return null;
            }
            WeakReference weakReference = (WeakReference) this.f10488c.get(str);
            if (weakReference != null) {
                View view = (View) weakReference.get();
            }
            C2309a a = C2312b.m7327a(obj);
            return a;
        }
    }

    AdChoicesView m13583a(Context context) {
        return new AdChoicesView(context);
    }

    public void mo3882a() {
        synchronized (this.f10495j) {
            if (this.f10487b != null) {
                this.f10487b.removeAllViews();
            }
            this.f10487b = null;
            this.f10488c = null;
            this.f10489d = null;
            this.f10490e = null;
            this.f10492g = null;
            this.f10493h = null;
            this.f10494i = null;
        }
    }

    void m13585a(@Nullable View view) {
        if (this.f10490e != null) {
            qz c = this.f10490e instanceof qx ? ((qx) this.f10490e).m13492c() : this.f10490e;
            if (c != null) {
                c.mo3961a(view);
            }
        }
    }

    public void mo3883a(C2309a c2309a) {
        synchronized (this.f10495j) {
            m13585a(null);
            Object a = C2312b.m7328a(c2309a);
            if (a instanceof ra) {
                if (this.f10487b != null) {
                    this.f10487b.setLayoutParams(new LayoutParams(0, 0));
                    this.f10496k.requestLayout();
                }
                this.f10491f = true;
                final ra raVar = (ra) a;
                if (this.f10490e != null && ((Boolean) qb.cj.m13225c()).booleanValue()) {
                    this.f10490e.mo3967b(this.f10496k, this.f10488c);
                }
                m13590c();
                if ((this.f10490e instanceof qx) && ((qx) this.f10490e).m13491b()) {
                    ((qx) this.f10490e).m13488a(raVar);
                } else {
                    this.f10490e = raVar;
                    if (raVar instanceof qx) {
                        ((qx) raVar).m13488a(null);
                    }
                }
                if (((Boolean) qb.cj.m13225c()).booleanValue()) {
                    this.f10487b.setClickable(false);
                }
                this.f10487b.removeAllViews();
                m13575a(raVar);
                raVar.mo3971a(this.f10496k, this.f10488c, (OnTouchListener) this, (OnClickListener) this);
                zl.f11678a.post(new Runnable(this) {
                    final /* synthetic */ rc f10483b;

                    public void run() {
                        aat d = raVar.mo3972d();
                        if (!(d == null || this.f10483b.f10487b == null)) {
                            this.f10483b.f10487b.addView(d.mo3405b());
                        }
                        if (!(raVar instanceof qx)) {
                            this.f10483b.m13577b(raVar);
                        }
                    }
                });
                m13585a(this.f10496k);
                m13589b();
                return;
            }
            aad.m8426e("Not an instance of native engine. This is most likely a transient error");
        }
    }

    public void mo3884a(C2309a c2309a, int i) {
        if (zzw.zzdl().m14949c()) {
            na naVar = (na) this.f10494i.get();
            if (naVar != null) {
                naVar.m12737a();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3885a(java.lang.String r5, com.google.android.gms.p065a.C2309a r6) {
        /*
        r4 = this;
        r0 = com.google.android.gms.p065a.C2312b.m7328a(r6);
        r0 = (android.view.View) r0;
        r1 = r4.f10495j;
        monitor-enter(r1);
        r2 = r4.f10488c;	 Catch:{ all -> 0x0018 }
        if (r2 != 0) goto L_0x000f;
    L_0x000d:
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
    L_0x000e:
        return;
    L_0x000f:
        if (r0 != 0) goto L_0x001b;
    L_0x0011:
        r0 = r4.f10488c;	 Catch:{ all -> 0x0018 }
        r0.remove(r5);	 Catch:{ all -> 0x0018 }
    L_0x0016:
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
        goto L_0x000e;
    L_0x0018:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
        throw r0;
    L_0x001b:
        r2 = r4.f10488c;	 Catch:{ all -> 0x0018 }
        r3 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x0018 }
        r3.<init>(r0);	 Catch:{ all -> 0x0018 }
        r2.put(r5, r3);	 Catch:{ all -> 0x0018 }
        r2 = "1098";
        r2 = r2.equals(r5);	 Catch:{ all -> 0x0018 }
        if (r2 == 0) goto L_0x002f;
    L_0x002d:
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
        goto L_0x000e;
    L_0x002f:
        r0.setOnTouchListener(r4);	 Catch:{ all -> 0x0018 }
        r2 = 1;
        r0.setClickable(r2);	 Catch:{ all -> 0x0018 }
        r0.setOnClickListener(r4);	 Catch:{ all -> 0x0018 }
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.rc.a(java.lang.String, com.google.android.gms.a.a):void");
    }

    void m13589b() {
        if (this.f10490e instanceof ra) {
            ra raVar = (ra) this.f10490e;
            if (zzw.zzdl().m14949c() && raVar != null && raVar.mo3970f() != null) {
                na naVar = (na) this.f10494i.get();
                if (naVar == null) {
                    naVar = new na(this.f10496k.getContext(), this.f10496k);
                    this.f10494i = new WeakReference(naVar);
                }
                naVar.m12739a(raVar.m13483j());
            }
        }
    }

    void m13590c() {
        if (this.f10490e instanceof ra) {
            ra raVar = (ra) this.f10490e;
            if (zzw.zzdl().m14949c() && raVar != null && raVar.mo3970f() != null) {
                C2640b j = raVar.m13483j();
                if (j != null) {
                    j.m14933a(false);
                }
                na naVar = (na) this.f10494i.get();
                if (naVar != null && j != null) {
                    naVar.m12740b(j);
                }
            }
        }
    }

    int m13591d() {
        return this.f10496k.getMeasuredWidth();
    }

    int m13592e() {
        return this.f10496k.getMeasuredHeight();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r8) {
        /*
        r7 = this;
        r6 = r7.f10495j;
        monitor-enter(r6);
        r0 = r7.f10490e;	 Catch:{ all -> 0x0072 }
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r6);	 Catch:{ all -> 0x0072 }
    L_0x0008:
        return;
    L_0x0009:
        r3 = new org.json.JSONObject;	 Catch:{ all -> 0x0072 }
        r3.<init>();	 Catch:{ all -> 0x0072 }
        r0 = "x";
        r1 = r7.f10492g;	 Catch:{ JSONException -> 0x0075 }
        r1 = r1.x;	 Catch:{ JSONException -> 0x0075 }
        r1 = r7.m13579a(r1);	 Catch:{ JSONException -> 0x0075 }
        r3.put(r0, r1);	 Catch:{ JSONException -> 0x0075 }
        r0 = "y";
        r1 = r7.f10492g;	 Catch:{ JSONException -> 0x0075 }
        r1 = r1.y;	 Catch:{ JSONException -> 0x0075 }
        r1 = r7.m13579a(r1);	 Catch:{ JSONException -> 0x0075 }
        r3.put(r0, r1);	 Catch:{ JSONException -> 0x0075 }
        r0 = "start_x";
        r1 = r7.f10493h;	 Catch:{ JSONException -> 0x0075 }
        r1 = r1.x;	 Catch:{ JSONException -> 0x0075 }
        r1 = r7.m13579a(r1);	 Catch:{ JSONException -> 0x0075 }
        r3.put(r0, r1);	 Catch:{ JSONException -> 0x0075 }
        r0 = "start_y";
        r1 = r7.f10493h;	 Catch:{ JSONException -> 0x0075 }
        r1 = r1.y;	 Catch:{ JSONException -> 0x0075 }
        r1 = r7.m13579a(r1);	 Catch:{ JSONException -> 0x0075 }
        r3.put(r0, r1);	 Catch:{ JSONException -> 0x0075 }
    L_0x0042:
        r0 = r7.f10489d;	 Catch:{ all -> 0x0072 }
        if (r0 == 0) goto L_0x0089;
    L_0x0046:
        r0 = r7.f10489d;	 Catch:{ all -> 0x0072 }
        r0 = r0.equals(r8);	 Catch:{ all -> 0x0072 }
        if (r0 == 0) goto L_0x0089;
    L_0x004e:
        r0 = r7.f10490e;	 Catch:{ all -> 0x0072 }
        r0 = r0 instanceof com.google.android.gms.internal.qx;	 Catch:{ all -> 0x0072 }
        if (r0 == 0) goto L_0x007c;
    L_0x0054:
        r0 = r7.f10490e;	 Catch:{ all -> 0x0072 }
        r0 = (com.google.android.gms.internal.qx) r0;	 Catch:{ all -> 0x0072 }
        r0 = r0.m13492c();	 Catch:{ all -> 0x0072 }
        if (r0 == 0) goto L_0x0070;
    L_0x005e:
        r0 = r7.f10490e;	 Catch:{ all -> 0x0072 }
        r0 = (com.google.android.gms.internal.qx) r0;	 Catch:{ all -> 0x0072 }
        r0 = r0.m13492c();	 Catch:{ all -> 0x0072 }
        r2 = "1007";
        r4 = r7.f10488c;	 Catch:{ all -> 0x0072 }
        r5 = r7.f10496k;	 Catch:{ all -> 0x0072 }
        r1 = r8;
        r0.mo3963a(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x0072 }
    L_0x0070:
        monitor-exit(r6);	 Catch:{ all -> 0x0072 }
        goto L_0x0008;
    L_0x0072:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0072 }
        throw r0;
    L_0x0075:
        r0 = move-exception;
        r0 = "Unable to get click location";
        com.google.android.gms.internal.aad.m8426e(r0);	 Catch:{ all -> 0x0072 }
        goto L_0x0042;
    L_0x007c:
        r0 = r7.f10490e;	 Catch:{ all -> 0x0072 }
        r2 = "1007";
        r4 = r7.f10488c;	 Catch:{ all -> 0x0072 }
        r5 = r7.f10496k;	 Catch:{ all -> 0x0072 }
        r1 = r8;
        r0.mo3963a(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x0072 }
        goto L_0x0070;
    L_0x0089:
        r0 = r7.f10490e;	 Catch:{ all -> 0x0072 }
        r1 = r7.f10488c;	 Catch:{ all -> 0x0072 }
        r2 = r7.f10496k;	 Catch:{ all -> 0x0072 }
        r0.mo3965a(r8, r1, r3, r2);	 Catch:{ all -> 0x0072 }
        goto L_0x0070;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.rc.onClick(android.view.View):void");
    }

    public void onGlobalLayout() {
        synchronized (this.f10495j) {
            if (this.f10491f) {
                int d = m13591d();
                int e = m13592e();
                if (!(d == 0 || e == 0 || this.f10487b == null)) {
                    this.f10487b.setLayoutParams(new LayoutParams(d, e));
                    this.f10491f = false;
                }
            }
            if (this.f10490e != null) {
                this.f10490e.mo3968c(this.f10496k, this.f10488c);
            }
        }
    }

    public void onScrollChanged() {
        synchronized (this.f10495j) {
            if (this.f10490e != null) {
                this.f10490e.mo3968c(this.f10496k, this.f10488c);
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.f10495j) {
            if (this.f10490e == null) {
            } else {
                Point a = m13580a(motionEvent);
                this.f10492g = a;
                if (motionEvent.getAction() == 0) {
                    this.f10493h = a;
                }
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setLocation((float) a.x, (float) a.y);
                this.f10490e.mo3960a(obtain);
                obtain.recycle();
            }
        }
        return false;
    }
}
