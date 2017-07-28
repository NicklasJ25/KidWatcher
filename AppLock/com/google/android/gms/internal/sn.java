package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.overlay.zzl;
import java.util.Map;
import org.json.JSONObject;

@wh
public final class sn implements sc {
    private boolean f10582a;

    private static int m13736a(Context context, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                i = ol.m12979a().m8398a(context, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                aad.m8426e(new StringBuilder((String.valueOf(str).length() + 34) + String.valueOf(str2).length()).append("Could not parse ").append(str).append(" in a video GMSG: ").append(str2).toString());
            }
        }
        return i;
    }

    public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
        String str = (String) map.get("action");
        if (str == null) {
            aad.m8426e("Action missing from video GMSG.");
            return;
        }
        if (aad.m8420a(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject.toString());
            aad.m8421b(new StringBuilder((String.valueOf(str).length() + 13) + String.valueOf(valueOf).length()).append("Video GMSG: ").append(str).append(" ").append(valueOf).toString());
        }
        if ("background".equals(str)) {
            valueOf = (String) map.get("color");
            if (TextUtils.isEmpty(valueOf)) {
                aad.m8426e("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                com_google_android_gms_internal_aat.setBackgroundColor(Color.parseColor(valueOf));
                return;
            } catch (IllegalArgumentException e) {
                aad.m8426e("Invalid color parameter in video GMSG.");
                return;
            }
        }
        aas w = com_google_android_gms_internal_aat.mo3445w();
        if (w == null) {
            aad.m8426e("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = "new".equals(str);
        boolean equals2 = "position".equals(str);
        int a;
        int min;
        if (equals || equals2) {
            Context context = com_google_android_gms_internal_aat.getContext();
            int a2 = m13736a(context, map, "x", 0);
            a = m13736a(context, map, "y", 0);
            int a3 = m13736a(context, map, "w", -1);
            int a4 = m13736a(context, map, "h", -1);
            if (((Boolean) qb.cp.m13225c()).booleanValue()) {
                min = Math.min(a3, com_google_android_gms_internal_aat.getMeasuredWidth() - a2);
                a4 = Math.min(a4, com_google_android_gms_internal_aat.getMeasuredHeight() - a);
            } else {
                min = a3;
            }
            try {
                a3 = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e2) {
                a3 = 0;
            }
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
            if (equals && w.m8471a() == null) {
                w.m8473a(a2, a, min, a4, a3, parseBoolean);
                return;
            } else {
                w.m8472a(a2, a, min, a4);
                return;
            }
        }
        zzl a5 = w.m8471a();
        if (a5 == null) {
            zzl.zzi(com_google_android_gms_internal_aat);
        } else if ("click".equals(str)) {
            r0 = com_google_android_gms_internal_aat.getContext();
            a = m13736a(r0, map, "x", 0);
            min = m13736a(r0, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a, (float) min, 0);
            a5.zzf(obtain);
            obtain.recycle();
        } else if ("currentTime".equals(str)) {
            valueOf = (String) map.get("time");
            if (valueOf == null) {
                aad.m8426e("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                a5.seekTo((int) (Float.parseFloat(valueOf) * 1000.0f));
            } catch (NumberFormatException e3) {
                str = "Could not parse time parameter from currentTime video GMSG: ";
                valueOf = String.valueOf(valueOf);
                aad.m8426e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        } else if ("hide".equals(str)) {
            a5.setVisibility(4);
        } else if ("load".equals(str)) {
            a5.zzib();
        } else if ("muted".equals(str)) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                a5.zzhZ();
            } else {
                a5.zzia();
            }
        } else if ("pause".equals(str)) {
            a5.pause();
        } else if ("play".equals(str)) {
            a5.play();
        } else if ("show".equals(str)) {
            a5.setVisibility(0);
        } else if ("src".equals(str)) {
            a5.zzaC((String) map.get("src"));
        } else if ("touchMove".equals(str)) {
            r0 = com_google_android_gms_internal_aat.getContext();
            a5.zza((float) m13736a(r0, map, "dx", 0), (float) m13736a(r0, map, "dy", 0));
            if (!this.f10582a) {
                com_google_android_gms_internal_aat.mo3421i().zzhL();
                this.f10582a = true;
            }
        } else if ("volume".equals(str)) {
            valueOf = (String) map.get("volume");
            if (valueOf == null) {
                aad.m8426e("Level parameter missing from volume video GMSG.");
                return;
            }
            try {
                a5.zzb(Float.parseFloat(valueOf));
            } catch (NumberFormatException e4) {
                str = "Could not parse volume parameter from volume video GMSG: ";
                valueOf = String.valueOf(valueOf);
                aad.m8426e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        } else if ("watermark".equals(str)) {
            a5.zzic();
        } else {
            String str2 = "Unknown video action: ";
            valueOf = String.valueOf(str);
            aad.m8426e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }
}
