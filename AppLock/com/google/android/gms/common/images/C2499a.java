package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.images.ImageManager.C2494a;
import com.google.android.gms.common.internal.C2512b;
import com.google.android.gms.common.internal.C2523j;
import com.google.android.gms.internal.ax;
import java.lang.ref.WeakReference;

public abstract class C2499a {
    final C2498a f7380a;
    protected int f7381b;

    static final class C2498a {
        public final Uri f7379a;

        public C2498a(Uri uri) {
            this.f7379a = uri;
        }

        public boolean equals(Object obj) {
            return !(obj instanceof C2498a) ? false : this == obj ? true : C2512b.m7931a(((C2498a) obj).f7379a, this.f7379a);
        }

        public int hashCode() {
            return C2512b.m7929a(this.f7379a);
        }
    }

    public static final class C2500b extends C2499a {
        private WeakReference<C2494a> f7382c;

        protected void mo3325a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            if (!z2) {
                C2494a c2494a = (C2494a) this.f7382c.get();
                if (c2494a != null) {
                    c2494a.m7882a(this.a.f7379a, drawable, z3);
                }
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C2500b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C2500b c2500b = (C2500b) obj;
            C2494a c2494a = (C2494a) this.f7382c.get();
            C2494a c2494a2 = (C2494a) c2500b.f7382c.get();
            boolean z = c2494a2 != null && c2494a != null && C2512b.m7931a(c2494a2, c2494a) && C2512b.m7931a(c2500b.a, this.a);
            return z;
        }

        public int hashCode() {
            return C2512b.m7929a(this.a);
        }
    }

    private Drawable m7899a(Context context, ax axVar, int i) {
        return context.getResources().getDrawable(i);
    }

    void m7900a(Context context, Bitmap bitmap, boolean z) {
        C2523j.m8015a((Object) bitmap);
        mo3325a(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    void m7901a(Context context, ax axVar, boolean z) {
        Drawable drawable = null;
        if (this.f7381b != 0) {
            drawable = m7899a(context, axVar, this.f7381b);
        }
        mo3325a(drawable, z, false, false);
    }

    protected abstract void mo3325a(Drawable drawable, boolean z, boolean z2, boolean z3);
}
