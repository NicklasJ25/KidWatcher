package com.domobile.applock.livelock.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import com.domobile.applock.C1150y;
import com.domobile.applock.livelock.p014b.C0975a;
import com.domobile.applock.livelock.p014b.C0975a.C0973a;
import com.domobile.applock.livelock.p014b.C0976b;
import com.domobile.applock.livelock.p014b.C0978c;
import com.domobile.frame.p000a.C1148d;
import com.domobile.imagelock.C1318c;
import com.domobile.imagelock.LockPatternView.C0950c;
import com.domobile.imagelock.LockPatternView.C1308a;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
public class LivePatternView extends View {
    public static final long[] f1707a = new long[]{0, 1, 26, 30};
    private C0975a f1708A;
    private C0975a f1709B;
    private C0975a f1710C;
    private Bitmap f1711D;
    private Bitmap f1712E;
    private Bitmap f1713F;
    private AsyncTask f1714G;
    public HashMap<String, ArrayList<C0976b>> f1715b;
    public Runnable f1716c = new C09945(this);
    private Vibrator f1717d;
    private int f1718e;
    private int f1719f = 0;
    private float f1720g;
    private float f1721h;
    private C0950c f1722i;
    private ArrayList<C1308a> f1723j = new ArrayList(9);
    private boolean[][] f1724k = ((boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{3, 3}));
    private final Matrix f1725l = new Matrix();
    private int f1726m = 0;
    private boolean f1727n = true;
    private boolean f1728o = false;
    private boolean f1729p = true;
    private boolean f1730q = false;
    private View f1731r;
    private View f1732s;
    private C1308a f1733t;
    private PointF f1734u = new PointF();
    private PointF f1735v = new PointF();
    private PointF f1736w = new PointF();
    private int f1737x;
    private Paint f1738y = new Paint(7);
    private HashMap<String, C0996a> f1739z = new HashMap();

    class C09901 implements C0973a {
        final /* synthetic */ LivePatternView f1694a;

        C09901(LivePatternView livePatternView) {
            this.f1694a = livePatternView;
        }

        public void mo2470a() {
        }

        public void mo2471a(int i, C0976b c0976b) {
            this.f1694a.f1711D = C0978c.m1849a().m1851a(c0976b.f1602a);
            this.f1694a.invalidate();
            if (this.f1694a.f1708A.m1841b() == 1) {
                this.f1694a.f1708A.m1844d();
            }
        }
    }

    class C09912 implements C0973a {
        final /* synthetic */ LivePatternView f1695a;

        C09912(LivePatternView livePatternView) {
            this.f1695a = livePatternView;
        }

        public void mo2470a() {
        }

        public void mo2471a(int i, C0976b c0976b) {
            this.f1695a.f1712E = C0978c.m1849a().m1851a(c0976b.f1602a);
            this.f1695a.invalidate();
        }
    }

    class C09923 implements C0973a {
        final /* synthetic */ LivePatternView f1696a;

        C09923(LivePatternView livePatternView) {
            this.f1696a = livePatternView;
        }

        public void mo2470a() {
        }

        public void mo2471a(int i, C0976b c0976b) {
            this.f1696a.f1713F = C0978c.m1849a().m1851a(c0976b.f1602a);
            this.f1696a.invalidate();
        }
    }

    class C09934 extends AsyncTask<Object, Object, Object> {
        final /* synthetic */ LivePatternView f1697a;

        C09934(LivePatternView livePatternView) {
            this.f1697a = livePatternView;
        }

        protected Object doInBackground(Object... objArr) {
            Iterator it = ((ArrayList) this.f1697a.f1715b.get("NORM")).iterator();
            while (it.hasNext()) {
                C0976b c0976b = (C0976b) it.next();
                if (isCancelled()) {
                    break;
                }
                C0978c.m1849a().m1851a(c0976b.f1602a);
            }
            it = ((ArrayList) this.f1697a.f1715b.get("DOWN")).iterator();
            while (it.hasNext()) {
                c0976b = (C0976b) it.next();
                if (isCancelled()) {
                    break;
                }
                C0978c.m1849a().m1851a(c0976b.f1602a);
            }
            it = ((ArrayList) this.f1697a.f1715b.get("ERROR")).iterator();
            while (it.hasNext()) {
                c0976b = (C0976b) it.next();
                if (isCancelled()) {
                    break;
                }
                C0978c.m1849a().m1851a(c0976b.f1602a);
            }
            return null;
        }
    }

