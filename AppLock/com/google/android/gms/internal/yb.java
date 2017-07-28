package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.internal.C2513c;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@wh
public class yb {
    public static void m14852a(Context context, Runnable runnable) {
        C2513c.m7940b("Adapters must be initialized on the main thread.");
        Map e = zzw.zzcQ().m15029r().m14985e();
        if (e != null && !e.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    aad.m8424c("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            xq g = xq.m14798g();
            if (g != null) {
                m14853a(context, e.values(), g);
            }
        }
    }

    static void m14853a(Context context, Collection<tr> collection, xq xqVar) {
        Map hashMap = new HashMap();
        C2309a a = C2312b.m7327a((Object) context);
        for (tr trVar : collection) {
            for (tq tqVar : trVar.f10787a) {
                String str = tqVar.f10779i;
                for (String str2 : tqVar.f10773c) {
                    String str22;
                    if (!hashMap.containsKey(str22)) {
                        hashMap.put(str22, new ArrayList());
                    }
                    if (str != null) {
                        ((Collection) hashMap.get(str22)).add(str);
                    }
                }
            }
        }
        for (Entry entry : hashMap.entrySet()) {
            String str3 = (String) entry.getKey();
            try {
                yj b = xqVar.m14803b(str3);
                if (b != null) {
                    uc a2 = b.m14914a();
                    if (!a2.mo4078g() && a2.mo4084m()) {
                        a2.mo4064a(a, b.m14915b(), (List) entry.getValue());
                        String str4 = "Initialized rewarded video mediation adapter ";
                        str22 = String.valueOf(str3);
                        aad.m8421b(str22.length() != 0 ? str4.concat(str22) : new String(str4));
                    }
                }
            } catch (Throwable th) {
                aad.m8424c(new StringBuilder(String.valueOf(str3).length() + 56).append("Failed to initialize rewarded video mediation adapter \"").append(str3).append("\"").toString(), th);
            }
        }
    }
}
