package com.domobile.frame;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1279a;
import com.domobile.frame.ui.C1280b;
import com.domobile.p015b.C1168b.C1158b;
import com.domobile.p015b.C1168b.C1159c;
import com.domobile.p015b.C1168b.C1161e;
import com.domobile.p015b.C1168b.C1162f;
import com.domobile.p015b.C1168b.C1163g;
import com.domobile.p015b.C1168b.C1164h;

public class C1263b implements OnMenuItemClickListener, OnClickListener {
    private Activity f2581a;
    private Resources f2582b;
    private View f2583c;
    private ViewGroup f2584d;
    private ViewGroup f2585e;
    private ViewGroup f2586f;
    private ViewGroup f2587g;
    private ImageButton f2588h;
    private ImageButton f2589i;
    private TextView f2590j;
    private TextView f2591k;
    private LayoutInflater f2592l = null;
    private C1279a f2593m;
    private C1279a f2594n;
    private C1270e f2595o;
    private C1270e f2596p;
    private C1262a f2597q;
    private boolean f2598r = false;
    private int f2599s = 4;
    private OnClickListener f2600t;
    private int f2601u = C1161e.badge_overlay_more_light;

    public interface C1262a {
        void m2988a();
    }

    public C1263b(Activity activity, boolean z, boolean z2, boolean z3) {
        this.f2581a = activity;
        this.f2582b = this.f2581a.getResources();
        this.f2592l = LayoutInflater.from(activity);
        this.f2583c = this.f2592l.inflate(C1163g.domo_action_bar, null);
        m2992a(z, z2, z3);
    }

