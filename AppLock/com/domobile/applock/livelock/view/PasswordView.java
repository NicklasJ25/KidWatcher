package com.domobile.applock.livelock.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
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

@TargetApi(14)
public class PasswordView extends View {
    private Paint f1746a = new Paint(7);
    private Rect f1747b = new Rect();
    private Rect f1748c = new Rect();
    private ArrayList<C0976b> f1749d;
    private int f1750e;
    private int f1751f;
    private ArrayList<C0998a> f1752g = new ArrayList();
    private AsyncTask f1753h;
    private Rect f1754i;

    class C09971 extends AsyncTask<Object, Object, Object> {
        final /* synthetic */ PasswordView f1740a;

        C09971(PasswordView passwordView) {
            this.f1740a = passwordView;
        }

        protected Object doInBackground(Object... objArr) {
            for (int i = 0; i < this.f1740a.f1749d.size(); i++) {
                String str = ((C0976b) this.f1740a.f1749d.get(i)).f1602a;
                if (isCancelled()) {
                    break;
                }
                Bitmap a = C0978c.m1849a().m1851a(str);
                if (this.f1740a.f1750e == 0 && a != null) {
                    this.f1740a.f1750e = a.getWidth();
                    this.f1740a.f1751f = a.getHeight();
                    publishProgress(new Object[0]);
                }
            }
            return null;
        }

        protected void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
            this.f1740a.requestLayout();
        }
    }

    class C0998a implements C0973a {
        int f1741a;
        Bitmap f1742b;
        C0975a f1743c;
        boolean f1744d = false;
        final /* synthetic */ PasswordView f1745e;

        public C0998a(PasswordView passwordView, int i) {
            this.f1745e = passwordView;
            this.f1741a = i;
            this.f1743c = new C0975a();
            this.f1743c.m1840a(false);
            this.f1743c.m1838a((C0973a) this);
            this.f1743c.m1839a(passwordView.f1749d);
        }

        public void mo2470a() {
            if (this.f1744d) {
                this.f1745e.f1752g.remove(this);
                this.f1745e.invalidate();
            }
        }

        public void mo2471a(int i, C0976b c0976b) {
            this.f1742b = C0978c.m1849a().m1851a(c0976b.f1602a);
            if (this.f1742b != null) {
                this.f1745e.invalidate();
            }
        }

        public void m1976b() {
            this.f1743c.m1842b(false);
            this.f1743c.m1843c();
        }

        public void m1977c() {
            this.f1744d = true;
            this.f1743c.m1842b(true);
            this.f1743c.m1843c();
        }
    }

    public PasswordView(Context context) {
        super(context);
        m1980a(context);
    }

    public PasswordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1980a(context);
    }

    public PasswordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1980a(context);
    }

    @TargetApi(21)
    public PasswordView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m1980a(context);
    }

    private void m1980a(Context context) {
        this.f1747b.left = 0;
        this.f1747b.top = 0;
        this.f1754i = C0978c.m1849a().m1859d();
    }

    private void m1984e() {
        this.f1753h = new C09971(this);
        C1148d.m2521b(this.f1753h, new Object[0]);
    }

    public void m1985a() {
        m1984e();
    }

    public void m1986a(int i) {
        try {
            int size = this.f1752g.size();
            if (size < 16) {
                C0998a c0998a;
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    c0998a = (C0998a) this.f1752g.get(i2);
                    if (!c0998a.f1744d) {
                        break;
                    }
                    c0998a.f1743c.m1844d();
                }
                c0998a = new C0998a(this, i);
                this.f1752g.add(c0998a);
                c0998a.m1976b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m1987b() {
        try {
            int size = this.f1752g.size();
            if (size > 0) {
                C0998a c0998a;
                for (int i = size - 1; i >= 0; i--) {
                    c0998a = (C0998a) this.f1752g.get(i);
                    if (!c0998a.f1744d) {
                        break;
                    }
                }
                c0998a = null;
                if (c0998a != null) {
                    c0998a.m1977c();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m1988c() {
        Iterator it = this.f1752g.iterator();
        while (it.hasNext()) {
            ((C0998a) it.next()).m1977c();
        }
    }

    public void m1989d() {
        this.f1752g.clear();
        if (this.f1753h != null) {
            this.f1753h.cancel(true);
            this.f1753h = null;
        }
    }

    @NonNull
    public String getPassword() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.f1752g.size(); i++) {
            C0998a c0998a = (C0998a) this.f1752g.get(i);
            if (!c0998a.f1744d) {
                stringBuilder.append(c0998a.f1741a);
            }
        }
        return stringBuilder.toString();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1989d();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int size = this.f1752g.size() * this.f1750e;
        int i = size <= width ? (width / 2) - (size / 2) : width - size;
        for (size = 0; size < this.f1752g.size(); size++) {
            C0998a c0998a = (C0998a) this.f1752g.get(size);
            if (!(c0998a.f1742b == null || c0998a.f1742b.isRecycled())) {
                int i2 = (this.f1750e * size) + i;
                int i3 = this.f1750e + i2;
                if (i3 > 0) {
                    this.f1747b.right = c0998a.f1742b.getWidth();
                    this.f1747b.bottom = c0998a.f1742b.getHeight();
                    this.f1748c.left = i2;
                    this.f1748c.top = 0;
                    this.f1748c.right = i3;
                    this.f1748c.bottom = this.f1751f;
                    canvas.drawBitmap(c0998a.f1742b, this.f1747b, this.f1748c, this.f1746a);
                }
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        if (this.f1750e != 0) {
            setMeasuredDimension((((size - this.f1754i.left) - this.f1754i.right) / this.f1750e) * this.f1750e, this.f1751f);
        }
    }

    public void setFrameList(ArrayList<C0976b> arrayList) {
        this.f1749d = arrayList;
    }
}
