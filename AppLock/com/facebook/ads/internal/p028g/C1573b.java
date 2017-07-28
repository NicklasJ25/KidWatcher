package com.facebook.ads.internal.p028g;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C1573b {
    public String f3867a;
    public String f3868b;
    public String f3869c;
    public Date f3870d;
    public boolean f3871e;

    public C1573b(String str, String str2, String str3, Date date) {
        this.f3867a = str;
        this.f3868b = str2;
        this.f3869c = str3;
        this.f3870d = date;
        boolean z = (str2 == null || str3 == null) ? false : true;
        this.f3871e = z;
    }

    public C1573b(JSONObject jSONObject) {
        this(jSONObject.optString("url"), jSONObject.optString("key"), jSONObject.optString("value"), new Date(jSONObject.optLong("expiration") * 1000));
    }

    public static List<C1573b> m4379a(String str) {
        if (str == null) {
            return null;
        }
        JSONArray jSONArray;
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e) {
            jSONArray = null;
        }
        if (jSONArray == null) {
            return null;
        }
        List<C1573b> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject;
            try {
                jSONObject = jSONArray.getJSONObject(i);
            } catch (JSONException e2) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                C1573b c1573b = new C1573b(jSONObject);
                if (c1573b != null) {
                    arrayList.add(c1573b);
                }
            }
        }
        return arrayList;
    }

    public String m4380a() {
        Date date = this.f3870d;
        if (date == null) {
            date = new Date();
            date.setTime(date.getTime() + 3600000);
        }
        DateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss zzz");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(date);
    }

    public boolean m4381b() {
        return (this.f3868b == null || this.f3869c == null || this.f3867a == null) ? false : true;
    }
}
