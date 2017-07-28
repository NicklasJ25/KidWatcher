package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.exoplayer2.C2129e.C1841a;
import com.google.android.exoplayer2.C2129e.C1946b;
import com.google.android.exoplayer2.C2129e.C2116c;
import com.google.android.exoplayer2.drm.C2113b;
import com.google.android.exoplayer2.drm.C2115d;
import com.google.android.exoplayer2.p041a.C1927b;
import com.google.android.exoplayer2.p041a.C1935c;
import com.google.android.exoplayer2.p041a.C1952f;
import com.google.android.exoplayer2.p042d.C2100c;
import com.google.android.exoplayer2.p044b.C1956d;
import com.google.android.exoplayer2.p053e.C2128c;
import com.google.android.exoplayer2.p053e.C2128c.C2127a;
import com.google.android.exoplayer2.p053e.p054a.C2117e;
import com.google.android.exoplayer2.p053e.p054a.C2122d;
import com.google.android.exoplayer2.p055f.C2145d;
import com.google.android.exoplayer2.p057g.C2167b;
import com.google.android.exoplayer2.p057g.C2196k;
import com.google.android.exoplayer2.p057g.C2196k.C2195a;
import com.google.android.exoplayer2.p063h.C2208h;
import com.google.android.exoplayer2.p063h.C2208h.C2216a;
import com.google.android.exoplayer2.p063h.C2214g;
import com.google.android.exoplayer2.p064k.C2278c;
import com.google.android.exoplayer2.p064k.C2289e;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public final class C2298o implements C2129e {
    private final C2129e f6561a;
    private final C1947m[] f6562b;
    private final C2297a f6563c = new C2297a();
    private final Handler f6564d = new Handler();
    private final int f6565e;
    private final int f6566f;
    private boolean f6567g;
    private Format f6568h;
    private Format f6569i;
    private Surface f6570j;
    private boolean f6571k;
    private SurfaceHolder f6572l;
    private TextureView f6573m;
    private C2195a f6574n;
    private C2127a<List<C2117e>> f6575o;
    private C1842b f6576p;
    private C1935c f6577q;
    private C2289e f6578r;
    private C1956d f6579s;
    private C1956d f6580t;
    private int f6581u;
    private float f6582v;

    public interface C1842b {
        void mo2785a();

        void mo2786a(int i, int i2, int i3, float f);

        void mo2791b();
    }

    private final class C2297a implements Callback, SurfaceTextureListener, C1935c, C2127a<List<C2117e>>, C2195a, C2216a<Object>, C2289e {
        final /* synthetic */ C2298o f6560a;

        private C2297a(C2298o c2298o) {
            this.f6560a = c2298o;
        }

        public void mo3110a(int i) {
            this.f6560a.f6581u = i;
            if (this.f6560a.f6577q != null) {
                this.f6560a.f6577q.mo3110a(i);
            }
        }

        public void mo3111a(int i, int i2, int i3, float f) {
            if (this.f6560a.f6576p != null) {
                this.f6560a.f6576p.mo2786a(i, i2, i3, f);
            }
            if (this.f6560a.f6578r != null) {
                this.f6560a.f6578r.mo3111a(i, i2, i3, f);
            }
        }

        public void mo3112a(int i, long j) {
            if (this.f6560a.f6578r != null) {
                this.f6560a.f6578r.mo3112a(i, j);
            }
        }

        public void mo3113a(int i, long j, long j2) {
            if (this.f6560a.f6577q != null) {
                this.f6560a.f6577q.mo3113a(i, j, j2);
            }
        }

        public void mo3114a(Surface surface) {
            if (this.f6560a.f6576p != null && this.f6560a.f6570j == surface) {
                this.f6560a.f6576p.mo2785a();
            }
            if (this.f6560a.f6578r != null) {
                this.f6560a.f6578r.mo3114a(surface);
            }
        }

        public void mo3115a(Format format) {
            this.f6560a.f6568h = format;
            if (this.f6560a.f6578r != null) {
                this.f6560a.f6578r.mo3115a(format);
            }
        }

        public void mo3116a(C1956d c1956d) {
            this.f6560a.f6579s = c1956d;
            if (this.f6560a.f6578r != null) {
                this.f6560a.f6578r.mo3116a(c1956d);
            }
        }

        public void mo3117a(C2214g<?> c2214g) {
            boolean z = false;
            int i = 0;
            while (i < this.f6560a.f6562b.length) {
                if (this.f6560a.f6562b[i].mo2894a() == 2 && c2214g.m6898a(i) != null) {
                    z = true;
                    break;
                }
                i++;
            }
            if (!(this.f6560a.f6576p == null || !this.f6560a.f6567g || z)) {
                this.f6560a.f6576p.mo2791b();
            }
            this.f6560a.f6567g = z;
        }

        public /* synthetic */ void mo3118a(Object obj) {
            m7225b((List) obj);
        }

        public void mo3119a(String str, long j, long j2) {
            if (this.f6560a.f6578r != null) {
                this.f6560a.f6578r.mo3119a(str, j, j2);
            }
        }

        public void mo3120a(List<C2167b> list) {
            if (this.f6560a.f6574n != null) {
                this.f6560a.f6574n.mo3120a(list);
            }
        }

        public void mo3121b(Format format) {
            this.f6560a.f6569i = format;
            if (this.f6560a.f6577q != null) {
                this.f6560a.f6577q.mo3121b(format);
            }
        }

        public void mo3122b(C1956d c1956d) {
            if (this.f6560a.f6578r != null) {
                this.f6560a.f6578r.mo3122b(c1956d);
            }
            this.f6560a.f6568h = null;
            this.f6560a.f6579s = null;
        }

        public void mo3123b(String str, long j, long j2) {
            if (this.f6560a.f6577q != null) {
                this.f6560a.f6577q.mo3123b(str, j, j2);
            }
        }

        public void m7225b(List<C2117e> list) {
            if (this.f6560a.f6575o != null) {
                this.f6560a.f6575o.mo3118a(list);
            }
        }

        public void mo3124c(C1956d c1956d) {
            this.f6560a.f6580t = c1956d;
            if (this.f6560a.f6577q != null) {
                this.f6560a.f6577q.mo3124c(c1956d);
            }
        }

        public void mo3125d(C1956d c1956d) {
            if (this.f6560a.f6577q != null) {
                this.f6560a.f6577q.mo3125d(c1956d);
            }
            this.f6560a.f6569i = null;
            this.f6560a.f6580t = null;
            this.f6560a.f6581u = 0;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f6560a.m7233a(new Surface(surfaceTexture), true);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f6560a.m7233a(null, true);
            return true;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f6560a.m7233a(surfaceHolder.getSurface(), false);
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f6560a.m7233a(null, false);
        }
    }

    C2298o(Context context, C2208h<?> c2208h, C2096j c2096j, C2113b<C2115d> c2113b, boolean z, long j) {
        c2208h.m6874a(this.f6563c);
        ArrayList arrayList = new ArrayList();
        if (z) {
            m7235a(arrayList, j);
            m7232a(context, c2113b, arrayList, j);
        } else {
            m7232a(context, c2113b, arrayList, j);
            m7235a(arrayList, j);
        }
        this.f6562b = (C1947m[]) arrayList.toArray(new C1947m[arrayList.size()]);
        int i = 0;
        int i2 = 0;
        for (C1947m a : this.f6562b) {
            switch (a.mo2894a()) {
                case 1:
                    i++;
                    break;
                case 2:
                    i2++;
                    break;
                default:
                    break;
            }
        }
        this.f6565e = i2;
        this.f6566f = i;
        this.f6581u = 0;
        this.f6582v = 1.0f;
        this.f6561a = new C2197g(this.f6562b, c2208h, c2096j);
    }

    private void m7232a(Context context, C2113b<C2115d> c2113b, ArrayList<C1947m> arrayList, long j) {
        arrayList.add(new C2278c(context, C2100c.f5909a, 1, j, c2113b, false, this.f6564d, this.f6563c, 50));
        arrayList.add(new C1952f(C2100c.f5909a, c2113b, true, this.f6564d, this.f6563c, C1927b.m5504a(context), 3));
        arrayList.add(new C2196k(this.f6563c, this.f6564d.getLooper()));
        arrayList.add(new C2128c(this.f6563c, this.f6564d.getLooper(), new C2122d()));
    }

    private void m7233a(Surface surface, boolean z) {
        C2116c[] c2116cArr = new C2116c[this.f6565e];
        C1947m[] c1947mArr = this.f6562b;
        int length = c1947mArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            C1946b c1946b = c1947mArr[i];
            if (c1946b.mo2894a() == 2) {
                i3 = i2 + 1;
                c2116cArr[i2] = new C2116c(c1946b, 1, surface);
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (this.f6570j == null || this.f6570j == surface) {
            this.f6561a.mo3072a(c2116cArr);
        } else {
            if (this.f6571k) {
                this.f6570j.release();
            }
            this.f6561a.mo3074b(c2116cArr);
        }
        this.f6570j = surface;
        this.f6571k = z;
    }

    private void m7235a(ArrayList<C1947m> arrayList, long j) {
        try {
            arrayList.add((C1947m) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(new Class[]{Boolean.TYPE, Long.TYPE, Handler.class, C2289e.class, Integer.TYPE}).newInstance(new Object[]{Boolean.valueOf(true), Long.valueOf(j), this.f6564d, this.f6563c, Integer.valueOf(50)}));
            Log.i("SimpleExoPlayer", "Loaded LibvpxVideoRenderer.");
        } catch (ClassNotFoundException e) {
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
        try {
            arrayList.add((C1947m) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(new Class[]{Handler.class, C1935c.class}).newInstance(new Object[]{this.f6564d, this.f6563c}));
            Log.i("SimpleExoPlayer", "Loaded LibopusAudioRenderer.");
        } catch (ClassNotFoundException e3) {
        } catch (Throwable e22) {
            throw new RuntimeException(e22);
        }
        try {
            arrayList.add((C1947m) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(new Class[]{Handler.class, C1935c.class}).newInstance(new Object[]{this.f6564d, this.f6563c}));
            Log.i("SimpleExoPlayer", "Loaded LibflacAudioRenderer.");
        } catch (ClassNotFoundException e4) {
        } catch (Throwable e222) {
            throw new RuntimeException(e222);
        }
        try {
            arrayList.add((C1947m) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(new Class[]{Handler.class, C1935c.class}).newInstance(new Object[]{this.f6564d, this.f6563c}));
            Log.i("SimpleExoPlayer", "Loaded FfmpegAudioRenderer.");
        } catch (ClassNotFoundException e5) {
        } catch (Throwable e2222) {
            throw new RuntimeException(e2222);
        }
    }

    private void m7246m() {
        if (this.f6573m != null) {
            if (this.f6573m.getSurfaceTextureListener() != this.f6563c) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f6573m.setSurfaceTextureListener(null);
            }
            this.f6573m = null;
        }
        if (this.f6572l != null) {
            this.f6572l.removeCallback(this.f6563c);
            this.f6572l = null;
        }
    }

    public int mo3066a() {
        return this.f6561a.mo3066a();
    }

    public void m7248a(float f) {
        this.f6582v = f;
        C2116c[] c2116cArr = new C2116c[this.f6566f];
        C1947m[] c1947mArr = this.f6562b;
        int length = c1947mArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            C1946b c1946b = c1947mArr[i];
            if (c1946b.mo2894a() == 1) {
                i3 = i2 + 1;
                c2116cArr[i2] = new C2116c(c1946b, 2, Float.valueOf(f));
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        this.f6561a.mo3072a(c2116cArr);
    }

    public void mo3067a(int i) {
        this.f6561a.mo3067a(i);
    }

    public void mo3068a(long j) {
        this.f6561a.mo3068a(j);
    }

    public void m7251a(Surface surface) {
        m7246m();
        m7233a(surface, false);
    }

    public void mo3069a(C1841a c1841a) {
        this.f6561a.mo3069a(c1841a);
    }

    public void mo3070a(C2145d c2145d) {
        this.f6561a.mo3070a(c2145d);
    }

    public void m7254a(C1842b c1842b) {
        this.f6576p = c1842b;
    }

    public void mo3071a(boolean z) {
        this.f6561a.mo3071a(z);
    }

    public void mo3072a(C2116c... c2116cArr) {
        this.f6561a.mo3072a(c2116cArr);
    }

    public void mo3073b(C1841a c1841a) {
        this.f6561a.mo3073b(c1841a);
    }

    public void mo3074b(C2116c... c2116cArr) {
        this.f6561a.mo3074b(c2116cArr);
    }

    public boolean mo3075b() {
        return this.f6561a.mo3075b();
    }

    public void mo3076c() {
        this.f6561a.mo3076c();
    }

    public void mo3077d() {
        this.f6561a.mo3077d();
    }

    public void mo3078e() {
        this.f6561a.mo3078e();
        m7246m();
        if (this.f6570j != null) {
            if (this.f6571k) {
                this.f6570j.release();
            }
            this.f6570j = null;
        }
    }

    public C2150p mo3079f() {
        return this.f6561a.mo3079f();
    }

    public int mo3080g() {
        return this.f6561a.mo3080g();
    }

    public long mo3081h() {
        return this.f6561a.mo3081h();
    }

    public long mo3082i() {
        return this.f6561a.mo3082i();
    }

    public long mo3083j() {
        return this.f6561a.mo3083j();
    }

    public int mo3084k() {
        return this.f6561a.mo3084k();
    }

    public int m7269l() {
        return this.f6581u;
    }
}
