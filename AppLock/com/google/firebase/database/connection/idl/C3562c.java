package com.google.firebase.database.connection.idl;

import android.content.Context;
import com.google.android.gms.internal.gl;
import com.google.android.gms.internal.go;
import com.google.android.gms.internal.gp;
import com.google.android.gms.internal.gp.C2900a;
import com.google.android.gms.internal.gs;
import com.google.android.gms.p065a.C2312b;
import com.google.firebase.database.connection.idl.C3556g.C3557a;
import com.google.firebase.database.connection.idl.C3559j.C3560a;
import java.util.List;
import java.util.Map;

public class C3562c implements gp {
    private final C3552h f12166a;

    class C35612 extends C3560a {
        final /* synthetic */ gs f12165a;

        C35612(gs gsVar) {
            this.f12165a = gsVar;
        }

        public void mo4310a(String str, String str2) {
            this.f12165a.mo3707a(str, str2);
        }
    }

    private C3562c(C3552h c3552h) {
        this.f12166a = c3552h;
    }

    public static C3562c m15527a(Context context, zzc com_google_firebase_database_connection_idl_zzc, gl glVar, C2900a c2900a) {
        return new C3562c(IPersistentConnectionImpl.loadDynamic(context, com_google_firebase_database_connection_idl_zzc, glVar.m11067b(), glVar.m11068c(), c2900a));
    }

    private static C3559j m15528a(gs gsVar) {
        return new C35612(gsVar);
    }

    public void mo3669a() {
        try {
            this.f12166a.initialize();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo3673a(List<String> list, gs gsVar) {
        try {
            this.f12166a.onDisconnectCancel(list, C3562c.m15528a(gsVar));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo3674a(List<String> list, Object obj, gs gsVar) {
        try {
            this.f12166a.put(list, C2312b.m7327a(obj), C3562c.m15528a(gsVar));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo3675a(List<String> list, Object obj, String str, gs gsVar) {
        try {
            this.f12166a.compareAndPut(list, C2312b.m7327a(obj), str, C3562c.m15528a(gsVar));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo3676a(List<String> list, Map<String, Object> map) {
        try {
            this.f12166a.unlisten(list, C2312b.m7327a((Object) map));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo3677a(List<String> list, Map<String, Object> map, final go goVar, Long l, gs gsVar) {
        long longValue;
        C3556g c35581 = new C3557a(this) {
            public String mo4307a() {
                return goVar.mo3722a();
            }

            public boolean mo4308b() {
                return goVar.mo3724b();
            }

            public zza mo4309c() {
                return zza.m15565a(goVar.mo3725c());
            }
        };
        if (l != null) {
            try {
                longValue = l.longValue();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        longValue = -1;
        this.f12166a.listen(list, C2312b.m7327a((Object) map), c35581, longValue, C3562c.m15528a(gsVar));
    }

    public void mo3678a(List<String> list, Map<String, Object> map, gs gsVar) {
        try {
            this.f12166a.merge(list, C2312b.m7327a((Object) map), C3562c.m15528a(gsVar));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo3680b() {
        try {
            this.f12166a.shutdown();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo3682b(List<String> list, Object obj, gs gsVar) {
        try {
            this.f12166a.onDisconnectPut(list, C2312b.m7327a(obj), C3562c.m15528a(gsVar));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo3683b(List<String> list, Map<String, Object> map, gs gsVar) {
        try {
            this.f12166a.onDisconnectMerge(list, C2312b.m7327a((Object) map), C3562c.m15528a(gsVar));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo3684c() {
        try {
            this.f12166a.refreshAuthToken();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo3685c(String str) {
        try {
            this.f12166a.refreshAuthToken2(str);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo3686d() {
        try {
            this.f12166a.purgeOutstandingWrites();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo3687d(String str) {
        try {
            this.f12166a.interrupt(str);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void mo3688e(String str) {
        try {
            this.f12166a.resume(str);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public boolean mo3689f(String str) {
        try {
            return this.f12166a.isInterrupted(str);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
