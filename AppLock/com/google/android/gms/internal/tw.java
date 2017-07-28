package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@wh
public class tw {
    public List<String> m14033a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        List arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void m14034a(Context context, String str, yy yyVar, String str2, boolean z, List<String> list) {
        if (list != null && !list.isEmpty()) {
            String str3 = z ? "1" : "0";
            for (String replaceAll : list) {
                String replaceAll2 = replaceAll2.replaceAll("@gw_adlocid@", str2).replaceAll("@gw_adnetrefresh@", str3).replaceAll("@gw_qdata@", yyVar.f11543r.f10794h).replaceAll("@gw_sdkver@", str).replaceAll("@gw_sessid@", zzw.zzcQ().m14989a()).replaceAll("@gw_seqnum@", yyVar.f11534i);
                if (!TextUtils.isEmpty(yyVar.f11546u)) {
                    replaceAll2 = replaceAll2.replaceAll("@gw_adnetstatus@", yyVar.f11546u);
                }
                if (yyVar.f11540o != null) {
                    replaceAll2 = replaceAll2.replaceAll("@gw_adnetid@", yyVar.f11540o.f10772b).replaceAll("@gw_allocid@", yyVar.f11540o.f10774d);
                }
                zzw.zzcM().m15141b(context, str, replaceAll2);
            }
        }
    }
}
