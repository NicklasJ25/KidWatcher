package com.domobile.eframe;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.domobile.applock.C1140x.C1134b;
import com.domobile.applock.C1140x.C1135c;
import com.domobile.applock.C1150y;
import com.domobile.applock.R;
import com.domobile.frame.http.C0607f;
import com.domobile.frame.http.C1272a;
import com.domobile.frame.http.C1273b;
import com.domobile.frame.http.C1275d;
import com.domobile.frame.http.C1276e;
import com.domobile.frame.http.image.C1277a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1288c;
import java.util.ArrayList;
import org.json.JSONObject;

public class C1228f {

    public static class C1226a implements OnClickListener {
        private Context f2419a = null;

        public C1226a(Context context) {
            this.f2419a = context;
        }

        public void onClick(View view) {
            C1230g.m2897a("last_push_clicked", "true");
            C1228f.m2885b("0", this.f2419a);
            if (this.f2419a instanceof Activity) {
                ((Activity) this.f2419a).finish();
            }
        }
    }

    public static class C1227b implements OnClickListener {
        private String f2420a = "";
        private String f2421b = "";
        private Context f2422c = null;

        public C1227b(Context context, String str, String str2) {
            this.f2422c = context;
            this.f2420a = str;
            this.f2421b = str2;
        }

        public void onClick(View view) {
            C1230g.m2897a("last_push_clicked", "true");
            if (!TextUtils.isEmpty(this.f2420a)) {
                C1148d.m2493E(this.f2422c, this.f2420a);
            } else if (!TextUtils.isEmpty(this.f2421b)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f2421b));
                intent.setFlags(268435456);
                this.f2422c.startActivity(intent);
            }
            if (this.f2422c instanceof Activity) {
                ((Activity) this.f2422c).finish();
            }
        }
    }

    public static C1288c m2879a(Activity activity) {
        try {
            JSONObject jSONObject = new JSONObject(C1228f.m2880a());
            String a = C1230g.m2894a(jSONObject, "dialog_title");
            CharSequence a2 = C1230g.m2894a(jSONObject, "content_main_title");
            CharSequence a3 = C1230g.m2894a(jSONObject, "content_sub_title");
            Object replaceAll = C1230g.m2894a(jSONObject, "content_message").replaceAll("\\n", "\n").replaceAll("\\t", "\t");
            String a4 = C1230g.m2894a(jSONObject, "content_package");
            String a5 = C1230g.m2894a(jSONObject, "content_url");
            LayoutInflater from = LayoutInflater.from(activity);
            C1135c c1135c = C1230g.f2429f;
            View inflate = from.inflate(R.layout.push_dialog, null);
            C1134b c1134b = C1230g.f2430g;
            TextView textView = (TextView) inflate.findViewById(R.id.push_dialog_content_msg);
            C1134b c1134b2 = C1230g.f2430g;
            ImageView imageView = (ImageView) inflate.findViewById(R.id.push_dialog_content_icon);
            C1134b c1134b3 = C1230g.f2430g;
            TextView textView2 = (TextView) inflate.findViewById(R.id.push_dialog_content_maintitle);
            C1134b c1134b4 = C1230g.f2430g;
            TextView textView3 = (TextView) inflate.findViewById(R.id.push_dialog_content_subtitle);
            if (!TextUtils.isEmpty(a2)) {
                textView2.setText(a2);
                textView2.setVisibility(0);
            }
            if (!TextUtils.isEmpty(a3)) {
                textView3.setText(a3);
                textView3.setVisibility(0);
            }
            if (!TextUtils.isEmpty(replaceAll)) {
                textView.setText("\t" + replaceAll);
                textView.setVisibility(0);
            }
            Object a6 = C1230g.m2894a(jSONObject, "content_icon");
            if (!TextUtils.isEmpty(a6)) {
                Bitmap b = C1277a.m3060b(a6);
                if (b != null) {
                    imageView.setImageBitmap(b);
                    imageView.setVisibility(0);
                }
            }
            C1288c a7 = new C1288c(activity).m3105a(inflate);
            a7.m3114b(17039370, new C1227b(activity, a4, a5));
            a7.m3102a(17039360, new C1226a(activity));
            a7.m3127e(true);
            a7.m3124d(true);
            a7.m3126e(0);
            a7.m3109a(a);
            return a7;
        } catch (Exception e) {
            return null;
        }
    }

    public static String m2880a() {
        return C1230g.m2893a("push_json_cache");
    }

    public static void m2882a(Context context, JSONObject jSONObject) {
        Object optString = jSONObject.optString("content_icon");
        Builder builder = new Builder(context);
        builder.setAutoCancel(true).setOngoing(true);
        builder.setSmallIcon(R.drawable.icon_notify);
        builder.setContentTitle(jSONObject.optString("content_main_title"));
        builder.setContentText(jSONObject.optString("content_message").replaceAll("\\n", "\n").replaceAll("\\t", "\t"));
        if (!TextUtils.isEmpty(optString)) {
            builder.setLargeIcon(C1277a.m3060b(optString));
        }
        if (jSONObject.optInt("content_push_type") == 0) {
            Intent intent = new Intent(context, PushDialogActivity.class);
            intent.setFlags(268435456);
            builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 0));
            C1148d.m2508a(context, (int) R.id.notify_push_message, builder.build());
            return;
        }
        intent = null;
        if (!TextUtils.isEmpty(jSONObject.optString("content_package"))) {
            intent = C1150y.m2639k(context, "com.android.vending") ? new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + jSONObject.optString("content_package"))) : new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + jSONObject.optString("content_package")));
        } else if (!TextUtils.isEmpty(jSONObject.optString("content_url"))) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(jSONObject.optString("content_url")));
        }
        if (intent != null) {
            intent.setFlags(268435456);
            builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 0));
            C1148d.m2508a(context, (int) R.id.notify_push_message, builder.build());
        }
    }

    private static String m2884b(Context context) {
        String a = C1230g.m2893a("last_push_id");
        if (!TextUtils.isEmpty(a)) {
            try {
                Integer.parseInt(a);
                return a;
            } catch (Exception e) {
            }
        }
        Object a2 = C1230g.m2892a(context, "last_push_id");
        return TextUtils.isEmpty(a2) ? "-1" : a2;
    }

    private static void m2885b(final String str, final Context context) {
        C1148d.m2516a(new C1276e(), new C0607f() {
            public C1275d mo2363a() {
                C1275d c1275d = new C1275d("https://www.domobile.com/servlet/applock");
                String valueOf = String.valueOf(C1230g.m2890a(context));
                ArrayList arrayList = new ArrayList();
                arrayList.add(new C1272a("action", "push_feedback"));
                arrayList.add(new C1272a("from_app", context.getPackageName()));
                arrayList.add(new C1272a("language", C1230g.m2891a()));
                arrayList.add(new C1272a("push_id", C1228f.m2884b(context)));
                arrayList.add(new C1272a("push_feedback", str));
                arrayList.add(new C1272a("version_code", valueOf));
                c1275d.f2626d = arrayList;
                C1273b.m3035a(c1275d);
                return c1275d;
            }

            public void mo2364a(String str) {
            }
        });
    }
}
