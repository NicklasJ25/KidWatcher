package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.TextureView;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.aad;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.qf;
import com.google.android.gms.internal.qh;
import com.google.android.gms.internal.qj;
import com.google.android.gms.internal.wh;
import com.google.android.gms.internal.zr;
import com.google.android.gms.internal.zr.C3499a;
import com.google.android.gms.internal.zr.C3500b;
import com.google.android.gms.internal.zzqh;
import java.util.concurrent.TimeUnit;

@wh
public class zzz {
    private final Context f6856a;
    private final String f6857b;
    private final zzqh f6858c;
    @Nullable
    private final qh f6859d;
    @Nullable
    private final qj f6860e;
    private final zr f6861f = new C3500b().m15254a("min_1", Double.MIN_VALUE, 1.0d).m15254a("1_5", 1.0d, 5.0d).m15254a("5_10", 5.0d, 10.0d).m15254a("10_20", 10.0d, 20.0d).m15254a("20_30", 20.0d, 30.0d).m15254a("30_max", 30.0d, Double.MAX_VALUE).m15255a();
    private final long[] f6862g;
    private final String[] f6863h;
    private boolean f6864i = false;
    private boolean f6865j = false;
    private boolean f6866k = false;
    private boolean f6867l = false;
    private boolean f6868m;
    private zzj f6869n;
    private boolean f6870o;
    private boolean f6871p;
    private long f6872q = -1;

    public zzz(Context context, zzqh com_google_android_gms_internal_zzqh, String str, @Nullable qj qjVar, @Nullable qh qhVar) {
        this.f6856a = context;
        this.f6858c = com_google_android_gms_internal_zzqh;
        this.f6857b = str;
        this.f6860e = qjVar;
        this.f6859d = qhVar;
        String str2 = (String) qb.f10312y.m13225c();
        if (str2 == null) {
            this.f6863h = new String[0];
            this.f6862g = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.f6863h = new String[split.length];
        this.f6862g = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.f6862g[i] = Long.parseLong(split[i]);
            } catch (Throwable e) {
                aad.m8424c("Unable to parse frame hash target time number.", e);
                this.f6862g[i] = -1;
            }
        }
    }

    private void m7438a() {
        if (this.f6866k && !this.f6867l) {
            qf.m13288a(this.f6860e, this.f6859d, "vff2");
            this.f6867l = true;
        }
        long c = zzw.zzcS().mo3362c();
        if (this.f6868m && this.f6871p && this.f6872q != -1) {
            this.f6861f.m15258a(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (c - this.f6872q)));
        }
        this.f6871p = this.f6868m;
        this.f6872q = c;
    }

    private void m7439a(zzj com_google_android_gms_ads_internal_overlay_zzj) {
        long longValue = ((Long) qb.f10313z.m13225c()).longValue();
        long currentPosition = (long) com_google_android_gms_ads_internal_overlay_zzj.getCurrentPosition();
        int i = 0;
        while (i < this.f6863h.length) {
            if (this.f6863h[i] == null && longValue > Math.abs(currentPosition - this.f6862g[i])) {
                this.f6863h[i] = m7440a((TextureView) com_google_android_gms_ads_internal_overlay_zzj);
                return;
            }
            i++;
        }
    }

    @TargetApi(14)
    String m7440a(TextureView textureView) {
        Bitmap bitmap = textureView.getBitmap(8, 8);
        long j = 0;
        long j2 = 63;
        int i = 0;
        while (i < 8) {
            long j3 = j;
            j = j2;
            for (int i2 = 0; i2 < 8; i2++) {
                int pixel = bitmap.getPixel(i2, i);
                j3 |= (Color.green(pixel) + (Color.blue(pixel) + Color.red(pixel)) > 128 ? 1 : 0) << ((int) j);
                j--;
            }
            i++;
            j2 = j;
            j = j3;
        }
        return String.format("%016X", new Object[]{Long.valueOf(j)});
    }

    public void onStop() {
        if (((Boolean) qb.f10311x.m13225c()).booleanValue() && !this.f6870o) {
            String valueOf;
            String valueOf2;
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.f6857b);
            bundle.putString("player", this.f6869n.zzhy());
            for (C3499a c3499a : this.f6861f.m15257a()) {
                valueOf = String.valueOf("fps_c_");
                valueOf2 = String.valueOf(c3499a.f11713a);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Integer.toString(c3499a.f11717e));
                valueOf = String.valueOf("fps_p_");
                valueOf2 = String.valueOf(c3499a.f11713a);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Double.toString(c3499a.f11716d));
            }
            for (int i = 0; i < this.f6862g.length; i++) {
                valueOf2 = this.f6863h[i];
                if (valueOf2 != null) {
                    String valueOf3 = String.valueOf("fh_");
                    valueOf = String.valueOf(Long.valueOf(this.f6862g[i]));
                    bundle.putString(new StringBuilder(String.valueOf(valueOf3).length() + String.valueOf(valueOf).length()).append(valueOf3).append(valueOf).toString(), valueOf2);
                }
            }
            zzw.zzcM().m15120a(this.f6856a, this.f6858c.f12081a, "gmob-apps", bundle, true);
            this.f6870o = true;
        }
    }

    public void zza(zzj com_google_android_gms_ads_internal_overlay_zzj) {
        qf.m13288a(this.f6860e, this.f6859d, "vpc2");
        this.f6864i = true;
        if (this.f6860e != null) {
            this.f6860e.m13305a("vpn", com_google_android_gms_ads_internal_overlay_zzj.zzhy());
        }
        this.f6869n = com_google_android_gms_ads_internal_overlay_zzj;
    }

    public void zzb(zzj com_google_android_gms_ads_internal_overlay_zzj) {
        m7438a();
        m7439a(com_google_android_gms_ads_internal_overlay_zzj);
    }

    public void zzhU() {
        if (this.f6864i && !this.f6865j) {
            qf.m13288a(this.f6860e, this.f6859d, "vfr2");
            this.f6865j = true;
        }
    }

    public void zzix() {
        this.f6868m = true;
        if (this.f6865j && !this.f6866k) {
            qf.m13288a(this.f6860e, this.f6859d, "vfp2");
            this.f6866k = true;
        }
    }

    public void zziy() {
        this.f6868m = false;
    }
}
