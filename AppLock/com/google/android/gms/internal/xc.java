package com.google.android.gms.internal;

import com.google.android.gms.internal.ti.C3303c;
import java.util.Map;
import java.util.concurrent.Future;

@wh
public final class xc {
    C3303c f11313a;
    public final sc f11314b = new C34321(this);
    public final sc f11315c = new C34332(this);
    public final sc f11316d = new C34343(this);
    private final Object f11317e = new Object();
    private String f11318f;
    private String f11319g;
    private aag<xf> f11320h = new aag();

    class C34321 implements sc {
        final /* synthetic */ xc f11310a;

        C34321(xc xcVar) {
            this.f11310a = xcVar;
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            synchronized (this.f11310a.f11317e) {
                if (this.f11310a.f11320h.isDone()) {
                } else if (this.f11310a.f11318f.equals(map.get("request_id"))) {
                    Object xfVar = new xf(1, map);
                    String valueOf = String.valueOf(xfVar.m14753f());
                    String valueOf2 = String.valueOf(xfVar.m14749b());
                    aad.m8426e(new StringBuilder((String.valueOf(valueOf).length() + 24) + String.valueOf(valueOf2).length()).append("Invalid ").append(valueOf).append(" request error: ").append(valueOf2).toString());
                    this.f11310a.f11320h.m8436b(xfVar);
                }
            }
        }
    }

    class C34332 implements sc {
        final /* synthetic */ xc f11311a;

        C34332(xc xcVar) {
            this.f11311a = xcVar;
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            synchronized (this.f11311a.f11317e) {
                if (this.f11311a.f11320h.isDone()) {
                    return;
                }
                Object xfVar = new xf(-2, map);
                if (this.f11311a.f11318f.equals(xfVar.m14755h())) {
                    String e = xfVar.m14752e();
                    if (e == null) {
                        aad.m8426e("URL missing in loadAdUrl GMSG.");
                        return;
                    }
                    if (e.contains("%40mediation_adapters%40")) {
                        String replaceAll = e.replaceAll("%40mediation_adapters%40", zf.m15049a(com_google_android_gms_internal_aat.getContext(), (String) map.get("check_adapters"), this.f11311a.f11319g));
                        xfVar.m14748a(replaceAll);
                        e = "Ad request URL modified to ";
                        replaceAll = String.valueOf(replaceAll);
                        zh.m15051a(replaceAll.length() != 0 ? e.concat(replaceAll) : new String(e));
                    }
                    this.f11311a.f11320h.m8436b(xfVar);
                    return;
                }
            }
        }
    }

    class C34343 implements sc {
        final /* synthetic */ xc f11312a;

        C34343(xc xcVar) {
            this.f11312a = xcVar;
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            synchronized (this.f11312a.f11317e) {
                if (this.f11312a.f11320h.isDone()) {
                    return;
                }
                Object xfVar = new xf(-2, map);
                if (this.f11312a.f11318f.equals(xfVar.m14755h())) {
                    this.f11312a.f11320h.m8436b(xfVar);
                    return;
                }
            }
        }
    }

    public xc(String str, String str2) {
        this.f11319g = str2;
        this.f11318f = str;
    }

    public C3303c m14704a() {
        return this.f11313a;
    }

    public void m14705a(C3303c c3303c) {
        this.f11313a = c3303c;
    }

    public Future<xf> m14706b() {
        return this.f11320h;
    }
}
