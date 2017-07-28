package com.facebook.ads.internal.view.p035c.p039b;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.view.C1864k;

public abstract class C1785n extends RelativeLayout implements C1784m {
    static final /* synthetic */ boolean f4453a = (!C1785n.class.desiredAssertionStatus());
    private C1864k f4454b;

    public C1785n(Context context) {
        super(context);
    }

    public C1785n(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutParams(new LayoutParams(-1, -1));
    }

    public void mo2783a(C1864k c1864k) {
        this.f4454b = c1864k;
        a_(c1864k);
    }

    protected void a_(C1864k c1864k) {
    }

    protected C1864k getVideoView() {
        if (f4453a || this.f4454b != null) {
            return this.f4454b;
        }
        throw new AssertionError();
    }
}
