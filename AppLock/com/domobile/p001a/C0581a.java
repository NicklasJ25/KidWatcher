package com.domobile.p001a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.provider.Settings.System;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.domobile.frame.ui.C1288c;
import com.domobile.p001a.p002a.C0575c;
import com.domobile.p001a.p002a.C0575c.C0561c;
import com.domobile.p001a.p002a.C0575c.C0563d;
import com.domobile.p001a.p002a.C0575c.C0565b;
import com.domobile.p001a.p002a.C0575c.C0567a;
import com.domobile.p001a.p002a.C0576d;
import com.domobile.p001a.p002a.C0577e;
import com.domobile.p001a.p002a.C0578f;
import com.domobile.p001a.p002a.C0580h;
import com.domobile.p016c.C1169a;
import com.google.android.vending.licensing.C3526a.C3524a;
import java.util.ArrayList;

public class C0581a {
    C0563d f394a;
    C0565b f395b;
    C0567a f396c;
    private String f397d;
    private Context f398e;
    private String f399f;
    private C0569a f400g;
    private ArrayList<String> f401h;
    private C0575c f402i;
    private boolean f403j;

    class C05621 implements C0561c {
        final /* synthetic */ C0581a f339a;

        C05621(C0581a c0581a) {
            this.f339a = c0581a;
        }

        public void mo2349a(C0576d c0576d) {
            if (this.f339a.f400g != null) {
                this.f339a.f400g.mo2447a(c0576d);
            }
            if (c0576d != null && c0576d.m526b()) {
                this.f339a.f403j = true;
                this.f339a.m563c();
            }
        }
    }

    class C05642 implements C0563d {
        final /* synthetic */ C0581a f340a;

        C05642(C0581a c0581a) {
            this.f340a = c0581a;
        }

        public void mo2350a(C0576d c0576d, C0577e c0577e) {
            this.f340a.f400g.mo2448a(c0577e, c0576d);
        }
    }

    class C05663 implements C0565b {
        final /* synthetic */ C0581a f341a;

        C05663(C0581a c0581a) {
            this.f341a = c0581a;
        }

        public void mo2351a(C0576d c0576d, C0578f c0578f) {
            if (!this.f341a.m548a(c0578f)) {
                c0576d.m525a(6);
            }
            if (this.f341a.f400g != null) {
                this.f341a.f400g.mo2449a(c0578f, c0576d);
            }
        }
    }

    class C05684 implements C0567a {
        final /* synthetic */ C0581a f342a;

        C05684(C0581a c0581a) {
            this.f342a = c0581a;
        }
    }

    public interface C0569a {
        void mo2447a(C0576d c0576d);

        void mo2448a(C0577e c0577e, C0576d c0576d);

        void mo2449a(C0578f c0578f, C0576d c0576d);
    }

    public C0581a(Context context, String str, C0569a c0569a) {
        this(context, str, null, c0569a, true);
    }

    public C0581a(Context context, String str, ArrayList<String> arrayList, C0569a c0569a, boolean z) {
        this.f397d = "";
        this.f403j = false;
        this.f394a = new C05642(this);
        this.f395b = new C05663(this);
        this.f396c = new C05684(this);
        this.f399f = str;
        this.f401h = arrayList;
        this.f400g = c0569a;
        this.f398e = context;
        this.f402i = new C0575c(this.f398e, this.f399f);
        this.f402i.m514a(false);
        if (z) {
            m558a();
        }
    }

