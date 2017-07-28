package com.facebook.ads.internal.view.p035c.p040c;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import com.facebook.ads.C1462f;
import com.facebook.ads.internal.p018m.C1722n;
import com.facebook.ads.internal.p018m.C1723o;
import com.google.android.exoplayer2.C2097c;
import com.google.android.exoplayer2.C2109d;
import com.google.android.exoplayer2.C2129e.C1841a;
import com.google.android.exoplayer2.C2150p;
import com.google.android.exoplayer2.C2154f;
import com.google.android.exoplayer2.C2298o;
import com.google.android.exoplayer2.C2298o.C1842b;
import com.google.android.exoplayer2.p043j.C2273r;
import com.google.android.exoplayer2.p045c.C1994c;
import com.google.android.exoplayer2.p055f.C2147b;
import com.google.android.exoplayer2.p056i.C2233r;
import com.google.android.exoplayer2.p056i.C2234j;
import com.google.android.exoplayer2.p056i.C2236l;
import com.google.android.exoplayer2.p063h.C2204a.C2201a;
import com.google.android.exoplayer2.p063h.C2210c;

@TargetApi(14)
public class C1843a extends TextureView implements SurfaceTextureListener, C1840c, C1841a, C1842b {
    private static final String f4574a = C1843a.class.getSimpleName();
    private Uri f4575b;
    private String f4576c;
    private C1848e f4577d;
    private Handler f4578e = new Handler();
    private Surface f4579f;
    @Nullable
    private C2298o f4580g;
    private MediaController f4581h;
    private C1847d f4582i = C1847d.IDLE;
    private C1847d f4583j = C1847d.IDLE;
    private View f4584k;
    private boolean f4585l = false;
    private boolean f4586m = false;
    private long f4587n;
    private long f4588o;
    private long f4589p;
    private int f4590q;
    private int f4591r;
    private float f4592s = 1.0f;
    private int f4593t = -1;

    class C18371 implements MediaPlayerControl {
        final /* synthetic */ C1843a f4571a;

        C18371(C1843a c1843a) {
            this.f4571a = c1843a;
        }

        public boolean canPause() {
            return true;
        }

        public boolean canSeekBackward() {
            return true;
        }

        public boolean canSeekForward() {
            return true;
        }

        public int getAudioSessionId() {
            return this.f4571a.f4580g.m7269l();
        }

        public int getBufferPercentage() {
            return this.f4571a.f4580g.mo3084k();
        }

        public int getCurrentPosition() {
            return this.f4571a.getCurrentPosition();
        }

        public int getDuration() {
            return this.f4571a.getDuration();
        }

        public boolean isPlaying() {
            return this.f4571a.f4580g.mo3075b();
        }

        public void pause() {
            this.f4571a.pause();
        }

        public void seekTo(int i) {
            this.f4571a.seekTo(i);
        }

        public void start() {
            this.f4571a.start();
        }
    }

    class C18382 implements OnTouchListener {
        final /* synthetic */ C1843a f4572a;

