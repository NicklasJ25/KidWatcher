package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.internal.aam.C2380c;
import com.google.android.gms.internal.aam.C2637a;
import com.google.android.gms.internal.aam.C2638b;
import com.google.android.gms.internal.ti.C3303c;
import java.util.Map;
import org.json.JSONObject;

@wh
public class my implements mz {
    private final mv f9908a;
    private C3303c f9909b;
    private boolean f9910c;
    private final sc f9911d = new C30765(this);
    private final sc f9912e = new C30776(this);
    private final sc f9913f = new C30787(this);
    private final sc f9914g = new C30798(this);

    class C30721 implements C2380c<tj> {
        final /* synthetic */ my f9900a;

        C30721(my myVar) {
            this.f9900a = myVar;
        }

        public void m12702a(tj tjVar) {
            this.f9900a.f9910c = true;
            this.f9900a.m12715a(tjVar);
        }

        public /* synthetic */ void mo3272a(Object obj) {
            m12702a((tj) obj);
        }
    }

    class C30732 implements C2637a {
        final /* synthetic */ my f9901a;

        C30732(my myVar) {
            this.f9901a = myVar;
        }

        public void mo3379a() {
            this.f9901a.f9908a.m12671b(this.f9901a);
        }
    }

    class C30754 implements C2380c<tj> {
        final /* synthetic */ my f9903a;

        C30754(my myVar) {
            this.f9903a = myVar;
        }

        public void m12707a(tj tjVar) {
            this.f9903a.m12719b(tjVar);
        }

        public /* synthetic */ void mo3272a(Object obj) {
            m12707a((tj) obj);
        }
    }

    class C30765 implements sc {
        final /* synthetic */ my f9904a;

        C30765(my myVar) {
            this.f9904a = myVar;
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            if (this.f9904a.f9908a.m12669a((Map) map)) {
                this.f9904a.f9908a.m12663a(com_google_android_gms_internal_aat, (Map) map);
            }
        }
    }

    class C30776 implements sc {
        final /* synthetic */ my f9905a;

        C30776(my myVar) {
            this.f9905a = myVar;
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            if (this.f9905a.f9908a.m12669a((Map) map)) {
                this.f9905a.f9908a.m12666a(this.f9905a, (Map) map);
            }
        }
    }

    class C30787 implements sc {
        final /* synthetic */ my f9906a;

        C30787(my myVar) {
            this.f9906a = myVar;
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            if (this.f9906a.f9908a.m12669a((Map) map)) {
                this.f9906a.f9908a.m12672b((Map) map);
            }
        }
    }

    class C30798 implements sc {
        final /* synthetic */ my f9907a;

        C30798(my myVar) {
            this.f9907a = myVar;
        }

        public void mo3260a(aat com_google_android_gms_internal_aat, Map<String, String> map) {
            if (this.f9907a.f9908a.m12669a((Map) map)) {
                sb.f10543p.mo3260a(com_google_android_gms_internal_aat, map);
            }
        }
    }

    public my(mv mvVar, ti tiVar) {
        this.f9908a = mvVar;
        this.f9909b = tiVar.m13966a();
        this.f9909b.mo3380a(new C30721(this), new C30732(this));
        String str = "Core JS tracking ad unit: ";
        String valueOf = String.valueOf(this.f9908a.m12689r().m12627d());
        aad.m8421b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    void m12715a(tj tjVar) {
        tjVar.mo3402a("/updateActiveView", this.f9911d);
        tjVar.mo3402a("/untrackActiveViewUnit", this.f9912e);
        tjVar.mo3402a("/visibilityChanged", this.f9913f);
        if (zzw.zzdl().m14943a()) {
            tjVar.mo3402a("/logScionEvent", this.f9914g);
        }
    }

    public void mo3843a(final JSONObject jSONObject, boolean z) {
        this.f9909b.mo3380a(new C2380c<tj>(this) {
            public void m12705a(tj tjVar) {
                tjVar.mo3385a("AFMA_updateActiveView", jSONObject);
            }

            public /* synthetic */ void mo3272a(Object obj) {
                m12705a((tj) obj);
            }
        }, new C2638b());
    }

    public boolean mo3844a() {
        return this.f9910c;
    }

    public void mo3845b() {
        this.f9909b.mo3380a(new C30754(this), new C2638b());
        this.f9909b.g_();
    }

    void m12719b(tj tjVar) {
        tjVar.mo3409b("/visibilityChanged", this.f9913f);
        tjVar.mo3409b("/untrackActiveViewUnit", this.f9912e);
        tjVar.mo3409b("/updateActiveView", this.f9911d);
        if (zzw.zzdl().m14943a()) {
            tjVar.mo3409b("/logScionEvent", this.f9914g);
        }
    }
}
