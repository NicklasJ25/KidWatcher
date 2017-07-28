package com.domobile.cropimage;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.domobile.p015b.C1168b.C1162f;
import com.domobile.p015b.C1168b.C1163g;
import com.domobile.p015b.C1168b.C1165i;
import java.util.concurrent.CountDownLatch;

public class C0591d extends C0590n {
    boolean f454a;
    boolean f455b;
    C1191e f456c;
    Runnable f457d = new C11894(this);
    private int f458e;
    private int f459f;
    private boolean f460g = false;
    private boolean f461h = false;
    private final Handler f462i = new Handler();
    private int f463j;
    private int f464k;
    private boolean f465l;
    private boolean f466m = true;
    private CropImageView f467n;
    private ContentResolver f468o;
    private Bitmap f469p;
    private C1175g f470q;
    private C1177f f471r;

    class C11841 implements OnClickListener {
        final /* synthetic */ C0591d f2314a;

        C11841(C0591d c0591d) {
            this.f2314a = c0591d;
        }

        public void onClick(View view) {
            this.f2314a.setResult(0);
            this.f2314a.finish();
        }
    }

    class C11852 implements OnClickListener {
        final /* synthetic */ C0591d f2315a;

        C11852(C0591d c0591d) {
            this.f2315a = c0591d;
        }

        public void onClick(View view) {
            this.f2315a.m613a();
        }
    }

    class C11873 implements Runnable {
        final /* synthetic */ C0591d f2319a;

        C11873(C0591d c0591d) {
            this.f2319a = c0591d;
        }