        C18382(C1843a c1843a) {
            this.f4572a = c1843a;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f4572a.f4581h != null && motionEvent.getAction() == 1) {
                if (this.f4572a.f4581h.isShowing()) {
                    this.f4572a.f4581h.hide();
                } else {
                    this.f4572a.f4581h.show();
                }
            }
            return true;
        }
    }

    class C18393 implements OnTouchListener {
        final /* synthetic */ C1843a f4573a;

        C18393(C1843a c1843a) {
            this.f4573a = c1843a;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f4573a.f4581h != null && motionEvent.getAction() == 1) {
                if (this.f4573a.f4581h.isShowing()) {
                    this.f4573a.f4581h.hide();
                } else {
                    this.f4573a.f4581h.show();
                }
            }
            return true;
        }
    }

    public C1843a(Context context) {
        super(context);
    }

    private void m5171f() {
        C2233r c2234j = new C2234j();
        this.f4580g = C2154f.m6577a(getContext(), new C2210c(this.f4578e, new C2201a(c2234j)), new C2097c());
        this.f4580g.m7254a((C1842b) this);
        this.f4580g.mo3069a((C1841a) this);
        this.f4580g.mo3071a(false);
        if (this.f4586m) {
            this.f4581h = new MediaController(getContext());
            this.f4581h.setAnchorView(this.f4584k == null ? this : this.f4584k);
            this.f4581h.setMediaPlayer(new C18371(this));
            this.f4581h.setEnabled(true);
        }
        if (this.f4576c == null || this.f4576c.length() <= 0 || C1462f.m3761a(getContext())) {
            this.f4580g.mo3070a(new C2147b(this.f4575b, new C2236l(getContext(), C2273r.m7129a(getContext(), "ads"), c2234j), new C1994c(), null, null));
        }
        setVideoState(C1847d.PREPARING);
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }

    private void m5172g() {
        if (this.f4579f != null) {
            this.f4579f.release();
            this.f4579f = null;
        }
        if (this.f4580g != null) {
            this.f4580g.mo3078e();
            this.f4580g = null;
        }
        this.f4581h = null;
        this.f4585l = false;
        setVideoState(C1847d.IDLE);
    }

    private void setVideoState(C1847d c1847d) {
        if (c1847d != this.f4582i) {
            this.f4582i = c1847d;
            if (this.f4582i == C1847d.STARTED) {
                this.f4585l = true;
            }
            if (this.f4577d != null) {
                this.f4577d.mo2821a(c1847d);
            }
        }
    }

    public void mo2785a() {
    }

    public void mo2786a(int i, int i2, int i3, float f) {
        this.f4590q = i;
        this.f4591r = i2;
        if (this.f4590q != 0 && this.f4591r != 0) {
            requestLayout();
        }
    }

    public void mo2787a(C2109d c2109d) {
        setVideoState(C1847d.ERROR);
        c2109d.printStackTrace();
        C1723o.m4943a(C1722n.m4940a(c2109d, "[ExoPlayer] Error during playback of ExoPlayer"));
    }

    public void mo2788a(C2150p c2150p, Object obj) {
    }

    public void mo2789a(boolean z) {
    }

    public void mo2790a(boolean z, int i) {
        switch (i) {
            case 1:
                setVideoState(C1847d.IDLE);
                return;
            case 2:
                if (this.f4593t >= 0) {
                    int i2 = this.f4593t;
                    this.f4593t = -1;
                    this.f4577d.mo2820a(i2, getCurrentPosition());
                    return;
                }
                return;
            case 3:
                if (this.f4587n != 0) {
                    this.f4588o = System.currentTimeMillis() - this.f4587n;
                }
                setRequestedVolume(this.f4592s);
                if (this.f4589p > 0 && this.f4589p < this.f4580g.mo3081h()) {
                    this.f4580g.mo3068a(this.f4589p);
                    this.f4589p = 0;
                }
                if (this.f4580g.mo3082i() != 0 && !z && this.f4585l) {
                    setVideoState(C1847d.PAUSED);
                    return;
                } else if (!z && this.f4582i != C1847d.PLAYBACK_COMPLETED) {
                    setVideoState(C1847d.PREPARED);
                    if (this.f4583j == C1847d.STARTED) {
                        start();
                        this.f4583j = C1847d.IDLE;
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case 4:
                if (z) {
                    setVideoState(C1847d.PLAYBACK_COMPLETED);
                }
                if (this.f4580g != null) {
                    this.f4580g.mo3071a(false);
                    if (!z) {
                        this.f4580g.mo3076c();
                    }
                }
                this.f4585l = false;
                return;
            default:
                return;
        }
    }

    public void mo2791b() {
    }

    public void mo2792b(boolean z) {
    }

    public void mo2793c() {
        setVideoState(C1847d.PLAYBACK_COMPLETED);
    }

    public void mo2794d() {
        this.f4583j = C1847d.IDLE;
        if (this.f4580g != null) {
            this.f4580g.mo3077d();
            this.f4580g.mo3078e();
            this.f4580g = null;
        }
        setVideoState(C1847d.IDLE);
    }

    public void mo2795e() {
    }

    public int getCurrentPosition() {
        return this.f4580g != null ? (int) this.f4580g.mo3082i() : 0;
    }

    public int getDuration() {
        return this.f4580g == null ? 0 : (int) this.f4580g.mo3081h();
    }

    public long getInitialBufferTime() {
        return this.f4588o;
    }

    public C1847d getState() {
        return this.f4582i;
    }

    public C1847d getTargetState() {
        return this.f4583j;
    }

    public int getVideoHeight() {
        return this.f4591r;
    }

    public int getVideoWidth() {
        return this.f4590q;
    }

    public View getView() {
        return this;
    }

    public float getVolume() {
        return this.f4592s;
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = C1843a.getDefaultSize(this.f4590q, i);
        int defaultSize2 = C1843a.getDefaultSize(this.f4591r, i2);
        if (this.f4590q > 0 && this.f4591r > 0) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            int mode2 = MeasureSpec.getMode(i2);
            defaultSize2 = MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.f4590q * defaultSize2 < this.f4591r * size) {
                    defaultSize = (this.f4590q * defaultSize2) / this.f4591r;
                } else if (this.f4590q * defaultSize2 > this.f4591r * size) {
                    defaultSize2 = (this.f4591r * size) / this.f4590q;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                defaultSize = (this.f4591r * size) / this.f4590q;
                if (mode2 != Integer.MIN_VALUE || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.f4590q * defaultSize2) / this.f4591r;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i3 = this.f4590q;
                defaultSize = this.f4591r;
                if (mode2 != Integer.MIN_VALUE || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = i3;
                } else {
                    defaultSize = (this.f4590q * defaultSize2) / this.f4591r;
                }
                if (mode == Integer.MIN_VALUE && r1 > size) {
                    defaultSize2 = (this.f4591r * size) / this.f4590q;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f4579f = new Surface(surfaceTexture);
        if (this.f4579f == null) {
            this.f4579f = new Surface(surfaceTexture);
        }
        if (this.f4580g != null) {
            this.f4580g.m7251a(this.f4579f);
            if (this.f4582i == C1847d.PAUSED && this.f4583j != C1847d.PAUSED) {
                start();
            }
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        if (this.f4579f != null) {
            this.f4579f.release();
            this.f4579f = null;
            if (this.f4580g != null) {
                this.f4580g.m7251a(null);
            }
        }
        if (this.f4582i != C1847d.PAUSED) {
            this.f4583j = this.f4586m ? C1847d.STARTED : this.f4582i;
            pause();
        }
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f4580g != null) {
            if (z) {
                if (this.f4582i == C1847d.PAUSED && this.f4583j != C1847d.PAUSED) {
                    start();
                }
            } else if (this.f4582i != C1847d.PAUSED) {
                this.f4583j = this.f4586m ? C1847d.STARTED : this.f4582i;
                pause();
            }
        }
    }

    public void pause() {
        if (this.f4580g != null) {
            this.f4580g.mo3071a(false);
        } else {
            setVideoState(C1847d.IDLE);
        }
    }

    public void seekTo(int i) {
        if (this.f4580g != null) {
            this.f4593t = getCurrentPosition();
            this.f4580g.mo3068a((long) i);
            return;
        }
        this.f4589p = (long) i;
    }

    public void setControlsAnchorView(View view) {
        this.f4584k = view;
        view.setOnTouchListener(new C18393(this));
    }

    public void setFullScreen(boolean z) {
        this.f4586m = z;
        if (z) {
            setOnTouchListener(new C18382(this));
        }
    }

    public void setRequestedVolume(float f) {
        this.f4592s = f;
        if (this.f4580g != null && this.f4582i != C1847d.PREPARING && this.f4582i != C1847d.IDLE) {
            this.f4580g.m7248a(f);
        }
    }

    public void setVideoMPD(String str) {
        this.f4576c = str;
    }

    public void setVideoStateChangeListener(C1848e c1848e) {
        this.f4577d = c1848e;
    }

    public void setup(Uri uri) {
        if (!(this.f4580g == null || this.f4582i == C1847d.PLAYBACK_COMPLETED)) {
            m5172g();
        }
        this.f4575b = uri;
        setSurfaceTextureListener(this);
        m5171f();
    }

    public void start() {
        this.f4583j = C1847d.STARTED;
        if (this.f4580g == null) {
            setup(this.f4575b);
        } else if (this.f4582i == C1847d.PREPARED || this.f4582i == C1847d.PAUSED || this.f4582i == C1847d.PLAYBACK_COMPLETED) {
            this.f4580g.mo3071a(true);
            setVideoState(C1847d.STARTED);
        }
    }
}
