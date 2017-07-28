package com.domobile.applock.p003a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.domobile.applock.AgentActivity;
import com.domobile.applock.C0386c;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.frame.http.C0607f;
import com.domobile.frame.http.C1275d;
import com.domobile.frame.http.C1276e;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import java.io.File;
import java.util.ArrayList;
import org.apache.p068a.p069a.C3613c;
import org.json.JSONArray;
import org.json.JSONObject;

public class C0621h {
    public ArrayList<C0619a> f561a = new ArrayList();
    public ArrayList<C0619a> f562b = new ArrayList();
    public boolean f563c = false;
    public String f564d = "";
    private Context f565e;

    public static class C0619a {
        public JSONObject f558a;

        public C0619a(JSONObject jSONObject) {
            this.f558a = jSONObject;
        }

        public String m720a() {
            return this.f558a.optString("id");
        }

        public String m721a(Activity activity) {
            return TextUtils.equals("playstore", m726d()) ? activity.getString(R.string.download_theme) : (TextUtils.equals("fragment", m726d()) || TextUtils.equals("url", m726d()) || TextUtils.equals("tab", m726d())) ? activity.getString(R.string.open) : null;
        }

        public void m722a(View view) {
            ((TextView) view.findViewById(R.id.fragment_infos_card_item_more)).setText(R.string.close);
            ((TextView) view.findViewById(R.id.fragment_infos_card_item_title)).setText(m724b());
            ((TextView) view.findViewById(R.id.fragment_infos_card_item_message)).setText(m725c());
            view.findViewById(R.id.fragment_infos_card_item_more).setTag(this);
            view.findViewById(R.id.fragment_infos_card_item_details).setTag(this);
            view.findViewById(R.id.fragment_infos_card_item_cardview).setTag(this);
        }

        public void m723a(C0386c c0386c) {
            if (TextUtils.equals("playstore", m726d())) {
                C1148d.m2493E(c0386c, m727e());
            } else if (TextUtils.equals("fragment", m726d())) {
                c0386c.startActivity(AgentActivity.m570a(c0386c, Integer.parseInt(m727e().substring(2), 16)));
            } else if (TextUtils.equals("url", m726d())) {
                C1148d.m2492D(c0386c, m727e());
            }
        }

        public String m724b() {
            return this.f558a.optString("title");
        }

        public String m725c() {
            return this.f558a.optString("summary");
        }

        public String m726d() {
            return this.f558a.optString("action");
        }

        public String m727e() {
            return this.f558a.optString("action_data");
        }

        public String m728f() {
            return this.f558a.optString("position");
        }
    }

    public class C0620b implements C0607f {
        final /* synthetic */ C0621h f559a;
        private Context f560b;

        public C0620b(C0621h c0621h, Context context) {
            this.f559a = c0621h;
            this.f560b = context;
        }

