package com.domobile.applock.chamber.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.domobile.applock.R;

public class DownloadProgressView extends View {
    private int f1312a = 0;
    private int f1313b = 0;
    private Paint f1314c;
    private Paint f1315d;
    private Paint f1316e;
    private int f1317f;
    private RectF f1318g;
    private Bitmap f1319h;
    private Bitmap f1320i;
    private Bitmap f1321j;
    private Bitmap f1322k;
    private Rect f1323l = new Rect();
    private Rect f1324m = new Rect();
    private Paint f1325n = new Paint(7);

    public DownloadProgressView(Context context) {
        super(context);
        m1534a(context);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1534a(context);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1534a(context);
    }

    @TargetApi(21)
    public DownloadProgressView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m1534a(context);
    }

    private void m1534a(Context context) {
        this.f1318g = new RectF();
        int color = ContextCompat.getColor(context, R.color.bg_white_holo);
        int parseColor = Color.parseColor("#EEEEEE");
        int parseColor2 = Color.parseColor("#009688");
        this.f1317f = m1535a(context, 2.0f);
        this.f1314c = new Paint(1);
        this.f1314c.setColor(color);
        this.f1314c.setStyle(Style.FILL);
        this.f1314c.setStrokeCap(Cap.ROUND);
        this.f1315d = new Paint(1);
        this.f1315d.setColor(parseColor);
        this.f1315d.setStyle(Style.STROKE);
        this.f1315d.setStrokeWidth((float) this.f1317f);
        this.f1315d.setStrokeCap(Cap.ROUND);
        this.f1316e = new Paint(1);
        this.f1316e.setColor(parseColor2);
        this.f1316e.setStyle(Style.STROKE);
        this.f1316e.setStrokeWidth((float) this.f1317f);
        this.f1316e.setStrokeCap(Cap.ROUND);
        this.f1319h = BitmapFactory.decodeResource(getResources(), R.drawable.icon_download_delete);
        this.f1320i = BitmapFactory.decodeResource(getResources(), R.drawable.icon_download_finished);
        this.f1321j = BitmapFactory.decodeResource(getResources(), R.drawable.icon_download_retry);
        this.f1322k = BitmapFactory.decodeResource(getResources(), R.drawable.icon_download_waiting);
        this.f1323l.left = 0;
        this.f1323l.top = 0;
        this.f1324m.left = 0;
        this.f1324m.top = 0;
    }

    public int m1535a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (width != 0) {
            int i = width / 2;
            int i2 = height / 2;
            int i3 = width / 2;
            int i4 = this.f1317f / 2;
            canvas.drawCircle((float) i, (float) i2, (float) i3, this.f1314c);
            Bitmap bitmap = null;
            if (this.f1313b == 1) {
                bitmap = this.f1319h;
            } else if (this.f1313b == 0) {
                bitmap = this.f1322k;
            } else if (this.f1313b == 2) {
                bitmap = this.f1320i;
            } else if (this.f1313b == 3 || this.f1313b == 4) {
                bitmap = this.f1321j;
            }
            if (bitmap != null) {
                this.f1323l.right = bitmap.getWidth();
                this.f1323l.bottom = bitmap.getHeight();
                this.f1324m.right = width;
                this.f1324m.bottom = height;
                canvas.drawBitmap(bitmap, this.f1323l, this.f1324m, this.f1325n);
            }
            if (this.f1313b == 1) {
                canvas.drawCircle((float) i, (float) i2, (float) (i3 - i4), this.f1315d);
                this.f1318g.left = (float) i4;
                this.f1318g.top = (float) i4;
                this.f1318g.right = (float) (getWidth() - i4);
                this.f1318g.bottom = (float) (getHeight() - i4);
                Canvas canvas2 = canvas;
                canvas2.drawArc(this.f1318g, -90.0f, (0.01f * ((float) this.f1312a)) * 360.0f, false, this.f1316e);
            }
        }
    }

    public void setProgress(int i) {
        this.f1312a = i;
        invalidate();
    }

    public void setStatus(int i) {
        this.f1313b = i;
        invalidate();
    }
}
