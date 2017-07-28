package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.C2315a.C2307b;
import com.google.android.gms.ads.internal.zzw;
import java.util.Map;

@wh
public class ur extends ux {
    private final Map<String, String> f10923a;
    private final Context f10924b;
    private String f10925c;
    private long f10926d;
    private long f10927e;
    private String f10928f;
    private String f10929g;

    class C33411 implements OnClickListener {
        final /* synthetic */ ur f10919a;

        C33411(ur urVar) {
            this.f10919a = urVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            zzw.zzcM().m15117a(this.f10919a.f10924b, this.f10919a.m14283b());
        }
    }

    class C33422 implements OnClickListener {
        final /* synthetic */ ur f10920a;

        C33422(ur urVar) {
            this.f10920a = urVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f10920a.m14275b("Operation denied by user.");
        }
    }

    public ur(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        super(com_google_android_gms_internal_aat, "createCalendarEvent");
        this.f10923a = map;
        this.f10924b = com_google_android_gms_internal_aat.mo3418f();
        m14280c();
    }

    private String m14279a(String str) {
        return TextUtils.isEmpty((CharSequence) this.f10923a.get(str)) ? "" : (String) this.f10923a.get(str);
    }

    private void m14280c() {
        this.f10925c = m14279a("description");
        this.f10928f = m14279a("summary");
        this.f10926d = m14281e("start_ticks");
        this.f10927e = m14281e("end_ticks");
        this.f10929g = m14279a("location");
    }

    private long m14281e(String str) {
        String str2 = (String) this.f10923a.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void m14282a() {
        if (this.f10924b == null) {
            m14275b("Activity context is not available.");
        } else if (zzw.zzcM().m15153e(this.f10924b).m13211e()) {
            Builder d = zzw.zzcM().m15150d(this.f10924b);
            Resources t = zzw.zzcQ().m15031t();
            d.setTitle(t != null ? t.getString(C2307b.create_calendar_title) : "Create calendar event");
            d.setMessage(t != null ? t.getString(C2307b.create_calendar_message) : "Allow Ad to create a calendar event?");
            d.setPositiveButton(t != null ? t.getString(C2307b.accept) : "Accept", new C33411(this));
            d.setNegativeButton(t != null ? t.getString(C2307b.decline) : "Decline", new C33422(this));
            d.create().show();
        } else {
            m14275b("This feature is not available on the device.");
        }
    }

    @TargetApi(14)
    Intent m14283b() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra("title", this.f10925c);
        data.putExtra("eventLocation", this.f10929g);
        data.putExtra("description", this.f10928f);
        if (this.f10926d > -1) {
            data.putExtra("beginTime", this.f10926d);
        }
        if (this.f10927e > -1) {
            data.putExtra("endTime", this.f10927e);
        }
        data.setFlags(268435456);
        return data;
    }
}
