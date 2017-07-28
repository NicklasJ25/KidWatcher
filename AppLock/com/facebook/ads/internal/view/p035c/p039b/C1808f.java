package com.facebook.ads.internal.view.p035c.p039b;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.p018m.ab;
import com.facebook.ads.internal.p022h.C1511s;
import com.facebook.ads.internal.view.C1864k;
import com.facebook.ads.internal.view.p035c.p036a.C1758b;
import com.facebook.ads.internal.view.p035c.p036a.C1766j;

public class C1808f extends C1785n implements OnLayoutChangeListener {
    private final ImageView f4498b;
    private final C1511s<C1766j> f4499c = new C18061(this);
    private final C1511s<C1758b> f4500d = new C18072(this);

    class C18061 extends C1511s<C1766j> {
        final /* synthetic */ C1808f f4496a;

        C18061(C1808f c1808f) {
            this.f4496a = c1808f;
        }

        public Class<C1766j> mo2709a() {
            return C1766j.class;
        }

        public void m5097a(C1766j c1766j) {
            this.f4496a.setVisibility(8);
        }
    }

    class C18072 extends C1511s<C1758b> {
        final /* synthetic */ C1808f f4497a;

        C18072(C1808f c1808f) {
            this.f4497a = c1808f;
        }

        public Class<C1758b> mo2709a() {
            return C1758b.class;
        }

        public void m5100a(C1758b c1758b) {
            this.f4497a.setVisibility(0);
        }
    }

    public C1808f(Context context) {
        super(context);
        this.f4498b = new ImageView(context);
        this.f4498b.setScaleType(ScaleType.FIT_CENTER);
        this.f4498b.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    protected void a_(C1864k c1864k) {
        c1864k.getEventBus().m4513a(this.f4499c);
        c1864k.getEventBus().m4513a(this.f4500d);
        c1864k.addOnLayoutChangeListener(this);
        super.a_(c1864k);
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        int i9 = i4 - i2;
        int i10 = i3 - i;
        if (layoutParams.height != i9 || layoutParams.width != i10 || layoutParams.topMargin != i2 || layoutParams.leftMargin != i) {
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(i10, i9);
            layoutParams2.topMargin = i2;
            layoutParams2.leftMargin = i;
            this.f4498b.setLayoutParams(new LayoutParams(i10, i9));
            if (this.f4498b.getParent() == null) {
                addView(this.f4498b);
            }
            setLayoutParams(layoutParams2);
        }
    }

    public void setImage(@Nullable String str) {
        if (str == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        new ab(this.f4498b).m4809a(str);
    }
}
