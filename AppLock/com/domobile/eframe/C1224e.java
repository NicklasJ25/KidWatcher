package com.domobile.eframe;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import com.domobile.applock.C1150y;
import com.domobile.applock.MainActivity;
import com.domobile.applock.R;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import com.domobile.frame.ui.C1288c;
import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class C1224e {

    public static class C1222a implements Comparable<C1222a> {
        static final Collator f2412a = Collator.getInstance();
        String f2413b;
        Locale f2414c;

        public C1222a(String str, Locale locale) {
            this.f2413b = str;
            this.f2414c = locale;
        }

        public int m2868a(C1222a c1222a) {
            return f2412a.compare(this.f2413b, c1222a.f2413b);
        }

        public Locale m2869a() {
            return this.f2414c;
        }

        public /* synthetic */ int compareTo(Object obj) {
            return m2868a((C1222a) obj);
        }

        public String toString() {
            return this.f2413b;
        }
    }

    private static class C1223b extends BaseAdapter {
        private C1222a[] f2415a;
        private Context f2416b;

        public C1223b(Context context, C1222a[] c1222aArr) {
            this.f2416b = context;
            if (c1222aArr == null) {
                c1222aArr = new C1222a[0];
            }
            this.f2415a = c1222aArr;
        }

        public C1222a m2870a(int i) {
            return this.f2415a[i];
        }

        public int getCount() {
            return this.f2415a.length + 1;
        }

        public /* synthetic */ Object getItem(int i) {
            return m2870a(i);
        }

        public long getItemId(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(this.f2416b).inflate(R.layout.codeset_list_item, null);
            }
            ((ImageView) view.findViewById(16908294)).setVisibility(8);
            CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(16908308);
            checkedTextView.setCheckMarkDrawable(null);
            if (i == 0) {
                checkedTextView.setText(R.string.default_language);
            } else {
                checkedTextView.setText(this.f2415a[i - 1].toString());
            }
            return view;
        }
    }

    public C1224e(final Activity activity) {
        final BaseAdapter b = C1224e.m2875b(activity);
        final C1288c c1288c = new C1288c(activity);
        c1288c.m3109a("Language").m3117b(true);
        c1288c.m3106a(b, -1, new OnItemClickListener(this) {
            final /* synthetic */ C1224e f2410d;

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c1288c.m3125e();
                if (i > 0) {
                    C1148d.m2520b(activity, "applock_language", (Object) b.m2870a(i - 1).toString());
                    C1148d.m2520b(activity, "applock_locale_text", (Object) C1147a.m2480a(r0.m2869a().getLanguage(), ",", r0.m2869a().getCountry()));
                } else {
                    C1148d.m2534y(activity, "applock_language");
                    C1148d.m2534y(activity, "applock_locale_text");
                }
                C1224e.m2874a(activity);
            }
        }).m3122d();
    }

    private static String m2871a(String str) {
        return TextUtils.isEmpty(str) ? str : Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    private static String m2872a(Locale locale, String[] strArr, String[] strArr2) {
        String locale2 = locale.toString();
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(locale2)) {
                return strArr2[i];
            }
        }
        return locale.getDisplayName(locale);
    }

    public static Locale m2873a(Context context) {
        try {
            return C1224e.m2876b(context);
        } catch (Exception e) {
            return C1150y.m2578a();
        }
    }

    public static void m2874a(final Activity activity) {
        ApplicationInfo applicationInfo = activity.getApplicationInfo();
        String string = activity.getString(R.string.restart_applock, new Object[]{activity.getResources().getString(applicationInfo.labelRes)});
        C1288c c1288c = new C1288c(activity);
        c1288c.m3123d((int) R.string.change_language_must_restart_app);
        c1288c.m3101a((int) R.string.notice).m3116b(string, new OnClickListener() {
            public void onClick(View view) {
                activity.finish();
                Intent intent = new Intent(activity, MainActivity.class);
                intent.setFlags(268435456);
                ((AlarmManager) activity.getSystemService("alarm")).set(2, 1500, PendingIntent.getActivity(activity, 0, intent, 134217728));
            }
        }).m3122d();
    }

    public static C1223b m2875b(Activity activity) {
        Resources resources = activity.getResources();
        String[] stringArray = resources.getStringArray(R.array.languages);
        String[] stringArray2 = resources.getStringArray(R.array.special_locale_codes);
        String[] stringArray3 = resources.getStringArray(R.array.special_locale_names);
        Arrays.sort(stringArray);
        int length = stringArray.length;
        C1222a[] c1222aArr = new C1222a[length];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            String str = stringArray[i];
            String substring = str.substring(0, 2);
            Object substring2 = str.length() == 5 ? str.substring(3, 5) : null;
            Locale locale = TextUtils.isEmpty(substring2) ? new Locale(substring) : new Locale(substring, substring2);
            if (i2 == 0) {
                i3 = i2 + 1;
                c1222aArr[i2] = new C1222a(C1224e.m2871a(locale.getDisplayLanguage(locale)), locale);
            } else if (c1222aArr[i2 - 1].f2414c.getLanguage().equals(substring)) {
                c1222aArr[i2 - 1].f2413b = C1224e.m2871a(C1224e.m2872a(c1222aArr[i2 - 1].f2414c, stringArray2, stringArray3));
                i3 = i2 + 1;
                c1222aArr[i2] = new C1222a(C1224e.m2871a(C1224e.m2872a(locale, stringArray2, stringArray3)), locale);
            } else {
                i3 = i2 + 1;
                c1222aArr[i2] = new C1222a(C1224e.m2871a(locale.getDisplayLanguage(locale)), locale);
            }
            i++;
            i2 = i3;
        }
        C1222a[] c1222aArr2 = new C1222a[i2];
        for (i3 = 0; i3 < i2; i3++) {
            c1222aArr2[i3] = c1222aArr[i3];
        }
        Arrays.sort(c1222aArr2);
        return new C1223b(activity, c1222aArr2);
    }

    private static Locale m2876b(Context context) {
        Object b = C1150y.m2602b(context, "applock_locale_text");
        if (TextUtils.isEmpty(b)) {
            return C1150y.m2578a();
        }
        String[] split = b.split(",");
        if (split.length == 1) {
            if (!TextUtils.isEmpty(split[0])) {
                return new Locale(split[0]);
            }
        } else if (split.length > 1) {
            String str = split[0];
            Object obj = split[1];
            if (!TextUtils.isEmpty(str)) {
                return !TextUtils.isEmpty(obj) ? new Locale(str, obj) : new Locale(str);
            }
        }
        return C1150y.m2578a();
    }
}
