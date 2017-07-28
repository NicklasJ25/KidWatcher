package com.domobile.widget;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.applock.p003a.C0618g;
import com.domobile.applock.p012e.C0898c;
import com.domobile.eframe.ui.SlidingLeftMenu.C1236a;
import com.domobile.frame.http.image.C1277a;
import com.domobile.libs_ads.C1342b;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class RecommendAdsView extends View {
    private C1236a f3091a;

    public RecommendAdsView(Context context) {
        super(context);
    }

    public RecommendAdsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RecommendAdsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @NonNull
    public static C1236a m3558a(Context context, boolean z) {
        C1236a c1236a;
        C1236a c1236a2;
        ArrayList a = m3559a(context);
        if (!C1150y.m2554S(context)) {
            c1236a = new C1236a();
            c1236a.f2461j = 11;
            a.add(c1236a);
        }
        if (!C1150y.m2542G(context)) {
            c1236a = new C1236a();
            c1236a.f2461j = 12;
            a.add(c1236a);
        }
        c1236a = new C1236a();
        c1236a.f2461j = 10;
        a.add(c1236a);
        try {
            int size = a.size();
            int a2 = C1342b.m3318a(context, "home_header_ads_position", 0);
            if (z) {
                size = (a2 + 1) % size;
                C1342b.m3326a(context, "home_header_ads_position", Integer.valueOf(size));
                c1236a2 = (C1236a) a.get(size);
            } else {
                c1236a2 = (C1236a) a.get(a2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            c1236a2 = null;
        }
        return c1236a2 == null ? c1236a : c1236a2;
    }

    public static ArrayList<C1236a> m3559a(Context context) {
        ArrayList<C1236a> arrayList = new ArrayList();
        try {
            String country = Locale.getDefault().getCountry();
            Object a = C1342b.m3323a(context, "home_header_ads_json", "");
            if (!TextUtils.isEmpty(a)) {
                JSONArray jSONArray = new JSONArray(a);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (UnlockGiftView.m3567a(jSONObject, country)) {
                        C1236a c1236a = new C1236a(jSONObject);
                        if (!(c1236a.f2456e == 4 && C1150y.m2639k(context, c1236a.f2453b)) && new File(C1277a.m3057a(c1236a.f2454c)).exists()) {
                            arrayList.add(c1236a);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private void m3560a() {
        try {
            ViewCompat.setBackground(this, C0618g.m716a(getResources(), C1277a.m3055a(this.f3091a.f2454c, false), getResources().getDimensionPixelSize(R.dimen.item_height_min)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void m3561a(Context context, C1236a c1236a) {
        if (c1236a != null) {
            if (c1236a.f2456e == 4 && C1150y.m2639k(context, c1236a.f2453b)) {
                Intent a = C0898c.m1562a(context, c1236a.f2453b);
                if (a != null) {
                    context.startActivity(a);
                    return;
                }
            }
            c1236a.m2904a(context);
        }
    }

    public C1236a getAdsBean() {
        return this.f3091a;
    }

    public void setAdsBean(C1236a c1236a) {
        this.f3091a = c1236a;
        m3560a();
    }
}
