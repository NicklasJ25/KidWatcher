package com.facebook.ads.internal.p021b;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkActivity.C1449b;
import com.facebook.ads.C1460d;
import com.facebook.ads.C1467i;
import com.facebook.ads.internal.p018m.C1727r;
import com.facebook.ads.internal.p022h.C1597f;
import com.facebook.ads.internal.view.C1523c;
import com.facebook.ads.p019a.C1452a;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONObject;

public class C1520p extends C1493d {
    private static final ConcurrentMap<String, C1523c> f3580a = new ConcurrentHashMap();
    private final String f3581b = UUID.randomUUID().toString();
    private Context f3582c;
    private C1538y f3583d;
    private C1478e f3584e;
    private boolean f3585f = false;
    private C1533u f3586g;
    private C1519a f3587h;

    public enum C1519a {
        UNSPECIFIED,
        VERTICAL,
        HORIZONTAL;

        public static C1519a m4040a(int i) {
            return i == 0 ? UNSPECIFIED : i == 2 ? HORIZONTAL : VERTICAL;
        }
    }

    public static C1523c m4043a(String str) {
        return (C1523c) f3580a.get(str);
    }

    public static void m4044a(C1523c c1523c) {
        for (Entry entry : f3580a.entrySet()) {
            if (entry.getValue() == c1523c) {
                f3580a.remove(entry.getKey());
            }
        }
    }

    private int m4048e() {
        int rotation = ((WindowManager) this.f3582c.getSystemService("window")).getDefaultDisplay().getRotation();
        if (this.f3587h == C1519a.UNSPECIFIED) {
            return -1;
        }
        if (this.f3587h == C1519a.HORIZONTAL) {
            switch (rotation) {
                case 2:
                case 3:
                    return 8;
                default:
                    return 0;
            }
        }
        switch (rotation) {
            case 2:
                return 9;
            default:
                return 1;
        }
    }

    public void mo2713a(Context context, C1478e c1478e, Map<String, Object> map, C1597f c1597f) {
        this.f3582c = context;
        this.f3584e = c1478e;
        JSONObject jSONObject = (JSONObject) map.get("data");
        if (jSONObject.has("markup")) {
            this.f3586g = C1533u.m4167a(jSONObject);
            if (C1727r.m4953a(context, this.f3586g)) {
                c1478e.mo2656a(this, C1460d.f3364b);
                return;
            }
            this.f3583d = new C1538y(context, this.f3581b, this, this.f3584e);
            this.f3583d.m4217a();
            Map c = this.f3586g.m4173c();
            if (c.containsKey("orientation")) {
                this.f3587h = C1519a.m4040a(Integer.parseInt((String) c.get("orientation")));
            }
            this.f3585f = true;
            if (this.f3584e != null) {
                this.f3584e.mo2655a(this);
                return;
            }
            return;
        }
        this.f3583d = new C1538y(context, this.f3581b, this, this.f3584e);
        this.f3583d.m4217a();
        final C1524q c1524q = new C1524q();
        c1524q.mo2711a(context, new C1452a(this) {
            final /* synthetic */ C1520p f3575b;

            public void mo2665a(C1516x c1516x) {
                this.f3575b.f3585f = true;
                if (this.f3575b.f3584e != null) {
                    this.f3575b.f3584e.mo2655a(this.f3575b);
                }
            }

            public void mo2666a(C1516x c1516x, View view) {
                this.f3575b.f3587h = c1524q.m4078k();
                C1520p.f3580a.put(this.f3575b.f3581b, c1524q);
            }

            public void mo2667a(C1516x c1516x, C1460d c1460d) {
                c1524q.m4079l();
                this.f3575b.f3584e.mo2656a(this.f3575b, c1460d);
            }

            public void mo2668b(C1516x c1516x) {
                this.f3575b.f3584e.mo2657a(this.f3575b, "", true);
            }

            public void mo2669c(C1516x c1516x) {
                this.f3575b.f3584e.mo2658b(this.f3575b);
            }

            public void mo2670d(C1516x c1516x) {
            }
        }, map, c1597f);
    }

    public void mo2680b() {
        if (this.f3583d != null) {
            this.f3583d.m4218b();
        }
    }

    public boolean mo2714c() {
        if (this.f3585f) {
            Intent intent = new Intent(this.f3582c, AudienceNetworkActivity.class);
            intent.putExtra("predefinedOrientationKey", m4048e());
            intent.putExtra("uniqueId", this.f3581b);
            if (f3580a.containsKey(this.f3581b)) {
                intent.putExtra("viewType", C1449b.NATIVE);
            } else {
                intent.putExtra("viewType", C1449b.DISPLAY);
                this.f3586g.m4171a(intent);
            }
            intent.addFlags(268435456);
            try {
                this.f3582c.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                intent.setClass(this.f3582c, C1467i.class);
                this.f3582c.startActivity(intent);
            }
            return true;
        }
        if (this.f3584e != null) {
            this.f3584e.mo2656a(this, C1460d.f3367e);
        }
        return false;
    }
}
