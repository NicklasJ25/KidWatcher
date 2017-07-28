package com.domobile.applock.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.text.TextUtils;
import com.domobile.applock.C1150y;
import com.domobile.applock.receiver.CodeSetReceiver;
import com.domobile.lockbean.C1359b;
import com.domobile.lockbean.Location;

public class CodeSetService extends Service {
    private void m2126a(Context context) {
        if (CheckSubsService.m2121a(context)) {
            context.startService(new Intent(context, CheckSubsService.class));
        }
        if (UpdateService.m2274a(context)) {
            context.startService(new Intent(context, UpdateService.class));
        }
    }

    private void m2127a(Context context, Intent intent) {
        if (C1150y.m2539D(context)) {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                String a = Location.m3380a(connectionInfo.getSSID());
                if (!TextUtils.isEmpty(a)) {
                    C1359b.m3422c(context, a);
                    Intent intent2 = new Intent(context, LocationService.class);
                    intent2.putExtra(Location.LOCATION_INTENT_EXTRA, a);
                    context.startService(intent2);
                }
            }
        }
    }

    private static boolean m2128a(NetworkInfo networkInfo) {
        return networkInfo.getState() == State.DISCONNECTED;
    }

    private void m2129b(Context context) {
        if (((WifiManager) context.getSystemService("wifi")).isWifiEnabled()) {
            Object b = C1359b.m3419b(context);
            C1359b.m3417a(context);
            if (C1150y.m2539D(context) && !TextUtils.isEmpty(b)) {
                Intent intent = new Intent(context, LocationService.class);
                intent.putExtra(Location.LOCATION_INTENT_EXTRA, b);
                intent.putExtra(Location.LOCATION_DISCONNECT_EXTRA, true);
                context.startService(intent);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onStart(Intent intent, int i) {
        int i2 = -1;
        if (intent == null) {
            stopSelf(i);
            return;
        }
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        if (networkInfo == null) {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        }
        if (C1150y.O > 16) {
            i2 = intent.getIntExtra("networkType", -1);
        } else if (networkInfo != null) {
            i2 = networkInfo.getType();
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            m2126a((Context) this);
        }
        if (i2 == 1) {
            if (networkInfo == null || m2128a(networkInfo)) {
                m2129b(this);
            }
            if (networkInfo != null && networkInfo.isConnected()) {
                m2127a(this, intent);
            }
        }
        CodeSetReceiver.m2089a((Service) this, i);
    }
}
