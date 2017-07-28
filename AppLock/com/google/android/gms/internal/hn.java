package com.google.android.gms.internal;

import com.google.android.gms.internal.hp.C2941b;
import com.google.android.gms.internal.jt.C2958a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class hn {

    class C29571 implements C2941b {
        final /* synthetic */ hp f9287a;
        final /* synthetic */ Map f9288b;

        C29571(hp hpVar, Map map) {
            this.f9287a = hpVar;
            this.f9288b = map;
        }

        public void mo3710a(hh hhVar, kf kfVar) {
            this.f9287a.m11501a(hhVar, hn.m11492a(kfVar, this.f9288b));
        }
    }

    class C29592 extends C2958a {
        final /* synthetic */ Map f9289a;
        final /* synthetic */ ho f9290b;

        C29592(Map map, ho hoVar) {
            this.f9289a = map;
            this.f9290b = hoVar;
        }

        public void mo3720a(js jsVar, kf kfVar) {
            kf a = hn.m11492a(kfVar, this.f9289a);
            if (a != kfVar) {
                this.f9290b.m11497a(new hh(jsVar.m12010d()), a);
            }
        }
    }

    public static gx m11490a(gx gxVar, Map<String, Object> map) {
        gx a = gx.m11275a();
        Iterator it = gxVar.iterator();
        gx gxVar2 = a;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            gxVar2 = gxVar2.m11281a((hh) entry.getKey(), m11492a((kf) entry.getValue(), (Map) map));
        }
        return gxVar2;
    }

    public static hp m11491a(hp hpVar, Map<String, Object> map) {
        hp hpVar2 = new hp();
        hpVar.m11500a(new hh(""), new C29571(hpVar2, map));
        return hpVar2;
    }

    public static kf m11492a(kf kfVar, Map<String, Object> map) {
        Object a = kfVar.mo3783f().mo3786a();
        if (a instanceof Map) {
            Map map2 = (Map) a;
            if (map2.containsKey(".sv")) {
                a = map.get((String) map2.get(".sv"));
            }
        }
        kf a2 = kj.m12191a(a);
        if (kfVar.mo3782e()) {
            a = m11493a(kfVar.mo3786a(), (Map) map);
            return (a.equals(kfVar.mo3786a()) && a2.equals(kfVar.mo3783f())) ? kfVar : kg.m12178a(a, a2);
        } else if (kfVar.mo3778b()) {
            return kfVar;
        } else {
            jt jtVar = (jt) kfVar;
            ho hoVar = new ho(jtVar);
            jtVar.m12029a(new C29592(map, hoVar));
            return !hoVar.m11495a().mo3783f().equals(a2) ? hoVar.m11495a().mo3788b(a2) : hoVar.m11495a();
        }
    }

    public static Object m11493a(Object obj, Map<String, Object> map) {
        if (!(obj instanceof Map)) {
            return obj;
        }
        Map map2 = (Map) obj;
        if (!map2.containsKey(".sv")) {
            return obj;
        }
        String str = (String) map2.get(".sv");
        return map.containsKey(str) ? map.get(str) : obj;
    }

    public static Map<String, Object> m11494a(kz kzVar) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("timestamp", Long.valueOf(kzVar.mo3817a()));
        return hashMap;
    }
}
