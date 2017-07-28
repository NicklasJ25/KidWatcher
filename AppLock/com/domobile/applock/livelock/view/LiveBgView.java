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
import android.util.AttributeSet;
import android.view.View;
import com.domobile.applock.livelock.p014b.C0975a;
import com.domobile.applock.livelock.p014b.C0975a.C0973a;
import com.domobile.applock.livelock.p014b.C0976b;
import com.domobile.applock.livelock.p014b.C0978c;
import com.domobile.frame.p000a.C1148d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@TargetApi(14)
public class LiveBgView extends View {
    private Paint f1642a = new Paint(7);
    private Rect f1643b;
    private Rect f1644c;
    private AsyncTask f1645d;
    private ArrayList<C0976b> f1646e;
    private ArrayList<C0976b> f1647f;
    private boolean f1648g = false;
    private final LinkedBlockingQueue<Bitmap> f1649h = new LinkedBlockingQueue(2);
    private final LinkedBlockingQueue<Bitmap> f1650i = new LinkedBlockingQueue(2);
    private C0975a f1651j;
    private Bitmap f1652k;

    class C09831 implements C0973a {
        final /* synthetic */ LiveBgView f1640a;

        C09831(LiveBgView liveBgView) {
            this.f1640a = liveBgView;
        }

        public void mo2470a() {
        }

        public void mo2471a(int i, C0976b c0976b) {
            try {
                Bitmap bitmap = (Bitmap) this.f1640a.f1649h.poll(100, TimeUnit.MILLISECONDS);
                if (bitmap != null) {
                    if (this.f1640a.f1652k != null) {
                        this.f1640a.f1650i.offer(this.f1640a.f1652k);
                    }
                    this.f1640a.f1652k = bitmap;
                    this.f1640a.invalidate();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class C09842 extends AsyncTask<Object, Object, Object> {
        final /* synthetic */ LiveBgView f1641a;

        C09842(LiveBgView liveBgView) {
            this.f1641a = liveBgView;
        }

        protected Object doInBackground(Object... objArr) {
            ArrayList e = this.f1641a.f1648g ? this.f1641a.f1646e : this.f1641a.f1647f;
            loop0:
            while (!isCancelled()) {
                int i = 0;
                while (i < e.size()) {
                    if (!isCancelled()) {
                        String str = ((C0976b) e.get(i)).f1602a;
                        Options options = new Options();
                        options.inMutable = true;
                        options.inSampleSize = 1;
                        options.inPreferredConfig = Config.ARGB_8888;
                        Bitmap bitmap = (Bitmap) this.f1641a.f1650i.poll();
                        if (bitmap != null) {
                            options.inBitmap = bitmap;
                        }
                        bitmap = C0978c.m1849a().m1852a(str, options);
                        if (isCancelled()) {
                            break loop0;
                        }
                        try {
                            this.f1641a.f1649h.put(bitmap);
                        } catch (Exception e2) {
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
            this.f1641a.m1886c();
        }
    }

    public LiveBgView(Context context) {
        super(context);
        m1882a(context);
    }

    public LiveBgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1882a(context);
    }

    public LiveBgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1882a(context);
    }

    @TargetApi(21)
    public LiveBgView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m1882a(context);
    }

    private void m1882a(Context context) {
        this.f1651j = new C0975a();
        this.f1651j.m1838a(new C09831(this));
    }

    private void m1883a(Bitmap bitmap) {
        if (this.f1643b == null) {
            this.f1643b = new Rect();
            this.f1643b.left = 0;
            this.f1643b.top = 0;
            this.f1643b.right = bitmap.getWidth();
            this.f1643b.bottom = bitmap.getHeight();
            this.f1644c = new Rect();
            this.f1644c.left = 0;
            this.f1644c.top = 0;
            this.f1644c.right = getWidth();
            this.f1644c.bottom = getHeight();
        }
    }

    private void m1886c() {
        ArrayList arrayList = new ArrayList();
        this.f1650i.drainTo(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Bitmap) it.next()).recycle();
        }
        arrayList.clear();
        this.f1649h.drainTo(arrayList);
        it = arrayList.iterator();
        while (it.hasNext()) {
            ((Bitmap) it.next()).recycle();
        }
        arrayList.clear();
        if (this.f1652k != null) {
            this.f1652k.recycle();
            this.f1652k = null;
        }
    }

    private void m1887d() {
        if (this.f1648g) {
            this.f1652k = C0978c.m1849a().m1855b(((C0976b) this.f1646e.get(0)).f1602a);
        } else {
            this.f1652k = C0978c.m1849a().m1855b(((C0976b) this.f1647f.get(0)).f1602a);
        }
        invalidate();
    }

    private void m1890e() {
        this.f1645d = new C09842(this);
        C1148d.m2521b(this.f1645d, new Object[0]);
    }

    public void m1893a() {
        m1887d();
        if (this.f1648g && this.f1646e.size() > 1) {
            m1890e();
            this.f1651j.m1839a(this.f1646e);
            this.f1651j.m1843c();
        } else if (!this.f1648g && this.f1647f.size() > 1) {
            m1890e();
            this.f1651j.m1839a(this.f1647f);
            this.f1651j.m1843c();
        }
    }

    public void m1894b() {
        if (this.f1645d != null) {
            this.f1645d.cancel(true);
            this.f1645d = null;
        }
        if (this.f1651j != null) {
            this.f1651j.m1844d();
        }
        m1886c();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1894b();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1652k != null) {
            try {
                m1883a(this.f1652k);
                canvas.drawBitmap(this.f1652k, this.f1643b, this.f1644c, this.f1642a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f1643b = null;
    }

    public void setLandFrameList(ArrayList<C0976b> arrayList) {
        this.f1646e = arrayList;
    }

    public void setLandscape(boolean z) {
        this.f1648g = z;
    }

    public void setPortFrameList(ArrayList<C0976b> arrayList) {
        this.f1647f = arrayList;
    }
}
