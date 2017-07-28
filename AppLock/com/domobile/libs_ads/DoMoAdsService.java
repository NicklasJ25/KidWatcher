package com.domobile.libs_ads;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.IBinder;
import android.text.TextUtils;
import com.domobile.frame.http.C0607f;
import com.domobile.frame.http.C1275d;
import com.domobile.frame.http.C1276e;
import com.domobile.frame.http.image.C1277a;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import java.text.SimpleDateFormat;
import org.json.JSONArray;
import org.json.JSONObject;

public class DoMoAdsService extends Service implements C0607f {
    public static boolean m3310a(Context context) {
        if (!context.getPackageName().startsWith("com.domobile")) {
            return false;
        }
        return !TextUtils.equals(new SimpleDateFormat("yyyyMMdd").format(Long.valueOf(System.currentTimeMillis())), C1342b.m3323a(context, "domo_ad_date", ""));
    }

    public C1275d mo2363a() {
        return new C1275d(C1147a.m2480a(((C0588a) getApplicationContext()).mo2353g(), "apps/ad/", getPackageName(), ".json"));
    }

    public void mo2364a(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            C1342b.m3326a((Context) this, "domo_ad_json", (Object) str);
            C1342b.m3326a((Context) this, "domo_ad_date", simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())));
            C1342b.m3326a((Context) this, "domo_ad_index", Integer.valueOf(-1));
            new Thread(this) {
                final /* synthetic */ DoMoAdsService f2882b;

                public void run() {
                    JSONArray optJSONArray = jSONObject.optJSONArray("ad");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            try {
                                String optString = optJSONArray.getJSONObject(i).optString("pic");
                                if (!TextUtils.isEmpty(optString)) {
                                    Bitmap a = C1277a.m3056a(optString, false, CompressFormat.JPEG);
                                    if (a != null) {
                                        a.recycle();
                                    }
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
            stopSelf();
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int i) {
        if (m3310a((Context) this)) {
            C1148d.m2516a(new C1276e(), this);
            return;
        }
        stopSelf();
    }
}