    private static String m544a(Context context) {
        String string;
        String macAddress;
        try {
            string = System.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
            string = null;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            macAddress = wifiManager != null ? wifiManager.getConnectionInfo().getMacAddress() : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            macAddress = null;
        }
        if (string == null) {
            string = "";
        }
        if (macAddress == null) {
            macAddress = "";
        }
        String substring = context.getPackageName().substring(4, 12);
        macAddress = "true" + macAddress;
        try {
            macAddress = C1169a.m2675a(macAddress, substring);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return macAddress;
    }

    public static void m545a(Context context, C0578f c0578f) {
        if (c0578f != null) {
            C0581a.m546a(context, c0578f.m535b());
        }
    }

    public static void m546a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            context.getSharedPreferences("purchase", 0).edit().putString(C0581a.m557e(context, str), C0581a.m544a(context)).commit();
        }
    }

    private void m547a(String str) {
        if (this.f398e instanceof Activity) {
            C1288c c1288c = new C1288c((Activity) this.f398e);
            c1288c.m3114b(17039370, null);
            c1288c.mo2528a((CharSequence) str).m3117b(true).m3122d();
        }
    }

    private boolean m548a(C0578f c0578f) {
        return true;
    }

    private static String m551b(Context context) {
        String macAddress;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            macAddress = wifiManager != null ? wifiManager.getConnectionInfo().getMacAddress() : "";
        } catch (Exception e) {
            e.printStackTrace();
            macAddress = null;
        }
        if (macAddress == null) {
            macAddress = "";
        }
        String substring = context.getPackageName().substring(4, 12);
        macAddress = "true" + macAddress;
        try {
            macAddress = C1169a.m2675a(macAddress, substring);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return macAddress;
    }

    private void m552b(Activity activity, Fragment fragment, C0580h c0580h) {
        this.f402i.m511a(activity, fragment, c0580h.m541b(), 10001, this.f395b, this.f397d);
    }

    public static void m553b(Context context, String str) {
        context.getSharedPreferences("purchase", 0).edit().remove(C0581a.m557e(context, str)).commit();
    }

    private void m554c(Activity activity, Fragment fragment, C0580h c0580h) {
        if (!this.f402i.m518b()) {
            m547a(this.f398e.getString(C3524a.billing_not_supported_message));
        }
        this.f402i.m512a(activity, fragment, c0580h.m541b(), "subs", 10001, this.f395b, this.f397d);
    }

    public static boolean m555c(Context context, String str) {
        String e = C0581a.m557e(context, str);
        return TextUtils.equals(context.getSharedPreferences("purchase", 0).getString(e, null), C0581a.m544a(context));
    }

    public static boolean m556d(Context context, String str) {
        String e = C0581a.m557e(context, str);
        return TextUtils.equals(context.getSharedPreferences("purchase", 0).getString(e, null), C0581a.m551b(context));
    }

    private static final String m557e(Context context, String str) {
        String substring = context.getPackageName().substring(4, 12);
        try {
            return C1169a.m2675a(str, substring);
        } catch (Exception e) {
            e.printStackTrace();
            if (str == null) {
                str = "";
            }
            return substring;
        }
    }

    public void m558a() {
        this.f402i.m513a(new C05621(this));
    }

    public void m559a(Activity activity, Fragment fragment, C0580h c0580h) {
        if (this.f403j) {
            try {
                if (c0580h.m540a() == "subs") {
                    m554c(activity, fragment, c0580h);
                    return;
                } else {
                    m552b(activity, fragment, c0580h);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        m547a(this.f398e.getString(C3524a.billing_not_supported_message));
    }

    public boolean m560a(int i, int i2, Intent intent) {
        return this.f402i != null ? this.f402i.m516a(i, i2, intent) : false;
    }

    public boolean m561a(C0577e c0577e, String str) {
        if (c0577e == null) {
            return false;
        }
        C0578f b = c0577e.m531b(str);
        return b != null && m548a(b);
    }

    public boolean m562b() {
        return this.f403j;
    }

    public void m563c() {
        if (this.f403j) {
            try {
                this.f402i.m515a(true, this.f401h, this.f394a);
            } catch (Exception e) {
                e.printStackTrace();
                this.f400g.mo2448a(null, null);
            }
        }
    }

    public void m564d() {
        try {
            if (this.f402i != null) {
                this.f402i.m510a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f402i = null;
    }
}
