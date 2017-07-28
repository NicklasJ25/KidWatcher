package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@wh
public class sd implements sc {
    private final Context f10568a;
    private final zzqh f10569b;

    @wh
    static class C3235a {
        private final String f10555a;
        private final String f10556b;

        public C3235a(String str, String str2) {
            this.f10555a = str;
            this.f10556b = str2;
        }

        public String m13696a() {
            return this.f10555a;
        }

        public String m13697b() {
            return this.f10556b;
        }
    }

    @wh
    static class C3236b {
        private final String f10557a;
        private final URL f10558b;
        private final ArrayList<C3235a> f10559c;
        private final String f10560d;

        public C3236b(String str, URL url, ArrayList<C3235a> arrayList, String str2) {
            this.f10557a = str;
            this.f10558b = url;
            if (arrayList == null) {
                this.f10559c = new ArrayList();
            } else {
                this.f10559c = arrayList;
            }
            this.f10560d = str2;
        }

        public String m13698a() {
            return this.f10557a;
        }

        public URL m13699b() {
            return this.f10558b;
        }

        public ArrayList<C3235a> m13700c() {
            return this.f10559c;
        }

        public String m13701d() {
            return this.f10560d;
        }
    }

    @wh
    class C3237c {
        private final C3238d f10561a;
        private final boolean f10562b;
        private final String f10563c;

        public C3237c(sd sdVar, boolean z, C3238d c3238d, String str) {
            this.f10562b = z;
            this.f10561a = c3238d;
            this.f10563c = str;
        }

        public String m13702a() {
            return this.f10563c;
        }

        public C3238d m13703b() {
            return this.f10561a;
        }

        public boolean m13704c() {
            return this.f10562b;
        }
    }

    @wh
    static class C3238d {
        private final String f10564a;
        private final int f10565b;
        private final List<C3235a> f10566c;
        private final String f10567d;

        public C3238d(String str, int i, List<C3235a> list, String str2) {
            this.f10564a = str;
            this.f10565b = i;
            if (list == null) {
                this.f10566c = new ArrayList();
            } else {
                this.f10566c = list;
            }
            this.f10567d = str2;
        }

        public String m13705a() {
            return this.f10564a;
        }

        public int m13706b() {
            return this.f10565b;
        }

        public Iterable<C3235a> m13707c() {
            return this.f10566c;
        }

        public String m13708d() {
            return this.f10567d;
        }
    }

    public sd(Context context, zzqh com_google_android_gms_internal_zzqh) {
        this.f10568a = context;
        this.f10569b = com_google_android_gms_internal_zzqh;
    }

    protected C3236b m13709a(JSONObject jSONObject) {
        URL url;
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString("url");
        String optString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(optString2);
        } catch (Throwable e) {
            aad.m8422b("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new C3235a(optJSONObject.optString("key"), optJSONObject.optString("value")));
            }
        }
        return new C3236b(optString, url, arrayList, optString3);
    }

    protected C3237c m13710a(C3236b c3236b) {
        Exception e;
        HttpURLConnection httpURLConnection;
        C3237c c3237c;
        Throwable th;
        HttpURLConnection httpURLConnection2 = null;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) c3236b.m13699b().openConnection();
            try {
                zzw.zzcM().m15122a(this.f10568a, this.f10569b.f12081a, false, httpURLConnection3);
                Iterator it = c3236b.m13700c().iterator();
                while (it.hasNext()) {
                    C3235a c3235a = (C3235a) it.next();
                    httpURLConnection3.addRequestProperty(c3235a.m13696a(), c3235a.m13697b());
                }
                if (!TextUtils.isEmpty(c3236b.m13701d())) {
                    httpURLConnection3.setDoOutput(true);
                    byte[] bytes = c3236b.m13701d().getBytes();
                    httpURLConnection3.setFixedLengthStreamingMode(bytes.length);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection3.getOutputStream());
                    bufferedOutputStream.write(bytes);
                    bufferedOutputStream.close();
                }
                List arrayList = new ArrayList();
                if (httpURLConnection3.getHeaderFields() != null) {
                    for (Entry entry : httpURLConnection3.getHeaderFields().entrySet()) {
                        for (String c3235a2 : (List) entry.getValue()) {
                            arrayList.add(new C3235a((String) entry.getKey(), c3235a2));
                        }
                    }
                }
                C3237c c3237c2 = new C3237c(this, true, new C3238d(c3236b.m13698a(), httpURLConnection3.getResponseCode(), arrayList, zzw.zzcM().m15108a(new InputStreamReader(httpURLConnection3.getInputStream()))), null);
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                return c3237c2;
            } catch (Exception e2) {
                e = e2;
                httpURLConnection = httpURLConnection3;
                try {
                    c3237c = new C3237c(this, false, null, e.toString());
                    if (httpURLConnection != null) {
                        return c3237c;
                    }
                    httpURLConnection.disconnect();
                    return c3237c;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                httpURLConnection2 = httpURLConnection3;
                th = th4;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e3) {
            httpURLConnection = null;
            e = e3;
            c3237c = new C3237c(this, false, null, e.toString());
            if (httpURLConnection != null) {
                return c3237c;
            }
            httpURLConnection.disconnect();
            return c3237c;
        } catch (Throwable th5) {
            th = th5;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    protected JSONObject m13711a(C3238d c3238d) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", c3238d.m13705a());
            if (c3238d.m13708d() != null) {
                jSONObject.put("body", c3238d.m13708d());
            }
            JSONArray jSONArray = new JSONArray();
            for (C3235a c3235a : c3238d.m13707c()) {
                jSONArray.put(new JSONObject().put("key", c3235a.m13696a()).put("value", c3235a.m13697b()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", c3238d.m13706b());
        } catch (Throwable e) {
            aad.m8422b("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    public JSONObject m13712a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            Object obj = "";
            try {
                obj = jSONObject.optString("http_request_id");
                C3237c a = m13710a(m13709a(jSONObject));
                if (a.m13704c()) {
                    jSONObject2.put("response", m13711a(a.m13703b()));
                    jSONObject2.put("success", true);
                    return jSONObject2;
                }
                jSONObject2.put("response", new JSONObject().put("http_request_id", obj));
                jSONObject2.put("success", false);
                jSONObject2.put("reason", a.m13702a());
                return jSONObject2;
            } catch (Exception e) {
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", obj));
                    jSONObject2.put("success", false);
                    jSONObject2.put("reason", e.toString());
                    return jSONObject2;
                } catch (JSONException e2) {
                    return jSONObject2;
                }
            }
        } catch (JSONException e3) {
            aad.m8423c("The request is not a valid JSON.");
            try {
                return new JSONObject().put("success", false);
            } catch (JSONException e4) {
                return new JSONObject();
            }
        }
    }

    public void mo3260a(final aat com_google_android_gms_internal_aat, final Map<String, String> map) {
        zk.m15079a(new Runnable(this) {
            final /* synthetic */ sd f10554c;

            public void run() {
                aad.m8421b("Received Http request.");
                final JSONObject a = this.f10554c.m13712a((String) map.get("http_request"));
                if (a == null) {
                    aad.m8423c("Response should not be null.");
                } else {
                    zl.f11678a.post(new Runnable(this) {
                        final /* synthetic */ C32341 f10551b;

                        public void run() {
                            com_google_android_gms_internal_aat.mo3410b("fetchHttpRequestCompleted", a);
                            aad.m8421b("Dispatched http response.");
                        }
                    });
                }
            }
        });
    }
}
