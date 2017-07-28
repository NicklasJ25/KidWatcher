package com.google.android.gms.internal;

import java.util.Map;
import org.json.JSONObject;

@wh
public class mx implements mz {
    private final mv f9895a;
    private final tj f9896b;
    private final sc f9897c = new C30691(this);
    private final sc f9898d = new C30702(this);
    private final sc f9899e = new C30713(this);

    class C30691 implements sc {
        final /* synthetic */ mx f9892a;

        C30691(mx mxVar) {
            this.f9892a = mxVar;
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            this.f9892a.f9895a.m12663a(com_google_android_gms_internal_aat, (Map) map);
        }
    }

    class C30702 implements sc {
        final /* synthetic */ mx f9893a;

        C30702(mx mxVar) {
            this.f9893a = mxVar;
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            this.f9893a.f9895a.m12666a(this.f9893a, (Map) map);
        }
    }

    class C30713 implements sc {
        final /* synthetic */ mx f9894a;

        C30713(mx mxVar) {
            this.f9894a = mxVar;
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            this.f9894a.f9895a.m12672b((Map) map);
        }
    }

    public mx(mv mvVar, tj tjVar) {
        this.f9895a = mvVar;
        this.f9896b = tjVar;
        m12697a(this.f9896b);
        String str = "Custom JS tracking ad unit: ";
        String valueOf = String.valueOf(this.f9895a.m12689r().m12627d());
        aad.m8421b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    void m12697a(tj tjVar) {
        tjVar.mo3402a("/updateActiveView", this.f9897c);
        tjVar.mo3402a("/untrackActiveViewUnit", this.f9898d);
        tjVar.mo3402a("/visibilityChanged", this.f9899e);
    }

    public void mo3843a(JSONObject jSONObject, boolean z) {
        if (z) {
            this.f9895a.m12671b((mz) this);
        } else {
            this.f9896b.mo3385a("AFMA_updateActiveView", jSONObject);
        }
    }

    public boolean mo3844a() {
        return true;
    }

    public void mo3845b() {
        m12701b(this.f9896b);
    }

    void m12701b(tj tjVar) {
        tjVar.mo3409b("/visibilityChanged", this.f9899e);
        tjVar.mo3409b("/untrackActiveViewUnit", this.f9898d);
        tjVar.mo3409b("/updateActiveView", this.f9897c);
    }
}
