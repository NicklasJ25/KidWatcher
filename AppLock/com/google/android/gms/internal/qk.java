package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.internal.qm.C3173a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;

@wh
public final class qk extends C3173a {
    private final zzi f10344a;
    @Nullable
    private final String f10345b;
    private final String f10346c;

    public qk(zzi com_google_android_gms_ads_internal_zzi, @Nullable String str, String str2) {
        this.f10344a = com_google_android_gms_ads_internal_zzi;
        this.f10345b = str;
        this.f10346c = str2;
    }

    public String mo3908a() {
        return this.f10345b;
    }

    public void mo3909a(@Nullable C2309a c2309a) {
        if (c2309a != null) {
            this.f10344a.zzc((View) C2312b.m7328a(c2309a));
        }
    }

    public String mo3910b() {
        return this.f10346c;
    }

    public void mo3911c() {
        this.f10344a.zzbZ();
    }

    public void mo3912d() {
        this.f10344a.zzca();
    }
}
