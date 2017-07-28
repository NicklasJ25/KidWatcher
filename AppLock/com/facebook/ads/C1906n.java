package com.facebook.ads;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.ViewCompat;
import com.facebook.ads.internal.p018m.C1722n;
import com.facebook.ads.internal.p018m.C1723o;
import org.json.JSONObject;

public class C1906n {
    private Typeface f4831a = Typeface.DEFAULT;
    private int f4832b = -1;
    private int f4833c = ViewCompat.MEASURED_STATE_MASK;
    private int f4834d = -11643291;
    private int f4835e = 0;
    private int f4836f = -12420889;
    private int f4837g = -12420889;
    private boolean f4838h = C1462f.m3762b();
    private boolean f4839i = C1462f.m3763c();

    public C1906n(JSONObject jSONObject) {
        int i = 0;
        try {
            int parseColor = jSONObject.getBoolean("background_transparent") ? 0 : Color.parseColor(jSONObject.getString("background_color"));
            int parseColor2 = Color.parseColor(jSONObject.getString("title_text_color"));
            int parseColor3 = Color.parseColor(jSONObject.getString("description_text_color"));
            int parseColor4 = jSONObject.getBoolean("button_transparent") ? 0 : Color.parseColor(jSONObject.getString("button_color"));
            if (!jSONObject.getBoolean("button_border_transparent")) {
                i = Color.parseColor(jSONObject.getString("button_border_color"));
            }
            int parseColor5 = Color.parseColor(jSONObject.getString("button_text_color"));
            Typeface create = Typeface.create(jSONObject.getString("android_typeface"), 0);
            this.f4832b = parseColor;
            this.f4833c = parseColor2;
            this.f4834d = parseColor3;
            this.f4835e = parseColor4;
            this.f4837g = i;
            this.f4836f = parseColor5;
            this.f4831a = create;
        } catch (Throwable e) {
            C1723o.m4943a(C1722n.m4940a(e, "Error retrieving native ui configuration data"));
        }
    }
}
