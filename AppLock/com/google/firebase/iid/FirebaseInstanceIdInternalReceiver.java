package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.common.util.C2590o;
import com.google.firebase.iid.C3590b.C3597c;

public final class FirebaseInstanceIdInternalReceiver extends WakefulBroadcastReceiver {
    private static boolean f12215a = false;
    private static C3597c f12216b;
    private static C3597c f12217c;

    static synchronized C3597c m15621a(Context context, String str) {
        C3597c c3597c;
        synchronized (FirebaseInstanceIdInternalReceiver.class) {
            if ("com.google.firebase.MESSAGING_EVENT".equals(str)) {
                if (f12217c == null) {
                    f12217c = new C3597c(context, str);
                }
                c3597c = f12217c;
            } else {
                if (f12216b == null) {
                    f12216b = new C3597c(context, str);
                }
                c3597c = f12216b;
            }
        }
        return c3597c;
    }

    static boolean m15622a(Context context) {
        return C2590o.m8318m() && context.getApplicationInfo().targetSdkVersion > 25;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            if (parcelableExtra instanceof Intent) {
                Intent intent2 = (Intent) parcelableExtra;
                if (m15622a(context)) {
                    m15621a(context, intent.getAction()).m15654a(intent2, goAsync());
                    return;
                } else {
                    C3606g.m15695a().m15699a(context, intent.getAction(), intent2);
                    return;
                }
            }
            Log.e("FirebaseInstanceId", "Missing or invalid wrapped intent");
        }
    }
}
