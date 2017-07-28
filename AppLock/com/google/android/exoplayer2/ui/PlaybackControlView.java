package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.support.v4.media.TransportMediator;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.google.android.exoplayer2.C2109d;
import com.google.android.exoplayer2.C2129e;
import com.google.android.exoplayer2.C2129e.C1841a;
import com.google.android.exoplayer2.C2150p;
import com.google.android.exoplayer2.C2150p.C2300b;
import com.google.android.exoplayer2.C2295l.C2290a;
import com.google.android.exoplayer2.C2295l.C2291b;
import com.google.android.exoplayer2.C2295l.C2292c;
import com.google.android.exoplayer2.C2295l.C2293d;
import com.google.android.exoplayer2.C2295l.C2294e;
import com.google.android.exoplayer2.p043j.C2273r;
import java.util.Formatter;
import java.util.Locale;

public class PlaybackControlView extends FrameLayout {
    private final C2303a f6603a;
    private final View f6604b;
    private final View f6605c;
    private final ImageButton f6606d;
    private final TextView f6607e;
    private final TextView f6608f;
    private final SeekBar f6609g;
    private final View f6610h;
    private final View f6611i;
    private final StringBuilder f6612j;
    private final Formatter f6613k;
    private final C2300b f6614l;
    private C2129e f6615m;
    private C2304b f6616n;
    private boolean f6617o;
    private int f6618p;
    private int f6619q;
    private int f6620r;
    private long f6621s;
    private final Runnable f6622t;
    private final Runnable f6623u;

    class C23011 implements Runnable {
        final /* synthetic */ PlaybackControlView f6600a;

        C23011(PlaybackControlView playbackControlView) {
            this.f6600a = playbackControlView;
        }

        public void run() {
            this.f6600a.m7304h();
        }
    }

    class C23022 implements Runnable {
        final /* synthetic */ PlaybackControlView f6601a;

        C23022(PlaybackControlView playbackControlView) {
            this.f6601a = playbackControlView;
        }

        public void run() {
            this.f6601a.m7318b();
        }
    }

    private final class C2303a implements OnClickListener, OnSeekBarChangeListener, C1841a {
        final /* synthetic */ PlaybackControlView f6602a;

        private C2303a(PlaybackControlView playbackControlView) {
            this.f6602a = playbackControlView;
        }

        public void mo2787a(C2109d c2109d) {
        }

        public void mo2788a(C2150p c2150p, Object obj) {
            this.f6602a.m7301g();
            this.f6602a.m7304h();
        }

        public void mo2790a(boolean z, int i) {
            this.f6602a.m7299f();
            this.f6602a.m7304h();
        }

        public void mo2792b(boolean z) {
        }

        public void mo2795e() {
            this.f6602a.m7301g();
            this.f6602a.m7304h();
        }

        public void onClick(View view) {
            C2150p f = this.f6602a.f6615m.mo3079f();
            if (this.f6602a.f6605c == view) {
                this.f6602a.m7308j();
            } else if (this.f6602a.f6604b == view) {
                this.f6602a.m7305i();
            } else if (this.f6602a.f6610h == view) {
                this.f6602a.m7312l();
            } else if (this.f6602a.f6611i == view && f != null) {
                this.f6602a.m7309k();
            } else if (this.f6602a.f6606d == view) {
                this.f6602a.f6615m.mo3071a(!this.f6602a.f6615m.mo3075b());
            }
            this.f6602a.m7296d();
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                this.f6602a.f6608f.setText(this.f6602a.m7287a(this.f6602a.m7285a(i)));
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            this.f6602a.removeCallbacks(this.f6602a.f6623u);
            this.f6602a.f6617o = true;
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            this.f6602a.f6617o = false;
            this.f6602a.f6615m.mo3068a(this.f6602a.m7285a(seekBar.getProgress()));
            this.f6602a.m7296d();
        }
    }

    public interface C2304b {
        void m7284a(int i);
    }

