package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.C2456a;
import com.google.android.gms.common.api.C2456a.C2416a.C2446b;
import com.google.android.gms.common.api.C2456a.C2448b;
import com.google.android.gms.common.api.C2456a.C2451f;
import com.google.android.gms.common.api.C2456a.C2452g;
import com.google.android.gms.common.api.C2461c;
import com.google.android.gms.common.api.C2461c.C2459b;
import com.google.android.gms.common.api.C2461c.C2460c;
import com.google.android.gms.common.api.C2463d;
import com.google.android.gms.common.api.C2464e;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.common.internal.C2539m;
import com.google.android.gms.common.util.C2580e;
import com.google.android.gms.common.util.C2582g;
import com.google.android.gms.internal.mf.C3053d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;

public final class abq {
    public static final C2452g<abu> f7835a = new C2452g();
    public static final C2448b<abu, C2446b> f7836b = new C26671();
    @Deprecated
    public static final C2456a<C2446b> f7837c = new C2456a("ClearcutLogger.API", f7836b, f7835a);
    private final String f7838d;
    private final int f7839e;
    private String f7840f;
    private int f7841g;
    private String f7842h;
    private String f7843i;
    private final boolean f7844j;
    private int f7845k;
    private final abr f7846l;
    private final C2580e f7847m;
    private C2671d f7848n;
    private final C2669b f7849o;

    class C26671 extends C2448b<abu, C2446b> {
        C26671() {
        }

        public /* synthetic */ C2451f mo3464a(Context context, Looper looper, C2539m c2539m, Object obj, C2459b c2459b, C2460c c2460c) {
            return m8807a(context, looper, c2539m, (C2446b) obj, c2459b, c2460c);
        }

        public abu m8807a(Context context, Looper looper, C2539m c2539m, C2446b c2446b, C2459b c2459b, C2460c c2460c) {
            return new abu(context, looper, c2539m, c2459b, c2460c);
        }
    }

    public class C2668a {
        final /* synthetic */ abq f7821a;
        private int f7822b;
        private String f7823c;
        private String f7824d;
        private String f7825e;
        private int f7826f;
        private final C2670c f7827g;
        private ArrayList<Integer> f7828h;
        private ArrayList<String> f7829i;
        private ArrayList<Integer> f7830j;
        private ArrayList<byte[]> f7831k;
        private boolean f7832l;
        private final C3053d f7833m;
        private boolean f7834n;

        private C2668a(abq com_google_android_gms_internal_abq, byte[] bArr) {
            this(com_google_android_gms_internal_abq, bArr, null);
        }

        private C2668a(abq com_google_android_gms_internal_abq, byte[] bArr, C2670c c2670c) {
            this.f7821a = com_google_android_gms_internal_abq;
            this.f7822b = this.f7821a.f7841g;
            this.f7823c = this.f7821a.f7840f;
            this.f7824d = this.f7821a.f7842h;
            this.f7825e = this.f7821a.f7843i;
            this.f7826f = 0;
            this.f7828h = null;
            this.f7829i = null;
            this.f7830j = null;
            this.f7831k = null;
            this.f7832l = true;
            this.f7833m = new C3053d();
            this.f7834n = false;
            this.f7824d = com_google_android_gms_internal_abq.f7842h;
            this.f7825e = com_google_android_gms_internal_abq.f7843i;
            this.f7833m.f9797a = com_google_android_gms_internal_abq.f7847m.mo3360a();
            this.f7833m.f9798b = com_google_android_gms_internal_abq.f7847m.mo3361b();
            this.f7833m.f9812p = com_google_android_gms_internal_abq.f7848n.m8815a(this.f7833m.f9797a);
            if (bArr != null) {
                this.f7833m.f9807k = bArr;
            }
            this.f7827g = c2670c;
        }

        @Deprecated
        public C2463d<Status> m8808a(C2461c c2461c) {
            return m8811b();
        }

        public C2668a m8809a(int i) {
            this.f7833m.f9801e = i;
            return this;
        }

        public zzzm m8810a() {
            return new zzzm(new zzzu(this.f7821a.f7838d, this.f7821a.f7839e, this.f7822b, this.f7823c, this.f7824d, this.f7825e, this.f7821a.f7844j, this.f7826f), this.f7833m, this.f7827g, null, abq.m8824d(null), abq.m8826e(null), abq.m8824d(null), abq.m8828f(null), this.f7832l);
        }

        @Deprecated
        public C2463d<Status> m8811b() {
            if (this.f7834n) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.f7834n = true;
            zzzm a = m8810a();
            zzzu com_google_android_gms_internal_zzzu = a.f12086a;
            return this.f7821a.f7849o.mo3483a(com_google_android_gms_internal_zzzu.f12102g, com_google_android_gms_internal_zzzu.f12098c) ? this.f7821a.f7846l.mo3477a(a) : C2464e.m7779a(Status.zzazx);
        }

        public C2668a m8812b(int i) {
            this.f7833m.f9802f = i;
            return this;
        }
    }

    public interface C2669b {
        boolean mo3483a(String str, int i);
    }

    public interface C2670c {
        byte[] m8814a();
    }

    public static class C2671d {
        public long m8815a(long j) {
            return (long) (TimeZone.getDefault().getOffset(j) / 1000);
        }
    }

    public abq(Context context, int i, String str, String str2, String str3, boolean z, abr com_google_android_gms_internal_abr, C2580e c2580e, C2671d c2671d, C2669b c2669b) {
        boolean z2 = false;
        this.f7841g = -1;
        this.f7845k = 0;
        this.f7838d = context.getPackageName();
        this.f7839e = m8816a(context);
        this.f7841g = i;
        this.f7840f = str;
        this.f7842h = str2;
        this.f7843i = str3;
        this.f7844j = z;
        this.f7846l = com_google_android_gms_internal_abr;
        this.f7847m = c2580e;
        if (c2671d == null) {
            c2671d = new C2671d();
        }
        this.f7848n = c2671d;
        this.f7845k = 0;
        this.f7849o = c2669b;
        if (this.f7844j) {
            if (this.f7842h == null) {
                z2 = true;
            }
            C2513c.m7942b(z2, "can't be anonymous with an upload account");
        }
    }

    public abq(Context context, String str, String str2) {
        this(context, -1, str, str2, null, false, abt.m8880a(context), C2582g.m8288d(), null, new aby(context));
    }

    private int m8816a(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.");
            return i;
        }
    }

    private static int[] m8824d(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            iArr[i] = ((Integer) it.next()).intValue();
            i = i2;
        }
        return iArr;
    }

    private static String[] m8826e(ArrayList<String> arrayList) {
        return arrayList == null ? null : (String[]) arrayList.toArray(new String[0]);
    }

    private static byte[][] m8828f(ArrayList<byte[]> arrayList) {
        return arrayList == null ? null : (byte[][]) arrayList.toArray(new byte[0][]);
    }

    public C2668a m8835a(byte[] bArr) {
        return new C2668a(bArr);
    }
}
