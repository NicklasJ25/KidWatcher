package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@wh
public class qj {
    boolean f10337a;
    private final List<qh> f10338b = new LinkedList();
    private final Map<String, String> f10339c = new LinkedHashMap();
    private final Object f10340d = new Object();
    private String f10341e;
    private qh f10342f;
    @Nullable
    private qj f10343g;

    public qj(boolean z, String str, String str2) {
        this.f10337a = z;
        this.f10339c.put("action", str);
        this.f10339c.put("ad_format", str2);
    }

    public qh m13301a() {
        return m13302a(zzw.zzcS().mo3361b());
    }

    @Nullable
    public qh m13302a(long j) {
        return !this.f10337a ? null : new qh(j, null, null);
    }

    public void m13303a(@Nullable qj qjVar) {
        synchronized (this.f10340d) {
            this.f10343g = qjVar;
        }
    }

    public void m13304a(String str) {
        if (this.f10337a) {
            synchronized (this.f10340d) {
                this.f10341e = str;
            }
        }
    }

    public void m13305a(String str, String str2) {
        if (this.f10337a && !TextUtils.isEmpty(str2)) {
            qd f = zzw.zzcQ().m15017f();
            if (f != null) {
                synchronized (this.f10340d) {
                    f.m13279a(str).m13290a(this.f10339c, str, str2);
                }
            }
        }
    }

    public boolean m13306a(qh qhVar, long j, String... strArr) {
        synchronized (this.f10340d) {
            for (String qhVar2 : strArr) {
                this.f10338b.add(new qh(j, qhVar2, qhVar));
            }
        }
        return true;
    }

    public boolean m13307a(@Nullable qh qhVar, String... strArr) {
        return (!this.f10337a || qhVar == null) ? false : m13306a(qhVar, zzw.zzcS().mo3361b(), strArr);
    }

    public void m13308b() {
        synchronized (this.f10340d) {
            this.f10342f = m13301a();
        }
    }

    public String m13309c() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        synchronized (this.f10340d) {
            for (qh qhVar : this.f10338b) {
                long a = qhVar.m13295a();
                String b = qhVar.m13296b();
                qh qhVar2 = qhVar2.m13297c();
                if (qhVar2 != null && a > 0) {
                    stringBuilder2.append(b).append('.').append(a - qhVar2.m13295a()).append(',');
                }
            }
            this.f10338b.clear();
            if (!TextUtils.isEmpty(this.f10341e)) {
                stringBuilder2.append(this.f10341e);
            } else if (stringBuilder2.length() > 0) {
                stringBuilder2.setLength(stringBuilder2.length() - 1);
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }

    Map<String, String> m13310d() {
        Map<String, String> map;
        synchronized (this.f10340d) {
            qd f = zzw.zzcQ().m15017f();
            if (f == null || this.f10343g == null) {
                map = this.f10339c;
            } else {
                map = f.m13281a(this.f10339c, this.f10343g.m13310d());
            }
        }
        return map;
    }

    public qh m13311e() {
        qh qhVar;
        synchronized (this.f10340d) {
            qhVar = this.f10342f;
        }
        return qhVar;
    }
}
