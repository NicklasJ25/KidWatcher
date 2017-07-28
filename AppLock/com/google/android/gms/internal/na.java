package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzw;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

@TargetApi(14)
@wh
public class na implements ActivityLifecycleCallbacks, OnAttachStateChangeListener, OnGlobalLayoutListener, OnScrollChangedListener {
    private static final long f9934c = ((Long) qb.bo.m13225c()).longValue();
    @Nullable
    BroadcastReceiver f9935a;
    WeakReference<View> f9936b;
    private final Context f9937d;
    private Application f9938e;
    private final WindowManager f9939f;
    private final PowerManager f9940g;
    private final KeyguardManager f9941h;
    private WeakReference<ViewTreeObserver> f9942i;
    private nb f9943j;
    private zw f9944k = new zw(f9934c);
    private boolean f9945l = false;
    private int f9946m = -1;
    private HashSet<C2640b> f9947n = new HashSet();
    private DisplayMetrics f9948o;

    public interface C2640b {
        void mo3398a(C3084a c3084a);
    }

    class C30821 implements Runnable {
        final /* synthetic */ na f9919a;

        C30821(na naVar) {
            this.f9919a = naVar;
        }

        public void run() {
            this.f9919a.m12727a(3);
        }
    }

    class C30832 extends BroadcastReceiver {
        final /* synthetic */ na f9920a;

        C30832(na naVar) {
            this.f9920a = naVar;
        }

        public void onReceive(Context context, Intent intent) {
            this.f9920a.m12727a(3);
        }
    }

    public static class C3084a {
        public final long f9921a;
        public final boolean f9922b;
        public final boolean f9923c;
        public final int f9924d;
        public final Rect f9925e;
        public final Rect f9926f;
        public final Rect f9927g;
        public final boolean f9928h;
        public final Rect f9929i;
        public final boolean f9930j;
        public final Rect f9931k;
        public final float f9932l;
        public final boolean f9933m;

        public C3084a(long j, boolean z, boolean z2, int i, Rect rect, Rect rect2, Rect rect3, boolean z3, Rect rect4, boolean z4, Rect rect5, float f, boolean z5) {
            this.f9921a = j;
            this.f9922b = z;
            this.f9923c = z2;
            this.f9924d = i;
            this.f9925e = rect;
            this.f9926f = rect2;
            this.f9927g = rect3;
            this.f9928h = z3;
            this.f9929i = rect4;
            this.f9930j = z4;
            this.f9931k = rect5;
            this.f9932l = f;
            this.f9933m = z5;
        }
    }

    public na(Context context, View view) {
        this.f9937d = context.getApplicationContext();
        this.f9939f = (WindowManager) context.getSystemService("window");
        this.f9940g = (PowerManager) this.f9937d.getSystemService("power");
        this.f9941h = (KeyguardManager) context.getSystemService("keyguard");
        if (this.f9937d instanceof Application) {
            this.f9938e = (Application) this.f9937d;
            this.f9943j = new nb((Application) this.f9937d, this);
        }
        this.f9948o = context.getResources().getDisplayMetrics();
        m12738a(view);
    }

    private void m12727a(int i) {
        if (this.f9947n.size() != 0 && this.f9936b != null) {
            View view = (View) this.f9936b.get();
            Object obj = i == 1 ? 1 : null;
            Object obj2 = view == null ? 1 : null;
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            boolean z = false;
            Rect rect3 = new Rect();
            boolean z2 = false;
            Rect rect4 = new Rect();
            Rect rect5 = new Rect();
            rect5.right = this.f9939f.getDefaultDisplay().getWidth();
            rect5.bottom = this.f9939f.getDefaultDisplay().getHeight();
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            if (view != null) {
                z = view.getGlobalVisibleRect(rect2);
                z2 = view.getLocalVisibleRect(rect3);
                view.getHitRect(rect4);
                try {
                    view.getLocationOnScreen(iArr);
                    view.getLocationInWindow(iArr2);
                } catch (Throwable e) {
                    aad.m8422b("Failure getting view location.", e);
                }
                rect.left = iArr[0];
                rect.top = iArr[1];
                rect.right = rect.left + view.getWidth();
                rect.bottom = rect.top + view.getHeight();
            }
            int windowVisibility = view != null ? view.getWindowVisibility() : 8;
            if (this.f9946m != -1) {
                windowVisibility = this.f9946m;
            }
            boolean z3 = obj2 == null && zzw.zzcM().m15133a(view, this.f9940g, this.f9941h) && z && z2 && windowVisibility == 0;
            if (obj != null && !this.f9944k.m15282a() && z3 == this.f9945l) {
                return;
            }
            if (z3 || this.f9945l || i != 1) {
                C3084a c3084a = new C3084a(zzw.zzcS().mo3361b(), this.f9940g.isScreenOn(), view != null ? zzw.zzcO().mo4264a(view) : false, view != null ? view.getWindowVisibility() : 8, m12736a(rect5), m12736a(rect), m12736a(rect2), z, m12736a(rect3), z2, m12736a(rect4), this.f9948o.density, z3);
                Iterator it = this.f9947n.iterator();
                while (it.hasNext()) {
                    ((C2640b) it.next()).mo3398a(c3084a);
                }
                this.f9945l = z3;
            }
        }
    }

