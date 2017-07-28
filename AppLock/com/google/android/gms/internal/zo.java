package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.C2315a.C2307b;
import com.google.android.gms.ads.internal.zzw;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@wh
public class zo {
    private final Context f11694a;
    private String f11695b;
    private String f11696c;
    private String f11697d;
    private final float f11698e;
    private float f11699f;
    private float f11700g;
    private float f11701h;
    private int f11702i;

    class C34933 implements OnClickListener {
        C34933(zo zoVar) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    class C34944 implements Runnable {
        final /* synthetic */ zo f11692a;

        C34944(zo zoVar) {
            this.f11692a = zoVar;
        }

        public void run() {
            zzw.zzcU().m15241a(this.f11692a.f11694a, this.f11692a.f11696c, this.f11692a.f11697d);
        }
    }

    class C34955 implements Runnable {
        final /* synthetic */ zo f11693a;

        C34955(zo zoVar) {
            this.f11693a = zoVar;
        }

        public void run() {
            zzw.zzcU().m15246b(this.f11693a.f11694a, this.f11693a.f11696c, this.f11693a.f11697d);
        }
    }

    public zo(Context context) {
        this.f11702i = 0;
        this.f11694a = context;
        this.f11698e = context.getResources().getDisplayMetrics().density;
    }

    public zo(Context context, String str) {
        this(context);
        this.f11695b = str;
    }

    private int m15219a(List<String> list, String str, boolean z) {
        if (!z) {
            return -1;
        }
        list.add(str);
        return list.size() - 1;
    }

    private void m15221b() {
        if (this.f11694a instanceof Activity) {
            CharSequence string;
            Resources t = zzw.zzcQ().m15031t();
            if (t != null) {
                string = t.getString(C2307b.debug_menu_title);
            } else {
                Object obj = "Select a Debug Mode";
            }
            String string2 = t != null ? t.getString(C2307b.debug_menu_ad_information) : "Ad Information";
            String string3 = t != null ? t.getString(C2307b.debug_menu_creative_preview) : "Creative Preview";
            String string4 = t != null ? t.getString(C2307b.debug_menu_troubleshooting) : "Troubleshooting";
            List arrayList = new ArrayList();
            final int a = m15219a(arrayList, string2, true);
            final int a2 = m15219a(arrayList, string3, ((Boolean) qb.df.m13225c()).booleanValue());
            final int a3 = m15219a(arrayList, string4, ((Boolean) qb.dg.m13225c()).booleanValue());
            new Builder(this.f11694a).setTitle(string).setItems((CharSequence[]) arrayList.toArray(new String[0]), new OnClickListener(this) {
                final /* synthetic */ zo f11689d;

                public void onClick(DialogInterface dialogInterface, int i) {
                    if (i == a) {
                        this.f11689d.m15223c();
                    } else if (i == a2 && ((Boolean) qb.df.m13225c()).booleanValue()) {
                        this.f11689d.m15227d();
                    } else if (i == a3 && ((Boolean) qb.dg.m13225c()).booleanValue()) {
                        this.f11689d.m15229e();
                    }
                }
            }).create().show();
            return;
        }
        aad.m8425d("Can not create dialog without Activity Context");
    }

    private void m15223c() {
        if (this.f11694a instanceof Activity) {
            final Object d = m15226d(this.f11695b);
            Builder builder = new Builder(this.f11694a);
            builder.setMessage(d);
            builder.setTitle("Ad Information");
            builder.setPositiveButton("Share", new OnClickListener(this) {
                final /* synthetic */ zo f11691b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    zzw.zzcM().m15117a(this.f11691b.f11694a, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", d), "Share via"));
                }
            });
            builder.setNegativeButton("Close", new C34933(this));
            builder.create().show();
            return;
        }
        aad.m8425d("Can not create dialog without Activity Context");
    }

    static String m15226d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "No debug information";
        }
        Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
        StringBuilder stringBuilder = new StringBuilder();
        Map a = zzw.zzcM().m15111a(build);
        for (String str2 : a.keySet()) {
            stringBuilder.append(str2).append(" = ").append((String) a.get(str2)).append("\n\n");
        }
        Object trim = stringBuilder.toString().trim();
        return TextUtils.isEmpty(trim) ? "No debug information" : trim;
    }

    private void m15227d() {
        aad.m8421b("Debug mode [Creative Preview] selected.");
        zk.m15079a(new C34944(this));
    }

    private void m15229e() {
        aad.m8421b("Debug mode [Troubleshooting] selected.");
        zk.m15079a(new C34955(this));
    }

    public void m15231a() {
        if (((Boolean) qb.dg.m13225c()).booleanValue() || ((Boolean) qb.df.m13225c()).booleanValue()) {
            m15221b();
        } else {
            m15223c();
        }
    }

    void m15232a(int i, float f, float f2) {
        if (i == 0) {
            this.f11702i = 0;
            this.f11699f = f;
            this.f11700g = f2;
            this.f11701h = f2;
        } else if (this.f11702i == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.f11700g) {
                    this.f11700g = f2;
                } else if (f2 < this.f11701h) {
                    this.f11701h = f2;
                }
                if (this.f11700g - this.f11701h > 30.0f * this.f11698e) {
                    this.f11702i = -1;
                    return;
                }
                if (this.f11702i == 0 || this.f11702i == 2) {
                    if (f - this.f11699f >= 50.0f * this.f11698e) {
                        this.f11699f = f;
                        this.f11702i++;
                    }
                } else if ((this.f11702i == 1 || this.f11702i == 3) && f - this.f11699f <= -50.0f * this.f11698e) {
                    this.f11699f = f;
                    this.f11702i++;
                }
                if (this.f11702i == 1 || this.f11702i == 3) {
                    if (f > this.f11699f) {
                        this.f11699f = f;
                    }
                } else if (this.f11702i == 2 && f < this.f11699f) {
                    this.f11699f = f;
                }
            } else if (i == 1 && this.f11702i == 4) {
                m15231a();
            }
        }
    }

    public void m15233a(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            m15232a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        m15232a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }

    public void m15234a(String str) {
        this.f11696c = str;
    }

    public void m15235b(String str) {
        this.f11697d = str;
    }

    public void m15236c(String str) {
        this.f11695b = str;
    }
}
