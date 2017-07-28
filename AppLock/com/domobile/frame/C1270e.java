package com.domobile.frame;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.PopupWindow.OnDismissListener;
import com.domobile.frame.ui.C1279a;
import com.domobile.frame.ui.C1280b;
import com.domobile.frame.ui.C1301e;
import com.domobile.frame.ui.ListMenuItemView;
import com.domobile.p015b.C1168b.C1161e;
import com.domobile.p015b.C1168b.C1163g;

public class C1270e implements OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int f2608a = C1163g.popup_menu_item_layout;
    boolean f2609b;
    private Context f2610c;
    private LayoutInflater f2611d;
    private C1268a f2612e;
    private ViewTreeObserver f2613f;
    private C1301e f2614g;
    private C1279a f2615h;
    private View f2616i;
    private C1269b f2617j;
    private int f2618k;

    public interface C1268a {
        boolean m3021a(C1279a c1279a, MenuItem menuItem);
    }

    private class C1269b extends BaseAdapter {
        final /* synthetic */ C1270e f2606a;
        private C1279a f2607b;

        public C1269b(C1270e c1270e, C1279a c1279a) {
            this.f2606a = c1270e;
            this.f2607b = c1279a;
        }

        public C1280b m3023a(int i) {
            int i2 = -1;
            int size = this.f2607b.size();
            for (int i3 = 0; i3 < size; i3++) {
                i2 += this.f2607b.m3070b(i3).isVisible() ? 1 : 0;
                if (i2 == i) {
                    break;
                }
            }
            return this.f2607b.m3070b(i2);
        }

        public int getCount() {
            int i = 0;
            for (int i2 = 0; i2 < this.f2607b.size(); i2++) {
                i += this.f2607b.m3070b(i2).isVisible() ? 1 : 0;
            }
            return i;
        }

        public /* synthetic */ Object getItem(int i) {
            return m3023a(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = view == null ? this.f2606a.f2611d.inflate(C1270e.f2608a, null) : view;
            ListMenuItemView listMenuItemView = (ListMenuItemView) inflate;
            listMenuItemView.setHighlightColor(this.f2606a.f2610c.getResources().getColor(C1161e.menu_box_pressed));
            listMenuItemView.setForceShowIcon(this.f2606a.f2609b);
            listMenuItemView.m3063a(m3023a(i), 0);
            return inflate;
        }
    }

    public C1270e(Context context, C1279a c1279a, View view) {
        this(context, c1279a, view, false);
    }

    public C1270e(Context context, C1279a c1279a, View view, boolean z) {
        this.f2609b = true;
        this.f2618k = -1;
        this.f2615h = c1279a;
        this.f2610c = context;
        this.f2616i = view;
        this.f2611d = LayoutInflater.from(context);
    }

    private void m3026e() {
        if (this.f2618k != -1) {
            C1269b c1269b = this.f2617j;
            MenuItem a = c1269b.m3023a(this.f2618k);
            c1269b.f2607b.performIdentifierAction(a.getItemId(), 0);
            this.f2618k = -1;
            if (this.f2612e != null) {
                this.f2612e.m3021a(c1269b.f2607b, a);
            }
        }
    }

    public void m3027a() {
        this.f2618k = -1;
        if (!m3028b()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m3028b() {
        int i = 0;
        this.f2614g = new C1301e(this.f2610c, null, 0);
        this.f2614g.m3169b(0);
        this.f2614g.m3162a(C1161e.dropdown_listview_bg);
        this.f2614g.m3166a((OnDismissListener) this);
        this.f2614g.m3164a((OnItemClickListener) this);
        this.f2617j = new C1269b(this, this.f2615h);
        this.f2614g.m3165a(this.f2617j);
        this.f2614g.m3167a(true);
        View view = this.f2616i;
        if (view == null) {
            return false;
        }
        if (this.f2613f == null) {
            i = 1;
        }
        this.f2613f = view.getViewTreeObserver();
        if (i != 0) {
            this.f2613f.addOnGlobalLayoutListener(this);
        }
        this.f2614g.m3163a(view);
        this.f2614g.m3168b();
        this.f2614g.m3173f().setOnKeyListener(this);
        return true;
    }

    public void m3029c() {
        if (m3030d()) {
            this.f2614g.m3170c();
        }
    }

    public boolean m3030d() {
        return this.f2614g != null && this.f2614g.m3172e();
    }

    public void onDismiss() {
        this.f2614g = null;
        this.f2615h.close();
        if (this.f2613f != null) {
            if (!this.f2613f.isAlive()) {
                this.f2613f = this.f2616i.getViewTreeObserver();
            }
            this.f2613f.removeGlobalOnLayoutListener(this);
            this.f2613f = null;
        }
        m3026e();
    }

    public void onGlobalLayout() {
        if (m3030d()) {
            View view = this.f2616i;
            if (view == null || !view.isShown()) {
                m3029c();
            } else if (m3030d()) {
                this.f2614g.m3168b();
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f2618k = i;
        this.f2614g.m3171d();
        m3029c();
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if ((i != 82 && i != 4) || keyEvent.getAction() != 1 || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        m3029c();
        return true;
    }
}
