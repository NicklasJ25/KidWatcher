package com.domobile.applock.livelock.p014b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.domobile.applock.p003a.C0614e;
import com.domobile.applock.theme.C1102c;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C0980e {
    public static final String f1620a = Environment.getExternalStorageDirectory().getAbsolutePath();

    @NonNull
    public static C0979d m1860a(Context context) {
        return C0980e.m1861a(context, C1102c.m2385a(context));
    }

    @NonNull
    public static C0979d m1861a(@NonNull Context context, @NonNull String str) {
        Resources b = C0978c.m1850b(context, str);
        return C0980e.m1862a(C0614e.m705a(b.openRawResource(b.getIdentifier("config", "raw", str))));
    }

    @NonNull
    public static C0979d m1862a(@NonNull String str) {
        C0979d c0979d = new C0979d();
        try {
            JSONObject jSONObject = new JSONObject(str);
            c0979d.f1609a = jSONObject.getString("packageName");
            c0979d.f1610b = C0980e.m1863b(jSONObject.getString("bgPortFrameList"));
            c0979d.f1611c = C0980e.m1863b(jSONObject.getString("bgLandFrameList"));
            c0979d.f1612d = C0980e.m1863b(jSONObject.getString("iconDecorFrameList"));
            c0979d.f1613e = C0980e.m1863b(jSONObject.getString("pwdItemFrameList"));
            c0979d.f1614f = C0980e.m1863b(jSONObject.optString("pwdBgFrameList"));
            c0979d.f1615g = C0980e.m1863b(jSONObject.getString("numNormFrameList"));
            c0979d.f1616h = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("numDownFrameList");
            for (int i = 0; i < jSONArray.length(); i++) {
                c0979d.f1616h.add(C0980e.m1863b(jSONArray.getString(i)));
            }
            c0979d.f1617i = new HashMap();
            JSONObject jSONObject2 = jSONObject.getJSONObject("patternFrameList");
            c0979d.f1617i.put("NORM", C0980e.m1863b(jSONObject2.getString("norm")));
            c0979d.f1617i.put("DOWN", C0980e.m1863b(jSONObject2.getString("down")));
            c0979d.f1617i.put("ERROR", C0980e.m1863b(jSONObject2.getString("error")));
            c0979d.f1618j = new HashMap();
            jSONObject2 = jSONObject.getJSONObject("patternLineList");
            c0979d.f1618j.put("NORM", jSONObject2.getString("norm"));
            c0979d.f1618j.put("ERROR", jSONObject2.getString("error"));
            c0979d.f1619k = jSONObject.getInt("patternLineSize");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return c0979d;
    }

    @NonNull
    private static ArrayList<C0976b> m1863b(@Nullable String str) {
        ArrayList<C0976b> arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String str2 : str.split(",")) {
                    C0976b c0976b = new C0976b();
                    String[] split = str2.split(":");
                    c0976b.f1602a = split[0];
                    c0976b.f1603b = Long.parseLong(split[1]);
                    arrayList.add(c0976b);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}
