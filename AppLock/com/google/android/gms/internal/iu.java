package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class iu<T> {
    public Map<js, iu<T>> f9460a = new HashMap();
    public T f9461b;

    String m11814a(String str) {
        String valueOf = String.valueOf(this.f9461b);
        valueOf = new StringBuilder((String.valueOf(str).length() + 10) + String.valueOf(valueOf).length()).append(str).append("<value>: ").append(valueOf).append("\n").toString();
        if (this.f9460a.isEmpty()) {
            return new StringBuilder((String.valueOf(valueOf).length() + 7) + String.valueOf(str).length()).append(valueOf).append(str).append("<empty>").toString();
        }
        String str2 = valueOf;
        for (Entry entry : this.f9460a.entrySet()) {
            str2 = String.valueOf(str2);
            String valueOf2 = String.valueOf(entry.getKey());
            valueOf = String.valueOf(((iu) entry.getValue()).m11814a(String.valueOf(str).concat("\t")));
            str2 = new StringBuilder((((String.valueOf(str2).length() + 3) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf).length()).append(str2).append(str).append(valueOf2).append(":\n").append(valueOf).append("\n").toString();
        }
        return str2;
    }
}