        public void run() {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final Bitmap a = this.f2319a.f471r != null ? this.f2319a.f471r.mo2510a(-1, 1048576) : this.f2319a.f469p;
            this.f2319a.f462i.post(new Runnable(this) {
                final /* synthetic */ C11873 f2318c;

                public void run() {
                    if (!(a == this.f2318c.f2319a.f469p || a == null)) {
                        this.f2318c.f2319a.f467n.mo2498a(a, true);
                        this.f2318c.f2319a.f469p.recycle();
                        this.f2318c.f2319a.f469p = a;
                    }
                    if (this.f2318c.f2319a.f467n.getScale() == 1.0f) {
                        this.f2318c.f2319a.f467n.m2700a(true, true);
                    }
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
                this.f2319a.f457d.run();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    class C11894 implements Runnable {
        float f2321a = 1.0f;
        Matrix f2322b;
        Face[] f2323c = new Face[3];
        int f2324d;
        final /* synthetic */ C0591d f2325e;

        class C11881 implements Runnable {
            final /* synthetic */ C11894 f2320a;

            C11881(C11894 c11894) {
                this.f2320a = c11894;
            }

            public void run() {
                this.f2320a.f2325e.f454a = this.f2320a.f2324d > 1;
                if (this.f2320a.f2324d > 0) {
                    for (int i = 0; i < this.f2320a.f2324d; i++) {
                        this.f2320a.m2761a(this.f2320a.f2323c[i]);
                    }
                } else {
                    this.f2320a.m2760a();
                }
                this.f2320a.f2325e.f467n.invalidate();
                if (this.f2320a.f2325e.f467n.f2266a.size() == 1) {
                    this.f2320a.f2325e.f456c = (C1191e) this.f2320a.f2325e.f467n.f2266a.get(0);
                    this.f2320a.f2325e.f456c.m2772a(true);
                }
            }
        }

        C11894(C0591d c0591d) {
            this.f2325e = c0591d;
        }

        private void m2760a() {
            int i;
            int i2;
            boolean z = false;
            C1191e c1191e = new C1191e(this.f2325e.f467n);
            int width = this.f2325e.f469p.getWidth();
            int height = this.f2325e.f469p.getHeight();
            Rect rect = new Rect(0, 0, width, height);
            int min = (Math.min(width, height) * 4) / 5;
            if (this.f2325e.f458e == 0 || this.f2325e.f459f == 0) {
                i = min;
                i2 = min;
            } else if (this.f2325e.f458e > this.f2325e.f459f) {
                i = (this.f2325e.f459f * min) / this.f2325e.f458e;
                i2 = min;
            } else {
                i2 = (this.f2325e.f458e * min) / this.f2325e.f459f;
                i = min;
            }
            width = (width - i2) / 2;
            height = (height - i) / 2;
            RectF rectF = new RectF((float) width, (float) height, (float) (i2 + width), (float) (i + height));
            Matrix matrix = this.f2322b;
            boolean e = this.f2325e.f461h;
            if (!(this.f2325e.f458e == 0 || this.f2325e.f459f == 0)) {
                z = true;
            }
            c1191e.m2770a(matrix, rect, rectF, e, z);
            this.f2325e.f467n.m2710a(c1191e);
        }

        private void m2761a(Face face) {
            boolean z = false;
            PointF pointF = new PointF();
            int eyesDistance = ((int) (face.eyesDistance() * this.f2321a)) * 2;
            face.getMidPoint(pointF);
            pointF.x *= this.f2321a;
            pointF.y *= this.f2321a;
            int i = (int) pointF.x;
            int i2 = (int) pointF.y;
            C1191e c1191e = new C1191e(this.f2325e.f467n);
            Rect rect = new Rect(0, 0, this.f2325e.f469p.getWidth(), this.f2325e.f469p.getHeight());
            RectF rectF = new RectF((float) i, (float) i2, (float) i, (float) i2);
            rectF.inset((float) (-eyesDistance), (float) (-eyesDistance));
            if (rectF.left < 0.0f) {
                rectF.inset(-rectF.left, -rectF.left);
            }
            if (rectF.top < 0.0f) {
                rectF.inset(-rectF.top, -rectF.top);
            }
            if (rectF.right > ((float) rect.right)) {
                rectF.inset(rectF.right - ((float) rect.right), rectF.right - ((float) rect.right));
            }
            if (rectF.bottom > ((float) rect.bottom)) {
                rectF.inset(rectF.bottom - ((float) rect.bottom), rectF.bottom - ((float) rect.bottom));
            }
            Matrix matrix = this.f2322b;
            boolean e = this.f2325e.f461h;
            if (!(this.f2325e.f458e == 0 || this.f2325e.f459f == 0)) {
                z = true;
            }
            c1191e.m2770a(matrix, rect, rectF, e, z);
            this.f2325e.f467n.m2710a(c1191e);
        }

        private Bitmap m2764b() {
            if (this.f2325e.f469p == null) {
                return null;
            }
            if (this.f2325e.f469p.getWidth() > 256) {
                this.f2321a = 256.0f / ((float) this.f2325e.f469p.getWidth());
            }
            Matrix matrix = new Matrix();
            matrix.setScale(this.f2321a, this.f2321a);
            return Bitmap.createBitmap(this.f2325e.f469p, 0, 0, this.f2325e.f469p.getWidth(), this.f2325e.f469p.getHeight(), matrix, true);
        }

        public void run() {
            this.f2322b = this.f2325e.f467n.getImageMatrix();
            Bitmap b = m2764b();
            this.f2321a = 1.0f / this.f2321a;
            if (b != null && this.f2325e.f460g) {
                this.f2324d = new FaceDetector(b.getWidth(), b.getHeight(), this.f2323c.length).findFaces(b, this.f2323c);
            }
            if (!(b == null || b == this.f2325e.f469p)) {
                b.recycle();
            }
            this.f2325e.f462i.post(new C11881(this));
        }
    }

    private void m606b() {
        if (!isFinishing()) {
            this.f467n.mo2498a(this.f469p, true);
            C1203k.m2816a((C0590n) this, null, getResources().getString(C1165i.wait), new C11873(this), this.f462i);
        }
    }

    public void m613a() {
        if (this.f456c != null && !this.f455b) {
            Bitmap createBitmap;
            this.f455b = true;
            Rect b;
            int height;
            Canvas canvas;
            if (this.f463j == 0 || this.f464k == 0 || this.f465l) {
                b = this.f456c.m2774b();
                int width = b.width();
                height = b.height();
                createBitmap = Bitmap.createBitmap(width, height, this.f461h ? Config.ARGB_8888 : Config.RGB_565);
                new Canvas(createBitmap).drawBitmap(this.f469p, b, new Rect(0, 0, width, height), null);
                this.f467n.mo2495a();
                this.f469p.recycle();
                if (this.f461h) {
                    canvas = new Canvas(createBitmap);
                    Path path = new Path();
                    path.addCircle(((float) width) / 2.0f, ((float) height) / 2.0f, ((float) width) / 2.0f, Direction.CW);
                    canvas.clipPath(path, Op.DIFFERENCE);
                    canvas.drawColor(0, Mode.CLEAR);
                }
                if (!(this.f463j == 0 || this.f464k == 0 || !this.f465l)) {
                    createBitmap = C1203k.m2812a(new Matrix(), createBitmap, this.f463j, this.f464k, this.f466m, true);
                }
            } else {
                createBitmap = Bitmap.createBitmap(this.f463j, this.f464k, Config.RGB_565);
                canvas = new Canvas(createBitmap);
                b = this.f456c.m2774b();
                Rect rect = new Rect(0, 0, this.f463j, this.f464k);
                height = (b.width() - rect.width()) / 2;
                int height2 = (b.height() - rect.height()) / 2;
                b.inset(Math.max(0, height), Math.max(0, height2));
                rect.inset(Math.max(0, -height), Math.max(0, -height2));
                canvas.drawBitmap(this.f469p, b, rect, null);
                this.f467n.mo2495a();
                this.f469p.recycle();
            }
            this.f467n.mo2498a(createBitmap, true);
            this.f467n.m2700a(true, true);
            this.f467n.f2266a.clear();
            Bundle extras = getIntent().getExtras();
            if (extras != null && (extras.getParcelable("data") != null || extras.getBoolean("return-data"))) {
                extras = new Bundle();
                extras.putParcelable("data", createBitmap);
                setResult(-1, new Intent().setAction("inline-data").putExtras(extras));
                finish();
            }
            mo2358a(createBitmap);
        }
    }

    public void mo2358a(Bitmap bitmap) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f468o = getContentResolver();
        requestWindowFeature(1);
        setContentView(C1163g.crop_image);
        this.f467n = (CropImageView) findViewById(C1162f.image);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.getString("circleCrop") != null) {
                this.f461h = true;
                this.f458e = 1;
                this.f459f = 1;
            }
            this.f469p = (Bitmap) extras.getParcelable("data");
            this.f458e = extras.getInt("aspectX");
            this.f459f = extras.getInt("aspectY");
            this.f463j = extras.getInt("outputX");
            this.f464k = extras.getInt("outputY");
            this.f465l = extras.getBoolean("scale", true);
            this.f466m = extras.getBoolean("scaleUpIfNeeded", true);
            boolean z = extras.containsKey("noFaceDetection") ? !extras.getBoolean("noFaceDetection") : false;
            this.f460g = z;
        }
        if (this.f469p == null) {
            Uri data = intent.getData();
            this.f470q = ImageManager.m2725a(this.f468o, data, 1);
            this.f471r = this.f470q.mo2506a(data);
            if (this.f471r != null) {
                this.f469p = this.f471r.mo2511a(true);
            }
        }
        if (this.f469p == null) {
            finish();
            return;
        }
        getWindow().addFlags(1024);
        findViewById(C1162f.discard).setOnClickListener(new C11841(this));
        findViewById(C1162f.save).setOnClickListener(new C11852(this));
        m606b();
    }

    protected void onDestroy() {
        if (this.f470q != null) {
            this.f470q.mo2507a();
        }
        super.onDestroy();
    }
}
