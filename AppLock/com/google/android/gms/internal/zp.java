package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.android.gallery3d.exif.ExifTag.GpsMeasureMode;
import com.google.android.gms.ads.internal.zzw;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

@wh
public class zp {
    protected String f11708a = "";
    private final Object f11709b = new Object();
    private String f11710c = "";
    private String f11711d = "";
    private boolean f11712e = false;

    private Uri m15237b(Context context, String str, String str2, String str3) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", m15240a(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    private void m15238f(Context context, String str, String str2) {
        zzw.zzcM().m15118a(context, m15237b(context, (String) qb.dh.m13225c(), str, str2));
    }

    public String m15239a() {
        String str;
        synchronized (this.f11709b) {
            str = this.f11711d;
        }
        return str;
    }

    public String m15240a(Context context) {
        String str;
        synchronized (this.f11709b) {
            if (TextUtils.isEmpty(this.f11710c)) {
                this.f11710c = zzw.zzcM().m15139b(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.f11710c)) {
                    this.f11710c = zzw.zzcM().m15145c();
                    zzw.zzcM().m15147c(context, "debug_signals_id.txt", this.f11710c);
                }
            }
            str = this.f11710c;
        }
        return str;
    }

    public void m15241a(Context context, String str, String str2) {
        if (!m15248c(context, str, str2)) {
            m15243a(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if (GpsMeasureMode.MODE_2_DIMENSIONAL.equals(this.f11708a)) {
            aad.m8421b("Creative is not pushed for this device.");
            m15243a(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.f11708a)) {
            aad.m8421b("The app is not linked for creative preview.");
            m15238f(context, str, str2);
        } else if ("0".equals(this.f11708a)) {
            aad.m8421b("Device is linked for in app preview.");
            m15243a(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public void m15242a(Context context, String str, String str2, String str3) {
        Builder buildUpon = m15237b(context, (String) qb.dk.m13225c(), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzw.zzcM().m15141b(context, str, buildUpon.build().toString());
    }

    protected void m15243a(Context context, String str, boolean z, boolean z2) {
        if (context instanceof Activity) {
            final Context context2 = context;
            final String str2 = str;
            final boolean z3 = z;
            final boolean z4 = z2;
            zl.f11678a.post(new Runnable(this) {

                class C34961 implements OnClickListener {
                    final /* synthetic */ C34971 f11703a;

                    C34961(C34971 c34971) {
                        this.f11703a = c34971;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        zzw.zzcM().m15118a(context2, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
                    }
                }

                public void run() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context2);
                    builder.setMessage(str2);
                    if (z3) {
                        builder.setTitle("Error");
                    } else {
                        builder.setTitle("Info");
                    }
                    if (z4) {
                        builder.setNeutralButton("Dismiss", null);
                    } else {
                        builder.setPositiveButton("Learn More", new C34961(this));
                        builder.setNegativeButton("Dismiss", null);
                    }
                    builder.create().show();
                }
            });
            return;
        }
        aad.m8425d("Can not create dialog without Activity Context");
    }

    public void m15244a(String str) {
        synchronized (this.f11709b) {
            this.f11711d = str;
        }
    }

    public void m15245a(boolean z) {
        synchronized (this.f11709b) {
            this.f11712e = z;
        }
    }

    public void m15246b(Context context, String str, String str2) {
        if (m15249d(context, str, str2)) {
            aad.m8421b("Device is linked for debug signals.");
            m15243a(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        m15238f(context, str, str2);
    }

    public boolean m15247b() {
        boolean z;
        synchronized (this.f11709b) {
            z = this.f11712e;
        }
        return z;
    }

    boolean m15248c(Context context, String str, String str2) {
        Object e = m15250e(context, m15237b(context, (String) qb.di.m13225c(), str, str2).toString(), str2);
        if (TextUtils.isEmpty(e)) {
            aad.m8421b("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(e.trim());
            String optString = jSONObject.optString("gct");
            this.f11708a = jSONObject.optString("status");
            m15244a(optString);
            return true;
        } catch (Throwable e2) {
            aad.m8424c("Fail to get in app preview response json.", e2);
            return false;
        }
    }

    boolean m15249d(Context context, String str, String str2) {
        Object e = m15250e(context, m15237b(context, (String) qb.dj.m13225c(), str, str2).toString(), str2);
        if (TextUtils.isEmpty(e)) {
            aad.m8421b("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(e.trim()).optString("debug_mode"));
            m15245a(equals);
            return equals;
        } catch (Throwable e2) {
            aad.m8424c("Fail to get debug mode response json.", e2);
            return false;
        }
    }

    protected String m15250e(Context context, String str, String str2) {
        Throwable th;
        String str3;
        String valueOf;
        Map hashMap = new HashMap();
        hashMap.put("User-Agent", zzw.zzcM().m15106a(context, str2));
        aaj a = new zs(context).m15274a(str, hashMap);
        try {
            return (String) a.get((long) ((Integer) qb.dl.m13225c()).intValue(), TimeUnit.MILLISECONDS);
        } catch (Throwable e) {
            th = e;
            str3 = "Timeout while retriving a response from: ";
            valueOf = String.valueOf(str);
            aad.m8422b(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), th);
            a.cancel(true);
        } catch (Throwable e2) {
            th = e2;
            str3 = "Interrupted while retriving a response from: ";
            valueOf = String.valueOf(str);
            aad.m8422b(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), th);
            a.cancel(true);
        } catch (Throwable e22) {
            th = e22;
            String str4 = "Error retriving a response from: ";
            valueOf = String.valueOf(str);
            aad.m8422b(valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4), th);
        }
        return null;
    }
}
