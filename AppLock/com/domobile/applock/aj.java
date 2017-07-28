package com.domobile.applock;

import android.bluetooth.BluetoothAdapter;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import com.domobile.applock.receiver.SwitcherLockReceiver;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import java.util.regex.Matcher;
import org.json.JSONObject;

public class aj extends C0704e {

    public static class C0721a {
        public int f899a;
        public String f900b;
        public String f901c;
        public String f902d;
        public boolean f903e;

        public C0721a(JSONObject jSONObject, Context context) {
            String packageName = context.getPackageName();
            Matcher matcher = C1150y.f2216c.matcher(jSONObject.optString("icon"));
            if (matcher.find()) {
                this.f899a = context.getResources().getIdentifier(matcher.group(1), null, packageName);
            }
            matcher = C1150y.f2218e.matcher(jSONObject.optString("name"));
            if (matcher.find()) {
                Resources resources = context.getResources();
                this.f900b = resources.getString(resources.getIdentifier(matcher.group(1), null, packageName));
            } else {
                this.f900b = "";
            }
            this.f902d = jSONObject.optString("prefKey");
            m1002b(context);
            this.f901c = this.f900b;
        }

        public static void m994a(Context context) {
            C0721a.m995a(context, "key_locked_wifi_state", false);
            C0721a.m995a(context, "key_locked_2g3g_state", false);
            C0721a.m995a(context, "key_locked_bluetooth_state", false);
            C0721a.m995a(context, "key_locked_autosync_state", false);
        }

        public static void m995a(Context context, String str, boolean z) {
            context.getSharedPreferences("switcher_lock", 0).edit().putBoolean(str, z).commit();
            if ("key_locked_2g3g_state".equals(str)) {
                C1150y.m2598b(context).f2235t = z;
            } else if ("key_locked_wifi_state".equals(str)) {
                C1150y.m2598b(context).f2234s = z;
            }
            C0721a.m1001d(context, str);
        }

        public static boolean m996a(Context context, String str) {
            boolean z = context.getSharedPreferences("switcher_lock", 0).getBoolean(C1147a.m2480a(str, "_status"), false);
            if ("key_locked_wifi_state".equals(str)) {
                C1150y.m2598b(context).f2236u = z;
            } else if ("key_locked_2g3g_state".equals(str)) {
                C1150y.m2598b(context).f2237v = z;
            }
            return z;
        }

        public static void m997b(Context context, String str, boolean z) {
            context.getSharedPreferences("switcher_lock", 0).edit().putBoolean(C1147a.m2480a(str, "_status"), z).commit();
            if ("key_locked_wifi_state".equals(str)) {
                C1150y.m2598b(context).f2236u = z;
            } else if ("key_locked_2g3g_state".equals(str)) {
                C1150y.m2598b(context).f2237v = z;
            }
        }

        public static boolean m998b(Context context, String str) {
            boolean z = context.getSharedPreferences("switcher_lock", 0).getBoolean(str, false);
            if ("key_locked_2g3g_state".equals(str)) {
                C1150y.m2598b(context).f2235t = z;
            } else if ("key_locked_wifi_state".equals(str)) {
                C1150y.m2598b(context).f2234s = z;
            }
            return z;
        }

        public static Drawable m999c(Context context, String str) {
            Resources resources = context.getResources();
            return "key_locked_autosync_state".equals(str) ? C1148d.m2502a(resources, (int) R.drawable.icon_switch_sync) : "key_locked_bluetooth_state".equals(str) ? C1148d.m2502a(resources, (int) R.drawable.icon_switch_bluetooth) : "key_locked_2g3g_state".equals(str) ? C1148d.m2502a(resources, (int) R.drawable.icon_switch_cell) : "key_locked_wifi_state".equals(str) ? C1148d.m2502a(resources, (int) R.drawable.icon_switch_wifi) : null;
        }

        public static void m1000c(Context context) {
            try {
                if (C0721a.m998b(context, "key_locked_wifi_state")) {
                    C0721a.m1001d(context, "key_locked_wifi_state");
                }
            } catch (Exception e) {
                C0721a.m1001d(context, "key_locked_wifi_state");
            }
            try {
                if (C0721a.m998b(context, "key_locked_bluetooth_state")) {
                    C0721a.m1001d(context, "key_locked_bluetooth_state");
                }
            } catch (Exception e2) {
                C0721a.m1001d(context, "key_locked_bluetooth_state");
            }
            try {
                if (C0721a.m998b(context, "key_locked_2g3g_state")) {
                    C0721a.m1001d(context, "key_locked_2g3g_state");
                }
            } catch (Exception e3) {
                C0721a.m1001d(context, "key_locked_2g3g_state");
            }
            try {
                if (C0721a.m998b(context, "key_locked_autosync_state")) {
                    C0721a.m1001d(context, "key_locked_autosync_state");
                }
            } catch (Exception e4) {
                C0721a.m1001d(context, "key_locked_autosync_state");
            }
        }

        private static void m1001d(final Context context, final String str) {
            if ("key_locked_wifi_state".equals(str)) {
                try {
                    C0721a.m997b(context, str, ((WifiManager) context.getSystemService("wifi")).isWifiEnabled());
                } catch (Exception e) {
                }
            } else if ("key_locked_autosync_state".equals(str)) {
                C0721a.m997b(context, str, ContentResolver.getMasterSyncAutomatically());
            } else if ("key_locked_bluetooth_state".equals(str)) {
                if (context.getMainLooper() == Looper.myLooper()) {
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null) {
                        C0721a.m997b(context, str, defaultAdapter.isEnabled());
                        return;
                    }
                    return;
                }
                new Handler(context.getMainLooper()).post(new Runnable() {
                    public void run() {
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        if (defaultAdapter != null) {
                            C0721a.m997b(context, str, defaultAdapter.isEnabled());
                        }
                    }
                });
            } else if ("key_locked_2g3g_state".equals(str)) {
                C0721a.m997b(context, str, SwitcherLockReceiver.m2101b(context));
            }
        }

        public boolean m1002b(Context context) {
            this.f903e = C0721a.m998b(context, this.f902d);
            return this.f903e;
        }
    }
}
