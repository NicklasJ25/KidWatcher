package com.domobile.frame.http;

import android.os.AsyncTask;
import com.domobile.frame.p000a.C1147a;
import java.util.Iterator;

public class C1276e extends AsyncTask<C0607f, Integer, C0607f> {
    String f2628a = "";

    protected C0607f m3039a(C0607f... c0607fArr) {
        C0607f c0607f = c0607fArr[0];
        C1275d a = c0607f.mo2363a();
        Iterator it = a.f2626d.iterator();
        Object obj = "";
        while (it.hasNext()) {
            C1271g c1271g = (C1271g) it.next();
            String a2 = C1147a.m2480a(obj, "&", c1271g.mo2523a(), "=", c1271g.mo2524b());
        }
        C1147a.m2482b(a.f2623a, obj);
        this.f2628a = C1273b.m3035a(a);
        return c0607f;
    }

    protected void m3040a(C0607f c0607f) {
        C1147a.m2481a((Object) this.f2628a);
        c0607f.mo2364a(this.f2628a);
    }

    protected void m3041a(Integer... numArr) {
        System.out.println("" + numArr[0]);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m3039a((C0607f[]) objArr);
    }

    protected void onCancelled() {
        super.onCancelled();
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m3040a((C0607f) obj);
    }

    protected void onPreExecute() {
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        m3041a((Integer[]) objArr);
    }
}
