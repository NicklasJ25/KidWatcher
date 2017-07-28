package com.facebook.ads.internal.p034k;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import com.facebook.ads.internal.C1668j;
import com.facebook.ads.internal.p018m.C1486l;
import com.facebook.ads.internal.p018m.C1719m;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p018m.aa;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class C1671a {
    private static final String f4104a = C1671a.class.getSimpleName();
    private final View f4105b;
    private final int f4106c;
    private final int f4107d;
    private final C1669a f4108e;
    private final Handler f4109f;
    private final Runnable f4110g;
    private final boolean f4111h;
    private int f4112i;
    private int f4113j;
    private boolean f4114k;
    private C1672b f4115l;
    private Map<String, Integer> f4116m;
    private long f4117n;
    private int f4118o;

    public static abstract class C1669a {
        public abstract void mo2782a();

        public void mo2819b() {
        }
    }

    private static final class C1670b extends C1486l<C1671a> {
        public C1670b(C1671a c1671a) {
            super(c1671a);
        }

        public void run() {
            int i = 0;
            C1671a c1671a = (C1671a) m3873a();
            if (c1671a != null) {
                View a = c1671a.f4105b;
                C1669a b = c1671a.f4108e;
                if (a != null && b != null) {
                    C1672b a2 = C1671a.m4743a(a, c1671a.f4106c);
                    if (a2.m4763a()) {
                        c1671a.f4118o = c1671a.f4118o + 1;
                    } else {
                        c1671a.f4118o = 0;
                    }
                    int i2 = c1671a.f4118o > c1671a.f4107d ? 1 : 0;
                    int i3 = (c1671a.f4115l == null || !c1671a.f4115l.m4763a()) ? 0 : 1;
                    if (!(i2 == 0 && a2.m4763a())) {
                        c1671a.f4115l = a2;
                    }
                    String valueOf = String.valueOf(a2.m4764b());
                    synchronized (c1671a) {
                        if (c1671a.f4116m.containsKey(valueOf)) {
                            i = ((Integer) c1671a.f4116m.get(valueOf)).intValue();
                        }
                        c1671a.f4116m.put(valueOf, Integer.valueOf(i + 1));
                    }
                    if (i2 != 0 && i3 == 0) {
                        c1671a.f4117n = System.currentTimeMillis();
                        b.mo2782a();
                        if (!c1671a.f4111h) {
                            return;
                        }
                    } else if (i2 == 0 && i3 != 0) {
                        b.mo2819b();
                    }
                    if (!c1671a.f4114k) {
                        c1671a.f4109f.postDelayed(c1671a.f4110g, (long) c1671a.f4113j);
                    }
                }
            }
        }
    }

    public C1671a(View view, int i, int i2, boolean z, C1669a c1669a) {
        this.f4109f = new Handler();
        this.f4110g = new C1670b(this);
        this.f4112i = 0;
        this.f4113j = 1000;
        this.f4114k = true;
        this.f4115l = new C1672b(C1673c.UNKNOWN);
        this.f4116m = new HashMap();
        this.f4117n = 0;
        this.f4118o = 0;
        this.f4105b = view;
        this.f4106c = i;
        this.f4108e = c1669a;
        this.f4111h = z;
        if (i2 < 0) {
            i2 = 0;
        }
        this.f4107d = i2;
    }

    public C1671a(View view, int i, C1669a c1669a) {
        this(view, i, 0, false, c1669a);
    }

    public C1671a(View view, int i, boolean z, C1669a c1669a) {
        this(view, i, 0, z, c1669a);
    }

    public static C1672b m4743a(View view, int i) {
        if (view == null) {
            C1671a.m4745a(view, false, "adView is null.");
            return new C1672b(C1673c.AD_IS_NULL);
        } else if (view.getParent() == null) {
            C1671a.m4745a(view, false, "adView has no parent.");
            return new C1672b(C1673c.INVALID_PARENT);
        } else if (view.getWindowVisibility() != 0) {
            C1671a.m4745a(view, false, "adView window is not set to VISIBLE.");
            return new C1672b(C1673c.INVALID_WINDOW);
        } else if (view.getVisibility() != 0) {
            C1671a.m4745a(view, false, "adView is not set to VISIBLE.");
            return new C1672b(C1673c.AD_IS_NOT_VISIBLE);
        } else if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
            C1671a.m4745a(view, false, "adView has invisible dimensions (w=" + view.getMeasuredWidth() + ", h=" + view.getMeasuredHeight());
            return new C1672b(C1673c.INVALID_DIMENSIONS);
        } else if (view.getAlpha() < 0.9f) {
            C1671a.m4745a(view, false, "adView is too transparent.");
            return new C1672b(C1673c.AD_IS_TRANSPARENT);
        } else {
            int width = view.getWidth();
            int height = view.getHeight();
            int[] iArr = new int[2];
            try {
                view.getLocationOnScreen(iArr);
                Context context = view.getContext();
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                Rect rect = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
                float f = 0.0f;
                if (rect.intersect(iArr[0], iArr[1], iArr[0] + width, iArr[1] + height)) {
                    f = (((float) (rect.width() * rect.height())) * 1.0f) / ((float) (width * height));
                }
                boolean m = C1668j.m4730m(context);
                int n = C1668j.m4731n(context);
                if (m) {
                    f *= 100.0f;
                    if (f < ((float) n)) {
                        C1671a.m4745a(view, false, String.format("adView visible area is too small [%.2f%% visible, current threshold %d%%]", new Object[]{Float.valueOf(f), Integer.valueOf(n)}));
                        return new C1672b(C1673c.AD_INSUFFICIENT_VISIBLE_AREA, f);
                    }
                } else if (iArr[0] < 0 || displayMetrics.widthPixels - iArr[0] < width) {
                    C1671a.m4745a(view, false, "adView is not fully on screen horizontally.");
                    return new C1672b(C1673c.AD_OFFSCREEN_HORIZONTALLY, f);
                } else {
                    width = (int) ((((double) height) * (100.0d - ((double) i))) / 100.0d);
                    if (iArr[1] < 0 && Math.abs(iArr[1]) > width) {
                        C1671a.m4745a(view, false, "adView is not visible from the top.");
                        return new C1672b(C1673c.AD_OFFSCREEN_TOP, f);
                    } else if ((height + iArr[1]) - displayMetrics.heightPixels > width) {
                        C1671a.m4745a(view, false, "adView is not visible from the bottom.");
                        return new C1672b(C1673c.AD_OFFSCREEN_BOTTOM, f);
                    }
                }
                if (aa.m4805b(context)) {
                    Map a = C1719m.m4933a(context);
                    if (C1719m.m4934a(a)) {
                        C1671a.m4745a(view, false, "Keyguard is obstructing view.");
                        return new C1672b(C1673c.AD_IS_OBSTRUCTED_BY_KEYGUARD, f);
                    } else if (C1668j.m4719b(context) && C1719m.m4936b(a)) {
                        C1671a.m4745a(view, false, "Ad is on top of the Lockscreen.");
                        return new C1672b(C1673c.AD_IN_LOCKSCREEN, f, a);
                    } else {
                        C1671a.m4745a(view, true, "adView is visible.");
                        return new C1672b(C1673c.IS_VIEWABLE, f, a);
                    }
                }
                C1671a.m4745a(view, false, "Screen is not interactive.");
                return new C1672b(C1673c.SCREEN_NOT_INTERACTIVE, f);
            } catch (NullPointerException e) {
                C1671a.m4745a(view, false, "Cannot get location on screen.");
                return new C1672b(C1673c.INVALID_DIMENSIONS);
            }
        }
    }

    private static void m4745a(View view, boolean z, String str) {
    }

    public void m4758a() {
        this.f4109f.postDelayed(this.f4110g, (long) this.f4112i);
        this.f4114k = false;
        this.f4118o = 0;
    }

    public void m4759a(int i) {
        this.f4112i = i;
    }

    public void m4760a(Map<String, String> map) {
        map.put("vrc", String.valueOf(this.f4115l.m4764b()));
        map.put("vp", String.valueOf(this.f4115l.m4765c()));
        map.put("vh", new JSONObject(this.f4116m).toString());
        map.put("vt", C1729s.m4961a(this.f4117n));
        map.putAll(this.f4115l.m4766d());
    }

    public void m4761b() {
        this.f4109f.removeCallbacks(this.f4110g);
        this.f4114k = true;
        this.f4118o = 0;
    }

    public void m4762b(int i) {
        this.f4113j = i;
    }
}
