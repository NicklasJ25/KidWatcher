package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.MeasureSpec;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.zh;
import com.google.android.gms.internal.zl;
import com.google.android.gms.internal.zzds;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
@wh
public class zzd extends zzj implements OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnVideoSizeChangedListener, SurfaceTextureListener {
    private static final Map<Integer, String> f6752c = new HashMap();
    private final zzz f6753d;
    private final boolean f6754e;
    private int f6755f = 0;
    private int f6756g = 0;
    private MediaPlayer f6757h;
    private Uri f6758i;
    private int f6759j;
    private int f6760k;
    private int f6761l;
    private int f6762m;
    private int f6763n;
    private zzy f6764o;
    private boolean f6765p;
    private int f6766q;
    private zzi f6767r;

    class C23321 implements Runnable {
        final /* synthetic */ zzd f6738a;

        C23321(zzd com_google_android_gms_ads_internal_overlay_zzd) {
            this.f6738a = com_google_android_gms_ads_internal_overlay_zzd;
        }

        public void run() {
            if (this.f6738a.f6767r != null) {
                this.f6738a.f6767r.zzhU();
            }
        }
    }

    class C23332 implements Runnable {
        final /* synthetic */ zzd f6739a;

        C23332(zzd com_google_android_gms_ads_internal_overlay_zzd) {
            this.f6739a = com_google_android_gms_ads_internal_overlay_zzd;
        }

        public void run() {
            if (this.f6739a.f6767r != null) {
                this.f6739a.f6767r.zzhW();
            }
        }
    }

    class C23354 implements Runnable {
        final /* synthetic */ zzd f6743a;

        C23354(zzd com_google_android_gms_ads_internal_overlay_zzd) {
            this.f6743a = com_google_android_gms_ads_internal_overlay_zzd;
        }

        public void run() {
            if (this.f6743a.f6767r != null) {
                this.f6743a.f6767r.zzhT();
            }
        }
    }

    class C23376 implements Runnable {
        final /* synthetic */ zzd f6747a;

        C23376(zzd com_google_android_gms_ads_internal_overlay_zzd) {
            this.f6747a = com_google_android_gms_ads_internal_overlay_zzd;
        }

        public void run() {
            if (this.f6747a.f6767r != null) {
                this.f6747a.f6767r.onPaused();
                this.f6747a.f6767r.zzhX();
            }
        }
    }

    class C23387 implements Runnable {
        final /* synthetic */ zzd f6748a;

        C23387(zzd com_google_android_gms_ads_internal_overlay_zzd) {
            this.f6748a = com_google_android_gms_ads_internal_overlay_zzd;
        }

        public void run() {
            if (this.f6748a.f6767r != null) {
                this.f6748a.f6767r.zzhV();
            }
        }
    }

    class C23398 implements Runnable {
        final /* synthetic */ zzd f6749a;

        C23398(zzd com_google_android_gms_ads_internal_overlay_zzd) {
            this.f6749a = com_google_android_gms_ads_internal_overlay_zzd;
        }

