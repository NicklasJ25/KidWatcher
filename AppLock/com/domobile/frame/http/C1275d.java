package com.domobile.frame.http;

import android.content.Context;
import java.util.ArrayList;

public class C1275d {
    public String f2623a;
    public String f2624b;
    public String f2625c;
    public ArrayList<C1271g> f2626d;
    public Context f2627e;

    public C1275d(String str) {
        this.f2625c = "POST";
        this.f2626d = new ArrayList();
        this.f2623a = str;
    }

    public C1275d(String str, String str2) {
        this.f2625c = "POST";
        this.f2623a = str;
        this.f2624b = str2;
        this.f2626d = new ArrayList();
    }

    public void m3038a(String str, String str2) {
        this.f2626d.add(new C1272a(str, str2));
    }

    public String toString() {
        String str = this.f2623a;
        int i = 0;
        while (i < this.f2626d.size()) {
            String str2 = str + "&" + ((C1271g) this.f2626d.get(i)).mo2523a() + "=" + ((C1271g) this.f2626d.get(i)).mo2524b();
            i++;
            str = str2;
        }
        return str;
    }
}
