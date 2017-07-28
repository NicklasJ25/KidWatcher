package com.facebook.ads.internal.p022h;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.C1668j;
import com.facebook.ads.internal.p018m.C1729s;
import com.facebook.ads.internal.p018m.C1734w;
import com.facebook.ads.internal.p018m.C1737z;
import com.facebook.ads.internal.p018m.aj;
import com.facebook.ads.internal.p022h.C1596e.C1595a;
import com.facebook.ads.internal.p026e.C1556a;
import com.facebook.ads.internal.p027f.C1559a;
import com.facebook.ads.internal.p027f.C1562c;
import com.facebook.ads.internal.p027f.C1567d;
import com.facebook.ads.internal.p028g.C1581g;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C1599g implements C1595a, C1597f {
    private static final String f3984a = C1599g.class.getSimpleName();
    private static C1599g f3985b;
    private static double f3986c;
    private static String f3987d;
    private final C1596e f3988e;
    private final C1567d f3989f;
    private final Context f3990g;

    protected C1599g(Context context) {
        this.f3989f = new C1567d(context);
        this.f3988e = new C1596e(context, this);
        this.f3988e.m4453b();
        this.f3990g = context;
        C1556a.m4324a(context).m4325a();
    }

    public static C1599g m4464a(Context context) {
        if (f3985b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (applicationContext) {
                if (f3985b == null) {
                    f3985b = new C1599g(applicationContext);
                    C1581g.m4408a();
                    f3986c = C1581g.m4409b();
                    f3987d = C1581g.m4410c();
                }
            }
        }
        return f3985b;
    }

    private JSONObject m4465a(int i) {
        Cursor d;
        Cursor cursor;
        Throwable th;
        Cursor a;
        try {
            d = this.f3989f.m4363d();
            try {
                a = this.f3989f.m4356a(i);
            } catch (JSONException e) {
                cursor = null;
                a = d;
                if (a != null) {
                    a.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                a = null;
                if (d != null) {
                    d.close();
                }
                if (a != null) {
                    a.close();
                }
                throw th;
            }
            try {
                JSONObject jSONObject;
                if (a.getCount() > 0) {
                    jSONObject = new JSONObject();
                    jSONObject.put("tokens", m4466a(a));
                    jSONObject.put("events", m4469c(a));
                } else {
                    jSONObject = null;
                }
                if (C1668j.m4722e(this.f3990g)) {
                    JSONArray a2 = C1737z.m4999a(this.f3990g);
                    if (a2 != null && a2.length() > 0) {
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        jSONObject.put("debug", a2);
                    }
                }
                if (d != null) {
                    d.close();
                }
                if (a == null) {
                    return jSONObject;
                }
                a.close();
                return jSONObject;
            } catch (JSONException e2) {
                cursor = a;
                a = d;
                if (a != null) {
                    a.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (d != null) {
                    d.close();
                }
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        } catch (JSONException e3) {
            cursor = null;
            a = null;
            if (a != null) {
                a.close();
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            a = null;
            d = null;
            if (d != null) {
                d.close();
            }
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    private JSONObject m4466a(Cursor cursor) {
        JSONObject jSONObject = new JSONObject();
        while (cursor.moveToNext()) {
            jSONObject.put(cursor.getString(0), cursor.getString(1));
        }
        return jSONObject;
    }

    private void m4467a(final C1589d c1589d) {
        this.f3989f.m4359a(c1589d, new C1559a<String>(this) {
            final /* synthetic */ C1599g f3983b;

            public void mo2735a(int i, String str) {
                super.mo2735a(i, str);
                if (!(c1589d instanceof C1592c)) {
                    this.f3983b.m4478b(str);
                }
            }

            public void m4462a(String str) {
                super.mo2736a(str);
                if (c1589d.m4428i()) {
                    this.f3983b.f3988e.m4452a();
                } else {
                    this.f3983b.f3988e.m4453b();
                }
            }
        });
    }

    private JSONArray m4468b(Cursor cursor) {
        JSONArray jSONArray = new JSONArray();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", cursor.getString(C1562c.f3808a.f3804a));
            jSONObject.put("token_id", cursor.getString(C1562c.f3809b.f3804a));
            jSONObject.put("type", cursor.getString(C1562c.f3811d.f3804a));
            jSONObject.put("time", C1729s.m4960a(cursor.getDouble(C1562c.f3812e.f3804a)));
            jSONObject.put("session_time", C1729s.m4960a(cursor.getDouble(C1562c.f3813f.f3804a)));
            jSONObject.put("session_id", cursor.getString(C1562c.f3814g.f3804a));
            String string = cursor.getString(C1562c.f3815h.f3804a);
            jSONObject.put("data", string != null ? new JSONObject(string) : new JSONObject());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    private JSONArray m4469c(Cursor cursor) {
        JSONArray jSONArray = new JSONArray();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", cursor.getString(2));
            jSONObject.put("token_id", cursor.getString(0));
            jSONObject.put("type", cursor.getString(4));
            jSONObject.put("time", C1729s.m4960a(cursor.getDouble(5)));
            jSONObject.put("session_time", C1729s.m4960a(cursor.getDouble(6)));
            jSONObject.put("session_id", cursor.getString(7));
            String string = cursor.getString(8);
            jSONObject.put("data", string != null ? new JSONObject(string) : new JSONObject());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    private JSONObject m4470d() {
        Cursor f;
        Cursor e;
        Cursor cursor;
        Throwable th;
        try {
            f = this.f3989f.m4365f();
            try {
                e = this.f3989f.m4364e();
            } catch (JSONException e2) {
                cursor = null;
                e = f;
                if (e != null) {
                    e.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                e = null;
                if (f != null) {
                    f.close();
                }
                if (e != null) {
                    e.close();
                }
                throw th;
            }
            try {
                JSONObject jSONObject;
                if (f.getCount() <= 0 || e.getCount() <= 0) {
                    jSONObject = null;
                } else {
                    jSONObject = new JSONObject();
                    jSONObject.put("tokens", m4466a(f));
                    jSONObject.put("events", m4468b(e));
                }
                if (C1668j.m4722e(this.f3990g)) {
                    JSONArray a = C1737z.m4999a(this.f3990g);
                    if (a != null && a.length() > 0) {
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        jSONObject.put("debug", a);
                    }
                }
                if (f != null) {
                    f.close();
                }
                if (e == null) {
                    return jSONObject;
                }
                e.close();
                return jSONObject;
            } catch (JSONException e3) {
                cursor = e;
                e = f;
                if (e != null) {
                    e.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (f != null) {
                    f.close();
                }
                if (e != null) {
                    e.close();
                }
                throw th;
            }
        } catch (JSONException e4) {
            cursor = null;
            e = null;
            if (e != null) {
                e.close();
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            e = null;
            f = null;
            if (f != null) {
                f.close();
            }
            if (e != null) {
                e.close();
            }
            throw th;
        }
    }

    public JSONObject mo2737a() {
        int h = C1668j.m4725h(this.f3990g);
        return h > 0 ? m4465a(h) : m4470d();
    }

    public void mo2738a(String str) {
        new aj().execute(new String[]{str});
    }

    public void m4473a(String str, C1734w c1734w) {
        m4467a(new C1590a(str, f3986c, f3987d, c1734w));
    }

    public void mo2739a(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m4467a(new C1601i(this.f3990g, str, f3986c, f3987d, map));
        }
    }

    public void m4475a(String str, Map<String, String> map, String str2, C1600h c1600h) {
        m4467a(new C1604l(this.f3990g, str, f3986c, f3987d, map, str2, c1600h));
    }

    public boolean mo2740a(JSONArray jSONArray) {
        boolean e = C1668j.m4722e(this.f3990g);
        Object obj = null;
        boolean z = true;
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("id");
                int i2 = jSONObject.getInt("code");
                if (i2 == 1) {
                    if (e && jSONObject.optInt("dbtype", 0) == 1) {
                        obj = 1;
                    } else {
                        this.f3989f.m4360a(string);
                    }
                } else if (i2 >= 1000 && i2 < 2000) {
                    z = false;
                } else if (i2 >= 2000 && i2 < 3000) {
                    if (e && jSONObject.optInt("dbtype", 0) == 1) {
                        int i3 = 1;
                    } else {
                        this.f3989f.m4360a(string);
                    }
                }
            } catch (JSONException e2) {
            }
        }
        if (obj != null) {
            C1737z.m5002b(this.f3990g);
        }
        return z;
    }

    public void mo2741b() {
        this.f3989f.m4366g();
        this.f3989f.m4361b();
    }

    public void m4478b(String str) {
        Log.e(f3984a, "AdEventManager error: " + str);
    }

    public void mo2742b(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m4467a(new C1603k(this.f3990g, str, f3986c, f3987d, map));
        }
    }

    public void mo2743c(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m4467a(new C1607o(this.f3990g, str, f3986c, f3987d, map));
        }
    }

    public boolean mo2744c() {
        Throwable th;
        Cursor cursor;
        boolean z = true;
        int h = C1668j.m4725h(this.f3990g);
        if (h < 1) {
            return false;
        }
        Cursor cursor2 = null;
        try {
            cursor2 = this.f3989f.m4363d();
            try {
                if (!cursor2.moveToFirst() || cursor2.getInt(0) <= h) {
                    z = false;
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursor2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = cursor2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void mo2745d(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m4467a(new C1605m(str, f3986c, f3987d, map));
        }
    }

    public void mo2746e(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m4467a(new C1591b(this.f3990g, str, f3986c, f3987d, map));
        }
    }

    public void m4484f(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m4467a(new C1602j(this.f3990g, str, f3986c, f3987d, map));
        }
    }

    public void m4485g(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m4467a(new C1606n(this.f3990g, str, f3986c, f3987d, map));
        }
    }
}
