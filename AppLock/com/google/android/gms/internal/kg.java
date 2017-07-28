package com.google.android.gms.internal;

import com.google.android.gms.internal.fx.C2882a;
import com.google.firebase.database.C3537c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kg {
    public static int m12176a(js jsVar, kf kfVar, js jsVar2, kf kfVar2) {
        int compareTo = kfVar.compareTo(kfVar2);
        return compareTo != 0 ? compareTo : jsVar.m12009a(jsVar2);
    }

    public static kf m12177a(Object obj) {
        return m12178a(obj, kj.m12190a());
    }

    public static kf m12178a(Object obj, kf kfVar) {
        try {
            Map map;
            Object obj2;
            List list;
            Map hashMap;
            int i;
            String str;
            kf a;
            Map hashMap2;
            if (obj instanceof Map) {
                map = (Map) obj;
                if (map.containsKey(".priority")) {
                    kfVar = kj.m12191a(map.get(".priority"));
                }
                if (map.containsKey(".value")) {
                    obj2 = map.get(".value");
                    if (obj2 == null) {
                        return jx.m12080j();
                    }
                    if (obj2 instanceof String) {
                        return new kl((String) obj2, kfVar);
                    }
                    if (obj2 instanceof Long) {
                        return new kd((Long) obj2, kfVar);
                    }
                    if (obj2 instanceof Integer) {
                        return new kd(Long.valueOf((long) ((Integer) obj2).intValue()), kfVar);
                    }
                    if (obj2 instanceof Double) {
                        return new jw((Double) obj2, kfVar);
                    }
                    if (obj2 instanceof Boolean) {
                        return new jr((Boolean) obj2, kfVar);
                    }
                    if (!(obj2 instanceof Map) || (obj2 instanceof List)) {
                        if (obj2 instanceof Map) {
                            list = (List) obj2;
                            hashMap = new HashMap(list.size());
                            for (i = 0; i < list.size(); i++) {
                                str = i;
                                a = m12177a(list.get(i));
                                if (!a.mo3778b()) {
                                    hashMap.put(js.m12005a(str), a);
                                }
                            }
                            map = hashMap;
                        } else {
                            map = (Map) obj2;
                            if (map.containsKey(".sv")) {
                                return new jv(map, kfVar);
                            }
                            hashMap2 = new HashMap(map.size());
                            for (String str2 : map.keySet()) {
                                if (!str2.startsWith(".")) {
                                    a = m12177a(map.get(str2));
                                    if (!a.mo3778b()) {
                                        hashMap2.put(js.m12005a(str2), a);
                                    }
                                }
                            }
                            map = hashMap2;
                        }
                        return map.isEmpty() ? jx.m12080j() : new jt(C2882a.m10946a(map, jt.f9568a), kfVar);
                    } else {
                        String str3 = "Failed to parse node with class ";
                        String valueOf = String.valueOf(obj2.getClass().toString());
                        throw new C3537c(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    }
                }
            }
            obj2 = obj;
            if (obj2 == null) {
                return jx.m12080j();
            }
            if (obj2 instanceof String) {
                return new kl((String) obj2, kfVar);
            }
            if (obj2 instanceof Long) {
                return new kd((Long) obj2, kfVar);
            }
            if (obj2 instanceof Integer) {
                return new kd(Long.valueOf((long) ((Integer) obj2).intValue()), kfVar);
            }
            if (obj2 instanceof Double) {
                return new jw((Double) obj2, kfVar);
            }
            if (obj2 instanceof Boolean) {
                return new jr((Boolean) obj2, kfVar);
            }
            if (obj2 instanceof Map) {
            }
            if (obj2 instanceof Map) {
                list = (List) obj2;
                hashMap = new HashMap(list.size());
                for (i = 0; i < list.size(); i++) {
                    str = i;
                    a = m12177a(list.get(i));
                    if (!a.mo3778b()) {
                        hashMap.put(js.m12005a(str), a);
                    }
                }
                map = hashMap;
            } else {
                map = (Map) obj2;
                if (map.containsKey(".sv")) {
                    return new jv(map, kfVar);
                }
                hashMap2 = new HashMap(map.size());
                for (String str22 : map.keySet()) {
                    if (!str22.startsWith(".")) {
                        a = m12177a(map.get(str22));
                        if (!a.mo3778b()) {
                            hashMap2.put(js.m12005a(str22), a);
                        }
                    }
                }
                map = hashMap2;
            }
            if (map.isEmpty()) {
            }
        } catch (Throwable e) {
            throw new C3537c("Failed to parse node", e);
        }
    }
}
