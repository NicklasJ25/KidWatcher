package com.facebook.ads.internal.p021b;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView.ScaleType;
import com.facebook.ads.C1903l;
import com.facebook.ads.internal.p018m.ab;
import com.facebook.ads.internal.p018m.ac;
import com.facebook.ads.internal.view.C1854f;
import com.facebook.ads.internal.view.C1881l;
import com.facebook.ads.internal.view.hscroll.C1871b;
import java.util.List;

public class C1507m extends Adapter<C1854f> {
    private static final int f3541a = Color.argb(51, 0, 0, 0);
    private final List<C1903l> f3542b;
    private final int f3543c;
    private final int f3544d;

    public C1507m(C1871b c1871b, List<C1903l> list) {
        float f = c1871b.getContext().getResources().getDisplayMetrics().density;
        this.f3542b = list;
        this.f3543c = Math.round(f * 1.0f);
        this.f3544d = c1871b.getChildSpacing();
    }

    public C1854f m3986a(ViewGroup viewGroup, int i) {
        C1881l c1881l = new C1881l(viewGroup.getContext());
        c1881l.setScaleType(ScaleType.CENTER_CROP);
        return new C1854f(c1881l);
    }

    public void m3987a(final C1854f c1854f, int i) {
        LayoutParams marginLayoutParams = new MarginLayoutParams(-2, -1);
        marginLayoutParams.setMargins(i == 0 ? this.f3544d * 2 : this.f3544d, 0, i >= this.f3542b.size() + -1 ? this.f3544d * 2 : this.f3544d, 0);
        c1854f.f4654a.setBackgroundColor(0);
        c1854f.f4654a.setImageDrawable(null);
        c1854f.f4654a.setLayoutParams(marginLayoutParams);
        c1854f.f4654a.setPadding(this.f3543c, this.f3543c, this.f3543c, this.f3543c);
        C1903l c1903l = (C1903l) this.f3542b.get(i);
        c1903l.m5404a(c1854f.f4654a);
        if (c1903l.m5415f() != null) {
            ab abVar = new ab(c1854f.f4654a);
            abVar.m4807a(new ac(this) {
                final /* synthetic */ C1507m f3540b;

                public void mo2706a() {
                    c1854f.f4654a.setBackgroundColor(C1507m.f3541a);
                }
            });
            abVar.m4809a(r0.m5367a());
        }
    }

    public int getItemCount() {
        return this.f3542b.size();
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        m3987a((C1854f) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m3986a(viewGroup, i);
    }
}
