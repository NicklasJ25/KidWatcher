package com.google.android.gms.internal;

import android.util.Base64;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

class ks {
    private URI f9664a = null;
    private String f9665b = null;
    private String f9666c = null;
    private Map<String, String> f9667d = null;

    public ks(URI uri, String str, Map<String, String> map) {
        this.f9664a = uri;
        this.f9665b = str;
        this.f9667d = map;
        this.f9666c = m12239b();
    }

    private int m12237a(int i, int i2) {
        return (int) ((Math.random() * ((double) i2)) + ((double) i));
    }

    private String m12238a(LinkedHashMap<String, String> linkedHashMap) {
        String str = new String();
        String str2 = str;
        for (String str3 : linkedHashMap.keySet()) {
            String valueOf = String.valueOf(str2);
            str2 = (String) linkedHashMap.get(str3);
            str2 = new StringBuilder(((String.valueOf(valueOf).length() + 4) + String.valueOf(str3).length()) + String.valueOf(str2).length()).append(valueOf).append(str3).append(": ").append(str2).append("\r\n").toString();
        }
        return str2;
    }

    private String m12239b() {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) m12237a(0, 255);
        }
        return Base64.encodeToString(bArr, 2);
    }

    public void m12240a(String str) {
        int intValue = Integer.valueOf(str.substring(9, 12)).intValue();
        if (intValue == 407) {
            throw new kr("connection failed: proxy authentication not supported");
        } else if (intValue == 404) {
            throw new kr("connection failed: 404 not found");
        } else if (intValue != 101) {
            throw new kr("connection failed: unknown status code " + intValue);
        }
    }

    public void m12241a(HashMap<String, String> hashMap) {
        if (!((String) hashMap.get("Upgrade")).toLowerCase(Locale.US).equals("websocket")) {
            throw new kr("connection failed: missing header field in server handshake: Upgrade");
        } else if (!((String) hashMap.get("Connection")).toLowerCase(Locale.US).equals("upgrade")) {
            throw new kr("connection failed: missing header field in server handshake: Connection");
        }
    }

    public byte[] m12242a() {
        Object obj;
        String path = this.f9664a.getPath();
        String query = this.f9664a.getQuery();
        String valueOf = String.valueOf(path);
        if (query == null) {
            obj = "";
        } else {
            String str = "?";
            path = String.valueOf(query);
            obj = path.length() != 0 ? str.concat(path) : new String(str);
        }
        path = String.valueOf(obj);
        valueOf = path.length() != 0 ? valueOf.concat(path) : new String(valueOf);
        obj = this.f9664a.getHost();
        if (this.f9664a.getPort() != -1) {
            path = String.valueOf(obj);
            obj = new StringBuilder(String.valueOf(path).length() + 12).append(path).append(":").append(this.f9664a.getPort()).toString();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Host", obj);
        linkedHashMap.put("Upgrade", "websocket");
        linkedHashMap.put("Connection", "Upgrade");
        linkedHashMap.put("Sec-WebSocket-Version", "13");
        linkedHashMap.put("Sec-WebSocket-Key", this.f9666c);
        if (this.f9665b != null) {
            linkedHashMap.put("Sec-WebSocket-Protocol", this.f9665b);
        }
        if (this.f9667d != null) {
            for (String path2 : this.f9667d.keySet()) {
                if (!linkedHashMap.containsKey(path2)) {
                    linkedHashMap.put(path2, (String) this.f9667d.get(path2));
                }
            }
        }
        query = String.valueOf(new StringBuilder(String.valueOf(valueOf).length() + 15).append("GET ").append(valueOf).append(" HTTP/1.1\r\n").toString());
        path2 = String.valueOf(m12238a(linkedHashMap));
        path2 = String.valueOf(path2.length() != 0 ? query.concat(path2) : new String(query)).concat("\r\n");
        Object obj2 = new byte[path2.getBytes().length];
        System.arraycopy(path2.getBytes(), 0, obj2, 0, path2.getBytes().length);
        return obj2;
    }
}