    class C09945 implements Runnable {
        final /* synthetic */ LivePatternView f1698a;

        C09945(LivePatternView livePatternView) {
            this.f1698a = livePatternView;
        }

        public void run() {
            this.f1698a.m1971c();
        }
    }

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C09951();
        private final String f1699a;
        private final int f1700b;
        private final boolean f1701c;
        private final boolean f1702d;
        private final boolean f1703e;
        private final String f1704f;

        static class C09951 implements Creator<SavedState> {
            C09951() {
            }

            public SavedState m1927a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m1928a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1927a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1928a(i);
            }
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f1699a = parcel.readString();
            this.f1700b = parcel.readInt();
            this.f1701c = ((Boolean) parcel.readValue(null)).booleanValue();
            this.f1702d = ((Boolean) parcel.readValue(null)).booleanValue();
            this.f1703e = ((Boolean) parcel.readValue(null)).booleanValue();
            this.f1704f = parcel.readString();
        }

        private SavedState(Parcelable parcelable, String str, int i, boolean z, boolean z2, boolean z3, String str2) {
            super(parcelable);
            this.f1699a = str;
            this.f1700b = i;
            this.f1701c = z;
            this.f1702d = z2;
            this.f1703e = z3;
            this.f1704f = str2;
        }

        public String m1930a() {
            return this.f1699a;
        }

        public int m1931b() {
            return this.f1700b;
        }

        public boolean m1932c() {
            return this.f1701c;
        }

        public boolean m1933d() {
            return this.f1702d;
        }

        public boolean m1934e() {
            return this.f1703e;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f1699a);
            parcel.writeInt(this.f1700b);
            parcel.writeValue(Boolean.valueOf(this.f1701c));
            parcel.writeValue(Boolean.valueOf(this.f1702d));
            parcel.writeValue(Boolean.valueOf(this.f1703e));
            parcel.writeString(this.f1704f);
        }
    }

    public static class C0996a {
        float f1705a;
        float f1706b;
    }

    public LivePatternView(Context context) {
        super(context);
        m1943a(context);
    }

    public LivePatternView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1943a(context);
    }

    public LivePatternView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1943a(context);
    }

    private float m1935a(int i) {
        return (((float) getPaddingLeft()) + (((float) i) * this.f1720g)) + (this.f1720g / 2.0f);
    }

    private float m1936a(PointF pointF, PointF pointF2) {
        float f = pointF2.x - pointF.x;
        float f2 = pointF2.y - pointF.y;
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }

    private int m1937a(float f) {
        float f2 = this.f1721h;
        float f3 = f2 * 0.6f;
        float paddingTop = ((f2 - f3) / 2.0f) + ((float) getPaddingTop());
        for (int i = 0; i < 3; i++) {
            float f4 = (((float) i) * f2) + paddingTop;
            if (f >= f4 && f <= f4 + f3) {
                return i;
            }
        }
        return -1;
    }

    private int m1938a(int i, int i2) {
        return Math.min(i2, MeasureSpec.getSize(i));
    }

    @NonNull
    private C0996a m1941a(C1308a c1308a) {
        String str = c1308a.f2773a + "" + c1308a.f2774b;
        C0996a c0996a = (C0996a) this.f1739z.get(str);
        if (c0996a != null) {
            return c0996a;
        }
        c0996a = new C0996a();
        c0996a.f1706b = 0.0f;
        c0996a.f1705a = 0.0f;
        this.f1739z.put(str, c0996a);
        return c0996a;
    }

    @Nullable
    private C1308a m1942a(float f, float f2) {
        C1308a c1308a = null;
        int i = 1;
        C1308a b = m1950b(f, f2);
        C1308a c1308a2;
        int i2;
        if (b != null) {
            ArrayList arrayList = this.f1723j;
            if (!arrayList.isEmpty()) {
                c1308a2 = (C1308a) arrayList.get(arrayList.size() - 1);
                int i3 = b.f2773a - c1308a2.f2773a;
                int i4 = b.f2774b - c1308a2.f2774b;
                int i5 = c1308a2.f2773a;
                int i6 = c1308a2.f2774b;
                if (Math.abs(i3) == 2 && Math.abs(i4) != 1) {
                    i5 = (i3 > 0 ? 1 : -1) + c1308a2.f2773a;
                }
                if (Math.abs(i4) != 2 || Math.abs(i3) == 1) {
                    i2 = i6;
                } else {
                    i2 = c1308a2.f2774b;
                    if (i4 <= 0) {
                        i = -1;
                    }
                    i2 += i;
                }
                c1308a = C1308a.m3181a(i5, i2);
            }
            if (!(c1308a == null || this.f1724k[c1308a.f2773a][c1308a.f2774b])) {
                m1953b(c1308a);
            }
            m1953b(b);
            if (this.f1729p) {
                this.f1717d.vibrate(f1707a, -1);
            }
            return b;
        }
        i2 = this.f1723j.size();
        if (i2 > 0) {
            c1308a2 = (C1308a) this.f1723j.get(i2 - 1);
            this.f1736w.set(f, f2);
            C0996a a = m1941a(c1308a2);
            a.f1705a = m1964m();
            a.f1706b = m1936a(this.f1734u, this.f1736w);
        }
        return null;
    }

    private void m1943a(Context context) {
        this.f1718e = m1966a(context, 72.0f);
        this.f1717d = (Vibrator) context.getSystemService("vibrator");
        this.f1737x = m1966a(context, 10.0f);
        this.f1708A = new C0975a();
        this.f1708A.m1838a(new C09901(this));
        this.f1709B = new C0975a();
        this.f1709B.m1838a(new C09912(this));
        this.f1710C = new C0975a();
        this.f1710C.m1838a(new C09923(this));
    }

    private void m1944a(Canvas canvas) {
        if (this.f1715b != null) {
            float f = this.f1720g;
            float f2 = this.f1721h;
            int paddingTop = getPaddingTop();
            int paddingLeft = getPaddingLeft();
            for (int i = 0; i < 3; i++) {
                float f3 = ((float) paddingTop) + (((float) i) * f2);
                for (int i2 = 0; i2 < 3; i2++) {
                    float f4 = (((float) i2) * f) + ((float) paddingLeft);
                    Bitmap bitmap = this.f1724k[i][i2] ? this.f1726m == 1 ? this.f1713F : this.f1728o ? this.f1711D : this.f1712E : this.f1711D;
                    if (!(bitmap == null || bitmap.isRecycled())) {
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        float f5 = (float) this.f1718e;
                        float f6 = ((f - f5) - (((float) width) - f5)) / 2.0f;
                        float f7 = ((f2 - f5) - (((float) width) - f5)) / 2.0f;
                        float min = Math.min(f5 / ((float) width), 1.0f);
                        f5 = Math.min(f5 / ((float) height), 1.0f);
                        this.f1725l.setTranslate(f4 + f6, f3 + f7);
                        this.f1725l.preTranslate((float) (width / 2), (float) (height / 2));
                        this.f1725l.preScale(min, f5);
                        this.f1725l.preTranslate((float) ((-width) / 2), (float) ((-height) / 2));
                        canvas.drawBitmap(bitmap, this.f1725l, this.f1738y);
                    }
                }
            }
        }
    }

    private void m1945a(MotionEvent motionEvent) {
        m1962k();
        C1308a a = m1942a(motionEvent.getX(), motionEvent.getY());
        if (a != null) {
            this.f1733t = a;
            this.f1730q = true;
            this.f1726m = 0;
            m1959h();
        } else if (this.f1730q) {
            this.f1730q = false;
            m1961j();
        }
        if (a != null) {
            float a2 = m1935a(a.f2774b);
            float b = m1947b(a.f2773a);
            float f = this.f1720g / 2.0f;
            float f2 = this.f1721h / 2.0f;
            invalidate((int) (a2 - f), (int) (b - f2), (int) (a2 + f), (int) (b + f2));
        }
    }

    private void m1946a(String str) {
        this.f1739z.clear();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                C0996a c0996a = new C0996a();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("key");
                c0996a.f1705a = (float) jSONObject.getDouble("degree");
                c0996a.f1706b = (float) jSONObject.getDouble("length");
                this.f1739z.put(string, c0996a);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private float m1947b(int i) {
        return (((float) getPaddingTop()) + (((float) i) * this.f1721h)) + (this.f1721h / 2.0f);
    }

    private int m1948b(float f) {
        float f2 = this.f1720g;
        float f3 = f2 * 0.6f;
        float paddingLeft = ((f2 - f3) / 2.0f) + ((float) getPaddingLeft());
        for (int i = 0; i < 3; i++) {
            float f4 = (((float) i) * f2) + paddingLeft;
            if (f >= f4 && f <= f4 + f3) {
                return i;
            }
        }
        return -1;
    }

    @Nullable
    private C1308a m1950b(float f, float f2) {
        int a = m1937a(f2);
        if (a < 0) {
            return null;
        }
        int b = m1948b(f);
        return (b < 0 || this.f1724k[a][b]) ? null : C1308a.m3181a(a, b);
    }

    private void m1951b(Canvas canvas) {
        int size;
        int i;
        C1308a c1308a;
        C0996a a;
        float a2;
        float b;
        if (this.f1726m == 1) {
            size = this.f1723j.size();
            for (i = 0; i < size; i++) {
                if (i != size - 1) {
                    c1308a = (C1308a) this.f1723j.get(i);
                    a = m1941a(c1308a);
                    canvas.save();
                    this.f1732s.layout(0, 0, (int) a.f1706b, this.f1737x);
                    a2 = m1935a(c1308a.f2774b);
                    b = m1947b(c1308a.f2773a) - ((float) (this.f1737x / 2));
                    canvas.rotate(a.f1705a, a2, ((float) (this.f1737x / 2)) + b);
                    canvas.translate(a2, b);
                    this.f1732s.draw(canvas);
                    canvas.restore();
                }
            }
        } else if (!this.f1728o && this.f1726m == 0) {
            size = this.f1723j.size();
            for (i = 0; i < this.f1723j.size(); i++) {
                c1308a = (C1308a) this.f1723j.get(i);
                if (i != size - 1 || this.f1730q) {
                    a = m1941a(c1308a);
                    canvas.save();
                    this.f1731r.layout(0, 0, (int) a.f1706b, this.f1737x);
                    a2 = m1935a(c1308a.f2774b);
                    b = m1947b(c1308a.f2773a) - ((float) (this.f1737x / 2));
                    canvas.rotate(a.f1705a, a2, ((float) (this.f1737x / 2)) + b);
                    canvas.translate(a2, b);
                    this.f1731r.draw(canvas);
                    canvas.restore();
                }
            }
        }
    }

    private void m1952b(MotionEvent motionEvent) {
        C1308a c = m1955c(motionEvent.getX(), motionEvent.getY());
        if (motionEvent.getEventTime() - motionEvent.getDownTime() > 600 && this.f1733t != null && this.f1733t.equals(c)) {
            setInStealthMode(false);
            this.f1717d.vibrate(f1707a, -1);
            this.f1733t = null;
            invalidate();
        } else if (!(this.f1733t == null || this.f1733t.equals(c))) {
            this.f1733t = null;
        }
        int historySize = motionEvent.getHistorySize();
        int i = 0;
        while (i < historySize + 1) {
            C1308a a = m1942a(i < historySize ? motionEvent.getHistoricalX(i) : motionEvent.getX(), i < historySize ? motionEvent.getHistoricalY(i) : motionEvent.getY());
            invalidate();
            int size = this.f1723j.size();
            if (a != null && size == 1) {
                this.f1730q = true;
                m1959h();
            }
            i++;
        }
    }

    private void m1953b(C1308a c1308a) {
        int size = this.f1723j.size();
        float a = m1935a(c1308a.f2774b);
        float b = m1947b(c1308a.f2773a);
        if (size > 0) {
            C1308a c1308a2 = (C1308a) this.f1723j.get(size - 1);
            this.f1736w.set(a, b);
            C0996a a2 = m1941a(c1308a2);
            a2.f1705a = m1964m();
            a2.f1706b = m1936a(this.f1734u, this.f1736w);
        }
        this.f1734u.set(a, b);
        this.f1735v.set(a + 100.0f, b);
        m1941a(c1308a);
        this.f1724k[c1308a.m3183a()][c1308a.m3184b()] = true;
        this.f1723j.add(c1308a);
        m1958g();
    }

    @Nullable
    private C1308a m1955c(float f, float f2) {
        int a = m1937a(f2);
        if (a < 0) {
            return null;
        }
        int b = m1948b(f);
        return b >= 0 ? C1308a.m3181a(a, b) : null;
    }

    private void m1956c(MotionEvent motionEvent) {
        this.f1733t = null;
        if (!this.f1723j.isEmpty()) {
            this.f1730q = false;
            m1960i();
            invalidate();
        }
    }

    private void m1957f() {
        this.f1714G = new C09934(this);
        C1148d.m2521b(this.f1714G, new Object[0]);
    }

    private void m1958g() {
        if (this.f1722i != null) {
            this.f1722i.mo2453b(this.f1723j);
        }
    }

    private void m1959h() {
        if (this.f1722i != null) {
            this.f1722i.mo2450a();
        }
        m1973e();
    }

    private void m1960i() {
        if (this.f1722i != null) {
            this.f1722i.mo2451a(this.f1723j);
        }
    }

    private void m1961j() {
        if (this.f1722i != null) {
            this.f1722i.mo2452b();
        }
        m1973e();
    }

    private void m1962k() {
        boolean z = true;
        this.f1739z.clear();
        this.f1723j.clear();
        m1963l();
        this.f1726m = 0;
        if (C1150y.m2592a(getContext(), "enable_visible_pattern", true)) {
            z = false;
        }
        this.f1728o = z;
        invalidate();
    }

    private void m1963l() {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.f1724k[i][i2] = false;
            }
        }
    }

    private float m1964m() {
        double d = 1.0d;
        double a = (double) m1936a(this.f1734u, this.f1735v);
        double a2 = (double) m1936a(this.f1735v, this.f1736w);
        double a3 = (double) m1936a(this.f1734u, this.f1736w);
        a = (((a * a) + (a3 * a3)) - (a2 * a2)) / ((a * 2.0d) * a3);
        if (a < 1.0d) {
            d = a;
        }
        float toDegrees = (float) Math.toDegrees(Math.acos(d));
        PointF pointF = new PointF(this.f1735v.x - this.f1734u.x, this.f1735v.y - this.f1734u.y);
        PointF pointF2 = new PointF(this.f1736w.x - this.f1734u.x, this.f1736w.y - this.f1734u.y);
        return (pointF.x * pointF2.y) - (pointF.y * pointF2.x) < 0.0f ? -toDegrees : toDegrees;
    }

    private String m1965n() {
        JSONArray jSONArray = new JSONArray();
        try {
            for (String str : this.f1739z.keySet()) {
                C0996a c0996a = (C0996a) this.f1739z.get(str);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", str);
                jSONObject.put("degree", (double) c0996a.f1705a);
                jSONObject.put("length", (double) c0996a.f1706b);
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONArray.toString();
    }

    public int m1966a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public void m1967a() {
        m1957f();
        this.f1708A.m1843c();
        this.f1709B.m1843c();
    }

    public void m1968a(int i, List<C1308a> list) {
        this.f1723j.clear();
        this.f1723j.addAll(list);
        m1963l();
        for (C1308a c1308a : list) {
            this.f1724k[c1308a.m3183a()][c1308a.m3184b()] = true;
        }
        setDisplayMode(i);
    }

    public void m1969a(long j) {
        removeCallbacks(this.f1716c);
        postDelayed(this.f1716c, j);
    }

    public void m1970b() {
        if (this.f1714G != null) {
            this.f1714G.cancel(true);
            this.f1714G = null;
        }
        this.f1708A.m1844d();
        this.f1709B.m1844d();
        this.f1710C.m1844d();
    }

    public void m1971c() {
        try {
            this.f1710C.m1844d();
            m1962k();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void m1972d() {
        m1969a(2000);
    }

    public void m1973e() {
        removeCallbacks(this.f1716c);
    }

    protected int getSuggestedMinimumHeight() {
        return m1966a(getContext(), 76.0f) * 4;
    }

    protected int getSuggestedMinimumWidth() {
        return m1966a(getContext(), 76.0f) * 4;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            m1951b(canvas);
            m1944a(canvas);
        } catch (Exception e) {
        }
    }

    protected void onMeasure(int i, int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int a = m1938a(i, suggestedMinimumWidth);
        suggestedMinimumWidth = m1938a(i2, suggestedMinimumHeight);
        switch (this.f1719f) {
            case 0:
                suggestedMinimumWidth = Math.min(a, suggestedMinimumWidth);
                a = suggestedMinimumWidth;
                break;
            case 1:
                suggestedMinimumWidth = Math.min(a, suggestedMinimumWidth);
                break;
            case 2:
                a = Math.min(a, suggestedMinimumWidth);
                break;
        }
        setMeasuredDimension(a, suggestedMinimumWidth);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        m1946a(savedState.f1704f);
        m1968a(0, C1318c.m3242a(savedState.m1930a()));
        this.f1726m = savedState.m1931b();
        this.f1727n = savedState.m1932c();
        this.f1728o = savedState.m1933d();
        this.f1729p = savedState.m1934e();
    }

    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), C1318c.m3244c(this.f1723j), this.f1726m, this.f1727n, this.f1728o, this.f1729p, m1965n());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f1720g = ((float) ((i - getPaddingLeft()) - getPaddingRight())) / 3.0f;
        this.f1721h = ((float) ((i2 - getPaddingLeft()) - getPaddingRight())) / 3.0f;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f1727n || !isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                m1945a(motionEvent);
                break;
            case 1:
                m1956c(motionEvent);
                break;
            case 2:
                m1952b(motionEvent);
                break;
            case 3:
                this.f1733t = null;
                if (this.f1730q) {
                    this.f1730q = false;
                    m1962k();
                    m1961j();
                    break;
                }
                break;
        }
        return true;
    }

    public void setDisplayMode(int i) {
        this.f1726m = i;
        if (this.f1726m == 1) {
            this.f1710C.m1843c();
        }
        invalidate();
    }

    public void setFrameList(@NonNull HashMap<String, ArrayList<C0976b>> hashMap) {
        this.f1715b = hashMap;
        this.f1708A.m1839a((ArrayList) hashMap.get("NORM"));
        this.f1709B.m1839a((ArrayList) hashMap.get("DOWN"));
        this.f1710C.m1839a((ArrayList) hashMap.get("ERROR"));
    }

    public void setInStealthMode(boolean z) {
        this.f1728o = z;
    }

    public void setLineList(@NonNull HashMap<String, String> hashMap) {
        this.f1731r = new View(getContext());
        this.f1732s = new View(getContext());
        String str = (String) hashMap.get("ERROR");
        Drawable c = C0978c.m1849a().m1857c((String) hashMap.get("NORM"));
        Drawable c2 = C0978c.m1849a().m1857c(str);
        if (VERSION.SDK_INT >= 16) {
            this.f1731r.setBackground(c);
            this.f1732s.setBackground(c2);
            return;
        }
        this.f1731r.setBackgroundDrawable(c);
        this.f1732s.setBackgroundDrawable(c2);
    }

    public void setLineSize(int i) {
        if (i != 0) {
            this.f1737x = m1966a(getContext(), (float) i);
        }
    }

    public void setOnPatternListener(C0950c c0950c) {
        this.f1722i = c0950c;
    }

    public void setTactileFeedbackEnabled(boolean z) {
        this.f1729p = z;
    }
}
