package com.facebook.ads.internal.p020a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class C1469b {
    private static final String f3411a = C1469b.class.getSimpleName();

    public static C1468a m3801a(Context context, String str, Uri uri, Map<String, String> map) {
        String authority = uri.getAuthority();
        String queryParameter = uri.getQueryParameter("video_url");
        if (!TextUtils.isEmpty(uri.getQueryParameter("data"))) {
            try {
                JSONObject jSONObject = new JSONObject(uri.getQueryParameter("data"));
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    map.put(str2, jSONObject.getString(str2));
                }
            } catch (Throwable e) {
                Log.w(f3411a, "Unable to parse json data in AdActionFactory.", e);
            }
        }
        Object obj = -1;
        switch (authority.hashCode()) {
            case -1458789996:
                if (authority.equals("passthrough")) {
                    obj = 2;
                    break;
                }
                break;
            case 109770977:
                if (authority.equals("store")) {
                    obj = null;
                    break;
                }
                break;
            case 1546100943:
                if (authority.equals("open_link")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return queryParameter != null ? null : new C1470c(context, str, uri, map);
            case 1:
                return new C1471d(context, str, uri, map);
            case 2:
                return new C1472e(context, str, uri, map);
            default:
                return new C1473f(context, str, uri);
        }
    }

    public static boolean m3802a(String str) {
        return "store".equalsIgnoreCase(str) || "open_link".equalsIgnoreCase(str);
    }
}
