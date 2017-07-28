package com.domobile.applock.livelock.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.domobile.applock.C1140x.C1139g;
import com.domobile.applock.R;
import com.domobile.applock.livelock.p014b.C0975a;
import com.domobile.applock.livelock.p014b.C0975a.C0973a;
import com.domobile.applock.livelock.p014b.C0976b;
import com.domobile.applock.livelock.p014b.C0978c;
import com.domobile.frame.p000a.C1148d;
import com.domobile.imagelock.LockPatternView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@TargetApi(14)
public class LiveNumberView extends View {
    public ArrayList<ArrayList<C0976b>> f1669a;
    private int f1670b;
    private Paint f1671c = new Paint(7);
    private int f1672d;
    private int f1673e;
    private int f1674f;
    private int f1675g;
    private int f1676h;
    private AsyncTask f1677i;
    private AsyncTask f1678j;
    private ArrayList<C0976b> f1679k;
    private final LinkedBlockingQueue<Bitmap> f1680l = new LinkedBlockingQueue(3);
    private final LinkedBlockingQueue<Bitmap> f1681m = new LinkedBlockingQueue(3);
    private Bitmap f1682n;
    private C0975a f1683o;
    private boolean f1684p = false;
    private boolean f1685q = true;
    private Vibrator f1686r;
    private ArrayList<C0989a> f1687s = new ArrayList();
    private ArrayList<C0989a> f1688t = new ArrayList();
    private Point f1689u = new Point();
    private Point f1690v = new Point();
    private C0961b f1691w;
    private C0989a f1692x;
    private Handler f1693y = new Handler(this, Looper.getMainLooper()) {
        final /* synthetic */ LiveNumberView f1656a;

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1 && this.f1656a.f1691w != null) {
                this.f1656a.f1691w.mo2458g();
            }
        }
    };

    public interface C0961b {
        void mo2454a(int i);

        void mo2456e();

        void mo2457f();

        void mo2458g();
    }

    class C09851 implements C0973a {
        final /* synthetic */ LiveNumberView f1653a;

        C09851(LiveNumberView liveNumberView) {
            this.f1653a = liveNumberView;
        }

        public void mo2470a() {
        }

        public void mo2471a(int i, C0976b c0976b) {
            try {
                Bitmap bitmap = (Bitmap) this.f1653a.f1680l.poll(100, TimeUnit.MILLISECONDS);
                if (bitmap != null) {
                    if (this.f1653a.f1682n != null) {
                        this.f1653a.f1681m.offer(this.f1653a.f1682n);
                    }
                    this.f1653a.f1682n = bitmap;
                    this.f1653a.invalidate();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class C09862 extends AsyncTask<Object, Object, Object> {
        final /* synthetic */ LiveNumberView f1654a;

        C09862(LiveNumberView liveNumberView) {
            this.f1654a = liveNumberView;
        }

        protected Object doInBackground(Object... objArr) {
            loop0:
            while (!isCancelled()) {
                int i = 0;
                while (i < this.f1654a.f1679k.size()) {
                    if (!isCancelled()) {
                        String str = ((C0976b) this.f1654a.f1679k.get(i)).f1602a;
                        Options options = new Options();
                        options.inMutable = true;
                        options.inSampleSize = 1;
                        options.inPreferredConfig = Config.ARGB_8888;
                        Bitmap bitmap = (Bitmap) this.f1654a.f1681m.poll();
                        if (bitmap != null) {
                            options.inBitmap = bitmap;
                        }
                        bitmap = C0978c.m1849a().m1852a(str, options);
                        if (isCancelled()) {
                            break loop0;
                        }
                        try {
                            this.f1654a.f1680l.put(bitmap);
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
            this.f1654a.m1910c();
        }
    }

    class C09873 extends AsyncTask<Object, Object, Object> {
        final /* synthetic */ LiveNumberView f1655a;

        C09873(LiveNumberView liveNumberView) {
            this.f1655a = liveNumberView;
        }

        protected Object doInBackground(Object... objArr) {
            loop0:
            for (int i = 0; i < this.f1655a.f1669a.size() && !isCancelled(); i++) {
                ArrayList arrayList = (ArrayList) this.f1655a.f1669a.get(i);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (isCancelled()) {
                        break loop0;
                    }
                    C0978c.m1849a().m1851a(((C0976b) arrayList.get(i2)).f1602a);
                }
            }
            return null;
        }
    }

    class C0989a implements C0973a {
        int f1657a;
        int f1658b;
        Rect f1659c;
        Rect f1660d;
        Rect f1661e;
        Rect f1662f;
        int f1663g;
        int f1664h;
        C0975a f1665i = new C0975a();
        Bitmap f1666j;
        boolean f1667k;
        final /* synthetic */ LiveNumberView f1668l;

        public C0989a(LiveNumberView liveNumberView) {
            this.f1668l = liveNumberView;
            this.f1665i.m1840a(false);
            this.f1665i.m1838a((C0973a) this);
        }

        public void mo2470a() {
            if (!this.f1667k) {
                m1899b();
            }
        }

        public void mo2471a(int i, C0976b c0976b) {
            this.f1666j = C0978c.m1849a().m1851a(c0976b.f1602a);
            if (this.f1666j != null) {
                this.f1662f.right = this.f1666j.getWidth();
                this.f1662f.bottom = this.f1666j.getHeight();
                this.f1668l.invalidate();
            }
        }

        void m1899b() {
            this.f1666j = null;
            this.f1668l.f1688t.remove(this);
            this.f1668l.invalidate();
        }

        public boolean equals(Object obj) {
            try {
                C0989a c0989a = (C0989a) obj;
                return this.f1657a == c0989a.f1657a && this.f1658b == c0989a.f1658b;
            } catch (ClassCastException e) {
                e.printStackTrace();
                return super.equals(obj);
            }
        }
    }

    public LiveNumberView(Context context) {
        super(context);
        m1903a(context);
    }

    public LiveNumberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1903a(context);
    }

    public LiveNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1903a(context);
    }

    @TargetApi(21)
    public LiveNumberView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m1903a(context);
    }

    private C0989a m1901a(int i, int i2) {
        Iterator it = this.f1687s.iterator();
        while (it.hasNext()) {
            C0989a c0989a = (C0989a) it.next();
            if (c0989a.f1661e.contains(i, i2)) {
                return c0989a;
            }
        }
        return null;
    }

    private void m1903a(Context context) {
        this.f1670b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f1683o = new C0975a();
        this.f1683o.m1838a(new C09851(this));
        TypedArray obtainStyledAttributes = getResources().newTheme().obtainStyledAttributes(R.style.style_numslayout_portrait, C1139g.CustomeUnlockSkinView);
        this.f1675g = obtainStyledAttributes.getDimensionPixelSize(12, 0);
        obtainStyledAttributes.recycle();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.PaddingSizeSmallest);
        this.f1672d = getResources().getDimensionPixelSize(R.dimen.minimum_num_button_height);
        this.f1674f = (dimensionPixelSize * 2) + this.f1672d;
        this.f1673e = this.f1675g / 3;
        this.f1676h = this.f1674f * 4;
        this.f1686r = (Vibrator) context.getSystemService("vibrator");
    }

    private void m1904a(@NonNull Bitmap bitmap) {
        if (this.f1687s.size() <= 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                arrayList.add(Integer.valueOf(i));
            }
            if (this.f1684p) {
                Collections.shuffle(arrayList);
            }
            for (int i2 = 0; i2 < 12; i2++) {
                C0989a c0989a = new C0989a(this);
                c0989a.f1664h = i2;
                c0989a.f1657a = i2 / 3;
                c0989a.f1658b = i2 % 3;
                if (i2 == 9) {
                    c0989a.f1663g = 10;
                } else if (i2 == 11) {
                    c0989a.f1663g = 11;
                } else if (i2 == 10) {
                    if (this.f1684p) {
                        c0989a.f1663g = ((Integer) arrayList.get(9)).intValue();
                    } else {
                        c0989a.f1663g = ((Integer) arrayList.get(0)).intValue();
                    }
                } else if (this.f1684p) {
                    c0989a.f1663g = ((Integer) arrayList.get(i2)).intValue();
                } else {
                    c0989a.f1663g = ((Integer) arrayList.get(i2 + 1)).intValue();
                }
                m1906a(c0989a, bitmap);
                this.f1687s.add(c0989a);
            }
        }
    }

    private void m1905a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        this.f1689u.set(x, y);
        this.f1692x = m1901a(x, y);
        if (this.f1692x != null) {
            this.f1692x.f1667k = true;
            if (this.f1688t.contains(this.f1692x)) {
                this.f1688t.remove(this.f1692x);
            }
            this.f1688t.add(this.f1692x);
            if (this.f1692x.f1663g == 11) {
                this.f1693y.sendEmptyMessageDelayed(1, (long) ViewConfiguration.getLongPressTimeout());
            }
            this.f1692x.f1665i.m1843c();
        }
    }

    private void m1906a(@NonNull C0989a c0989a, @NonNull Bitmap bitmap) {
        int i = c0989a.f1663g / 3;
        int i2 = c0989a.f1663g % 3;
        int width = bitmap.getWidth() / 3;
        int height = bitmap.getHeight() / 4;
        int i3 = (int) ((((float) width) / ((float) height)) * ((float) this.f1672d));
        int i4 = this.f1672d;
        c0989a.f1659c = new Rect();
        c0989a.f1659c.left = i2 * width;
        c0989a.f1659c.top = i * height;
        c0989a.f1659c.right = c0989a.f1659c.left + width;
        c0989a.f1659c.bottom = c0989a.f1659c.top + height;
        i = c0989a.f1664h / 3;
        i2 = c0989a.f1664h % 3;
        c0989a.f1661e = new Rect();
        c0989a.f1661e.left = i2 * this.f1673e;
        c0989a.f1661e.top = i * this.f1674f;
        c0989a.f1661e.right = c0989a.f1661e.left + this.f1673e;
        c0989a.f1661e.bottom = c0989a.f1661e.top + this.f1674f;
        c0989a.f1660d = new Rect();
        c0989a.f1660d.left = c0989a.f1661e.centerX() - (i3 / 2);
        c0989a.f1660d.top = c0989a.f1661e.centerY() - (i4 / 2);
        c0989a.f1660d.right = c0989a.f1661e.centerX() + (i3 / 2);
        c0989a.f1660d.bottom = c0989a.f1661e.centerY() + (i4 / 2);
        c0989a.f1662f = new Rect();
        c0989a.f1662f.left = 0;
        c0989a.f1662f.top = 0;
        c0989a.f1665i.m1839a((ArrayList) this.f1669a.get(c0989a.f1663g));
    }

    private void m1908b(MotionEvent motionEvent) {
        if (this.f1692x != null) {
            if (!this.f1692x.f1661e.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.f1693y.removeMessages(1);
                this.f1692x.f1667k = false;
                this.f1692x.f1665i.m1845e();
                this.f1692x.m1899b();
                this.f1692x = null;
            }
        }
    }

    private void m1910c() {
        ArrayList arrayList = new ArrayList();
        this.f1681m.drainTo(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Bitmap) it.next()).recycle();
        }
        arrayList.clear();
        this.f1680l.drainTo(arrayList);
        it = arrayList.iterator();
        while (it.hasNext()) {
            ((Bitmap) it.next()).recycle();
        }
        arrayList.clear();
        if (this.f1682n != null) {
            this.f1682n.recycle();
            this.f1682n = null;
        }
    }

    private void m1911c(MotionEvent motionEvent) {
        this.f1693y.removeMessages(1);
        if (this.f1692x != null) {
            this.f1692x.f1667k = false;
            if (!this.f1692x.f1665i.m1846f()) {
                this.f1692x.m1899b();
            }
            long eventTime = motionEvent.getEventTime() - motionEvent.getDownTime();
            if ((this.f1692x.f1663g != 11 || eventTime <= ((long) ViewConfiguration.getLongPressTimeout())) && this.f1691w != null) {
                playSoundEffect(0);
                if (this.f1692x.f1663g == 10) {
                    this.f1691w.mo2456e();
                } else if (this.f1692x.f1663g == 11) {
                    this.f1691w.mo2457f();
                } else {
                    if (this.f1685q) {
                        this.f1686r.vibrate(LockPatternView.f2779a, -1);
                    }
                    this.f1691w.mo2454a(this.f1692x.f1663g);
                }
            }
        }
    }

    private void m1913d() {
        this.f1677i = new C09862(this);
        C1148d.m2521b(this.f1677i, new Object[0]);
    }

    private void m1914e() {
        this.f1682n = C0978c.m1849a().m1855b(((C0976b) this.f1679k.get(0)).f1602a);
        invalidate();
    }

    private void m1917f() {
        this.f1678j = new C09873(this);
        C1148d.m2521b(this.f1678j, new Object[0]);
    }

    public void m1919a() {
        m1917f();
        m1914e();
        if (this.f1679k.size() > 1) {
            m1913d();
            this.f1683o.m1843c();
        }
    }

    public void m1920b() {
        if (this.f1677i != null) {
            this.f1677i.cancel(true);
            this.f1677i = null;
        }
        if (this.f1678j != null) {
            this.f1678j.cancel(true);
            this.f1678j = null;
        }
        if (this.f1683o != null) {
            this.f1683o.m1844d();
        }
        m1910c();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1920b();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            Iterator it;
            C0989a c0989a;
            if (!(this.f1682n == null || this.f1682n.isRecycled())) {
                m1904a(this.f1682n);
                it = this.f1687s.iterator();
                while (it.hasNext()) {
                    c0989a = (C0989a) it.next();
                    if (!this.f1688t.contains(c0989a)) {
                        canvas.drawBitmap(this.f1682n, c0989a.f1659c, c0989a.f1660d, this.f1671c);
                    }
                }
            }
            it = this.f1688t.iterator();
            while (it.hasNext()) {
                c0989a = (C0989a) it.next();
                if (!(c0989a.f1666j == null || c0989a.f1666j.isRecycled())) {
                    canvas.drawBitmap(c0989a.f1666j, c0989a.f1662f, c0989a.f1660d, this.f1671c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f1675g, this.f1676h);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                m1905a(motionEvent);
                break;
            case 1:
            case 3:
                m1911c(motionEvent);
                break;
            case 2:
                m1908b(motionEvent);
                break;
        }
        return true;
    }

    public void setDownFrameList(ArrayList<ArrayList<C0976b>> arrayList) {
        this.f1669a = arrayList;
    }

    public void setNormFrameList(ArrayList<C0976b> arrayList) {
        this.f1679k = arrayList;
        this.f1683o.m1839a((ArrayList) arrayList);
    }

    public void setOnNumberBoardClickListener(C0961b c0961b) {
        this.f1691w = c0961b;
    }

    public void setRandomNumBoard(boolean z) {
        this.f1684p = z;
        this.f1687s.clear();
        invalidate();
    }

    public void setTactileFeedbackEnabled(boolean z) {
        this.f1685q = z;
    }
}
