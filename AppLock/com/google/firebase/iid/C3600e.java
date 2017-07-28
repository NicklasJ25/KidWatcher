package com.google.firebase.iid;

import android.support.annotation.Nullable;
import android.text.TextUtils;

public class C3600e {
    private static final Object f12254a = new Object();
    private final C3608h f12255b;

    C3600e(C3608h c3608h) {
        this.f12255b = c3608h;
    }

    @Nullable
    String m15665a() {
        String str = null;
        synchronized (f12254a) {
            String string = this.f12255b.m15709a().getString("topic_operaion_queue", null);
            if (string != null) {
                String[] split = string.split(",");
                if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                    str = split[1];
                }
            }
        }
        return str;
    }

    boolean m15666a(String str) {
        boolean z;
        synchronized (f12254a) {
            String string = this.f12255b.m15709a().getString("topic_operaion_queue", "");
            String valueOf = String.valueOf(",");
            String valueOf2 = String.valueOf(str);
            if (string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
                valueOf = String.valueOf(",");
                valueOf2 = String.valueOf(str);
                this.f12255b.m15709a().edit().putString("topic_operaion_queue", string.substring((valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).length())).apply();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
