package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.internal.mv.C3065a;
import com.google.android.gms.internal.mv.C3068d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@wh
public class mu implements mw {
    private final Object f9859a = new Object();
    private final WeakHashMap<yy, mv> f9860b = new WeakHashMap();
    private final ArrayList<mv> f9861c = new ArrayList();
    private final Context f9862d;
    private final zzqh f9863e;
    private final ti f9864f;

    public mu(Context context, zzqh com_google_android_gms_internal_zzqh, ti tiVar) {
        this.f9862d = context.getApplicationContext();
        this.f9863e = com_google_android_gms_internal_zzqh;
        this.f9864f = tiVar;
    }

    public void mo3839a(mv mvVar) {
        synchronized (this.f9859a) {
            if (!mvVar.m12677f()) {
                this.f9861c.remove(mvVar);
                Iterator it = this.f9860b.entrySet().iterator();
                while (it.hasNext()) {
                    if (((Entry) it.next()).getValue() == mvVar) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void m12632a(zzeg com_google_android_gms_internal_zzeg, yy yyVar) {
        m12633a(com_google_android_gms_internal_zzeg, yyVar, yyVar.f11527b.mo3405b());
    }

    public void m12633a(zzeg com_google_android_gms_internal_zzeg, yy yyVar, View view) {
        m12635a(com_google_android_gms_internal_zzeg, yyVar, new C3068d(view, yyVar), null);
    }

    public void m12634a(zzeg com_google_android_gms_internal_zzeg, yy yyVar, View view, tj tjVar) {
        m12635a(com_google_android_gms_internal_zzeg, yyVar, new C3068d(view, yyVar), tjVar);
    }

    public void m12635a(zzeg com_google_android_gms_internal_zzeg, yy yyVar, nd ndVar, @Nullable tj tjVar) {
        synchronized (this.f9859a) {
            mv mvVar;
            if (m12637a(yyVar)) {
                mvVar = (mv) this.f9860b.get(yyVar);
            } else {
                mvVar = new mv(this.f9862d, com_google_android_gms_internal_zzeg, yyVar, this.f9863e, ndVar);
                mvVar.m12664a((mw) this);
                this.f9860b.put(yyVar, mvVar);
                this.f9861c.add(mvVar);
            }
            if (tjVar != null) {
                mvVar.m12665a(new mx(mvVar, tjVar));
            } else {
                mvVar.m12665a(new my(mvVar, this.f9864f));
            }
        }
    }

    public void m12636a(zzeg com_google_android_gms_internal_zzeg, yy yyVar, qz qzVar) {
        m12635a(com_google_android_gms_internal_zzeg, yyVar, new C3065a(qzVar), null);
    }

    public boolean m12637a(yy yyVar) {
        boolean z;
        synchronized (this.f9859a) {
            mv mvVar = (mv) this.f9860b.get(yyVar);
            z = mvVar != null && mvVar.m12677f();
        }
        return z;
    }

    public void m12638b(yy yyVar) {
        synchronized (this.f9859a) {
            mv mvVar = (mv) this.f9860b.get(yyVar);
            if (mvVar != null) {
                mvVar.m12675d();
            }
        }
    }

    public void m12639c(yy yyVar) {
        synchronized (this.f9859a) {
            mv mvVar = (mv) this.f9860b.get(yyVar);
            if (mvVar != null) {
                mvVar.m12686o();
            }
        }
    }

    public void m12640d(yy yyVar) {
        synchronized (this.f9859a) {
            mv mvVar = (mv) this.f9860b.get(yyVar);
            if (mvVar != null) {
                mvVar.m12687p();
            }
        }
    }

    public void m12641e(yy yyVar) {
        synchronized (this.f9859a) {
            mv mvVar = (mv) this.f9860b.get(yyVar);
            if (mvVar != null) {
                mvVar.m12688q();
            }
        }
    }
}
