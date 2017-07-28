package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras implements NetworkExtras {
    private final HashMap<String, Object> f7147a = new HashMap();

    public Object getExtra(String str) {
        return this.f7147a.get(str);
    }

    public void setExtra(String str, Object obj) {
        this.f7147a.put(str, obj);
    }
}