    private void m12728a(Activity activity, int i) {
        if (this.f9936b != null) {
            Window window = activity.getWindow();
            if (window != null) {
                View peekDecorView = window.peekDecorView();
                View view = (View) this.f9936b.get();
                if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                    this.f9946m = i;
                }
            }
        }
    }

    private int m12730b(int i) {
        return (int) (((float) i) / this.f9948o.density);
    }

    private void m12731b() {
        zzw.zzcM();
        zl.f11678a.post(new C30821(this));
    }

    private void m12732b(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.f9942i = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        m12733c();
        if (this.f9938e != null) {
            try {
                this.f9938e.registerActivityLifecycleCallbacks(this.f9943j);
            } catch (Throwable e) {
                aad.m8422b("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private void m12733c() {
        if (this.f9935a == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.f9935a = new C30832(this);
            this.f9937d.registerReceiver(this.f9935a, intentFilter);
        }
    }

    private void m12734c(View view) {
        ViewTreeObserver viewTreeObserver;
        try {
            if (this.f9942i != null) {
                viewTreeObserver = (ViewTreeObserver) this.f9942i.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.f9942i = null;
            }
        } catch (Throwable e) {
            aad.m8422b("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnScrollChangedListener(this);
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        } catch (Throwable e2) {
            aad.m8422b("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        m12735d();
        if (this.f9938e != null) {
            try {
                this.f9938e.unregisterActivityLifecycleCallbacks(this.f9943j);
            } catch (Throwable e22) {
                aad.m8422b("Error registering activity lifecycle callbacks.", e22);
            }
        }
    }

    private void m12735d() {
        if (this.f9935a != null) {
            try {
                this.f9937d.unregisterReceiver(this.f9935a);
            } catch (Throwable e) {
                aad.m8422b("Failed trying to unregister the receiver", e);
            } catch (Throwable e2) {
                zzw.zzcQ().m15000a(e2, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.f9935a = null;
        }
    }

    Rect m12736a(Rect rect) {
        return new Rect(m12730b(rect.left), m12730b(rect.top), m12730b(rect.right), m12730b(rect.bottom));
    }

    public void m12737a() {
        m12727a(4);
    }

    public void m12738a(View view) {
        View view2 = this.f9936b != null ? (View) this.f9936b.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            m12734c(view2);
        }
        this.f9936b = new WeakReference(view);
        if (view != null) {
            if (zzw.zzcO().mo4264a(view)) {
                m12732b(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    public void m12739a(C2640b c2640b) {
        this.f9947n.add(c2640b);
        m12727a(3);
    }

    public void m12740b(C2640b c2640b) {
        this.f9947n.remove(c2640b);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        m12728a(activity, 0);
        m12727a(3);
        m12731b();
    }

    public void onActivityDestroyed(Activity activity) {
        m12727a(3);
        m12731b();
    }

    public void onActivityPaused(Activity activity) {
        m12728a(activity, 4);
        m12727a(3);
        m12731b();
    }

    public void onActivityResumed(Activity activity) {
        m12728a(activity, 0);
        m12727a(3);
        m12731b();
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m12727a(3);
        m12731b();
    }

    public void onActivityStarted(Activity activity) {
        m12728a(activity, 0);
        m12727a(3);
        m12731b();
    }

    public void onActivityStopped(Activity activity) {
        m12727a(3);
        m12731b();
    }

    public void onGlobalLayout() {
        m12727a(2);
        m12731b();
    }

    public void onScrollChanged() {
        m12727a(1);
    }

    public void onViewAttachedToWindow(View view) {
        this.f9946m = -1;
        m12732b(view);
        m12727a(3);
    }

    public void onViewDetachedFromWindow(View view) {
        this.f9946m = -1;
        m12727a(3);
        m12731b();
        m12734c(view);
    }
}
