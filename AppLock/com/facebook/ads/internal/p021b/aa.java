package com.facebook.ads.internal.p021b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.support.v4.os.EnvironmentCompat;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.gallery3d.common.FileCache.FileEntry.Columns;
import com.facebook.ads.C1905m.C1904a;
import com.facebook.ads.MediaView;
import com.facebook.ads.internal.p034k.C1671a;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aa extends C1491f {
    private final ab f3482c;
    private C1904a f3483d;
    private boolean f3484e;
    private boolean f3485f;
    private boolean f3486g;
    private View f3487h;
    private List<View> f3488i;

    public aa(Context context, C1495h c1495h, C1671a c1671a, ab abVar) {
        super(context, c1495h, c1671a);
        this.f3482c = abVar;
    }

    private String m3878b(View view) {
        try {
            return m3879c(view).toString();
        } catch (JSONException e) {
            return "Json exception";
        }
    }

    private JSONObject m3879c(View view) {
        boolean z = true;
        int i = 0;
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("id", Integer.valueOf(view.getId()));
        jSONObject.putOpt("class", view.getClass());
        jSONObject.putOpt("origin", String.format("{x:%d, y:%d}", new Object[]{Integer.valueOf(view.getTop()), Integer.valueOf(view.getLeft())}));
        jSONObject.putOpt(Columns.SIZE, String.format("{h:%d, w:%d}", new Object[]{Integer.valueOf(view.getHeight()), Integer.valueOf(view.getWidth())}));
        if (this.f3488i == null || !this.f3488i.contains(view)) {
            z = false;
        }
        jSONObject.putOpt("clickable", Boolean.valueOf(z));
        Object obj = EnvironmentCompat.MEDIA_UNKNOWN;
        if (view instanceof Button) {
            obj = "button";
        } else if (view instanceof TextView) {
            obj = "text";
        } else if (view instanceof ImageView) {
            obj = "image";
        } else if (view instanceof MediaView) {
            obj = "mediaview";
        } else if (view instanceof ViewGroup) {
            obj = "viewgroup";
        }
        jSONObject.putOpt("type", obj);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            JSONArray jSONArray = new JSONArray();
            while (i < viewGroup.getChildCount()) {
                jSONArray.put(m3879c(viewGroup.getChildAt(i)));
                i++;
            }
            jSONObject.putOpt("list", jSONArray);
        }
        return jSONObject;
    }

    private String m3880d(View view) {
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return "";
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
            createBitmap.setDensity(view.getResources().getDisplayMetrics().densityDpi);
            view.draw(new Canvas(createBitmap));
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(CompressFormat.JPEG, this.f3482c.mo2688i(), byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (Exception e) {
            return "";
        }
    }

    public void m3881a(View view) {
        this.f3487h = view;
    }

    public void m3882a(C1904a c1904a) {
        this.f3483d = c1904a;
    }

    public void m3883a(List<View> list) {
        this.f3488i = list;
    }

    protected void mo2671a(Map<String, String> map) {
        if (this.f3482c != null) {
            if (this.a != null) {
                map.put("mil", String.valueOf(this.a.mo2842a()));
                map.put("eil", String.valueOf(this.a.mo2844b()));
                map.put("eil_source", this.a.mo2845c());
            }
            if (this.f3483d != null) {
                map.put("nti", String.valueOf(this.f3483d.m5429a()));
            }
            if (this.f3484e) {
                map.put("nhs", Boolean.TRUE.toString());
            }
            if (this.f3485f) {
                map.put("nmv", Boolean.TRUE.toString());
            }
            if (this.f3486g) {
                map.put("nmvap", Boolean.TRUE.toString());
            }
            if (this.f3487h != null && this.f3482c.mo2686g()) {
                map.put("view", m3878b(this.f3487h));
            }
            if (this.f3487h != null && this.f3482c.mo2685f()) {
                map.put("snapshot", m3880d(this.f3487h));
            }
            this.f3482c.mo2679a((Map) map);
        }
    }

    public void m3885a(boolean z) {
        this.f3484e = z;
    }

    public void m3886b(boolean z) {
        this.f3485f = z;
    }

    public void m3887c(boolean z) {
        this.f3486g = z;
    }
}