    public PlaybackControlView(Context context) {
        this(context, null);
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6622t = new C23011(this);
        this.f6623u = new C23022(this);
        this.f6618p = 5000;
        this.f6619q = 15000;
        this.f6620r = 5000;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C2294e.PlaybackControlView, 0, 0);
            try {
                this.f6618p = obtainStyledAttributes.getInt(C2294e.PlaybackControlView_rewind_increment, this.f6618p);
                this.f6619q = obtainStyledAttributes.getInt(C2294e.PlaybackControlView_fastforward_increment, this.f6619q);
                this.f6620r = obtainStyledAttributes.getInt(C2294e.PlaybackControlView_show_timeout, this.f6620r);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f6614l = new C2300b();
        this.f6612j = new StringBuilder();
        this.f6613k = new Formatter(this.f6612j, Locale.getDefault());
        this.f6603a = new C2303a();
        LayoutInflater.from(context).inflate(C2292c.exo_playback_control_view, this);
        this.f6607e = (TextView) findViewById(C2291b.time);
        this.f6608f = (TextView) findViewById(C2291b.time_current);
        this.f6609g = (SeekBar) findViewById(C2291b.mediacontroller_progress);
        this.f6609g.setOnSeekBarChangeListener(this.f6603a);
        this.f6609g.setMax(1000);
        this.f6606d = (ImageButton) findViewById(C2291b.play);
        this.f6606d.setOnClickListener(this.f6603a);
        this.f6604b = findViewById(C2291b.prev);
        this.f6604b.setOnClickListener(this.f6603a);
        this.f6605c = findViewById(C2291b.next);
        this.f6605c.setOnClickListener(this.f6603a);
        this.f6611i = findViewById(C2291b.rew);
        this.f6611i.setOnClickListener(this.f6603a);
        this.f6610h = findViewById(C2291b.ffwd);
        this.f6610h.setOnClickListener(this.f6603a);
    }

    private long m7285a(int i) {
        long h = this.f6615m == null ? -9223372036854775807L : this.f6615m.mo3081h();
        return h == -9223372036854775807L ? 0 : (h * ((long) i)) / 1000;
    }

    private String m7287a(long j) {
        if (j == -9223372036854775807L) {
            j = 0;
        }
        long j2 = (500 + j) / 1000;
        long j3 = j2 % 60;
        long j4 = (j2 / 60) % 60;
        j2 /= 3600;
        this.f6612j.setLength(0);
        if (j2 > 0) {
            return this.f6613k.format("%d:%02d:%02d", new Object[]{Long.valueOf(j2), Long.valueOf(j4), Long.valueOf(j3)}).toString();
        }
        return this.f6613k.format("%02d:%02d", new Object[]{Long.valueOf(j4), Long.valueOf(j3)}).toString();
    }

    private void m7290a(boolean z, View view) {
        view.setEnabled(z);
        if (C2273r.f6478a >= 11) {
            view.setAlpha(z ? 1.0f : 0.3f);
            view.setVisibility(0);
            return;
        }
        view.setVisibility(z ? 0 : 4);
    }

    private int m7292b(long j) {
        long h = this.f6615m == null ? -9223372036854775807L : this.f6615m.mo3081h();
        return (h == -9223372036854775807L || h == 0) ? 0 : (int) ((1000 * j) / h);
    }

    private void m7296d() {
        removeCallbacks(this.f6623u);
        if (this.f6620r > 0) {
            this.f6621s = SystemClock.uptimeMillis() + ((long) this.f6620r);
            if (isAttachedToWindow()) {
                postDelayed(this.f6623u, (long) this.f6620r);
                return;
            }
            return;
        }
        this.f6621s = -9223372036854775807L;
    }

    private void m7297e() {
        m7299f();
        m7301g();
        m7304h();
    }

    private void m7299f() {
        if (m7319c() && isAttachedToWindow()) {
            Object obj = (this.f6615m == null || !this.f6615m.mo3075b()) ? null : 1;
            this.f6606d.setContentDescription(getResources().getString(obj != null ? C2293d.exo_controls_pause_description : C2293d.exo_controls_play_description));
            this.f6606d.setImageResource(obj != null ? C2290a.exo_controls_pause : C2290a.exo_controls_play);
        }
    }

    private void m7301g() {
        boolean z = true;
        if (m7319c() && isAttachedToWindow()) {
            boolean z2;
            boolean z3;
            boolean z4;
            C2150p f = this.f6615m != null ? this.f6615m.mo3079f() : null;
            if (f != null) {
                int g = this.f6615m.mo3080g();
                f.m6565a(g, this.f6614l);
                z2 = this.f6614l.f6591d;
                z3 = g > 0 || z2 || !this.f6614l.f6592e;
                z4 = g < f.mo3039a() + -1 || this.f6614l.f6592e;
            } else {
                z4 = false;
                z3 = false;
                z2 = false;
            }
            m7290a(z3, this.f6604b);
            m7290a(z4, this.f6605c);
            z3 = this.f6619q > 0 && z2;
            m7290a(z3, this.f6610h);
            if (this.f6618p <= 0 || !z2) {
                z = false;
            }
            m7290a(z, this.f6611i);
            this.f6609g.setEnabled(z2);
        }
    }

