package com.facebook.ads.internal.view.p035c.p039b;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.p022h.C1511s;
import com.facebook.ads.internal.view.C1864k;
import com.facebook.ads.internal.view.p035c.p036a.C1768l;

public class C1822j extends C1785n {
    private final ProgressBar f4534b;
    private final C1511s<C1768l> f4535c;

    class C18211 extends C1511s<C1768l> {
        final /* synthetic */ C1822j f4533a;

        C18211(C1822j c1822j) {
            this.f4533a = c1822j;
        }

        public Class<C1768l> mo2709a() {
            return C1768l.class;
        }

        public void m5130a(C1768l c1768l) {
            this.f4533a.setVisibility(8);
        }
    }

    public C1822j(Context context) {
        this(context, null);
    }

    public C1822j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1822j(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4535c = new C18211(this);
        int applyDimension = (int) TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics());
        this.f4534b = new ProgressBar(getContext());
        this.f4534b.setIndeterminate(true);
        this.f4534b.getIndeterminateDrawable().setColorFilter(-1, Mode.SRC_IN);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(applyDimension, applyDimension);
        layoutParams.addRule(13);
        addView(this.f4534b, layoutParams);
    }

    protected void a_(C1864k c1864k) {
        setVisibility(0);
        c1864k.getEventBus().m4513a(this.f4535c);
    }
}
