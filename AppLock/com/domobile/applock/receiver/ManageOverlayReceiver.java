package com.domobile.applock.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.domobile.applock.C1150y;

public class ManageOverlayReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if ("com.domoile.applock.ACTION_MANAGE_OVERLAY".equals(intent.getAction())) {
            C1150y.m2550O(context);
        }
    }
}