    private void m7304h() {
        long j = 0;
        if (m7319c() && isAttachedToWindow()) {
            long h = this.f6615m == null ? 0 : this.f6615m.mo3081h();
            long i = this.f6615m == null ? 0 : this.f6615m.mo3082i();
            this.f6607e.setText(m7287a(h));
            if (!this.f6617o) {
                this.f6608f.setText(m7287a(i));
            }
            if (!this.f6617o) {
                this.f6609g.setProgress(m7292b(i));
            }
            if (this.f6615m != null) {
                j = this.f6615m.mo3083j();
            }
            this.f6609g.setSecondaryProgress(m7292b(j));
            removeCallbacks(this.f6622t);
            int a = this.f6615m == null ? 1 : this.f6615m.mo3066a();
            if (a != 1 && a != 4) {
                if (this.f6615m.mo3075b() && a == 3) {
                    h = 1000 - (i % 1000);
                    if (h < 200) {
                        h += 1000;
                    }
                } else {
                    h = 1000;
                }
                postDelayed(this.f6622t, h);
            }
        }
    }

    private void m7305i() {
        C2150p f = this.f6615m.mo3079f();
        if (f != null) {
            int g = this.f6615m.mo3080g();
            f.m6565a(g, this.f6614l);
            if (g <= 0 || (this.f6615m.mo3082i() > 3000 && (!this.f6614l.f6592e || this.f6614l.f6591d))) {
                this.f6615m.mo3068a(0);
            } else {
                this.f6615m.mo3067a(g - 1);
            }
        }
    }

    private void m7308j() {
        C2150p f = this.f6615m.mo3079f();
        if (f != null) {
            int g = this.f6615m.mo3080g();
            if (g < f.mo3039a() - 1) {
                this.f6615m.mo3067a(g + 1);
            } else if (f.mo3042a(g, this.f6614l, false).f6592e) {
                this.f6615m.mo3076c();
            }
        }
    }

    private void m7309k() {
        if (this.f6618p > 0) {
            this.f6615m.mo3068a(Math.max(this.f6615m.mo3082i() - ((long) this.f6618p), 0));
        }
    }

    private void m7312l() {
        if (this.f6619q > 0) {
            this.f6615m.mo3068a(Math.min(this.f6615m.mo3082i() + ((long) this.f6619q), this.f6615m.mo3081h()));
        }
    }

    public void m7317a() {
        if (!m7319c()) {
            setVisibility(0);
            if (this.f6616n != null) {
                this.f6616n.m7284a(getVisibility());
            }
            m7297e();
        }
        m7296d();
    }

    public void m7318b() {
        if (m7319c()) {
            setVisibility(8);
            if (this.f6616n != null) {
                this.f6616n.m7284a(getVisibility());
            }
            removeCallbacks(this.f6622t);
            removeCallbacks(this.f6623u);
            this.f6621s = -9223372036854775807L;
        }
    }

    public boolean m7319c() {
        return getVisibility() == 0;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z = false;
        if (this.f6615m == null || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
            case 89:
                m7309k();
                break;
            case 22:
            case 90:
                m7312l();
                break;
            case 85:
                C2129e c2129e = this.f6615m;
                if (!this.f6615m.mo3075b()) {
                    z = true;
                }
                c2129e.mo3071a(z);
                break;
            case 87:
                m7308j();
                break;
            case 88:
                m7305i();
                break;
            case TransportMediator.KEYCODE_MEDIA_PLAY /*126*/:
                this.f6615m.mo3071a(true);
                break;
            case TransportMediator.KEYCODE_MEDIA_PAUSE /*127*/:
                this.f6615m.mo3071a(false);
                break;
            default:
                return false;
        }
        m7317a();
        return true;
    }

    public C2129e getPlayer() {
        return this.f6615m;
    }

    public int getShowTimeoutMs() {
        return this.f6620r;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6621s != -9223372036854775807L) {
            long uptimeMillis = this.f6621s - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                m7318b();
            } else {
                postDelayed(this.f6623u, uptimeMillis);
            }
        }
        m7297e();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f6622t);
        removeCallbacks(this.f6623u);
    }

    public void setFastForwardIncrementMs(int i) {
        this.f6619q = i;
        m7301g();
    }

    public void setPlayer(C2129e c2129e) {
        if (this.f6615m != c2129e) {
            if (this.f6615m != null) {
                this.f6615m.mo3073b(this.f6603a);
            }
            this.f6615m = c2129e;
            if (c2129e != null) {
                c2129e.mo3069a(this.f6603a);
            }
            m7297e();
        }
    }

    public void setRewindIncrementMs(int i) {
        this.f6618p = i;
        m7301g();
    }

    public void setShowTimeoutMs(int i) {
        this.f6620r = i;
    }

    public void setVisibilityListener(C2304b c2304b) {
        this.f6616n = c2304b;
    }
}
