package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.ads.internal.overlay.C2330b.C2329a;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.pw;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.wh;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@TargetApi(14)
@wh
public class zzy extends Thread implements OnFrameAvailableListener, C2329a {
    private static final float[] f6828a = new float[]{-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private volatile boolean f6829A;
    private volatile boolean f6830B;
    private final C2330b f6831b;
    private final float[] f6832c;
    private final float[] f6833d;
    private final float[] f6834e;
    private final float[] f6835f;
    private final float[] f6836g;
    private final float[] f6837h;
    private final float[] f6838i;
    private float f6839j;
    private float f6840k;
    private float f6841l;
    private int f6842m;
    private int f6843n;
    private SurfaceTexture f6844o;
    private SurfaceTexture f6845p;
    private int f6846q;
    private int f6847r;
    private int f6848s;
    private FloatBuffer f6849t = ByteBuffer.allocateDirect(f6828a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private final CountDownLatch f6850u;
    private final Object f6851v;
    private EGL10 f6852w;
    private EGLDisplay f6853x;
    private EGLContext f6854y;
    private EGLSurface f6855z;

    public zzy(Context context) {
        super("SphericalVideoProcessor");
        this.f6849t.put(f6828a).position(0);
        this.f6832c = new float[9];
        this.f6833d = new float[9];
        this.f6834e = new float[9];
        this.f6835f = new float[9];
        this.f6836g = new float[9];
        this.f6837h = new float[9];
        this.f6838i = new float[9];
        this.f6839j = Float.NaN;
        this.f6831b = new C2330b(context);
        this.f6831b.m7382a((C2329a) this);
        this.f6850u = new CountDownLatch(1);
        this.f6851v = new Object();
    }

    private float m7422a(float[] fArr) {
        float[] a = m7427a(fArr, new float[]{0.0f, 1.0f, 0.0f});
        return ((float) Math.atan2((double) a[1], (double) a[0])) - 1.5707964f;
    }

    private int m7423a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        m7424a("createShader");
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            m7424a("shaderSource");
            GLES20.glCompileShader(glCreateShader);
            m7424a("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            m7424a("getShaderiv");
            if (iArr[0] == 0) {
                Log.e("SphericalVideoRenderer", "Could not compile shader " + i + ":");
                Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                m7424a("deleteShader");
                return 0;
            }
        }
        return glCreateShader;
    }

    private void m7424a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("SphericalVideoRenderer", new StringBuilder(String.valueOf(str).length() + 21).append(str).append(": glError ").append(glGetError).toString());
        }
    }

    private void m7425a(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = (float) Math.cos((double) f);
        fArr[5] = (float) (-Math.sin((double) f));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin((double) f);
        fArr[8] = (float) Math.cos((double) f);
    }

    private void m7426a(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = ((fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3])) + (fArr2[2] * fArr3[6]);
        fArr[1] = ((fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4])) + (fArr2[2] * fArr3[7]);
        fArr[2] = ((fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5])) + (fArr2[2] * fArr3[8]);
        fArr[3] = ((fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3])) + (fArr2[5] * fArr3[6]);
        fArr[4] = ((fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4])) + (fArr2[5] * fArr3[7]);
        fArr[5] = ((fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5])) + (fArr2[5] * fArr3[8]);
        fArr[6] = ((fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3])) + (fArr2[8] * fArr3[6]);
        fArr[7] = ((fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4])) + (fArr2[8] * fArr3[7]);
        fArr[8] = ((fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5])) + (fArr2[8] * fArr3[8]);
    }

    private float[] m7427a(float[] fArr, float[] fArr2) {
        return new float[]{((fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1])) + (fArr[2] * fArr2[2]), ((fArr[3] * fArr2[0]) + (fArr[4] * fArr2[1])) + (fArr[5] * fArr2[2]), ((fArr[6] * fArr2[0]) + (fArr[7] * fArr2[1])) + (fArr[8] * fArr2[2])};
    }

    private void m7428b(float[] fArr, float f) {
        fArr[0] = (float) Math.cos((double) f);
        fArr[1] = (float) (-Math.sin((double) f));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin((double) f);
        fArr[4] = (float) Math.cos((double) f);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private void m7429e() {
        GLES20.glViewport(0, 0, this.f6843n, this.f6842m);
        m7424a("viewport");
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f6846q, "uFOVx");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f6846q, "uFOVy");
        if (this.f6843n > this.f6842m) {
            GLES20.glUniform1f(glGetUniformLocation, 0.87266463f);
            GLES20.glUniform1f(glGetUniformLocation2, (((float) this.f6842m) * 0.87266463f) / ((float) this.f6843n));
            return;
        }
        GLES20.glUniform1f(glGetUniformLocation, (((float) this.f6843n) * 0.87266463f) / ((float) this.f6842m));
        GLES20.glUniform1f(glGetUniformLocation2, 0.87266463f);
    }

    private int m7430f() {
        int a = m7423a(35633, m7432h());
        if (a == 0) {
            return 0;
        }
        int a2 = m7423a(35632, m7433i());
        if (a2 == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        m7424a("createProgram");
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, a);
            m7424a("attachShader");
            GLES20.glAttachShader(glCreateProgram, a2);
            m7424a("attachShader");
            GLES20.glLinkProgram(glCreateProgram);
            m7424a("linkProgram");
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            m7424a("getProgramiv");
            if (iArr[0] != 1) {
                Log.e("SphericalVideoRenderer", "Could not link program: ");
                Log.e("SphericalVideoRenderer", GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                m7424a("deleteProgram");
                return 0;
            }
            GLES20.glValidateProgram(glCreateProgram);
            m7424a("validateProgram");
        }
        return glCreateProgram;
    }

    @Nullable
    private EGLConfig m7431g() {
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        return !this.f6852w.eglChooseConfig(this.f6853x, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344}, eGLConfigArr, 1, iArr) ? null : iArr[0] > 0 ? eGLConfigArr[0] : null;
    }

    private String m7432h() {
        pw pwVar = qb.bi;
        return !((String) pwVar.m13225c()).equals(pwVar.m13224b()) ? (String) pwVar.m13225c() : "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}";
    }

    private String m7433i() {
        pw pwVar = qb.bj;
        return !((String) pwVar.m13225c()).equals(pwVar.m13224b()) ? (String) pwVar.m13225c() : "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}";
    }

    void m7434a() {
        while (this.f6848s > 0) {
            this.f6844o.updateTexImage();
            this.f6848s--;
        }
        if (this.f6831b.m7385b(this.f6832c)) {
            if (Float.isNaN(this.f6839j)) {
                this.f6839j = -m7422a(this.f6832c);
            }
            m7428b(this.f6837h, this.f6839j + this.f6840k);
        } else {
            m7425a(this.f6832c, -1.5707964f);
            m7428b(this.f6837h, this.f6840k);
        }
        m7425a(this.f6833d, 1.5707964f);
        m7426a(this.f6834e, this.f6837h, this.f6833d);
        m7426a(this.f6835f, this.f6832c, this.f6834e);
        m7425a(this.f6836g, this.f6841l);
        m7426a(this.f6838i, this.f6836g, this.f6835f);
        GLES20.glUniformMatrix3fv(this.f6847r, 1, false, this.f6838i, 0);
        GLES20.glDrawArrays(5, 0, 4);
        m7424a("drawArrays");
        GLES20.glFinish();
        this.f6852w.eglSwapBuffers(this.f6853x, this.f6855z);
    }

    int m7435b() {
        this.f6846q = m7430f();
        GLES20.glUseProgram(this.f6846q);
        m7424a("useProgram");
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f6846q, "aPosition");
        GLES20.glVertexAttribPointer(glGetAttribLocation, 3, 5126, false, 12, this.f6849t);
        m7424a("vertexAttribPointer");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        m7424a("enableVertexAttribArray");
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        m7424a("genTextures");
        glGetAttribLocation = iArr[0];
        GLES20.glBindTexture(36197, glGetAttribLocation);
        m7424a("bindTextures");
        GLES20.glTexParameteri(36197, 10240, 9729);
        m7424a("texParameteri");
        GLES20.glTexParameteri(36197, 10241, 9729);
        m7424a("texParameteri");
        GLES20.glTexParameteri(36197, 10242, 33071);
        m7424a("texParameteri");
        GLES20.glTexParameteri(36197, 10243, 33071);
        m7424a("texParameteri");
        this.f6847r = GLES20.glGetUniformLocation(this.f6846q, "uVMat");
        GLES20.glUniformMatrix3fv(this.f6847r, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
        return glGetAttribLocation;
    }

    boolean m7436c() {
        this.f6852w = (EGL10) EGLContext.getEGL();
        this.f6853x = this.f6852w.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.f6853x == EGL10.EGL_NO_DISPLAY) {
            return false;
        }
        if (!this.f6852w.eglInitialize(this.f6853x, new int[2])) {
            return false;
        }
        EGLConfig g = m7431g();
        if (g == null) {
            return false;
        }
        this.f6854y = this.f6852w.eglCreateContext(this.f6853x, g, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        if (this.f6854y == null || this.f6854y == EGL10.EGL_NO_CONTEXT) {
            return false;
        }
        this.f6855z = this.f6852w.eglCreateWindowSurface(this.f6853x, g, this.f6845p, null);
        return (this.f6855z == null || this.f6855z == EGL10.EGL_NO_SURFACE) ? false : this.f6852w.eglMakeCurrent(this.f6853x, this.f6855z, this.f6855z, this.f6854y);
    }

    boolean m7437d() {
        boolean z = false;
        if (!(this.f6855z == null || this.f6855z == EGL10.EGL_NO_SURFACE)) {
            z = (this.f6852w.eglMakeCurrent(this.f6853x, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | 0) | this.f6852w.eglDestroySurface(this.f6853x, this.f6855z);
            this.f6855z = null;
        }
        if (this.f6854y != null) {
            z |= this.f6852w.eglDestroyContext(this.f6853x, this.f6854y);
            this.f6854y = null;
        }
        if (this.f6853x == null) {
            return z;
        }
        z |= this.f6852w.eglTerminate(this.f6853x);
        this.f6853x = null;
        return z;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f6848s++;
        synchronized (this.f6851v) {
            this.f6851v.notifyAll();
        }
    }

    public void run() {
        Object obj = 1;
        if (this.f6845p == null) {
            aad.m8423c("SphericalVideoProcessor started with no output texture.");
            this.f6850u.countDown();
            return;
        }
        boolean c = m7436c();
        int b = m7435b();
        if (this.f6846q == 0) {
            obj = null;
        }
        if (!c || r0 == null) {
            String str = "EGL initialization failed: ";
            String valueOf = String.valueOf(GLUtils.getEGLErrorString(this.f6852w.eglGetError()));
            valueOf = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
            aad.m8423c(valueOf);
            zzw.zzcQ().m15000a(new Throwable(valueOf), "SphericalVideoProcessor.run.1");
            m7437d();
            this.f6850u.countDown();
            return;
        }
        this.f6844o = new SurfaceTexture(b);
        this.f6844o.setOnFrameAvailableListener(this);
        this.f6850u.countDown();
        this.f6831b.m7384b();
        try {
            this.f6829A = true;
            while (!this.f6830B) {
                m7434a();
                if (this.f6829A) {
                    m7429e();
                    this.f6829A = false;
                }
                try {
                    synchronized (this.f6851v) {
                        if (!(this.f6830B || this.f6829A || this.f6848s != 0)) {
                            this.f6851v.wait();
                        }
                    }
                } catch (InterruptedException e) {
                }
            }
        } catch (IllegalStateException e2) {
            aad.m8426e("SphericalVideoProcessor halted unexpectedly.");
        } catch (Throwable th) {
            aad.m8422b("SphericalVideoProcessor died.", th);
            zzw.zzcQ().m15000a(th, "SphericalVideoProcessor.run.2");
        } finally {
            this.f6831b.m7386c();
            this.f6844o.setOnFrameAvailableListener(null);
            this.f6844o = null;
            m7437d();
        }
    }

    public void zza(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f6843n = i;
        this.f6842m = i2;
        this.f6845p = surfaceTexture;
    }

    public void zzb(float f, float f2) {
        float f3;
        float f4;
        if (this.f6843n > this.f6842m) {
            f3 = (1.7453293f * f) / ((float) this.f6843n);
            f4 = (1.7453293f * f2) / ((float) this.f6843n);
        } else {
            f3 = (1.7453293f * f) / ((float) this.f6842m);
            f4 = (1.7453293f * f2) / ((float) this.f6842m);
        }
        this.f6840k -= f3;
        this.f6841l -= f4;
        if (this.f6841l < -1.5707964f) {
            this.f6841l = -1.5707964f;
        }
        if (this.f6841l > 1.5707964f) {
            this.f6841l = 1.5707964f;
        }
    }

    public void zzhJ() {
        synchronized (this.f6851v) {
            this.f6851v.notifyAll();
        }
    }

    public void zzil() {
        synchronized (this.f6851v) {
            this.f6830B = true;
            this.f6845p = null;
            this.f6851v.notifyAll();
        }
    }

    public SurfaceTexture zzim() {
        if (this.f6845p == null) {
            return null;
        }
        try {
            this.f6850u.await();
        } catch (InterruptedException e) {
        }
        return this.f6844o;
    }

    public void zzj(int i, int i2) {
        synchronized (this.f6851v) {
            this.f6843n = i;
            this.f6842m = i2;
            this.f6829A = true;
            this.f6851v.notifyAll();
        }
    }
}
