package com.facebook.ads.internal.view.p035c.p040c;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import java.io.IOException;

@TargetApi(14)
public class C1846b extends TextureView implements OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnSeekCompleteListener, OnVideoSizeChangedListener, SurfaceTextureListener, MediaPlayerControl, C1840c {
    private static final String f4596p = C1846b.class.getSimpleName();
    private Uri f4597a;
    private C1848e f4598b;
    private Surface f4599c;
    @Nullable
    private MediaPlayer f4600d;
    private MediaController f4601e;
    private C1847d f4602f = C1847d.IDLE;
    private C1847d f4603g = C1847d.IDLE;
    private View f4604h;
    private int f4605i = 0;
    private long f4606j;
    private int f4607k = 0;
    private int f4608l = 0;
    private float f4609m = 1.0f;
    private boolean f4610n = false;
    private int f4611o = 3;
    private int f4612q = 0;
    private boolean f4613r = false;

    class C18441 implements OnTouchListener {
        final /* synthetic */ C1846b f4594a;

        C18441(C1846b c1846b) {
            this.f4594a = c1846b;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!(this.f4594a.f4613r || this.f4594a.f4601e == null || motionEvent.getAction() != 1)) {
                if (this.f4594a.f4601e.isShowing()) {
                    this.f4594a.f4601e.hide();
                } else {
                    this.f4594a.f4601e.show();
                }
            }
            return true;
        }
    }

    class C18452 implements OnTouchListener {
        final /* synthetic */ C1846b f4595a;

        C18452(C1846b c1846b) {
            this.f4595a = c1846b;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!(this.f4595a.f4613r || this.f4595a.f4601e == null || motionEvent.getAction() != 1)) {
                if (this.f4595a.f4601e.isShowing()) {
                    this.f4595a.f4601e.hide();
                } else {
                    this.f4595a.f4601e.show();
                }
            }
            return true;
        }
    }

    public C1846b(Context context) {
        super(context);
    }

    private boolean m5184a() {
        return this.f4602f == C1847d.PREPARED || this.f4602f == C1847d.STARTED || this.f4602f == C1847d.PAUSED || this.f4602f == C1847d.PLAYBACK_COMPLETED;
    }

    private void setVideoState(C1847d c1847d) {
        if (c1847d != this.f4602f) {
            this.f4602f = c1847d;
            if (this.f4598b != null) {
                this.f4598b.mo2821a(c1847d);
            }
        }
    }

    public void mo2789a(boolean z) {
        if (this.f4601e != null) {
            this.f4601e.setVisibility(8);
        }
        this.f4613r = true;
    }

    public void mo2793c() {
        setVideoState(C1847d.PLAYBACK_COMPLETED);
        mo2794d();
        this.f4605i = 0;
    }

    public boolean canPause() {
        return (this.f4602f == C1847d.PREPARING || this.f4602f == C1847d.PREPARED) ? false : true;
    }

    public boolean canSeekBackward() {
        return true;
    }

    public boolean canSeekForward() {
        return true;
    }

    public void mo2794d() {
        this.f4603g = C1847d.IDLE;
        if (this.f4600d != null) {
            int currentPosition = this.f4600d.getCurrentPosition();
            if (currentPosition > 0) {
                this.f4605i = currentPosition;
            }
            this.f4600d.stop();
            this.f4600d.reset();
            this.f4600d.release();
            this.f4600d = null;
            if (this.f4601e != null) {
                this.f4601e.hide();
                this.f4601e.setEnabled(false);
            }
        }
        setVideoState(C1847d.IDLE);
    }

    public int getAudioSessionId() {
        return this.f4600d != null ? this.f4600d.getAudioSessionId() : 0;
    }

    public int getBufferPercentage() {
        return 0;
    }

    public int getCurrentPosition() {
        return this.f4600d != null ? this.f4600d.getCurrentPosition() : 0;
    }

    public int getDuration() {
        return this.f4600d == null ? 0 : (getState() == C1847d.STARTED || getState() == C1847d.PAUSED || getState() == C1847d.PREPARED || getState() == C1847d.PLAYBACK_COMPLETED) ? this.f4600d.getDuration() : 0;
    }

    public long getInitialBufferTime() {
        return this.f4606j;
    }

    public C1847d getState() {
        return this.f4602f;
    }

    public C1847d getTargetState() {
        return this.f4603g;
    }

    public int getVideoHeight() {
        return this.f4608l;
    }

    public int getVideoWidth() {
        return this.f4607k;
    }

    public View getView() {
        return this;
    }

    public float getVolume() {
        return this.f4609m;
    }

    public boolean isPlaying() {
        return this.f4600d != null && this.f4600d.isPlaying();
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.f4600d != null) {
            this.f4600d.pause();
        }
        setVideoState(C1847d.PLAYBACK_COMPLETED);
        seekTo(0);
        this.f4605i = 0;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.f4611o <= 0 || getState() != C1847d.STARTED) {
            setVideoState(C1847d.ERROR);
            mo2794d();
        } else {
            this.f4611o--;
            mo2794d();
            start();
        }
        return true;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        switch (i) {
            case 701:
                setVideoState(C1847d.BUFFERING);
                break;
            case 702:
                setVideoState(C1847d.STARTED);
                break;
        }
        return false;
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = C1846b.getDefaultSize(this.f4607k, i);
        int defaultSize2 = C1846b.getDefaultSize(this.f4608l, i2);
        if (this.f4607k > 0 && this.f4608l > 0) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            int mode2 = MeasureSpec.getMode(i2);
            defaultSize2 = MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.f4607k * defaultSize2 < this.f4608l * size) {
                    defaultSize = (this.f4607k * defaultSize2) / this.f4608l;
                } else if (this.f4607k * defaultSize2 > this.f4608l * size) {
                    defaultSize2 = (this.f4608l * size) / this.f4607k;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                defaultSize = (this.f4608l * size) / this.f4607k;
                if (mode2 != Integer.MIN_VALUE || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.f4607k * defaultSize2) / this.f4608l;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i3 = this.f4607k;
                defaultSize = this.f4608l;
                if (mode2 != Integer.MIN_VALUE || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = i3;
                } else {
                    defaultSize = (this.f4607k * defaultSize2) / this.f4608l;
                }
                if (mode == Integer.MIN_VALUE && r1 > size) {
                    defaultSize2 = (this.f4608l * size) / this.f4607k;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        setVideoState(C1847d.PREPARED);
        if (this.f4610n && !this.f4613r) {
            this.f4601e = new MediaController(getContext());
            this.f4601e.setAnchorView(this.f4604h == null ? this : this.f4604h);
            this.f4601e.setMediaPlayer(this);
            this.f4601e.setEnabled(true);
        }
        setRequestedVolume(this.f4609m);
        this.f4607k = mediaPlayer.getVideoWidth();
        this.f4608l = mediaPlayer.getVideoHeight();
        if (this.f4605i > 0) {
            if (this.f4605i >= this.f4600d.getDuration()) {
                this.f4605i = 0;
            }
            this.f4600d.seekTo(this.f4605i);
            this.f4605i = 0;
        }
        if (this.f4603g == C1847d.STARTED) {
            start();
        }
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        if (this.f4598b != null) {
            this.f4598b.mo2820a(this.f4612q, this.f4605i);
            this.f4605i = 0;
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.f4599c == null) {
            this.f4599c = new Surface(surfaceTexture);
        }
        if (this.f4600d != null) {
            this.f4600d.setSurface(this.f4599c);
            if (this.f4602f == C1847d.PAUSED && this.f4603g != C1847d.PAUSED) {
                start();
            }
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        if (this.f4599c != null) {
            this.f4599c.release();
            this.f4599c = null;
        }
        if (this.f4602f != C1847d.PAUSED) {
            this.f4603g = this.f4610n ? C1847d.STARTED : this.f4602f;
            pause();
        }
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.f4607k = mediaPlayer.getVideoWidth();
        this.f4608l = mediaPlayer.getVideoHeight();
        if (this.f4607k != 0 && this.f4608l != 0) {
            requestLayout();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f4600d != null) {
            if (this.f4601e != null && this.f4601e.isShowing()) {
                return;
            }
            if (z) {
                if (this.f4602f == C1847d.PAUSED && this.f4603g != C1847d.PAUSED) {
                    start();
                }
            } else if (this.f4602f != C1847d.PAUSED) {
                this.f4603g = this.f4610n ? C1847d.STARTED : this.f4602f;
                pause();
            }
        }
    }

    public void pause() {
        if (this.f4600d == null) {
            setVideoState(C1847d.IDLE);
        } else if (canPause()) {
            this.f4600d.pause();
            if (this.f4602f != C1847d.PLAYBACK_COMPLETED) {
                setVideoState(C1847d.PAUSED);
            }
        }
    }

    public void seekTo(int i) {
        if (this.f4600d == null || !m5184a()) {
            this.f4605i = i;
        } else if (i < getDuration() && i > 0) {
            this.f4612q = getCurrentPosition();
            this.f4605i = i;
            this.f4600d.seekTo(i);
        }
    }

    public void setControlsAnchorView(View view) {
        this.f4604h = view;
        view.setOnTouchListener(new C18452(this));
    }

    public void setFullScreen(boolean z) {
        this.f4610n = z;
        if (this.f4610n && !this.f4613r) {
            setOnTouchListener(new C18441(this));
        }
    }

    public void setRequestedVolume(float f) {
        this.f4609m = f;
        if (this.f4600d != null && this.f4602f != C1847d.PREPARING && this.f4602f != C1847d.IDLE) {
            this.f4600d.setVolume(f, f);
        }
    }

    public void setVideoMPD(String str) {
    }

    public void setVideoStateChangeListener(C1848e c1848e) {
        this.f4598b = c1848e;
    }

    public void setup(Uri uri) {
        MediaPlayer mediaPlayer;
        Object e;
        Throwable th;
        AssetFileDescriptor assetFileDescriptor = null;
        this.f4597a = uri;
        if (this.f4600d != null) {
            this.f4600d.reset();
            this.f4600d.setSurface(null);
            mediaPlayer = this.f4600d;
        } else {
            mediaPlayer = new MediaPlayer();
        }
        try {
            if (uri.getScheme().equals("asset")) {
                try {
                    AssetFileDescriptor openFd = getContext().getAssets().openFd(uri.getPath().substring(1));
                    try {
                        mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                        if (openFd != null) {
                            try {
                                openFd.close();
                            } catch (IOException e2) {
                                Log.w(f4596p, "Unable to close" + e2);
                            }
                        }
                    } catch (SecurityException e3) {
                        e = e3;
                        assetFileDescriptor = openFd;
                        try {
                            Log.w(f4596p, "Failed to open assets " + e);
                            setVideoState(C1847d.ERROR);
                            if (assetFileDescriptor != null) {
                                try {
                                    assetFileDescriptor.close();
                                } catch (IOException e22) {
                                    Log.w(f4596p, "Unable to close" + e22);
                                }
                            }
                            mediaPlayer.setLooping(false);
                            mediaPlayer.setOnBufferingUpdateListener(this);
                            mediaPlayer.setOnCompletionListener(this);
                            mediaPlayer.setOnErrorListener(this);
                            mediaPlayer.setOnInfoListener(this);
                            mediaPlayer.setOnPreparedListener(this);
                            mediaPlayer.setOnVideoSizeChangedListener(this);
                            mediaPlayer.setOnSeekCompleteListener(this);
                            mediaPlayer.prepareAsync();
                            this.f4600d = mediaPlayer;
                            setVideoState(C1847d.PREPARING);
                            setSurfaceTextureListener(this);
                            if (isAvailable()) {
                                onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (assetFileDescriptor != null) {
                                try {
                                    assetFileDescriptor.close();
                                } catch (IOException e4) {
                                    Log.w(f4596p, "Unable to close" + e4);
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        assetFileDescriptor = openFd;
                        Log.w(f4596p, "Failed to open assets " + e);
                        setVideoState(C1847d.ERROR);
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                        mediaPlayer.setLooping(false);
                        mediaPlayer.setOnBufferingUpdateListener(this);
                        mediaPlayer.setOnCompletionListener(this);
                        mediaPlayer.setOnErrorListener(this);
                        mediaPlayer.setOnInfoListener(this);
                        mediaPlayer.setOnPreparedListener(this);
                        mediaPlayer.setOnVideoSizeChangedListener(this);
                        mediaPlayer.setOnSeekCompleteListener(this);
                        mediaPlayer.prepareAsync();
                        this.f4600d = mediaPlayer;
                        setVideoState(C1847d.PREPARING);
                        setSurfaceTextureListener(this);
                        if (isAvailable()) {
                            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        assetFileDescriptor = openFd;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                        throw th;
                    }
                } catch (SecurityException e6) {
                    e = e6;
                    Log.w(f4596p, "Failed to open assets " + e);
                    setVideoState(C1847d.ERROR);
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    mediaPlayer.setLooping(false);
                    mediaPlayer.setOnBufferingUpdateListener(this);
                    mediaPlayer.setOnCompletionListener(this);
                    mediaPlayer.setOnErrorListener(this);
                    mediaPlayer.setOnInfoListener(this);
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.setOnVideoSizeChangedListener(this);
                    mediaPlayer.setOnSeekCompleteListener(this);
                    mediaPlayer.prepareAsync();
                    this.f4600d = mediaPlayer;
                    setVideoState(C1847d.PREPARING);
                    setSurfaceTextureListener(this);
                    if (isAvailable()) {
                        onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
                    }
                } catch (IOException e7) {
                    e = e7;
                    Log.w(f4596p, "Failed to open assets " + e);
                    setVideoState(C1847d.ERROR);
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    mediaPlayer.setLooping(false);
                    mediaPlayer.setOnBufferingUpdateListener(this);
                    mediaPlayer.setOnCompletionListener(this);
                    mediaPlayer.setOnErrorListener(this);
                    mediaPlayer.setOnInfoListener(this);
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.setOnVideoSizeChangedListener(this);
                    mediaPlayer.setOnSeekCompleteListener(this);
                    mediaPlayer.prepareAsync();
                    this.f4600d = mediaPlayer;
                    setVideoState(C1847d.PREPARING);
                    setSurfaceTextureListener(this);
                    if (isAvailable()) {
                        onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
                    }
                }
            }
            mediaPlayer.setDataSource(getContext(), uri);
            mediaPlayer.setLooping(false);
            mediaPlayer.setOnBufferingUpdateListener(this);
            mediaPlayer.setOnCompletionListener(this);
            mediaPlayer.setOnErrorListener(this);
            mediaPlayer.setOnInfoListener(this);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setOnVideoSizeChangedListener(this);
            mediaPlayer.setOnSeekCompleteListener(this);
            mediaPlayer.prepareAsync();
            this.f4600d = mediaPlayer;
            setVideoState(C1847d.PREPARING);
        } catch (Exception e8) {
            setVideoState(C1847d.ERROR);
            mediaPlayer.release();
            Log.e(f4596p, "Cannot prepare media player with SurfaceTexture: " + e8);
        }
        setSurfaceTextureListener(this);
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }

    public void start() {
        this.f4603g = C1847d.STARTED;
        if (this.f4602f == C1847d.STARTED || this.f4602f == C1847d.PREPARED || this.f4602f == C1847d.IDLE || this.f4602f == C1847d.PAUSED || this.f4602f == C1847d.PLAYBACK_COMPLETED) {
            if (this.f4600d == null) {
                setup(this.f4597a);
            } else {
                if (this.f4605i > 0) {
                    this.f4600d.seekTo(this.f4605i);
                }
                this.f4600d.start();
                setVideoState(C1847d.STARTED);
            }
        }
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }
}
