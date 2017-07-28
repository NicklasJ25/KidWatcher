package com.domobile.applock;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class BlankActivity extends Activity {
    BroadcastReceiver f452a = new C05891(this);

    class C05891 extends BroadcastReceiver {
        final /* synthetic */ BlankActivity f451a;

        C05891(BlankActivity blankActivity) {
            this.f451a = blankActivity;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.domobile.elock.blank_finish")) {
                this.f451a.finish();
            }
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public void onBackPressed() {
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1150y.m2566a((Context) this).m584a(this);
        requestWindowFeature(1);
        View linearLayout = new LinearLayout(this);
        linearLayout.setBackgroundResource(R.drawable.black);
        setContentView(linearLayout);
        registerReceiver(this.f452a, new IntentFilter("com.domobile.elock.blank_finish"));
    }

    protected void onDestroy() {
        C1150y.m2566a((Context) this).m584a(null);
        unregisterReceiver(this.f452a);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        C1150y.m2566a((Context) this).m584a(this);
    }

    protected void onStop() {
        super.onStop();
    }
}
