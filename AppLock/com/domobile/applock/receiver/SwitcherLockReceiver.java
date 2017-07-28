package com.domobile.applock.receiver;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Handler;
import com.domobile.applock.AppLockApplication;
import com.domobile.applock.C1150y;
import com.domobile.applock.MainActivity;
import com.domobile.applock.R;
import com.domobile.applock.aj.C0721a;
import com.domobile.frame.p000a.C1147a;
import com.domobile.frame.p000a.C1148d;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SwitcherLockReceiver extends BroadcastReceiver {
    public static String m2092a(Context context, String str) {
        return "com.android.sync.SYNC_CONN_STATUS_CHANGED".equals(str) ? context.getString(R.string.auto_sync) : "android.bluetooth.adapter.action.STATE_CHANGED".equals(str) ? context.getString(R.string.bluetooth) : "android.net.conn.CONNECTIVITY_CHANGE".equals(str) ? context.getString(R.string.mobile_network) : "android.net.wifi.WIFI_STATE_CHANGED".equals(str) ? context.getString(R.string.wifi) : context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public static void m2093a(Activity activity) {
        final AppLockApplication a = C1150y.m2566a((Context) activity);
        ArrayList h = a.m594h();
        a.m588b(activity.getIntent().getStringExtra("com.domobile.elock.EXTRA_SWITCHER_LOKC_ACTION"));
        if (h != null && !h.isEmpty()) {
            final String str = (String) h.get(0);
            new Handler(activity.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    a.m588b(str);
                    SwitcherLockReceiver.m2096a(a, str, false);
                }
            }, 200);
        }
    }

    public static void m2094a(Context context) {
        C1148d.m2534y(context, "com.android.sync.SYNC_CONN_STATUS_CHANGED");
        C1148d.m2534y(context, "android.bluetooth.adapter.action.STATE_CHANGED");
        C1148d.m2534y(context, "android.net.conn.CONNECTIVITY_CHANGE");
        C1148d.m2534y(context, "android.net.wifi.WIFI_STATE_CHANGED");
        C1148d.m2534y(context, "android.intent.action.AIRPLANE_MODE");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m2095a(android.content.Context r7, android.content.Intent r8) {
        /*
        r6 = 1;
        r0 = com.domobile.applock.C1150y.m2627g(r7);
        if (r0 == 0) goto L_0x000d;
    L_0x0007:
        r0 = com.domobile.applock.C1150y.m2539D(r7);
        if (r0 != 0) goto L_0x000e;
    L_0x000d:
        return;
    L_0x000e:
        r0 = r8.getAction();
        r1 = 0;
        r1 = com.domobile.applock.C1150y.m2592a(r7, r0, r1);
        r2 = "com.android.sync.SYNC_CONN_STATUS_CHANGED";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0041;
    L_0x001f:
        r2 = "key_locked_autosync_state";
        r3 = com.domobile.applock.aj.C0721a.m998b(r7, r2);
        if (r3 == 0) goto L_0x000d;
    L_0x0027:
        r3 = com.domobile.applock.aj.C0721a.m996a(r7, r2);
        r4 = android.content.ContentResolver.getMasterSyncAutomatically();
        if (r3 == r4) goto L_0x0039;
    L_0x0031:
        if (r1 != 0) goto L_0x0039;
    L_0x0033:
        android.content.ContentResolver.setMasterSyncAutomatically(r3);
        m2096a(r7, r0, r6);
    L_0x0039:
        if (r3 == r4) goto L_0x000d;
    L_0x003b:
        if (r1 == 0) goto L_0x000d;
    L_0x003d:
        com.domobile.applock.aj.C0721a.m997b(r7, r2, r4);
        goto L_0x000d;
    L_0x0041:
        r2 = "android.bluetooth.adapter.action.STATE_CHANGED";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0080;
    L_0x0049:
        r2 = "key_locked_bluetooth_state";
        r3 = com.domobile.applock.aj.C0721a.m998b(r7, r2);
        if (r3 == 0) goto L_0x000d;
    L_0x0051:
        r3 = android.bluetooth.BluetoothAdapter.getDefaultAdapter();
        r4 = com.domobile.applock.aj.C0721a.m996a(r7, r2);
        r5 = r3.isEnabled();
        if (r1 != 0) goto L_0x0071;
    L_0x005f:
        if (r5 == r4) goto L_0x0071;
    L_0x0061:
        if (r4 == 0) goto L_0x0079;
    L_0x0063:
        r3 = r3.enable();
        if (r3 == 0) goto L_0x006e;
    L_0x0069:
        r3 = "BT ENABLE/DISABLE BEGUN";
        com.domobile.frame.p000a.C1147a.m2481a(r3);
    L_0x006e:
        m2096a(r7, r0, r6);
    L_0x0071:
        if (r4 == r5) goto L_0x000d;
    L_0x0073:
        if (r1 == 0) goto L_0x000d;
    L_0x0075:
        com.domobile.applock.aj.C0721a.m997b(r7, r2, r5);
        goto L_0x000d;
    L_0x0079:
        r3 = r3.disable();
        if (r3 == 0) goto L_0x006e;
    L_0x007f:
        goto L_0x0069;
    L_0x0080:
        r1 = "android.net.wifi.WIFI_STATE_CHANGED";
        r1 = r1.equals(r0);
        if (r1 != 0) goto L_0x000d;
    L_0x0088:
        r1 = "android.hardware.usb.action.USB_STATE";
        r0 = r1.equals(r0);
        if (r0 == 0) goto L_0x000d;
    L_0x0090:
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.domobile.applock.receiver.SwitcherLockReceiver.a(android.content.Context, android.content.Intent):void");
    }

    public static void m2096a(Context context, String str, boolean z) {
        if (z) {
            C1150y.m2566a(context).m585a(str);
        }
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("com.domobile.elock.EXTRA_SWITCHER_LOKC_ACTION", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static boolean m2097a(Context context, boolean z) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            Class[] clsArr = new Class[]{Boolean.TYPE};
            connectivityManager.getClass().getMethod("setMobileDataEnabled", clsArr).invoke(connectivityManager, new Object[]{Boolean.valueOf(z)});
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean m2098a(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = connectivityManager.getClass().getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Drawable m2099b(Context context, String str) {
        Resources resources = context.getResources();
        return "com.android.sync.SYNC_CONN_STATUS_CHANGED".equals(str) ? C1148d.m2502a(resources, (int) R.drawable.icon_switch_sync) : "android.bluetooth.adapter.action.STATE_CHANGED".equals(str) ? C1148d.m2502a(resources, (int) R.drawable.icon_switch_bluetooth) : "android.net.conn.CONNECTIVITY_CHANGE".equals(str) ? C1148d.m2502a(resources, (int) R.drawable.icon_switch_cell) : "android.net.wifi.WIFI_STATE_CHANGED".equals(str) ? C1148d.m2502a(resources, (int) R.drawable.icon_switch_wifi) : C1148d.m2502a(resources, (int) R.drawable.icon);
    }

    public static void m2100b(Context context, Intent intent) {
        boolean z = true;
        String action = intent.getAction();
        String str;
        boolean a;
        if ("com.android.sync.SYNC_CONN_STATUS_CHANGED".equals(action)) {
            str = "key_locked_autosync_state";
            a = C0721a.m996a(context, str);
            C0721a.m997b(context, str, !a);
            if (a) {
                z = false;
            }
            ContentResolver.setMasterSyncAutomatically(z);
        } else if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
            action = "key_locked_bluetooth_state";
            boolean a2 = C0721a.m996a(context, action);
            if (a2) {
                z = false;
            }
            C0721a.m997b(context, action, z);
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (a2) {
                if (!defaultAdapter.disable()) {
                    return;
                }
            } else if (!defaultAdapter.enable()) {
                return;
            }
            C1147a.m2481a((Object) "BT ENABLE/DISABLE BEGUN");
        } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            str = "key_locked_2g3g_state";
            a = C0721a.m996a(context, str);
            C0721a.m997b(context, str, !a);
            if (a) {
                z = false;
            }
            m2097a(context, z);
        } else if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action)) {
            String str2 = "key_locked_wifi_state";
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            boolean a3 = C0721a.m996a(context, str2);
            C0721a.m997b(context, str2, !a3);
            if (a3) {
                z = false;
            }
            wifiManager.setWifiEnabled(z);
        }
    }

    public static boolean m2101b(Context context) {
        try {
            return m2098a((ConnectivityManager) context.getSystemService("connectivity"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void onReceive(Context context, Intent intent) {
        try {
            m2095a(context, intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
