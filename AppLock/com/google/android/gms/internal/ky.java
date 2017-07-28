package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class ky {
    public static String m12267a(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof String) {
            return JSONObject.quote((String) obj);
        }
        if (obj instanceof Number) {
            try {
                return JSONObject.numberToString((Number) obj);
            } catch (Throwable e) {
                throw new IOException("Could not serialize number", e);
            }
        } else if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? "true" : "false";
        } else {
            try {
                JSONStringer jSONStringer = new JSONStringer();
                m12272a(obj, jSONStringer);
                return jSONStringer.toString();
            } catch (Throwable e2) {
                throw new IOException("Failed to serialize JSON", e2);
            }
        }
    }

    public static String m12268a(Map<String, Object> map) {
        return m12267a((Object) map);
    }

    private static List<Object> m12269a(JSONArray jSONArray) {
        List<Object> arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m12273b(jSONArray.get(i)));
        }
        return arrayList;
    }

    public static Map<String, Object> m12270a(String str) {
        try {
            return m12271a(new JSONObject(str));
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }

    private static Map<String, Object> m12271a(JSONObject jSONObject) {
        Map<String, Object> hashMap = new HashMap(jSONObject.length());
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, m12273b(jSONObject.get(str)));
        }
        return hashMap;
    }

    private static void m12272a(Object obj, JSONStringer jSONStringer) {
        if (obj instanceof Map) {
            jSONStringer.object();
            for (Entry entry : ((Map) obj).entrySet()) {
                jSONStringer.key((String) entry.getKey());
                m12272a(entry.getValue(), jSONStringer);
            }
            jSONStringer.endObject();
        } else if (obj instanceof Collection) {
            Collection<Object> collection = (Collection) obj;
            jSONStringer.array();
            for (Object a : collection) {
                m12272a(a, jSONStringer);
            }
            jSONStringer.endArray();
        } else {
            jSONStringer.value(obj);
        }
    }

    private static Object m12273b(Object obj) {
        return obj instanceof JSONObject ? m12271a((JSONObject) obj) : obj instanceof JSONArray ? m12269a((JSONArray) obj) : obj.equals(JSONObject.NULL) ? null : obj;
    }

    public static Object m12274b(String str) {
        try {
            return m12273b(new JSONTokener(str).nextValue());
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }
}
