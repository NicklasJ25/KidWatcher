package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.flags.impl.C2615a.C2616a;
import com.google.android.gms.flags.impl.C2615a.C2618b;
import com.google.android.gms.flags.impl.C2615a.C2620c;
import com.google.android.gms.flags.impl.C2615a.C2622d;
import com.google.android.gms.internal.bz.C2613a;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;

@DynamiteApi
public class FlagProviderImpl extends C2613a {
    private boolean f7588a = false;
    private SharedPreferences f7589b;

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return !this.f7588a ? z : C2616a.m8365a(this.f7589b, str, Boolean.valueOf(z)).booleanValue();
    }

    public int getIntFlagValue(String str, int i, int i2) {
        return !this.f7588a ? i : C2618b.m8367a(this.f7589b, str, Integer.valueOf(i)).intValue();
    }

    public long getLongFlagValue(String str, long j, int i) {
        return !this.f7588a ? j : C2620c.m8369a(this.f7589b, str, Long.valueOf(j)).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i) {
        return !this.f7588a ? str2 : C2622d.m8371a(this.f7589b, str, str2);
    }

    public void init(C2309a c2309a) {
        Context context = (Context) C2312b.m7328a(c2309a);
        if (!this.f7588a) {
            try {
                this.f7589b = C2624b.m8373a(context.createPackageContext("com.google.android.gms", 0));
                this.f7588a = true;
            } catch (NameNotFoundException e) {
            }
        }
    }
}