        public void run() {
            if (this.f6749a.f6767r != null) {
                this.f6749a.f6767r.onPaused();
            }
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f6752c.put(Integer.valueOf(-1004), "MEDIA_ERROR_IO");
            f6752c.put(Integer.valueOf(-1007), "MEDIA_ERROR_MALFORMED");
            f6752c.put(Integer.valueOf(-1010), "MEDIA_ERROR_UNSUPPORTED");
            f6752c.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
            f6752c.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        f6752c.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
        f6752c.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
        f6752c.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
        f6752c.put(Integer.valueOf(PositionController.CAPTURE_ANIMATION_TIME), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        f6752c.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
        f6752c.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
        f6752c.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
        f6752c.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
        f6752c.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
        if (VERSION.SDK_INT >= 19) {
            f6752c.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            f6752c.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }

    public zzd(Context context, boolean z, boolean z2, zzz com_google_android_gms_ads_internal_overlay_zzz) {
        super(context);
        setSurfaceTextureListener(this);
        this.f6753d = com_google_android_gms_ads_internal_overlay_zzz;
        this.f6765p = z;
        this.f6754e = z2;
        this.f6753d.zza(this);
    }

    private void m7392a() {
        Throwable e;
        String valueOf;
        zh.m15051a("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.f6758i != null && surfaceTexture != null) {
            m7395a(false);
            try {
                SurfaceTexture zzim;
                this.f6757h = zzw.zzdd().zzik();
                this.f6757h.setOnBufferingUpdateListener(this);
                this.f6757h.setOnCompletionListener(this);
                this.f6757h.setOnErrorListener(this);
                this.f6757h.setOnInfoListener(this);
                this.f6757h.setOnPreparedListener(this);
                this.f6757h.setOnVideoSizeChangedListener(this);
                this.f6761l = 0;
                if (this.f6765p) {
                    this.f6764o = new zzy(getContext());
                    this.f6764o.zza(surfaceTexture, getWidth(), getHeight());
                    this.f6764o.start();
                    zzim = this.f6764o.zzim();
                    if (zzim == null) {
                        this.f6764o.zzil();
                        this.f6764o = null;
                    }
                    this.f6757h.setDataSource(getContext(), this.f6758i);
                    this.f6757h.setSurface(zzw.zzde().zza(zzim));
                    this.f6757h.setAudioStreamType(3);
                    this.f6757h.setScreenOnWhilePlaying(true);
                    this.f6757h.prepareAsync();
                    m7394a(1);
                }
                zzim = surfaceTexture;
                this.f6757h.setDataSource(getContext(), this.f6758i);
                this.f6757h.setSurface(zzw.zzde().zza(zzim));
                this.f6757h.setAudioStreamType(3);
                this.f6757h.setScreenOnWhilePlaying(true);
                this.f6757h.prepareAsync();
                m7394a(1);
            } catch (IOException e2) {
                e = e2;
                valueOf = String.valueOf(this.f6758i);
                aad.m8424c(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to initialize MediaPlayer at ").append(valueOf).toString(), e);
                onError(this.f6757h, 1, 0);
            } catch (IllegalArgumentException e3) {
                e = e3;
                valueOf = String.valueOf(this.f6758i);
                aad.m8424c(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to initialize MediaPlayer at ").append(valueOf).toString(), e);
                onError(this.f6757h, 1, 0);
            } catch (IllegalStateException e4) {
                e = e4;
                valueOf = String.valueOf(this.f6758i);
                aad.m8424c(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to initialize MediaPlayer at ").append(valueOf).toString(), e);
                onError(this.f6757h, 1, 0);
            }
        }
    }

    private void m7393a(float f) {
        if (this.f6757h != null) {
            try {
                this.f6757h.setVolume(f, f);
                return;
            } catch (IllegalStateException e) {
                return;
            }
        }
        aad.m8426e("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
    }

    private void m7394a(int i) {
        if (i == 3) {
            this.f6753d.zzix();
            this.b.zzix();
        } else if (this.f6755f == 3) {
            this.f6753d.zziy();
            this.b.zziy();
        }
        this.f6755f = i;
    }

    private void m7395a(boolean z) {
        zh.m15051a("AdMediaPlayerView release");
        if (this.f6764o != null) {
            this.f6764o.zzil();
            this.f6764o = null;
        }
        if (this.f6757h != null) {
            this.f6757h.reset();
            this.f6757h.release();
            this.f6757h = null;
            m7394a(0);
            if (z) {
                this.f6756g = 0;
                m7397b(0);
            }
        }
    }

    private void m7396b() {
        if (this.f6754e && m7398c() && this.f6757h.getCurrentPosition() > 0 && this.f6756g != 3) {
            zh.m15051a("AdMediaPlayerView nudging MediaPlayer");
            m7393a(0.0f);
            this.f6757h.start();
            int currentPosition = this.f6757h.getCurrentPosition();
            long a = zzw.zzcS().mo3360a();
            while (m7398c() && this.f6757h.getCurrentPosition() == currentPosition) {
                if (zzw.zzcS().mo3360a() - a > 250) {
                    break;
                }
            }
            this.f6757h.pause();
            zzhC();
        }
    }

    private void m7397b(int i) {
        this.f6756g = i;
    }

    private boolean m7398c() {
        return (this.f6757h == null || this.f6755f == -1 || this.f6755f == 0 || this.f6755f == 1) ? false : true;
    }

    public int getCurrentPosition() {
        return m7398c() ? this.f6757h.getCurrentPosition() : 0;
    }

    public int getDuration() {
        return m7398c() ? this.f6757h.getDuration() : -1;
    }

    public int getVideoHeight() {
        return this.f6757h != null ? this.f6757h.getVideoHeight() : 0;
    }

    public int getVideoWidth() {
        return this.f6757h != null ? this.f6757h.getVideoWidth() : 0;
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.f6761l = i;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        zh.m15051a("AdMediaPlayerView completion");
        m7394a(5);
        m7397b(5);
        zl.f11678a.post(new C23332(this));
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        final String str = (String) f6752c.get(Integer.valueOf(i));
        final String str2 = (String) f6752c.get(Integer.valueOf(i2));
        aad.m8426e(new StringBuilder((String.valueOf(str).length() + 38) + String.valueOf(str2).length()).append("AdMediaPlayerView MediaPlayer error: ").append(str).append(":").append(str2).toString());
        m7394a(-1);
        m7397b(-1);
        zl.f11678a.post(new Runnable(this) {
            final /* synthetic */ zzd f6742c;

            public void run() {
                if (this.f6742c.f6767r != null) {
                    this.f6742c.f6767r.zzl(str, str2);
                }
            }
        });
        return true;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) f6752c.get(Integer.valueOf(i));
        String str2 = (String) f6752c.get(Integer.valueOf(i2));
        zh.m15051a(new StringBuilder((String.valueOf(str).length() + 37) + String.valueOf(str2).length()).append("AdMediaPlayerView MediaPlayer info: ").append(str).append(":").append(str2).toString());
        return true;
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.f6759j, i);
        int defaultSize2 = getDefaultSize(this.f6760k, i2);
        if (this.f6759j > 0 && this.f6760k > 0 && this.f6764o == null) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            int mode2 = MeasureSpec.getMode(i2);
            defaultSize2 = MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.f6759j * defaultSize2 < this.f6760k * size) {
                    defaultSize = (this.f6759j * defaultSize2) / this.f6760k;
                } else if (this.f6759j * defaultSize2 > this.f6760k * size) {
                    defaultSize2 = (this.f6760k * size) / this.f6759j;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                defaultSize = (this.f6760k * size) / this.f6759j;
                if (mode2 != Integer.MIN_VALUE || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.f6759j * defaultSize2) / this.f6760k;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i3 = this.f6759j;
                defaultSize = this.f6760k;
                if (mode2 != Integer.MIN_VALUE || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = i3;
                } else {
                    defaultSize = (this.f6759j * defaultSize2) / this.f6760k;
                }
                if (mode == Integer.MIN_VALUE && r1 > size) {
                    defaultSize2 = (this.f6760k * size) / this.f6759j;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        if (this.f6764o != null) {
            this.f6764o.zzj(defaultSize, defaultSize2);
        }
        if (VERSION.SDK_INT == 16) {
            if ((this.f6762m > 0 && this.f6762m != defaultSize) || (this.f6763n > 0 && this.f6763n != defaultSize2)) {
                m7396b();
            }
            this.f6762m = defaultSize;
            this.f6763n = defaultSize2;
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        zh.m15051a("AdMediaPlayerView prepared");
        m7394a(2);
        this.f6753d.zzhU();
        zl.f11678a.post(new C23321(this));
        this.f6759j = mediaPlayer.getVideoWidth();
        this.f6760k = mediaPlayer.getVideoHeight();
        if (this.f6766q != 0) {
            seekTo(this.f6766q);
        }
        m7396b();
        int i = this.f6759j;
        aad.m8425d("AdMediaPlayerView stream dimensions: " + i + " x " + this.f6760k);
        if (this.f6756g == 3) {
            play();
        }
        zzhC();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zh.m15051a("AdMediaPlayerView surface created");
        m7392a();
        zl.f11678a.post(new C23354(this));
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zh.m15051a("AdMediaPlayerView surface destroyed");
        if (this.f6757h != null && this.f6766q == 0) {
            this.f6766q = this.f6757h.getCurrentPosition();
        }
        if (this.f6764o != null) {
            this.f6764o.zzil();
        }
        zl.f11678a.post(new C23376(this));
        m7395a(true);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i, final int i2) {
        Object obj = 1;
        zh.m15051a("AdMediaPlayerView surface changed");
        Object obj2 = this.f6756g == 3 ? 1 : null;
        if (!(this.f6759j == i && this.f6760k == i2)) {
            obj = null;
        }
        if (!(this.f6757h == null || obj2 == null || r1 == null)) {
            if (this.f6766q != 0) {
                seekTo(this.f6766q);
            }
            play();
        }
        if (this.f6764o != null) {
            this.f6764o.zzj(i, i2);
        }
        zl.f11678a.post(new Runnable(this) {
            final /* synthetic */ zzd f6746c;

            public void run() {
                if (this.f6746c.f6767r != null) {
                    this.f6746c.f6767r.zzg(i, i2);
                }
            }
        });
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f6753d.zzb(this);
        this.a.zza(surfaceTexture, this.f6767r);
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        zh.m15051a("AdMediaPlayerView size changed: " + i + " x " + i2);
        this.f6759j = mediaPlayer.getVideoWidth();
        this.f6760k = mediaPlayer.getVideoHeight();
        if (this.f6759j != 0 && this.f6760k != 0) {
            requestLayout();
        }
    }

    public void pause() {
        zh.m15051a("AdMediaPlayerView pause");
        if (m7398c() && this.f6757h.isPlaying()) {
            this.f6757h.pause();
            m7394a(4);
            zl.f11678a.post(new C23398(this));
        }
        m7397b(4);
    }

    public void play() {
        zh.m15051a("AdMediaPlayerView play");
        if (m7398c()) {
            this.f6757h.start();
            m7394a(3);
            this.a.zzhV();
            zl.f11678a.post(new C23387(this));
        }
        m7397b(3);
    }

    public void seekTo(int i) {
        zh.m15051a("AdMediaPlayerView seek " + i);
        if (m7398c()) {
            this.f6757h.seekTo(i);
            this.f6766q = 0;
            return;
        }
        this.f6766q = i;
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        zzds a = zzds.m15378a(uri);
        if (a != null) {
            uri = Uri.parse(a.f11870a);
        }
        this.f6758i = uri;
        this.f6766q = 0;
        m7392a();
        requestLayout();
        invalidate();
    }

    public void stop() {
        zh.m15051a("AdMediaPlayerView stop");
        if (this.f6757h != null) {
            this.f6757h.stop();
            this.f6757h.release();
            this.f6757h = null;
            m7394a(0);
            m7397b(0);
        }
        this.f6753d.onStop();
    }

    public String toString() {
        String valueOf = String.valueOf(getClass().getName());
        String valueOf2 = String.valueOf(Integer.toHexString(hashCode()));
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append("@").append(valueOf2).toString();
    }

    public void zza(float f, float f2) {
        if (this.f6764o != null) {
            this.f6764o.zzb(f, f2);
        }
    }

    public void zza(zzi com_google_android_gms_ads_internal_overlay_zzi) {
        this.f6767r = com_google_android_gms_ads_internal_overlay_zzi;
    }

    public void zzhC() {
        m7393a(this.b.zziA());
    }

    public String zzhy() {
        String str = "MediaPlayer";
        String valueOf = String.valueOf(this.f6765p ? " spherical" : "");
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }
}
