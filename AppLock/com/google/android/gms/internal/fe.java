package com.google.android.gms.internal;

import android.provider.Settings.SettingNotFoundException;
import com.google.android.gms.internal.bp.C2711a;
import java.lang.reflect.InvocationTargetException;

public class fe extends ml {
    public fe(ez ezVar, String str, String str2, C2711a c2711a, int i, int i2) {
        super(ezVar, str, str2, c2711a, i, i2);
    }

    protected void mo3587a() {
        this.e.f8031P = Integer.valueOf(2);
        try {
            this.e.f8031P = Integer.valueOf(((Boolean) this.f.invoke(null, new Object[]{this.b.m10721b()})).booleanValue() ? 1 : 0);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