    private View m2990a(final C1280b c1280b, final boolean z) {
        final View linearLayout = new LinearLayout(this.f2581a);
        linearLayout.setLayoutParams(new LayoutParams(0, -1, 1.0f));
        ImageButton imageButton = new ImageButton(this.f2581a);
        imageButton.setLayoutParams(new LayoutParams(0, -1, 1.0f));
        imageButton.setBackgroundResource(C1148d.m2531g(this.f2581a, C1158b.selectableItemBackground).resourceId);
        imageButton.setImageDrawable(c1280b.getIcon());
        imageButton.setColorFilter(ResourcesCompat.getColor(this.f2582b, C1159c.domo_toolbar_button_tintcolor, null));
        c1280b.m3071a(imageButton);
        linearLayout.addView(imageButton);
        imageButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ C1263b f2578d;

            public void onClick(View view) {
                if (z) {
                    if (this.f2578d.f2600t != null) {
                        this.f2578d.f2600t.onClick(view);
                    }
                    if (this.f2578d.f2594n != null && this.f2578d.f2594n.size() > 0) {
                        if (this.f2578d.f2596p != null) {
                            this.f2578d.f2596p.m3029c();
                        }
                        this.f2578d.f2596p = new C1270e(this.f2578d.f2581a, this.f2578d.f2594n, linearLayout);
                        this.f2578d.f2596p.m3027a();
                        return;
                    }
                    return;
                }
                c1280b.m3075b();
            }
        });
        imageButton.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ C1263b f2580b;

            public boolean onLongClick(View view) {
                if (!TextUtils.isEmpty(c1280b.getTitle())) {
                    C1147a.m2487w(this.f2580b.f2581a, c1280b.getTitle().toString());
                }
                return true;
            }
        });
        return linearLayout;
    }

    private void m2992a(boolean z, boolean z2, boolean z3) {
        this.f2584d = (ViewGroup) m2996a(C1162f.domo_action_bar_titlebar);
        this.f2585e = (ViewGroup) m2996a(C1162f.domo_action_bar_titlebar_titleview);
        this.f2587g = (ViewGroup) m2996a(C1162f.domo_action_bar_container);
        this.f2591k = (TextView) m2996a(C1162f.domo_action_bar_titlebar_title);
        this.f2588h = (ImageButton) m2996a(C1162f.domo_action_bar_titlebar_left);
        this.f2590j = (TextView) m2996a(C1162f.domo_action_bar_titlebar_left_badge);
        this.f2589i = (ImageButton) m2996a(C1162f.domo_action_bar_titlebar_right);
        if (z2) {
            this.f2586f = (ViewGroup) m2996a(C1162f.domo_action_bar_float_toolbar);
        } else {
            this.f2586f = (ViewGroup) m2996a(C1162f.domo_action_bar_toolbar);
        }
        m3010d(false);
        m3012e(false);
        this.f2588h.setOnClickListener(this);
        TypedValue g = C1148d.m2531g(this.f2581a, C1158b.domoActionButtonBackground);
        this.f2588h.setBackgroundResource(g.resourceId);
        this.f2589i.setBackgroundResource(g.resourceId);
        if (z3) {
            m3007c();
        }
    }

    public View m2996a(int i) {
        return this.f2583c == null ? null : this.f2583c.findViewById(i);
    }

    public ViewGroup m2997a() {
        return this.f2583c != null ? (ViewGroup) this.f2583c.getParent() : null;
    }

    public void m2998a(OnClickListener onClickListener) {
        this.f2600t = onClickListener;
    }

    public void m2999a(C1279a c1279a, int i, OnMenuItemClickListener onMenuItemClickListener) {
        if (c1279a != null && c1279a.size() > 0 && c1279a.hasVisibleItems()) {
            if (i <= 0) {
                i = this.f2601u;
            }
            int size = c1279a.size();
            for (int i2 = 0; i2 < size; i2++) {
                c1279a.m3070b(i2).setOnMenuItemClickListener(onMenuItemClickListener);
            }
            m3012e(true);
            this.f2593m = c1279a;
            this.f2589i.setOnClickListener(this);
            if (c1279a.size() == 1) {
                this.f2589i.setBackgroundResource(C1148d.m2531g(this.f2581a, C1158b.domoActionButtonBackground).resourceId);
                this.f2589i.setImageDrawable(c1279a.m3070b(0).getIcon());
                c1279a.m3070b(0).m3071a(this.f2589i);
            } else if (c1279a.size() > 1) {
                this.f2589i.setImageResource(i);
            }
        }
    }

    public void m3000a(Runnable runnable) {
        if (this.f2583c != null) {
            this.f2583c.post(runnable);
        }
    }

    public void m3001a(Runnable runnable, long j) {
        if (this.f2583c != null) {
            this.f2583c.postDelayed(runnable, j);
        }
    }

    public void m3002a(boolean z) {
        this.f2598r = z;
        m2996a(C1162f.domo_action_bar_titlebar_margin).setVisibility(z ? 8 : 0);
    }

    public boolean m3003a(View view) {
        return this.f2588h.getId() == view.getId();
    }

    public View m3004b() {
        return this.f2583c;
    }

    public void m3005b(C1279a c1279a, int i, OnMenuItemClickListener onMenuItemClickListener) {
        if (c1279a != null && c1279a.size() > 0 && c1279a.hasVisibleItems()) {
            if (i == 0) {
                i = this.f2601u;
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < c1279a.size()) {
                i2++;
                i3 += c1279a.m3070b(i2).isVisible() ? 1 : 0;
            }
            m3008c(true);
            this.f2586f.removeAllViews();
            this.f2594n = new C1279a(this.f2581a);
            int i4 = 0;
            while (i4 < i3) {
                C1280b b = c1279a.m3070b(i4);
                b.setOnMenuItemClickListener(onMenuItemClickListener);
                if (!(i4 == this.f2599s - 1 && i3 == this.f2599s) && i4 >= this.f2599s - 1) {
                    if (i4 == this.f2599s - 1) {
                        this.f2586f.addView(m2990a(new C1280b(this.f2581a, 0, 0, 0, 0, "").m3073a(i), true));
                    }
                    Drawable mutate = b.getIcon().mutate();
                    mutate.setColorFilter(ResourcesCompat.getColor(this.f2582b, C1159c.domo_toolbar_button_tintcolor, null), Mode.SRC_ATOP);
                    b.setIcon(mutate);
                    this.f2594n.m3068a(b);
                } else {
                    View a = m2990a(b, false);
                    a.setVisibility(!b.isVisible() ? 8 : 0);
                    this.f2586f.addView(a);
                }
                i4++;
            }
        }
    }

    public void m3006b(boolean z) {
        int i = 0;
        View a = m2996a(C1162f.domo_action_bar_titlebar_margin);
        this.f2584d.setVisibility(z ? 0 : 8);
        if (!z) {
            i = 8;
        }
        a.setVisibility(i);
        if (this.f2598r) {
            a.setVisibility(8);
        }
        if (this.f2597q != null) {
            this.f2597q.m2988a();
        }
    }

    public void m3007c() {
        C1279a c1279a = new C1279a(this.f2581a);
        if ((this.f2581a instanceof C0384c) && !((C0384c) this.f2581a).f40g) {
            c1279a.removeItem(C1162f.default_menu_setting);
        }
        this.f2581a.getMenuInflater().inflate(C1164h.default_menus, c1279a);
        m2999a(c1279a, C1161e.titlebar_domo, (OnMenuItemClickListener) this);
    }

    public void m3008c(boolean z) {
        this.f2586f.setVisibility(z ? 0 : 8);
    }

    public ImageButton m3009d() {
        return this.f2588h;
    }

    public void m3010d(boolean z) {
        m2996a(C1162f.domo_action_bar_titlebar_left_layout).setVisibility(z ? 0 : 4);
    }

    public ImageButton m3011e() {
        return this.f2589i;
    }

    public void m3012e(boolean z) {
        m2996a(C1162f.domo_action_bar_titlebar_right_layout).setVisibility(z ? 0 : 4);
    }

    public View m3013f() {
        return this.f2586f;
    }

    public ViewGroup m3014g() {
        return this.f2587g;
    }

    public void m3015h() {
        if (this.f2593m != null && this.f2593m.size() > 1) {
            onClick(this.f2589i);
        }
    }

    public void m3016i() {
        m3008c(false);
    }

    public void onClick(View view) {
        if (!view.isShown()) {
            return;
        }
        if (view == this.f2588h) {
            if (this.f2581a != null) {
                this.f2581a.finish();
            }
        } else if (view == this.f2589i && this.f2593m != null) {
            if (this.f2593m.size() > 1) {
                if (this.f2595o != null) {
                    this.f2595o.m3029c();
                }
                this.f2595o = new C1270e(this.f2581a, this.f2593m, this.f2589i);
                this.f2595o.m3027a();
            } else if (this.f2593m.size() == 1) {
                this.f2593m.m3070b(0).m3075b();
            }
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (this.f2581a instanceof C0384c) {
            int itemId = menuItem.getItemId();
            if (itemId == C1162f.default_menu_rate) {
                ((C0384c) this.f2581a).m47A();
            } else if (itemId == C1162f.default_menu_share) {
                ((C0384c) this.f2581a).m48B();
            }
        }
        return true;
    }
}
