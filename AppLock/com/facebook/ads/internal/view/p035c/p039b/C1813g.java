package com.facebook.ads.internal.view.p035c.p039b;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.p022h.C1610r;
import com.facebook.ads.internal.view.C1864k;
import com.facebook.ads.internal.view.p035c.p036a.C1701m;
import com.facebook.ads.internal.view.p035c.p036a.C1758b;
import com.facebook.ads.internal.view.p035c.p036a.C1759c;
import com.facebook.ads.internal.view.p035c.p036a.C1764h;
import com.facebook.ads.internal.view.p035c.p036a.C1765i;
import com.facebook.ads.internal.view.p035c.p036a.C1766j;
import com.facebook.ads.internal.view.p035c.p036a.C1767k;
import com.facebook.ads.internal.view.p035c.p036a.C1768l;
import com.facebook.ads.internal.view.p035c.p040c.C1847d;

public class C1813g extends C1785n implements OnTouchListener {
    private final C1701m f4505b;
    private final C1765i f4506c;
    private final C1767k f4507d;
    private final C1759c f4508e;
    private final C1829l f4509f;

    class C18091 extends C1701m {
        final /* synthetic */ C1813g f4501a;

        C18091(C1813g c1813g) {
            this.f4501a = c1813g;
        }

        public void m5102a(C1768l c1768l) {
            this.f4501a.setVisibility(0);
        }
    }

    class C18102 extends C1765i {
        final /* synthetic */ C1813g f4502a;

        C18102(C1813g c1813g) {
            this.f4502a = c1813g;
        }

        public void m5104a(C1764h c1764h) {
            this.f4502a.f4509f.setChecked(true);
        }
    }

    class C18113 extends C1767k {
        final /* synthetic */ C1813g f4503a;

        C18113(C1813g c1813g) {
            this.f4503a = c1813g;
        }

        public void m5106a(C1766j c1766j) {
            this.f4503a.f4509f.setChecked(false);
        }
    }

    class C18124 extends C1759c {
        final /* synthetic */ C1813g f4504a;

        C18124(C1813g c1813g) {
            this.f4504a = c1813g;
        }

        public void m5108a(C1758b c1758b) {
            this.f4504a.f4509f.setChecked(true);
        }
    }

    public C1813g(Context context) {
        this(context, null);
    }

    public C1813g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1813g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4505b = new C18091(this);
        this.f4506c = new C18102(this);
        this.f4507d = new C18113(this);
        this.f4508e = new C18124(this);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f4509f = new C1829l(context);
        this.f4509f.setChecked(true);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (displayMetrics.density * 25.0f), (int) (displayMetrics.density * 25.0f));
        setVisibility(8);
        addView(this.f4509f, layoutParams);
        setClickable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    protected void a_(C1864k c1864k) {
        this.f4509f.setOnTouchListener(this);
        setOnTouchListener(this);
        C1610r eventBus = c1864k.getEventBus();
        eventBus.m4513a(this.f4505b);
        eventBus.m4513a(this.f4508e);
        eventBus.m4513a(this.f4506c);
        eventBus.m4513a(this.f4507d);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        C1864k videoView = getVideoView();
        if (videoView == null) {
            return false;
        }
        if (videoView.getState() == C1847d.PREPARED || videoView.getState() == C1847d.PAUSED || videoView.getState() == C1847d.PLAYBACK_COMPLETED) {
            videoView.mo2828d();
            return true;
        } else if (videoView.getState() != C1847d.STARTED) {
            return false;
        } else {
            videoView.m5256e();
            return false;
        }
    }
}