        public C1275d mo2363a() {
            this.f559a.f563c = true;
            C1275d c1275d = new C1275d(C1147a.m2480a("https://www.domobile.com/", "apps/messages/", this.f560b.getPackageName(), "/", this.f560b.getString(R.string.language_values), ".json"), "UTF8");
            this.f559a.m737b(this.f560b);
            this.f559a.m734a(this.f560b);
            this.f559a.m739c(this.f560b);
            return c1275d;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo2364a(java.lang.String r5) {
            /*
            r4 = this;
            r3 = 0;
            r0 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            r0.<init>(r5);	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            if (r0 == 0) goto L_0x003e;
        L_0x0008:
            r0 = new java.io.File;	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            r1 = r4.f560b;	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            r1 = r1.getFilesDir();	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            r2 = "newest_promot_json";
            r0.<init>(r1, r2);	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            org.apache.p068a.p069a.C3613c.m15738b(r0, r5);	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            r0 = new java.io.File;	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            r1 = r4.f560b;	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            r1 = r1.getFilesDir();	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            r2 = "total_promot_json";
            r0.<init>(r1, r2);	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            org.apache.p068a.p069a.C3613c.m15738b(r0, r5);	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            r0 = r4.f559a;	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            r1 = r4.f559a;	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            r1 = r1.f565e;	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            r0.m734a(r1);	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            r0 = r4.f559a;	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            r1 = r4.f559a;	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            r1 = r1.f565e;	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
            r0.m739c(r1);	 Catch:{ Exception -> 0x0043, Error -> 0x004c }
        L_0x003e:
            r0 = r4.f559a;
            r0.f563c = r3;
        L_0x0042:
            return;
        L_0x0043:
            r0 = move-exception;
            r0.printStackTrace();	 Catch:{ all -> 0x0055 }
            r0 = r4.f559a;
            r0.f563c = r3;
            goto L_0x0042;
        L_0x004c:
            r0 = move-exception;
            r0.printStackTrace();	 Catch:{ all -> 0x0055 }
            r0 = r4.f559a;
            r0.f563c = r3;
            goto L_0x0042;
        L_0x0055:
            r0 = move-exception;
            r1 = r4.f559a;
            r1.f563c = r3;
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.domobile.applock.a.h.b.a(java.lang.String):void");
        }
    }

    public C0621h(Context context) {
        this.f565e = context;
        m733a();
    }

    public ArrayList<C0619a> m732a(Context context, String str) {
        ArrayList<C0619a> arrayList = new ArrayList();
        int size = this.f561a.size();
        for (int i = 0; i < size; i++) {
            C0619a c0619a = (C0619a) this.f561a.get(i);
            if (c0619a.m728f().contains(str) && !m736a(c0619a)) {
                arrayList.add(c0619a);
            }
            if (arrayList.size() >= 3) {
                break;
            }
        }
        return arrayList;
    }

    public void m733a() {
        if (!this.f563c && C1150y.m2592a(this.f565e, "auto_load_promts", false)) {
            C1148d.m2516a(new C1276e(), new C0620b(this, this.f565e));
        }
    }

    public void m734a(Context context) {
        int i = 0;
        try {
            this.f561a.clear();
            JSONArray jSONArray = new JSONArray(C3613c.m15726a(new File(context.getFilesDir(), "newest_promot_json"), "UTF8"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            while (i < length) {
                C0619a c0619a = new C0619a(jSONArray.optJSONObject(i));
                if (!m736a(c0619a)) {
                    this.f561a.add(c0619a);
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean m735a(Context context, C0619a c0619a) {
        if (m736a(c0619a)) {
            return true;
        }
        try {
            this.f564d = C1147a.m2480a(this.f564d, c0619a.m720a(), ",");
            C3613c.m15738b(new File(context.getFilesDir(), "readed_promt_ids"), this.f564d);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean m736a(C0619a c0619a) {
        return this.f564d.contains(C1147a.m2480a(c0619a.m720a(), ","));
    }

    public String m737b(Context context) {
        try {
            this.f564d = C3613c.m15726a(new File(context.getFilesDir(), "readed_promt_ids"), "UTF8");
            if (this.f564d == null) {
                this.f564d = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.f564d == null) {
                this.f564d = "";
            }
        } catch (Throwable th) {
            if (this.f564d == null) {
                this.f564d = "";
            }
        }
        return this.f564d;
    }

    public ArrayList<C0619a> m738b() {
        return this.f562b;
    }

    public void m739c(Context context) {
        int i = 0;
        try {
            this.f562b.clear();
            JSONArray jSONArray = new JSONArray(C3613c.m15726a(new File(context.getFilesDir(), "total_promot_json"), "UTF8"));
            int length = jSONArray != null ? jSONArray.length() : 0;
            while (i < length) {
                this.f562b.add(new C0619a(jSONArray.optJSONObject(i)));
                i++;
            }
            C1148d.m2489A(context, "com.domobile.applock.ACTION_INFOS_CENTER_RELOAD_COMPLETE");
        } catch (Exception e) {
        }
    }
}
