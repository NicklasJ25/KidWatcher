package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.yd.C3451a;
import com.google.android.gms.internal.yy.C3457a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

@wh
public class yi extends zg implements yh {
    private final C3457a f11486a;
    private final Context f11487b;
    private final ArrayList<Future> f11488c;
    private final ArrayList<String> f11489d;
    private final HashMap<String, yc> f11490e;
    private final List<yd> f11491f;
    private final HashSet<String> f11492g;
    private final Object f11493h;
    private final xq f11494i;
    private final long f11495j;

    public yi(Context context, C3457a c3457a, xq xqVar) {
        this(context, c3457a, xqVar, ((Long) qb.aI.m13225c()).longValue());
    }

    yi(Context context, C3457a c3457a, xq xqVar, long j) {
        this.f11488c = new ArrayList();
        this.f11489d = new ArrayList();
        this.f11490e = new HashMap();
        this.f11491f = new ArrayList();
        this.f11492g = new HashSet();
        this.f11493h = new Object();
        this.f11487b = context;
        this.f11486a = c3457a;
        this.f11494i = xqVar;
        this.f11495j = j;
    }

    private static int m14903a(int i) {
        switch (i) {
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 4;
            case 6:
                return 0;
            case 7:
                return 3;
            default:
                return 6;
        }
    }

    private yy m14905a() {
        return m14906a(3, null, null);
    }

    private yy m14906a(int i, @Nullable String str, @Nullable tq tqVar) {
        return new yy(this.f11486a.f11509a.f11994c, null, this.f11486a.f11510b.f12038d, i, this.f11486a.f11510b.f12040f, this.f11486a.f11510b.f12044j, this.f11486a.f11510b.f12046l, this.f11486a.f11510b.f12045k, this.f11486a.f11509a.f12000i, this.f11486a.f11510b.f12042h, tqVar, null, str, this.f11486a.f11511c, null, this.f11486a.f11510b.f12043i, this.f11486a.f11512d, this.f11486a.f11510b.f12041g, this.f11486a.f11514f, this.f11486a.f11510b.f12048n, this.f11486a.f11510b.f12049o, this.f11486a.f11516h, null, this.f11486a.f11510b.f12020C, this.f11486a.f11510b.f12021D, this.f11486a.f11510b.f12022E, this.f11486a.f11510b.f12023F, this.f11486a.f11510b.f12024G, m14910b(), this.f11486a.f11510b.f12027J, this.f11486a.f11510b.f12031N);
    }

    private yy m14907a(String str, tq tqVar) {
        return m14906a(-2, str, tqVar);
    }

    private static String m14908a(yd ydVar) {
        String str = ydVar.f11476b;
        int a = m14903a(ydVar.f11477c);
        return new StringBuilder(String.valueOf(str).length() + 33).append(str).append(".").append(a).append(".").append(ydVar.f11478d).toString();
    }

    private void m14909a(String str, String str2, tq tqVar) {
        synchronized (this.f11493h) {
            yj b = this.f11494i.m14803b(str);
            if (b == null || b.m14915b() == null || b.m14914a() == null) {
                this.f11491f.add(new C3451a().m14879b(tqVar.f10774d).m14877a(str).m14876a(0).m14875a(7).m14878a());
                return;
            }
            zg a = m14911a(str, str2, tqVar, b);
            this.f11488c.add((Future) a.zziP());
            this.f11489d.add(str);
            this.f11490e.put(str, a);
        }
    }

    private String m14910b() {
        StringBuilder stringBuilder = new StringBuilder("");
        if (this.f11491f == null) {
            return stringBuilder.toString();
        }
        for (yd ydVar : this.f11491f) {
            if (!(ydVar == null || TextUtils.isEmpty(ydVar.f11476b))) {
                stringBuilder.append(String.valueOf(m14908a(ydVar)).concat("_"));
            }
        }
        return stringBuilder.substring(0, Math.max(0, stringBuilder.length() - 1));
    }

    protected yc m14911a(String str, String str2, tq tqVar, yj yjVar) {
        return new yc(this.f11487b, str, str2, tqVar, this.f11486a, yjVar, this, this.f11495j);
    }

    public void mo4220a(String str) {
        synchronized (this.f11493h) {
            this.f11492g.add(str);
        }
    }

    public void mo4221a(String str, int i) {
    }

    public void onStop() {
    }

    public void zzco() {
        yc ycVar;
        final yy a;
        for (tq tqVar : this.f11486a.f11511c.f10787a) {
            String str = tqVar.f10779i;
            for (String str2 : tqVar.f10773c) {
                String str22;
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str22) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str22)) {
                    try {
                        str22 = new JSONObject(str).getString("class_name");
                    } catch (Throwable e) {
                        aad.m8422b("Unable to determine custom event class name, skipping...", e);
                    }
                }
                m14909a(str22, str, tqVar);
            }
        }
        int i = 0;
        while (i < this.f11488c.size()) {
            String str3;
            try {
                ((Future) this.f11488c.get(i)).get();
                synchronized (this.f11493h) {
                    str3 = (String) this.f11489d.get(i);
                    if (!TextUtils.isEmpty(str3)) {
                        ycVar = (yc) this.f11490e.get(str3);
                        if (ycVar != null) {
                            this.f11491f.add(ycVar.m14864a());
                        }
                    }
                }
                synchronized (this.f11493h) {
                    if (this.f11492g.contains(this.f11489d.get(i))) {
                        str3 = (String) this.f11489d.get(i);
                        a = m14907a(str3, this.f11490e.get(str3) != null ? ((yc) this.f11490e.get(str3)).m14869b() : null);
                        aac.f7622a.post(new Runnable(this) {
                            final /* synthetic */ yi f11483b;

                            public void run() {
                                this.f11483b.f11494i.zzb(a);
                            }
                        });
                        return;
                    }
                }
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                synchronized (this.f11493h) {
                    str3 = (String) this.f11489d.get(i);
                    if (!TextUtils.isEmpty(str3)) {
                        ycVar = (yc) this.f11490e.get(str3);
                        if (ycVar != null) {
                            this.f11491f.add(ycVar.m14864a());
                        }
                    }
                }
            } catch (Throwable e3) {
                aad.m8424c("Unable to resolve rewarded adapter.", e3);
                synchronized (this.f11493h) {
                    str3 = (String) this.f11489d.get(i);
                    if (!TextUtils.isEmpty(str3)) {
                        ycVar = (yc) this.f11490e.get(str3);
                        if (ycVar != null) {
                            this.f11491f.add(ycVar.m14864a());
                        }
                    }
                }
            } catch (Throwable e32) {
                Throwable th = e32;
                synchronized (this.f11493h) {
                    str3 = (String) this.f11489d.get(i);
                    if (!TextUtils.isEmpty(str3)) {
                        ycVar = (yc) this.f11490e.get(str3);
                        if (ycVar != null) {
                            this.f11491f.add(ycVar.m14864a());
                        }
                    }
                }
            }
        }
        a = m14905a();
        aac.f7622a.post(new Runnable(this) {
            final /* synthetic */ yi f11485b;

            public void run() {
                this.f11485b.f11494i.zzb(a);
            }
        });
        return;
        i++;
    }
}
