package com.google.firebase.database.connection.idl;

import android.content.Context;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.firebase_database.ModuleDescriptor;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gk;
import com.google.android.gms.internal.gk.C2899a;
import com.google.android.gms.internal.gl;
import com.google.android.gms.internal.go;
import com.google.android.gms.internal.gp;
import com.google.android.gms.internal.gp.C2900a;
import com.google.android.gms.internal.gq;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.jn;
import com.google.android.gms.p065a.C2309a;
import com.google.android.gms.p065a.C2312b;
import com.google.firebase.database.connection.idl.C3540i.C3541a;
import com.google.firebase.database.connection.idl.C3545e.C3546a;
import com.google.firebase.database.connection.idl.C3548f.C3549a;
import com.google.firebase.database.connection.idl.C3552h.C3553a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

@DynamiteApi
public class IPersistentConnectionImpl extends C3553a {
    private gp f12163a;

    class C35392 implements gs {
        final /* synthetic */ C3559j f12156a;

        C35392(C3559j c3559j) {
            this.f12156a = c3559j;
        }

        public void mo3707a(String str, String str2) {
            try {
                this.f12156a.mo4310a(str, str2);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    class C35423 extends C3541a {
        final /* synthetic */ C2900a f12157a;

        C35423(C2900a c2900a) {
            this.f12157a = c2900a;
        }

        public void mo4281a() {
            this.f12157a.mo3713a();
        }

        public void mo4282a(C2309a c2309a) {
            this.f12157a.mo3716a((Map) C2312b.m7328a(c2309a));
        }

        public void mo4283a(List<String> list, C2309a c2309a, boolean z, long j) {
            this.f12157a.mo3714a(list, C2312b.m7328a(c2309a), z, IPersistentConnectionImpl.m15510b(j));
        }

        public void mo4284a(List<String> list, List<zzn> list2, C2309a c2309a, long j) {
            List list3 = (List) C2312b.m7328a(c2309a);
            List arrayList = new ArrayList(list2.size());
            for (int i = 0; i < list2.size(); i++) {
                arrayList.add(zzn.m15570a((zzn) list2.get(i), list3.get(i)));
            }
            this.f12157a.mo3715a(list, arrayList, IPersistentConnectionImpl.m15510b(j));
        }

        public void mo4285a(boolean z) {
            this.f12157a.mo3717a(z);
        }

        public void mo4286b() {
            this.f12157a.mo3718b();
        }
    }

    class C35434 implements C2900a {
        final /* synthetic */ C3540i f12158a;

        C35434(C3540i c3540i) {
            this.f12158a = c3540i;
        }

        public void mo3713a() {
            try {
                this.f12158a.mo4281a();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void mo3714a(List<String> list, Object obj, boolean z, Long l) {
            try {
                this.f12158a.mo4283a((List) list, C2312b.m7327a(obj), z, IPersistentConnectionImpl.m15509b(l));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void mo3715a(List<String> list, List<gr> list2, Long l) {
            List arrayList = new ArrayList(list2.size());
            Object arrayList2 = new ArrayList(list2.size());
            for (gr grVar : list2) {
                arrayList.add(zzn.m15571a(grVar));
                arrayList2.add(grVar.m11212c());
            }
            try {
                this.f12158a.mo4284a((List) list, arrayList, C2312b.m7327a(arrayList2), IPersistentConnectionImpl.m15509b(l));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void mo3716a(Map<String, Object> map) {
            try {
                this.f12158a.mo4282a(C2312b.m7327a((Object) map));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void mo3717a(boolean z) {
            try {
                this.f12158a.mo4285a(z);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void mo3718b() {
            try {
                this.f12158a.mo4286b();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    class C35475 extends C3546a {
        final /* synthetic */ gk f12160a;

        C35475(gk gkVar) {
            this.f12160a = gkVar;
        }

        public void mo4287a(boolean z, final C3548f c3548f) {
            this.f12160a.mo3699a(z, new C2899a(this) {
                public void mo3666a(String str) {
                    try {
                        c3548f.mo4288a(str);
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                }

                public void mo3667b(String str) {
                    try {
                        c3548f.mo4289b(str);
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }

    class C35516 implements gk {
        final /* synthetic */ C3545e f12162a;

        C35516(C3545e c3545e) {
            this.f12162a = c3545e;
        }

        public void mo3699a(boolean z, final C2899a c2899a) {
            try {
                this.f12162a.mo4287a(z, new C3549a(this) {
                    public void mo4288a(String str) {
                        c2899a.mo3666a(str);
                    }

                    public void mo4289b(String str) {
                        c2899a.mo3667b(str);
                    }
                });
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static gk m15503a(C3545e c3545e) {
        return new C35516(c3545e);
    }

    private static C2900a m15504a(C3540i c3540i) {
        return new C35434(c3540i);
    }

    private static gs m15505a(C3559j c3559j) {
        return new C35392(c3559j);
    }

    private static C3545e m15506a(gk gkVar) {
        return new C35475(gkVar);
    }

    private static C3540i m15507a(C2900a c2900a) {
        return new C35423(c2900a);
    }

    private static long m15509b(Long l) {
        if (l == null) {
            return -1;
        }
        if (l.longValue() != -1) {
            return l.longValue();
        }
        throw new IllegalArgumentException("Tag parameter clashed with NO_TAG value");
    }

    private static Long m15510b(long j) {
        return j == -1 ? null : Long.valueOf(j);
    }

    public static C3552h loadDynamic(Context context, zzc com_google_firebase_database_connection_idl_zzc, gk gkVar, ScheduledExecutorService scheduledExecutorService, C2900a c2900a) {
        try {
            C3552h asInterface = C3553a.asInterface(DynamiteModule.m8341a(context, DynamiteModule.f7577d, ModuleDescriptor.MODULE_ID).m8353a("com.google.firebase.database.connection.idl.IPersistentConnectionImpl"));
            asInterface.setup(com_google_firebase_database_connection_idl_zzc, m15506a(gkVar), C2312b.m7327a((Object) scheduledExecutorService), m15507a(c2900a));
            return asInterface;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    public void compareAndPut(List<String> list, C2309a c2309a, String str, C3559j c3559j) {
        this.f12163a.mo3675a(list, C2312b.m7328a(c2309a), str, m15505a(c3559j));
    }

    public void initialize() {
        this.f12163a.mo3669a();
    }

    public void interrupt(String str) {
        this.f12163a.mo3687d(str);
    }

    public boolean isInterrupted(String str) {
        return this.f12163a.mo3689f(str);
    }

    public void listen(List<String> list, C2309a c2309a, final C3556g c3556g, long j, C3559j c3559j) {
        Long b = m15510b(j);
        List<String> list2 = list;
        this.f12163a.mo3677a(list2, (Map) C2312b.m7328a(c2309a), new go(this) {
            public String mo3722a() {
                try {
                    return c3556g.mo4307a();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }

            public boolean mo3724b() {
                try {
                    return c3556g.mo4308b();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }

            public gi mo3725c() {
                try {
                    return zza.m15564a(c3556g.mo4309c());
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }, b, m15505a(c3559j));
    }

    public void merge(List<String> list, C2309a c2309a, C3559j c3559j) {
        this.f12163a.mo3678a((List) list, (Map) C2312b.m7328a(c2309a), m15505a(c3559j));
    }

    public void onDisconnectCancel(List<String> list, C3559j c3559j) {
        this.f12163a.mo3673a((List) list, m15505a(c3559j));
    }

    public void onDisconnectMerge(List<String> list, C2309a c2309a, C3559j c3559j) {
        this.f12163a.mo3683b((List) list, (Map) C2312b.m7328a(c2309a), m15505a(c3559j));
    }

    public void onDisconnectPut(List<String> list, C2309a c2309a, C3559j c3559j) {
        this.f12163a.mo3682b((List) list, C2312b.m7328a(c2309a), m15505a(c3559j));
    }

    public void purgeOutstandingWrites() {
        this.f12163a.mo3686d();
    }

    public void put(List<String> list, C2309a c2309a, C3559j c3559j) {
        this.f12163a.mo3674a((List) list, C2312b.m7328a(c2309a), m15505a(c3559j));
    }

    public void refreshAuthToken() {
        this.f12163a.mo3684c();
    }

    public void refreshAuthToken2(String str) {
        this.f12163a.mo3685c(str);
    }

    public void resume(String str) {
        this.f12163a.mo3688e(str);
    }

    public void setup(zzc com_google_firebase_database_connection_idl_zzc, C3545e c3545e, C2309a c2309a, C3540i c3540i) {
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) C2312b.m7328a(c2309a);
        this.f12163a = new gq(new gl(new jn(com_google_firebase_database_connection_idl_zzc.m15566a(), com_google_firebase_database_connection_idl_zzc.m15567b()), m15503a(c3545e), scheduledExecutorService, com_google_firebase_database_connection_idl_zzc.f12179d, com_google_firebase_database_connection_idl_zzc.f12180e, com_google_firebase_database_connection_idl_zzc.f12181f), zzf.m15568a(com_google_firebase_database_connection_idl_zzc.f12176a), m15504a(c3540i));
    }

    public void shutdown() {
        this.f12163a.mo3680b();
    }

    public void unlisten(List<String> list, C2309a c2309a) {
        this.f12163a.mo3676a((List) list, (Map) C2312b.m7328a(c2309a));
    }
}
