package com.domobile.applock.livelock.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.domobile.applock.livelock.p014b.C0975a;
import com.domobile.applock.livelock.p014b.C0975a.C0973a;
import com.domobile.applock.livelock.p014b.C0976b;
import com.domobile.applock.livelock.p014b.C0978c;
import com.domobile.frame.p000a.C1148d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(14)
public class IconDecorView extends View {
    private Paint f1623a = new Paint(7);
    private final Rect f1624b = new Rect();
    private final Rect f1625c = new Rect();
    private final Rect f1626d = new Rect();
    private final Rect f1627e = new Rect();
    private final Rect f1628f = new Rect();
    private final Rect f1629g = new Rect();
    private Bitmap f1630h;
    private LayoutParams f1631i;
    private LayoutParams f1632j;
    private AsyncTask f1633k;
    private ArrayList<C0976b> f1634l;
    private final LinkedBlockingQueue<Bitmap> f1635m = new LinkedBlockingQueue(3);
    private final LinkedBlockingQueue<Bitmap> f1636n = new LinkedBlockingQueue(3);
    private C0975a f1637o;
    private Bitmap f1638p;
    private AtomicBoolean f1639q = new AtomicBoolean(false);

    class C09811 implements C0973a {
        final /* synthetic */ IconDecorView f1621a;

        C09811(IconDecorView iconDecorView) {
            this.f1621a = iconDecorView;
        }

        public void mo2470a() {
        }

        public void mo2471a(int i, C0976b c0976b) {
            try {
                Bitmap bitmap = (Bitmap) this.f1621a.f1635m.poll(100, TimeUnit.MILLISECONDS);
                if (bitmap != null) {
                    if (this.f1621a.f1638p != null) {
                        this.f1621a.f1636n.offer(this.f1621a.f1638p);
                    }
                    this.f1621a.f1638p = bitmap;
                    this.f1621a.invalidate();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class C09822 extends AsyncTask<Object, Object, Object> {
        final /* synthetic */ IconDecorView f1622a;

        C09822(IconDecorView iconDecorView) {
            this.f1622a = iconDecorView;
        }

        protected Object doInBackground(Object... objArr) {
            loop0:
            while (!isCancelled()) {
                int i = 0;
                while (i < this.f1622a.f1634l.size()) {
                    if (!isCancelled()) {
                        String str = ((C0976b) this.f1622a.f1634l.get(i)).f1602a;
                        Options options = new Options();
                        options.inMutable = true;
                        options.inSampleSize = 1;
                        options.inPreferredConfig = Config.ARGB_8888;
                        Bitmap bitmap = (Bitmap) this.f1622a.f1636n.poll();
                        if (bitmap != null) {
                            options.inBitmap = bitmap;
                        }
                        bitmap = C0978c.m1849a().m1852a(str, options);
                        if (isCancelled()) {
                            break loop0;
                        }
                        try {
                            this.f1622a.f1635m.put(bitmap);
                        } catch (Exception e) {
                        }
                        i++;
                    } else {
                        break loop0;
                    }
                }
            }
            return null;
        }

        protected void onCancelled(Object obj) {
            super.onCancelled(obj);
            this.f1622a.m1873d();
        }
    }

    public IconDecorView(Context context) {
        super(context);
        m1871c();
    }

    public IconDecorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1871c();
    }

    public IconDecorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1871c();
    }

    @TargetApi(21)
    public IconDecorView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m1871c();
    }

    private void m1868a(Bitmap bitmap) {
        if (!this.f1639q.get()) {
            int width = bitmap.getWidth() / 2;
            int height = bitmap.getHeight();
            int width2 = ((getWidth() / 2) + this.f1632j.leftMargin) - this.f1632j.rightMargin;
            int height2 = ((getHeight() / 2) + this.f1632j.topMargin) - this.f1632j.bottomMargin;
            this.f1625c.left = width2 - (width / 2);
            this.f1625c.top = height2 - (height / 2);
            this.f1625c.right = (width / 2) + width2;
            this.f1625c.bottom = (height / 2) + height2;
            this.f1624b.left = width;
            this.f1624b.top = 0;
            this.f1624b.right = width * 2;
            this.f1624b.bottom = height;
            int i = (this.f1631i.leftMargin + width2) - this.f1631i.rightMargin;
            int i2 = (this.f1631i.topMargin + height2) - this.f1631i.bottomMargin;
            this.f1627e.left = i - (this.f1631i.width / 2);
            this.f1627e.top = i2 - (this.f1631i.height / 2);
            this.f1627e.right = i + (this.f1631i.width / 2);
            this.f1627e.bottom = i2 + (this.f1631i.height / 2);
            this.f1626d.left = 0;
            this.f1626d.top = 0;
            this.f1626d.right = this.f1630h.getWidth();
            this.f1626d.bottom = this.f1630h.getHeight();
            this.f1629g.left = width2 - (width / 2);
            this.f1629g.top = height2 - (height / 2);
            this.f1629g.right = width2 + (width / 2);
            this.f1629g.bottom = height2 + (height / 2);
            this.f1628f.left = 0;
            this.f1628f.top = 0;
            this.f1628f.right = width;
            this.f1628f.bottom = height;
            this.f1639q.set(true);
        }
    }

    private void m1871c() {
        this.f1631i = C0978c.m1849a().m1858c();
        this.f1637o = new C0975a();
        this.f1637o.m1838a(new C09811(this));
    }

    private void m1873d() {
        ArrayList arrayList = new ArrayList();
        this.f1636n.drainTo(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Bitmap) it.next()).recycle();
        }
        arrayList.clear();
        this.f1635m.drainTo(arrayList);
        it = arrayList.iterator();
        while (it.hasNext()) {
            ((Bitmap) it.next()).recycle();
        }
        arrayList.clear();
        if (this.f1638p != null) {
            this.f1638p.recycle();
            this.f1638p = null;
        }
    }

    private void m1874e() {
        this.f1638p = C0978c.m1849a().m1855b(((C0976b) this.f1634l.get(0)).f1602a);
        invalidate();
    }

    public void m1876a() {
        this.f1639q.set(false);
        m1874e();
        if (this.f1634l.size() >= 1) {
            this.f1633k = new C09822(this);
            C1148d.m2521b(this.f1633k, new Object[0]);
            this.f1637o.m1843c();
        }
    }

    public void m1877b() {
        this.f1639q.set(false);
        if (this.f1633k != null) {
            this.f1633k.cancel(true);
            this.f1633k = null;
        }
        if (this.f1637o != null) {
            this.f1637o.m1844d();
        }
        m1873d();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1877b();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1630h != null && this.f1638p != null && !this.f1638p.isRecycled()) {
            try {
                m1868a(this.f1638p);
                canvas.drawBitmap(this.f1638p, this.f1624b, this.f1625c, this.f1623a);
                canvas.drawBitmap(this.f1630h, this.f1626d, this.f1627e, this.f1623a);
                canvas.drawBitmap(this.f1638p, this.f1628f, this.f1629g, this.f1623a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f1639q.set(false);
    }

    public void setAppIcon(Bitmap bitmap) {
        this.f1630h = bitmap;
    }

    public void setDecorParams(@NonNull LayoutParams layoutParams) {
        this.f1632j = layoutParams;
    }

    public void setFrameList(ArrayList<C0976b> arrayList) {
        this.f1634l = arrayList;
        this.f1637o.m1839a((ArrayList) arrayList);
    }
}
