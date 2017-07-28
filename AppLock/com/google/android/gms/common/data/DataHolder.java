package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

@KeepName
public final class DataHolder extends zza implements Closeable {
    public static final Creator<DataHolder> CREATOR = new C2488b();
    private static final C2485a f7331k = new C24861(new String[0], null);
    final int f7332a;
    Bundle f7333b;
    int[] f7334c;
    int f7335d;
    boolean f7336e = false;
    private final String[] f7337f;
    private final CursorWindow[] f7338g;
    private final int f7339h;
    private final Bundle f7340i;
    private boolean f7341j = true;

    public static class C2485a {
        private final String[] f7325a;
        private final ArrayList<HashMap<String, Object>> f7326b;
        private final String f7327c;
        private final HashMap<Object, Integer> f7328d;
        private boolean f7329e;
        private String f7330f;

        private C2485a(String[] strArr, String str) {
            this.f7325a = (String[]) C2513c.m7932a((Object) strArr);
            this.f7326b = new ArrayList();
            this.f7327c = str;
            this.f7328d = new HashMap();
            this.f7329e = false;
            this.f7330f = null;
        }
    }

    class C24861 extends C2485a {
        C24861(String[] strArr, String str) {
            super(strArr, str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.f7332a = i;
        this.f7337f = strArr;
        this.f7338g = cursorWindowArr;
        this.f7339h = i2;
        this.f7340i = bundle;
    }

    public void m7845a() {
        int i;
        int i2 = 0;
        this.f7333b = new Bundle();
        for (i = 0; i < this.f7337f.length; i++) {
            this.f7333b.putInt(this.f7337f[i], i);
        }
        this.f7334c = new int[this.f7338g.length];
        i = 0;
        while (i2 < this.f7338g.length) {
            this.f7334c[i2] = i;
            i += this.f7338g[i2].getNumRows() - (i - this.f7338g[i2].getStartPosition());
            i2++;
        }
        this.f7335d = i;
    }

    String[] m7846b() {
        return this.f7337f;
    }

    CursorWindow[] m7847c() {
        return this.f7338g;
    }

    public void close() {
        synchronized (this) {
            if (!this.f7336e) {
                this.f7336e = true;
                for (CursorWindow close : this.f7338g) {
                    close.close();
                }
            }
        }
    }

    public int m7848d() {
        return this.f7339h;
    }

    public Bundle m7849e() {
        return this.f7340i;
    }

    public boolean m7850f() {
        boolean z;
        synchronized (this) {
            z = this.f7336e;
        }
        return z;
    }

    protected void finalize() {
        try {
            if (this.f7341j && this.f7338g.length > 0 && !m7850f()) {
                close();
                String valueOf = String.valueOf(toString());
                Log.e("DataBuffer", new StringBuilder(String.valueOf(valueOf).length() + 178).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ").append(valueOf).append(")").toString());
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2488b.m7854a(this, parcel, i);
    }
}
