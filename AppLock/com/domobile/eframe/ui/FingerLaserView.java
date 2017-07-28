package com.domobile.eframe.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.domobile.applock.R;

public final class FingerLaserView extends SurfaceView implements Callback {
    private Paint f2435a = null;
    private int f2436b = 2;
    private int f2437c = 0;
    private int f2438d = 0;
    private Bitmap f2439e = null;
    private Bitmap f2440f = null;
    private Matrix f2441g = new Matrix();
    private int f2442h = 0;
    private int f2443i = 0;
    private int f2444j = 0;
    private int f2445k = 0;
    private SurfaceHolder f2446l;
    private C1231a f2447m;

    private class C1231a extends Thread {
        public boolean f2431a = true;
        public boolean f2432b;
        final /* synthetic */ FingerLaserView f2433c;
        private SurfaceHolder f2434d;

        public C1231a(FingerLaserView fingerLaserView, SurfaceHolder surfaceHolder) {
            this.f2433c = fingerLaserView;
            this.f2434d = surfaceHolder;
        }

        public void run() {
            this.f2432b = true;
            while (this.f2431a) {
                try {
                    Canvas lockCanvas;
                    synchronized (this.f2434d) {
                        lockCanvas = this.f2434d.lockCanvas();
                        this.f2433c.m2900a(lockCanvas);
                        Thread.sleep(12);
                    }
                    if (lockCanvas != null) {
                        try {
                            this.f2434d.unlockCanvasAndPost(lockCanvas);
                        } catch (Throwable th) {
                        }
                    }
                } catch (Exception e) {
                    if (null != null) {
                        try {
                            this.f2434d.unlockCanvasAndPost(null);
                        } catch (Throwable th2) {
                        }
                    }
                } catch (Throwable th3) {
                    if (null != null) {
                        this.f2434d.unlockCanvasAndPost(null);
                    }
                }
            }
        }
    }

    public FingerLaserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = context.getResources();
        this.f2435a = new Paint(1);
        this.f2436b = resources.getDimensionPixelSize(R.dimen.finger_laser_view_scan_minium_distance);
        this.f2444j = resources.getDimensionPixelSize(R.dimen.finger_laser_view_top_border_height);
        this.f2445k = this.f2444j * 2;
        resources = getResources();
        this.f2439e = BitmapFactory.decodeResource(resources, R.drawable.scaning_highlight);
        this.f2440f = BitmapFactory.decodeResource(resources, R.drawable.scaning_fingerprint);
        this.f2442h = this.f2439e.getWidth();
        this.f2443i = this.f2439e.getHeight();
        this.f2441g.setRotate(180.0f);
        this.f2446l = getHolder();
        this.f2446l.addCallback(this);
        this.f2447m = new C1231a(this, this.f2446l);
    }

    public void m2900a(Canvas canvas) {
        if (this.f2439e != null && !this.f2439e.isRecycled() && this.f2440f != null && !this.f2440f.isRecycled() && isShown()) {
            int width = getWidth();
            int height = getHeight();
            if (width > 0 && height > 0) {
                this.f2438d += this.f2436b;
                Bitmap createBitmap;
                if (this.f2438d >= height - this.f2445k) {
                    this.f2438d = height - this.f2445k;
                    this.f2436b = -this.f2436b;
                    createBitmap = Bitmap.createBitmap(this.f2439e, 0, 0, this.f2442h, this.f2443i, this.f2441g, false);
                    this.f2439e.recycle();
                    this.f2439e = createBitmap;
                } else if (this.f2438d <= this.f2444j - this.f2443i) {
                    this.f2438d = this.f2444j - this.f2443i;
                    this.f2436b = -this.f2436b;
                    createBitmap = Bitmap.createBitmap(this.f2439e, 0, 0, this.f2442h, this.f2443i, this.f2441g, false);
                    this.f2439e.recycle();
                    this.f2439e = createBitmap;
                }
                canvas.drawBitmap(this.f2440f, null, new Rect(0, 0, width, height), this.f2435a);
                canvas.drawBitmap(this.f2439e, null, new Rect(this.f2437c, this.f2438d, width, this.f2438d + this.f2443i), this.f2435a);
            }
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (!this.f2447m.f2432b) {
            this.f2447m.f2431a = true;
            this.f2447m.start();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f2447m.f2431a = false;
        if (this.f2440f != null) {
            this.f2440f.recycle();
        }
        if (this.f2439e != null) {
            this.f2439e.recycle();
        }
        this.f2440f = null;
        this.f2439e = null;
        this.f2441g = null;
        this.f2435a = null;
        this.f2446l = null;
    }
}
