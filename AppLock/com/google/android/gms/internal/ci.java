package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.bn.C2705a;
import com.google.android.gms.internal.bp.C2711a;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class ci implements ch {
    protected MotionEvent f8196a;
    protected LinkedList<MotionEvent> f8197b = new LinkedList();
    protected long f8198c = 0;
    protected long f8199d = 0;
    protected long f8200e = 0;
    protected long f8201f = 0;
    protected long f8202g = 0;
    protected long f8203h = 0;
    protected long f8204i = 0;
    protected boolean f8205j = false;
    protected DisplayMetrics f8206k;
    private boolean f8207l = false;

    protected ci(Context context) {
        try {
            bt.m9205a();
            this.f8206k = context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
        }
    }

    private String m9304a(Context context, String str, boolean z, View view, byte[] bArr) {
        boolean z2 = true;
        C2705a c2705a = null;
        if (bArr != null && bArr.length > 0) {
            try {
                c2705a = C2705a.m9138a(bArr);
            } catch (ma e) {
            }
        }
        if (z) {
            try {
                C2711a a = mo3524a(context, view);
                this.f8207l = true;
            } catch (NoSuchAlgorithmException e2) {
                return Integer.toString(7);
            } catch (UnsupportedEncodingException e3) {
                return Integer.toString(7);
            } catch (Throwable th) {
                return Integer.toString(3);
            }
        }
        a = mo3525a(context, c2705a);
        if (a == null || a.m9131g() == 0) {
            return Integer.toString(5);
        }
        if (m9306a(z)) {
            z2 = false;
        }
        return bt.m9199a(a, str, z2);
    }

    private static boolean m9305a(fa faVar) {
        return (faVar == null || faVar.f8891d == null || faVar.f8894g == null) ? false : true;
    }

    private static boolean m9306a(boolean z) {
        return !((Boolean) qb.bJ.m13225c()).booleanValue() ? true : ((Boolean) qb.bP.m13225c()).booleanValue() && z;
    }

    private boolean m9307b(fa faVar) {
        return (this.f8206k == null || faVar == null || faVar.f8892e == null || faVar.f8895h == null) ? false : true;
    }

    protected abstract long mo3523a(StackTraceElement[] stackTraceElementArr);

    protected abstract C2711a mo3524a(Context context, View view);

    protected abstract C2711a mo3525a(Context context, C2705a c2705a);

    public String mo3151a(Context context) {
        if (!fb.m10743b() || !((Boolean) qb.bO.m13225c()).booleanValue()) {
            return m9304a(context, null, false, null, null);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    public String m9312a(Context context, String str) {
        return mo3152a(context, str, null);
    }

    public String mo3152a(Context context, String str, View view) {
        return m9304a(context, str, true, view, null);
    }

    public String m9314a(Context context, byte[] bArr) {
        if (!fb.m10743b() || !((Boolean) qb.bO.m13225c()).booleanValue()) {
            return m9304a(context, null, false, null, bArr);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    public void mo3153a(int i, int i2, int i3) {
        if (this.f8196a != null) {
            this.f8196a.recycle();
        }
        if (this.f8206k != null) {
            this.f8196a = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.f8206k.density, ((float) i2) * this.f8206k.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.f8196a = null;
        }
        this.f8205j = false;
    }

    public void mo3154a(MotionEvent motionEvent) {
        if (this.f8207l) {
            this.f8201f = 0;
            this.f8200e = 0;
            this.f8199d = 0;
            this.f8198c = 0;
            this.f8202g = 0;
            this.f8204i = 0;
            this.f8203h = 0;
            Iterator it = this.f8197b.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.f8197b.clear();
            this.f8196a = null;
            this.f8207l = false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f8198c++;
                break;
            case 1:
                this.f8196a = MotionEvent.obtain(motionEvent);
                this.f8197b.add(this.f8196a);
                if (this.f8197b.size() > 6) {
                    ((MotionEvent) this.f8197b.remove()).recycle();
                }
                this.f8200e++;
                try {
                    this.f8202g = mo3523a(new Throwable().getStackTrace());
                    break;
                } catch (ek e) {
                    break;
                }
            case 2:
                this.f8199d += (long) (motionEvent.getHistorySize() + 1);
                try {
                    fa b = mo3526b(motionEvent);
                    if (m9305a(b)) {
                        this.f8203h += b.f8891d.longValue() + b.f8894g.longValue();
                    }
                    if (m9307b(b)) {
                        this.f8204i = (b.f8895h.longValue() + b.f8892e.longValue()) + this.f8204i;
                        break;
                    }
                } catch (ek e2) {
                    break;
                }
                break;
            case 3:
                this.f8201f++;
                break;
        }
        this.f8205j = true;
    }

    protected abstract fa mo3526b(MotionEvent motionEvent);
}
