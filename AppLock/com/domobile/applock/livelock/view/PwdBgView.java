package com.domobile.applock.livelock.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.domobile.applock.livelock.p014b.C0975a;
import com.domobile.applock.livelock.p014b.C0975a.C0973a;
import com.domobile.applock.livelock.p014b.C0976b;
import com.domobile.applock.livelock.p014b.C0978c;
import com.domobile.frame.p000a.C1148d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PwdBgView extends View {
    private Paint f1757a = new Paint(7);
    private AsyncTask f1758b;
    private ArrayList<C0976b> f1759c;
    private final LinkedBlockingQueue<Bitmap> f1760d = new LinkedBlockingQueue(3);
    private final LinkedBlockingQueue<Bitmap> f1761e = new LinkedBlockingQueue(3);
    private C0975a f1762f;
    private Bitmap f1763g;
    private Rect f1764h;
    private byte[] f1765i;

    class C09991 implements C0973a {
        final /* synthetic */ PwdBgView f1755a;

        C09991(PwdBgView pwdBgView) {
            this.f1755a = pwdBgView;
        }

        public void mo2470a() {
        }

        public void mo2471a(int i, C0976b c0976b) {
            try {
                Bitmap bitmap = (Bitmap) this.f1755a.f1760d.poll(100, TimeUnit.MILLISECONDS);
                if (bitmap != null) {
                    if (this.f1755a.f1763g != null) {
                        this.f1755a.f1761e.offer(this.f1755a.f1763g);
                    }
                    this.f1755a.f1763g = bitmap;
                    this.f1755a.invalidate();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class C10002 extends AsyncTask<Object, Object, Object> {
        final /* synthetic */ PwdBgView f1756a;

        C10002(PwdBgView pwdBgView) {
            this.f1756a = pwdBgView;
        }

        protected Object doInBackground(Object... objArr) {
            loop0:
            while (!isCancelled()) {
                int i = 0;
                while (i < this.f1756a.f1759c.size()) {
                    if (!isCancelled()) {
                        String str = ((C0976b) this.f1756a.f1759c.get(i)).f1602a;
                        Options options = new Options();
                        options.inMutable = true;
                        options.inSampleSize = 1;
                        options.inPreferredConfig = Config.ARGB_8888;
                        Bitmap bitmap = (Bitmap) this.f1756a.f1761e.poll();
                        if (bitmap != null) {
                            options.inBitmap = bitmap;
                        }
                        bitmap = C0978c.m1849a().m1852a(str, options);
                        if (isCancelled()) {
                            break loop0;
                        }
                        try {
                            this.f1756a.f1760d.put(bitmap);
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
            this.f1756a.m1999d();
        }
    }

    public PwdBgView(Context context) {
        super(context);
        m1994a(context);
    }

    public PwdBgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1994a(context);
    }

    public PwdBgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1994a(context);
    }

    @TargetApi(21)
    public PwdBgView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m1994a(context);
    }

    private void m1994a(Context context) {
        this.f1764h = C0978c.m1849a().m1859d();
        this.f1762f = new C0975a();
        this.f1762f.m1838a(new C09991(this));
    }

    private void m1997c() {
        this.f1758b = new C10002(this);
        C1148d.m2521b(this.f1758b, new Object[0]);
    }

    private void m1999d() {
        ArrayList arrayList = new ArrayList();
        this.f1761e.drainTo(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Bitmap) it.next()).recycle();
        }
        arrayList.clear();
        this.f1760d.drainTo(arrayList);
        it = arrayList.iterator();
        while (it.hasNext()) {
            ((Bitmap) it.next()).recycle();
        }
        arrayList.clear();
        if (this.f1763g != null) {
            this.f1763g.recycle();
            this.f1763g = null;
        }
    }

    public void m2001a() {
        if (this.f1759c != null && this.f1759c.size() != 0) {
            this.f1763g = C0978c.m1849a().m1855b(((C0976b) this.f1759c.get(0)).f1602a);
            if (this.f1763g != null) {
                this.f1765i = this.f1763g.getNinePatchChunk();
                m1997c();
                requestLayout();
                this.f1762f.m1843c();
            }
        }
    }

    public void m2002b() {
        if (this.f1758b != null) {
            this.f1758b.cancel(true);
            this.f1758b = null;
        }
        if (this.f1762f != null) {
            this.f1762f.m1844d();
        }
        m1999d();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1763g != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), this.f1763g, this.f1765i, this.f1764h, null);
            ninePatchDrawable.setBounds(0, 0, getWidth(), getHeight());
            ninePatchDrawable.draw(canvas);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1763g != null) {
            setMeasuredDimension(MeasureSpec.getSize(i), this.f1763g.getHeight());
        }
    }

    public void setFrameList(ArrayList<C0976b> arrayList) {
        this.f1759c = arrayList;
        this.f1762f.m1839a((ArrayList) arrayList);
    }
}
